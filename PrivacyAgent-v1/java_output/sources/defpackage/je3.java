package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class je3 implements com.moji.mjweather.weather.avatar.AvatarView.PrepareShareListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.WeatherAndShortView a;
    public final /* synthetic */ com.moji.mjweather.weather.share.ShareBitmapListener b;

    public /* synthetic */ je3(com.moji.mjweather.weather.view.WeatherAndShortView weatherAndShortView, com.moji.mjweather.weather.share.ShareBitmapListener shareBitmapListener) {
        this.a = weatherAndShortView;
        this.b = shareBitmapListener;
    }

    public final void onDataReady(com.moji.mjweather.weather.avatar.AvatarView.AvatarBitmap avatarBitmap) {
        com.moji.mjweather.weather.view.WeatherAndShortView.i(this.a, this.b, avatarBitmap);
    }
}
