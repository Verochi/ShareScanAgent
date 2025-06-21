package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class be2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.share.view.newview.SecondFunctionAdapter n;
    public final /* synthetic */ com.moji.share.entity.second_function.SecondFunctionItem t;

    public /* synthetic */ be2(com.moji.share.view.newview.SecondFunctionAdapter secondFunctionAdapter, com.moji.share.entity.second_function.SecondFunctionItem secondFunctionItem) {
        this.n = secondFunctionAdapter;
        this.t = secondFunctionItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.share.view.newview.SecondFunctionAdapter.FunctionItemViewHolder.a(this.n, this.t, view);
    }
}
