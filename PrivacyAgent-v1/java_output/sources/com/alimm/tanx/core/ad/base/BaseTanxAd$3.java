package com.alimm.tanx.core.ad.base;

/* loaded from: classes.dex */
public class BaseTanxAd$3 extends com.alimm.tanx.core.ad.listener.ViewClickListener {
    final /* synthetic */ com.alimm.tanx.core.ad.base.tanxc_do this$0;
    final /* synthetic */ com.alimm.tanx.core.ad.view.TanxAdView val$adView;

    public BaseTanxAd$3(com.alimm.tanx.core.ad.base.tanxc_do tanxc_doVar, com.alimm.tanx.core.ad.view.TanxAdView tanxAdView) {
        this.this$0 = tanxc_doVar;
        this.val$adView = tanxAdView;
    }

    @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
    public void viewClick(android.view.View view) {
        this.this$0.doClickExposure(this.val$adView);
    }
}
