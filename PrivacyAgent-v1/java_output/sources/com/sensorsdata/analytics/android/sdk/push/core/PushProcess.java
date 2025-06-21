package com.sensorsdata.analytics.android.sdk.push.core;

/* loaded from: classes19.dex */
public class PushProcess {
    private static final java.lang.String DIR_NAME = "sensors.push";
    private static final int GT_PUSH_MSG = 1;
    private static com.sensorsdata.analytics.android.sdk.push.core.PushProcess INSTANCE = null;
    private static final java.lang.String SA_PUSH_ID = "SA_PUSH_ID";
    private static final java.lang.String TAG = "SA.NotificationProcessor";
    private final boolean customizeEnable;
    private final java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo> mGeTuiPushInfoMap;
    private java.lang.ref.WeakReference<android.content.Intent> mLastIntentRef;
    private final java.util.WeakHashMap<android.app.PendingIntent, java.lang.String> mPendingIntent2Ids;
    private java.io.File mPushFile;
    private final android.os.Handler mPushHandler;
    private final java.util.concurrent.atomic.AtomicInteger mSAIntentId;
    private final int myPid;

    /* renamed from: com.sensorsdata.analytics.android.sdk.push.core.PushProcess$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 1) {
                try {
                    java.lang.String str = (java.lang.String) message.obj;
                    if (android.text.TextUtils.isEmpty(str) || !com.sensorsdata.analytics.android.sdk.push.core.PushProcess.this.mGeTuiPushInfoMap.containsKey(str)) {
                        return;
                    }
                    com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo notificationInfo = (com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo) com.sensorsdata.analytics.android.sdk.push.core.PushProcess.this.mGeTuiPushInfoMap.get(str);
                    com.sensorsdata.analytics.android.sdk.push.core.PushProcess.this.mGeTuiPushInfoMap.remove(str);
                    if (notificationInfo != null) {
                        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.trackGeTuiNotificationClicked(notificationInfo.title, notificationInfo.content, null, notificationInfo.time);
                    }
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.push.core.PushProcess$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.app.Notification val$notification;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo val$push;

        public AnonymousClass2(android.app.Notification notification, com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo notificationInfo) {
            this.val$notification = notification;
            this.val$push = notificationInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.push.core.PushProcess.this.checkAndStoreNotificationInfo(this.val$notification.contentIntent, this.val$push);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.push.core.PushProcess$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$id;

        public AnonymousClass3(java.lang.String str) {
            this.val$id = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo notificationInfo = com.sensorsdata.analytics.android.sdk.push.core.PushProcess.this.getNotificationInfo(this.val$id);
            if (notificationInfo != null) {
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.trackNotificationOpenedEvent(null, notificationInfo.title, notificationInfo.content, com.amap.api.services.cloud.CloudSearch.SearchBound.LOCAL_SHAPE, null);
            }
        }
    }

    public static class NotificationInfo {
        java.lang.String content;
        long time;
        java.lang.String title;

        public NotificationInfo(java.lang.String str, java.lang.String str2, long j) {
            this.title = str;
            this.content = str2;
            this.time = j;
        }

        public static com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo fromJson(java.lang.String str) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                return new com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo(jSONObject.optString("title"), jSONObject.optString("content"), jSONObject.optLong("time"));
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return null;
            }
        }

        public java.lang.String toJson() {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("title", this.title);
                jSONObject.put("content", this.content);
                jSONObject.put("time", this.time);
                return jSONObject.toString();
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return null;
            }
        }

        public java.lang.String toString() {
            return "NotificationInfo{title='" + this.title + "', content='" + this.content + "', time=" + this.time + '}';
        }
    }

    private PushProcess() {
        android.content.Context context = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext();
        if (context != null) {
            this.mPushFile = new java.io.File(context.getFilesDir(), DIR_NAME);
        }
        this.mSAIntentId = new java.util.concurrent.atomic.AtomicInteger();
        this.myPid = android.os.Process.myPid();
        this.customizeEnable = true;
        this.mPendingIntent2Ids = new java.util.WeakHashMap<>();
        this.mGeTuiPushInfoMap = new java.util.HashMap();
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants.THREAD_PUSH_HANDLER);
        handlerThread.start();
        this.mPushHandler = new com.sensorsdata.analytics.android.sdk.push.core.PushProcess.AnonymousClass1(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndStoreNotificationInfo(android.app.PendingIntent pendingIntent, com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo notificationInfo) {
        if (pendingIntent == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "pendingIntent is null");
            return;
        }
        try {
            java.lang.String str = this.mPendingIntent2Ids.get(pendingIntent);
            if (str != null) {
                storeNotificationInfo(notificationInfo, str);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static synchronized com.sensorsdata.analytics.android.sdk.push.core.PushProcess getInstance() {
        com.sensorsdata.analytics.android.sdk.push.core.PushProcess pushProcess;
        synchronized (com.sensorsdata.analytics.android.sdk.push.core.PushProcess.class) {
            if (INSTANCE == null) {
                INSTANCE = new com.sensorsdata.analytics.android.sdk.push.core.PushProcess();
            }
            pushProcess = INSTANCE;
        }
        return pushProcess;
    }

    private com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo getNotificationInfo(android.app.Notification notification) {
        java.lang.String string;
        java.lang.String string2;
        com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo notificationInfo;
        com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo notificationInfo2 = null;
        try {
            string = notification.extras.getString(androidx.core.app.NotificationCompat.EXTRA_TITLE);
            string2 = notification.extras.getString(androidx.core.app.NotificationCompat.EXTRA_TEXT);
            notificationInfo = new com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo(string, string2, 0L);
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "NotificationInfo: title = " + string + "content = " + string2);
            return notificationInfo;
        } catch (java.lang.Exception e2) {
            e = e2;
            notificationInfo2 = notificationInfo;
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return notificationInfo2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo getNotificationInfo(java.lang.String str) {
        try {
            initAndCleanDir();
            java.io.File file = new java.io.File(this.mPushFile, str);
            if (!file.exists()) {
                return null;
            }
            java.lang.String readFileToString = com.sensorsdata.analytics.android.sdk.util.FileUtils.readFileToString(file);
            if (android.text.TextUtils.isEmpty(readFileToString)) {
                return null;
            }
            java.lang.String str2 = (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_DECRYPT_AES, readFileToString);
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = readFileToString;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "cache local notification info:" + str2);
            com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo fromJson = com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo.fromJson(str2);
            return fromJson == null ? com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo.fromJson(readFileToString) : fromJson;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    private synchronized void initAndCleanDir() {
        try {
            if (!this.mPushFile.exists()) {
                this.mPushFile.mkdirs();
            }
            java.io.File[] listFiles = this.mPushFile.listFiles();
            if (listFiles != null) {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                for (java.io.File file : listFiles) {
                    if (currentTimeMillis - file.lastModified() > 86400000) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "clean file: " + file);
                        file.delete();
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private boolean isHooked(android.content.Intent intent) {
        try {
            return intent.hasExtra(SA_PUSH_ID);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    private void storeNotificationInfo(com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo notificationInfo, java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "storeNotificationInfo: id=" + str + ", actionInfo" + notificationInfo);
        try {
            initAndCleanDir();
            java.io.File file = new java.io.File(this.mPushFile, str);
            if (file.exists()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "toFile exists");
                file.delete();
            }
            java.lang.String json = notificationInfo.toJson();
            java.lang.String str2 = (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_AES, json);
            if (!android.text.TextUtils.isEmpty(str2)) {
                json = str2;
            }
            com.sensorsdata.analytics.android.sdk.util.FileUtils.writeToFile(file, json);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void trackCustomizeClick(android.content.Intent intent) {
        if (this.customizeEnable) {
            try {
                if (isHooked(intent)) {
                    java.lang.String stringExtra = intent.getStringExtra(SA_PUSH_ID);
                    intent.removeExtra(SA_PUSH_ID);
                    if (android.text.TextUtils.isEmpty(stringExtra)) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "intent tag is null");
                    } else {
                        this.mPushHandler.post(new com.sensorsdata.analytics.android.sdk.push.core.PushProcess.AnonymousClass3(stringExtra));
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public void hookIntent(android.content.Intent intent) {
        if (this.customizeEnable) {
            try {
                if (isHooked(intent)) {
                    return;
                }
                intent.putExtra(SA_PUSH_ID, this.myPid + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mSAIntentId.getAndIncrement());
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public void hookPendingIntent(android.content.Intent intent, android.app.PendingIntent pendingIntent) {
        if (this.customizeEnable) {
            this.mPendingIntent2Ids.put(pendingIntent, intent.getStringExtra(SA_PUSH_ID));
        }
    }

    public void onNotificationClick(android.content.Context context, android.content.Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            java.lang.ref.WeakReference<android.content.Intent> weakReference = this.mLastIntentRef;
            if (weakReference == null || weakReference.get() != intent) {
                this.mLastIntentRef = new java.lang.ref.WeakReference<>(intent);
                if (this.customizeEnable) {
                    trackCustomizeClick(intent);
                }
                if (context instanceof android.app.Activity) {
                    com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.trackJPushOpenActivity(intent);
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onNotificationClick");
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void onNotify(java.lang.String str, int i, android.app.Notification notification) {
        if (this.customizeEnable) {
            try {
                if (notification.contentIntent != null) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onNotify, tag: " + str + ", id=" + i);
                    com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo notificationInfo = getNotificationInfo(notification);
                    if (notificationInfo != null) {
                        this.mPushHandler.post(new com.sensorsdata.analytics.android.sdk.push.core.PushProcess.AnonymousClass2(notification, notificationInfo));
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public void trackGTClickDelayed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            this.mGeTuiPushInfoMap.put(str, new com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo(str2, str3, java.lang.System.currentTimeMillis()));
            this.mPushHandler.sendMessageDelayed(obtain, 200L);
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sendMessageDelayed,msgId = " + str);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void trackReceiveMessageData(java.lang.String str, java.lang.String str2) {
        try {
            if (this.mPushHandler.hasMessages(1) && this.mGeTuiPushInfoMap.containsKey(str2)) {
                this.mPushHandler.removeMessages(1);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remove GeTui Push Message");
                com.sensorsdata.analytics.android.sdk.push.core.PushProcess.NotificationInfo notificationInfo = this.mGeTuiPushInfoMap.get(str2);
                if (notificationInfo != null) {
                    com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.trackGeTuiNotificationClicked(notificationInfo.title, notificationInfo.content, str, notificationInfo.time);
                }
                this.mGeTuiPushInfoMap.remove(str2);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, " onGeTuiReceiveMessage:msg id : " + str2);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
