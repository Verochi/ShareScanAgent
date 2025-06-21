package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class gf0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfloatball.FloatBallDetailActivity n;

    public /* synthetic */ gf0(com.moji.mjfloatball.FloatBallDetailActivity floatBallDetailActivity) {
        this.n = floatBallDetailActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfloatball.FloatBallDetailActivity.g(this.n, (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) obj);
    }
}
