package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public interface IDownloadCache {
    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel(int i, long j);

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted(int i, long j);

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected(int i, long j, java.lang.String str, java.lang.String str2);

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError(int i, long j);

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept(int i);

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause(int i, long j);

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare(int i);

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress(int i, long j);

    com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry(int i);

    void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk);

    void addSubDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk);

    boolean cacheExist(int i);

    void clearData();

    boolean ensureDownloadCacheSyncSuccess();

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo();

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i);

    com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str);

    java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> getSegmentMap(int i);

    java.util.List<com.ss.android.socialbase.downloader.segment.Segment> getSegments(int i);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str);

    void init();

    boolean isDownloadCacheSyncSuccess();

    com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart(int i);

    void removeAllDownloadChunk(int i);

    boolean removeDownloadInfo(int i);

    boolean removeDownloadTaskData(int i);

    void removeSegments(int i);

    void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list);

    void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list);

    com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount(int i, int i2);

    void updateDownloadChunk(int i, int i2, long j);

    boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    boolean updateSegments(int i, java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> map);

    void updateSubDownloadChunk(int i, int i2, int i3, long j);

    void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4);
}
