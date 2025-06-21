package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class tm implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjchargingscreen.activity.ChargingScreenActivity n;

    public /* synthetic */ tm(com.moji.mjchargingscreen.activity.ChargingScreenActivity chargingScreenActivity) {
        this.n = chargingScreenActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjchargingscreen.activity.ChargingScreenActivity.k(this.n, (java.lang.Float) obj);
    }
}
