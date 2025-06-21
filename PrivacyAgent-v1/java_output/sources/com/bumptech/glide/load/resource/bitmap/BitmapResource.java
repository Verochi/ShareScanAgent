package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class BitmapResource implements com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap>, com.bumptech.glide.load.engine.Initializable {
    private final android.graphics.Bitmap bitmap;
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public BitmapResource(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.bitmap = (android.graphics.Bitmap) com.bumptech.glide.util.Preconditions.checkNotNull(bitmap, "Bitmap must not be null");
        this.bitmapPool = (com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool) com.bumptech.glide.util.Preconditions.checkNotNull(bitmapPool, "BitmapPool must not be null");
    }

    @androidx.annotation.Nullable
    public static com.bumptech.glide.load.resource.bitmap.BitmapResource obtain(@androidx.annotation.Nullable android.graphics.Bitmap bitmap, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new com.bumptech.glide.load.resource.bitmap.BitmapResource(bitmap, bitmapPool);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public android.graphics.Bitmap get() {
        return this.bitmap;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public java.lang.Class<android.graphics.Bitmap> getResourceClass() {
        return android.graphics.Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return com.bumptech.glide.util.Util.getBitmapByteSize(this.bitmap);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        this.bitmap.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }
}
