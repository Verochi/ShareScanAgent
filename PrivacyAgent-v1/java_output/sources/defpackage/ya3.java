package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ya3 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.amap.api.maps.TextureMapView a;
    public final /* synthetic */ android.content.Context b;
    public final /* synthetic */ com.moji.shorttime.ui.player.MapRadarPlayBar c;
    public final /* synthetic */ java.lang.String d;
    public final /* synthetic */ com.moji.shorttime.ui.view.MapMarkerView e;
    public final /* synthetic */ android.view.View f;

    public /* synthetic */ ya3(com.amap.api.maps.TextureMapView textureMapView, android.content.Context context, com.moji.shorttime.ui.player.MapRadarPlayBar mapRadarPlayBar, java.lang.String str, com.moji.shorttime.ui.view.MapMarkerView mapMarkerView, android.view.View view) {
        this.a = textureMapView;
        this.b = context;
        this.c = mapRadarPlayBar;
        this.d = str;
        this.e = mapMarkerView;
        this.f = view;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.shorttime.utils.VideoRecordUtil.e(this.a, this.b, this.c, this.d, this.e, this.f, observableEmitter);
    }
}
