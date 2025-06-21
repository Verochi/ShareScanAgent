package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class et2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.share.MJThirdShareManager n;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig.Builder t;

    public /* synthetic */ et2(com.moji.share.MJThirdShareManager mJThirdShareManager, com.moji.share.entity.ShareContentConfig.Builder builder) {
        this.n = mJThirdShareManager;
        this.t = builder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.subject.SubjectDetailActivity.doShare.2.a(this.n, this.t);
    }
}
