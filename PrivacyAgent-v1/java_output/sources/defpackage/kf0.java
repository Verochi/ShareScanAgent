package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class kf0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean n;
    public final /* synthetic */ com.moji.mjfloatball.FloatBallDetailActivity t;

    public /* synthetic */ kf0(com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean, com.moji.mjfloatball.FloatBallDetailActivity floatBallDetailActivity) {
        this.n = entranceResListBean;
        this.t = floatBallDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjfloatball.FloatBallDetailActivity.h(this.n, this.t, view);
    }
}
