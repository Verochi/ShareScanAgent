package defpackage;

/* loaded from: classes26.dex */
public final /* synthetic */ class i60 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.index.dress.DressActivity2 n;

    public /* synthetic */ i60(com.moji.index.dress.DressActivity2 dressActivity2) {
        this.n = dressActivity2;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.index.dress.DressActivity2.c(this.n, (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) obj);
    }
}
