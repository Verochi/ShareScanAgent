package com.aliyun.svideo.editor.editor.thumblinebar;

/* loaded from: classes12.dex */
public class OverlayThumbLineBar extends com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar {
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar";
    private java.util.List<com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay> mOverlayList;

    /* renamed from: com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ boolean val$isIvert;
        final /* synthetic */ com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay val$overlay;
        final /* synthetic */ com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView val$tailView;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass1(android.view.View view, boolean z, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView thumbLineOverlayHandleView, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay) {
            this.val$view = view;
            this.val$isIvert = z;
            this.val$tailView = thumbLineOverlayHandleView;
            this.val$overlay = thumbLineOverlay;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.val$view.getLayoutParams();
            if (this.val$isIvert) {
                marginLayoutParams.rightMargin = com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar.this.calculateTailViewInvertPosition(this.val$tailView);
            } else {
                marginLayoutParams.leftMargin = com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar.this.calculateTailViewPosition(this.val$tailView);
            }
            this.val$view.requestLayout();
            this.val$overlay.setVisibility(true);
        }
    }

    public OverlayThumbLineBar(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public OverlayThumbLineBar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayThumbLineBar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOverlayList = new java.util.ArrayList();
    }

    public com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay addOverlay(long j, long j2, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView thumbLineOverlayView, long j3, boolean z, com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage) {
        return addOverlay(j, j2, thumbLineOverlayView, j3, z, uIEditorPage, null);
    }

    public com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay addOverlay(long j, long j2, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView thumbLineOverlayView, long j3, boolean z, com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.OnSelectedDurationChangeListener onSelectedDurationChangeListener) {
        long j4 = j < 0 ? 0L : j;
        thumbLineOverlayView.getContainer().setTag(uIEditorPage);
        com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener playerListener = this.mLinePlayer;
        if (playerListener != null) {
            this.mDuration = playerListener.getDuration();
        }
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay(this, j4, j2, thumbLineOverlayView, this.mDuration, j3, z, onSelectedDurationChangeListener);
        thumbLineOverlay.setUIEditorPage(uIEditorPage);
        this.mOverlayList.add(thumbLineOverlay);
        return thumbLineOverlay;
    }

    public void addOverlayView(android.view.View view, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView thumbLineOverlayHandleView, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay, boolean z) {
        if (view.getParent() instanceof android.view.ViewGroup) {
            ((android.view.ViewGroup) view.getParent()).removeView(view);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            addView(view, 0);
        } else if (childCount > 0) {
            addView(view, childCount - 1);
        }
        view.post(new com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar.AnonymousClass1(thumbLineOverlayHandleView.getView(), z, thumbLineOverlayHandleView, thumbLineOverlay));
    }

    public int calculateTailViewInvertPosition(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView thumbLineOverlayHandleView) {
        if (thumbLineOverlayHandleView.getView() != null) {
            return (int) ((((this.mThumbLineConfig.getScreenWidth() / 2) - thumbLineOverlayHandleView.getView().getMeasuredWidth()) - duration2Distance(thumbLineOverlayHandleView.getDuration())) + this.mCurrScroll);
        }
        return 0;
    }

    public int calculateTailViewPosition(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlayHandleView thumbLineOverlayHandleView) {
        if (thumbLineOverlayHandleView.getView() != null) {
            return (int) ((((this.mThumbLineConfig.getScreenWidth() / 2) - thumbLineOverlayHandleView.getView().getMeasuredWidth()) + duration2Distance(thumbLineOverlayHandleView.getDuration())) - this.mCurrScroll);
        }
        return 0;
    }

    public void clearOverlay() {
        java.util.Iterator<com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay> it = this.mOverlayList.iterator();
        while (it.hasNext()) {
            removeView(it.next().getOverlayView());
        }
        this.mOverlayList.clear();
    }

    public long distance2Duration(float f) {
        return java.lang.Math.round((this.mDuration * f) / getTimelineBarViewWidth());
    }

    public int duration2Distance(long j) {
        return java.lang.Math.round(((getTimelineBarViewWidth() * j) * 1.0f) / this.mDuration);
    }

    @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar
    public void onRecyclerViewScroll(int i, int i2) {
        super.onRecyclerViewScroll(i, i2);
        int size = this.mOverlayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mOverlayList.get(i3).requestLayout();
        }
    }

    @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar
    public void onRecyclerViewScrollStateChanged(int i) {
        super.onRecyclerViewScrollStateChanged(i);
        if (i != 0) {
            return;
        }
        java.util.Iterator<com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay> it = this.mOverlayList.iterator();
        while (it.hasNext()) {
            it.next().requestLayout();
        }
    }

    public void removeOverlay(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay) {
        if (thumbLineOverlay != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("remove TimelineBar Overlay : ");
            sb.append(thumbLineOverlay.getUIEditorPage());
            removeView(thumbLineOverlay.getOverlayView());
            this.mOverlayList.remove(thumbLineOverlay);
        }
    }

    public void removeOverlayByPages(com.aliyun.svideo.editor.effects.control.UIEditorPage... uIEditorPageArr) {
        if (uIEditorPageArr == null || uIEditorPageArr.length == 0) {
            return;
        }
        java.util.List asList = java.util.Arrays.asList(uIEditorPageArr);
        int i = 0;
        while (i < getChildCount()) {
            android.view.View childAt = getChildAt(i);
            if (childAt.getTag() instanceof com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay) {
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay) childAt.getTag();
                if (asList.contains(thumbLineOverlay.getUIEditorPage())) {
                    removeOverlay(thumbLineOverlay);
                    i--;
                }
            }
            i++;
        }
    }

    @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar
    public void setup(com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig thumbLineConfig, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineBar.OnBarSeekListener onBarSeekListener, com.aliyun.svideo.editor.view.AlivcEditView.PlayerListener playerListener) {
        super.setup(thumbLineConfig, onBarSeekListener, playerListener);
    }

    public void showOverlay(com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage) {
        if (uIEditorPage == null) {
            return;
        }
        for (com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay : this.mOverlayList) {
            if (uIEditorPage == thumbLineOverlay.getUIEditorPage()) {
                thumbLineOverlay.getOverlayView().setVisibility(0);
            } else {
                thumbLineOverlay.getOverlayView().setVisibility(4);
            }
        }
    }
}
