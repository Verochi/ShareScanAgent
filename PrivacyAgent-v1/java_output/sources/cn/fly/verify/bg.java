package cn.fly.verify;

/* loaded from: classes.dex */
public class bg implements java.lang.Runnable {
    private static volatile cn.fly.verify.bg a;
    private final java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.concurrent.CopyOnWriteArrayList<cn.fly.verify.bf> c = new java.util.concurrent.CopyOnWriteArrayList<>();

    private bg() {
    }

    public static cn.fly.verify.bg a() {
        if (a == null) {
            synchronized (cn.fly.verify.dz.class) {
                if (a == null) {
                    a = new cn.fly.verify.bg();
                }
            }
        }
        return a;
    }

    private long c() {
        return ((java.lang.Integer) cn.fly.verify.fq.a(cn.fly.verify.bo.a(cn.fly.verify.bj.a("003Kek5kj"), 300), 300)).intValue() * 1000;
    }

    public <T extends cn.fly.verify.bf> void a(T t, int i) {
        if (i != 1) {
            if (i != 3) {
                this.c.add(t);
                return;
            } else {
                this.c.add(0, t);
                return;
            }
        }
        java.util.Iterator<cn.fly.verify.bf> it = this.c.iterator();
        while (it.hasNext()) {
            cn.fly.verify.bf next = it.next();
            if (t.j() == next.j()) {
                this.c.set(this.c.indexOf(next), t);
            } else {
                this.c.add(t);
            }
        }
    }

    public void a(cn.fly.verify.bf bfVar, long j, int i) {
        if (j == 0 && (i == 0 || i == 3)) {
            bfVar.g();
        } else {
            cn.fly.verify.bj.a().a(j, (long) bfVar, i);
        }
    }

    public void b() {
        if (this.b.compareAndSet(false, true)) {
            a(new cn.fly.verify.bh(), 0);
            a(new cn.fly.verify.bi(), 0);
            cn.fly.verify.ea.c.execute(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        cn.fly.verify.bj a2;
        long c;
        if (this.c.size() > 0) {
            if (!cn.fly.verify.bo.d() || !cn.fly.verify.de.f()) {
                a2 = cn.fly.verify.bj.a();
                c = 60000;
                a2.d(c, this);
            } else {
                try {
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    java.util.Iterator<cn.fly.verify.bf> it = this.c.iterator();
                    while (it.hasNext()) {
                        cn.fly.verify.bf next = it.next();
                        if (currentTimeMillis >= next.i()) {
                            next.g();
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        a2 = cn.fly.verify.bj.a();
        c = c();
        a2.d(c, this);
    }
}
