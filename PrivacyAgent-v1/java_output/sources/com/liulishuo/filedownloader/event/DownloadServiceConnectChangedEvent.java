package com.liulishuo.filedownloader.event;

/* loaded from: classes23.dex */
public class DownloadServiceConnectChangedEvent extends com.liulishuo.filedownloader.event.IDownloadEvent {
    public static final java.lang.String ID = "event.service.connect.changed";
    public final com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus a;
    public final java.lang.Class<?> b;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus connectStatus, java.lang.Class<?> cls) {
        super(ID);
        this.a = connectStatus;
        this.b = cls;
    }

    public com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus getStatus() {
        return this.a;
    }

    public boolean isSuchService(java.lang.Class<?> cls) {
        java.lang.Class<?> cls2 = this.b;
        return cls2 != null && cls2.getName().equals(cls.getName());
    }
}
