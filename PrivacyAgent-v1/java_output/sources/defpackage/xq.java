package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class xq implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.detail.CommentManager n;

    public /* synthetic */ xq(com.moji.newliveview.detail.CommentManager commentManager) {
        this.n = commentManager;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.detail.CommentManager.d(this.n, (com.moji.http.snsforum.entity.PictureReplyListResult) obj);
    }
}
