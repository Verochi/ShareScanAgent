package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public interface Renderer extends com.google.android.exoplayer2.PlayerMessage.Target {
    public static final int MSG_CUSTOM_BASE = 10000;
    public static final int MSG_SET_AUDIO_ATTRIBUTES = 3;
    public static final int MSG_SET_AUDIO_SESSION_ID = 102;
    public static final int MSG_SET_AUX_EFFECT_INFO = 5;
    public static final int MSG_SET_CAMERA_MOTION_LISTENER = 7;
    public static final int MSG_SET_SCALING_MODE = 4;
    public static final int MSG_SET_SKIP_SILENCE_ENABLED = 101;
    public static final int MSG_SET_SURFACE = 1;
    public static final int MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER = 8;
    public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 6;
    public static final int MSG_SET_VOLUME = 2;
    public static final int MSG_SET_WAKEUP_LISTENER = 103;
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_STARTED = 2;
    public static final int VIDEO_SCALING_MODE_DEFAULT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface State {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VideoScalingMode {
    }

    public interface WakeupListener {
        void onSleep(long j);

        void onWakeup();
    }

    void disable();

    void enable(com.google.android.exoplayer2.RendererConfiguration rendererConfiguration, com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) throws com.google.android.exoplayer2.ExoPlaybackException;

    com.google.android.exoplayer2.RendererCapabilities getCapabilities();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.util.MediaClock getMediaClock();

    java.lang.String getName();

    long getReadingPositionUs();

    int getState();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.source.SampleStream getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws java.io.IOException;

    void render(long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException;

    void replaceStream(com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException;

    void reset();

    void resetPosition(long j) throws com.google.android.exoplayer2.ExoPlaybackException;

    void setCurrentStreamFinal();

    void setIndex(int i);

    void setOperatingRate(float f) throws com.google.android.exoplayer2.ExoPlaybackException;

    void start() throws com.google.android.exoplayer2.ExoPlaybackException;

    void stop();
}
