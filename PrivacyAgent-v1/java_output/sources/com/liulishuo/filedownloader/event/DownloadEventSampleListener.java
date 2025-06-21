package com.liulishuo.filedownloader.event;

/* loaded from: classes23.dex */
public class DownloadEventSampleListener extends com.liulishuo.filedownloader.event.IDownloadListener {
    public final com.liulishuo.filedownloader.event.DownloadEventSampleListener.IEventListener a;

    public interface IEventListener {
        boolean callback(com.liulishuo.filedownloader.event.IDownloadEvent iDownloadEvent);
    }

    public DownloadEventSampleListener(com.liulishuo.filedownloader.event.DownloadEventSampleListener.IEventListener iEventListener) {
        this.a = iEventListener;
    }

    @Override // com.liulishuo.filedownloader.event.IDownloadListener
    public boolean callback(com.liulishuo.filedownloader.event.IDownloadEvent iDownloadEvent) {
        com.liulishuo.filedownloader.event.DownloadEventSampleListener.IEventListener iEventListener = this.a;
        return iEventListener != null && iEventListener.callback(iDownloadEvent);
    }
}
