package com.aliyun.svideo.music.widget;

/* loaded from: classes12.dex */
public class MusicHorizontalScrollView extends android.widget.HorizontalScrollView {
    private com.aliyun.svideo.music.widget.MusicHorizontalScrollView.ScrollViewListener scrollViewListener;

    public interface ScrollViewListener {
        void onScrollChanged(android.widget.HorizontalScrollView horizontalScrollView, int i, int i2, int i3, int i4);

        void onScrollStop();
    }

    public MusicHorizontalScrollView(android.content.Context context) {
        super(context);
        this.scrollViewListener = null;
    }

    public MusicHorizontalScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollViewListener = null;
    }

    public MusicHorizontalScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scrollViewListener = null;
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i) {
        super.fling(0);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        com.aliyun.svideo.music.widget.MusicHorizontalScrollView.ScrollViewListener scrollViewListener = this.scrollViewListener;
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.aliyun.svideo.music.widget.MusicHorizontalScrollView.ScrollViewListener scrollViewListener;
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && (scrollViewListener = this.scrollViewListener) != null) {
            scrollViewListener.onScrollStop();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollViewListener(com.aliyun.svideo.music.widget.MusicHorizontalScrollView.ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }
}
