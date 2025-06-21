package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class f00 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newliveview.detail.adapter.DetailCommentPresenter n;
    public final /* synthetic */ com.moji.newliveview.detail.adapter.DetailCommentPresenter.CommentTitleHolder t;

    public /* synthetic */ f00(com.moji.newliveview.detail.adapter.DetailCommentPresenter detailCommentPresenter, com.moji.newliveview.detail.adapter.DetailCommentPresenter.CommentTitleHolder commentTitleHolder) {
        this.n = detailCommentPresenter;
        this.t = commentTitleHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newliveview.detail.adapter.DetailCommentPresenter.CommentTitleHolder.b(this.n, this.t, view);
    }
}
