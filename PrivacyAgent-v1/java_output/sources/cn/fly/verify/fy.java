package cn.fly.verify;

/* loaded from: classes.dex */
public abstract class fy implements java.lang.Runnable {
    public abstract void a() throws java.lang.Throwable;

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }
}
