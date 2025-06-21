package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class vx2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.TabWeatherBetaFragment n;
    public final /* synthetic */ com.mojiweather.area.CityTipsLoc t;
    public final /* synthetic */ com.mojiweather.area.repositories.TravelCardDiamondPositionRequest.TravelCardDiamondData u;

    public /* synthetic */ vx2(com.moji.mjweather.TabWeatherBetaFragment tabWeatherBetaFragment, com.mojiweather.area.CityTipsLoc cityTipsLoc, com.mojiweather.area.repositories.TravelCardDiamondPositionRequest.TravelCardDiamondData travelCardDiamondData) {
        this.n = tabWeatherBetaFragment;
        this.t = cityTipsLoc;
        this.u = travelCardDiamondData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.TabWeatherBetaFragment.n(this.n, this.t, this.u);
    }
}
