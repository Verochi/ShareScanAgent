package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class x implements io.reactivex.functions.Function {
    public final /* synthetic */ com.moji.mjad.common.view.creater.AbsAdImageViewCreater n;

    public /* synthetic */ x(com.moji.mjad.common.view.creater.AbsAdImageViewCreater absAdImageViewCreater) {
        this.n = absAdImageViewCreater;
    }

    @Override // io.reactivex.functions.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        return com.moji.mjad.common.view.creater.AbsAdImageViewCreater.r(this.n, (com.moji.mjad.common.view.creater.bean.ZipImageBean) obj);
    }
}
