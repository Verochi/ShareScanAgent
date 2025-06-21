package com.alimm.tanx.core.ad.ad.template.rendering.feed;

/* loaded from: classes.dex */
public interface ITanxFeedExpressAd extends com.alimm.tanx.core.ad.listener.INewTanxExpressAd {

    public interface OnFeedAdListener {
        void onAdClose(com.alimm.tanx.core.ad.ITanxAd iTanxAd);

        void onAdShow(com.alimm.tanx.core.ad.ITanxAd iTanxAd);

        void onClick(com.alimm.tanx.core.ad.ITanxAd iTanxAd);

        void onError(java.lang.String str);
    }

    void setOnFeedAdListener(com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener);
}
