package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public abstract class FileDownloadConnectListener extends com.liulishuo.filedownloader.event.IDownloadListener {
    public com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus a;

    @Override // com.liulishuo.filedownloader.event.IDownloadListener
    public boolean callback(com.liulishuo.filedownloader.event.IDownloadEvent iDownloadEvent) {
        if (!(iDownloadEvent instanceof com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent)) {
            return false;
        }
        com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus status = ((com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent) iDownloadEvent).getStatus();
        this.a = status;
        if (status == com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            connected();
            return false;
        }
        disconnected();
        return false;
    }

    public abstract void connected();

    public abstract void disconnected();

    public com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus getConnectStatus() {
        return this.a;
    }
}
