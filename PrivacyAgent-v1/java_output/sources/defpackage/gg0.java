package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class gg0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfloatball.FloatBallService n;
    public final /* synthetic */ com.moji.common.area.AreaInfo t;
    public final /* synthetic */ com.moji.weatherprovider.data.Weather u;

    public /* synthetic */ gg0(com.moji.mjfloatball.FloatBallService floatBallService, com.moji.common.area.AreaInfo areaInfo, com.moji.weatherprovider.data.Weather weather) {
        this.n = floatBallService;
        this.t = areaInfo;
        this.u = weather;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfloatball.FloatBallService.d(this.n, this.t, this.u, (com.moji.opevent.model.OperationEvent) obj);
    }
}
