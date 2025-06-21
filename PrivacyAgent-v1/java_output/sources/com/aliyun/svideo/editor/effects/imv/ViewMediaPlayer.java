package com.aliyun.svideo.editor.effects.imv;

/* loaded from: classes12.dex */
public class ViewMediaPlayer extends android.view.TextureView implements android.view.TextureView.SurfaceTextureListener, android.media.MediaPlayer.OnSeekCompleteListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnVideoSizeChangedListener {
    private boolean mIsVideoReadyToBePlayed;
    private final int[] mLock;
    public android.media.MediaPlayer mMediaPlayer;
    private android.view.Surface mSurface;
    private android.graphics.SurfaceTexture mSurfaceTexture;
    private android.net.Uri mUri;
    private android.view.View mView;

    public ViewMediaPlayer(android.content.Context context, android.util.AttributeSet attributeSet, android.net.Uri uri, android.view.View view) {
        super(context, attributeSet);
        this.mIsVideoReadyToBePlayed = false;
        this.mMediaPlayer = null;
        this.mUri = uri;
        this.mLock = new int[0];
        this.mView = view;
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        setSurfaceTextureListener(this);
    }

    private void loadVideo() {
        setScaleX(1.0001f);
        setScaleY(1.0001f);
        android.graphics.SurfaceTexture surfaceTexture = getSurfaceTexture();
        this.mSurfaceTexture = surfaceTexture;
        if (surfaceTexture == null) {
            return;
        }
        release();
        this.mMediaPlayer = new android.media.MediaPlayer();
        this.mSurface = new android.view.Surface(this.mSurfaceTexture);
        android.net.Uri uri = this.mUri;
        if (uri != null) {
            try {
                this.mMediaPlayer.setDataSource(uri.toString());
                this.mMediaPlayer.setSurface(this.mSurface);
                this.mMediaPlayer.setOnSeekCompleteListener(this);
                this.mMediaPlayer.setOnPreparedListener(this);
                this.mMediaPlayer.setOnErrorListener(null);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setLooping(true);
                this.mMediaPlayer.prepareAsync();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } catch (java.lang.NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void release() {
        synchronized (this.mLock) {
            android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.mMediaPlayer.stop();
                }
                this.mMediaPlayer.reset();
                this.mMediaPlayer.release();
                this.mMediaPlayer = null;
            }
        }
    }

    public android.view.View getShowView() {
        return this;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(android.media.MediaPlayer mediaPlayer) {
        this.mIsVideoReadyToBePlayed = true;
        startVideoPlay();
        this.mView.setVisibility(8);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(android.media.MediaPlayer mediaPlayer) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        loadVideo();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        release();
        android.graphics.SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        android.view.Surface surface = this.mSurface;
        if (surface == null) {
            return true;
        }
        surface.release();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i, int i2) {
    }

    public void startVideoPlay() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (this.mIsVideoReadyToBePlayed) {
            try {
                this.mMediaPlayer.start();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }
}
