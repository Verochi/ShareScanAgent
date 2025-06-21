package com.alimm.tanx.core.ad.ad.template.rendering.splash;

/* loaded from: classes.dex */
public interface IRenderCallback {
    void onAdClicked(boolean z, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, long j, android.content.Context context, boolean z2, int i);

    void onAdClosed(boolean z, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, long j);

    void onAdFinished(boolean z, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, long j);

    void onAdShowError(int i);

    void onAdShowException(boolean z, java.lang.String str);

    void onAdStarted(boolean z, com.alimm.tanx.core.ad.bean.BidInfo bidInfo);

    void requestCloseAd(boolean z, int i);
}
