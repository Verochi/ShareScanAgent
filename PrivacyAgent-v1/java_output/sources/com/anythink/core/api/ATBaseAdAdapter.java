package com.anythink.core.api;

/* loaded from: classes12.dex */
public abstract class ATBaseAdAdapter extends com.anythink.core.common.b.a {
    public com.anythink.core.api.ATBiddingListener mBiddingListener;
    protected com.anythink.core.api.ATEventInterface mDownloadListener;
    protected com.anythink.core.api.ATCustomLoadListener mLoadListener;
    protected com.anythink.core.api.ATBaseAdAdapter mThirdPartyAdapter;
    protected java.lang.String mUserId = "";
    protected java.lang.String mUserData = "";
    protected java.lang.String mScenario = "";
    protected int mDismissType = 0;
    protected int mFetchAdTimeout = 10000;
    protected int mRequestNum = 1;
    protected int mMixedFormatAdType = -1;

    private void cleanLoadListener() {
        this.mBiddingListener = null;
        this.mLoadListener = null;
    }

    private void fillParams(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (getTrackingInfo() != null) {
            com.anythink.core.common.o.h.a(map, getTrackingInfo().S());
        }
    }

    private void parseGloableParams(java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map2 != null) {
            this.mUserId = map2.get("user_id") != null ? map2.get("user_id").toString() : "";
            this.mUserData = map2.get(com.anythink.core.api.ATAdConst.KEY.USER_CUSTOM_DATA) != null ? map2.get(com.anythink.core.api.ATAdConst.KEY.USER_CUSTOM_DATA).toString() : "";
        }
        if (map == null || !map.containsKey("ad_type")) {
            return;
        }
        this.mMixedFormatAdType = java.lang.Integer.parseInt(map.get("ad_type").toString());
    }

    public abstract void destory();

    public com.anythink.core.api.BaseAd getBaseAdObject(android.content.Context context) {
        return null;
    }

    public com.anythink.core.api.MediationBidManager getBidManager() {
        return null;
    }

    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onFailed(com.anythink.core.api.ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE);
        }
    }

    public final int getDismissType() {
        return this.mDismissType;
    }

    public java.lang.String getILRD() {
        return null;
    }

    public final java.lang.String getInternalNetworkName() {
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.mThirdPartyAdapter;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.getNetworkName() : getNetworkName();
    }

    public final java.lang.String getInternalNetworkPlacementId() {
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.mThirdPartyAdapter;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.getNetworkPlacementId() : getNetworkPlacementId();
    }

    public final java.lang.String getInternalNetworkSDKVersion() {
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.mThirdPartyAdapter;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.getNetworkSDKVersion() : getNetworkSDKVersion();
    }

    public com.anythink.core.api.ATInitMediation getMediationInitManager() {
        return null;
    }

    public final int getMixedFormatAdType() {
        return this.mMixedFormatAdType;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return null;
    }

    public abstract java.lang.String getNetworkName();

    public abstract java.lang.String getNetworkPlacementId();

    public abstract java.lang.String getNetworkSDKVersion();

    public final java.lang.String getUserCustomData() {
        return this.mUserData;
    }

    public final java.lang.String getUserId() {
        return this.mUserId;
    }

    public boolean initNetworkObjectByPlacementId(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        return false;
    }

    public final void internalDestory() {
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.mThirdPartyAdapter;
        if (aTBaseAdAdapter != null) {
            aTBaseAdAdapter.destory();
        }
        destory();
    }

    public void internalFormatShow(android.app.Activity activity, android.view.ViewGroup viewGroup, com.anythink.core.api.ATCommonImpressionListener aTCommonImpressionListener) {
    }

    public final boolean internalInitNetworkObjectByPlacementId(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        fillParams(map);
        parseGloableParams(map, map2);
        return initNetworkObjectByPlacementId(context, map, map2);
    }

    public final boolean internalIsAdReady() {
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.mThirdPartyAdapter;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.isAdReady() : isAdReady();
    }

    public final void internalLoad(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener) {
        this.mLoadListener = aTCustomLoadListener;
        fillParams(map);
        parseGloableParams(map, map2);
        loadCustomNetworkAd(context, map, map2);
    }

    public final boolean internalSetUserDataConsent(android.content.Context context, boolean z, boolean z2) {
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.mThirdPartyAdapter;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.setUserDataConsent(context, z, z2) : setUserDataConsent(context, z, z2);
    }

    public final void internalShow(android.app.Activity activity, android.view.ViewGroup viewGroup, com.anythink.core.api.ATCommonImpressionListener aTCommonImpressionListener) {
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter;
        if (!isMixFormatAd() || (aTBaseAdAdapter = this.mThirdPartyAdapter) == null) {
            internalFormatShow(activity, viewGroup, aTCommonImpressionListener);
        } else {
            aTBaseAdAdapter.internalFormatShow(activity, viewGroup, aTCommonImpressionListener);
        }
    }

    public final boolean internalStartBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        fillParams(map);
        parseGloableParams(map, map2);
        this.mBiddingListener = aTBiddingListener;
        boolean startBiddingRequest = startBiddingRequest(context, map, map2, aTBiddingListener);
        if (!startBiddingRequest) {
            this.mBiddingListener = null;
        }
        return startBiddingRequest;
    }

    public abstract boolean isAdReady();

    public boolean isMixFormatAd() {
        return false;
    }

    public abstract void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2);

    public final void notifyATLoadFail(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        if (this.mBiddingListener != null) {
            if (android.text.TextUtils.isEmpty(str)) {
                str3 = str2;
            } else {
                str3 = str + "|" + str2;
            }
            this.mBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.fail(str3), null);
        }
        com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdLoadError(str, str2);
        }
    }

    public void releaseLoadResource() {
        cleanLoadListener();
    }

    public void setAdDownloadListener(com.anythink.core.api.ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    public final void setFetchAdTimeout(int i) {
        this.mFetchAdTimeout = i;
    }

    public final void setRequestNum(int i) {
        if (i > 0) {
            this.mRequestNum = i;
        }
    }

    public final void setScenario(java.lang.String str) {
        this.mScenario = str;
    }

    public boolean setUserDataConsent(android.content.Context context, boolean z, boolean z2) {
        return false;
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        return false;
    }

    public boolean supportImpressionCallback() {
        return true;
    }

    public final void thirdPartyLoad(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.mThirdPartyAdapter = aTBaseAdAdapter;
        aTBaseAdAdapter.internalLoad(context, map, map2, new com.anythink.core.common.b.q(this.mLoadListener, map, this.mMixedFormatAdType));
    }

    public final boolean thirdPartyStartBiddingRequest(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.mThirdPartyAdapter = aTBaseAdAdapter;
        return aTBaseAdAdapter.internalStartBiddingRequest(context, map, map2, new com.anythink.core.common.b.p(aTBiddingListener, map, this.mMixedFormatAdType));
    }
}
