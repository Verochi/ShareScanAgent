package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
final class FloatResamplingAudioProcessor extends com.google.android.exoplayer2.audio.BaseAudioProcessor {
    public static final int f = java.lang.Float.floatToIntBits(Float.NaN);

    public static void a(int i, java.nio.ByteBuffer byteBuffer) {
        int floatToIntBits = java.lang.Float.floatToIntBits((float) (i * 4.656612875245797E-10d));
        if (floatToIntBits == f) {
            floatToIntBits = java.lang.Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat onConfigure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException {
        int i = audioFormat.encoding;
        if (com.google.android.exoplayer2.util.Util.isEncodingHighResolutionPcm(i)) {
            return i != 4 ? new com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat(audioFormat.sampleRate, audioFormat.channelCount, 4) : com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        java.nio.ByteBuffer replaceOutputBuffer;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.inputAudioFormat.encoding;
        if (i2 == 536870912) {
            replaceOutputBuffer = replaceOutputBuffer((i / 3) * 4);
            while (position < limit) {
                a(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), replaceOutputBuffer);
                position += 3;
            }
        } else {
            if (i2 != 805306368) {
                throw new java.lang.IllegalStateException();
            }
            replaceOutputBuffer = replaceOutputBuffer(i);
            while (position < limit) {
                a((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), replaceOutputBuffer);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        replaceOutputBuffer.flip();
    }
}
