package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class rq2 implements com.moji.mjad.splash.SensorManagerHelper.OnShakeListener {
    public final /* synthetic */ com.moji.mjad.splash.view.SplashViewCreater a;
    public final /* synthetic */ com.moji.mjad.splash.data.AdSplashThird b;
    public final /* synthetic */ int[] c;
    public final /* synthetic */ android.view.View d;

    public /* synthetic */ rq2(com.moji.mjad.splash.view.SplashViewCreater splashViewCreater, com.moji.mjad.splash.data.AdSplashThird adSplashThird, int[] iArr, android.view.View view) {
        this.a = splashViewCreater;
        this.b = adSplashThird;
        this.c = iArr;
        this.d = view;
    }

    public final void onShake() {
        com.moji.mjad.splash.view.SplashViewCreater.n(this.a, this.b, this.c, this.d);
    }
}
