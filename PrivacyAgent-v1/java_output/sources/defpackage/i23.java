package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class i23 implements com.moji.base.curve.Day15Hour24HorizontalScrollView.OnScrollListener {
    public final /* synthetic */ com.moji.mjweather.dailydetail.view.TideCurveView n;
    public final /* synthetic */ com.moji.mjweather.dailydetail.view.TideFloatView t;

    public /* synthetic */ i23(com.moji.mjweather.dailydetail.view.TideCurveView tideCurveView, com.moji.mjweather.dailydetail.view.TideFloatView tideFloatView) {
        this.n = tideCurveView;
        this.t = tideFloatView;
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, byte b) {
        com.moji.mjweather.dailydetail.TideDetailActivity.b(this.n, this.t, i, i2, i3, i4, b);
    }
}
