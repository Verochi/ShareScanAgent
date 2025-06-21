package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public class FileDescriptorAssetPathFetcher extends com.alimm.tanx.ui.image.glide.load.data.AssetPathFetcher<android.os.ParcelFileDescriptor> {
    public FileDescriptorAssetPathFetcher(android.content.res.AssetManager assetManager, java.lang.String str) {
        super(assetManager, str);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.AssetPathFetcher
    public void close(android.os.ParcelFileDescriptor parcelFileDescriptor) throws java.io.IOException {
        parcelFileDescriptor.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.AssetPathFetcher
    public android.os.ParcelFileDescriptor loadResource(android.content.res.AssetManager assetManager, java.lang.String str) throws java.io.IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
