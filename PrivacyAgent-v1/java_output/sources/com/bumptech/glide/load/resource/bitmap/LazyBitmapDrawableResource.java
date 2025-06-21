package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public final class LazyBitmapDrawableResource implements com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable>, com.bumptech.glide.load.engine.Initializable {
    private final com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> bitmapResource;
    private final android.content.res.Resources resources;

    private LazyBitmapDrawableResource(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource) {
        this.resources = (android.content.res.Resources) com.bumptech.glide.util.Preconditions.checkNotNull(resources);
        this.bitmapResource = (com.bumptech.glide.load.engine.Resource) com.bumptech.glide.util.Preconditions.checkNotNull(resource);
    }

    @androidx.annotation.Nullable
    public static com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable> obtain(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.Nullable com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource(resources, resource);
    }

    @java.lang.Deprecated
    public static com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource obtain(android.content.Context context, android.graphics.Bitmap bitmap) {
        return (com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource) obtain(context.getResources(), com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(bitmap, com.bumptech.glide.Glide.get(context).getBitmapPool()));
    }

    @java.lang.Deprecated
    public static com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource obtain(android.content.res.Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap) {
        return (com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource) obtain(resources, com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(bitmap, bitmapPool));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public android.graphics.drawable.BitmapDrawable get() {
        return new android.graphics.drawable.BitmapDrawable(this.resources, this.bitmapResource.get());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public java.lang.Class<android.graphics.drawable.BitmapDrawable> getResourceClass() {
        return android.graphics.drawable.BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bitmapResource.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource = this.bitmapResource;
        if (resource instanceof com.bumptech.glide.load.engine.Initializable) {
            ((com.bumptech.glide.load.engine.Initializable) resource).initialize();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapResource.recycle();
    }
}
