package com.google.android.material.floatingactionbutton;

/* loaded from: classes22.dex */
class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    private static final float HIDE_ICON_SCALE = 0.0f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.0f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;

    @androidx.annotation.Nullable
    com.google.android.material.floatingactionbutton.BorderDrawable borderDrawable;

    @androidx.annotation.Nullable
    android.graphics.drawable.Drawable contentBackground;

    @androidx.annotation.Nullable
    private android.animation.Animator currentAnimator;

    @androidx.annotation.Nullable
    private com.google.android.material.animation.MotionSpec defaultHideMotionSpec;

    @androidx.annotation.Nullable
    private com.google.android.material.animation.MotionSpec defaultShowMotionSpec;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private java.util.ArrayList<android.animation.Animator.AnimatorListener> hideListeners;

    @androidx.annotation.Nullable
    private com.google.android.material.animation.MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    private int maxImageSize;
    int minTouchTargetSize;

    @androidx.annotation.Nullable
    private android.view.ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;

    @androidx.annotation.Nullable
    android.graphics.drawable.Drawable rippleDrawable;
    private float rotation;
    final com.google.android.material.shadow.ShadowViewDelegate shadowViewDelegate;

    @androidx.annotation.Nullable
    com.google.android.material.shape.ShapeAppearanceModel shapeAppearance;

    @androidx.annotation.Nullable
    com.google.android.material.shape.MaterialShapeDrawable shapeDrawable;
    private java.util.ArrayList<android.animation.Animator.AnimatorListener> showListeners;

    @androidx.annotation.Nullable
    private com.google.android.material.animation.MotionSpec showMotionSpec;

    @androidx.annotation.NonNull
    private final com.google.android.material.internal.StateListAnimator stateListAnimator;
    private java.util.ArrayList<com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback> transformationCallbacks;
    final com.google.android.material.floatingactionbutton.FloatingActionButton view;
    static final android.animation.TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = com.google.android.material.animation.AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    static final int[] PRESSED_ENABLED_STATE_SET = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] FOCUSED_ENABLED_STATE_SET = {android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] HOVERED_ENABLED_STATE_SET = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    static final int[] ENABLED_STATE_SET = {android.R.attr.state_enabled};
    static final int[] EMPTY_STATE_SET = new int[0];
    boolean shadowPaddingEnabled = true;
    private float imageMatrixScale = 1.0f;
    private int animState = 0;
    private final android.graphics.Rect tmpRect = new android.graphics.Rect();
    private final android.graphics.RectF tmpRectF1 = new android.graphics.RectF();
    private final android.graphics.RectF tmpRectF2 = new android.graphics.RectF();
    private final android.graphics.Matrix tmpMatrix = new android.graphics.Matrix();

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        private boolean cancelled;
        final /* synthetic */ boolean val$fromUser;
        final /* synthetic */ com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener val$listener;

        public AnonymousClass1(boolean z, com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener) {
            this.val$fromUser = z;
            this.val$listener = internalVisibilityChangedListener;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.cancelled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.animState = 0;
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.currentAnimator = null;
            if (this.cancelled) {
                return;
            }
            com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.view;
            boolean z = this.val$fromUser;
            floatingActionButton.internalSetVisibility(z ? 8 : 4, z);
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener = this.val$listener;
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onHidden();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.animState = 1;
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.currentAnimator = animator;
            this.cancelled = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$2, reason: invalid class name */
    public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ boolean val$fromUser;
        final /* synthetic */ com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener val$listener;

        public AnonymousClass2(boolean z, com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener) {
            this.val$fromUser = z;
            this.val$listener = internalVisibilityChangedListener;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.animState = 0;
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.currentAnimator = null;
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener = this.val$listener;
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onShown();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.animState = 2;
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.currentAnimator = animator;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.android.material.animation.MatrixEvaluator {
        public AnonymousClass3() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
        public android.graphics.Matrix evaluate(float f, @androidx.annotation.NonNull android.graphics.Matrix matrix, @androidx.annotation.NonNull android.graphics.Matrix matrix2) {
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.imageMatrixScale = f;
            return super.evaluate(f, matrix, matrix2);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements android.animation.TypeEvaluator<java.lang.Float> {
        android.animation.FloatEvaluator floatEvaluator = new android.animation.FloatEvaluator();

        public AnonymousClass4() {
        }

        @Override // android.animation.TypeEvaluator
        public java.lang.Float evaluate(float f, java.lang.Float f2, java.lang.Float f3) {
            float floatValue = this.floatEvaluator.evaluate(f, (java.lang.Number) f2, (java.lang.Number) f3).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return java.lang.Float.valueOf(floatValue);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.ViewTreeObserver.OnPreDrawListener {
        public AnonymousClass5() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.onPreDraw();
            return true;
        }
    }

    public class DisabledElevationAnimation extends com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl {
        public DisabledElevationAnimation() {
            super(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return 0.0f;
        }
    }

    public class ElevateToHoveredFocusedTranslationZAnimation extends com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl {
        public ElevateToHoveredFocusedTranslationZAnimation() {
            super(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl floatingActionButtonImpl = com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.hoveredFocusedTranslationZ;
        }
    }

    public class ElevateToPressedTranslationZAnimation extends com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl {
        public ElevateToPressedTranslationZAnimation() {
            super(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl floatingActionButtonImpl = com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.pressedTranslationZ;
        }
    }

    public interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    public interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    public class ResetElevationAnimation extends com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl {
        public ResetElevationAnimation() {
            super(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.elevation;
        }
    }

    public abstract class ShadowAnimatorImpl extends android.animation.AnimatorListenerAdapter implements android.animation.ValueAnimator.AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        private boolean validValues;

        private ShadowAnimatorImpl() {
        }

        public /* synthetic */ ShadowAnimatorImpl(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl floatingActionButtonImpl, com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.AnonymousClass1 anonymousClass1) {
            this();
        }

        public abstract float getTargetShadowSize();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.updateShapeElevation((int) this.shadowSizeEnd);
            this.validValues = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            if (!this.validValues) {
                com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this.shapeDrawable;
                this.shadowSizeStart = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.getElevation();
                this.shadowSizeEnd = getTargetShadowSize();
                this.validValues = true;
            }
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl floatingActionButtonImpl = com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.this;
            float f = this.shadowSizeStart;
            floatingActionButtonImpl.updateShapeElevation((int) (f + ((this.shadowSizeEnd - f) * valueAnimator.getAnimatedFraction())));
        }
    }

    public FloatingActionButtonImpl(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, com.google.android.material.shadow.ShadowViewDelegate shadowViewDelegate) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate;
        com.google.android.material.internal.StateListAnimator stateListAnimator = new com.google.android.material.internal.StateListAnimator();
        this.stateListAnimator = stateListAnimator;
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ElevateToPressedTranslationZAnimation()));
        stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ResetElevationAnimation()));
        stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.DisabledElevationAnimation()));
        this.rotation = floatingActionButton.getRotation();
    }

    private void calculateImageMatrixFromScale(float f, @androidx.annotation.NonNull android.graphics.Matrix matrix) {
        matrix.reset();
        if (this.view.getDrawable() == null || this.maxImageSize == 0) {
            return;
        }
        android.graphics.RectF rectF = this.tmpRectF1;
        android.graphics.RectF rectF2 = this.tmpRectF2;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i = this.maxImageSize;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.CENTER);
        int i2 = this.maxImageSize;
        matrix.postScale(f, f, i2 / 2.0f, i2 / 2.0f);
    }

    @androidx.annotation.NonNull
    private android.animation.AnimatorSet createAnimator(@androidx.annotation.NonNull com.google.android.material.animation.MotionSpec motionSpec, float f, float f2, float f3) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this.view, (android.util.Property<com.google.android.material.floatingactionbutton.FloatingActionButton, java.lang.Float>) android.view.View.ALPHA, f);
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.view, (android.util.Property<com.google.android.material.floatingactionbutton.FloatingActionButton, java.lang.Float>) android.view.View.SCALE_X, f2);
        motionSpec.getTiming("scale").apply(ofFloat2);
        workAroundOreoBug(ofFloat2);
        arrayList.add(ofFloat2);
        android.animation.ObjectAnimator ofFloat3 = android.animation.ObjectAnimator.ofFloat(this.view, (android.util.Property<com.google.android.material.floatingactionbutton.FloatingActionButton, java.lang.Float>) android.view.View.SCALE_Y, f2);
        motionSpec.getTiming("scale").apply(ofFloat3);
        workAroundOreoBug(ofFloat3);
        arrayList.add(ofFloat3);
        calculateImageMatrixFromScale(f3, this.tmpMatrix);
        android.animation.ObjectAnimator ofObject = android.animation.ObjectAnimator.ofObject(this.view, new com.google.android.material.animation.ImageMatrixProperty(), new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.AnonymousClass3(), new android.graphics.Matrix(this.tmpMatrix));
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        com.google.android.material.animation.AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    @androidx.annotation.NonNull
    private android.animation.ValueAnimator createElevationAnimator(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl shadowAnimatorImpl) {
        android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
        valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private com.google.android.material.animation.MotionSpec getDefaultHideMotionSpec() {
        if (this.defaultHideMotionSpec == null) {
            this.defaultHideMotionSpec = com.google.android.material.animation.MotionSpec.createFromResource(this.view.getContext(), com.google.android.material.R.animator.design_fab_hide_motion_spec);
        }
        return (com.google.android.material.animation.MotionSpec) androidx.core.util.Preconditions.checkNotNull(this.defaultHideMotionSpec);
    }

    private com.google.android.material.animation.MotionSpec getDefaultShowMotionSpec() {
        if (this.defaultShowMotionSpec == null) {
            this.defaultShowMotionSpec = com.google.android.material.animation.MotionSpec.createFromResource(this.view.getContext(), com.google.android.material.R.animator.design_fab_show_motion_spec);
        }
        return (com.google.android.material.animation.MotionSpec) androidx.core.util.Preconditions.checkNotNull(this.defaultShowMotionSpec);
    }

    @androidx.annotation.NonNull
    private android.view.ViewTreeObserver.OnPreDrawListener getOrCreatePreDrawListener() {
        if (this.preDrawListener == null) {
            this.preDrawListener = new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.AnonymousClass5();
        }
        return this.preDrawListener;
    }

    private boolean shouldAnimateVisibilityChange() {
        return androidx.core.view.ViewCompat.isLaidOut(this.view) && !this.view.isInEditMode();
    }

    private void workAroundOreoBug(android.animation.ObjectAnimator objectAnimator) {
        if (android.os.Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.AnonymousClass4());
    }

    public void addOnHideAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            this.hideListeners = new java.util.ArrayList<>();
        }
        this.hideListeners.add(animatorListener);
    }

    public void addOnShowAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            this.showListeners = new java.util.ArrayList<>();
        }
        this.showListeners.add(animatorListener);
    }

    public void addTransformationCallback(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback internalTransformationCallback) {
        if (this.transformationCallbacks == null) {
            this.transformationCallbacks = new java.util.ArrayList<>();
        }
        this.transformationCallbacks.add(internalTransformationCallback);
    }

    public com.google.android.material.shape.MaterialShapeDrawable createShapeDrawable() {
        return new com.google.android.material.shape.MaterialShapeDrawable((com.google.android.material.shape.ShapeAppearanceModel) androidx.core.util.Preconditions.checkNotNull(this.shapeAppearance));
    }

    @androidx.annotation.Nullable
    public final android.graphics.drawable.Drawable getContentBackground() {
        return this.contentBackground;
    }

    public float getElevation() {
        return this.elevation;
    }

    public boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    @androidx.annotation.Nullable
    public final com.google.android.material.animation.MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    public void getPadding(@androidx.annotation.NonNull android.graphics.Rect rect) {
        int sizeDimension = this.ensureMinTouchTargetSize ? (this.minTouchTargetSize - this.view.getSizeDimension()) / 2 : 0;
        int max = java.lang.Math.max(sizeDimension, (int) java.lang.Math.ceil(this.shadowPaddingEnabled ? getElevation() + this.pressedTranslationZ : 0.0f));
        int max2 = java.lang.Math.max(sizeDimension, (int) java.lang.Math.ceil(r1 * SHADOW_MULTIPLIER));
        rect.set(max, max2, max, max2);
    }

    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    @androidx.annotation.Nullable
    public final com.google.android.material.shape.ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    @androidx.annotation.Nullable
    public final com.google.android.material.animation.MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public void hide(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z) {
        if (isOrWillBeHidden()) {
            return;
        }
        android.animation.Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (!shouldAnimateVisibilityChange()) {
            this.view.internalSetVisibility(z ? 8 : 4, z);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onHidden();
                return;
            }
            return;
        }
        com.google.android.material.animation.MotionSpec motionSpec = this.hideMotionSpec;
        if (motionSpec == null) {
            motionSpec = getDefaultHideMotionSpec();
        }
        android.animation.AnimatorSet createAnimator = createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
        createAnimator.addListener(new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.AnonymousClass1(z, internalVisibilityChangedListener));
        java.util.ArrayList<android.animation.Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList != null) {
            java.util.Iterator<android.animation.Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                createAnimator.addListener(it.next());
            }
        }
        createAnimator.start();
    }

    public void initializeBackgroundDrawable(android.content.res.ColorStateList colorStateList, @androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode, android.content.res.ColorStateList colorStateList2, int i) {
        com.google.android.material.shape.MaterialShapeDrawable createShapeDrawable = createShapeDrawable();
        this.shapeDrawable = createShapeDrawable;
        createShapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.setShadowColor(-12303292);
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        com.google.android.material.ripple.RippleDrawableCompat rippleDrawableCompat = new com.google.android.material.ripple.RippleDrawableCompat(this.shapeDrawable.getShapeAppearanceModel());
        rippleDrawableCompat.setTintList(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(colorStateList2));
        this.rippleDrawable = rippleDrawableCompat;
        this.contentBackground = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{(android.graphics.drawable.Drawable) androidx.core.util.Preconditions.checkNotNull(this.shapeDrawable), rippleDrawableCompat});
    }

    public boolean isOrWillBeHidden() {
        return this.view.getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    public boolean isOrWillBeShown() {
        return this.view.getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    public void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    public void onAttachedToWindow() {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this.view, materialShapeDrawable);
        }
        if (requirePreDrawListener()) {
            this.view.getViewTreeObserver().addOnPreDrawListener(getOrCreatePreDrawListener());
        }
    }

    public void onCompatShadowChanged() {
    }

    public void onDetachedFromWindow() {
        android.view.ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
        android.view.ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.preDrawListener = null;
        }
    }

    public void onDrawableStateChanged(int[] iArr) {
        this.stateListAnimator.setState(iArr);
    }

    public void onElevationsChanged(float f, float f2, float f3) {
        updatePadding();
        updateShapeElevation(f);
    }

    public void onPaddingUpdated(@androidx.annotation.NonNull android.graphics.Rect rect) {
        androidx.core.util.Preconditions.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (!shouldAddPadding()) {
            this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
        } else {
            this.shadowViewDelegate.setBackgroundDrawable(new android.graphics.drawable.InsetDrawable(this.contentBackground, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    public void onPreDraw() {
        float rotation = this.view.getRotation();
        if (this.rotation != rotation) {
            this.rotation = rotation;
            updateFromViewRotation();
        }
    }

    public void onScaleChanged() {
        java.util.ArrayList<com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            java.util.Iterator<com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScaleChanged();
            }
        }
    }

    public void onTranslationChanged() {
        java.util.ArrayList<com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            java.util.Iterator<com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTranslationChanged();
            }
        }
    }

    public void removeOnHideAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        java.util.ArrayList<android.animation.Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeOnShowAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        java.util.ArrayList<android.animation.Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeTransformationCallback(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback internalTransformationCallback) {
        java.util.ArrayList<com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(internalTransformationCallback);
    }

    public boolean requirePreDrawListener() {
        return true;
    }

    public void setBackgroundTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.BorderDrawable borderDrawable = this.borderDrawable;
        if (borderDrawable != null) {
            borderDrawable.setBorderTint(colorStateList);
        }
    }

    public void setBackgroundTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    public final void setElevation(float f) {
        if (this.elevation != f) {
            this.elevation = f;
            onElevationsChanged(f, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.ensureMinTouchTargetSize = z;
    }

    public final void setHideMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public final void setHoveredFocusedTranslationZ(float f) {
        if (this.hoveredFocusedTranslationZ != f) {
            this.hoveredFocusedTranslationZ = f;
            onElevationsChanged(this.elevation, f, this.pressedTranslationZ);
        }
    }

    public final void setImageMatrixScale(float f) {
        this.imageMatrixScale = f;
        android.graphics.Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f, matrix);
        this.view.setImageMatrix(matrix);
    }

    public final void setMaxImageSize(int i) {
        if (this.maxImageSize != i) {
            this.maxImageSize = i;
            updateImageMatrixScale();
        }
    }

    public void setMinTouchTargetSize(int i) {
        this.minTouchTargetSize = i;
    }

    public final void setPressedTranslationZ(float f) {
        if (this.pressedTranslationZ != f) {
            this.pressedTranslationZ = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, f);
        }
    }

    public void setRippleColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        android.graphics.drawable.Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    public void setShadowPaddingEnabled(boolean z) {
        this.shadowPaddingEnabled = z;
        updatePadding();
    }

    public final void setShapeAppearance(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearance = shapeAppearanceModel;
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        java.lang.Object obj = this.rippleDrawable;
        if (obj instanceof com.google.android.material.shape.Shapeable) {
            ((com.google.android.material.shape.Shapeable) obj).setShapeAppearanceModel(shapeAppearanceModel);
        }
        com.google.android.material.floatingactionbutton.BorderDrawable borderDrawable = this.borderDrawable;
        if (borderDrawable != null) {
            borderDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public final void setShowMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public boolean shouldAddPadding() {
        return true;
    }

    public final boolean shouldExpandBoundsForA11y() {
        return !this.ensureMinTouchTargetSize || this.view.getSizeDimension() >= this.minTouchTargetSize;
    }

    public void show(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z) {
        if (isOrWillBeShown()) {
            return;
        }
        android.animation.Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (!shouldAnimateVisibilityChange()) {
            this.view.internalSetVisibility(0, z);
            this.view.setAlpha(1.0f);
            this.view.setScaleY(1.0f);
            this.view.setScaleX(1.0f);
            setImageMatrixScale(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onShown();
                return;
            }
            return;
        }
        if (this.view.getVisibility() != 0) {
            this.view.setAlpha(0.0f);
            this.view.setScaleY(0.0f);
            this.view.setScaleX(0.0f);
            setImageMatrixScale(0.0f);
        }
        com.google.android.material.animation.MotionSpec motionSpec = this.showMotionSpec;
        if (motionSpec == null) {
            motionSpec = getDefaultShowMotionSpec();
        }
        android.animation.AnimatorSet createAnimator = createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
        createAnimator.addListener(new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.AnonymousClass2(z, internalVisibilityChangedListener));
        java.util.ArrayList<android.animation.Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList != null) {
            java.util.Iterator<android.animation.Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                createAnimator.addListener(it.next());
            }
        }
        createAnimator.start();
    }

    public void updateFromViewRotation() {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShadowCompatRotation((int) this.rotation);
        }
    }

    public final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    public final void updatePadding() {
        android.graphics.Rect rect = this.tmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        this.shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void updateShapeElevation(float f) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f);
        }
    }
}
