package com.aliyun.player;

/* loaded from: classes.dex */
public abstract class AVPLBase implements com.aliyun.player.IListPlayer, com.aliyun.player.IPlayer {
    private static final java.lang.String TAG = "AVPLBase";
    private com.aliyun.player.nativeclass.JniListPlayerBase mListPlayer;
    private com.aliyun.player.IPlayer mNativePlayer;
    private com.aliyun.player.IPlayer mPrerenderPlayer;

    public AVPLBase(android.content.Context context, java.lang.String str) {
        this.mListPlayer = null;
        this.mNativePlayer = null;
        this.mPrerenderPlayer = null;
        this.mNativePlayer = getNativePlayer(context, str);
        this.mPrerenderPlayer = getPrerenderPlayer(context, str);
        this.mListPlayer = createListPlayer(context, str, this.mNativePlayer.getNativeContextAddr(), this.mPrerenderPlayer.getNativeContextAddr());
    }

    @Override // com.aliyun.player.IListPlayer
    public com.aliyun.player.IListPlayer.MultiBitratesMode GetMultiBitratesMode() {
        int GetMultiBitratesMode = this.mListPlayer.GetMultiBitratesMode();
        return GetMultiBitratesMode != 0 ? GetMultiBitratesMode != 1 ? GetMultiBitratesMode != 2 ? GetMultiBitratesMode != 3 ? com.aliyun.player.IListPlayer.MultiBitratesMode.MultiBitratesMode_Default : com.aliyun.player.IListPlayer.MultiBitratesMode.MultiBitratesMode_SmoothPrio : com.aliyun.player.IListPlayer.MultiBitratesMode.MultiBitratesMode_FC_AND_SMOOTH : com.aliyun.player.IListPlayer.MultiBitratesMode.MultiBitratesMode_FCPrio : com.aliyun.player.IListPlayer.MultiBitratesMode.MultiBitratesMode_Default;
    }

    @Override // com.aliyun.player.IListPlayer
    public void SetMultiBitratesMode(com.aliyun.player.IListPlayer.MultiBitratesMode multiBitratesMode) {
        this.mListPlayer.SetMultiBitratesMode(multiBitratesMode.getValue());
    }

    @Override // com.aliyun.player.IPlayer
    public void addExtSubtitle(java.lang.String str) {
        getCurrentPlayer().addExtSubtitle(str);
    }

    @Override // com.aliyun.player.IListPlayer
    public void clear() {
        this.mListPlayer.clear();
    }

    @Override // com.aliyun.player.IPlayer
    public void clearScreen() {
        getCurrentPlayer().clearScreen();
    }

