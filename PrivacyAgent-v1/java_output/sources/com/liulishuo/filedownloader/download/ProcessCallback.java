package com.liulishuo.filedownloader.download;

/* loaded from: classes23.dex */
public interface ProcessCallback {
    boolean isRetry(java.lang.Exception exc);

    void onCompleted(com.liulishuo.filedownloader.download.DownloadRunnable downloadRunnable, long j, long j2);

    void onError(java.lang.Exception exc);

    void onProgress(long j);

    void onRetry(java.lang.Exception exc);

    void syncProgressFromCache();
}
