package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class u21 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.third.toutiao.listener.MJFeedAdListener n;
    public final /* synthetic */ java.util.List t;

    public /* synthetic */ u21(com.moji.mjad.third.toutiao.listener.MJFeedAdListener mJFeedAdListener, java.util.List list) {
        this.n = mJFeedAdListener;
        this.t = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.toutiao.listener.MJFeedAdListener.a(this.n, this.t);
    }
}
