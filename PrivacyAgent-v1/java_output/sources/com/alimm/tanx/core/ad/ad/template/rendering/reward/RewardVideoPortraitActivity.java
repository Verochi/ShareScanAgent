package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes29.dex */
public class RewardVideoPortraitActivity extends android.app.Activity implements com.alimm.tanx.core.utils.NotConfused {
    private android.widget.Button btnForceClose;
    private android.widget.FrameLayout flVideo;
    private android.widget.LinearLayout flWeb;
    private android.widget.ImageView ivAdLogo;
    private android.widget.ImageView ivForceClose;
    private android.widget.ImageView ivVoice;
    private android.widget.LinearLayout llRewardVideoPlay;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.TanxRewardVideoAdView mAdView;
    private com.alimm.tanx.core.utils.TanxCountDownTimer mCountDownTimer;
    private com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd mTanxAd;
    private android.view.ViewStub operationButton;
    private com.alimm.tanx.core.view.player.core.ITanxPlayer player;
    private com.alimm.tanx.core.view.player.ui.TanxPlayerView playerView;
    private java.lang.String reqID;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxRewardVideoExpressAd;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil webViewUtil;
    private final java.lang.String TAG = "RewardVideoPortraitActivity";
    private int nowVoiceRes = com.alimm.tanx.core.R.mipmap.ic_voice;
    private long nowCurrentPosition = 0;
    private long totalTime = 0;
    private java.lang.String nowPlayerState = "ready";
    private volatile boolean startTimerSwitch = false;
    private boolean h5Pause = false;
    private volatile boolean isFront = false;
    private boolean isFirstDraw = true;
    private boolean isSendRewardArrived = false;
    volatile boolean isHsUt = false;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00201 implements java.lang.Runnable {
            public RunnableC00201() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.ivForceClose.setVisibility(8);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adClose() {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.adCloseUpload();
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.finish();
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adSkip(boolean z) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd != null && com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onSkippedVideo();
            }
            if (z) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.adCloseUpload();
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.finish();
            } else if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.playerView != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.playerView.stop();
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public long getCurrentTime() {
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.playerView == null) {
                return 0L;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.nowCurrentPosition = r0.playerView.getCurrentPosition() / 1000;
            com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "当前视频进度：" + com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.nowCurrentPosition);
            return com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.nowCurrentPosition;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public java.lang.String getPlayState() {
            return com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.nowPlayerState;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public long getTotalTime() {
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.playerView == null) {
                return 0L;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.totalTime = r0.playerView.getDuration() / 1000;
            return com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.totalTime;
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void h5NotifyDrawSuccess() {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.ivForceClose.post(new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.AnonymousClass1.RunnableC00201());
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void onScroll(int i, int i2) {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void setPlayer(java.lang.Boolean bool, java.lang.Boolean bool2) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.playerView != null) {
                if (bool != null) {
                    if (bool.booleanValue()) {
                        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = true;
                        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.playerView.mute();
                    } else {
                        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = false;
                        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.playerView.resumeVolume();
                    }
                }
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.h5Pause = true;
                        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.playerView.pause();
                    } else {
                        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.h5Pause = false;
                        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.playerView.start();
                    }
                }
            }
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webDrawStatus(boolean z) {
            if (z || com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.isHsUt) {
                return;
            }
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utErrorCode(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.mTanxAd, com.alimm.tanx.core.ut.UtErrorCode.CRASH_H5_ERROR);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.isHsUt = true;
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webError(int i, java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.e("RewardVideoPortraitActivity", "激励视频：webError: cmd :" + i + " msg:" + str);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void webNotifyCountDown(int i, int i2) {
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.listener.ITanxInteractionListener<com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd> {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public /* synthetic */ void onAdClicked(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd) {
            tanxc_do();
        }

        public void tanxc_do() {
            com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "onAdClicked");
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void onAdShow(com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "onAdShow");
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd == null || com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() == null) {
                return;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onAdShow(iTanxRewardVideoAd);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$3, reason: invalid class name */
    public class AnonymousClass3 extends com.alimm.tanx.core.utils.TanxCountDownTimer {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.btnForceClose.setVisibility(0);
            }
        }

        public AnonymousClass3(long j, long j2) {
            super(j, j2);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            com.alimm.tanx.core.utils.LogUtils.d("adCloseStartTimer", "onFinish");
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.startTimerSwitch = false;
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j) {
            int round = java.lang.Math.round(j / 1000.0f);
            if (round <= 1) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.this.btnForceClose.post(new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.AnonymousClass3.AnonymousClass1());
            }
            com.alimm.tanx.core.utils.LogUtils.d("adCloseStartTimer", round + "");
        }
    }

    private void adCloseStartTimer() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("startTimer - startSwitch:");
        sb.append(this.startTimerSwitch);
        sb.append("  btnForceClose.Visibility：");
        sb.append(this.btnForceClose.getVisibility() == 0);
        sb.append(" isFront：");
        sb.append(this.isFront);
        com.alimm.tanx.core.utils.LogUtils.d("adCloseStartTimer", sb.toString());
        try {
            if (this.isFront && !this.startTimerSwitch && this.btnForceClose.getVisibility() != 0) {
                com.alimm.tanx.core.view.player.ui.TanxPlayerView tanxPlayerView = this.playerView;
                if (tanxPlayerView != null && tanxPlayerView.getState() != null && (this.playerView.getState() == com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED || this.playerView.getState() == com.alimm.tanx.core.view.player.core.PlayerState.END)) {
                    com.alimm.tanx.core.utils.LogUtils.d("adCloseStartTimer", "启动强制关闭倒计时");
                    com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.AnonymousClass3 anonymousClass3 = new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.AnonymousClass3(10000L, 1000L);
                    this.mCountDownTimer = anonymousClass3;
                    anonymousClass3.start();
                    this.startTimerSwitch = true;
                    return;
                }
                java.lang.String str = "";
                if (this.playerView != null) {
                    str = "" + this.playerView.getState();
                }
                com.alimm.tanx.core.utils.LogUtils.d("adCloseStartTimer", "不满足启动条件playerView.getState():" + str);
                return;
            }
            com.alimm.tanx.core.utils.LogUtils.d("adCloseStartTimer", "return");
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("adCloseStartTimer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adCloseUpload() {
        com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
        if (iTanxRewardVideoAd == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getEventTrack() == null) {
            return;
        }
        com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload interactionUpload = com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
        java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> eventTrack = this.mTanxAd.getBidInfo().getEventTrack();
        com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
        interactionUpload.uploadInteraction(eventTrack, 3);
    }

    private void adCloseUtAndUpload() {
        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_if(2);
        }
        adCloseUpload();
    }

    private void bindMonitor() {
        this.mTanxAd.bindRewardVideoAdView(this.mAdView, new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dispatchBufferingState, reason: merged with bridge method [inline-methods] */
    public void lambda$initVideo$8(com.alimm.tanx.core.view.player.core.PlayerBufferingState playerBufferingState) {
        this.nowPlayerState = android.text.TextUtils.isEmpty(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_do.tanxc_do(playerBufferingState)) ? this.nowPlayerState : com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_do.tanxc_do(playerBufferingState);
        com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "nowPlayerState:" + this.nowPlayerState);
        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_do(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_do.tanxc_do(playerBufferingState));
        }
        if (playerBufferingState != com.alimm.tanx.core.view.player.core.PlayerBufferingState.BUFFERING_START && playerBufferingState == com.alimm.tanx.core.view.player.core.PlayerBufferingState.BUFFERING_END) {
            timerCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dispatchStateChange, reason: merged with bridge method [inline-methods] */
    public void lambda$initVideo$7(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer, com.alimm.tanx.core.view.player.core.PlayerState playerState) {
        try {
            java.lang.String tanxc_do = com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_do.tanxc_do(playerState);
            if (android.text.TextUtils.isEmpty(tanxc_do)) {
                tanxc_do = this.nowPlayerState;
            }
            this.nowPlayerState = tanxc_do;
            com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "nowPlayerState:" + this.nowPlayerState);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_do(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_do.tanxc_do(playerState));
            }
            if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.STARTED) {
                if (this.isFirstDraw) {
                    com.alimm.tanx.core.utils.LogUtils.d("utLog", "utViewDraw");
                    com.alimm.tanx.core.ut.impl.TanxRewardUt.utViewDraw(this.mTanxAd, 1);
                }
                this.isFirstDraw = false;
                timerCancel();
                com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
                if (iTanxRewardVideoAd != null) {
                    iTanxRewardVideoAd.onResourceLoadSuccess();
                }
            }
            if (playerState == com.alimm.tanx.core.view.player.core.PlayerState.COMPLETED || playerState == com.alimm.tanx.core.view.player.core.PlayerState.END) {
                videoCompleteAndRewardArrived();
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("RewardVideoPortraitActivity", e);
        }
    }

    private boolean getIntentData() {
        try {
            java.lang.String stringExtra = getIntent().getStringExtra("REQ_ID");
            this.reqID = stringExtra;
            if (android.text.TextUtils.isEmpty(stringExtra)) {
                return false;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxc_newVar = (com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new) com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do.get(this.reqID);
            this.tanxRewardVideoExpressAd = tanxc_newVar;
            if (tanxc_newVar == null) {
                return false;
            }
            this.mTanxAd = tanxc_newVar.tanxc_if;
            return true;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return false;
        }
    }

    private void init() {
        this.llRewardVideoPlay = (android.widget.LinearLayout) findViewById(com.alimm.tanx.core.R.id.ll_reward_video_play);
        this.ivVoice = (android.widget.ImageView) findViewById(com.alimm.tanx.core.R.id.iv_voice);
        this.ivForceClose = (android.widget.ImageView) findViewById(com.alimm.tanx.core.R.id.iv_force_close);
        this.mAdView = (com.alimm.tanx.core.ad.ad.template.rendering.reward.TanxRewardVideoAdView) findViewById(com.alimm.tanx.core.R.id.root_view);
        this.flVideo = (android.widget.FrameLayout) findViewById(com.alimm.tanx.core.R.id.fl_video);
        this.flWeb = (android.widget.LinearLayout) findViewById(com.alimm.tanx.core.R.id.fl_reward_video_portrait_wb);
        this.btnForceClose = (android.widget.Button) findViewById(com.alimm.tanx.core.R.id.btn_force_close);
    }

    private void initVideo() {
        try {
            com.alimm.tanx.core.view.player.ui.TanxPlayerView tanxPlayerView = new com.alimm.tanx.core.view.player.ui.TanxPlayerView(this);
            this.playerView = tanxPlayerView;
            this.flVideo.addView(tanxPlayerView, 0, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
            com.alimm.tanx.core.view.player.core.ITanxPlayer create = com.alimm.tanx.core.TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getTanxPlayer().create();
            this.player = create;
            this.playerView.setTanxPlayer(create);
            this.playerView.setDataSource(this.mTanxAd.getBidInfo().getCreativeItem().getVideo());
            this.playerView.setVideoScaleMode(com.alimm.tanx.core.view.player.VideoScaleMode.FIT_CENTER);
            this.playerView.setCover(this.mTanxAd.getBidInfo().getCreativeItem().getImageUrl());
            com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", this.mTanxAd.getBidInfo().getCreativeItem().getVideo());
            this.playerView.prepare();
            if (this.tanxRewardVideoExpressAd.tanxc_do.mute) {
                this.playerView.mute();
            } else {
                this.playerView.resumeVolume();
            }
            this.playerView.setOnVideoStateChangeListener(new defpackage.cc2(this));
            this.playerView.setOnVideoBufferingListener(new defpackage.dc2(this));
            this.playerView.setOnVideoErrorListener(new defpackage.ec2(this));
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "initVideo()-" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
            com.alimm.tanx.core.ut.impl.TanxRewardUt.utViewDraw(this.mTanxAd, 0);
        }
    }

    private void initView() {
        initVideo();
        initWeb();
    }

    private void initWeb() {
        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil = new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil();
        this.webViewUtil = rewardWebViewUtil;
        rewardWebViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxRewardVideoExpressAd, new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initVideo$9(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer, com.alimm.tanx.core.request.TanxPlayerError tanxPlayerError) {
        com.alimm.tanx.core.utils.LogUtils.e("playerView", tanxPlayerError);
        com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxc_newVar = this.tanxRewardVideoExpressAd;
        if (tanxc_newVar != null && tanxc_newVar.tanxc_for() != null) {
            this.tanxRewardVideoExpressAd.tanxc_for().onVideoError(tanxPlayerError);
        }
        com.alimm.tanx.core.ut.impl.TanxRewardUt.utViewDraw(this.mTanxAd, 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$timerCancel$10() {
        this.btnForceClose.setVisibility(8);
    }

    private void timerCancel() {
        try {
            com.alimm.tanx.core.utils.LogUtils.e("RewardVideoPortraitActivity", "adCloseTimerCancel");
            com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.mCountDownTimer = null;
            }
            this.btnForceClose.post(new defpackage.fc2(this));
            this.startTimerSwitch = false;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("timerCancel", e);
        }
    }

    private void videoCompleteAndRewardArrived() {
        adCloseStartTimer();
        com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "开始判断发奖 totalTime：" + this.totalTime + "  nowCurrentPosition：" + this.nowCurrentPosition + "  isSendRewardArrived:" + this.isSendRewardArrived);
        if (this.isSendRewardArrived) {
            return;
        }
        long j = this.totalTime;
        if (j <= 0 || j - this.nowCurrentPosition > 1) {
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "触发发奖");
        this.isSendRewardArrived = true;
        com.alimm.tanx.core.ut.impl.TanxRewardUt.utIsRewardValid(this.mTanxAd, 0);
        this.tanxRewardVideoExpressAd.tanxc_for().onVideoComplete();
        this.tanxRewardVideoExpressAd.tanxc_for().onRewardArrived(true, 0, null);
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.alimm.tanx.core.R.id.ll_reward_video_feed_back) {
            new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog(this, com.alimm.tanx.core.R.style.CommonDialog, this.mTanxAd).show();
        } else if (id == com.alimm.tanx.core.R.id.iv_voice) {
            int i = this.nowVoiceRes;
            int i2 = com.alimm.tanx.core.R.mipmap.ic_voice;
            if (i == i2) {
                i2 = com.alimm.tanx.core.R.mipmap.ic_mute;
            }
            this.ivVoice.setImageResource(i2);
            this.nowVoiceRes = i2;
        } else if (id == com.alimm.tanx.core.R.id.ll_reward_video_play) {
            this.llRewardVideoPlay.setVisibility(8);
        } else if (id == com.alimm.tanx.core.R.id.iv_close) {
            this.mTanxAd.click("", "");
        } else if (id == com.alimm.tanx.core.R.id.btn_pre_load_h5) {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer.resume();
        } else if (id == com.alimm.tanx.core.R.id.btn_send_play_state) {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_do("2123");
            }
        } else if (id == com.alimm.tanx.core.R.id.btn_send_audio) {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil2 = this.webViewUtil;
            if (rewardWebViewUtil2 != null) {
                rewardWebViewUtil2.tanxc_do(0);
            }
        } else if (id == com.alimm.tanx.core.R.id.btn_force_close) {
            adCloseUtAndUpload();
            finish();
        } else if (id == com.alimm.tanx.core.R.id.iv_force_close) {
            adCloseUtAndUpload();
            finish();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.alimm.tanx.core.R.layout.activity_reward_video_portrait);
        if (!getIntentData()) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "getIntentData数据有问题。");
            finish();
        } else {
            init();
            initView();
            bindMonitor();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.playerView != null) {
                com.alimm.tanx.core.ut.impl.TanxRewardUt.utCloseAdVideoProgress(this.mTanxAd, r0.getCurrentPosition());
                this.playerView.release();
            }
            com.alimm.tanx.core.utils.VideoCacheManager.getInstance().clearThis(this.tanxRewardVideoExpressAd);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do(this.reqID);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxc_newVar = this.tanxRewardVideoExpressAd;
            if (tanxc_newVar != null && tanxc_newVar.tanxc_for() != null) {
                this.tanxRewardVideoExpressAd.tanxc_for().onAdClose();
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_if();
            }
            timerCancel();
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("RewardVideoPortraitActivity", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "RewardVideoPortraitActivity", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        if (i != 4 || this.btnForceClose.getVisibility() != 0) {
            return true;
        }
        adCloseUtAndUpload();
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel();
        if (this.playerView != null) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "playerView onPause");
            this.playerView.pause();
        }
        if (this.webViewUtil != null) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardVideoPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isFront = true;
        com.alimm.tanx.core.view.player.ui.TanxPlayerView tanxPlayerView = this.playerView;
        if (tanxPlayerView != null && tanxPlayerView.getState() == com.alimm.tanx.core.view.player.core.PlayerState.PAUSED && !this.h5Pause) {
            this.playerView.start();
        }
        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_int();
        }
        adCloseStartTimer();
    }
}
