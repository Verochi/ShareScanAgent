package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class t90 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.mjweather.ipc.activity.EmojiMJDetailsActivity a;
    public final /* synthetic */ com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean b;

    public /* synthetic */ t90(com.moji.mjweather.ipc.activity.EmojiMJDetailsActivity emojiMJDetailsActivity, com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean mJEmojiBean) {
        this.a = emojiMJDetailsActivity;
        this.b = mJEmojiBean;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.mjweather.ipc.activity.EmojiMJDetailsActivity.d(this.a, this.b, mJDialog, eTypeAction);
    }
}
