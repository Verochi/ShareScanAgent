package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class lt0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaExo n;
    public final /* synthetic */ int t;
    public final /* synthetic */ float u;
    public final /* synthetic */ int v;

    public /* synthetic */ lt0(cn.jzvd.JZMediaExo jZMediaExo, int i, float f, int i2) {
        this.n = jZMediaExo;
        this.t = i;
        this.u = f;
        this.v = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.l(this.t, this.u, this.v);
    }
}
