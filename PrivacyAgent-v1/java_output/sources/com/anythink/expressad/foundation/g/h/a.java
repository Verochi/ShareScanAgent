package com.anythink.expressad.foundation.g.h;

/* loaded from: classes12.dex */
public final class a {
    public static java.util.concurrent.ThreadPoolExecutor a;
    private static java.util.concurrent.ThreadPoolExecutor b;
    private static java.util.concurrent.ThreadPoolExecutor c;

    /* renamed from: com.anythink.expressad.foundation.g.h.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            java.lang.Thread newThread = java.util.concurrent.Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("CommonThreadPool");
            return newThread;
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.h.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            java.lang.Thread newThread = java.util.concurrent.Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("ReportThreadPool");
            return newThread;
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.h.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            java.lang.Thread newThread = java.util.concurrent.Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("NwtThreadPool");
            return newThread;
        }
    }

    public static java.util.concurrent.ThreadPoolExecutor a() {
        if (a == null) {
            a = new java.util.concurrent.ThreadPoolExecutor(5, 10, 15L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(60), new com.anythink.expressad.foundation.g.h.a.AnonymousClass1(), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        }
        return a;
    }

    public static java.util.concurrent.ThreadPoolExecutor b() {
        if (c == null) {
            c = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(1), new com.anythink.expressad.foundation.g.h.a.AnonymousClass3(), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        }
        return c;
    }

    private static java.util.concurrent.ThreadPoolExecutor c() {
        if (b == null) {
            b = new java.util.concurrent.ThreadPoolExecutor(5, 200, 5L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(60), new com.anythink.expressad.foundation.g.h.a.AnonymousClass2(), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        }
        return b;
    }
}
