package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class i00 implements com.moji.mjweather.ipc.view.liveviewcomment.CommentPraiseView.CommentPraiseClickListener {
    public final /* synthetic */ com.moji.newliveview.detail.adapter.DetailCommentPresenter n;

    public /* synthetic */ i00(com.moji.newliveview.detail.adapter.DetailCommentPresenter detailCommentPresenter) {
        this.n = detailCommentPresenter;
    }

    public final void onCommentPraiseClick(com.moji.mjweather.ipc.view.liveviewcomment.CommentPraiseView commentPraiseView, com.moji.http.snsforum.ILiveViewComment iLiveViewComment) {
        com.moji.newliveview.detail.adapter.DetailCommentPresenter.CommentViewHolder.b(this.n, commentPraiseView, iLiveViewComment);
    }
}
