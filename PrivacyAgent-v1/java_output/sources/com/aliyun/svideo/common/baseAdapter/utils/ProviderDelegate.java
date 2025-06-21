package com.aliyun.svideo.common.baseAdapter.utils;

/* loaded from: classes.dex */
public class ProviderDelegate {
    private android.util.SparseArray<com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider> mItemProviders = new android.util.SparseArray<>();

    public android.util.SparseArray<com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider> getItemProviders() {
        return this.mItemProviders;
    }

    public void registerProvider(com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider baseItemProvider) {
        if (baseItemProvider == null) {
            throw new com.aliyun.svideo.common.baseAdapter.utils.ItemProviderException("ItemProvider can not be null");
        }
        int viewType = baseItemProvider.viewType();
        if (this.mItemProviders.get(viewType) == null) {
            this.mItemProviders.put(viewType, baseItemProvider);
        }
    }
}
