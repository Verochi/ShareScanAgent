package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class mn2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.snow.viewmodel.SnowPageViewModel n;

    public /* synthetic */ mn2(com.moji.snow.viewmodel.SnowPageViewModel snowPageViewModel) {
        this.n = snowPageViewModel;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.snow.viewmodel.SnowPageViewModel.b(this.n, (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) obj);
    }
}
