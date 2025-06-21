package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public abstract class OrientationHelper {
    public static final int HORIZONTAL = 0;
    private static final int INVALID_SIZE = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    private int mLastTotalSpace;
    protected final androidx.recyclerview.widget.RecyclerView.LayoutManager mLayoutManager;
    final android.graphics.Rect mTmpRect;

    /* renamed from: androidx.recyclerview.widget.OrientationHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.recyclerview.widget.OrientationHelper {
        public AnonymousClass1(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedEnd(android.view.View view) {
            return this.mLayoutManager.getDecoratedRight(view) + ((android.view.ViewGroup.MarginLayoutParams) ((androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurement(android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurementInOther(android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedStart(android.view.View view) {
            return this.mLayoutManager.getDecoratedLeft(view) - ((android.view.ViewGroup.MarginLayoutParams) ((androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEnd() {
            return this.mLayoutManager.getWidth();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndAfterPadding() {
            return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndPadding() {
            return this.mLayoutManager.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getMode() {
            return this.mLayoutManager.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getModeInOther() {
            return this.mLayoutManager.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTotalSpace() {
            return (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedEndWithDecoration(android.view.View view) {
            this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
            return this.mTmpRect.right;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedStartWithDecoration(android.view.View view) {
            this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
            return this.mTmpRect.left;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChild(android.view.View view, int i) {
            view.offsetLeftAndRight(i);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChildren(int i) {
            this.mLayoutManager.offsetChildrenHorizontal(i);
        }
    }

    /* renamed from: androidx.recyclerview.widget.OrientationHelper$2, reason: invalid class name */
    public class AnonymousClass2 extends androidx.recyclerview.widget.OrientationHelper {
        public AnonymousClass2(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedEnd(android.view.View view) {
            return this.mLayoutManager.getDecoratedBottom(view) + ((android.view.ViewGroup.MarginLayoutParams) ((androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurement(android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurementInOther(android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedStart(android.view.View view) {
            return this.mLayoutManager.getDecoratedTop(view) - ((android.view.ViewGroup.MarginLayoutParams) ((androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEnd() {
            return this.mLayoutManager.getHeight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndAfterPadding() {
            return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndPadding() {
            return this.mLayoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getMode() {
            return this.mLayoutManager.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getModeInOther() {
            return this.mLayoutManager.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTotalSpace() {
            return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedEndWithDecoration(android.view.View view) {
            this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
            return this.mTmpRect.bottom;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedStartWithDecoration(android.view.View view) {
            this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
            return this.mTmpRect.top;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChild(android.view.View view, int i) {
            view.offsetTopAndBottom(i);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChildren(int i) {
            this.mLayoutManager.offsetChildrenVertical(i);
        }
    }

    private OrientationHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        this.mLastTotalSpace = Integer.MIN_VALUE;
        this.mTmpRect = new android.graphics.Rect();
        this.mLayoutManager = layoutManager;
    }

    public /* synthetic */ OrientationHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, androidx.recyclerview.widget.OrientationHelper.AnonymousClass1 anonymousClass1) {
        this(layoutManager);
    }

    public static androidx.recyclerview.widget.OrientationHelper createHorizontalHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        return new androidx.recyclerview.widget.OrientationHelper.AnonymousClass1(layoutManager);
    }

    public static androidx.recyclerview.widget.OrientationHelper createOrientationHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, int i) {
        if (i == 0) {
            return createHorizontalHelper(layoutManager);
        }
        if (i == 1) {
            return createVerticalHelper(layoutManager);
        }
        throw new java.lang.IllegalArgumentException("invalid orientation");
    }

    public static androidx.recyclerview.widget.OrientationHelper createVerticalHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        return new androidx.recyclerview.widget.OrientationHelper.AnonymousClass2(layoutManager);
    }

    public abstract int getDecoratedEnd(android.view.View view);

    public abstract int getDecoratedMeasurement(android.view.View view);

    public abstract int getDecoratedMeasurementInOther(android.view.View view);

    public abstract int getDecoratedStart(android.view.View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public androidx.recyclerview.widget.RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        if (Integer.MIN_VALUE == this.mLastTotalSpace) {
            return 0;
        }
        return getTotalSpace() - this.mLastTotalSpace;
    }

    public abstract int getTransformedEndWithDecoration(android.view.View view);

    public abstract int getTransformedStartWithDecoration(android.view.View view);

    public abstract void offsetChild(android.view.View view, int i);

    public abstract void offsetChildren(int i);

    public void onLayoutComplete() {
        this.mLastTotalSpace = getTotalSpace();
    }
}
