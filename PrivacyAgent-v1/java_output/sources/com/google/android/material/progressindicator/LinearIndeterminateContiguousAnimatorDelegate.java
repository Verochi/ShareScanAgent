package com.google.android.material.progressindicator;

/* loaded from: classes22.dex */
final class LinearIndeterminateContiguousAnimatorDelegate extends com.google.android.material.progressindicator.IndeterminateAnimatorDelegate<android.animation.ObjectAnimator> {
    private static final android.util.Property<com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate, java.lang.Float> ANIMATION_FRACTION = new com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.AnonymousClass2(java.lang.Float.class, "animationFraction");
    private static final int DURATION_PER_CYCLE_IN_MS = 333;
    private static final int TOTAL_DURATION_IN_MS = 667;
    private float animationFraction;
    private android.animation.ObjectAnimator animator;
    private final com.google.android.material.progressindicator.BaseProgressIndicatorSpec baseSpec;
    private boolean dirtyColors;
    private androidx.interpolator.view.animation.FastOutSlowInInterpolator interpolator;
    private int newIndicatorColorIndex;

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
            super.onAnimationRepeat(animator);
            com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.this;
            linearIndeterminateContiguousAnimatorDelegate.newIndicatorColorIndex = (linearIndeterminateContiguousAnimatorDelegate.newIndicatorColorIndex + 1) % com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.this.baseSpec.indicatorColors.length;
            com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.this.dirtyColors = true;
        }
    }

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate$2, reason: invalid class name */
    public static class AnonymousClass2 extends android.util.Property<com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate, java.lang.Float> {
        public AnonymousClass2(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public java.lang.Float get(com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
            return java.lang.Float.valueOf(linearIndeterminateContiguousAnimatorDelegate.getAnimationFraction());
        }

        @Override // android.util.Property
        public void set(com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, java.lang.Float f) {
            linearIndeterminateContiguousAnimatorDelegate.setAnimationFraction(f.floatValue());
        }
    }

    public LinearIndeterminateContiguousAnimatorDelegate(@androidx.annotation.NonNull com.google.android.material.progressindicator.LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.newIndicatorColorIndex = 1;
        this.baseSpec = linearProgressIndicatorSpec;
        this.interpolator = new androidx.interpolator.view.animation.FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getAnimationFraction() {
        return this.animationFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator = ofFloat;
            ofFloat.setDuration(333L);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.AnonymousClass1());
        }
    }

    private void maybeUpdateSegmentColors() {
        if (!this.dirtyColors || this.segmentPositions[3] >= 1.0f) {
            return;
        }
        int[] iArr = this.segmentColors;
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = com.google.android.material.color.MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.newIndicatorColorIndex], this.drawable.getAlpha());
        this.dirtyColors = false;
    }

    private void updateSegmentPositions(int i) {
        this.segmentPositions[0] = 0.0f;
        float fractionInRange = getFractionInRange(i, 0, TOTAL_DURATION_IN_MS);
        float[] fArr = this.segmentPositions;
        float interpolation = this.interpolator.getInterpolation(fractionInRange);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.segmentPositions;
        float interpolation2 = this.interpolator.getInterpolation(fractionInRange + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.segmentPositions[5] = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void cancelAnimatorImmediately() {
        android.animation.ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void registerAnimatorsCompleteCallback(@androidx.annotation.Nullable androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback animationCallback) {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
    }

    @androidx.annotation.VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        java.util.Arrays.fill(this.segmentColors, com.google.android.material.color.MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha()));
    }

    @androidx.annotation.VisibleForTesting
    public void setAnimationFraction(float f) {
        this.animationFraction = f;
        updateSegmentPositions((int) (f * 333.0f));
        maybeUpdateSegmentColors();
        this.drawable.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void unregisterAnimatorsCompleteCallback() {
    }
}
