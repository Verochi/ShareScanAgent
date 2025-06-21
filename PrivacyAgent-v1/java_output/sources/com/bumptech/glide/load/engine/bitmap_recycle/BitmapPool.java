package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public interface BitmapPool {
    void clearMemory();

    @androidx.annotation.NonNull
    android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config);

    @androidx.annotation.NonNull
    android.graphics.Bitmap getDirty(int i, int i2, android.graphics.Bitmap.Config config);

    long getMaxSize();

    void put(android.graphics.Bitmap bitmap);

    void setSizeMultiplier(float f);

    void trimMemory(int i);
}
