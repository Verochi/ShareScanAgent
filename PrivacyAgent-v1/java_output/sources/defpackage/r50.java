package defpackage;

/* loaded from: classes26.dex */
public final /* synthetic */ class r50 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.opevent.model.OperationEvent n;

    public /* synthetic */ r50(com.moji.opevent.model.OperationEvent operationEvent) {
        this.n = operationEvent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.fragment.DrawLotsBannerFragment.a(this.n, view);
    }
}
