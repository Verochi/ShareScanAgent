package com.aliyun.svideo.editor.editor.thumblinebar;

/* loaded from: classes12.dex */
public class ThumbLineOverlay {
    public static final byte STATE_ACTIVE = 1;
    public static final byte STATE_FIX = 2;
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay";
    private android.content.Context mContext;
    private int mDistance;
    public long mDuration;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView mHeadView;
    private boolean mIsInvert;
    private long mMaxDuration;
    private long mMinDuration;
    private android.view.ViewGroup mOverlayContainer;
    private com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar mOverlayThumbLineBar;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView mOverlayView;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.OnSelectedDurationChangeListener mSelectedDurationChange;
    private android.view.View mSelectedMiddleView;
    private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView mTailView;
    private com.aliyun.svideo.editor.effects.control.UIEditorPage mUIEditorPage;
    public long startTime;
    public int middleViewColor = 0;
    private byte mState = 1;

    /* renamed from: com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener
        public void onChangeComplete() {
            if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mState == 1) {
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mOverlayThumbLineBar.seekTo(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mHeadView.getDuration(), true);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0083 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPositionChanged(float f) {
            long j;
            long duration;
            if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mState == 2) {
                return;
            }
            long distance2Duration = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mOverlayThumbLineBar.distance2Duration(f);
            if (distance2Duration >= 0 || (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mHeadView.getDuration() + distance2Duration) - com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getDuration() >= com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mMinDuration) {
                if (distance2Duration > 0 && com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mHeadView.getDuration() + distance2Duration > com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mMaxDuration) {
                    j = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mMaxDuration;
                    duration = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mHeadView.getDuration();
                }
                if (distance2Duration != 0) {
                    return;
                }
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this;
                thumbLineOverlay.mDuration += distance2Duration;
                android.view.ViewGroup.LayoutParams layoutParams = thumbLineOverlay.mSelectedMiddleView.getLayoutParams();
                layoutParams.width = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mOverlayThumbLineBar.duration2Distance(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mDuration);
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mHeadView.changeDuration(distance2Duration);
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mSelectedMiddleView.setLayoutParams(layoutParams);
                if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mSelectedDurationChange != null) {
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mSelectedDurationChange.onDurationChange(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getDuration(), com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mHeadView.getDuration(), com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mDuration);
                    return;
                }
                return;
            }
            j = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mMinDuration + com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getDuration();
            duration = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mHeadView.getDuration();
            distance2Duration = j - duration;
            if (distance2Duration != 0) {
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener
        public void onChangeComplete() {
            if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mState == 1) {
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mOverlayThumbLineBar.seekTo(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getDuration(), true);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView.OnPositionChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPositionChanged(float f) {
            if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mState == 2) {
                return;
            }
            long distance2Duration = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mOverlayThumbLineBar.distance2Duration(f);
            if (distance2Duration > 0) {
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this;
                if (thumbLineOverlay.mDuration - distance2Duration < thumbLineOverlay.mMinDuration) {
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay2 = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this;
                    distance2Duration = thumbLineOverlay2.mDuration - thumbLineOverlay2.mMinDuration;
                    if (distance2Duration != 0) {
                        return;
                    }
                    com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay3 = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this;
                    thumbLineOverlay3.mDuration -= distance2Duration;
                    thumbLineOverlay3.mTailView.changeDuration(distance2Duration);
                    if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getView() != null) {
                        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getView().getLayoutParams();
                        int i = com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mIsInvert ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
                        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.requestLayout();
                        int i2 = (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mIsInvert ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin) - i;
                        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getView().setLayoutParams(marginLayoutParams);
                        android.view.ViewGroup.MarginLayoutParams marginLayoutParams2 = (android.view.ViewGroup.MarginLayoutParams) com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mSelectedMiddleView.getLayoutParams();
                        marginLayoutParams2.width -= i2;
                        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mSelectedMiddleView.setLayoutParams(marginLayoutParams2);
                    }
                    if (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mSelectedDurationChange != null) {
                        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mSelectedDurationChange.onDurationChange(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getDuration(), com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mHeadView.getDuration(), com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mDuration);
                        return;
                    }
                    return;
                }
            }
            if (distance2Duration < 0 && com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getDuration() + distance2Duration < 0) {
                distance2Duration = -com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.this.mTailView.getDuration();
            }
            if (distance2Duration != 0) {
            }
        }
    }

    public interface OnSelectedDurationChangeListener {
        void onDurationChange(long j, long j2, long j3);
    }

    public interface ThumbLineOverlayView {
        android.view.ViewGroup getContainer();

        android.view.View getHeadView();

        android.view.View getMiddleView();

        android.view.View getTailView();
    }

    public ThumbLineOverlay(com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar, long j, long j2, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView thumbLineOverlayView, long j3, long j4, boolean z, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.OnSelectedDurationChangeListener onSelectedDurationChangeListener) {
        this.mDuration = j2;
        this.mOverlayThumbLineBar = overlayThumbLineBar;
        this.mOverlayView = thumbLineOverlayView;
        this.mMaxDuration = j3;
        this.mMinDuration = j4;
        this.mIsInvert = z;
        this.startTime = j;
        this.mSelectedDurationChange = onSelectedDurationChangeListener;
        initView(j);
        invalidate();
    }

    private void initView(long j) {
        this.mSelectedMiddleView = this.mOverlayView.getMiddleView();
        if (!this.mIsInvert) {
            long j2 = this.mDuration;
            long j3 = this.mMinDuration;
            if (j2 < j3) {
                this.mDuration = j3;
            } else {
                long j4 = this.mMaxDuration;
                if (j4 - j <= 100) {
                    j = j4 - 100;
                    this.mDuration = j4 - j;
                } else if (j2 + j > j4) {
                    this.mDuration = j4 - j;
                }
            }
        }
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.OnSelectedDurationChangeListener onSelectedDurationChangeListener = this.mSelectedDurationChange;
        if (onSelectedDurationChangeListener != null) {
            long j5 = this.mDuration;
            onSelectedDurationChangeListener.onDurationChange(j, j + j5, j5);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("add TimelineBar Overlay startTime:");
        sb.append(j);
        sb.append(" ,endTime:");
        sb.append(this.mDuration + j);
        sb.append(" ,duration:");
        sb.append(this.mDuration);
        this.mTailView = new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView(this.mOverlayView.getTailView(), j);
        this.mHeadView = new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView(this.mOverlayView.getHeadView(), this.mDuration + j);
        android.view.ViewGroup container = this.mOverlayView.getContainer();
        this.mOverlayContainer = container;
        container.setTag(this);
        setVisibility(false);
        this.mOverlayThumbLineBar.addOverlayView(this.mOverlayContainer, this.mTailView, this, this.mIsInvert);
        this.mContext = this.mSelectedMiddleView.getContext();
        this.mHeadView.setPositionChangeListener(new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.AnonymousClass1());
        this.mTailView.setPositionChangeListener(new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.AnonymousClass2());
    }

    private void setLeftMargin(android.view.View view, int i) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = i;
            view.requestLayout();
        }
    }

    public android.view.View getOverlayView() {
        return this.mOverlayContainer;
    }

    public com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView getThumbLineOverlayView() {
        return this.mOverlayView;
    }

    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return this.mUIEditorPage;
    }

    public void invalidate() {
        this.mDistance = this.mOverlayThumbLineBar.duration2Distance(this.mDuration);
        android.view.ViewGroup.LayoutParams layoutParams = this.mSelectedMiddleView.getLayoutParams();
        layoutParams.width = this.mDistance;
        this.mSelectedMiddleView.setLayoutParams(layoutParams);
        byte b = this.mState;
        if (b == 1) {
            this.mTailView.active();
            this.mHeadView.active();
            if (this.middleViewColor != 0) {
                this.mSelectedMiddleView.setBackgroundColor(this.mContext.getResources().getColor(this.middleViewColor));
                return;
            } else {
                this.mSelectedMiddleView.setBackgroundColor(this.mContext.getResources().getColor(com.aliyun.svideo.editor.R.color.alivc_edit_timeline_bar_active_overlay));
                return;
            }
        }
        if (b != 2) {
            return;
        }
        this.mTailView.fix();
        this.mHeadView.fix();
        if (this.middleViewColor != 0) {
            this.mSelectedMiddleView.setBackgroundColor(this.mContext.getResources().getColor(this.middleViewColor));
        } else {
            this.mSelectedMiddleView.setBackgroundColor(this.mContext.getResources().getColor(com.aliyun.svideo.editor.R.color.alivc_edit_timeline_bar_active_overlay));
        }
    }

    public void requestLayout() {
        int calculateTailViewPosition;
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.mTailView.getView().getLayoutParams();
        if (this.mIsInvert) {
            calculateTailViewPosition = this.mOverlayThumbLineBar.calculateTailViewInvertPosition(this.mTailView);
            marginLayoutParams.rightMargin = calculateTailViewPosition;
        } else {
            calculateTailViewPosition = this.mOverlayThumbLineBar.calculateTailViewPosition(this.mTailView);
            marginLayoutParams.leftMargin = calculateTailViewPosition;
        }
        this.mTailView.getView().setLayoutParams(marginLayoutParams);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("TailView Margin = ");
        sb.append(calculateTailViewPosition);
        sb.append("timeline over");
        sb.append(this);
    }

    public void setOnSelectedDurationChangeListener(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.OnSelectedDurationChangeListener onSelectedDurationChangeListener) {
        this.mSelectedDurationChange = onSelectedDurationChangeListener;
    }

    public void setUIEditorPage(com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage) {
        this.mUIEditorPage = uIEditorPage;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.mTailView.getView().setAlpha(1.0f);
            this.mHeadView.getView().setAlpha(1.0f);
            this.mSelectedMiddleView.setAlpha(1.0f);
        } else {
            this.mTailView.getView().setAlpha(0.0f);
            this.mHeadView.getView().setAlpha(0.0f);
            this.mSelectedMiddleView.setAlpha(0.0f);
        }
    }

    public void switchState(byte b) {
        this.mState = b;
        if (b == 1) {
            this.mTailView.active();
            this.mHeadView.active();
            if (this.middleViewColor != 0) {
                this.mSelectedMiddleView.setBackgroundColor(this.mContext.getResources().getColor(this.middleViewColor));
                return;
            } else {
                this.mSelectedMiddleView.setBackgroundColor(this.mContext.getResources().getColor(com.aliyun.svideo.editor.R.color.alivc_edit_timeline_bar_active_overlay));
                return;
            }
        }
        if (b != 2) {
            return;
        }
        this.mTailView.fix();
        this.mHeadView.fix();
        if (this.middleViewColor != 0) {
            this.mSelectedMiddleView.setBackgroundColor(this.mContext.getResources().getColor(this.middleViewColor));
        } else {
            this.mSelectedMiddleView.setBackgroundColor(this.mContext.getResources().getColor(com.aliyun.svideo.editor.R.color.alivc_edit_timeline_bar_active_overlay));
        }
    }

    public void updateDuration(long j) {
        this.mDuration = j;
        invalidate();
        requestLayout();
    }

    public void updateMiddleViewColor(int i) {
        if (this.middleViewColor != i) {
            this.middleViewColor = i;
            this.mSelectedMiddleView.setBackgroundColor(this.mContext.getResources().getColor(i));
        }
    }
}
