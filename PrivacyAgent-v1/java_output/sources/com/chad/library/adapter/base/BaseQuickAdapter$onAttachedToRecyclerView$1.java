package com.chad.library.adapter.base;

@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/chad/library/adapter/base/BaseQuickAdapter$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public final class BaseQuickAdapter$onAttachedToRecyclerView$1 extends androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup {
    public final /* synthetic */ com.chad.library.adapter.base.BaseQuickAdapter<T, VH> a;
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView.LayoutManager b;
    public final /* synthetic */ androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup c;

    public BaseQuickAdapter$onAttachedToRecyclerView$1(com.chad.library.adapter.base.BaseQuickAdapter<T, VH> baseQuickAdapter, androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.a = baseQuickAdapter;
        this.b = layoutManager;
        this.c = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int position) {
        com.chad.library.adapter.base.listener.GridSpanSizeLookup gridSpanSizeLookup;
        com.chad.library.adapter.base.listener.GridSpanSizeLookup gridSpanSizeLookup2;
        int itemViewType = this.a.getItemViewType(position);
        if (itemViewType == 268435729 && this.a.getHeaderViewAsFlow()) {
            return 1;
        }
        if (itemViewType == 268436275 && this.a.getFooterViewAsFlow()) {
            return 1;
        }
        gridSpanSizeLookup = this.a.mSpanSizeLookup;
        if (gridSpanSizeLookup == null) {
            return this.a.isFixedViewType(itemViewType) ? ((androidx.recyclerview.widget.GridLayoutManager) this.b).getSpanCount() : this.c.getSpanSize(position);
        }
        if (this.a.isFixedViewType(itemViewType)) {
            return ((androidx.recyclerview.widget.GridLayoutManager) this.b).getSpanCount();
        }
        gridSpanSizeLookup2 = this.a.mSpanSizeLookup;
        kotlin.jvm.internal.Intrinsics.checkNotNull(gridSpanSizeLookup2);
        return gridSpanSizeLookup2.getSpanSize((androidx.recyclerview.widget.GridLayoutManager) this.b, itemViewType, position - this.a.getHeaderLayoutCount());
    }
}
