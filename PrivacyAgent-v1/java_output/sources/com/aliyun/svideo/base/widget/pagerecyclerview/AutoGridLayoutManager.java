package com.aliyun.svideo.base.widget.pagerecyclerview;

/* loaded from: classes.dex */
public class AutoGridLayoutManager extends androidx.recyclerview.widget.GridLayoutManager {
    private int measuredHeight;
    private int measuredWidth;

    public AutoGridLayoutManager(android.content.Context context, int i) {
        super(context, i);
        this.measuredWidth = 0;
        this.measuredHeight = 0;
    }

    public AutoGridLayoutManager(android.content.Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
        this.measuredWidth = 0;
        this.measuredHeight = 0;
    }

    public AutoGridLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.measuredWidth = 0;
        this.measuredHeight = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state, int i, int i2) {
        android.view.View viewForPosition;
        if (this.measuredHeight <= 0 && state.getItemCount() > 0 && (viewForPosition = recycler.getViewForPosition(0)) != null) {
            measureChild(viewForPosition, i, i2);
            this.measuredWidth = android.view.View.MeasureSpec.getSize(i);
            this.measuredHeight = viewForPosition.getMeasuredHeight() * getSpanCount();
        }
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }
}
