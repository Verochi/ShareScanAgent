package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dj3 implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.WeatherV10TitleBar n;

    public /* synthetic */ dj3(com.moji.mjweather.weather.view.WeatherV10TitleBar weatherV10TitleBar) {
        this.n = weatherV10TitleBar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.mjweather.weather.view.WeatherV10TitleBar.e(this.n, view, motionEvent);
    }
}
