package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class hn3 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.zodiac.ZodiacActivity a;

    public /* synthetic */ hn3(com.moji.zodiac.ZodiacActivity zodiacActivity) {
        this.a = zodiacActivity;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.zodiac.ZodiacActivity.f(this.a, observableEmitter);
    }
}
