package com.google.android.exoplayer2.decoder;

/* loaded from: classes22.dex */
public class SimpleOutputBuffer extends com.google.android.exoplayer2.decoder.OutputBuffer {

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer data;
    public final com.google.android.exoplayer2.decoder.OutputBuffer.Owner<com.google.android.exoplayer2.decoder.SimpleOutputBuffer> n;

    public SimpleOutputBuffer(com.google.android.exoplayer2.decoder.OutputBuffer.Owner<com.google.android.exoplayer2.decoder.SimpleOutputBuffer> owner) {
        this.n = owner;
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        java.nio.ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public java.nio.ByteBuffer init(long j, int i) {
        this.timeUs = j;
        java.nio.ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.data = java.nio.ByteBuffer.allocateDirect(i).order(java.nio.ByteOrder.nativeOrder());
        }
        this.data.position(0);
        this.data.limit(i);
        return this.data;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public void release() {
        this.n.releaseOutputBuffer(this);
    }
}
