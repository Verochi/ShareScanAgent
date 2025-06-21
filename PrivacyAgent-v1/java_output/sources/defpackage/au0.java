package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class au0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaSystem n;
    public final /* synthetic */ int t;

    public /* synthetic */ au0(cn.jzvd.JZMediaSystem jZMediaSystem, int i) {
        this.n = jZMediaSystem;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.n(this.t);
    }
}
