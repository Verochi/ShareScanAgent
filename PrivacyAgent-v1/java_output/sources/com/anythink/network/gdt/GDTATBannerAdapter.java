package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATBannerAdapter extends com.anythink.banner.unitgroup.api.CustomBannerAdapter {
    java.lang.String a;
    java.lang.String b;
    java.lang.String c;
    com.qq.e.ads.banner2.UnifiedBannerView d;
    int f;
    boolean g;
    boolean h;
    private final java.lang.String j = com.anythink.network.gdt.GDTATBannerAdapter.class.getSimpleName();
    int e = 0;
    com.qq.e.comm.compliance.DownloadConfirmListener i = new com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass1();

    /* renamed from: com.anythink.network.gdt.GDTATBannerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.qq.e.comm.compliance.DownloadConfirmListener {
        public AnonymousClass1() {
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public final void onDownloadConfirm(android.app.Activity activity, int i, java.lang.String str, com.qq.e.comm.compliance.DownloadConfirmCallBack downloadConfirmCallBack) {
            if (com.anythink.network.gdt.GDTATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.gdt.GDTDownloadFirmInfo gDTDownloadFirmInfo = new com.anythink.network.gdt.GDTDownloadFirmInfo();
                gDTDownloadFirmInfo.appInfoUrl = str;
                gDTDownloadFirmInfo.scenes = i;
                gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                com.anythink.network.gdt.GDTATBannerAdapter.this.mImpressionEventListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
            }
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATBannerAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.qq.e.ads.banner2.UnifiedBannerADListener {
        public AnonymousClass2() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADClicked() {
            if (com.anythink.network.gdt.GDTATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.gdt.GDTATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADClosed() {
            if (com.anythink.network.gdt.GDTATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.gdt.GDTATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADExposure() {
            try {
                com.anythink.network.gdt.GDTATInitManager.getInstance().a(com.anythink.network.gdt.GDTATBannerAdapter.this.getTrackingInfo().q(), new java.lang.ref.WeakReference(com.anythink.network.gdt.GDTATBannerAdapter.this.d));
            } catch (java.lang.Throwable unused) {
            }
            if (com.anythink.network.gdt.GDTATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.gdt.GDTATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADReceive() {
            com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView;
            com.anythink.network.gdt.GDTATBannerAdapter gDTATBannerAdapter = com.anythink.network.gdt.GDTATBannerAdapter.this;
            if (gDTATBannerAdapter.g && (unifiedBannerView = gDTATBannerAdapter.d) != null) {
                unifiedBannerView.setDownloadConfirmListener(gDTATBannerAdapter.i);
            }
            com.anythink.network.gdt.GDTATBannerAdapter gDTATBannerAdapter2 = com.anythink.network.gdt.GDTATBannerAdapter.this;
            if (!gDTATBannerAdapter2.h) {
                if (gDTATBannerAdapter2.mLoadListener != null) {
                    com.anythink.network.gdt.GDTATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                }
            } else if (gDTATBannerAdapter2.mBiddingListener != null) {
                com.anythink.network.gdt.GDTATBannerAdapter gDTATBannerAdapter3 = com.anythink.network.gdt.GDTATBannerAdapter.this;
                com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView2 = gDTATBannerAdapter3.d;
                if (unifiedBannerView2 == null) {
                    gDTATBannerAdapter3.notifyATLoadFail("", "GDT: Offer had been destroy.");
                    return;
                }
                double ecpm = unifiedBannerView2.getECPM();
                com.anythink.network.gdt.GDTATBiddingNotice gDTATBiddingNotice = new com.anythink.network.gdt.GDTATBiddingNotice(com.anythink.network.gdt.GDTATBannerAdapter.this.d);
                com.anythink.core.api.ATBiddingListener aTBiddingListener = com.anythink.network.gdt.GDTATBannerAdapter.this.mBiddingListener;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(java.lang.System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onNoAD(com.qq.e.comm.util.AdError adError) {
            com.anythink.network.gdt.GDTATBannerAdapter gDTATBannerAdapter = com.anythink.network.gdt.GDTATBannerAdapter.this;
            gDTATBannerAdapter.d = null;
            gDTATBannerAdapter.notifyATLoadFail(java.lang.String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATBannerAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;

        /* renamed from: com.anythink.network.gdt.GDTATBannerAdapter$3$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.core.api.MediationInitCallback {
            public AnonymousClass1() {
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(java.lang.String str) {
                com.anythink.network.gdt.GDTATBannerAdapter.this.notifyATLoadFail("", str);
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                if (com.anythink.network.gdt.GDTATBannerAdapter.this.getMixedFormatAdType() != 0) {
                    com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass3 anonymousClass3 = com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass3.this;
                    com.anythink.network.gdt.GDTATBannerAdapter.a(com.anythink.network.gdt.GDTATBannerAdapter.this, (android.app.Activity) anonymousClass3.a, anonymousClass3.b);
                } else {
                    com.anythink.network.gdt.GDTATBannerAdapter gDTATBannerAdapter = com.anythink.network.gdt.GDTATBannerAdapter.this;
                    com.anythink.network.gdt.GDTATAdapter gDTATAdapter = new com.anythink.network.gdt.GDTATAdapter();
                    com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass3 anonymousClass32 = com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass3.this;
                    gDTATBannerAdapter.thirdPartyLoad(gDTATAdapter, anonymousClass32.a, anonymousClass32.b, anonymousClass32.c);
                }
            }
        }

        public AnonymousClass3(android.content.Context context, java.util.Map map, java.util.Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.network.gdt.GDTATInitManager.getInstance().initSDK(this.a, this.b, new com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass3.AnonymousClass1());
        }
    }

    private void a(android.app.Activity activity, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView;
        com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass2 anonymousClass2 = new com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass2();
        if (android.text.TextUtils.isEmpty(this.c) || this.h) {
            com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView2 = new com.qq.e.ads.banner2.UnifiedBannerView(activity, this.b, anonymousClass2);
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            unifiedBannerView2.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a(map));
            unifiedBannerView = unifiedBannerView2;
        } else {
            unifiedBannerView = new com.qq.e.ads.banner2.UnifiedBannerView(activity, this.b, anonymousClass2, null, this.c);
        }
        int i = this.f;
        if (i > 0) {
            unifiedBannerView.setRefresh(i);
        } else {
            unifiedBannerView.setRefresh(0);
        }
        if (unifiedBannerView.getLayoutParams() == null) {
            unifiedBannerView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        }
        this.d = unifiedBannerView;
        unifiedBannerView.loadAD();
    }

    public static /* synthetic */ void a(com.anythink.network.gdt.GDTATBannerAdapter gDTATBannerAdapter, android.app.Activity activity, java.util.Map map) {
        com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView;
        com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass2 anonymousClass2 = gDTATBannerAdapter.new AnonymousClass2();
        if (android.text.TextUtils.isEmpty(gDTATBannerAdapter.c) || gDTATBannerAdapter.h) {
            com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView2 = new com.qq.e.ads.banner2.UnifiedBannerView(activity, gDTATBannerAdapter.b, anonymousClass2);
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            unifiedBannerView2.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a((java.util.Map<java.lang.String, java.lang.Object>) map));
            unifiedBannerView = unifiedBannerView2;
        } else {
            unifiedBannerView = new com.qq.e.ads.banner2.UnifiedBannerView(activity, gDTATBannerAdapter.b, anonymousClass2, null, gDTATBannerAdapter.c);
        }
        int i = gDTATBannerAdapter.f;
        if (i > 0) {
            unifiedBannerView.setRefresh(i);
        } else {
            unifiedBannerView.setRefresh(0);
        }
        if (unifiedBannerView.getLayoutParams() == null) {
            unifiedBannerView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        }
        gDTATBannerAdapter.d = unifiedBannerView;
        unifiedBannerView.loadAD();
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_version");
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.g = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        this.f = 0;
        try {
            if (map.containsKey("nw_rft")) {
                this.f = (int) (com.anythink.core.api.ATInitMediation.getIntFromMap(map, "nw_rft") / 1000.0f);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void destory() {
        com.qq.e.ads.banner2.UnifiedBannerView unifiedBannerView = this.d;
        if (unifiedBannerView != null) {
            if (unifiedBannerView instanceof com.qq.e.ads.banner2.UnifiedBannerView) {
                unifiedBannerView.destroy();
            }
            this.d = null;
        }
    }

    public android.view.View getBannerView() {
        return this.d;
    }

    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        com.anythink.network.gdt.GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    public com.anythink.core.api.ATInitMediation getMediationInitManager() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance();
    }

    public java.lang.String getNetworkName() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkName();
    }

    public java.lang.String getNetworkPlacementId() {
        return this.b;
    }

    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkVersion();
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_version");
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.g = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        this.f = 0;
        try {
            if (map.containsKey("nw_rft")) {
                this.f = (int) (com.anythink.core.api.ATInitMediation.getIntFromMap(map, "nw_rft") / 1000.0f);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (android.text.TextUtils.isEmpty(this.a) || android.text.TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else if (context instanceof android.app.Activity) {
            runOnNetworkRequestThread(new com.anythink.network.gdt.GDTATBannerAdapter.AnonymousClass3(context, map, map2));
        } else {
            notifyATLoadFail("", "Context must be activity.");
        }
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        if (getMixedFormatAdType() == 0) {
            return thirdPartyStartBiddingRequest(new com.anythink.network.gdt.GDTATAdapter(), context, map, map2, aTBiddingListener);
        }
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
