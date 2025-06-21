package com.alimm.tanx.core.view.player.ui;

/* loaded from: classes.dex */
public class TanxPlayerView extends com.alimm.tanx.core.ad.view.TanxAdView implements android.view.TextureView.SurfaceTextureListener, com.alimm.tanx.core.view.player.ui.ITanxPlayerView {
    private static final java.lang.String TAG = "TanxPlayerView";
    private com.alimm.tanx.core.view.player.core.audio.IAudioManager audioManager;
    private java.lang.String coverUrl;
    private android.widget.ImageView coverView;
    private android.graphics.Bitmap firstFrame;
    private com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
    private android.graphics.Matrix matrix;
    private com.alimm.tanx.core.view.player.core.OnVideoBufferingListener onVideoBufferingListener;
    private com.alimm.tanx.core.view.player.core.OnVideoErrorListener onVideoErrorListener;
    private com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener onVideoStateChangeListener;
    private android.view.Surface surface;
    private boolean surfaceIsDestroy;
    private android.graphics.SurfaceTexture surfaceTexture;
    private android.view.TextureView textureView;
    private com.alimm.tanx.core.view.player.VideoScaleMode videoScaleMode;
    private java.lang.String videoUrl;

    /* renamed from: com.alimm.tanx.core.view.player.ui.TanxPlayerView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener {
        final /* synthetic */ com.alimm.tanx.core.view.player.core.ITanxPlayer val$iTanxPlayer;

