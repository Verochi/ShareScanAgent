package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

/* loaded from: classes.dex */
public class GifBitmapWrapperResource implements com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> {
    private final com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper data;

    public GifBitmapWrapperResource(com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper gifBitmapWrapper) {
        if (gifBitmapWrapper == null) {
            throw new java.lang.NullPointerException("Data must not be null");
        }
        this.data = gifBitmapWrapper;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper get() {
        return this.data;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return this.data.getSize();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> bitmapResource = this.data.getBitmapResource();
        if (bitmapResource != null) {
            bitmapResource.recycle();
        }
        com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> gifResource = this.data.getGifResource();
        if (gifResource != null) {
            gifResource.recycle();
        }
    }
}
