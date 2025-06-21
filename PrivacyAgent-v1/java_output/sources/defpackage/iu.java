package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class iu implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.member.entity.MemberCurrentTyphoonResult.CurrentTy n;
    public final /* synthetic */ com.moji.shorttime.ui.view.CurrentTyphoonView t;
    public final /* synthetic */ com.moji.shorttime.ui.view.CurrentTyphoonListView u;
    public final /* synthetic */ int v;

    public /* synthetic */ iu(com.moji.http.member.entity.MemberCurrentTyphoonResult.CurrentTy currentTy, com.moji.shorttime.ui.view.CurrentTyphoonView currentTyphoonView, com.moji.shorttime.ui.view.CurrentTyphoonListView currentTyphoonListView, int i) {
        this.n = currentTy;
        this.t = currentTyphoonView;
        this.u = currentTyphoonListView;
        this.v = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.view.CurrentTyphoonListView.a(this.n, this.t, this.u, this.v, view);
    }
}
