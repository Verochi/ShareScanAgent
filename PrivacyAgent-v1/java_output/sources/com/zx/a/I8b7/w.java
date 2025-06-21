package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class w implements java.util.concurrent.ThreadFactory {
    public java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

    public class a implements java.lang.Thread.UncaughtExceptionHandler {
        public a(com.zx.a.I8b7.w wVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        }
    }

    public w(com.zx.a.I8b7.x xVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable);
        java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("ZXHttpClient dispatcher's thread");
        a2.append(this.a.getAndIncrement());
        thread.setName(a2.toString());
        thread.setUncaughtExceptionHandler(new com.zx.a.I8b7.w.a(this));
        return thread;
    }
}
