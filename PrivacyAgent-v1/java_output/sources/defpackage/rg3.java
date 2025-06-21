package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class rg3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.dailydetails.adpater.WeatherInfoDelegate n;
    public final /* synthetic */ moji.com.mjweather.databinding.ItemDailyDetailWeatherBinding t;

    public /* synthetic */ rg3(com.moji.mjweather.dailydetails.adpater.WeatherInfoDelegate weatherInfoDelegate, moji.com.mjweather.databinding.ItemDailyDetailWeatherBinding itemDailyDetailWeatherBinding) {
        this.n = weatherInfoDelegate;
        this.t = itemDailyDetailWeatherBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.dailydetails.adpater.WeatherInfoDelegate.a(this.n, this.t, view);
    }
}
