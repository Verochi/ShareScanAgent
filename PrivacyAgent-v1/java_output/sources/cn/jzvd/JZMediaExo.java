package cn.jzvd;

/* loaded from: classes.dex */
public class JZMediaExo extends cn.jzvd.JZMediaInterface implements com.google.android.exoplayer2.Player.EventListener, com.google.android.exoplayer2.video.VideoListener {
    public com.google.android.exoplayer2.SimpleExoPlayer n;
    public java.lang.Runnable t;
    public java.lang.String u;
    public long v;

    public class onBufferingUpdate implements java.lang.Runnable {
        public onBufferingUpdate() {
        }

        public /* synthetic */ onBufferingUpdate(cn.jzvd.JZMediaExo jZMediaExo, defpackage.ot0 ot0Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i) {
            cn.jzvd.JZMediaExo.this.jzvd.setBufferProgress(i);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (cn.jzvd.JZMediaExo.this.n != null) {
                int bufferedPercentage = cn.jzvd.JZMediaExo.this.n.getBufferedPercentage();
                cn.jzvd.JZMediaExo.this.handler.post(new cn.jzvd.a(this, bufferedPercentage));
                if (bufferedPercentage < 100) {
                    cn.jzvd.JZMediaExo jZMediaExo = cn.jzvd.JZMediaExo.this;
                    jZMediaExo.handler.postDelayed(jZMediaExo.t, 300L);
                } else {
                    cn.jzvd.JZMediaExo jZMediaExo2 = cn.jzvd.JZMediaExo.this;
                    jZMediaExo2.handler.removeCallbacks(jZMediaExo2.t);
                }
            }
        }
    }

