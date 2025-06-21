package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class c91 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.main.MainTabConfig n;
    public final /* synthetic */ com.moji.mjweather.main.TabViewsContainer t;

    public /* synthetic */ c91(com.moji.mjweather.main.MainTabConfig mainTabConfig, com.moji.mjweather.main.TabViewsContainer tabViewsContainer) {
        this.n = mainTabConfig;
        this.t = tabViewsContainer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.MainFragment.b(this.n, this.t);
    }
}
