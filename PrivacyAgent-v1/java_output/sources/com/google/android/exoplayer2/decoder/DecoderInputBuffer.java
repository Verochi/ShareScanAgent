package com.google.android.exoplayer2.decoder;

/* loaded from: classes22.dex */
public class DecoderInputBuffer extends com.google.android.exoplayer2.decoder.Buffer {
    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    public final com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo;

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer data;
    public final int n;

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer supplementalData;
    public final int t;
    public long timeUs;
    public boolean waitingForKeys;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    public DecoderInputBuffer(int i) {
        this(i, 0);
    }

    public DecoderInputBuffer(int i, int i2) {
        this.cryptoInfo = new com.google.android.exoplayer2.decoder.CryptoInfo();
        this.n = i;
        this.t = i2;
    }

    public static com.google.android.exoplayer2.decoder.DecoderInputBuffer newFlagsOnlyInstance() {
        return new com.google.android.exoplayer2.decoder.DecoderInputBuffer(0);
    }

    public final java.nio.ByteBuffer a(int i) {
        int i2 = this.n;
        if (i2 == 1) {
            return java.nio.ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return java.nio.ByteBuffer.allocateDirect(i);
        }
        java.nio.ByteBuffer byteBuffer = this.data;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new java.lang.IllegalStateException(sb.toString());
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        java.nio.ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        java.nio.ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.waitingForKeys = false;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"data"})
    public void ensureSpaceForWrite(int i) {
        int i2 = i + this.t;
        java.nio.ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            this.data = a(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i3 = i2 + position;
        if (capacity >= i3) {
            this.data = byteBuffer;
            return;
        }
        java.nio.ByteBuffer a = a(i3);
        a.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            a.put(byteBuffer);
        }
        this.data = a;
    }

    public final void flip() {
        java.nio.ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        java.nio.ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean isEncrypted() {
        return getFlag(1073741824);
    }

    public final boolean isFlagsOnly() {
        return this.data == null && this.n == 0;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"supplementalData"})
    public void resetSupplementalData(int i) {
        java.nio.ByteBuffer byteBuffer = this.supplementalData;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.supplementalData = java.nio.ByteBuffer.allocate(i);
        } else {
            this.supplementalData.clear();
        }
    }
}
