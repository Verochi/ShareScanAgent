package com.anythink.expressad.playercommon;

/* loaded from: classes12.dex */
public class VideoFeedsPlayer implements com.anythink.expressad.exoplayer.w.c {
    public static final int INTERVAL_TIME_PLAY_TIME_CD_THREAD = 1000;
    public static final java.lang.String TAG = "VideoFeedsPlayer";
    private com.anythink.expressad.exoplayer.ad exoPlayer;
    private java.util.Timer mBufferTimeoutTimer;
    private android.content.Context mContext;
    private long mCurrentPosition;
    private android.view.View mFullScreenLoadingView;
    private volatile com.anythink.expressad.playercommon.VideoPlayerStatusListener mInnerVFPLisener;
    private boolean mIsSilent;
    private java.lang.ref.WeakReference<android.view.View> mLoadingView;
    private volatile com.anythink.expressad.playercommon.VideoPlayerStatusListener mOutterVFListener;
    java.lang.String mPlayLocalVideoFileErrorStr;
    private java.lang.String mPlayUrl;
    private android.view.SurfaceHolder mSurfaceHolder;
    private int mVideoReadyRate;
    private com.anythink.expressad.exoplayer.h.s mediaSource;
    com.anythink.expressad.reward.player.c tempEventListener;
    private boolean mIsComplete = false;
    private boolean mIsPlaying = false;
    private boolean mHasPrepare = false;
    private boolean mIsBuffering = false;
    private boolean mIsNeedBufferingTimeout = false;
    private boolean mIsFrontDesk = true;
    private int mBufferTime = 5;
    private java.lang.Object mLock = new java.lang.Object();
    private boolean isStart = false;
    private final android.os.Handler mHandler = new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass1(android.os.Looper.getMainLooper());
    private boolean needPrepareVideoPlayAgain = false;
    private java.lang.String mNetVideoUrl = "";
    private java.lang.String mMediaSourceUrl = "";
    private java.lang.Runnable playProgressRunnable = new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass2();

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$errStr;

