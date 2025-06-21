package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public abstract class UriLoader<T> implements com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, T> {
    private final android.content.Context context;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, T> urlLoader;

    public UriLoader(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, T> modelLoader) {
        this.context = context;
        this.urlLoader = modelLoader;
    }

    private static boolean isLocalUri(java.lang.String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }

    public abstract com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> getAssetPathFetcher(android.content.Context context, java.lang.String str);

    public abstract com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> getLocalUriFetcher(android.content.Context context, android.net.Uri uri);

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public final com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> getResourceFetcher(android.net.Uri uri, int i, int i2) {
        java.lang.String scheme = uri.getScheme();
        if (isLocalUri(scheme)) {
            if (!com.alimm.tanx.ui.image.glide.load.model.AssetUriParser.isAssetUri(uri)) {
                return getLocalUriFetcher(this.context, uri);
            }
            return getAssetPathFetcher(this.context, com.alimm.tanx.ui.image.glide.load.model.AssetUriParser.toAssetPath(uri));
        }
        if (this.urlLoader == null || !(com.alipay.sdk.m.l.a.q.equals(scheme) || "https".equals(scheme))) {
            return null;
        }
        return this.urlLoader.getResourceFetcher(new com.alimm.tanx.ui.image.glide.load.model.GlideUrl(uri.toString()), i, i2);
    }
}