    public JZMediaExo(cn.jzvd.Jzvd jzvd) {
        super(jzvd);
        this.u = "JZMediaExo";
        this.v = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        this.jzvd.onError(1000, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int i, boolean z) {
        if (i == 2) {
            this.jzvd.onStatePreparingPlaying();
            this.handler.post(this.t);
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            this.jzvd.onCompletion();
        } else if (z) {
            this.jzvd.onPrepared();
            this.jzvd.onStatePlaying();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.jzvd.onSeekComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i, float f, int i2) {
        this.jzvd.onVideoSizeChanged((int) (i * f), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(android.content.Context context) {
        android.graphics.SurfaceTexture surfaceTexture;
        this.n = new com.google.android.exoplayer2.SimpleExoPlayer.Builder(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context)).setTrackSelector(new com.google.android.exoplayer2.trackselection.DefaultTrackSelector(context, new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory())).setLoadControl(new com.google.android.exoplayer2.DefaultLoadControl.Builder().setAllocator(new com.google.android.exoplayer2.upstream.DefaultAllocator(true, 65536)).setBufferDurationsMs(360000, 600000, 1000, 5000).setPrioritizeTimeOverSizeThresholds(false).setTargetBufferBytes(-1).createDefaultLoadControl()).setBandwidthMeter(new com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder(context).build()).build();
        com.google.android.exoplayer2.upstream.DefaultDataSourceFactory defaultDataSourceFactory = new com.google.android.exoplayer2.upstream.DefaultDataSourceFactory(context, com.google.android.exoplayer2.util.Util.getUserAgent(context, context.getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.app_name)));
        java.lang.String obj = this.jzvd.jzDataSource.getCurrentUrl().toString();
        com.google.android.exoplayer2.source.MediaSource createMediaSource = obj.contains(".m3u8") ? new com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory(defaultDataSourceFactory).createMediaSource(android.net.Uri.parse(obj)) : new com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory(defaultDataSourceFactory).createMediaSource(android.net.Uri.parse(obj));
        this.n.addVideoListener(this);
        com.moji.tool.log.MJLogger.e(this.u, "URL Link = " + obj);
        this.n.addListener(this);
        cn.jzvd.Jzvd jzvd = this.jzvd;
        if (jzvd.needRepeat) {
            this.n.setRepeatMode(2);
        } else if (jzvd.jzDataSource.looping) {
            this.n.setRepeatMode(1);
        } else {
            this.n.setRepeatMode(0);
        }
        this.n.prepare(createMediaSource);
        this.n.setPlayWhenReady(true);
        this.t = new cn.jzvd.JZMediaExo.onBufferingUpdate(this, null);
        cn.jzvd.JZTextureView jZTextureView = this.jzvd.textureView;
        if (jZTextureView == null || (surfaceTexture = jZTextureView.getSurfaceTexture()) == null) {
            return;
        }
        this.n.setVideoSurface(new android.view.Surface(surfaceTexture));
    }

    public static /* synthetic */ void n(com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer, android.os.HandlerThread handlerThread) {
        simpleExoPlayer.release();
        handlerThread.quit();
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getCurrentPosition() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.n;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getDuration() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.n;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.getDuration();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isMute() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.n;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.isDeviceMuted();
        }
        return false;
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isPlaying() {
        return this.n.getPlayWhenReady();
    }

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
    public void onLoadingChanged(boolean z) {
        com.moji.tool.log.MJLogger.e(this.u, "onLoadingChanged");
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
    public void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
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
    public void onPlayerError(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        com.moji.tool.log.MJLogger.e(this.u, "onPlayerError" + exoPlaybackException.toString());
        this.handler.post(new defpackage.it0(this));
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        com.moji.tool.log.MJLogger.e(this.u, "onPlayerStateChanged" + i + "/ready=" + java.lang.String.valueOf(z));
        this.handler.post(new defpackage.mt0(this, i, z));
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i) {
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onRenderedFirstFrame() {
        com.moji.tool.log.MJLogger.e(this.u, "onRenderedFirstFrame");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int i) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
        this.handler.post(new defpackage.nt0(this));
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
        defpackage.y93.b(this, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        android.graphics.SurfaceTexture surfaceTexture2 = this.SAVED_SURFACE;
        if (surfaceTexture2 != null) {
            this.jzvd.textureView.setSurfaceTexture(surfaceTexture2);
        } else {
            this.SAVED_SURFACE = surfaceTexture;
            prepare();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
        defpackage.h32.p(this, timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i) {
        com.moji.tool.log.MJLogger.e(this.u, "onTimelineChanged");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        com.moji.tool.log.MJLogger.i("JVZDOnVideo", "width: " + i + "  height: " + i2 + "  pixelWidthHeightRatio: " + f);
        this.handler.post(new defpackage.lt0(this, i, f, i2));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause() {
        pause(true);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause(boolean z) {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.n;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void prepare() {
        com.moji.tool.log.MJLogger.e(this.u, "prepare");
        android.content.Context context = this.jzvd.getContext();
        release();
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("JZVD");
        this.mMediaHandlerThread = handlerThread;
        handlerThread.start();
        this.mMediaHandler = new android.os.Handler(context.getMainLooper());
        this.handler = new android.os.Handler();
        this.mMediaHandler.post(new defpackage.jt0(this, context));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void release() {
        android.os.HandlerThread handlerThread;
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer;
        android.os.Handler handler = this.mMediaHandler;
        if (handler == null || (handlerThread = this.mMediaHandlerThread) == null || (simpleExoPlayer = this.n) == null) {
            return;
        }
        this.SAVED_SURFACE = null;
        handler.post(new defpackage.kt0(simpleExoPlayer, handlerThread));
        this.n = null;
    }

    @Override // cn.jzvd.JZMediaInterface
    public void seekTo(long j) {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.n;
        if (simpleExoPlayer == null || j == this.v) {
            return;
        }
        if (j >= simpleExoPlayer.getBufferedPosition()) {
            this.jzvd.onStatePreparingPlaying();
        }
        this.n.seekTo(j);
        this.v = j;
        this.jzvd.seekToInAdvance = j;
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setMute(boolean z) {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.n;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setDeviceMuted(z);
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSpeed(float f) {
        this.n.setPlaybackParameters(new com.google.android.exoplayer2.PlaybackParameters(f, 1.0f));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSurface(android.view.Surface surface) {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.n;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoSurface(surface);
        } else {
            com.moji.tool.log.MJLogger.e("AGVideo", "simpleExoPlayer为空");
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setVolume(float f, float f2) {
        this.n.setVolume(f);
        this.n.setVolume(f2);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void start() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.n;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
    }
}