    public abstract com.aliyun.player.nativeclass.JniListPlayerBase createListPlayer(android.content.Context context, java.lang.String str, long j, long j2);

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.nativeclass.TrackInfo currentTrack(int i) {
        return getCurrentPlayer().currentTrack(i);
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.nativeclass.TrackInfo currentTrack(com.aliyun.player.nativeclass.TrackInfo.Type type) {
        return getCurrentPlayer().currentTrack(type);
    }

    @Override // com.aliyun.player.IPlayer
    public void enableHardwareDecoder(boolean z) {
        getCurrentPlayer().enableHardwareDecoder(z);
    }

    @Override // com.aliyun.player.IListPlayer
    public void enablePreloadStrategy(com.aliyun.player.IListPlayer.StrategyType strategyType, boolean z) {
        this.mListPlayer.enablePreloadStrategy(strategyType.getValue(), z);
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.IPlayer.AlphaRenderMode getAlphaRenderMode() {
        return com.aliyun.player.IPlayer.AlphaRenderMode.RENDER_MODE_ALPHA_NONE;
    }

    @Override // com.aliyun.player.IPlayer
    public long getBufferedPosition() {
        return getCurrentPlayer().getBufferedPosition();
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getCacheFilePath(java.lang.String str) {
        return getCurrentPlayer().getCacheFilePath(str);
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getCacheFilePath(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        return getCurrentPlayer().getCacheFilePath(str, str2, str3, i);
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.nativeclass.PlayerConfig getConfig() {
        return getCurrentPlayer().getConfig();
    }

    public com.aliyun.player.nativeclass.JniListPlayerBase getCorePlayer() {
        return this.mListPlayer;
    }

    public com.aliyun.player.IPlayer getCurrentPlayer() {
        return getCurrentPlayerIndex() == 1 ? this.mPrerenderPlayer : this.mNativePlayer;
    }

    public abstract long getCurrentPlayerIndex();

    @Override // com.aliyun.player.IPlayer
    public long getCurrentPosition() {
        return getCurrentPlayer().getCurrentPosition();
    }

    public com.aliyun.player.IPlayer getCurrentPrerenderPlayer(long j) {
        if (j == 0) {
            return this.mNativePlayer;
        }
        if (j == 1) {
            return this.mPrerenderPlayer;
        }
        return null;
    }

    @Override // com.aliyun.player.IListPlayer
    public java.lang.String getCurrentUid() {
        return this.mListPlayer.getCurrentUid();
    }

    @Override // com.aliyun.player.IPlayer
    public long getDuration() {
        return getCurrentPlayer().getDuration();
    }

    @Override // com.aliyun.player.IListPlayer
    public int getMaxPreloadMemorySizeMB() {
        return this.mListPlayer.getMaxPreloadMemorySizeMB();
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.nativeclass.MediaInfo getMediaInfo() {
        return getCurrentPlayer().getMediaInfo();
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.IPlayer.MirrorMode getMirrorMode() {
        return getCurrentPlayer().getMirrorMode();
    }

    @Override // com.aliyun.player.IPlayer
    public long getNativeContextAddr() {
        return this.mNativePlayer.getNativeContextAddr();
    }

    public com.aliyun.player.IPlayer getNativePlayer() {
        return this.mNativePlayer;
    }

    public abstract com.aliyun.player.IPlayer getNativePlayer(android.content.Context context, java.lang.String str);

    @Override // com.aliyun.player.IPlayer
    public java.lang.Object getOption(com.aliyun.player.IPlayer.Option option) {
        return getCurrentPlayer().getOption(option);
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getPlayerName() {
        return getCurrentPlayer().getPlayerName();
    }

    @Override // com.aliyun.player.IPlayer
    public int getPlayerStatus() {
        return getCurrentPlayer().getPlayerStatus();
    }

    public com.aliyun.player.IPlayer getPrerenderPlayer() {
        return this.mPrerenderPlayer;
    }

    public abstract com.aliyun.player.IPlayer getPrerenderPlayer(android.content.Context context, java.lang.String str);

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getPropertyString(com.aliyun.player.IPlayer.PropertyKey propertyKey) {
        return getCurrentPlayer().getPropertyString(propertyKey);
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.IPlayer.RotateMode getRotateMode() {
        return getCurrentPlayer().getRotateMode();
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.IPlayer.ScaleMode getScaleMode() {
        return getCurrentPlayer().getScaleMode();
    }

    @Override // com.aliyun.player.IPlayer
    public float getSpeed() {
        return getCurrentPlayer().getSpeed();
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.nativeclass.MediaInfo getSubMediaInfo() {
        return getCurrentPlayer().getSubMediaInfo();
    }

    @Override // com.aliyun.player.IPlayer
    public int getVideoHeight() {
        return getCurrentPlayer().getVideoHeight();
    }

    @Override // com.aliyun.player.IPlayer
    public int getVideoRotation() {
        return getCurrentPlayer().getVideoRotation();
    }

    @Override // com.aliyun.player.IPlayer
    public int getVideoWidth() {
        return getCurrentPlayer().getVideoWidth();
    }

    @Override // com.aliyun.player.IPlayer
    public float getVolume() {
        return getCurrentPlayer().getVolume();
    }

    @Override // com.aliyun.player.IPlayer
    public boolean isAutoPlay() {
        return getCurrentPlayer().isAutoPlay();
    }

    @Override // com.aliyun.player.IPlayer
    public boolean isLoop() {
        return getCurrentPlayer().isLoop();
    }

    @Override // com.aliyun.player.IPlayer
    public boolean isMute() {
        return getCurrentPlayer().isMute();
    }

    @Override // com.aliyun.player.IPlayer
    public void pause() {
        getCurrentPlayer().pause();
    }

    @Override // com.aliyun.player.IPlayer
    public void prepare() {
        getCurrentPlayer().prepare();
    }

    @Override // com.aliyun.player.IPlayer
    public void redraw() {
        getCurrentPlayer().redraw();
    }

    @Override // com.aliyun.player.IPlayer
    public void release() {
        this.mListPlayer.release();
        this.mNativePlayer.release();
        this.mPrerenderPlayer.release();
    }

    @Override // com.aliyun.player.IPlayer
    public void releaseAsync() {
        com.cicada.player.utils.Logger.w(TAG, "don't support releaseAsync on listplayer, call release instead");
        release();
    }

    @Override // com.aliyun.player.IPlayer
    public void reload() {
        getCurrentPlayer().reload();
    }

    @Override // com.aliyun.player.IListPlayer
    public void removeSource(java.lang.String str) {
        this.mListPlayer.removeSource(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void reset() {
        getCurrentPlayer().reset();
    }

    @Override // com.aliyun.player.IPlayer
    public void seekTo(long j) {
        getCurrentPlayer().seekTo(j);
    }

    @Override // com.aliyun.player.IPlayer
    public void seekTo(long j, com.aliyun.player.IPlayer.SeekMode seekMode) {
        getCurrentPlayer().seekTo(j, seekMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void selectExtSubtitle(int i, boolean z) {
        getCurrentPlayer().selectExtSubtitle(i, z);
    }

    @Override // com.aliyun.player.IPlayer
    public void selectTrack(int i) {
        getCurrentPlayer().selectTrack(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void selectTrack(int i, boolean z) {
        getCurrentPlayer().selectTrack(i, z);
    }

    @Override // com.aliyun.player.IPlayer
    public void sendCustomEvent(java.lang.String str) {
        getCurrentPlayer().sendCustomEvent(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setAlphaRenderMode(com.aliyun.player.IPlayer.AlphaRenderMode alphaRenderMode) {
    }

    @Override // com.aliyun.player.IPlayer
    public void setAutoPlay(boolean z) {
        getCurrentPlayer().setAutoPlay(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setCacheConfig(com.aliyun.player.nativeclass.CacheConfig cacheConfig) {
        getCurrentPlayer().setCacheConfig(cacheConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setConfig(com.aliyun.player.nativeclass.PlayerConfig playerConfig) {
        com.aliyun.player.IPlayer iPlayer = this.mNativePlayer;
        if (iPlayer != null) {
            iPlayer.setConfig(playerConfig);
        }
        com.aliyun.player.IPlayer iPlayer2 = this.mPrerenderPlayer;
        if (iPlayer2 != null) {
            iPlayer2.setConfig(playerConfig);
        }
    }

    @Override // com.aliyun.player.IPlayer
    public void setDefaultBandWidth(int i) {
        getCurrentPlayer().setDefaultBandWidth(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        getCurrentPlayer().setDisplay(surfaceHolder);
    }

    @Override // com.aliyun.player.IPlayer
    public void setDisplayView(com.aliyun.player.videoview.AliDisplayView aliDisplayView) {
        getCurrentPlayer().setDisplayView(aliDisplayView);
    }

    @Override // com.aliyun.player.IPlayer
    public void setDrmCallback(com.cicada.player.utils.media.DrmCallback drmCallback) {
        getCurrentPlayer().setDrmCallback(drmCallback);
    }

    @Override // com.aliyun.player.IPlayer
    public void setFastStart(boolean z) {
        getCurrentPlayer().setFastStart(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setFilterConfig(com.aliyun.player.FilterConfig filterConfig) {
        getCurrentPlayer().setFilterConfig(filterConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setFilterInvalid(java.lang.String str, boolean z) {
        getCurrentPlayer().setFilterInvalid(str, z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setIPResolveType(com.aliyun.player.IPlayer.IPResolveType iPResolveType) {
        getCurrentPlayer().setIPResolveType(iPResolveType);
    }

    @Override // com.aliyun.player.IPlayer
    public void setLoop(boolean z) {
        getCurrentPlayer().setLoop(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setMaxAccurateSeekDelta(int i) {
        getCurrentPlayer().setMaxAccurateSeekDelta(i);
    }

    @Override // com.aliyun.player.IListPlayer
    public void setMaxPreloadMemorySizeMB(int i) {
        this.mListPlayer.setMaxPreloadMemorySizeMB(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void setMirrorMode(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
        getCurrentPlayer().setMirrorMode(mirrorMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setMute(boolean z) {
        getCurrentPlayer().setMute(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnAVNotSyncStatusListener(com.aliyun.player.IPlayer.OnAVNotSyncStatusListener onAVNotSyncStatusListener) {
        getCurrentPlayer().setOnAVNotSyncStatusListener(onAVNotSyncStatusListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnChooseTrackIndexListener(com.aliyun.player.IPlayer.OnChooseTrackIndexListener onChooseTrackIndexListener) {
        getCurrentPlayer().setOnChooseTrackIndexListener(onChooseTrackIndexListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnCompletionListener(com.aliyun.player.IPlayer.OnCompletionListener onCompletionListener) {
        getCurrentPlayer().setOnCompletionListener(onCompletionListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnErrorListener(com.aliyun.player.IPlayer.OnErrorListener onErrorListener) {
        getCurrentPlayer().setOnErrorListener(onErrorListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnInfoListener(com.aliyun.player.IPlayer.OnInfoListener onInfoListener) {
        getCurrentPlayer().setOnInfoListener(onInfoListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnLoadingStatusListener(com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener) {
        getCurrentPlayer().setOnLoadingStatusListener(onLoadingStatusListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnPreRenderFrameCallback(com.aliyun.player.IPlayer.OnPreRenderFrameCallback onPreRenderFrameCallback) {
        getCurrentPlayer().setOnPreRenderFrameCallback(onPreRenderFrameCallback);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnPreparedListener(com.aliyun.player.IPlayer.OnPreparedListener onPreparedListener) {
        getCurrentPlayer().setOnPreparedListener(onPreparedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnRenderFrameCallback(com.aliyun.player.IPlayer.OnRenderFrameCallback onRenderFrameCallback) {
        getCurrentPlayer().setOnRenderFrameCallback(onRenderFrameCallback);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnRenderingStartListener(com.aliyun.player.IPlayer.OnRenderingStartListener onRenderingStartListener) {
        getCurrentPlayer().setOnRenderingStartListener(onRenderingStartListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnReportEventListener(com.aliyun.player.IPlayer.OnReportEventListener onReportEventListener) {
        getCurrentPlayer().setOnReportEventListener(onReportEventListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSeekCompleteListener(com.aliyun.player.IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        getCurrentPlayer().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSeiDataListener(com.aliyun.player.IPlayer.OnSeiDataListener onSeiDataListener) {
        getCurrentPlayer().setOnSeiDataListener(onSeiDataListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSnapShotListener(com.aliyun.player.IPlayer.OnSnapShotListener onSnapShotListener) {
        getCurrentPlayer().setOnSnapShotListener(onSnapShotListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnStateChangedListener(com.aliyun.player.IPlayer.OnStateChangedListener onStateChangedListener) {
        getCurrentPlayer().setOnStateChangedListener(onStateChangedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnStreamSwitchedListener(com.aliyun.player.IPlayer.OnStreamSwitchedListener onStreamSwitchedListener) {
        getCurrentPlayer().setOnStreamSwitchedListener(onStreamSwitchedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSubTrackReadyListener(com.aliyun.player.IPlayer.OnSubTrackReadyListener onSubTrackReadyListener) {
        getCurrentPlayer().setOnSubTrackReadyListener(onSubTrackReadyListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSubtitleDisplayListener(com.aliyun.player.IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener) {
        getCurrentPlayer().setOnSubtitleDisplayListener(onSubtitleDisplayListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnTrackChangedListener(com.aliyun.player.IPlayer.OnTrackChangedListener onTrackChangedListener) {
        getCurrentPlayer().setOnTrackChangedListener(onTrackChangedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnTrackReadyListener(com.aliyun.player.IPlayer.OnTrackReadyListener onTrackReadyListener) {
        getCurrentPlayer().setOnTrackReadyListener(onTrackReadyListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnVideoRenderedListener(com.aliyun.player.IPlayer.OnVideoRenderedListener onVideoRenderedListener) {
        getCurrentPlayer().setOnVideoRenderedListener(onVideoRenderedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnVideoSizeChangedListener(com.aliyun.player.IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        getCurrentPlayer().setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOption(int i, int i2) {
        getCurrentPlayer().setOption(i, i2);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOption(int i, java.lang.String str) {
        getCurrentPlayer().setOption(i, str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOutputAudioChannel(com.aliyun.player.IPlayer.OutputAudioChannel outputAudioChannel) {
        getCurrentPlayer().setOutputAudioChannel(outputAudioChannel);
    }

    @Override // com.aliyun.player.IPlayer
    public void setPreferPlayerName(java.lang.String str) {
        getCurrentPlayer().setPreferPlayerName(str);
    }

    @Override // com.aliyun.player.IListPlayer
    public void setPreloadCount(int i) {
        this.mListPlayer.setPreloadCount(i);
    }

    @Override // com.aliyun.player.IListPlayer
    public void setPreloadScene(com.aliyun.player.IListPlayer.SceneType sceneType) {
        this.mListPlayer.setPreloadScene(sceneType.getValue());
    }

    @Override // com.aliyun.player.IListPlayer
    public void setPreloadStrategy(com.aliyun.player.IListPlayer.StrategyType strategyType, java.lang.String str) {
        this.mListPlayer.setPreloadStrategyParam(strategyType.getValue(), str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setRenderFrameCallbackConfig(com.aliyun.player.IPlayer.RenderFrameCallbackConfig renderFrameCallbackConfig) {
        getCurrentPlayer().setRenderFrameCallbackConfig(renderFrameCallbackConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setRotateMode(com.aliyun.player.IPlayer.RotateMode rotateMode) {
        getCurrentPlayer().setRotateMode(rotateMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setScaleMode(com.aliyun.player.IPlayer.ScaleMode scaleMode) {
        getCurrentPlayer().setScaleMode(scaleMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setSpeed(float f) {
        getCurrentPlayer().setSpeed(f);
    }

    @Override // com.aliyun.player.IPlayer
    public void setStartTime(long j, com.aliyun.player.IPlayer.SeekMode seekMode) {
        getCurrentPlayer().setStartTime(j, seekMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setStreamDelayTime(int i, int i2) {
        getCurrentPlayer().setStreamDelayTime(i, i2);
    }

    @Override // com.aliyun.player.IPlayer
    public void setSurface(android.view.Surface surface) {
        getCurrentPlayer().setSurface(surface);
    }

    @Override // com.aliyun.player.IPlayer
    public void setTraceId(java.lang.String str) {
        getCurrentPlayer().setTraceId(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setVideoBackgroundColor(int i) {
        getCurrentPlayer().setVideoBackgroundColor(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void setVideoTag(int[] iArr) {
        getCurrentPlayer().setVideoTag(iArr);
    }

    @Override // com.aliyun.player.IPlayer
    public void setVolume(float f) {
        getCurrentPlayer().setVolume(f);
    }

    @Override // com.aliyun.player.IPlayer
    public void snapshot() {
        getCurrentPlayer().snapshot();
    }

    @Override // com.aliyun.player.IPlayer
    public void start() {
        getCurrentPlayer().start();
    }

    @Override // com.aliyun.player.IPlayer
    public void stop() {
        getCurrentPlayer().stop();
    }

    @Override // com.aliyun.player.IPlayer
    public void surfaceChanged() {
        getCurrentPlayer().surfaceChanged();
    }

    @Override // com.aliyun.player.IPlayer
    public void switchStream(java.lang.String str) {
        getCurrentPlayer().switchStream(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void updateFilterConfig(java.lang.String str, com.aliyun.player.FilterConfig.FilterOptions filterOptions) {
        getCurrentPlayer().updateFilterConfig(str, filterOptions);
    }
}
