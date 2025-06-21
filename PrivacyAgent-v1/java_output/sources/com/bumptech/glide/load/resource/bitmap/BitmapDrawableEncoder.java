package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class BitmapDrawableEncoder implements com.bumptech.glide.load.ResourceEncoder<android.graphics.drawable.BitmapDrawable> {
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.bumptech.glide.load.ResourceEncoder<android.graphics.Bitmap> encoder;

    public BitmapDrawableEncoder(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.ResourceEncoder<android.graphics.Bitmap> resourceEncoder) {
        this.bitmapPool = bitmapPool;
        this.encoder = resourceEncoder;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable> resource, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return this.encoder.encode(new com.bumptech.glide.load.resource.bitmap.BitmapResource(resource.get().getBitmap(), this.bitmapPool), file, options);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.EncodeStrategy getEncodeStrategy(@androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return this.encoder.getEncodeStrategy(options);
    }
}
