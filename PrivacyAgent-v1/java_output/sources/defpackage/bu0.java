package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class bu0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaSystem n;
    public final /* synthetic */ float t;
    public final /* synthetic */ float u;

    public /* synthetic */ bu0(cn.jzvd.JZMediaSystem jZMediaSystem, float f, float f2) {
        this.n = jZMediaSystem;
        this.t = f;
        this.u = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.y(this.t, this.u);
    }
}
