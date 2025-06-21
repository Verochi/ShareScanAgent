package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
public class GifDrawableLoadProvider implements com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> {
    private final com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> cacheDecoder;
    private final com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder decoder;
    private final com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceEncoder encoder;
    private final com.alimm.tanx.ui.image.glide.load.model.StreamEncoder sourceEncoder;

    public GifDrawableLoadProvider(android.content.Context context, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder gifResourceDecoder = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder(context, bitmapPool);
        this.decoder = gifResourceDecoder;
        this.cacheDecoder = new com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder<>(gifResourceDecoder);
        this.encoder = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceEncoder(bitmapPool);
        this.sourceEncoder = new com.alimm.tanx.ui.image.glide.load.model.StreamEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceEncoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> getEncoder() {
        return this.encoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> getSourceDecoder() {
        return this.decoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.Encoder<java.io.InputStream> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
