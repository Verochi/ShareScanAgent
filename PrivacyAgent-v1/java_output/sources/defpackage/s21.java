package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class s21 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.ipc.adapter.MJEmojiHomeAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean u;

    public /* synthetic */ s21(com.moji.mjweather.ipc.adapter.MJEmojiHomeAdapter mJEmojiHomeAdapter, int i, com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean mJEmojiBean) {
        this.n = mJEmojiHomeAdapter;
        this.t = i;
        this.u = mJEmojiBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.ipc.adapter.MJEmojiHomeAdapter.MJEmojiHomeHolder.a(this.n, this.t, this.u, view);
    }
}
