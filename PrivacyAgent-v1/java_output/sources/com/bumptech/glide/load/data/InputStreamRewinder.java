package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public final class InputStreamRewinder implements com.bumptech.glide.load.data.DataRewinder<java.io.InputStream> {
    private static final int MARK_READ_LIMIT = 5242880;
    private final com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream bufferedStream;

    public static final class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory<java.io.InputStream> {
        private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;

        public Factory(com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.data.DataRewinder<java.io.InputStream> build(java.io.InputStream inputStream) {
            return new com.bumptech.glide.load.data.InputStreamRewinder(inputStream, this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @androidx.annotation.NonNull
        public java.lang.Class<java.io.InputStream> getDataClass() {
            return java.io.InputStream.class;
        }
    }

    public InputStreamRewinder(java.io.InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(inputStream, arrayPool);
        this.bufferedStream = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(MARK_READ_LIMIT);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
        this.bufferedStream.release();
    }

    public void fixMarkLimits() {
        this.bufferedStream.fixMarkLimit();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    @androidx.annotation.NonNull
    public java.io.InputStream rewindAndGet() throws java.io.IOException {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }
}
