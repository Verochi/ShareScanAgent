package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class ce2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjquestionnaire.ui.SecondLevelQuestionAdapter n;
    public final /* synthetic */ com.moji.mjquestionnaire.data.Question.QuestionOption t;

    public /* synthetic */ ce2(com.moji.mjquestionnaire.ui.SecondLevelQuestionAdapter secondLevelQuestionAdapter, com.moji.mjquestionnaire.data.Question.QuestionOption questionOption) {
        this.n = secondLevelQuestionAdapter;
        this.t = questionOption;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjquestionnaire.ui.SecondLevelQuestionAdapter.SecondLevelQuestionViewHolder.a(this.n, this.t, view);
    }
}
