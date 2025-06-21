package com.alimm.tanx.core.ad.base;

/* loaded from: classes.dex */
public abstract class tanxc_do implements com.alimm.tanx.core.ad.ITanxAd {
    protected com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo;
    protected com.alimm.tanx.core.request.TanxAdSlot adSlot;
    protected com.alimm.tanx.core.ad.bean.BidInfo bidInfo;
    protected com.alimm.tanx.core.ad.event.track.expose.ExposeCallback clickExposeCallback;
    private java.util.List<com.alimm.tanx.core.ad.event.track.expose.tanxc_if> clickList;
    protected boolean hasExposure;
    protected com.alimm.tanx.core.ad.event.track.expose.ExposeCallback impExposeCallback;
    private java.util.List<com.alimm.tanx.core.ad.event.track.expose.tanxc_if> impList;
    protected boolean isReadyExposure;
    protected boolean isResourceLoadSuccess;
    protected java.lang.Boolean lastIsReadyExposure = null;
    protected java.lang.Boolean lastIsResourceLoadSuccess = null;
    private com.alimm.tanx.core.ad.bean.TanxBiddingInfo mBiddingInfo;
    protected java.lang.String reqId;
    public java.lang.String scene;
    protected com.alimm.tanx.core.ad.listener.ITanxInteractionListener tanxInteractionListener;

    /* renamed from: com.alimm.tanx.core.ad.base.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.event.track.expose.ExposeCallback {
        final /* synthetic */ com.alimm.tanx.core.request.TanxAdSlot tanxc_do;
        final /* synthetic */ java.lang.String tanxc_if;

