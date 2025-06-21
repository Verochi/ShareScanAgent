package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class GalleryItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private int mLineSpace = -1;
    private int offset = -1;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.mLineSpace == -1) {
            this.mLineSpace = com.aliyun.svideo.common.utils.DensityUtils.dip2px(view.getContext(), 1.0f);
            this.offset = com.aliyun.svideo.common.utils.DensityUtils.dip2px(view.getContext(), 1.0f);
        }
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        rect.bottom = this.mLineSpace;
        int i = childLayoutPosition % 4;
        if (i == 0) {
            rect.right = this.offset;
            return;
        }
        if (i != 1 && i != 2) {
            rect.left = this.offset;
            return;
        }
        int i2 = this.offset;
        rect.left = i2 / 2;
        rect.right = i2 / 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }
}
