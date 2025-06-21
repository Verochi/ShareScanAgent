package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class cc implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.article.detail.ArticleDetailPictureItemPresenter.ArticleDetailPictureItemViewHolder n;
    public final /* synthetic */ com.moji.article.detail.ArticleDetailPictureItemPresenter t;

    public /* synthetic */ cc(com.moji.article.detail.ArticleDetailPictureItemPresenter.ArticleDetailPictureItemViewHolder articleDetailPictureItemViewHolder, com.moji.article.detail.ArticleDetailPictureItemPresenter articleDetailPictureItemPresenter) {
        this.n = articleDetailPictureItemViewHolder;
        this.t = articleDetailPictureItemPresenter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.article.detail.ArticleDetailPictureItemPresenter.ArticleDetailPictureItemViewHolder.a(this.n, this.t, view);
    }
}
