package com.aliyun.svideosdk.common.struct.asset;

/* loaded from: classes12.dex */
public abstract class AssetInfo {
    public static final int FLAG_LOCKED = 2;
    public static final int FLAG_NEW = 1;
    public static final int FONT_TYPE_COMPLEX = 3;
    public static final int FONT_TYPE_FAMILIAR = 2;
    public static final int FONT_TYPE_NORMAL = 1;
    public static final long INVALID_UID = 0;
    public static final int RECOMMEND_CLIENT_DELETE = 4;
    public static final int RECOMMEND_DOWNLOAD = 1;
    public static final int RECOMMEND_LOCAL = 2;
    public static final int RECOMMEND_SERVER = 0;
    public static final int RECOMMEND_SERVER_DELETE = 3;
    public static final int RESOURCE_HOT = 2;
    public static final int RESOURCE_LOCK = 3;
    public static final int RESOURCE_NORMAL = 1;
    public static final int TYPE_CAPTION = 10;
    public static final int TYPE_DIYOVERLAY = 1;
    public static final int TYPE_FONT = 2;
    public static final int TYPE_MUSIC = 3;
    public static final int TYPE_MV_MUSIC = 9;
    public static final int TYPE_SHADER_EFFECT = 4;
    public static final int TYPE_SHADER_MV = 7;

    public java.lang.String getBannerURIString() {
        return null;
    }

    public abstract com.aliyun.svideosdk.common.struct.asset.AssetBundle getContent();

    public abstract java.lang.String getContentURIString();

    public abstract int getFlags();

    public int getFontType() {
        return 1;
    }

    public abstract long getID();

    public abstract java.lang.String getIconURIString();

    public com.aliyun.svideosdk.common.struct.asset.AssetInfo[] getOverlays() {
        return null;
    }

    public abstract int getResourceFrom();

    public abstract int getResourceStatus();

    public abstract java.lang.String getResourceUrl();

    public abstract java.lang.String getTitle();

    public abstract int getType();

    public abstract long getUID();

    public final java.lang.String getURIString() {
        return com.aliyun.common.utils.UriUtil.formatAssetURI(getType(), (int) getID());
    }

    public abstract int getVersion();

    public boolean hasMultiOverlay() {
        return false;
    }

    public abstract boolean isAvailable();

    public boolean isDownloadable() {
        return false;
    }

    public boolean isDownloading() {
        return false;
    }

    public final boolean isLocked() {
        return (getFlags() & 2) > 0;
    }

    public final boolean isNew() {
        return (getFlags() & 1) > 0;
    }
}
