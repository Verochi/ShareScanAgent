package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
final class ResamplingAudioProcessor extends com.google.android.exoplayer2.audio.BaseAudioProcessor {
    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat onConfigure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException {
        int i = audioFormat.encoding;
        if (i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4) {
            return i != 2 ? new com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat(audioFormat.sampleRate, audioFormat.channelCount, 2) : com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0 A[ADDED_TO_REGION, LOOP:4: B:33:0x00b0->B:34:0x00b2, LOOP_START, PHI: r0
  0x00b0: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:12:0x0037, B:34:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.inputAudioFormat.encoding;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 268435456) {
                    if (i3 == 536870912) {
                        i2 /= 3;
                    } else if (i3 != 805306368) {
                        throw new java.lang.IllegalStateException();
                    }
                }
                java.nio.ByteBuffer replaceOutputBuffer = replaceOutputBuffer(i2);
                i = this.inputAudioFormat.encoding;
                if (i == 3) {
                    while (position < limit) {
                        replaceOutputBuffer.put((byte) 0);
                        replaceOutputBuffer.put((byte) ((byteBuffer.get(position) & 255) + com.alipay.sdk.m.n.a.g));
                        position++;
                    }
                } else if (i == 4) {
                    while (position < limit) {
                        short constrainValue = (short) (com.google.android.exoplayer2.util.Util.constrainValue(byteBuffer.getFloat(position), -1.0f, 1.0f) * 32767.0f);
                        replaceOutputBuffer.put((byte) (constrainValue & 255));
                        replaceOutputBuffer.put((byte) ((constrainValue >> 8) & 255));
                        position += 4;
                    }
                } else if (i == 268435456) {
                    while (position < limit) {
                        replaceOutputBuffer.put(byteBuffer.get(position + 1));
                        replaceOutputBuffer.put(byteBuffer.get(position));
                        position += 2;
                    }
                } else if (i == 536870912) {
                    while (position < limit) {
                        replaceOutputBuffer.put(byteBuffer.get(position + 1));
                        replaceOutputBuffer.put(byteBuffer.get(position + 2));
                        position += 3;
                    }
                } else {
                    if (i != 805306368) {
                        throw new java.lang.IllegalStateException();
                    }
                    while (position < limit) {
                        replaceOutputBuffer.put(byteBuffer.get(position + 2));
                        replaceOutputBuffer.put(byteBuffer.get(position + 3));
                        position += 4;
                    }
                }
                byteBuffer.position(byteBuffer.limit());
                replaceOutputBuffer.flip();
            }
            i2 /= 2;
            java.nio.ByteBuffer replaceOutputBuffer2 = replaceOutputBuffer(i2);
            i = this.inputAudioFormat.encoding;
            if (i == 3) {
            }
            byteBuffer.position(byteBuffer.limit());
            replaceOutputBuffer2.flip();
        }
        i2 *= 2;
        java.nio.ByteBuffer replaceOutputBuffer22 = replaceOutputBuffer(i2);
        i = this.inputAudioFormat.encoding;
        if (i == 3) {
        }
        byteBuffer.position(byteBuffer.limit());
        replaceOutputBuffer22.flip();
    }
}
