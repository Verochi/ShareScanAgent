package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class yq implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.detail.CommentManager n;

    public /* synthetic */ yq(com.moji.newliveview.detail.CommentManager commentManager) {
        this.n = commentManager;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.detail.CommentManager.a(this.n, (com.moji.http.snsforum.entity.PictureCommentListResult) obj);
    }
}
