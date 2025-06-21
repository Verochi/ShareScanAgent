package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class a11 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjlunarphase.phase.LunarPhaseScrollView n;
    public final /* synthetic */ int t;

    public /* synthetic */ a11(com.moji.mjlunarphase.phase.LunarPhaseScrollView lunarPhaseScrollView, int i) {
        this.n = lunarPhaseScrollView;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjlunarphase.phase.LunarPhaseScrollView.b(this.n, this.t);
    }
}
