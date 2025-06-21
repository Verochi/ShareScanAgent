package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

/* loaded from: classes.dex */
public class GifBitmapWrapperStreamResourceDecoder implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> {
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> gifBitmapDecoder;

    public GifBitmapWrapperStreamResourceDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> resourceDecoder) {
        this.gifBitmapDecoder = resourceDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> decode(java.io.InputStream inputStream, int i, int i2) throws java.io.IOException {
        return this.gifBitmapDecoder.decode(new com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper(inputStream, null), i, i2);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        return this.gifBitmapDecoder.getId();
    }
}
