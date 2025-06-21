package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class CenterLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {

    public static class CenterSmoothScroller extends androidx.recyclerview.widget.LinearSmoothScroller {
        public CenterSmoothScroller(android.content.Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
        }
    }

    public CenterLayoutManager(android.content.Context context) {
        super(context);
    }

    public CenterLayoutManager(android.content.Context context, int i, boolean z) {
        super(context, i, z);
    }

    public CenterLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state, int i) {
        com.aliyun.svideo.base.widget.CenterLayoutManager.CenterSmoothScroller centerSmoothScroller = new com.aliyun.svideo.base.widget.CenterLayoutManager.CenterSmoothScroller(recyclerView.getContext());
        centerSmoothScroller.setTargetPosition(i);
        startSmoothScroll(centerSmoothScroller);
    }
}
