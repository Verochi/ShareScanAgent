package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public interface BitmapPool {
    void clearMemory();

    android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config);

    android.graphics.Bitmap getDirty(int i, int i2, android.graphics.Bitmap.Config config);

    int getMaxSize();

    boolean put(android.graphics.Bitmap bitmap);

    void setSizeMultiplier(float f);

    void trimMemory(int i);
}
