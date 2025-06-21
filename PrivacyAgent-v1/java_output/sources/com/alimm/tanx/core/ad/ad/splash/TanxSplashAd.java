package com.alimm.tanx.core.ad.ad.splash;

/* loaded from: classes.dex */
public class TanxSplashAd extends com.alimm.tanx.core.ad.base.tanxc_do implements com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd, com.alimm.tanx.core.utils.NotConfused {
    private int closeType;
    public int fromType;

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.monitor.ITanxExposureCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposure() {
            ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this).isReadyExposure = true;
            com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this.doImpExposure();
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposureTime(long j) {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void onMonitor(java.util.Map<java.lang.String, java.lang.Object> map) {
            com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot = ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this).adSlot;
            java.lang.String str = ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this).reqId;
            java.lang.String templateId = ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this).bidInfo.getTemplateId();
            java.lang.String creativeId = ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this).bidInfo.getCreativeId();
            com.alimm.tanx.core.ad.ad.splash.TanxSplashAd tanxSplashAd = com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this;
            com.alimm.tanx.core.ut.impl.TanxMonitorUt.sendSplashMonitor(tanxAdSlot, str, templateId, creativeId, tanxSplashAd.fromType, tanxSplashAd.closeType, map, ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this).bidInfo.getSessionId());
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd$2, reason: invalid class name */
    public class AnonymousClass2 extends com.alimm.tanx.core.ad.listener.ViewClickListener {
        final /* synthetic */ com.alimm.tanx.core.ad.view.TanxAdView val$adView;

        public AnonymousClass2(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView) {
            this.val$adView = tanxAdView;
        }

        @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
        public void viewClick(android.view.View view) {
            com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this.click(this.val$adView, null, null);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd$3, reason: invalid class name */
    public class AnonymousClass3 extends com.alimm.tanx.core.ad.listener.ViewClickListener {
        final /* synthetic */ com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener val$iTanxSplashInteractionListener;

        public AnonymousClass3(com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener iTanxSplashInteractionListener) {
            this.val$iTanxSplashInteractionListener = iTanxSplashInteractionListener;
        }

        @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
        public void viewClick(android.view.View view) {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener iTanxSplashInteractionListener = this.val$iTanxSplashInteractionListener;
            if (iTanxSplashInteractionListener != null) {
                iTanxSplashInteractionListener.onAdClose();
            }
            com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this.closeType = 2;
            com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload interactionUpload = com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
            java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.ITrackItem> eventTrack = com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this.getBidInfo().getMonitorBean().getEventTrack();
            com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance();
            interactionUpload.uploadInteraction(eventTrack, 3);
            com.alimm.tanx.core.ad.ad.splash.TanxSplashAd tanxSplashAd = com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.this;
            com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashViewClose(tanxSplashAd, tanxSplashAd.fromType);
        }
    }

    public TanxSplashAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, int i, java.lang.String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
        this.closeType = 0;
        this.fromType = i;
    }

    @Override // com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd
    public void bindSplashAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, android.view.View view, android.view.View view2, com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener iTanxSplashInteractionListener) {
        com.alimm.tanx.core.ut.impl.TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, "bindSplashAdView", com.alimm.tanx.core.ut.AdUtConstants.INTO_METHOD);
        this.tanxInteractionListener = iTanxSplashInteractionListener;
        if (tanxAdView != null) {
            tanxAdView.setAdMonitor(new com.alimm.tanx.core.ad.monitor.tanxc_new(tanxAdView, new com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.AnonymousClass1()));
        }
        if (view != null) {
            view.setOnClickListener(new com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.AnonymousClass2(tanxAdView));
        }
        if (view2 != null) {
            view2.setOnClickListener(new com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.AnonymousClass3(iTanxSplashInteractionListener));
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd
    public void click(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.lang.String str, java.lang.String str2) {
        if (tanxAdView != null) {
            navigateAndUt(tanxAdView, tanxAdView.getContext(), false, str, str2);
        } else {
            com.alimm.tanx.core.utils.LogUtils.e("TanxSplashAd", "adView点击时为空");
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd
    public void clickUpload() {
        com.alimm.tanx.core.ad.event.track.expose.ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), com.tanx.exposer.achieve.AdMonitorType.CLICK, getMonitorList(com.anythink.expressad.foundation.d.c.ca), this.clickExposeCallback);
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        super.destroy();
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do
    public com.alimm.tanx.core.ut.AdUtConstants getAdClickUtKey() {
        return com.alimm.tanx.core.ut.AdUtConstants.SCREEN_VIEW_CLICK;
    }

    public com.alimm.tanx.core.ut.AdUtConstants getAdShakeUtKey() {
        return com.alimm.tanx.core.ut.AdUtConstants.SHAKE_NAVIGATE;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public com.alimm.tanx.core.ad.bean.BidInfo getBidInfo() {
        if (super.getBidInfo() != null) {
            return super.getBidInfo().removeSensitiveData();
        }
        return null;
    }

    public void navigateAndUt(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, android.content.Context context, boolean z, java.lang.String str, java.lang.String str2) {
        com.alimm.tanx.core.ad.listener.ITanxInteractionListener iTanxInteractionListener;
        try {
            if (this.adClickInfo == null) {
                if (z) {
                    this.closeType = 3;
                    this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdShakeUtKey(), str, str2);
                } else {
                    this.closeType = 1;
                    this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdClickUtKey(), str, str2);
                }
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.alimm.tanx.core.ut.impl.TanxSplashUt.FROM_TYPE, java.lang.String.valueOf(this.fromType));
            this.adClickInfo.setUtArgs(hashMap);
            com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(context, this.adClickInfo, true);
            if (!z && (iTanxInteractionListener = this.tanxInteractionListener) != null) {
                iTanxInteractionListener.onAdClicked(tanxAdView, this);
            }
            clickUpload();
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "TanxSplashAd", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }
}
