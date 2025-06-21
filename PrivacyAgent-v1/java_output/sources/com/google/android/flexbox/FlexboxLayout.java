package com.google.android.flexbox;

/* loaded from: classes22.dex */
public class FlexboxLayout extends android.view.ViewGroup implements com.google.android.flexbox.FlexContainer {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public int A;
    public int B;
    public int C;
    public int D;
    public int[] E;
    public android.util.SparseIntArray F;
    public com.google.android.flexbox.FlexboxHelper G;
    public java.util.List<com.google.android.flexbox.FlexLine> H;
    public com.google.android.flexbox.FlexboxHelper.FlexLinesResult I;
    public int n;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable y;

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable z;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams implements com.google.android.flexbox.FlexItem {
        public static final android.os.Parcelable.Creator<com.google.android.flexbox.FlexboxLayout.LayoutParams> CREATOR = new com.google.android.flexbox.FlexboxLayout.LayoutParams.AnonymousClass1();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private int mOrder;
        private boolean mWrapBefore;

        /* renamed from: com.google.android.flexbox.FlexboxLayout$LayoutParams$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.flexbox.FlexboxLayout.LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.android.flexbox.FlexboxLayout.LayoutParams createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.flexbox.FlexboxLayout.LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.android.flexbox.FlexboxLayout.LayoutParams[] newArray(int i) {
                return new com.google.android.flexbox.FlexboxLayout.LayoutParams[i];
            }
        }

        public LayoutParams(int i, int i2) {
            super(new android.view.ViewGroup.LayoutParams(i, i2));
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.flexbox.R.styleable.FlexboxLayout_Layout);
            this.mOrder = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = obtainStyledAttributes.getFloat(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = obtainStyledAttributes.getFloat(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = obtainStyledAttributes.getFraction(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = obtainStyledAttributes.getBoolean(com.google.android.flexbox.R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.os.Parcel parcel) {
            super(0, 0);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((android.view.ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((android.view.ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((android.view.ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((android.view.ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((android.view.ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((android.view.ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams) {
            super((android.view.ViewGroup.MarginLayoutParams) layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = layoutParams.mOrder;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((android.view.ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((android.view.ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((android.view.ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((android.view.ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((android.view.ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.mOrder;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((android.view.ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i) {
            this.mAlignSelf = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f) {
            this.mFlexBasisPercent = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f) {
            this.mFlexGrow = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f) {
            this.mFlexShrink = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i) {
            ((android.view.ViewGroup.MarginLayoutParams) this).height = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i) {
            this.mMaxHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i) {
            this.mMaxWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i) {
            this.mMinHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i) {
            this.mMinWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i) {
            this.mOrder = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i) {
            ((android.view.ViewGroup.MarginLayoutParams) this).width = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z) {
            this.mWrapBefore = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.mOrder);
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((android.view.ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((android.view.ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((android.view.ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((android.view.ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((android.view.ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((android.view.ViewGroup.MarginLayoutParams) this).width);
        }
    }

    public FlexboxLayout(android.content.Context context) {
        this(context, null);
    }

    public FlexboxLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = -1;
        this.G = new com.google.android.flexbox.FlexboxHelper(this);
        this.H = new java.util.ArrayList();
        this.I = new com.google.android.flexbox.FlexboxHelper.FlexLinesResult();
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.flexbox.R.styleable.FlexboxLayout, i, 0);
        this.n = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_flexDirection, 0);
        this.t = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_flexWrap, 0);
        this.u = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_justifyContent, 0);
        this.v = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_alignItems, 0);
        this.w = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_alignContent, 0);
        this.x = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_maxLine, -1);
        android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(com.google.android.flexbox.R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        android.graphics.drawable.Drawable drawable2 = obtainStyledAttributes.getDrawable(com.google.android.flexbox.R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        android.graphics.drawable.Drawable drawable3 = obtainStyledAttributes.getDrawable(com.google.android.flexbox.R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i2 = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_showDivider, 0);
        if (i2 != 0) {
            this.B = i2;
            this.A = i2;
        }
        int i3 = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.B = i3;
        }
        int i4 = obtainStyledAttributes.getInt(com.google.android.flexbox.R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.A = i4;
        }
        obtainStyledAttributes.recycle();
    }

    public final boolean a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.H.get(i2).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.F == null) {
            this.F = new android.util.SparseIntArray(getChildCount());
        }
        this.E = this.G.n(view, i, layoutParams, this.F);
        super.addView(view, i, layoutParams);
    }

    public final boolean b(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            android.view.View reorderedChildAt = getReorderedChildAt(i - i3);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public final void c(android.graphics.Canvas canvas, boolean z, boolean z2) {
        int paddingLeft = getPaddingLeft();
        int max = java.lang.Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.H.size();
        for (int i = 0; i < size; i++) {
            com.google.android.flexbox.FlexLine flexLine = this.H.get(i);
            for (int i2 = 0; i2 < flexLine.h; i2++) {
                int i3 = flexLine.o + i2;
                android.view.View reorderedChildAt = getReorderedChildAt(i3);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams = (com.google.android.flexbox.FlexboxLayout.LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i3, i2)) {
                        f(canvas, z ? reorderedChildAt.getRight() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (reorderedChildAt.getLeft() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.D, flexLine.b, flexLine.g);
                    }
                    if (i2 == flexLine.h - 1 && (this.B & 4) > 0) {
                        f(canvas, z ? (reorderedChildAt.getLeft() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.D : reorderedChildAt.getRight() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin, flexLine.b, flexLine.g);
                    }
                }
            }
            if (h(i)) {
                e(canvas, paddingLeft, z2 ? flexLine.d : flexLine.b - this.C, max);
            }
            if (i(i) && (this.A & 4) > 0) {
                e(canvas, paddingLeft, z2 ? flexLine.b - this.C : flexLine.d, max);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof com.google.android.flexbox.FlexboxLayout.LayoutParams;
    }

    public final void d(android.graphics.Canvas canvas, boolean z, boolean z2) {
        int paddingTop = getPaddingTop();
        int max = java.lang.Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.H.size();
        for (int i = 0; i < size; i++) {
            com.google.android.flexbox.FlexLine flexLine = this.H.get(i);
            for (int i2 = 0; i2 < flexLine.h; i2++) {
                int i3 = flexLine.o + i2;
                android.view.View reorderedChildAt = getReorderedChildAt(i3);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams = (com.google.android.flexbox.FlexboxLayout.LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i3, i2)) {
                        e(canvas, flexLine.a, z2 ? reorderedChildAt.getBottom() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (reorderedChildAt.getTop() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.C, flexLine.g);
                    }
                    if (i2 == flexLine.h - 1 && (this.A & 4) > 0) {
                        e(canvas, flexLine.a, z2 ? (reorderedChildAt.getTop() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.C : reorderedChildAt.getBottom() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, flexLine.g);
                    }
                }
            }
            if (h(i)) {
                f(canvas, z ? flexLine.c : flexLine.a - this.D, paddingTop, max);
            }
            if (i(i) && (this.B & 4) > 0) {
                f(canvas, z ? flexLine.a - this.D : flexLine.c, paddingTop, max);
            }
        }
    }

    public final void e(android.graphics.Canvas canvas, int i, int i2, int i3) {
        android.graphics.drawable.Drawable drawable = this.y;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.C + i2);
        this.y.draw(canvas);
    }

    public final void f(android.graphics.Canvas canvas, int i, int i2, int i3) {
        android.graphics.drawable.Drawable drawable = this.z;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.D + i, i3 + i2);
        this.z.draw(canvas);
    }

    public final boolean g(int i, int i2) {
        return b(i, i2) ? isMainAxisDirectionHorizontal() ? (this.B & 1) != 0 : (this.A & 1) != 0 : isMainAxisDirectionHorizontal() ? (this.B & 2) != 0 : (this.A & 2) != 0;
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof com.google.android.flexbox.FlexboxLayout.LayoutParams ? new com.google.android.flexbox.FlexboxLayout.LayoutParams((com.google.android.flexbox.FlexboxLayout.LayoutParams) layoutParams) : layoutParams instanceof android.view.ViewGroup.MarginLayoutParams ? new com.google.android.flexbox.FlexboxLayout.LayoutParams((android.view.ViewGroup.MarginLayoutParams) layoutParams) : new com.google.android.flexbox.FlexboxLayout.LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public com.google.android.flexbox.FlexboxLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.google.android.flexbox.FlexboxLayout.LayoutParams(getContext(), attributeSet);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return this.w;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.v;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int i, int i2, int i3) {
        return android.view.ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int i, int i2, int i3) {
        return android.view.ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(android.view.View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(android.view.View view, int i, int i2) {
        int i3;
        int i4;
        if (isMainAxisDirectionHorizontal()) {
            i3 = g(i, i2) ? 0 + this.D : 0;
            if ((this.B & 4) <= 0) {
                return i3;
            }
            i4 = this.D;
        } else {
            i3 = g(i, i2) ? 0 + this.C : 0;
            if ((this.A & 4) <= 0) {
                return i3;
            }
            i4 = this.C;
        }
        return i3 + i4;
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getDividerDrawableHorizontal() {
        return this.y;
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getDividerDrawableVertical() {
        return this.z;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.n;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public android.view.View getFlexItemAt(int i) {
        return getChildAt(i);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return getChildCount();
    }

    public java.util.List<com.google.android.flexbox.FlexLine> getFlexLines() {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.H.size());
        for (com.google.android.flexbox.FlexLine flexLine : this.H) {
            if (flexLine.getItemCountNotGone() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public java.util.List<com.google.android.flexbox.FlexLine> getFlexLinesInternal() {
        return this.H;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.t;
    }

    public int getJustifyContent() {
        return this.u;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        java.util.Iterator<com.google.android.flexbox.FlexLine> it = this.H.iterator();
        int i = Integer.MIN_VALUE;
        while (it.hasNext()) {
            i = java.lang.Math.max(i, it.next().e);
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.x;
    }

    public android.view.View getReorderedChildAt(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.E;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public android.view.View getReorderedFlexItemAt(int i) {
        return getReorderedChildAt(i);
    }

    public int getShowDividerHorizontal() {
        return this.A;
    }

    public int getShowDividerVertical() {
        return this.B;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.H.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.flexbox.FlexLine flexLine = this.H.get(i2);
            if (h(i2)) {
                i += isMainAxisDirectionHorizontal() ? this.C : this.D;
            }
            if (i(i2)) {
                i += isMainAxisDirectionHorizontal() ? this.C : this.D;
            }
            i += flexLine.g;
        }
        return i;
    }

    public final boolean h(int i) {
        if (i < 0 || i >= this.H.size()) {
            return false;
        }
        return a(i) ? isMainAxisDirectionHorizontal() ? (this.A & 1) != 0 : (this.B & 1) != 0 : isMainAxisDirectionHorizontal() ? (this.A & 2) != 0 : (this.B & 2) != 0;
    }

    public final boolean i(int i) {
        if (i < 0 || i >= this.H.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.H.size(); i2++) {
            if (this.H.get(i2).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return isMainAxisDirectionHorizontal() ? (this.A & 4) != 0 : (this.B & 4) != 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.n;
        return i == 0 || i == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7;
        float f4;
        int i8;
        int i9;
        com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i10 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.H.size();
        int i11 = 0;
        while (i11 < size) {
            com.google.android.flexbox.FlexLine flexLine = this.H.get(i11);
            if (h(i11)) {
                int i12 = this.C;
                paddingBottom -= i12;
                paddingTop += i12;
            }
            int i13 = this.u;
            int i14 = 1;
            if (i13 == 0) {
                f = paddingLeft;
                f2 = i10 - paddingRight;
            } else if (i13 == 1) {
                int i15 = flexLine.e;
                f2 = i15 - paddingLeft;
                f = (i10 - i15) + paddingRight;
            } else if (i13 != 2) {
                if (i13 == 3) {
                    f = paddingLeft;
                    f3 = (i10 - flexLine.e) / (flexLine.getItemCountNotGone() != 1 ? r10 - 1 : 1.0f);
                    f2 = i10 - paddingRight;
                } else if (i13 == 4) {
                    int itemCountNotGone = flexLine.getItemCountNotGone();
                    f3 = itemCountNotGone != 0 ? (i10 - flexLine.e) / itemCountNotGone : 0.0f;
                    float f5 = f3 / 2.0f;
                    f = paddingLeft + f5;
                    f2 = (i10 - paddingRight) - f5;
                } else {
                    if (i13 != 5) {
                        throw new java.lang.IllegalStateException("Invalid justifyContent is set: " + this.u);
                    }
                    f3 = flexLine.getItemCountNotGone() != 0 ? (i10 - flexLine.e) / (r7 + 1) : 0.0f;
                    f = paddingLeft + f3;
                    f2 = (i10 - paddingRight) - f3;
                }
                float max = java.lang.Math.max(f3, 0.0f);
                i5 = 0;
                while (i5 < flexLine.h) {
                    int i16 = flexLine.o + i5;
                    android.view.View reorderedChildAt = getReorderedChildAt(i16);
                    if (reorderedChildAt == null || reorderedChildAt.getVisibility() == 8) {
                        i6 = paddingLeft;
                        i7 = i5;
                    } else {
                        com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams2 = (com.google.android.flexbox.FlexboxLayout.LayoutParams) reorderedChildAt.getLayoutParams();
                        float f6 = f + ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                        float f7 = f2 - ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        if (g(i16, i5)) {
                            int i17 = this.D;
                            float f8 = i17;
                            f6 += f8;
                            i8 = i17;
                            f4 = f7 - f8;
                        } else {
                            f4 = f7;
                            i8 = 0;
                        }
                        if (i5 == flexLine.h - i14 && (this.B & 4) > 0) {
                            i9 = this.D;
                            if (this.t == 2) {
                                i6 = paddingLeft;
                                i7 = i5;
                                layoutParams = layoutParams2;
                                if (z) {
                                    this.G.Q(reorderedChildAt, flexLine, java.lang.Math.round(f4) - reorderedChildAt.getMeasuredWidth(), paddingTop, java.lang.Math.round(f4), paddingTop + reorderedChildAt.getMeasuredHeight());
                                } else {
                                    this.G.Q(reorderedChildAt, flexLine, java.lang.Math.round(f6), paddingTop, java.lang.Math.round(f6) + reorderedChildAt.getMeasuredWidth(), paddingTop + reorderedChildAt.getMeasuredHeight());
                                }
                            } else if (z) {
                                i7 = i5;
                                i6 = paddingLeft;
                                layoutParams = layoutParams2;
                                this.G.Q(reorderedChildAt, flexLine, java.lang.Math.round(f4) - reorderedChildAt.getMeasuredWidth(), paddingBottom - reorderedChildAt.getMeasuredHeight(), java.lang.Math.round(f4), paddingBottom);
                            } else {
                                i6 = paddingLeft;
                                i7 = i5;
                                layoutParams = layoutParams2;
                                this.G.Q(reorderedChildAt, flexLine, java.lang.Math.round(f6), paddingBottom - reorderedChildAt.getMeasuredHeight(), java.lang.Math.round(f6) + reorderedChildAt.getMeasuredWidth(), paddingBottom);
                            }
                            f = f6 + reorderedChildAt.getMeasuredWidth() + max + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                            float measuredWidth = f4 - ((reorderedChildAt.getMeasuredWidth() + max) + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
                            if (z) {
                                flexLine.a(reorderedChildAt, i8, 0, i9, 0);
                            } else {
                                flexLine.a(reorderedChildAt, i9, 0, i8, 0);
                            }
                            f2 = measuredWidth;
                        }
                        i9 = 0;
                        if (this.t == 2) {
                        }
                        f = f6 + reorderedChildAt.getMeasuredWidth() + max + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        float measuredWidth2 = f4 - ((reorderedChildAt.getMeasuredWidth() + max) + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
                        if (z) {
                        }
                        f2 = measuredWidth2;
                    }
                    i5 = i7 + 1;
                    paddingLeft = i6;
                    i14 = 1;
                }
                int i18 = paddingLeft;
                int i19 = flexLine.g;
                paddingTop += i19;
                paddingBottom -= i19;
                i11++;
                paddingLeft = i18;
            } else {
                int i20 = flexLine.e;
                f = paddingLeft + ((i10 - i20) / 2.0f);
                f2 = (i10 - paddingRight) - ((i10 - i20) / 2.0f);
            }
            f3 = 0.0f;
            float max2 = java.lang.Math.max(f3, 0.0f);
            i5 = 0;
            while (i5 < flexLine.h) {
            }
            int i182 = paddingLeft;
            int i192 = flexLine.g;
            paddingTop += i192;
            paddingBottom -= i192;
            i11++;
            paddingLeft = i182;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        int i6;
        int i7;
        float f4;
        float f5;
        int i8;
        int i9;
        com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i10 = i4 - i2;
        int i11 = (i3 - i) - paddingRight;
        int size = this.H.size();
        for (int i12 = 0; i12 < size; i12++) {
            com.google.android.flexbox.FlexLine flexLine = this.H.get(i12);
            if (h(i12)) {
                int i13 = this.D;
                paddingLeft += i13;
                i11 -= i13;
            }
            int i14 = this.u;
            if (i14 == 0) {
                f = paddingTop;
                i5 = i10 - paddingBottom;
            } else if (i14 == 1) {
                int i15 = flexLine.e;
                f = (i10 - i15) + paddingBottom;
                i5 = i15 - paddingTop;
            } else if (i14 != 2) {
                if (i14 == 3) {
                    f = paddingTop;
                    f3 = (i10 - flexLine.e) / (flexLine.getItemCountNotGone() != 1 ? r7 - 1 : 1.0f);
                    f2 = i10 - paddingBottom;
                } else if (i14 == 4) {
                    int itemCountNotGone = flexLine.getItemCountNotGone();
                    f3 = itemCountNotGone != 0 ? (i10 - flexLine.e) / itemCountNotGone : 0.0f;
                    float f6 = f3 / 2.0f;
                    f = paddingTop + f6;
                    f2 = (i10 - paddingBottom) - f6;
                } else {
                    if (i14 != 5) {
                        throw new java.lang.IllegalStateException("Invalid justifyContent is set: " + this.u);
                    }
                    f3 = flexLine.getItemCountNotGone() != 0 ? (i10 - flexLine.e) / (r10 + 1) : 0.0f;
                    f = paddingTop + f3;
                    f2 = (i10 - paddingBottom) - f3;
                }
                float max = java.lang.Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < flexLine.h) {
                    int i16 = flexLine.o + i6;
                    android.view.View reorderedChildAt = getReorderedChildAt(i16);
                    if (reorderedChildAt == null || reorderedChildAt.getVisibility() == 8) {
                        i7 = i6;
                    } else {
                        com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams2 = (com.google.android.flexbox.FlexboxLayout.LayoutParams) reorderedChildAt.getLayoutParams();
                        float f7 = f + ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                        float f8 = f2 - ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        if (g(i16, i6)) {
                            int i17 = this.C;
                            float f9 = i17;
                            f4 = f7 + f9;
                            i8 = i17;
                            f5 = f8 - f9;
                        } else {
                            f4 = f7;
                            f5 = f8;
                            i8 = 0;
                        }
                        if (i6 == flexLine.h - 1 && (this.A & 4) > 0) {
                            i9 = this.C;
                            if (z) {
                                i7 = i6;
                                layoutParams = layoutParams2;
                                if (z2) {
                                    this.G.R(reorderedChildAt, flexLine, false, paddingLeft, java.lang.Math.round(f5) - reorderedChildAt.getMeasuredHeight(), paddingLeft + reorderedChildAt.getMeasuredWidth(), java.lang.Math.round(f5));
                                } else {
                                    this.G.R(reorderedChildAt, flexLine, false, paddingLeft, java.lang.Math.round(f4), paddingLeft + reorderedChildAt.getMeasuredWidth(), java.lang.Math.round(f4) + reorderedChildAt.getMeasuredHeight());
                                }
                            } else if (z2) {
                                i7 = i6;
                                layoutParams = layoutParams2;
                                this.G.R(reorderedChildAt, flexLine, true, i11 - reorderedChildAt.getMeasuredWidth(), java.lang.Math.round(f5) - reorderedChildAt.getMeasuredHeight(), i11, java.lang.Math.round(f5));
                            } else {
                                i7 = i6;
                                layoutParams = layoutParams2;
                                this.G.R(reorderedChildAt, flexLine, true, i11 - reorderedChildAt.getMeasuredWidth(), java.lang.Math.round(f4), i11, java.lang.Math.round(f4) + reorderedChildAt.getMeasuredHeight());
                            }
                            com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams3 = layoutParams;
                            float measuredHeight = f4 + reorderedChildAt.getMeasuredHeight() + max + ((android.view.ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                            float measuredHeight2 = f5 - ((reorderedChildAt.getMeasuredHeight() + max) + ((android.view.ViewGroup.MarginLayoutParams) layoutParams3).topMargin);
                            if (z2) {
                                flexLine.a(reorderedChildAt, 0, i8, 0, i9);
                            } else {
                                flexLine.a(reorderedChildAt, 0, i9, 0, i8);
                            }
                            f = measuredHeight;
                            f2 = measuredHeight2;
                        }
                        i9 = 0;
                        if (z) {
                        }
                        com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams32 = layoutParams;
                        float measuredHeight3 = f4 + reorderedChildAt.getMeasuredHeight() + max + ((android.view.ViewGroup.MarginLayoutParams) layoutParams32).bottomMargin;
                        float measuredHeight22 = f5 - ((reorderedChildAt.getMeasuredHeight() + max) + ((android.view.ViewGroup.MarginLayoutParams) layoutParams32).topMargin);
                        if (z2) {
                        }
                        f = measuredHeight3;
                        f2 = measuredHeight22;
                    }
                    i6 = i7 + 1;
                }
                int i18 = flexLine.g;
                paddingLeft += i18;
                i11 -= i18;
            } else {
                int i19 = flexLine.e;
                f2 = (i10 - paddingBottom) - ((i10 - i19) / 2.0f);
                f = paddingTop + ((i10 - i19) / 2.0f);
                f3 = 0.0f;
                float max2 = java.lang.Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < flexLine.h) {
                }
                int i182 = flexLine.g;
                paddingLeft += i182;
                i11 -= i182;
            }
            f2 = i5;
            f3 = 0.0f;
            float max22 = java.lang.Math.max(f3, 0.0f);
            i6 = 0;
            while (i6 < flexLine.h) {
            }
            int i1822 = flexLine.g;
            paddingLeft += i1822;
            i11 -= i1822;
        }
    }

    public final void l(int i, int i2) {
        this.H.clear();
        this.I.a();
        this.G.c(this.I, i, i2);
        this.H = this.I.a;
        this.G.p(i, i2);
        if (this.v == 3) {
            for (com.google.android.flexbox.FlexLine flexLine : this.H) {
                int i3 = Integer.MIN_VALUE;
                for (int i4 = 0; i4 < flexLine.h; i4++) {
                    android.view.View reorderedChildAt = getReorderedChildAt(flexLine.o + i4);
                    if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                        com.google.android.flexbox.FlexboxLayout.LayoutParams layoutParams = (com.google.android.flexbox.FlexboxLayout.LayoutParams) reorderedChildAt.getLayoutParams();
                        i3 = this.t != 2 ? java.lang.Math.max(i3, reorderedChildAt.getMeasuredHeight() + java.lang.Math.max(flexLine.l - reorderedChildAt.getBaseline(), ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : java.lang.Math.max(i3, reorderedChildAt.getMeasuredHeight() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin + java.lang.Math.max((flexLine.l - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                flexLine.g = i3;
            }
        }
        this.G.o(i, i2, getPaddingTop() + getPaddingBottom());
        this.G.X();
        n(this.n, i, i2, this.I.b);
    }

    public final void m(int i, int i2) {
        this.H.clear();
        this.I.a();
        this.G.f(this.I, i, i2);
        this.H = this.I.a;
        this.G.p(i, i2);
        this.G.o(i, i2, getPaddingLeft() + getPaddingRight());
        this.G.X();
        n(this.n, i, i2, this.I.b);
    }

    public final void n(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        int mode2 = android.view.View.MeasureSpec.getMode(i3);
        int size2 = android.view.View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i != 2 && i != 3) {
                throw new java.lang.IllegalArgumentException("Invalid flex direction: " + i);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = android.view.View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = android.view.View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            resolveSizeAndState = android.view.View.resolveSizeAndState(largestMainSize, i2, i4);
        } else {
            if (mode != 1073741824) {
                throw new java.lang.IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                i4 = android.view.View.combineMeasuredStates(i4, 16777216);
            }
            resolveSizeAndState = android.view.View.resolveSizeAndState(size, i2, i4);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = android.view.View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = android.view.View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = android.view.View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else {
            if (mode2 != 1073741824) {
                throw new java.lang.IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                i4 = android.view.View.combineMeasuredStates(i4, 256);
            }
            resolveSizeAndState2 = android.view.View.resolveSizeAndState(size2, i3, i4);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    public final void o() {
        if (this.y == null && this.z == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        if (this.z == null && this.y == null) {
            return;
        }
        if (this.A == 0 && this.B == 0) {
            return;
        }
        int layoutDirection = androidx.core.view.ViewCompat.getLayoutDirection(this);
        int i = this.n;
        if (i == 0) {
            c(canvas, layoutDirection == 1, this.t == 2);
            return;
        }
        if (i == 1) {
            c(canvas, layoutDirection != 1, this.t == 2);
            return;
        }
        if (i == 2) {
            boolean z = layoutDirection == 1;
            if (this.t == 2) {
                z = !z;
            }
            d(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = layoutDirection == 1;
        if (this.t == 2) {
            z2 = !z2;
        }
        d(canvas, z2, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int layoutDirection = androidx.core.view.ViewCompat.getLayoutDirection(this);
        int i5 = this.n;
        if (i5 == 0) {
            j(layoutDirection == 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 1) {
            j(layoutDirection != 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 2) {
            z2 = layoutDirection == 1;
            k(this.t == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            z2 = layoutDirection == 1;
            k(this.t == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new java.lang.IllegalStateException("Invalid flex direction is set: " + this.n);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.F == null) {
            this.F = new android.util.SparseIntArray(getChildCount());
        }
        if (this.G.O(this.F)) {
            this.E = this.G.m(this.F);
        }
        int i3 = this.n;
        if (i3 == 0 || i3 == 1) {
            l(i, i2);
            return;
        }
        if (i3 == 2 || i3 == 3) {
            m(i, i2);
            return;
        }
        throw new java.lang.IllegalStateException("Invalid value for the flex direction is set: " + this.n);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(android.view.View view, int i, int i2, com.google.android.flexbox.FlexLine flexLine) {
        if (g(i, i2)) {
            if (isMainAxisDirectionHorizontal()) {
                int i3 = flexLine.e;
                int i4 = this.D;
                flexLine.e = i3 + i4;
                flexLine.f += i4;
                return;
            }
            int i5 = flexLine.e;
            int i6 = this.C;
            flexLine.e = i5 + i6;
            flexLine.f += i6;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(com.google.android.flexbox.FlexLine flexLine) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.B & 4) > 0) {
                int i = flexLine.e;
                int i2 = this.D;
                flexLine.e = i + i2;
                flexLine.f += i2;
                return;
            }
            return;
        }
        if ((this.A & 4) > 0) {
            int i3 = flexLine.e;
            int i4 = this.C;
            flexLine.e = i3 + i4;
            flexLine.f += i4;
        }
    }

    public void setAlignContent(int i) {
        if (this.w != i) {
            this.w = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.v != i) {
            this.v = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(android.graphics.drawable.Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == this.y) {
            return;
        }
        this.y = drawable;
        if (drawable != null) {
            this.C = drawable.getIntrinsicHeight();
        } else {
            this.C = 0;
        }
        o();
        requestLayout();
    }

    public void setDividerDrawableVertical(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == this.z) {
            return;
        }
        this.z = drawable;
        if (drawable != null) {
            this.D = drawable.getIntrinsicWidth();
        } else {
            this.D = 0;
        }
        o();
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.n != i) {
            this.n = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(java.util.List<com.google.android.flexbox.FlexLine> list) {
        this.H = list;
    }

    public void setFlexWrap(int i) {
        if (this.t != i) {
            this.t = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.u != i) {
            this.u = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.x != i) {
            this.x = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.A) {
            this.A = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.B) {
            this.B = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int i, android.view.View view) {
    }
}
