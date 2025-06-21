package com.anythink.core.api;

/* loaded from: classes12.dex */
public abstract class MediationBidManager {
    public static final java.lang.String NO_BID_TOKEN_ERROR = "NO_BID_TOKEN";
    protected java.lang.String mRequestUrl;

    public interface BidListener {
        void onBidFail(java.lang.String str);

        void onBidStart(com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter);

        void onBidSuccess(java.util.List<com.anythink.core.common.f.au> list);
    }

    public abstract void notifyWinnerDisplay(java.lang.String str, com.anythink.core.common.f.au auVar);

    public void setBidRequestUrl(java.lang.String str) {
        this.mRequestUrl = str;
    }

    public abstract void startBid(com.anythink.core.common.f.a aVar, com.anythink.core.api.MediationBidManager.BidListener bidListener);
}
