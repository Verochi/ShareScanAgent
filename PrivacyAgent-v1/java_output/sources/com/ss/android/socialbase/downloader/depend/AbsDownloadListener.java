package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public abstract class AbsDownloadListener implements com.ss.android.socialbase.downloader.depend.IDownloadListener {
    private static final java.lang.String TAG = "AbsDownloadListener";

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " onCanceled -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        java.lang.String str = TAG;
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.logger.Logger.d(str, java.lang.String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " onFirstStart -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " onFirstSuccess -- " + downloadInfo.getName());
    }

    public void onIntercept(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " onIntercept -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " onPause -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " onPrepare -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, java.lang.String.format("onProgress %s %.2f%%", downloadInfo.getName(), java.lang.Float.valueOf((downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        java.lang.String str = TAG;
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.logger.Logger.d(str, java.lang.String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        java.lang.String str = TAG;
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.logger.Logger.d(str, java.lang.String.format("onRetryDelay on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " onStart -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.logger.Logger.debug() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
    }
}
