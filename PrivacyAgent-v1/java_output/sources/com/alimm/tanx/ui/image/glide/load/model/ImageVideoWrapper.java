package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class ImageVideoWrapper {
    private final android.os.ParcelFileDescriptor fileDescriptor;
    private final java.io.InputStream streamData;

    public ImageVideoWrapper(java.io.InputStream inputStream, android.os.ParcelFileDescriptor parcelFileDescriptor) {
        this.streamData = inputStream;
        this.fileDescriptor = parcelFileDescriptor;
    }

    public android.os.ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public java.io.InputStream getStream() {
        return this.streamData;
    }
}
