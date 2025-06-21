package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public class FileDescriptorAssetPathFetcher extends com.bumptech.glide.load.data.AssetPathFetcher<android.os.ParcelFileDescriptor> {
    public FileDescriptorAssetPathFetcher(android.content.res.AssetManager assetManager, java.lang.String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public void close(android.os.ParcelFileDescriptor parcelFileDescriptor) throws java.io.IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public java.lang.Class<android.os.ParcelFileDescriptor> getDataClass() {
        return android.os.ParcelFileDescriptor.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public android.os.ParcelFileDescriptor loadResource(android.content.res.AssetManager assetManager, java.lang.String str) throws java.io.IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
