package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class vs2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.subject.adapter.SubjectAdapter n;

    public /* synthetic */ vs2(com.moji.mjweather.feed.subject.adapter.SubjectAdapter subjectAdapter) {
        this.n = subjectAdapter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        this.n.replaceData((java.util.List) obj);
    }
}
