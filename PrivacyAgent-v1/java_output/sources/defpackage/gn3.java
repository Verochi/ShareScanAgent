package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class gn3 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.moji.zodiac.ZodiacActivity t;

    public /* synthetic */ gn3(int i, com.moji.zodiac.ZodiacActivity zodiacActivity) {
        this.n = i;
        this.t = zodiacActivity;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.zodiac.ZodiacActivity.d(this.n, this.t, (java.lang.Boolean) obj);
    }
}
