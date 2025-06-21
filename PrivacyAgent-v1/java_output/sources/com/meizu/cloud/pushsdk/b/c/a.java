package com.meizu.cloud.pushsdk.b.c;

/* loaded from: classes23.dex */
public class a implements java.util.concurrent.Executor {
    private final java.util.concurrent.ThreadPoolExecutor a;

    /* renamed from: com.meizu.cloud.pushsdk.b.c.a$a, reason: collision with other inner class name */
    public static class C0421a {
        private static com.meizu.cloud.pushsdk.b.c.a a = new com.meizu.cloud.pushsdk.b.c.a(null);
    }

    private a() {
        this.a = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new com.meizu.cloud.pushsdk.b.c.d().a("io-pool-%d").a());
    }

    public /* synthetic */ a(com.meizu.cloud.pushsdk.b.c.a.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.meizu.cloud.pushsdk.b.c.a a() {
        return com.meizu.cloud.pushsdk.b.c.a.C0421a.a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        this.a.execute(runnable);
    }
}
