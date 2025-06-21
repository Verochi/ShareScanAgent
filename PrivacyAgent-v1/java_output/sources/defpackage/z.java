package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class z implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.mjad.common.view.creater.AbsAdImageViewCreater a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ android.widget.ImageView c;
    public final /* synthetic */ com.moji.mjad.common.view.creater.bean.ZipImageBean d;

    public /* synthetic */ z(com.moji.mjad.common.view.creater.AbsAdImageViewCreater absAdImageViewCreater, java.lang.String str, android.widget.ImageView imageView, com.moji.mjad.common.view.creater.bean.ZipImageBean zipImageBean) {
        this.a = absAdImageViewCreater;
        this.b = str;
        this.c = imageView;
        this.d = zipImageBean;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.mjad.common.view.creater.AbsAdImageViewCreater.l(this.a, this.b, this.c, this.d, observableEmitter);
    }
}
