package com.alimm.tanx.core.ad.ad.template.rendering.splash;

/* loaded from: classes.dex */
public class tanxc_if<T extends com.alimm.tanx.core.ad.ITanxAd> implements com.alimm.tanx.core.ad.ITanxAd {
    protected T tanxc_for;

    public tanxc_if(T t) {
        this.tanxc_for = t;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void bindAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.util.List<android.view.View> list) {
        this.tanxc_for.bindAdView(tanxAdView, list);
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void bindAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.util.List<android.view.View> list, com.alimm.tanx.core.ad.listener.ITanxInteractionListener iTanxInteractionListener) {
        this.tanxc_for.bindAdView(tanxAdView, list, iTanxInteractionListener);
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public com.alimm.tanx.core.request.TanxAdSlot getAdSlot() {
        return this.tanxc_for.getAdSlot();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public int getAdType() {
        return com.alimm.tanx.core.utils.tanxc_if.tanxc_do(getBidInfo());
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public com.alimm.tanx.core.ad.bean.BidInfo getBidInfo() {
        return this.tanxc_for.getBidInfo();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAdBidding
    public com.alimm.tanx.core.ad.bean.TanxBiddingInfo getBiddingInfo() {
        return this.tanxc_for.getBiddingInfo();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public java.lang.String getRequestId() {
        return this.tanxc_for.getRequestId();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public java.lang.String getScene() {
        return "";
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void onResourceLoadSuccess() {
        this.tanxc_for.onResourceLoadSuccess();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAdBidding
    public void setBiddingResult(com.alimm.tanx.core.ad.bean.TanxBiddingInfo tanxBiddingInfo) {
        this.tanxc_for.setBiddingResult(tanxBiddingInfo);
    }
}
