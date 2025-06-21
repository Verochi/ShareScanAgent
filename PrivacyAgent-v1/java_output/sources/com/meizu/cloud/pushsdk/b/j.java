package com.meizu.cloud.pushsdk.b;

/* loaded from: classes23.dex */
public final class j {
    private java.lang.String a = null;
    private java.lang.Boolean b = null;
    private java.lang.Integer c = null;
    private java.lang.Thread.UncaughtExceptionHandler d = null;
    private java.util.concurrent.ThreadFactory e = null;

    /* renamed from: com.meizu.cloud.pushsdk.b.j$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        final /* synthetic */ java.util.concurrent.ThreadFactory a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.util.concurrent.atomic.AtomicLong c;
        final /* synthetic */ java.lang.Boolean d;
        final /* synthetic */ java.lang.Integer e;
        final /* synthetic */ java.lang.Thread.UncaughtExceptionHandler f;

        public AnonymousClass1(java.util.concurrent.ThreadFactory threadFactory, java.lang.String str, java.util.concurrent.atomic.AtomicLong atomicLong, java.lang.Boolean bool, java.lang.Integer num, java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.a = threadFactory;
            this.b = str;
            this.c = atomicLong;
            this.d = bool;
            this.e = num;
            this.f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread newThread = this.a.newThread(runnable);
            java.lang.String str = this.b;
            if (str != null) {
                newThread.setName(java.lang.String.format(str, java.lang.Long.valueOf(this.c.getAndIncrement())));
            }
            java.lang.Boolean bool = this.d;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            java.lang.Integer num = this.e;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    private static java.util.concurrent.ThreadFactory a(com.meizu.cloud.pushsdk.b.j jVar) {
        java.lang.String str = jVar.a;
        java.lang.Boolean bool = jVar.b;
        java.lang.Integer num = jVar.c;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = jVar.d;
        java.util.concurrent.ThreadFactory threadFactory = jVar.e;
        if (threadFactory == null) {
            threadFactory = java.util.concurrent.Executors.defaultThreadFactory();
        }
        return new com.meizu.cloud.pushsdk.b.j.AnonymousClass1(threadFactory, str, str != null ? new java.util.concurrent.atomic.AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public com.meizu.cloud.pushsdk.b.j a(java.lang.String str) {
        java.lang.String.format(str, 0);
        this.a = str;
        return this;
    }

    public java.util.concurrent.ThreadFactory a() {
        return a(this);
    }
}
