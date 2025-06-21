package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class x20 implements android.content.DialogInterface.OnKeyListener {
    public final /* synthetic */ com.moji.mjad.disaster.DisasterBlockingControlImp n;
    public final /* synthetic */ com.moji.mjad.tab.data.AdBlocking t;

    public /* synthetic */ x20(com.moji.mjad.disaster.DisasterBlockingControlImp disasterBlockingControlImp, com.moji.mjad.tab.data.AdBlocking adBlocking) {
        this.n = disasterBlockingControlImp;
        this.t = adBlocking;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
        return com.moji.mjad.disaster.DisasterBlockingControlImp.h(this.n, this.t, dialogInterface, i, keyEvent);
    }
}
