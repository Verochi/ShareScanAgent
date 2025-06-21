package com.aliyun.svideo.common.baseAdapter.decoration;

/* loaded from: classes.dex */
public class GridItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private android.graphics.drawable.Drawable dividerDrawable;
    private int orientation;

    public GridItemDecoration(android.content.Context context, int i) {
        this.orientation = 1;
        this.dividerDrawable = context.getResources().getDrawable(i);
    }

    public GridItemDecoration(android.content.Context context, int i, int i2) {
        this.orientation = 1;
        this.dividerDrawable = context.getResources().getDrawable(i);
        this.orientation = i2;
    }

    public GridItemDecoration(android.graphics.drawable.Drawable drawable) {
        this.orientation = 1;
        this.dividerDrawable = drawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        if (this.dividerDrawable != null && recyclerView.getChildLayoutPosition(view) >= 1) {
            int i = this.orientation;
            if (i == 1) {
                rect.top = this.dividerDrawable.getIntrinsicHeight();
            } else if (i == 0) {
                rect.left = this.dividerDrawable.getIntrinsicWidth();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        if (this.dividerDrawable == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        int width = recyclerView.getWidth();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = recyclerView.getChildAt(i);
            androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) childAt.getLayoutParams();
            int paddingLeft = recyclerView.getPaddingLeft() + childAt.getPaddingLeft();
            int top = childAt.getTop() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int intrinsicHeight = top - this.dividerDrawable.getIntrinsicHeight();
            int top2 = childAt.getTop() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int bottom = childAt.getBottom() + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int left = childAt.getLeft() - ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            this.dividerDrawable.setBounds(left - this.dividerDrawable.getIntrinsicWidth(), top2, left, bottom);
            this.dividerDrawable.draw(canvas);
            this.dividerDrawable.setBounds(paddingLeft, intrinsicHeight, width, top);
            this.dividerDrawable.draw(canvas);
        }
    }
}
