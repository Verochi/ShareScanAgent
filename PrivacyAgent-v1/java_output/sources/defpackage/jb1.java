package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class jb1 implements com.amap.api.maps.AMap.OnMapLoadedListener {
    public final /* synthetic */ com.moji.earlywarning.view.MapViewContainer n;
    public final /* synthetic */ com.moji.common.area.AreaInfo t;
    public final /* synthetic */ androidx.fragment.app.FragmentActivity u;
    public final /* synthetic */ com.moji.earlywarning.radar.viewmodel.Rain48hRadarMapViewModel v;
    public final /* synthetic */ com.amap.api.maps.AMap.OnMapLoadedListener w;

    public /* synthetic */ jb1(com.moji.earlywarning.view.MapViewContainer mapViewContainer, com.moji.common.area.AreaInfo areaInfo, androidx.fragment.app.FragmentActivity fragmentActivity, com.moji.earlywarning.radar.viewmodel.Rain48hRadarMapViewModel rain48hRadarMapViewModel, com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) {
        this.n = mapViewContainer;
        this.t = areaInfo;
        this.u = fragmentActivity;
        this.v = rain48hRadarMapViewModel;
        this.w = onMapLoadedListener;
    }

    @Override // com.amap.api.maps.AMap.OnMapLoadedListener
    public final void onMapLoaded() {
        com.moji.earlywarning.view.MapViewContainer.c(this.n, this.t, this.u, this.v, this.w);
    }
}
