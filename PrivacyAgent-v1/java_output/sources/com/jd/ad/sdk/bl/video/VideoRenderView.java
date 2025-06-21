package com.jd.ad.sdk.bl.video;

/* loaded from: classes23.dex */
public class VideoRenderView extends android.widget.FrameLayout implements android.os.Handler.Callback {
    public static final /* synthetic */ int jad_gp = 0;
    public android.media.MediaPlayer.OnVideoSizeChangedListener jad_al;
    public android.media.MediaPlayer jad_an;
    public android.media.MediaPlayer.OnCompletionListener jad_bm;
    public int jad_bo;
    public int jad_cn;
    public int jad_cp;
    public boolean jad_do;
    public android.content.Context jad_dq;
    public android.media.MediaPlayer.OnErrorListener jad_en;
    public boolean jad_ep;
    public com.jd.ad.sdk.bl.video.jad_an jad_er;
    public android.media.MediaPlayer.OnBufferingUpdateListener jad_fo;
    public android.widget.ImageView jad_fq;
    public int jad_fs;
    public boolean jad_gr;
    public long jad_hs;
    public com.jd.ad.sdk.bl.dynamicrender.ShakeListener jad_hu;
    public com.jd.ad.sdk.bl.video.VideoSkipView jad_it;
    public int jad_iv;
    public com.jd.ad.sdk.bl.video.jad_an.jad_bo jad_jt;
    public android.widget.FrameLayout jad_ju;
    public float jad_jw;
    public android.widget.TextView jad_kv;
    public float jad_kx;
    public java.lang.String jad_lw;
    public float jad_ly;
    public int jad_mx;
    public float jad_mz;
    public float jad_na;
    public com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper jad_ny;
    public boolean jad_ob;
    public java.lang.String jad_oz;
    public int jad_pa;
    public int jad_pc;
    public java.lang.String jad_qb;
    public com.jd.ad.sdk.bl.video.listener.VideoInteractionListener jad_qd;
    public int jad_rc;
    public boolean jad_re;
    public boolean jad_sd;
    public com.jd.ad.sdk.bl.video.VideoRenderView.jad_hu jad_sf;
    public java.lang.String jad_te;
    public com.jd.ad.sdk.lottie.LottieAnimationView jad_tg;
    public com.jd.ad.sdk.bl.video.listener.VideoLoadListener jad_uf;
    public com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener jad_uh;
    public int jad_vg;
    public double jad_vi;
    public boolean jad_wh;
    public double jad_wj;
    public java.lang.String jad_xi;
    public java.lang.String jad_xk;
    public boolean jad_yj;
    public int jad_yl;
    public android.media.MediaPlayer.OnPreparedListener jad_zk;
    public int jad_zm;

