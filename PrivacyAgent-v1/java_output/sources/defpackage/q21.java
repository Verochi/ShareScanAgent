package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class q21 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newliveview.comment.emoji.MJEmojiCommentTabListAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean u;

    public /* synthetic */ q21(com.moji.newliveview.comment.emoji.MJEmojiCommentTabListAdapter mJEmojiCommentTabListAdapter, int i, com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean mJEmojiBean) {
        this.n = mJEmojiCommentTabListAdapter;
        this.t = i;
        this.u = mJEmojiBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newliveview.comment.emoji.MJEmojiCommentTabListAdapter.MJEmojiCommentTabListHolder.a(this.n, this.t, this.u, view);
    }
}
