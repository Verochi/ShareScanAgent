package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public abstract class AbsDownloadExtListener extends com.ss.android.socialbase.downloader.depend.AbsDownloadListener implements com.ss.android.socialbase.downloader.depend.IDownloadExtListener {
    private static final java.lang.String TAG = "AbsDownloadExtListener";

    public void onWaitingDownloadCompleteHandler(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
