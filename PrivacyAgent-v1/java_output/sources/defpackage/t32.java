package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class t32 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.poimodule.PoiMapActivity n;

    public /* synthetic */ t32(com.moji.poimodule.PoiMapActivity poiMapActivity) {
        this.n = poiMapActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.poimodule.PoiMapActivity.b(this.n, (java.util.List) obj);
    }
}
