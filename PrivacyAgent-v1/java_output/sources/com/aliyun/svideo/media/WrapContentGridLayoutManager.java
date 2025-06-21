package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class WrapContentGridLayoutManager extends androidx.recyclerview.widget.GridLayoutManager {
    public WrapContentGridLayoutManager(android.content.Context context, int i) {
        super(context, i);
    }

    public WrapContentGridLayoutManager(android.content.Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
    }

    public WrapContentGridLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (java.lang.IndexOutOfBoundsException unused) {
        }
    }
}
