package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class xb1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.tabme.model.MeUiModel n;

    public /* synthetic */ xb1(com.moji.mjweather.tabme.model.MeUiModel meUiModel) {
        this.n = meUiModel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.tabme.utils.MeCacheHelper.b(this.n);
    }
}
