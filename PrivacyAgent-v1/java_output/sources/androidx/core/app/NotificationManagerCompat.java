package androidx.core.app;

/* loaded from: classes.dex */
public final class NotificationManagerCompat {
    public static final java.lang.String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final java.lang.String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final java.lang.String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final java.lang.String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final java.lang.String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final java.lang.String TAG = "NotifManCompat";

    @androidx.annotation.GuardedBy("sEnabledNotificationListenersLock")
    private static java.lang.String sEnabledNotificationListeners;

    @androidx.annotation.GuardedBy("sLock")
    private static androidx.core.app.NotificationManagerCompat.SideChannelManager sSideChannelManager;
    private final android.content.Context mContext;
    private final android.app.NotificationManager mNotificationManager;
    private static final java.lang.Object sEnabledNotificationListenersLock = new java.lang.Object();

    @androidx.annotation.GuardedBy("sEnabledNotificationListenersLock")
    private static java.util.Set<java.lang.String> sEnabledNotificationListenerPackages = new java.util.HashSet();
    private static final java.lang.Object sLock = new java.lang.Object();

    public static class CancelTask implements androidx.core.app.NotificationManagerCompat.Task {
        final boolean all;
        final int id;
        final java.lang.String packageName;
        final java.lang.String tag;

        public CancelTask(java.lang.String str) {
            this.packageName = str;
            this.id = 0;
            this.tag = null;
            this.all = true;
        }

        public CancelTask(java.lang.String str, int i, java.lang.String str2) {
            this.packageName = str;
            this.id = i;
            this.tag = str2;
            this.all = false;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(android.support.v4.app.INotificationSideChannel iNotificationSideChannel) throws android.os.RemoteException {
            if (this.all) {
                iNotificationSideChannel.cancelAll(this.packageName);
            } else {
                iNotificationSideChannel.cancel(this.packageName, this.id, this.tag);
            }
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return "CancelTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + ", all:" + this.all + "]";
        }
    }

    public static class NotifyTask implements androidx.core.app.NotificationManagerCompat.Task {
        final int id;
        final android.app.Notification notif;
        final java.lang.String packageName;
        final java.lang.String tag;

        public NotifyTask(java.lang.String str, int i, java.lang.String str2, android.app.Notification notification) {
            this.packageName = str;
            this.id = i;
            this.tag = str2;
            this.notif = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(android.support.v4.app.INotificationSideChannel iNotificationSideChannel) throws android.os.RemoteException {
            iNotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return "NotifyTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + "]";
        }
    }

    public static class ServiceConnectedEvent {
        final android.content.ComponentName componentName;
        final android.os.IBinder iBinder;

        public ServiceConnectedEvent(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    public static class SideChannelManager implements android.os.Handler.Callback, android.content.ServiceConnection {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private final android.content.Context mContext;
        private final android.os.Handler mHandler;
        private final android.os.HandlerThread mHandlerThread;
        private final java.util.Map<android.content.ComponentName, androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord> mRecordMap = new java.util.HashMap();
        private java.util.Set<java.lang.String> mCachedEnabledPackages = new java.util.HashSet();

        public static class ListenerRecord {
            final android.content.ComponentName componentName;
            android.support.v4.app.INotificationSideChannel service;
            boolean bound = false;
            java.util.ArrayDeque<androidx.core.app.NotificationManagerCompat.Task> taskQueue = new java.util.ArrayDeque<>();
            int retryCount = 0;

            public ListenerRecord(android.content.ComponentName componentName) {
                this.componentName = componentName;
            }
        }

        public SideChannelManager(android.content.Context context) {
            this.mContext = context;
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new android.os.Handler(handlerThread.getLooper(), this);
        }

        private boolean ensureServiceBound(androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                return true;
            }
            boolean bindService = this.mContext.bindService(new android.content.Intent(androidx.core.app.NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.componentName), this, 33);
            listenerRecord.bound = bindService;
            if (bindService) {
                listenerRecord.retryCount = 0;
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Unable to bind to listener ");
                sb.append(listenerRecord.componentName);
                this.mContext.unbindService(this);
            }
            return listenerRecord.bound;
        }

        private void ensureServiceUnbound(androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                this.mContext.unbindService(this);
                listenerRecord.bound = false;
            }
            listenerRecord.service = null;
        }

