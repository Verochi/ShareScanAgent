package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class ap1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.condition.viewcontrol.NearMomentViewControl n;

    public /* synthetic */ ap1(com.moji.condition.viewcontrol.NearMomentViewControl nearMomentViewControl) {
        this.n = nearMomentViewControl;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.condition.viewcontrol.NearMomentViewControl.a(this.n, (java.lang.Boolean) obj);
    }
}
