package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public class BitmapPoolAdapter implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool {
    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config) {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public android.graphics.Bitmap getDirty(int i, int i2, android.graphics.Bitmap.Config config) {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public int getMaxSize() {
        return 0;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public boolean put(android.graphics.Bitmap bitmap) {
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void setSizeMultiplier(float f) {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int i) {
    }
}