        public AnonymousClass1(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer) {
            this.val$iTanxPlayer = iTanxPlayer;
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
        public void onStateChange(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer, com.alimm.tanx.core.view.player.core.PlayerState playerState) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.view.player.ui.TanxPlayerView.TAG, "onStateChange:" + playerState.name());
            if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.PREPARED) {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.loadImg(true);
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.coverView.setVisibility(8);
                com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer2 = this.val$iTanxPlayer;
                iTanxPlayer2.seekTo(iTanxPlayer2.getCurrentPosition());
                if (this.val$iTanxPlayer.isPlayWhenReady()) {
                    this.val$iTanxPlayer.start();
                }
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.setBackgroundResource(com.alimm.tanx.core.R.color.transparent);
            } else if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.STARTED) {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.coverView.setVisibility(8);
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.loadWeb();
                com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer3 = this.val$iTanxPlayer;
                if (iTanxPlayer3 != null && iTanxPlayer3.getVolume() > 0.0f && com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.audioManager != null) {
                    com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.audioManager.requestAudioFocus();
                }
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.view.player.ui.TanxPlayerView.TAG, " getVolume:" + this.val$iTanxPlayer.getVolume());
            } else if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED) {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.loadImg(false);
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.coverView.setVisibility(0);
            } else if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.STOPPED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.END) {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.audioManager.abandonAudioFocus();
            } else if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.ERROR) {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.audioManager.abandonAudioFocus();
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.loadImg(false);
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.coverView.setVisibility(0);
            }
            if (com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.onVideoStateChangeListener != null) {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.onVideoStateChangeListener.onStateChange(iTanxPlayer, playerState);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.view.player.ui.TanxPlayerView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.view.player.core.OnVideoBufferingListener {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
        public void OnBufferStateChanged(com.alimm.tanx.core.view.player.core.PlayerBufferingState playerBufferingState) {
            if (com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.onVideoBufferingListener != null) {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.onVideoBufferingListener.OnBufferStateChanged(playerBufferingState);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.view.player.ui.TanxPlayerView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.view.player.core.OnVideoErrorListener {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
        public boolean onError(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer, com.alimm.tanx.core.request.TanxPlayerError tanxPlayerError) {
            if (com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.onVideoErrorListener == null) {
                return false;
            }
            com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.onVideoErrorListener.onError(iTanxPlayer, tanxPlayerError);
            return false;
        }
    }

    /* renamed from: com.alimm.tanx.core.view.player.ui.TanxPlayerView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.view.player.core.OnVideoSizeChangeListener {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoSizeChangeListener
        public void onVideoSizeChanged(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer, int i, int i2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onVideoSizeChanged, width=");
            sb.append(i);
            sb.append(",");
            sb.append("height=");
            sb.append(i2);
            com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.transformVideo(i, i2);
        }
    }

    /* renamed from: com.alimm.tanx.core.view.player.ui.TanxPlayerView$5, reason: invalid class name */
    public class AnonymousClass5 implements com.alimm.tanx.core.view.player.ui.TanxPlayerView.IVideoThumb {
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig val$imageConfig;
        final /* synthetic */ long val$startTime;

        /* renamed from: com.alimm.tanx.core.view.player.ui.TanxPlayerView$5$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Bitmap val$bitmap;

            public AnonymousClass1(android.graphics.Bitmap bitmap) {
                this.val$bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.coverView.setImageDrawable(new com.alimm.tanx.core.image.util.TanxDrawable(this.val$bitmap, com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass5.this.val$imageConfig.getImageConfig()));
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.view.player.ui.TanxPlayerView.TAG, "耗时：" + (java.lang.System.currentTimeMillis() - com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass5.this.val$startTime));
            }
        }

        public AnonymousClass5(com.alimm.tanx.core.image.util.ImageConfig imageConfig, long j) {
            this.val$imageConfig = imageConfig;
            this.val$startTime = j;
        }

        @Override // com.alimm.tanx.core.view.player.ui.TanxPlayerView.IVideoThumb
        public void getBitmap(android.graphics.Bitmap bitmap) {
            if (bitmap != null) {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.coverView.post(new com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass5.AnonymousClass1(bitmap));
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.view.player.ui.TanxPlayerView$6, reason: invalid class name */
    public class AnonymousClass6 implements com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback {
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig val$imageConfig;

        public AnonymousClass6(com.alimm.tanx.core.image.util.ImageConfig imageConfig) {
            this.val$imageConfig = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(java.lang.String str) {
            com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.coverView.setVisibility(8);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(android.graphics.Bitmap bitmap) {
            com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.coverView.setImageDrawable(new com.alimm.tanx.core.image.util.TanxDrawable(bitmap, this.val$imageConfig.getImageConfig()));
        }
    }

    /* renamed from: com.alimm.tanx.core.view.player.ui.TanxPlayerView$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.alimm.tanx.core.view.player.ui.TanxPlayerView.IVideoThumb val$iVideoThumb;
        final /* synthetic */ java.lang.String val$videoUrl;

        public AnonymousClass7(java.lang.String str, com.alimm.tanx.core.view.player.ui.TanxPlayerView.IVideoThumb iVideoThumb) {
            this.val$videoUrl = str;
            this.val$iVideoThumb = iVideoThumb;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!android.text.TextUtils.isEmpty(this.val$videoUrl)) {
                    android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                    java.lang.String proxyUrl = com.alimm.tanx.core.TanxCoreSdk.getProxy(com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.getContext()).getProxyUrl(this.val$videoUrl);
                    com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.view.player.ui.TanxPlayerView.TAG, "loadFrameImg:" + proxyUrl);
                    if (android.os.Build.VERSION.SDK_INT >= 30) {
                        mediaMetadataRetriever.setDataSource(proxyUrl);
                    } else if (proxyUrl.contains(".mp4.download")) {
                        mediaMetadataRetriever.setDataSource(proxyUrl, new java.util.HashMap());
                    } else {
                        mediaMetadataRetriever.setDataSource(new java.io.FileInputStream(android.net.Uri.parse(proxyUrl).getEncodedPath()).getFD());
                    }
                    com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.firstFrame = mediaMetadataRetriever.getFrameAtTime(1L, 2);
                    mediaMetadataRetriever.release();
                }
                com.alimm.tanx.core.view.player.ui.TanxPlayerView.IVideoThumb iVideoThumb = this.val$iVideoThumb;
                if (iVideoThumb != null) {
                    iVideoThumb.getBitmap(com.alimm.tanx.core.view.player.ui.TanxPlayerView.this.firstFrame);
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.view.player.ui.TanxPlayerView.TAG, e);
            }
        }
    }

    public interface IVideoThumb {
        void getBitmap(android.graphics.Bitmap bitmap);
    }

    public TanxPlayerView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public TanxPlayerView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public TanxPlayerView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoScaleMode = com.alimm.tanx.core.view.player.VideoScaleMode.CENTER_CROP;
        init();
    }

    private boolean inState(com.alimm.tanx.core.view.player.core.PlayerState... playerStateArr) {
        com.alimm.tanx.core.view.player.core.PlayerState state = getState();
        for (com.alimm.tanx.core.view.player.core.PlayerState playerState : playerStateArr) {
            if (state == playerState) {
                return true;
            }
        }
        return false;
    }

    private void init() {
        this.audioManager = new com.alimm.tanx.core.view.player.core.audio.MediaPlayerAudioManager(getContext(), this.iTanxPlayer);
        android.widget.ImageView imageView = new android.widget.ImageView(getContext());
        this.coverView = imageView;
        imageView.setVisibility(8);
        android.view.TextureView textureView = new android.view.TextureView(getContext());
        this.textureView = textureView;
        textureView.setSurfaceTextureListener(this);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        addView(this.textureView, layoutParams);
        addView(this.coverView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImg(boolean z) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.alimm.tanx.core.image.util.ImageConfig build = com.alimm.tanx.core.image.ImageManager.with(getContext()).url(this.coverUrl).scaleMode(com.alimm.tanx.core.image.util.ScaleMode.FIT_CENTER).build();
        if (z) {
            loadFrameImg(this.videoUrl, new com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass5(build, currentTimeMillis));
        } else {
            if (android.text.TextUtils.isEmpty(this.coverUrl) || com.alimm.tanx.core.image.ImageManager.getLoader() == null) {
                return;
            }
            com.alimm.tanx.core.image.ImageManager.getLoader().load(build, new com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass6(build));
        }
    }

    private void registerMediaPlayerObserver(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer) {
        iTanxPlayer.setOnVideoStateChangeListener(new com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass1(iTanxPlayer));
        iTanxPlayer.setOnVideoBufferingStateChangeListener(new com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass2());
        iTanxPlayer.setOnVideoErrorListener(new com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass3());
        iTanxPlayer.setOnVideoSizeChangeListener(new com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass4());
    }

    private void removeMediaPlayerObserver(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer) {
        iTanxPlayer.setOnVideoStateChangeListener(null);
        iTanxPlayer.setOnVideoBufferingStateChangeListener(null);
        iTanxPlayer.setOnVideoErrorListener(null);
        iTanxPlayer.setOnVideoSizeChangeListener(null);
        this.audioManager.abandonAudioFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transformVideo(int i, int i2) {
        if (getHeight() == 0 || getWidth() == 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("transformVideo, getHeight=");
            sb.append(getHeight());
            sb.append(",");
            sb.append("getWidth=");
            sb.append(getWidth());
            return;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("transformVideo, getMeasuredWidth=");
        sb2.append(getMeasuredWidth());
        sb2.append(" getMeasuredHeight=");
        sb2.append(getMeasuredHeight());
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append("transformVideo, getWidth=");
        sb3.append(getWidth());
        sb3.append(" getHeight=");
        sb3.append(getHeight());
        float f = i;
        float measuredWidth = getMeasuredWidth() / f;
        float f2 = i2;
        float measuredHeight = getMeasuredHeight() / f2;
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append("transformVideo, sx=");
        sb4.append(measuredWidth);
        sb4.append(" sy=");
        sb4.append(measuredHeight);
        android.graphics.Matrix matrix = this.matrix;
        if (matrix == null) {
            this.matrix = new android.graphics.Matrix();
        } else {
            matrix.reset();
        }
        this.matrix.preTranslate((getWidth() - i) / 2, (getHeight() - i2) / 2);
        this.matrix.preScale(f / getWidth(), f2 / getHeight());
        com.alimm.tanx.core.view.player.VideoScaleMode videoScaleMode = this.videoScaleMode;
        if (videoScaleMode == com.alimm.tanx.core.view.player.VideoScaleMode.CENTER_CROP) {
            this.matrix.postScale(measuredWidth, measuredWidth, getWidth() / 2, getHeight() / 2);
        } else if (videoScaleMode == com.alimm.tanx.core.view.player.VideoScaleMode.FIT_CENTER) {
            this.matrix.postScale(java.lang.Math.min(measuredWidth, measuredHeight), java.lang.Math.min(measuredWidth, measuredHeight), getWidth() / 2, getHeight() / 2);
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "transformVideo, maxScale=" + measuredWidth);
        this.textureView.setTransform(this.matrix);
        postInvalidate();
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "transformVideo, videoWidth=" + i + ",videoHeight=" + i2);
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void attach() {
        if (this.surfaceTexture != null) {
            android.view.Surface surface = this.surface;
            if (surface != null) {
                surface.release();
            }
            android.view.Surface surface2 = new android.view.Surface(this.surfaceTexture);
            this.surface = surface2;
            com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
            if (iTanxPlayer != null) {
                iTanxPlayer.setSurface(surface2);
            }
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public long currentPosition() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer == null) {
            return 0L;
        }
        return iTanxPlayer.getCurrentPosition();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public long duration() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
        if (!inState(com.alimm.tanx.core.view.player.core.PlayerState.STARTED, com.alimm.tanx.core.view.player.core.PlayerState.PAUSED, com.alimm.tanx.core.view.player.core.PlayerState.STOPPED, com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return 0L;
        }
        return iTanxPlayer.getDuration();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public int getCurrentPosition() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
        if (!inState(com.alimm.tanx.core.view.player.core.PlayerState.PREPARED, com.alimm.tanx.core.view.player.core.PlayerState.STARTED, com.alimm.tanx.core.view.player.core.PlayerState.PAUSED, com.alimm.tanx.core.view.player.core.PlayerState.STOPPED, com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return 0;
        }
        return (int) iTanxPlayer.getCurrentPosition();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public int getDuration() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
        if (!inState(com.alimm.tanx.core.view.player.core.PlayerState.PREPARED, com.alimm.tanx.core.view.player.core.PlayerState.STARTED, com.alimm.tanx.core.view.player.core.PlayerState.PAUSED, com.alimm.tanx.core.view.player.core.PlayerState.STOPPED, com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return 0;
        }
        return (int) iTanxPlayer.getDuration();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public com.alimm.tanx.core.view.player.core.PlayerState getState() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        return iTanxPlayer == null ? com.alimm.tanx.core.view.player.core.PlayerState.IDLE : iTanxPlayer.getState();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public boolean isPlaying() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        return iTanxPlayer != null && iTanxPlayer.isPlaying();
    }

    public void loadFrameImg(java.lang.String str, com.alimm.tanx.core.view.player.ui.TanxPlayerView.IVideoThumb iVideoThumb) {
        android.graphics.Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            iVideoThumb.getBitmap(bitmap);
        }
        com.alimm.tanx.core.ut.core.thread.VideoSizeThreadPool.post(new com.alimm.tanx.core.view.player.ui.TanxPlayerView.AnonymousClass7(str, iVideoThumb));
    }

    public void loadWeb() {
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void mute() {
        com.alimm.tanx.core.view.player.core.audio.IAudioManager iAudioManager;
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.setVolume(0.0f);
            if (this.iTanxPlayer == null || (iAudioManager = this.audioManager) == null) {
                return;
            }
            iAudioManager.abandonAudioFocus();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onSizeChanged, w=");
        sb.append(i);
        sb.append(",");
        sb.append("h=");
        sb.append(i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        android.graphics.SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 == null) {
            this.surfaceTexture = surfaceTexture;
            attach();
        } else if (surfaceTexture2 != null) {
            this.textureView.setSurfaceTexture(surfaceTexture2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        this.surfaceTexture = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.textureView.getSurfaceTexture() != surfaceTexture) {
            this.textureView.setSurfaceTexture(surfaceTexture);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        if (this.textureView.getSurfaceTexture() != surfaceTexture) {
            this.textureView.setSurfaceTexture(surfaceTexture);
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void pause() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
        if (!inState(com.alimm.tanx.core.view.player.core.PlayerState.STARTED, com.alimm.tanx.core.view.player.core.PlayerState.PAUSED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return;
        }
        iTanxPlayer.pause();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void prepare() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
        attach();
        if (!inState(com.alimm.tanx.core.view.player.core.PlayerState.INITIALIZED, com.alimm.tanx.core.view.player.core.PlayerState.STOPPED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return;
        }
        iTanxPlayer.prepareAsync();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void release() {
        android.graphics.SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.surfaceTexture = null;
        }
        android.view.Surface surface = this.surface;
        if (surface != null) {
            surface.release();
            this.surface = null;
        }
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.release();
            this.iTanxPlayer = null;
            com.alimm.tanx.core.view.player.core.audio.IAudioManager iAudioManager = this.audioManager;
            if (iAudioManager != null) {
                iAudioManager.abandonAudioFocus();
            }
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void replay() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
        if (!inState(com.alimm.tanx.core.view.player.core.PlayerState.PREPARED, com.alimm.tanx.core.view.player.core.PlayerState.STARTED, com.alimm.tanx.core.view.player.core.PlayerState.PAUSED, com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return;
        }
        iTanxPlayer.seekTo(0L);
        this.iTanxPlayer.start();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void reset() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.reset();
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void resumeVolume() {
        com.alimm.tanx.core.view.player.core.audio.IAudioManager iAudioManager;
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.setVolume(1.0f);
        }
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 == null || iTanxPlayer2.getVolume() <= 0.0f || (iAudioManager = this.audioManager) == null) {
            return;
        }
        iAudioManager.requestAudioFocus();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void seekTo(long j) {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
        if (!inState(com.alimm.tanx.core.view.player.core.PlayerState.PREPARED, com.alimm.tanx.core.view.player.core.PlayerState.STARTED, com.alimm.tanx.core.view.player.core.PlayerState.PAUSED, com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return;
        }
        iTanxPlayer.seekTo(j);
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setCover(java.lang.String str) {
        this.coverUrl = str;
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setDataSource(android.net.Uri uri) {
        setDataSource(uri, null);
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setDataSource(android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            if (this.iTanxPlayer != null) {
                java.lang.String uri2 = uri.toString();
                java.lang.String proxyUrl = com.alimm.tanx.core.TanxCoreSdk.getProxy(getContext()).getProxyUrl(uri2);
                if (android.text.TextUtils.isEmpty(uri2) || android.text.TextUtils.isEmpty(proxyUrl)) {
                    loadImg(false);
                    this.coverView.setVisibility(0);
                }
                this.iTanxPlayer.setDataSource(getContext(), android.net.Uri.parse(proxyUrl), map);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("TanxPlayerView setDataSource", e);
            loadImg(false);
            this.coverView.setVisibility(0);
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setDataSource(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.videoUrl = str;
        setDataSource(android.net.Uri.parse(str));
    }

    public void setOnVideoBufferingListener(com.alimm.tanx.core.view.player.core.OnVideoBufferingListener onVideoBufferingListener) {
        this.onVideoBufferingListener = onVideoBufferingListener;
    }

    public void setOnVideoErrorListener(com.alimm.tanx.core.view.player.core.OnVideoErrorListener onVideoErrorListener) {
        this.onVideoErrorListener = onVideoErrorListener;
    }

    public void setOnVideoStateChangeListener(com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener onVideoStateChangeListener) {
        this.onVideoStateChangeListener = onVideoStateChangeListener;
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setTanxPlayer(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer) {
        removeMediaPlayerObserver(iTanxPlayer);
        this.iTanxPlayer = iTanxPlayer;
        registerMediaPlayerObserver(iTanxPlayer);
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setVideoScaleMode(com.alimm.tanx.core.view.player.VideoScaleMode videoScaleMode) {
        this.videoScaleMode = videoScaleMode;
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setVolume(int i) {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.setVolume(i);
            com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
            if (iTanxPlayer2 == null || this.audioManager == null) {
                return;
            }
            if (iTanxPlayer2.getVolume() > 0.0f) {
                this.audioManager.requestAudioFocus();
            } else {
                this.audioManager.abandonAudioFocus();
            }
        }
    }

    public void showCoverView(boolean z) {
        android.widget.ImageView imageView = this.coverView;
        if (imageView != null) {
            imageView.setVisibility(0);
            loadImg(z);
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void start() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
        if (!inState(com.alimm.tanx.core.view.player.core.PlayerState.PREPARED, com.alimm.tanx.core.view.player.core.PlayerState.STARTED, com.alimm.tanx.core.view.player.core.PlayerState.PAUSED, com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return;
        }
        iTanxPlayer.start();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void stop() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
        if (!inState(com.alimm.tanx.core.view.player.core.PlayerState.STARTED, com.alimm.tanx.core.view.player.core.PlayerState.PAUSED, com.alimm.tanx.core.view.player.core.PlayerState.STOPPED, com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return;
        }
        iTanxPlayer.pause();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public int videoHeight() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer == null) {
            return 0;
        }
        return iTanxPlayer.getVideoHeight();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public int videoWidth() {
        com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer == null) {
            return 0;
        }
        return iTanxPlayer.getVideoWidth();
    }
}
