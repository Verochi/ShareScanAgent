package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class yf0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfloatball.FloatBallService n;

    public /* synthetic */ yf0(com.moji.mjfloatball.FloatBallService floatBallService) {
        this.n = floatBallService;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfloatball.FloatBallService.g(this.n, (com.moji.common.area.AreaInfo) obj);
    }
}
