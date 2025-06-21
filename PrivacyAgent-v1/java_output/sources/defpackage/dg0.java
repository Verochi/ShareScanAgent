package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class dg0 implements io.reactivex.functions.Function {
    public final /* synthetic */ com.moji.mjfloatball.FloatBallService n;

    public /* synthetic */ dg0(com.moji.mjfloatball.FloatBallService floatBallService) {
        this.n = floatBallService;
    }

    @Override // io.reactivex.functions.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        return com.moji.mjfloatball.FloatBallService.h(this.n, (java.lang.Long) obj);
    }
}
