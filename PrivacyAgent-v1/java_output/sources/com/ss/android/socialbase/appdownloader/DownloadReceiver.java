package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public class DownloadReceiver extends android.content.BroadcastReceiver {
    private static final java.lang.String vw = "DownloadReceiver";
    private android.os.Handler wg = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent vw;
        final /* synthetic */ android.content.Context wg;

        /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04801 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;

            /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$1$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC04811 implements java.lang.Runnable {
                public RunnableC04811() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (com.ss.android.socialbase.appdownloader.DownloadReceiver.AnonymousClass1.RunnableC04801.this.vw.isSavePathRedirected()) {
                            com.ss.android.socialbase.downloader.utils.DownloadUtils.clearAntiHijackDir(com.ss.android.socialbase.appdownloader.DownloadReceiver.AnonymousClass1.RunnableC04801.this.vw);
                        }
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
            }

            public RunnableC04801(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.vw = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.appdownloader.DownloadReceiver.AnonymousClass1.RunnableC04801.RunnableC04811());
            }
        }

        public AnonymousClass1(android.content.Intent intent, android.content.Context context) {
            this.vw = intent;
            this.wg = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.net.Uri data = this.vw.getData();
            if (data == null) {
                return;
            }
            java.lang.String schemeSpecificPart = data.getSchemeSpecificPart();
            com.ss.android.socialbase.appdownloader.t.v wg = com.ss.android.socialbase.appdownloader.v.es().wg();
            if (wg != null) {
                wg.vw(this.wg, schemeSpecificPart);
            }
            java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> successedDownloadInfosWithMimeType = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(this.wg).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
            if (successedDownloadInfosWithMimeType != null) {
                for (com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                    if (downloadInfo != null && com.ss.android.socialbase.appdownloader.t.vw(downloadInfo, schemeSpecificPart)) {
                        com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener downloadNotificationEventListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(this.wg).getDownloadNotificationEventListener(downloadInfo.getId());
                        if (downloadNotificationEventListener != null && com.ss.android.socialbase.downloader.utils.DownloadUtils.isProcessNameSame(downloadNotificationEventListener.getNotifyProcessName())) {
                            downloadNotificationEventListener.onNotificationEvent(9, downloadInfo, schemeSpecificPart, "");
                        }
                        com.ss.android.socialbase.downloader.notification.AbsNotificationItem notificationItem = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
                        if (notificationItem != null) {
                            notificationItem.updateNotification(null, false);
                        }
                        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("install_queue_enable", 0) == 1) {
                            com.ss.android.socialbase.appdownloader.o.vw().vw(downloadInfo, schemeSpecificPart);
                        }
                        com.ss.android.socialbase.appdownloader.DownloadReceiver.this.wg.postDelayed(new com.ss.android.socialbase.appdownloader.DownloadReceiver.AnonymousClass1.RunnableC04801(downloadInfo), 1000L);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ java.lang.String wg;

        public AnonymousClass2(android.content.Context context, java.lang.String str) {
            this.vw = context;
            this.wg = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                android.content.Intent intent = new android.content.Intent(this.vw, (java.lang.Class<?>) com.ss.android.socialbase.appdownloader.DownloadHandlerService.class);
                intent.setAction(this.wg);
                this.vw.startService(intent);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void vw(android.content.Context context, java.lang.String str) {
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.needAutoRefreshUnSuccessTask()) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitScheduleTask(new com.ss.android.socialbase.appdownloader.DownloadReceiver.AnonymousClass2(context, str), 2000L, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (context == null || intent == null) {
            return;
        }
        java.lang.String action = intent.getAction();
        if (android.text.TextUtils.isEmpty(action)) {
            return;
        }
        com.ss.android.socialbase.appdownloader.t.t vw2 = com.ss.android.socialbase.appdownloader.v.es().vw();
        if (action.equals("android.intent.action.BOOT_COMPLETED") && (vw2 == null || vw2.vw())) {
            if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.v(vw, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
            }
            vw(context, action);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.v(vw, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            vw(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.appdownloader.DownloadReceiver.AnonymousClass1(intent, context));
        }
    }
}
