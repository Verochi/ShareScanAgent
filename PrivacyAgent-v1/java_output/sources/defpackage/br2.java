package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class br2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjstargaze.StarGazeOperationLiveData n;

    public /* synthetic */ br2(com.moji.mjstargaze.StarGazeOperationLiveData starGazeOperationLiveData) {
        this.n = starGazeOperationLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjstargaze.StarGazeOperationLiveData.a(this.n, (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) obj);
    }
}
