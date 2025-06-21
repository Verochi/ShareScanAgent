package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class SilenceSkippingAudioProcessor extends com.google.android.exoplayer2.audio.BaseAudioProcessor {
    public static final long DEFAULT_MINIMUM_SILENCE_DURATION_US = 150000;
    public static final long DEFAULT_PADDING_SILENCE_US = 20000;
    public static final short DEFAULT_SILENCE_THRESHOLD_LEVEL = 1024;
    public final long f;
    public final long g;
    public final short h;
    public int i;
    public boolean j;
    public byte[] k;
    public byte[] l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;

    public SilenceSkippingAudioProcessor() {
        this(DEFAULT_MINIMUM_SILENCE_DURATION_US, DEFAULT_PADDING_SILENCE_US, (short) 1024);
    }

    public SilenceSkippingAudioProcessor(long j, long j2, short s2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j2 <= j);
        this.f = j;
        this.g = j2;
        this.h = s2;
        byte[] bArr = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
        this.k = bArr;
        this.l = bArr;
    }

    public final int a(long j) {
        return (int) ((j * this.inputAudioFormat.sampleRate) / 1000000);
    }

    public final int b(java.nio.ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        do {
            limit -= 2;
            if (limit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (java.lang.Math.abs((int) byteBuffer.getShort(limit)) <= this.h);
        int i = this.i;
        return ((limit / i) * i) + i;
    }

    public final int c(java.nio.ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (java.lang.Math.abs((int) byteBuffer.getShort(position)) > this.h) {
                int i = this.i;
                return i * (position / i);
            }
        }
        return byteBuffer.limit();
    }

    public final void d(java.nio.ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        replaceOutputBuffer(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.p = true;
        }
    }

    public final void e(byte[] bArr, int i) {
        replaceOutputBuffer(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.p = true;
        }
    }

    public final void f(java.nio.ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int c = c(byteBuffer);
        int position = c - byteBuffer.position();
        byte[] bArr = this.k;
        int length = bArr.length;
        int i = this.n;
        int i2 = length - i;
        if (c < limit && position < i2) {
            e(bArr, i);
            this.n = 0;
            this.m = 0;
            return;
        }
        int min = java.lang.Math.min(position, i2);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.k, this.n, min);
        int i3 = this.n + min;
        this.n = i3;
        byte[] bArr2 = this.k;
        if (i3 == bArr2.length) {
            if (this.p) {
                e(bArr2, this.o);
                this.q += (this.n - (this.o * 2)) / this.i;
            } else {
                this.q += (i3 - this.o) / this.i;
            }
            i(byteBuffer, this.k, this.n);
            this.n = 0;
            this.m = 2;
        }
        byteBuffer.limit(limit);
    }

    public final void g(java.nio.ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(java.lang.Math.min(limit, byteBuffer.position() + this.k.length));
        int b = b(byteBuffer);
        if (b == byteBuffer.position()) {
            this.m = 1;
        } else {
            byteBuffer.limit(b);
            d(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    public long getSkippedFrames() {
        return this.q;
    }

    public final void h(java.nio.ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int c = c(byteBuffer);
        byteBuffer.limit(c);
        this.q += byteBuffer.remaining() / this.i;
        i(byteBuffer, this.l, this.o);
        if (c < limit) {
            e(this.l, this.o);
            this.m = 0;
            byteBuffer.limit(limit);
        }
    }

    public final void i(java.nio.ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = java.lang.Math.min(byteBuffer.remaining(), this.o);
        int i2 = this.o - min;
        java.lang.System.arraycopy(bArr, i - i2, this.l, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.l, i2, min);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat onConfigure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding == 2) {
            return this.j ? audioFormat : com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        if (this.j) {
            this.i = this.inputAudioFormat.bytesPerFrame;
            int a = a(this.f) * this.i;
            if (this.k.length != a) {
                this.k = new byte[a];
            }
            int a2 = a(this.g) * this.i;
            this.o = a2;
            if (this.l.length != a2) {
                this.l = new byte[a2];
            }
        }
        this.m = 0;
        this.q = 0L;
        this.n = 0;
        this.p = false;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        int i = this.n;
        if (i > 0) {
            e(this.k, i);
        }
        if (this.p) {
            return;
        }
        this.q += this.o / this.i;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.j = false;
        this.o = 0;
        byte[] bArr = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
        this.k = bArr;
        this.l = bArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !hasPendingOutput()) {
            int i = this.m;
            if (i == 0) {
                g(byteBuffer);
            } else if (i == 1) {
                f(byteBuffer);
            } else {
                if (i != 2) {
                    throw new java.lang.IllegalStateException();
                }
                h(byteBuffer);
            }
        }
    }

    public void setEnabled(boolean z) {
        this.j = z;
    }
}
