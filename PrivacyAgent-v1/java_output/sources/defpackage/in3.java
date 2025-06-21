package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class in3 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.zodiac.ZodiacActivity n;
    public final /* synthetic */ com.moji.dialog.MJDialog t;

    public /* synthetic */ in3(com.moji.zodiac.ZodiacActivity zodiacActivity, com.moji.dialog.MJDialog mJDialog) {
        this.n = zodiacActivity;
        this.t = mJDialog;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.zodiac.ZodiacActivity.n(this.n, this.t, (java.lang.Boolean) obj);
    }
}
