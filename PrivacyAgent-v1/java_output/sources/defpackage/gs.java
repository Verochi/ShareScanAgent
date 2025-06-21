package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class gs implements java.lang.Runnable {
    public final /* synthetic */ com.moji.condition.view.ConditionHour24CallBack n;

    public /* synthetic */ gs(com.moji.condition.view.ConditionHour24CallBack conditionHour24CallBack) {
        this.n = conditionHour24CallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.condition.view.ConditionHour24CallBack.a(this.n);
    }
}
