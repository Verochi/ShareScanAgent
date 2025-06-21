package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class se3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.view.WeatherAndShortView n;
    public final /* synthetic */ com.moji.mjweather.weather.avatar.AvatarView.AvatarBitmap t;
    public final /* synthetic */ com.moji.mjweather.weather.share.ShareBitmapListener u;

    public /* synthetic */ se3(com.moji.mjweather.weather.view.WeatherAndShortView weatherAndShortView, com.moji.mjweather.weather.avatar.AvatarView.AvatarBitmap avatarBitmap, com.moji.mjweather.weather.share.ShareBitmapListener shareBitmapListener) {
        this.n = weatherAndShortView;
        this.t = avatarBitmap;
        this.u = shareBitmapListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.view.WeatherAndShortView.j(this.n, this.t, this.u);
    }
}
