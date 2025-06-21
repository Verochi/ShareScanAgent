package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class iw implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.view.Days15View n;
    public final /* synthetic */ java.util.List t;
    public final /* synthetic */ com.moji.mjweather.weather.share.ShareBitmapListener u;

    public /* synthetic */ iw(com.moji.mjweather.weather.view.Days15View days15View, java.util.List list, com.moji.mjweather.weather.share.ShareBitmapListener shareBitmapListener) {
        this.n = days15View;
        this.t = list;
        this.u = shareBitmapListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.view.Days15View.d(this.n, this.t, this.u);
    }
}
