package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class ll2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean n;

    public /* synthetic */ ll2(com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean) {
        this.n = entranceResListBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.ski.adapter.SkiBannerHolder.a(this.n, view);
    }
}
