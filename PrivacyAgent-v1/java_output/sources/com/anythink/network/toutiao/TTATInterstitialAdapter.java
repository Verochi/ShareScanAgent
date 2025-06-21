package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATInterstitialAdapter extends com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter {
    private com.bytedance.sdk.openadsdk.TTFullScreenVideoAd i;
    private java.util.Map<java.lang.String, java.lang.Object> j;
    private final java.lang.String h = getClass().getSimpleName();
    java.lang.String a = "";
    int b = 1;
    java.lang.String c = "";
    boolean d = false;
    com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener e = new com.anythink.network.toutiao.TTATInterstitialAdapter.AnonymousClass1();
    com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f = new com.anythink.network.toutiao.TTATInterstitialAdapter.AnonymousClass2();
    private boolean k = false;
    com.bytedance.sdk.openadsdk.TTAppDownloadListener g = new com.anythink.network.toutiao.TTATInterstitialAdapter.AnonymousClass5();

    /* renamed from: com.anythink.network.toutiao.TTATInterstitialAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onError(int i, java.lang.String str) {
            com.anythink.network.toutiao.TTATInterstitialAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoAdLoad(com.bytedance.sdk.openadsdk.TTFullScreenVideoAd tTFullScreenVideoAd) {
            try {
                if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mLoadListener != null) {
                    com.anythink.network.toutiao.TTATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoCached(com.bytedance.sdk.openadsdk.TTFullScreenVideoAd tTFullScreenVideoAd) {
            com.anythink.network.toutiao.TTATInterstitialAdapter.this.i = tTFullScreenVideoAd;
            try {
                java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo = com.anythink.network.toutiao.TTATInterstitialAdapter.this.i.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.j == null) {
                        com.anythink.network.toutiao.TTATInterstitialAdapter.this.j = new java.util.HashMap(3);
                    }
                    com.anythink.network.toutiao.TTATInterstitialAdapter.this.j.putAll(mediaExtraInfo);
                }
            } catch (java.lang.Throwable unused) {
            }
            com.anythink.network.toutiao.TTATInterstitialAdapter tTATInterstitialAdapter = com.anythink.network.toutiao.TTATInterstitialAdapter.this;
            if (tTATInterstitialAdapter.d) {
                try {
                    com.anythink.network.toutiao.TTATInitManager.getInstance().a(com.anythink.network.toutiao.TTATInterstitialAdapter.this.j, com.anythink.network.toutiao.TTATInterstitialAdapter.this.i, com.anythink.network.toutiao.TTATInterstitialAdapter.this.mBiddingListener);
                } catch (java.lang.Throwable unused2) {
                }
            } else {
                try {
                    if (tTATInterstitialAdapter.mLoadListener != null) {
                        com.anythink.network.toutiao.TTATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                    }
                } catch (java.lang.Throwable unused3) {
                }
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATInterstitialAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdClose() {
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.toutiao.TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdShow() {
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.toutiao.TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                com.anythink.network.toutiao.TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdVideoBarClick() {
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.toutiao.TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onSkippedVideo() {
            com.anythink.network.toutiao.TTATInterstitialAdapter.p(com.anythink.network.toutiao.TTATInterstitialAdapter.this);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onVideoComplete() {
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.toutiao.TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATInterstitialAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;

        public AnonymousClass3(android.content.Context context, java.util.Map map, java.util.Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.sdk.openadsdk.TTAdNative createAdNative = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager().createAdNative(this.a);
            com.anythink.network.toutiao.TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new com.anythink.network.toutiao.TTATCustomAdSlotBuilder(com.anythink.network.toutiao.TTATInterstitialAdapter.this.a, this.b, this.c);
            tTATCustomAdSlotBuilder.setAdCount(1);
            tTATCustomAdSlotBuilder.setOrientation(com.anythink.network.toutiao.TTATInterstitialAdapter.this.b);
            createAdNative.loadFullScreenVideoAd(tTATCustomAdSlotBuilder.build(), com.anythink.network.toutiao.TTATInterstitialAdapter.this.e);
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATInterstitialAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;

        public AnonymousClass4(android.content.Context context, java.util.Map map, java.util.Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.network.toutiao.TTATInterstitialAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            try {
                com.anythink.network.toutiao.TTATInterstitialAdapter.a(com.anythink.network.toutiao.TTATInterstitialAdapter.this, this.a, this.b, this.c);
            } catch (java.lang.Throwable th) {
                com.anythink.network.toutiao.TTATInterstitialAdapter.this.notifyATLoadFail("", th.getMessage());
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATInterstitialAdapter$5, reason: invalid class name */
    public class AnonymousClass5 implements com.bytedance.sdk.openadsdk.TTAppDownloadListener {
        public AnonymousClass5() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.k) {
                if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                    return;
                }
                ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            com.anythink.network.toutiao.TTATInterstitialAdapter.r(com.anythink.network.toutiao.TTATInterstitialAdapter.this);
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATInterstitialAdapter.this.mDownloadListener).onInstalled(str, str2);
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        runOnNetworkRequestThread(new com.anythink.network.toutiao.TTATInterstitialAdapter.AnonymousClass3(context.getApplicationContext(), map, map2));
    }

    public static /* synthetic */ void a(com.anythink.network.toutiao.TTATInterstitialAdapter tTATInterstitialAdapter, android.content.Context context, java.util.Map map, java.util.Map map2) {
        tTATInterstitialAdapter.runOnNetworkRequestThread(tTATInterstitialAdapter.new AnonymousClass3(context.getApplicationContext(), map, map2));
    }

    private boolean a(java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "slot_id");
        if (android.text.TextUtils.isEmpty(stringFromMap) || android.text.TextUtils.isEmpty(this.a)) {
            return false;
        }
        try {
            int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_ORIENTATION, 1);
            if (intFromMap == 1) {
                this.b = 1;
            } else if (intFromMap == 2) {
                this.b = 2;
            }
        } catch (java.lang.Exception unused) {
        }
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        return true;
    }

    public static /* synthetic */ int p(com.anythink.network.toutiao.TTATInterstitialAdapter tTATInterstitialAdapter) {
        tTATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    public static /* synthetic */ boolean r(com.anythink.network.toutiao.TTATInterstitialAdapter tTATInterstitialAdapter) {
        tTATInterstitialAdapter.k = true;
        return true;
    }

    public void destory() {
        com.bytedance.sdk.openadsdk.TTFullScreenVideoAd tTFullScreenVideoAd = this.i;
        if (tTFullScreenVideoAd != null) {
            tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
            this.i = null;
        }
        this.f = null;
        this.e = null;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.j;
    }

    public java.lang.String getNetworkName() {
        return com.anythink.network.toutiao.TTATInitManager.getInstance().getNetworkName();
    }

    public java.lang.String getNetworkPlacementId() {
        return this.a;
    }

    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.toutiao.TTATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        return this.i != null;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (a(map, map2)) {
            com.anythink.network.toutiao.TTATInitManager.getInstance().initSDK(context, map, new com.anythink.network.toutiao.TTATInterstitialAdapter.AnonymousClass4(context, map, map2));
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    public void show(android.app.Activity activity) {
        try {
            com.bytedance.sdk.openadsdk.TTFullScreenVideoAd tTFullScreenVideoAd = this.i;
            if (tTFullScreenVideoAd == null || activity == null) {
                return;
            }
            tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(this.f);
            this.i.setDownloadListener(this.g);
            this.i.showFullScreenVideoAd(activity);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.d = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
