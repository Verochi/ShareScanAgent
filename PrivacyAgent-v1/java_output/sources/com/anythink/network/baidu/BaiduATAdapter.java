package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATAdapter extends com.anythink.nativead.unitgroup.api.CustomNativeAdapter {
    java.lang.String a;
    java.lang.String b;
    java.lang.String c;
    private com.baidu.mobads.sdk.api.BaiduNativeManager i;
    private double h = 0.0d;
    com.baidu.mobads.sdk.api.StyleParams.Builder d = new com.baidu.mobads.sdk.api.StyleParams.Builder();
    int e = 0;
    boolean f = false;
    boolean g = true;

    /* renamed from: com.anythink.network.baidu.BaiduATAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;

        public AnonymousClass1(android.content.Context context, java.util.Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.network.baidu.BaiduATAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            try {
                com.anythink.network.baidu.BaiduATAdapter.a(com.anythink.network.baidu.BaiduATAdapter.this, this.a, this.b);
            } catch (java.lang.Throwable th) {
                com.anythink.network.baidu.BaiduATAdapter.this.notifyATLoadFail("", "Baidu: init error, " + th.getMessage());
            }
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass2(android.content.Context context) {
            this.a = context;
        }

        @Override // com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.network.baidu.BaiduATAdapter.this.notifyATLoadFail(str, str2);
        }

        @Override // com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener
        public final void onSuccess(com.baidu.mobads.sdk.api.NativeResponse nativeResponse, com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(nativeResponse);
            com.anythink.network.baidu.BaiduATAdapter.a(com.anythink.network.baidu.BaiduATAdapter.this, arrayList, this.a, customNativeAd);
        }
    }

    public class a implements com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener {
        private final android.content.Context b;

        public a(android.content.Context context) {
            this.b = context;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNativeFail(int i, java.lang.String str, com.baidu.mobads.sdk.api.ExpressResponse expressResponse) {
            com.anythink.network.baidu.BaiduATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNativeLoad(java.util.List<com.baidu.mobads.sdk.api.ExpressResponse> list) {
            double d;
            if (list == null || list.size() == 0) {
                com.anythink.network.baidu.BaiduATAdapter.this.notifyATLoadFail("", "Baidu ad return empty.");
                return;
            }
            if (!com.anythink.network.baidu.BaiduATAdapter.this.f) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<com.baidu.mobads.sdk.api.ExpressResponse> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.anythink.network.baidu.BaiduATNativeExpressFeedAd(this.b, it.next()));
                }
                com.anythink.nativead.unitgroup.api.CustomNativeAd[] customNativeAdArr = (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]);
                if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.baidu.BaiduATAdapter.this).mLoadListener != null) {
                    ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.baidu.BaiduATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            com.baidu.mobads.sdk.api.ExpressResponse expressResponse = list.get(0);
            com.anythink.network.baidu.BaiduATNativeExpressFeedAd baiduATNativeExpressFeedAd = new com.anythink.network.baidu.BaiduATNativeExpressFeedAd(this.b, expressResponse);
            com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(expressResponse);
            try {
                d = java.lang.Double.parseDouble(expressResponse.getECPMLevel());
            } catch (java.lang.Throwable unused) {
                d = 0.0d;
            }
            com.anythink.core.api.ATBiddingListener aTBiddingListener = com.anythink.network.baidu.BaiduATAdapter.this.mBiddingListener;
            if (aTBiddingListener != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(expressResponse.hashCode());
                aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), baiduATNativeExpressFeedAd);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNoAd(int i, java.lang.String str, com.baidu.mobads.sdk.api.ExpressResponse expressResponse) {
            com.anythink.network.baidu.BaiduATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onVideoDownloadSuccess() {
        }
    }

    public class b implements com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener {
        private final android.content.Context b;

        public b(android.content.Context context) {
            this.b = context;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeFail(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
            com.anythink.network.baidu.BaiduATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeLoad(java.util.List<com.baidu.mobads.sdk.api.NativeResponse> list) {
            if (list == null || list.size() == 0) {
                com.anythink.network.baidu.BaiduATAdapter.this.notifyATLoadFail("", "callback onNativeLoad but no ad");
            } else {
                com.anythink.network.baidu.BaiduATAdapter.a(com.anythink.network.baidu.BaiduATAdapter.this, list, this.b, null);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNoAd(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
            com.anythink.network.baidu.BaiduATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadSuccess() {
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.i = new com.baidu.mobads.sdk.api.BaiduNativeManager(context, this.b);
        com.baidu.mobads.sdk.api.RequestParameters.Builder downloadAppConfirmPolicy = new com.baidu.mobads.sdk.api.RequestParameters.Builder().downloadAppConfirmPolicy(3);
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(downloadAppConfirmPolicy, map);
        com.baidu.mobads.sdk.api.RequestParameters build = downloadAppConfirmPolicy.build();
        if (this.f && this.h > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) this.h);
            }
            this.i.setBidFloor((int) this.h);
        }
        int i = this.e;
        if (i == 3) {
            new com.anythink.network.baidu.BaiduATNativePortraitVideoAd(context, this.i, build, this.g).load(new com.anythink.network.baidu.BaiduATAdapter.AnonymousClass2(context));
        } else if (i == 2) {
            this.i.loadExpressAd(build, new com.anythink.network.baidu.BaiduATAdapter.a(context));
        } else {
            this.i.loadFeedAd(build, new com.anythink.network.baidu.BaiduATAdapter.b(context));
        }
    }

    public static /* synthetic */ void a(com.anythink.network.baidu.BaiduATAdapter baiduATAdapter, android.content.Context context, java.util.Map map) {
        baiduATAdapter.i = new com.baidu.mobads.sdk.api.BaiduNativeManager(context, baiduATAdapter.b);
        com.baidu.mobads.sdk.api.RequestParameters.Builder downloadAppConfirmPolicy = new com.baidu.mobads.sdk.api.RequestParameters.Builder().downloadAppConfirmPolicy(3);
        com.anythink.network.baidu.BaiduATInitManager.getInstance();
        com.anythink.network.baidu.BaiduATInitManager.a(downloadAppConfirmPolicy, (java.util.Map<java.lang.String, java.lang.Object>) map);
        com.baidu.mobads.sdk.api.RequestParameters build = downloadAppConfirmPolicy.build();
        if (baiduATAdapter.f && baiduATAdapter.h > 0.0d) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("setBidFloor:").append((int) baiduATAdapter.h);
            }
            baiduATAdapter.i.setBidFloor((int) baiduATAdapter.h);
        }
        int i = baiduATAdapter.e;
        if (i == 3) {
            new com.anythink.network.baidu.BaiduATNativePortraitVideoAd(context, baiduATAdapter.i, build, baiduATAdapter.g).load(baiduATAdapter.new AnonymousClass2(context));
        } else if (i == 2) {
            baiduATAdapter.i.loadExpressAd(build, baiduATAdapter.new a(context));
        } else {
            baiduATAdapter.i.loadFeedAd(build, baiduATAdapter.new b(context));
        }
    }

    public static /* synthetic */ void a(com.anythink.network.baidu.BaiduATAdapter baiduATAdapter, java.util.List list, android.content.Context context, com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd) {
        double d;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        baiduATAdapter.d.build();
        if (!baiduATAdapter.f) {
            if (baiduATAdapter.e == 3) {
                arrayList.add(customNativeAd);
            } else {
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.anythink.network.baidu.BaiduATNativeAd(context, (com.baidu.mobads.sdk.api.NativeResponse) it.next()));
                }
            }
            com.anythink.nativead.unitgroup.api.CustomNativeAd[] customNativeAdArr = (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]);
            com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = baiduATAdapter.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(customNativeAdArr);
                return;
            }
            return;
        }
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = (com.baidu.mobads.sdk.api.NativeResponse) list.get(0);
        if (baiduATAdapter.e != 3) {
            customNativeAd = new com.anythink.network.baidu.BaiduATNativeAd(context, nativeResponse);
        }
        com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(nativeResponse);
        try {
            d = java.lang.Double.parseDouble(nativeResponse.getECPMLevel());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            d = 0.0d;
        }
        if (d <= 0.0d) {
            baiduATAdapter.notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(java.lang.String.valueOf(d)));
            return;
        }
        com.anythink.core.api.ATBiddingListener aTBiddingListener = baiduATAdapter.mBiddingListener;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(nativeResponse.hashCode());
        aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), customNativeAd);
    }

    private void a(java.util.List<com.baidu.mobads.sdk.api.NativeResponse> list, android.content.Context context, com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd) {
        double d;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.d.build();
        if (!this.f) {
            if (this.e == 3) {
                arrayList.add(customNativeAd);
            } else {
                java.util.Iterator<com.baidu.mobads.sdk.api.NativeResponse> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.anythink.network.baidu.BaiduATNativeAd(context, it.next()));
                }
            }
            com.anythink.nativead.unitgroup.api.CustomNativeAd[] customNativeAdArr = (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]);
            com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(customNativeAdArr);
                return;
            }
            return;
        }
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = list.get(0);
        if (this.e != 3) {
            customNativeAd = new com.anythink.network.baidu.BaiduATNativeAd(context, nativeResponse);
        }
        com.anythink.network.baidu.BaiduATBiddingNotice baiduATBiddingNotice = new com.anythink.network.baidu.BaiduATBiddingNotice(nativeResponse);
        try {
            d = java.lang.Double.parseDouble(nativeResponse.getECPMLevel());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            d = 0.0d;
        }
        if (d <= 0.0d) {
            notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(java.lang.String.valueOf(d)));
            return;
        }
        com.anythink.core.api.ATBiddingListener aTBiddingListener = this.mBiddingListener;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(nativeResponse.hashCode());
        aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(d, sb.toString(), baiduATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), customNativeAd);
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.e = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_type");
        this.h = com.anythink.core.api.ATInitMediation.getDoubleFromMap(map, "bid_floor");
        try {
            if (map2.containsKey(com.anythink.network.baidu.BaiduATConst.STYLE_BUILDER)) {
                java.lang.Object obj = map2.get(com.anythink.network.baidu.BaiduATConst.STYLE_BUILDER);
                if (obj instanceof com.baidu.mobads.sdk.api.StyleParams.Builder) {
                    this.d = (com.baidu.mobads.sdk.api.StyleParams.Builder) obj;
                }
            }
            if (map.containsKey("cta_button")) {
                this.d.setShowActionButton(com.anythink.core.api.ATInitMediation.getStringFromMap(map, "cta_button").equals("1"));
            }
            if (map.containsKey("button_type")) {
                this.d.setRegionClick(com.anythink.core.api.ATInitMediation.getStringFromMap(map, "button_type").equals("2"));
            }
            if (map.containsKey("dl_type")) {
                this.d.setShowDialogFrame(com.anythink.core.api.ATInitMediation.getStringFromMap(map, "dl_type").equals("2"));
            }
            boolean z = true;
            if (com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_autoplay", 1) != 1) {
                z = false;
            }
            this.g = z;
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.baidu.BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.b = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.e = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_type");
        this.h = com.anythink.core.api.ATInitMediation.getDoubleFromMap(map, "bid_floor");
        try {
            if (map2.containsKey(com.anythink.network.baidu.BaiduATConst.STYLE_BUILDER)) {
                java.lang.Object obj = map2.get(com.anythink.network.baidu.BaiduATConst.STYLE_BUILDER);
                if (obj instanceof com.baidu.mobads.sdk.api.StyleParams.Builder) {
                    this.d = (com.baidu.mobads.sdk.api.StyleParams.Builder) obj;
                }
            }
            if (map.containsKey("cta_button")) {
                this.d.setShowActionButton(com.anythink.core.api.ATInitMediation.getStringFromMap(map, "cta_button").equals("1"));
            }
            if (map.containsKey("button_type")) {
                this.d.setRegionClick(com.anythink.core.api.ATInitMediation.getStringFromMap(map, "button_type").equals("2"));
            }
            if (map.containsKey("dl_type")) {
                this.d.setShowDialogFrame(com.anythink.core.api.ATInitMediation.getStringFromMap(map, "dl_type").equals("2"));
            }
            boolean z = true;
            if (com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_autoplay", 1) != 1) {
                z = false;
            }
            this.g = z;
        } catch (java.lang.Exception unused) {
        }
        if (android.text.TextUtils.isEmpty(this.a) || android.text.TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "app_id or ad_place_id is empty.");
        } else {
            android.content.Context applicationContext = context.getApplicationContext();
            com.anythink.network.baidu.BaiduATInitManager.getInstance().initSDK(applicationContext, map, new com.anythink.network.baidu.BaiduATAdapter.AnonymousClass1(applicationContext, map));
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
