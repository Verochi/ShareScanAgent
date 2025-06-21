package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class mt0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaExo n;
    public final /* synthetic */ int t;
    public final /* synthetic */ boolean u;

    public /* synthetic */ mt0(cn.jzvd.JZMediaExo jZMediaExo, int i, boolean z) {
        this.n = jZMediaExo;
        this.t = i;
        this.u = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.j(this.t, this.u);
    }
}
