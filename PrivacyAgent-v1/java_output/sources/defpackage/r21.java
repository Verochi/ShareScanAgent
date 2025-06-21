package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class r21 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.ipc.adapter.MJEmojiDetailsAdapter n;
    public final /* synthetic */ com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean t;

    public /* synthetic */ r21(com.moji.mjweather.ipc.adapter.MJEmojiDetailsAdapter mJEmojiDetailsAdapter, com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean mJEmojiBean) {
        this.n = mJEmojiDetailsAdapter;
        this.t = mJEmojiBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.ipc.adapter.MJEmojiDetailsAdapter.MJEmojiDetailsHeadHolder.a(this.n, this.t, view);
    }
}
