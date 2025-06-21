package cn.fly.verify;

/* loaded from: classes.dex */
public class at {
    private boolean a;
    private java.lang.Object b;
    private java.lang.String c;
    private cn.fly.verify.e d;

    public at(java.lang.String str) {
        this.c = str == null ? getClass().getSimpleName() : str;
    }

    public synchronized java.lang.Object a() {
        if (!this.a) {
            this.b = null;
            this.a = true;
            cn.fly.verify.f.a().a(this.c + " do lock");
            return null;
        }
        try {
            cn.fly.verify.f.a().a(this.c + " wait lock");
            wait();
            cn.fly.verify.f.a().a(this.c + " after wait, result = " + this.b);
            return this.b;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            return null;
        }
    }

    public void a(cn.fly.verify.e eVar) {
        this.d = eVar;
        cn.fly.verify.f.a().a("last:" + eVar.a());
    }

    public synchronized void a(java.lang.Object obj) {
        if (obj != null) {
            this.b = obj;
        }
        try {
            if (this.a) {
                cn.fly.verify.f.a().a(this.c + " notify wait");
                notifyAll();
                this.a = false;
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
        }
    }

    public synchronized java.lang.Object b() {
        if (!this.a) {
            return null;
        }
        try {
            cn.fly.verify.f.a().a(this.c + " wait lock");
            wait();
            cn.fly.verify.f.a().a(this.c + " after wait, result = " + this.b);
            return this.b;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            return null;
        }
    }

    public cn.fly.verify.e c() {
        cn.fly.verify.f.a().a("last:" + this.d.a());
        return this.d;
    }
}
