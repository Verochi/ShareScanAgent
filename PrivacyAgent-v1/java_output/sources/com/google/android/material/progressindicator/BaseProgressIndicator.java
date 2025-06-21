package com.google.android.material.progressindicator;

/* loaded from: classes22.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.BaseProgressIndicatorSpec> extends android.widget.ProgressBar {
    static final float DEFAULT_OPACITY = 0.2f;
    static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_ProgressIndicator;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    static final int MAX_ALPHA = 255;
    static final int MAX_HIDE_DELAY = 1000;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;
    com.google.android.material.progressindicator.AnimatorDurationScaleProvider animatorDurationScaleProvider;
    private final java.lang.Runnable delayedHide;
    private final java.lang.Runnable delayedShow;
    private final androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback hideAnimationCallback;
    private boolean isIndeterminateModeChangeRequested;
    private boolean isParentDoneInitializing;
    private long lastShowStartTime;
    private final int minHideDelay;
    private final int showDelay;
    S spec;
    private int storedProgress;
    private boolean storedProgressAnimated;
    private final androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback switchIndeterminateModeCallback;
    private int visibilityAfterHide;

    /* renamed from: com.google.android.material.progressindicator.BaseProgressIndicator$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.progressindicator.BaseProgressIndicator.this.internalShow();
        }
    }

    /* renamed from: com.google.android.material.progressindicator.BaseProgressIndicator$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.progressindicator.BaseProgressIndicator.this.internalHide();
            com.google.android.material.progressindicator.BaseProgressIndicator.this.lastShowStartTime = -1L;
        }
    }

    /* renamed from: com.google.android.material.progressindicator.BaseProgressIndicator$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback {
        public AnonymousClass3() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(android.graphics.drawable.Drawable drawable) {
            com.google.android.material.progressindicator.BaseProgressIndicator.this.setIndeterminate(false);
            com.google.android.material.progressindicator.BaseProgressIndicator.this.setProgressCompat(0, false);
            com.google.android.material.progressindicator.BaseProgressIndicator baseProgressIndicator = com.google.android.material.progressindicator.BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.storedProgress, com.google.android.material.progressindicator.BaseProgressIndicator.this.storedProgressAnimated);
        }
    }

    /* renamed from: com.google.android.material.progressindicator.BaseProgressIndicator$4, reason: invalid class name */
    public class AnonymousClass4 extends androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback {
        public AnonymousClass4() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(android.graphics.drawable.Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (com.google.android.material.progressindicator.BaseProgressIndicator.this.isIndeterminateModeChangeRequested) {
                return;
            }
            com.google.android.material.progressindicator.BaseProgressIndicator baseProgressIndicator = com.google.android.material.progressindicator.BaseProgressIndicator.this;
            baseProgressIndicator.setVisibility(baseProgressIndicator.visibilityAfterHide);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface HideAnimationBehavior {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ShowAnimationBehavior {
    }

    public BaseProgressIndicator(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.lastShowStartTime = -1L;
        this.isIndeterminateModeChangeRequested = false;
        this.visibilityAfterHide = 4;
        this.delayedShow = new com.google.android.material.progressindicator.BaseProgressIndicator.AnonymousClass1();
        this.delayedHide = new com.google.android.material.progressindicator.BaseProgressIndicator.AnonymousClass2();
        this.switchIndeterminateModeCallback = new com.google.android.material.progressindicator.BaseProgressIndicator.AnonymousClass3();
        this.hideAnimationCallback = new com.google.android.material.progressindicator.BaseProgressIndicator.AnonymousClass4();
        android.content.Context context2 = getContext();
        this.spec = createSpec(context2, attributeSet);
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.BaseProgressIndicator, i, i2, new int[0]);
        this.showDelay = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.BaseProgressIndicator_showDelay, -1);
        this.minHideDelay = java.lang.Math.min(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        obtainStyledAttributes.recycle();
        this.animatorDurationScaleProvider = new com.google.android.material.progressindicator.AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    @androidx.annotation.Nullable
    private com.google.android.material.progressindicator.DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().getDrawingDelegate();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().getDrawingDelegate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalHide() {
        ((com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, true);
        if (isNoLongerNeedToBeVisible()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalShow() {
        if (this.minHideDelay > 0) {
            this.lastShowStartTime = android.os.SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean isNoLongerNeedToBeVisible() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void registerAnimationCallbacks() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().getAnimatorDelegate().registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
    }

    private void unregisterAnimationCallbacks() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
            getIndeterminateDrawable().getAnimatorDelegate().unregisterAnimatorsCompleteCallback();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        }
    }

    public void applyNewVisibility(boolean z) {
        if (this.isParentDoneInitializing) {
            ((com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, z);
        }
    }

    public abstract S createSpec(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet);

    @Override // android.widget.ProgressBar
    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    @Override // android.widget.ProgressBar
    @androidx.annotation.Nullable
    public com.google.android.material.progressindicator.IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (com.google.android.material.progressindicator.IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @androidx.annotation.NonNull
    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    @Override // android.widget.ProgressBar
    @androidx.annotation.Nullable
    public com.google.android.material.progressindicator.DeterminateDrawable<S> getProgressDrawable() {
        return (com.google.android.material.progressindicator.DeterminateDrawable) super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    @androidx.annotation.ColorInt
    public int getTrackColor() {
        return this.spec.trackColor;
    }

    @androidx.annotation.Px
    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    @androidx.annotation.Px
    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    public void hide() {
        if (getVisibility() != 0) {
            removeCallbacks(this.delayedShow);
            return;
        }
        removeCallbacks(this.delayedHide);
        long uptimeMillis = android.os.SystemClock.uptimeMillis() - this.lastShowStartTime;
        int i = this.minHideDelay;
        if (uptimeMillis >= ((long) i)) {
            this.delayedHide.run();
        } else {
            postDelayed(this.delayedHide, i - uptimeMillis);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public boolean isEffectivelyVisible() {
        android.view.View view = this;
        while (view.getVisibility() == 0) {
            java.lang.Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof android.view.View)) {
                return true;
            }
            view = (android.view.View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerAnimationCallbacks();
        if (visibleToUser()) {
            internalShow();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        com.google.android.material.progressindicator.DrawingDelegate<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate == null) {
            return;
        }
        int preferredWidth = currentDrawingDelegate.getPreferredWidth();
        int preferredHeight = currentDrawingDelegate.getPreferredHeight();
        setMeasuredDimension(preferredWidth < 0 ? getMeasuredWidth() : preferredWidth + getPaddingLeft() + getPaddingRight(), preferredHeight < 0 ? getMeasuredHeight() : preferredHeight + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public void onVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        applyNewVisibility(i == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        applyNewVisibility(false);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    @androidx.annotation.VisibleForTesting
    public void setAnimatorDurationScaleProvider(@androidx.annotation.NonNull com.google.android.material.progressindicator.AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.animatorDurationScaleProvider = animatorDurationScaleProvider;
        if (getProgressDrawable() != null) {
            getProgressDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider;
        }
    }

    public void setHideAnimationBehavior(int i) {
        this.spec.hideAnimationBehavior = i;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        if (z == isIndeterminate()) {
            return;
        }
        if (visibleToUser() && z) {
            throw new java.lang.IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
        }
        com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
        if (drawableWithAnimatedVisibilityChange != null) {
            drawableWithAnimatedVisibilityChange.hideNow();
        }
        super.setIndeterminate(z);
        com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
        if (drawableWithAnimatedVisibilityChange2 != null) {
            drawableWithAnimatedVisibilityChange2.setVisible(visibleToUser(), false, false);
        }
        this.isIndeterminateModeChangeRequested = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof com.google.android.material.progressindicator.IndeterminateDrawable)) {
                throw new java.lang.IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange) drawable).hideNow();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(@androidx.annotation.ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{com.google.android.material.color.MaterialColors.getColor(getContext(), com.google.android.material.R.attr.colorPrimary, -1)};
        }
        if (java.util.Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.spec.indicatorColors = iArr;
        getIndeterminateDrawable().getAnimatorDelegate().invalidateSpecValues();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i, false);
    }

    public void setProgressCompat(int i, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i);
            if (getProgressDrawable() == null || z) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.storedProgress = i;
            this.storedProgressAnimated = z;
            this.isIndeterminateModeChangeRequested = true;
            if (!getIndeterminateDrawable().isVisible() || this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(getContext().getContentResolver()) == 0.0f) {
                this.switchIndeterminateModeCallback.onAnimationEnd(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().getAnimatorDelegate().requestCancelAnimatorAfterCurrentCycle();
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof com.google.android.material.progressindicator.DeterminateDrawable)) {
                throw new java.lang.IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            com.google.android.material.progressindicator.DeterminateDrawable determinateDrawable = (com.google.android.material.progressindicator.DeterminateDrawable) drawable;
            determinateDrawable.hideNow();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.setLevelByFraction(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i) {
        this.spec.showAnimationBehavior = i;
        invalidate();
    }

    public void setTrackColor(@androidx.annotation.ColorInt int i) {
        S s2 = this.spec;
        if (s2.trackColor != i) {
            s2.trackColor = i;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@androidx.annotation.Px int i) {
        S s2 = this.spec;
        if (s2.trackCornerRadius != i) {
            s2.trackCornerRadius = java.lang.Math.min(i, s2.trackThickness / 2);
        }
    }

    public void setTrackThickness(@androidx.annotation.Px int i) {
        S s2 = this.spec;
        if (s2.trackThickness != i) {
            s2.trackThickness = i;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i) {
        if (i != 0 && i != 4 && i != 8) {
            throw new java.lang.IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.visibilityAfterHide = i;
    }

    public void show() {
        if (this.showDelay <= 0) {
            this.delayedShow.run();
        } else {
            removeCallbacks(this.delayedShow);
            postDelayed(this.delayedShow, this.showDelay);
        }
    }

    public boolean visibleToUser() {
        return androidx.core.view.ViewCompat.isAttachedToWindow(this) && getWindowVisibility() == 0 && isEffectivelyVisible();
    }
}
