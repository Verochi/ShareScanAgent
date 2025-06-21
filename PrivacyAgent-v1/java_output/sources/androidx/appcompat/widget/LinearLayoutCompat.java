package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends android.view.ViewGroup {
    private static final java.lang.String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private android.graphics.drawable.Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DividerMode {
    }

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = com.google.android.material.badge.BadgeDrawable.TOP_START;
        int[] iArr = androidx.appcompat.R.styleable.LinearLayoutCompat;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        androidx.core.view.ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            android.view.View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                if (((android.widget.LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i4 = ((android.widget.LinearLayout.LayoutParams) layoutParams).width;
                    ((android.widget.LinearLayout.LayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    ((android.widget.LinearLayout.LayoutParams) layoutParams).width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            android.view.View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                if (((android.widget.LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i4 = ((android.widget.LinearLayout.LayoutParams) layoutParams).height;
                    ((android.widget.LinearLayout.LayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    ((android.widget.LinearLayout.LayoutParams) layoutParams).height = i4;
                }
            }
        }
    }

    private void setChildFrame(android.view.View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
    }

    void drawDividersHorizontal(android.graphics.Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = androidx.appcompat.widget.ViewUtils.isLayoutRtl(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            android.view.View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, isLayoutRtl ? virtualChildAt.getRight() + ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin : (virtualChildAt.getLeft() - ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            android.view.View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams2 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft() - ((android.widget.LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i = this.mDividerWidth;
                    right = left - i;
                } else {
                    right = virtualChildAt2.getRight() + ((android.widget.LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (isLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.mDividerWidth;
                right = left - i;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawDividersVertical(android.graphics.Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            android.view.View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((android.widget.LinearLayout.LayoutParams) ((androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            android.view.View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((android.widget.LinearLayout.LayoutParams) ((androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin);
        }
    }

    void drawHorizontalDivider(android.graphics.Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(android.graphics.Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new androidx.appcompat.widget.LinearLayoutCompat.LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new androidx.appcompat.widget.LinearLayoutCompat.LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.LinearLayoutCompat.LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new androidx.appcompat.widget.LinearLayoutCompat.LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new java.lang.RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        android.view.View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new java.lang.RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i3 = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return i3 + ((android.widget.LinearLayout.LayoutParams) ((androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount(android.view.View view, int i) {
        return 0;
    }

    public android.graphics.drawable.Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset(android.view.View view) {
        return 0;
    }

    public int getNextLocationOffset(android.view.View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public android.view.View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean isLayoutRtl = androidx.appcompat.widget.ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i14 = i4 - i2;
        int paddingBottom = i14 - getPaddingBottom();
        int paddingBottom2 = (i14 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i15 = this.mGravity;
        int i16 = i15 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = androidx.core.view.GravityCompat.getAbsoluteGravity(8388615 & i15, androidx.core.view.ViewCompat.getLayoutDirection(this));
        int paddingLeft = absoluteGravity != 1 ? absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.mTotalLength : getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        if (isLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i17 = 0;
        while (i17 < virtualChildCount) {
            int i18 = i5 + (i6 * i17);
            android.view.View virtualChildAt = getVirtualChildAt(i18);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i18);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                int i19 = i17;
                if (z) {
                    i7 = virtualChildCount;
                    if (((android.widget.LinearLayout.LayoutParams) layoutParams).height != -1) {
                        i8 = virtualChildAt.getBaseline();
                        i9 = ((android.widget.LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i9 < 0) {
                            i9 = i16;
                        }
                        i10 = i9 & 112;
                        i11 = i16;
                        if (i10 != 16) {
                            i12 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin) - ((android.widget.LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        } else if (i10 == 48) {
                            i12 = ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                            if (i8 != -1) {
                                i12 += iArr[1] - i8;
                            }
                        } else if (i10 != 80) {
                            i12 = paddingTop;
                        } else {
                            i12 = (paddingBottom - measuredHeight) - ((android.widget.LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if (i8 != -1) {
                                i12 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i8);
                            }
                        }
                        if (hasDividerBeforeChildAt(i18)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i20 = ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                        i13 = paddingTop;
                        setChildFrame(virtualChildAt, i20 + getLocationOffset(virtualChildAt), i12, measuredWidth, measuredHeight);
                        int nextLocationOffset = i20 + measuredWidth + ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                        i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                        paddingLeft = nextLocationOffset;
                        i17++;
                        virtualChildCount = i7;
                        i16 = i11;
                        paddingTop = i13;
                    }
                } else {
                    i7 = virtualChildCount;
                }
                i8 = -1;
                i9 = ((android.widget.LinearLayout.LayoutParams) layoutParams).gravity;
                if (i9 < 0) {
                }
                i10 = i9 & 112;
                i11 = i16;
                if (i10 != 16) {
                }
                if (hasDividerBeforeChildAt(i18)) {
                }
                int i202 = ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                i13 = paddingTop;
                setChildFrame(virtualChildAt, i202 + getLocationOffset(virtualChildAt), i12, measuredWidth, measuredHeight);
                int nextLocationOffset2 = i202 + measuredWidth + ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                paddingLeft = nextLocationOffset2;
                i17++;
                virtualChildCount = i7;
                i16 = i11;
                paddingTop = i13;
            }
            i13 = paddingTop;
            i7 = virtualChildCount;
            i11 = i16;
            i17++;
            virtualChildCount = i7;
            i16 = i11;
            paddingTop = i13;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.mGravity;
        int i10 = i9 & 112;
        int i11 = i9 & androidx.core.view.GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i10 != 16 ? i10 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength : getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        int i12 = 0;
        while (i12 < virtualChildCount) {
            android.view.View virtualChildAt = getVirtualChildAt(i12);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i12);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                int i13 = ((android.widget.LinearLayout.LayoutParams) layoutParams).gravity;
                if (i13 < 0) {
                    i13 = i11;
                }
                int absoluteGravity = androidx.core.view.GravityCompat.getAbsoluteGravity(i13, androidx.core.view.ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin;
                    i6 = ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else if (absoluteGravity != 5) {
                    i7 = ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    int i14 = i7;
                    if (hasDividerBeforeChildAt(i12)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i15 = paddingTop + ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin;
                    setChildFrame(virtualChildAt, i14, i15 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    int nextLocationOffset = i15 + measuredHeight + ((android.widget.LinearLayout.LayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                    i12 += getChildrenSkipCount(virtualChildAt, i12);
                    paddingTop = nextLocationOffset;
                } else {
                    i5 = paddingRight - measuredWidth;
                    i6 = ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin;
                }
                i7 = i5 - i6;
                int i142 = i7;
                if (hasDividerBeforeChildAt(i12)) {
                }
                int i152 = paddingTop + ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin;
                setChildFrame(virtualChildAt, i142, i152 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                int nextLocationOffset2 = i152 + measuredHeight + ((android.widget.LinearLayout.LayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                i12 += getChildrenSkipCount(virtualChildAt, i12);
                paddingTop = nextLocationOffset2;
            }
            i12++;
        }
    }

    public void measureChildBeforeLayout(android.view.View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:195:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        int max;
        int i4;
        int i5;
        int max2;
        int i6;
        int i7;
        int i8;
        float f;
        int i9;
        boolean z;
        int baseline;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z2;
        boolean z3;
        android.view.View view;
        int i15;
        boolean z4;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        int i16;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.mBaselineAligned;
        boolean z6 = this.mUseLargestChild;
        int i17 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f2 = 0.0f;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        boolean z8 = false;
        int i23 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            iArr = iArr3;
            if (i18 >= virtualChildCount) {
                break;
            }
            android.view.View virtualChildAt = getVirtualChildAt(i18);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i18);
            } else if (virtualChildAt.getVisibility() == 8) {
                i18 += getChildrenSkipCount(virtualChildAt, i18);
            } else {
                if (hasDividerBeforeChildAt(i18)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                float f3 = ((android.widget.LinearLayout.LayoutParams) layoutParams).weight;
                float f4 = f2 + f3;
                if (mode == i17 && ((android.widget.LinearLayout.LayoutParams) layoutParams).width == 0 && f3 > 0.0f) {
                    if (z7) {
                        this.mTotalLength += ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else {
                        int i24 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i24, ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin + i24 + ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin);
                    }
                    if (z5) {
                        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i14 = i18;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                    } else {
                        i14 = i18;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                        i15 = 1073741824;
                        z8 = true;
                        if (mode2 == i15 && ((android.widget.LinearLayout.LayoutParams) layoutParams).height == -1) {
                            z4 = true;
                            z10 = true;
                        } else {
                            z4 = false;
                        }
                        int i25 = ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i25;
                        i23 = android.view.View.combineMeasuredStates(i23, view.getMeasuredState());
                        if (z3 && (baseline2 = view.getBaseline()) != -1) {
                            i16 = ((android.widget.LinearLayout.LayoutParams) layoutParams).gravity;
                            if (i16 < 0) {
                                i16 = this.mGravity;
                            }
                            int i26 = (((i16 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i26] = java.lang.Math.max(iArr2[i26], baseline2);
                            iArr[i26] = java.lang.Math.max(iArr[i26], measuredHeight - baseline2);
                        }
                        i20 = java.lang.Math.max(i20, measuredHeight);
                        z9 = !z9 && ((android.widget.LinearLayout.LayoutParams) layoutParams).height == -1;
                        if (((android.widget.LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                            if (!z4) {
                                i25 = measuredHeight;
                            }
                            i22 = java.lang.Math.max(i22, i25);
                        } else {
                            int i27 = i22;
                            if (!z4) {
                                i25 = measuredHeight;
                            }
                            i21 = java.lang.Math.max(i21, i25);
                            i22 = i27;
                        }
                        int i28 = i14;
                        childrenSkipCount = getChildrenSkipCount(view, i28) + i28;
                        f2 = f4;
                        i18 = childrenSkipCount + 1;
                        iArr3 = iArr;
                        z6 = z2;
                        z5 = z3;
                        i17 = 1073741824;
                    }
                } else {
                    if (((android.widget.LinearLayout.LayoutParams) layoutParams).width != 0 || f3 <= 0.0f) {
                        i13 = Integer.MIN_VALUE;
                    } else {
                        ((android.widget.LinearLayout.LayoutParams) layoutParams).width = -2;
                        i13 = 0;
                    }
                    i14 = i18;
                    int i29 = i13;
                    z2 = z6;
                    z3 = z5;
                    measureChildBeforeLayout(virtualChildAt, i14, i, f4 == 0.0f ? this.mTotalLength : 0, i2, 0);
                    if (i29 != Integer.MIN_VALUE) {
                        ((android.widget.LinearLayout.LayoutParams) layoutParams).width = i29;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z7) {
                        view = virtualChildAt;
                        this.mTotalLength += ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth + ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i30 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i30, i30 + measuredWidth + ((android.widget.LinearLayout.LayoutParams) layoutParams).leftMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(view));
                    }
                    if (z2) {
                        i19 = java.lang.Math.max(measuredWidth, i19);
                    }
                }
                i15 = 1073741824;
                if (mode2 == i15) {
                }
                z4 = false;
                int i252 = ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i252;
                i23 = android.view.View.combineMeasuredStates(i23, view.getMeasuredState());
                if (z3) {
                    i16 = ((android.widget.LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i16 < 0) {
                    }
                    int i262 = (((i16 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i262] = java.lang.Math.max(iArr2[i262], baseline2);
                    iArr[i262] = java.lang.Math.max(iArr[i262], measuredHeight - baseline2);
                }
                i20 = java.lang.Math.max(i20, measuredHeight);
                if (z9) {
                }
                if (((android.widget.LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                }
                int i282 = i14;
                childrenSkipCount = getChildrenSkipCount(view, i282) + i282;
                f2 = f4;
                i18 = childrenSkipCount + 1;
                iArr3 = iArr;
                z6 = z2;
                z5 = z3;
                i17 = 1073741824;
            }
            childrenSkipCount = i18;
            z2 = z6;
            z3 = z5;
            i18 = childrenSkipCount + 1;
            iArr3 = iArr;
            z6 = z2;
            z5 = z3;
            i17 = 1073741824;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int i31 = i20;
        int i32 = i21;
        int i33 = i22;
        int i34 = i23;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        int i35 = iArr2[1];
        if (i35 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i31;
            i3 = i34;
        } else {
            i3 = i34;
            max = java.lang.Math.max(i31, java.lang.Math.max(iArr2[3], java.lang.Math.max(iArr2[0], java.lang.Math.max(i35, iArr2[2]))) + java.lang.Math.max(iArr[3], java.lang.Math.max(iArr[0], java.lang.Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i36 = 0;
            while (i36 < virtualChildCount) {
                android.view.View virtualChildAt2 = getVirtualChildAt(i36);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i36);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i36 += getChildrenSkipCount(virtualChildAt2, i36);
                } else {
                    androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams2 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z7) {
                        this.mTotalLength += ((android.widget.LinearLayout.LayoutParams) layoutParams2).leftMargin + i19 + ((android.widget.LinearLayout.LayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i37 = this.mTotalLength;
                        i12 = max;
                        this.mTotalLength = java.lang.Math.max(i37, i37 + i19 + ((android.widget.LinearLayout.LayoutParams) layoutParams2).leftMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2));
                        i36++;
                        max = i12;
                    }
                }
                i12 = max;
                i36++;
                max = i12;
            }
        }
        int i38 = max;
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = android.view.View.resolveSizeAndState(java.lang.Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i39 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z8 || (i39 != 0 && f2 > 0.0f)) {
            float f5 = this.mWeightSum;
            if (f5 > 0.0f) {
                f2 = f5;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i40 = i32;
            int i41 = i3;
            int i42 = -1;
            int i43 = 0;
            while (i43 < virtualChildCount) {
                android.view.View virtualChildAt3 = getVirtualChildAt(i43);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i7 = i39;
                    i8 = virtualChildCount;
                } else {
                    androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams3 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = ((android.widget.LinearLayout.LayoutParams) layoutParams3).weight;
                    if (f6 > 0.0f) {
                        int i44 = (int) ((i39 * f6) / f2);
                        float f7 = f2 - f6;
                        int i45 = i39 - i44;
                        i8 = virtualChildCount;
                        int childMeasureSpec = android.view.ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((android.widget.LinearLayout.LayoutParams) layoutParams3).topMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams3).bottomMargin, ((android.widget.LinearLayout.LayoutParams) layoutParams3).height);
                        if (((android.widget.LinearLayout.LayoutParams) layoutParams3).width == 0) {
                            i11 = 1073741824;
                            if (mode == 1073741824) {
                                if (i44 <= 0) {
                                    i44 = 0;
                                }
                                virtualChildAt3.measure(android.view.View.MeasureSpec.makeMeasureSpec(i44, 1073741824), childMeasureSpec);
                                i41 = android.view.View.combineMeasuredStates(i41, virtualChildAt3.getMeasuredState() & androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                                f2 = f7;
                                i7 = i45;
                            }
                        } else {
                            i11 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i44;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth2, i11), childMeasureSpec);
                        i41 = android.view.View.combineMeasuredStates(i41, virtualChildAt3.getMeasuredState() & androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                        f2 = f7;
                        i7 = i45;
                    } else {
                        i7 = i39;
                        i8 = virtualChildCount;
                    }
                    if (z7) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + ((android.widget.LinearLayout.LayoutParams) layoutParams3).leftMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt3);
                        f = f2;
                    } else {
                        int i46 = this.mTotalLength;
                        f = f2;
                        this.mTotalLength = java.lang.Math.max(i46, virtualChildAt3.getMeasuredWidth() + i46 + ((android.widget.LinearLayout.LayoutParams) layoutParams3).leftMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z13 = mode2 != 1073741824 && ((android.widget.LinearLayout.LayoutParams) layoutParams3).height == -1;
                    int i47 = ((android.widget.LinearLayout.LayoutParams) layoutParams3).topMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i47;
                    i42 = java.lang.Math.max(i42, measuredHeight2);
                    if (!z13) {
                        i47 = measuredHeight2;
                    }
                    int max3 = java.lang.Math.max(i40, i47);
                    if (z9) {
                        i9 = -1;
                        if (((android.widget.LinearLayout.LayoutParams) layoutParams3).height == -1) {
                            z = true;
                            if (z12 && (baseline = virtualChildAt3.getBaseline()) != i9) {
                                i10 = ((android.widget.LinearLayout.LayoutParams) layoutParams3).gravity;
                                if (i10 < 0) {
                                    i10 = this.mGravity;
                                }
                                int i48 = (((i10 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i48] = java.lang.Math.max(iArr2[i48], baseline);
                                iArr[i48] = java.lang.Math.max(iArr[i48], measuredHeight2 - baseline);
                            }
                            z9 = z;
                            i40 = max3;
                            f2 = f;
                        }
                    } else {
                        i9 = -1;
                    }
                    z = false;
                    if (z12) {
                        i10 = ((android.widget.LinearLayout.LayoutParams) layoutParams3).gravity;
                        if (i10 < 0) {
                        }
                        int i482 = (((i10 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i482] = java.lang.Math.max(iArr2[i482], baseline);
                        iArr[i482] = java.lang.Math.max(iArr[i482], measuredHeight2 - baseline);
                    }
                    z9 = z;
                    i40 = max3;
                    f2 = f;
                }
                i43++;
                i39 = i7;
                virtualChildCount = i8;
            }
            i4 = i2;
            i5 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            int i49 = iArr2[1];
            max2 = (i49 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i42 : java.lang.Math.max(i42, java.lang.Math.max(iArr2[3], java.lang.Math.max(iArr2[0], java.lang.Math.max(i49, iArr2[2]))) + java.lang.Math.max(iArr[3], java.lang.Math.max(iArr[0], java.lang.Math.max(iArr[1], iArr[2]))));
            i6 = i40;
            i3 = i41;
        } else {
            i6 = java.lang.Math.max(i32, i33);
            if (z11 && mode != 1073741824) {
                for (int i50 = 0; i50 < virtualChildCount; i50++) {
                    android.view.View virtualChildAt4 = getVirtualChildAt(i50);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((android.widget.LinearLayout.LayoutParams) ((androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt4.getLayoutParams())).weight > 0.0f) {
                        virtualChildAt4.measure(android.view.View.MeasureSpec.makeMeasureSpec(i19, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i4 = i2;
            i5 = virtualChildCount;
            max2 = i38;
        }
        if (z9 || mode2 == 1073741824) {
            i6 = max2;
        }
        setMeasuredDimension(resolveSizeAndState | (i3 & androidx.core.view.ViewCompat.MEASURED_STATE_MASK), android.view.View.resolveSizeAndState(java.lang.Math.max(i6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, i3 << 16));
        if (z10) {
            forceUniformHeight(i5, i);
        }
    }

    public int measureNullChild(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0323  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        android.view.View view;
        int max;
        boolean z2;
        int max2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int i19 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        float f = 0.0f;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i26 = 8;
            int i27 = i23;
            if (i25 >= virtualChildCount) {
                int i28 = i20;
                int i29 = i22;
                int i30 = i24;
                int i31 = virtualChildCount;
                int i32 = mode2;
                int i33 = i21;
                if (this.mTotalLength > 0) {
                    i3 = i31;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = i31;
                }
                if (z3 && (i32 == Integer.MIN_VALUE || i32 == 0)) {
                    this.mTotalLength = 0;
                    int i34 = 0;
                    while (i34 < i3) {
                        android.view.View virtualChildAt = getVirtualChildAt(i34);
                        if (virtualChildAt == null) {
                            this.mTotalLength += measureNullChild(i34);
                        } else if (virtualChildAt.getVisibility() == i26) {
                            i34 += getChildrenSkipCount(virtualChildAt, i34);
                        } else {
                            androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt.getLayoutParams();
                            int i35 = this.mTotalLength;
                            this.mTotalLength = java.lang.Math.max(i35, i35 + i29 + ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt));
                        }
                        i34++;
                        i26 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = android.view.View.resolveSizeAndState(java.lang.Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i36 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (z4 || (i36 != 0 && f > 0.0f)) {
                    float f2 = this.mWeightSum;
                    if (f2 > 0.0f) {
                        f = f2;
                    }
                    this.mTotalLength = 0;
                    int i37 = i36;
                    int i38 = i30;
                    i4 = i28;
                    int i39 = 0;
                    while (i39 < i3) {
                        android.view.View virtualChildAt2 = getVirtualChildAt(i39);
                        if (virtualChildAt2.getVisibility() == 8) {
                            i7 = i37;
                        } else {
                            androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams2 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt2.getLayoutParams();
                            float f3 = ((android.widget.LinearLayout.LayoutParams) layoutParams2).weight;
                            if (f3 > 0.0f) {
                                int i40 = (int) ((i37 * f3) / f);
                                float f4 = f - f3;
                                i7 = i37 - i40;
                                int childMeasureSpec = android.view.ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((android.widget.LinearLayout.LayoutParams) layoutParams2).leftMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams2).rightMargin, ((android.widget.LinearLayout.LayoutParams) layoutParams2).width);
                                if (((android.widget.LinearLayout.LayoutParams) layoutParams2).height == 0) {
                                    i10 = 1073741824;
                                    if (i32 == 1073741824) {
                                        if (i40 <= 0) {
                                            i40 = 0;
                                        }
                                        virtualChildAt2.measure(childMeasureSpec, android.view.View.MeasureSpec.makeMeasureSpec(i40, 1073741824));
                                        i4 = android.view.View.combineMeasuredStates(i4, virtualChildAt2.getMeasuredState() & androidx.core.view.InputDeviceCompat.SOURCE_ANY);
                                        f = f4;
                                    }
                                } else {
                                    i10 = 1073741824;
                                }
                                int measuredHeight = virtualChildAt2.getMeasuredHeight() + i40;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                virtualChildAt2.measure(childMeasureSpec, android.view.View.MeasureSpec.makeMeasureSpec(measuredHeight, i10));
                                i4 = android.view.View.combineMeasuredStates(i4, virtualChildAt2.getMeasuredState() & androidx.core.view.InputDeviceCompat.SOURCE_ANY);
                                f = f4;
                            } else {
                                i7 = i37;
                            }
                            int i41 = ((android.widget.LinearLayout.LayoutParams) layoutParams2).leftMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams2).rightMargin;
                            int measuredWidth = virtualChildAt2.getMeasuredWidth() + i41;
                            i33 = java.lang.Math.max(i33, measuredWidth);
                            float f5 = f;
                            if (mode != 1073741824) {
                                i8 = i4;
                                i9 = -1;
                                if (((android.widget.LinearLayout.LayoutParams) layoutParams2).width == -1) {
                                    z = true;
                                    if (!z) {
                                        i41 = measuredWidth;
                                    }
                                    int max3 = java.lang.Math.max(i38, i41);
                                    boolean z7 = !z5 && ((android.widget.LinearLayout.LayoutParams) layoutParams2).width == i9;
                                    int i42 = this.mTotalLength;
                                    this.mTotalLength = java.lang.Math.max(i42, virtualChildAt2.getMeasuredHeight() + i42 + ((android.widget.LinearLayout.LayoutParams) layoutParams2).topMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams2).bottomMargin + getNextLocationOffset(virtualChildAt2));
                                    z5 = z7;
                                    i4 = i8;
                                    i38 = max3;
                                    f = f5;
                                }
                            } else {
                                i8 = i4;
                                i9 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            int max32 = java.lang.Math.max(i38, i41);
                            if (z5) {
                            }
                            int i422 = this.mTotalLength;
                            this.mTotalLength = java.lang.Math.max(i422, virtualChildAt2.getMeasuredHeight() + i422 + ((android.widget.LinearLayout.LayoutParams) layoutParams2).topMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams2).bottomMargin + getNextLocationOffset(virtualChildAt2));
                            z5 = z7;
                            i4 = i8;
                            i38 = max32;
                            f = f5;
                        }
                        i39++;
                        i37 = i7;
                    }
                    i5 = i;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i6 = i38;
                } else {
                    i6 = java.lang.Math.max(i30, i27);
                    if (z3 && i32 != 1073741824) {
                        for (int i43 = 0; i43 < i3; i43++) {
                            android.view.View virtualChildAt3 = getVirtualChildAt(i43);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((android.widget.LinearLayout.LayoutParams) ((androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt3.getLayoutParams())).weight > 0.0f) {
                                virtualChildAt3.measure(android.view.View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(i29, 1073741824));
                            }
                        }
                    }
                    i5 = i;
                    i4 = i28;
                }
                if (z5 || mode == 1073741824) {
                    i6 = i33;
                }
                setMeasuredDimension(android.view.View.resolveSizeAndState(java.lang.Math.max(i6 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, i4), resolveSizeAndState);
                if (z6) {
                    forceUniformWidth(i3, i2);
                    return;
                }
                return;
            }
            android.view.View virtualChildAt4 = getVirtualChildAt(i25);
            if (virtualChildAt4 == null) {
                this.mTotalLength += measureNullChild(i25);
                i14 = virtualChildCount;
                i15 = mode2;
                i23 = i27;
            } else {
                int i44 = i20;
                if (virtualChildAt4.getVisibility() == 8) {
                    i25 += getChildrenSkipCount(virtualChildAt4, i25);
                    i14 = virtualChildCount;
                    i23 = i27;
                    i20 = i44;
                    i15 = mode2;
                } else {
                    if (hasDividerBeforeChildAt(i25)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    androidx.appcompat.widget.LinearLayoutCompat.LayoutParams layoutParams3 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) virtualChildAt4.getLayoutParams();
                    float f6 = ((android.widget.LinearLayout.LayoutParams) layoutParams3).weight;
                    float f7 = f + f6;
                    if (mode2 == 1073741824 && ((android.widget.LinearLayout.LayoutParams) layoutParams3).height == 0 && f6 > 0.0f) {
                        int i45 = this.mTotalLength;
                        this.mTotalLength = java.lang.Math.max(i45, ((android.widget.LinearLayout.LayoutParams) layoutParams3).topMargin + i45 + ((android.widget.LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        max = i22;
                        view = virtualChildAt4;
                        i17 = i24;
                        i12 = i44;
                        i13 = i21;
                        z4 = true;
                        i14 = virtualChildCount;
                        i15 = mode2;
                        i16 = i27;
                        i18 = i25;
                    } else {
                        int i46 = i21;
                        if (((android.widget.LinearLayout.LayoutParams) layoutParams3).height != 0 || f6 <= 0.0f) {
                            i11 = Integer.MIN_VALUE;
                        } else {
                            ((android.widget.LinearLayout.LayoutParams) layoutParams3).height = -2;
                            i11 = 0;
                        }
                        i12 = i44;
                        int i47 = i11;
                        i13 = i46;
                        int i48 = i22;
                        i14 = virtualChildCount;
                        i15 = mode2;
                        i16 = i27;
                        i17 = i24;
                        i18 = i25;
                        measureChildBeforeLayout(virtualChildAt4, i25, i, 0, i2, f7 == 0.0f ? this.mTotalLength : 0);
                        if (i47 != Integer.MIN_VALUE) {
                            ((android.widget.LinearLayout.LayoutParams) layoutParams3).height = i47;
                        }
                        int measuredHeight2 = virtualChildAt4.getMeasuredHeight();
                        int i49 = this.mTotalLength;
                        view = virtualChildAt4;
                        this.mTotalLength = java.lang.Math.max(i49, i49 + measuredHeight2 + ((android.widget.LinearLayout.LayoutParams) layoutParams3).topMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(view));
                        max = z3 ? java.lang.Math.max(measuredHeight2, i48) : i48;
                    }
                    if (i19 >= 0 && i19 == i18 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i18 < i19 && ((android.widget.LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        throw new java.lang.RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((android.widget.LinearLayout.LayoutParams) layoutParams3).width != -1) {
                        z2 = false;
                    } else {
                        z2 = true;
                        z6 = true;
                    }
                    int i50 = ((android.widget.LinearLayout.LayoutParams) layoutParams3).leftMargin + ((android.widget.LinearLayout.LayoutParams) layoutParams3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i50;
                    int max4 = java.lang.Math.max(i13, measuredWidth2);
                    int combineMeasuredStates = android.view.View.combineMeasuredStates(i12, view.getMeasuredState());
                    z5 = z5 && ((android.widget.LinearLayout.LayoutParams) layoutParams3).width == -1;
                    if (((android.widget.LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        if (!z2) {
                            i50 = measuredWidth2;
                        }
                        i23 = java.lang.Math.max(i16, i50);
                        max2 = i17;
                    } else {
                        if (!z2) {
                            i50 = measuredWidth2;
                        }
                        max2 = java.lang.Math.max(i17, i50);
                        i23 = i16;
                    }
                    int childrenSkipCount = getChildrenSkipCount(view, i18) + i18;
                    i22 = max;
                    f = f7;
                    i24 = max2;
                    i20 = combineMeasuredStates;
                    i25 = childrenSkipCount;
                    i21 = max4;
                }
            }
            i25++;
            mode2 = i15;
            virtualChildCount = i14;
        }
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.mBaselineAlignedChildIndex = i;
            return;
        }
        throw new java.lang.IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(android.graphics.drawable.Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= androidx.core.view.GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & androidx.core.view.GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = java.lang.Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
