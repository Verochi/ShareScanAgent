package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class bq2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.splash.view.SplashViewCreater n;
    public final /* synthetic */ android.view.View t;

    public /* synthetic */ bq2(com.moji.mjad.splash.view.SplashViewCreater splashViewCreater, android.view.View view) {
        this.n = splashViewCreater;
        this.t = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.view.SplashViewCreater.d(this.n, this.t);
    }
}
