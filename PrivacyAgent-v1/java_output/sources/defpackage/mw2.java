package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class mw2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.tabmember.TabMemberFragment n;
    public final /* synthetic */ com.moji.preferences.DefaultPrefer t;

    public /* synthetic */ mw2(com.moji.mjweather.tabmember.TabMemberFragment tabMemberFragment, com.moji.preferences.DefaultPrefer defaultPrefer) {
        this.n = tabMemberFragment;
        this.t = defaultPrefer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.tabmember.TabMemberFragment.i(this.n, this.t, view);
    }
}
