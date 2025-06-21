package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
public class GifResourceDecoder implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> {
    private static final java.lang.String TAG = "GifResourceDecoder";
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final android.content.Context context;
    private final com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder.GifDecoderPool decoderPool;
    private final com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder.GifHeaderParserPool parserPool;
    private final com.alimm.tanx.ui.image.glide.load.resource.gif.GifBitmapProvider provider;
    private static final com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder.GifHeaderParserPool PARSER_POOL = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder.GifHeaderParserPool();
    private static final com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder.GifDecoderPool DECODER_POOL = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder.GifDecoderPool();

    public static class GifDecoderPool {
        private final java.util.Queue<com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder> pool = com.alimm.tanx.ui.image.glide.util.Util.createQueue(0);

        public synchronized com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder obtain(com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider) {
            com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder poll;
            poll = this.pool.poll();
            if (poll == null) {
                poll = new com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder(bitmapProvider);
            }
            return poll;
        }

        public synchronized void release(com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder) {
            gifDecoder.clear();
            this.pool.offer(gifDecoder);
        }
    }

    public static class GifHeaderParserPool {
        private final java.util.Queue<com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser> pool = com.alimm.tanx.ui.image.glide.util.Util.createQueue(0);

        public synchronized com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser obtain(byte[] bArr) {
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser poll;
            poll = this.pool.poll();
            if (poll == null) {
                poll = new com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser();
            }
            return poll.setData(bArr);
        }

        public synchronized void release(com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }

    public GifResourceDecoder(android.content.Context context) {
        this(context, com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool());
    }

    public GifResourceDecoder(android.content.Context context, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this(context, bitmapPool, PARSER_POOL, DECODER_POOL);
    }

    public GifResourceDecoder(android.content.Context context, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder.GifHeaderParserPool gifHeaderParserPool, com.alimm.tanx.ui.image.glide.load.resource.gif.GifResourceDecoder.GifDecoderPool gifDecoderPool) {
        this.context = context.getApplicationContext();
        this.bitmapPool = bitmapPool;
        this.decoderPool = gifDecoderPool;
        this.provider = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifBitmapProvider(bitmapPool);
        this.parserPool = gifHeaderParserPool;
    }

    private com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableResource decode(byte[] bArr, int i, int i2, com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser gifHeaderParser, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder) {
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader parseHeader = gifHeaderParser.parseHeader();
        if (parseHeader.getNumFrames() <= 0 || parseHeader.getStatus() != 0) {
            return null;
        }
        gifDecoder.setData(parseHeader, bArr);
        gifDecoder.advance();
        android.graphics.Bitmap nextFrame = gifDecoder.getNextFrame();
        if (nextFrame == null) {
            return null;
        }
        return new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableResource(new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable(this.context, this.provider, this.bitmapPool, com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation.get(), i, i2, parseHeader, bArr, nextFrame));
    }

    private android.graphics.Bitmap decodeFirstFrame(com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder, com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader, byte[] bArr) {
        gifDecoder.setData(gifHeader, bArr);
        gifDecoder.advance();
        return gifDecoder.getNextFrame();
    }

    private static byte[] inputStreamToBytes(java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (java.io.IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableResource decode(java.io.InputStream inputStream, int i, int i2) {
        byte[] inputStreamToBytes = inputStreamToBytes(inputStream);
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser obtain = this.parserPool.obtain(inputStreamToBytes);
        com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder obtain2 = this.decoderPool.obtain(this.provider);
        try {
            return decode(inputStreamToBytes, i, i2, obtain, obtain2);
        } finally {
            this.parserPool.release(obtain);
            this.decoderPool.release(obtain2);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        return "";
    }
}
