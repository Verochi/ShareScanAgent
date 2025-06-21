package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class vq implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.detail.CommentManager n;

    public /* synthetic */ vq(com.moji.newliveview.detail.CommentManager commentManager) {
        this.n = commentManager;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.detail.CommentManager.c(this.n, (com.moji.newliveview.detail.data.DeleteCommentData) obj);
    }
}
