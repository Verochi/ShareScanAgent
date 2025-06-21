package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public abstract class SnapHelper extends androidx.recyclerview.widget.RecyclerView.OnFlingListener {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private android.widget.Scroller mGravityScroller;
    androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private final androidx.recyclerview.widget.RecyclerView.OnScrollListener mScrollListener = new androidx.recyclerview.widget.SnapHelper.AnonymousClass1();

    /* renamed from: androidx.recyclerview.widget.SnapHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
        boolean mScrolled = false;

        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.mScrolled) {
                this.mScrolled = false;
                androidx.recyclerview.widget.SnapHelper.this.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.mScrolled = true;
        }
    }

    /* renamed from: androidx.recyclerview.widget.SnapHelper$2, reason: invalid class name */
    public class AnonymousClass2 extends androidx.recyclerview.widget.LinearSmoothScroller {
        public AnonymousClass2(android.content.Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(android.util.DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(android.view.View view, androidx.recyclerview.widget.RecyclerView.State state, androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action action) {
            androidx.recyclerview.widget.SnapHelper snapHelper = androidx.recyclerview.widget.SnapHelper.this;
            androidx.recyclerview.widget.RecyclerView recyclerView = snapHelper.mRecyclerView;
            if (recyclerView == null) {
                return;
            }
            int[] calculateDistanceToFinalSnap = snapHelper.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
            int i = calculateDistanceToFinalSnap[0];
            int i2 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(java.lang.Math.max(java.lang.Math.abs(i), java.lang.Math.abs(i2)));
            if (calculateTimeForDeceleration > 0) {
                action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() throws java.lang.IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() != null) {
            throw new java.lang.IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
    }

    private boolean snapFromFling(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, int i, int i2) {
        androidx.recyclerview.widget.RecyclerView.SmoothScroller createScroller;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) || (createScroller = createScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2)) == -1) {
            return false;
        }
        createScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createScroller);
        return true;
    }

    public void attachToRecyclerView(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView recyclerView) throws java.lang.IllegalStateException {
        androidx.recyclerview.widget.RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            this.mGravityScroller = new android.widget.Scroller(this.mRecyclerView.getContext(), new android.view.animation.DecelerateInterpolator());
            snapToTargetExistingView();
        }
    }

    @androidx.annotation.Nullable
    public abstract int[] calculateDistanceToFinalSnap(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, @androidx.annotation.NonNull android.view.View view);

    public int[] calculateScrollDistance(int i, int i2) {
        this.mGravityScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    @androidx.annotation.Nullable
    public androidx.recyclerview.widget.RecyclerView.SmoothScroller createScroller(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        return createSnapScroller(layoutManager);
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public androidx.recyclerview.widget.LinearSmoothScroller createSnapScroller(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new androidx.recyclerview.widget.SnapHelper.AnonymousClass2(this.mRecyclerView.getContext());
        }
        return null;
    }

    @androidx.annotation.Nullable
    public abstract android.view.View findSnapView(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager);

    public abstract int findTargetSnapPosition(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, int i, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i, int i2) {
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        return (java.lang.Math.abs(i2) > minFlingVelocity || java.lang.Math.abs(i) > minFlingVelocity) && snapFromFling(layoutManager, i, i2);
    }

    public void snapToTargetExistingView() {
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
        android.view.View findSnapView;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (findSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
        int i = calculateDistanceToFinalSnap[0];
        if (i == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(i, calculateDistanceToFinalSnap[1]);
    }
}
