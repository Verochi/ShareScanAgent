package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class us2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.subject.SubjectDetailActivity n;
    public final /* synthetic */ int t;

    public /* synthetic */ us2(com.moji.mjweather.feed.subject.SubjectDetailActivity subjectDetailActivity, int i) {
        this.n = subjectDetailActivity;
        this.t = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.feed.subject.SubjectDetailActivity.l(this.n, this.t, view);
    }
}
