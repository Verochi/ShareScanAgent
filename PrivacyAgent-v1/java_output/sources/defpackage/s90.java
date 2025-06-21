package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class s90 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.ipc.activity.EmojiMJDetailsActivity n;

    public /* synthetic */ s90(com.moji.mjweather.ipc.activity.EmojiMJDetailsActivity emojiMJDetailsActivity) {
        this.n = emojiMJDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.ipc.activity.EmojiMJDetailsActivity.c(this.n, (com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean) obj);
    }
}
