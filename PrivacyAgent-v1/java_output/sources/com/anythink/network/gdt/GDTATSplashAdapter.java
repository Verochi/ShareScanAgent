package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATSplashAdapter extends com.anythink.splashad.unitgroup.api.CustomSplashAdapter implements com.qq.e.ads.splash.SplashADZoomOutListener {
    boolean b;
    com.anythink.network.gdt.GDTATSplashEyeAd c;
    android.view.ViewGroup d;
    java.lang.String e;
    private java.lang.String g;
    private java.lang.String h;
    private boolean i;
    private com.qq.e.ads.splash.SplashAD j;
    private boolean k;
    final java.lang.String a = com.anythink.network.gdt.GDTATSplashAdapter.class.getSimpleName();
    private boolean l = false;
    boolean f = false;

    /* renamed from: com.anythink.network.gdt.GDTATSplashAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ java.util.Map a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ java.util.Map c;
        final /* synthetic */ android.content.Context d;

        public AnonymousClass1(java.util.Map map, android.content.Context context, java.util.Map map2, android.content.Context context2) {
            this.a = map;
            this.b = context;
            this.c = map2;
            this.d = context2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.network.gdt.GDTATSplashAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            if (com.anythink.network.gdt.GDTATSplashAdapter.this.getMixedFormatAdType() != 0) {
                com.anythink.network.gdt.GDTATSplashAdapter.a(com.anythink.network.gdt.GDTATSplashAdapter.this, this.d, this.a);
                return;
            }
            if (!this.a.containsKey("video_muted")) {
                this.a.put("video_muted", "1");
            }
            com.anythink.network.gdt.GDTATSplashAdapter.this.thirdPartyLoad(new com.anythink.network.gdt.GDTATAdapter(), this.b, this.a, this.c);
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATSplashAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.anythink.network.gdt.GDTATSplashAdapter.this.j != null) {
                    com.anythink.network.gdt.GDTATSplashAdapter gDTATSplashAdapter = com.anythink.network.gdt.GDTATSplashAdapter.this;
                    if (gDTATSplashAdapter.d != null) {
                        gDTATSplashAdapter.j.showAd(com.anythink.network.gdt.GDTATSplashAdapter.this.d);
                    }
                }
            } catch (java.lang.Throwable unused) {
                if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.gdt.GDTATSplashAdapter.this).mImpressionListener != null) {
                    com.anythink.network.gdt.GDTATSplashAdapter.c(com.anythink.network.gdt.GDTATSplashAdapter.this);
                    ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.gdt.GDTATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, "", "GDT Splash show with exception"));
                    ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.gdt.GDTATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATSplashAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.view.ViewGroup a;

        public AnonymousClass3(android.view.ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.anythink.network.gdt.GDTATSplashAdapter.this.j == null || this.a == null) {
                    return;
                }
                com.anythink.network.gdt.GDTATSplashAdapter.this.j.showAd(this.a);
            } catch (java.lang.Throwable unused) {
                if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.gdt.GDTATSplashAdapter.this).mImpressionListener != null) {
                    com.anythink.network.gdt.GDTATSplashAdapter.g(com.anythink.network.gdt.GDTATSplashAdapter.this);
                    ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.gdt.GDTATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, "", "GDT Splash show with exception"));
                    ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.gdt.GDTATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATSplashAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements com.qq.e.comm.compliance.DownloadConfirmListener {
        public AnonymousClass4() {
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public final void onDownloadConfirm(android.app.Activity activity, int i, java.lang.String str, com.qq.e.comm.compliance.DownloadConfirmCallBack downloadConfirmCallBack) {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.gdt.GDTATSplashAdapter.this).mImpressionListener != null) {
                com.anythink.network.gdt.GDTDownloadFirmInfo gDTDownloadFirmInfo = new com.anythink.network.gdt.GDTDownloadFirmInfo();
                gDTDownloadFirmInfo.appInfoUrl = str;
                gDTDownloadFirmInfo.scenes = i;
                gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.gdt.GDTATSplashAdapter.this).mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
            }
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (android.text.TextUtils.isEmpty(this.e) || this.f) {
            com.qq.e.ads.splash.SplashAD splashAD = new com.qq.e.ads.splash.SplashAD(context, this.h, this, this.mFetchAdTimeout);
            this.j = splashAD;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            splashAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a(map));
        } else {
            this.j = new com.qq.e.ads.splash.SplashAD(context, this.h, this, this.mFetchAdTimeout, this.e);
        }
        this.j.fetchAdOnly();
    }

    public static /* synthetic */ void a(com.anythink.network.gdt.GDTATSplashAdapter gDTATSplashAdapter, android.content.Context context, java.util.Map map) {
        if (android.text.TextUtils.isEmpty(gDTATSplashAdapter.e) || gDTATSplashAdapter.f) {
            com.qq.e.ads.splash.SplashAD splashAD = new com.qq.e.ads.splash.SplashAD(context, gDTATSplashAdapter.h, gDTATSplashAdapter, gDTATSplashAdapter.mFetchAdTimeout);
            gDTATSplashAdapter.j = splashAD;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            splashAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a((java.util.Map<java.lang.String, java.lang.Object>) map));
        } else {
            gDTATSplashAdapter.j = new com.qq.e.ads.splash.SplashAD(context, gDTATSplashAdapter.h, gDTATSplashAdapter, gDTATSplashAdapter.mFetchAdTimeout, gDTATSplashAdapter.e);
        }
        gDTATSplashAdapter.j.fetchAdOnly();
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.g = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.h = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.i = false;
        this.k = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (map.containsKey("zoomoutad_sw")) {
            this.l = android.text.TextUtils.equals("2", com.anythink.core.api.ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
    }

    public static /* synthetic */ int c(com.anythink.network.gdt.GDTATSplashAdapter gDTATSplashAdapter) {
        gDTATSplashAdapter.mDismissType = 99;
        return 99;
    }

    public static /* synthetic */ int g(com.anythink.network.gdt.GDTATSplashAdapter gDTATSplashAdapter) {
        gDTATSplashAdapter.mDismissType = 99;
        return 99;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.j = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.h = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        com.anythink.network.gdt.GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public com.anythink.core.api.ATInitMediation getMediationInitManager() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        return this.h;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public com.anythink.splashad.api.IATSplashEyeAd getSplashEyeAd() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        return this.i;
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public boolean isSupportZoomOut() {
        return this.l;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.g = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.h = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.i = false;
        this.k = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (map.containsKey("zoomoutad_sw")) {
            this.l = android.text.TextUtils.equals("2", com.anythink.core.api.ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
        if (android.text.TextUtils.isEmpty(this.g) || android.text.TextUtils.isEmpty(this.h)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            com.anythink.network.gdt.GDTATInitManager.getInstance().initSDK(context, map, new com.anythink.network.gdt.GDTATSplashAdapter.AnonymousClass1(map, context, map2, context.getApplicationContext()));
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdClicked();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        com.anythink.splashad.api.ATSplashEyeAdListener splashEyeAdListener;
        if (!this.l || !this.b) {
            com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
            if (customSplashEventListener != null) {
                customSplashEventListener.onSplashAdDismiss();
                return;
            }
            return;
        }
        com.anythink.network.gdt.GDTATSplashEyeAd gDTATSplashEyeAd = this.c;
        if (gDTATSplashEyeAd == null || (splashEyeAdListener = gDTATSplashEyeAd.getSplashEyeAdListener()) == null) {
            return;
        }
        splashEyeAdListener.onAdDismiss(true, "");
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        try {
            com.anythink.network.gdt.GDTATInitManager.getInstance().a(getTrackingInfo().q(), new java.lang.ref.WeakReference(this.j));
        } catch (java.lang.Throwable unused) {
        }
        com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdShow();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        this.i = true;
        com.qq.e.ads.splash.SplashAD splashAD = this.j;
        if (splashAD != null && this.k) {
            splashAD.setDownloadConfirmListener(new com.anythink.network.gdt.GDTATSplashAdapter.AnonymousClass4());
        }
        if (!this.f) {
            com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (this.mBiddingListener != null) {
            com.qq.e.ads.splash.SplashAD splashAD2 = this.j;
            if (splashAD2 == null) {
                notifyATLoadFail("", "GDT: SplashAD had been destroy.");
                return;
            }
            double ecpm = splashAD2.getECPM();
            com.anythink.network.gdt.GDTATBiddingNotice gDTATBiddingNotice = new com.anythink.network.gdt.GDTATBiddingNotice(this.j);
            com.anythink.core.api.ATBiddingListener aTBiddingListener = this.mBiddingListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(com.qq.e.comm.util.AdError adError) {
        if (adError == null) {
            notifyATLoadFail("", "GDT Splash show fail");
            com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
            if (customSplashEventListener != null) {
                customSplashEventListener.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, "", "GDT Splash show fail"));
                this.mImpressionListener.onSplashAdDismiss();
                return;
            }
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(adError.getErrorCode());
        notifyATLoadFail(sb.toString(), adError.getErrorMsg());
        if (this.mImpressionListener != null) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("GDT Splash show fail:[errorCode:");
            sb2.append(adError.getErrorCode());
            sb2.append(",errorMsg:");
            sb2.append(adError.getErrorMsg());
            sb2.append("]");
            this.mDismissType = 99;
            com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener2 = this.mImpressionListener;
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(adError.getErrorCode());
            customSplashEventListener2.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, sb3.toString(), adError.getErrorMsg()));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOut() {
        this.b = true;
        if (this.l) {
            com.anythink.network.gdt.GDTATSplashEyeAd gDTATSplashEyeAd = new com.anythink.network.gdt.GDTATSplashEyeAd(this, this.j);
            this.c = gDTATSplashEyeAd;
            gDTATSplashEyeAd.setSplashView(this.d);
            com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
            if (customSplashEventListener != null) {
                customSplashEventListener.onSplashAdDismiss();
            }
        }
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOutPlayFinish() {
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
            if (customSplashEventListener != null) {
                this.mDismissType = 99;
                customSplashEventListener.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, "", "Container is null"));
                this.mImpressionListener.onSplashAdDismiss();
                return;
            }
            return;
        }
        if (!this.i || this.j == null) {
            return;
        }
        if (!this.l) {
            viewGroup.post(new com.anythink.network.gdt.GDTATSplashAdapter.AnonymousClass3(viewGroup));
            return;
        }
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(viewGroup.getContext());
        this.d = frameLayout;
        viewGroup.addView(frameLayout, new android.view.ViewGroup.LayoutParams(-1, -1));
        this.d.post(new com.anythink.network.gdt.GDTATSplashAdapter.AnonymousClass2());
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
