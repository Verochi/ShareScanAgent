package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class i implements java.lang.Runnable {
    public final /* synthetic */ com.moji.aqi.AQIActivity n;
    public final /* synthetic */ com.moji.http.weather.entity.AqiDetailEntity t;

    public /* synthetic */ i(com.moji.aqi.AQIActivity aQIActivity, com.moji.http.weather.entity.AqiDetailEntity aqiDetailEntity) {
        this.n = aQIActivity;
        this.t = aqiDetailEntity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.aqi.AQIActivity.h(this.n, this.t);
    }
}
