package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class fs implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.condition.view.ConditionFeedbackCallback n;

    public /* synthetic */ fs(com.moji.condition.view.ConditionFeedbackCallback conditionFeedbackCallback) {
        this.n = conditionFeedbackCallback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.condition.view.ConditionFeedbackCallback.b(this.n, view);
    }
}
