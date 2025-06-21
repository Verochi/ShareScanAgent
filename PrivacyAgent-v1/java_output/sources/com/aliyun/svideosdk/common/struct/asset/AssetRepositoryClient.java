package com.aliyun.svideosdk.common.struct.asset;

/* loaded from: classes12.dex */
public class AssetRepositoryClient {
    private final java.util.HashMap<com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind, com.aliyun.svideosdk.common.struct.asset.AssetRepositoryClient.Listener> _Listener = new java.util.HashMap<>();
    private final com.aliyun.svideosdk.common.struct.asset.AssetRepository _Repo;

    public interface Listener {
        void onDataChange(com.aliyun.svideosdk.common.struct.asset.AssetRepositoryClient assetRepositoryClient, com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind kind);
    }

    public AssetRepositoryClient(com.aliyun.svideosdk.common.struct.asset.AssetRepository assetRepository) {
        this._Repo = assetRepository;
    }

    public void addListener(com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind kind, com.aliyun.svideosdk.common.struct.asset.AssetRepositoryClient.Listener listener) {
        this._Listener.put(kind, listener);
    }

    public void connect() {
        this._Repo.attachClient(this);
    }

    public void disconnect() {
        this._Repo.detachClient(this);
    }

    public java.util.List<? extends com.aliyun.svideosdk.common.struct.asset.AssetInfo> find(com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind kind) {
        return this._Repo.find(kind);
    }

    public com.aliyun.svideosdk.common.struct.asset.AssetRepository getRepository() {
        return this._Repo;
    }

    public void onDataChange(com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind kind) {
        if (kind != null && kind != com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind.ALL) {
            com.aliyun.svideosdk.common.struct.asset.AssetRepositoryClient.Listener listener = this._Listener.get(kind);
            if (listener != null) {
                listener.onDataChange(this, kind);
                return;
            }
            return;
        }
        java.util.Iterator<java.util.Map.Entry<com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind, com.aliyun.svideosdk.common.struct.asset.AssetRepositoryClient.Listener>> it = this._Listener.entrySet().iterator();
        while (it.hasNext()) {
            com.aliyun.svideosdk.common.struct.asset.AssetRepositoryClient.Listener value = it.next().getValue();
            if (value != null) {
                value.onDataChange(this, null);
            }
        }
    }
}
