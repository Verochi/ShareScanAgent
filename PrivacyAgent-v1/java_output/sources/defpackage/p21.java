package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class p21 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newliveview.comment.emoji.MJEmojiCommentDetailsAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.http.credit.entity.MJEmojiLocalConfig.EmojiLocalConfigBean u;

    public /* synthetic */ p21(com.moji.newliveview.comment.emoji.MJEmojiCommentDetailsAdapter mJEmojiCommentDetailsAdapter, int i, com.moji.http.credit.entity.MJEmojiLocalConfig.EmojiLocalConfigBean emojiLocalConfigBean) {
        this.n = mJEmojiCommentDetailsAdapter;
        this.t = i;
        this.u = emojiLocalConfigBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newliveview.comment.emoji.MJEmojiCommentDetailsAdapter.MJEmojiCommentDetailsHolder.a(this.n, this.t, this.u, view);
    }
}
