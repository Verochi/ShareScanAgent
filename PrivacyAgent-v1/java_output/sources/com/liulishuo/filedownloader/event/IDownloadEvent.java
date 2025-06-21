package com.liulishuo.filedownloader.event;

/* loaded from: classes23.dex */
public abstract class IDownloadEvent {
    public java.lang.Runnable callback = null;
    protected final java.lang.String id;

    public IDownloadEvent(java.lang.String str) {
        this.id = str;
    }

    public IDownloadEvent(java.lang.String str, boolean z) {
        this.id = str;
        if (z) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "do not handle ORDER any more, %s", str);
        }
    }

    public final java.lang.String getId() {
        return this.id;
    }
}
