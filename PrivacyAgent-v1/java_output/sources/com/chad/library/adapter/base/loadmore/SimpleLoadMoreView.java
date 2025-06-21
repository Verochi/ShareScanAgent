package com.chad.library.adapter.base.loadmore;

@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/SimpleLoadMoreView;", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "()V", "getLoadComplete", "Landroid/view/View;", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "getLoadEndView", "getLoadFailView", "getLoadingView", "getRootView", "parent", "Landroid/view/ViewGroup;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public final class SimpleLoadMoreView extends com.chad.library.adapter.base.loadmore.BaseLoadMoreView {
    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    @org.jetbrains.annotations.NotNull
    public android.view.View getLoadComplete(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        return holder.getView(com.chad.library.R.id.load_more_load_complete_view);
    }

    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    @org.jetbrains.annotations.NotNull
    public android.view.View getLoadEndView(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        return holder.getView(com.chad.library.R.id.load_more_load_end_view);
    }

    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    @org.jetbrains.annotations.NotNull
    public android.view.View getLoadFailView(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        return holder.getView(com.chad.library.R.id.load_more_load_fail_view);
    }

    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    @org.jetbrains.annotations.NotNull
    public android.view.View getLoadingView(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        return holder.getView(com.chad.library.R.id.load_more_loading_view);
    }

    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    @org.jetbrains.annotations.NotNull
    public android.view.View getRootView(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        return com.chad.library.adapter.base.util.AdapterUtilsKt.getItemView(parent, com.chad.library.R.layout.brvah_quick_view_load_more);
    }
}
