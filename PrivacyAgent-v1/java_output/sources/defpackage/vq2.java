package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class vq2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean n;

    public /* synthetic */ vq2(com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean) {
        this.n = entranceResListBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjstargaze.viewcontrol.StarBannerViewControl.a(this.n, view);
    }
}
