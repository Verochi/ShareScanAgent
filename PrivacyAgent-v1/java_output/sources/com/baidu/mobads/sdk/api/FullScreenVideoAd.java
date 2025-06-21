package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class FullScreenVideoAd {
    private static final java.lang.String TAG = "FullScreenVideoAd";
    private com.baidu.mobads.sdk.internal.dh mAdProd;
    private final android.content.Context mContext;
    private com.baidu.mobads.sdk.api.RequestParameters mRequestParameters;

    public interface FullScreenVideoAdListener extends com.baidu.mobads.sdk.api.ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(java.lang.String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public FullScreenVideoAd(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
    }

    public FullScreenVideoAd(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        this.mContext = context;
        com.baidu.mobads.sdk.internal.df dfVar = new com.baidu.mobads.sdk.internal.df(context, str, z);
        this.mAdProd = dfVar;
        dfVar.a(fullScreenVideoAdListener);
    }

    public void biddingFail(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public void biddingSuccess(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public java.lang.String getBiddingToken() {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            return dhVar.l();
        }
        return null;
    }

    public java.lang.String getECPMLevel() {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        return dhVar != null ? dhVar.g() : "";
    }

    public java.lang.String getPECPM() {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        return dhVar != null ? dhVar.x() : "";
    }

    public boolean isReady() {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            return dhVar.f();
        }
        return false;
    }

    public synchronized void load() {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.a();
        }
    }

    public void loadBiddingAd(java.lang.String str) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.c(str);
        }
    }

    public void setAppSid(java.lang.String str) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.h(str);
        }
    }

    public void setBidFloor(int i) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.r = i;
        }
    }

    @java.lang.Deprecated
    public void setBiddingData(java.lang.String str) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.b(str);
        }
    }

    public void setRequestParameters(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        com.baidu.mobads.sdk.internal.dh dhVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (dhVar = this.mAdProd) == null) {
            return;
        }
        dhVar.a(requestParameters);
    }

    public synchronized void show() {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.e();
        }
    }

    public synchronized void show(android.content.Context context) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.a(context);
        }
    }
}
