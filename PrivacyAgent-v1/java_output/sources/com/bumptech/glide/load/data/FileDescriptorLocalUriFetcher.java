package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public class FileDescriptorLocalUriFetcher extends com.bumptech.glide.load.data.LocalUriFetcher<android.os.ParcelFileDescriptor> {
    public FileDescriptorLocalUriFetcher(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(android.os.ParcelFileDescriptor parcelFileDescriptor) throws java.io.IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public java.lang.Class<android.os.ParcelFileDescriptor> getDataClass() {
        return android.os.ParcelFileDescriptor.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public android.os.ParcelFileDescriptor loadResource(android.net.Uri uri, android.content.ContentResolver contentResolver) throws java.io.FileNotFoundException {
        android.content.res.AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new java.io.FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}
