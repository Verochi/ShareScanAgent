package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class TeeAudioProcessor extends com.google.android.exoplayer2.audio.BaseAudioProcessor {
    public final com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink f;

    public interface AudioBufferSink {
        void flush(int i, int i2, int i3);

        void handleBuffer(java.nio.ByteBuffer byteBuffer);
    }

    public static final class WavFileAudioBufferSink implements com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink {
        public final java.lang.String a;
        public final byte[] b;
        public final java.nio.ByteBuffer c;
        public int d;
        public int e;
        public int f;

        @androidx.annotation.Nullable
        public java.io.RandomAccessFile g;
        public int h;
        public int i;

        public WavFileAudioBufferSink(java.lang.String str) {
            this.a = str;
            byte[] bArr = new byte[1024];
            this.b = bArr;
            this.c = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        }

        public final java.lang.String a() {
            int i = this.h;
            this.h = i + 1;
            return com.google.android.exoplayer2.util.Util.formatInvariant("%s-%04d.wav", this.a, java.lang.Integer.valueOf(i));
        }

        public final void b() throws java.io.IOException {
            if (this.g != null) {
                return;
            }
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(a(), "rw");
            e(randomAccessFile);
            this.g = randomAccessFile;
            this.i = 44;
        }

        public final void c() throws java.io.IOException {
            java.io.RandomAccessFile randomAccessFile = this.g;
            if (randomAccessFile == null) {
                return;
            }
            try {
                this.c.clear();
                this.c.putInt(this.i - 8);
                randomAccessFile.seek(4L);
                randomAccessFile.write(this.b, 0, 4);
                this.c.clear();
                this.c.putInt(this.i - 44);
                randomAccessFile.seek(40L);
                randomAccessFile.write(this.b, 0, 4);
            } catch (java.io.IOException e) {
                com.google.android.exoplayer2.util.Log.w("WaveFileAudioBufferSink", "Error updating file size", e);
            }
            try {
                randomAccessFile.close();
            } finally {
                this.g = null;
            }
        }

        public final void d(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            java.io.RandomAccessFile randomAccessFile = (java.io.RandomAccessFile) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.g);
            while (byteBuffer.hasRemaining()) {
                int min = java.lang.Math.min(byteBuffer.remaining(), this.b.length);
                byteBuffer.get(this.b, 0, min);
                randomAccessFile.write(this.b, 0, min);
                this.i += min;
            }
        }

        public final void e(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
            randomAccessFile.writeInt(com.google.android.exoplayer2.audio.WavUtil.RIFF_FOURCC);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(com.google.android.exoplayer2.audio.WavUtil.WAVE_FOURCC);
            randomAccessFile.writeInt(com.google.android.exoplayer2.audio.WavUtil.FMT_FOURCC);
            this.c.clear();
            this.c.putInt(16);
            this.c.putShort((short) com.google.android.exoplayer2.audio.WavUtil.getTypeForPcmEncoding(this.f));
            this.c.putShort((short) this.e);
            this.c.putInt(this.d);
            int pcmFrameSize = com.google.android.exoplayer2.util.Util.getPcmFrameSize(this.f, this.e);
            this.c.putInt(this.d * pcmFrameSize);
            this.c.putShort((short) pcmFrameSize);
            this.c.putShort((short) ((pcmFrameSize * 8) / this.e));
            randomAccessFile.write(this.b, 0, this.c.position());
            randomAccessFile.writeInt(com.google.android.exoplayer2.audio.WavUtil.DATA_FOURCC);
            randomAccessFile.writeInt(-1);
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void flush(int i, int i2, int i3) {
            try {
                c();
            } catch (java.io.IOException e) {
                com.google.android.exoplayer2.util.Log.e("WaveFileAudioBufferSink", "Error resetting", e);
            }
            this.d = i;
            this.e = i2;
            this.f = i3;
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void handleBuffer(java.nio.ByteBuffer byteBuffer) {
            try {
                b();
                d(byteBuffer);
            } catch (java.io.IOException e) {
                com.google.android.exoplayer2.util.Log.e("WaveFileAudioBufferSink", "Error writing data", e);
            }
        }
    }

    public TeeAudioProcessor(com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink audioBufferSink) {
        this.f = (com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink) com.google.android.exoplayer2.util.Assertions.checkNotNull(audioBufferSink);
    }

    public final void a() {
        if (isActive()) {
            com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink audioBufferSink = this.f;
            com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat = this.inputAudioFormat;
            audioBufferSink.flush(audioFormat.sampleRate, audioFormat.channelCount, audioFormat.encoding);
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat onConfigure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) {
        return audioFormat;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        a();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        a();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return;
        }
        this.f.handleBuffer(byteBuffer.asReadOnlyBuffer());
        replaceOutputBuffer(remaining).put(byteBuffer).flip();
    }
}
