package com.aliyun.player;

/* loaded from: classes.dex */
public abstract class ApasaraExternalPlayer {
    private static java.util.List<com.aliyun.player.ApasaraExternalPlayer> externalPlayerList = new java.util.ArrayList();

    public enum DecoderType {
        DT_HARDWARE,
        DT_SOFTWARE;

        public int getValue() {
            return ordinal();
        }
    }

    public interface OnAutoPlayStartListener {
        void onAutoPlayStart();
    }

    public interface OnBufferPositionUpdateListener {
        void onBufferPositionUpdate(long j);
    }

    public interface OnCaptureScreenListener {
        void onCaptureScreen(int i, int i2, byte[] bArr);
    }

    public interface OnCompletionListener {
        void onCompletion();
    }

    public interface OnDRMCallback {
        byte[] onRequestKey(java.lang.String str, byte[] bArr);

        byte[] onRequestProvision(java.lang.String str, byte[] bArr);
    }

    public interface OnErrorListener {
        void onError(int i, java.lang.String str);
    }

    public interface OnEventListener {
        void onEvent(int i, java.lang.String str);
    }

    public interface OnFirstFrameRenderListener {
        void onFirstFrameRender();
    }

    public interface OnLoadStatusListener {
        void onLoadingEnd();

        void onLoadingProgress(int i);

        void onLoadingStart();
    }

    public interface OnLoopingStartListener {
        void onLoopingStart();
    }

    public interface OnPositionUpdateListener {
        void onPositionUpdate(long j);
    }

    public interface OnPreparedListener {
        void onPrepared();
    }

    public interface OnSeekStatusListener {
        void onSeekEnd(boolean z);

        void onSeekStart(boolean z);
    }

    public interface OnStatusChangedListener {
        void onStatusChanged(int i, int i2);
    }

    public interface OnStreamInfoGetListener {
        void OnStreamInfoGet(com.aliyun.player.nativeclass.MediaInfo mediaInfo);
    }

    public interface OnStreamSwitchSucListener {
        void onStreamSwitchSuc(com.aliyun.player.ApasaraExternalPlayer.StreamType streamType, com.aliyun.player.nativeclass.TrackInfo trackInfo);
    }

    public interface OnSubtitleListener {
        void onSubtitleExtAdded(int i, java.lang.String str);

        void onSubtitleHide(int i, long j);

        void onSubtitleShow(int i, long j, java.lang.String str);
    }

