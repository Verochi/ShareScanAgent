package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class SonicAudioProcessor implements com.google.android.exoplayer2.audio.AudioProcessor {
    public static final int SAMPLE_RATE_NO_CHANGE = -1;
    public int a;
    public float b = 1.0f;
    public float c = 1.0f;
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat d;
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat e;
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat f;
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat g;
    public boolean h;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.audio.Sonic i;
    public java.nio.ByteBuffer j;
    public java.nio.ShortBuffer k;
    public java.nio.ByteBuffer l;
    public long m;
    public long n;
    public boolean o;

    public SonicAudioProcessor() {
        com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat = com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
        this.d = audioFormat;
        this.e = audioFormat;
        this.f = audioFormat;
        this.g = audioFormat;
        java.nio.ByteBuffer byteBuffer = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
        this.j = byteBuffer;
        this.k = byteBuffer.asShortBuffer();
        this.l = byteBuffer;
        this.a = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat configure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding != 2) {
            throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        int i = this.a;
        if (i == -1) {
            i = audioFormat.sampleRate;
        }
        this.d = audioFormat;
        com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat2 = new com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat(i, audioFormat.channelCount, 2);
        this.e = audioFormat2;
        this.h = true;
        return audioFormat2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat = this.d;
            this.f = audioFormat;
            com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat2 = this.e;
            this.g = audioFormat2;
            if (this.h) {
                this.i = new com.google.android.exoplayer2.audio.Sonic(audioFormat.sampleRate, audioFormat.channelCount, this.b, this.c, audioFormat2.sampleRate);
            } else {
                com.google.android.exoplayer2.audio.Sonic sonic = this.i;
                if (sonic != null) {
                    sonic.i();
                }
            }
        }
        this.l = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
        this.m = 0L;
        this.n = 0L;
        this.o = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public java.nio.ByteBuffer getOutput() {
        java.nio.ByteBuffer byteBuffer = this.l;
        this.l = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.e.sampleRate != -1 && (java.lang.Math.abs(this.b - 1.0f) >= 0.01f || java.lang.Math.abs(this.c - 1.0f) >= 0.01f || this.e.sampleRate != this.d.sampleRate);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        com.google.android.exoplayer2.audio.Sonic sonic;
        return this.o && ((sonic = this.i) == null || sonic.k() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        com.google.android.exoplayer2.audio.Sonic sonic = this.i;
        if (sonic != null) {
            sonic.r();
        }
        this.o = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        com.google.android.exoplayer2.audio.Sonic sonic = (com.google.android.exoplayer2.audio.Sonic) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.i);
        if (byteBuffer.hasRemaining()) {
            java.nio.ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.m += remaining;
            sonic.s(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int k = sonic.k();
        if (k > 0) {
            if (this.j.capacity() < k) {
                java.nio.ByteBuffer order = java.nio.ByteBuffer.allocateDirect(k).order(java.nio.ByteOrder.nativeOrder());
                this.j = order;
                this.k = order.asShortBuffer();
            } else {
                this.j.clear();
                this.k.clear();
            }
            sonic.j(this.k);
            this.n += k;
            this.j.limit(k);
            this.l = this.j;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.b = 1.0f;
        this.c = 1.0f;
        com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat = com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
        this.d = audioFormat;
        this.e = audioFormat;
        this.f = audioFormat;
        this.g = audioFormat;
        java.nio.ByteBuffer byteBuffer = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
        this.j = byteBuffer;
        this.k = byteBuffer.asShortBuffer();
        this.l = byteBuffer;
        this.a = -1;
        this.h = false;
        this.i = null;
        this.m = 0L;
        this.n = 0L;
        this.o = false;
    }

    public long scaleDurationForSpeedup(long j) {
        long j2 = this.n;
        if (j2 < 1024) {
            return (long) (this.b * j);
        }
        int i = this.g.sampleRate;
        int i2 = this.f.sampleRate;
        return i == i2 ? com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j, this.m, j2) : com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j, this.m * i, j2 * i2);
    }

    public void setOutputSampleRateHz(int i) {
        this.a = i;
    }

    public float setPitch(float f) {
        if (this.c != f) {
            this.c = f;
            this.h = true;
        }
        return f;
    }

    public float setSpeed(float f) {
        if (this.b != f) {
            this.b = f;
            this.h = true;
        }
        return f;
    }
}
