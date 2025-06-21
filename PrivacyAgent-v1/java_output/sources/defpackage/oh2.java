package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class oh2 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.mjshortvideo.ShortVideoShareActivity a;

    public /* synthetic */ oh2(com.moji.mjshortvideo.ShortVideoShareActivity shortVideoShareActivity) {
        this.a = shortVideoShareActivity;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.mjshortvideo.ShortVideoShareActivity.onCreate.4.a(this.a, observableEmitter);
    }
}
