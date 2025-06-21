package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
public final class FadeThroughProvider implements com.google.android.material.transition.platform.VisibilityAnimatorProvider {
    static final float FADE_THROUGH_THRESHOLD = 0.35f;
    private float progressThreshold = FADE_THROUGH_THRESHOLD;

    /* renamed from: com.google.android.material.transition.platform.FadeThroughProvider$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float val$endFraction;
        final /* synthetic */ float val$endValue;
        final /* synthetic */ float val$startFraction;
        final /* synthetic */ float val$startValue;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass1(android.view.View view, float f, float f2, float f3, float f4) {
            this.val$view = view;
            this.val$startValue = f;
            this.val$endValue = f2;
            this.val$startFraction = f3;
            this.val$endFraction = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            this.val$view.setAlpha(com.google.android.material.transition.platform.TransitionUtils.lerp(this.val$startValue, this.val$endValue, this.val$startFraction, this.val$endFraction, ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeThroughProvider$2, reason: invalid class name */
    public static class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ float val$originalAlpha;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass2(android.view.View view, float f) {
            this.val$view = view;
            this.val$originalAlpha = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$view.setAlpha(this.val$originalAlpha);
        }
    }

    private static android.animation.Animator createFadeThroughAnimator(android.view.View view, float f, float f2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f3, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f4, float f5) {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new com.google.android.material.transition.platform.FadeThroughProvider.AnonymousClass1(view, f, f2, f3, f4));
        ofFloat.addListener(new com.google.android.material.transition.platform.FadeThroughProvider.AnonymousClass2(view, f5));
        return ofFloat;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @androidx.annotation.Nullable
    public android.animation.Animator createAppear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, 0.0f, alpha, this.progressThreshold, 1.0f, alpha);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @androidx.annotation.Nullable
    public android.animation.Animator createDisappear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, alpha, 0.0f, 0.0f, this.progressThreshold, alpha);
    }

    public float getProgressThreshold() {
        return this.progressThreshold;
    }

    public void setProgressThreshold(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.progressThreshold = f;
    }
}
