package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class nw implements com.moji.mjweather.weather.view.Days15ViewThree.OnCalculateReadyListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.Days15ViewThree a;
    public final /* synthetic */ java.util.List b;
    public final /* synthetic */ com.moji.mjweather.weather.share.ShareBitmapListener c;

    public /* synthetic */ nw(com.moji.mjweather.weather.view.Days15ViewThree days15ViewThree, java.util.List list, com.moji.mjweather.weather.share.ShareBitmapListener shareBitmapListener) {
        this.a = days15ViewThree;
        this.b = list;
        this.c = shareBitmapListener;
    }

    public final void onCalculateReady() {
        com.moji.mjweather.weather.view.Days15ViewThree.a(this.a, this.b, this.c);
    }
}
