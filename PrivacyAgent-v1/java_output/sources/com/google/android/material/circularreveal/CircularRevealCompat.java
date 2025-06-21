package com.google.android.material.circularreveal;

/* loaded from: classes22.dex */
public final class CircularRevealCompat {

    /* renamed from: com.google.android.material.circularreveal.CircularRevealCompat$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ com.google.android.material.circularreveal.CircularRevealWidget val$view;

        public AnonymousClass1(com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget) {
            this.val$view = circularRevealWidget;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$view.destroyCircularRevealCache();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            this.val$view.buildCircularRevealCache();
        }
    }

    private CircularRevealCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    public static android.animation.Animator createCircularReveal(@androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget, float f, float f2, float f3) {
        android.animation.ObjectAnimator ofObject = android.animation.ObjectAnimator.ofObject(circularRevealWidget, (android.util.Property<com.google.android.material.circularreveal.CircularRevealWidget, V>) com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, (android.animation.TypeEvaluator) com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, (java.lang.Object[]) new com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo[]{new com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo(f, f2, f3)});
        com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo == null) {
            throw new java.lang.IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        android.animation.Animator createCircularReveal = android.view.ViewAnimationUtils.createCircularReveal((android.view.View) circularRevealWidget, (int) f, (int) f2, revealInfo.radius, f3);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(ofObject, createCircularReveal);
        return animatorSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    public static android.animation.Animator createCircularReveal(com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget, float f, float f2, float f3, float f4) {
        android.animation.ObjectAnimator ofObject = android.animation.ObjectAnimator.ofObject(circularRevealWidget, (android.util.Property<com.google.android.material.circularreveal.CircularRevealWidget, V>) com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, (android.animation.TypeEvaluator) com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, (java.lang.Object[]) new com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo[]{new com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo(f, f2, f3), new com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo(f, f2, f4)});
        android.animation.Animator createCircularReveal = android.view.ViewAnimationUtils.createCircularReveal((android.view.View) circularRevealWidget, (int) f, (int) f2, f3, f4);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(ofObject, createCircularReveal);
        return animatorSet;
    }

    @androidx.annotation.NonNull
    public static android.animation.Animator.AnimatorListener createCircularRevealListener(@androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget) {
        return new com.google.android.material.circularreveal.CircularRevealCompat.AnonymousClass1(circularRevealWidget);
    }
}
