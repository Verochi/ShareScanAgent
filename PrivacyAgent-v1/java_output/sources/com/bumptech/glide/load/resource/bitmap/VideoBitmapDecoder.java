package com.bumptech.glide.load.resource.bitmap;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class VideoBitmapDecoder extends com.bumptech.glide.load.resource.bitmap.VideoDecoder<android.os.ParcelFileDescriptor> {
    public VideoBitmapDecoder(android.content.Context context) {
        this(com.bumptech.glide.Glide.get(context).getBitmapPool());
    }

    public VideoBitmapDecoder(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        super(bitmapPool, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.ParcelFileDescriptorInitializer());
    }
}
