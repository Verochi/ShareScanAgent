package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class xl2 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.ski.viewmodel.SkiViewModel n;

    public /* synthetic */ xl2(com.moji.ski.viewmodel.SkiViewModel skiViewModel) {
        this.n = skiViewModel;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.ski.viewmodel.SkiViewModel.c(this.n, (com.moji.ski.viewmodel.SkiMapInfo) obj);
    }
}
