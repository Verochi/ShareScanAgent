package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class li3 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.WeatherPagerStatusLayoutV10 n;

    public /* synthetic */ li3(com.moji.mjweather.weather.WeatherPagerStatusLayoutV10 weatherPagerStatusLayoutV10) {
        this.n = weatherPagerStatusLayoutV10;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.WeatherPagerStatusLayoutV10.b(this.n, valueAnimator);
    }
}
