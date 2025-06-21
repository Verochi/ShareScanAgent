package com.alimm.tanx.core.ad.loader;

/* loaded from: classes.dex */
public class NewTanxAdLoader extends com.alimm.tanx.core.ad.loader.TanxRequestLoader implements com.alimm.tanx.core.ad.listener.ITanxAdLoader {
    protected android.content.Context mContext;
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_do mFeedPresenter;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int mRewardVideoPresenter;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int mSplashAdPresenter;
    private com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_do mTableScreenPresenter;
    long splashTimeConsuming = 0;

    /* renamed from: com.alimm.tanx.core.ad.loader.NewTanxAdLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener {
        final /* synthetic */ com.alimm.tanx.core.request.TanxAdSlot val$adSlot;
        final /* synthetic */ com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener val$feedAdListener;
        final /* synthetic */ long val$sTime;

        public AnonymousClass1(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, long j, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener) {
            this.val$adSlot = tanxAdSlot;
            this.val$sTime = j;
            this.val$feedAdListener = onAdLoadListener;
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onError(com.alimm.tanx.core.request.TanxError tanxError) {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_FEED, "error", java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = this.val$feedAdListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onError(tanxError);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
        public void onLoaded(java.util.List list) {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_FEED, "success", java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = this.val$feedAdListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onLoaded(list);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onTimeOut() {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_FEED, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.CALLBACK_TIMEOUT, java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = this.val$feedAdListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onTimeOut();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.loader.NewTanxAdLoader$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd> {
        final /* synthetic */ com.alimm.tanx.core.request.TanxAdSlot val$adSlot;
        final /* synthetic */ long val$sTime;
        final /* synthetic */ com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener val$splashAdListener;

        public AnonymousClass2(long j, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener) {
            this.val$sTime = j;
            this.val$adSlot = tanxAdSlot;
            this.val$splashAdListener = onAdLoadListener;
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onError(com.alimm.tanx.core.request.TanxError tanxError) {
            com.alimm.tanx.core.ad.loader.NewTanxAdLoader.this.splashTimeConsuming = java.lang.System.currentTimeMillis() - this.val$sTime;
            com.alimm.tanx.core.utils.LogUtils.d("splashTimeConsuming", com.alimm.tanx.core.ad.loader.NewTanxAdLoader.this.splashTimeConsuming + "");
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_SPLASH, "error", java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = this.val$splashAdListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onError(tanxError);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
        public void onLoaded(java.util.List<com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd> list) {
            com.alimm.tanx.core.ad.loader.NewTanxAdLoader.this.splashTimeConsuming = java.lang.System.currentTimeMillis() - this.val$sTime;
            com.alimm.tanx.core.utils.LogUtils.d("splashTimeConsuming", com.alimm.tanx.core.ad.loader.NewTanxAdLoader.this.splashTimeConsuming + "");
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_SPLASH, "success", java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = this.val$splashAdListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onLoaded(list);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onTimeOut() {
            com.alimm.tanx.core.ad.loader.NewTanxAdLoader.this.splashTimeConsuming = java.lang.System.currentTimeMillis() - this.val$sTime;
            com.alimm.tanx.core.utils.LogUtils.d("splashTimeConsuming", com.alimm.tanx.core.ad.loader.NewTanxAdLoader.this.splashTimeConsuming + "");
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_SPLASH, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.CALLBACK_TIMEOUT, java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = this.val$splashAdListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onTimeOut();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.loader.NewTanxAdLoader$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> {
        final /* synthetic */ com.alimm.tanx.core.request.TanxAdSlot val$adSlot;
        final /* synthetic */ com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener val$onAdLoadListener;
        final /* synthetic */ long val$sTime;

        public AnonymousClass3(com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, long j) {
            this.val$onAdLoadListener = onAdLoadListener;
            this.val$adSlot = tanxAdSlot;
            this.val$sTime = j;
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onError(com.alimm.tanx.core.request.TanxError tanxError) {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_TABLE_SCREEN, "error", java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = this.val$onAdLoadListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onError(tanxError);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
        public void onLoaded(java.util.List<com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> list) {
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = this.val$onAdLoadListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onLoaded(list);
            }
            com.alimm.tanx.core.ad.loader.NewTanxAdLoader.this.mTableScreenPresenter.tanxc_do(list, this.val$onAdLoadListener);
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_TABLE_SCREEN, "success", java.lang.System.currentTimeMillis() - this.val$sTime);
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onTimeOut() {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_TABLE_SCREEN, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.CALLBACK_TIMEOUT, java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener onAdLoadListener = this.val$onAdLoadListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onTimeOut();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.loader.NewTanxAdLoader$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> {
        final /* synthetic */ com.alimm.tanx.core.request.TanxAdSlot val$adSlot;
        final /* synthetic */ com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener val$rewardAdListener;
        final /* synthetic */ long val$sTime;

        public AnonymousClass4(com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, long j) {
            this.val$rewardAdListener = onRewardAdLoadListener;
            this.val$adSlot = tanxAdSlot;
            this.val$sTime = j;
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onError(com.alimm.tanx.core.request.TanxError tanxError) {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_REWARD, "error", java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener = this.val$rewardAdListener;
            if (onRewardAdLoadListener != null) {
                onRewardAdLoadListener.onError(tanxError);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
        public void onLoaded(java.util.List<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> list) {
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener = this.val$rewardAdListener;
            if (onRewardAdLoadListener != null) {
                onRewardAdLoadListener.onLoaded(list);
            }
            com.alimm.tanx.core.ad.loader.NewTanxAdLoader.this.mRewardVideoPresenter.tanxc_do(list, this.val$rewardAdListener);
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_REWARD, "success", java.lang.System.currentTimeMillis() - this.val$sTime);
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onTimeOut() {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.val$adSlot, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_REWARD, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.CALLBACK_TIMEOUT, java.lang.System.currentTimeMillis() - this.val$sTime);
            com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener = this.val$rewardAdListener;
            if (onRewardAdLoadListener != null) {
                onRewardAdLoadListener.onTimeOut();
            }
        }
    }

    public NewTanxAdLoader(android.content.Context context) {
        this.mContext = context;
    }

    private void rewardAdExecute(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener, long j) {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (!com.alimm.tanx.core.orange.OrangeManager.getInstance().getAdSwitch(com.alimm.tanx.core.orange.OrangeSwitchConstants.AD_TEMPLATE_REWARD)) {
                onRewardAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("", com.alimm.tanx.core.request.TanxError.ERROR_AD_SWITCH_CLOSE));
                return;
            }
            tanxAdSlot.setAdCount(1);
            if (this.mRewardVideoPresenter == null) {
                this.mRewardVideoPresenter = new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int(this.mContext, new com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel());
            }
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_REWARD);
            this.mRewardVideoPresenter.request(tanxAdSlot, new com.alimm.tanx.core.ad.loader.NewTanxAdLoader.AnonymousClass4(onRewardAdLoadListener, tanxAdSlot, currentTimeMillis), j);
        } catch (java.lang.Exception e) {
            if (onRewardAdLoadListener != null) {
                onRewardAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("loadRewardAd异常:" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e)));
            }
            com.alimm.tanx.core.utils.LogUtils.e("loadRewardVideoAd", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "loadRewardAd", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    private void tableScreenAdAdExecute(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> onAdLoadListener, long j) {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (!com.alimm.tanx.core.orange.OrangeManager.getInstance().getAdSwitch(com.alimm.tanx.core.orange.OrangeSwitchConstants.AD_TEMPLATE_TABLE_SCREEN)) {
                onAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("", com.alimm.tanx.core.request.TanxError.ERROR_AD_SWITCH_CLOSE));
                return;
            }
            tanxAdSlot.setAdCount(1);
            if (this.mTableScreenPresenter == null) {
                this.mTableScreenPresenter = new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_do(this.mContext, new com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenAdModel());
            }
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_TABLE_SCREEN);
            this.mTableScreenPresenter.request(tanxAdSlot, new com.alimm.tanx.core.ad.loader.NewTanxAdLoader.AnonymousClass3(onAdLoadListener, tanxAdSlot, currentTimeMillis), j);
        } catch (java.lang.Exception e) {
            if (onAdLoadListener != null) {
                onAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("tableScreenAdAdExecute异常:" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e)));
            }
            com.alimm.tanx.core.utils.LogUtils.e("tableScreenAdAdExecute", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "tableScreenAdAdExecute", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void destroy() {
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadFeedAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd> onAdLoadListener) {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (!com.alimm.tanx.core.orange.OrangeManager.getInstance().getAdSwitch(com.alimm.tanx.core.orange.OrangeSwitchConstants.AD_TEMPLATE_FEED)) {
                onAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("", com.alimm.tanx.core.request.TanxError.ERROR_AD_SWITCH_CLOSE));
                return;
            }
            tanxAdSlot.addTemplateAdSlot(2);
            if (this.mFeedPresenter == null) {
                this.mFeedPresenter = new com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_do(this.mContext, new com.alimm.tanx.core.ad.ad.feed.FeedAdModel());
            }
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_FEED);
            this.mFeedPresenter.request(tanxAdSlot, new com.alimm.tanx.core.ad.loader.NewTanxAdLoader.AnonymousClass1(tanxAdSlot, currentTimeMillis, onAdLoadListener));
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("loadFeedAd", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "loadFeedAd", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
            if (onAdLoadListener != null) {
                onAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("feedAdListener异常:" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e)));
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadRewardAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener) {
        loadRewardAd(tanxAdSlot, onRewardAdLoadListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadRewardAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener, long j) {
        tanxAdSlot.addTemplateAdSlot(4);
        rewardAdExecute(tanxAdSlot, onRewardAdLoadListener, j);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadRewardVideoAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener) {
        loadRewardVideoAd(tanxAdSlot, onRewardAdLoadListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadRewardVideoAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener, long j) {
        tanxAdSlot.addTemplateAdSlot(3);
        rewardAdExecute(tanxAdSlot, onRewardAdLoadListener, j);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadSplashAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd> onAdLoadListener) {
        loadSplashAd(tanxAdSlot, onAdLoadListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadSplashAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd> onAdLoadListener, long j) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            this.splashTimeConsuming = 0L;
            if (!com.alimm.tanx.core.orange.OrangeManager.getInstance().getAdSwitch(com.alimm.tanx.core.orange.OrangeSwitchConstants.AD_TEMPLATE_SPLASH)) {
                onAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("", com.alimm.tanx.core.request.TanxError.ERROR_AD_SWITCH_CLOSE));
                return;
            }
            tanxAdSlot.addTemplateAdSlot(1);
            if (this.mSplashAdPresenter == null) {
                this.mSplashAdPresenter = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int(this.mContext, new com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel());
            }
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), com.alimm.tanx.core.ut.impl.TanxInterfaceUt.TEMPLATE_SPLASH);
            this.mSplashAdPresenter.tanxc_do(tanxAdSlot, new com.alimm.tanx.core.ad.loader.NewTanxAdLoader.AnonymousClass2(currentTimeMillis, tanxAdSlot, onAdLoadListener), j);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("loadSplashAd", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "loadSplashAd", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
            if (onAdLoadListener != null) {
                onAdLoadListener.onError(new com.alimm.tanx.core.request.TanxError("loadSplashAd异常:" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e)));
                this.splashTimeConsuming = java.lang.System.currentTimeMillis() - currentTimeMillis;
                com.alimm.tanx.core.utils.LogUtils.d("splashTimeConsuming", this.splashTimeConsuming + "");
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadTableScreenAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> onAdLoadListener) {
        loadTableScreenAd(tanxAdSlot, onAdLoadListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadTableScreenAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> onAdLoadListener, long j) {
        tanxAdSlot.addTemplateAdSlot(5);
        tableScreenAdAdExecute(tanxAdSlot, onAdLoadListener, j);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void preloadSplashAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot) {
        try {
            if (!com.alimm.tanx.core.orange.OrangeManager.getInstance().getAdSwitch(com.alimm.tanx.core.orange.OrangeSwitchConstants.AD_TEMPLATE_SPLASH)) {
                com.alimm.tanx.core.utils.LogUtils.e("preloadSplashAd", com.alimm.tanx.core.request.TanxError.ERROR_AD_SWITCH_CLOSE);
                return;
            }
            tanxAdSlot.addTemplateAdSlot(1);
            if (this.mSplashAdPresenter == null) {
                this.mSplashAdPresenter = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int(this.mContext, new com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel());
            }
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), com.alimm.tanx.core.ut.impl.TanxInterfaceUt.SPLASH_PRELOAD);
            this.mSplashAdPresenter.tanxc_do(tanxAdSlot);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.alimm.tanx.core.utils.LogUtils.e("preloadSplashAd", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "preloadSplashAd", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }
}
