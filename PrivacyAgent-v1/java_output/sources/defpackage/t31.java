package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class t31 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjlunarphase.MJLunarPhaseActivity n;

    public /* synthetic */ t31(com.moji.mjlunarphase.MJLunarPhaseActivity mJLunarPhaseActivity) {
        this.n = mJLunarPhaseActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjlunarphase.MJLunarPhaseActivity.i(this.n, (java.lang.Boolean) obj);
    }
}
