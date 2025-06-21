package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dv2 implements androidx.core.widget.NestedScrollView.OnScrollChangeListener {
    public final /* synthetic */ com.moji.mjweather.tabme.TabMeFragment a;
    public final /* synthetic */ android.view.View b;

    public /* synthetic */ dv2(com.moji.mjweather.tabme.TabMeFragment tabMeFragment, android.view.View view) {
        this.a = tabMeFragment;
        this.b = view;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public final void onScrollChange(androidx.core.widget.NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        com.moji.mjweather.tabme.TabMeFragment.p(this.a, this.b, nestedScrollView, i, i2, i3, i4);
    }
}
