package com.alimm.tanx.core.ad.listener;

/* loaded from: classes.dex */
public interface ITanxInteractionListener<T extends com.alimm.tanx.core.ad.ITanxAd> {
    void onAdClicked(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, T t);

    void onAdShow(T t);
}
