package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class fn3 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ int a;
    public final /* synthetic */ com.moji.zodiac.ZodiacActivity b;

    public /* synthetic */ fn3(int i, com.moji.zodiac.ZodiacActivity zodiacActivity) {
        this.a = i;
        this.b = zodiacActivity;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.zodiac.ZodiacActivity.i(this.a, this.b, observableEmitter);
    }
}
