package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class on2 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.snow.viewmodel.SnowPageViewModel n;

    public /* synthetic */ on2(com.moji.snow.viewmodel.SnowPageViewModel snowPageViewModel) {
        this.n = snowPageViewModel;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.snow.viewmodel.SnowPageViewModel.c(this.n, (com.moji.snow.viewmodel.SnowMapInfo) obj);
    }
}
