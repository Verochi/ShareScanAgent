package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class we3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.common.area.AreaInfo n;
    public final /* synthetic */ com.moji.card.data.OpPositionData t;

    public /* synthetic */ we3(com.moji.common.area.AreaInfo areaInfo, com.moji.card.data.OpPositionData opPositionData) {
        this.n = areaInfo;
        this.t = opPositionData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.view.WeatherAndShortView.c(this.n, this.t);
    }
}
