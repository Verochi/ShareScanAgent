package com.chad.library.adapter.base.diff;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "", "onInserted", "onRemoved", "fromPosition", "toPosition", "onMoved", "", "payload", "onChanged", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "mAdapter", "<init>", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public final class BrvahListUpdateCallback implements androidx.recyclerview.widget.ListUpdateCallback {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final com.chad.library.adapter.base.BaseQuickAdapter<?, ?> mAdapter;

    public BrvahListUpdateCallback(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.BaseQuickAdapter<?, ?> mAdapter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mAdapter, "mAdapter");
        this.mAdapter = mAdapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int position, int count, @org.jetbrains.annotations.Nullable java.lang.Object payload) {
        com.chad.library.adapter.base.BaseQuickAdapter<?, ?> baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeChanged(position + baseQuickAdapter.getHeaderLayoutCount(), count, payload);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int position, int count) {
        com.chad.library.adapter.base.BaseQuickAdapter<?, ?> baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeInserted(position + baseQuickAdapter.getHeaderLayoutCount(), count);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int fromPosition, int toPosition) {
        com.chad.library.adapter.base.BaseQuickAdapter<?, ?> baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemMoved(fromPosition + baseQuickAdapter.getHeaderLayoutCount(), toPosition + this.mAdapter.getHeaderLayoutCount());
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int position, int count) {
        com.chad.library.adapter.base.module.BaseLoadMoreModule mLoadMoreModule = this.mAdapter.getMLoadMoreModule();
        boolean z = false;
        if (mLoadMoreModule != null && mLoadMoreModule.hasLoadMoreView()) {
            z = true;
        }
        if (z && this.mAdapter.getItemCount() == 0) {
            com.chad.library.adapter.base.BaseQuickAdapter<?, ?> baseQuickAdapter = this.mAdapter;
            baseQuickAdapter.notifyItemRangeRemoved(position + baseQuickAdapter.getHeaderLayoutCount(), count + 1);
        } else {
            com.chad.library.adapter.base.BaseQuickAdapter<?, ?> baseQuickAdapter2 = this.mAdapter;
            baseQuickAdapter2.notifyItemRangeRemoved(position + baseQuickAdapter2.getHeaderLayoutCount(), count);
        }
    }
}
