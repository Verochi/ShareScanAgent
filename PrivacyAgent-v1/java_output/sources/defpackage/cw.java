package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class cw implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.weather.beta.day2.Day2S5Adapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.mjweather.weather.beta.day2.Day2ForecastItemDataS5 u;

    public /* synthetic */ cw(com.moji.mjweather.weather.beta.day2.Day2S5Adapter day2S5Adapter, int i, com.moji.mjweather.weather.beta.day2.Day2ForecastItemDataS5 day2ForecastItemDataS5) {
        this.n = day2S5Adapter;
        this.t = i;
        this.u = day2ForecastItemDataS5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.weather.beta.day2.Day2S5Adapter.ViewHolder.a(this.n, this.t, this.u, view);
    }
}