        public AnonymousClass1(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str) {
            this.tanxc_do = tanxAdSlot;
            this.tanxc_if = str;
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void onFail(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.ut.impl.TanxCommonUt.sendExposureFail(this.tanxc_do.getPid(), this.tanxc_if, com.alimm.tanx.core.ad.base.tanxc_do.this.bidInfo, str2, i, str);
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void onSucceed(int i, java.lang.String str) {
            com.alimm.tanx.core.ut.impl.TanxCommonUt.sendExposureSuc(this.tanxc_do.getPid(), this.tanxc_if, com.alimm.tanx.core.ad.base.tanxc_do.this.bidInfo, str);
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void send(java.lang.String str) {
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.base.tanxc_do$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.ad.event.track.expose.ExposeCallback {
        final /* synthetic */ com.alimm.tanx.core.request.TanxAdSlot tanxc_do;
        final /* synthetic */ java.lang.String tanxc_if;

        public AnonymousClass2(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str) {
            this.tanxc_do = tanxAdSlot;
            this.tanxc_if = str;
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void onFail(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.ut.impl.TanxCommonUt.sendClickExposureFail(this.tanxc_do.getPid(), this.tanxc_if, com.alimm.tanx.core.ad.base.tanxc_do.this.bidInfo, str2, i, str);
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void onSucceed(int i, java.lang.String str) {
            com.alimm.tanx.core.ut.impl.TanxCommonUt.sendClickExposureSuc(this.tanxc_do.getPid(), this.tanxc_if, com.alimm.tanx.core.ad.base.tanxc_do.this.bidInfo, str);
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void send(java.lang.String str) {
        }
    }

    public tanxc_do(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.lang.String str2) {
        this.isResourceLoadSuccess = true;
        this.scene = str2;
        this.adSlot = tanxAdSlot;
        this.bidInfo = bidInfo;
        this.reqId = str;
        if (tanxAdSlot.isExpressRender()) {
            this.isResourceLoadSuccess = false;
        }
        this.impExposeCallback = new com.alimm.tanx.core.ad.base.tanxc_do.AnonymousClass1(tanxAdSlot, str);
        this.clickExposeCallback = new com.alimm.tanx.core.ad.base.tanxc_do.AnonymousClass2(tanxAdSlot, str);
    }

    private void adExposeDeleteAndPreLoad() {
        if (this.adSlot != null) {
            com.alimm.tanx.core.common.tanxc_do.tanxc_do(new defpackage.ls3(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$adExposeDeleteAndPreLoad$5() {
        try {
            if (this.adSlot.getAdType() == 1 && !android.text.TextUtils.isEmpty(this.adSlot.getPid())) {
                com.alimm.tanx.core.utils.FileUtils.delete(com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getSplashAdResponseFile(com.alimm.tanx.core.TanxCoreSdk.getApplication(), this.adSlot.getPid()));
            }
            if (this.adSlot.getLoadType() != null && this.adSlot.getLoadType().equals(com.alimm.tanx.core.request.TanxAdLoadType.PRELOAD) && this.adSlot.getAdType() == 1) {
                new com.alimm.tanx.core.ad.loader.NewTanxAdLoader(com.alimm.tanx.core.TanxCoreSdk.getApplication()).preloadSplashAd(this.adSlot);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), e);
        }
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void bindAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.util.List<android.view.View> list) {
        bindAdView(tanxAdView, list, null);
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void bindAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.util.List<android.view.View> list, com.alimm.tanx.core.ad.listener.ITanxInteractionListener iTanxInteractionListener) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("bindAdView->adView:");
        java.lang.String str = com.igexin.push.core.b.m;
        sb.append(tanxAdView == null ? com.igexin.push.core.b.m : "不为空");
        sb.append("interactionListener:");
        if (iTanxInteractionListener != null) {
            str = "不为空";
        }
        sb.append(str);
        com.alimm.tanx.core.utils.LogUtils.d("bindView", sb.toString());
        if (tanxAdView != null) {
            this.tanxInteractionListener = iTanxInteractionListener;
            if (list == null || list.size() <= 0) {
                tanxAdView.setOnClickListener(new com.alimm.tanx.core.ad.base.BaseTanxAd$3(this, tanxAdView));
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOnClickListener(new com.alimm.tanx.core.ad.base.BaseTanxAd$4(this, tanxAdView));
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        this.tanxInteractionListener = null;
        this.impExposeCallback = null;
        this.clickExposeCallback = null;
    }

    public void doClickExposure(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView) {
        if (this.adClickInfo == null) {
            this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdClickUtKey());
        }
        com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(tanxAdView.getContext(), this.adClickInfo, true);
        if (this.tanxInteractionListener != null) {
            com.alimm.tanx.core.utils.LogUtils.d("TanxSDK-DoClick", "媒体侧点击回调 reqId:" + this.reqId);
            this.tanxInteractionListener.onAdClicked(tanxAdView, this);
        }
        com.alimm.tanx.core.ad.event.track.expose.ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), com.tanx.exposer.achieve.AdMonitorType.CLICK, getMonitorList(com.anythink.expressad.foundation.d.c.ca), this.clickExposeCallback);
    }

    public void doImpExposure() {
        int adType = getAdSlot().getAdType();
        com.alimm.tanx.core.utils.LogUtils.d("doImpExposure", "fromType:" + com.alimm.tanx.core.constant.TanxAdType.getAdTypeStr(adType) + " isReadyExposure:" + this.isReadyExposure + " isResourceLoadSuccess:" + this.isResourceLoadSuccess);
        if (!this.hasExposure) {
            java.lang.Boolean bool = this.lastIsReadyExposure;
            if (bool == null || this.lastIsResourceLoadSuccess == null || bool.booleanValue() != this.isReadyExposure || this.lastIsResourceLoadSuccess.booleanValue() != this.isResourceLoadSuccess) {
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("isReadyExposure", this.isReadyExposure + "");
                hashMap.put("isResourceLoadSuccess", this.isResourceLoadSuccess + "");
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, com.alimm.tanx.core.constant.TanxAdType.getAdTypeStr(adType) + " - doImpExposure", com.alimm.tanx.core.ut.AdUtConstants.INTO_METHOD, hashMap);
                this.lastIsReadyExposure = java.lang.Boolean.valueOf(this.isReadyExposure);
                this.lastIsResourceLoadSuccess = java.lang.Boolean.valueOf(this.isResourceLoadSuccess);
            } else {
                com.alimm.tanx.core.utils.LogUtils.d("doImpExposure", "防止重复埋点");
            }
        }
        if (this.isReadyExposure && this.isResourceLoadSuccess) {
            if (!this.hasExposure) {
                com.alimm.tanx.core.utils.LogUtils.d("TanxSDK-DoImpExposure", "达到曝光条件埋点..  reqId：" + getRequestId());
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendStartImp(this.adSlot, this.reqId, this.bidInfo, adType);
            }
            if (this.tanxInteractionListener != null && !this.hasExposure) {
                com.alimm.tanx.core.utils.LogUtils.d("TanxSDK-DoImpExposure", "媒体侧曝光回调  reqId：" + getRequestId());
                this.tanxInteractionListener.onAdShow(this);
                adExposeDeleteAndPreLoad();
            }
            if (this.hasExposure) {
                return;
            }
            com.alimm.tanx.core.ad.event.track.expose.ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), com.tanx.exposer.achieve.AdMonitorType.EXPOSE, getMonitorList(com.umeng.analytics.pro.ay.c), this.impExposeCallback);
            this.hasExposure = true;
        }
    }

    public abstract com.alimm.tanx.core.ut.AdUtConstants getAdClickUtKey();

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public com.alimm.tanx.core.request.TanxAdSlot getAdSlot() {
        return this.adSlot;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public int getAdType() {
        return com.alimm.tanx.core.utils.tanxc_if.tanxc_do(this.bidInfo);
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public com.alimm.tanx.core.ad.bean.BidInfo getBidInfo() {
        return this.bidInfo;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAdBidding
    public com.alimm.tanx.core.ad.bean.TanxBiddingInfo getBiddingInfo() {
        if (this.mBiddingInfo == null) {
            com.alimm.tanx.core.ad.bean.TanxBiddingInfo tanxBiddingInfo = new com.alimm.tanx.core.ad.bean.TanxBiddingInfo();
            this.mBiddingInfo = tanxBiddingInfo;
            tanxBiddingInfo.setAdPrice(this.bidInfo.getBidPrice());
        }
        return this.mBiddingInfo;
    }

    public java.util.List<com.alimm.tanx.core.ad.event.track.expose.tanxc_if> getMonitorList(java.lang.String str) {
        if (com.anythink.expressad.foundation.d.c.ca.equals(str)) {
            if (this.clickList == null) {
                this.clickList = new java.util.ArrayList();
                com.alimm.tanx.core.ad.bean.BidInfo bidInfo = this.bidInfo;
                if (bidInfo != null && bidInfo.getMonitorBean() != null && this.bidInfo.getMonitorBean().getClickTrackUrl() != null) {
                    java.util.Iterator<java.lang.String> it = this.bidInfo.getMonitorBean().getClickTrackUrl().iterator();
                    while (it.hasNext()) {
                        this.clickList.add(new com.alimm.tanx.core.ad.event.track.expose.tanxc_if(it.next(), str, false));
                    }
                }
            }
            return this.clickList;
        }
        if (!com.umeng.analytics.pro.ay.c.equals(str)) {
            return null;
        }
        if (this.impList == null) {
            this.impList = new java.util.ArrayList();
            com.alimm.tanx.core.ad.bean.BidInfo bidInfo2 = this.bidInfo;
            if (bidInfo2 != null && bidInfo2.getMonitorBean() != null && this.bidInfo.getMonitorBean().getImpTrackUrl() != null) {
                java.util.Iterator<java.lang.String> it2 = this.bidInfo.getMonitorBean().getImpTrackUrl().iterator();
                while (it2.hasNext()) {
                    this.impList.add(new com.alimm.tanx.core.ad.event.track.expose.tanxc_if(it2.next(), str, true));
                }
            }
        }
        return this.impList;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public java.lang.String getRequestId() {
        return this.reqId;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public java.lang.String getScene() {
        return this.scene;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void onResourceLoadSuccess() {
        this.isResourceLoadSuccess = true;
        doImpExposure();
    }

    public void setBidInfo(com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
        this.bidInfo = bidInfo;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAdBidding
    public void setBiddingResult(com.alimm.tanx.core.ad.bean.TanxBiddingInfo tanxBiddingInfo) {
        this.mBiddingInfo = tanxBiddingInfo;
    }
}
