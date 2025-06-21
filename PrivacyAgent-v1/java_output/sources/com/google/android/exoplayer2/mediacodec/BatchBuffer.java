package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
final class BatchBuffer extends com.google.android.exoplayer2.decoder.DecoderInputBuffer {
    public final com.google.android.exoplayer2.decoder.DecoderInputBuffer u;
    public boolean v;
    public long w;
    public int x;
    public int y;

    public BatchBuffer() {
        super(2);
        this.u = new com.google.android.exoplayer2.decoder.DecoderInputBuffer(2);
        clear();
    }

    public void b() {
        d();
        if (this.v) {
            m(this.u);
            this.v = false;
        }
    }

    public final boolean c(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) {
        java.nio.ByteBuffer byteBuffer;
        if (k()) {
            return true;
        }
        if (decoderInputBuffer.isDecodeOnly() != isDecodeOnly()) {
            return false;
        }
        java.nio.ByteBuffer byteBuffer2 = decoderInputBuffer.data;
        return byteBuffer2 == null || (byteBuffer = this.data) == null || byteBuffer.position() + byteBuffer2.limit() < 3072000;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        f();
        this.y = 32;
    }

    public final void d() {
        super.clear();
        this.x = 0;
        this.w = -9223372036854775807L;
        this.timeUs = -9223372036854775807L;
    }

    public void e() {
        com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer = this.u;
        boolean z = false;
        com.google.android.exoplayer2.util.Assertions.checkState((l() || isEndOfStream()) ? false : true);
        if (!decoderInputBuffer.isEncrypted() && !decoderInputBuffer.hasSupplementalData()) {
            z = true;
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(z);
        if (c(decoderInputBuffer)) {
            m(decoderInputBuffer);
        } else {
            this.v = true;
        }
    }

    public void f() {
        d();
        this.u.clear();
        this.v = false;
    }

    public int g() {
        return this.x;
    }

    public long h() {
        return this.w;
    }

    public long i() {
        return this.timeUs;
    }

    public com.google.android.exoplayer2.decoder.DecoderInputBuffer j() {
        return this.u;
    }

    public boolean k() {
        return this.x == 0;
    }

    public boolean l() {
        java.nio.ByteBuffer byteBuffer;
        return this.x >= this.y || ((byteBuffer = this.data) != null && byteBuffer.position() >= 3072000) || this.v;
    }

    public final void m(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) {
        java.nio.ByteBuffer byteBuffer = decoderInputBuffer.data;
        if (byteBuffer != null) {
            decoderInputBuffer.flip();
            ensureSpaceForWrite(byteBuffer.remaining());
            this.data.put(byteBuffer);
        }
        if (decoderInputBuffer.isEndOfStream()) {
            setFlags(4);
        }
        if (decoderInputBuffer.isDecodeOnly()) {
            setFlags(Integer.MIN_VALUE);
        }
        if (decoderInputBuffer.isKeyFrame()) {
            setFlags(1);
        }
        int i = this.x + 1;
        this.x = i;
        long j = decoderInputBuffer.timeUs;
        this.timeUs = j;
        if (i == 1) {
            this.w = j;
        }
        decoderInputBuffer.clear();
    }

    public void n(@androidx.annotation.IntRange(from = 1) int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i > 0);
        this.y = i;
    }
}
