package defpackage;

/* loaded from: classes13.dex */
public final /* synthetic */ class g72 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.rapeflowers.RFlowersViewModel n;

    public /* synthetic */ g72(com.moji.rapeflowers.RFlowersViewModel rFlowersViewModel) {
        this.n = rFlowersViewModel;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.rapeflowers.RFlowersViewModel.b(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
