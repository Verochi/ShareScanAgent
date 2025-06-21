package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class uu2 implements com.moji.mjweather.tabme.IUpdateTabView {
    public final /* synthetic */ com.moji.mjweather.tabme.TabMeFragment a;
    public final /* synthetic */ com.moji.mjweather.tabme.model.MeTabDetailModel b;

    public /* synthetic */ uu2(com.moji.mjweather.tabme.TabMeFragment tabMeFragment, com.moji.mjweather.tabme.model.MeTabDetailModel meTabDetailModel) {
        this.a = tabMeFragment;
        this.b = meTabDetailModel;
    }

    public final void updateCurrentItems(java.util.List list) {
        com.moji.mjweather.tabme.TabMeFragment.j(this.a, this.b, list);
    }
}
