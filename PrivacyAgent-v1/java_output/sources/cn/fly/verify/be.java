package cn.fly.verify;

/* loaded from: classes.dex */
public class be implements cn.fly.verify.bd {
    public static java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean();

    /* renamed from: cn.fly.verify.be$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.ar {
        public AnonymousClass1() {
        }

        @Override // cn.fly.verify.ar
        public void a() {
            if (cn.fly.verify.ax.h() || !cn.fly.verify.be.a.compareAndSet(false, true)) {
                return;
            }
            cn.fly.verify.n.a(true);
        }
    }

    @Override // cn.fly.verify.bd
    public java.lang.String a() {
        c();
        return cn.fly.verify.FlyVerify.sdkTag;
    }

    @Override // cn.fly.verify.bd
    public int b() {
        return 130604;
    }

    public void c() {
        cn.fly.verify.as.a(new cn.fly.verify.be.AnonymousClass1());
    }
}
