package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class zr0 implements android.widget.CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ com.moji.influenza.viewcontrol.InfluenzaMapView n;

    public /* synthetic */ zr0(com.moji.influenza.viewcontrol.InfluenzaMapView influenzaMapView) {
        this.n = influenzaMapView;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        com.moji.influenza.viewcontrol.InfluenzaMapView.a(this.n, compoundButton, z);
    }
}
