package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class o91 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.splash.view.DrawerImageView n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;

    public /* synthetic */ o91(com.moji.mjad.splash.view.DrawerImageView drawerImageView, int i, int i2) {
        this.n = drawerImageView;
        this.t = i;
        this.u = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.MainFragment.h(this.n, this.t, this.u);
    }
}
