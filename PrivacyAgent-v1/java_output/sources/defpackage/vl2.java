package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class vl2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.ski.viewmodel.SkiViewModel n;

    public /* synthetic */ vl2(com.moji.ski.viewmodel.SkiViewModel skiViewModel) {
        this.n = skiViewModel;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.ski.viewmodel.SkiViewModel.a(this.n, (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) obj);
    }
}
