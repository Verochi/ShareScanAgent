package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class StringLoader<T> implements com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.lang.String, T> {
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, T> uriLoader;

    public StringLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, T> modelLoader) {
        this.uriLoader = modelLoader;
    }

    private static android.net.Uri toFileUri(java.lang.String str) {
        return android.net.Uri.fromFile(new java.io.File(str));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> getResourceFetcher(java.lang.String str, int i, int i2) {
        android.net.Uri fileUri;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            fileUri = toFileUri(str);
        } else {
            android.net.Uri parse = android.net.Uri.parse(str);
            fileUri = parse.getScheme() == null ? toFileUri(str) : parse;
        }
        return this.uriLoader.getResourceFetcher(fileUri, i, i2);
    }
}
