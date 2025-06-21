package cn.jzvd;

/* loaded from: classes.dex */
public class JZMediaSystem extends cn.jzvd.JZMediaInterface implements android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnSeekCompleteListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnVideoSizeChangedListener {
    public android.media.MediaPlayer mediaPlayer;

    public JZMediaSystem(cn.jzvd.Jzvd jzvd) {
        super(jzvd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(int i) {
        this.jzvd.setBufferProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        this.jzvd.onCompletion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int i, int i2) {
        this.jzvd.onError(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(int i, int i2) {
        this.jzvd.onInfo(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        this.jzvd.onPrepared();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        this.jzvd.onSeekComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(int i, int i2) {
        this.jzvd.onVideoSizeChanged(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.mediaPlayer.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        try {
            android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setLooping(this.jzvd.jzDataSource.looping);
            this.mediaPlayer.setOnPreparedListener(this);
            this.mediaPlayer.setOnCompletionListener(this);
            this.mediaPlayer.setOnBufferingUpdateListener(this);
            this.mediaPlayer.setScreenOnWhilePlaying(true);
            this.mediaPlayer.setOnSeekCompleteListener(this);
            this.mediaPlayer.setOnErrorListener(this);
            this.mediaPlayer.setOnInfoListener(this);
            this.mediaPlayer.setOnVideoSizeChangedListener(this);
            android.media.MediaPlayer.class.getDeclaredMethod("setDataSource", java.lang.String.class, java.util.Map.class).invoke(this.mediaPlayer, this.jzvd.jzDataSource.getCurrentUrl().toString(), this.jzvd.jzDataSource.headerMap);
            this.mediaPlayer.prepareAsync();
            this.mediaPlayer.setSurface(new android.view.Surface(this.SAVED_SURFACE));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void w(android.media.MediaPlayer mediaPlayer, android.os.HandlerThread handlerThread) {
        mediaPlayer.setSurface(null);
        mediaPlayer.release();
        handlerThread.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(long j) {
        try {
            this.mediaPlayer.seekTo((int) j);
        } catch (java.lang.IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(float f, float f2) {
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        this.mediaPlayer.start();
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getCurrentPosition() {
        if (this.mediaPlayer != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getDuration() {
        if (this.mediaPlayer != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isMute() {
        return false;
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i) {
        this.handler.post(new defpackage.au0(this, i));
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(android.media.MediaPlayer mediaPlayer) {
        this.handler.post(new defpackage.zt0(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        this.handler.post(new defpackage.tt0(this, i, i2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        this.handler.post(new defpackage.du0(this, i, i2));
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(android.media.MediaPlayer mediaPlayer) {
        this.handler.post(new defpackage.st0(this));
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(android.media.MediaPlayer mediaPlayer) {
        this.handler.post(new defpackage.vt0(this));
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

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        this.handler.post(new defpackage.yt0(this, i, i2));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause() {
        pause(true);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause(boolean z) {
        this.mMediaHandler.post(new defpackage.wt0(this));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void prepare() {
        release();
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("JZVD");
        this.mMediaHandlerThread = handlerThread;
        handlerThread.start();
        this.mMediaHandler = new android.os.Handler(this.mMediaHandlerThread.getLooper());
        this.handler = new android.os.Handler();
        this.mMediaHandler.post(new defpackage.cu0(this));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void release() {
        android.os.HandlerThread handlerThread;
        android.media.MediaPlayer mediaPlayer;
        android.os.Handler handler = this.mMediaHandler;
        if (handler == null || (handlerThread = this.mMediaHandlerThread) == null || (mediaPlayer = this.mediaPlayer) == null) {
            return;
        }
        this.SAVED_SURFACE = null;
        handler.post(new defpackage.eu0(mediaPlayer, handlerThread));
        this.mediaPlayer = null;
    }

    @Override // cn.jzvd.JZMediaInterface
    public void seekTo(long j) {
        this.mMediaHandler.post(new defpackage.xt0(this, j));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setMute(boolean z) {
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSpeed(float f) {
        android.media.PlaybackParams playbackParams;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            playbackParams = this.mediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f);
            this.mediaPlayer.setPlaybackParams(playbackParams);
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSurface(android.view.Surface surface) {
        this.mediaPlayer.setSurface(surface);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setVolume(float f, float f2) {
        android.os.Handler handler = this.mMediaHandler;
        if (handler == null) {
            return;
        }
        handler.post(new defpackage.bu0(this, f, f2));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void start() {
        this.mMediaHandler.post(new defpackage.ut0(this));
    }
}
