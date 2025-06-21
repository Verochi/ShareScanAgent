package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class aa0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.ipc.activity.EmojiMJHomeActivity n;

    public /* synthetic */ aa0(com.moji.mjweather.ipc.activity.EmojiMJHomeActivity emojiMJHomeActivity) {
        this.n = emojiMJHomeActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.ipc.activity.EmojiMJHomeActivity.d(this.n, (com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean) obj);
    }
}
