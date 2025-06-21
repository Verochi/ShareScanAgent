package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dr implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.ipc.view.liveviewcomment.CommentReportDialog n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.mjweather.ipc.view.liveviewcomment.CommentReportDialog.ItemData u;

    public /* synthetic */ dr(com.moji.mjweather.ipc.view.liveviewcomment.CommentReportDialog commentReportDialog, int i, com.moji.mjweather.ipc.view.liveviewcomment.CommentReportDialog.ItemData itemData) {
        this.n = commentReportDialog;
        this.t = i;
        this.u = itemData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.ipc.view.liveviewcomment.CommentReportDialog.ReportOptionsAdapter.ViewHolder.a(this.n, this.t, this.u, view);
    }
}
