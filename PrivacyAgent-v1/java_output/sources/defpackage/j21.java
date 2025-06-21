package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class j21 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.third.toutiao.listener.MJDrawFeedAdListener n;
    public final /* synthetic */ int t;
    public final /* synthetic */ java.lang.String u;

    public /* synthetic */ j21(com.moji.mjad.third.toutiao.listener.MJDrawFeedAdListener mJDrawFeedAdListener, int i, java.lang.String str) {
        this.n = mJDrawFeedAdListener;
        this.t = i;
        this.u = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.toutiao.listener.MJDrawFeedAdListener.b(this.n, this.t, this.u);
    }
}
