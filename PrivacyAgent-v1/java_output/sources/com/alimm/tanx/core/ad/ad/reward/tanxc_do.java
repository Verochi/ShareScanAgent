package com.alimm.tanx.core.ad.ad.reward;

/* loaded from: classes.dex */
public class tanxc_do extends com.alimm.tanx.core.ad.base.tanxc_do implements com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd {
    com.alimm.tanx.core.ad.view.TanxAdView tanxc_do;
    private int tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.ad.reward.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.monitor.ITanxExposureCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposure() {
            ((com.alimm.tanx.core.ad.base.tanxc_do) com.alimm.tanx.core.ad.ad.reward.tanxc_do.this).isReadyExposure = true;
            com.alimm.tanx.core.ad.ad.reward.tanxc_do.this.doImpExposure();
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposureTime(long j) {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void onMonitor(java.util.Map<java.lang.String, java.lang.Object> map) {
        }
    }

    public tanxc_do(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.lang.String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
        this.tanxc_if = 0;
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd
    public void bindRewardVideoAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.listener.ITanxInteractionListener iTanxInteractionListener) {
        java.lang.String str;
        com.alimm.tanx.core.ut.impl.TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, "bindRewardVideoAdView", com.alimm.tanx.core.ut.AdUtConstants.INTO_METHOD);
        this.tanxc_do = tanxAdView;
        this.tanxInteractionListener = iTanxInteractionListener;
        if (tanxAdView != null) {
            try {
                str = getBidInfo().getTemplateConf().getPidStyleId();
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(e);
                str = "";
            }
            tanxAdView.setAdMonitor(new com.alimm.tanx.core.ad.monitor.tanxc_int(tanxAdView, new com.alimm.tanx.core.ad.ad.reward.tanxc_do.AnonymousClass1(), this.adSlot.getAdType(), str));
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd
    public void click(java.lang.String str, java.lang.String str2) {
        tanxc_do(this.tanxc_do.getContext(), str, str2);
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd
    public void clickUpload() {
        com.alimm.tanx.core.ad.event.track.expose.ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), com.tanx.exposer.achieve.AdMonitorType.CLICK, getMonitorList(com.anythink.expressad.foundation.d.c.ca), this.clickExposeCallback);
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        super.destroy();
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do
    public com.alimm.tanx.core.ut.AdUtConstants getAdClickUtKey() {
        return com.alimm.tanx.core.ut.AdUtConstants.REWARD_VIDEO_NAVIGATE;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public com.alimm.tanx.core.ad.bean.BidInfo getBidInfo() {
        return super.getBidInfo().removeSensitiveData();
    }

    public void tanxc_do(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            this.tanxc_if = 1;
            this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdClickUtKey(), str, str2);
            this.adClickInfo.setUtArgs(new java.util.HashMap());
            com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(context, this.adClickInfo, true);
            com.alimm.tanx.core.ad.listener.ITanxInteractionListener iTanxInteractionListener = this.tanxInteractionListener;
            if (iTanxInteractionListener != null) {
                iTanxInteractionListener.onAdClicked(this.tanxc_do, this);
            }
            clickUpload();
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "TanxRewardVideoAd", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }
}
