package com.aliyun.svideo.editor.effects.control;

/* loaded from: classes12.dex */
public class SpacesEffectItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private int space;

    public SpacesEffectItemDecoration(int i) {
        this.space = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (childAdapterPosition == 0) {
            rect.left = com.moji.tool.DeviceTool.dp2px(20.0f);
        } else if (childAdapterPosition != itemCount - 1) {
            rect.left = this.space;
        } else {
            rect.left = this.space;
            rect.right = com.moji.tool.DeviceTool.dp2px(15.0f);
        }
    }
}
