package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class r5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.splash.data.AdSplashs n;

    public /* synthetic */ r5(com.moji.mjad.splash.data.AdSplashs adSplashs) {
        this.n = adSplashs;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.network.AdSplashRequestCallback.c(this.n);
    }
}