        private void handleQueueTask(androidx.core.app.NotificationManagerCompat.Task task) {
            updateListenerMap();
            for (androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord : this.mRecordMap.values()) {
                listenerRecord.taskQueue.add(task);
                processListenerQueue(listenerRecord);
            }
        }

        private void handleRetryListenerQueue(android.content.ComponentName componentName) {
            androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord = this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord = this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.service = android.support.v4.app.INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.retryCount = 0;
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceDisconnected(android.content.ComponentName componentName) {
            androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord = this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                ensureServiceUnbound(listenerRecord);
            }
        }

        private void processListenerQueue(androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord) {
            if (android.util.Log.isLoggable(androidx.core.app.NotificationManagerCompat.TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Processing component ");
                sb.append(listenerRecord.componentName);
                sb.append(", ");
                sb.append(listenerRecord.taskQueue.size());
                sb.append(" queued tasks");
            }
            if (listenerRecord.taskQueue.isEmpty()) {
                return;
            }
            if (!ensureServiceBound(listenerRecord) || listenerRecord.service == null) {
                scheduleListenerRetry(listenerRecord);
                return;
            }
            while (true) {
                androidx.core.app.NotificationManagerCompat.Task peek = listenerRecord.taskQueue.peek();
                if (peek == null) {
                    break;
                }
                try {
                    if (android.util.Log.isLoggable(androidx.core.app.NotificationManagerCompat.TAG, 3)) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("Sending task ");
                        sb2.append(peek);
                    }
                    peek.send(listenerRecord.service);
                    listenerRecord.taskQueue.remove();
                } catch (android.os.DeadObjectException unused) {
                    if (android.util.Log.isLoggable(androidx.core.app.NotificationManagerCompat.TAG, 3)) {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("Remote service has died: ");
                        sb3.append(listenerRecord.componentName);
                    }
                } catch (android.os.RemoteException unused2) {
                    java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                    sb4.append("RemoteException communicating with ");
                    sb4.append(listenerRecord.componentName);
                }
            }
            if (listenerRecord.taskQueue.isEmpty()) {
                return;
            }
            scheduleListenerRetry(listenerRecord);
        }

        private void scheduleListenerRetry(androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord listenerRecord) {
            if (this.mHandler.hasMessages(3, listenerRecord.componentName)) {
                return;
            }
            int i = listenerRecord.retryCount + 1;
            listenerRecord.retryCount = i;
            if (i <= 6) {
                int i2 = (1 << (i - 1)) * 1000;
                if (android.util.Log.isLoggable(androidx.core.app.NotificationManagerCompat.TAG, 3)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Scheduling retry for ");
                    sb.append(i2);
                    sb.append(" ms");
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, listenerRecord.componentName), i2);
                return;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Giving up on delivering ");
            sb2.append(listenerRecord.taskQueue.size());
            sb2.append(" tasks to ");
            sb2.append(listenerRecord.componentName);
            sb2.append(" after ");
            sb2.append(listenerRecord.retryCount);
            sb2.append(" retries");
            listenerRecord.taskQueue.clear();
        }

