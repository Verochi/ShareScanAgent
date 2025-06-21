package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public interface IThreadPoolMonitor {
    int findRunningTaskIdBySameTempPath(java.lang.String str, int i);

    boolean isDownloading(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel);
}
