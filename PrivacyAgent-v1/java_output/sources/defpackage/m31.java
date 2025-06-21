package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class m31 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.mjlunarphase.MJLunarPhaseActivity n;

    public /* synthetic */ m31(com.moji.mjlunarphase.MJLunarPhaseActivity mJLunarPhaseActivity) {
        this.n = mJLunarPhaseActivity;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjlunarphase.MJLunarPhaseActivity.d(this.n, ((java.lang.Boolean) obj).booleanValue());
    }
}
