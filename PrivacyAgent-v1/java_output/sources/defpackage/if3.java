package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class if3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.weather.beta.condition.WeatherConditionS5View n;

    public /* synthetic */ if3(com.moji.mjweather.weather.beta.condition.WeatherConditionS5View weatherConditionS5View) {
        this.n = weatherConditionS5View;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.beta.condition.WeatherConditionS5View.a(this.n, obj);
    }
}
