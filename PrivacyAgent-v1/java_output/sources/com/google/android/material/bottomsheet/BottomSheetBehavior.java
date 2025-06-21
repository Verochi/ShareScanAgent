package com.google.android.material.bottomsheet;

/* loaded from: classes22.dex */
public class BottomSheetBehavior<V extends android.view.View> extends androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_WIDTH = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final java.lang.String TAG = "BottomSheetBehavior";
    int activePointerId;

    @androidx.annotation.NonNull
    private final java.util.ArrayList<com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final androidx.customview.widget.ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    private int expandHalfwayActionId;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;

    @androidx.annotation.Nullable
    private java.util.Map<android.view.View, java.lang.Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;

    @androidx.annotation.Nullable
    private android.animation.ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    private com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;

    @androidx.annotation.Nullable
    java.lang.ref.WeakReference<android.view.View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<V>.SettleRunnable settleRunnable;
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;

    @androidx.annotation.Nullable
    private android.view.VelocityTracker velocityTracker;

    @androidx.annotation.Nullable
    androidx.customview.widget.ViewDragHelper viewDragHelper;

    @androidx.annotation.Nullable
    java.lang.ref.WeakReference<V> viewRef;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.view.View val$child;
        final /* synthetic */ android.view.ViewGroup.LayoutParams val$lp;

        public AnonymousClass1(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
            this.val$child = view;
            this.val$lp = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$child.setLayoutParams(this.val$lp);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.view.View val$child;
        final /* synthetic */ int val$finalState;

        public AnonymousClass2(android.view.View view, int i) {
            this.val$child = view;
            this.val$finalState = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.bottomsheet.BottomSheetBehavior.this.settleToState(this.val$child, this.val$finalState);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$3, reason: invalid class name */
    public class AnonymousClass3 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.materialShapeDrawable != null) {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$4, reason: invalid class name */
    public class AnonymousClass4 implements com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener {
        final /* synthetic */ boolean val$shouldHandleGestureInsets;

        public AnonymousClass4(boolean z) {
            this.val$shouldHandleGestureInsets = z;
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat, com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
            com.google.android.material.bottomsheet.BottomSheetBehavior.this.insetTop = windowInsetsCompat.getSystemWindowInsetTop();
            boolean isLayoutRtl = com.google.android.material.internal.ViewUtils.isLayoutRtl(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.insetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                paddingBottom = relativePadding.bottom + com.google.android.material.bottomsheet.BottomSheetBehavior.this.insetBottom;
            }
            if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                paddingLeft = (isLayoutRtl ? relativePadding.end : relativePadding.start) + windowInsetsCompat.getSystemWindowInsetLeft();
            }
            if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                paddingRight = (isLayoutRtl ? relativePadding.start : relativePadding.end) + windowInsetsCompat.getSystemWindowInsetRight();
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.val$shouldHandleGestureInsets) {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.gestureInsetBottom = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
            }
            if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.paddingBottomSystemWindowInsets || this.val$shouldHandleGestureInsets) {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.updatePeekHeight(false);
            }
            return windowInsetsCompat;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$5, reason: invalid class name */
    public class AnonymousClass5 extends androidx.customview.widget.ViewDragHelper.Callback {
        public AnonymousClass5() {
        }

        private boolean releasedLow(@androidx.annotation.NonNull android.view.View view) {
            int top = view.getTop();
            com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior = com.google.android.material.bottomsheet.BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
            int expandedOffset = com.google.android.material.bottomsheet.BottomSheetBehavior.this.getExpandedOffset();
            com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior = com.google.android.material.bottomsheet.BottomSheetBehavior.this;
            return androidx.core.math.MathUtils.clamp(i, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@androidx.annotation.NonNull android.view.View view) {
            com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior = com.google.android.material.bottomsheet.BottomSheetBehavior.this;
            return bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (i == 1 && com.google.android.material.bottomsheet.BottomSheetBehavior.this.draggable) {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4) {
            com.google.android.material.bottomsheet.BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@androidx.annotation.NonNull android.view.View view, float f, float f2) {
            int i;
            int i2 = 6;
            if (f2 < 0.0f) {
                if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                    i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset;
                } else {
                    int top = view.getTop();
                    com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior = com.google.android.material.bottomsheet.BottomSheetBehavior.this;
                    int i3 = bottomSheetBehavior.halfExpandedOffset;
                    if (top > i3) {
                        i = i3;
                    } else {
                        i = bottomSheetBehavior.getExpandedOffset();
                    }
                }
                i2 = 3;
            } else {
                com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this;
                if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view, f2)) {
                    if ((java.lang.Math.abs(f) >= java.lang.Math.abs(f2) || f2 <= 500.0f) && !releasedLow(view)) {
                        if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                            i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset;
                        } else if (java.lang.Math.abs(view.getTop() - com.google.android.material.bottomsheet.BottomSheetBehavior.this.getExpandedOffset()) < java.lang.Math.abs(view.getTop() - com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset)) {
                            i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.getExpandedOffset();
                        } else {
                            i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                        }
                        i2 = 3;
                    } else {
                        i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.parentHeight;
                        i2 = 5;
                    }
                } else if (f2 == 0.0f || java.lang.Math.abs(f) > java.lang.Math.abs(f2)) {
                    int top2 = view.getTop();
                    if (!com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                        com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this;
                        int i4 = bottomSheetBehavior3.halfExpandedOffset;
                        if (top2 < i4) {
                            if (top2 < java.lang.Math.abs(top2 - bottomSheetBehavior3.collapsedOffset)) {
                                i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.getExpandedOffset();
                                i2 = 3;
                            } else {
                                i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                            }
                        } else if (java.lang.Math.abs(top2 - i4) < java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                            i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                            i2 = 4;
                        }
                    } else if (java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset) < java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                        i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset;
                        i2 = 3;
                    } else {
                        i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                        i2 = 4;
                    }
                } else {
                    if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                        i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                    } else {
                        int top3 = view.getTop();
                        if (java.lang.Math.abs(top3 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset) < java.lang.Math.abs(top3 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                            i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                        }
                    }
                    i2 = 4;
                }
            }
            com.google.android.material.bottomsheet.BottomSheetBehavior.this.startSettlingAnimation(view, i2, i, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@androidx.annotation.NonNull android.view.View view, int i) {
            com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior = com.google.android.material.bottomsheet.BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.state;
            if (i2 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.activePointerId == i) {
                java.lang.ref.WeakReference<android.view.View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                android.view.View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            java.lang.ref.WeakReference<V> weakReference2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this.viewRef;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$6, reason: invalid class name */
    public class AnonymousClass6 implements androidx.core.view.accessibility.AccessibilityViewCommand {
        final /* synthetic */ int val$state;

        public AnonymousClass6(int i) {
            this.val$state = i;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments commandArguments) {
            com.google.android.material.bottomsheet.BottomSheetBehavior.this.setState(this.val$state);
            return true;
        }
    }

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@androidx.annotation.NonNull android.view.View view, float f);

        public abstract void onStateChanged(@androidx.annotation.NonNull android.view.View view, int i);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SaveFlags {
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState> CREATOR = new com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.AnonymousClass1();
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState> {
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.Nullable
            public com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
                return new com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState(parcel, (java.lang.ClassLoader) null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @androidx.annotation.NonNull
            public com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState[] newArray(int i) {
                return new com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState[i];
            }
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel) {
            this(parcel, (java.lang.ClassLoader) null);
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        @java.lang.Deprecated
        public SavedState(android.os.Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public SavedState(android.os.Parcelable parcelable, @androidx.annotation.NonNull com.google.android.material.bottomsheet.BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = ((com.google.android.material.bottomsheet.BottomSheetBehavior) bottomSheetBehavior).peekHeight;
            this.fitToContents = ((com.google.android.material.bottomsheet.BottomSheetBehavior) bottomSheetBehavior).fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = ((com.google.android.material.bottomsheet.BottomSheetBehavior) bottomSheetBehavior).skipCollapsed;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    public class SettleRunnable implements java.lang.Runnable {
        private boolean isPosted;
        int targetState;
        private final android.view.View view;

        public SettleRunnable(android.view.View view, int i) {
            this.view = view;
            this.targetState = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.customview.widget.ViewDragHelper viewDragHelper = com.google.android.material.bottomsheet.BottomSheetBehavior.this.viewDragHelper;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.setStateInternal(this.targetState);
            } else {
                androidx.core.view.ViewCompat.postOnAnimation(this.view, this);
            }
            this.isPosted = false;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new java.util.ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5();
    }

    public BottomSheetBehavior(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new java.util.ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5();
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_min_touch_target_size);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i2 = com.google.android.material.R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, i2));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i3 = com.google.android.material.R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i3)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(i3, -1));
        }
        int i4 = com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        android.util.TypedValue peekValue = obtainStyledAttributes.peekValue(i4);
        if (peekValue == null || (i = peekValue.data) != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i4, -1));
        } else {
            setPeekHeight(i);
        }
        setHideable(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i5 = com.google.android.material.R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        android.util.TypedValue peekValue2 = obtainStyledAttributes.peekValue(i5);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i5, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = android.view.ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private int addAccessibilityActionForState(V v, @androidx.annotation.StringRes int i, int i2) {
        return androidx.core.view.ViewCompat.addAccessibilityAction(v, v.getResources().getString(i), createAccessibilityViewCommandForState(i2));
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = java.lang.Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        int i;
        return this.peekHeightAuto ? java.lang.Math.min(java.lang.Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom : (this.gestureInsetBottomIgnored || this.paddingBottomSystemWindowInsets || (i = this.gestureInsetBottom) <= 0) ? this.peekHeight + this.insetBottom : java.lang.Math.max(this.peekHeight, i + this.peekHeightGestureInsetBuffer);
    }

    private androidx.core.view.accessibility.AccessibilityViewCommand createAccessibilityViewCommandForState(int i) {
        return new com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass6(i);
    }

    private void createMaterialShapeDrawable(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, boolean z) {
        createMaterialShapeDrawable(context, attributeSet, z, null);
    }

    private void createMaterialShapeDrawable(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, boolean z, @androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = com.google.android.material.shape.ShapeAppearanceModel.builder(context, attributeSet, com.google.android.material.R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            if (z && colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            android.util.TypedValue typedValue = new android.util.TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    private void createShapeValueAnimator() {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass3());
    }

    @androidx.annotation.NonNull
    public static <V extends android.view.View> com.google.android.material.bottomsheet.BottomSheetBehavior<V> from(@androidx.annotation.NonNull V v) {
        android.view.ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams)) {
            throw new java.lang.IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior behavior = ((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof com.google.android.material.bottomsheet.BottomSheetBehavior) {
            return (com.google.android.material.bottomsheet.BottomSheetBehavior) behavior;
        }
        throw new java.lang.IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private float getYVelocity() {
        android.view.VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void replaceAccessibilityActionForState(V v, androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i) {
        androidx.core.view.ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, createAccessibilityViewCommandForState(i));
    }

    private void reset() {
        this.activePointerId = -1;
        android.view.VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(@androidx.annotation.NonNull com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState savedState) {
        int i = this.saveFlags;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        if (i == -1 || (i & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        if (i == -1 || (i & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        if (i == -1 || (i & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    private void setWindowInsetsListener(@androidx.annotation.NonNull android.view.View view) {
        boolean z = (android.os.Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.peekHeightAuto) ? false : true;
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || z) {
            com.google.android.material.internal.ViewUtils.doOnApplyWindowInsets(view, new com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4(z));
        }
    }

    private void settleToStatePendingLayout(int i) {
        V v = this.viewRef.get();
        if (v == null) {
            return;
        }
        android.view.ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && androidx.core.view.ViewCompat.isAttachedToWindow(v)) {
            v.post(new com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass2(v, i));
        } else {
            settleToState(v, i);
        }
    }

    private void updateAccessibilityActions() {
        V v;
        java.lang.ref.WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        androidx.core.view.ViewCompat.removeAccessibilityAction(v, 524288);
        androidx.core.view.ViewCompat.removeAccessibilityAction(v, 262144);
        androidx.core.view.ViewCompat.removeAccessibilityAction(v, 1048576);
        int i = this.expandHalfwayActionId;
        if (i != -1) {
            androidx.core.view.ViewCompat.removeAccessibilityAction(v, i);
        }
        if (!this.fitToContents && this.state != 6) {
            this.expandHalfwayActionId = addAccessibilityActionForState(v, com.google.android.material.R.string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.hideable && this.state != 5) {
            replaceAccessibilityActionForState(v, androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i2 = this.state;
        if (i2 == 3) {
            replaceAccessibilityActionForState(v, androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.fitToContents ? 4 : 6);
            return;
        }
        if (i2 == 4) {
            replaceAccessibilityActionForState(v, androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.fitToContents ? 3 : 6);
        } else {
            if (i2 != 6) {
                return;
            }
            replaceAccessibilityActionForState(v, androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            replaceAccessibilityActionForState(v, androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private void updateDrawableForTargetState(int i) {
        android.animation.ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.isShapeExpanded != z) {
            this.isShapeExpanded = z;
            if (this.materialShapeDrawable == null || (valueAnimator = this.interpolatorAnimator) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.interpolatorAnimator.reverse();
                return;
            }
            float f = z ? 0.0f : 1.0f;
            this.interpolatorAnimator.setFloatValues(1.0f - f, f);
            this.interpolatorAnimator.start();
        }
    }

    private void updateImportantForAccessibility(boolean z) {
        java.util.Map<android.view.View, java.lang.Integer> map;
        java.lang.ref.WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        android.view.ViewParent parent = weakReference.get().getParent();
        if (parent instanceof androidx.coordinatorlayout.widget.CoordinatorLayout) {
            androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = (androidx.coordinatorlayout.widget.CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new java.util.HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.viewRef.get()) {
                    if (z) {
                        this.importantForAccessibilityMap.put(childAt, java.lang.Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.updateImportantForAccessibilityOnSiblings) {
                            androidx.core.view.ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                        androidx.core.view.ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                    }
                }
            }
            if (!z) {
                this.importantForAccessibilityMap = null;
            } else if (this.updateImportantForAccessibilityOnSiblings) {
                this.viewRef.get().sendAccessibilityEvent(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePeekHeight(boolean z) {
        V v;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state != 4 || (v = this.viewRef.get()) == null) {
                return;
            }
            if (z) {
                settleToStatePendingLayout(this.state);
            } else {
                v.requestLayout();
            }
        }
    }

    public void addBottomSheetCallback(@androidx.annotation.NonNull com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        if (this.callbacks.contains(bottomSheetCallback)) {
            return;
        }
        this.callbacks.add(bottomSheetCallback);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    @androidx.annotation.VisibleForTesting
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int i) {
        float f;
        float f2;
        V v = this.viewRef.get();
        if (v == null || this.callbacks.isEmpty()) {
            return;
        }
        int i2 = this.collapsedOffset;
        if (i > i2 || i2 == getExpandedOffset()) {
            int i3 = this.collapsedOffset;
            f = i3 - i;
            f2 = this.parentHeight - i3;
        } else {
            int i4 = this.collapsedOffset;
            f = i4 - i;
            f2 = i4 - getExpandedOffset();
        }
        float f3 = f / f2;
        for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
            this.callbacks.get(i5).onSlide(v, f3);
        }
    }

    @androidx.annotation.Nullable
    @androidx.annotation.VisibleForTesting
    public android.view.View findScrollingChild(android.view.View view) {
        if (androidx.core.view.ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof android.view.ViewGroup)) {
            return null;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return java.lang.Math.max(this.expandedOffset, this.paddingTopSystemWindowInsets ? 0 : this.insetTop);
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public com.google.android.material.shape.MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @androidx.annotation.Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    @androidx.annotation.VisibleForTesting
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, @androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        androidx.customview.widget.ViewDragHelper viewDragHelper;
        if (!v.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = android.view.VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                java.lang.ref.WeakReference<android.view.View> weakReference = this.nestedScrollingChildRef;
                android.view.View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (viewDragHelper = this.viewDragHelper) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        java.lang.ref.WeakReference<android.view.View> weakReference2 = this.nestedScrollingChildRef;
        android.view.View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || java.lang.Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, int i) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable;
        if (androidx.core.view.ViewCompat.getFitsSystemWindows(coordinatorLayout) && !androidx.core.view.ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_sheet_peek_height_min);
            setWindowInsetsListener(v);
            this.viewRef = new java.lang.ref.WeakReference<>(v);
            if (this.shapeThemingEnabled && (materialShapeDrawable = this.materialShapeDrawable) != null) {
                androidx.core.view.ViewCompat.setBackground(v, materialShapeDrawable);
            }
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                float f = this.elevation;
                if (f == -1.0f) {
                    f = androidx.core.view.ViewCompat.getElevation(v);
                }
                materialShapeDrawable2.setElevation(f);
                boolean z = this.state == 3;
                this.isShapeExpanded = z;
                this.materialShapeDrawable.setInterpolation(z ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (androidx.core.view.ViewCompat.getImportantForAccessibility(v) == 0) {
                androidx.core.view.ViewCompat.setImportantForAccessibility(v, 1);
            }
            int measuredWidth = v.getMeasuredWidth();
            int i2 = this.maxWidth;
            if (measuredWidth > i2 && i2 != -1) {
                android.view.ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.width = this.maxWidth;
                v.post(new com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass1(v, layoutParams));
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = androidx.customview.widget.ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.childHeight = height;
        int i3 = this.parentHeight;
        int i4 = i3 - height;
        int i5 = this.insetTop;
        if (i4 < i5) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = i3;
            } else {
                this.childHeight = i3 - i5;
            }
        }
        this.fitToContentsOffset = java.lang.Math.max(0, i3 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i6 = this.state;
        if (i6 == 3) {
            androidx.core.view.ViewCompat.offsetTopAndBottom(v, getExpandedOffset());
        } else if (i6 == 6) {
            androidx.core.view.ViewCompat.offsetTopAndBottom(v, this.halfExpandedOffset);
        } else if (this.hideable && i6 == 5) {
            androidx.core.view.ViewCompat.offsetTopAndBottom(v, this.parentHeight);
        } else if (i6 == 4) {
            androidx.core.view.ViewCompat.offsetTopAndBottom(v, this.collapsedOffset);
        } else if (i6 == 1 || i6 == 2) {
            androidx.core.view.ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        this.nestedScrollingChildRef = new java.lang.ref.WeakReference<>(findScrollingChild(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, @androidx.annotation.NonNull android.view.View view, float f, float f2) {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.state != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, @androidx.annotation.NonNull android.view.View view, int i, int i2, @androidx.annotation.NonNull int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        java.lang.ref.WeakReference<android.view.View> weakReference = this.nestedScrollingChildRef;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (i4 < getExpandedOffset()) {
                int expandedOffset = top - getExpandedOffset();
                iArr[1] = expandedOffset;
                androidx.core.view.ViewCompat.offsetTopAndBottom(v, -expandedOffset);
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i2;
                androidx.core.view.ViewCompat.offsetTopAndBottom(v, -i2);
                setStateInternal(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i5 = this.collapsedOffset;
            if (i4 > i5 && !this.hideable) {
                int i6 = top - i5;
                iArr[1] = i6;
                androidx.core.view.ViewCompat.offsetTopAndBottom(v, -i6);
                setStateInternal(4);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i2;
                androidx.core.view.ViewCompat.offsetTopAndBottom(v, -i2);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(v.getTop());
        this.lastNestedScrollDy = i2;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, @androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4, int i5, @androidx.annotation.NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, @androidx.annotation.NonNull android.os.Parcelable parcelable) {
        com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState savedState = (com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i = savedState.state;
        if (i == 1 || i == 2) {
            this.state = 4;
        } else {
            this.state = i;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @androidx.annotation.NonNull
    public android.os.Parcelable onSaveInstanceState(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v) {
        return new com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState(super.onSaveInstanceState(coordinatorLayout, v), (com.google.android.material.bottomsheet.BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, @androidx.annotation.NonNull android.view.View view, int i) {
        int i2;
        int i3 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        java.lang.ref.WeakReference<android.view.View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i2 = this.fitToContentsOffset;
                } else {
                    int top = v.getTop();
                    int i4 = this.halfExpandedOffset;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = getExpandedOffset();
                    }
                }
            } else if (this.hideable && shouldHide(v, getYVelocity())) {
                i2 = this.parentHeight;
                i3 = 5;
            } else if (this.lastNestedScrollDy == 0) {
                int top2 = v.getTop();
                if (!this.fitToContents) {
                    int i5 = this.halfExpandedOffset;
                    if (top2 < i5) {
                        if (top2 < java.lang.Math.abs(top2 - this.collapsedOffset)) {
                            i2 = getExpandedOffset();
                        } else {
                            i2 = this.halfExpandedOffset;
                        }
                    } else if (java.lang.Math.abs(top2 - i5) < java.lang.Math.abs(top2 - this.collapsedOffset)) {
                        i2 = this.halfExpandedOffset;
                    } else {
                        i2 = this.collapsedOffset;
                        i3 = 4;
                    }
                    i3 = 6;
                } else if (java.lang.Math.abs(top2 - this.fitToContentsOffset) < java.lang.Math.abs(top2 - this.collapsedOffset)) {
                    i2 = this.fitToContentsOffset;
                } else {
                    i2 = this.collapsedOffset;
                    i3 = 4;
                }
            } else {
                if (this.fitToContents) {
                    i2 = this.collapsedOffset;
                } else {
                    int top3 = v.getTop();
                    if (java.lang.Math.abs(top3 - this.halfExpandedOffset) < java.lang.Math.abs(top3 - this.collapsedOffset)) {
                        i2 = this.halfExpandedOffset;
                        i3 = 6;
                    } else {
                        i2 = this.collapsedOffset;
                    }
                }
                i3 = 4;
            }
            startSettlingAnimation(v, i3, i2, false);
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, @androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        androidx.customview.widget.ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = android.view.VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (this.viewDragHelper != null && actionMasked == 2 && !this.ignoreEvents && java.lang.Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.getTouchSlop()) {
            this.viewDragHelper.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@androidx.annotation.NonNull com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    @java.lang.Deprecated
    public void setBottomSheetCallback(com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
    }

    public void setExpandedOffset(int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.expandedOffset = i;
    }

    public void setFitToContents(boolean z) {
        if (this.fitToContents == z) {
            return;
        }
        this.fitToContents = z;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
        updateAccessibilityActions();
    }

    public void setGestureInsetBottomIgnored(boolean z) {
        this.gestureInsetBottomIgnored = z;
    }

    public void setHalfExpandedRatio(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new java.lang.IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setMaxWidth(@androidx.annotation.Px int i) {
        this.maxWidth = i;
    }

    public void setPeekHeight(int i) {
        setPeekHeight(i, false);
    }

    public final void setPeekHeight(int i, boolean z) {
        boolean z2 = true;
        if (i == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
            }
            z2 = false;
        } else {
            if (this.peekHeightAuto || this.peekHeight != i) {
                this.peekHeightAuto = false;
                this.peekHeight = java.lang.Math.max(0, i);
            }
            z2 = false;
        }
        if (z2) {
            updatePeekHeight(z);
        }
    }

    public void setSaveFlags(int i) {
        this.saveFlags = i;
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public void setState(int i) {
        if (i == this.state) {
            return;
        }
        if (this.viewRef != null) {
            settleToStatePendingLayout(i);
            return;
        }
        if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
            this.state = i;
        }
    }

    public void setStateInternal(int i) {
        V v;
        if (this.state == i) {
            return;
        }
        this.state = i;
        java.lang.ref.WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            updateImportantForAccessibility(true);
        } else if (i == 6 || i == 5 || i == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i);
        for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
            this.callbacks.get(i2).onStateChanged(v, i);
        }
        updateAccessibilityActions();
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z) {
        this.updateImportantForAccessibilityOnSiblings = z;
    }

    public void settleToState(@androidx.annotation.NonNull android.view.View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.collapsedOffset;
        } else if (i == 6) {
            i2 = this.halfExpandedOffset;
            if (this.fitToContents && i2 <= (i3 = this.fitToContentsOffset)) {
                i2 = i3;
                i = 3;
            }
        } else if (i == 3) {
            i2 = getExpandedOffset();
        } else {
            if (!this.hideable || i != 5) {
                throw new java.lang.IllegalArgumentException("Illegal state argument: " + i);
            }
            i2 = this.parentHeight;
        }
        startSettlingAnimation(view, i, i2, false);
    }

    public boolean shouldHide(@androidx.annotation.NonNull android.view.View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        return java.lang.Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f;
    }

    public void startSettlingAnimation(android.view.View view, int i, int i2, boolean z) {
        androidx.customview.widget.ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (!(viewDragHelper != null && (!z ? !viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i2) : !viewDragHelper.settleCapturedViewAt(view.getLeft(), i2)))) {
            setStateInternal(i);
            return;
        }
        setStateInternal(2);
        updateDrawableForTargetState(i);
        if (this.settleRunnable == null) {
            this.settleRunnable = new com.google.android.material.bottomsheet.BottomSheetBehavior.SettleRunnable(view, i);
        }
        if (((com.google.android.material.bottomsheet.BottomSheetBehavior.SettleRunnable) this.settleRunnable).isPosted) {
            this.settleRunnable.targetState = i;
            return;
        }
        com.google.android.material.bottomsheet.BottomSheetBehavior<V>.SettleRunnable settleRunnable = this.settleRunnable;
        settleRunnable.targetState = i;
        androidx.core.view.ViewCompat.postOnAnimation(view, settleRunnable);
        ((com.google.android.material.bottomsheet.BottomSheetBehavior.SettleRunnable) this.settleRunnable).isPosted = true;
    }
}
