package com.google.android.flexbox;

/* loaded from: classes22.dex */
public class FlexboxLayoutManager extends androidx.recyclerview.widget.RecyclerView.LayoutManager implements com.google.android.flexbox.FlexContainer, androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final android.graphics.Rect S = new android.graphics.Rect();
    public final com.google.android.flexbox.FlexboxHelper A;
    public androidx.recyclerview.widget.RecyclerView.Recycler B;
    public androidx.recyclerview.widget.RecyclerView.State C;
    public com.google.android.flexbox.FlexboxLayoutManager.LayoutState D;
    public com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo E;
    public androidx.recyclerview.widget.OrientationHelper F;
    public androidx.recyclerview.widget.OrientationHelper G;
    public com.google.android.flexbox.FlexboxLayoutManager.SavedState H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public android.util.SparseArray<android.view.View> N;
    public final android.content.Context O;
    public android.view.View P;
    public int Q;
    public com.google.android.flexbox.FlexboxHelper.FlexLinesResult R;
    public int n;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public java.util.List<com.google.android.flexbox.FlexLine> z;

    public class AnchorInfo {
        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public boolean f;
        public boolean g;

        public AnchorInfo() {
            this.d = 0;
        }

        public /* synthetic */ AnchorInfo(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager, com.google.android.flexbox.FlexboxLayoutManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        public static /* synthetic */ int l(com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo anchorInfo, int i) {
            int i2 = anchorInfo.d + i;
            anchorInfo.d = i2;
            return i2;
        }

        public final void r() {
            if (com.google.android.flexbox.FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !com.google.android.flexbox.FlexboxLayoutManager.this.x) {
                this.c = this.e ? com.google.android.flexbox.FlexboxLayoutManager.this.F.getEndAfterPadding() : com.google.android.flexbox.FlexboxLayoutManager.this.F.getStartAfterPadding();
            } else {
                this.c = this.e ? com.google.android.flexbox.FlexboxLayoutManager.this.F.getEndAfterPadding() : com.google.android.flexbox.FlexboxLayoutManager.this.getWidth() - com.google.android.flexbox.FlexboxLayoutManager.this.F.getStartAfterPadding();
            }
        }

        public final void s(android.view.View view) {
            androidx.recyclerview.widget.OrientationHelper orientationHelper = com.google.android.flexbox.FlexboxLayoutManager.this.t == 0 ? com.google.android.flexbox.FlexboxLayoutManager.this.G : com.google.android.flexbox.FlexboxLayoutManager.this.F;
            if (com.google.android.flexbox.FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !com.google.android.flexbox.FlexboxLayoutManager.this.x) {
                if (this.e) {
                    this.c = orientationHelper.getDecoratedEnd(view) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.c = orientationHelper.getDecoratedStart(view);
                }
            } else if (this.e) {
                this.c = orientationHelper.getDecoratedStart(view) + orientationHelper.getTotalSpaceChange();
            } else {
                this.c = orientationHelper.getDecoratedEnd(view);
            }
            this.a = com.google.android.flexbox.FlexboxLayoutManager.this.getPosition(view);
            this.g = false;
            int[] iArr = com.google.android.flexbox.FlexboxLayoutManager.this.A.c;
            int i = this.a;
            if (i == -1) {
                i = 0;
            }
            int i2 = iArr[i];
            this.b = i2 != -1 ? i2 : 0;
            if (com.google.android.flexbox.FlexboxLayoutManager.this.z.size() > this.b) {
                this.a = ((com.google.android.flexbox.FlexLine) com.google.android.flexbox.FlexboxLayoutManager.this.z.get(this.b)).o;
            }
        }

        public final void t() {
            this.a = -1;
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.f = false;
            this.g = false;
            if (com.google.android.flexbox.FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (com.google.android.flexbox.FlexboxLayoutManager.this.t == 0) {
                    this.e = com.google.android.flexbox.FlexboxLayoutManager.this.n == 1;
                    return;
                } else {
                    this.e = com.google.android.flexbox.FlexboxLayoutManager.this.t == 2;
                    return;
                }
            }
            if (com.google.android.flexbox.FlexboxLayoutManager.this.t == 0) {
                this.e = com.google.android.flexbox.FlexboxLayoutManager.this.n == 3;
            } else {
                this.e = com.google.android.flexbox.FlexboxLayoutManager.this.t == 2;
            }
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mFlexLinePosition=" + this.b + ", mCoordinate=" + this.c + ", mPerpendicularCoordinate=" + this.d + ", mLayoutFromEnd=" + this.e + ", mValid=" + this.f + ", mAssignedFromSavedState=" + this.g + '}';
        }
    }

    public static class LayoutParams extends androidx.recyclerview.widget.RecyclerView.LayoutParams implements com.google.android.flexbox.FlexItem {
        public static final android.os.Parcelable.Creator<com.google.android.flexbox.FlexboxLayoutManager.LayoutParams> CREATOR = new com.google.android.flexbox.FlexboxLayoutManager.LayoutParams.AnonymousClass1();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$LayoutParams$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.flexbox.FlexboxLayoutManager.LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.android.flexbox.FlexboxLayoutManager.LayoutParams createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.flexbox.FlexboxLayoutManager.LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.android.flexbox.FlexboxLayoutManager.LayoutParams[] newArray(int i) {
                return new com.google.android.flexbox.FlexboxLayoutManager.LayoutParams[i];
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(android.os.Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
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
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(com.google.android.flexbox.FlexboxLayoutManager.LayoutParams layoutParams) {
            super((androidx.recyclerview.widget.RecyclerView.LayoutParams) layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
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
            return 1;
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
            throw new java.lang.UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
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

    public static class LayoutState {
        public int a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean j;

        public LayoutState() {
            this.h = 1;
            this.i = 1;
        }

        public /* synthetic */ LayoutState(com.google.android.flexbox.FlexboxLayoutManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        public static /* synthetic */ int c(com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState, int i) {
            int i2 = layoutState.e + i;
            layoutState.e = i2;
            return i2;
        }

        public static /* synthetic */ int d(com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState, int i) {
            int i2 = layoutState.e - i;
            layoutState.e = i2;
            return i2;
        }

        public static /* synthetic */ int i(com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState, int i) {
            int i2 = layoutState.a - i;
            layoutState.a = i2;
            return i2;
        }

        public static /* synthetic */ int l(com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState) {
            int i = layoutState.c;
            layoutState.c = i + 1;
            return i;
        }

        public static /* synthetic */ int m(com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState) {
            int i = layoutState.c;
            layoutState.c = i - 1;
            return i;
        }

        public static /* synthetic */ int n(com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState, int i) {
            int i2 = layoutState.c + i;
            layoutState.c = i2;
            return i2;
        }

        public static /* synthetic */ int q(com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState, int i) {
            int i2 = layoutState.f + i;
            layoutState.f = i2;
            return i2;
        }

        public static /* synthetic */ int u(com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState, int i) {
            int i2 = layoutState.d + i;
            layoutState.d = i2;
            return i2;
        }

        public static /* synthetic */ int v(com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState, int i) {
            int i2 = layoutState.d - i;
            layoutState.d = i2;
            return i2;
        }

        public final boolean D(androidx.recyclerview.widget.RecyclerView.State state, java.util.List<com.google.android.flexbox.FlexLine> list) {
            int i;
            int i2 = this.d;
            return i2 >= 0 && i2 < state.getItemCount() && (i = this.c) >= 0 && i < list.size();
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return "LayoutState{mAvailable=" + this.a + ", mFlexLinePosition=" + this.c + ", mPosition=" + this.d + ", mOffset=" + this.e + ", mScrollingOffset=" + this.f + ", mLastScrollDelta=" + this.g + ", mItemDirection=" + this.h + ", mLayoutDirection=" + this.i + '}';
        }
    }

    public static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.flexbox.FlexboxLayoutManager.SavedState> CREATOR = new com.google.android.flexbox.FlexboxLayoutManager.SavedState.AnonymousClass1();
        private int mAnchorOffset;
        private int mAnchorPosition;

        /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.flexbox.FlexboxLayoutManager.SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.android.flexbox.FlexboxLayoutManager.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.flexbox.FlexboxLayoutManager.SavedState(parcel, (com.google.android.flexbox.FlexboxLayoutManager.AnonymousClass1) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.android.flexbox.FlexboxLayoutManager.SavedState[] newArray(int i) {
                return new com.google.android.flexbox.FlexboxLayoutManager.SavedState[i];
            }
        }

        public SavedState() {
        }

        private SavedState(android.os.Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        public /* synthetic */ SavedState(android.os.Parcel parcel, com.google.android.flexbox.FlexboxLayoutManager.AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        private SavedState(com.google.android.flexbox.FlexboxLayoutManager.SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }

        public /* synthetic */ SavedState(com.google.android.flexbox.FlexboxLayoutManager.SavedState savedState, com.google.android.flexbox.FlexboxLayoutManager.AnonymousClass1 anonymousClass1) {
            this(savedState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasValidAnchor(int i) {
            int i2 = this.mAnchorPosition;
            return i2 >= 0 && i2 < i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }
    }

    public FlexboxLayoutManager(android.content.Context context) {
        this(context, 0, 1);
    }

    public FlexboxLayoutManager(android.content.Context context, int i) {
        this(context, i, 1);
    }

    public FlexboxLayoutManager(android.content.Context context, int i, int i2) {
        this.w = -1;
        this.z = new java.util.ArrayList();
        this.A = new com.google.android.flexbox.FlexboxHelper(this);
        this.E = new com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo(this, null);
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.L = Integer.MIN_VALUE;
        this.N = new android.util.SparseArray<>();
        this.Q = -1;
        this.R = new com.google.android.flexbox.FlexboxHelper.FlexLinesResult();
        setFlexDirection(i);
        setFlexWrap(i2);
        setAlignItems(4);
        this.O = context;
    }

    public FlexboxLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        this.w = -1;
        this.z = new java.util.ArrayList();
        this.A = new com.google.android.flexbox.FlexboxHelper(this);
        this.E = new com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo(this, null);
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.L = Integer.MIN_VALUE;
        this.N = new android.util.SparseArray<>();
        this.Q = -1;
        this.R = new com.google.android.flexbox.FlexboxHelper.FlexLinesResult();
        androidx.recyclerview.widget.RecyclerView.LayoutManager.Properties properties = androidx.recyclerview.widget.RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 != 0) {
            if (i3 == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        this.O = context;
    }

    public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    private boolean shouldMeasureChild(android.view.View view, int i, int i2, androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i, ((android.view.ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((android.view.ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public final boolean A(android.view.View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int t = t(view);
        int v = v(view);
        int u = u(view);
        int s2 = s(view);
        return z ? (paddingLeft <= t && width >= u) && (paddingTop <= v && height >= s2) : (t >= width || u >= paddingLeft) && (v >= height || s2 >= paddingTop);
    }

    public final int B(com.google.android.flexbox.FlexLine flexLine, com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState) {
        return isMainAxisDirectionHorizontal() ? C(flexLine, layoutState) : D(flexLine, layoutState);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int C(com.google.android.flexbox.FlexLine flexLine, com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState) {
        float f;
        float f2;
        float f3;
        int itemCount;
        int i;
        com.google.android.flexbox.FlexboxLayoutManager.LayoutParams layoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i2 = layoutState.e;
        if (layoutState.i == -1) {
            i2 -= flexLine.g;
        }
        int i3 = i2;
        int i4 = layoutState.d;
        int i5 = this.u;
        int i6 = 1;
        if (i5 != 0) {
            if (i5 == 1) {
                int i7 = flexLine.e;
                float f4 = (width - i7) + paddingRight;
                f3 = 0.0f;
                f2 = i7 - paddingLeft;
                f = f4;
            } else if (i5 == 2) {
                int i8 = flexLine.e;
                f = paddingLeft + ((width - i8) / 2.0f);
                f2 = (width - paddingRight) - ((width - i8) / 2.0f);
            } else if (i5 == 3) {
                f = paddingLeft;
                f3 = (width - flexLine.e) / (flexLine.h != 1 ? r4 - 1 : 1.0f);
                f2 = width - paddingRight;
            } else if (i5 == 4) {
                int i9 = flexLine.h;
                f3 = i9 != 0 ? (width - flexLine.e) / i9 : 0.0f;
                float f5 = f3 / 2.0f;
                f = paddingLeft + f5;
                f2 = (width - paddingRight) - f5;
            } else {
                if (i5 != 5) {
                    throw new java.lang.IllegalStateException("Invalid justifyContent is set: " + this.u);
                }
                f3 = flexLine.h != 0 ? (width - flexLine.e) / (r4 + 1) : 0.0f;
                f = paddingLeft + f3;
                f2 = (width - paddingRight) - f3;
            }
            float f6 = f - this.E.d;
            float f7 = f2 - this.E.d;
            float max = java.lang.Math.max(f3, 0.0f);
            itemCount = flexLine.getItemCount();
            int i10 = 0;
            i = i4;
            while (i < i4 + itemCount) {
                android.view.View flexItemAt = getFlexItemAt(i);
                if (flexItemAt != null) {
                    if (layoutState.i == i6) {
                        calculateItemDecorationsForChild(flexItemAt, S);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, S);
                        addView(flexItemAt, i10);
                        i10++;
                    }
                    int i11 = i10;
                    com.google.android.flexbox.FlexboxHelper flexboxHelper = this.A;
                    long j = flexboxHelper.d[i];
                    int y = flexboxHelper.y(j);
                    int x = this.A.x(j);
                    com.google.android.flexbox.FlexboxLayoutManager.LayoutParams layoutParams2 = (com.google.android.flexbox.FlexboxLayoutManager.LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, y, x, layoutParams2)) {
                        flexItemAt.measure(y, x);
                    }
                    float leftDecorationWidth = f6 + ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + getLeftDecorationWidth(flexItemAt);
                    float rightDecorationWidth = f7 - (((android.view.ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getRightDecorationWidth(flexItemAt));
                    int topDecorationHeight = i3 + getTopDecorationHeight(flexItemAt);
                    if (this.x) {
                        layoutParams = layoutParams2;
                        this.A.Q(flexItemAt, flexLine, java.lang.Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, java.lang.Math.round(rightDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    } else {
                        layoutParams = layoutParams2;
                        this.A.Q(flexItemAt, flexLine, java.lang.Math.round(leftDecorationWidth), topDecorationHeight, java.lang.Math.round(leftDecorationWidth) + flexItemAt.getMeasuredWidth(), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    }
                    i10 = i11;
                    f6 = leftDecorationWidth + flexItemAt.getMeasuredWidth() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt) + max;
                    f7 = rightDecorationWidth - (((flexItemAt.getMeasuredWidth() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(flexItemAt)) + max);
                }
                i++;
                i6 = 1;
            }
            com.google.android.flexbox.FlexboxLayoutManager.LayoutState.n(layoutState, this.D.i);
            return flexLine.getCrossSize();
        }
        f = paddingLeft;
        f2 = width - paddingRight;
        f3 = 0.0f;
        float f62 = f - this.E.d;
        float f72 = f2 - this.E.d;
        float max2 = java.lang.Math.max(f3, 0.0f);
        itemCount = flexLine.getItemCount();
        int i102 = 0;
        i = i4;
        while (i < i4 + itemCount) {
        }
        com.google.android.flexbox.FlexboxLayoutManager.LayoutState.n(layoutState, this.D.i);
        return flexLine.getCrossSize();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int D(com.google.android.flexbox.FlexLine flexLine, com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState) {
        float f;
        float f2;
        float f3;
        int itemCount;
        int i;
        float f4;
        android.view.View view;
        int i2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = layoutState.e;
        int i4 = layoutState.e;
        if (layoutState.i == -1) {
            int i5 = flexLine.g;
            i3 -= i5;
            i4 += i5;
        }
        int i6 = i3;
        int i7 = i4;
        int i8 = layoutState.d;
        int i9 = this.u;
        if (i9 != 0) {
            if (i9 == 1) {
                int i10 = flexLine.e;
                float f5 = (height - i10) + paddingBottom;
                f3 = 0.0f;
                f2 = i10 - paddingTop;
                f = f5;
            } else if (i9 == 2) {
                int i11 = flexLine.e;
                f = paddingTop + ((height - i11) / 2.0f);
                f2 = (height - paddingBottom) - ((height - i11) / 2.0f);
            } else if (i9 == 3) {
                f = paddingTop;
                f3 = (height - flexLine.e) / (flexLine.h != 1 ? r4 - 1 : 1.0f);
                f2 = height - paddingBottom;
            } else if (i9 == 4) {
                int i12 = flexLine.h;
                f3 = i12 != 0 ? (height - flexLine.e) / i12 : 0.0f;
                float f6 = f3 / 2.0f;
                f = paddingTop + f6;
                f2 = (height - paddingBottom) - f6;
            } else {
                if (i9 != 5) {
                    throw new java.lang.IllegalStateException("Invalid justifyContent is set: " + this.u);
                }
                f3 = flexLine.h != 0 ? (height - flexLine.e) / (r4 + 1) : 0.0f;
                f = paddingTop + f3;
                f2 = (height - paddingBottom) - f3;
            }
            float f7 = f - this.E.d;
            float f8 = f2 - this.E.d;
            float max = java.lang.Math.max(f3, 0.0f);
            itemCount = flexLine.getItemCount();
            int i13 = 0;
            i = i8;
            while (i < i8 + itemCount) {
                android.view.View flexItemAt = getFlexItemAt(i);
                if (flexItemAt == null) {
                    i2 = i;
                    f4 = max;
                } else {
                    com.google.android.flexbox.FlexboxHelper flexboxHelper = this.A;
                    f4 = max;
                    long j = flexboxHelper.d[i];
                    int y = flexboxHelper.y(j);
                    int x = this.A.x(j);
                    if (shouldMeasureChild(flexItemAt, y, x, (com.google.android.flexbox.FlexboxLayoutManager.LayoutParams) flexItemAt.getLayoutParams())) {
                        flexItemAt.measure(y, x);
                    }
                    float topDecorationHeight = f7 + ((android.view.ViewGroup.MarginLayoutParams) r13).topMargin + getTopDecorationHeight(flexItemAt);
                    float bottomDecorationHeight = f8 - (((android.view.ViewGroup.MarginLayoutParams) r13).rightMargin + getBottomDecorationHeight(flexItemAt));
                    if (layoutState.i == 1) {
                        calculateItemDecorationsForChild(flexItemAt, S);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, S);
                        addView(flexItemAt, i13);
                        i13++;
                    }
                    int i14 = i13;
                    int leftDecorationWidth = i6 + getLeftDecorationWidth(flexItemAt);
                    int rightDecorationWidth = i7 - getRightDecorationWidth(flexItemAt);
                    boolean z = this.x;
                    if (!z) {
                        view = flexItemAt;
                        i2 = i;
                        if (this.y) {
                            this.A.R(view, flexLine, z, leftDecorationWidth, java.lang.Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), java.lang.Math.round(bottomDecorationHeight));
                        } else {
                            this.A.R(view, flexLine, z, leftDecorationWidth, java.lang.Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), java.lang.Math.round(topDecorationHeight) + view.getMeasuredHeight());
                        }
                    } else if (this.y) {
                        view = flexItemAt;
                        i2 = i;
                        this.A.R(flexItemAt, flexLine, z, rightDecorationWidth - flexItemAt.getMeasuredWidth(), java.lang.Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, java.lang.Math.round(bottomDecorationHeight));
                    } else {
                        view = flexItemAt;
                        i2 = i;
                        this.A.R(view, flexLine, z, rightDecorationWidth - view.getMeasuredWidth(), java.lang.Math.round(topDecorationHeight), rightDecorationWidth, java.lang.Math.round(topDecorationHeight) + view.getMeasuredHeight());
                    }
                    android.view.View view2 = view;
                    f7 = topDecorationHeight + view.getMeasuredHeight() + ((android.view.ViewGroup.MarginLayoutParams) r13).topMargin + getBottomDecorationHeight(view2) + f4;
                    i13 = i14;
                    f8 = bottomDecorationHeight - (((view2.getMeasuredHeight() + ((android.view.ViewGroup.MarginLayoutParams) r13).bottomMargin) + getTopDecorationHeight(view2)) + f4);
                }
                i = i2 + 1;
                max = f4;
            }
            com.google.android.flexbox.FlexboxLayoutManager.LayoutState.n(layoutState, this.D.i);
            return flexLine.getCrossSize();
        }
        f = paddingTop;
        f2 = height - paddingBottom;
        f3 = 0.0f;
        float f72 = f - this.E.d;
        float f82 = f2 - this.E.d;
        float max2 = java.lang.Math.max(f3, 0.0f);
        itemCount = flexLine.getItemCount();
        int i132 = 0;
        i = i8;
        while (i < i8 + itemCount) {
        }
        com.google.android.flexbox.FlexboxLayoutManager.LayoutState.n(layoutState, this.D.i);
        return flexLine.getCrossSize();
    }

    public final void E(androidx.recyclerview.widget.RecyclerView.Recycler recycler, com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState) {
        if (layoutState.j) {
            if (layoutState.i == -1) {
                F(recycler, layoutState);
            } else {
                G(recycler, layoutState);
            }
        }
    }

    public final void F(androidx.recyclerview.widget.RecyclerView.Recycler recycler, com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState) {
        int childCount;
        int i;
        android.view.View childAt;
        int i2;
        if (layoutState.f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(childCount - 1)) == null || (i2 = this.A.c[getPosition(childAt)]) == -1) {
            return;
        }
        com.google.android.flexbox.FlexLine flexLine = this.z.get(i2);
        int i3 = i;
        while (true) {
            if (i3 < 0) {
                break;
            }
            android.view.View childAt2 = getChildAt(i3);
            if (childAt2 != null) {
                if (!h(childAt2, layoutState.f)) {
                    break;
                }
                if (flexLine.o != getPosition(childAt2)) {
                    continue;
                } else if (i2 <= 0) {
                    childCount = i3;
                    break;
                } else {
                    i2 += layoutState.i;
                    flexLine = this.z.get(i2);
                    childCount = i3;
                }
            }
            i3--;
        }
        recycleChildren(recycler, childCount, i);
    }

    public final void G(androidx.recyclerview.widget.RecyclerView.Recycler recycler, com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState) {
        int childCount;
        android.view.View childAt;
        if (layoutState.f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i = this.A.c[getPosition(childAt)];
        int i2 = -1;
        if (i == -1) {
            return;
        }
        com.google.android.flexbox.FlexLine flexLine = this.z.get(i);
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            android.view.View childAt2 = getChildAt(i3);
            if (childAt2 != null) {
                if (!i(childAt2, layoutState.f)) {
                    break;
                }
                if (flexLine.p != getPosition(childAt2)) {
                    continue;
                } else if (i >= this.z.size() - 1) {
                    i2 = i3;
                    break;
                } else {
                    i += layoutState.i;
                    flexLine = this.z.get(i);
                    i2 = i3;
                }
            }
            i3++;
        }
        recycleChildren(recycler, 0, i2);
    }

    public final void H() {
        int heightMode = isMainAxisDirectionHorizontal() ? getHeightMode() : getWidthMode();
        this.D.b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    public final void I() {
        int layoutDirection = getLayoutDirection();
        int i = this.n;
        if (i == 0) {
            this.x = layoutDirection == 1;
            this.y = this.t == 2;
            return;
        }
        if (i == 1) {
            this.x = layoutDirection != 1;
            this.y = this.t == 2;
            return;
        }
        if (i == 2) {
            boolean z = layoutDirection == 1;
            this.x = z;
            if (this.t == 2) {
                this.x = !z;
            }
            this.y = false;
            return;
        }
        if (i != 3) {
            this.x = false;
            this.y = false;
            return;
        }
        boolean z2 = layoutDirection == 1;
        this.x = z2;
        if (this.t == 2) {
            this.x = !z2;
        }
        this.y = true;
    }

    public final boolean J(androidx.recyclerview.widget.RecyclerView.State state, com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo anchorInfo) {
        if (getChildCount() == 0) {
            return false;
        }
        android.view.View o = anchorInfo.e ? o(state.getItemCount()) : m(state.getItemCount());
        if (o == null) {
            return false;
        }
        anchorInfo.s(o);
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.F.getDecoratedStart(o) >= this.F.getEndAfterPadding() || this.F.getDecoratedEnd(o) < this.F.getStartAfterPadding()) {
                anchorInfo.c = anchorInfo.e ? this.F.getEndAfterPadding() : this.F.getStartAfterPadding();
            }
        }
        return true;
    }

    public final boolean K(androidx.recyclerview.widget.RecyclerView.State state, com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo anchorInfo, com.google.android.flexbox.FlexboxLayoutManager.SavedState savedState) {
        int i;
        android.view.View childAt;
        if (!state.isPreLayout() && (i = this.I) != -1) {
            if (i >= 0 && i < state.getItemCount()) {
                anchorInfo.a = this.I;
                anchorInfo.b = this.A.c[anchorInfo.a];
                com.google.android.flexbox.FlexboxLayoutManager.SavedState savedState2 = this.H;
                if (savedState2 != null && savedState2.hasValidAnchor(state.getItemCount())) {
                    anchorInfo.c = this.F.getStartAfterPadding() + savedState.mAnchorOffset;
                    anchorInfo.g = true;
                    anchorInfo.b = -1;
                    return true;
                }
                if (this.J != Integer.MIN_VALUE) {
                    if (isMainAxisDirectionHorizontal() || !this.x) {
                        anchorInfo.c = this.F.getStartAfterPadding() + this.J;
                    } else {
                        anchorInfo.c = this.J - this.F.getEndPadding();
                    }
                    return true;
                }
                android.view.View findViewByPosition = findViewByPosition(this.I);
                if (findViewByPosition == null) {
                    if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                        anchorInfo.e = this.I < getPosition(childAt);
                    }
                    anchorInfo.r();
                } else {
                    if (this.F.getDecoratedMeasurement(findViewByPosition) > this.F.getTotalSpace()) {
                        anchorInfo.r();
                        return true;
                    }
                    if (this.F.getDecoratedStart(findViewByPosition) - this.F.getStartAfterPadding() < 0) {
                        anchorInfo.c = this.F.getStartAfterPadding();
                        anchorInfo.e = false;
                        return true;
                    }
                    if (this.F.getEndAfterPadding() - this.F.getDecoratedEnd(findViewByPosition) < 0) {
                        anchorInfo.c = this.F.getEndAfterPadding();
                        anchorInfo.e = true;
                        return true;
                    }
                    anchorInfo.c = anchorInfo.e ? this.F.getDecoratedEnd(findViewByPosition) + this.F.getTotalSpaceChange() : this.F.getDecoratedStart(findViewByPosition);
                }
                return true;
            }
            this.I = -1;
            this.J = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void L(androidx.recyclerview.widget.RecyclerView.State state, com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo anchorInfo) {
        if (K(state, anchorInfo, this.H) || J(state, anchorInfo)) {
            return;
        }
        anchorInfo.r();
        anchorInfo.a = 0;
        anchorInfo.b = 0;
    }

    public final void M(int i) {
        if (i >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.A.t(childCount);
        this.A.u(childCount);
        this.A.s(childCount);
        if (i >= this.A.c.length) {
            return;
        }
        this.Q = i;
        android.view.View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.I = getPosition(childClosestToStart);
        if (isMainAxisDirectionHorizontal() || !this.x) {
            this.J = this.F.getDecoratedStart(childClosestToStart) - this.F.getStartAfterPadding();
        } else {
            this.J = this.F.getDecoratedEnd(childClosestToStart) + this.F.getEndPadding();
        }
    }

    public final void N(int i) {
        boolean z;
        int i2;
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (isMainAxisDirectionHorizontal()) {
            int i3 = this.K;
            z = (i3 == Integer.MIN_VALUE || i3 == width) ? false : true;
            i2 = this.D.b ? this.O.getResources().getDisplayMetrics().heightPixels : this.D.a;
        } else {
            int i4 = this.L;
            z = (i4 == Integer.MIN_VALUE || i4 == height) ? false : true;
            i2 = this.D.b ? this.O.getResources().getDisplayMetrics().widthPixels : this.D.a;
        }
        int i5 = i2;
        this.K = width;
        this.L = height;
        int i6 = this.Q;
        if (i6 == -1 && (this.I != -1 || z)) {
            if (this.E.e) {
                return;
            }
            this.z.clear();
            this.R.a();
            if (isMainAxisDirectionHorizontal()) {
                this.A.e(this.R, makeMeasureSpec, makeMeasureSpec2, i5, this.E.a, this.z);
            } else {
                this.A.h(this.R, makeMeasureSpec, makeMeasureSpec2, i5, this.E.a, this.z);
            }
            this.z = this.R.a;
            this.A.p(makeMeasureSpec, makeMeasureSpec2);
            this.A.X();
            com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo anchorInfo = this.E;
            anchorInfo.b = this.A.c[anchorInfo.a];
            this.D.c = this.E.b;
            return;
        }
        int min = i6 != -1 ? java.lang.Math.min(i6, this.E.a) : this.E.a;
        this.R.a();
        if (isMainAxisDirectionHorizontal()) {
            if (this.z.size() > 0) {
                this.A.j(this.z, min);
                this.A.b(this.R, makeMeasureSpec, makeMeasureSpec2, i5, min, this.E.a, this.z);
            } else {
                this.A.s(i);
                this.A.d(this.R, makeMeasureSpec, makeMeasureSpec2, i5, 0, this.z);
            }
        } else if (this.z.size() > 0) {
            this.A.j(this.z, min);
            this.A.b(this.R, makeMeasureSpec2, makeMeasureSpec, i5, min, this.E.a, this.z);
        } else {
            this.A.s(i);
            this.A.g(this.R, makeMeasureSpec, makeMeasureSpec2, i5, 0, this.z);
        }
        this.z = this.R.a;
        this.A.q(makeMeasureSpec, makeMeasureSpec2, min);
        this.A.Y(min);
    }

    public final void O(int i, int i2) {
        this.D.i = i;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !isMainAxisDirectionHorizontal && this.x;
        if (i == 1) {
            android.view.View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.D.e = this.F.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            android.view.View p = p(childAt, this.z.get(this.A.c[position]));
            this.D.h = 1;
            com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState = this.D;
            layoutState.d = position + layoutState.h;
            if (this.A.c.length <= this.D.d) {
                this.D.c = -1;
            } else {
                com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState2 = this.D;
                layoutState2.c = this.A.c[layoutState2.d];
            }
            if (z) {
                this.D.e = this.F.getDecoratedStart(p);
                this.D.f = (-this.F.getDecoratedStart(p)) + this.F.getStartAfterPadding();
                com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState3 = this.D;
                layoutState3.f = java.lang.Math.max(layoutState3.f, 0);
            } else {
                this.D.e = this.F.getDecoratedEnd(p);
                this.D.f = this.F.getDecoratedEnd(p) - this.F.getEndAfterPadding();
            }
            if ((this.D.c == -1 || this.D.c > this.z.size() - 1) && this.D.d <= getFlexItemCount()) {
                int i3 = i2 - this.D.f;
                this.R.a();
                if (i3 > 0) {
                    if (isMainAxisDirectionHorizontal) {
                        this.A.d(this.R, makeMeasureSpec, makeMeasureSpec2, i3, this.D.d, this.z);
                    } else {
                        this.A.g(this.R, makeMeasureSpec, makeMeasureSpec2, i3, this.D.d, this.z);
                    }
                    this.A.q(makeMeasureSpec, makeMeasureSpec2, this.D.d);
                    this.A.Y(this.D.d);
                }
            }
        } else {
            android.view.View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.D.e = this.F.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            android.view.View n = n(childAt2, this.z.get(this.A.c[position2]));
            this.D.h = 1;
            int i4 = this.A.c[position2];
            if (i4 == -1) {
                i4 = 0;
            }
            if (i4 > 0) {
                this.D.d = position2 - this.z.get(i4 - 1).getItemCount();
            } else {
                this.D.d = -1;
            }
            this.D.c = i4 > 0 ? i4 - 1 : 0;
            if (z) {
                this.D.e = this.F.getDecoratedEnd(n);
                this.D.f = this.F.getDecoratedEnd(n) - this.F.getEndAfterPadding();
                com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState4 = this.D;
                layoutState4.f = java.lang.Math.max(layoutState4.f, 0);
            } else {
                this.D.e = this.F.getDecoratedStart(n);
                this.D.f = (-this.F.getDecoratedStart(n)) + this.F.getStartAfterPadding();
            }
        }
        com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState5 = this.D;
        layoutState5.a = i2 - layoutState5.f;
    }

    public final void P(com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo anchorInfo, boolean z, boolean z2) {
        if (z2) {
            H();
        } else {
            this.D.b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.x) {
            this.D.a = this.F.getEndAfterPadding() - anchorInfo.c;
        } else {
            this.D.a = anchorInfo.c - getPaddingRight();
        }
        this.D.d = anchorInfo.a;
        this.D.h = 1;
        this.D.i = 1;
        this.D.e = anchorInfo.c;
        this.D.f = Integer.MIN_VALUE;
        this.D.c = anchorInfo.b;
        if (!z || this.z.size() <= 1 || anchorInfo.b < 0 || anchorInfo.b >= this.z.size() - 1) {
            return;
        }
        com.google.android.flexbox.FlexLine flexLine = this.z.get(anchorInfo.b);
        com.google.android.flexbox.FlexboxLayoutManager.LayoutState.l(this.D);
        com.google.android.flexbox.FlexboxLayoutManager.LayoutState.u(this.D, flexLine.getItemCount());
    }

    public final void Q(com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo anchorInfo, boolean z, boolean z2) {
        if (z2) {
            H();
        } else {
            this.D.b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.x) {
            this.D.a = anchorInfo.c - this.F.getStartAfterPadding();
        } else {
            this.D.a = (this.P.getWidth() - anchorInfo.c) - this.F.getStartAfterPadding();
        }
        this.D.d = anchorInfo.a;
        this.D.h = 1;
        this.D.i = -1;
        this.D.e = anchorInfo.c;
        this.D.f = Integer.MIN_VALUE;
        this.D.c = anchorInfo.b;
        if (!z || anchorInfo.b <= 0 || this.z.size() <= anchorInfo.b) {
            return;
        }
        com.google.android.flexbox.FlexLine flexLine = this.z.get(anchorInfo.b);
        com.google.android.flexbox.FlexboxLayoutManager.LayoutState.m(this.D);
        com.google.android.flexbox.FlexboxLayoutManager.LayoutState.v(this.D, flexLine.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.t == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            android.view.View view = this.P;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.t == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        android.view.View view = this.P;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof com.google.android.flexbox.FlexboxLayoutManager.LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(androidx.recyclerview.widget.RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        k();
        android.view.View m = m(itemCount);
        android.view.View o = o(itemCount);
        if (state.getItemCount() == 0 || m == null || o == null) {
            return 0;
        }
        return java.lang.Math.min(this.F.getTotalSpace(), this.F.getDecoratedEnd(o) - this.F.getDecoratedStart(m));
    }

    public final int computeScrollOffset(androidx.recyclerview.widget.RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        android.view.View m = m(itemCount);
        android.view.View o = o(itemCount);
        if (state.getItemCount() != 0 && m != null && o != null) {
            int position = getPosition(m);
            int position2 = getPosition(o);
            int abs = java.lang.Math.abs(this.F.getDecoratedEnd(o) - this.F.getDecoratedStart(m));
            int i = this.A.c[position];
            if (i != 0 && i != -1) {
                return java.lang.Math.round((i * (abs / ((r4[position2] - i) + 1))) + (this.F.getStartAfterPadding() - this.F.getDecoratedStart(m)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(androidx.recyclerview.widget.RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        android.view.View m = m(itemCount);
        android.view.View o = o(itemCount);
        if (state.getItemCount() == 0 || m == null || o == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((java.lang.Math.abs(this.F.getDecoratedEnd(o) - this.F.getDecoratedStart(m)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public android.graphics.PointF computeScrollVectorForPosition(int i) {
        android.view.View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i2 = i < getPosition(childAt) ? -1 : 1;
        return isMainAxisDirectionHorizontal() ? new android.graphics.PointF(0.0f, i2) : new android.graphics.PointF(i2, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final void ensureLayoutState() {
        if (this.D == null) {
            this.D = new com.google.android.flexbox.FlexboxLayoutManager.LayoutState(null);
        }
    }

    public int findFirstCompletelyVisibleItemPosition() {
        android.view.View q = q(0, getChildCount(), true);
        if (q == null) {
            return -1;
        }
        return getPosition(q);
    }

    public int findFirstVisibleItemPosition() {
        android.view.View q = q(0, getChildCount(), false);
        if (q == null) {
            return -1;
        }
        return getPosition(q);
    }

    public int findLastCompletelyVisibleItemPosition() {
        android.view.View q = q(getChildCount() - 1, -1, true);
        if (q == null) {
            return -1;
        }
        return getPosition(q);
    }

    public int findLastVisibleItemPosition() {
        android.view.View q = q(getChildCount() - 1, -1, false);
        if (q == null) {
            return -1;
        }
        return getPosition(q);
    }

    public final int fixLayoutEndGap(int i, androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state, boolean z) {
        int i2;
        int endAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.x) {
            int startAfterPadding = i - this.F.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            i2 = x(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.F.getEndAfterPadding() - i;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            i2 = -x(-endAfterPadding2, recycler, state);
        }
        int i3 = i + i2;
        if (!z || (endAfterPadding = this.F.getEndAfterPadding() - i3) <= 0) {
            return i2;
        }
        this.F.offsetChildren(endAfterPadding);
        return endAfterPadding + i2;
    }

    public final int fixLayoutStartGap(int i, androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (isMainAxisDirectionHorizontal() || !this.x) {
            int startAfterPadding2 = i - this.F.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            i2 = -x(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.F.getEndAfterPadding() - i;
            if (endAfterPadding <= 0) {
                return 0;
            }
            i2 = x(-endAfterPadding, recycler, state);
        }
        int i3 = i + i2;
        if (!z || (startAfterPadding = i3 - this.F.getStartAfterPadding()) <= 0) {
            return i2;
        }
        this.F.offsetChildren(-startAfterPadding);
        return i2 - startAfterPadding;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new com.google.android.flexbox.FlexboxLayoutManager.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new com.google.android.flexbox.FlexboxLayoutManager.LayoutParams(context, attributeSet);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.v;
    }

    public final android.view.View getChildClosestToStart() {
        return getChildAt(0);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int i, int i2, int i3) {
        return androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int i, int i2, int i3) {
        return androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(android.view.View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(android.view.View view, int i, int i2) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.n;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public android.view.View getFlexItemAt(int i) {
        android.view.View view = this.N.get(i);
        return view != null ? view : this.B.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return this.C.getItemCount();
    }

    @androidx.annotation.NonNull
    public java.util.List<com.google.android.flexbox.FlexLine> getFlexLines() {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.z.size());
        int size = this.z.size();
        for (int i = 0; i < size; i++) {
            com.google.android.flexbox.FlexLine flexLine = this.z.get(i);
            if (flexLine.getItemCount() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public java.util.List<com.google.android.flexbox.FlexLine> getFlexLinesInternal() {
        return this.z;
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
        if (this.z.size() == 0) {
            return 0;
        }
        int size = this.z.size();
        int i = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            i = java.lang.Math.max(i, this.z.get(i2).e);
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.w;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.M;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public android.view.View getReorderedFlexItemAt(int i) {
        return getFlexItemAt(i);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.z.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.z.get(i2).g;
        }
        return i;
    }

    public final boolean h(android.view.View view, int i) {
        return (isMainAxisDirectionHorizontal() || !this.x) ? this.F.getDecoratedStart(view) >= this.F.getEnd() - i : this.F.getDecoratedEnd(view) <= i;
    }

    public final boolean i(android.view.View view, int i) {
        return (isMainAxisDirectionHorizontal() || !this.x) ? this.F.getDecoratedEnd(view) <= i : this.F.getEnd() - this.F.getDecoratedStart(view) <= i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.n;
        return i == 0 || i == 1;
    }

    public final void j() {
        this.z.clear();
        this.E.t();
        this.E.d = 0;
    }

    public final void k() {
        if (this.F != null) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            if (this.t == 0) {
                this.F = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(this);
                this.G = androidx.recyclerview.widget.OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.F = androidx.recyclerview.widget.OrientationHelper.createVerticalHelper(this);
                this.G = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.t == 0) {
            this.F = androidx.recyclerview.widget.OrientationHelper.createVerticalHelper(this);
            this.G = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(this);
        } else {
            this.F = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(this);
            this.G = androidx.recyclerview.widget.OrientationHelper.createVerticalHelper(this);
        }
    }

    public final int l(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state, com.google.android.flexbox.FlexboxLayoutManager.LayoutState layoutState) {
        if (layoutState.f != Integer.MIN_VALUE) {
            if (layoutState.a < 0) {
                com.google.android.flexbox.FlexboxLayoutManager.LayoutState.q(layoutState, layoutState.a);
            }
            E(recycler, layoutState);
        }
        int i = layoutState.a;
        int i2 = layoutState.a;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i3 = 0;
        while (true) {
            if ((i2 > 0 || this.D.b) && layoutState.D(state, this.z)) {
                com.google.android.flexbox.FlexLine flexLine = this.z.get(layoutState.c);
                layoutState.d = flexLine.o;
                i3 += B(flexLine, layoutState);
                if (isMainAxisDirectionHorizontal || !this.x) {
                    com.google.android.flexbox.FlexboxLayoutManager.LayoutState.c(layoutState, flexLine.getCrossSize() * layoutState.i);
                } else {
                    com.google.android.flexbox.FlexboxLayoutManager.LayoutState.d(layoutState, flexLine.getCrossSize() * layoutState.i);
                }
                i2 -= flexLine.getCrossSize();
            }
        }
        com.google.android.flexbox.FlexboxLayoutManager.LayoutState.i(layoutState, i3);
        if (layoutState.f != Integer.MIN_VALUE) {
            com.google.android.flexbox.FlexboxLayoutManager.LayoutState.q(layoutState, i3);
            if (layoutState.a < 0) {
                com.google.android.flexbox.FlexboxLayoutManager.LayoutState.q(layoutState, layoutState.a);
            }
            E(recycler, layoutState);
        }
        return i - layoutState.a;
    }

    public final android.view.View m(int i) {
        android.view.View r = r(0, getChildCount(), i);
        if (r == null) {
            return null;
        }
        int i2 = this.A.c[getPosition(r)];
        if (i2 == -1) {
            return null;
        }
        return n(r, this.z.get(i2));
    }

    public final android.view.View n(android.view.View view, com.google.android.flexbox.FlexLine flexLine) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i = flexLine.h;
        for (int i2 = 1; i2 < i; i2++) {
            android.view.View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.x || isMainAxisDirectionHorizontal) {
                    if (this.F.getDecoratedStart(view) <= this.F.getDecoratedStart(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.F.getDecoratedEnd(view) >= this.F.getDecoratedEnd(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final android.view.View o(int i) {
        android.view.View r = r(getChildCount() - 1, -1, i);
        if (r == null) {
            return null;
        }
        return p(r, this.z.get(this.A.c[getPosition(r)]));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(androidx.recyclerview.widget.RecyclerView.Adapter adapter, androidx.recyclerview.widget.RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.P = (android.view.View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.M) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        M(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        M(java.lang.Math.min(i, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        M(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        M(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2, java.lang.Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        M(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        int i;
        int i2;
        this.B = recycler;
        this.C = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        I();
        k();
        ensureLayoutState();
        this.A.t(itemCount);
        this.A.u(itemCount);
        this.A.s(itemCount);
        this.D.j = false;
        com.google.android.flexbox.FlexboxLayoutManager.SavedState savedState = this.H;
        if (savedState != null && savedState.hasValidAnchor(itemCount)) {
            this.I = this.H.mAnchorPosition;
        }
        if (!this.E.f || this.I != -1 || this.H != null) {
            this.E.t();
            L(state, this.E);
            this.E.f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.E.e) {
            Q(this.E, false, true);
        } else {
            P(this.E, false, true);
        }
        N(itemCount);
        l(recycler, state, this.D);
        if (this.E.e) {
            i2 = this.D.e;
            P(this.E, true, false);
            l(recycler, state, this.D);
            i = this.D.e;
        } else {
            i = this.D.e;
            Q(this.E, true, false);
            l(recycler, state, this.D);
            i2 = this.D.e;
        }
        if (getChildCount() > 0) {
            if (this.E.e) {
                fixLayoutStartGap(i2 + fixLayoutEndGap(i, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(androidx.recyclerview.widget.RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.H = null;
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.Q = -1;
        this.E.t();
        this.N.clear();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(android.view.View view, int i, int i2, com.google.android.flexbox.FlexLine flexLine) {
        calculateItemDecorationsForChild(view, S);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            flexLine.e += leftDecorationWidth;
            flexLine.f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            flexLine.e += topDecorationHeight;
            flexLine.f += topDecorationHeight;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(com.google.android.flexbox.FlexLine flexLine) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (parcelable instanceof com.google.android.flexbox.FlexboxLayoutManager.SavedState) {
            this.H = (com.google.android.flexbox.FlexboxLayoutManager.SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public android.os.Parcelable onSaveInstanceState() {
        if (this.H != null) {
            return new com.google.android.flexbox.FlexboxLayoutManager.SavedState(this.H, (com.google.android.flexbox.FlexboxLayoutManager.AnonymousClass1) null);
        }
        com.google.android.flexbox.FlexboxLayoutManager.SavedState savedState = new com.google.android.flexbox.FlexboxLayoutManager.SavedState();
        if (getChildCount() > 0) {
            android.view.View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.F.getDecoratedStart(childClosestToStart) - this.F.getStartAfterPadding();
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public final android.view.View p(android.view.View view, com.google.android.flexbox.FlexLine flexLine) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - flexLine.h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            android.view.View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.x || isMainAxisDirectionHorizontal) {
                    if (this.F.getDecoratedEnd(view) >= this.F.getDecoratedEnd(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.F.getDecoratedStart(view) <= this.F.getDecoratedStart(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final android.view.View q(int i, int i2, boolean z) {
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            android.view.View childAt = getChildAt(i);
            if (A(childAt, z)) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    public final android.view.View r(int i, int i2, int i3) {
        int position;
        k();
        ensureLayoutState();
        int startAfterPadding = this.F.getStartAfterPadding();
        int endAfterPadding = this.F.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        android.view.View view = null;
        android.view.View view2 = null;
        while (i != i2) {
            android.view.View childAt = getChildAt(i);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < i3) {
                if (((androidx.recyclerview.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.F.getDecoratedStart(childAt) >= startAfterPadding && this.F.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    public final void recycleChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    public final int s(android.view.View view) {
        return getDecoratedBottom(view) + ((android.view.ViewGroup.MarginLayoutParams) ((androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal() || this.t == 0) {
            int x = x(i, recycler, state);
            this.N.clear();
            return x;
        }
        int y = y(i);
        com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo.l(this.E, y);
        this.G.offsetChildren(-y);
        return y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.I = i;
        this.J = Integer.MIN_VALUE;
        com.google.android.flexbox.FlexboxLayoutManager.SavedState savedState = this.H;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal() || (this.t == 0 && !isMainAxisDirectionHorizontal())) {
            int x = x(i, recycler, state);
            this.N.clear();
            return x;
        }
        int y = y(i);
        com.google.android.flexbox.FlexboxLayoutManager.AnchorInfo.l(this.E, y);
        this.G.offsetChildren(-y);
        return y;
    }

    public void setAlignContent(int i) {
        throw new java.lang.UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    public void setAlignItems(int i) {
        int i2 = this.v;
        if (i2 != i) {
            if (i2 == 4 || i == 4) {
                removeAllViews();
                j();
            }
            this.v = i;
            requestLayout();
        }
    }

    public void setFlexDirection(int i) {
        if (this.n != i) {
            removeAllViews();
            this.n = i;
            this.F = null;
            this.G = null;
            j();
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(java.util.List<com.google.android.flexbox.FlexLine> list) {
        this.z = list;
    }

    public void setFlexWrap(int i) {
        if (i == 2) {
            throw new java.lang.UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i2 = this.t;
        if (i2 != i) {
            if (i2 == 0 || i == 0) {
                removeAllViews();
                j();
            }
            this.t = i;
            this.F = null;
            this.G = null;
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
        if (this.w != i) {
            this.w = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.M = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state, int i) {
        androidx.recyclerview.widget.LinearSmoothScroller linearSmoothScroller = new androidx.recyclerview.widget.LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public final int t(android.view.View view) {
        return getDecoratedLeft(view) - ((android.view.ViewGroup.MarginLayoutParams) ((androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    public final int u(android.view.View view) {
        return getDecoratedRight(view) + ((android.view.ViewGroup.MarginLayoutParams) ((androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int i, android.view.View view) {
        this.N.put(i, view);
    }

    public final int v(android.view.View view) {
        return getDecoratedTop(view) - ((android.view.ViewGroup.MarginLayoutParams) ((androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public int w(int i) {
        return this.A.c[i];
    }

    public final int x(int i, androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        k();
        int i2 = 1;
        this.D.j = true;
        boolean z = !isMainAxisDirectionHorizontal() && this.x;
        if (!z ? i <= 0 : i >= 0) {
            i2 = -1;
        }
        int abs = java.lang.Math.abs(i);
        O(i2, abs);
        int l = this.D.f + l(recycler, state, this.D);
        if (l < 0) {
            return 0;
        }
        if (z) {
            if (abs > l) {
                i = (-i2) * l;
            }
        } else if (abs > l) {
            i = i2 * l;
        }
        this.F.offsetChildren(-i);
        this.D.g = i;
        return i;
    }

    public final int y(int i) {
        int i2;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        k();
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        android.view.View view = this.P;
        int width = isMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = isMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = java.lang.Math.abs(i);
            if (i < 0) {
                i2 = java.lang.Math.min((width2 + this.E.d) - width, abs);
            } else {
                if (this.E.d + i <= 0) {
                    return i;
                }
                i2 = this.E.d;
            }
        } else {
            if (i > 0) {
                return java.lang.Math.min((width2 - this.E.d) - width, i);
            }
            if (this.E.d + i >= 0) {
                return i;
            }
            i2 = this.E.d;
        }
        return -i2;
    }

    public boolean z() {
        return this.x;
    }
}
