package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class wg3 implements com.moji.tool.preferences.core.IPreferKey {
    public final /* synthetic */ com.moji.common.area.AreaInfo n;

    public /* synthetic */ wg3(com.moji.common.area.AreaInfo areaInfo) {
        this.n = areaInfo;
    }

    public final java.lang.String name() {
        return com.moji.newliveview.weathertab.WeatherLiveViewPreference.e(this.n);
    }
}
