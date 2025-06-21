package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class jn implements android.widget.CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ com.moji.mjchargingscreen.activity.ChargingSettingsActivity n;

    public /* synthetic */ jn(com.moji.mjchargingscreen.activity.ChargingSettingsActivity chargingSettingsActivity) {
        this.n = chargingSettingsActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        com.moji.mjchargingscreen.activity.ChargingSettingsActivity.j(this.n, compoundButton, z);
    }
}
