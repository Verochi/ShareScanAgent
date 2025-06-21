package com.google.android.material.progressindicator;

/* loaded from: classes22.dex */
final class LinearIndeterminateDisjointAnimatorDelegate extends com.google.android.material.progressindicator.IndeterminateAnimatorDelegate<android.animation.ObjectAnimator> {
    private static final int TOTAL_DURATION_IN_MS = 1800;
    private float animationFraction;
    private android.animation.ObjectAnimator animator;
    androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private boolean animatorCompleteEndRequested;
    private final com.google.android.material.progressindicator.BaseProgressIndicatorSpec baseSpec;
    private boolean dirtyColors;
    private int indicatorColorIndex;
    private final android.view.animation.Interpolator[] interpolatorArray;
    private static final int[] DURATION_TO_MOVE_SEGMENT_ENDS = {533, 567, 850, 750};
    private static final int[] DELAY_TO_MOVE_SEGMENT_ENDS = {1267, 1000, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, 0};
    private static final android.util.Property<com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate, java.lang.Float> ANIMATION_FRACTION = new com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.AnonymousClass2(java.lang.Float.class, "animationFraction");

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            if (com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteEndRequested) {
                com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.this.animator.setRepeatCount(-1);
                com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.this;
                linearIndeterminateDisjointAnimatorDelegate.animatorCompleteCallback.onAnimationEnd(linearIndeterminateDisjointAnimatorDelegate.drawable);
                com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteEndRequested = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
            super.onAnimationRepeat(animator);
            com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.this;
            linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex = (linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex + 1) % com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.this.baseSpec.indicatorColors.length;
            com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.this.dirtyColors = true;
        }
    }

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate$2, reason: invalid class name */
    public static class AnonymousClass2 extends android.util.Property<com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate, java.lang.Float> {
        public AnonymousClass2(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public java.lang.Float get(com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return java.lang.Float.valueOf(linearIndeterminateDisjointAnimatorDelegate.getAnimationFraction());
        }

        @Override // android.util.Property
        public void set(com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, java.lang.Float f) {
            linearIndeterminateDisjointAnimatorDelegate.setAnimationFraction(f.floatValue());
        }
    }

    public LinearIndeterminateDisjointAnimatorDelegate(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.google.android.material.progressindicator.LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.indicatorColorIndex = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = linearProgressIndicatorSpec;
        this.interpolatorArray = new android.view.animation.Interpolator[]{androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat.loadInterpolator(context, com.google.android.material.R.animator.linear_indeterminate_line1_head_interpolator), androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat.loadInterpolator(context, com.google.android.material.R.animator.linear_indeterminate_line1_tail_interpolator), androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat.loadInterpolator(context, com.google.android.material.R.animator.linear_indeterminate_line2_head_interpolator), androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat.loadInterpolator(context, com.google.android.material.R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getAnimationFraction() {
        return this.animationFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator = ofFloat;
            ofFloat.setDuration(com.anythink.expressad.d.a.b.aC);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.AnonymousClass1());
        }
    }

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors) {
            java.util.Arrays.fill(this.segmentColors, com.google.android.material.color.MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.indicatorColorIndex], this.drawable.getAlpha()));
            this.dirtyColors = false;
        }
    }

    private void updateSegmentPositions(int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            this.segmentPositions[i2] = java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, this.interpolatorArray[i2].getInterpolation(getFractionInRange(i, DELAY_TO_MOVE_SEGMENT_ENDS[i2], DURATION_TO_MOVE_SEGMENT_ENDS[i2]))));
        }
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
    public void registerAnimatorsCompleteCallback(@androidx.annotation.NonNull androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback animationCallback) {
        this.animatorCompleteCallback = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
        if (!this.drawable.isVisible()) {
            cancelAnimatorImmediately();
        } else {
            this.animatorCompleteEndRequested = true;
            this.animator.setRepeatCount(0);
        }
    }

    @androidx.annotation.VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.indicatorColorIndex = 0;
        int compositeARGBWithAlpha = com.google.android.material.color.MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        int[] iArr = this.segmentColors;
        iArr[0] = compositeARGBWithAlpha;
        iArr[1] = compositeARGBWithAlpha;
    }

    @androidx.annotation.VisibleForTesting
    public void setAnimationFraction(float f) {
        this.animationFraction = f;
        updateSegmentPositions((int) (f * 1800.0f));
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
        this.animatorCompleteCallback = null;
    }
}
