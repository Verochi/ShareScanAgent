package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class yv2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.tabmember.TabMemberFragment n;
    public final /* synthetic */ com.moji.preferences.DefaultPrefer t;

    public /* synthetic */ yv2(com.moji.mjweather.tabmember.TabMemberFragment tabMemberFragment, com.moji.preferences.DefaultPrefer defaultPrefer) {
        this.n = tabMemberFragment;
        this.t = defaultPrefer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.tabmember.TabMemberFragment.f(this.n, this.t, view);
    }
}
