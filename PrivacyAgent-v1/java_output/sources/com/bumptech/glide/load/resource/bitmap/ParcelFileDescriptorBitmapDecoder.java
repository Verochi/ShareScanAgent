package com.bumptech.glide.load.resource.bitmap;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
public final class ParcelFileDescriptorBitmapDecoder implements com.bumptech.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> {
    private final com.bumptech.glide.load.resource.bitmap.Downsampler downsampler;

    public ParcelFileDescriptorBitmapDecoder(com.bumptech.glide.load.resource.bitmap.Downsampler downsampler) {
        this.downsampler = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(@androidx.annotation.NonNull android.os.ParcelFileDescriptor parcelFileDescriptor, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        return this.downsampler.decode(parcelFileDescriptor, i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull android.os.ParcelFileDescriptor parcelFileDescriptor, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return this.downsampler.handles(parcelFileDescriptor);
    }
}
