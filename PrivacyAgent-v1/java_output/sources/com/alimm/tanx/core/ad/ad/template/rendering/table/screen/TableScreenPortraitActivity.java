package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

/* loaded from: classes29.dex */
public class TableScreenPortraitActivity extends android.app.Activity implements com.alimm.tanx.core.utils.NotConfused {
    private android.widget.Button btnForceClose;
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if errorPopupWindow;
    private android.widget.LinearLayout flWeb;
    private android.widget.ImageView ivAdLogo;
    private android.widget.ImageView ivForceClose;
    private android.widget.ImageView ivVoice;
    private android.widget.LinearLayout llRewardVideoPlay;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.TanxRewardAdView mAdView;
    private com.alimm.tanx.core.ad.bean.BidInfo mBidInfo;
    private com.alimm.tanx.core.utils.TanxCountDownTimer mCountDownTimer;
    public long mShakeStartTime;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView mShakeView;
    private com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd mTanxAd;
    private android.view.ViewStub operationButton;
    private java.lang.String reqID;
    private android.widget.RelativeLayout rlShake;
    private com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_if tanxTableScreenExpressAd;
    private com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil webViewUtil;
    private final java.lang.String TAG = "RewardPortraitActivity";
    private volatile boolean startTimerSwitch = false;
    private volatile boolean isFront = false;
    private final boolean webCountDownOver = false;
    private long adStartTime = 0;
    private long nowExposureTime = 0;
    private volatile boolean isH5Ut = false;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.TableScreenInterface {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00221 implements java.lang.Runnable {
            public RunnableC00221() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.initShake();
                if (com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.errorPopupWindow != null && com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                    com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.errorPopupWindow.tanxc_if();
                }
                com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.ivForceClose.setVisibility(8);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adClose() {
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.adCloseUpload();
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.finish();
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adSkip(boolean z) {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void h5NotifyDrawSuccess() {
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.ivForceClose.post(new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.AnonymousClass1.RunnableC00221());
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.adStartTime = java.lang.System.currentTimeMillis();
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webDrawStatus(boolean z) {
            if (z) {
                com.alimm.tanx.core.utils.LogUtils.d("utLog", "utViewDraw");
                com.alimm.tanx.core.ut.impl.TanxTableScreenUt.utViewDraw(com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.mTanxAd, 1);
                return;
            }
            com.alimm.tanx.core.ut.impl.TanxTableScreenUt.utViewDraw(com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.mTanxAd, 0);
            if (!com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.isH5Ut) {
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utErrorCode(com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.mTanxAd, com.alimm.tanx.core.ut.UtErrorCode.CRASH_H5_ERROR);
                com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.isH5Ut = true;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.showErrorDialog();
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webError(int i, java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.e("RewardPortraitActivity", "webError: cmd :" + i + " msg:" + str);
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.showErrorDialog();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.listener.ITanxInteractionListener<com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd> {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public /* synthetic */ void onAdClicked(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd iTanxTableScreenAd) {
            tanxc_do();
        }

        public void tanxc_do() {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "onAdClicked");
            if (com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.mTanxAd == null || com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.mTanxAd.getAdSlot() == null || !com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.mTanxAd.getAdSlot().isClickAdClose()) {
                return;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.finish();
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void onAdShow(com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd iTanxTableScreenAd) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "onAdShow");
            if (com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.tanxTableScreenExpressAd == null || com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.tanxTableScreenExpressAd.tanxc_for() == null) {
                return;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.tanxTableScreenExpressAd.tanxc_for().onAdShow(iTanxTableScreenAd);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {

        /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity$3$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.errorPopupWindow.tanxc_if();
                com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.finish();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.errorPopupWindow.tanxc_do(com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.mAdView, new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.AnonymousClass3.AnonymousClass1());
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
        public void destroy(java.lang.String str) {
            com.alimm.tanx.core.ut.impl.TanxCommonUt.utShakeDestroy(com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this.mTanxAd, str);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
        public void onShake() {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "tableShowNativeShakeView 互动成功摇一摇跳转");
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity tableScreenPortraitActivity = com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.this;
            tableScreenPortraitActivity.mShakeView.getClass();
            tableScreenPortraitActivity.onGestureInteractionEnd(true, 1, true);
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
                com.alimm.tanx.core.utils.LogUtils.d("adCloseStartTimer", "不满足启动条件 webCountDownOverfalse");
                return;
            }
            com.alimm.tanx.core.utils.LogUtils.d("adCloseStartTimer", "return");
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("adCloseStartTimer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adCloseUpload() {
        com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd iTanxTableScreenAd = this.mTanxAd;
        if (iTanxTableScreenAd == null || iTanxTableScreenAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getEventTrack() == null) {
            return;
        }
        com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload interactionUpload = com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
        java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> eventTrack = this.mTanxAd.getBidInfo().getEventTrack();
        com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
        interactionUpload.uploadInteraction(eventTrack, 3);
    }

    private void adCloseUtAndUpload() {
        adCloseUpload();
    }

    private void addInteractionView(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        this.mShakeStartTime = android.os.SystemClock.elapsedRealtime();
        showNativeShakeView(viewGroup);
        addShakeViewUt(this.mBidInfo, "table_add_interaction_view", null);
    }

    public static void addShakeViewUt(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        com.alimm.tanx.core.ut.impl.TanxBaseUt.shake(str, bidInfo, null);
    }

    private void bindMonitor() {
        this.mTanxAd.bindTableScreenAdView(this.mAdView, new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.AnonymousClass2());
    }

    private boolean getIntentData() {
        try {
            java.lang.String stringExtra = getIntent().getStringExtra("REQ_ID");
            this.reqID = stringExtra;
            if (android.text.TextUtils.isEmpty(stringExtra)) {
                return false;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_if tanxc_ifVar = (com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_if) com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do.get(this.reqID);
            this.tanxTableScreenExpressAd = tanxc_ifVar;
            if (tanxc_ifVar == null) {
                return false;
            }
            this.mTanxAd = tanxc_ifVar.tanxc_do;
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
        this.mAdView = (com.alimm.tanx.core.ad.ad.template.rendering.reward.TanxRewardAdView) findViewById(com.alimm.tanx.core.R.id.root_view);
        this.flWeb = (android.widget.LinearLayout) findViewById(com.alimm.tanx.core.R.id.fl_reward_video_portrait_wb);
        this.rlShake = (android.widget.RelativeLayout) findViewById(com.alimm.tanx.core.R.id.rl_shake);
        this.btnForceClose = (android.widget.Button) findViewById(com.alimm.tanx.core.R.id.btn_force_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initShake() {
        com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd iTanxTableScreenAd = this.mTanxAd;
        if (iTanxTableScreenAd != null) {
            this.mBidInfo = iTanxTableScreenAd.getBidInfo();
        }
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = this.mBidInfo;
        if (bidInfo == null || !bidInfo.getInteractType2Shake()) {
            return;
        }
        addInteractionView(this.rlShake);
    }

    private void initView() {
        initWeb();
    }

    private void initWeb() {
        com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil tableScreenWebViewUtil = new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil();
        this.webViewUtil = tableScreenWebViewUtil;
        tableScreenWebViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxTableScreenExpressAd, new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$timerCancel$6() {
        this.btnForceClose.setVisibility(8);
    }

    private void rewardArrived(int i, int i2) {
    }

    private void sendInteractionViewShowExpose() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("table_add_interaction_view_time", java.lang.String.valueOf(android.os.SystemClock.elapsedRealtime() - this.mShakeStartTime));
        com.alimm.tanx.core.ut.impl.TanxBaseUt.shake("add_interaction_view_time", null, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog() {
        if (this.errorPopupWindow == null) {
            this.errorPopupWindow = new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if(this);
        }
        this.flWeb.postDelayed(new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.AnonymousClass3(), 200L);
    }

    private void showNativeShakeView(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "tableShowNativeShakeView");
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = this.mBidInfo;
        com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean build = (bidInfo == null || bidInfo.getTemplateConf() == null) ? null : new com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean().build(this.mBidInfo.getTemplateConf());
        if (this.mShakeView == null) {
            this.mShakeView = new com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView(this, "摇一摇跳转详情", build);
        }
        this.rlShake.setVisibility(0);
        this.mShakeView.setClickable(false);
        this.mShakeView.setOnTouchListener(null);
        this.mShakeView.load(new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.AnonymousClass4(), false);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, com.alimm.tanx.core.utils.DimenUtil.dp2px(this, 280.0f));
        layoutParams.gravity = 80;
        viewGroup.addView(this.mShakeView, layoutParams);
        sendInteractionViewShowExpose();
    }

    private void timerCancel() {
        try {
            com.alimm.tanx.core.utils.LogUtils.e("RewardPortraitActivity", "adCloseTimerCancel");
            com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.mCountDownTimer = null;
            }
            this.btnForceClose.post(new defpackage.d03(this));
            this.startTimerSwitch = false;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("timerCancel", e);
        }
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.alimm.tanx.core.R.id.ll_reward_video_feed_back) {
            new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog(this, com.alimm.tanx.core.R.style.CommonDialog, this.mTanxAd).show();
        } else if (id == com.alimm.tanx.core.R.id.ll_reward_video_play) {
            this.llRewardVideoPlay.setVisibility(8);
        } else if (id == com.alimm.tanx.core.R.id.iv_close) {
            finish();
        } else if (id == com.alimm.tanx.core.R.id.btn_pre_load_h5) {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer.resume();
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
        setContentView(com.alimm.tanx.core.R.layout.activity_table_screen_portrait);
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
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_if tanxc_ifVar = this.tanxTableScreenExpressAd;
            if (tanxc_ifVar != null && tanxc_ifVar.tanxc_for() != null) {
                this.tanxTableScreenExpressAd.tanxc_for().onAdClose();
            }
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil tableScreenWebViewUtil = this.webViewUtil;
            if (tableScreenWebViewUtil != null) {
                tableScreenWebViewUtil.tanxc_if();
            }
            timerCancel();
            long j = this.nowExposureTime;
            if (j > 0) {
                com.alimm.tanx.core.ut.impl.TanxTableScreenUt.utRewardExposureTime(this.mTanxAd, j);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("RewardPortraitActivity", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "RewardPortraitActivity", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    public void onGestureInteractionEnd(boolean z, int i, boolean z2) {
        com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd iTanxTableScreenAd;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil tableScreenWebViewUtil = this.webViewUtil;
        long j = currentTimeMillis - tableScreenWebViewUtil.tanxc_do;
        tableScreenWebViewUtil.getClass();
        if (j < 500) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "mClickedOnce = true");
            return;
        }
        this.webViewUtil.tanxc_do = java.lang.System.currentTimeMillis();
        com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_if tanxc_ifVar = this.tanxTableScreenExpressAd;
        if (tanxc_ifVar == null || (iTanxTableScreenAd = tanxc_ifVar.tanxc_do) == null) {
            return;
        }
        iTanxTableScreenAd.shake();
        if (this.tanxTableScreenExpressAd.tanxc_for() != null) {
            this.tanxTableScreenExpressAd.tanxc_for().onAdShake();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        android.widget.Button button;
        if (i != 4 || (button = this.btnForceClose) == null || button.getVisibility() != 0) {
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
        com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel();
        if (this.webViewUtil != null) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
        if (this.adStartTime > 0) {
            this.nowExposureTime += java.lang.System.currentTimeMillis() - this.adStartTime;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isFront = true;
        com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil tableScreenWebViewUtil = this.webViewUtil;
        if (tableScreenWebViewUtil != null) {
            tableScreenWebViewUtil.tanxc_int();
        }
        adCloseStartTimer();
        if (this.adStartTime > 0) {
            this.adStartTime = java.lang.System.currentTimeMillis();
        }
    }
}
