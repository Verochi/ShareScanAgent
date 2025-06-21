package com.alimm.tanx.ui.image.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class GifBitmapWrapperDrawableTranscoder implements com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> {
    private final com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable> bitmapDrawableResourceTranscoder;

    public GifBitmapWrapperDrawableTranscoder(com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable> resourceTranscoder) {
        this.bitmapDrawableResourceTranscoder = resourceTranscoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public java.lang.String getId() {
        return "GifBitmapWrapperDrawableTranscoder.com.alimm.tanx.ui.image.glide.load.resource.transcode";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> transcode(com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> resource) {
        com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper gifBitmapWrapper = resource.get();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> bitmapResource = gifBitmapWrapper.getBitmapResource();
        return bitmapResource != null ? this.bitmapDrawableResourceTranscoder.transcode(bitmapResource) : gifBitmapWrapper.getGifResource();
    }
}