        private void updateListenerMap() {
            java.util.Set<java.lang.String> enabledListenerPackages = androidx.core.app.NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (enabledListenerPackages.equals(this.mCachedEnabledPackages)) {
                return;
            }
            this.mCachedEnabledPackages = enabledListenerPackages;
            java.util.List<android.content.pm.ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new android.content.Intent().setAction(androidx.core.app.NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            java.util.HashSet<android.content.ComponentName> hashSet = new java.util.HashSet();
            for (android.content.pm.ResolveInfo resolveInfo : queryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    android.content.pm.ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    android.content.ComponentName componentName = new android.content.ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Permission present on component ");
                        sb.append(componentName);
                        sb.append(", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (android.content.ComponentName componentName2 : hashSet) {
                if (!this.mRecordMap.containsKey(componentName2)) {
                    if (android.util.Log.isLoggable(androidx.core.app.NotificationManagerCompat.TAG, 3)) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("Adding listener record for ");
                        sb2.append(componentName2);
                    }
                    this.mRecordMap.put(componentName2, new androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord(componentName2));
                }
            }
            java.util.Iterator<java.util.Map.Entry<android.content.ComponentName, androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord>> it = this.mRecordMap.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<android.content.ComponentName, androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (android.util.Log.isLoggable(androidx.core.app.NotificationManagerCompat.TAG, 3)) {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("Removing listener record for ");
                        sb3.append(next.getKey());
                    }
                    ensureServiceUnbound(next.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 0) {
                handleQueueTask((androidx.core.app.NotificationManagerCompat.Task) message.obj);
                return true;
            }
            if (i == 1) {
                androidx.core.app.NotificationManagerCompat.ServiceConnectedEvent serviceConnectedEvent = (androidx.core.app.NotificationManagerCompat.ServiceConnectedEvent) message.obj;
                handleServiceConnected(serviceConnectedEvent.componentName, serviceConnectedEvent.iBinder);
                return true;
            }
            if (i == 2) {
                handleServiceDisconnected((android.content.ComponentName) message.obj);
                return true;
            }
            if (i != 3) {
                return false;
            }
            handleRetryListenerQueue((android.content.ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            if (android.util.Log.isLoggable(androidx.core.app.NotificationManagerCompat.TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Connected to service ");
                sb.append(componentName);
            }
            this.mHandler.obtainMessage(1, new androidx.core.app.NotificationManagerCompat.ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            if (android.util.Log.isLoggable(androidx.core.app.NotificationManagerCompat.TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Disconnected from service ");
                sb.append(componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        public void queueTask(androidx.core.app.NotificationManagerCompat.Task task) {
            this.mHandler.obtainMessage(0, task).sendToTarget();
        }
    }

    public interface Task {
        void send(android.support.v4.app.INotificationSideChannel iNotificationSideChannel) throws android.os.RemoteException;
    }

    private NotificationManagerCompat(android.content.Context context) {
        this.mContext = context;
        this.mNotificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.NotificationManagerCompat from(@androidx.annotation.NonNull android.content.Context context) {
        return new androidx.core.app.NotificationManagerCompat(context);
    }

    @androidx.annotation.NonNull
    public static java.util.Set<java.lang.String> getEnabledListenerPackages(@androidx.annotation.NonNull android.content.Context context) {
        java.util.Set<java.lang.String> set;
        java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        synchronized (sEnabledNotificationListenersLock) {
            if (string != null) {
                if (!string.equals(sEnabledNotificationListeners)) {
                    java.lang.String[] split = string.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, -1);
                    java.util.HashSet hashSet = new java.util.HashSet(split.length);
                    for (java.lang.String str : split) {
                        android.content.ComponentName unflattenFromString = android.content.ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    sEnabledNotificationListenerPackages = hashSet;
                    sEnabledNotificationListeners = string;
                }
            }
            set = sEnabledNotificationListenerPackages;
        }
        return set;
    }

    private void pushSideChannelQueue(androidx.core.app.NotificationManagerCompat.Task task) {
        synchronized (sLock) {
            if (sSideChannelManager == null) {
                sSideChannelManager = new androidx.core.app.NotificationManagerCompat.SideChannelManager(this.mContext.getApplicationContext());
            }
            sSideChannelManager.queueTask(task);
        }
    }

    private static boolean useSideChannelForNotification(android.app.Notification notification) {
        android.os.Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    public boolean areNotificationsEnabled() {
        boolean areNotificationsEnabled;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            areNotificationsEnabled = this.mNotificationManager.areNotificationsEnabled();
            return areNotificationsEnabled;
        }
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) this.mContext.getSystemService("appops");
        android.content.pm.ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        java.lang.String packageName = this.mContext.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return ((java.lang.Integer) cls.getMethod(CHECK_OP_NO_THROW, cls2, cls2, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(((java.lang.Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(java.lang.Integer.class)).intValue()), java.lang.Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException | java.lang.NoSuchMethodException | java.lang.RuntimeException | java.lang.reflect.InvocationTargetException unused) {
            return true;
        }
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancel(@androidx.annotation.Nullable java.lang.String str, int i) {
        this.mNotificationManager.cancel(str, i);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void createNotificationChannel(@androidx.annotation.NonNull android.app.NotificationChannel notificationChannel) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void createNotificationChannel(@androidx.annotation.NonNull androidx.core.app.NotificationChannelCompat notificationChannelCompat) {
        createNotificationChannel(notificationChannelCompat.getNotificationChannel());
    }

    public void createNotificationChannelGroup(@androidx.annotation.NonNull android.app.NotificationChannelGroup notificationChannelGroup) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroup(@androidx.annotation.NonNull androidx.core.app.NotificationChannelGroupCompat notificationChannelGroupCompat) {
        createNotificationChannelGroup(notificationChannelGroupCompat.getNotificationChannelGroup());
    }

    public void createNotificationChannelGroups(@androidx.annotation.NonNull java.util.List<android.app.NotificationChannelGroup> list) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannelGroups(list);
        }
    }

    public void createNotificationChannelGroupsCompat(@androidx.annotation.NonNull java.util.List<androidx.core.app.NotificationChannelGroupCompat> list) {
        if (android.os.Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<androidx.core.app.NotificationChannelGroupCompat> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getNotificationChannelGroup());
        }
        this.mNotificationManager.createNotificationChannelGroups(arrayList);
    }

    public void createNotificationChannels(@androidx.annotation.NonNull java.util.List<android.app.NotificationChannel> list) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannels(list);
        }
    }

    public void createNotificationChannelsCompat(@androidx.annotation.NonNull java.util.List<androidx.core.app.NotificationChannelCompat> list) {
        if (android.os.Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<androidx.core.app.NotificationChannelCompat> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getNotificationChannel());
        }
        this.mNotificationManager.createNotificationChannels(arrayList);
    }

    public void deleteNotificationChannel(@androidx.annotation.NonNull java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.deleteNotificationChannel(str);
        }
    }

    public void deleteNotificationChannelGroup(@androidx.annotation.NonNull java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.deleteNotificationChannelGroup(str);
        }
    }

    public void deleteUnlistedNotificationChannels(@androidx.annotation.NonNull java.util.Collection<java.lang.String> collection) {
        java.util.List<android.app.NotificationChannel> notificationChannels;
        java.lang.String id;
        java.lang.String id2;
        java.lang.String parentChannelId;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            notificationChannels = this.mNotificationManager.getNotificationChannels();
            for (android.app.NotificationChannel notificationChannel : notificationChannels) {
                id = notificationChannel.getId();
                if (!collection.contains(id)) {
                    if (android.os.Build.VERSION.SDK_INT >= 30) {
                        parentChannelId = notificationChannel.getParentChannelId();
                        if (collection.contains(parentChannelId)) {
                        }
                    }
                    android.app.NotificationManager notificationManager = this.mNotificationManager;
                    id2 = notificationChannel.getId();
                    notificationManager.deleteNotificationChannel(id2);
                }
            }
        }
    }

    public int getImportance() {
        int importance;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return -1000;
        }
        importance = this.mNotificationManager.getImportance();
        return importance;
    }

    @androidx.annotation.Nullable
    public android.app.NotificationChannel getNotificationChannel(@androidx.annotation.NonNull java.lang.String str) {
        android.app.NotificationChannel notificationChannel;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        notificationChannel = this.mNotificationManager.getNotificationChannel(str);
        return notificationChannel;
    }

    @androidx.annotation.Nullable
    public android.app.NotificationChannel getNotificationChannel(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        android.app.NotificationChannel notificationChannel;
        if (android.os.Build.VERSION.SDK_INT < 30) {
            return getNotificationChannel(str);
        }
        notificationChannel = this.mNotificationManager.getNotificationChannel(str, str2);
        return notificationChannel;
    }

    @androidx.annotation.Nullable
    public androidx.core.app.NotificationChannelCompat getNotificationChannelCompat(@androidx.annotation.NonNull java.lang.String str) {
        android.app.NotificationChannel notificationChannel;
        if (android.os.Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str)) == null) {
            return null;
        }
        return new androidx.core.app.NotificationChannelCompat(notificationChannel);
    }

