package androidx.slidingpanelayout.widget;

/* loaded from: classes.dex */
public class SlidingPaneLayout extends android.view.ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final java.lang.String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    final androidx.customview.widget.ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private java.lang.reflect.Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final java.util.ArrayList<androidx.slidingpanelayout.widget.SlidingPaneLayout.DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    private java.lang.reflect.Field mRecreateDisplayList;
    private android.graphics.drawable.Drawable mShadowDrawableLeft;
    private android.graphics.drawable.Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    android.view.View mSlideableView;
    private int mSliderFadeColor;
    private final android.graphics.Rect mTmpRect;

    public class AccessibilityDelegate extends androidx.core.view.AccessibilityDelegateCompat {
        private final android.graphics.Rect mTmpRect = new android.graphics.Rect();

        public AccessibilityDelegate() {
        }

        private void copyNodeInfoNoChildren(androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            android.graphics.Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(android.view.View view) {
            return androidx.slidingpanelayout.widget.SlidingPaneLayout.this.isDimmed(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(androidx.slidingpanelayout.widget.SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat obtain = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(androidx.slidingpanelayout.widget.SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            java.lang.Object parentForAccessibility = androidx.core.view.ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof android.view.View) {
                accessibilityNodeInfoCompat.setParent((android.view.View) parentForAccessibility);
            }
            int childCount = androidx.slidingpanelayout.widget.SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = androidx.slidingpanelayout.widget.SlidingPaneLayout.this.getChildAt(i);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    androidx.core.view.ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            if (filter(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    public class DisableLayerRunnable implements java.lang.Runnable {
        final android.view.View mChildView;

        public DisableLayerRunnable(android.view.View view) {
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == androidx.slidingpanelayout.widget.SlidingPaneLayout.this) {
                this.mChildView.setLayerType(0, null);
                androidx.slidingpanelayout.widget.SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    public class DragHelperCallback extends androidx.customview.widget.ViewDragHelper.Callback {
        public DragHelperCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(android.view.View view, int i, int i2) {
            androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (androidx.slidingpanelayout.widget.SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int width = androidx.slidingpanelayout.widget.SlidingPaneLayout.this.getWidth() - ((androidx.slidingpanelayout.widget.SlidingPaneLayout.this.getPaddingRight() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideableView.getWidth());
                return java.lang.Math.max(java.lang.Math.min(i, width), width - androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideRange);
            }
            int paddingLeft = androidx.slidingpanelayout.widget.SlidingPaneLayout.this.getPaddingLeft() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            return java.lang.Math.min(java.lang.Math.max(i, paddingLeft), androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(android.view.View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(android.view.View view) {
            return androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            androidx.slidingpanelayout.widget.SlidingPaneLayout slidingPaneLayout = androidx.slidingpanelayout.widget.SlidingPaneLayout.this;
            slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(android.view.View view, int i) {
            androidx.slidingpanelayout.widget.SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                androidx.slidingpanelayout.widget.SlidingPaneLayout slidingPaneLayout = androidx.slidingpanelayout.widget.SlidingPaneLayout.this;
                if (slidingPaneLayout.mSlideOffset != 0.0f) {
                    slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                    androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mPreservedOpenState = true;
                } else {
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    androidx.slidingpanelayout.widget.SlidingPaneLayout slidingPaneLayout2 = androidx.slidingpanelayout.widget.SlidingPaneLayout.this;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mPreservedOpenState = false;
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(android.view.View view, int i, int i2, int i3, int i4) {
            androidx.slidingpanelayout.widget.SlidingPaneLayout.this.onPanelDragged(i);
            androidx.slidingpanelayout.widget.SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(android.view.View view, float f, float f2) {
            int paddingLeft;
            androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams();
            if (androidx.slidingpanelayout.widget.SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = androidx.slidingpanelayout.widget.SlidingPaneLayout.this.getPaddingRight() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f < 0.0f || (f == 0.0f && androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideRange;
                }
                paddingLeft = (androidx.slidingpanelayout.widget.SlidingPaneLayout.this.getWidth() - paddingRight) - androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                paddingLeft = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin + androidx.slidingpanelayout.widget.SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingLeft += androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mSlideRange;
                }
            }
            androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
            androidx.slidingpanelayout.widget.SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(android.view.View view, int i) {
            if (androidx.slidingpanelayout.widget.SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {android.R.attr.layout_weight};
        android.graphics.Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.weight = 0.0f;
        }

        public LayoutParams(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.weight = 0.0f;
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(@androidx.annotation.NonNull android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@androidx.annotation.NonNull android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@androidx.annotation.NonNull androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams) {
            super((android.view.ViewGroup.MarginLayoutParams) layoutParams);
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(@androidx.annotation.NonNull android.view.View view);

        void onPanelOpened(@androidx.annotation.NonNull android.view.View view);

        void onPanelSlide(@androidx.annotation.NonNull android.view.View view, float f);
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState> CREATOR = new androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.AnonymousClass1();
        boolean isOpen;

        /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState> {
            @Override // android.os.Parcelable.Creator
            public androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState[] newArray(int i) {
                return new androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState[i];
            }
        }

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }
    }

    public static class SimplePanelSlideListener implements androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(android.view.View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(android.view.View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(android.view.View view, float f) {
        }
    }

    public SlidingPaneLayout(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new android.graphics.Rect();
        this.mPostedRunnables = new java.util.ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this, new androidx.slidingpanelayout.widget.SlidingPaneLayout.AccessibilityDelegate());
        androidx.core.view.ViewCompat.setImportantForAccessibility(this, 1);
        androidx.customview.widget.ViewDragHelper create = androidx.customview.widget.ViewDragHelper.create(this, 0.5f, new androidx.slidingpanelayout.widget.SlidingPaneLayout.DragHelperCallback());
        this.mDragHelper = create;
        create.setMinVelocity(f * 400.0f);
    }

    private boolean closePane(android.view.View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, i)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(android.view.View view, float f, int i) {
        androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & 16777215);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new android.graphics.Paint();
            }
            layoutParams.dimPaint.setColorFilter(new android.graphics.PorterDuffColorFilter(i2, android.graphics.PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view);
            return;
        }
        if (view.getLayerType() != 0) {
            android.graphics.Paint paint = layoutParams.dimPaint;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            androidx.slidingpanelayout.widget.SlidingPaneLayout.DisableLayerRunnable disableLayerRunnable = new androidx.slidingpanelayout.widget.SlidingPaneLayout.DisableLayerRunnable(view);
            this.mPostedRunnables.add(disableLayerRunnable);
            androidx.core.view.ViewCompat.postOnAnimation(this, disableLayerRunnable);
        }
    }

    private boolean openPane(android.view.View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parallaxOtherViews(float f) {
        boolean z;
        int childCount;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) this.mSlideableView.getLayoutParams();
        if (layoutParams.dimWhenOffset) {
            if ((isLayoutRtlSupport ? ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin) <= 0) {
                z = true;
                childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    android.view.View childAt = getChildAt(i);
                    if (childAt != this.mSlideableView) {
                        float f2 = 1.0f - this.mParallaxOffset;
                        int i2 = this.mParallaxBy;
                        this.mParallaxOffset = f;
                        int i3 = ((int) (f2 * i2)) - ((int) ((1.0f - f) * i2));
                        if (isLayoutRtlSupport) {
                            i3 = -i3;
                        }
                        childAt.offsetLeftAndRight(i3);
                        if (z) {
                            float f3 = this.mParallaxOffset;
                            dimChildView(childAt, isLayoutRtlSupport ? f3 - 1.0f : 1.0f - f3, this.mCoveredFadeColor);
                        }
                    }
                }
            }
        }
        z = false;
        childCount = getChildCount();
        while (i < childCount) {
        }
    }

    private static boolean viewIsOpaque(android.view.View view) {
        return view.isOpaque();
    }

    public boolean canScroll(android.view.View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                android.view.View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z) {
            if (view.canScrollHorizontally(isLayoutRtlSupport() ? i : -i)) {
                return true;
            }
        }
        return false;
    }

    @java.lang.Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (this.mCanSlide) {
                androidx.core.view.ViewCompat.postInvalidateOnAnimation(this);
            } else {
                this.mDragHelper.abort();
            }
        }
    }

    public void dispatchOnPanelClosed(android.view.View view) {
        androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelOpened(android.view.View view) {
        androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelSlide(android.view.View view) {
        androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        int i;
        int i2;
        super.draw(canvas);
        android.graphics.drawable.Drawable drawable = isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        android.view.View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isLayoutRtlSupport()) {
            i2 = childAt.getRight();
            i = intrinsicWidth + i2;
        } else {
            int left = childAt.getLeft();
            int i3 = left - intrinsicWidth;
            i = left;
            i2 = i3;
        }
        drawable.setBounds(i2, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j) {
        androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                android.graphics.Rect rect = this.mTmpRect;
                rect.left = java.lang.Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                android.graphics.Rect rect2 = this.mTmpRect;
                rect2.right = java.lang.Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams();
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof android.view.ViewGroup.MarginLayoutParams ? new androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams((android.view.ViewGroup.MarginLayoutParams) layoutParams) : new androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams(layoutParams);
    }

    @androidx.annotation.ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    @androidx.annotation.Px
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @androidx.annotation.ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public void invalidateChildRegion(android.view.View view) {
        androidx.core.view.ViewCompat.setLayerPaint(view, ((androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams()).dimPaint);
    }

    public boolean isDimmed(android.view.View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) view.getLayoutParams()).dimWhenOffset && this.mSlideOffset > 0.0f;
    }

    public boolean isLayoutRtlSupport() {
        return androidx.core.view.ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            this.mPostedRunnables.get(i).run();
        }
        this.mPostedRunnables.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        boolean z;
        android.view.View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        }
        if (actionMasked == 0) {
            this.mIsUnableToDrag = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                z = true;
                return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || z;
            }
        } else if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float abs = java.lang.Math.abs(x2 - this.mInitialMotionX);
            float abs2 = java.lang.Math.abs(y2 - this.mInitialMotionY);
            if (abs > this.mDragHelper.getTouchSlop() && abs2 > abs) {
                this.mDragHelper.cancel();
                this.mIsUnableToDrag = true;
                return false;
            }
        }
        z = false;
        if (this.mDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        if (isLayoutRtlSupport) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int i9 = i3 - i;
        int paddingRight = isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (this.mCanSlide && this.mPreservedOpenState) ? 1.0f : 0.0f;
        }
        int i10 = paddingRight;
        for (int i11 = 0; i11 < childCount; i11++) {
            android.view.View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int i12 = i9 - paddingLeft;
                    int min = (java.lang.Math.min(paddingRight, i12 - this.mOverhangSize) - i10) - (((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.mSlideRange = min;
                    int i13 = isLayoutRtlSupport ? ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    layoutParams.dimWhenOffset = ((i10 + i13) + min) + (measuredWidth / 2) > i12;
                    int i14 = (int) (min * this.mSlideOffset);
                    i10 += i13 + i14;
                    this.mSlideOffset = i14 / min;
                    i5 = 0;
                } else if (!this.mCanSlide || (i6 = this.mParallaxBy) == 0) {
                    i10 = paddingRight;
                    i5 = 0;
                } else {
                    i5 = (int) ((1.0f - this.mSlideOffset) * i6);
                    i10 = paddingRight;
                }
                if (isLayoutRtlSupport) {
                    i8 = (i9 - i10) + i5;
                    i7 = i8 - measuredWidth;
                } else {
                    i7 = i10 - i5;
                    i8 = i7 + measuredWidth;
                }
                childAt.layout(i7, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                paddingRight += childAt.getWidth();
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i15 = 0; i15 < childCount; i15++) {
                    dimChildView(getChildAt(i15), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int paddingTop;
        int i3;
        int i4;
        int makeMeasureSpec;
        int i5;
        int i6;
        int makeMeasureSpec2;
        float f;
        int i7;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int mode = android.view.View.MeasureSpec.getMode(i);
        int size = android.view.View.MeasureSpec.getSize(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new java.lang.IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new java.lang.IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i3 = 0;
        } else if (mode2 != 1073741824) {
            i3 = 0;
            paddingTop = 0;
        } else {
            i3 = (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = i3;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.mSlideableView = null;
        int i8 = paddingLeft;
        int i9 = 0;
        boolean z2 = false;
        float f2 = 0.0f;
        while (true) {
            i4 = 8;
            if (i9 >= childCount) {
                break;
            }
            android.view.View childAt = getChildAt(i9);
            androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = z;
            } else {
                float f3 = layoutParams.weight;
                if (f3 > 0.0f) {
                    f2 += f3;
                    if (((android.view.ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                }
                int i10 = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int i11 = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i11 == -2) {
                    makeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(paddingLeft - i10, Integer.MIN_VALUE);
                    f = f2;
                    i7 = Integer.MIN_VALUE;
                } else {
                    f = f2;
                    i7 = Integer.MIN_VALUE;
                    makeMeasureSpec3 = i11 == -1 ? android.view.View.MeasureSpec.makeMeasureSpec(paddingLeft - i10, 1073741824) : android.view.View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
                }
                int i12 = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i12 == -2) {
                    makeMeasureSpec4 = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, i7);
                } else {
                    makeMeasureSpec4 = i12 == -1 ? android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824) : android.view.View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i7 && measuredHeight > i3) {
                    i3 = java.lang.Math.min(measuredHeight, paddingTop);
                }
                i8 -= measuredWidth;
                boolean z3 = i8 < 0;
                layoutParams.slideable = z3;
                z2 |= z3;
                if (z3) {
                    this.mSlideableView = childAt;
                }
                f2 = f;
            }
            i9++;
            z = false;
        }
        if (z2 || f2 > 0.0f) {
            int i13 = paddingLeft - this.mOverhangSize;
            int i14 = 0;
            while (i14 < childCount) {
                android.view.View childAt2 = getChildAt(i14);
                if (childAt2.getVisibility() != i4) {
                    androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams2 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i4) {
                        boolean z4 = ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f;
                        int measuredWidth2 = z4 ? 0 : childAt2.getMeasuredWidth();
                        if (!z2 || childAt2 == this.mSlideableView) {
                            if (layoutParams2.weight > 0.0f) {
                                if (((android.view.ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                    int i15 = ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    makeMeasureSpec = i15 == -2 ? android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE) : i15 == -1 ? android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824) : android.view.View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                                } else {
                                    makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i16 = paddingLeft - (((android.view.ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                    i5 = i13;
                                    int makeMeasureSpec5 = android.view.View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                    if (measuredWidth2 != i16) {
                                        childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                    }
                                    i14++;
                                    i13 = i5;
                                    i4 = 8;
                                } else {
                                    i5 = i13;
                                    childAt2.measure(android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((layoutParams2.weight * java.lang.Math.max(0, i8)) / f2)), 1073741824), makeMeasureSpec);
                                    i14++;
                                    i13 = i5;
                                    i4 = 8;
                                }
                            }
                        } else if (((android.view.ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth2 > i13 || layoutParams2.weight > 0.0f)) {
                            if (z4) {
                                int i17 = ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).height;
                                if (i17 == -2) {
                                    makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    i6 = 1073741824;
                                } else if (i17 == -1) {
                                    i6 = 1073741824;
                                    makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    i6 = 1073741824;
                                    makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                                }
                            } else {
                                i6 = 1073741824;
                                makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(android.view.View.MeasureSpec.makeMeasureSpec(i13, i6), makeMeasureSpec2);
                        }
                    }
                }
                i5 = i13;
                i14++;
                i13 = i5;
                i4 = 8;
            }
        }
        setMeasuredDimension(size, i3 + getPaddingTop() + getPaddingBottom());
        this.mCanSlide = z2;
        if (this.mDragHelper.getViewDragState() == 0 || z2) {
            return;
        }
        this.mDragHelper.abort();
    }

    public void onPanelDragged(int i) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (isLayoutRtlSupport) {
            i = (getWidth() - i) - width;
        }
        float paddingRight = (i - ((isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (isLayoutRtlSupport ? ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin))) / this.mSlideRange;
        this.mSlideOffset = paddingRight;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(paddingRight);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState savedState = (androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState savedState = new androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState(super.onSaveInstanceState());
        savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
        } else if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x2 - this.mInitialMotionX;
            float f2 = y2 - this.mInitialMotionY;
            int touchSlop = this.mDragHelper.getTouchSlop();
            if ((f * f) + (f2 * f2) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2)) {
                closePane(this.mSlideableView, 0);
            }
        }
        return true;
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(android.view.View view, android.view.View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.mCanSlide) {
            return;
        }
        this.mPreservedOpenState = view == this.mSlideableView;
    }

    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@androidx.annotation.ColorInt int i) {
        this.mCoveredFadeColor = i;
    }

    public void setPanelSlideListener(@androidx.annotation.Nullable androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(@androidx.annotation.Px int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    @java.lang.Deprecated
    public void setShadowDrawable(android.graphics.drawable.Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @java.lang.Deprecated
    public void setShadowResource(@androidx.annotation.DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(androidx.core.content.ContextCompat.getDrawable(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(androidx.core.content.ContextCompat.getDrawable(getContext(), i));
    }

    public void setSliderFadeColor(@androidx.annotation.ColorInt int i) {
        this.mSliderFadeColor = i;
    }

    @java.lang.Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @java.lang.Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean smoothSlideTo(float f, int i) {
        int paddingLeft;
        if (!this.mCanSlide) {
            return false;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams layoutParams = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) this.mSlideableView.getLayoutParams();
        if (isLayoutRtlSupport) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (f * this.mSlideRange)) + this.mSlideableView.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (f * this.mSlideRange));
        }
        androidx.customview.widget.ViewDragHelper viewDragHelper = this.mDragHelper;
        android.view.View view = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo(view, paddingLeft, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        androidx.core.view.ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    public void updateObscuredViewsVisibility(android.view.View view) {
        int i;
        int i2;
        int i3;
        int i4;
        android.view.View childAt;
        boolean z;
        android.view.View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int width = isLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i = view.getLeft();
            i2 = view.getRight();
            i3 = view.getTop();
            i4 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount && (childAt = getChildAt(i5)) != view2) {
            if (childAt.getVisibility() == 8) {
                z = isLayoutRtlSupport;
            } else {
                z = isLayoutRtlSupport;
                childAt.setVisibility((java.lang.Math.max(isLayoutRtlSupport ? paddingLeft : width, childAt.getLeft()) < i || java.lang.Math.max(paddingTop, childAt.getTop()) < i3 || java.lang.Math.min(isLayoutRtlSupport ? width : paddingLeft, childAt.getRight()) > i2 || java.lang.Math.min(height, childAt.getBottom()) > i4) ? 0 : 4);
            }
            i5++;
            view2 = view;
            isLayoutRtlSupport = z;
        }
    }
}
