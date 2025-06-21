package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class xs2 implements com.moji.dialog.publish.OnPublishListener {
    public final /* synthetic */ long a;
    public final /* synthetic */ com.moji.mjweather.feed.subject.SubjectDetailActivity b;
    public final /* synthetic */ java.lang.String c;

    public /* synthetic */ xs2(long j, com.moji.mjweather.feed.subject.SubjectDetailActivity subjectDetailActivity, java.lang.String str) {
        this.a = j;
        this.b = subjectDetailActivity;
        this.c = str;
    }

    public final void onAgree() {
        com.moji.mjweather.feed.subject.SubjectDetailActivity.e(this.a, this.b, this.c);
    }
}
