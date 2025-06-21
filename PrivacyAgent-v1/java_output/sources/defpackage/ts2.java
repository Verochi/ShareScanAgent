package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ts2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.share.MJThirdShareManager n;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig.Builder t;

    public /* synthetic */ ts2(com.moji.share.MJThirdShareManager mJThirdShareManager, com.moji.share.entity.ShareContentConfig.Builder builder) {
        this.n = mJThirdShareManager;
        this.t = builder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.subject.SubjectDetailActivity.f(this.n, this.t);
    }
}
