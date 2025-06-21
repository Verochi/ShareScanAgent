package com.aliyun.svideosdk.common.struct.asset;

/* loaded from: classes12.dex */
public abstract class AssetRepository {
    public static final int FEATURE_DOWNLOAD = 1;

    public enum Kind {
        SOUND,
        FILTER,
        MV,
        DIY,
        FONT,
        CAPTION,
        ALL
    }

    public void addListener(com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind kind, com.aliyun.svideosdk.common.struct.asset.AssetRepositoryClient.Listener listener) {
    }

    public void attachClient(com.aliyun.svideosdk.common.struct.asset.AssetRepositoryClient assetRepositoryClient) {
    }

    public void clearNew(com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind kind) {
    }

    public void detachClient(com.aliyun.svideosdk.common.struct.asset.AssetRepositoryClient assetRepositoryClient) {
    }

    public abstract com.aliyun.svideosdk.common.struct.asset.AssetInfo find(com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind kind, long j);

    public abstract java.util.List<? extends com.aliyun.svideosdk.common.struct.asset.AssetInfo> find(com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind kind);

    public abstract com.aliyun.svideosdk.common.struct.asset.AssetRepository.Kind[] findCategory();

    public abstract java.util.List<? extends com.aliyun.svideosdk.common.struct.asset.AssetGroup> findDIYCategory();

    public abstract java.util.List<? extends com.aliyun.svideosdk.common.struct.asset.AssetGroup> findDIYCategory(int i);

    public abstract java.util.List<? extends com.aliyun.svideosdk.common.struct.asset.AssetInfo> findDIYCategoryContent(int i);

    public com.aliyun.svideosdk.common.struct.asset.RepositoryEditor getEditor() {
        return null;
    }

    public com.aliyun.svideosdk.common.struct.asset.FontResolver getFontResolver() {
        return null;
    }

    public boolean onAssetUsed(com.aliyun.svideosdk.common.struct.asset.AssetInfo assetInfo) {
        com.aliyun.svideosdk.common.struct.asset.RepositoryEditor editor = getEditor();
        if (editor == null) {
            return false;
        }
        return editor.onAssetUsed(assetInfo);
    }

    public com.aliyun.svideosdk.common.struct.asset.TypefaceConfig resolveTypeface(java.lang.String str) {
        long j;
        android.graphics.Typeface typefaceByFont;
        try {
            j = java.lang.Long.parseLong(str);
        } catch (java.lang.NumberFormatException unused) {
            j = -1;
        }
        if (j < 0 || (typefaceByFont = getFontResolver().getTypefaceByFont(j)) == null) {
            return null;
        }
        return new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig(typefaceByFont);
    }

    public void updateAssetInfo(com.aliyun.svideosdk.common.struct.asset.AssetInfo assetInfo) {
        com.aliyun.svideosdk.common.struct.asset.RepositoryEditor editor = getEditor();
        if (editor == null) {
            return;
        }
        editor.updateAsset(assetInfo);
    }
}
