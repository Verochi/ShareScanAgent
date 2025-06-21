package defpackage;

/* loaded from: classes29.dex */
public final /* synthetic */ class cn2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean n;

    public /* synthetic */ cn2(com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean) {
        this.n = entranceResListBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.snow.adapter.SnowBannerHolder.a(this.n, view);
    }
}
