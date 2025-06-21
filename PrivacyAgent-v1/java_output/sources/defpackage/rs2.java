package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class rs2 implements com.moji.share.MJThirdShareManager.OnCancelBtnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.subject.SubjectDetailActivity n;
    public final /* synthetic */ com.moji.http.fdsapi.entity.FeedSubjectDetail t;

    public /* synthetic */ rs2(com.moji.mjweather.feed.subject.SubjectDetailActivity subjectDetailActivity, com.moji.http.fdsapi.entity.FeedSubjectDetail feedSubjectDetail) {
        this.n = subjectDetailActivity;
        this.t = feedSubjectDetail;
    }

    public final void onShareCancelBtnClicked() {
        com.moji.mjweather.feed.subject.SubjectDetailActivity.j(this.n, this.t);
    }
}
