package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
class GifFrameResourceDecoder implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, android.graphics.Bitmap> {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public GifFrameResourceDecoder(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> decode(com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder, int i, int i2) {
        return com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource.obtain(gifDecoder.getNextFrame(), this.bitmapPool);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        return "GifFrameResourceDecoder.com.alimm.tanx.ui.image.glide.load.resource.gif";
    }
}
