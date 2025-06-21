package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class x2 {
    public static final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    public class a implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context a;

        public a(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.zx.a.I8b7.m3.b(this.a);
                try {
                    com.zx.a.I8b7.x2.a().a();
                } catch (java.lang.Throwable th) {
                    new java.lang.StringBuilder("can ignore,").append(th.getMessage());
                }
            } catch (java.lang.Throwable th2) {
                com.zx.a.I8b7.g3.a(th2, com.zx.a.I8b7.f3.a("ZXCore init failed: "));
                com.zx.a.I8b7.x2.a.set(false);
            }
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.x2 a = new com.zx.a.I8b7.x2();
    }

    public static com.zx.a.I8b7.h3 a() {
        android.os.Handler handler = com.zx.a.I8b7.k3.a;
        com.zx.a.I8b7.k3 k3Var = com.zx.a.I8b7.k3.a.a;
        if (k3Var.b()) {
            throw new java.lang.RuntimeException("请先调用 ZXManager.checkPermission() 检查用户是否已授权");
        }
        if (!k3Var.a()) {
            throw new java.lang.RuntimeException("用户未授权");
        }
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = com.zx.a.I8b7.h3.e;
        return com.zx.a.I8b7.h3.e.a;
    }

    public static void a(android.content.Context context) {
        try {
            if (a.getAndSet(true)) {
                return;
            }
            com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.x2.a(context));
        } catch (java.lang.Throwable th) {
            a.set(false);
            com.zx.a.I8b7.r.b("ZXManager.init failed:".concat(java.lang.String.valueOf(th)));
        }
    }

    public static final com.zx.a.I8b7.x2 b() {
        if (a.get()) {
            return com.zx.a.I8b7.x2.b.a;
        }
        throw new java.lang.IllegalStateException("ZXManager not init, should init firstly");
    }

    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String a(java.lang.String str, java.lang.String str2) throws java.lang.Throwable;
}
