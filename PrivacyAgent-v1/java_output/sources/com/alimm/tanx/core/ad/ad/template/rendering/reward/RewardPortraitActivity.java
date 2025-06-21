package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes29.dex */
public class RewardPortraitActivity extends android.app.Activity implements com.alimm.tanx.core.utils.NotConfused {
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if errorPopupWindow;
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog exitRetentionDialog;
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog feedBackDialog;
    private android.widget.LinearLayout flWeb;
    private android.widget.ImageView ivAdLogo;
    private android.widget.ImageView ivVoice;
    private android.widget.LinearLayout llRewardVideoPlay;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.TanxRewardAdView mAdView;
    private com.alimm.tanx.core.utils.TanxCountDownTimer mCountDownTimer;
    private com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd mTanxAd;
    private java.lang.String reqID;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface rewardInterface;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxRewardVideoExpressAd;
    private android.widget.TextView tvRewardCountDownTxt;
    private android.widget.TextView tvRewardVideoCountDown;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil webViewUtil;
    private final java.lang.String TAG = "RewardPortraitActivity";
    private int nowVoiceRes = com.alimm.tanx.core.R.mipmap.ic_voice;
    private volatile boolean startTimerSwitch = false;
    private volatile boolean timerFinishSwitch = false;
    private volatile boolean isFront = false;
    private boolean isSendRewardArrived = false;
    private volatile int nowWebViewSlideDistance = 0;
    private volatile int lastWebViewSlideDistance = 0;
    private final int SLIDE_CALCULATE_INTERVAL = 5;
    private volatile int nowCalculateNoSlide = 0;
    volatile boolean isHsUt = false;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback {
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig tanxc_do;

        public AnonymousClass1(com.alimm.tanx.core.image.util.ImageConfig imageConfig) {
            this.tanxc_do = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(java.lang.String str) {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.ivAdLogo.setVisibility(8);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(android.graphics.Bitmap bitmap) {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.ivAdLogo.setImageBitmap(bitmap);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.ivAdLogo.setVisibility(0);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.ivAdLogo.setImageDrawable(new com.alimm.tanx.core.image.util.TanxDrawable(bitmap, this.tanxc_do.getImageConfig()));
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.errorPopupWindow == null || !com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                    return;
                }
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adClose() {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.adCloseUpload();
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.finish();
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adSkip(boolean z) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tanxRewardVideoExpressAd != null && com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onSkippedVideo();
            }
            if (z) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.adCloseUpload();
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.finish();
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public long getCurrentTime() {
            return 0L;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public java.lang.String getPlayState() {
            return null;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public long getTotalTime() {
            return 0L;
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void h5NotifyDrawSuccess() {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "h5NotifyDrawSuccess");
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.flWeb.post(new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.AnonymousClass2.AnonymousClass1());
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void onScroll(int i, int i2) {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.nowWebViewSlideDistance = i2;
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.startTimer();
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void setPlayer(java.lang.Boolean bool, java.lang.Boolean bool2) {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webDrawStatus(boolean z) {
            if (z) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.mTanxAd.onResourceLoadSuccess();
                com.alimm.tanx.core.utils.LogUtils.d("utLog", "utViewDraw");
                com.alimm.tanx.core.ut.impl.TanxRewardUt.utViewDraw(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.mTanxAd, 1);
            } else {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.showErrorDialog();
                if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.isHsUt) {
                    return;
                }
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utErrorCode(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.mTanxAd, com.alimm.tanx.core.ut.UtErrorCode.CRASH_H5_ERROR);
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.isHsUt = true;
            }
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webError(int i, java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.e("RewardPortraitActivity", "webError: cmd :" + i + " msg:" + str);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.showErrorDialog();
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
        public void webNotifyCountDown(int i, int i2) {
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.ad.listener.ITanxInteractionListener<com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd> {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public /* synthetic */ void onAdClicked(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd) {
            tanxc_do();
        }

        public void tanxc_do() {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "onAdClicked");
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void onAdShow(com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "onAdShow");
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tanxRewardVideoExpressAd == null || com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for() == null) {
                return;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_for().onAdShow(iTanxRewardVideoAd);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$4$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.finish();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.errorPopupWindow.tanxc_do(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.mAdView, new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.AnonymousClass4.AnonymousClass1());
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack {
        public AnonymousClass5() {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack
        public void continueClick() {
            com.alimm.tanx.core.ut.impl.TanxRewardUt.utSavePopPresist(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tanxRewardVideoExpressAd);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.ClickCallBack
        public void exitClick() {
            com.alimm.tanx.core.ut.impl.TanxRewardUt.utSavePopCancel(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tanxRewardVideoExpressAd);
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.rewardInterface != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.rewardInterface.adClose();
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.finish();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity$6, reason: invalid class name */
    public class AnonymousClass6 extends com.alimm.tanx.core.utils.TanxCountDownTimer {
        public AnonymousClass6(long j, long j2) {
            super(j, j2);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            com.alimm.tanx.core.utils.LogUtils.d("startTimer", "onFinish");
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tvRewardVideoCountDown.setVisibility(8);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tvRewardCountDownTxt.setText("已领取");
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.rewardArrived();
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tvRewardCountDownTxt.getLayoutParams();
            marginLayoutParams.leftMargin = (int) android.util.TypedValue.applyDimension(1, 8.0f, com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.getResources().getDisplayMetrics());
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tvRewardCountDownTxt.setLayoutParams(marginLayoutParams);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.timerFinishSwitch = true;
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.startTimerSwitch = false;
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j) {
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.isDialogShow()) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.mCountDownTimer.pause();
            }
            if (!com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.isSlide() && com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.access$1404(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this) >= 5) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.mCountDownTimer.pause();
            }
            int round = java.lang.Math.round(j / 1000.0f);
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tvRewardVideoCountDown != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.this.tvRewardVideoCountDown.setText(round + "s");
            }
            com.alimm.tanx.core.utils.LogUtils.d("startTimer", round + "");
        }
    }

    public static /* synthetic */ int access$1404(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity rewardPortraitActivity) {
        int i = rewardPortraitActivity.nowCalculateNoSlide + 1;
        rewardPortraitActivity.nowCalculateNoSlide = i;
        return i;
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
        this.mTanxAd.bindRewardVideoAdView(this.mAdView, new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.AnonymousClass3());
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

    private long getTimeCount() {
        try {
            com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
            if (iTanxRewardVideoAd == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getTemplateConf() == null || android.text.TextUtils.isEmpty(this.mTanxAd.getBidInfo().getTemplateConf().getCountDown())) {
                return 30L;
            }
            return java.lang.Long.parseLong(this.mTanxAd.getBidInfo().getTemplateConf().getCountDown()) / 1000;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return 30L;
        }
    }

    private void init() {
        this.llRewardVideoPlay = (android.widget.LinearLayout) findViewById(com.alimm.tanx.core.R.id.ll_reward_video_play);
        this.ivVoice = (android.widget.ImageView) findViewById(com.alimm.tanx.core.R.id.iv_voice);
        this.ivAdLogo = (android.widget.ImageView) findViewById(com.alimm.tanx.core.R.id.iv_ad_logo);
        this.mAdView = (com.alimm.tanx.core.ad.ad.template.rendering.reward.TanxRewardAdView) findViewById(com.alimm.tanx.core.R.id.root_view);
        this.flWeb = (android.widget.LinearLayout) findViewById(com.alimm.tanx.core.R.id.fl_reward_video_portrait_wb);
        this.tvRewardVideoCountDown = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_reward_count_down);
        this.tvRewardCountDownTxt = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_reward_count_down_txt);
        this.tvRewardVideoCountDown.setText(getTimeCount() + "s");
    }

    private void initView() {
        initWeb();
        com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
        if (iTanxRewardVideoAd == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getCreativeItem() == null || android.text.TextUtils.isEmpty(this.mTanxAd.getBidInfo().getCreativeItem().getAdvLogo())) {
            return;
        }
        com.alimm.tanx.core.image.util.ImageConfig build = com.alimm.tanx.core.image.ImageManager.with(this.ivAdLogo.getContext()).url(this.mTanxAd.getBidInfo().getCreativeItem().getAdvLogo()).scaleMode(com.alimm.tanx.core.image.util.ScaleMode.FIT_CENTER).build();
        com.alimm.tanx.core.image.ImageManager.getLoader().load(build, new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.AnonymousClass1(build));
    }

    private void initWeb() {
        this.webViewUtil = new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil();
        this.rewardInterface = new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.AnonymousClass2();
        this.webViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxRewardVideoExpressAd, this.rewardInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDialogShow() {
        com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog exitRetentionDialog = this.exitRetentionDialog;
        if (exitRetentionDialog != null && exitRetentionDialog.isShowing()) {
            return true;
        }
        com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog feedBackDialog = this.feedBackDialog;
        return feedBackDialog != null && feedBackDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSlide() {
        if (this.lastWebViewSlideDistance == this.nowWebViewSlideDistance) {
            return false;
        }
        this.lastWebViewSlideDistance = this.nowWebViewSlideDistance;
        this.nowCalculateNoSlide = 0;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewardArrived() {
        try {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "开始判断发奖 isSendRewardArrived:" + this.isSendRewardArrived);
            if (this.isSendRewardArrived) {
                return;
            }
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "触发发奖");
            this.isSendRewardArrived = true;
            com.alimm.tanx.core.ut.impl.TanxRewardUt.utIsRewardValid(this.mTanxAd, 0);
            this.tanxRewardVideoExpressAd.tanxc_for().onVideoComplete();
            this.tanxRewardVideoExpressAd.tanxc_for().onRewardArrived(true, 0, null);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("RewardPortraitActivity", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog() {
        if (this.errorPopupWindow == null) {
            this.errorPopupWindow = new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if(this);
        }
        this.flWeb.postDelayed(new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.AnonymousClass4(), 200L);
    }

    private void showExitRetentionDialog() {
        com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd;
        if (this.isSendRewardArrived || (iTanxRewardVideoAd = this.mTanxAd) == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getTemplateConf() == null || (!android.text.TextUtils.isEmpty(this.mTanxAd.getBidInfo().getTemplateConf().getBackPop()) && this.mTanxAd.getBidInfo().getTemplateConf().getBackPop().equals("0"))) {
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface rewardInterface = this.rewardInterface;
            if (rewardInterface != null) {
                rewardInterface.adClose();
            }
            finish();
            return;
        }
        com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog exitRetentionDialog = new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog(this, com.alimm.tanx.core.R.style.CommonDialog);
        this.exitRetentionDialog = exitRetentionDialog;
        exitRetentionDialog.setClickCallBack(new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.AnonymousClass5());
        this.exitRetentionDialog.show();
        com.alimm.tanx.core.ut.impl.TanxRewardUt.utSavePopImp(this.tanxRewardVideoExpressAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer() {
        if (!this.timerFinishSwitch && !isDialogShow() && isSlide() && this.isFront) {
            if (!this.startTimerSwitch) {
                this.mCountDownTimer = new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.AnonymousClass6(1000 * getTimeCount(), 1000L);
                com.alimm.tanx.core.utils.LogUtils.d("startTimer", "启动倒计时");
                this.mCountDownTimer.start();
                this.startTimerSwitch = true;
                return;
            }
            com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer == null || !tanxCountDownTimer.isPaused()) {
                return;
            }
            com.alimm.tanx.core.utils.LogUtils.d("startTimer", "倒计时resume()");
            this.mCountDownTimer.resume();
        }
    }

    private void timerCancel(boolean z) {
        try {
            com.alimm.tanx.core.utils.LogUtils.e("RewardPortraitActivity", "adCloseTimerCancel");
            if (!z) {
                com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
                if (tanxCountDownTimer != null) {
                    tanxCountDownTimer.pause();
                    return;
                }
                return;
            }
            com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer2 = this.mCountDownTimer;
            if (tanxCountDownTimer2 != null) {
                tanxCountDownTimer2.cancel();
                this.mCountDownTimer = null;
            }
            this.startTimerSwitch = false;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("timerCancel", e);
        }
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.alimm.tanx.core.R.id.ll_reward_video_feed_back) {
            com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog feedBackDialog = new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog(this, com.alimm.tanx.core.R.style.CommonDialog, this.mTanxAd);
            this.feedBackDialog = feedBackDialog;
            feedBackDialog.show();
            com.alimm.tanx.core.ut.impl.TanxRewardUt.utFeedbackPopImp(this.tanxRewardVideoExpressAd);
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
        } else if (id == com.alimm.tanx.core.R.id.ll_reward_video_ad_count_down) {
            showExitRetentionDialog();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.alimm.tanx.core.R.layout.activity_reward_portrait);
        if (!getIntentData()) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "getIntentData数据有问题。");
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
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do(this.reqID);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxc_newVar = this.tanxRewardVideoExpressAd;
            if (tanxc_newVar != null && tanxc_newVar.tanxc_for() != null) {
                this.tanxRewardVideoExpressAd.tanxc_for().onAdClose();
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_if();
            }
            timerCancel(true);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("RewardPortraitActivity", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "RewardPortraitActivity", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        return true;
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel(false);
        if (this.webViewUtil != null) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isFront = true;
        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_int();
        }
    }
}