    public interface OnVideoRenderedListener {
        void onVideoRendered(long j, long j2);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2);
    }

    public enum PlayerStatus {
        PLAYER_IDLE(0),
        PLAYER_INITIALZED(1),
        PLAYER_PREPARINIT(2),
        PLAYER_PREPARING(3),
        PLAYER_PREPARED(4),
        PLAYER_PLAYING(5),
        PLAYER_PAUSED(6),
        PLAYER_STOPPED(7),
        PLAYER_COMPLETION(8),
        PLAYER_ERROR(99);

        private int mValue;

        PlayerStatus(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum PropertyKey {
        PROPERTY_KEY_RESPONSE_INFO,
        PROPERTY_KEY_CONNECT_INFO,
        PROPERTY_KEY_OPEN_TIME_STR,
        PROPERTY_KEY_PROBE_STR,
        PROPERTY_KEY_VIDEO_BUFFER_LEN,
        PROPERTY_KEY_DELAY_INFO,
        PROPERTY_KEY_REMAIN_LIVE_SEG,
        PROPERTY_KEY_NETWORK_IS_CONNECTED
    }

    public enum StreamType {
        ST_TYPE_UNKNOWN(-1),
        ST_TYPE_VIDEO(0),
        ST_TYPE_AUDIO(1),
        ST_TYPE_SUB(2);

        private int mValue;

        StreamType(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static com.aliyun.player.ApasaraExternalPlayer isSupportExternal(com.aliyun.player.nativeclass.Options options) {
        for (com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer : externalPlayerList) {
            if (apasaraExternalPlayer.isSupport(options)) {
                return apasaraExternalPlayer;
            }
        }
        return null;
    }

    public static void registerExternalPlayer(com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer) {
        if (apasaraExternalPlayer != null) {
            externalPlayerList.add(apasaraExternalPlayer);
        }
    }

    public abstract void addCustomHttpHeader(java.lang.String str);

    public abstract void addExtSubtitle(java.lang.String str);

    public abstract void captureScreen();

    public abstract com.aliyun.player.ApasaraExternalPlayer create(android.content.Context context, com.aliyun.player.nativeclass.Options options);

    public abstract void enterBackGround(boolean z);

    public abstract long getBufferPosition();

    public abstract int getCurrentStreamIndex(com.aliyun.player.ApasaraExternalPlayer.StreamType streamType);

    public abstract com.aliyun.player.nativeclass.TrackInfo getCurrentStreamInfo(com.aliyun.player.ApasaraExternalPlayer.StreamType streamType);

    public abstract com.aliyun.player.ApasaraExternalPlayer.DecoderType getDecoderType();

    public abstract long getDuration();

    public abstract long getMasterClockPts();

    public abstract com.aliyun.player.IPlayer.MirrorMode getMirrorMode();

    public abstract java.lang.String getName();

    public abstract java.lang.String getOption(java.lang.String str);

    public abstract com.aliyun.player.ApasaraExternalPlayer.PlayerStatus getPlayerStatus();

    public abstract long getPlayingPosition();

    public abstract long getPropertyInt(com.aliyun.player.ApasaraExternalPlayer.PropertyKey propertyKey);

    public abstract long getPropertyLong(com.aliyun.player.ApasaraExternalPlayer.PropertyKey propertyKey);

    public abstract java.lang.String getPropertyString(com.aliyun.player.ApasaraExternalPlayer.PropertyKey propertyKey);

    public abstract com.aliyun.player.IPlayer.RotateMode getRotateMode();

    public abstract com.aliyun.player.IPlayer.ScaleMode getScaleMode();

    public abstract float getSpeed();

    public abstract float getVideoDecodeFps();

    public abstract int getVideoHeight();

    public abstract float getVideoRenderFps();

    public abstract int getVideoRotation();

    public abstract int getVideoWidth();

    public abstract float getVolume();

    public abstract int invokeComponent(java.lang.String str);

    public abstract boolean isAutoPlay();

    public abstract boolean isLooping();

    public abstract boolean isMute();

    public abstract boolean isSupport(com.aliyun.player.nativeclass.Options options);

    public abstract void mute(boolean z);

    public abstract void pause();

    public abstract void prepare();

    public abstract void reLoad();

    public abstract void release();

    public abstract void removeAllCustomHttpHeader();

    public abstract void seekTo(long j, boolean z);

    public abstract int selectExtSubtitle(int i, boolean z);

    public abstract void setAutoPlay(boolean z);

    public abstract void setDataSource(java.lang.String str);

    public abstract void setDecoderType(com.aliyun.player.ApasaraExternalPlayer.DecoderType decoderType);

    public abstract void setDrmCallback(com.aliyun.player.ApasaraExternalPlayer.OnDRMCallback onDRMCallback);

    public abstract void setDropBufferThreshold(int i);

    public abstract void setLooping(boolean z);

    public abstract void setMirrorMode(com.aliyun.player.IPlayer.MirrorMode mirrorMode);

    public abstract void setOnAutoPlayStartListener(com.aliyun.player.ApasaraExternalPlayer.OnAutoPlayStartListener onAutoPlayStartListener);

    public abstract void setOnBufferPositionUpdateListener(com.aliyun.player.ApasaraExternalPlayer.OnBufferPositionUpdateListener onBufferPositionUpdateListener);

    public abstract void setOnCaptureScreenListener(com.aliyun.player.ApasaraExternalPlayer.OnCaptureScreenListener onCaptureScreenListener);

    public abstract void setOnCompletionListener(com.aliyun.player.ApasaraExternalPlayer.OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(com.aliyun.player.ApasaraExternalPlayer.OnErrorListener onErrorListener);

    public abstract void setOnEventListener(com.aliyun.player.ApasaraExternalPlayer.OnEventListener onEventListener);

    public abstract void setOnFirstFrameRenderListener(com.aliyun.player.ApasaraExternalPlayer.OnFirstFrameRenderListener onFirstFrameRenderListener);

    public abstract void setOnLoadStatusListener(com.aliyun.player.ApasaraExternalPlayer.OnLoadStatusListener onLoadStatusListener);

    public abstract void setOnLoopingStartListener(com.aliyun.player.ApasaraExternalPlayer.OnLoopingStartListener onLoopingStartListener);

    public abstract void setOnPositionUpdateListener(com.aliyun.player.ApasaraExternalPlayer.OnPositionUpdateListener onPositionUpdateListener);

    public abstract void setOnPreparedListener(com.aliyun.player.ApasaraExternalPlayer.OnPreparedListener onPreparedListener);

    public abstract void setOnSeekStatusListener(com.aliyun.player.ApasaraExternalPlayer.OnSeekStatusListener onSeekStatusListener);

    public abstract void setOnStatusChangedListener(com.aliyun.player.ApasaraExternalPlayer.OnStatusChangedListener onStatusChangedListener);

    public abstract void setOnStreamInfoGetListener(com.aliyun.player.ApasaraExternalPlayer.OnStreamInfoGetListener onStreamInfoGetListener);

    public abstract void setOnStreamSwitchSucListener(com.aliyun.player.ApasaraExternalPlayer.OnStreamSwitchSucListener onStreamSwitchSucListener);

    public abstract void setOnSubtitleListener(com.aliyun.player.ApasaraExternalPlayer.OnSubtitleListener onSubtitleListener);

    public abstract void setOnVideoRenderedListener(com.aliyun.player.ApasaraExternalPlayer.OnVideoRenderedListener onVideoRenderedListener);

    public abstract void setOnVideoSizeChangedListener(com.aliyun.player.ApasaraExternalPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    public abstract int setOption(java.lang.String str, java.lang.String str2);

    public abstract void setRefer(java.lang.String str);

    public abstract void setRotateMode(com.aliyun.player.IPlayer.RotateMode rotateMode);

    public abstract void setScaleMode(com.aliyun.player.IPlayer.ScaleMode scaleMode);

    public abstract void setSpeed(float f);

    public abstract void setSurface(android.view.Surface surface);

    public abstract void setTimeout(int i);

    public abstract void setUserAgent(java.lang.String str);

    public abstract void setVideoBackgroundColor(long j);

    public abstract void setVolume(float f);

    public abstract void start();

    public abstract void stop();

    public abstract com.aliyun.player.ApasaraExternalPlayer.StreamType switchStream(int i);
}
