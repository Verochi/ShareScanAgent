package com.alimm.tanx.core.ad.ad.feed;

/* loaded from: classes.dex */
public class FeedVideoManager implements com.alimm.tanx.core.ad.ad.feed.ITanxVideoView, com.alimm.tanx.core.utils.NotConfused, com.alimm.tanx.core.view.feed.ITanxFeedCacheContext {
    private static final java.lang.String TAG = "FeedVideoManager";
    private final com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd;
    private com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener iTanxFeedVideoAdListener;
    private com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback iTanxFeedVideoMonitorCallback;
    private com.alimm.tanx.core.view.player.core.ITanxPlayer player;
    private volatile com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer;
    private final com.alimm.tanx.core.view.feed.tanxc_do tanxFeedVideoViewCache;
    private com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView;
    private int duration = 0;
    private int nowCurrentCount = 0;
    private boolean nowViewAttach = false;
    private final long defaultVideoSize = 52428800;
    private boolean isPlayed = false;
    private boolean nowMute = false;
    private volatile boolean isShow = false;
    private volatile boolean video3SReportCompleted = false;

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
        public void attach() {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.TAG, "attach ");
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.startPlay(true);
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoLoad(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.iTanxFeedAd);
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.nowViewAttach = true;
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
        public void detached() {
            try {
                com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.isShow = false;
                com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.nowViewAttach = false;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("detached:");
                sb.append((com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.tanxVideoView == null || com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.tanxVideoView.getState() == null) ? "tanxVideoView为空" : com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.tanxVideoView.getState().name());
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.TAG, sb.toString());
                com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.stop();
                com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.iTanxFeedVideoMonitorCallback = null;
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(e);
            }
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposure() {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposureTime(long j) {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void onMonitor(java.util.Map<java.lang.String, java.lang.Object> map) {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
        public void remove() {
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.isShow = false;
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.stop();
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
        public void show() {
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.isShow = true;
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.startPlay(true);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener {
        final /* synthetic */ com.alimm.tanx.core.ad.monitor.tanxc_do tanxc_do;

        public AnonymousClass2(com.alimm.tanx.core.ad.monitor.tanxc_do tanxc_doVar) {
            this.tanxc_do = tanxc_doVar;
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
        public void onStateChange(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer, com.alimm.tanx.core.view.player.core.PlayerState playerState) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.TAG, "onStateChange state " + playerState.name() + " url:" + iTanxPlayer.getUrl() + "  adMonitor.getAttachedWindow():" + this.tanxc_do.tanxc_goto() + ", isAttach:" + com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.isAttach());
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.initState(playerState);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.view.player.core.OnVideoBufferingListener {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
        public void OnBufferStateChanged(com.alimm.tanx.core.view.player.core.PlayerBufferingState playerBufferingState) {
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.view.player.core.OnVideoErrorListener {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
        public boolean onError(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer, com.alimm.tanx.core.request.TanxPlayerError tanxPlayerError) {
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoError(tanxPlayerError);
            com.alimm.tanx.core.ut.impl.TanxRewardUt.utViewDraw(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.iTanxFeedAd, 0);
            return false;
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.play();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$6, reason: invalid class name */
    public class AnonymousClass6 extends com.alimm.tanx.core.utils.TanxCountDownTimer {
        public AnonymousClass6(long j, long j2) {
            super(j, j2);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            try {
                if (com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.iTanxFeedAd.getAdSlot().getVideoParam().looping) {
                    com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.TAG, "onFinish - tanxVideoView.getState()：" + com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.tanxVideoView.getState());
                    com.alimm.tanx.core.ad.ad.feed.FeedVideoManager feedVideoManager = com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this;
                    feedVideoManager.initState(feedVideoManager.tanxVideoView.getState());
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(e);
            }
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.TAG, "initVideoProgress - onFinish");
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j) {
            if (com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.tanxVideoView != null && com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.tanxVideoView.getState() != com.alimm.tanx.core.view.player.core.PlayerState.STARTED) {
                com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.stopVideoProgress();
            }
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.correctTimer(java.lang.Long.valueOf(j), com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.tanxVideoView);
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.nowCurrentCount = java.lang.Math.round(j / 1000.0f);
            int round = java.lang.Math.round(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.duration / 1000.0f);
            long j2 = round;
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.iTanxFeedVideoAdListener.onProgressUpdate(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.nowCurrentCount, j2);
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.exposeVideo3s(r1.nowCurrentCount, j2);
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.TAG, "initVideoProgress nowCurrentCount：" + com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.nowCurrentCount + " duration：" + round + " millisUntilFinished:" + j);
            if (round - com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.nowCurrentCount > 1) {
                com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.this.isPlayed = true;
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] tanxc_do;

        static {
            int[] iArr = new int[com.alimm.tanx.core.view.player.core.PlayerState.values().length];
            tanxc_do = iArr;
            try {
                iArr[com.alimm.tanx.core.view.player.core.PlayerState.IDLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                tanxc_do[com.alimm.tanx.core.view.player.core.PlayerState.PREPARED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                tanxc_do[com.alimm.tanx.core.view.player.core.PlayerState.PAUSED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public FeedVideoManager(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd, com.alimm.tanx.core.view.feed.tanxc_do tanxc_doVar, android.content.Context context) {
        this.tanxFeedVideoViewCache = tanxc_doVar;
        this.iTanxFeedAd = iTanxFeedAd;
        initVideoView(context);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, iTanxFeedAd.getBidInfo().getCreativeItem().getVideo());
    }

    private void autoPlayCheck() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "autoPlayCheck");
        if (this.isPlayed) {
            playItem(true);
            return;
        }
        if (this.iTanxFeedAd.getAdSlot().getVideoParam() != null && this.iTanxFeedAd.getAdSlot().getVideoParam().mute) {
            mute();
        }
        if (this.iTanxFeedAd.getAdSlot().isNotAutoPlay()) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "媒体设置不自动播放");
            playItem(false);
            return;
        }
        if (!this.iTanxFeedAd.getAdSlot().isPlayUnderWifi()) {
            playItem(true);
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "媒体设置wifi下自动播放 NetworkType" + com.alimm.tanx.core.utils.NetWorkUtil.getNetworkType(com.alimm.tanx.core.TanxCoreSdk.getApplication()).getKey());
        if (com.alimm.tanx.core.utils.NetWorkUtil.getNetworkType(com.alimm.tanx.core.TanxCoreSdk.getApplication()).getKey() == 1) {
            playItem(true);
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "当前非wifi环境只准备，不自动播放");
        this.player.setPlayWhenReady(false);
        playItem(false);
    }

    private void callBackAndSetUi(com.alimm.tanx.core.view.player.core.PlayerState playerState) {
        if (this.tanxVideoView != null) {
            com.alimm.tanx.core.view.player.core.PlayerState playerState2 = com.alimm.tanx.core.view.player.core.PlayerState.STARTED;
            if (playerState == playerState2) {
                this.iTanxFeedVideoAdListener.onVideoAdStartPlay(this.iTanxFeedAd);
            } else if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.PAUSED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.STOPPED) {
                this.iTanxFeedVideoAdListener.onVideoAdPaused(this.iTanxFeedAd);
            } else if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.END) {
                this.iTanxFeedVideoAdListener.onVideoComplete();
            }
            if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.IDLE || playerState == com.alimm.tanx.core.view.player.core.PlayerState.INITIALIZED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.ERROR || playerState == com.alimm.tanx.core.view.player.core.PlayerState.PAUSED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.STOPPED) {
                this.tanxVideoView.setPauseType();
                return;
            }
            if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.PREPARING) {
                this.tanxVideoView.setLoadingType();
                return;
            }
            if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.END || playerState == playerState2) {
                this.tanxVideoView.setPlayType();
                return;
            }
            if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.PREPARED) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "onStateChangeTest " + this.player.getState().name());
                com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer = this.player;
                if (iTanxPlayer == null || iTanxPlayer.getState() == playerState2) {
                    return;
                }
                this.tanxVideoView.setPauseType();
            }
        }
    }

    private void cancelVideoProgress() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("cancelVideoProgress played:");
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
        sb.append(tanxVideoView != null ? tanxVideoView.getState().name() : "");
        com.alimm.tanx.core.utils.LogUtils.d(TAG, sb.toString());
        try {
            if (this.tanxCountDownTimer != null) {
                this.tanxCountDownTimer.cancel();
                this.tanxCountDownTimer = null;
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "cancelVideoProgress", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void correctTimer(java.lang.Long l, com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView) {
        int round;
        if (tanxVideoView != null) {
            if (l == null) {
                if (tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition() <= 0 || this.tanxCountDownTimer == null) {
                    return;
                }
                this.tanxCountDownTimer.updateTime(tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition());
                this.tanxCountDownTimer.resume();
                return;
            }
            int round2 = java.lang.Math.round(l.longValue() / 1000.0f);
            if (tanxVideoView.getCurrentPosition() <= 0 || (round = java.lang.Math.round((tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition()) / 1000.0f)) <= 1 || java.lang.Math.abs(round - round2) <= 1 || this.tanxCountDownTimer == null) {
                return;
            }
            this.tanxCountDownTimer.updateTime(tanxVideoView.getDuration() - tanxVideoView.getCurrentPosition());
            this.tanxCountDownTimer.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exposeVideo3s(long j, long j2) {
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd;
        try {
            if (this.video3SReportCompleted || (iTanxFeedAd = this.iTanxFeedAd) == null || iTanxFeedAd.getBidInfo() == null || this.iTanxFeedAd.getBidInfo().getEventTrack() == null) {
                return;
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "exposeVideo3s start current:" + j + " duration:" + j2);
            com.alimm.tanx.core.ad.bean.BidInfo bidInfo = this.iTanxFeedAd.getBidInfo();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (bidInfo != null && bidInfo.getEventTrack() != null && bidInfo.getEventTrack().size() > 0) {
                for (int i = 0; i < bidInfo.getEventTrack().size(); i++) {
                    com.alimm.tanx.core.ad.listener.bean.NewTrackItem newTrackItem = bidInfo.getEventTrack().get(i);
                    if (newTrackItem != null && newTrackItem.getType() == 2 && newTrackItem.getTime() != -1) {
                        int i2 = (int) (j2 - j);
                        com.alimm.tanx.core.utils.LogUtils.d(TAG, "exposeVideo3s startTime:" + i2 + " newTrackItem.getTime():" + newTrackItem.getTime());
                        if (i2 == newTrackItem.getTime()) {
                            arrayList.addAll(bidInfo.getEventTrack().get(i).getUrl());
                        }
                    }
                }
            }
            if (arrayList.size() <= 0) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "exposeVideo3s urls 为空，不调用上报");
            } else {
                com.alimm.tanx.core.ad.event.track.expose.ExposeManager.tanxc_do().tanxc_do(bidInfo, this.iTanxFeedAd.getAdSlot().getReqId(), this.iTanxFeedAd.getAdSlot().getPid(), arrayList);
                this.video3SReportCompleted = true;
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
        }
    }

    private com.alimm.tanx.core.view.player.ui.TanxPlayerView getVideoView() {
        try {
            if (this.tanxVideoView == null) {
                initVideoView(com.alimm.tanx.core.TanxCoreSdk.getApplication());
            }
            this.tanxVideoView.setiTanxFeedVideoAdListener(this.iTanxFeedVideoAdListener);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "getVideoView()-" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
            com.alimm.tanx.core.ut.impl.TanxRewardUt.utViewDraw(this.iTanxFeedAd, 0);
        }
        return this.tanxVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initState(com.alimm.tanx.core.view.player.core.PlayerState playerState) {
        playCheck(playerState);
        setVideoProgress(playerState, false);
        callBackAndSetUi(playerState);
    }

    private void initVideoProgress() {
        try {
            if (this.tanxCountDownTimer != null) {
                return;
            }
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
            if (tanxVideoView != null) {
                this.duration = tanxVideoView.getDuration();
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "initVideoProgress duration" + this.duration + "");
            if (this.tanxCountDownTimer == null) {
                this.tanxCountDownTimer = new com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.AnonymousClass6(this.duration, 1000L);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "initVideoProgress", e);
        }
    }

    private void initVideoView(android.content.Context context) {
        try {
            com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxc_do = this.tanxFeedVideoViewCache.tanxc_do(this, context);
            this.tanxVideoView = tanxc_do;
            tanxc_do.setTanxAd(this.iTanxFeedAd);
            com.alimm.tanx.core.view.player.core.ITanxPlayer create = com.alimm.tanx.core.TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getTanxPlayer().create();
            this.player = create;
            create.setLooping(this.iTanxFeedAd.getAdSlot().getVideoParam().looping);
            com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.AnonymousClass1 anonymousClass1 = new com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.AnonymousClass1();
            this.iTanxFeedVideoMonitorCallback = anonymousClass1;
            com.alimm.tanx.core.ad.monitor.tanxc_for tanxc_forVar = new com.alimm.tanx.core.ad.monitor.tanxc_for(this.tanxVideoView, anonymousClass1);
            this.tanxVideoView.setAdMonitor(tanxc_forVar);
            this.tanxVideoView.setOnVideoStateChangeListener(new com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.AnonymousClass2(tanxc_forVar));
            this.tanxVideoView.setOnVideoBufferingListener(new com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.AnonymousClass3());
            this.tanxVideoView.setOnVideoErrorListener(new com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.AnonymousClass4());
            this.tanxVideoView.setPlayClickListener(new com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.AnonymousClass5());
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "initVideoView()-" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
            com.alimm.tanx.core.ut.impl.TanxRewardUt.utViewDraw(this.iTanxFeedAd, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAttach() {
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
        return (tanxVideoView == null || tanxVideoView.getWindowToken() == null) ? false : true;
    }

    private void playCheck(com.alimm.tanx.core.view.player.core.PlayerState playerState) {
        if (!playerState.equals(com.alimm.tanx.core.view.player.core.PlayerState.STARTED) || this.nowViewAttach) {
            return;
        }
        stop();
    }

    private void playItem(boolean z) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "playItem");
        if (this.tanxVideoView != null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "playItem isIdle:" + this.tanxVideoView.getState() + "， isStart:" + z + "， isShow:" + this.isShow);
            int i = com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.AnonymousClass7.tanxc_do[this.tanxVideoView.getState().ordinal()];
            if (i == 1) {
                if (!z || !this.isShow) {
                    this.player.setPlayWhenReady(false);
                }
                this.tanxVideoView.prepare();
            } else if (i == 2 || i == 3) {
                this.tanxVideoView.showCoverView(true);
            } else {
                this.tanxVideoView.showCoverView(false);
            }
            if (z && this.isShow) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "先暂停所有视频，再起播当前视频");
                com.alimm.tanx.core.utils.PlayerListManager.getInstance().stopOtherPlayer(this.iTanxFeedAd);
                this.player.setPlayWhenReady(true);
                this.tanxVideoView.prepare();
                this.tanxVideoView.start();
            }
        }
    }

    private void setVideoProgress(com.alimm.tanx.core.view.player.core.PlayerState playerState, boolean z) {
        if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.STARTED) {
            startVideoProgress(z);
        } else {
            stopVideoProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay(boolean z) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "startPlay fromAttach：" + z);
        if (!videoSizeCheck(this.iTanxFeedAd)) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "视频体积超限");
            this.iTanxFeedVideoAdListener.onError(new com.alimm.tanx.core.request.TanxError(this.iTanxFeedAd.getRequestId(), "视频超限"));
            return;
        }
        if (this.tanxVideoView != null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "startPlay tanxVideoView.getState()：" + this.tanxVideoView.getState().name());
            if (this.tanxVideoView.getState().equals(com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED)) {
                return;
            }
            if (this.tanxVideoView.getState().equals(com.alimm.tanx.core.view.player.core.PlayerState.ERROR)) {
                this.tanxVideoView.reset();
            }
            if (this.tanxVideoView.getState().equals(com.alimm.tanx.core.view.player.core.PlayerState.IDLE)) {
                this.tanxVideoView.setTanxPlayer(this.player);
                this.tanxVideoView.setDataSource(this.iTanxFeedAd.getBidInfo().getCreativeItem().getVideo());
                this.tanxVideoView.setVideoScaleMode(com.alimm.tanx.core.view.player.VideoScaleMode.FIT_CENTER);
                this.tanxVideoView.setCover(this.iTanxFeedAd.getBidInfo().getCreativeItem().getImageUrl());
                if (z) {
                    autoPlayCheck();
                } else {
                    playItem(true);
                }
            } else if (z) {
                autoPlayCheck();
            } else {
                playItem(true);
            }
            this.iTanxFeedAd.onResourceLoadSuccess();
        }
    }

