package com.bumptech.glide.load.resource.gif;

/* loaded from: classes.dex */
public class StreamGifDecoder implements com.bumptech.glide.load.ResourceDecoder<java.io.InputStream, com.bumptech.glide.load.resource.gif.GifDrawable> {
    private static final java.lang.String TAG = "StreamGifDecoder";
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
    private final com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, com.bumptech.glide.load.resource.gif.GifDrawable> byteBufferDecoder;
    private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;

    public StreamGifDecoder(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, com.bumptech.glide.load.resource.gif.GifDrawable> resourceDecoder, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.parsers = list;
        this.byteBufferDecoder = resourceDecoder;
        this.byteArrayPool = arrayPool;
    }

    private static byte[] inputStreamToBytes(java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<com.bumptech.glide.load.resource.gif.GifDrawable> decode(@androidx.annotation.NonNull java.io.InputStream inputStream, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        byte[] inputStreamToBytes = inputStreamToBytes(inputStream);
        if (inputStreamToBytes == null) {
            return null;
        }
        return this.byteBufferDecoder.decode(java.nio.ByteBuffer.wrap(inputStreamToBytes), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        return !((java.lang.Boolean) options.get(com.bumptech.glide.load.resource.gif.GifOptions.DISABLE_ANIMATION)).booleanValue() && com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool) == com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF;
    }
}
