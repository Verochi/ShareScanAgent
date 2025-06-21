package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class wu2 implements com.moji.tablayout.TabLayout.DrawIndicatorListener {
    public final /* synthetic */ com.moji.mjweather.tabme.TabMeFragment a;
    public final /* synthetic */ int b;

    public /* synthetic */ wu2(com.moji.mjweather.tabme.TabMeFragment tabMeFragment, int i) {
        this.a = tabMeFragment;
        this.b = i;
    }

    public final void drawIndicator(android.graphics.Canvas canvas, int i, int i2, int i3, int i4, int i5, android.graphics.Paint paint) {
        com.moji.mjweather.tabme.TabMeFragment.r(this.a, this.b, canvas, i, i2, i3, i4, i5, paint);
    }
}
