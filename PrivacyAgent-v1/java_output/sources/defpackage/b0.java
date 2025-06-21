package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class b0 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.mjad.common.view.creater.bean.ZipImageGifDrawable a;

    public /* synthetic */ b0(com.moji.mjad.common.view.creater.bean.ZipImageGifDrawable zipImageGifDrawable) {
        this.a = zipImageGifDrawable;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.mjad.common.view.creater.AbsAdImageViewCreater.q(this.a, observableEmitter);
    }
}
