package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class fz2 implements com.moji.mjweather.weather.share.ShareBitmapListener {
    public final /* synthetic */ com.moji.mjweather.TabWeatherV9Fragment a;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig b;

    public /* synthetic */ fz2(com.moji.mjweather.TabWeatherV9Fragment tabWeatherV9Fragment, com.moji.share.entity.ShareContentConfig shareContentConfig) {
        this.a = tabWeatherV9Fragment;
        this.b = shareContentConfig;
    }

    public final void onReady(java.util.List list) {
        com.moji.mjweather.TabWeatherV9Fragment.g(this.a, this.b, list);
    }
}
