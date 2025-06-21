package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class hf3 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.beta.condition.WeatherConditionS5View n;
    public final /* synthetic */ com.moji.mjweather.weather.share.ShareBitmapListener t;

    public /* synthetic */ hf3(com.moji.mjweather.weather.beta.condition.WeatherConditionS5View weatherConditionS5View, com.moji.mjweather.weather.share.ShareBitmapListener shareBitmapListener) {
        this.n = weatherConditionS5View;
        this.t = shareBitmapListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.beta.condition.WeatherConditionS5View.b(this.n, this.t);
    }
}
