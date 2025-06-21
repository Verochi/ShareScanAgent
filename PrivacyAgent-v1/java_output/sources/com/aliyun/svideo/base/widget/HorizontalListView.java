package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class HorizontalListView extends android.widget.AdapterView<android.widget.ListAdapter> {
    protected android.widget.ListAdapter adapter;
    public boolean mAlwaysOverrideTouch;
    private com.aliyun.svideo.base.widget.HorizontalListView.OnScrollCallBack mCallback;
    protected int mCurrentX;
    private boolean mDataChanged;
    private android.database.DataSetObserver mDataObserver;
    private int mDisplayOffset;
    private com.aliyun.svideo.base.widget.HorizontalListView.OnDownCallBack mDownCallBack;
    private android.view.GestureDetector mGesture;
    private int mLeftViewIndex;
    private int mMaxX;
    protected int mNextX;
    private android.view.GestureDetector.OnGestureListener mOnGesture;
    private android.widget.AdapterView.OnItemClickListener mOnItemClicked;
    private android.widget.AdapterView.OnItemLongClickListener mOnItemLongClicked;
    private android.widget.AdapterView.OnItemSelectedListener mOnItemSelected;
    private java.util.Queue<android.view.View> mRemovedViewQueue;
    private int mRightDataIndex;
    private int mRightViewIndex;
    protected android.widget.Scroller mScroller;

    /* renamed from: com.aliyun.svideo.base.widget.HorizontalListView$1, reason: invalid class name */
    public class AnonymousClass1 extends android.database.DataSetObserver {
        public AnonymousClass1() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            synchronized (com.aliyun.svideo.base.widget.HorizontalListView.this) {
                com.aliyun.svideo.base.widget.HorizontalListView.this.mDataChanged = true;
            }
            com.aliyun.svideo.base.widget.HorizontalListView.this.invalidate();
            com.aliyun.svideo.base.widget.HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            com.aliyun.svideo.base.widget.HorizontalListView.this.reset();
            com.aliyun.svideo.base.widget.HorizontalListView.this.invalidate();
            com.aliyun.svideo.base.widget.HorizontalListView.this.requestLayout();
        }
    }

    /* renamed from: com.aliyun.svideo.base.widget.HorizontalListView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.base.widget.HorizontalListView.this.requestLayout();
        }
    }

    /* renamed from: com.aliyun.svideo.base.widget.HorizontalListView$3, reason: invalid class name */
    public class AnonymousClass3 extends android.view.GestureDetector.SimpleOnGestureListener {
        public AnonymousClass3() {
        }

        private boolean isEventWithinView(android.view.MotionEvent motionEvent, android.view.View view) {
            android.graphics.Rect rect = new android.graphics.Rect();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int width = view.getWidth() + i;
            int i2 = iArr[1];
            rect.set(i, i2, width, view.getHeight() + i2);
            return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(android.view.MotionEvent motionEvent) {
            if (com.aliyun.svideo.base.widget.HorizontalListView.this.mDownCallBack != null) {
                com.aliyun.svideo.base.widget.HorizontalListView.this.mDownCallBack.onIsDown(true);
            }
            return com.aliyun.svideo.base.widget.HorizontalListView.this.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            return com.aliyun.svideo.base.widget.HorizontalListView.this.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) {
            int childCount = com.aliyun.svideo.base.widget.HorizontalListView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = com.aliyun.svideo.base.widget.HorizontalListView.this.getChildAt(i);
                if (isEventWithinView(motionEvent, childAt)) {
                    if (com.aliyun.svideo.base.widget.HorizontalListView.this.mOnItemLongClicked != null) {
                        android.widget.AdapterView.OnItemLongClickListener onItemLongClickListener = com.aliyun.svideo.base.widget.HorizontalListView.this.mOnItemLongClicked;
                        com.aliyun.svideo.base.widget.HorizontalListView horizontalListView = com.aliyun.svideo.base.widget.HorizontalListView.this;
                        int i2 = horizontalListView.mLeftViewIndex + 1 + i;
                        com.aliyun.svideo.base.widget.HorizontalListView horizontalListView2 = com.aliyun.svideo.base.widget.HorizontalListView.this;
                        onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i2, horizontalListView2.adapter.getItemId(horizontalListView2.mLeftViewIndex + 1 + i));
                        return;
                    }
                    return;
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            com.aliyun.svideo.base.widget.HorizontalListView horizontalListView;
            synchronized (com.aliyun.svideo.base.widget.HorizontalListView.this) {
                horizontalListView = com.aliyun.svideo.base.widget.HorizontalListView.this;
                horizontalListView.mNextX += (int) f;
            }
            horizontalListView.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
            int i = 0;
            while (true) {
                if (i >= com.aliyun.svideo.base.widget.HorizontalListView.this.getChildCount()) {
                    break;
                }
                android.view.View childAt = com.aliyun.svideo.base.widget.HorizontalListView.this.getChildAt(i);
                if (isEventWithinView(motionEvent, childAt)) {
                    if (com.aliyun.svideo.base.widget.HorizontalListView.this.mOnItemClicked != null) {
                        android.widget.AdapterView.OnItemClickListener onItemClickListener = com.aliyun.svideo.base.widget.HorizontalListView.this.mOnItemClicked;
                        com.aliyun.svideo.base.widget.HorizontalListView horizontalListView = com.aliyun.svideo.base.widget.HorizontalListView.this;
                        int i2 = horizontalListView.mLeftViewIndex + 1 + i;
                        com.aliyun.svideo.base.widget.HorizontalListView horizontalListView2 = com.aliyun.svideo.base.widget.HorizontalListView.this;
                        onItemClickListener.onItemClick(horizontalListView, childAt, i2, horizontalListView2.adapter.getItemId(horizontalListView2.mLeftViewIndex + 1 + i));
                    }
                    if (com.aliyun.svideo.base.widget.HorizontalListView.this.mOnItemSelected != null) {
                        android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener = com.aliyun.svideo.base.widget.HorizontalListView.this.mOnItemSelected;
                        com.aliyun.svideo.base.widget.HorizontalListView horizontalListView3 = com.aliyun.svideo.base.widget.HorizontalListView.this;
                        int i3 = horizontalListView3.mLeftViewIndex + 1 + i;
                        com.aliyun.svideo.base.widget.HorizontalListView horizontalListView4 = com.aliyun.svideo.base.widget.HorizontalListView.this;
                        onItemSelectedListener.onItemSelected(horizontalListView3, childAt, i3, horizontalListView4.adapter.getItemId(horizontalListView4.mLeftViewIndex + 1 + i));
                    }
                } else {
                    i++;
                }
            }
            return true;
        }
    }

    public interface OnDownCallBack {
        void onIsDown(boolean z);
    }

    public interface OnScrollCallBack {
        void onScrollDistance(java.lang.Long l, int i);
    }

    public HorizontalListView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAlwaysOverrideTouch = true;
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mRightDataIndex = -1;
        this.mMaxX = Integer.MAX_VALUE;
        this.mDisplayOffset = 0;
        this.mRemovedViewQueue = new java.util.LinkedList();
        this.mDataChanged = false;
        this.mDataObserver = new com.aliyun.svideo.base.widget.HorizontalListView.AnonymousClass1();
        this.mOnGesture = new com.aliyun.svideo.base.widget.HorizontalListView.AnonymousClass3();
        initView();
    }

    private void addAndMeasureChild(android.view.View view, int i) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        int i2 = layoutParams.width;
        int makeMeasureSpec = i2 >= 0 ? android.view.View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE);
        int i3 = layoutParams.height;
        view.measure(makeMeasureSpec, i3 >= 0 ? android.view.View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    private void fillList(int i) {
        android.view.View childAt = getChildAt(getChildCount() - 1);
        fillListRight(childAt != null ? childAt.getRight() : 0, i);
        android.view.View childAt2 = getChildAt(0);
        fillListLeft(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void fillListLeft(int i, int i2) {
        int i3;
        while (i + i2 > 0 && (i3 = this.mLeftViewIndex) >= 0) {
            android.view.View view = this.adapter.getView(i3, this.mRemovedViewQueue.poll(), this);
            addAndMeasureChild(view, 0);
            i -= view.getMeasuredWidth();
            this.mLeftViewIndex--;
            this.mDisplayOffset -= view.getMeasuredWidth();
        }
    }

    private void fillListRight(int i, int i2) {
        while (i + i2 < getWidth() && this.mRightViewIndex < this.adapter.getCount()) {
            android.view.View view = this.adapter.getView(this.mRightViewIndex, this.mRemovedViewQueue.poll(), this);
            addAndMeasureChild(view, -1);
            i += view.getMeasuredWidth();
            if (this.mRightViewIndex == this.adapter.getCount() - 1) {
                this.mMaxX = (this.mCurrentX + i) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.mRightViewIndex++;
        }
    }

    private synchronized void initView() {
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mDisplayOffset = 0;
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new android.widget.Scroller(getContext());
        this.mGesture = new android.view.GestureDetector(getContext(), this.mOnGesture);
    }

    private void positionItems(int i) {
        if (getChildCount() > 0) {
            int i2 = this.mDisplayOffset + i;
            this.mDisplayOffset = i2;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                android.view.View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += measuredWidth + childAt.getPaddingRight();
            }
        }
    }

    private void removeNonVisibleItems(int i) {
        android.view.View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.mDisplayOffset += childAt.getMeasuredWidth();
            this.mRemovedViewQueue.offer(childAt);
            removeViewInLayout(childAt);
            this.mLeftViewIndex++;
            childAt = getChildAt(0);
        }
        android.view.View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.mRemovedViewQueue.offer(childAt2);
            removeViewInLayout(childAt2);
            this.mRightViewIndex--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mGesture.onTouchEvent(motionEvent) | super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView
    public android.widget.ListAdapter getAdapter() {
        return this.adapter;
    }

    public int getItemContentHight() {
        if (getChildAt(0) == null) {
            return 0;
        }
        return getChildAt(0).getHeight();
    }

    @Override // android.widget.AdapterView
    public android.view.View getSelectedView() {
        return null;
    }

    public boolean onDown(android.view.MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }

    public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.mNextX, 0, (int) (-f), 0, 0, this.mMaxX, 0, 0);
        }
        requestLayout();
        return true;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        super.onLayout(z, i, i2, i3, i4);
        if (this.adapter == null) {
            return;
        }
        if (this.mDataChanged) {
            int i5 = this.mCurrentX;
            initView();
            removeAllViewsInLayout();
            this.mNextX = i5;
            this.mDataChanged = false;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.mScroller.computeScrollOffset()) {
            this.mNextX = this.mScroller.getCurrX();
        }
        if (this.mNextX <= 0) {
            this.mNextX = 0;
            this.mScroller.forceFinished(true);
        }
        int i6 = this.mNextX;
        int i7 = this.mMaxX;
        if (i6 >= i7) {
            this.mNextX = i7;
            this.mScroller.forceFinished(true);
        }
        int i8 = this.mCurrentX - this.mNextX;
        removeNonVisibleItems(i8);
        fillList(i8);
        if (!z2 && this.mCallback != null) {
            this.mCallback.onScrollDistance(java.lang.Long.valueOf(this.adapter.getItemId(this.mLeftViewIndex + 1)), this.mCurrentX);
        }
        positionItems(i8);
        this.mCurrentX = this.mNextX;
        if (!this.mScroller.isFinished()) {
            post(new com.aliyun.svideo.base.widget.HorizontalListView.AnonymousClass2());
        }
    }

    public synchronized void scrollTo(int i) {
        android.widget.Scroller scroller = this.mScroller;
        int i2 = this.mNextX;
        scroller.startScroll(i2, 0, i - i2, 0);
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(android.widget.ListAdapter listAdapter) {
        android.widget.ListAdapter listAdapter2 = this.adapter;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.mDataObserver);
        }
        this.adapter = listAdapter;
        listAdapter.registerDataSetObserver(this.mDataObserver);
        reset();
    }

    public void setOnDownCallBack(com.aliyun.svideo.base.widget.HorizontalListView.OnDownCallBack onDownCallBack) {
        this.mDownCallBack = onDownCallBack;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClicked = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClicked = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelected = onItemSelectedListener;
    }

    public void setOnScrollCallBack(com.aliyun.svideo.base.widget.HorizontalListView.OnScrollCallBack onScrollCallBack) {
        this.mCallback = onScrollCallBack;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }
}
