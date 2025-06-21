package cn.fly.verify;

/* loaded from: classes.dex */
public class bi extends cn.fly.verify.bf {
    private static cn.fly.verify.dl c;

    /* renamed from: cn.fly.verify.bi$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.dl {
        @Override // cn.fly.verify.dl
        public void a(boolean z, boolean z2, long j) {
            if (z) {
                cn.fly.verify.bi biVar = new cn.fly.verify.bi();
                biVar.b(false).a(java.lang.Long.valueOf(java.lang.System.currentTimeMillis())).a(true);
                cn.fly.verify.bg.a().a(biVar, 0L, 0);
            }
        }
    }

    public bi() {
        super("p", 0L, null, 0L, 0L);
        a(0);
    }

    private static synchronized boolean m() {
        synchronized (cn.fly.verify.bi.class) {
            if (c != null) {
                return false;
            }
            c = new cn.fly.verify.bi.AnonymousClass1();
            cn.fly.verify.ba.a().a(c);
            return true;
        }
    }

    @Override // cn.fly.verify.bf
    public void a() {
        m();
    }

    @Override // cn.fly.verify.bf
    public void k() {
        if (f()) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put(cn.fly.verify.dt.a("004i%dk6jf"), "PVMT");
        hashMap.put(cn.fly.verify.dt.a("008Ydc4difiMdidf%f"), this.b);
        if (!cn.fly.verify.dk.a().a.get()) {
            hashMap.putAll(cn.fly.verify.dk.a().c());
            cn.fly.verify.dk.a().a.compareAndSet(false, true);
        }
        cn.fly.verify.cd.a().a(java.lang.System.currentTimeMillis(), hashMap);
    }
}
