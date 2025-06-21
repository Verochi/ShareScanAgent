package com.anythink.expressad.playercommon;

/* loaded from: classes12.dex */
public class PlayerView extends android.widget.LinearLayout {
    public static final java.lang.String TAG = "PlayerView";
    private boolean isBTVideo;
    private boolean isBTVideoPlaying;
    private boolean mInitState;
    private boolean mIsCovered;
    private boolean mIsFirstCreateHolder;
    private boolean mIsNeedToRepeatPrepare;
    private boolean mIsSurfaceHolderDestoryed;
    private android.widget.LinearLayout mLlSurContainer;
    private android.widget.LinearLayout mLoadingView;
    private java.lang.String mPlayUrl;
    private android.view.SurfaceHolder mSurfaceHolder;
    private com.anythink.expressad.playercommon.VideoFeedsPlayer mVideoFeedsPlayer;
    com.anythink.expressad.reward.player.c tempEventListener;

    public class MySurfaceHoldeCallback implements android.view.SurfaceHolder.Callback {
        private MySurfaceHoldeCallback() {
        }

        public /* synthetic */ MySurfaceHoldeCallback(com.anythink.expressad.playercommon.PlayerView playerView, com.anythink.expressad.playercommon.PlayerView.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            try {
                if (com.anythink.expressad.playercommon.PlayerView.this.mIsSurfaceHolderDestoryed && !com.anythink.expressad.playercommon.PlayerView.this.mIsCovered && !com.anythink.expressad.playercommon.PlayerView.this.isComplete() && !com.anythink.expressad.foundation.f.b.c) {
                    if (com.anythink.expressad.playercommon.PlayerView.this.isBTVideo) {
                        if (com.anythink.expressad.playercommon.PlayerView.this.mVideoFeedsPlayer.getIsFrontDesk()) {
                            if (!com.anythink.expressad.playercommon.PlayerView.this.mVideoFeedsPlayer.hasPrepare()) {
                                com.anythink.expressad.playercommon.PlayerView.this.mVideoFeedsPlayer.prepare();
                            }
                            com.anythink.expressad.playercommon.PlayerView.this.mVideoFeedsPlayer.start(false);
                        } else {
                            com.anythink.expressad.playercommon.PlayerView.this.pause();
                        }
                    } else if (com.anythink.expressad.playercommon.PlayerView.this.mVideoFeedsPlayer.hasPrepare()) {
                        com.anythink.expressad.playercommon.PlayerView.this.resumeStart();
                    } else {
                        com.anythink.expressad.playercommon.PlayerView.this.playVideo(0);
                    }
                }
                com.anythink.expressad.playercommon.PlayerView.this.mIsSurfaceHolderDestoryed = false;
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            try {
                if (com.anythink.expressad.playercommon.PlayerView.this.mVideoFeedsPlayer != null && surfaceHolder != null) {
                    com.anythink.expressad.playercommon.PlayerView.this.mSurfaceHolder = surfaceHolder;
                    com.anythink.expressad.playercommon.PlayerView.this.mVideoFeedsPlayer.setDisplay(surfaceHolder);
                }
                com.anythink.expressad.playercommon.PlayerView.this.mIsFirstCreateHolder = false;
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            try {
                com.anythink.expressad.playercommon.PlayerView.this.mIsSurfaceHolderDestoryed = true;
                com.anythink.expressad.playercommon.PlayerView.this.mIsNeedToRepeatPrepare = true;
                com.anythink.expressad.playercommon.PlayerView.this.mVideoFeedsPlayer.pause();
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    public PlayerView(android.content.Context context) {
        super(context);
        this.mInitState = false;
        this.mIsFirstCreateHolder = true;
        this.mIsSurfaceHolderDestoryed = false;
        this.mIsCovered = false;
        this.mIsNeedToRepeatPrepare = false;
        this.isBTVideo = false;
        this.isBTVideoPlaying = false;
        init();
    }

    public PlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInitState = false;
        this.mIsFirstCreateHolder = true;
        this.mIsSurfaceHolderDestoryed = false;
        this.mIsCovered = false;
        this.mIsNeedToRepeatPrepare = false;
        this.isBTVideo = false;
        this.isBTVideoPlaying = false;
        init();
    }

    private void init() {
        try {
            initView();
            initPlayer();
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private void initPlayer() {
        this.mVideoFeedsPlayer = new com.anythink.expressad.playercommon.VideoFeedsPlayer();
    }

    private void initView() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_playercommon_player_view", "layout"), (android.view.ViewGroup) null);
        if (inflate != null) {
            this.mLlSurContainer = (android.widget.LinearLayout) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_playercommon_ll_sur_container", "id"));
            this.mLoadingView = (android.widget.LinearLayout) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_playercommon_ll_loading", "id"));
            addSurfaceView();
            addView(inflate, -1, -1);
        }
    }

    public void addSurfaceView() {
        try {
            android.view.SurfaceView surfaceView = new android.view.SurfaceView(getContext().getApplicationContext());
            android.view.SurfaceHolder holder = surfaceView.getHolder();
            this.mSurfaceHolder = holder;
            holder.setType(3);
            this.mSurfaceHolder.setKeepScreenOn(true);
            this.mSurfaceHolder.addCallback(new com.anythink.expressad.playercommon.PlayerView.MySurfaceHoldeCallback(this, null));
            this.mLlSurContainer.addView(surfaceView, -1, -1);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void closeSound() {
        com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.closeSound();
        }
    }

    public void coverUnlockResume() {
        try {
            this.mVideoFeedsPlayer.setIsFrontDesk(true);
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                if (videoFeedsPlayer.hasPrepare() && !this.mIsNeedToRepeatPrepare) {
                    start(true);
                    return;
                }
                playVideo(0);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public int getCurPosition() {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                return videoFeedsPlayer.getCurPosition();
            }
            return 0;
        } catch (java.lang.Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int getDuration() {
        com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            return videoFeedsPlayer.getDuration();
        }
        return 0;
    }

    public void initBufferIngParam(int i) {
        com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.initBufferIngParam(i);
        }
    }

    public boolean initVFPData(java.lang.String str, java.lang.String str2, int i, com.anythink.expressad.playercommon.VideoPlayerStatusListener videoPlayerStatusListener) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        this.mPlayUrl = str;
        this.mVideoFeedsPlayer.setTempEventListener(this.tempEventListener);
        this.mVideoFeedsPlayer.initPlayer(getContext(), this.mLoadingView, str, str2, i, videoPlayerStatusListener);
        this.mInitState = true;
        return true;
    }

    public boolean isComplete() {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                return videoFeedsPlayer.isComplete();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public boolean isPlayIng() {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                return videoFeedsPlayer.isPlayIng();
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public boolean isSilent() {
        return this.mVideoFeedsPlayer.isSilent();
    }

    public void justSeekTo(int i) {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.justSeekTo(i);
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void onPause() {
        try {
            pause();
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.setIsFrontDesk(false);
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void onResume() {
        try {
            this.mVideoFeedsPlayer.setIsFrontDesk(true);
            if (this.mVideoFeedsPlayer == null || this.mIsSurfaceHolderDestoryed || isComplete() || this.mIsCovered) {
                return;
            }
            if (this.mVideoFeedsPlayer.hasPrepare()) {
                resumeStart();
            } else {
                playVideo(0);
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void openSound() {
        com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.openSound();
        }
    }

    public void pause() {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.pause();
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public boolean playVideo() {
        return playVideo(0);
    }

    public boolean playVideo(int i) {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer == null || !this.mInitState) {
                return false;
            }
            videoFeedsPlayer.play(this.mPlayUrl, i);
            this.mIsNeedToRepeatPrepare = false;
            return true;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public void prepare() {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.prepare();
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void release() {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.releasePlayer();
            }
            android.view.SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.getSurface().release();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void removeSurface() {
        try {
            this.mLlSurContainer.removeAllViews();
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void resumeStart() {
        try {
            start(true);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void seekTo(int i) {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.seekTo(i);
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setDataSource() {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.showLoading();
                this.mVideoFeedsPlayer.setDataSource();
                this.mIsNeedToRepeatPrepare = false;
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setDesk(boolean z) {
        this.mVideoFeedsPlayer.setIsFrontDesk(z);
    }

    public void setIsBTVideo(boolean z) {
        this.isBTVideo = z;
    }

    public void setIsBTVideoPlaying(boolean z) {
        this.isBTVideoPlaying = z;
    }

    public void setIsCovered(boolean z) {
        try {
            this.mIsCovered = z;
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setPlaybackParams(float f) {
        com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.setPlaybackParams(f);
        }
    }

    public void setTempEventListener(com.anythink.expressad.reward.player.c cVar) {
        this.tempEventListener = cVar;
    }

    public void setVolume(float f, float f2) {
        com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.setVolume(f, f2);
        }
    }

    public void start(boolean z) {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer == null || this.mIsCovered) {
                return;
            }
            videoFeedsPlayer.start(z);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void stop() {
        try {
            com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
            if (videoFeedsPlayer != null) {
                videoFeedsPlayer.stop();
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }
}
