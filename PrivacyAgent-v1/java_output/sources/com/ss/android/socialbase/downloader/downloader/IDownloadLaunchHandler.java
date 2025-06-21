package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public interface IDownloadLaunchHandler {
    java.util.List<java.lang.String> getResumeMimeTypes();

    void onLaunchResume(java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> list, int i);
}
