package com.ss.android.socialbase.downloader.thread;

/* loaded from: classes19.dex */
public class WeakDownloadHandler extends android.os.Handler {
    private final java.lang.ref.WeakReference<com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler> mRef;

    public interface IHandler {
        void handleMsg(android.os.Message message);
    }

    public WeakDownloadHandler(android.os.Looper looper, com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler iHandler) {
        super(looper);
        this.mRef = new java.lang.ref.WeakReference<>(iHandler);
    }

    public WeakDownloadHandler(com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler iHandler) {
        this.mRef = new java.lang.ref.WeakReference<>(iHandler);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler iHandler = this.mRef.get();
        if (iHandler == null || message == null) {
            return;
        }
        iHandler.handleMsg(message);
    }
}
