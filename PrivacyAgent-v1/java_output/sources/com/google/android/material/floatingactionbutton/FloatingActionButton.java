package com.google.android.material.floatingactionbutton;

/* loaded from: classes22.dex */
public class FloatingActionButton extends com.google.android.material.internal.VisibilityAwareImageButton implements androidx.core.view.TintableBackgroundView, androidx.core.widget.TintableImageSourceView, com.google.android.material.expandable.ExpandableTransformationWidget, com.google.android.material.shape.Shapeable, androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_FloatingActionButton;
    private static final java.lang.String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final java.lang.String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList backgroundTint;

    @androidx.annotation.Nullable
    private android.graphics.PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;

    @androidx.annotation.NonNull
    private final com.google.android.material.expandable.ExpandableWidgetHelper expandableWidgetHelper;

    @androidx.annotation.NonNull
    private final androidx.appcompat.widget.AppCompatImageHelper imageHelper;

    @androidx.annotation.Nullable
    private android.graphics.PorterDuff.Mode imageMode;
    private int imagePadding;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList imageTint;
    private com.google.android.material.floatingactionbutton.FloatingActionButtonImpl impl;
    private int maxImageSize;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList rippleColor;
    final android.graphics.Rect shadowPadding;
    private int size;
    private final android.graphics.Rect touchArea;

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener {
        final /* synthetic */ com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener val$listener;

        public AnonymousClass1(com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
            this.val$listener = onVisibilityChangedListener;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
        public void onHidden() {
            this.val$listener.onHidden(com.google.android.material.floatingactionbutton.FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
        public void onShown() {
            this.val$listener.onShown(com.google.android.material.floatingactionbutton.FloatingActionButton.this);
        }
    }

    public static class BaseBehavior<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> extends androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean autoHideEnabled;
        private com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener internalAutoHideListener;
        private android.graphics.Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        public BaseBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        private static boolean isBottomSheet(@androidx.annotation.NonNull android.view.View view) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) {
                return ((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof com.google.android.material.bottomsheet.BottomSheetBehavior;
            }
            return false;
        }

        private void offsetIfNeeded(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            android.graphics.Rect rect = floatingActionButton.shadowPadding;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i = 0;
            int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i = -rect.top;
            }
            if (i != 0) {
                androidx.core.view.ViewCompat.offsetTopAndBottom(floatingActionButton, i);
            }
            if (i2 != 0) {
                androidx.core.view.ViewCompat.offsetLeftAndRight(floatingActionButton, i2);
            }
        }

        private boolean shouldUpdateVisibility(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            return this.autoHideEnabled && ((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean updateFabVisibilityForAppBarLayout(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.appbar.AppBarLayout appBarLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new android.graphics.Rect();
            }
            android.graphics.Rect rect = this.tmpRect;
            com.google.android.material.internal.DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(this.internalAutoHideListener, false);
                return true;
            }
            floatingActionButton.show(this.internalAutoHideListener, false);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((android.view.ViewGroup.MarginLayoutParams) ((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.hide(this.internalAutoHideListener, false);
                return true;
            }
            floatingActionButton.show(this.internalAutoHideListener, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, @androidx.annotation.NonNull android.graphics.Rect rect) {
            android.graphics.Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, android.view.View view) {
            if (view instanceof com.google.android.material.appbar.AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (com.google.android.material.appbar.AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!isBottomSheet(view)) {
                return false;
            }
            updateFabVisibilityForBottomSheet(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, int i) {
            java.util.List<android.view.View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                android.view.View view = dependencies.get(i2);
                if (!(view instanceof com.google.android.material.appbar.AppBarLayout)) {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (com.google.android.material.appbar.AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            offsetIfNeeded(coordinatorLayout, floatingActionButton);
            return true;
        }

        public void setAutoHideEnabled(boolean z) {
            this.autoHideEnabled = z;
        }

        @androidx.annotation.VisibleForTesting
        public void setInternalAutoHideListener(com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
            this.internalAutoHideListener = onVisibilityChangedListener;
        }
    }

    public static class Behavior extends com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior<com.google.android.material.floatingactionbutton.FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, @androidx.annotation.NonNull android.graphics.Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams) {
            super.onAttachedToLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, android.view.View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, int i) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean z) {
            super.setAutoHideEnabled(z);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @androidx.annotation.VisibleForTesting
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
            super.setInternalAutoHideListener(onVisibilityChangedListener);
        }
    }

    public static abstract class OnVisibilityChangedListener {
        public void onHidden(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
        }

        public void onShown(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
        }
    }

    public class ShadowDelegateImpl implements com.google.android.material.shadow.ShadowViewDelegate {
        public ShadowDelegateImpl() {
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public float getRadius() {
            return com.google.android.material.floatingactionbutton.FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public boolean isCompatPaddingEnabled() {
            return com.google.android.material.floatingactionbutton.FloatingActionButton.this.compatPadding;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setBackgroundDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            if (drawable != null) {
                com.google.android.material.floatingactionbutton.FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setShadowPadding(int i, int i2, int i3, int i4) {
            com.google.android.material.floatingactionbutton.FloatingActionButton.this.shadowPadding.set(i, i2, i3, i4);
            com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = com.google.android.material.floatingactionbutton.FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.imagePadding, i2 + com.google.android.material.floatingactionbutton.FloatingActionButton.this.imagePadding, i3 + com.google.android.material.floatingactionbutton.FloatingActionButton.this.imagePadding, i4 + com.google.android.material.floatingactionbutton.FloatingActionButton.this.imagePadding);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Size {
    }

    public class TransformationCallbackWrapper<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> implements com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback {

        @androidx.annotation.NonNull
        private final com.google.android.material.animation.TransformationCallback<T> listener;

        public TransformationCallbackWrapper(@androidx.annotation.NonNull com.google.android.material.animation.TransformationCallback<T> transformationCallback) {
            this.listener = transformationCallback;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            return (obj instanceof com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper) && ((com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper) obj).listener.equals(this.listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onScaleChanged() {
            this.listener.onScaleChanged(com.google.android.material.floatingactionbutton.FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onTranslationChanged() {
            this.listener.onTranslationChanged(com.google.android.material.floatingactionbutton.FloatingActionButton.this);
        }
    }

    public FloatingActionButton(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public FloatingActionButton(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.floatingActionButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FloatingActionButton(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r6), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        this.shadowPadding = new android.graphics.Rect();
        this.touchArea = new android.graphics.Rect();
        android.content.Context context2 = getContext();
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.FloatingActionButton, i, i2, new int[0]);
        this.backgroundTint = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainStyledAttributes, com.google.android.material.R.styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = com.google.android.material.internal.ViewUtils.parseTintMode(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.rippleColor = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainStyledAttributes, com.google.android.material.R.styleable.FloatingActionButton_rippleColor);
        this.size = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.FloatingActionButton_fabSize, -1);
        this.customSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.compatPadding = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_fab_min_touch_target);
        this.maxImageSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.FloatingActionButton_maxImageSize, 0);
        com.google.android.material.animation.MotionSpec createFromAttribute = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, obtainStyledAttributes, com.google.android.material.R.styleable.FloatingActionButton_showMotionSpec);
        com.google.android.material.animation.MotionSpec createFromAttribute2 = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, obtainStyledAttributes, com.google.android.material.R.styleable.FloatingActionButton_hideMotionSpec);
        com.google.android.material.shape.ShapeAppearanceModel build = com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i, i2, com.google.android.material.shape.ShapeAppearanceModel.PILL).build();
        boolean z = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.FloatingActionButton_android_enabled, true));
        obtainStyledAttributes.recycle();
        androidx.appcompat.widget.AppCompatImageHelper appCompatImageHelper = new androidx.appcompat.widget.AppCompatImageHelper(this);
        this.imageHelper = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
        this.expandableWidgetHelper = new com.google.android.material.expandable.ExpandableWidgetHelper(this);
        getImpl().setShapeAppearance(build);
        getImpl().initializeBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().setMinTouchTargetSize(dimensionPixelSize);
        getImpl().setElevation(dimension);
        getImpl().setHoveredFocusedTranslationZ(dimension2);
        getImpl().setPressedTranslationZ(dimension3);
        getImpl().setMaxImageSize(this.maxImageSize);
        getImpl().setShowMotionSpec(createFromAttribute);
        getImpl().setHideMotionSpec(createFromAttribute2);
        getImpl().setEnsureMinTouchTargetSize(z);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    @androidx.annotation.NonNull
    private com.google.android.material.floatingactionbutton.FloatingActionButtonImpl createImpl() {
        return new com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop(this, new com.google.android.material.floatingactionbutton.FloatingActionButton.ShadowDelegateImpl());
    }

    private com.google.android.material.floatingactionbutton.FloatingActionButtonImpl getImpl() {
        if (this.impl == null) {
            this.impl = createImpl();
        }
        return this.impl;
    }

    private int getSizeDimension(int i) {
        int i2 = this.customSize;
        if (i2 != 0) {
            return i2;
        }
        android.content.res.Resources resources = getResources();
        return i != -1 ? i != 1 ? resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_fab_size_mini) : java.lang.Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < AUTO_MINI_LARGEST_SCREEN_WIDTH ? getSizeDimension(1) : getSizeDimension(0);
    }

    private void offsetRectWithShadow(@androidx.annotation.NonNull android.graphics.Rect rect) {
        int i = rect.left;
        android.graphics.Rect rect2 = this.shadowPadding;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void onApplySupportImageTint() {
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        android.content.res.ColorStateList colorStateList = this.imageTint;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        android.graphics.PorterDuff.Mode mode = this.imageMode;
        if (mode == null) {
            mode = android.graphics.PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return java.lang.Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new java.lang.IllegalArgumentException();
    }

    @androidx.annotation.Nullable
    private com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new com.google.android.material.floatingactionbutton.FloatingActionButton.AnonymousClass1(onVisibilityChangedListener);
    }

    public void addOnHideAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        getImpl().addOnHideAnimationListener(animatorListener);
    }

    public void addOnShowAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        getImpl().addOnShowAnimationListener(animatorListener);
    }

    public void addTransformationCallback(@androidx.annotation.NonNull com.google.android.material.animation.TransformationCallback<? extends com.google.android.material.floatingactionbutton.FloatingActionButton> transformationCallback) {
        getImpl().addTransformationCallback(new com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper(transformationCallback));
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
    }

    @Override // android.view.View
    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    @androidx.annotation.Nullable
    public android.graphics.PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @androidx.annotation.NonNull
    public androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<com.google.android.material.floatingactionbutton.FloatingActionButton> getBehavior() {
        return new com.google.android.material.floatingactionbutton.FloatingActionButton.Behavior();
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().getHoveredFocusedTranslationZ();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().getPressedTranslationZ();
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getContentBackground() {
        return getImpl().getContentBackground();
    }

    @java.lang.Deprecated
    public boolean getContentRect(@androidx.annotation.NonNull android.graphics.Rect rect) {
        if (!androidx.core.view.ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(rect);
        return true;
    }

    @androidx.annotation.Px
    public int getCustomSize() {
        return this.customSize;
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.getExpandedComponentIdHint();
    }

    @androidx.annotation.Nullable
    public com.google.android.material.animation.MotionSpec getHideMotionSpec() {
        return getImpl().getHideMotionSpec();
    }

    public void getMeasuredContentRect(@androidx.annotation.NonNull android.graphics.Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(rect);
    }

    @androidx.annotation.ColorInt
    @java.lang.Deprecated
    public int getRippleColor() {
        android.content.res.ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    @Override // com.google.android.material.shape.Shapeable
    @androidx.annotation.NonNull
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return (com.google.android.material.shape.ShapeAppearanceModel) androidx.core.util.Preconditions.checkNotNull(getImpl().getShapeAppearance());
    }

    @androidx.annotation.Nullable
    public com.google.android.material.animation.MotionSpec getShowMotionSpec() {
        return getImpl().getShowMotionSpec();
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @androidx.annotation.Nullable
    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @androidx.annotation.Nullable
    public android.graphics.PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide() {
        hide(null);
    }

    public void hide(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
        hide(onVisibilityChangedListener, true);
    }

    public void hide(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().hide(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z);
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean isExpanded() {
        return this.expandableWidgetHelper.isExpanded();
    }

    public boolean isOrWillBeHidden() {
        return getImpl().isOrWillBeHidden();
    }

    public boolean isOrWillBeShown() {
        return getImpl().isOrWillBeShown();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().jumpDrawableToCurrentState();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().updatePadding();
        int min = java.lang.Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        android.graphics.Rect rect = this.shadowPadding;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.stateful.ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.stateful.ExtendableSavedState extendableSavedState = (com.google.android.material.stateful.ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.expandableWidgetHelper.onRestoreInstanceState((android.os.Bundle) androidx.core.util.Preconditions.checkNotNull(extendableSavedState.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY)));
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        android.os.Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new android.os.Bundle();
        }
        com.google.android.material.stateful.ExtendableSavedState extendableSavedState = new com.google.android.material.stateful.ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.extendableStates.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.onSaveInstanceState());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getContentRect(this.touchArea) && !this.touchArea.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeOnHideAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        getImpl().removeOnHideAnimationListener(animatorListener);
    }

    public void removeOnShowAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        getImpl().removeOnShowAnimationListener(animatorListener);
    }

    public void removeTransformationCallback(@androidx.annotation.NonNull com.google.android.material.animation.TransformationCallback<? extends com.google.android.material.floatingactionbutton.FloatingActionButton> transformationCallback) {
        getImpl().removeTransformationCallback(new com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper(transformationCallback));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            getImpl().setBackgroundTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            getImpl().setBackgroundTintMode(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().setElevation(f);
    }

    public void setCompatElevationResource(@androidx.annotation.DimenRes int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().setHoveredFocusedTranslationZ(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(@androidx.annotation.DimenRes int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().setPressedTranslationZ(f);
    }

    public void setCompatPressedTranslationZResource(@androidx.annotation.DimenRes int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(@androidx.annotation.Px int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.customSize) {
            this.customSize = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    @androidx.annotation.RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        getImpl().updateShapeElevation(f);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().getEnsureMinTouchTargetSize()) {
            getImpl().setEnsureMinTouchTargetSize(z);
            requestLayout();
        }
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean setExpanded(boolean z) {
        return this.expandableWidgetHelper.setExpanded(z);
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public void setExpandedComponentIdHint(@androidx.annotation.IdRes int i) {
        this.expandableWidgetHelper.setExpandedComponentIdHint(i);
    }

    public void setHideMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        getImpl().setHideMotionSpec(motionSpec);
    }

    public void setHideMotionSpecResource(@androidx.annotation.AnimatorRes int i) {
        setHideMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().updateImageMatrixScale();
            if (this.imageTint != null) {
                onApplySupportImageTint();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@androidx.annotation.DrawableRes int i) {
        this.imageHelper.setImageResource(i);
        onApplySupportImageTint();
    }

    public void setRippleColor(@androidx.annotation.ColorInt int i) {
        setRippleColor(android.content.res.ColorStateList.valueOf(i));
    }

    public void setRippleColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            getImpl().setRippleColor(this.rippleColor);
        }
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().onScaleChanged();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().onScaleChanged();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    @androidx.annotation.VisibleForTesting
    public void setShadowPaddingEnabled(boolean z) {
        getImpl().setShadowPaddingEnabled(z);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().setShapeAppearance(shapeAppearanceModel);
    }

    public void setShowMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        getImpl().setShowMotionSpec(motionSpec);
    }

    public void setShowMotionSpecResource(@androidx.annotation.AnimatorRes int i) {
        setShowMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i));
    }

    public void setSize(int i) {
        this.customSize = 0;
        if (i != this.size) {
            this.size = i;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        if (this.imageMode != mode) {
            this.imageMode = mode;
            onApplySupportImageTint();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().onTranslationChanged();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.compatPadding != z) {
            this.compatPadding = z;
            getImpl().onCompatShadowChanged();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().getEnsureMinTouchTargetSize();
    }

    public void show() {
        show(null);
    }

    public void show(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
        show(onVisibilityChangedListener, true);
    }

    public void show(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().show(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z);
    }
}
