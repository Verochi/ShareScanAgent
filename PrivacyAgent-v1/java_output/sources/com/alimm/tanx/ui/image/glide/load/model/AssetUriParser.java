package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
final class AssetUriParser {
    private static final java.lang.String ASSET_PATH_SEGMENT = "android_asset";
    private static final java.lang.String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH = 22;

    private AssetUriParser() {
    }

    public static boolean isAssetUri(android.net.Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0));
    }

    public static java.lang.String toAssetPath(android.net.Uri uri) {
        return uri.toString().substring(ASSET_PREFIX_LENGTH);
    }
}
