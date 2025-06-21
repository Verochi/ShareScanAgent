package com.meizu.cloud.pushsdk.b.c;

/* loaded from: classes23.dex */
public class b implements java.util.concurrent.Executor {
    private final java.util.concurrent.ThreadPoolExecutor a;

    public static class a {
        private static com.meizu.cloud.pushsdk.b.c.b a = new com.meizu.cloud.pushsdk.b.c.b(null);
    }

    private b() {
        this.a = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.meizu.cloud.pushsdk.b.c.d().a((java.lang.Integer) 10).a("message-pool-%d").a());
    }

    public /* synthetic */ b(com.meizu.cloud.pushsdk.b.c.b.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.meizu.cloud.pushsdk.b.c.b a() {
        return com.meizu.cloud.pushsdk.b.c.b.a.a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        this.a.execute(runnable);
    }
}
