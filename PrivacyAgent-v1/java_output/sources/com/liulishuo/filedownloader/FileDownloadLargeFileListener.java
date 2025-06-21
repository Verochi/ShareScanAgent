package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public abstract class FileDownloadLargeFileListener extends com.liulishuo.filedownloader.FileDownloadListener {
    public FileDownloadLargeFileListener() {
    }

    public FileDownloadLargeFileListener(int i) {
        super(i);
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void connected(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.String str, boolean z, int i, int i2) {
    }

    public void connected(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.String str, boolean z, long j, long j2) {
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void paused(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
    }

    public abstract void paused(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, long j, long j2);

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void pending(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
    }

    public abstract void pending(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, long j, long j2);

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void progress(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
    }

    public abstract void progress(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, long j, long j2);

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void retry(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th, int i, int i2) {
    }

    public void retry(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th, int i, long j) {
    }
}
