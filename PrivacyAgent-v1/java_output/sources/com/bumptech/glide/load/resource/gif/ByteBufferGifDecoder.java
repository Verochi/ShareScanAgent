package com.bumptech.glide.load.resource.gif;

/* loaded from: classes.dex */
public class ByteBufferGifDecoder implements com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, com.bumptech.glide.load.resource.gif.GifDrawable> {
    private static final com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifDecoderFactory GIF_DECODER_FACTORY = new com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifDecoderFactory();
    private static final com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifHeaderParserPool PARSER_POOL = new com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifHeaderParserPool();
    private static final java.lang.String TAG = "BufferGifDecoder";
    private final android.content.Context context;
    private final com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifDecoderFactory gifDecoderFactory;
    private final com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifHeaderParserPool parserPool;
    private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;
    private final com.bumptech.glide.load.resource.gif.GifBitmapProvider provider;

    @androidx.annotation.VisibleForTesting
    public static class GifDecoderFactory {
        public com.bumptech.glide.gifdecoder.GifDecoder build(com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider, com.bumptech.glide.gifdecoder.GifHeader gifHeader, java.nio.ByteBuffer byteBuffer, int i) {
            return new com.bumptech.glide.gifdecoder.StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
        }
    }

    @androidx.annotation.VisibleForTesting
    public static class GifHeaderParserPool {
        private final java.util.Queue<com.bumptech.glide.gifdecoder.GifHeaderParser> pool = com.bumptech.glide.util.Util.createQueue(0);

        public synchronized com.bumptech.glide.gifdecoder.GifHeaderParser obtain(java.nio.ByteBuffer byteBuffer) {
            com.bumptech.glide.gifdecoder.GifHeaderParser poll;
            poll = this.pool.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.gifdecoder.GifHeaderParser();
            }
            return poll.setData(byteBuffer);
        }

        public synchronized void release(com.bumptech.glide.gifdecoder.GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(android.content.Context context) {
        this(context, com.bumptech.glide.Glide.get(context).getRegistry().getImageHeaderParsers(), com.bumptech.glide.Glide.get(context).getBitmapPool(), com.bumptech.glide.Glide.get(context).getArrayPool());
    }

    public ByteBufferGifDecoder(android.content.Context context, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    @androidx.annotation.VisibleForTesting
    public ByteBufferGifDecoder(android.content.Context context, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifHeaderParserPool gifHeaderParserPool, com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifDecoderFactory gifDecoderFactory) {
        this.context = context.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory;
        this.provider = new com.bumptech.glide.load.resource.gif.GifBitmapProvider(bitmapPool, arrayPool);
        this.parserPool = gifHeaderParserPool;
    }

    @androidx.annotation.Nullable
    private com.bumptech.glide.load.resource.gif.GifDrawableResource decode(java.nio.ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.gifdecoder.GifHeaderParser gifHeaderParser, com.bumptech.glide.load.Options options) {
        long logTime = com.bumptech.glide.util.LogTime.getLogTime();
        try {
            com.bumptech.glide.gifdecoder.GifHeader parseHeader = gifHeaderParser.parseHeader();
            if (parseHeader.getNumFrames() > 0 && parseHeader.getStatus() == 0) {
                android.graphics.Bitmap.Config config = options.get(com.bumptech.glide.load.resource.gif.GifOptions.DECODE_FORMAT) == com.bumptech.glide.load.DecodeFormat.PREFER_RGB_565 ? android.graphics.Bitmap.Config.RGB_565 : android.graphics.Bitmap.Config.ARGB_8888;
                com.bumptech.glide.gifdecoder.GifDecoder build = this.gifDecoderFactory.build(this.provider, parseHeader, byteBuffer, getSampleSize(parseHeader, i, i2));
                build.setDefaultBitmapConfig(config);
                build.advance();
                android.graphics.Bitmap nextFrame = build.getNextFrame();
                if (nextFrame == null) {
                    return null;
                }
                com.bumptech.glide.load.resource.gif.GifDrawableResource gifDrawableResource = new com.bumptech.glide.load.resource.gif.GifDrawableResource(new com.bumptech.glide.load.resource.gif.GifDrawable(this.context, build, com.bumptech.glide.load.resource.UnitTransformation.get(), i, i2, nextFrame));
                if (android.util.Log.isLoggable(TAG, 2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Decoded GIF from stream in ");
                    sb.append(com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
                }
                return gifDrawableResource;
            }
            if (android.util.Log.isLoggable(TAG, 2)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Decoded GIF from stream in ");
                sb2.append(com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
            }
            return null;
        } finally {
            if (android.util.Log.isLoggable(TAG, 2)) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("Decoded GIF from stream in ");
                sb3.append(com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
            }
        }
    }

    private static int getSampleSize(com.bumptech.glide.gifdecoder.GifHeader gifHeader, int i, int i2) {
        int min = java.lang.Math.min(gifHeader.getHeight() / i2, gifHeader.getWidth() / i);
        int max = java.lang.Math.max(1, min == 0 ? 0 : java.lang.Integer.highestOneBit(min));
        if (android.util.Log.isLoggable(TAG, 2) && max > 1) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Downsampling GIF, sampleSize: ");
            sb.append(max);
            sb.append(", target dimens: [");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append("], actual dimens: [");
            sb.append(gifHeader.getWidth());
            sb.append("x");
            sb.append(gifHeader.getHeight());
            sb.append("]");
        }
        return max;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.resource.gif.GifDrawableResource decode(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        com.bumptech.glide.gifdecoder.GifHeaderParser obtain = this.parserPool.obtain(byteBuffer);
        try {
            return decode(byteBuffer, i, i2, obtain, options);
        } finally {
            this.parserPool.release(obtain);
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        return !((java.lang.Boolean) options.get(com.bumptech.glide.load.resource.gif.GifOptions.DISABLE_ANIMATION)).booleanValue() && com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, byteBuffer) == com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF;
    }
}
