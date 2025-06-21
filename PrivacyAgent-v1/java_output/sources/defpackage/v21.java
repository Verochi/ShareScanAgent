package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class v21 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.third.toutiao.listener.MJFeedAdListener n;
    public final /* synthetic */ int t;
    public final /* synthetic */ java.lang.String u;

    public /* synthetic */ v21(com.moji.mjad.third.toutiao.listener.MJFeedAdListener mJFeedAdListener, int i, java.lang.String str) {
        this.n = mJFeedAdListener;
        this.t = i;
        this.u = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.toutiao.listener.MJFeedAdListener.b(this.n, this.t, this.u);
    }
}
