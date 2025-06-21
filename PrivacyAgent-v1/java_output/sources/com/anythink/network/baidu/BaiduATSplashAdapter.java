package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATSplashAdapter extends com.anythink.splashad.unitgroup.api.CustomSplashAdapter {
    com.baidu.mobads.sdk.api.SplashAd b;
    java.lang.String c;
    private final java.lang.String g = com.anythink.network.baidu.BaiduATSplashAdapter.class.getSimpleName();
    java.lang.String a = "";
    private double h = 0.0d;
    boolean d = false;
    boolean e = false;
    boolean f = false;

    /* renamed from: com.anythink.network.baidu.BaiduATSplashAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.baidu.mobads.sdk.api.SplashInteractionListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public final void onADLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdCacheFailed() {
            com.anythink.network.baidu.BaiduATSplashAdapter baiduATSplashAdapter = com.anythink.network.baidu.BaiduATSplashAdapter.this;
            if (baiduATSplashAdapter.e) {
                return;
            }
            baiduATSplashAdapter.notifyATLoadFail("", "onAdCacheFailed");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdCacheSuccess() {
            com.anythink.network.baidu.BaiduATSplashAdapter baiduATSplashAdapter = com.anythink.network.baidu.BaiduATSplashAdapter.this;
            baiduATSplashAdapter.e = true;
            com.anythink.network.baidu.BaiduATSplashAdapter.m(baiduATSplashAdapter);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdClick() {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdDismissed() {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdExposed() {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public final void onAdFailed(java.lang.String str) {
            com.anythink.network.baidu.BaiduATSplashAdapter baiduATSplashAdapter = com.anythink.network.baidu.BaiduATSplashAdapter.this;
            if (!baiduATSplashAdapter.e) {
                baiduATSplashAdapter.notifyATLoadFail("", str);
                return;
            }
            java.lang.String unused = baiduATSplashAdapter.g;
            "onAdFailed: ".concat(java.lang.String.valueOf(str));
            com.anythink.network.baidu.BaiduATSplashAdapter.e(com.anythink.network.baidu.BaiduATSplashAdapter.this);
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, "", str));
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdPresent() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdSkip() {
            com.anythink.network.baidu.BaiduATSplashAdapter.c(com.anythink.network.baidu.BaiduATSplashAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onLpClosed() {
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATSplashAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;
        final /* synthetic */ android.content.Context d;

        public AnonymousClass2(android.content.Context context, java.util.Map map, java.util.Map map2, android.content.Context context2) {
            this.a = context;
            this.b = map;
            this.c = map2;
            this.d = context2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.baidu.BaiduATSplashAdapter.this).mLoadListener.onAdLoadError("", str);
            }
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            if (com.anythink.network.baidu.BaiduATSplashAdapter.this.getMixedFormatAdType() == 0) {
                com.anythink.network.baidu.BaiduATSplashAdapter.this.thirdPartyLoad(new com.anythink.network.baidu.BaiduATAdapter(), this.a, this.b, this.c);
            } else {
                com.anythink.network.baidu.BaiduATSplashAdapter baiduATSplashAdapter = com.anythink.network.baidu.BaiduATSplashAdapter.this;
                com.anythink.network.baidu.BaiduATSplashAdapter.a(baiduATSplashAdapter, this.d, baiduATSplashAdapter.d, this.b, this.c);
            }
        }
    }

    private static int a(android.content.Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    private void a() {
        double d;
        if (!this.f) {
            com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (this.mBiddingListener != null) {
            com.baidu.mobads.sdk.api.SplashAd splashAd = this.b;
            if (splashAd == null) {
                notifyATLoadFail("", "Baidu: SplashAd had been destroyed.");
                return;
            }
            java.lang.String eCPMLevel = splashAd.getECPMLevel();
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
            com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(this.b);
            com.anythink.core.api.ATBiddingListener aTBiddingListener = this.mBiddingListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    private void a(android.content.Context context, boolean z, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        com.baidu.mobads.sdk.api.RequestParameters.Builder builder = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
        builder.addExtra("timeout", java.lang.String.valueOf(this.mFetchAdTimeout));
        builder.addExtra(com.baidu.mobads.sdk.api.SplashAd.KEY_DISPLAY_DOWNLOADINFO, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        builder.addExtra(com.baidu.mobads.sdk.api.SplashAd.KEY_POPDIALOG_DOWNLOAD, java.lang.String.valueOf(z));
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_WIDTH, 0);
        int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT, 0);
        if (intFromMap > 0 && intFromMap2 > 0) {
            builder.setWidth(a(context, intFromMap));
            builder.setHeight(a(context, intFromMap2));
        }
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(builder, map);
        this.b = new com.baidu.mobads.sdk.api.SplashAd(context.getApplicationContext(), this.a, builder.build(), new com.anythink.network.baidu.BaiduATSplashAdapter.AnonymousClass1());
        if (this.f && this.h > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) this.h);
            }
            this.b.setBidFloor((int) this.h);
        }
        this.b.load();
    }

    public static /* synthetic */ void a(com.anythink.network.baidu.BaiduATSplashAdapter baiduATSplashAdapter, android.content.Context context, boolean z, java.util.Map map, java.util.Map map2) {
        com.baidu.mobads.sdk.api.RequestParameters.Builder builder = new com.baidu.mobads.sdk.api.RequestParameters.Builder();
        builder.addExtra("timeout", java.lang.String.valueOf(baiduATSplashAdapter.mFetchAdTimeout));
        builder.addExtra(com.baidu.mobads.sdk.api.SplashAd.KEY_DISPLAY_DOWNLOADINFO, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        builder.addExtra(com.baidu.mobads.sdk.api.SplashAd.KEY_POPDIALOG_DOWNLOAD, java.lang.String.valueOf(z));
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_WIDTH, 0);
        int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT, 0);
        if (intFromMap > 0 && intFromMap2 > 0) {
            builder.setWidth(a(context, intFromMap));
            builder.setHeight(a(context, intFromMap2));
        }
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(builder, (java.util.Map<java.lang.String, java.lang.Object>) map);
        baiduATSplashAdapter.b = new com.baidu.mobads.sdk.api.SplashAd(context.getApplicationContext(), baiduATSplashAdapter.a, builder.build(), baiduATSplashAdapter.new AnonymousClass1());
        if (baiduATSplashAdapter.f && baiduATSplashAdapter.h > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) baiduATSplashAdapter.h);
            }
            baiduATSplashAdapter.b.setBidFloor((int) baiduATSplashAdapter.h);
        }
        baiduATSplashAdapter.b.load();
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.h = com.anythink.core.api.ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.d = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS);
    }

    public static /* synthetic */ int c(com.anythink.network.baidu.BaiduATSplashAdapter baiduATSplashAdapter) {
        baiduATSplashAdapter.mDismissType = 2;
        return 2;
    }

    public static /* synthetic */ int e(com.anythink.network.baidu.BaiduATSplashAdapter baiduATSplashAdapter) {
        baiduATSplashAdapter.mDismissType = 99;
        return 99;
    }

    public static /* synthetic */ void m(com.anythink.network.baidu.BaiduATSplashAdapter baiduATSplashAdapter) {
        double d;
        if (!baiduATSplashAdapter.f) {
            com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = baiduATSplashAdapter.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (baiduATSplashAdapter.mBiddingListener != null) {
            com.baidu.mobads.sdk.api.SplashAd splashAd = baiduATSplashAdapter.b;
            if (splashAd == null) {
                baiduATSplashAdapter.notifyATLoadFail("", "Baidu: SplashAd had been destroyed.");
                return;
            }
            java.lang.String eCPMLevel = splashAd.getECPMLevel();
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
                baiduATSplashAdapter.notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(java.lang.String.valueOf(d)));
                return;
            }
            com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(baiduATSplashAdapter.b);
            com.anythink.core.api.ATBiddingListener aTBiddingListener = baiduATSplashAdapter.mBiddingListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        com.baidu.mobads.sdk.api.SplashAd splashAd = this.b;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        com.baidu.mobads.sdk.api.SplashAd splashAd = this.b;
        if (splashAd != null) {
            return splashAd.isReady();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.e = false;
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.h = com.anythink.core.api.ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.d = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS);
        if (android.text.TextUtils.isEmpty(this.c) || android.text.TextUtils.isEmpty(this.a)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
        } else {
            android.content.Context applicationContext = context.getApplicationContext();
            com.anythink.network.baidu.BaiduATInitManager.getInstance().initSDK(applicationContext, map, new com.anythink.network.baidu.BaiduATSplashAdapter.AnonymousClass2(context, map, map2, applicationContext));
        }
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        com.baidu.mobads.sdk.api.SplashAd splashAd = this.b;
        if (splashAd != null) {
            splashAd.show(viewGroup);
            return;
        }
        this.mDismissType = 99;
        com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, "", "Baidu Splash show fail: mSplashAd = null"));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.f = true;
        if (getMixedFormatAdType() == 0) {
            return false;
        }
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
