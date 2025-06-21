package defpackage;

/* loaded from: classes13.dex */
public final /* synthetic */ class pv0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.redleaves.data.LeafLiveData n;

    public /* synthetic */ pv0(com.moji.redleaves.data.LeafLiveData leafLiveData) {
        this.n = leafLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.redleaves.data.LeafLiveData.c(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
