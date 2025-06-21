package com.google.android.material.bottomappbar;

/* loaded from: classes22.dex */
public class BottomAppBar extends androidx.appcompat.widget.Toolbar implements androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_BottomAppBar;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private java.util.ArrayList<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> animationListeners;
    private com.google.android.material.bottomappbar.BottomAppBar.Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;

    @androidx.annotation.NonNull
    android.animation.AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;

    @androidx.annotation.NonNull
    com.google.android.material.animation.TransformationCallback<com.google.android.material.floatingactionbutton.FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable;
    private boolean menuAnimatingWithFabAlignmentMode;

    @androidx.annotation.Nullable
    private android.animation.Animator menuAnimator;

    @androidx.annotation.Nullable
    private android.animation.Animator modeAnimator;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;

    @androidx.annotation.MenuRes
    private int pendingMenuResId;
    private int rightInset;

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (com.google.android.material.bottomappbar.BottomAppBar.this.menuAnimatingWithFabAlignmentMode) {
                return;
            }
            com.google.android.material.bottomappbar.BottomAppBar bottomAppBar = com.google.android.material.bottomappbar.BottomAppBar.this;
            bottomAppBar.maybeAnimateMenuView(bottomAppBar.fabAlignmentMode, com.google.android.material.bottomappbar.BottomAppBar.this.fabAttached);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.android.material.animation.TransformationCallback<com.google.android.material.floatingactionbutton.FloatingActionButton> {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.animation.TransformationCallback
        public void onScaleChanged(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            com.google.android.material.bottomappbar.BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // com.google.android.material.animation.TransformationCallback
        public void onTranslationChanged(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (com.google.android.material.bottomappbar.BottomAppBar.this.getTopEdgeTreatment().getHorizontalOffset() != translationX) {
                com.google.android.material.bottomappbar.BottomAppBar.this.getTopEdgeTreatment().setHorizontalOffset(translationX);
                com.google.android.material.bottomappbar.BottomAppBar.this.materialShapeDrawable.invalidateSelf();
            }
            float max = java.lang.Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (com.google.android.material.bottomappbar.BottomAppBar.this.getTopEdgeTreatment().getCradleVerticalOffset() != max) {
                com.google.android.material.bottomappbar.BottomAppBar.this.getTopEdgeTreatment().setCradleVerticalOffset(max);
                com.google.android.material.bottomappbar.BottomAppBar.this.materialShapeDrawable.invalidateSelf();
            }
            com.google.android.material.bottomappbar.BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$3, reason: invalid class name */
    public class AnonymousClass3 implements com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener {
        public AnonymousClass3() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
            boolean z;
            if (com.google.android.material.bottomappbar.BottomAppBar.this.paddingBottomSystemWindowInsets) {
                com.google.android.material.bottomappbar.BottomAppBar.this.bottomInset = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean z2 = false;
            if (com.google.android.material.bottomappbar.BottomAppBar.this.paddingLeftSystemWindowInsets) {
                z = com.google.android.material.bottomappbar.BottomAppBar.this.leftInset != windowInsetsCompat.getSystemWindowInsetLeft();
                com.google.android.material.bottomappbar.BottomAppBar.this.leftInset = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z = false;
            }
            if (com.google.android.material.bottomappbar.BottomAppBar.this.paddingRightSystemWindowInsets) {
                boolean z3 = com.google.android.material.bottomappbar.BottomAppBar.this.rightInset != windowInsetsCompat.getSystemWindowInsetRight();
                com.google.android.material.bottomappbar.BottomAppBar.this.rightInset = windowInsetsCompat.getSystemWindowInsetRight();
                z2 = z3;
            }
            if (z || z2) {
                com.google.android.material.bottomappbar.BottomAppBar.this.cancelAnimations();
                com.google.android.material.bottomappbar.BottomAppBar.this.setCutoutState();
                com.google.android.material.bottomappbar.BottomAppBar.this.setActionMenuViewPosition();
            }
            return windowInsetsCompat;
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$4, reason: invalid class name */
    public class AnonymousClass4 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass4() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationEnd();
            com.google.android.material.bottomappbar.BottomAppBar.this.modeAnimator = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationStart();
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$5, reason: invalid class name */
    public class AnonymousClass5 extends com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener {
        final /* synthetic */ int val$targetMode;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$5$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener {
            public AnonymousClass1() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
            public void onShown(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
                com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationEnd();
            }
        }

        public AnonymousClass5(int i) {
            this.val$targetMode = i;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
        public void onHidden(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(com.google.android.material.bottomappbar.BottomAppBar.this.getFabTranslationX(this.val$targetMode));
            floatingActionButton.show(new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass5.AnonymousClass1());
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$6, reason: invalid class name */
    public class AnonymousClass6 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass6() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationEnd();
            com.google.android.material.bottomappbar.BottomAppBar.this.menuAnimatingWithFabAlignmentMode = false;
            com.google.android.material.bottomappbar.BottomAppBar.this.menuAnimator = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationStart();
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$7, reason: invalid class name */
    public class AnonymousClass7 extends android.animation.AnimatorListenerAdapter {
        public boolean cancelled;
        final /* synthetic */ androidx.appcompat.widget.ActionMenuView val$actionMenuView;
        final /* synthetic */ boolean val$targetAttached;
        final /* synthetic */ int val$targetMode;

        public AnonymousClass7(androidx.appcompat.widget.ActionMenuView actionMenuView, int i, boolean z) {
            this.val$actionMenuView = actionMenuView;
            this.val$targetMode = i;
            this.val$targetAttached = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.cancelled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (this.cancelled) {
                return;
            }
            boolean z = com.google.android.material.bottomappbar.BottomAppBar.this.pendingMenuResId != 0;
            com.google.android.material.bottomappbar.BottomAppBar bottomAppBar = com.google.android.material.bottomappbar.BottomAppBar.this;
            bottomAppBar.replaceMenu(bottomAppBar.pendingMenuResId);
            com.google.android.material.bottomappbar.BottomAppBar.this.translateActionMenuView(this.val$actionMenuView, this.val$targetMode, this.val$targetAttached, z);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ androidx.appcompat.widget.ActionMenuView val$actionMenuView;
        final /* synthetic */ int val$fabAlignmentMode;
        final /* synthetic */ boolean val$fabAttached;

        public AnonymousClass8(androidx.appcompat.widget.ActionMenuView actionMenuView, int i, boolean z) {
            this.val$actionMenuView = actionMenuView;
            this.val$fabAlignmentMode = i;
            this.val$fabAttached = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$actionMenuView.setTranslationX(com.google.android.material.bottomappbar.BottomAppBar.this.getActionMenuViewTranslationX(r0, this.val$fabAlignmentMode, this.val$fabAttached));
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$9, reason: invalid class name */
    public class AnonymousClass9 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass9() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.material.bottomappbar.BottomAppBar.this.fabAnimationListener.onAnimationStart(animator);
            com.google.android.material.floatingactionbutton.FloatingActionButton findDependentFab = com.google.android.material.bottomappbar.BottomAppBar.this.findDependentFab();
            if (findDependentFab != null) {
                findDependentFab.setTranslationX(com.google.android.material.bottomappbar.BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    public interface AnimationListener {
        void onAnimationEnd(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar);

        void onAnimationStart(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar);
    }

    public static class Behavior extends com.google.android.material.behavior.HideBottomViewOnScrollBehavior<com.google.android.material.bottomappbar.BottomAppBar> {

        @androidx.annotation.NonNull
        private final android.graphics.Rect fabContentRect;
        private final android.view.View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private java.lang.ref.WeakReference<com.google.android.material.bottomappbar.BottomAppBar> viewRef;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$Behavior$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnLayoutChangeListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                com.google.android.material.bottomappbar.BottomAppBar bottomAppBar = (com.google.android.material.bottomappbar.BottomAppBar) com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.viewRef.get();
                if (bottomAppBar == null || !(view instanceof com.google.android.material.floatingactionbutton.FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = (com.google.android.material.floatingactionbutton.FloatingActionButton) view;
                floatingActionButton.getMeasuredContentRect(com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.fabContentRect);
                int height = com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.fabContentRect.height();
                bottomAppBar.setFabDiameter(height);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().getTopLeftCornerSize().getCornerSize(new android.graphics.RectF(com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.fabContentRect)));
                androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.originalBottomMargin == 0) {
                    ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                    ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                    if (com.google.android.material.internal.ViewUtils.isLayoutRtl(floatingActionButton)) {
                        ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.fabOffsetEndMode;
                    } else {
                        ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.fabOffsetEndMode;
                    }
                }
            }
        }

        public Behavior() {
            this.fabLayoutListener = new com.google.android.material.bottomappbar.BottomAppBar.Behavior.AnonymousClass1();
            this.fabContentRect = new android.graphics.Rect();
        }

        public Behavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fabLayoutListener = new com.google.android.material.bottomappbar.BottomAppBar.Behavior.AnonymousClass1();
            this.fabContentRect = new android.graphics.Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, int i) {
            this.viewRef = new java.lang.ref.WeakReference<>(bottomAppBar);
            android.view.View findDependentView = bottomAppBar.findDependentView();
            if (findDependentView != null && !androidx.core.view.ViewCompat.isLaidOut(findDependentView)) {
                androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) findDependentView.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.originalBottomMargin = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (findDependentView instanceof com.google.android.material.floatingactionbutton.FloatingActionButton) {
                    com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = (com.google.android.material.floatingactionbutton.FloatingActionButton) findDependentView;
                    floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                    bottomAppBar.addFabAnimationListeners(floatingActionButton);
                }
                bottomAppBar.setCutoutState();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) bottomAppBar, i);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) bottomAppBar, view, view2, i, i2);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.bottomappbar.BottomAppBar.SavedState> CREATOR = new com.google.android.material.bottomappbar.BottomAppBar.SavedState.AnonymousClass1();
        int fabAlignmentMode;
        boolean fabAttached;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<com.google.android.material.bottomappbar.BottomAppBar.SavedState> {
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.Nullable
            public com.google.android.material.bottomappbar.BottomAppBar.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
                return new com.google.android.material.bottomappbar.BottomAppBar.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @androidx.annotation.NonNull
            public com.google.android.material.bottomappbar.BottomAppBar.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.bottomappbar.BottomAppBar.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.bottomappbar.BottomAppBar.SavedState[] newArray(int i) {
                return new com.google.android.material.bottomappbar.BottomAppBar.SavedState[i];
            }
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }
    }

    public BottomAppBar(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null, 0);
    }

    public BottomAppBar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.bottomAppBarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BottomAppBar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r6), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        this.materialShapeDrawable = materialShapeDrawable;
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass1();
        this.fabTransformationCallback = new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass2();
        android.content.Context context2 = getContext();
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.BottomAppBar, i, i2, new int[0]);
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainStyledAttributes, com.google.android.material.R.styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        materialShapeDrawable.setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel.builder().setTopEdge(new com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).build());
        materialShapeDrawable.setShadowCompatibilityMode(2);
        materialShapeDrawable.setPaintStyle(android.graphics.Paint.Style.FILL);
        materialShapeDrawable.initializeElevationOverlay(context2);
        setElevation(dimensionPixelSize);
        androidx.core.graphics.drawable.DrawableCompat.setTintList(materialShapeDrawable, colorStateList);
        androidx.core.view.ViewCompat.setBackground(this, materialShapeDrawable);
        com.google.android.material.internal.ViewUtils.doOnApplyWindowInsets(this, attributeSet, i, i2, new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFabAnimationListeners(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass9());
        floatingActionButton.addTransformationCallback(this.fabTransformationCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnimations() {
        android.animation.Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        android.animation.Animator animator2 = this.modeAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void createFabTranslationXAnimation(int i, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list) {
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(findDependentFab(), "translationX", getFabTranslationX(i));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void createMenuViewTranslationAnimation(int i, boolean z, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list) {
        androidx.appcompat.widget.ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        android.animation.Animator ofFloat = android.animation.ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (java.lang.Math.abs(actionMenuView.getTranslationX() - getActionMenuViewTranslationX(actionMenuView, i, z)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        } else {
            android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass7(actionMenuView, i, z));
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAnimationEnd() {
        java.util.ArrayList<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> arrayList;
        int i = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = i;
        if (i != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        java.util.Iterator<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAnimationStart() {
        java.util.ArrayList<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> arrayList;
        int i = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = i + 1;
        if (i != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        java.util.Iterator<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.Nullable
    public com.google.android.material.floatingactionbutton.FloatingActionButton findDependentFab() {
        android.view.View findDependentView = findDependentView();
        if (findDependentView instanceof com.google.android.material.floatingactionbutton.FloatingActionButton) {
            return (com.google.android.material.floatingactionbutton.FloatingActionButton) findDependentView;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.Nullable
    public android.view.View findDependentView() {
        if (!(getParent() instanceof androidx.coordinatorlayout.widget.CoordinatorLayout)) {
            return null;
        }
        for (android.view.View view : ((androidx.coordinatorlayout.widget.CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof com.google.android.material.floatingactionbutton.FloatingActionButton) || (view instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    private androidx.appcompat.widget.ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            android.view.View childAt = getChildAt(i);
            if (childAt instanceof androidx.appcompat.widget.ActionMenuView) {
                return (androidx.appcompat.widget.ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.bottomInset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX(int i) {
        boolean isLayoutRtl = com.google.android.material.internal.ViewUtils.isLayoutRtl(this);
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - (this.fabOffsetEndMode + (isLayoutRtl ? this.leftInset : this.rightInset))) * (isLayoutRtl ? -1 : 1);
        }
        return 0.0f;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().getCradleVerticalOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.leftInset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.rightInset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.NonNull
    public com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private boolean isFabVisibleOrWillBeShown() {
        com.google.android.material.floatingactionbutton.FloatingActionButton findDependentFab = findDependentFab();
        return findDependentFab != null && findDependentFab.isOrWillBeShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeAnimateMenuView(int i, boolean z) {
        if (!androidx.core.view.ViewCompat.isLaidOut(this)) {
            this.menuAnimatingWithFabAlignmentMode = false;
            replaceMenu(this.pendingMenuResId);
            return;
        }
        android.animation.Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!isFabVisibleOrWillBeShown()) {
            i = 0;
            z = false;
        }
        createMenuViewTranslationAnimation(i, z, arrayList);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.menuAnimator = animatorSet;
        animatorSet.addListener(new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass6());
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int i) {
        if (this.fabAlignmentMode == i || !androidx.core.view.ViewCompat.isLaidOut(this)) {
            return;
        }
        android.animation.Animator animator = this.modeAnimator;
        if (animator != null) {
            animator.cancel();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.fabAnimationMode == 1) {
            createFabTranslationXAnimation(i, arrayList);
        } else {
            createFabDefaultXAnimation(i, arrayList);
        }
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.modeAnimator = animatorSet;
        animatorSet.addListener(new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass4());
        this.modeAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActionMenuViewPosition() {
        androidx.appcompat.widget.ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.menuAnimator != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown()) {
            translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
        } else {
            translateActionMenuView(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCutoutState() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        android.view.View findDependentView = findDependentView();
        this.materialShapeDrawable.setInterpolation((this.fabAttached && isFabVisibleOrWillBeShown()) ? 1.0f : 0.0f);
        if (findDependentView != null) {
            findDependentView.setTranslationY(getFabTranslationY());
            findDependentView.setTranslationX(getFabTranslationX());
        }
    }

    private void translateActionMenuView(@androidx.annotation.NonNull androidx.appcompat.widget.ActionMenuView actionMenuView, int i, boolean z) {
        translateActionMenuView(actionMenuView, i, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateActionMenuView(@androidx.annotation.NonNull androidx.appcompat.widget.ActionMenuView actionMenuView, int i, boolean z, boolean z2) {
        com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass8 anonymousClass8 = new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass8(actionMenuView, i, z);
        if (z2) {
            actionMenuView.post(anonymousClass8);
        } else {
            anonymousClass8.run();
        }
    }

    public void addAnimationListener(@androidx.annotation.NonNull com.google.android.material.bottomappbar.BottomAppBar.AnimationListener animationListener) {
        if (this.animationListeners == null) {
            this.animationListeners = new java.util.ArrayList<>();
        }
        this.animationListeners.add(animationListener);
    }

    public void createFabDefaultXAnimation(int i, java.util.List<android.animation.Animator> list) {
        com.google.android.material.floatingactionbutton.FloatingActionButton findDependentFab = findDependentFab();
        if (findDependentFab == null || findDependentFab.isOrWillBeHidden()) {
            return;
        }
        dispatchAnimationStart();
        findDependentFab.hide(new com.google.android.material.bottomappbar.BottomAppBar.AnonymousClass5(i));
    }

    public int getActionMenuViewTranslationX(@androidx.annotation.NonNull androidx.appcompat.widget.ActionMenuView actionMenuView, int i, boolean z) {
        if (i != 1 || !z) {
            return 0;
        }
        boolean isLayoutRtl = com.google.android.material.internal.ViewUtils.isLayoutRtl(this);
        int measuredWidth = isLayoutRtl ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            android.view.View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof androidx.appcompat.widget.Toolbar.LayoutParams) && (((androidx.appcompat.widget.Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & androidx.core.view.GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = isLayoutRtl ? java.lang.Math.min(measuredWidth, childAt.getLeft()) : java.lang.Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((isLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft()) + (isLayoutRtl ? this.rightInset : -this.leftInset));
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @androidx.annotation.NonNull
    public com.google.android.material.bottomappbar.BottomAppBar.Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new com.google.android.material.bottomappbar.BottomAppBar.Behavior();
        }
        return this.behavior;
    }

    @androidx.annotation.Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    @androidx.annotation.Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if (getParent() instanceof android.view.ViewGroup) {
            ((android.view.ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            cancelAnimations();
            setCutoutState();
        }
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.bottomappbar.BottomAppBar.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.bottomappbar.BottomAppBar.SavedState savedState = (com.google.android.material.bottomappbar.BottomAppBar.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @androidx.annotation.NonNull
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.bottomappbar.BottomAppBar.SavedState savedState = new com.google.android.material.bottomappbar.BottomAppBar.SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    public void performHide() {
        getBehavior().slideDown(this);
    }

    public void performShow() {
        getBehavior().slideUp(this);
    }

    public void removeAnimationListener(@androidx.annotation.NonNull com.google.android.material.bottomappbar.BottomAppBar.AnimationListener animationListener) {
        java.util.ArrayList<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> arrayList = this.animationListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animationListener);
    }

    public void replaceMenu(@androidx.annotation.MenuRes int i) {
        if (i != 0) {
            this.pendingMenuResId = 0;
            getMenu().clear();
            inflateMenu(i);
        }
    }

    public void setBackgroundTint(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        androidx.core.graphics.drawable.DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
    }

    public void setCradleVerticalOffset(@androidx.annotation.Dimension float f) {
        if (f != getCradleVerticalOffset()) {
            getTopEdgeTreatment().setCradleVerticalOffset(f);
            this.materialShapeDrawable.invalidateSelf();
            setCutoutState();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        this.materialShapeDrawable.setElevation(f);
        getBehavior().setAdditionalHiddenOffsetY(this, this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY());
    }

    public void setFabAlignmentMode(int i) {
        setFabAlignmentModeAndReplaceMenu(i, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i, @androidx.annotation.MenuRes int i2) {
        this.pendingMenuResId = i2;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(i, this.fabAttached);
        maybeAnimateModeChange(i);
        this.fabAlignmentMode = i;
    }

    public void setFabAnimationMode(int i) {
        this.fabAnimationMode = i;
    }

    public void setFabCornerSize(@androidx.annotation.Dimension float f) {
        if (f != getTopEdgeTreatment().getFabCornerRadius()) {
            getTopEdgeTreatment().setFabCornerSize(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@androidx.annotation.Dimension float f) {
        if (f != getFabCradleMargin()) {
            getTopEdgeTreatment().setFabCradleMargin(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@androidx.annotation.Dimension float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().setFabCradleRoundedCornerRadius(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public boolean setFabDiameter(@androidx.annotation.Px int i) {
        float f = i;
        if (f == getTopEdgeTreatment().getFabDiameter()) {
            return false;
        }
        getTopEdgeTreatment().setFabDiameter(f);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    }

    public void setHideOnScroll(boolean z) {
        this.hideOnScroll = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(java.lang.CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(java.lang.CharSequence charSequence) {
    }
}