    private synchronized void startVideoProgress(boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("startVideoProgress played:");
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
        sb.append(tanxVideoView != null ? tanxVideoView.getState().name() : "");
        com.alimm.tanx.core.utils.LogUtils.d(TAG, sb.toString());
        try {
            initVideoProgress();
            if (this.tanxCountDownTimer.isPaused() && this.tanxVideoView.getState() == com.alimm.tanx.core.view.player.core.PlayerState.STARTED) {
                correctTimer(null, this.tanxVideoView);
            } else {
                com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
                if (iTanxFeedAd == null || iTanxFeedAd.getAdSlot() == null || this.iTanxFeedAd.getAdSlot().getVideoParam() == null || !((this.iTanxFeedAd.getAdSlot().getVideoParam().looping || z) && this.tanxCountDownTimer.getNowType() == 4)) {
                    this.tanxCountDownTimer.start();
                } else {
                    this.tanxCountDownTimer.updateTime(this.tanxVideoView.getDuration() - this.tanxVideoView.getCurrentPosition());
                    this.tanxCountDownTimer.finishReStart();
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "startVideoProgress", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView == null || tanxVideoView.getState() == null || this.tanxVideoView.getState().equals(com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED)) {
            return;
        }
        this.tanxVideoView.stop();
        stopVideoProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVideoProgress() {
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("stopVideoProgress played:");
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView2 = this.tanxVideoView;
        sb.append(tanxVideoView2 != null ? tanxVideoView2.getState().name() : "");
        com.alimm.tanx.core.utils.LogUtils.d(TAG, sb.toString());
        try {
            if (this.tanxCountDownTimer == null || (tanxVideoView = this.tanxVideoView) == null || tanxVideoView.getState() == com.alimm.tanx.core.view.player.core.PlayerState.STARTED) {
                return;
            }
            this.tanxCountDownTimer.pause();
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "startVideoProgress", e);
        }
    }

    private boolean videoSizeCheck(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd) {
        java.lang.Long l;
        if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || iTanxFeedAd.getBidInfo().getCreativeItem() == null || android.text.TextUtils.isEmpty(iTanxFeedAd.getBidInfo().getCreativeItem().getVideo())) {
            return true;
        }
        java.util.LinkedHashMap<java.lang.String, java.lang.Long> linkedHashMap = com.alimm.tanx.core.view.player.cache.VideoGetSizeManager.mCachedVideoSizeMap;
        long j = 0;
        if (linkedHashMap != null && (l = linkedHashMap.get(iTanxFeedAd.getBidInfo().getCreativeItem().getVideo())) != null) {
            j = l.longValue();
        }
        return j <= ((com.alimm.tanx.core.orange.OrangeManager.getInstance().getThreshold(com.alimm.tanx.core.orange.OrangeManager.FEED_VIDEO_MAX_SIZE) > (-1L) ? 1 : (com.alimm.tanx.core.orange.OrangeManager.getInstance().getThreshold(com.alimm.tanx.core.orange.OrangeManager.FEED_VIDEO_MAX_SIZE) == (-1L) ? 0 : -1)) > 0 ? (com.alimm.tanx.core.orange.OrangeManager.getInstance().getThreshold(com.alimm.tanx.core.orange.OrangeManager.FEED_VIDEO_MAX_SIZE) * 1024) * 1024 : 52428800L);
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void destroy() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "destroy");
        if (this.tanxVideoView != null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "destroy tanxVideoView置空");
            this.tanxVideoView.release();
            this.tanxVideoView = null;
        }
        com.alimm.tanx.core.utils.VideoCacheManager.getInstance().clearThis(this.iTanxFeedAd);
        cancelVideoProgress();
    }

    public java.lang.String getSessionId() {
        com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        return (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null) ? com.igexin.push.core.b.m : this.iTanxFeedAd.getBidInfo().getSessionId();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public android.view.View getVideoAdView(com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener iTanxFeedVideoAdListener) {
        this.iTanxFeedVideoAdListener = iTanxFeedVideoAdListener;
        return getVideoView();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public boolean isMute() {
        return this.nowMute;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void mute() {
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.mute();
            this.nowMute = true;
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void pause() {
        stop();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void play() {
        startPlay(false);
    }

    @Override // com.alimm.tanx.core.view.feed.ITanxFeedCacheContext
    public android.view.View remove() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "remove");
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.release();
        }
        this.tanxVideoView = null;
        return tanxVideoView;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void replay() {
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.replay();
            setVideoProgress(this.tanxVideoView.getState(), true);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void resumeVolume() {
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.resumeVolume();
            this.nowMute = false;
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void setVolume(int i) {
        com.alimm.tanx.core.ad.ad.feed.TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.setVolume(i);
            this.nowMute = i <= 0;
        }
    }
}
