package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class lw1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.poimodule.POIListAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.location.geo.MJReGeoPoiItem u;

    public /* synthetic */ lw1(com.moji.poimodule.POIListAdapter pOIListAdapter, int i, com.moji.location.geo.MJReGeoPoiItem mJReGeoPoiItem) {
        this.n = pOIListAdapter;
        this.t = i;
        this.u = mJReGeoPoiItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.poimodule.POIListAdapter.a(this.n, this.t, this.u, view);
    }
}
