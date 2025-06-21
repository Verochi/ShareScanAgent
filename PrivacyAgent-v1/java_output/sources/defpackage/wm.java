package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class wm implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjchargingscreen.activity.ChargingScreenActivity n;

    public /* synthetic */ wm(com.moji.mjchargingscreen.activity.ChargingScreenActivity chargingScreenActivity) {
        this.n = chargingScreenActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjchargingscreen.activity.ChargingScreenActivity.l(this.n, (com.moji.http.snsforum.entity.WaterFallPictureResult) obj);
    }
}
