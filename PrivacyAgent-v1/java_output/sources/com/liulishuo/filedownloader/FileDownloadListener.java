package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public abstract class FileDownloadListener {
    public FileDownloadListener() {
    }

    public FileDownloadListener(int i) {
        com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "not handle priority any more", new java.lang.Object[0]);
    }

    public void blockComplete(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) throws java.lang.Throwable {
    }

    public abstract void completed(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask);

    public void connected(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.String str, boolean z, int i, int i2) {
    }

    public abstract void error(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th);

    public boolean isInvalid() {
        return false;
    }

    public abstract void paused(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2);

    public abstract void pending(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2);

    public abstract void progress(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2);

    public void retry(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th, int i, int i2) {
    }

    public void started(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
    }

    public abstract void warn(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask);
}
