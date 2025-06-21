package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class jt0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaExo n;
    public final /* synthetic */ android.content.Context t;

    public /* synthetic */ jt0(cn.jzvd.JZMediaExo jZMediaExo, android.content.Context context) {
        this.n = jZMediaExo;
        this.t = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.m(this.t);
    }
}
