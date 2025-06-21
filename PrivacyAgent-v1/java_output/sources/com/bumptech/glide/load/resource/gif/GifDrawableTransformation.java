package com.bumptech.glide.load.resource.gif;

/* loaded from: classes.dex */
public class GifDrawableTransformation implements com.bumptech.glide.load.Transformation<com.bumptech.glide.load.resource.gif.GifDrawable> {
    private final com.bumptech.glide.load.Transformation<android.graphics.Bitmap> wrapped;

    public GifDrawableTransformation(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        this.wrapped = (com.bumptech.glide.load.Transformation) com.bumptech.glide.util.Preconditions.checkNotNull(transformation);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.load.resource.gif.GifDrawableTransformation) {
            return this.wrapped.equals(((com.bumptech.glide.load.resource.gif.GifDrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.engine.Resource<com.bumptech.glide.load.resource.gif.GifDrawable> transform(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<com.bumptech.glide.load.resource.gif.GifDrawable> resource, int i, int i2) {
        com.bumptech.glide.load.resource.gif.GifDrawable gifDrawable = resource.get();
        com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> bitmapResource = new com.bumptech.glide.load.resource.bitmap.BitmapResource(gifDrawable.getFirstFrame(), com.bumptech.glide.Glide.get(context).getBitmapPool());
        com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> transform = this.wrapped.transform(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(transform)) {
            bitmapResource.recycle();
        }
        gifDrawable.setFrameTransformation(this.wrapped, transform.get());
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
