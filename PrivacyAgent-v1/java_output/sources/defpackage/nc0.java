package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class nc0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.feedback.FeedbackMapFunction n;

    public /* synthetic */ nc0(com.moji.shorttime.ui.function.feedback.FeedbackMapFunction feedbackMapFunction) {
        this.n = feedbackMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.feedback.FeedbackMapFunction.j(this.n, (java.util.HashMap) obj);
    }
}
