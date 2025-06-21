package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class BitmapDrawableResource extends com.alimm.tanx.ui.image.glide.load.resource.drawable.DrawableResource<android.graphics.drawable.BitmapDrawable> {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public BitmapDrawableResource(android.graphics.drawable.BitmapDrawable bitmapDrawable, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        super(bitmapDrawable);
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(((android.graphics.drawable.BitmapDrawable) this.drawable).getBitmap());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(((android.graphics.drawable.BitmapDrawable) this.drawable).getBitmap());
    }
}
