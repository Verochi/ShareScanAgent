package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public interface ISqlDownloadCache extends com.ss.android.socialbase.downloader.downloader.IDownloadCache {
    void init(android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray, android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> sparseArray2, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback);

    void setInitCallback(com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl);
}
