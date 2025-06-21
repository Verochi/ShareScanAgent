package com.alimm.tanx.core.ad.ad.table.screen;

/* loaded from: classes.dex */
public interface ITanxTableScreenAd extends com.alimm.tanx.core.ad.ITanxAd {
    void bindTableScreenAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.listener.ITanxInteractionListener iTanxInteractionListener);

    void click(java.lang.String str, java.lang.String str2);

    void shake();
}
