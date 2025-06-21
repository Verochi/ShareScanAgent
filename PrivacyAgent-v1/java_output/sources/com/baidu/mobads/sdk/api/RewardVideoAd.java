package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class RewardVideoAd {
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private static final java.lang.String TAG = "RewardVideoAd";
    private com.baidu.mobads.sdk.internal.dh mAdProd;
    private final android.content.Context mContext;
    private com.baidu.mobads.sdk.api.RequestParameters mRequestParameters;

    public interface RewardVideoAdListener extends com.baidu.mobads.sdk.api.ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(java.lang.String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdLoaded();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        void onRewardVerify(boolean z);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public RewardVideoAd(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, false);
    }

    public RewardVideoAd(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener rewardVideoAdListener, boolean z) {
        this.mContext = context;
        com.baidu.mobads.sdk.internal.dh dhVar = new com.baidu.mobads.sdk.internal.dh(context, str, z);
        this.mAdProd = dhVar;
        dhVar.a(rewardVideoAdListener);
        if (android.text.TextUtils.isEmpty(str)) {
            com.baidu.mobads.sdk.internal.ay.c().e("RewardVideoAd初始化异常：广告位为空");
        }
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

    public java.lang.Object getAdDataForKey(java.lang.String str) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            return dhVar.k(str);
        }
        return null;
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

    @java.lang.Deprecated
    public void setDownloadAppConfirmPolicy(int i) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.a(i);
        }
    }

    public void setExtraInfo(java.lang.String str) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.j(str);
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

    public void setShowDialogOnSkip(boolean z) {
        if (this.mAdProd != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("showDialogOnSkip", z);
                this.mAdProd.a(jSONObject);
            } catch (java.lang.Throwable th) {
                com.baidu.mobads.sdk.internal.bt.a().c(th);
            }
        }
    }

    public void setUserId(java.lang.String str) {
        com.baidu.mobads.sdk.internal.dh dhVar = this.mAdProd;
        if (dhVar != null) {
            dhVar.a(str);
        }
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
