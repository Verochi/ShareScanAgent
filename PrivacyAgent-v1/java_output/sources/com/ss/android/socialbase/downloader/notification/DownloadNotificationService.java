package com.ss.android.socialbase.downloader.notification;

/* loaded from: classes19.dex */
public class DownloadNotificationService extends android.app.Service {
    private static final long NOTIFY_TIME_WINDOW = 900;
    private static final java.lang.String TAG = "DownloadNotificationService";
    private static boolean sAllowStartForeground = true;
    private static boolean sBugFixNonOngoing = false;
    private static boolean sBugfixNotifyTooFast = false;
    private static int sForegroundId = -1;
    private static int sIndependentProcessForegroundId = -1;
    private static volatile long sLastImportantNotifyTimestamp = 0;
    private static volatile long sLastNotifyTimestamp = 0;
    private static long sNotifyTimeWindow = 900;
    private com.ss.android.socialbase.downloader.thread.ThreadWithHandler mNotifyThreadHandler;
    private final android.util.SparseArray<android.app.Notification> pendingImportantNotify = new android.util.SparseArray<>(2);

    /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$action;
        final /* synthetic */ android.content.Intent val$intent;

        /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04871 implements java.lang.Runnable {
            final /* synthetic */ android.app.Notification val$notification;
            final /* synthetic */ int val$notificationId;
            final /* synthetic */ android.app.NotificationManager val$notificationManager;

            public RunnableC04871(android.app.NotificationManager notificationManager, int i, android.app.Notification notification) {
                this.val$notificationManager = notificationManager;
                this.val$notificationId = i;
                this.val$notification = notification;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.doNotify(this.val$notificationManager, this.val$notificationId, this.val$notification);
            }
        }

