package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class xg2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.typhoon.newversion.view.ShortPopBackground n;

    public /* synthetic */ xg2(com.moji.mjweather.typhoon.newversion.view.ShortPopBackground shortPopBackground) {
        this.n = shortPopBackground;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.typhoon.newversion.view.ShortPopBackground.a(this.n, valueAnimator);
    }
}
