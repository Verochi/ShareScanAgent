package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class gf3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.opevent.model.OperationEvent n;

    public /* synthetic */ gf3(com.moji.opevent.model.OperationEvent operationEvent) {
        this.n = operationEvent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.condition.WeatherConditionActivity.d(this.n, view);
    }
}
