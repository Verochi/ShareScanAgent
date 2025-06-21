package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public final class AssetFileDescriptorLocalUriFetcher extends com.bumptech.glide.load.data.LocalUriFetcher<android.content.res.AssetFileDescriptor> {
    public AssetFileDescriptorLocalUriFetcher(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(android.content.res.AssetFileDescriptor assetFileDescriptor) throws java.io.IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public java.lang.Class<android.content.res.AssetFileDescriptor> getDataClass() {
        return android.content.res.AssetFileDescriptor.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public android.content.res.AssetFileDescriptor loadResource(android.net.Uri uri, android.content.ContentResolver contentResolver) throws java.io.FileNotFoundException {
        android.content.res.AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor;
        }
        throw new java.io.FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}
