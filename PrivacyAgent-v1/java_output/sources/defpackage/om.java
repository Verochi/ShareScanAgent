package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class om implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjchargingscreen.activity.ChargingGuideActivity n;

    public /* synthetic */ om(com.moji.mjchargingscreen.activity.ChargingGuideActivity chargingGuideActivity) {
        this.n = chargingGuideActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjchargingscreen.activity.ChargingGuideActivity.j(this.n, (java.lang.Boolean) obj);
    }
}
