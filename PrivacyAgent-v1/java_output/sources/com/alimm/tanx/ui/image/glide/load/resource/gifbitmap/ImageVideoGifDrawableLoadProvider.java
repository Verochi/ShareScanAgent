package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

/* loaded from: classes.dex */
public class ImageVideoGifDrawableLoadProvider implements com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> {
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> cacheDecoder;
    private final com.alimm.tanx.ui.image.glide.load.ResourceEncoder<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> encoder;
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> sourceDecoder;
    private final com.alimm.tanx.ui.image.glide.load.Encoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> sourceEncoder;

    public ImageVideoGifDrawableLoadProvider(com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap> dataLoadProvider, com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> dataLoadProvider2, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder gifBitmapWrapperResourceDecoder = new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder(dataLoadProvider.getSourceDecoder(), dataLoadProvider2.getSourceDecoder(), bitmapPool);
        this.cacheDecoder = new com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder(new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperStreamResourceDecoder(gifBitmapWrapperResourceDecoder));
        this.sourceDecoder = gifBitmapWrapperResourceDecoder;
        this.encoder = new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceEncoder(dataLoadProvider.getEncoder(), dataLoadProvider2.getEncoder());
        this.sourceEncoder = dataLoadProvider.getSourceEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceEncoder<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> getEncoder() {
        return this.encoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> getSourceDecoder() {
        return this.sourceDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.Encoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
