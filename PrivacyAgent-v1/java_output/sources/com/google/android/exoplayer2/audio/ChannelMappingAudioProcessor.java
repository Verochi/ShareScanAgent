package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
final class ChannelMappingAudioProcessor extends com.google.android.exoplayer2.audio.BaseAudioProcessor {

    @androidx.annotation.Nullable
    public int[] f;

    @androidx.annotation.Nullable
    public int[] g;

    public void a(@androidx.annotation.Nullable int[] iArr) {
        this.f = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat onConfigure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f;
        if (iArr == null) {
            return com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
        }
        if (audioFormat.encoding != 2) {
            throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        boolean z = audioFormat.channelCount != iArr.length;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            if (i2 >= audioFormat.channelCount) {
                throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException(audioFormat);
            }
            z |= i2 != i;
            i++;
        }
        return z ? new com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat(audioFormat.sampleRate, iArr.length, 2) : com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        this.g = this.f;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.g = null;
        this.f = null;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        int[] iArr = (int[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.g);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        java.nio.ByteBuffer replaceOutputBuffer = replaceOutputBuffer(((limit - position) / this.inputAudioFormat.bytesPerFrame) * this.outputAudioFormat.bytesPerFrame);
        while (position < limit) {
            for (int i : iArr) {
                replaceOutputBuffer.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.inputAudioFormat.bytesPerFrame;
        }
        byteBuffer.position(limit);
        replaceOutputBuffer.flip();
    }
}
