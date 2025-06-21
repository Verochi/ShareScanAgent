package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class zf0 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.mjfloatball.FloatBallService n;

    public /* synthetic */ zf0(com.moji.mjfloatball.FloatBallService floatBallService) {
        this.n = floatBallService;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjfloatball.FloatBallService.b(this.n, (kotlin.Unit) obj);
    }
}
