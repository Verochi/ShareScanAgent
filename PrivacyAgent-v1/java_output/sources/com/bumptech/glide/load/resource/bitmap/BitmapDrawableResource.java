package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class BitmapDrawableResource extends com.bumptech.glide.load.resource.drawable.DrawableResource<android.graphics.drawable.BitmapDrawable> {
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public BitmapDrawableResource(android.graphics.drawable.BitmapDrawable bitmapDrawable, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        super(bitmapDrawable);
        this.bitmapPool = bitmapPool;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public java.lang.Class<android.graphics.drawable.BitmapDrawable> getResourceClass() {
        return android.graphics.drawable.BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return com.bumptech.glide.util.Util.getBitmapByteSize(((android.graphics.drawable.BitmapDrawable) this.drawable).getBitmap());
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        ((android.graphics.drawable.BitmapDrawable) this.drawable).getBitmap().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(((android.graphics.drawable.BitmapDrawable) this.drawable).getBitmap());
    }
}
