package defpackage;

/* loaded from: classes20.dex */
public final /* synthetic */ class u62 implements android.view.View.OnClickListener {
    public final /* synthetic */ moji.com.mjwallet.qa.QaListAdapter n;
    public final /* synthetic */ int t;

    public /* synthetic */ u62(moji.com.mjwallet.qa.QaListAdapter qaListAdapter, int i) {
        this.n = qaListAdapter;
        this.t = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        moji.com.mjwallet.qa.QaListAdapter.b(this.n, this.t, view);
    }
}
