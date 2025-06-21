package com.meizu.cloud.pushsdk.b.c;

/* loaded from: classes23.dex */
public class c implements java.util.concurrent.Executor {
    private final java.util.concurrent.ThreadPoolExecutor a;

    public static class a {
        private static com.meizu.cloud.pushsdk.b.c.c a = new com.meizu.cloud.pushsdk.b.c.c(null);
    }

    private c() {
        this.a = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.meizu.cloud.pushsdk.b.c.d().a("single-pool-%d").a());
    }

    public /* synthetic */ c(com.meizu.cloud.pushsdk.b.c.c.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.meizu.cloud.pushsdk.b.c.c a() {
        return com.meizu.cloud.pushsdk.b.c.c.a.a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        this.a.execute(runnable);
    }
}
