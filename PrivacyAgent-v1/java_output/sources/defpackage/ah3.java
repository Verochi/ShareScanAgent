package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ah3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.nearlive.WeatherNearLivePresenter n;

    public /* synthetic */ ah3(com.moji.mjweather.nearlive.WeatherNearLivePresenter weatherNearLivePresenter) {
        this.n = weatherNearLivePresenter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.nearlive.WeatherNearLivePresenter.a(this.n, (com.moji.mjweather.nearlive.NearLiveData) obj);
    }
}
