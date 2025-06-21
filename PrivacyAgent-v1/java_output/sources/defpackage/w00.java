package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class w00 implements com.moji.mjweather.ipc.view.liveviewcomment.CommentPraiseView.CommentPraiseClickListener {
    public final /* synthetic */ com.moji.newliveview.detail.adapter.DetailReplyPresenter n;

    public /* synthetic */ w00(com.moji.newliveview.detail.adapter.DetailReplyPresenter detailReplyPresenter) {
        this.n = detailReplyPresenter;
    }

    public final void onCommentPraiseClick(com.moji.mjweather.ipc.view.liveviewcomment.CommentPraiseView commentPraiseView, com.moji.http.snsforum.ILiveViewComment iLiveViewComment) {
        com.moji.newliveview.detail.adapter.DetailReplyPresenter.ReplyViewHolder.b(this.n, commentPraiseView, iLiveViewComment);
    }
}
