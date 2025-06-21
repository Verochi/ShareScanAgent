package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class DrawableTransformation implements com.bumptech.glide.load.Transformation<android.graphics.drawable.Drawable> {
    private final boolean isRequired;
    private final com.bumptech.glide.load.Transformation<android.graphics.Bitmap> wrapped;

    public DrawableTransformation(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation, boolean z) {
        this.wrapped = transformation;
        this.isRequired = z;
    }

    private com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> newDrawableResource(android.content.Context context, com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource) {
        return com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource.obtain(context.getResources(), resource);
    }

    public com.bumptech.glide.load.Transformation<android.graphics.drawable.BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.load.resource.bitmap.DrawableTransformation) {
            return this.wrapped.equals(((com.bumptech.glide.load.resource.bitmap.DrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> transform(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> resource, int i, int i2) {
        com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool = com.bumptech.glide.Glide.get(context).getBitmapPool();
        android.graphics.drawable.Drawable drawable = resource.get();
        com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> convert = com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.convert(bitmapPool, drawable, i, i2);
        if (convert != null) {
            com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> transform = this.wrapped.transform(context, convert, i, i2);
            if (!transform.equals(convert)) {
                return newDrawableResource(context, transform);
            }
            transform.recycle();
            return resource;
        }
        if (!this.isRequired) {
            return resource;
        }
        throw new java.lang.IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
