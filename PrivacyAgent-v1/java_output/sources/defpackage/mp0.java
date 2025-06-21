package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class mp0 implements com.moji.scrollview.HorizontalScrollViewMonitor.OnScrollListener {
    public final /* synthetic */ com.moji.mjfishing.view.HourWeatherView a;

    public /* synthetic */ mp0(com.moji.mjfishing.view.HourWeatherView hourWeatherView) {
        this.a = hourWeatherView;
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        com.moji.mjfishing.view.HourWeatherView.b(this.a, i, i2, i3, i4);
    }
}