        public AnonymousClass1(android.content.Intent intent, java.lang.String str) {
            this.val$intent = intent;
            this.val$action = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.net.ConnectivityManager connectivityManager;
            android.net.NetworkInfo activeNetworkInfo;
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
            int intExtra = this.val$intent.getIntExtra(com.ss.android.socialbase.downloader.constants.NotificationConstants.EXTRA_NOTIFICATION_ID, 0);
            if (!this.val$action.equals(com.ss.android.socialbase.downloader.constants.NotificationConstants.ACTION_NOTIFICATION_NOTIFY)) {
                if (this.val$action.equals(com.ss.android.socialbase.downloader.constants.NotificationConstants.ACTION_NOTIFICATION_CANCEL)) {
                    if (intExtra != 0) {
                        com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.doCancel(notificationManager, intExtra);
                        return;
                    }
                    return;
                }
                if (!this.val$action.equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                    if (this.val$action.equals("android.intent.action.MEDIA_UNMOUNTED") || this.val$action.equals("android.intent.action.MEDIA_REMOVED") || this.val$action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || this.val$action.equals("android.intent.action.MEDIA_EJECT")) {
                        try {
                            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this).pauseAll();
                            return;
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                try {
                    if (com.ss.android.socialbase.downloader.utils.DownloadUtils.checkPermission(com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (android.net.ConnectivityManager) com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        if (!android.text.TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.DownloadConstants.MIME_APK)) {
                            arrayList.add(com.ss.android.socialbase.downloader.constants.DownloadConstants.MIME_APK);
                        }
                        arrayList.add(com.ss.android.socialbase.downloader.constants.DownloadConstants.MIME_PLG);
                        android.content.Context applicationContext = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.getApplicationContext();
                        if (applicationContext != null) {
                            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            android.app.Notification notification = (android.app.Notification) this.val$intent.getParcelableExtra(com.ss.android.socialbase.downloader.constants.NotificationConstants.EXTRA_NOTIFICATION);
            int intExtra2 = this.val$intent.getIntExtra(com.ss.android.socialbase.downloader.constants.NotificationConstants.EXTRA_NOTIFICATION_STATUS, 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 != -2 && intExtra2 != -3) {
                    if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sBugfixNotifyTooFast) {
                        com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.doImportantNotify(notificationManager, intExtra, notification);
                        return;
                    } else {
                        com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                        return;
                    }
                }
                if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sBugfixNotifyTooFast) {
                    com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.doImportantNotify(notificationManager, intExtra, notification);
                    return;
                } else {
                    if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.mNotifyThreadHandler != null) {
                        com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.mNotifyThreadHandler.postDelayed(new com.ss.android.socialbase.downloader.notification.DownloadNotificationService.AnonymousClass1.RunnableC04871(notificationManager, intExtra, notification), intExtra2 == -2 ? 50L : 200L);
                        return;
                    }
                    return;
                }
            }
            if (com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).isDownloading(intExtra)) {
                com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getDownloadInfo(intExtra);
                if (!com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sBugfixNotifyTooFast) {
                    if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                        return;
                    }
                    com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                    downloadInfo.setLastNotifyProgressTime();
                    return;
                }
                if (downloadInfo == null || !downloadInfo.canNotifyProgress() || java.lang.System.currentTimeMillis() - com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sLastImportantNotifyTimestamp <= com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sNotifyTimeWindow) {
                    return;
                }
                com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                downloadInfo.setLastNotifyProgressTime();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int val$notificationId;
        final /* synthetic */ android.app.NotificationManager val$notificationManager;

        public AnonymousClass2(android.app.NotificationManager notificationManager, int i) {
            this.val$notificationManager = notificationManager;
            this.val$notificationId = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.this.performImportantNotify(this.val$notificationManager, this.val$notificationId);
        }
    }

    private void createNotifyHandlerThread() {
        if (this.mNotifyThreadHandler == null) {
            com.ss.android.socialbase.downloader.thread.ThreadWithHandler threadWithHandler = new com.ss.android.socialbase.downloader.thread.ThreadWithHandler("DownloaderNotifyThread");
            this.mNotifyThreadHandler = threadWithHandler;
            threadWithHandler.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCancel(android.app.NotificationManager notificationManager, int i) {
        boolean z;
        com.ss.android.socialbase.downloader.notification.AbsNotificationItem absNotificationItem;
        int id;
        int i2 = sForegroundId;
        if (i2 != i && sIndependentProcessForegroundId != i) {
            try {
                notificationManager.cancel(i);
                return;
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (i2 == i) {
            sForegroundId = 0;
            z = false;
        } else {
            sIndependentProcessForegroundId = 0;
            z = true;
        }
        try {
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadHandler(i);
            if (!downloadHandler.isServiceForeground()) {
                sAllowStartForeground = false;
                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "try to stopForeground when is not Foreground, id = " + i + ", isIndependentProcess = " + z);
            }
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "doCancel, ========== stopForeground id = " + i + ", isIndependentProcess = " + z);
            downloadHandler.stopForeground(false, true);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        try {
            notificationManager.cancel(i);
        } catch (java.lang.Throwable unused2) {
        }
        if (sAllowStartForeground) {
            try {
                android.util.SparseArray<com.ss.android.socialbase.downloader.notification.AbsNotificationItem> allNotificationItems = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().getAllNotificationItems();
                if (allNotificationItems != null) {
                    for (int size = allNotificationItems.size() - 1; size >= 0; size--) {
                        absNotificationItem = allNotificationItems.valueAt(size);
                        if (absNotificationItem != null && (id = absNotificationItem.getId()) != i && id != sForegroundId && id != sIndependentProcessForegroundId && absNotificationItem.isOngoing()) {
                            if ((com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(absNotificationItem.getId()) == 1 && !com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess()) == z) {
                                break;
                            }
                        }
                    }
                }
                absNotificationItem = null;
                if (absNotificationItem != null) {
                    int id2 = absNotificationItem.getId();
                    try {
                        notificationManager.cancel(id2);
                    } catch (java.lang.Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(this).getStatus(id2) != 1) {
                        z2 = false;
                    }
                    com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "doCancel, updateNotification id = ".concat(java.lang.String.valueOf(id2)));
                    absNotificationItem.updateNotification(null, z2);
                }
            } catch (java.lang.Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doImportantNotify(android.app.NotificationManager notificationManager, int i, android.app.Notification notification) {
        synchronized (this.pendingImportantNotify) {
            int indexOfKey = this.pendingImportantNotify.indexOfKey(i);
            if (indexOfKey >= 0 && indexOfKey < this.pendingImportantNotify.size()) {
                this.pendingImportantNotify.setValueAt(indexOfKey, notification);
                return;
            }
            long currentTimeMillis = sNotifyTimeWindow - (java.lang.System.currentTimeMillis() - sLastNotifyTimestamp);
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis > com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                currentTimeMillis = 20000;
            }
            long currentTimeMillis2 = java.lang.System.currentTimeMillis() + currentTimeMillis;
            sLastImportantNotifyTimestamp = currentTimeMillis2;
            sLastNotifyTimestamp = currentTimeMillis2;
            if (currentTimeMillis <= 0) {
                doNotify(notificationManager, i, notification);
            } else if (this.mNotifyThreadHandler != null) {
                synchronized (this.pendingImportantNotify) {
                    this.pendingImportantNotify.put(i, notification);
                }
                this.mNotifyThreadHandler.postDelayed(new com.ss.android.socialbase.downloader.notification.DownloadNotificationService.AnonymousClass2(notificationManager, i), currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x001f, code lost:
    
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.sForegroundId == 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doNotify(android.app.NotificationManager notificationManager, int i, android.app.Notification notification) {
        if (needStartForeground(i, notification)) {
            try {
                boolean z = false;
                boolean z2 = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(i) == 1 && !com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess();
                if (!z2) {
                }
                if (z2 && sIndependentProcessForegroundId == 0) {
                    z = true;
                }
                if (z) {
                    com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadHandler(i);
                    if (!downloadHandler.isServiceAlive() || downloadHandler.isServiceForeground()) {
                        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = ".concat(java.lang.String.valueOf(z2)));
                    } else {
                        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "doNotify, startForeground, ======== id = " + i + ", isIndependentProcess = " + z2);
                        if (z2) {
                            sIndependentProcessForegroundId = i;
                        } else {
                            sForegroundId = i;
                        }
                        downloadHandler.startForeground(i, notification);
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        } else if ((sForegroundId == i || sIndependentProcessForegroundId == i) && sBugFixNonOngoing && (notification.flags & 2) == 0) {
            doCancel(notificationManager, i);
        }
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (sLastNotifyTimestamp < currentTimeMillis) {
                sLastNotifyTimestamp = currentTimeMillis;
            }
            notificationManager.notify(i, notification);
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNotify(notificationManager, i, notification);
        } catch (java.lang.Throwable unused) {
        }
    }

    private void handleIntent(android.content.Intent intent) {
        com.ss.android.socialbase.downloader.thread.ThreadWithHandler threadWithHandler;
        if (intent == null) {
            return;
        }
        java.lang.String action = intent.getAction();
        if (android.text.TextUtils.isEmpty(action) || (threadWithHandler = this.mNotifyThreadHandler) == null) {
            return;
        }
        threadWithHandler.post(new com.ss.android.socialbase.downloader.notification.DownloadNotificationService.AnonymousClass1(intent, action));
    }

    private boolean needStartForeground(int i, android.app.Notification notification) {
        int i2;
        int i3;
        java.lang.String channelId;
        if (!sAllowStartForeground || (i2 = sForegroundId) == i || (i3 = sIndependentProcessForegroundId) == i) {
            return false;
        }
        if (i2 != 0 && i3 != 0) {
            return false;
        }
        if (sBugFixNonOngoing && (notification.flags & 2) == 0) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return true;
        }
        channelId = notification.getChannelId();
        return !android.text.TextUtils.isEmpty(channelId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performImportantNotify(android.app.NotificationManager notificationManager, int i) {
        android.app.Notification notification;
        synchronized (this.pendingImportantNotify) {
            notification = this.pendingImportantNotify.get(i);
            this.pendingImportantNotify.remove(i);
        }
        if (notification != null) {
            doNotify(notificationManager, i, notification);
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        createNotifyHandlerThread();
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setAppContext(this);
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtainGlobal = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal();
        int optInt = obtainGlobal.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DOWNLOAD_SERVICE_FOREGROUND, 0);
        if ((optInt == 1 || optInt == 3) && sForegroundId == -1) {
            sForegroundId = 0;
        }
        if ((optInt == 2 || optInt == 3) && sIndependentProcessForegroundId == -1) {
            sIndependentProcessForegroundId = 0;
        }
        sBugFixNonOngoing = obtainGlobal.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.NON_GOING_NOTIFICATION_FOREGROUND, false);
        sBugfixNotifyTooFast = obtainGlobal.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_NOTIFY_TOO_FAST, false);
        long optLong = obtainGlobal.optLong(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.NOTIFICATION_TIME_WINDOW, NOTIFY_TIME_WINDOW);
        sNotifyTimeWindow = optLong;
        if (optLong < 0 || optLong > 1200) {
            sNotifyTimeWindow = NOTIFY_TIME_WINDOW;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.ss.android.socialbase.downloader.thread.ThreadWithHandler threadWithHandler = this.mNotifyThreadHandler;
        if (threadWithHandler != null) {
            try {
                threadWithHandler.quit();
            } catch (java.lang.Throwable unused) {
            }
            this.mNotifyThreadHandler = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        handleIntent(intent);
        return 2;
    }
}
