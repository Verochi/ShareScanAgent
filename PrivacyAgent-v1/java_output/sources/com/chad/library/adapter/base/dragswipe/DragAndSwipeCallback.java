package com.chad.library.adapter.base.dragswipe;

/* loaded from: classes22.dex */
public class DragAndSwipeCallback extends androidx.recyclerview.widget.ItemTouchHelper.Callback {
    public com.chad.library.adapter.base.module.BaseDraggableModule a;
    public float b = 0.1f;
    public float c = 0.7f;
    public int d = 15;
    public int e = 32;

    public DragAndSwipeCallback(com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule) {
        this.a = baseDraggableModule;
    }

    public final boolean a(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return itemViewType == 268435729 || itemViewType == 268436002 || itemViewType == 268436275 || itemViewType == 268436821;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (a(viewHolder)) {
            return;
        }
        android.view.View view = viewHolder.itemView;
        int i = com.chad.library.R.id.BaseQuickAdapter_dragging_support;
        if (view.getTag(i) != null && ((java.lang.Boolean) viewHolder.itemView.getTag(i)).booleanValue()) {
            com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule = this.a;
            if (baseDraggableModule != null) {
                baseDraggableModule.onItemDragEnd(viewHolder);
            }
            viewHolder.itemView.setTag(i, java.lang.Boolean.FALSE);
        }
        android.view.View view2 = viewHolder.itemView;
        int i2 = com.chad.library.R.id.BaseQuickAdapter_swiping_support;
        if (view2.getTag(i2) == null || !((java.lang.Boolean) viewHolder.itemView.getTag(i2)).booleanValue()) {
            return;
        }
        com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule2 = this.a;
        if (baseDraggableModule2 != null) {
            baseDraggableModule2.onItemSwipeClear(viewHolder);
        }
        viewHolder.itemView.setTag(i2, java.lang.Boolean.FALSE);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder) ? androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags(0, 0) : androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags(this.d, this.e);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule = this.a;
        if (baseDraggableModule != null) {
            return baseDraggableModule.getIsSwipeEnabled();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule = this.a;
        return (baseDraggableModule == null || !baseDraggableModule.getIsDragEnabled() || this.a.hasToggleView()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDrawOver(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        super.onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, z);
        if (i != 1 || a(viewHolder)) {
            return;
        }
        android.view.View view = viewHolder.itemView;
        canvas.save();
        if (f > 0.0f) {
            canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f, view.getBottom());
            canvas.translate(view.getLeft(), view.getTop());
        } else {
            canvas.clipRect(view.getRight() + f, view.getTop(), view.getRight(), view.getBottom());
            canvas.translate(view.getRight() + f, view.getTop());
        }
        com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule = this.a;
        if (baseDraggableModule != null) {
            baseDraggableModule.onItemSwiping(canvas, viewHolder, f, f2, z);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder2) {
        return viewHolder.getItemViewType() == viewHolder2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onMoved(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
        super.onMoved(recyclerView, viewHolder, i, viewHolder2, i2, i3, i4);
        com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule = this.a;
        if (baseDraggableModule != null) {
            baseDraggableModule.onItemDragMoving(viewHolder, viewHolder2);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        if (i == 2 && !a(viewHolder)) {
            com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule = this.a;
            if (baseDraggableModule != null) {
                baseDraggableModule.onItemDragStart(viewHolder);
            }
            viewHolder.itemView.setTag(com.chad.library.R.id.BaseQuickAdapter_dragging_support, java.lang.Boolean.TRUE);
        } else if (i == 1 && !a(viewHolder)) {
            com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule2 = this.a;
            if (baseDraggableModule2 != null) {
                baseDraggableModule2.onItemSwipeStart(viewHolder);
            }
            viewHolder.itemView.setTag(com.chad.library.R.id.BaseQuickAdapter_swiping_support, java.lang.Boolean.TRUE);
        }
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule;
        if (a(viewHolder) || (baseDraggableModule = this.a) == null) {
            return;
        }
        baseDraggableModule.onItemSwiped(viewHolder);
    }

    public void setDragMoveFlags(int i) {
        this.d = i;
    }

    public void setMoveThreshold(float f) {
        this.b = f;
    }

    public void setSwipeMoveFlags(int i) {
        this.e = i;
    }

    public void setSwipeThreshold(float f) {
        this.c = f;
    }
}
