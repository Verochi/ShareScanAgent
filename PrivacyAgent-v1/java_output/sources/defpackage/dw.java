package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dw implements com.moji.mjweather.weather.view.Days15View.OnCalculateReadyListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.Days15View a;
    public final /* synthetic */ java.util.List b;
    public final /* synthetic */ com.moji.mjweather.weather.share.ShareBitmapListener c;

    public /* synthetic */ dw(com.moji.mjweather.weather.view.Days15View days15View, java.util.List list, com.moji.mjweather.weather.share.ShareBitmapListener shareBitmapListener) {
        this.a = days15View;
        this.b = list;
        this.c = shareBitmapListener;
    }

    public final void onCalculateReady() {
        com.moji.mjweather.weather.view.Days15View.e(this.a, this.b, this.c);
    }
}
