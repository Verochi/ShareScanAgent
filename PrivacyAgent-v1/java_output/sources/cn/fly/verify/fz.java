package cn.fly.verify;

/* loaded from: classes.dex */
public abstract class fz extends java.lang.Thread {
    public fz(java.lang.String str) {
        if (android.text.TextUtils.isEmpty("M-")) {
            return;
        }
        setName("M-" + str);
    }

    public abstract void a() throws java.lang.Throwable;

    public void a(java.lang.Throwable th) {
        cn.fly.verify.ed.a().a(th);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (java.lang.Throwable th) {
            a(th);
        }
    }
}
