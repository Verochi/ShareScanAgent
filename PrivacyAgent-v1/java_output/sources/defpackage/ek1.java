package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ek1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.MemberTabGuideView n;

    public /* synthetic */ ek1(com.moji.mjweather.weather.view.MemberTabGuideView memberTabGuideView) {
        this.n = memberTabGuideView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.weather.view.MemberTabGuideView.a(this.n, valueAnimator);
    }
}
