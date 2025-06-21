package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class en3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.zodiac.ZodiacActivity n;
    public final /* synthetic */ com.moji.http.zodiac.ZodiacResp t;

    public /* synthetic */ en3(com.moji.zodiac.ZodiacActivity zodiacActivity, com.moji.http.zodiac.ZodiacResp zodiacResp) {
        this.n = zodiacActivity;
        this.t = zodiacResp;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.zodiac.ZodiacActivity.c(this.n, this.t);
    }
}
