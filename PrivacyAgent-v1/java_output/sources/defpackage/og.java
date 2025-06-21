package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class og implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ com.moji.mjweather.feed.statistic.BaseApiEventExposure n;
    public final /* synthetic */ android.view.View t;

    public /* synthetic */ og(com.moji.mjweather.feed.statistic.BaseApiEventExposure baseApiEventExposure, android.view.View view) {
        this.n = baseApiEventExposure;
        this.t = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        com.moji.mjweather.feed.statistic.BaseApiEventExposure.a(this.n, this.t);
    }
}
