package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class i6 implements java.lang.Runnable {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;
    public final /* synthetic */ android.view.View v;

    public /* synthetic */ i6(android.view.View view, int i, int i2, android.view.View view2) {
        this.n = view;
        this.t = i;
        this.u = i2;
        this.v = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.util.AdUtil.b(this.n, this.t, this.u, this.v);
    }
}
