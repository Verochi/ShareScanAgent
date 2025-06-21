package com.bumptech.glide.load.resource.bytes;

/* loaded from: classes.dex */
public class ByteBufferRewinder implements com.bumptech.glide.load.data.DataRewinder<java.nio.ByteBuffer> {
    private final java.nio.ByteBuffer buffer;

    public static class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory<java.nio.ByteBuffer> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.data.DataRewinder<java.nio.ByteBuffer> build(java.nio.ByteBuffer byteBuffer) {
            return new com.bumptech.glide.load.resource.bytes.ByteBufferRewinder(byteBuffer);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @androidx.annotation.NonNull
        public java.lang.Class<java.nio.ByteBuffer> getDataClass() {
            return java.nio.ByteBuffer.class;
        }
    }

    public ByteBufferRewinder(java.nio.ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    @androidx.annotation.NonNull
    public java.nio.ByteBuffer rewindAndGet() {
        this.buffer.position(0);
        return this.buffer;
    }
}
