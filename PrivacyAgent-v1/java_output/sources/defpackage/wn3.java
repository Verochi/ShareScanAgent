package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class wn3 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.zodiac.ZodiacShareActivity a;
    public final /* synthetic */ java.lang.String b;

    public /* synthetic */ wn3(com.moji.zodiac.ZodiacShareActivity zodiacShareActivity, java.lang.String str) {
        this.a = zodiacShareActivity;
        this.b = str;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.zodiac.ZodiacShareActivity.onCreate.1.b(this.a, this.b, observableEmitter);
    }
}
