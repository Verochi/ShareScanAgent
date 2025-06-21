package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class lq2 implements kotlin.jvm.functions.Function1 {
    public final /* synthetic */ com.moji.mjad.splash.view.SplashViewCreater n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.mjad.splash.data.AdSplashThird u;
    public final /* synthetic */ android.view.View v;

    public /* synthetic */ lq2(com.moji.mjad.splash.view.SplashViewCreater splashViewCreater, int i, com.moji.mjad.splash.data.AdSplashThird adSplashThird, android.view.View view) {
        this.n = splashViewCreater;
        this.t = i;
        this.u = adSplashThird;
        this.v = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public final java.lang.Object invoke(java.lang.Object obj) {
        return com.moji.mjad.splash.view.SplashViewCreater.m(this.n, this.t, this.u, this.v, (android.graphics.Rect) obj);
    }
}
