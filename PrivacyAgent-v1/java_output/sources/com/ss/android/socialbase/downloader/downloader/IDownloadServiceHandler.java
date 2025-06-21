package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public interface IDownloadServiceHandler<T extends com.ss.android.socialbase.downloader.downloader.DownloadService> {
    boolean isServiceAlive();

    boolean isServiceForeground();

    android.os.IBinder onBind(android.content.Intent intent);

    void onDestroy();

    void onStartCommand(android.content.Intent intent, int i, int i2);

    void onStartCommandOnMainThread();

    void pendDownloadTask(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask);

    void setDownloadService(java.lang.ref.WeakReference<T> weakReference);

    void setLogLevel(int i);

    void setServiceConnectionListener(com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener iDownloadServiceConnectionListener);

    void startForeground(int i, android.app.Notification notification);

    void startService();

    void stopForeground(boolean z);

    void tryDownload(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask);

    void tryDownloadWithEngine(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask);
}
