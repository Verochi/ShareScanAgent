package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class r90 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.ipc.activity.EmojiMJDetailsActivity n;

    public /* synthetic */ r90(com.moji.mjweather.ipc.activity.EmojiMJDetailsActivity emojiMJDetailsActivity) {
        this.n = emojiMJDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.ipc.activity.EmojiMJDetailsActivity.f(this.n, (com.moji.http.credit.entity.MJEmojiDetailsResp) obj);
    }
}
