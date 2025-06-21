package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class ca2 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.rainbow.RainbowShareActivity a;

    public /* synthetic */ ca2(com.moji.rainbow.RainbowShareActivity rainbowShareActivity) {
        this.a = rainbowShareActivity;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.rainbow.RainbowShareActivity.onCreate.1.a(this.a, observableEmitter);
    }
}
