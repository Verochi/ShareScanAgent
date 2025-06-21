package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class q5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.launchserver.AdCommonInterface.AdResponse n;
    public final /* synthetic */ com.moji.mjad.preferences.MojiAdPreference t;

    public /* synthetic */ q5(com.moji.launchserver.AdCommonInterface.AdResponse adResponse, com.moji.mjad.preferences.MojiAdPreference mojiAdPreference) {
        this.n = adResponse;
        this.t = mojiAdPreference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.network.AdSplashRequestCallback.b(this.n, this.t);
    }
}
