package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class BitmapResource implements com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> {
    private final android.graphics.Bitmap bitmap;
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public BitmapResource(android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        if (bitmap == null) {
            throw new java.lang.NullPointerException("Bitmap must not be null");
        }
        if (bitmapPool == null) {
            throw new java.lang.NullPointerException("BitmapPool must not be null");
        }
        this.bitmap = bitmap;
        this.bitmapPool = bitmapPool;
    }

    public static com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource obtain(android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource(bitmap, bitmapPool);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public android.graphics.Bitmap get() {
        return this.bitmap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(this.bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        if (this.bitmapPool.put(this.bitmap)) {
            return;
        }
        this.bitmap.recycle();
    }
}
