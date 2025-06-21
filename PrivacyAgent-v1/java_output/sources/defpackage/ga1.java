package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ga1 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.mjweather.main.MainTabConfig n;

    public /* synthetic */ ga1(com.moji.mjweather.main.MainTabConfig mainTabConfig) {
        this.n = mainTabConfig;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjweather.main.MainTabConfig.b(this.n, (java.lang.Throwable) obj);
    }
}
