package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public class SpaceItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private int space;

    public SpaceItemDecoration(int i) {
        this.space = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        if (recyclerView.getChildPosition(view) != 0) {
            rect.left = this.space;
        }
    }
}
