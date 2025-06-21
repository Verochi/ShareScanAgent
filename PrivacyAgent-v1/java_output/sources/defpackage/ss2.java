package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ss2 implements com.moji.requestcore.ProgressListener {
    public final /* synthetic */ com.moji.mjweather.feed.subject.SubjectDetailActivity a;
    public final /* synthetic */ com.moji.share.MJThirdShareManager b;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig.Builder c;

    public /* synthetic */ ss2(com.moji.mjweather.feed.subject.SubjectDetailActivity subjectDetailActivity, com.moji.share.MJThirdShareManager mJThirdShareManager, com.moji.share.entity.ShareContentConfig.Builder builder) {
        this.a = subjectDetailActivity;
        this.b = mJThirdShareManager;
        this.c = builder;
    }

    public final void update(long j, long j2, boolean z) {
        com.moji.mjweather.feed.subject.SubjectDetailActivity.b(this.a, this.b, this.c, j, j2, z);
    }
}
