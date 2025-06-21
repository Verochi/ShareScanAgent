package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class oa1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.MainVoiceView n;

    public /* synthetic */ oa1(com.moji.mjweather.weather.view.MainVoiceView mainVoiceView) {
        this.n = mainVoiceView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.MainVoiceView.a(this.n, valueAnimator);
    }
}
