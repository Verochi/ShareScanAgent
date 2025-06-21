package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class y32 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.PoiSearchActivity n;

    public /* synthetic */ y32(com.moji.PoiSearchActivity poiSearchActivity) {
        this.n = poiSearchActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.PoiSearchActivity.c(this.n, (com.moji.location.geo.MJReGeoPoiItem) obj);
    }
}
