package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class BitmapDrawableDecoder<DataType> implements com.bumptech.glide.load.ResourceDecoder<DataType, android.graphics.drawable.BitmapDrawable> {
    private final com.bumptech.glide.load.ResourceDecoder<DataType, android.graphics.Bitmap> decoder;
    private final android.content.res.Resources resources;

    public BitmapDrawableDecoder(android.content.Context context, com.bumptech.glide.load.ResourceDecoder<DataType, android.graphics.Bitmap> resourceDecoder) {
        this(context.getResources(), resourceDecoder);
    }

    public BitmapDrawableDecoder(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceDecoder<DataType, android.graphics.Bitmap> resourceDecoder) {
        this.resources = (android.content.res.Resources) com.bumptech.glide.util.Preconditions.checkNotNull(resources);
        this.decoder = (com.bumptech.glide.load.ResourceDecoder) com.bumptech.glide.util.Preconditions.checkNotNull(resourceDecoder);
    }

    @java.lang.Deprecated
    public BitmapDrawableDecoder(android.content.res.Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.ResourceDecoder<DataType, android.graphics.Bitmap> resourceDecoder) {
        this(resources, resourceDecoder);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable> decode(@androidx.annotation.NonNull DataType datatype, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        return com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource.obtain(this.resources, this.decoder.decode(datatype, i, i2, options));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull DataType datatype, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        return this.decoder.handles(datatype, options);
    }
}
