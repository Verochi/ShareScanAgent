package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class j11 implements java.lang.Runnable {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;
    public final /* synthetic */ com.moji.mjad.splash.view.MJAdSplashTipsLayout t;

    public /* synthetic */ j11(kotlin.jvm.internal.Ref.ObjectRef objectRef, com.moji.mjad.splash.view.MJAdSplashTipsLayout mJAdSplashTipsLayout) {
        this.n = objectRef;
        this.t = mJAdSplashTipsLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.view.MJAdSplashTipsLayout.c(this.n, this.t);
    }
}
