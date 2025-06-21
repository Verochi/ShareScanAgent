package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class fr implements android.view.View.OnLongClickListener {
    public final /* synthetic */ com.moji.mjweather.ipc.view.liveviewcomment.CommentView n;
    public final /* synthetic */ android.content.Context t;

    public /* synthetic */ fr(com.moji.mjweather.ipc.view.liveviewcomment.CommentView commentView, android.content.Context context) {
        this.n = commentView;
        this.t = context;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(android.view.View view) {
        return com.moji.mjweather.ipc.view.liveviewcomment.CommentView.d(this.n, this.t, view);
    }
}
