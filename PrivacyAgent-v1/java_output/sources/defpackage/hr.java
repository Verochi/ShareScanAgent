package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class hr implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.mjweather.ipc.view.liveviewcomment.CommentView n;

    public /* synthetic */ hr(com.moji.mjweather.ipc.view.liveviewcomment.CommentView commentView) {
        this.n = commentView;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.mjweather.ipc.view.liveviewcomment.CommentView.c(this.n, dialogInterface);
    }
}
