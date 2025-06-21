package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
interface LruPoolStrategy {
    android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config);

    int getSize(android.graphics.Bitmap bitmap);

    java.lang.String logBitmap(int i, int i2, android.graphics.Bitmap.Config config);

    java.lang.String logBitmap(android.graphics.Bitmap bitmap);

    void put(android.graphics.Bitmap bitmap);

    android.graphics.Bitmap removeLast();
}
