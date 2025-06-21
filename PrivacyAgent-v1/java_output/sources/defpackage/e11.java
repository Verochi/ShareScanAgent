package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class e11 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.mjlunarphase.phase.LunarPhaseViewModel n;

    public /* synthetic */ e11(com.moji.mjlunarphase.phase.LunarPhaseViewModel lunarPhaseViewModel) {
        this.n = lunarPhaseViewModel;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjlunarphase.phase.LunarPhaseViewModel.c(this.n, (io.reactivex.Notification) obj);
    }
}
