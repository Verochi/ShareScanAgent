package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
interface LruPoolStrategy {
    @androidx.annotation.Nullable
    android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config);

    int getSize(android.graphics.Bitmap bitmap);

    java.lang.String logBitmap(int i, int i2, android.graphics.Bitmap.Config config);

    java.lang.String logBitmap(android.graphics.Bitmap bitmap);

    void put(android.graphics.Bitmap bitmap);

    @androidx.annotation.Nullable
    android.graphics.Bitmap removeLast();
}
