package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class pw1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.poimodule.model.PoiItem n;

    public /* synthetic */ pw1(com.moji.poimodule.model.PoiItem poiItem) {
        this.n = poiItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.poimodule.POISettingAdapter.c(this.n, view);
    }
}
