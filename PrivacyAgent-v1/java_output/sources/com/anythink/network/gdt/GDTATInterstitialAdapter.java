package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATInterstitialAdapter extends com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter implements com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener {
    public static java.lang.String TAG = com.anythink.network.gdt.GDTATInterstitialAdapter.class.getSimpleName();
    com.qq.e.ads.interstitial2.UnifiedInterstitialAD a;
    java.lang.String b;
    java.lang.String c;
    java.lang.String d;
    int e = 0;
    java.lang.String f;
    boolean g;
    boolean h;

    /* renamed from: com.anythink.network.gdt.GDTATInterstitialAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.qq.e.ads.interstitial2.UnifiedInterstitialADListener {

        /* renamed from: com.anythink.network.gdt.GDTATInterstitialAdapter$1$1, reason: invalid class name and collision with other inner class name */
        public class C02381 implements com.qq.e.comm.compliance.DownloadConfirmListener {
            public C02381() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public final void onDownloadConfirm(android.app.Activity activity, int i, java.lang.String str, com.qq.e.comm.compliance.DownloadConfirmCallBack downloadConfirmCallBack) {
                if (com.anythink.network.gdt.GDTATInterstitialAdapter.this.mImpressListener != null) {
                    com.anythink.network.gdt.GDTDownloadFirmInfo gDTDownloadFirmInfo = new com.anythink.network.gdt.GDTDownloadFirmInfo();
                    gDTDownloadFirmInfo.appInfoUrl = str;
                    gDTDownloadFirmInfo.scenes = i;
                    gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                    com.anythink.network.gdt.GDTATInterstitialAdapter.this.mImpressListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClicked() {
            if (com.anythink.network.gdt.GDTATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.gdt.GDTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClosed() {
            com.anythink.network.gdt.GDTATInitManager.getInstance().b();
            if (com.anythink.network.gdt.GDTATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.gdt.GDTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = com.anythink.network.gdt.GDTATInterstitialAdapter.this.a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.destroy();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADExposure() {
            try {
                com.anythink.network.gdt.GDTATInitManager.getInstance().a(com.anythink.network.gdt.GDTATInterstitialAdapter.this.getTrackingInfo().q(), new java.lang.ref.WeakReference(com.anythink.network.gdt.GDTATInterstitialAdapter.this.a));
            } catch (java.lang.Throwable unused) {
            }
            if (com.anythink.network.gdt.GDTATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.gdt.GDTATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADReceive() {
            com.anythink.network.gdt.GDTATInterstitialAdapter gDTATInterstitialAdapter = com.anythink.network.gdt.GDTATInterstitialAdapter.this;
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = gDTATInterstitialAdapter.a;
            if (unifiedInterstitialAD != null && gDTATInterstitialAdapter.g) {
                unifiedInterstitialAD.setDownloadConfirmListener(new com.anythink.network.gdt.GDTATInterstitialAdapter.AnonymousClass1.C02381());
            }
            com.anythink.network.gdt.GDTATInterstitialAdapter gDTATInterstitialAdapter2 = com.anythink.network.gdt.GDTATInterstitialAdapter.this;
            if (!gDTATInterstitialAdapter2.h) {
                if (gDTATInterstitialAdapter2.mLoadListener != null) {
                    com.anythink.network.gdt.GDTATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
                }
            } else if (gDTATInterstitialAdapter2.mBiddingListener != null) {
                double ecpm = com.anythink.network.gdt.GDTATInterstitialAdapter.this.a.getECPM();
                com.anythink.network.gdt.GDTATBiddingNotice gDTATBiddingNotice = new com.anythink.network.gdt.GDTATBiddingNotice(com.anythink.network.gdt.GDTATInterstitialAdapter.this.a);
                com.anythink.core.api.ATBiddingListener aTBiddingListener = com.anythink.network.gdt.GDTATInterstitialAdapter.this.mBiddingListener;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(java.lang.System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onNoAD(com.qq.e.comm.util.AdError adError) {
            com.anythink.network.gdt.GDTATInterstitialAdapter.this.notifyATLoadFail(java.lang.String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderFail() {
            com.anythink.network.gdt.GDTATInterstitialAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderSuccess() {
            if (com.anythink.network.gdt.GDTATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.gdt.GDTATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onVideoCached() {
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATInterstitialAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;

        public AnonymousClass2(android.content.Context context, java.util.Map map, java.util.Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.network.gdt.GDTATInterstitialAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            if (com.anythink.network.gdt.GDTATInterstitialAdapter.this.getMixedFormatAdType() == 0) {
                com.anythink.network.gdt.GDTATInterstitialAdapter.this.thirdPartyLoad(new com.anythink.network.gdt.GDTATAdapter(), this.a, this.b, this.c);
            } else {
                com.anythink.network.gdt.GDTATInterstitialAdapter.a(com.anythink.network.gdt.GDTATInterstitialAdapter.this, this.a, this.b, this.c);
            }
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (!(context instanceof android.app.Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        com.anythink.network.gdt.GDTATInterstitialAdapter.AnonymousClass1 anonymousClass1 = new com.anythink.network.gdt.GDTATInterstitialAdapter.AnonymousClass1();
        if (android.text.TextUtils.isEmpty(this.d) || this.h) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, this.c, anonymousClass1);
            this.a = unifiedInterstitialAD;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a(map));
        } else {
            this.a = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, this.c, anonymousClass1, null, this.d);
        }
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            this.a.setVideoOption(new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (android.text.TextUtils.equals("1", this.f)) {
            this.a.loadFullScreenAD();
        } else {
            this.a.loadAD();
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.f = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        this.g = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (!(context instanceof android.app.Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        com.anythink.network.gdt.GDTATInterstitialAdapter.AnonymousClass1 anonymousClass1 = new com.anythink.network.gdt.GDTATInterstitialAdapter.AnonymousClass1();
        if (android.text.TextUtils.isEmpty(this.d) || this.h) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, this.c, anonymousClass1);
            this.a = unifiedInterstitialAD;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a(map));
        } else {
            this.a = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, this.c, anonymousClass1, null, this.d);
        }
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            this.a.setVideoOption(new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (android.text.TextUtils.equals("1", this.f)) {
            this.a.loadFullScreenAD();
        } else {
            this.a.loadAD();
        }
    }

    public static /* synthetic */ void a(com.anythink.network.gdt.GDTATInterstitialAdapter gDTATInterstitialAdapter, android.content.Context context, java.util.Map map, java.util.Map map2) {
        gDTATInterstitialAdapter.f = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        gDTATInterstitialAdapter.g = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (!(context instanceof android.app.Activity)) {
            gDTATInterstitialAdapter.notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        com.anythink.network.gdt.GDTATInterstitialAdapter.AnonymousClass1 anonymousClass1 = gDTATInterstitialAdapter.new AnonymousClass1();
        if (android.text.TextUtils.isEmpty(gDTATInterstitialAdapter.d) || gDTATInterstitialAdapter.h) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, gDTATInterstitialAdapter.c, anonymousClass1);
            gDTATInterstitialAdapter.a = unifiedInterstitialAD;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a((java.util.Map<java.lang.String, java.lang.Object>) map));
        } else {
            gDTATInterstitialAdapter.a = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, gDTATInterstitialAdapter.c, anonymousClass1, null, gDTATInterstitialAdapter.d);
        }
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (gDTATInterstitialAdapter.a != null) {
            gDTATInterstitialAdapter.a.setVideoOption(new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                gDTATInterstitialAdapter.a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (android.text.TextUtils.equals("1", gDTATInterstitialAdapter.f)) {
            gDTATInterstitialAdapter.a.loadFullScreenAD();
        } else {
            gDTATInterstitialAdapter.a.loadAD();
        }
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
    }

    private void b(java.util.Map<java.lang.String, java.lang.Object> map) {
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            this.a.setVideoOption(new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
    }

    public void destory() {
        com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(null);
            this.a.destroy();
            this.a = null;
        }
    }

    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        com.anythink.network.gdt.GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    public com.anythink.core.api.ATInitMediation getMediationInitManager() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance();
    }

    public java.lang.String getNetworkName() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkName();
    }

    public java.lang.String getNetworkPlacementId() {
        return this.c;
    }

    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        if (android.text.TextUtils.isEmpty(this.b) || android.text.TextUtils.isEmpty(this.c)) {
            notifyATLoadFail("", "GDT appid or unitId is empty.");
        } else {
            com.anythink.network.gdt.GDTATInitManager.getInstance().initSDK(context, map, new com.anythink.network.gdt.GDTATInterstitialAdapter.AnonymousClass2(context, map, map2));
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoComplete() {
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdVideoEnd();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoError(com.qq.e.comm.util.AdError adError) {
        com.anythink.network.gdt.GDTATInitManager.getInstance().b();
        if (this.mImpressListener != null) {
            com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(adError.getErrorCode());
            customInterstitialEventListener.onInterstitialAdVideoError(sb.toString(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageClose() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageOpen() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPause() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoReady(long j) {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoStart() {
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdVideoStart();
        }
    }

    public void show(android.app.Activity activity) {
        com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(this);
            if (android.text.TextUtils.equals("1", this.f)) {
                if (activity != null) {
                    com.anythink.network.gdt.GDTATInitManager.getInstance().a(this.c, this.a);
                    this.a.showFullScreenAD(activity);
                    return;
                }
                return;
            }
            com.anythink.network.gdt.GDTATInitManager.getInstance().a(this.c, this.a);
            if (activity != null) {
                this.a.show(activity);
            } else {
                this.a.show();
            }
        }
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
