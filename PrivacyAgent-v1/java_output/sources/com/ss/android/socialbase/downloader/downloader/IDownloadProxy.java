package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public interface IDownloadProxy {
    void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk);

    void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z);

    void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z, boolean z2);

    void addProcessCallback(com.ss.android.socialbase.downloader.depend.ProcessCallback processCallback);

    boolean canResume(int i);

    void cancel(int i, boolean z);

    void clearData();

    void clearDownloadData(int i, boolean z);

    void dispatchProcessCallback(int i, int i2);

    void forceDownloadIngoreRecommendSize(int i);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo();

    long getCurBytes(int i);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i);

    com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider getDownloadFileUriProvider(int i);

    int getDownloadId(java.lang.String str, java.lang.String str2);

    com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i);

    com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(java.lang.String str, java.lang.String str2);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str);

    com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener getDownloadNotificationEventListener(int i);

    int getDownloadWithIndependentProcessStatus(int i);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str);

    com.ss.android.socialbase.downloader.depend.INotificationClickCallback getNotificationClickCallback(int i);

    int getStatus(int i);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str);

    java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str);

    boolean isDownloadCacheSyncSuccess();

    boolean isDownloadSuccessAndFileNotExist(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    boolean isDownloading(int i);

    boolean isHttpServiceInit();

    boolean isServiceAlive();

    boolean isServiceForeground();

    void pause(int i);

    void pauseAll();

    void removeAllDownloadChunk(int i);

    boolean removeDownloadInfo(int i);

    void removeDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z);

    boolean removeDownloadTaskData(int i);

    void resetDownloadData(int i, boolean z);

    void restart(int i);

    void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list);

    void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list);

    void resume(int i);

    boolean retryDelayStart(int i);

    void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener);

    void setDownloadWithIndependentProcessStatus(int i, boolean z);

    void setLogLevel(int i);

    void setThrottleNetSpeed(int i, long j);

    void startForeground(int i, android.app.Notification notification);

    void startService();

    void stopForeground(boolean z, boolean z2);

    void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list);

    void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list);

    void tryDownload(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask);

    void tryDownloadWithEngine(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask);

    void updateDownloadChunk(int i, int i2, long j);

    boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    void updateSubDownloadChunk(int i, int i2, int i3, long j);

    void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4);
}
