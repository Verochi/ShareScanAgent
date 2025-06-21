package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class v20 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjad.disaster.DisasterBlockingControlImp n;
    public final /* synthetic */ com.moji.mjad.tab.data.AdBlocking t;
    public final /* synthetic */ com.moji.mjad.tab.BlockingViewCreater.BlockingView u;
    public final /* synthetic */ int v;

    public /* synthetic */ v20(com.moji.mjad.disaster.DisasterBlockingControlImp disasterBlockingControlImp, com.moji.mjad.tab.data.AdBlocking adBlocking, com.moji.mjad.tab.BlockingViewCreater.BlockingView blockingView, int i) {
        this.n = disasterBlockingControlImp;
        this.t = adBlocking;
        this.u = blockingView;
        this.v = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjad.disaster.DisasterBlockingControlImp.a(this.n, this.t, this.u, this.v, view);
    }
}
