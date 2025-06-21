package com.bumptech.glide.load.resource.transcode;

/* loaded from: classes.dex */
public final class DrawableBytesTranscoder implements com.bumptech.glide.load.resource.transcode.ResourceTranscoder<android.graphics.drawable.Drawable, byte[]> {
    private final com.bumptech.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, byte[]> bitmapBytesTranscoder;
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.bumptech.glide.load.resource.transcode.ResourceTranscoder<com.bumptech.glide.load.resource.gif.GifDrawable, byte[]> gifDrawableBytesTranscoder;

    public DrawableBytesTranscoder(@androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, @androidx.annotation.NonNull com.bumptech.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, byte[]> resourceTranscoder, @androidx.annotation.NonNull com.bumptech.glide.load.resource.transcode.ResourceTranscoder<com.bumptech.glide.load.resource.gif.GifDrawable, byte[]> resourceTranscoder2) {
        this.bitmapPool = bitmapPool;
        this.bitmapBytesTranscoder = resourceTranscoder;
        this.gifDrawableBytesTranscoder = resourceTranscoder2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    private static com.bumptech.glide.load.engine.Resource<com.bumptech.glide.load.resource.gif.GifDrawable> toGifDrawableResource(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> resource) {
        return resource;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<byte[]> transcode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> resource, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        android.graphics.drawable.Drawable drawable = resource.get();
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            return this.bitmapBytesTranscoder.transcode(com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(((android.graphics.drawable.BitmapDrawable) drawable).getBitmap(), this.bitmapPool), options);
        }
        if (drawable instanceof com.bumptech.glide.load.resource.gif.GifDrawable) {
            return this.gifDrawableBytesTranscoder.transcode(toGifDrawableResource(resource), options);
        }
        return null;
    }
}
