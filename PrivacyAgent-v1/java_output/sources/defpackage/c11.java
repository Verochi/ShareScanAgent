package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class c11 implements io.reactivex.functions.Function {
    public final /* synthetic */ com.moji.mjlunarphase.phase.LunarPhaseViewModel n;

    public /* synthetic */ c11(com.moji.mjlunarphase.phase.LunarPhaseViewModel lunarPhaseViewModel) {
        this.n = lunarPhaseViewModel;
    }

    @Override // io.reactivex.functions.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        return com.moji.mjlunarphase.phase.LunarPhaseViewModel.b(this.n, (com.moji.mjlunarphase.moondatepicker.DatePickerData) obj);
    }
}
