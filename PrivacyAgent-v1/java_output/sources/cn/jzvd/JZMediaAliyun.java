package cn.jzvd;

/* loaded from: classes.dex */
public class JZMediaAliyun extends cn.jzvd.JZMediaInterface implements com.aliyun.player.IPlayer.OnPreparedListener, com.aliyun.player.IPlayer.OnVideoSizeChangedListener, com.aliyun.player.IPlayer.OnCompletionListener, com.aliyun.player.IPlayer.OnErrorListener, com.aliyun.player.IPlayer.OnInfoListener, com.aliyun.player.IPlayer.OnSeekCompleteListener, com.aliyun.player.IPlayer.OnRenderingStartListener, com.aliyun.player.IPlayer.OnLoadingStatusListener {
    public final java.lang.String n;
    public int t;
    public com.aliyun.player.AliListPlayer u;
    public boolean v;
    public long w;
    public int x;

    /* renamed from: cn.jzvd.JZMediaAliyun$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (cn.jzvd.JZMediaAliyun.this.u != null) {
                cn.jzvd.JZMediaAliyun jZMediaAliyun = cn.jzvd.JZMediaAliyun.this;
                if (jZMediaAliyun.jzvd == null) {
                    return;
                }
                cn.jzvd.JZMediaAliyun.this.jzvd.onVideoSizeChanged(jZMediaAliyun.u.getVideoWidth(), cn.jzvd.JZMediaAliyun.this.u.getVideoHeight());
            }
        }
    }

    public JZMediaAliyun(cn.jzvd.Jzvd jzvd) {
        super(jzvd);
        this.t = -1;
        this.x = 0;
        release();
        this.mMediaHandler = new android.os.Handler();
        this.handler = new android.os.Handler();
        this.n = com.moji.aliyun.AliPlayerManager.getCachePath(jzvd.getContext());
        this.u = com.aliyun.player.AliPlayerFactory.createAliListPlayer(jzvd.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        this.jzvd.onStatePlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        this.jzvd.onCompletion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(com.aliyun.player.bean.ErrorInfo errorInfo) {
        this.jzvd.onError(errorInfo.getCode().getValue(), errorInfo.getCode().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(long j) {
        this.jzvd.setBufferProgress((int) j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        this.jzvd.onAliyunCurrentPositionChange(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(com.aliyun.player.bean.InfoBean infoBean) {
        this.jzvd.onInfo(5768, infoBean.getCode().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.jzvd.setReplayTimes(this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.jzvd.onLoadingBegin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        this.jzvd.onLoadingEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(int i) {
        this.jzvd.setBufferProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        this.jzvd.onPrepared();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        this.jzvd.onSeekComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(boolean z) {
        this.jzvd.onStatePause(z);
    }

    public int getCacheRotation(java.lang.Object obj) {
        cn.jzvd.Jzvd jzvd = this.jzvd;
        if (jzvd == null) {
            return -1;
        }
        return jzvd.getContext().getSharedPreferences("ALIYUN_ROTATION", 0).getInt("rotate:" + obj.toString(), -1);
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getCurrentPosition() {
        if (this.u != null) {
            return this.w;
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getDuration() {
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            return aliListPlayer.getDuration();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isMute() {
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            return aliListPlayer.isMute();
        }
        return false;
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isPlaying() {
        return this.v;
    }

    @Override // com.aliyun.player.IPlayer.OnCompletionListener
    public void onCompletion() {
        this.v = false;
        this.w = 0L;
        this.handler.post(new defpackage.xs0(this));
    }

    @Override // com.aliyun.player.IPlayer.OnErrorListener
    public void onError(com.aliyun.player.bean.ErrorInfo errorInfo) {
        this.v = false;
        this.w = 0L;
        this.handler.post(new defpackage.gt0(this, errorInfo));
    }

    @Override // com.aliyun.player.IPlayer.OnInfoListener
    public void onInfo(com.aliyun.player.bean.InfoBean infoBean) {
        if (infoBean.getCode() == com.aliyun.player.bean.InfoCode.AutoPlayStart) {
            this.v = true;
        } else if (infoBean.getCode() == com.aliyun.player.bean.InfoCode.BufferedPosition) {
            this.handler.post(new defpackage.zs0(this, infoBean.getExtraValue()));
        } else if (infoBean.getCode() == com.aliyun.player.bean.InfoCode.CurrentPosition) {
            this.w = infoBean.getExtraValue();
            this.handler.post(new defpackage.at0(this));
        } else {
            this.handler.post(new defpackage.bt0(this, infoBean));
        }
        if (infoBean.getCode() == com.aliyun.player.bean.InfoCode.LoopingStart) {
            this.x++;
            this.handler.post(new defpackage.ct0(this));
        }
    }

    @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
    public void onLoadingBegin() {
        this.handler.post(new defpackage.ht0(this));
    }

    @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
    public void onLoadingEnd() {
        this.handler.post(new defpackage.ws0(this));
    }

    @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
    public void onLoadingProgress(int i, float f) {
        this.handler.post(new defpackage.ft0(this, i));
    }

    @Override // com.aliyun.player.IPlayer.OnPreparedListener
    public void onPrepared() {
        this.handler.post(new defpackage.ys0(this));
    }

    @Override // com.aliyun.player.IPlayer.OnRenderingStartListener
    public void onRenderingStart() {
    }

    @Override // com.aliyun.player.IPlayer.OnSeekCompleteListener
    public void onSeekComplete() {
        this.handler.post(new defpackage.et0(this));
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
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            aliListPlayer.redraw();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    @Override // com.aliyun.player.IPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2) {
        if (this.u != null && !android.text.TextUtils.isEmpty(this.n)) {
            if (this.t == -1) {
                if (getCacheRotation(this.jzvd.jzDataSource.getCurrentUrl()) == -1) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("第一次播放, 记录角度:");
                    sb.append(this.u.getVideoRotation());
                    this.t = this.u.getVideoRotation();
                    saveCacheRotation(this.jzvd.jzDataSource.getCurrentUrl(), this.u.getVideoRotation());
                } else {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("第一次播放, 获取角度:");
                    sb2.append(getCacheRotation(this.jzvd.jzDataSource.getCurrentUrl()));
                    this.t = getCacheRotation(this.jzvd.jzDataSource.getCurrentUrl());
                }
            }
            if (this.t != this.u.getVideoRotation()) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("角度应旋转:");
                sb3.append(this.t);
                this.jzvd.setTextureViewRotation(this.t);
            }
        }
        this.handler.post(new cn.jzvd.JZMediaAliyun.AnonymousClass1());
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause() {
        pause(true);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause(boolean z) {
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            this.v = false;
            aliListPlayer.pause();
            if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
                this.jzvd.onStatePause(z);
            } else {
                this.handler.post(new defpackage.vs0(this, z));
            }
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void prepare() {
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer == null) {
            return;
        }
        com.aliyun.player.nativeclass.PlayerConfig config = aliListPlayer.getConfig();
        config.mNetworkTimeout = 10000;
        config.mNetworkRetryCount = 2;
        config.mMaxDelayTime = 5000;
        config.mMaxBufferDuration = 10000;
        config.mHighBufferDuration = 3000;
        config.mStartBufferDuration = 500;
        config.mMaxBackwardBufferDurationMs = 0L;
        this.u.setConfig(config);
        if (!android.text.TextUtils.isEmpty(this.n)) {
            com.aliyun.player.nativeclass.CacheConfig cacheConfig = new com.aliyun.player.nativeclass.CacheConfig();
            cacheConfig.mEnable = true;
            cacheConfig.mMaxDurationS = 500L;
            cacheConfig.mDir = this.n;
            cacheConfig.mMaxSizeMB = 192;
            this.u.setCacheConfig(cacheConfig);
        }
        this.u.setLoop(this.jzvd.jzDataSource.looping);
        this.u.setMute(true);
        this.u.setOnPreparedListener(this);
        this.u.setOnVideoSizeChangedListener(this);
        this.u.setOnCompletionListener(this);
        this.u.setOnErrorListener(this);
        this.u.setOnInfoListener(this);
        this.u.setOnSeekCompleteListener(this);
        this.u.setOnRenderingStartListener(this);
        this.u.setOnLoadingStatusListener(this);
        this.u.setScaleMode(com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FILL);
        try {
            com.aliyun.player.source.UrlSource urlSource = new com.aliyun.player.source.UrlSource();
            urlSource.setUri(this.jzvd.jzDataSource.getCurrentUrl().toString());
            this.u.setDataSource(urlSource);
            this.u.setSurface(new android.view.Surface(this.SAVED_SURFACE));
            this.u.prepare();
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void release() {
        android.os.Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        android.os.Handler handler2 = this.mMediaHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            this.SAVED_SURFACE = null;
            this.v = false;
            this.w = 0L;
            aliListPlayer.setSurface(null);
            this.u.release();
            this.u = null;
        }
    }

    public void saveCacheRotation(java.lang.Object obj, int i) {
        cn.jzvd.Jzvd jzvd = this.jzvd;
        if (jzvd == null) {
            return;
        }
        jzvd.getContext().getSharedPreferences("ALIYUN_ROTATION", 0).edit().putInt("rotate:" + obj.toString(), i).apply();
    }

    @Override // cn.jzvd.JZMediaInterface
    public void seekTo(long j) {
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            aliListPlayer.seekTo(j, com.aliyun.player.IPlayer.SeekMode.Accurate);
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setMute(boolean z) {
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            aliListPlayer.setMute(z);
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSpeed(float f) {
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            aliListPlayer.setSpeed(f);
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSurface(android.view.Surface surface) {
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            aliListPlayer.setSurface(surface);
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setVolume(float f, float f2) {
        this.u.setVolume(java.lang.Math.max(f, f2));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void start() {
        com.aliyun.player.AliListPlayer aliListPlayer = this.u;
        if (aliListPlayer != null) {
            this.v = true;
            aliListPlayer.start();
            if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
                this.jzvd.onStatePlaying();
            } else {
                this.handler.post(new defpackage.dt0(this));
            }
        }
    }
}
