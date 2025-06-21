package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class df3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.condition.WeatherConditionActivity n;

    public /* synthetic */ df3(com.moji.condition.WeatherConditionActivity weatherConditionActivity) {
        this.n = weatherConditionActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.condition.WeatherConditionActivity.b(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
