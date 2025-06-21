package com.chad.library.adapter.base.loadmore;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0014\u0010\u0014\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¨\u0006\u0017"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "getRootView", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "getLoadingView", "getLoadComplete", "getLoadEndView", "getLoadFailView", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "loadMoreStatus", "", "convert", "", "visible", "a", "<init>", "()V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public abstract class BaseLoadMoreView {

    @kotlin.Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.chad.library.adapter.base.loadmore.LoadMoreStatus.values().length];
            iArr[com.chad.library.adapter.base.loadmore.LoadMoreStatus.Complete.ordinal()] = 1;
            iArr[com.chad.library.adapter.base.loadmore.LoadMoreStatus.Loading.ordinal()] = 2;
            iArr[com.chad.library.adapter.base.loadmore.LoadMoreStatus.Fail.ordinal()] = 3;
            iArr[com.chad.library.adapter.base.loadmore.LoadMoreStatus.End.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void a(android.view.View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    public void convert(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder, int position, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.loadmore.LoadMoreStatus loadMoreStatus) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(loadMoreStatus, "loadMoreStatus");
        int i = com.chad.library.adapter.base.loadmore.BaseLoadMoreView.WhenMappings.$EnumSwitchMapping$0[loadMoreStatus.ordinal()];
        if (i == 1) {
            a(getLoadingView(holder), false);
            a(getLoadComplete(holder), true);
            a(getLoadFailView(holder), false);
            a(getLoadEndView(holder), false);
            return;
        }
        if (i == 2) {
            a(getLoadingView(holder), true);
            a(getLoadComplete(holder), false);
            a(getLoadFailView(holder), false);
            a(getLoadEndView(holder), false);
            return;
        }
        if (i == 3) {
            a(getLoadingView(holder), false);
            a(getLoadComplete(holder), false);
            a(getLoadFailView(holder), true);
            a(getLoadEndView(holder), false);
            return;
        }
        if (i != 4) {
            return;
        }
        a(getLoadingView(holder), false);
        a(getLoadComplete(holder), false);
        a(getLoadFailView(holder), false);
        a(getLoadEndView(holder), true);
    }

    @org.jetbrains.annotations.NotNull
    public abstract android.view.View getLoadComplete(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder);

    @org.jetbrains.annotations.NotNull
    public abstract android.view.View getLoadEndView(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder);

    @org.jetbrains.annotations.NotNull
    public abstract android.view.View getLoadFailView(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder);

    @org.jetbrains.annotations.NotNull
    public abstract android.view.View getLoadingView(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder holder);

    @org.jetbrains.annotations.NotNull
    public abstract android.view.View getRootView(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent);
}
