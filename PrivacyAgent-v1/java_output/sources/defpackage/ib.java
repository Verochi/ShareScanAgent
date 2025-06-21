package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class ib implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.card.OperationCardViewModel n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;
    public final /* synthetic */ com.mojiweather.area.AreaManageFragment u;

    public /* synthetic */ ib(com.moji.card.OperationCardViewModel operationCardViewModel, kotlin.jvm.internal.Ref.ObjectRef objectRef, com.mojiweather.area.AreaManageFragment areaManageFragment) {
        this.n = operationCardViewModel;
        this.t = objectRef;
        this.u = areaManageFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.mojiweather.area.AreaManageFragment.l(this.n, this.t, this.u, (com.moji.card.event.OpCardChangeEvent) obj);
    }
}
