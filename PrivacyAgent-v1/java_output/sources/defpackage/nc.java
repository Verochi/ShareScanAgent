package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class nc implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.article.ui.ArticleUploadActivity n;

    public /* synthetic */ nc(com.moji.article.ui.ArticleUploadActivity articleUploadActivity) {
        this.n = articleUploadActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.article.ui.ArticleUploadActivity.d(this.n, (com.moji.http.snsforum.article.entity.ArticlePublishResult) obj);
    }
}
