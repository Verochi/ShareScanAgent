package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class dz2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.TabWeatherV9Fragment n;
    public final /* synthetic */ com.mojiweather.area.CityTipsLoc t;
    public final /* synthetic */ com.mojiweather.area.repositories.TravelCardDiamondPositionRequest.TravelCardDiamondData u;

    public /* synthetic */ dz2(com.moji.mjweather.TabWeatherV9Fragment tabWeatherV9Fragment, com.mojiweather.area.CityTipsLoc cityTipsLoc, com.mojiweather.area.repositories.TravelCardDiamondPositionRequest.TravelCardDiamondData travelCardDiamondData) {
        this.n = tabWeatherV9Fragment;
        this.t = cityTipsLoc;
        this.u = travelCardDiamondData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.TabWeatherV9Fragment.l(this.n, this.t, this.u);
    }
}
