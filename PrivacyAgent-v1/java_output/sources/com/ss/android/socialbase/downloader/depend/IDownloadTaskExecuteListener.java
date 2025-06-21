package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadTaskExecuteListener {
    void onFinish(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, @com.ss.android.socialbase.downloader.constants.BoundType int i);

    void onStart(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, @com.ss.android.socialbase.downloader.constants.BoundType int i);
}
