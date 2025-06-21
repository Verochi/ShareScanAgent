package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class w31 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.mjlunarphase.MJLunarPhaseActivity a;

    public /* synthetic */ w31(com.moji.mjlunarphase.MJLunarPhaseActivity mJLunarPhaseActivity) {
        this.a = mJLunarPhaseActivity;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.mjlunarphase.MJLunarPhaseActivity.o(this.a, observableEmitter);
    }
}
