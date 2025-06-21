package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class cn3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.zodiac.fragment.Zodiac7Fragment n;
    public final /* synthetic */ java.util.List t;
    public final /* synthetic */ com.moji.http.zodiac.ZodiacResp u;

    public /* synthetic */ cn3(com.moji.zodiac.fragment.Zodiac7Fragment zodiac7Fragment, java.util.List list, com.moji.http.zodiac.ZodiacResp zodiacResp) {
        this.n = zodiac7Fragment;
        this.t = list;
        this.u = zodiacResp;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.zodiac.fragment.Zodiac7Fragment.d(this.n, this.t, this.u);
    }
}
