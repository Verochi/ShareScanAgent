package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class nw1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.poimodule.POISettingAdapter n;
    public final /* synthetic */ com.moji.poimodule.model.PoiItem t;

    public /* synthetic */ nw1(com.moji.poimodule.POISettingAdapter pOISettingAdapter, com.moji.poimodule.model.PoiItem poiItem) {
        this.n = pOISettingAdapter;
        this.t = poiItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.poimodule.POISettingAdapter.a(this.n, this.t, view);
    }
}
