package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class i21 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.third.toutiao.listener.MJDrawFeedAdListener n;
    public final /* synthetic */ java.util.List t;

    public /* synthetic */ i21(com.moji.mjad.third.toutiao.listener.MJDrawFeedAdListener mJDrawFeedAdListener, java.util.List list) {
        this.n = mJDrawFeedAdListener;
        this.t = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.toutiao.listener.MJDrawFeedAdListener.a(this.n, this.t);
    }
}
