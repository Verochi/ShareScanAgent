package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class bg0 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.mjfloatball.FloatBallService n;

    public /* synthetic */ bg0(com.moji.mjfloatball.FloatBallService floatBallService) {
        this.n = floatBallService;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjfloatball.FloatBallService.e(this.n, (java.lang.Long) obj);
    }
}
