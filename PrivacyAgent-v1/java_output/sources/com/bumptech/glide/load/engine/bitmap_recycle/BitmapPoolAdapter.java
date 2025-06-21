package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public class BitmapPoolAdapter implements com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool {
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @androidx.annotation.NonNull
    public android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config) {
        return android.graphics.Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @androidx.annotation.NonNull
    public android.graphics.Bitmap getDirty(int i, int i2, android.graphics.Bitmap.Config config) {
        return get(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void put(android.graphics.Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void setSizeMultiplier(float f) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int i) {
    }
}