    public class jad_an implements android.media.MediaPlayer.OnPreparedListener {
        public jad_an() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer mediaPlayer) {
            com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_yj = true;
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            videoRenderView.jad_cp = 2;
            com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener = videoRenderView.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(2, videoRenderView.getDuration());
            }
            int i = com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_fs;
            if (i > 0 && mediaPlayer.getDuration() > 0) {
                com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_an.seekTo(i);
                com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_fs = 0;
            }
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView2 = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            int i2 = videoRenderView2.jad_bo;
            if (i2 == 3) {
                videoRenderView2.jad_bo = 3;
                try {
                    if (videoRenderView2.jad_an() && (videoRenderView2.getState() == 2 || videoRenderView2.getState() == 4 || videoRenderView2.getState() == 6)) {
                        if (videoRenderView2.jad_an != null && videoRenderView2.jad_bo() && videoRenderView2.jad_yj) {
                            videoRenderView2.jad_an.start();
                        }
                        videoRenderView2.jad_cp = 3;
                    }
                } catch (java.lang.Exception e) {
                    videoRenderView2.jad_an(e);
                }
            } else if (i2 == 4) {
                try {
                    if (videoRenderView2.jad_an()) {
                        int state = videoRenderView2.getState();
                        if (videoRenderView2.jad_an() && state != -2 && state != -1 && state != 0 && state != 1 && state != 4 && state != 5) {
                            videoRenderView2.jad_an.pause();
                            videoRenderView2.jad_cp = 4;
                        }
                    }
                } catch (java.lang.Exception e2) {
                    videoRenderView2.jad_an(e2);
                }
                videoRenderView2.jad_bo = 4;
            } else if (i2 == 5 || i2 == 0) {
                if (videoRenderView2.jad_an()) {
                    videoRenderView2.jad_an.reset();
                    videoRenderView2.jad_cp = 0;
                }
                videoRenderView2.jad_bo = 0;
            }
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView3 = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener2 = videoRenderView3.jad_uh;
            if (onVideoRenderListener2 != null) {
                videoRenderView3.jad_vg = 1;
                onVideoRenderListener2.onVideoRenderSuccess(videoRenderView3);
            }
        }
    }

    public class jad_bo implements android.media.MediaPlayer.OnVideoSizeChangedListener {
        public jad_bo() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i, int i2) {
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            com.jd.ad.sdk.bl.video.jad_an jad_anVar = videoRenderView.jad_er;
            if (jad_anVar != null) {
                jad_anVar.jad_an((int) videoRenderView.jad_vi, (int) videoRenderView.jad_wj);
            }
        }
    }

    public class jad_cp implements android.media.MediaPlayer.OnCompletionListener {
        public jad_cp() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer mediaPlayer) {
            com.jd.ad.sdk.bl.video.VideoRenderView.jad_an(com.jd.ad.sdk.bl.video.VideoRenderView.this, mediaPlayer);
        }
    }

    public class jad_dq implements android.media.MediaPlayer.OnErrorListener {
        public jad_dq() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
            java.lang.String jad_an;
            com.jd.ad.sdk.logger.Logger.d("VideoRenderView Error: " + i + "," + i2);
            com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_re = true;
            com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_an(false);
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            videoRenderView.jad_cp = -1;
            videoRenderView.jad_bo = -1;
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_PLAYBACK_ERROR;
            int i3 = jad_anVar.jad_an;
            jad_anVar.jad_an(new java.lang.String[0]);
            if (i == -1010) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_UNSUPPORTED_ERROR;
                i3 = jad_anVar2.jad_an;
                jad_an = jad_anVar2.jad_an(new java.lang.String[0]);
            } else if (i == -1007) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_MALFORMED_ERROR;
                i3 = jad_anVar3.jad_an;
                jad_an = jad_anVar3.jad_an(new java.lang.String[0]);
            } else if (i == -1004) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_IO_ERROR;
                i3 = jad_anVar4.jad_an;
                jad_an = jad_anVar4.jad_an(new java.lang.String[0]);
            } else if (i == -110) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar5 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_TIMED_OUT_ERROR;
                i3 = jad_anVar5.jad_an;
                jad_an = jad_anVar5.jad_an(new java.lang.String[0]);
            } else if (i == 1) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar6 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_UNKNOWN_ERROR;
                i3 = jad_anVar6.jad_an;
                jad_an = jad_anVar6.jad_an(new java.lang.String[0]);
            } else if (i == 100) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar7 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_SERVER_DIED_ERROR;
                i3 = jad_anVar7.jad_an;
                jad_an = jad_anVar7.jad_an(new java.lang.String[0]);
            } else if (i != 200) {
                jad_an = jad_anVar.jad_an(new java.lang.String[0]) + " " + i;
            } else {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar8 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_PROGRESSIVE_PLAYBACK_ERROR;
                i3 = jad_anVar8.jad_an;
                jad_an = jad_anVar8.jad_an(new java.lang.String[0]);
            }
            java.lang.String str = jad_an;
            int i4 = i3;
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView2 = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener = videoRenderView2.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(7, videoRenderView2.getDuration());
                com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView3 = com.jd.ad.sdk.bl.video.VideoRenderView.this;
                videoRenderView3.jad_uh.videoPlayerError(i4, i, i2, videoRenderView3.getDuration(), str);
            }
            return true;
        }
    }

    public class jad_er implements android.media.MediaPlayer.OnBufferingUpdateListener {
        public jad_er() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i) {
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            int i2 = com.jd.ad.sdk.bl.video.VideoRenderView.jad_gp;
            videoRenderView.getClass();
        }
    }

    public class jad_fs implements android.view.View.OnTouchListener {
        public jad_fs(com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            return true;
        }
    }

    public class jad_hu implements com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an {
        public jad_hu() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_bo() {
            com.jd.ad.sdk.bl.dynamicrender.ShakeListener shakeListener = com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_hu;
            if (shakeListener != null) {
                shakeListener.unregister();
            }
        }
    }

    public static class jad_iv {
        public float jad_an;
        public float jad_bo;
        public com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener jad_cp;
        public int jad_dq;
        public int jad_er;
        public java.lang.String jad_fs;
        public boolean jad_hu;
        public boolean jad_iv;
        public int jad_jt;
        public java.lang.String jad_jw;
        public java.lang.String jad_kx;
        public java.lang.String jad_ly;
        public com.jd.ad.sdk.bl.video.listener.VideoLoadListener jad_mz;
        public long jad_na;
        public int jad_ob;
        public int jad_pc;
    }

    public class jad_jt implements com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener {
        public jad_jt() {
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadFailed(int i, java.lang.String str, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            videoRenderView.jad_pa = i;
            videoRenderView.jad_qb = str;
            videoRenderView.jad_gr = false;
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView2 = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            videoRenderView2.jad_an(videoRenderView2.jad_wh);
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadSuccess(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = com.jd.ad.sdk.bl.video.VideoRenderView.this;
            if (videoRenderView.jad_fq != null) {
                videoRenderView.jad_gr = true;
                com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_fq.setImageDrawable(drawable);
                if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_lw)) {
                    com.jd.ad.sdk.bl.video.VideoRenderView.this.jad_an(true);
                } else {
                    com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView2 = com.jd.ad.sdk.bl.video.VideoRenderView.this;
                    videoRenderView2.jad_an(videoRenderView2.jad_wh);
                }
            }
        }
    }

    public VideoRenderView(android.content.Context context, com.jd.ad.sdk.bl.video.VideoRenderView.jad_iv jad_ivVar) {
        super(context);
        this.jad_an = null;
        this.jad_bo = Integer.MAX_VALUE;
        this.jad_cp = 0;
        this.jad_iv = 100;
        this.jad_jw = 0.0f;
        this.jad_kx = 1.0f;
        this.jad_ly = 0.0f;
        this.jad_mz = 0.0f;
        this.jad_na = 45.0f;
        this.jad_re = false;
        this.jad_rc = 2;
        this.jad_vg = 0;
        this.jad_yj = false;
        this.jad_zk = new com.jd.ad.sdk.bl.video.VideoRenderView.jad_an();
        this.jad_al = new com.jd.ad.sdk.bl.video.VideoRenderView.jad_bo();
        this.jad_bm = new com.jd.ad.sdk.bl.video.VideoRenderView.jad_cp();
        this.jad_en = new com.jd.ad.sdk.bl.video.VideoRenderView.jad_dq();
        this.jad_fo = new com.jd.ad.sdk.bl.video.VideoRenderView.jad_er();
        this.jad_dq = context;
        jad_iv();
        jad_cp();
        jad_an(jad_ivVar);
        jad_dq();
        if (!this.jad_wh) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdVideoService().registerAd(this.jad_te);
        }
        jad_an(context);
        jad_jt();
        if (this.jad_wh) {
            return;
        }
        jad_er();
    }

    private java.lang.String getStoreVideoPath() {
        if ("1".equals(this.jad_xi)) {
            return "";
        }
        if (this.jad_ny == null) {
            this.jad_ny = new com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), this.jad_oz);
        }
        com.jd.ad.sdk.jad_ly.jad_cp storageVideoByUrl = this.jad_ny.getStorageVideoByUrl(this.jad_lw);
        return storageVideoByUrl != null ? storageVideoByUrl.jad_dq : "";
    }

    public static void jad_an(com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView, android.media.MediaPlayer mediaPlayer) {
        int i;
        videoRenderView.getClass();
        try {
            if (videoRenderView.jad_cp == 6 || (i = videoRenderView.jad_mx) <= 0 || i != videoRenderView.getDuration()) {
                return;
            }
            videoRenderView.jad_cp = 6;
            videoRenderView.jad_bo = 6;
            com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener = videoRenderView.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(4, videoRenderView.getDuration());
            }
            if (mediaPlayer == null || mediaPlayer.isLooping()) {
                return;
            }
            try {
                if (videoRenderView.jad_an() && (videoRenderView.getState() == 2 || videoRenderView.getState() == 3 || videoRenderView.getState() == 4 || videoRenderView.getState() == 6)) {
                    videoRenderView.jad_an.stop();
                    videoRenderView.jad_cp = 5;
                }
            } catch (java.lang.Exception unused) {
            }
            videoRenderView.jad_bo = 5;
        } catch (java.lang.Exception unused2) {
        }
    }

    public static boolean jad_an(com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView, android.view.View view) {
        videoRenderView.getClass();
        return view != null && view.getGlobalVisibleRect(new android.graphics.Rect()) && view.isShown();
    }

    public void destroy() {
        android.media.AudioManager audioManager;
        try {
            if (jad_an()) {
                this.jad_cp = -2;
                android.media.MediaPlayer mediaPlayer = this.jad_an;
                if (mediaPlayer != null) {
                    mediaPlayer.setOnPreparedListener(null);
                    this.jad_an.setOnVideoSizeChangedListener(null);
                    this.jad_an.setOnCompletionListener(null);
                    this.jad_an.setOnErrorListener(null);
                    this.jad_an.setOnInfoListener(null);
                    this.jad_an.setOnBufferingUpdateListener(null);
                }
                this.jad_an.release();
            }
            android.content.Context context = this.jad_dq;
            if (context != null && (audioManager = (android.media.AudioManager) context.getSystemService("audio")) != null) {
                audioManager.abandonAudioFocus(null);
            }
            this.jad_jt = null;
            com.jd.ad.sdk.bl.video.jad_an jad_anVar = this.jad_er;
            if (jad_anVar != null) {
                jad_anVar.jad_an();
                this.jad_er = null;
            }
            com.jd.ad.sdk.bl.video.VideoRenderView.jad_hu jad_huVar = this.jad_sf;
            java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an> copyOnWriteArrayList = com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_bo;
            if (jad_huVar != null) {
                com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_bo.remove(jad_huVar);
            }
            this.jad_sf = null;
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdVideoService().unregisterAd(this.jad_te);
        } catch (java.lang.Exception unused) {
        }
    }

    public int getAdAnimationType() {
        return this.jad_pc;
    }

    public int getAdClickAreaValue() {
        return this.jad_iv;
    }

    public int getDuration() {
        try {
            if (this.jad_re || !jad_an() || getState() == -1 || getState() == 1 || getState() == 0) {
                return 0;
            }
            return this.jad_an.getDuration();
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public int getState() {
        return this.jad_cp;
    }

    public java.lang.Exception getVideoRenderException() {
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        if (message.what != 10001) {
            return false;
        }
        jad_an(true);
        return false;
    }

    public final void jad_an(int i, int i2) {
        int i3 = (int) (this.jad_vi * this.jad_wj);
        if (i3 > 0) {
            this.jad_iv = ((i * i2) * 100) / i3;
        }
    }

    public final void jad_an(android.content.Context context) {
        android.view.View inflate;
        com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView;
        try {
            if (this.jad_wh) {
                inflate = android.view.LayoutInflater.from(context).inflate(com.jd.ad.sdk.R.layout.jad_video_img_render_layout, (android.view.ViewGroup) null);
            } else {
                inflate = android.view.LayoutInflater.from(context).inflate(com.jd.ad.sdk.R.layout.jad_video_render_layout, (android.view.ViewGroup) null);
                this.jad_kv = (android.widget.TextView) inflate.findViewById(com.jd.ad.sdk.R.id.jad_text_video_preloaded);
                this.jad_ju = (android.widget.FrameLayout) inflate.findViewById(com.jd.ad.sdk.R.id.fl_splash_video);
                this.jad_er = (com.jd.ad.sdk.bl.video.jad_an) inflate.findViewById(com.jd.ad.sdk.R.id.jad_video_texture_view);
                this.jad_an = new android.media.MediaPlayer();
                com.jd.ad.sdk.bl.video.jad_an jad_anVar = this.jad_er;
                if (jad_anVar != null) {
                    jad_anVar.setRenderCallback(new com.jd.ad.sdk.bl.video.jad_cp(this));
                }
            }
            com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView2 = (com.jd.ad.sdk.lottie.LottieAnimationView) inflate.findViewById(com.jd.ad.sdk.R.id.jad_video_lottie);
            this.jad_tg = lottieAnimationView2;
            int i = 8;
            lottieAnimationView2.setVisibility(8);
            this.jad_tg.setCacheComposition(false);
            this.jad_fq = (android.widget.ImageView) inflate.findViewById(com.jd.ad.sdk.R.id.jad_splash_video_image);
            this.jad_it = (com.jd.ad.sdk.bl.video.VideoSkipView) inflate.findViewById(com.jd.ad.sdk.R.id.jad_video_skip_btn);
            addView(inflate);
            android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int i2 = (int) this.jad_vi;
            int i3 = (int) this.jad_wj;
            if (layoutParams == null) {
                layoutParams = new android.widget.FrameLayout.LayoutParams(i2, i3);
            } else {
                layoutParams.height = i3;
                layoutParams.width = i2;
            }
            setLayoutParams(layoutParams);
            if (this.jad_yl > 5) {
                this.jad_yl = 5;
            }
            com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView = this.jad_it;
            if (videoSkipView != null) {
                videoSkipView.setVisibility(this.jad_do ? 8 : 0);
                if (!this.jad_do) {
                    com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView2 = this.jad_it;
                    int i4 = this.jad_yl;
                    com.jd.ad.sdk.bl.video.jad_bo jad_boVar = new com.jd.ad.sdk.bl.video.jad_bo(this);
                    videoSkipView2.jad_an = i4;
                    videoSkipView2.jad_bo = jad_boVar;
                    videoSkipView2.setOnClickListener(new com.jd.ad.sdk.bl.video.jad_dq(videoSkipView2));
                }
            }
            com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView3 = this.jad_tg;
            if (lottieAnimationView3 != null && context != null) {
                lottieAnimationView3.jad_er.jad_cp.jad_bo.add(new com.jd.ad.sdk.jad_ly.jad_jt(this, context));
            }
            if (this.jad_wh || android.text.TextUtils.isEmpty(this.jad_lw)) {
                this.jad_re = true;
            } else {
                java.lang.String str = this.jad_lw;
                this.jad_sd = false;
                java.lang.String storeVideoPath = getStoreVideoPath();
                if (!android.text.TextUtils.isEmpty(storeVideoPath)) {
                    this.jad_sd = true;
                    str = storeVideoPath;
                }
                com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener = this.jad_uh;
                if (onVideoRenderListener != null) {
                    onVideoRenderListener.updateMaterialMetaPreload(this.jad_sd);
                }
                android.widget.TextView textView = this.jad_kv;
                if (this.jad_sd && !this.jad_ep) {
                    i = 0;
                }
                textView.setVisibility(i);
                setDataSource(str);
            }
            if (this.jad_tg != null) {
                jad_fs();
            }
            jad_hu();
            int i5 = this.jad_pc;
            if (i5 == 3) {
                android.content.Context context2 = this.jad_dq;
                android.widget.FrameLayout frameLayout = this.jad_ju;
                if (frameLayout != null) {
                    frameLayout.setOnTouchListener(new com.jd.ad.sdk.jad_ly.jad_fs(this, context2));
                }
            } else if (i5 == 1) {
                android.view.View view = this.jad_wh ? this.jad_fq : this.jad_ju;
                if (view != null) {
                    view.setOnClickListener(new com.jd.ad.sdk.jad_ly.jad_er(this));
                    jad_an(view.getWidth(), view.getHeight());
                }
            } else if (i5 == 0 && (lottieAnimationView = this.jad_tg) != null) {
                lottieAnimationView.setOnClickListener(new com.jd.ad.sdk.jad_ly.jad_er(this));
                jad_an(lottieAnimationView.getWidth(), lottieAnimationView.getHeight());
            }
            if (this.jad_wh || this.jad_sd || "1".equals(this.jad_xi) || android.text.TextUtils.isEmpty(this.jad_lw)) {
                return;
            }
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdVideoService().loadAdVideo(context, this.jad_te, this.jad_lw, this.jad_oz, this.jad_uf);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_FAIL_ERROR;
            sb.append(jad_anVar2.jad_an);
            sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(jad_anVar2.jad_an(new java.lang.String[0]));
            throw new java.lang.Throwable(sb.toString(), e);
        }
    }

    public final void jad_an(com.jd.ad.sdk.bl.video.VideoRenderView.jad_iv jad_ivVar) {
        this.jad_vi = jad_ivVar.jad_an;
        this.jad_wj = jad_ivVar.jad_bo;
        this.jad_xk = jad_ivVar.jad_fs;
        this.jad_yl = jad_ivVar.jad_jt;
        this.jad_uh = jad_ivVar.jad_cp;
        this.jad_zm = jad_ivVar.jad_dq;
        this.jad_cn = jad_ivVar.jad_er;
        this.jad_do = jad_ivVar.jad_hu;
        this.jad_ep = jad_ivVar.jad_iv;
        this.jad_lw = jad_ivVar.jad_jw;
        this.jad_oz = jad_ivVar.jad_kx;
        this.jad_te = jad_ivVar.jad_ly;
        this.jad_uf = jad_ivVar.jad_mz;
        this.jad_hs = jad_ivVar.jad_na;
        this.jad_rc = jad_ivVar.jad_ob;
        this.jad_mx = jad_ivVar.jad_pc;
    }

    public final void jad_an(java.lang.Exception exc) {
        try {
            if (this.jad_uh != null) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_PLAY_PLAYBACK_ERROR;
                int i = jad_anVar.jad_an;
                java.lang.String jad_an2 = jad_anVar.jad_an(new java.lang.String[0]);
                java.lang.String message = exc.getMessage();
                this.jad_uh.videoPlayerError(i, i, i, getDuration(), jad_an2 + message);
            }
            if (jad_an()) {
                this.jad_an.reset();
                this.jad_cp = 0;
            }
            this.jad_bo = 0;
        } catch (java.lang.Exception unused) {
        }
    }

    public final void jad_an(boolean z) {
        if ((z || this.jad_re) && this.jad_vg == 0) {
            if (!this.jad_gr) {
                com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener = this.jad_uh;
                if (onVideoRenderListener != null) {
                    onVideoRenderListener.onVideoRenderFailed(this.jad_pa, this.jad_qb);
                    return;
                }
                return;
            }
            android.widget.ImageView imageView = this.jad_fq;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener2 = this.jad_uh;
            if (onVideoRenderListener2 != null) {
                onVideoRenderListener2.onVideoRenderSuccess(this);
                this.jad_vg = 2;
            }
        }
    }

    public final boolean jad_an() {
        return (this.jad_an == null || this.jad_wh) ? false : true;
    }

    public final boolean jad_bo() {
        int i;
        int i2;
        try {
            android.graphics.Rect rect = new android.graphics.Rect();
            if (getGlobalVisibleRect(rect)) {
                i2 = rect.width();
                i = rect.height();
            } else {
                i = 0;
                i2 = 0;
            }
            return com.jd.ad.sdk.jad_jt.jad_iv.jad_an(i * i2, com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) * com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) >= 50;
        } catch (java.lang.Exception unused) {
            return true;
        }
    }

    public final void jad_cp() {
        com.jd.ad.sdk.jad_pc.jad_an jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_an2 == null) {
            return;
        }
        this.jad_jw = jad_an2.jad_cp;
        this.jad_kx = jad_an2.jad_dq;
        this.jad_na = jad_an2.jad_jw;
        this.jad_ly = jad_an2.jad_er;
        this.jad_mz = jad_an2.jad_fs;
        this.jad_xi = jad_an2.jad_sf;
        this.jad_wh = "1".equals(jad_an2.jad_tg);
        if (this.jad_kx <= 0.0f) {
            this.jad_kx = 1.0f;
        }
        if (this.jad_na <= 0.0f) {
            this.jad_na = 45.0f;
        }
    }

    public final void jad_dq() {
        if (this.jad_zm == com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.CLICK.ordinal()) {
            if (this.jad_cn == com.jd.ad.sdk.dl.common.CommonConstants.ClickAreaType.FULL_SCREEN_CLICK.getTemplateId()) {
                this.jad_pc = 1;
                return;
            } else {
                this.jad_pc = 0;
                return;
            }
        }
        if (this.jad_zm == com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE.ordinal()) {
            this.jad_pc = 2;
        } else if (this.jad_zm == com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal()) {
            this.jad_pc = 3;
        }
    }

    public final void jad_er() {
        new android.os.Handler(android.os.Looper.getMainLooper(), this).sendEmptyMessageDelayed(10001, java.lang.Math.max(this.jad_hs - 100, 5L));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007b A[Catch: Exception -> 0x0092, TRY_LEAVE, TryCatch #1 {Exception -> 0x0092, blocks: (B:3:0x0001, B:5:0x0008, B:10:0x0015, B:12:0x005b, B:14:0x0074, B:16:0x007b, B:23:0x0071, B:26:0x002c, B:29:0x0046, B:20:0x0067), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void jad_fs() {
        double d;
        double d2;
        double d3;
        java.lang.String str;
        com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView;
        try {
            java.lang.String str2 = "";
            int i = this.jad_pc;
            boolean z = true;
            if (i == 1) {
                this.jad_tg.setVisibility(8);
                return;
            }
            double d4 = 0.0d;
            if (i != 0) {
                if (i == 2) {
                    double min = java.lang.Math.min(this.jad_wj, this.jad_vi) / 2.0d;
                    d2 = min;
                    d4 = (min / 5.0d) * 2.0d;
                    str2 = "jad_shake.json";
                    d = d2;
                } else if (i == 3) {
                    d3 = (this.jad_vi / 4.0d) * 3.0d;
                    d = this.jad_wj / 2.0d;
                    d4 = d / 4.0d;
                    str = "jad_slideup.json";
                } else {
                    d = 0.0d;
                    d2 = 0.0d;
                    z = false;
                }
                this.jad_tg.setImageAssetsFolder("images/");
                lottieAnimationView = this.jad_tg;
                if (lottieAnimationView != null) {
                    try {
                        lottieAnimationView.setFontAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_er());
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
                this.jad_tg.setAnimation(str2);
                if (z) {
                    return;
                }
                android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.jad_tg.getLayoutParams();
                layoutParams.width = (int) d2;
                layoutParams.height = (int) d;
                layoutParams.bottomMargin = (int) d4;
                this.jad_tg.setLayoutParams(layoutParams);
                return;
            }
            d3 = this.jad_vi;
            d = (104.0d * d3) / 750.0d;
            str = "jad_click.json";
            double d5 = d3;
            str2 = str;
            d2 = d5;
            this.jad_tg.setImageAssetsFolder("images/");
            lottieAnimationView = this.jad_tg;
            if (lottieAnimationView != null) {
            }
            this.jad_tg.setAnimation(str2);
            if (z) {
            }
        } catch (java.lang.Exception e2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_FAIL_ERROR;
            sb.append(jad_anVar.jad_an);
            sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(jad_anVar.jad_an(new java.lang.String[0]));
            throw new java.lang.Throwable(sb.toString(), e2);
        }
    }

    public void jad_hu() {
        try {
            if (android.text.TextUtils.isEmpty(this.jad_xk)) {
                this.jad_gr = false;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_VIEW_INIT_EMPTY_IMAGES_ERROR;
                this.jad_pa = jad_anVar.jad_an;
                this.jad_qb = jad_anVar.jad_an(new java.lang.String[0]);
                if (this.jad_wh || android.text.TextUtils.isEmpty(this.jad_lw) || this.jad_re) {
                    jad_an(true);
                }
            } else {
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getFoundationService().loadImage(this.jad_dq, this.jad_xk, new com.jd.ad.sdk.bl.video.VideoRenderView.jad_jt());
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_VIEW_INIT_LOAD_IMAGES_ERROR;
            this.jad_pa = jad_anVar2.jad_an;
            this.jad_qb = jad_anVar2.jad_an(new java.lang.String[0]) + e.getMessage();
            this.jad_gr = false;
            jad_an(this.jad_wh);
        }
    }

    public final void jad_iv() {
        com.jd.ad.sdk.bl.video.VideoRenderView.jad_hu jad_huVar = new com.jd.ad.sdk.bl.video.VideoRenderView.jad_hu();
        this.jad_sf = jad_huVar;
        com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an(jad_huVar);
    }

    public final void jad_jt() {
        setOnTouchListener(new com.jd.ad.sdk.bl.video.VideoRenderView.jad_fs(this));
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.jad_ob = z;
        if (z) {
            com.jd.ad.sdk.bl.dynamicrender.ShakeListener shakeListener = this.jad_hu;
            if (shakeListener != null) {
                shakeListener.register();
            }
        } else {
            com.jd.ad.sdk.bl.dynamicrender.ShakeListener shakeListener2 = this.jad_hu;
            if (shakeListener2 != null) {
                shakeListener2.unregister();
            }
        }
        try {
            if (this.jad_an == null || !jad_bo() || this.jad_re || this.jad_wh) {
                return;
            }
            if (this.jad_ob) {
                if (!this.jad_an.isPlaying() && this.jad_an != null && jad_bo() && this.jad_yj) {
                    this.jad_an.start();
                }
            } else if (this.jad_an.isPlaying()) {
                this.jad_an.pause();
            }
            com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener = this.jad_uh;
            if (onVideoRenderListener != null) {
                onVideoRenderListener.videoPlayerStatusChanged(this.jad_ob ? 6 : 5, getDuration());
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void play() {
        android.media.MediaPlayer mediaPlayer;
        com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener;
        com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener2;
        try {
            if (this.jad_an != null && !jad_bo() && !this.jad_re && this.jad_yj) {
                this.jad_an.seekTo(0);
                this.jad_an.start();
                this.jad_an.pause();
                com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView = this.jad_it;
                if (videoSkipView != null) {
                    videoSkipView.setTotalCount(this.jad_yl);
                    return;
                }
                return;
            }
            if (this.jad_ju != null) {
                if (!this.jad_re && jad_an() && this.jad_yj) {
                    this.jad_ju.setVisibility(0);
                    this.jad_an.start();
                } else {
                    this.jad_ju.setVisibility(8);
                }
            }
            com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView = this.jad_tg;
            if (lottieAnimationView != null && this.jad_pc != 1) {
                lottieAnimationView.setVisibility(0);
                this.jad_tg.jad_dq();
            }
            if (!this.jad_wh && (onVideoRenderListener2 = this.jad_uh) != null) {
                onVideoRenderListener2.videoPlayerStatusChanged(1, getDuration());
            }
            if (!this.jad_wh && !this.jad_re && (mediaPlayer = this.jad_an) != null && mediaPlayer.isPlaying() && (onVideoRenderListener = this.jad_uh) != null) {
                onVideoRenderListener.videoPlayerStatusChanged(3, getDuration());
            }
            if (this.jad_it != null) {
                com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_ly.jad_dq(this));
            }
        } catch (java.lang.Exception unused) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_PLAY_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]));
        }
    }

    public void setDataSource(java.lang.String str) {
        try {
            if (this.jad_an == null) {
                this.jad_an = new android.media.MediaPlayer();
            }
            this.jad_bo = Integer.MAX_VALUE;
            this.jad_an.setOnPreparedListener(this.jad_zk);
            this.jad_an.setOnVideoSizeChangedListener(this.jad_al);
            this.jad_an.setOnErrorListener(this.jad_en);
            this.jad_an.setOnBufferingUpdateListener(this.jad_fo);
            if (this.jad_rc == 1) {
                if (jad_an()) {
                    this.jad_an.setVolume(1.0f, 1.0f);
                }
            } else if (jad_an()) {
                this.jad_an.setVolume(0.0f, 0.0f);
            }
            this.jad_cp = 1;
            this.jad_an.setDataSource(this.jad_dq, android.net.Uri.parse(str));
            this.jad_an.setOnCompletionListener(this.jad_bm);
            this.jad_an.setAudioStreamType(3);
            this.jad_an.setScreenOnWhilePlaying(true);
            this.jad_an.setLooping(false);
            this.jad_an.prepareAsync();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            this.jad_cp = -1;
            this.jad_bo = -1;
        }
    }

    public void setVideoInteractionListener(com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener) {
        this.jad_qd = videoInteractionListener;
    }
}
