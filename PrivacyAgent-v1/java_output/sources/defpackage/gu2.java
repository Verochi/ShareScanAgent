package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class gu2 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.sunglow.SunglowShareActivity a;

    public /* synthetic */ gu2(com.moji.sunglow.SunglowShareActivity sunglowShareActivity) {
        this.a = sunglowShareActivity;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.sunglow.SunglowShareActivity.onCreate.1.a(this.a, observableEmitter);
    }
}
