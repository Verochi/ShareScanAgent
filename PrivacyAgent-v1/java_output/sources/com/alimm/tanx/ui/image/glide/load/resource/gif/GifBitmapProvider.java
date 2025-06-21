package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
class GifBitmapProvider implements com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public GifBitmapProvider(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider
    public android.graphics.Bitmap obtain(int i, int i2, android.graphics.Bitmap.Config config) {
        return this.bitmapPool.getDirty(i, i2, config);
    }

    @Override // com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(android.graphics.Bitmap bitmap) {
        if (this.bitmapPool.put(bitmap)) {
            return;
        }
        bitmap.recycle();
    }
}
