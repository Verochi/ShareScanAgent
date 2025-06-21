package cn.fly.verify;

/* loaded from: classes.dex */
public abstract class ar implements java.lang.Runnable {
    public abstract void a();

    public void a(java.lang.Throwable th) {
    }

    public void b() {
        try {
            new java.lang.Thread(this).start();
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (java.lang.Throwable th) {
            a(th);
        }
    }
}
