package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ow implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.view.Days15ViewThree n;
    public final /* synthetic */ java.util.List t;
    public final /* synthetic */ com.moji.mjweather.weather.share.ShareBitmapListener u;

    public /* synthetic */ ow(com.moji.mjweather.weather.view.Days15ViewThree days15ViewThree, java.util.List list, com.moji.mjweather.weather.share.ShareBitmapListener shareBitmapListener) {
        this.n = days15ViewThree;
        this.t = list;
        this.u = shareBitmapListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.view.Days15ViewThree.e(this.n, this.t, this.u);
    }
}
