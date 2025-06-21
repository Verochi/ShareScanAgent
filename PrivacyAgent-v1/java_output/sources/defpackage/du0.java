package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class du0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaSystem n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;

    public /* synthetic */ du0(cn.jzvd.JZMediaSystem jZMediaSystem, int i, int i2) {
        this.n = jZMediaSystem;
        this.t = i;
        this.u = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.q(this.t, this.u);
    }
}
