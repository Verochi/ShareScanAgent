package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATSplashAdapter extends com.anythink.splashad.unitgroup.api.CustomSplashAdapter implements com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener {
    com.bytedance.sdk.openadsdk.CSJSplashAd d;
    boolean e;
    com.anythink.network.toutiao.TTATSplashEyeAd f;
    android.view.View g;
    private java.util.Map<java.lang.String, java.lang.Object> m;
    private final java.lang.String k = getClass().getSimpleName();
    java.lang.String a = "";
    java.lang.String b = "";
    java.lang.String c = "";
    private boolean l = false;
    java.lang.String h = "";
    boolean i = false;
    private boolean n = false;
    com.bytedance.sdk.openadsdk.TTAppDownloadListener j = new com.anythink.network.toutiao.TTATSplashAdapter.AnonymousClass4();

    /* renamed from: com.anythink.network.toutiao.TTATSplashAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;

        public AnonymousClass1(android.content.Context context, java.util.Map map, java.util.Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.network.toutiao.TTATSplashAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            try {
                if (com.anythink.network.toutiao.TTATSplashAdapter.this.getMixedFormatAdType() == 0) {
                    com.anythink.network.toutiao.TTATSplashAdapter.this.thirdPartyLoad(new com.anythink.network.toutiao.TTATAdapter(), this.a, this.b, this.c);
                } else {
                    com.anythink.network.toutiao.TTATSplashAdapter.a(com.anythink.network.toutiao.TTATSplashAdapter.this, this.a, this.b, this.c);
                }
            } catch (java.lang.Throwable th) {
                com.anythink.network.toutiao.TTATSplashAdapter.this.notifyATLoadFail("", th.getMessage());
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATSplashAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.bytedance.sdk.openadsdk.AdSlot.Builder a;
        final /* synthetic */ com.bytedance.sdk.openadsdk.TTAdNative b;

        /* renamed from: com.anythink.network.toutiao.TTATSplashAdapter$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener {
            public AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public final void onSplashLoadFail(com.bytedance.sdk.openadsdk.CSJAdError cSJAdError) {
                com.anythink.network.toutiao.TTATSplashAdapter tTATSplashAdapter = com.anythink.network.toutiao.TTATSplashAdapter.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(cSJAdError.getCode());
                tTATSplashAdapter.notifyATLoadFail(sb.toString(), cSJAdError.getMsg());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public final void onSplashLoadSuccess(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
                if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mLoadListener != null) {
                    ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public final void onSplashRenderFail(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd, com.bytedance.sdk.openadsdk.CSJAdError cSJAdError) {
                com.anythink.network.toutiao.TTATSplashAdapter tTATSplashAdapter = com.anythink.network.toutiao.TTATSplashAdapter.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(cSJAdError.getCode());
                tTATSplashAdapter.notifyATLoadFail(sb.toString(), cSJAdError.getMsg());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public final void onSplashRenderSuccess(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
                com.anythink.network.toutiao.TTATSplashAdapter.this.d = cSJSplashAd;
                try {
                    java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo = cSJSplashAd.getMediaExtraInfo();
                    if (mediaExtraInfo != null) {
                        if (com.anythink.network.toutiao.TTATSplashAdapter.this.m == null) {
                            com.anythink.network.toutiao.TTATSplashAdapter.this.m = new java.util.HashMap(3);
                        }
                        com.anythink.network.toutiao.TTATSplashAdapter.this.m.putAll(mediaExtraInfo);
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                com.anythink.network.toutiao.TTATSplashAdapter tTATSplashAdapter = com.anythink.network.toutiao.TTATSplashAdapter.this;
                if (!tTATSplashAdapter.i) {
                    if (((com.anythink.core.api.ATBaseAdAdapter) tTATSplashAdapter).mLoadListener != null) {
                        ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                    }
                } else {
                    try {
                        com.anythink.network.toutiao.TTATInitManager tTATInitManager = com.anythink.network.toutiao.TTATInitManager.getInstance();
                        java.util.Map<java.lang.String, java.lang.Object> map = com.anythink.network.toutiao.TTATSplashAdapter.this.m;
                        com.anythink.network.toutiao.TTATSplashAdapter tTATSplashAdapter2 = com.anythink.network.toutiao.TTATSplashAdapter.this;
                        tTATInitManager.a(map, tTATSplashAdapter2.d, tTATSplashAdapter2.mBiddingListener);
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }

        public AnonymousClass2(com.bytedance.sdk.openadsdk.AdSlot.Builder builder, com.bytedance.sdk.openadsdk.TTAdNative tTAdNative) {
            this.a = builder;
            this.b = tTAdNative;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.b.loadSplashAd(this.a.build(), new com.anythink.network.toutiao.TTATSplashAdapter.AnonymousClass2.AnonymousClass1(), ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mFetchAdTimeout);
            } catch (java.lang.Exception e) {
                com.anythink.network.toutiao.TTATSplashAdapter.this.notifyATLoadFail("", e.getMessage());
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATSplashAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener {
        public AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public final void onSplashClickEyeClick() {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public final void onSplashClickEyeClose() {
            com.anythink.network.toutiao.TTATSplashEyeAd tTATSplashEyeAd;
            com.anythink.splashad.api.ATSplashEyeAdListener splashEyeAdListener;
            com.anythink.network.toutiao.TTATSplashAdapter tTATSplashAdapter = com.anythink.network.toutiao.TTATSplashAdapter.this;
            if (!tTATSplashAdapter.e || (tTATSplashEyeAd = tTATSplashAdapter.f) == null || (splashEyeAdListener = tTATSplashEyeAd.getSplashEyeAdListener()) == null) {
                return;
            }
            splashEyeAdListener.onAdDismiss(true, "");
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public final void onSplashClickEyeReadyToShow(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
            com.anythink.network.toutiao.TTATSplashAdapter tTATSplashAdapter = com.anythink.network.toutiao.TTATSplashAdapter.this;
            tTATSplashAdapter.e = true;
            tTATSplashAdapter.f = new com.anythink.network.toutiao.TTATSplashEyeAd(tTATSplashAdapter, tTATSplashAdapter.d);
            com.anythink.network.toutiao.TTATSplashAdapter tTATSplashAdapter2 = com.anythink.network.toutiao.TTATSplashAdapter.this;
            tTATSplashAdapter2.f.setSplashView(tTATSplashAdapter2.g);
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATSplashAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements com.bytedance.sdk.openadsdk.TTAppDownloadListener {
        public AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATSplashAdapter.this.n) {
                if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener == null || !(((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                    return;
                }
                ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            com.anythink.network.toutiao.TTATSplashAdapter.j(com.anythink.network.toutiao.TTATSplashAdapter.this);
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener == null || !(((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener == null || !(((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, java.lang.String str, java.lang.String str2) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener == null || !(((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener == null || !(((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(java.lang.String str, java.lang.String str2) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener == null || !(((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.toutiao.TTATSplashAdapter.this).mDownloadListener).onInstalled(str, str2);
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
        if (this.l) {
            this.d.setSplashClickEyeListener(new com.anythink.network.toutiao.TTATSplashAdapter.AnonymousClass3());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|(2:2|3)|(12:5|6|7|(2:9|10)|(1:13)|(1:15)|16|17|18|(1:20)|22|23)|29|6|7|(0)|(0)|(0)|16|17|18|(0)|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        r10.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c A[Catch: Exception -> 0x008c, TRY_LEAVE, TryCatch #0 {Exception -> 0x008c, blocks: (B:18:0x0076, B:20:0x007c), top: B:17:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003a A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #1 {all -> 0x0048, blocks: (B:7:0x0034, B:9:0x003a), top: B:6:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        int i;
        com.bytedance.sdk.openadsdk.TTAdManager adManager = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager();
        android.content.Context applicationContext = context.getApplicationContext();
        com.bytedance.sdk.openadsdk.TTAdNative createAdNative = adManager.createAdNative(applicationContext);
        com.anythink.network.toutiao.TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new com.anythink.network.toutiao.TTATCustomAdSlotBuilder(this.b, map, map2);
        int i2 = 0;
        try {
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH)) {
            i = java.lang.Integer.parseInt(map2.get(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH).toString());
            if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT)) {
                i2 = java.lang.Integer.parseInt(map2.get(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT).toString());
            }
            if (i <= 0) {
                i = applicationContext.getResources().getDisplayMetrics().widthPixels;
            }
            if (i2 <= 0) {
                i2 = applicationContext.getResources().getDisplayMetrics().heightPixels;
            }
            tTATCustomAdSlotBuilder.setImageAcceptedSize(i, i2);
            tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(a(applicationContext, i), a(applicationContext, i2));
            if (map.containsKey("zoomoutad_sw")) {
                this.l = android.text.TextUtils.equals("2", map.get("zoomoutad_sw").toString());
            }
            runOnNetworkRequestThread(new com.anythink.network.toutiao.TTATSplashAdapter.AnonymousClass2(tTATCustomAdSlotBuilder, createAdNative));
        }
        i = 0;
        if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT)) {
        }
        if (i <= 0) {
        }
        if (i2 <= 0) {
        }
        tTATCustomAdSlotBuilder.setImageAcceptedSize(i, i2);
        tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(a(applicationContext, i), a(applicationContext, i2));
        if (map.containsKey("zoomoutad_sw")) {
        }
        runOnNetworkRequestThread(new com.anythink.network.toutiao.TTATSplashAdapter.AnonymousClass2(tTATCustomAdSlotBuilder, createAdNative));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|(2:2|3)|(12:5|6|7|(2:9|10)|(1:13)|(1:15)|16|17|18|(1:20)|22|23)|29|6|7|(0)|(0)|(0)|16|17|18|(0)|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        r10.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c A[Catch: Exception -> 0x008c, TRY_LEAVE, TryCatch #0 {Exception -> 0x008c, blocks: (B:18:0x0076, B:20:0x007c), top: B:17:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003a A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #1 {all -> 0x0048, blocks: (B:7:0x0034, B:9:0x003a), top: B:6:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(com.anythink.network.toutiao.TTATSplashAdapter tTATSplashAdapter, android.content.Context context, java.util.Map map, java.util.Map map2) {
        int i;
        com.bytedance.sdk.openadsdk.TTAdManager adManager = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager();
        android.content.Context applicationContext = context.getApplicationContext();
        com.bytedance.sdk.openadsdk.TTAdNative createAdNative = adManager.createAdNative(applicationContext);
        com.anythink.network.toutiao.TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new com.anythink.network.toutiao.TTATCustomAdSlotBuilder(tTATSplashAdapter.b, map, map2);
        int i2 = 0;
        try {
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH)) {
            i = java.lang.Integer.parseInt(map2.get(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH).toString());
            if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT)) {
                i2 = java.lang.Integer.parseInt(map2.get(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT).toString());
            }
            if (i <= 0) {
                i = applicationContext.getResources().getDisplayMetrics().widthPixels;
            }
            if (i2 <= 0) {
                i2 = applicationContext.getResources().getDisplayMetrics().heightPixels;
            }
            tTATCustomAdSlotBuilder.setImageAcceptedSize(i, i2);
            tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(a(applicationContext, i), a(applicationContext, i2));
            if (map.containsKey("zoomoutad_sw")) {
                tTATSplashAdapter.l = android.text.TextUtils.equals("2", map.get("zoomoutad_sw").toString());
            }
            tTATSplashAdapter.runOnNetworkRequestThread(tTATSplashAdapter.new AnonymousClass2(tTATCustomAdSlotBuilder, createAdNative));
        }
        i = 0;
        if (map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT)) {
        }
        if (i <= 0) {
        }
        if (i2 <= 0) {
        }
        tTATCustomAdSlotBuilder.setImageAcceptedSize(i, i2);
        tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(a(applicationContext, i), a(applicationContext, i2));
        if (map.containsKey("zoomoutad_sw")) {
        }
        tTATSplashAdapter.runOnNetworkRequestThread(tTATSplashAdapter.new AnonymousClass2(tTATCustomAdSlotBuilder, createAdNative));
    }

    private boolean a(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "slot_id");
        if (android.text.TextUtils.isEmpty(stringFromMap) || android.text.TextUtils.isEmpty(this.b)) {
            return false;
        }
        this.h = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "personalized_template", "0");
        return true;
    }

    public static /* synthetic */ boolean j(com.anythink.network.toutiao.TTATSplashAdapter tTATSplashAdapter) {
        tTATSplashAdapter.n = true;
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.m;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return com.anythink.network.toutiao.TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.toutiao.TTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public com.anythink.splashad.api.IATSplashEyeAd getSplashEyeAd() {
        return this.f;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        return this.d != null;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        boolean z;
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "slot_id");
        if (android.text.TextUtils.isEmpty(stringFromMap) || android.text.TextUtils.isEmpty(this.b)) {
            z = false;
        } else {
            this.h = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
            this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "personalized_template", "0");
            z = true;
        }
        if (z) {
            com.anythink.network.toutiao.TTATInitManager.getInstance().initSDK(context, map, new com.anythink.network.toutiao.TTATSplashAdapter.AnonymousClass1(context, map, map2));
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClick(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
        com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClose(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd, int i) {
        if (i == 1) {
            this.mDismissType = 2;
            if (this.l && cSJSplashAd != null) {
                cSJSplashAd.startClickEye();
            }
        } else if (i == 2) {
            this.mDismissType = 3;
        } else if (i == 3) {
            this.mDismissType = 4;
        }
        com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdDismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdShow(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
        com.anythink.splashad.unitgroup.api.CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdShow();
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        if (this.d != null) {
            if (isCustomSkipView()) {
                this.d.hideSkipButton();
            }
            this.d.setDownloadListener(this.j);
            if (this.l) {
                this.d.setSplashClickEyeListener(new com.anythink.network.toutiao.TTATSplashAdapter.AnonymousClass3());
            }
            this.d.setSplashAdListener(this);
            android.view.View splashView = this.d.getSplashView();
            if (splashView != null) {
                if (!this.l) {
                    viewGroup.addView(splashView, new android.view.ViewGroup.LayoutParams(-1, -1));
                } else {
                    this.g = splashView;
                    viewGroup.addView(splashView, new android.view.ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.i = true;
        if (getMixedFormatAdType() == 0) {
            return false;
        }
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void startSplashCustomSkipViewClickEye() {
        com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd = this.d;
        if (cSJSplashAd != null) {
            cSJSplashAd.startClickEye();
        }
    }
}
