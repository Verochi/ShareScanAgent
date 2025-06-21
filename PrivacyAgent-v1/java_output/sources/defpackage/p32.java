package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class p32 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.poimodule.PoiMapActivity a;
    public final /* synthetic */ com.moji.location.geo.MJReGeoPoiItem b;

    public /* synthetic */ p32(com.moji.poimodule.PoiMapActivity poiMapActivity, com.moji.location.geo.MJReGeoPoiItem mJReGeoPoiItem) {
        this.a = poiMapActivity;
        this.b = mJReGeoPoiItem;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.poimodule.PoiMapActivity.g(this.a, this.b, mJDialog, eTypeAction);
    }
}
