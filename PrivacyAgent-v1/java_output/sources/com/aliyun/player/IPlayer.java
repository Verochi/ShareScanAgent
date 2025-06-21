package com.aliyun.player;

/* loaded from: classes.dex */
public interface IPlayer {
    public static final int ALLOW_PRE_RENDER = 2;
    public static final int SET_MEDIA_TYPE = 0;
    public static final int completion = 6;
    public static final int error = 7;
    public static final int idle = 0;
    public static final int initalized = 1;
    public static final int paused = 4;
    public static final int prepared = 2;
    public static final int started = 3;
    public static final int stopped = 5;
    public static final int unknow = -1;

    public enum AlphaRenderMode {
        RENDER_MODE_ALPHA_NONE(0),
        RENDER_MODE_ALPHA_AT_RIGHT(1),
        RENDER_MODE_ALPHA_AT_LEFT(2),
        RENDER_MODE_ALPHA_AT_TOP(3),
        RENDER_MODE_ALPHA_AT_BOTTOM(4);

        private int mValue;

        AlphaRenderMode(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public interface ConvertURLCallback {
        java.lang.String convertURL(java.lang.String str, java.lang.String str2);
    }

    public enum IPResolveType {
        IpResolveWhatEver,
        IpResolveV4,
        IpResolveV6
    }

    public enum MirrorMode {
        MIRROR_MODE_NONE(0),
        MIRROR_MODE_HORIZONTAL(1),
        MIRROR_MODE_VERTICAL(2);

        private int mValue;

        MirrorMode(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public interface OnAVNotSyncStatusListener {
        void onAVNotSyncEnd();

        void onAVNotSyncStart(int i);
    }

    public interface OnChooseTrackIndexListener {
        int onChooseTrackIndex(com.aliyun.player.nativeclass.TrackInfo[] trackInfoArr);
    }

    public interface OnCompletionListener {
        void onCompletion();
    }

    public interface OnErrorListener {
        void onError(com.aliyun.player.bean.ErrorInfo errorInfo);
    }

    public interface OnInfoListener {
        void onInfo(com.aliyun.player.bean.InfoBean infoBean);
    }

    public interface OnLoadingStatusListener {
        void onLoadingBegin();

        void onLoadingEnd();

        void onLoadingProgress(int i, float f);
    }

    public interface OnPreRenderFrameCallback {
        boolean onPreRenderFrame(com.cicada.player.utils.FrameInfo frameInfo);
    }

    public interface OnPreparedListener {
        void onPrepared();
    }

    public interface OnRenderFrameCallback {
        boolean onRenderFrame(com.cicada.player.utils.FrameInfo frameInfo);
    }

    public interface OnRenderingStartListener {
        void onRenderingStart();
    }

    public interface OnReportEventListener {
        void onEventParam(java.util.Map<java.lang.String, java.lang.String> map);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete();
    }

    public interface OnSeiDataListener {
        void onSeiData(int i, byte[] bArr, byte[] bArr2);
    }

    public interface OnSnapShotListener {
        void onSnapShot(android.graphics.Bitmap bitmap, int i, int i2);
    }

    public interface OnStateChangedListener {
        void onStateChanged(int i);
    }

    public interface OnStreamSwitchedListener {
        void onSwitchedFail(java.lang.String str, com.aliyun.player.bean.ErrorInfo errorInfo);

        void onSwitchedSuccess(java.lang.String str);
    }

    public interface OnSubTrackReadyListener {
        void onSubTrackReady(com.aliyun.player.nativeclass.MediaInfo mediaInfo);
    }

    public interface OnSubtitleDisplayListener {
        void onSubtitleExtAdded(int i, java.lang.String str);

        void onSubtitleHeader(int i, java.lang.String str);

        void onSubtitleHide(int i, long j);

        void onSubtitleShow(int i, long j, java.lang.String str);
    }

    public interface OnThumbnailListener {
        void onGetFail(long j, com.aliyun.player.bean.ErrorInfo errorInfo);

        void onGetSuccess(long j, com.aliyun.thumbnail.ThumbnailBitmapInfo thumbnailBitmapInfo);
    }

    public interface OnTrackChangedListener {
        void onChangedFail(com.aliyun.player.nativeclass.TrackInfo trackInfo, com.aliyun.player.bean.ErrorInfo errorInfo);

        void onChangedSuccess(com.aliyun.player.nativeclass.TrackInfo trackInfo);
    }

    public interface OnTrackReadyListener {
        void onTrackReady(com.aliyun.player.nativeclass.MediaInfo mediaInfo);
    }

    public interface OnVideoRenderedListener {
        void onVideoRendered(long j, long j2);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2);
    }

    public static class Option {
        private java.lang.String mValue;
        public static com.aliyun.player.IPlayer.Option RenderFPS = new com.aliyun.player.IPlayer.Option("renderFps");
        public static com.aliyun.player.IPlayer.Option DownloadBitrate = new com.aliyun.player.IPlayer.Option("downloadBitrate");
        public static com.aliyun.player.IPlayer.Option VideoBitrate = new com.aliyun.player.IPlayer.Option("videoBitrate");
        public static com.aliyun.player.IPlayer.Option AudioBitrate = new com.aliyun.player.IPlayer.Option("audioBitrate");
        public static com.aliyun.player.IPlayer.Option IsAbrSwitching = new com.aliyun.player.IPlayer.Option("isAbrSwitching");

        private Option(java.lang.String str) {
            this.mValue = str;
        }

        public java.lang.String getValue() {
            return this.mValue;
        }
    }

    public enum OutputAudioChannel {
        OUTPUT_AUDIO_CHANNEL_NONE(0),
        OUTPUT_AUDIO_CHANNEL_LEFT(1),
        OUTPUT_AUDIO_CHANNEL_RIGHT(2);

        private int mValue;

        OutputAudioChannel(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum PropertyKey {
        RESPONSE_INFO(0),
        CONNECT_INFO(1);

        private int mValue;

        PropertyKey(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class RenderFrameCallbackConfig {
        public boolean mVideoDataAddr = true;
        public boolean mAudioDataAddr = false;
    }

    public enum RotateMode {
        ROTATE_0(0),
        ROTATE_90(90),
        ROTATE_180(180),
        ROTATE_270(270);

        private int mValue;

        RotateMode(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum ScaleMode {
        SCALE_ASPECT_FIT(0),
        SCALE_ASPECT_FILL(1),
        SCALE_TO_FILL(2);

        private int mValue;

        ScaleMode(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum SeekMode {
        Accurate(1),
        Inaccurate(16);

        private int mValue;

        SeekMode(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    void addExtSubtitle(java.lang.String str);

    void clearScreen();

    @java.lang.Deprecated
    com.aliyun.player.nativeclass.TrackInfo currentTrack(int i);

    com.aliyun.player.nativeclass.TrackInfo currentTrack(com.aliyun.player.nativeclass.TrackInfo.Type type);

    void enableHardwareDecoder(boolean z);

    com.aliyun.player.IPlayer.AlphaRenderMode getAlphaRenderMode();

    long getBufferedPosition();

    java.lang.String getCacheFilePath(java.lang.String str);

    java.lang.String getCacheFilePath(java.lang.String str, java.lang.String str2, java.lang.String str3, int i);

    com.aliyun.player.nativeclass.PlayerConfig getConfig();

    long getCurrentPosition();

    long getDuration();

    com.aliyun.player.nativeclass.MediaInfo getMediaInfo();

    com.aliyun.player.IPlayer.MirrorMode getMirrorMode();

    long getNativeContextAddr();

    java.lang.Object getOption(com.aliyun.player.IPlayer.Option option);

    java.lang.String getPlayerName();

    int getPlayerStatus();

    java.lang.String getPropertyString(com.aliyun.player.IPlayer.PropertyKey propertyKey);

    com.aliyun.player.IPlayer.RotateMode getRotateMode();

    com.aliyun.player.IPlayer.ScaleMode getScaleMode();

    float getSpeed();

    com.aliyun.player.nativeclass.MediaInfo getSubMediaInfo();

    java.lang.String getUserData();

    int getVideoHeight();

    int getVideoRotation();

    int getVideoWidth();

    float getVolume();

    boolean isAutoPlay();

    boolean isLoop();

    boolean isMute();

    void pause();

    void prepare();

    @java.lang.Deprecated
    void redraw();

    void release();

    void releaseAsync();

    void reload();

    void reset();

    void seekTo(long j);

    void seekTo(long j, com.aliyun.player.IPlayer.SeekMode seekMode);

    void selectExtSubtitle(int i, boolean z);

    void selectTrack(int i);

    void selectTrack(int i, boolean z);

    void sendCustomEvent(java.lang.String str);

    void setAlphaRenderMode(com.aliyun.player.IPlayer.AlphaRenderMode alphaRenderMode);

    void setAutoPlay(boolean z);

    void setCacheConfig(com.aliyun.player.nativeclass.CacheConfig cacheConfig);

    void setConfig(com.aliyun.player.nativeclass.PlayerConfig playerConfig);

    void setDefaultBandWidth(int i);

    void setDisplay(android.view.SurfaceHolder surfaceHolder);

    void setDisplayView(com.aliyun.player.videoview.AliDisplayView aliDisplayView);

    void setDrmCallback(com.cicada.player.utils.media.DrmCallback drmCallback);

    void setFastStart(boolean z);

    void setFilterConfig(com.aliyun.player.FilterConfig filterConfig);

    void setFilterInvalid(java.lang.String str, boolean z);

    void setIPResolveType(com.aliyun.player.IPlayer.IPResolveType iPResolveType);

    void setLoop(boolean z);

    void setMaxAccurateSeekDelta(int i);

    void setMirrorMode(com.aliyun.player.IPlayer.MirrorMode mirrorMode);

    void setMute(boolean z);

    void setOnAVNotSyncStatusListener(com.aliyun.player.IPlayer.OnAVNotSyncStatusListener onAVNotSyncStatusListener);

    void setOnChooseTrackIndexListener(com.aliyun.player.IPlayer.OnChooseTrackIndexListener onChooseTrackIndexListener);

    void setOnCompletionListener(com.aliyun.player.IPlayer.OnCompletionListener onCompletionListener);

    void setOnErrorListener(com.aliyun.player.IPlayer.OnErrorListener onErrorListener);

    void setOnInfoListener(com.aliyun.player.IPlayer.OnInfoListener onInfoListener);

    void setOnLoadingStatusListener(com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener);

    void setOnPreRenderFrameCallback(com.aliyun.player.IPlayer.OnPreRenderFrameCallback onPreRenderFrameCallback);

    void setOnPreparedListener(com.aliyun.player.IPlayer.OnPreparedListener onPreparedListener);

    void setOnRenderFrameCallback(com.aliyun.player.IPlayer.OnRenderFrameCallback onRenderFrameCallback);

    void setOnRenderingStartListener(com.aliyun.player.IPlayer.OnRenderingStartListener onRenderingStartListener);

    void setOnReportEventListener(com.aliyun.player.IPlayer.OnReportEventListener onReportEventListener);

    void setOnSeekCompleteListener(com.aliyun.player.IPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void setOnSeiDataListener(com.aliyun.player.IPlayer.OnSeiDataListener onSeiDataListener);

    void setOnSnapShotListener(com.aliyun.player.IPlayer.OnSnapShotListener onSnapShotListener);

    void setOnStateChangedListener(com.aliyun.player.IPlayer.OnStateChangedListener onStateChangedListener);

    void setOnStreamSwitchedListener(com.aliyun.player.IPlayer.OnStreamSwitchedListener onStreamSwitchedListener);

    void setOnSubTrackReadyListener(com.aliyun.player.IPlayer.OnSubTrackReadyListener onSubTrackReadyListener);

    void setOnSubtitleDisplayListener(com.aliyun.player.IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener);

    void setOnTrackChangedListener(com.aliyun.player.IPlayer.OnTrackChangedListener onTrackChangedListener);

    void setOnTrackReadyListener(com.aliyun.player.IPlayer.OnTrackReadyListener onTrackReadyListener);

    void setOnVideoRenderedListener(com.aliyun.player.IPlayer.OnVideoRenderedListener onVideoRenderedListener);

    void setOnVideoSizeChangedListener(com.aliyun.player.IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setOption(int i, int i2);

    void setOption(int i, java.lang.String str);

    void setOutputAudioChannel(com.aliyun.player.IPlayer.OutputAudioChannel outputAudioChannel);

    void setPreferPlayerName(java.lang.String str);

    void setRenderFrameCallbackConfig(com.aliyun.player.IPlayer.RenderFrameCallbackConfig renderFrameCallbackConfig);

    void setRotateMode(com.aliyun.player.IPlayer.RotateMode rotateMode);

    void setScaleMode(com.aliyun.player.IPlayer.ScaleMode scaleMode);

    void setSpeed(float f);

    void setStartTime(long j, com.aliyun.player.IPlayer.SeekMode seekMode);

    void setStreamDelayTime(int i, int i2);

    void setSurface(android.view.Surface surface);

    void setTraceId(java.lang.String str);

    void setUserData(java.lang.String str);

    void setVideoBackgroundColor(int i);

    void setVideoTag(int[] iArr);

    void setVolume(float f);

    void snapshot();

    void start();

    void stop();

    void surfaceChanged();

    void switchStream(java.lang.String str);

    void updateFilterConfig(java.lang.String str, com.aliyun.player.FilterConfig.FilterOptions filterOptions);
}
