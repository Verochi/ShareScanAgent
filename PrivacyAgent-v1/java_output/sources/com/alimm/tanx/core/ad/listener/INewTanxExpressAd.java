package com.alimm.tanx.core.ad.listener;

/* loaded from: classes.dex */
public interface INewTanxExpressAd extends com.alimm.tanx.core.ad.ITanxAd {
    android.view.View getAdView();

    android.view.View getAdView(android.app.Activity activity);

    void refresh();
}
