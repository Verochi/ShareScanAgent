package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class hz2 implements com.moji.mjweather.weather.share.ShareBitmapListener {
    public final /* synthetic */ com.moji.mjweather.TabWeatherV9Fragment a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ com.moji.common.area.AreaInfo c;

    public /* synthetic */ hz2(com.moji.mjweather.TabWeatherV9Fragment tabWeatherV9Fragment, java.lang.String str, com.moji.common.area.AreaInfo areaInfo) {
        this.a = tabWeatherV9Fragment;
        this.b = str;
        this.c = areaInfo;
    }

    public final void onReady(java.util.List list) {
        com.moji.mjweather.TabWeatherV9Fragment.x(this.a, this.b, this.c, list);
    }
}
