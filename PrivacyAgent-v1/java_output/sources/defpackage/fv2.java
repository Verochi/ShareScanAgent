package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class fv2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.tabme.TabMeFragment n;

    public /* synthetic */ fv2(com.moji.mjweather.tabme.TabMeFragment tabMeFragment) {
        this.n = tabMeFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.tabme.TabMeFragment.i(this.n, (com.moji.account.data.UserInfo.Status) obj);
    }
}
