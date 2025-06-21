package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ki3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mvpframe.delegate.ILoadingCallback n;

    public /* synthetic */ ki3(com.moji.mvpframe.delegate.ILoadingCallback iLoadingCallback) {
        this.n = iLoadingCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.WeatherPagerStatusLayoutV10.d(this.n);
    }
}
