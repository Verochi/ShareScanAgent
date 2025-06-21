package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class bt2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.subject.SubjectDetailActivity n;

    public /* synthetic */ bt2(com.moji.mjweather.feed.subject.SubjectDetailActivity subjectDetailActivity) {
        this.n = subjectDetailActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.subject.SubjectDetailActivity.g(this.n, (java.lang.Boolean) obj);
    }
}
