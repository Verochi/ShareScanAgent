package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

/* loaded from: classes.dex */
public class GifBitmapWrapperResourceEncoder implements com.alimm.tanx.ui.image.glide.load.ResourceEncoder<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> {
    private final com.alimm.tanx.ui.image.glide.load.ResourceEncoder<android.graphics.Bitmap> bitmapEncoder;
    private final com.alimm.tanx.ui.image.glide.load.ResourceEncoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> gifEncoder;
    private java.lang.String id;

    public GifBitmapWrapperResourceEncoder(com.alimm.tanx.ui.image.glide.load.ResourceEncoder<android.graphics.Bitmap> resourceEncoder, com.alimm.tanx.ui.image.glide.load.ResourceEncoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resourceEncoder2) {
        this.bitmapEncoder = resourceEncoder;
        this.gifEncoder = resourceEncoder2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> resource, java.io.OutputStream outputStream) {
        com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper gifBitmapWrapper = resource.get();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> bitmapResource = gifBitmapWrapper.getBitmapResource();
        return bitmapResource != null ? this.bitmapEncoder.encode(bitmapResource, outputStream) : this.gifEncoder.encode(gifBitmapWrapper.getGifResource(), outputStream);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public java.lang.String getId() {
        if (this.id == null) {
            this.id = this.bitmapEncoder.getId() + this.gifEncoder.getId();
        }
        return this.id;
    }
}
