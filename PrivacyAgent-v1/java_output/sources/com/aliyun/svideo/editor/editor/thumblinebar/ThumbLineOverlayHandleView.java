package com.aliyun.svideo.editor.editor.thumblinebar;

/* loaded from: classes12.dex */
public class ThumbLineOverlayHandleView implements android.view.View.OnTouchListener {
    private long mDuration;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener mPositionChangeListener;
    private float mStartX;
    private android.view.View mView;

    public interface OnPositionChangeListener {
        void onChangeComplete();

        void onPositionChanged(float f);
    }

    public ThumbLineOverlayHandleView(android.view.View view, long j) {
        this.mView = view;
        if (view != null) {
            view.setOnTouchListener(this);
        }
        this.mDuration = j;
    }

    public void active() {
        android.view.View view = this.mView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void changeDuration(long j) {
        this.mDuration += j;
    }

    public void fix() {
        android.view.View view = this.mView;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public android.view.View getView() {
        return this.mView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int actionMasked = androidx.core.view.MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float rawX = motionEvent.getRawX() - this.mStartX;
                    this.mStartX = motionEvent.getRawX();
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener onPositionChangeListener = this.mPositionChangeListener;
                    if (onPositionChangeListener != null) {
                        onPositionChangeListener.onPositionChanged(rawX);
                    }
                } else if (actionMasked != 3) {
                    this.mStartX = 0.0f;
                }
            }
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener onPositionChangeListener2 = this.mPositionChangeListener;
            if (onPositionChangeListener2 != null) {
                onPositionChangeListener2.onChangeComplete();
            }
            this.mStartX = 0.0f;
        } else {
            this.mStartX = motionEvent.getRawX();
        }
        return true;
    }

    public void setPositionChangeListener(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener onPositionChangeListener) {
        this.mPositionChangeListener = onPositionChangeListener;
    }
}
