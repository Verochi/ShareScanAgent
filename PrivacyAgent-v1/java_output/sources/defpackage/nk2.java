package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class nk2 implements com.amap.api.maps.AMap.OnMapLoadedListener {
    public final /* synthetic */ com.moji.earlywarning.SingleWarningFragment n;
    public final /* synthetic */ com.moji.earlywarning.radar.ui.TilesLoadResult t;
    public final /* synthetic */ com.moji.earlywarning.view.MapViewContainer u;

    public /* synthetic */ nk2(com.moji.earlywarning.SingleWarningFragment singleWarningFragment, com.moji.earlywarning.radar.ui.TilesLoadResult tilesLoadResult, com.moji.earlywarning.view.MapViewContainer mapViewContainer) {
        this.n = singleWarningFragment;
        this.t = tilesLoadResult;
        this.u = mapViewContainer;
    }

    @Override // com.amap.api.maps.AMap.OnMapLoadedListener
    public final void onMapLoaded() {
        com.moji.earlywarning.SingleWarningFragment.n(this.n, this.t, this.u);
    }
}
