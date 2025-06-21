package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class s20 implements android.content.DialogInterface.OnKeyListener {
    public final /* synthetic */ com.moji.mjad.disaster.DisasterBlockingControlImp n;
    public final /* synthetic */ com.moji.mjad.tab.data.AdBlocking t;
    public final /* synthetic */ com.moji.mjad.tab.BlockingViewCreater.BlockingView u;
    public final /* synthetic */ int v;

    public /* synthetic */ s20(com.moji.mjad.disaster.DisasterBlockingControlImp disasterBlockingControlImp, com.moji.mjad.tab.data.AdBlocking adBlocking, com.moji.mjad.tab.BlockingViewCreater.BlockingView blockingView, int i) {
        this.n = disasterBlockingControlImp;
        this.t = adBlocking;
        this.u = blockingView;
        this.v = i;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
        return com.moji.mjad.disaster.DisasterBlockingControlImp.g(this.n, this.t, this.u, this.v, dialogInterface, i, keyEvent);
    }
}
