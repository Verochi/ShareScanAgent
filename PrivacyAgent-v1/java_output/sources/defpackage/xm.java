package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class xm implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjchargingscreen.activity.ChargingScreenActivity n;

    public /* synthetic */ xm(com.moji.mjchargingscreen.activity.ChargingScreenActivity chargingScreenActivity) {
        this.n = chargingScreenActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjchargingscreen.activity.ChargingScreenActivity.m(this.n, (com.moji.http.weather.entity.AqiDetailEntity) obj);
    }
}
