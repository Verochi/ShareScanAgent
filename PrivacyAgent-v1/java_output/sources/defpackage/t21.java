package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class t21 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean n;

    public /* synthetic */ t21(com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean mJEmojiBean) {
        this.n = mJEmojiBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.ipc.adapter.MJEmojiHomeAdapter.MJEmojiHomeHolder.b(this.n, view);
    }
}
