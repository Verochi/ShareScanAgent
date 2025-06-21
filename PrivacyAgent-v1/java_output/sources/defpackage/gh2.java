package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class gh2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.ShortTimeFragmentV2 n;
    public final /* synthetic */ com.amap.api.maps.model.LatLng t;
    public final /* synthetic */ com.moji.shorttime.ui.ShortTimeUiState u;
    public final /* synthetic */ com.moji.shorttime.ui.RadarType v;

    public /* synthetic */ gh2(com.moji.shorttime.ui.ShortTimeFragmentV2 shortTimeFragmentV2, com.amap.api.maps.model.LatLng latLng, com.moji.shorttime.ui.ShortTimeUiState shortTimeUiState, com.moji.shorttime.ui.RadarType radarType) {
        this.n = shortTimeFragmentV2;
        this.t = latLng;
        this.u = shortTimeUiState;
        this.v = radarType;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.ShortTimeFragmentV2.c(this.n, this.t, this.u, this.v);
    }
}
