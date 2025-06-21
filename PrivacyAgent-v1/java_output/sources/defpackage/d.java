package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class d implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.aqi.AQIActivity n;

    public /* synthetic */ d(com.moji.aqi.AQIActivity aQIActivity) {
        this.n = aQIActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.aqi.AQIActivity.d(this.n, (com.moji.http.weather.entity.AqiDetailEntity) obj);
    }
}
