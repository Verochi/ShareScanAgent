package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class fa1 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.mjweather.main.TabViewsContainer n;
    public final /* synthetic */ com.moji.mjweather.main.MainTabConfig t;

    public /* synthetic */ fa1(com.moji.mjweather.main.TabViewsContainer tabViewsContainer, com.moji.mjweather.main.MainTabConfig mainTabConfig) {
        this.n = tabViewsContainer;
        this.t = mainTabConfig;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjweather.main.MainTabConfig.c(this.n, this.t, (com.moji.mjweather.main.TabViewsContainer.TabServerStyle) obj);
    }
}
