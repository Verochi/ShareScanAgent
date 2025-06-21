package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class z01 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjlunarphase.phase.LunarPhaseFragment n;

    public /* synthetic */ z01(com.moji.mjlunarphase.phase.LunarPhaseFragment lunarPhaseFragment) {
        this.n = lunarPhaseFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjlunarphase.phase.LunarPhaseFragment.b(this.n, (com.moji.mjlunarphase.phase.PhaseData) obj);
    }
}
