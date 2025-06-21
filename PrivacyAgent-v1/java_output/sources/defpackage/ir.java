package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ir implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.mjweather.ipc.view.liveviewcomment.CommentView n;

    public /* synthetic */ ir(com.moji.mjweather.ipc.view.liveviewcomment.CommentView commentView) {
        this.n = commentView;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.mjweather.ipc.view.liveviewcomment.CommentView.e(this.n, dialogInterface);
    }
}
