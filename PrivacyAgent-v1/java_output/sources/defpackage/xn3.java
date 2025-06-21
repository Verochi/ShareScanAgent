package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class xn3 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.share.pane.PaneShareView n;
    public final /* synthetic */ com.moji.zodiac.ZodiacShareActivity t;

    public /* synthetic */ xn3(com.moji.share.pane.PaneShareView paneShareView, com.moji.zodiac.ZodiacShareActivity zodiacShareActivity) {
        this.n = paneShareView;
        this.t = zodiacShareActivity;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.zodiac.ZodiacShareActivity.onCreate.1.a(this.n, this.t, (java.lang.Boolean) obj);
    }
}
