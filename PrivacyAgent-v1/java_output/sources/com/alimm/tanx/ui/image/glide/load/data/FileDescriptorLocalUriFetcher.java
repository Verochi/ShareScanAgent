package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public class FileDescriptorLocalUriFetcher extends com.alimm.tanx.ui.image.glide.load.data.LocalUriFetcher<android.os.ParcelFileDescriptor> {
    public FileDescriptorLocalUriFetcher(android.content.Context context, android.net.Uri uri) {
        super(context, uri);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.LocalUriFetcher
    public void close(android.os.ParcelFileDescriptor parcelFileDescriptor) throws java.io.IOException {
        parcelFileDescriptor.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.LocalUriFetcher
    public android.os.ParcelFileDescriptor loadResource(android.net.Uri uri, android.content.ContentResolver contentResolver) throws java.io.FileNotFoundException {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }
}
