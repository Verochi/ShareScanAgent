package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class ResourceLoader<T> implements com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.lang.Integer, T> {
    private static final java.lang.String TAG = "ResourceLoader";
    private final android.content.res.Resources resources;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, T> uriLoader;

    public ResourceLoader(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, T> modelLoader) {
        this(context.getResources(), modelLoader);
    }

    public ResourceLoader(android.content.res.Resources resources, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, T> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> getResourceFetcher(java.lang.Integer num, int i, int i2) {
        android.net.Uri uri;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("android.resource://");
            sb.append(this.resources.getResourcePackageName(num.intValue()));
            sb.append('/');
            sb.append(this.resources.getResourceTypeName(num.intValue()));
            sb.append('/');
            sb.append(this.resources.getResourceEntryName(num.intValue()));
            uri = android.net.Uri.parse(sb.toString());
        } catch (android.content.res.Resources.NotFoundException unused) {
            if (android.util.Log.isLoggable(TAG, 5)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Received invalid resource id: ");
                sb2.append(num);
            }
            uri = null;
        }
        if (uri != null) {
            return this.uriLoader.getResourceFetcher(uri, i, i2);
        }
        return null;
    }
}
