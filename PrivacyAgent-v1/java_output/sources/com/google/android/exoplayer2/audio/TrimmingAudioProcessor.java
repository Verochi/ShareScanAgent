package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
final class TrimmingAudioProcessor extends com.google.android.exoplayer2.audio.BaseAudioProcessor {
    public int f;
    public int g;
    public boolean h;
    public int i;
    public byte[] j = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    public int k;
    public long l;

    public long a() {
        return this.l;
    }

    public void b() {
        this.l = 0L;
    }

    public void c(int i, int i2) {
        this.f = i;
        this.g = i2;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public java.nio.ByteBuffer getOutput() {
        int i;
        if (super.isEnded() && (i = this.k) > 0) {
            replaceOutputBuffer(i).put(this.j, 0, this.k).flip();
            this.k = 0;
        }
        return super.getOutput();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.k == 0;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat onConfigure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding != 2) {
            throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        this.h = true;
        return (this.f == 0 && this.g == 0) ? com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET : audioFormat;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        if (this.h) {
            this.h = false;
            int i = this.g;
            int i2 = this.inputAudioFormat.bytesPerFrame;
            this.j = new byte[i * i2];
            this.i = this.f * i2;
        }
        this.k = 0;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        if (this.h) {
            if (this.k > 0) {
                this.l += r0 / this.inputAudioFormat.bytesPerFrame;
            }
            this.k = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.j = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i == 0) {
            return;
        }
        int min = java.lang.Math.min(i, this.i);
        this.l += min / this.inputAudioFormat.bytesPerFrame;
        this.i -= min;
        byteBuffer.position(position + min);
        if (this.i > 0) {
            return;
        }
        int i2 = i - min;
        int length = (this.k + i2) - this.j.length;
        java.nio.ByteBuffer replaceOutputBuffer = replaceOutputBuffer(length);
        int constrainValue = com.google.android.exoplayer2.util.Util.constrainValue(length, 0, this.k);
        replaceOutputBuffer.put(this.j, 0, constrainValue);
        int constrainValue2 = com.google.android.exoplayer2.util.Util.constrainValue(length - constrainValue, 0, i2);
        byteBuffer.limit(byteBuffer.position() + constrainValue2);
        replaceOutputBuffer.put(byteBuffer);
        byteBuffer.limit(limit);
        int i3 = i2 - constrainValue2;
        int i4 = this.k - constrainValue;
        this.k = i4;
        byte[] bArr = this.j;
        java.lang.System.arraycopy(bArr, constrainValue, bArr, 0, i4);
        byteBuffer.get(this.j, this.k, i3);
        this.k += i3;
        replaceOutputBuffer.flip();
    }
}
