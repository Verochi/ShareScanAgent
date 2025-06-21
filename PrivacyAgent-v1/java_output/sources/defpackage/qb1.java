package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class qb1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.map.MapleLeavesMarkerAdapter n;
    public final /* synthetic */ com.amap.api.maps.model.Marker t;

    public /* synthetic */ qb1(com.moji.shorttime.ui.map.MapleLeavesMarkerAdapter mapleLeavesMarkerAdapter, com.amap.api.maps.model.Marker marker) {
        this.n = mapleLeavesMarkerAdapter;
        this.t = marker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.map.MapleLeavesMarkerAdapter.c(this.n, this.t, view);
    }
}
