package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class zs2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.subject.SubjectDetailActivity n;

    public /* synthetic */ zs2(com.moji.mjweather.feed.subject.SubjectDetailActivity subjectDetailActivity) {
        this.n = subjectDetailActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.subject.SubjectDetailActivity.h(this.n, (com.moji.mjweather.feed.subject.viewmodel.SubjectPraiseData) obj);
    }
}
