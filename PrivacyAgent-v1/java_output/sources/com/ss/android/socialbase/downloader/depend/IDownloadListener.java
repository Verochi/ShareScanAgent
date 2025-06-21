package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadListener {
    void onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException);

    void onFirstStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void onFirstSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void onRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException);

    void onRetryDelay(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException);

    void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);
}
