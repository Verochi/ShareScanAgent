package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class h23 implements android.view.ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ com.moji.base.curve.Day15Hour24HorizontalScrollView n;
    public final /* synthetic */ com.moji.mjweather.dailydetail.view.TideFloatView t;

    public /* synthetic */ h23(com.moji.base.curve.Day15Hour24HorizontalScrollView day15Hour24HorizontalScrollView, com.moji.mjweather.dailydetail.view.TideFloatView tideFloatView) {
        this.n = day15Hour24HorizontalScrollView;
        this.t = tideFloatView;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        com.moji.mjweather.dailydetail.TideDetailActivity.g(this.n, this.t);
    }
}
