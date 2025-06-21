package com.aliyun.svideo.common.baseAdapter;

/* loaded from: classes.dex */
public final class SimpleLoadMoreView extends com.aliyun.svideo.common.baseAdapter.LoadMoreView {
    @Override // com.aliyun.svideo.common.baseAdapter.LoadMoreView
    public int getLayoutId() {
        return com.aliyun.svideo.common.R.layout.alivc_quick_view_load_more;
    }

    @Override // com.aliyun.svideo.common.baseAdapter.LoadMoreView
    public int getLoadEndViewId() {
        return com.aliyun.svideo.common.R.id.load_more_load_end_view;
    }

    @Override // com.aliyun.svideo.common.baseAdapter.LoadMoreView
    public int getLoadFailViewId() {
        return com.aliyun.svideo.common.R.id.load_more_load_fail_view;
    }

    @Override // com.aliyun.svideo.common.baseAdapter.LoadMoreView
    public int getLoadingViewId() {
        return com.aliyun.svideo.common.R.id.load_more_loading_view;
    }
}
