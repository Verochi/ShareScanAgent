package com.google.android.material.floatingactionbutton;

/* loaded from: classes22.dex */
public class ExtendedFloatingActionButton extends com.google.android.material.button.MaterialButton implements androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private int animState;
    private boolean animateShowBeforeLayout;

    @androidx.annotation.NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton> behavior;
    private final com.google.android.material.floatingactionbutton.AnimatorTracker changeVisibilityTracker;
    private final int collapsedSize;

    @androidx.annotation.NonNull
    private final com.google.android.material.floatingactionbutton.MotionStrategy extendStrategy;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final com.google.android.material.floatingactionbutton.MotionStrategy hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;

    @androidx.annotation.NonNull
    protected android.content.res.ColorStateList originalTextCsl;
    private final com.google.android.material.floatingactionbutton.MotionStrategy showStrategy;

    @androidx.annotation.NonNull
    private final com.google.android.material.floatingactionbutton.MotionStrategy shrinkStrategy;
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final android.util.Property<android.view.View, java.lang.Float> WIDTH = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass4(java.lang.Float.class, "width");
    static final android.util.Property<android.view.View, java.lang.Float> HEIGHT = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass5(java.lang.Float.class, "height");
    static final android.util.Property<android.view.View, java.lang.Float> PADDING_START = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass6(java.lang.Float.class, "paddingStart");
    static final android.util.Property<android.view.View, java.lang.Float> PADDING_END = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass7(java.lang.Float.class, "paddingEnd");

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public android.view.ViewGroup.LayoutParams getLayoutParams() {
            return new android.view.ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingEnd() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.extendedPaddingEnd;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingStart() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.extendedPaddingStart;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            return (com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getMeasuredWidth() - (com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.extendedPaddingStart + com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.extendedPaddingEnd;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public android.view.ViewGroup.LayoutParams getLayoutParams() {
            return new android.view.ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingEnd() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingStart() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$3, reason: invalid class name */
    public class AnonymousClass3 extends android.animation.AnimatorListenerAdapter {
        private boolean cancelled;
        final /* synthetic */ com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback val$callback;
        final /* synthetic */ com.google.android.material.floatingactionbutton.MotionStrategy val$strategy;

        public AnonymousClass3(com.google.android.material.floatingactionbutton.MotionStrategy motionStrategy, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            this.val$strategy = motionStrategy;
            this.val$callback = onChangedCallback;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.cancelled = true;
            this.val$strategy.onAnimationCancel();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$strategy.onAnimationEnd();
            if (this.cancelled) {
                return;
            }
            this.val$strategy.onChange(this.val$callback);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            this.val$strategy.onAnimationStart(animator);
            this.cancelled = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$4, reason: invalid class name */
    public static class AnonymousClass4 extends android.util.Property<android.view.View, java.lang.Float> {
        public AnonymousClass4(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @androidx.annotation.NonNull
        public java.lang.Float get(@androidx.annotation.NonNull android.view.View view) {
            return java.lang.Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        public void set(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.Float f) {
            view.getLayoutParams().width = f.intValue();
            view.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$5, reason: invalid class name */
    public static class AnonymousClass5 extends android.util.Property<android.view.View, java.lang.Float> {
        public AnonymousClass5(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @androidx.annotation.NonNull
        public java.lang.Float get(@androidx.annotation.NonNull android.view.View view) {
            return java.lang.Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        public void set(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.Float f) {
            view.getLayoutParams().height = f.intValue();
            view.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$6, reason: invalid class name */
    public static class AnonymousClass6 extends android.util.Property<android.view.View, java.lang.Float> {
        public AnonymousClass6(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @androidx.annotation.NonNull
        public java.lang.Float get(@androidx.annotation.NonNull android.view.View view) {
            return java.lang.Float.valueOf(androidx.core.view.ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        public void set(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.Float f) {
            androidx.core.view.ViewCompat.setPaddingRelative(view, f.intValue(), view.getPaddingTop(), androidx.core.view.ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$7, reason: invalid class name */
    public static class AnonymousClass7 extends android.util.Property<android.view.View, java.lang.Float> {
        public AnonymousClass7(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @androidx.annotation.NonNull
        public java.lang.Float get(@androidx.annotation.NonNull android.view.View view) {
            return java.lang.Float.valueOf(androidx.core.view.ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        public void set(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.Float f) {
            androidx.core.view.ViewCompat.setPaddingRelative(view, androidx.core.view.ViewCompat.getPaddingStart(view), view.getPaddingTop(), f.intValue(), view.getPaddingBottom());
        }
    }

    public class ChangeSizeStrategy extends com.google.android.material.floatingactionbutton.BaseMotionStrategy {
        private final boolean extending;
        private final com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size size;

        public ChangeSizeStrategy(com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size size, boolean z) {
            super(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this, animatorTracker);
            this.size = size;
            this.extending = z;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        @androidx.annotation.NonNull
        public android.animation.AnimatorSet createAnimator() {
            com.google.android.material.animation.MotionSpec currentMotionSpec = getCurrentMotionSpec();
            if (currentMotionSpec.hasPropertyValues("width")) {
                android.animation.PropertyValuesHolder[] propertyValues = currentMotionSpec.getPropertyValues("width");
                propertyValues[0].setFloatValues(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getWidth(), this.size.getWidth());
                currentMotionSpec.setPropertyValues("width", propertyValues);
            }
            if (currentMotionSpec.hasPropertyValues("height")) {
                android.animation.PropertyValuesHolder[] propertyValues2 = currentMotionSpec.getPropertyValues("height");
                propertyValues2[0].setFloatValues(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getHeight(), this.size.getHeight());
                currentMotionSpec.setPropertyValues("height", propertyValues2);
            }
            if (currentMotionSpec.hasPropertyValues("paddingStart")) {
                android.animation.PropertyValuesHolder[] propertyValues3 = currentMotionSpec.getPropertyValues("paddingStart");
                propertyValues3[0].setFloatValues(androidx.core.view.ViewCompat.getPaddingStart(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this), this.size.getPaddingStart());
                currentMotionSpec.setPropertyValues("paddingStart", propertyValues3);
            }
            if (currentMotionSpec.hasPropertyValues("paddingEnd")) {
                android.animation.PropertyValuesHolder[] propertyValues4 = currentMotionSpec.getPropertyValues("paddingEnd");
                propertyValues4[0].setFloatValues(androidx.core.view.ViewCompat.getPaddingEnd(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this), this.size.getPaddingEnd());
                currentMotionSpec.setPropertyValues("paddingEnd", propertyValues4);
            }
            if (currentMotionSpec.hasPropertyValues("labelOpacity")) {
                android.animation.PropertyValuesHolder[] propertyValues5 = currentMotionSpec.getPropertyValues("labelOpacity");
                boolean z = this.extending;
                propertyValues5[0].setFloatValues(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
                currentMotionSpec.setPropertyValues("labelOpacity", propertyValues5);
            }
            return super.createAnimator(currentMotionSpec);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return this.extending ? com.google.android.material.R.animator.mtrl_extended_fab_change_size_expand_motion_spec : com.google.android.material.R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isTransforming = false;
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            android.view.ViewGroup.LayoutParams layoutParams = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.size.getLayoutParams().width;
            layoutParams.height = this.size.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(android.animation.Animator animator) {
            super.onAnimationStart(animator);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isExtended = this.extending;
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isTransforming = true;
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            if (onChangedCallback == null) {
                return;
            }
            if (this.extending) {
                onChangedCallback.onExtended(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this);
            } else {
                onChangedCallback.onShrunken(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isExtended = this.extending;
            android.view.ViewGroup.LayoutParams layoutParams = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.size.getLayoutParams().width;
            layoutParams.height = this.size.getLayoutParams().height;
            androidx.core.view.ViewCompat.setPaddingRelative(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this, this.size.getPaddingStart(), com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getPaddingTop(), this.size.getPaddingEnd(), com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getPaddingBottom());
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return this.extending == com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isExtended || com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getIcon() == null || android.text.TextUtils.isEmpty(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getText());
        }
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton> extends androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;

        @androidx.annotation.Nullable
        private com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback internalAutoHideCallback;

        @androidx.annotation.Nullable
        private com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback internalAutoShrinkCallback;
        private android.graphics.Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public ExtendedFloatingActionButtonBehavior(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        private static boolean isBottomSheet(@androidx.annotation.NonNull android.view.View view) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) {
                return ((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof com.google.android.material.bottomsheet.BottomSheetBehavior;
            }
            return false;
        }

        private boolean shouldUpdateVisibility(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.autoHideEnabled || this.autoShrinkEnabled) && ((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        private boolean updateFabVisibilityForAppBarLayout(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.appbar.AppBarLayout appBarLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new android.graphics.Rect();
            }
            android.graphics.Rect rect = this.tmpRect;
            com.google.android.material.internal.DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((android.view.ViewGroup.MarginLayoutParams) ((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        public void extendOrShow(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.autoShrinkEnabled;
            extendedFloatingActionButton.performMotion(z ? extendedFloatingActionButton.extendStrategy : extendedFloatingActionButton.showStrategy, z ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, @androidx.annotation.NonNull android.graphics.Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) extendedFloatingActionButton, rect);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, android.view.View view) {
            if (view instanceof com.google.android.material.appbar.AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (com.google.android.material.appbar.AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!isBottomSheet(view)) {
                return false;
            }
            updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            java.util.List<android.view.View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                android.view.View view = dependencies.get(i2);
                if (!(view instanceof com.google.android.material.appbar.AppBarLayout)) {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (com.google.android.material.appbar.AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
            return true;
        }

        public void setAutoHideEnabled(boolean z) {
            this.autoHideEnabled = z;
        }

        public void setAutoShrinkEnabled(boolean z) {
            this.autoShrinkEnabled = z;
        }

        @androidx.annotation.VisibleForTesting
        public void setInternalAutoHideCallback(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            this.internalAutoHideCallback = onChangedCallback;
        }

        @androidx.annotation.VisibleForTesting
        public void setInternalAutoShrinkCallback(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            this.internalAutoShrinkCallback = onChangedCallback;
        }

        public void shrinkOrHide(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.autoShrinkEnabled;
            extendedFloatingActionButton.performMotion(z ? extendedFloatingActionButton.shrinkStrategy : extendedFloatingActionButton.hideStrategy, z ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }
    }

    public class HideStrategy extends com.google.android.material.floatingactionbutton.BaseMotionStrategy {
        private boolean isCancelled;

        public HideStrategy(com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker) {
            super(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return com.google.android.material.R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationCancel() {
            super.onAnimationCancel();
            this.isCancelled = true;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.animState = 0;
            if (this.isCancelled) {
                return;
            }
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(android.animation.Animator animator) {
            super.onAnimationStart(animator);
            this.isCancelled = false;
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(0);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.animState = 1;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onHidden(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isOrWillBeHidden();
        }
    }

    public static abstract class OnChangedCallback {
        public void onExtended(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onHidden(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShown(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShrunken(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    public class ShowStrategy extends com.google.android.material.floatingactionbutton.BaseMotionStrategy {
        public ShowStrategy(com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker) {
            super(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return com.google.android.material.R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.animState = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(android.animation.Animator animator) {
            super.onAnimationStart(animator);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(0);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.animState = 2;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onShown(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(0);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setAlpha(1.0f);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setScaleY(1.0f);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isOrWillBeShown();
        }
    }

    public interface Size {
        int getHeight();

        android.view.ViewGroup.LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.extendedFloatingActionButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r9), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        this.animState = 0;
        com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker = new com.google.android.material.floatingactionbutton.AnimatorTracker();
        this.changeVisibilityTracker = animatorTracker;
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ShowStrategy showStrategy = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ShowStrategy(animatorTracker);
        this.showStrategy = showStrategy;
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.HideStrategy hideStrategy = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.HideStrategy(animatorTracker);
        this.hideStrategy = hideStrategy;
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        android.content.Context context2 = getContext();
        this.behavior = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.ExtendedFloatingActionButton, i, i2, new int[0]);
        com.google.android.material.animation.MotionSpec createFromAttribute = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, obtainStyledAttributes, com.google.android.material.R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        com.google.android.material.animation.MotionSpec createFromAttribute2 = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, obtainStyledAttributes, com.google.android.material.R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        com.google.android.material.animation.MotionSpec createFromAttribute3 = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, obtainStyledAttributes, com.google.android.material.R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        com.google.android.material.animation.MotionSpec createFromAttribute4 = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, obtainStyledAttributes, com.google.android.material.R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.extendedPaddingStart = androidx.core.view.ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = androidx.core.view.ViewCompat.getPaddingEnd(this);
        com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker2 = new com.google.android.material.floatingactionbutton.AnimatorTracker();
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ChangeSizeStrategy changeSizeStrategy = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ChangeSizeStrategy(animatorTracker2, new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass1(), true);
        this.extendStrategy = changeSizeStrategy;
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ChangeSizeStrategy changeSizeStrategy2 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ChangeSizeStrategy(animatorTracker2, new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass2(), false);
        this.shrinkStrategy = changeSizeStrategy2;
        showStrategy.setMotionSpec(createFromAttribute);
        hideStrategy.setMotionSpec(createFromAttribute2);
        changeSizeStrategy.setMotionSpec(createFromAttribute3);
        changeSizeStrategy2.setMotionSpec(createFromAttribute4);
        obtainStyledAttributes.recycle();
        setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i, i2, com.google.android.material.shape.ShapeAppearanceModel.PILL).build());
        saveOriginalTextCsl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrWillBeHidden() {
        return getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrWillBeShown() {
        return getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performMotion(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.MotionStrategy motionStrategy, @androidx.annotation.Nullable com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        if (motionStrategy.shouldCancel()) {
            return;
        }
        if (!shouldAnimateVisibilityChange()) {
            motionStrategy.performNow();
            motionStrategy.onChange(onChangedCallback);
            return;
        }
        measure(0, 0);
        android.animation.AnimatorSet createAnimator = motionStrategy.createAnimator();
        createAnimator.addListener(new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass3(motionStrategy, onChangedCallback));
        java.util.Iterator<android.animation.Animator.AnimatorListener> it = motionStrategy.getListeners().iterator();
        while (it.hasNext()) {
            createAnimator.addListener(it.next());
        }
        createAnimator.start();
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    private boolean shouldAnimateVisibilityChange() {
        return (androidx.core.view.ViewCompat.isLaidOut(this) || (!isOrWillBeShown() && this.animateShowBeforeLayout)) && !isInEditMode();
    }

    public void addOnExtendAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.extendStrategy.addAnimationListener(animatorListener);
    }

    public void addOnHideAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.hideStrategy.addAnimationListener(animatorListener);
    }

    public void addOnShowAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.showStrategy.addAnimationListener(animatorListener);
    }

    public void addOnShrinkAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.addAnimationListener(animatorListener);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    public void extend(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        performMotion(this.extendStrategy, onChangedCallback);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @androidx.annotation.NonNull
    public androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @androidx.annotation.VisibleForTesting
    public int getCollapsedSize() {
        int i = this.collapsedSize;
        return i < 0 ? (java.lang.Math.min(androidx.core.view.ViewCompat.getPaddingStart(this), androidx.core.view.ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.animation.MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.getMotionSpec();
    }

    @androidx.annotation.Nullable
    public com.google.android.material.animation.MotionSpec getHideMotionSpec() {
        return this.hideStrategy.getMotionSpec();
    }

    @androidx.annotation.Nullable
    public com.google.android.material.animation.MotionSpec getShowMotionSpec() {
        return this.showStrategy.getMotionSpec();
    }

    @androidx.annotation.Nullable
    public com.google.android.material.animation.MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.getMotionSpec();
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public void hide(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        performMotion(this.hideStrategy, onChangedCallback);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended && android.text.TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.isExtended = false;
            this.shrinkStrategy.performNow();
        }
    }

    public void removeOnExtendAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.extendStrategy.removeAnimationListener(animatorListener);
    }

    public void removeOnHideAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.hideStrategy.removeAnimationListener(animatorListener);
    }

    public void removeOnShowAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.showStrategy.removeAnimationListener(animatorListener);
    }

    public void removeOnShrinkAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.removeAnimationListener(animatorListener);
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.animateShowBeforeLayout = z;
    }

    public void setExtendMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        this.extendStrategy.setMotionSpec(motionSpec);
    }

    public void setExtendMotionSpecResource(@androidx.annotation.AnimatorRes int i) {
        setExtendMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (this.isExtended == z) {
            return;
        }
        com.google.android.material.floatingactionbutton.MotionStrategy motionStrategy = z ? this.extendStrategy : this.shrinkStrategy;
        if (motionStrategy.shouldCancel()) {
            return;
        }
        motionStrategy.performNow();
    }

    public void setHideMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        this.hideStrategy.setMotionSpec(motionSpec);
    }

    public void setHideMotionSpecResource(@androidx.annotation.AnimatorRes int i) {
        setHideMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = androidx.core.view.ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = androidx.core.view.ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = i;
        this.extendedPaddingEnd = i3;
    }

    public void setShowMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        this.showStrategy.setMotionSpec(motionSpec);
    }

    public void setShowMotionSpecResource(@androidx.annotation.AnimatorRes int i) {
        setShowMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i));
    }

    public void setShrinkMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        this.shrinkStrategy.setMotionSpec(motionSpec);
    }

    public void setShrinkMotionSpecResource(@androidx.annotation.AnimatorRes int i) {
        setShrinkMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void show(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        performMotion(this.showStrategy, onChangedCallback);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public void shrink(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        performMotion(this.shrinkStrategy, onChangedCallback);
    }

    public void silentlyUpdateTextColor(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }
}
