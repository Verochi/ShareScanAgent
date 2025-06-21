package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class c implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.aqi.AQIActivity n;

    public /* synthetic */ c(com.moji.aqi.AQIActivity aQIActivity) {
        this.n = aQIActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.aqi.AQIActivity.f(this.n, (com.moji.common.area.AreaInfo) obj);
    }
}
