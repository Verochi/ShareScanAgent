package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class GlideBitmapDrawableResource extends com.alimm.tanx.ui.image.glide.load.resource.drawable.DrawableResource<com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable> {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public GlideBitmapDrawableResource(com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable glideBitmapDrawable, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        super(glideBitmapDrawable);
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(((com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable) this.drawable).getBitmap());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(((com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable) this.drawable).getBitmap());
    }
}