    @androidx.annotation.Nullable
    public androidx.core.app.NotificationChannelCompat getNotificationChannelCompat(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        android.app.NotificationChannel notificationChannel;
        if (android.os.Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str, str2)) == null) {
            return null;
        }
        return new androidx.core.app.NotificationChannelCompat(notificationChannel);
    }

    @androidx.annotation.Nullable
    public android.app.NotificationChannelGroup getNotificationChannelGroup(@androidx.annotation.NonNull java.lang.String str) {
        java.lang.String id;
        android.app.NotificationChannelGroup notificationChannelGroup;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28) {
            notificationChannelGroup = this.mNotificationManager.getNotificationChannelGroup(str);
            return notificationChannelGroup;
        }
        if (i >= 26) {
            for (android.app.NotificationChannelGroup notificationChannelGroup2 : getNotificationChannelGroups()) {
                id = notificationChannelGroup2.getId();
                if (id.equals(str)) {
                    return notificationChannelGroup2;
                }
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public androidx.core.app.NotificationChannelGroupCompat getNotificationChannelGroupCompat(@androidx.annotation.NonNull java.lang.String str) {
        android.app.NotificationChannelGroup notificationChannelGroup;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28) {
            android.app.NotificationChannelGroup notificationChannelGroup2 = getNotificationChannelGroup(str);
            if (notificationChannelGroup2 != null) {
                return new androidx.core.app.NotificationChannelGroupCompat(notificationChannelGroup2);
            }
            return null;
        }
        if (i < 26 || (notificationChannelGroup = getNotificationChannelGroup(str)) == null) {
            return null;
        }
        return new androidx.core.app.NotificationChannelGroupCompat(notificationChannelGroup, getNotificationChannels());
    }

    @androidx.annotation.NonNull
    public java.util.List<android.app.NotificationChannelGroup> getNotificationChannelGroups() {
        java.util.List<android.app.NotificationChannelGroup> notificationChannelGroups;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return java.util.Collections.emptyList();
        }
        notificationChannelGroups = this.mNotificationManager.getNotificationChannelGroups();
        return notificationChannelGroups;
    }

    @androidx.annotation.NonNull
    public java.util.List<androidx.core.app.NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 26) {
            java.util.List<android.app.NotificationChannelGroup> notificationChannelGroups = getNotificationChannelGroups();
            if (!notificationChannelGroups.isEmpty()) {
                java.util.List<android.app.NotificationChannel> emptyList = i >= 28 ? java.util.Collections.emptyList() : getNotificationChannels();
                java.util.ArrayList arrayList = new java.util.ArrayList(notificationChannelGroups.size());
                for (android.app.NotificationChannelGroup notificationChannelGroup : notificationChannelGroups) {
                    if (android.os.Build.VERSION.SDK_INT >= 28) {
                        arrayList.add(new androidx.core.app.NotificationChannelGroupCompat(notificationChannelGroup));
                    } else {
                        arrayList.add(new androidx.core.app.NotificationChannelGroupCompat(notificationChannelGroup, emptyList));
                    }
                }
                return arrayList;
            }
        }
        return java.util.Collections.emptyList();
    }

    @androidx.annotation.NonNull
    public java.util.List<android.app.NotificationChannel> getNotificationChannels() {
        java.util.List<android.app.NotificationChannel> notificationChannels;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return java.util.Collections.emptyList();
        }
        notificationChannels = this.mNotificationManager.getNotificationChannels();
        return notificationChannels;
    }

    @androidx.annotation.NonNull
    public java.util.List<androidx.core.app.NotificationChannelCompat> getNotificationChannelsCompat() {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            java.util.List<android.app.NotificationChannel> notificationChannels = getNotificationChannels();
            if (!notificationChannels.isEmpty()) {
                java.util.ArrayList arrayList = new java.util.ArrayList(notificationChannels.size());
                java.util.Iterator<android.app.NotificationChannel> it = notificationChannels.iterator();
                while (it.hasNext()) {
                    arrayList.add(new androidx.core.app.NotificationChannelCompat(it.next()));
                }
                return arrayList;
            }
        }
        return java.util.Collections.emptyList();
    }

    public void notify(int i, @androidx.annotation.NonNull android.app.Notification notification) {
        notify(null, i, notification);
    }

    public void notify(@androidx.annotation.Nullable java.lang.String str, int i, @androidx.annotation.NonNull android.app.Notification notification) {
        if (useSideChannelForNotification(notification)) {
            pushSideChannelQueue(new androidx.core.app.NotificationManagerCompat.NotifyTask(this.mContext.getPackageName(), i, str, notification));
            this.mNotificationManager.cancel(str, i);
        } else {
            android.app.NotificationManager notificationManager = this.mNotificationManager;
            notificationManager.notify(str, i, notification);
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNotify(notificationManager, str, i, notification);
        }
    }
}
