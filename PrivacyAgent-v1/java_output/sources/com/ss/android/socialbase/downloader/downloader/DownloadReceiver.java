package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public class DownloadReceiver extends android.content.BroadcastReceiver {
    private static final java.lang.String TAG = "DownloadReceiver";

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadReceiver$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$action;
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass1(android.content.Context context, java.lang.String str) {
            this.val$context = context;
            this.val$action = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                android.content.Intent intent = new android.content.Intent(this.val$context, (java.lang.Class<?>) com.ss.android.socialbase.downloader.notification.DownloadNotificationService.class);
                intent.setAction(this.val$action);
                this.val$context.startService(intent);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadReceiver$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$action;
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass2(android.content.Context context, java.lang.String str) {
            this.val$context = context;
            this.val$action = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                android.content.Intent intent = new android.content.Intent(this.val$context, (java.lang.Class<?>) com.ss.android.socialbase.downloader.notification.DownloadNotificationService.class);
                intent.setAction(this.val$action);
                this.val$context.startService(intent);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void autoRefreshUnsuccessDownloadTask(android.content.Context context, java.lang.String str) {
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.needAutoRefreshUnSuccessTask()) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitScheduleTask(new com.ss.android.socialbase.downloader.downloader.DownloadReceiver.AnonymousClass1(context, str), 2000L, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
    }

    private void forceStopAllDownloadTask(android.content.Context context, java.lang.String str) {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitCPUTask(new com.ss.android.socialbase.downloader.downloader.DownloadReceiver.AnonymousClass2(context, str));
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
        if (action.equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.v(TAG, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            autoRefreshUnsuccessDownloadTask(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            forceStopAllDownloadTask(context, action);
        }
    }
}
