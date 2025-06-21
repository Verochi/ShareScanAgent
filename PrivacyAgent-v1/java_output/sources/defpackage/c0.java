package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class c0 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.mjad.common.view.creater.bean.ZipImageBean a;

    public /* synthetic */ c0(com.moji.mjad.common.view.creater.bean.ZipImageBean zipImageBean) {
        this.a = zipImageBean;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.mjad.common.view.creater.AbsAdImageViewCreater.k(this.a, observableEmitter);
    }
}
