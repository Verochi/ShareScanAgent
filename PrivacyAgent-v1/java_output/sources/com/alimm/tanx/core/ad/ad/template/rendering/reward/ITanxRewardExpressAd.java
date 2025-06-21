package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes.dex */
public interface ITanxRewardExpressAd extends com.alimm.tanx.core.ad.listener.INewTanxExpressAd {

    public interface OnRewardAdListener extends com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoInteractionListener {
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    void destroy();

    void setOnRewardAdListener(com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd.OnRewardAdListener onRewardAdListener);

    void showAd(android.app.Activity activity);

    void showAd(android.app.Activity activity, com.alimm.tanx.core.ad.ad.reward.model.VideoParam videoParam);

    void showAd(android.app.Activity activity, com.alimm.tanx.core.ad.ad.reward.model.VideoParam videoParam, boolean z);
}
