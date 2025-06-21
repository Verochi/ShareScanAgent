package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

/* loaded from: classes.dex */
public class GifBitmapWrapperResourceDecoder implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> {
    private static final com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder.ImageTypeParser DEFAULT_PARSER = new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder.ImageTypeParser();
    private static final com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder.BufferedStreamFactory DEFAULT_STREAM_FACTORY = new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder.BufferedStreamFactory();
    static final int MARK_LIMIT_BYTES = 2048;
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap> bitmapDecoder;
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> gifDecoder;
    private java.lang.String id;
    private final com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder.ImageTypeParser parser;
    private final com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder.BufferedStreamFactory streamFactory;

    public static class BufferedStreamFactory {
        public java.io.InputStream build(java.io.InputStream inputStream, byte[] bArr) {
            return new com.alimm.tanx.ui.image.glide.load.resource.bitmap.RecyclableBufferedInputStream(inputStream, bArr);
        }
    }

    public static class ImageTypeParser {
        public com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType parse(java.io.InputStream inputStream) throws java.io.IOException {
            return new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser(inputStream).getType();
        }
    }

    public GifBitmapWrapperResourceDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap> resourceDecoder, com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resourceDecoder2, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this(resourceDecoder, resourceDecoder2, bitmapPool, DEFAULT_PARSER, DEFAULT_STREAM_FACTORY);
    }

    public GifBitmapWrapperResourceDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap> resourceDecoder, com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resourceDecoder2, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder.ImageTypeParser imageTypeParser, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResourceDecoder.BufferedStreamFactory bufferedStreamFactory) {
        this.bitmapDecoder = resourceDecoder;
        this.gifDecoder = resourceDecoder2;
        this.bitmapPool = bitmapPool;
        this.parser = imageTypeParser;
        this.streamFactory = bufferedStreamFactory;
    }

    private com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper decode(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper imageVideoWrapper, int i, int i2, byte[] bArr) throws java.io.IOException {
        return imageVideoWrapper.getStream() != null ? decodeStream(imageVideoWrapper, i, i2, bArr) : decodeBitmapWrapper(imageVideoWrapper, i, i2);
    }

    private com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper decodeBitmapWrapper(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper imageVideoWrapper, int i, int i2) throws java.io.IOException {
        com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> decode = this.bitmapDecoder.decode(imageVideoWrapper, i, i2);
        if (decode != null) {
            return new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper(decode, null);
        }
        return null;
    }

    private com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper decodeGifWrapper(java.io.InputStream inputStream, int i, int i2) throws java.io.IOException {
        com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> decode = this.gifDecoder.decode(inputStream, i, i2);
        if (decode == null) {
            return null;
        }
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable gifDrawable = decode.get();
        return gifDrawable.getFrameCount() > 1 ? new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper(null, decode) : new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper(new com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource(gifDrawable.getFirstFrame(), this.bitmapPool), null);
    }

    private com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper decodeStream(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper imageVideoWrapper, int i, int i2, byte[] bArr) throws java.io.IOException {
        java.io.InputStream build = this.streamFactory.build(imageVideoWrapper.getStream(), bArr);
        build.mark(2048);
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType parse = this.parser.parse(build);
        build.reset();
        com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper decodeGifWrapper = parse == com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType.GIF ? decodeGifWrapper(build, i, i2) : null;
        return decodeGifWrapper == null ? decodeBitmapWrapper(new com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper(build, imageVideoWrapper.getFileDescriptor()), i, i2) : decodeGifWrapper;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> decode(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper imageVideoWrapper, int i, int i2) throws java.io.IOException {
        com.alimm.tanx.ui.image.glide.util.ByteArrayPool byteArrayPool = com.alimm.tanx.ui.image.glide.util.ByteArrayPool.get();
        byte[] bytes = byteArrayPool.getBytes();
        try {
            com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper decode = decode(imageVideoWrapper, i, i2, bytes);
            if (decode != null) {
                return new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResource(decode);
            }
            return null;
        } finally {
            byteArrayPool.releaseBytes(bytes);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        if (this.id == null) {
            this.id = this.gifDecoder.getId() + this.bitmapDecoder.getId();
        }
        return this.id;
    }
}
