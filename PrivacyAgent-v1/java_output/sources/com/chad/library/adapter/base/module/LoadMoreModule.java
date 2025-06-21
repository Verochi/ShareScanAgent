package com.chad.library.adapter.base.module;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/chad/library/adapter/base/module/LoadMoreModule;", "", "addLoadMoreModule", "Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "baseQuickAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public interface LoadMoreModule {

    @kotlin.Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @org.jetbrains.annotations.NotNull
        public static com.chad.library.adapter.base.module.BaseLoadMoreModule addLoadMoreModule(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.module.LoadMoreModule loadMoreModule, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.BaseQuickAdapter<?, ?> baseQuickAdapter) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
            return new com.chad.library.adapter.base.module.BaseLoadMoreModule(baseQuickAdapter);
        }
    }

    @org.jetbrains.annotations.NotNull
    com.chad.library.adapter.base.module.BaseLoadMoreModule addLoadMoreModule(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.BaseQuickAdapter<?, ?> baseQuickAdapter);
}
