package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class wu0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjkinsfolk.ui.KinsfolkHomeActivity n;

    public /* synthetic */ wu0(com.moji.mjkinsfolk.ui.KinsfolkHomeActivity kinsfolkHomeActivity) {
        this.n = kinsfolkHomeActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjkinsfolk.ui.KinsfolkHomeActivity.c(this.n, (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) obj);
    }
}
