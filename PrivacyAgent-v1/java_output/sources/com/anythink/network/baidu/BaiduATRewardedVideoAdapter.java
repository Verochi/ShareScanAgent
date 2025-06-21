package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATRewardedVideoAdapter extends com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter {
    private static final java.lang.String c = com.anythink.network.baidu.BaiduATRewardedVideoAdapter.class.getSimpleName();
    com.baidu.mobads.sdk.api.RewardVideoAd a;
    private java.lang.String d = "";
    private java.lang.String e = "";
    private double f = 0.0d;
    boolean b = false;

    /* renamed from: com.anythink.network.baidu.BaiduATRewardedVideoAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClick() {
            if (com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClose(float f) {
            if (com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdFailed(java.lang.String str) {
            com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdLoaded() {
            if (com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mLoadListener != null) {
                com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdShow() {
            if (com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdSkip(float f) {
            com.anythink.network.baidu.BaiduATRewardedVideoAdapter.j(com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        public final void onRewardVerify(boolean z) {
            if (com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener == null || !z) {
                return;
            }
            com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener.onReward();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadFailed() {
            com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.notifyATLoadFail("", "BaiduRewardedVideo: onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadSuccess() {
            com.anythink.network.baidu.BaiduATRewardedVideoAdapter.g(com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void playCompletion() {
            if (com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATRewardedVideoAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;

        public AnonymousClass2(android.content.Context context, java.util.Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            if (com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mLoadListener != null) {
                com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mLoadListener.onAdLoadError("", str);
            }
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            try {
                com.anythink.network.baidu.BaiduATRewardedVideoAdapter.a(com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this, this.a, this.b);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                if (com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mLoadListener != null) {
                    com.anythink.network.baidu.BaiduATRewardedVideoAdapter.this.mLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                }
            }
        }
    }

    private void a() {
        double d;
        if (!this.b) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (this.mBiddingListener != null) {
            com.baidu.mobads.sdk.api.RewardVideoAd rewardVideoAd = this.a;
            if (rewardVideoAd == null) {
                notifyATLoadFail("", "Baidu: RewardVideoAd had been destroyed.");
                return;
            }
            java.lang.String eCPMLevel = rewardVideoAd.getECPMLevel();
            if (android.text.TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            try {
                d = java.lang.Double.parseDouble(eCPMLevel);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            if (d <= 0.0d) {
                notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(java.lang.String.valueOf(d)));
                return;
            }
            com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(this.a);
            com.anythink.core.api.ATBiddingListener aTBiddingListener = this.mBiddingListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.a = new com.baidu.mobads.sdk.api.RewardVideoAd(context.getApplicationContext(), this.d, new com.anythink.network.baidu.BaiduATRewardedVideoAdapter.AnonymousClass1());
        if (this.b && this.f > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) this.f);
            }
            this.a.setBidFloor((int) this.f);
        }
        if (!android.text.TextUtils.isEmpty(this.mUserId)) {
            this.a.setUserId(this.mUserId);
        }
        if (!android.text.TextUtils.isEmpty(this.mUserData)) {
            if (this.mUserData.contains(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.mUserData = this.mUserData.replace(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.d);
            }
            this.a.setExtraInfo(this.mUserData);
        }
        com.baidu.mobads.sdk.api.RequestParameters.Builder builder = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(builder, map);
        this.a.setRequestParameters(builder.build());
        this.a.load();
    }

    public static /* synthetic */ void a(com.anythink.network.baidu.BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter, android.content.Context context, java.util.Map map) {
        baiduATRewardedVideoAdapter.a = new com.baidu.mobads.sdk.api.RewardVideoAd(context.getApplicationContext(), baiduATRewardedVideoAdapter.d, baiduATRewardedVideoAdapter.new AnonymousClass1());
        if (baiduATRewardedVideoAdapter.b && baiduATRewardedVideoAdapter.f > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) baiduATRewardedVideoAdapter.f);
            }
            baiduATRewardedVideoAdapter.a.setBidFloor((int) baiduATRewardedVideoAdapter.f);
        }
        if (!android.text.TextUtils.isEmpty(baiduATRewardedVideoAdapter.mUserId)) {
            baiduATRewardedVideoAdapter.a.setUserId(baiduATRewardedVideoAdapter.mUserId);
        }
        if (!android.text.TextUtils.isEmpty(baiduATRewardedVideoAdapter.mUserData)) {
            if (baiduATRewardedVideoAdapter.mUserData.contains(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                baiduATRewardedVideoAdapter.mUserData = baiduATRewardedVideoAdapter.mUserData.replace(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, baiduATRewardedVideoAdapter.d);
            }
            baiduATRewardedVideoAdapter.a.setExtraInfo(baiduATRewardedVideoAdapter.mUserData);
        }
        com.baidu.mobads.sdk.api.RequestParameters.Builder builder = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(builder, (java.util.Map<java.lang.String, java.lang.Object>) map);
        baiduATRewardedVideoAdapter.a.setRequestParameters(builder.build());
        baiduATRewardedVideoAdapter.a.load();
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.e = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.d = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f = com.anythink.core.api.ATInitMediation.getDoubleFromMap(map, "bid_floor");
    }

    public static /* synthetic */ void g(com.anythink.network.baidu.BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter) {
        double d;
        if (!baiduATRewardedVideoAdapter.b) {
            if (baiduATRewardedVideoAdapter.mLoadListener != null) {
                baiduATRewardedVideoAdapter.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (baiduATRewardedVideoAdapter.mBiddingListener != null) {
            com.baidu.mobads.sdk.api.RewardVideoAd rewardVideoAd = baiduATRewardedVideoAdapter.a;
            if (rewardVideoAd == null) {
                baiduATRewardedVideoAdapter.notifyATLoadFail("", "Baidu: RewardVideoAd had been destroyed.");
                return;
            }
            java.lang.String eCPMLevel = rewardVideoAd.getECPMLevel();
            if (android.text.TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            try {
                d = java.lang.Double.parseDouble(eCPMLevel);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            if (d <= 0.0d) {
                baiduATRewardedVideoAdapter.notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(java.lang.String.valueOf(d)));
                return;
            }
            com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(baiduATRewardedVideoAdapter.a);
            com.anythink.core.api.ATBiddingListener aTBiddingListener = baiduATRewardedVideoAdapter.mBiddingListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    public static /* synthetic */ int j(com.anythink.network.baidu.BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter) {
        baiduATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    public void destory() {
        this.a = null;
    }

    public java.lang.String getNetworkName() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkName();
    }

    public java.lang.String getNetworkPlacementId() {
        return this.d;
    }

    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        com.baidu.mobads.sdk.api.RewardVideoAd rewardVideoAd = this.a;
        if (rewardVideoAd != null) {
            return rewardVideoAd.isReady();
        }
        return false;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.e = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.d = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f = com.anythink.core.api.ATInitMediation.getDoubleFromMap(map, "bid_floor");
        if (android.text.TextUtils.isEmpty(this.e) || android.text.TextUtils.isEmpty(this.d)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
        } else {
            android.content.Context applicationContext = context.getApplicationContext();
            com.anythink.network.baidu.BaiduATInitManager.getInstance().initSDK(applicationContext, map, new com.anythink.network.baidu.BaiduATRewardedVideoAdapter.AnonymousClass2(applicationContext, map));
        }
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    public void show(android.app.Activity activity) {
        try {
            this.a.show(activity);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.b = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
