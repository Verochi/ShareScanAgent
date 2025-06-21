package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class kq2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjad.splash.view.SplashViewCreater n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;
    public final /* synthetic */ java.lang.String v;

    public /* synthetic */ kq2(com.moji.mjad.splash.view.SplashViewCreater splashViewCreater, int i, int i2, java.lang.String str) {
        this.n = splashViewCreater;
        this.t = i;
        this.u = i2;
        this.v = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjad.splash.view.SplashViewCreater.j(this.n, this.t, this.u, this.v, view);
    }
}
