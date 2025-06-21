package com.chad.library.adapter.base.diff;

@kotlin.Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/chad/library/adapter/base/diff/BrvahAsyncDiffer$submitList$1$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public final class BrvahAsyncDiffer$submitList$1$result$1 extends androidx.recyclerview.widget.DiffUtil.Callback {
    public final /* synthetic */ java.util.List<T> a;
    public final /* synthetic */ java.util.List<T> b;
    public final /* synthetic */ com.chad.library.adapter.base.diff.BrvahAsyncDiffer<T> c;

    /* JADX WARN: Multi-variable type inference failed */
    public BrvahAsyncDiffer$submitList$1$result$1(java.util.List<? extends T> list, java.util.List<T> list2, com.chad.library.adapter.base.diff.BrvahAsyncDiffer<T> brvahAsyncDiffer) {
        this.a = list;
        this.b = list2;
        this.c = brvahAsyncDiffer;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig brvahAsyncDifferConfig;
        java.lang.Object obj = this.a.get(oldItemPosition);
        java.lang.Object obj2 = this.b.get(newItemPosition);
        if (obj != null && obj2 != null) {
            brvahAsyncDifferConfig = this.c.config;
            return brvahAsyncDifferConfig.getDiffCallback().areContentsTheSame(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        throw new java.lang.AssertionError();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig brvahAsyncDifferConfig;
        java.lang.Object obj = this.a.get(oldItemPosition);
        java.lang.Object obj2 = this.b.get(newItemPosition);
        if (obj == null || obj2 == null) {
            return obj == null && obj2 == null;
        }
        brvahAsyncDifferConfig = this.c.config;
        return brvahAsyncDifferConfig.getDiffCallback().areItemsTheSame(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getChangePayload(int oldItemPosition, int newItemPosition) {
        com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig brvahAsyncDifferConfig;
        java.lang.Object obj = this.a.get(oldItemPosition);
        java.lang.Object obj2 = this.b.get(newItemPosition);
        if (obj == null || obj2 == null) {
            throw new java.lang.AssertionError();
        }
        brvahAsyncDifferConfig = this.c.config;
        return brvahAsyncDifferConfig.getDiffCallback().getChangePayload(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.a.size();
    }
}
