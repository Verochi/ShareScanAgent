package com.zx.sdk.common.utils;

/* loaded from: classes19.dex */
public class ZXTask implements java.lang.Runnable {
    private com.zx.sdk.common.utils.ZXTask.a errorCallback;
    private java.lang.Runnable r;

    public interface a {
    }

    public ZXTask(java.lang.Runnable runnable, com.zx.sdk.common.utils.ZXTask.a aVar) {
        this.r = runnable;
        this.errorCallback = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            java.lang.Runnable runnable = this.r;
            if (runnable != null) {
                runnable.run();
            }
        } catch (java.lang.Throwable th) {
            com.zx.sdk.common.utils.ZXTask.a aVar = this.errorCallback;
            if (aVar != null) {
                ((com.zx.a.I8b7.r3) aVar).a.c.onMessage("MESSAGE_ON_ZXID_RECEIVED", com.zx.a.I8b7.e2.a(10008, th.getMessage()));
                com.zx.a.I8b7.g3.a(th, new java.lang.StringBuilder("ZXCore start failed: "));
            }
        }
    }
}
