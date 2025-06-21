package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class tw implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mj180dayforecast.Days180MainActivity n;

    public /* synthetic */ tw(com.moji.mj180dayforecast.Days180MainActivity days180MainActivity) {
        this.n = days180MainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mj180dayforecast.Days180MainActivity.e(this.n, (com.moji.http.weather.entity.Weather180DaysForecastResult) obj);
    }
}
