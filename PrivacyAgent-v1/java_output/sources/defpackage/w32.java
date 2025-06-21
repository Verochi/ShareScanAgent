package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class w32 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.poi.PoiPictureActivity n;

    public /* synthetic */ w32(com.moji.newliveview.poi.PoiPictureActivity poiPictureActivity) {
        this.n = poiPictureActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.poi.PoiPictureActivity.c(this.n, (com.moji.http.snsforum.entity.WaterFallPictureResult) obj);
    }
}
