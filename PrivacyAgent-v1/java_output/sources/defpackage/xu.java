package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class xu implements android.view.View.OnClickListener {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.moji.mjweather.dailydetails.DailyTimeIndicator t;
    public final /* synthetic */ com.moji.weatherprovider.data.ForecastDayList.ForecastDay u;

    public /* synthetic */ xu(int i, com.moji.mjweather.dailydetails.DailyTimeIndicator dailyTimeIndicator, com.moji.weatherprovider.data.ForecastDayList.ForecastDay forecastDay) {
        this.n = i;
        this.t = dailyTimeIndicator;
        this.u = forecastDay;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.dailydetails.DailyTimeIndicator.DailyTimeAdapter.a(this.n, this.t, this.u, view);
    }
}
