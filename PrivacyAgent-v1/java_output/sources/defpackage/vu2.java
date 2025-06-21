package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class vu2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.tabme.TabMeFragment n;

    public /* synthetic */ vu2(com.moji.mjweather.tabme.TabMeFragment tabMeFragment) {
        this.n = tabMeFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.tabme.TabMeFragment.m(this.n, (com.moji.mjweather.tabme.model.MeCityModel) obj);
    }
}
