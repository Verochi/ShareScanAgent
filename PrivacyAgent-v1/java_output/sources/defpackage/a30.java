package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class a30 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjad.disaster.DisasterBlockingControlImp n;
    public final /* synthetic */ com.moji.mjad.tab.data.AdBlocking t;

    public /* synthetic */ a30(com.moji.mjad.disaster.DisasterBlockingControlImp disasterBlockingControlImp, com.moji.mjad.tab.data.AdBlocking adBlocking) {
        this.n = disasterBlockingControlImp;
        this.t = adBlocking;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjad.disaster.DisasterBlockingControlImp.b(this.n, this.t, view);
    }
}
