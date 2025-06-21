package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class d00 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newliveview.detail.adapter.DetailCommentFooterPresenter n;
    public final /* synthetic */ com.moji.newliveview.detail.adapter.DetailCommentFooterPresenter.DetailCommentFooterViewHolder t;

    public /* synthetic */ d00(com.moji.newliveview.detail.adapter.DetailCommentFooterPresenter detailCommentFooterPresenter, com.moji.newliveview.detail.adapter.DetailCommentFooterPresenter.DetailCommentFooterViewHolder detailCommentFooterViewHolder) {
        this.n = detailCommentFooterPresenter;
        this.t = detailCommentFooterViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newliveview.detail.adapter.DetailCommentFooterPresenter.DetailCommentFooterViewHolder.c(this.n, this.t, view);
    }
}
