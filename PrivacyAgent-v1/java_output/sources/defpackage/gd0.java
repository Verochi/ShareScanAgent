package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class gd0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjquestionnaire.ui.FirstLevelQuestionAdapter n;
    public final /* synthetic */ com.moji.mjquestionnaire.data.Question.QuestionOption t;

    public /* synthetic */ gd0(com.moji.mjquestionnaire.ui.FirstLevelQuestionAdapter firstLevelQuestionAdapter, com.moji.mjquestionnaire.data.Question.QuestionOption questionOption) {
        this.n = firstLevelQuestionAdapter;
        this.t = questionOption;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjquestionnaire.ui.FirstLevelQuestionAdapter.FirstLevelQuestionViewHolder.a(this.n, this.t, view);
    }
}
