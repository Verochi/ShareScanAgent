package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class y01 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjlunarphase.phase.LunarPhaseFragment n;

    public /* synthetic */ y01(com.moji.mjlunarphase.phase.LunarPhaseFragment lunarPhaseFragment) {
        this.n = lunarPhaseFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjlunarphase.phase.LunarPhaseFragment.a(this.n, obj);
    }
}
