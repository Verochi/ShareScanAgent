package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class ImageVideoBitmapDecoder implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap> {
    private static final java.lang.String TAG = "ImageVideoDecoder";
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> fileDescriptorDecoder;
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.Bitmap> streamDecoder;

    public ImageVideoBitmapDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.Bitmap> resourceDecoder, com.alimm.tanx.ui.image.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> resourceDecoder2) {
        this.streamDecoder = resourceDecoder;
        this.fileDescriptorDecoder = resourceDecoder2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> decode(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper imageVideoWrapper, int i, int i2) throws java.io.IOException {
        com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> decode;
        android.os.ParcelFileDescriptor fileDescriptor;
        java.io.InputStream stream = imageVideoWrapper.getStream();
        if (stream != null) {
            try {
                decode = this.streamDecoder.decode(stream, i, i2);
            } catch (java.io.IOException unused) {
            }
            return (decode != null || (fileDescriptor = imageVideoWrapper.getFileDescriptor()) == null) ? decode : this.fileDescriptorDecoder.decode(fileDescriptor, i, i2);
        }
        decode = null;
        if (decode != null) {
            return decode;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        return "ImageVideoBitmapDecoder.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }
}
