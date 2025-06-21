package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public interface Player {
    public static final int DISCONTINUITY_REASON_AD_INSERTION = 3;
    public static final int DISCONTINUITY_REASON_INTERNAL = 4;
    public static final int DISCONTINUITY_REASON_PERIOD_TRANSITION = 0;
    public static final int DISCONTINUITY_REASON_SEEK = 1;
    public static final int DISCONTINUITY_REASON_SEEK_ADJUSTMENT = 2;
    public static final int MEDIA_ITEM_TRANSITION_REASON_AUTO = 1;
    public static final int MEDIA_ITEM_TRANSITION_REASON_PLAYLIST_CHANGED = 3;
    public static final int MEDIA_ITEM_TRANSITION_REASON_REPEAT = 0;
    public static final int MEDIA_ITEM_TRANSITION_REASON_SEEK = 2;
    public static final int PLAYBACK_SUPPRESSION_REASON_NONE = 0;
    public static final int PLAYBACK_SUPPRESSION_REASON_TRANSIENT_AUDIO_FOCUS_LOSS = 1;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_AUDIO_BECOMING_NOISY = 3;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_AUDIO_FOCUS_LOSS = 2;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_END_OF_MEDIA_ITEM = 5;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_REMOTE = 4;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_USER_REQUEST = 1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_OFF = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;
    public static final int TIMELINE_CHANGE_REASON_PLAYLIST_CHANGED = 0;
    public static final int TIMELINE_CHANGE_REASON_SOURCE_UPDATE = 1;

    public interface AudioComponent {
        void addAudioListener(com.google.android.exoplayer2.audio.AudioListener audioListener);

        void clearAuxEffectInfo();

        com.google.android.exoplayer2.audio.AudioAttributes getAudioAttributes();

        int getAudioSessionId();

        boolean getSkipSilenceEnabled();

        float getVolume();

        void removeAudioListener(com.google.android.exoplayer2.audio.AudioListener audioListener);

        @java.lang.Deprecated
        void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes);

        void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, boolean z);

        void setAudioSessionId(int i);

        void setAuxEffectInfo(com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo);

        void setSkipSilenceEnabled(boolean z);

        void setVolume(float f);
    }

    @java.lang.Deprecated
    public static abstract class DefaultEventListener implements com.google.android.exoplayer2.Player.EventListener {
        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
            defpackage.h32.a(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            defpackage.h32.b(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            defpackage.h32.c(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            defpackage.h32.d(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(com.google.android.exoplayer2.MediaItem mediaItem, int i) {
            defpackage.h32.e(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            defpackage.h32.f(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
            defpackage.h32.g(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackStateChanged(int i) {
            defpackage.h32.h(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            defpackage.h32.i(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerError(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
            defpackage.h32.j(this, exoPlaybackException);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            defpackage.h32.k(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            defpackage.h32.l(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onRepeatModeChanged(int i) {
            defpackage.h32.m(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            defpackage.h32.n(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            defpackage.h32.o(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
            onTimelineChanged(timeline, timeline.getWindowCount() == 1 ? timeline.getWindow(0, new com.google.android.exoplayer2.Timeline.Window()).manifest : null, i);
        }

        @java.lang.Deprecated
        public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, @androidx.annotation.Nullable java.lang.Object obj) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, @androidx.annotation.Nullable java.lang.Object obj, int i) {
            onTimelineChanged(timeline, obj);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
            defpackage.h32.r(this, trackGroupArray, trackSelectionArray);
        }
    }

    public interface DeviceComponent {
        void addDeviceListener(com.google.android.exoplayer2.device.DeviceListener deviceListener);

        void decreaseDeviceVolume();

        com.google.android.exoplayer2.device.DeviceInfo getDeviceInfo();

        int getDeviceVolume();

        void increaseDeviceVolume();

        boolean isDeviceMuted();

        void removeDeviceListener(com.google.android.exoplayer2.device.DeviceListener deviceListener);

        void setDeviceMuted(boolean z);

        void setDeviceVolume(int i);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    public interface EventListener {
        void onExperimentalOffloadSchedulingEnabledChanged(boolean z);

        void onIsLoadingChanged(boolean z);

        void onIsPlayingChanged(boolean z);

        @java.lang.Deprecated
        void onLoadingChanged(boolean z);

        void onMediaItemTransition(@androidx.annotation.Nullable com.google.android.exoplayer2.MediaItem mediaItem, int i);

        void onPlayWhenReadyChanged(boolean z, int i);

        void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters);

        void onPlaybackStateChanged(int i);

        void onPlaybackSuppressionReasonChanged(int i);

        void onPlayerError(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException);

        @java.lang.Deprecated
        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity(int i);

        void onRepeatModeChanged(int i);

        @java.lang.Deprecated
        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z);

        void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i);

        @java.lang.Deprecated
        void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, @androidx.annotation.Nullable java.lang.Object obj, int i);

        void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface MediaItemTransitionReason {
    }

    public interface MetadataComponent {
        void addMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput);

        void removeMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PlayWhenReadyChangeReason {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PlaybackSuppressionReason {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface State {
    }

    public interface TextComponent {
        void addTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput);

        java.util.List<com.google.android.exoplayer2.text.Cue> getCurrentCues();

        void removeTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    public interface VideoComponent {
        void addVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener);

        void clearCameraMotionListener(com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener);

        void clearVideoDecoderOutputBufferRenderer();

        void clearVideoDecoderOutputBufferRenderer(@androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer);

        void clearVideoFrameMetadataListener(com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener);

        void clearVideoSurface();

        void clearVideoSurface(@androidx.annotation.Nullable android.view.Surface surface);

        void clearVideoSurfaceHolder(@androidx.annotation.Nullable android.view.SurfaceHolder surfaceHolder);

        void clearVideoSurfaceView(@androidx.annotation.Nullable android.view.SurfaceView surfaceView);

        void clearVideoTextureView(@androidx.annotation.Nullable android.view.TextureView textureView);

        int getVideoScalingMode();

        void removeVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener);

        void setCameraMotionListener(com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener);

        void setVideoDecoderOutputBufferRenderer(@androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer);

        void setVideoFrameMetadataListener(com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener);

        void setVideoScalingMode(int i);

        void setVideoSurface(@androidx.annotation.Nullable android.view.Surface surface);

        void setVideoSurfaceHolder(@androidx.annotation.Nullable android.view.SurfaceHolder surfaceHolder);

        void setVideoSurfaceView(@androidx.annotation.Nullable android.view.SurfaceView surfaceView);

        void setVideoTextureView(@androidx.annotation.Nullable android.view.TextureView textureView);
    }

    void addListener(com.google.android.exoplayer2.Player.EventListener eventListener);

    void addMediaItem(int i, com.google.android.exoplayer2.MediaItem mediaItem);

    void addMediaItem(com.google.android.exoplayer2.MediaItem mediaItem);

    void addMediaItems(int i, java.util.List<com.google.android.exoplayer2.MediaItem> list);

    void addMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list);

    void clearMediaItems();

    android.os.Looper getApplicationLooper();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.Player.AudioComponent getAudioComponent();

    int getBufferedPercentage();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    long getCurrentLiveOffset();

    @androidx.annotation.Nullable
    java.lang.Object getCurrentManifest();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.MediaItem getCurrentMediaItem();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    java.lang.Object getCurrentTag();

    com.google.android.exoplayer2.Timeline getCurrentTimeline();

    com.google.android.exoplayer2.source.TrackGroupArray getCurrentTrackGroups();

    com.google.android.exoplayer2.trackselection.TrackSelectionArray getCurrentTrackSelections();

    int getCurrentWindowIndex();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.Player.DeviceComponent getDeviceComponent();

    long getDuration();

    com.google.android.exoplayer2.MediaItem getMediaItemAt(int i);

    int getMediaItemCount();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.Player.MetadataComponent getMetadataComponent();

    int getNextWindowIndex();

    boolean getPlayWhenReady();

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    com.google.android.exoplayer2.ExoPlaybackException getPlaybackError();

    com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.ExoPlaybackException getPlayerError();

    int getPreviousWindowIndex();

    int getRendererCount();

    int getRendererType(int i);

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.Player.TextComponent getTextComponent();

    long getTotalBufferedDuration();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.trackselection.TrackSelector getTrackSelector();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.Player.VideoComponent getVideoComponent();

    boolean hasNext();

    boolean hasPrevious();

    boolean isCurrentWindowDynamic();

    boolean isCurrentWindowLive();

    boolean isCurrentWindowSeekable();

    boolean isLoading();

    boolean isPlaying();

    boolean isPlayingAd();

    void moveMediaItem(int i, int i2);

    void moveMediaItems(int i, int i2, int i3);

    void next();

    void pause();

    void play();

    void prepare();

    void previous();

    void release();

    void removeListener(com.google.android.exoplayer2.Player.EventListener eventListener);

    void removeMediaItem(int i);

    void removeMediaItems(int i, int i2);

    void seekTo(int i, long j);

    void seekTo(long j);

    void seekToDefaultPosition();

    void seekToDefaultPosition(int i);

    void setMediaItem(com.google.android.exoplayer2.MediaItem mediaItem);

    void setMediaItem(com.google.android.exoplayer2.MediaItem mediaItem, long j);

    void setMediaItem(com.google.android.exoplayer2.MediaItem mediaItem, boolean z);

    void setMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list);

    void setMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list, int i, long j);

    void setMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list, boolean z);

    void setPlayWhenReady(boolean z);

    void setPlaybackParameters(@androidx.annotation.Nullable com.google.android.exoplayer2.PlaybackParameters playbackParameters);

    void setRepeatMode(int i);

    void setShuffleModeEnabled(boolean z);

    void stop();

    void stop(boolean z);
}
