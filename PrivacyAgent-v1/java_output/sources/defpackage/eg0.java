package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class eg0 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.mjfloatball.FloatBallService n;

    public /* synthetic */ eg0(com.moji.mjfloatball.FloatBallService floatBallService) {
        this.n = floatBallService;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjfloatball.FloatBallService.i(this.n, (java.lang.Boolean) obj);
    }
}
