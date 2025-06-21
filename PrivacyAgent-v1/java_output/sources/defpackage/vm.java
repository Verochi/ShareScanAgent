package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class vm implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjchargingscreen.activity.ChargingScreenActivity n;

    public /* synthetic */ vm(com.moji.mjchargingscreen.activity.ChargingScreenActivity chargingScreenActivity) {
        this.n = chargingScreenActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjchargingscreen.activity.ChargingScreenActivity.j(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
