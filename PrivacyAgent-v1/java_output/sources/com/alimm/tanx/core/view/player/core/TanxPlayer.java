package com.alimm.tanx.core.view.player.core;

/* loaded from: classes.dex */
public class TanxPlayer implements android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnSeekCompleteListener, android.media.MediaPlayer.OnVideoSizeChangedListener, com.alimm.tanx.core.view.player.core.ITanxPlayer {
    private static final java.lang.String TAG = "TanxPlayer";
    private int bufferPercent;
    private final android.media.MediaPlayer mediaPlayer;
    private float mediaPlayerVolume;
    private com.alimm.tanx.core.view.player.core.OnVideoBufferingListener onVideoBufferingListener;
    private com.alimm.tanx.core.view.player.core.OnVideoErrorListener onVideoErrorListener;
    private com.alimm.tanx.core.view.player.core.OnVideoSizeChangeListener onVideoSizeChangeListener;
    private com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener onVideoStateChangeListener;
    private boolean playWhenReady;
    private com.alimm.tanx.core.view.player.core.PlayerState playerState;
    private java.lang.String url;

    public TanxPlayer() {
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        this.url = "";
        this.mediaPlayerVolume = 1.0f;
        this.playWhenReady = true;
        this.playerState = com.alimm.tanx.core.view.player.core.PlayerState.IDLE;
        mediaPlayer.setScreenOnWhilePlaying(true);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnSeekCompleteListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnInfoListener(this);
        mediaPlayer.setOnVideoSizeChangedListener(this);
    }

    private void setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState playerState) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, playerState.name());
        this.playerState = playerState;
        if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.PREPARED) {
            this.mediaPlayer.setVideoScalingMode(1);
        }
        com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener onVideoStateChangeListener = this.onVideoStateChangeListener;
        if (onVideoStateChangeListener != null) {
            onVideoStateChangeListener.onStateChange(this, playerState);
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public com.alimm.tanx.core.view.player.core.ITanxPlayer create() {
        return new com.alimm.tanx.core.view.player.core.TanxPlayer();
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public int getBufferPercent() {
        return this.bufferPercent;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public long getCurrentPosition() {
        try {
            return this.mediaPlayer.getCurrentPosition();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public long getDuration() {
        try {
            return this.mediaPlayer.getDuration();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public com.alimm.tanx.core.view.player.core.PlayerState getState() {
        return this.playerState;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public java.lang.String getUrl() {
        return this.url;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public int getVideoHeight() {
        try {
            return this.mediaPlayer.getVideoHeight();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public int getVideoWidth() {
        try {
            return this.mediaPlayer.getVideoWidth();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public float getVolume() {
        return this.mediaPlayerVolume;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public boolean isPlayWhenReady() {
        return this.playWhenReady;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public boolean isPlaying() {
        try {
            return this.mediaPlayer.isPlaying();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i) {
        this.bufferPercent = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(android.media.MediaPlayer mediaPlayer) {
        setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.ERROR);
        com.alimm.tanx.core.view.player.core.OnVideoErrorListener onVideoErrorListener = this.onVideoErrorListener;
        if (onVideoErrorListener == null) {
            return true;
        }
        onVideoErrorListener.onError(this, new com.alimm.tanx.core.request.TanxPlayerError("playerError", i, i2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        com.alimm.tanx.core.view.player.core.OnVideoBufferingListener onVideoBufferingListener = this.onVideoBufferingListener;
        if (onVideoBufferingListener == null) {
            return false;
        }
        if (i == 701) {
            onVideoBufferingListener.OnBufferStateChanged(com.alimm.tanx.core.view.player.core.PlayerBufferingState.BUFFERING_START);
            return false;
        }
        onVideoBufferingListener.OnBufferStateChanged(com.alimm.tanx.core.view.player.core.PlayerBufferingState.BUFFERING_END);
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(android.media.MediaPlayer mediaPlayer) {
        setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.PREPARED);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(android.media.MediaPlayer mediaPlayer) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        com.alimm.tanx.core.view.player.core.OnVideoSizeChangeListener onVideoSizeChangeListener = this.onVideoSizeChangeListener;
        if (onVideoSizeChangeListener != null) {
            onVideoSizeChangeListener.onVideoSizeChanged(this, i, i2);
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void pause() {
        try {
            this.mediaPlayer.pause();
            setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.PAUSED);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void prepare() {
        try {
            this.mediaPlayer.prepare();
            setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.PREPARED);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void prepareAsync() {
        try {
            this.mediaPlayer.prepareAsync();
            setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.PREPARING);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void release() {
        try {
            this.mediaPlayer.release();
            setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.END);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void reset() {
        try {
            this.mediaPlayer.reset();
            setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.IDLE);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void seekTo(long j) {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                this.mediaPlayer.seekTo(j, 3);
            } else {
                this.mediaPlayer.seekTo((int) j);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setDataSource(android.content.Context context, android.net.Uri uri) {
        setDataSource(context, uri, null);
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setDataSource(android.content.Context context, android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            this.mediaPlayer.setDataSource(context, uri, map);
            setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.INITIALIZED);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setDataSource(android.content.Context context, java.lang.String str) {
        setDataSource(context, android.net.Uri.parse(str));
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        try {
            this.mediaPlayer.setDisplay(surfaceHolder);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setLooping(boolean z) {
        try {
            this.mediaPlayer.setLooping(z);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setOnVideoBufferingStateChangeListener(com.alimm.tanx.core.view.player.core.OnVideoBufferingListener onVideoBufferingListener) {
        this.onVideoBufferingListener = onVideoBufferingListener;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setOnVideoErrorListener(com.alimm.tanx.core.view.player.core.OnVideoErrorListener onVideoErrorListener) {
        this.onVideoErrorListener = onVideoErrorListener;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setOnVideoSizeChangeListener(com.alimm.tanx.core.view.player.core.OnVideoSizeChangeListener onVideoSizeChangeListener) {
        this.onVideoSizeChangeListener = onVideoSizeChangeListener;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setOnVideoStateChangeListener(com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener onVideoStateChangeListener) {
        this.onVideoStateChangeListener = onVideoStateChangeListener;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setPlayWhenReady(boolean z) {
        this.playWhenReady = z;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setSurface(android.view.Surface surface) {
        try {
            this.mediaPlayer.setSurface(surface);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setVolume(float f) {
        try {
            this.mediaPlayer.setVolume(f, f);
            this.mediaPlayerVolume = f;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void start() {
        try {
            this.mediaPlayer.start();
            setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.STARTED);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void stop() {
        try {
            this.mediaPlayer.stop();
            setPlayerState(com.alimm.tanx.core.view.player.core.PlayerState.STOPPED);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
