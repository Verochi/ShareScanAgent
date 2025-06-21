package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class h6 implements java.lang.Runnable {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ int t;
    public final /* synthetic */ android.view.View u;

    public /* synthetic */ h6(android.view.View view, int i, android.view.View view2) {
        this.n = view;
        this.t = i;
        this.u = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.util.AdUtil.a(this.n, this.t, this.u);
    }
}
