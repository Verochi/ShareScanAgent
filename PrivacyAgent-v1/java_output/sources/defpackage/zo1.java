package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class zo1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.condition.viewcontrol.NearMomentViewControl n;

    public /* synthetic */ zo1(com.moji.condition.viewcontrol.NearMomentViewControl nearMomentViewControl) {
        this.n = nearMomentViewControl;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.condition.viewcontrol.NearMomentViewControl.b(this.n, (com.moji.condition.model.ConditionNearMomentModel) obj);
    }
}
