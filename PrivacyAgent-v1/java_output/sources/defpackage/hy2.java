package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class hy2 implements com.moji.mjweather.weather.share.ShareBitmapListener {
    public final /* synthetic */ com.moji.mjweather.TabWeatherBetaFragment a;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig b;

    public /* synthetic */ hy2(com.moji.mjweather.TabWeatherBetaFragment tabWeatherBetaFragment, com.moji.share.entity.ShareContentConfig shareContentConfig) {
        this.a = tabWeatherBetaFragment;
        this.b = shareContentConfig;
    }

    public final void onReady(java.util.List list) {
        com.moji.mjweather.TabWeatherBetaFragment.j(this.a, this.b, list);
    }
}
