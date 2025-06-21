package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class gr implements com.moji.mjweather.ipc.view.liveviewcomment.CommentReportDialog.OnDialogClickListener {
    public final /* synthetic */ com.moji.mjweather.ipc.view.liveviewcomment.CommentView a;
    public final /* synthetic */ android.content.Context b;
    public final /* synthetic */ com.moji.http.snsforum.ILiveViewComment c;

    public /* synthetic */ gr(com.moji.mjweather.ipc.view.liveviewcomment.CommentView commentView, android.content.Context context, com.moji.http.snsforum.ILiveViewComment iLiveViewComment) {
        this.a = commentView;
        this.b = context;
        this.c = iLiveViewComment;
    }

    public final void onSubmitClick(com.moji.mjweather.ipc.view.liveviewcomment.CommentReportDialog.ItemData itemData) {
        com.moji.mjweather.ipc.view.liveviewcomment.CommentView.b(this.a, this.b, this.c, itemData);
    }
}
