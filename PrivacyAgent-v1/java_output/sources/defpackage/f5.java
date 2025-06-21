package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class f5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.tab.AdInterstitialSDKLoad n;
    public final /* synthetic */ android.app.Activity t;
    public final /* synthetic */ com.moji.mjad.tab.data.AdBlocking u;
    public final /* synthetic */ com.moji.mjad.tab.AdInterstitialSDKLoad.BlockingSDKAdLoadCallBack v;

    public /* synthetic */ f5(com.moji.mjad.tab.AdInterstitialSDKLoad adInterstitialSDKLoad, android.app.Activity activity, com.moji.mjad.tab.data.AdBlocking adBlocking, com.moji.mjad.tab.AdInterstitialSDKLoad.BlockingSDKAdLoadCallBack blockingSDKAdLoadCallBack) {
        this.n = adInterstitialSDKLoad;
        this.t = activity;
        this.u = adBlocking;
        this.v = blockingSDKAdLoadCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.tab.AdInterstitialSDKLoad.a(this.n, this.t, this.u, this.v);
    }
}
