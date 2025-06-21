package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class s13 implements com.moji.thunder.thunderstorm.fragment.ThunderMapViewControl.MapWindowMovedCallback {
    public final /* synthetic */ com.moji.thunder.thunderstorm.ThunderStormActivity a;

    public /* synthetic */ s13(com.moji.thunder.thunderstorm.ThunderStormActivity thunderStormActivity) {
        this.a = thunderStormActivity;
    }

    public final void windowMoved(com.amap.api.maps.model.LatLng latLng) {
        com.moji.thunder.thunderstorm.ThunderStormActivity.c(this.a, latLng);
    }
}
