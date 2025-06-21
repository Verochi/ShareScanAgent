package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public interface AudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;
    public static final int SINK_FORMAT_SUPPORTED_DIRECTLY = 2;
    public static final int SINK_FORMAT_SUPPORTED_WITH_TRANSCODING = 1;
    public static final int SINK_FORMAT_UNSUPPORTED = 0;

    public static final class ConfigurationException extends java.lang.Exception {
        public ConfigurationException(java.lang.String str) {
            super(str);
        }

        public ConfigurationException(java.lang.Throwable th) {
            super(th);
        }
    }

    public static final class InitializationException extends java.lang.Exception {
        public final int audioTrackState;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InitializationException(int i, int i2, int i3, int i4) {
            super(r0.toString());
            java.lang.StringBuilder sb = new java.lang.StringBuilder(82);
            sb.append("AudioTrack init failed: ");
            sb.append(i);
            sb.append(", Config(");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i4);
            sb.append(")");
            this.audioTrackState = i;
        }
    }

    public interface Listener {
        void onAudioSessionId(int i);

        void onOffloadBufferEmptying();

        void onOffloadBufferFull(long j);

        void onPositionAdvancing(long j);

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z);

        void onUnderrun(int i, long j, long j2);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface SinkFormatSupport {
    }

    public static final class WriteException extends java.lang.Exception {
        public final int errorCode;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public WriteException(int i) {
            super(r0.toString());
            java.lang.StringBuilder sb = new java.lang.StringBuilder(36);
            sb.append("AudioTrack write failed: ");
            sb.append(i);
            this.errorCode = i;
        }
    }

    void configure(com.google.android.exoplayer2.Format format, int i, @androidx.annotation.Nullable int[] iArr) throws com.google.android.exoplayer2.audio.AudioSink.ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21(int i);

    void experimentalFlushWithoutAudioTrackRelease();

    void flush();

    long getCurrentPositionUs(boolean z);

    int getFormatSupport(com.google.android.exoplayer2.Format format);

    com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters();

    boolean getSkipSilenceEnabled();

    boolean handleBuffer(java.nio.ByteBuffer byteBuffer, long j, int i) throws com.google.android.exoplayer2.audio.AudioSink.InitializationException, com.google.android.exoplayer2.audio.AudioSink.WriteException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws com.google.android.exoplayer2.audio.AudioSink.WriteException;

    void reset();

    void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes);

    void setAudioSessionId(int i);

    void setAuxEffectInfo(com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo);

    void setListener(com.google.android.exoplayer2.audio.AudioSink.Listener listener);

    void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters);

    void setSkipSilenceEnabled(boolean z);

    void setVolume(float f);

    boolean supportsFormat(com.google.android.exoplayer2.Format format);
}
