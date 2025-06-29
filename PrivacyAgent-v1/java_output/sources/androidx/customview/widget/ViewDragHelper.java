package androidx.customview.widget;

/* loaded from: classes.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final java.lang.String TAG = "ViewDragHelper";
    private static final android.view.animation.Interpolator sInterpolator = new androidx.customview.widget.ViewDragHelper.AnonymousClass1();
    private final androidx.customview.widget.ViewDragHelper.Callback mCallback;
    private android.view.View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final android.view.ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private android.widget.OverScroller mScroller;
    private int mTouchSlop;
    private int mTrackingEdges;
    private android.view.VelocityTracker mVelocityTracker;
    private int mActivePointerId = -1;
    private final java.lang.Runnable mSetIdleRunnable = new androidx.customview.widget.ViewDragHelper.AnonymousClass2();

    /* renamed from: androidx.customview.widget.ViewDragHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.view.animation.Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.customview.widget.ViewDragHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.customview.widget.ViewDragHelper.this.setDragState(0);
        }
    }

    public static abstract class Callback {
        public int clampViewPositionHorizontal(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(@androidx.annotation.NonNull android.view.View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@androidx.annotation.NonNull android.view.View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(@androidx.annotation.NonNull android.view.View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(@androidx.annotation.NonNull android.view.View view, int i, int i2, @androidx.annotation.Px int i3, @androidx.annotation.Px int i4) {
        }

        public void onViewReleased(@androidx.annotation.NonNull android.view.View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(@androidx.annotation.NonNull android.view.View view, int i);
    }

    private ViewDragHelper(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull androidx.customview.widget.ViewDragHelper.Callback callback) {
        if (viewGroup == null) {
            throw new java.lang.IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new java.lang.IllegalArgumentException("Callback may not be null");
        }
        this.mParentView = viewGroup;
        this.mCallback = callback;
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.mEdgeSize = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mScroller = new android.widget.OverScroller(context, sInterpolator);
    }

    private boolean checkNewEdgeDrag(float f, float f2, int i, int i2) {
        float abs = java.lang.Math.abs(f);
        float abs2 = java.lang.Math.abs(f2);
        if ((this.mInitialEdgesTouched[i] & i2) != i2 || (this.mTrackingEdges & i2) == 0 || (this.mEdgeDragsLocked[i] & i2) == i2 || (this.mEdgeDragsInProgress[i] & i2) == i2) {
            return false;
        }
        int i3 = this.mTouchSlop;
        if (abs <= i3 && abs2 <= i3) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.mCallback.onEdgeLock(i2)) {
            return (this.mEdgeDragsInProgress[i] & i2) == 0 && abs > ((float) this.mTouchSlop);
        }
        int[] iArr = this.mEdgeDragsLocked;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    private boolean checkTouchSlop(android.view.View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? java.lang.Math.abs(f) > ((float) this.mTouchSlop) : z2 && java.lang.Math.abs(f2) > ((float) this.mTouchSlop);
        }
        float f3 = (f * f) + (f2 * f2);
        int i = this.mTouchSlop;
        return f3 > ((float) (i * i));
    }

    private float clampMag(float f, float f2, float f3) {
        float abs = java.lang.Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    private int clampMag(int i, int i2, int i3) {
        int abs = java.lang.Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        java.util.Arrays.fill(fArr, 0.0f);
        java.util.Arrays.fill(this.mInitialMotionY, 0.0f);
        java.util.Arrays.fill(this.mLastMotionX, 0.0f);
        java.util.Arrays.fill(this.mLastMotionY, 0.0f);
        java.util.Arrays.fill(this.mInitialEdgesTouched, 0);
        java.util.Arrays.fill(this.mEdgeDragsInProgress, 0);
        java.util.Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private void clearMotionHistory(int i) {
        if (this.mInitialMotionX == null || !isPointerDown(i)) {
            return;
        }
        this.mInitialMotionX[i] = 0.0f;
        this.mInitialMotionY[i] = 0.0f;
        this.mLastMotionX[i] = 0.0f;
        this.mLastMotionY[i] = 0.0f;
        this.mInitialEdgesTouched[i] = 0;
        this.mEdgeDragsInProgress[i] = 0;
        this.mEdgeDragsLocked[i] = 0;
        this.mPointersDown = (~(1 << i)) & this.mPointersDown;
    }

    private int computeAxisDuration(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f = width / 2;
        float distanceInfluenceForSnapDuration = f + (distanceInfluenceForSnapDuration(java.lang.Math.min(1.0f, java.lang.Math.abs(i) / width)) * f);
        int abs = java.lang.Math.abs(i2);
        return java.lang.Math.min(abs > 0 ? java.lang.Math.round(java.lang.Math.abs(distanceInfluenceForSnapDuration / abs) * 1000.0f) * 4 : (int) (((java.lang.Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    private int computeSettleDuration(android.view.View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int clampMag = clampMag(i3, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i4, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = java.lang.Math.abs(i);
        int abs2 = java.lang.Math.abs(i2);
        int abs3 = java.lang.Math.abs(clampMag);
        int abs4 = java.lang.Math.abs(clampMag2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (clampMag != 0) {
            f = abs3;
            f2 = i5;
        } else {
            f = abs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (clampMag2 != 0) {
            f3 = abs4;
            f4 = i5;
        } else {
            f3 = abs2;
            f4 = i6;
        }
        return (int) ((computeAxisDuration(i, clampMag, this.mCallback.getViewHorizontalDragRange(view)) * f5) + (computeAxisDuration(i2, clampMag2, this.mCallback.getViewVerticalDragRange(view)) * (f3 / f4)));
    }

    public static androidx.customview.widget.ViewDragHelper create(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, float f, @androidx.annotation.NonNull androidx.customview.widget.ViewDragHelper.Callback callback) {
        androidx.customview.widget.ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) (create.mTouchSlop * (1.0f / f));
        return create;
    }

    public static androidx.customview.widget.ViewDragHelper create(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull androidx.customview.widget.ViewDragHelper.Callback callback) {
        return new androidx.customview.widget.ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f, float f2) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f, f2);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f) {
        return (float) java.lang.Math.sin((f - 0.5f) * 0.47123894f);
    }

    private void dragTo(int i, int i2, int i3, int i4) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i3 != 0) {
            i = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i, i3);
            androidx.core.view.ViewCompat.offsetLeftAndRight(this.mCapturedView, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i2, i4);
            androidx.core.view.ViewCompat.offsetTopAndBottom(this.mCapturedView, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.mCallback.onViewPositionChanged(this.mCapturedView, i5, i6, i5 - left, i6 - top);
    }

    private void ensureMotionHistorySizeForId(int i) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                java.lang.System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                java.lang.System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                java.lang.System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                java.lang.System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                java.lang.System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                java.lang.System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i, int i2, int i3, int i4) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i5, i6, computeSettleDuration(this.mCapturedView, i5, i6, i3, i4));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i, int i2) {
        int i3 = i < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if (i2 < this.mParentView.getTop() + this.mEdgeSize) {
            i3 |= 4;
        }
        if (i > this.mParentView.getRight() - this.mEdgeSize) {
            i3 |= 2;
        }
        return i2 > this.mParentView.getBottom() - this.mEdgeSize ? i3 | 8 : i3;
    }

    private boolean isValidPointerForActionMove(int i) {
        if (isPointerDown(i)) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Ignoring pointerId=");
        sb.append(i);
        sb.append(" because ACTION_DOWN was not received ");
        sb.append("for this pointer before ACTION_MOVE. It likely happened because ");
        sb.append(" ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    private void reportNewEdgeDrags(float f, float f2, int i) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f, f2, i, 1);
        boolean z = checkNewEdgeDrag;
        if (checkNewEdgeDrag(f2, f, i, 4)) {
            z = (checkNewEdgeDrag ? 1 : 0) | 4;
        }
        boolean z2 = z;
        if (checkNewEdgeDrag(f, f2, i, 2)) {
            z2 = (z ? 1 : 0) | 2;
        }
        ?? r0 = z2;
        if (checkNewEdgeDrag(f2, f, i, 8)) {
            r0 = (z2 ? 1 : 0) | 8;
        }
        if (r0 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i] = iArr[i] | r0;
            this.mCallback.onEdgeDragStarted(r0, i);
        }
    }

    private void saveInitialMotion(float f, float f2, int i) {
        ensureMotionHistorySizeForId(i);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i] = f2;
        fArr2[i] = f2;
        this.mInitialEdgesTouched[i] = getEdgesTouched((int) f, (int) f2);
        this.mPointersDown |= 1 << i;
    }

    private void saveLastMotion(android.view.MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (isValidPointerForActionMove(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.mLastMotionX[pointerId] = x;
                this.mLastMotionY[pointerId] = y;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    public boolean canScroll(@androidx.annotation.NonNull android.view.View view, boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                android.view.View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && (view.canScrollHorizontally(-i) || view.canScrollVertically(-i2));
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@androidx.annotation.NonNull android.view.View view, int i) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i;
            this.mCallback.onViewCaptured(view, i);
            setDragState(1);
            return;
        }
        throw new java.lang.IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean checkTouchSlop(int i) {
        int length = this.mInitialMotionX.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.mLastMotionX[i2] - this.mInitialMotionX[i2];
        float f2 = this.mLastMotionY[i2] - this.mInitialMotionY[i2];
        if (!z || !z2) {
            return z ? java.lang.Math.abs(f) > ((float) this.mTouchSlop) : z2 && java.lang.Math.abs(f2) > ((float) this.mTouchSlop);
        }
        float f3 = (f * f) + (f2 * f2);
        int i3 = this.mTouchSlop;
        return f3 > ((float) (i3 * i3));
    }

    public boolean continueSettling(boolean z) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                androidx.core.view.ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                androidx.core.view.ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    @androidx.annotation.Nullable
    public android.view.View findTopChildUnder(int i, int i2) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (!this.mReleaseInProgress) {
            throw new java.lang.IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i, i3, i2, i4);
        setDragState(2);
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @androidx.annotation.Nullable
    public android.view.View getCapturedView() {
        return this.mCapturedView;
    }

    @androidx.annotation.Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @androidx.annotation.Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.mCapturedView, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.mInitialEdgesTouched.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (i & this.mInitialEdgesTouched[i2]) != 0;
    }

    public boolean isPointerDown(int i) {
        return ((1 << i) & this.mPointersDown) != 0;
    }

    public boolean isViewUnder(@androidx.annotation.Nullable android.view.View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void processTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            android.view.View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            saveInitialMotion(x, y, pointerId);
            tryCaptureViewForDrag(findTopChildUnder, pointerId);
            int i3 = this.mInitialEdgesTouched[pointerId];
            int i4 = this.mTrackingEdges;
            if ((i3 & i4) != 0) {
                this.mCallback.onEdgeTouched(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
            return;
        }
        if (actionMasked == 2) {
            if (this.mDragState == 1) {
                if (isValidPointerForActionMove(this.mActivePointerId)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.mLastMotionX;
                    int i5 = this.mActivePointerId;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.mLastMotionY[i5]);
                    dragTo(this.mCapturedView.getLeft() + i6, this.mCapturedView.getTop() + i7, i6, i7);
                    saveLastMotion(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (isValidPointerForActionMove(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.mInitialMotionX[pointerId2];
                    float f2 = y3 - this.mInitialMotionY[pointerId2];
                    reportNewEdgeDrags(f, f2, pointerId2);
                    if (this.mDragState != 1) {
                        android.view.View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                        if (checkTouchSlop(findTopChildUnder2, f, f2) && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            saveLastMotion(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.mDragState == 1) {
                dispatchViewReleased(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            saveInitialMotion(x4, y4, pointerId3);
            if (this.mDragState != 0) {
                if (isCapturedViewUnder((int) x4, (int) y4)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                    return;
                }
                return;
            } else {
                tryCaptureViewForDrag(findTopChildUnder((int) x4, (int) y4), pointerId3);
                int i8 = this.mInitialEdgesTouched[pointerId3];
                int i9 = this.mTrackingEdges;
                if ((i8 & i9) != 0) {
                    this.mCallback.onEdgeTouched(i8 & i9, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.mDragState == 1 && pointerId4 == this.mActivePointerId) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i2);
                if (pointerId5 != this.mActivePointerId) {
                    android.view.View findTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                    android.view.View view = this.mCapturedView;
                    if (findTopChildUnder3 == view && tryCaptureViewForDrag(view, pointerId5)) {
                        i = this.mActivePointerId;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                releaseViewForPointerUp();
            }
        }
        clearMotionHistory(pointerId4);
    }

    public void setDragState(int i) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i) {
            this.mDragState = i;
            this.mCallback.onViewDragStateChanged(i);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        this.mTrackingEdges = i;
    }

    public void setMinVelocity(float f) {
        this.mMinVelocity = f;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i, i2, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new java.lang.IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        boolean z;
        android.view.View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x = motionEvent.getX(actionIndex);
                            float y = motionEvent.getY(actionIndex);
                            saveInitialMotion(x, y, pointerId);
                            int i = this.mDragState;
                            if (i == 0) {
                                int i2 = this.mInitialEdgesTouched[pointerId];
                                int i3 = this.mTrackingEdges;
                                if ((i2 & i3) != 0) {
                                    this.mCallback.onEdgeTouched(i2 & i3, pointerId);
                                }
                            } else if (i == 2 && (findTopChildUnder = findTopChildUnder((int) x, (int) y)) == this.mCapturedView) {
                                tryCaptureViewForDrag(findTopChildUnder, pointerId);
                            }
                        } else if (actionMasked == 6) {
                            clearMotionHistory(motionEvent.getPointerId(actionIndex));
                        }
                    }
                } else if (this.mInitialMotionX != null && this.mInitialMotionY != null) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i4 = 0; i4 < pointerCount; i4++) {
                        int pointerId2 = motionEvent.getPointerId(i4);
                        if (isValidPointerForActionMove(pointerId2)) {
                            float x2 = motionEvent.getX(i4);
                            float y2 = motionEvent.getY(i4);
                            float f = x2 - this.mInitialMotionX[pointerId2];
                            float f2 = y2 - this.mInitialMotionY[pointerId2];
                            android.view.View findTopChildUnder2 = findTopChildUnder((int) x2, (int) y2);
                            boolean z2 = findTopChildUnder2 != null && checkTouchSlop(findTopChildUnder2, f, f2);
                            if (z2) {
                                int left = findTopChildUnder2.getLeft();
                                int i5 = (int) f;
                                int clampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(findTopChildUnder2, left + i5, i5);
                                int top = findTopChildUnder2.getTop();
                                int i6 = (int) f2;
                                int clampViewPositionVertical = this.mCallback.clampViewPositionVertical(findTopChildUnder2, top + i6, i6);
                                int viewHorizontalDragRange = this.mCallback.getViewHorizontalDragRange(findTopChildUnder2);
                                int viewVerticalDragRange = this.mCallback.getViewVerticalDragRange(findTopChildUnder2);
                                if (viewHorizontalDragRange != 0) {
                                    if (viewHorizontalDragRange > 0) {
                                    }
                                }
                                if (viewVerticalDragRange == 0) {
                                    break;
                                }
                                if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                    break;
                                }
                            }
                            reportNewEdgeDrags(f, f2, pointerId2);
                            if (this.mDragState == 1) {
                                break;
                            }
                            if (z2 && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                                break;
                            }
                        }
                    }
                    saveLastMotion(motionEvent);
                }
                z = false;
            }
            cancel();
            z = false;
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            z = false;
            int pointerId3 = motionEvent.getPointerId(0);
            saveInitialMotion(x3, y3, pointerId3);
            android.view.View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
            if (findTopChildUnder3 == this.mCapturedView && this.mDragState == 2) {
                tryCaptureViewForDrag(findTopChildUnder3, pointerId3);
            }
            int i7 = this.mInitialEdgesTouched[pointerId3];
            int i8 = this.mTrackingEdges;
            if ((i7 & i8) != 0) {
                this.mCallback.onEdgeTouched(i7 & i8, pointerId3);
            }
        }
        if (this.mDragState == 1) {
            return true;
        }
        return z;
    }

    public boolean smoothSlideViewTo(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i, i2, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    public boolean tryCaptureViewForDrag(android.view.View view, int i) {
        if (view == this.mCapturedView && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i)) {
            return false;
        }
        this.mActivePointerId = i;
        captureChildView(view, i);
        return true;
    }
}
