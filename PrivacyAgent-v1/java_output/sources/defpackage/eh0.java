package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class eh0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.feed.view.FocusButton n;

    public /* synthetic */ eh0(com.moji.mjweather.feed.view.FocusButton focusButton) {
        this.n = focusButton;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.feed.view.FocusButton.a(this.n, valueAnimator);
    }
}
