package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class yg3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.weathertab.WeatherLiveViewPresenter n;

    public /* synthetic */ yg3(com.moji.newliveview.weathertab.WeatherLiveViewPresenter weatherLiveViewPresenter) {
        this.n = weatherLiveViewPresenter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.weathertab.WeatherLiveViewPresenter.a(this.n, (com.moji.http.snsforum.entity.WeatherLiveView) obj);
    }
}
