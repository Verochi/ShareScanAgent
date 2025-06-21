package defpackage;

/* loaded from: classes13.dex */
public final /* synthetic */ class nv0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.redleaves.data.LeafLiveData n;

    public /* synthetic */ nv0(com.moji.redleaves.data.LeafLiveData leafLiveData) {
        this.n = leafLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.redleaves.data.LeafLiveData.a(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
