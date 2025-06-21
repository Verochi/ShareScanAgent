package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class um implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjchargingscreen.activity.ChargingScreenActivity n;

    public /* synthetic */ um(com.moji.mjchargingscreen.activity.ChargingScreenActivity chargingScreenActivity) {
        this.n = chargingScreenActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjchargingscreen.activity.ChargingScreenActivity.n(this.n, (java.lang.Boolean) obj);
    }
}
