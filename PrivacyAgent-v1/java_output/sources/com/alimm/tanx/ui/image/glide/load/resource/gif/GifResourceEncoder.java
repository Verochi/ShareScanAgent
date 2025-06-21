package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
public class GifResourceEncoder implements com.alimm.tanx.ui.image.glide.load.ResourceEncoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> {
    private static final com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceEncoder.Factory FACTORY = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceEncoder.Factory();
    private static final java.lang.String TAG = "GifEncoder";
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceEncoder.Factory factory;
    private final com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider provider;

    public static class Factory {
        public com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder buildDecoder(com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider) {
            return new com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder(bitmapProvider);
        }

        public com.alimm.tanx.ui.image.glide.gifencoder.AnimatedGifEncoder buildEncoder() {
            return new com.alimm.tanx.ui.image.glide.gifencoder.AnimatedGifEncoder();
        }

        public com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> buildFrameResource(android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
            return new com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource(bitmap, bitmapPool);
        }

        public com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser buildParser() {
            return new com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser();
        }
    }

    public GifResourceEncoder(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this(bitmapPool, FACTORY);
    }

    public GifResourceEncoder(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceEncoder.Factory factory) {
        this.bitmapPool = bitmapPool;
        this.provider = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifBitmapProvider(bitmapPool);
        this.factory = factory;
    }

    private com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder decodeHeaders(byte[] bArr) {
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser buildParser = this.factory.buildParser();
        buildParser.setData(bArr);
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader parseHeader = buildParser.parseHeader();
        com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder buildDecoder = this.factory.buildDecoder(this.provider);
        buildDecoder.setData(parseHeader, bArr);
        buildDecoder.advance();
        return buildDecoder;
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> getTransformedFrame(android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable gifDrawable) {
        com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> buildFrameResource = this.factory.buildFrameResource(bitmap, this.bitmapPool);
        com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> transform = transformation.transform(buildFrameResource, gifDrawable.getIntrinsicWidth(), gifDrawable.getIntrinsicHeight());
        if (!buildFrameResource.equals(transform)) {
            buildFrameResource.recycle();
        }
        return transform;
    }

    private boolean writeDataDirect(byte[] bArr, java.io.OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resource, java.io.OutputStream outputStream) {
        long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable gifDrawable = resource.get();
        com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> frameTransformation = gifDrawable.getFrameTransformation();
        if (frameTransformation instanceof com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation) {
            return writeDataDirect(gifDrawable.getData(), outputStream);
        }
        com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder decodeHeaders = decodeHeaders(gifDrawable.getData());
        com.alimm.tanx.ui.image.glide.gifencoder.AnimatedGifEncoder buildEncoder = this.factory.buildEncoder();
        if (!buildEncoder.start(outputStream)) {
            return false;
        }
        for (int i = 0; i < decodeHeaders.getFrameCount(); i++) {
            com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> transformedFrame = getTransformedFrame(decodeHeaders.getNextFrame(), frameTransformation, gifDrawable);
            try {
                if (!buildEncoder.addFrame(transformedFrame.get())) {
                    return false;
                }
                buildEncoder.setDelay(decodeHeaders.getDelay(decodeHeaders.getCurrentFrameIndex()));
                decodeHeaders.advance();
                transformedFrame.recycle();
            } finally {
                transformedFrame.recycle();
            }
        }
        boolean finish = buildEncoder.finish();
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Encoded gif with ");
            tanxu_do2.append(decodeHeaders.getFrameCount());
            tanxu_do2.append(" frames and ");
            tanxu_do2.append(gifDrawable.getData().length);
            tanxu_do2.append(" bytes in ");
            tanxu_do2.append(com.alimm.tanx.ui.image.glide.util.LogTime.getElapsedMillis(logTime));
            tanxu_do2.append(" ms");
        }
        return finish;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public java.lang.String getId() {
        return "";
    }
}
