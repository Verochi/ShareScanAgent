package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class xg3 implements com.moji.tool.preferences.core.IPreferKey {
    public final /* synthetic */ com.moji.common.area.AreaInfo n;

    public /* synthetic */ xg3(com.moji.common.area.AreaInfo areaInfo) {
        this.n = areaInfo;
    }

    public final java.lang.String name() {
        return com.moji.newliveview.weathertab.WeatherLiveViewPreference.d(this.n);
    }
}
