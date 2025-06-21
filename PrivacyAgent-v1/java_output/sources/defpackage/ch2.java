package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ch2 implements com.amap.api.maps.AMap.OnMapLoadedListener {
    public final /* synthetic */ com.moji.shorttime.ui.ShortTimeFragmentV2 n;
    public final /* synthetic */ android.os.Bundle t;

    public /* synthetic */ ch2(com.moji.shorttime.ui.ShortTimeFragmentV2 shortTimeFragmentV2, android.os.Bundle bundle) {
        this.n = shortTimeFragmentV2;
        this.t = bundle;
    }

    @Override // com.amap.api.maps.AMap.OnMapLoadedListener
    public final void onMapLoaded() {
        com.moji.shorttime.ui.ShortTimeFragmentV2.i(this.n, this.t);
    }
}