        public AnonymousClass10(java.lang.String str) {
            this.val$errStr = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener.onPlayError(this.val$errStr);
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener.onPlayError(this.val$errStr);
                } catch (java.lang.Exception e2) {
                    e2.getMessage();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$errStr;

        public AnonymousClass11(java.lang.String str) {
            this.val$errStr = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener.onPlaySetDataSourceError(this.val$errStr);
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener.onPlaySetDataSourceError(this.val$errStr);
                } catch (java.lang.Exception e2) {
                    e2.getMessage();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        public AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener.onPlayCompleted();
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener.onPlayCompleted();
                } catch (java.lang.Exception e2) {
                    e2.getMessage();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long j;
            try {
                if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.exoPlayer == null || !com.anythink.expressad.playercommon.VideoFeedsPlayer.this.exoPlayerIsPlaying()) {
                    return;
                }
                com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer = com.anythink.expressad.playercommon.VideoFeedsPlayer.this;
                videoFeedsPlayer.mCurrentPosition = videoFeedsPlayer.exoPlayer.t();
                float f = com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mCurrentPosition % 1000;
                int round = java.lang.Math.round(com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mCurrentPosition / 1000.0f);
                long unused = com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mCurrentPosition;
                if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.exoPlayer == null || com.anythink.expressad.playercommon.VideoFeedsPlayer.this.exoPlayer.s() <= 0) {
                    j = 0;
                } else {
                    j = com.anythink.expressad.playercommon.VideoFeedsPlayer.this.exoPlayer.s() / 1000;
                    if (f > 0.0f && f < 500.0f) {
                        round++;
                    }
                }
                if (round >= 0 && j > 0 && round < 1 + j) {
                    if (!com.anythink.expressad.playercommon.VideoFeedsPlayer.this.isStart) {
                        com.anythink.expressad.playercommon.VideoFeedsPlayer videoFeedsPlayer2 = com.anythink.expressad.playercommon.VideoFeedsPlayer.this;
                        videoFeedsPlayer2.postOnPlayStartOnMainThread(videoFeedsPlayer2.exoPlayer.s() / 1000);
                        com.anythink.expressad.playercommon.VideoFeedsPlayer.this.exoPlayer.t();
                        com.anythink.expressad.playercommon.VideoFeedsPlayer.this.isStart = true;
                    }
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.postOnPlayProgressOnMainThread(round, (int) j);
                }
                com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mIsComplete = false;
                if (!com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mIsBuffering) {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.hideLoading();
                }
                com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mHandler.postDelayed(this, 1000L);
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$3, reason: invalid class name */
    public class AnonymousClass3 extends java.util.TimerTask {
        final /* synthetic */ java.lang.String val$bufferMsg;

        public AnonymousClass3(java.lang.String str) {
            this.val$bufferMsg = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (!com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mHasPrepare || com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mIsBuffering) {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.postOnBufferingStarOnMainThread(this.val$bufferMsg);
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mFullScreenLoadingView != null) {
                com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mFullScreenLoadingView.setVisibility(0);
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mLoadingView != null && com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mLoadingView.get() != null) {
                ((android.view.View) com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mLoadingView.get()).setVisibility(8);
            }
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mFullScreenLoadingView != null) {
                com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mFullScreenLoadingView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ int val$allDurationSecond;
        final /* synthetic */ int val$curPlayPosition;

        public AnonymousClass6(int i, int i2) {
            this.val$curPlayPosition = i;
            this.val$allDurationSecond = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener.onPlayProgress(this.val$curPlayPosition, this.val$allDurationSecond);
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener.onPlayProgress(this.val$curPlayPosition, this.val$allDurationSecond);
                } catch (java.lang.Exception e2) {
                    e2.getMessage();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$bufferMsg;

        public AnonymousClass7(java.lang.String str) {
            this.val$bufferMsg = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener.onBufferingStart(this.val$bufferMsg);
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener.onBufferingStart(this.val$bufferMsg);
                } catch (java.lang.Exception e2) {
                    e2.getMessage();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener.onBufferingEnd();
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener.onBufferingEnd();
                } catch (java.lang.Exception e2) {
                    e2.getMessage();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.playercommon.VideoFeedsPlayer$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ long val$allDuration;

        public AnonymousClass9(long j) {
            this.val$allDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = (int) this.val$allDuration;
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mOutterVFListener.onPlayStarted(i);
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            if (com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                try {
                    com.anythink.expressad.playercommon.VideoFeedsPlayer.this.mInnerVFPLisener.onPlayStarted(i);
                } catch (java.lang.Exception e2) {
                    e2.getMessage();
                }
            }
        }
    }

    private void cancelBufferTimeoutTimer() {
        try {
            java.util.Timer timer = this.mBufferTimeoutTimer;
            if (timer != null) {
                timer.cancel();
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private void cancelPlayProgressTimer() {
        try {
            this.mHandler.removeCallbacks(this.playProgressRunnable);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        try {
            android.os.Handler handler = this.mHandler;
            if (handler == null) {
                return;
            }
            handler.post(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass5());
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private void postOnBufferinEndOnMainThread() {
        try {
            android.os.Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass8());
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnBufferingStarOnMainThread(java.lang.String str) {
        try {
            android.os.Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass7(str));
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private void postOnPlayCompletedOnMainThread() {
        try {
            android.os.Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass12());
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private void postOnPlayErrorOnMainThread(java.lang.String str) {
        try {
            android.os.Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass10(str));
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPlayProgressOnMainThread(int i, int i2) {
        try {
            android.os.Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass6(i, i2));
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private void postOnPlaySetDataSourceError2MainThread(java.lang.String str) {
        try {
            android.os.Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass11(str));
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPlayStartOnMainThread(long j) {
        try {
            android.os.Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass9(j));
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private void rePrepareVideoSourceAgain() {
        if (this.mOutterVFListener != null) {
            this.mOutterVFListener.onVideoDownloadResume();
        }
        com.anythink.expressad.exoplayer.h.s sVar = this.mediaSource;
        if (sVar != null) {
            this.exoPlayer.a(sVar);
        }
    }

    private void startBufferIngTimer(java.lang.String str) {
        if (this.mIsNeedBufferingTimeout) {
            cancelBufferTimeoutTimer();
            java.util.Timer timer = new java.util.Timer();
            this.mBufferTimeoutTimer = timer;
            timer.schedule(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass3(str), this.mBufferTime * 1000);
        }
    }

    private void startPlayProgressTimer() {
        try {
            cancelPlayProgressTimer();
            this.mHandler.post(this.playProgressRunnable);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void closeSound() {
        try {
            com.anythink.expressad.exoplayer.ad adVar = this.exoPlayer;
            if (adVar == null) {
                return;
            }
            adVar.a(0.0f);
            this.mIsSilent = true;
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public boolean exoPlayerIsPlaying() {
        return this.exoPlayer.J();
    }

    public boolean fullScreenLoadingViewisVisible() {
        try {
            android.view.View view = this.mFullScreenLoadingView;
            if (view != null) {
                return view.getVisibility() == 0;
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public int getCurPosition() {
        return (int) this.mCurrentPosition;
    }

    public int getDuration() {
        com.anythink.expressad.exoplayer.ad adVar = this.exoPlayer;
        if (adVar == null) {
            return 0;
        }
        adVar.s();
        return 0;
    }

    public boolean getIsFrontDesk() {
        return this.mIsFrontDesk;
    }

    public boolean halfLoadingViewisVisible() {
        try {
            java.lang.ref.WeakReference<android.view.View> weakReference = this.mLoadingView;
            if (weakReference == null || weakReference.get() == null) {
                return false;
            }
            return this.mLoadingView.get().getVisibility() == 0;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public boolean hasPrepare() {
        return this.mHasPrepare;
    }

    public void initBufferIngParam(int i) {
        if (i > 0) {
            this.mBufferTime = i;
        }
        this.mIsNeedBufferingTimeout = true;
    }

    public boolean initPlayer(android.content.Context context, android.view.View view, java.lang.String str, java.lang.String str2, int i, com.anythink.expressad.playercommon.VideoPlayerStatusListener videoPlayerStatusListener) {
        try {
            if (view == null) {
                postOnPlayErrorOnMainThread("MediaPlayer init error");
                return false;
            }
            this.needPrepareVideoPlayAgain = !android.text.TextUtils.equals(str, str2);
            this.mMediaSourceUrl = str;
            this.mNetVideoUrl = str2;
            this.mVideoReadyRate = i;
            this.mContext = context;
            this.mOutterVFListener = videoPlayerStatusListener;
            this.mLoadingView = new java.lang.ref.WeakReference<>(view);
            this.exoPlayer = com.anythink.expressad.exoplayer.i.a(new com.anythink.expressad.exoplayer.f(context), new com.anythink.expressad.exoplayer.i.c(), new com.anythink.expressad.exoplayer.d());
            this.mediaSource = new com.anythink.expressad.exoplayer.h.o.c(new com.anythink.expressad.exoplayer.j.o(context, "AT_ExoPlayer")).b(android.net.Uri.parse(str));
            this.exoPlayer.a(0);
            this.exoPlayer.a(this.mediaSource);
            this.exoPlayer.a(this);
            return true;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            postOnPlayErrorOnMainThread(th.toString());
            return false;
        }
    }

    public boolean isComplete() {
        return this.mIsComplete;
    }

    public boolean isPlayIng() {
        try {
            if (this.exoPlayer != null) {
                return exoPlayerIsPlaying();
            }
            return false;
        } catch (java.lang.Exception e) {
            e.getMessage();
            return false;
        }
    }

    public boolean isSilent() {
        return this.mIsSilent;
    }

    public void justSeekTo(int i) {
        try {
            this.mCurrentPosition = i;
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void onBufferingUpdate(int i) {
    }

    public void onCompletion() {
        try {
            this.mIsComplete = true;
            this.mIsPlaying = false;
            this.mCurrentPosition = 0L;
            hideLoading();
            postOnPlayCompletedOnMainThread();
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public boolean onError(int i, java.lang.String str) {
        try {
            hideLoading();
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
        if (!this.mIsFrontDesk && "MIX 3".equalsIgnoreCase(com.anythink.core.common.o.e.a()) && com.anythink.core.common.o.e.b().equalsIgnoreCase("Xiaomi")) {
            return true;
        }
        this.mHasPrepare = false;
        postOnPlayErrorOnMainThread(str);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onPlaybackParametersChanged(com.anythink.expressad.exoplayer.v vVar) {
        float f = vVar.b;
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onPlayerError(com.anythink.expressad.exoplayer.g gVar) {
        boolean z;
        long j;
        java.lang.String str;
        com.anythink.expressad.reward.player.c cVar = this.tempEventListener;
        if (cVar != null) {
            cVar.e();
        }
        java.lang.String str2 = "Play error and ExoPlayer have not message.";
        if (gVar != null) {
            int i = gVar.d;
            z = true;
            if (i != 0) {
                if (i == 1) {
                    str2 = "Play error, because have a RendererException.";
                } else if (i == 2) {
                    str2 = "Play error, because have a UnexpectedException.";
                }
                z = false;
            } else {
                str2 = "Play error, because have a SourceException.";
            }
            if (gVar.getCause() != null && !android.text.TextUtils.isEmpty(gVar.getCause().getMessage())) {
                str2 = gVar.getCause().getMessage();
            }
        } else {
            z = false;
        }
        if (this.needPrepareVideoPlayAgain && z) {
            this.mPlayLocalVideoFileErrorStr = str2;
            this.needPrepareVideoPlayAgain = false;
            rePrepareVideoSourceAgain();
            return;
        }
        try {
            j = this.exoPlayer.t();
        } catch (java.lang.Throwable unused) {
            j = 0;
        }
        java.lang.String str3 = "videoUrl" + this.mNetVideoUrl + ",readyRate:" + this.mVideoReadyRate + ",cdRate:0,play process:" + j;
        if (android.text.TextUtils.isEmpty(this.mPlayLocalVideoFileErrorStr)) {
            str = str3 + ",localFileErrorMsg:" + str2;
        } else {
            str = str3 + ",localFileErrorMsg:" + this.mPlayLocalVideoFileErrorStr + ",errorMsg:" + str2;
        }
        onError(gVar.d, str);
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onPlayerStateChanged(boolean z, int i) {
        if (i == 2) {
            this.mIsBuffering = true;
            showLoading();
            startBufferIngTimer("play buffering tiemout");
        } else {
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                cancelPlayProgressTimer();
                onCompletion();
                return;
            }
            this.mIsBuffering = false;
            hideLoading();
            postOnBufferinEndOnMainThread();
            onPrepared();
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onPositionDiscontinuity(int i) {
    }

    public void onPrepared() {
        com.anythink.expressad.reward.player.c cVar;
        try {
            if (!this.mHasPrepare && (cVar = this.tempEventListener) != null) {
                cVar.d();
            }
            this.mHasPrepare = true;
            if (!this.mIsFrontDesk && this.exoPlayer != null) {
                pause();
            }
            boolean z = this.mIsFrontDesk;
            if (z && z) {
                hideLoading();
                this.mHasPrepare = true;
                if (this.exoPlayer != null) {
                    this.mIsPlaying = true;
                }
                postOnBufferinEndOnMainThread();
                startPlayProgressTimer();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onRepeatModeChanged(int i) {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onSeekProcessed() {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onTimelineChanged(com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj, int i) {
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public void onTracksChanged(com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.g gVar) {
    }

    public void openSound() {
        try {
            com.anythink.expressad.exoplayer.ad adVar = this.exoPlayer;
            if (adVar == null) {
                return;
            }
            adVar.a(1.0f);
            this.mIsSilent = false;
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void pause() {
        try {
            if (this.exoPlayer != null) {
                exoPlayerIsPlaying();
                hideLoading();
                this.exoPlayer.a(false);
                this.mIsPlaying = false;
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void play() {
        this.exoPlayer.a(true);
    }

    public void play(java.lang.String str, int i) {
        try {
            synchronized (this.mLock) {
                if (i > 0) {
                    this.mCurrentPosition = i;
                }
                if (android.text.TextUtils.isEmpty(str)) {
                    postOnPlayErrorOnMainThread("play url is null");
                    return;
                }
                this.mPlayUrl = str;
                this.mHasPrepare = false;
                this.mIsFrontDesk = true;
                showLoading();
                setDataSource();
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread("mediaplayer cannot play");
        }
    }

    public void play(java.lang.String str, android.view.SurfaceHolder surfaceHolder) {
        try {
            synchronized (this.mLock) {
                if (android.text.TextUtils.isEmpty(str)) {
                    postOnPlayErrorOnMainThread("play url is null");
                    return;
                }
                this.mPlayUrl = str;
                this.mHasPrepare = false;
                this.mIsFrontDesk = true;
                this.mSurfaceHolder = surfaceHolder;
                showLoading();
                setDataSource();
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread("mediaplayer cannot play");
        }
    }

    public void prepare() {
        com.anythink.expressad.exoplayer.ad adVar;
        try {
            if (this.mHasPrepare || (adVar = this.exoPlayer) == null) {
                return;
            }
            adVar.a(this.mediaSource);
            this.mHasPrepare = true;
            this.mIsPlaying = false;
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void releasePlayer() {
        try {
            cancelPlayProgressTimer();
            cancelBufferTimeoutTimer();
            if (this.exoPlayer != null) {
                stop();
                this.exoPlayer.b(this);
                this.exoPlayer.n();
                this.mInnerVFPLisener = null;
                this.mOutterVFListener = null;
            }
            hideLoading();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void seekTo(int i) {
        com.anythink.expressad.exoplayer.ad adVar;
        long j = i;
        try {
            this.mCurrentPosition = j;
            if (this.mHasPrepare && (adVar = this.exoPlayer) != null) {
                adVar.a(j);
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setDataSource() {
        try {
            if (this.exoPlayer != null) {
                android.view.SurfaceHolder surfaceHolder = this.mSurfaceHolder;
                if (surfaceHolder != null) {
                    setDisplay(surfaceHolder);
                }
                boolean z = false;
                this.mHasPrepare = false;
                if (!android.text.TextUtils.equals(this.mMediaSourceUrl, this.mNetVideoUrl)) {
                    try {
                        z = new java.io.File(this.mMediaSourceUrl).exists();
                    } catch (java.lang.Throwable unused) {
                    }
                    if (!z) {
                        this.mediaSource = new com.anythink.expressad.exoplayer.h.o.c(new com.anythink.expressad.exoplayer.j.o(this.mContext, "AT_ExoPlayer")).b(android.net.Uri.parse(this.mNetVideoUrl));
                        this.mMediaSourceUrl = this.mNetVideoUrl;
                    }
                }
                if (android.text.TextUtils.equals(this.mMediaSourceUrl, this.mNetVideoUrl) && this.mVideoReadyRate > 0) {
                    com.anythink.core.common.n.c.a("Video Play Fail:Play Network Url", "AdxExpress videoUrl:" + this.mPlayUrl + ",readyRate:" + this.mVideoReadyRate + ",maxVideoCacheSize:" + com.anythink.core.common.a.k.a().c() + ",lastRecycleCheckDownloadedFileSize:" + com.anythink.core.common.a.k.a().d(), com.anythink.core.common.b.o.a().q());
                }
                this.exoPlayer.a(this.mediaSource);
                this.exoPlayer.a(true);
                startBufferIngTimer(com.anythink.expressad.playercommon.PlayerErrorConstant.PREPARE_TIMEOUT);
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
            hideLoading();
            postOnPlayErrorOnMainThread(com.anythink.expressad.playercommon.PlayerErrorConstant.ILLEGAL_VIDEO_ADDRESS);
            postOnPlaySetDataSourceError2MainThread(com.anythink.expressad.playercommon.PlayerErrorConstant.ILLEGAL_VIDEO_ADDRESS);
        }
    }

    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        try {
            this.exoPlayer.a(surfaceHolder);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            postOnPlayErrorOnMainThread(th.toString());
        }
    }

    public void setFullScreenLoadingView(android.view.View view) {
        if (view != null) {
            try {
                this.mFullScreenLoadingView = view;
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    public void setIsComplete(boolean z) {
        this.mIsComplete = z;
    }

    public void setIsFrontDesk(boolean z) {
        try {
            this.mIsFrontDesk = z;
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setPlaybackParams(float f) {
        try {
            if (exoPlayerIsPlaying()) {
                this.exoPlayer.a(new com.anythink.expressad.exoplayer.v(f));
            } else {
                this.exoPlayer.a(new com.anythink.expressad.exoplayer.v(f));
                this.exoPlayer.m();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void setSelfVideoFeedsPlayerListener(com.anythink.expressad.playercommon.VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mInnerVFPLisener = videoPlayerStatusListener;
    }

    public void setTempEventListener(com.anythink.expressad.reward.player.c cVar) {
        this.tempEventListener = cVar;
    }

    public void setVideoFeedsPlayerListener(com.anythink.expressad.playercommon.VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mOutterVFListener = videoPlayerStatusListener;
    }

    public void setVolume(float f, float f2) {
        try {
            com.anythink.expressad.exoplayer.ad adVar = this.exoPlayer;
            if (adVar != null) {
                adVar.a(f2);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void showLoading() {
        try {
            android.os.Handler handler = this.mHandler;
            if (handler == null) {
                return;
            }
            handler.post(new com.anythink.expressad.playercommon.VideoFeedsPlayer.AnonymousClass4());
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void start(boolean z) {
        try {
            if (this.exoPlayer == null || exoPlayerIsPlaying()) {
                return;
            }
            showLoading();
            play();
            this.mIsPlaying = true;
            if (z) {
                startPlayProgressTimer();
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void stop() {
        try {
            if (this.mHasPrepare && this.exoPlayer != null) {
                hideLoading();
                this.exoPlayer.m();
                this.mHasPrepare = false;
                this.mIsPlaying = false;
                this.mIsComplete = true;
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }
}
