package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class xt0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaSystem n;
    public final /* synthetic */ long t;

    public /* synthetic */ xt0(cn.jzvd.JZMediaSystem jZMediaSystem, long j) {
        this.n = jZMediaSystem;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.x(this.t);
    }
}
