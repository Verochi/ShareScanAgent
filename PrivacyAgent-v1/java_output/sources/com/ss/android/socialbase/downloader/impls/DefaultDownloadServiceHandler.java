package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DefaultDownloadServiceHandler extends com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler {
    private static final java.lang.String TAG = "DefaultDownloadServiceHandler";

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(android.content.Intent intent, int i, int i2) {
        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(262144)) {
            this.isServiceAlive = true;
        }
        resumePendingTask();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
        if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(262144)) {
            this.isServiceAlive = true;
            this.isInvokeStartService = false;
            if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(android.content.Context context, android.content.ServiceConnection serviceConnection) {
        try {
            context.startService(new android.content.Intent(context, (java.lang.Class<?>) com.ss.android.socialbase.downloader.downloader.DownloadService.class));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(android.content.Context context, android.content.ServiceConnection serviceConnection) {
        context.stopService(new android.content.Intent(context, (java.lang.Class<?>) com.ss.android.socialbase.downloader.downloader.DownloadService.class));
        this.isServiceAlive = false;
    }
}
