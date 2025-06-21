package com.chad.library.adapter.base.listener;

/* loaded from: classes22.dex */
public interface OnItemSwipeListener {
    void clearView(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i);

    void onItemSwipeMoving(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z);

    void onItemSwipeStart(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i);

    void onItemSwiped(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i);
}
