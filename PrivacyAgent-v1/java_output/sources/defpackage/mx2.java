package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class mx2 implements com.moji.mjweather.tabme.IUpdateTabView {
    public final /* synthetic */ com.moji.mjweather.tabme.TabPagerAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.moji.mjweather.tabme.IUpdateTabView c;

    public /* synthetic */ mx2(com.moji.mjweather.tabme.TabPagerAdapter tabPagerAdapter, int i, com.moji.mjweather.tabme.IUpdateTabView iUpdateTabView) {
        this.a = tabPagerAdapter;
        this.b = i;
        this.c = iUpdateTabView;
    }

    public final void updateCurrentItems(java.util.List list) {
        com.moji.mjweather.tabme.TabPagerAdapter.a(this.a, this.b, this.c, list);
    }
}
