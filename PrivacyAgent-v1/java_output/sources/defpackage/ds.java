package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class ds implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.condition.view.ConditionAqiCallback n;

    public /* synthetic */ ds(com.moji.condition.view.ConditionAqiCallback conditionAqiCallback) {
        this.n = conditionAqiCallback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.condition.view.ConditionAqiCallback.a(this.n, view);
    }
}
