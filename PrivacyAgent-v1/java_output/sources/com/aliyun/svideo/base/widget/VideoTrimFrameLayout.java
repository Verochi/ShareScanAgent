package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class VideoTrimFrameLayout extends android.widget.FrameLayout implements com.aliyun.svideo.base.widget.SizeChangedNotifier {
    private com.aliyun.svideo.base.widget.VideoTrimFrameLayout.OnVideoScrollCallBack VideoCallback;
    private com.aliyun.svideo.base.widget.SizeChangedNotifier.Listener _OnSizeChangedListener;
    private android.view.GestureDetector mGesture;
    private int mMaxX;
    protected int mNextX;
    protected int mNextY;
    private android.view.GestureDetector.OnGestureListener mOnGesture;
    protected android.widget.Scroller mScroller;

    /* renamed from: com.aliyun.svideo.base.widget.VideoTrimFrameLayout$1, reason: invalid class name */
    public class AnonymousClass1 extends android.view.GestureDetector.SimpleOnGestureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(android.view.MotionEvent motionEvent) {
            return com.aliyun.svideo.base.widget.VideoTrimFrameLayout.this.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            return com.aliyun.svideo.base.widget.VideoTrimFrameLayout.this.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            com.aliyun.svideo.base.widget.VideoTrimFrameLayout videoTrimFrameLayout;
            synchronized (com.aliyun.svideo.base.widget.VideoTrimFrameLayout.this) {
                videoTrimFrameLayout = com.aliyun.svideo.base.widget.VideoTrimFrameLayout.this;
                videoTrimFrameLayout.mNextX += (int) f;
                videoTrimFrameLayout.mNextY += (int) f2;
            }
            videoTrimFrameLayout.VideoCallback.onVideoScroll(f, f2);
            com.aliyun.svideo.base.widget.VideoTrimFrameLayout.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
            if (com.aliyun.svideo.base.widget.VideoTrimFrameLayout.this.VideoCallback == null) {
                return false;
            }
            com.aliyun.svideo.base.widget.VideoTrimFrameLayout.this.VideoCallback.onVideoSingleTapUp();
            return false;
        }
    }

    public interface OnVideoScrollCallBack {
        void onVideoScroll(float f, float f2);

        void onVideoSingleTapUp();
    }

    public VideoTrimFrameLayout(android.content.Context context) {
        super(context);
        this.mMaxX = Integer.MAX_VALUE;
        this.mOnGesture = new com.aliyun.svideo.base.widget.VideoTrimFrameLayout.AnonymousClass1();
        init();
    }

    public VideoTrimFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxX = Integer.MAX_VALUE;
        this.mOnGesture = new com.aliyun.svideo.base.widget.VideoTrimFrameLayout.AnonymousClass1();
        init();
    }

    public VideoTrimFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxX = Integer.MAX_VALUE;
        this.mOnGesture = new com.aliyun.svideo.base.widget.VideoTrimFrameLayout.AnonymousClass1();
        init();
    }

    private void init() {
        this.mNextX = 0;
        this.mNextY = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new android.widget.Scroller(getContext());
        this.mGesture = new android.view.GestureDetector(getContext(), this.mOnGesture);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mGesture.onTouchEvent(motionEvent) | super.dispatchTouchEvent(motionEvent);
    }

    public boolean onDown(android.view.MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }

    public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            int i = this.mMaxX;
            this.mScroller.fling(this.mNextX, this.mNextY, (int) (-f), (int) (-f2), 0, i, 0, i);
        }
        requestLayout();
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.aliyun.svideo.base.widget.SizeChangedNotifier.Listener listener = this._OnSizeChangedListener;
        if (listener != null) {
            listener.onSizeChanged(this, i, i2, i3, i4);
        }
    }

    public void setOnScrollCallBack(com.aliyun.svideo.base.widget.VideoTrimFrameLayout.OnVideoScrollCallBack onVideoScrollCallBack) {
        this.VideoCallback = onVideoScrollCallBack;
    }

    @Override // com.aliyun.svideo.base.widget.SizeChangedNotifier
    public void setOnSizeChangedListener(com.aliyun.svideo.base.widget.SizeChangedNotifier.Listener listener) {
        this._OnSizeChangedListener = listener;
    }
}
