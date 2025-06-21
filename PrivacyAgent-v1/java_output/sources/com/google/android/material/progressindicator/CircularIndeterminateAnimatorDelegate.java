package com.google.android.material.progressindicator;

/* loaded from: classes22.dex */
final class CircularIndeterminateAnimatorDelegate extends com.google.android.material.progressindicator.IndeterminateAnimatorDelegate<android.animation.ObjectAnimator> {
    private static final int CONSTANT_ROTATION_DEGREES = 1520;
    private static final int DURATION_TO_COLLAPSE_IN_MS = 667;
    private static final int DURATION_TO_COMPLETE_END_IN_MS = 333;
    private static final int DURATION_TO_EXPAND_IN_MS = 667;
    private static final int DURATION_TO_FADE_IN_MS = 333;
    private static final int EXTRA_DEGREES_PER_CYCLE = 250;
    private static final int TAIL_DEGREES_OFFSET = -20;
    private static final int TOTAL_CYCLES = 4;
    private static final int TOTAL_DURATION_IN_MS = 5400;
    private float animationFraction;
    private android.animation.ObjectAnimator animator;
    androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private final com.google.android.material.progressindicator.BaseProgressIndicatorSpec baseSpec;
    private android.animation.ObjectAnimator completeEndAnimator;
    private float completeEndFraction;
    private int indicatorColorIndexOffset;
    private final androidx.interpolator.view.animation.FastOutSlowInInterpolator interpolator;
    private static final int[] DELAY_TO_EXPAND_IN_MS = {0, 1350, 2700, 4050};
    private static final int[] DELAY_TO_COLLAPSE_IN_MS = {667, com.autonavi.base.amap.mapcore.tools.GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_MARK, 3367, 4717};
    private static final int[] DELAY_TO_FADE_IN_MS = {1000, 2350, 3700, 5050};
    private static final android.util.Property<com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate, java.lang.Float> ANIMATION_FRACTION = new com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.AnonymousClass3(java.lang.Float.class, "animationFraction");
    private static final android.util.Property<com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate, java.lang.Float> COMPLETE_END_FRACTION = new com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.AnonymousClass4(java.lang.Float.class, "completeEndFraction");

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
            super.onAnimationRepeat(animator);
            com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.this;
            circularIndeterminateAnimatorDelegate.indicatorColorIndexOffset = (circularIndeterminateAnimatorDelegate.indicatorColorIndexOffset + 4) % com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.this.baseSpec.indicatorColors.length;
        }
    }

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$2, reason: invalid class name */
    public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.this.cancelAnimatorImmediately();
            com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.this;
            circularIndeterminateAnimatorDelegate.animatorCompleteCallback.onAnimationEnd(circularIndeterminateAnimatorDelegate.drawable);
        }
    }

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$3, reason: invalid class name */
    public static class AnonymousClass3 extends android.util.Property<com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate, java.lang.Float> {
        public AnonymousClass3(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public java.lang.Float get(com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return java.lang.Float.valueOf(circularIndeterminateAnimatorDelegate.getAnimationFraction());
        }

        @Override // android.util.Property
        public void set(com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, java.lang.Float f) {
            circularIndeterminateAnimatorDelegate.setAnimationFraction(f.floatValue());
        }
    }

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$4, reason: invalid class name */
    public static class AnonymousClass4 extends android.util.Property<com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate, java.lang.Float> {
        public AnonymousClass4(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public java.lang.Float get(com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return java.lang.Float.valueOf(circularIndeterminateAnimatorDelegate.getCompleteEndFraction());
        }

        @Override // android.util.Property
        public void set(com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, java.lang.Float f) {
            circularIndeterminateAnimatorDelegate.setCompleteEndFraction(f.floatValue());
        }
    }

    public CircularIndeterminateAnimatorDelegate(@androidx.annotation.NonNull com.google.android.material.progressindicator.CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.indicatorColorIndexOffset = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = circularProgressIndicatorSpec;
        this.interpolator = new androidx.interpolator.view.animation.FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getAnimationFraction() {
        return this.animationFraction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCompleteEndFraction() {
        return this.completeEndFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator = ofFloat;
            ofFloat.setDuration(5400L);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.AnonymousClass1());
        }
        if (this.completeEndAnimator == null) {
            android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this, COMPLETE_END_FRACTION, 0.0f, 1.0f);
            this.completeEndAnimator = ofFloat2;
            ofFloat2.setDuration(333L);
            this.completeEndAnimator.setInterpolator(this.interpolator);
            this.completeEndAnimator.addListener(new com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.AnonymousClass2());
        }
    }

    private void maybeUpdateSegmentColors(int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            float fractionInRange = getFractionInRange(i, DELAY_TO_FADE_IN_MS[i2], com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID);
            if (fractionInRange >= 0.0f && fractionInRange <= 1.0f) {
                int i3 = i2 + this.indicatorColorIndexOffset;
                int[] iArr = this.baseSpec.indicatorColors;
                int length = i3 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int compositeARGBWithAlpha = com.google.android.material.color.MaterialColors.compositeARGBWithAlpha(iArr[length], this.drawable.getAlpha());
                int compositeARGBWithAlpha2 = com.google.android.material.color.MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[length2], this.drawable.getAlpha());
                this.segmentColors[0] = com.google.android.material.animation.ArgbEvaluatorCompat.getInstance().evaluate(this.interpolator.getInterpolation(fractionInRange), java.lang.Integer.valueOf(compositeARGBWithAlpha), java.lang.Integer.valueOf(compositeARGBWithAlpha2)).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompleteEndFraction(float f) {
        this.completeEndFraction = f;
    }

    private void updateSegmentPositions(int i) {
        float[] fArr = this.segmentPositions;
        float f = this.animationFraction;
        fArr[0] = (f * 1520.0f) - 20.0f;
        fArr[1] = f * 1520.0f;
        for (int i2 = 0; i2 < 4; i2++) {
            float fractionInRange = getFractionInRange(i, DELAY_TO_EXPAND_IN_MS[i2], 667);
            float[] fArr2 = this.segmentPositions;
            fArr2[1] = fArr2[1] + (this.interpolator.getInterpolation(fractionInRange) * 250.0f);
            float fractionInRange2 = getFractionInRange(i, DELAY_TO_COLLAPSE_IN_MS[i2], 667);
            float[] fArr3 = this.segmentPositions;
            fArr3[0] = fArr3[0] + (this.interpolator.getInterpolation(fractionInRange2) * 250.0f);
        }
        float[] fArr4 = this.segmentPositions;
        float f2 = fArr4[0];
        float f3 = fArr4[1];
        float f4 = f2 + ((f3 - f2) * this.completeEndFraction);
        fArr4[0] = f4;
        fArr4[0] = f4 / 360.0f;
        fArr4[1] = f3 / 360.0f;
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
        if (this.completeEndAnimator.isRunning()) {
            return;
        }
        if (this.drawable.isVisible()) {
            this.completeEndAnimator.start();
        } else {
            cancelAnimatorImmediately();
        }
    }

    @androidx.annotation.VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        this.segmentColors[0] = com.google.android.material.color.MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        this.completeEndFraction = 0.0f;
    }

    @androidx.annotation.VisibleForTesting
    public void setAnimationFraction(float f) {
        this.animationFraction = f;
        int i = (int) (f * 5400.0f);
        updateSegmentPositions(i);
        maybeUpdateSegmentColors(i);
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
