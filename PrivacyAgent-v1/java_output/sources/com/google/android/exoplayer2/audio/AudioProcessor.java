package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public interface AudioProcessor {
    public static final java.nio.ByteBuffer EMPTY_BUFFER = java.nio.ByteBuffer.allocateDirect(0).order(java.nio.ByteOrder.nativeOrder());

    public static final class AudioFormat {
        public static final com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat NOT_SET = new com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat(-1, -1, -1);
        public final int bytesPerFrame;
        public final int channelCount;
        public final int encoding;
        public final int sampleRate;

        public AudioFormat(int i, int i2, int i3) {
            this.sampleRate = i;
            this.channelCount = i2;
            this.encoding = i3;
            this.bytesPerFrame = com.google.android.exoplayer2.util.Util.isEncodingLinearPcm(i3) ? com.google.android.exoplayer2.util.Util.getPcmFrameSize(i3, i2) : -1;
        }

        public java.lang.String toString() {
            int i = this.sampleRate;
            int i2 = this.channelCount;
            int i3 = this.encoding;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(83);
            sb.append("AudioFormat[sampleRate=");
            sb.append(i);
            sb.append(", channelCount=");
            sb.append(i2);
            sb.append(", encoding=");
            sb.append(i3);
            sb.append(']');
            return sb.toString();
        }
    }

    public static final class UnhandledAudioFormatException extends java.lang.Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public UnhandledAudioFormatException(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) {
            super(r1.toString());
            java.lang.String valueOf = java.lang.String.valueOf(audioFormat);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 18);
            sb.append("Unhandled format: ");
            sb.append(valueOf);
        }
    }

    com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat configure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException;

    void flush();

    java.nio.ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(java.nio.ByteBuffer byteBuffer);

    void reset();
}
