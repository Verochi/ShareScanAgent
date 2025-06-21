package com.ss.android.socialbase.downloader.thread;

/* loaded from: classes19.dex */
public interface IDownloadRunnableCallback {
    boolean canRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException);

    void checkSpaceOverflow(long j) throws com.ss.android.socialbase.downloader.exception.BaseException;

    com.ss.android.socialbase.downloader.model.DownloadChunk getUnCompletedSubChunk(int i);

    void handleFirstConnection(java.lang.String str, com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection, long j) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable;

    void onAllChunkRetryWithReset(com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z);

    void onChunkDowngradeRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException);

    void onCompleted(com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable downloadChunkRunnable);

    void onError(com.ss.android.socialbase.downloader.exception.BaseException baseException);

    boolean onProgress(long j) throws com.ss.android.socialbase.downloader.exception.BaseException;

    com.ss.android.socialbase.downloader.exception.RetryCheckStatus onRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException, long j);

    com.ss.android.socialbase.downloader.exception.RetryCheckStatus onSingleChunkRetry(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, com.ss.android.socialbase.downloader.exception.BaseException baseException, long j);

    void setHttpResponseStatus(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection);
}
