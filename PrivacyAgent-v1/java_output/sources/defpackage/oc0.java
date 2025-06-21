package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class oc0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.FeedbackTextView n;
    public final /* synthetic */ android.content.Context t;

    public /* synthetic */ oc0(com.moji.shorttime.ui.view.FeedbackTextView feedbackTextView, android.content.Context context) {
        this.n = feedbackTextView;
        this.t = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.view.FeedbackTextView.a(this.n, this.t, view);
    }
}
