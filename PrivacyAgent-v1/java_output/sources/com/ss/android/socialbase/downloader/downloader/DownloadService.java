package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public class DownloadService extends android.app.Service {
    private static final java.lang.String TAG = "DownloadService";
    protected com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler downloadServiceHandler;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadService$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$flags;
        final /* synthetic */ android.content.Intent val$intent;
        final /* synthetic */ int val$startId;

        public AnonymousClass1(android.content.Intent intent, int i, int i2) {
            this.val$intent = intent;
            this.val$flags = i;
            this.val$startId = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler iDownloadServiceHandler = com.ss.android.socialbase.downloader.downloader.DownloadService.this.downloadServiceHandler;
            if (iDownloadServiceHandler != null) {
                iDownloadServiceHandler.onStartCommand(this.val$intent, this.val$flags, this.val$startId);
            }
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        java.lang.String str = TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("onBind downloadServiceHandler != null:");
        sb.append(this.downloadServiceHandler != null);
        com.ss.android.socialbase.downloader.logger.Logger.d(str, sb.toString());
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            return iDownloadServiceHandler.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setAppContext(this);
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler downloadServiceHandler = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadServiceHandler();
        this.downloadServiceHandler = downloadServiceHandler;
        downloadServiceHandler.setDownloadService(new java.lang.ref.WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "Service onDestroy");
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.onDestroy();
            this.downloadServiceHandler = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "DownloadService onStartCommand");
        }
        this.downloadServiceHandler.onStartCommandOnMainThread();
        java.util.concurrent.ExecutorService cPUThreadExecutor = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor();
        if (cPUThreadExecutor != null) {
            cPUThreadExecutor.execute(new com.ss.android.socialbase.downloader.downloader.DownloadService.AnonymousClass1(intent, i, i2));
        }
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.notAutoRebootService() ? 2 : 3;
    }
}
