package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class aw2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.opevent.model.OperationEvent n;

    public /* synthetic */ aw2(com.moji.opevent.model.OperationEvent operationEvent) {
        this.n = operationEvent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.tabmember.TabMemberFragment.q(this.n, view);
    }
}
