package com.aliyun.auth.core;

/* loaded from: classes.dex */
public class VodThreadService {
    private android.os.Handler mHandler;
    private android.os.HandlerThread mHandlerThread;

    public VodThreadService(java.lang.String str) {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(str);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new android.os.Handler(this.mHandlerThread.getLooper());
    }

    public void execute(java.lang.Runnable runnable) {
        this.mHandler.post(runnable);
    }

    public void quit() {
        android.os.HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }
}
