package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class r31 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjlunarphase.MJLunarPhaseActivity n;

    public /* synthetic */ r31(com.moji.mjlunarphase.MJLunarPhaseActivity mJLunarPhaseActivity) {
        this.n = mJLunarPhaseActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjlunarphase.MJLunarPhaseActivity.m(this.n, (com.moji.mjlunarphase.moondatepicker.SimpleCityInfo) obj);
    }
}
