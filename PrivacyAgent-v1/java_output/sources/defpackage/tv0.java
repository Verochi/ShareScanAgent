package defpackage;

/* loaded from: classes13.dex */
public final /* synthetic */ class tv0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.redleaves.data.LeafRepository n;

    public /* synthetic */ tv0(com.moji.redleaves.data.LeafRepository leafRepository) {
        this.n = leafRepository;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.redleaves.data.LeafRepository.b(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
