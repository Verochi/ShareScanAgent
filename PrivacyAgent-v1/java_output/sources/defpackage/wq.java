package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class wq implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.detail.CommentManager n;

    public /* synthetic */ wq(com.moji.newliveview.detail.CommentManager commentManager) {
        this.n = commentManager;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.detail.CommentManager.b(this.n, (com.moji.newliveview.detail.data.AddPictureCommentData) obj);
    }
}
