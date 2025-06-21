package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class o11 implements java.lang.Runnable {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ kotlin.jvm.functions.Function1 t;

    public /* synthetic */ o11(android.view.View view, kotlin.jvm.functions.Function1 function1) {
        this.n = view;
        this.t = function1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.splash.view.MJAdSplashTipsLayout.i(this.n, this.t);
    }
}
