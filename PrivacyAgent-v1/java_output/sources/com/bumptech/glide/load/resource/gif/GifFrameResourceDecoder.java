package com.bumptech.glide.load.resource.gif;

/* loaded from: classes.dex */
public final class GifFrameResourceDecoder implements com.bumptech.glide.load.ResourceDecoder<com.bumptech.glide.gifdecoder.GifDecoder, android.graphics.Bitmap> {
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public GifFrameResourceDecoder(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifDecoder gifDecoder, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(gifDecoder.getNextFrame(), this.bitmapPool);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifDecoder gifDecoder, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return true;
    }
}
