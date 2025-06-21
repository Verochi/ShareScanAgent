package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dh0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.feed.view.FocusButton n;

    public /* synthetic */ dh0(com.moji.mjweather.feed.view.FocusButton focusButton) {
        this.n = focusButton;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.feed.view.FocusButton.c(this.n, valueAnimator);
    }
}
