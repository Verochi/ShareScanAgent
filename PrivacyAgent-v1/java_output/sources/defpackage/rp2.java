package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class rp2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjad.splash.activity.SplashVideoActivity n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;
    public final /* synthetic */ java.lang.String v;

    public /* synthetic */ rp2(com.moji.mjad.splash.activity.SplashVideoActivity splashVideoActivity, int i, int i2, java.lang.String str) {
        this.n = splashVideoActivity;
        this.t = i;
        this.u = i2;
        this.v = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjad.splash.activity.SplashVideoActivity.d(this.n, this.t, this.u, this.v, view);
    }
}
