package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class mi3 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.WeatherPagerStatusLayoutV10 n;
    public final /* synthetic */ androidx.constraintlayout.widget.ConstraintLayout.LayoutParams t;

    public /* synthetic */ mi3(com.moji.mjweather.weather.WeatherPagerStatusLayoutV10 weatherPagerStatusLayoutV10, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
        this.n = weatherPagerStatusLayoutV10;
        this.t = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.WeatherPagerStatusLayoutV10.a(this.n, this.t, valueAnimator);
    }
}
