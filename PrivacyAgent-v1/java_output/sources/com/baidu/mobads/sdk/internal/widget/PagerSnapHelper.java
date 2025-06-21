package com.baidu.mobads.sdk.internal.widget;

/* loaded from: classes.dex */
public class PagerSnapHelper extends androidx.recyclerview.widget.SnapHelper {
    private static final int a = 100;
    private static final float b = 100.0f;
    private static final boolean g = com.baidu.mobads.sdk.internal.au.a((java.lang.Class<?>) androidx.recyclerview.widget.OrientationHelper.class, "getLayoutManager", (java.lang.Class<?>[]) new java.lang.Class[0]);

    @androidx.annotation.Nullable
    private androidx.recyclerview.widget.OrientationHelper c;

    @androidx.annotation.Nullable
    private androidx.recyclerview.widget.RecyclerView.LayoutManager d;

    @androidx.annotation.Nullable
    private androidx.recyclerview.widget.OrientationHelper e;

    @androidx.annotation.Nullable
    private androidx.recyclerview.widget.RecyclerView.LayoutManager f;
    private androidx.recyclerview.widget.RecyclerView h;

    /* renamed from: com.baidu.mobads.sdk.internal.widget.PagerSnapHelper$1, reason: invalid class name */
    class AnonymousClass1 extends androidx.recyclerview.widget.LinearSmoothScroller {
        public AnonymousClass1(android.content.Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(android.util.DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i) {
            return java.lang.Math.min(100, super.calculateTimeForScrolling(i));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStop() {
            androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
            super.onStop();
            if (!com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.g || com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.this.h == null || com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.this.h.getScrollState() == 0 || (layoutManager = com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.this.h.getLayoutManager()) == null || layoutManager.getChildCount() > 1) {
                return;
            }
            com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.this.h.stopScroll();
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(android.view.View view, androidx.recyclerview.widget.RecyclerView.State state, androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action action) {
            if (com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.this.h == null || com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.this.h.getLayoutManager() == null) {
                return;
            }
            com.baidu.mobads.sdk.internal.widget.PagerSnapHelper pagerSnapHelper = com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.this;
            int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.h.getLayoutManager(), view);
            int i = calculateDistanceToFinalSnap[0];
            int i2 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(java.lang.Math.max(java.lang.Math.abs(i), java.lang.Math.abs(i2)));
            if (calculateTimeForDeceleration > 0) {
                action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    private int a(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, @androidx.annotation.NonNull android.view.View view, androidx.recyclerview.widget.OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    @androidx.annotation.Nullable
    private android.view.View a(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, androidx.recyclerview.widget.OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        android.view.View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = layoutManager.getChildAt(i2);
            int abs = java.lang.Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        android.graphics.PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    private boolean a(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, int i, int i2) {
        return layoutManager.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    @androidx.annotation.Nullable
    private androidx.recyclerview.widget.OrientationHelper b(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return c(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return d(layoutManager);
        }
        return null;
    }

    @androidx.annotation.NonNull
    private androidx.recyclerview.widget.OrientationHelper c(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        if (this.c == null || this.d != layoutManager) {
            this.d = layoutManager;
            this.c = androidx.recyclerview.widget.OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.c;
    }

    @androidx.annotation.NonNull
    private androidx.recyclerview.widget.OrientationHelper d(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        if (this.e == null || this.f != layoutManager) {
            this.f = layoutManager;
            this.e = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.e;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        if (this.h == recyclerView) {
            return;
        }
        this.h = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @androidx.annotation.NonNull
    public int[] calculateDistanceToFinalSnap(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, @androidx.annotation.NonNull android.view.View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, c(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public androidx.recyclerview.widget.LinearSmoothScroller createSnapScroller(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        androidx.recyclerview.widget.RecyclerView recyclerView;
        if (!(layoutManager instanceof androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.h) == null) {
            return null;
        }
        return new com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.AnonymousClass1(recyclerView.getContext());
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @androidx.annotation.Nullable
    public android.view.View findSnapView(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, c(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, d(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, int i, int i2) {
        androidx.recyclerview.widget.OrientationHelper b2;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || (b2 = b(layoutManager)) == null) {
            return -1;
        }
        int childCount = layoutManager.getChildCount();
        android.view.View view = null;
        android.view.View view2 = null;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < childCount; i5++) {
            android.view.View childAt = layoutManager.getChildAt(i5);
            if (childAt != null) {
                int a2 = a(layoutManager, childAt, b2);
                if (a2 <= 0 && a2 > i3) {
                    view2 = childAt;
                    i3 = a2;
                }
                if (a2 >= 0 && a2 < i4) {
                    view = childAt;
                    i4 = a2;
                }
            }
        }
        boolean a3 = a(layoutManager, i, i2);
        if (a3 && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!a3 && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (a3) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view) + (a(layoutManager) == a3 ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }
}
