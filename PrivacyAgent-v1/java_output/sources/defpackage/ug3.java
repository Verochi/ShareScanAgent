package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class ug3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.dailydetails.adpater.WeatherInfoShortDelegate n;
    public final /* synthetic */ moji.com.mjweather.databinding.ItemDailyDetailWeatherShortBinding t;

    public /* synthetic */ ug3(com.moji.mjweather.dailydetails.adpater.WeatherInfoShortDelegate weatherInfoShortDelegate, moji.com.mjweather.databinding.ItemDailyDetailWeatherShortBinding itemDailyDetailWeatherShortBinding) {
        this.n = weatherInfoShortDelegate;
        this.t = itemDailyDetailWeatherShortBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.dailydetails.adpater.WeatherInfoShortDelegate.b(this.n, this.t, view);
    }
}
