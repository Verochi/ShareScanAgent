package cn.fly.verify;

/* loaded from: classes.dex */
public class eh {
    private static cn.fly.verify.eh a = new cn.fly.verify.eh();
    private volatile android.content.Context b;
    private volatile cn.fly.verify.ef c;
    private volatile cn.fly.verify.ef d;
    private volatile cn.fly.verify.ef e;
    private final java.util.concurrent.atomic.AtomicBoolean f = new java.util.concurrent.atomic.AtomicBoolean(false);

    public static cn.fly.verify.eh a(android.content.Context context) {
        if (a.b == null && context != null) {
            a.b = context.getApplicationContext();
        }
        return a;
    }

    public java.util.concurrent.CountDownLatch a() {
        b();
        return cn.fly.verify.ei.a(this.b).a();
    }

    public boolean a(cn.fly.verify.ef efVar) {
        this.e = efVar;
        return true;
    }

    public void b() {
        if (this.f.compareAndSet(false, true)) {
            d();
            c();
            cn.fly.verify.ej.a(this.b);
        }
    }

    public cn.fly.verify.ef c() {
        if (this.c == null) {
            this.c = new cn.fly.verify.eo(this.b);
        }
        return this.c;
    }

    public cn.fly.verify.ef d() {
        if (this.d == null) {
            this.d = new cn.fly.verify.el(this.b);
        }
        return this.d;
    }

    public cn.fly.verify.ef e() {
        return this.e == null ? c() : this.e;
    }
}
