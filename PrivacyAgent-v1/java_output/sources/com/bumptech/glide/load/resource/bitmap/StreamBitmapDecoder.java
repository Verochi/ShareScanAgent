package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class StreamBitmapDecoder implements com.bumptech.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.Bitmap> {
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
    private final com.bumptech.glide.load.resource.bitmap.Downsampler downsampler;

    public static class UntrustedCallbacks implements com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks {
        private final com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream bufferedStream;
        private final com.bumptech.glide.util.ExceptionCatchingInputStream exceptionStream;

        public UntrustedCallbacks(com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream, com.bumptech.glide.util.ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.bufferedStream = recyclableBufferedInputStream;
            this.exceptionStream = exceptionCatchingInputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap) throws java.io.IOException {
            java.io.IOException exception = this.exceptionStream.getException();
            if (exception != null) {
                if (bitmap == null) {
                    throw exception;
                }
                bitmapPool.put(bitmap);
                throw exception;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
            this.bufferedStream.fixMarkLimit();
        }
    }

    public StreamBitmapDecoder(com.bumptech.glide.load.resource.bitmap.Downsampler downsampler, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.downsampler = downsampler;
        this.byteArrayPool = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(@androidx.annotation.NonNull java.io.InputStream inputStream, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(inputStream, this.byteArrayPool);
            z = true;
        }
        com.bumptech.glide.util.ExceptionCatchingInputStream obtain = com.bumptech.glide.util.ExceptionCatchingInputStream.obtain(recyclableBufferedInputStream);
        try {
            return this.downsampler.decode(new com.bumptech.glide.util.MarkEnforcingInputStream(obtain), i, i2, options, new com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder.UntrustedCallbacks(recyclableBufferedInputStream, obtain));
        } finally {
            obtain.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return this.downsampler.handles(inputStream);
    }
}
