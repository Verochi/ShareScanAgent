package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class w90 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.mjweather.ipc.activity.EmojiMJHomeActivity a;
    public final /* synthetic */ com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean b;

    public /* synthetic */ w90(com.moji.mjweather.ipc.activity.EmojiMJHomeActivity emojiMJHomeActivity, com.moji.http.credit.entity.MJEmojiListResp.MJEmojiBean mJEmojiBean) {
        this.a = emojiMJHomeActivity;
        this.b = mJEmojiBean;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.mjweather.ipc.activity.EmojiMJHomeActivity.e(this.a, this.b, mJDialog, eTypeAction);
    }
}
