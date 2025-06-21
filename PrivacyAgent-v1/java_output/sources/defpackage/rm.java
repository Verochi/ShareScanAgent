package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class rm implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.snsforum.entity.WaterFallPicture n;
    public final /* synthetic */ com.moji.mjchargingscreen.adapter.ChargingNewLiveAdapter t;

    public /* synthetic */ rm(com.moji.http.snsforum.entity.WaterFallPicture waterFallPicture, com.moji.mjchargingscreen.adapter.ChargingNewLiveAdapter chargingNewLiveAdapter) {
        this.n = waterFallPicture;
        this.t = chargingNewLiveAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjchargingscreen.adapter.ChargingNewLiveAdapter.ChargingNewLiveHolder.a(this.n, this.t, view);
    }
}
