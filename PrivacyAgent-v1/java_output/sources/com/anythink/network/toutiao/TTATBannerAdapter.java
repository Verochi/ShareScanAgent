package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATBannerAdapter extends com.anythink.banner.unitgroup.api.CustomBannerAdapter {
    android.content.Context b;
    android.view.View c;
    int d;
    int e;
    int f;
    java.lang.String g;
    boolean h;
    private com.bytedance.sdk.openadsdk.TTNativeExpressAd n;
    private java.util.Map<java.lang.String, java.lang.Object> o;
    private final java.lang.String m = getClass().getSimpleName();
    java.lang.String a = "";
    boolean i = false;
    com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener j = new com.anythink.network.toutiao.TTATBannerAdapter.AnonymousClass1();
    com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener k = new com.anythink.network.toutiao.TTATBannerAdapter.AnonymousClass2();
    private boolean p = false;
    com.bytedance.sdk.openadsdk.TTAppDownloadListener l = new com.anythink.network.toutiao.TTATBannerAdapter.AnonymousClass6();

    /* renamed from: com.anythink.network.toutiao.TTATBannerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public final void onError(int i, java.lang.String str) {
            com.anythink.network.toutiao.TTATBannerAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTNativeExpressAd> list) {
            if (list == null || list.size() <= 0) {
                com.anythink.network.toutiao.TTATBannerAdapter.this.notifyATLoadFail("", "Return Ad list is empty.");
                return;
            }
            com.anythink.network.toutiao.TTATBannerAdapter.this.n = list.get(0);
            com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter = com.anythink.network.toutiao.TTATBannerAdapter.this;
            if (tTATBannerAdapter.f > 0) {
                tTATBannerAdapter.n.setSlideIntervalTime(com.anythink.network.toutiao.TTATBannerAdapter.this.f);
            } else {
                tTATBannerAdapter.n.setSlideIntervalTime(0);
            }
            com.anythink.network.toutiao.TTATBannerAdapter.b(com.anythink.network.toutiao.TTATBannerAdapter.this);
            com.anythink.network.toutiao.TTATBannerAdapter.this.n.render();
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATBannerAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked(android.view.View view, int i) {
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.toutiao.TTATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow(android.view.View view, int i) {
            try {
                android.view.ViewParent parent = com.anythink.network.toutiao.TTATBannerAdapter.this.c.getParent();
                while (!(parent instanceof android.view.ViewGroup) && parent != null) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    android.content.Context context = ((android.view.ViewGroup) parent).getContext();
                    if (context instanceof android.app.Activity) {
                        com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter = com.anythink.network.toutiao.TTATBannerAdapter.this;
                        com.anythink.network.toutiao.TTATBannerAdapter.a(tTATBannerAdapter, (android.app.Activity) context, tTATBannerAdapter.n);
                    } else {
                        java.lang.String unused = com.anythink.network.toutiao.TTATBannerAdapter.this.m;
                    }
                } else if (view == null || !(view.getContext() instanceof android.app.Activity)) {
                    java.lang.String unused2 = com.anythink.network.toutiao.TTATBannerAdapter.this.m;
                } else {
                    com.anythink.network.toutiao.TTATBannerAdapter.a(com.anythink.network.toutiao.TTATBannerAdapter.this, (android.app.Activity) view.getContext(), com.anythink.network.toutiao.TTATBannerAdapter.this.n);
                }
            } catch (java.lang.Throwable th) {
                java.lang.String unused3 = com.anythink.network.toutiao.TTATBannerAdapter.this.m;
                new java.lang.StringBuilder("bindDislike fail:").append(th.getMessage());
            }
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter2 = com.anythink.network.toutiao.TTATBannerAdapter.this;
                if (tTATBannerAdapter2.h) {
                    return;
                }
                tTATBannerAdapter2.mImpressionEventListener.onBannerAdShow();
                com.anythink.network.toutiao.TTATBannerAdapter.this.h = true;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(android.view.View view, java.lang.String str, int i) {
            com.anythink.network.toutiao.TTATBannerAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(android.view.View view, float f, float f2) {
            com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter = com.anythink.network.toutiao.TTATBannerAdapter.this;
            tTATBannerAdapter.c = view;
            try {
                java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo = tTATBannerAdapter.n.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (com.anythink.network.toutiao.TTATBannerAdapter.this.o == null) {
                        com.anythink.network.toutiao.TTATBannerAdapter.this.o = new java.util.HashMap(3);
                    }
                    com.anythink.network.toutiao.TTATBannerAdapter.this.o.putAll(mediaExtraInfo);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter2 = com.anythink.network.toutiao.TTATBannerAdapter.this;
            tTATBannerAdapter2.h = false;
            if (tTATBannerAdapter2.i) {
                try {
                    com.anythink.network.toutiao.TTATInitManager.getInstance().a(com.anythink.network.toutiao.TTATBannerAdapter.this.o, com.anythink.network.toutiao.TTATBannerAdapter.this.n, com.anythink.network.toutiao.TTATBannerAdapter.this.mBiddingListener);
                } catch (java.lang.Throwable unused) {
                }
            } else if (tTATBannerAdapter2.mLoadListener != null) {
                com.anythink.network.toutiao.TTATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATBannerAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.util.Map a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ android.content.Context c;

        public AnonymousClass3(java.util.Map map, java.util.Map map2, android.content.Context context) {
            this.a = map;
            this.b = map2;
            this.c = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0071 A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            int i;
            int i2;
            int parseInt;
            java.util.Map map;
            com.bytedance.sdk.openadsdk.TTAdManager adManager = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager();
            java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(this.a, com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
            int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(this.a, "layout_type", 1);
            int i3 = 0;
            int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(this.a, "media_size", 0);
            int i4 = 100;
            int i5 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
            if (intFromMap == 1) {
                i2 = 600;
                switch (intFromMap2) {
                    case 0:
                        parseInt = 90;
                        break;
                    case 1:
                        i2 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
                        parseInt = 100;
                        break;
                    case 2:
                        parseInt = 150;
                        break;
                    case 3:
                        parseInt = 260;
                        break;
                    case 4:
                        parseInt = 300;
                        break;
                    case 5:
                        parseInt = 200;
                        break;
                    case 6:
                        i2 = 690;
                        parseInt = 388;
                        break;
                    case 7:
                        parseInt = 400;
                        break;
                    case 8:
                        parseInt = 500;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                if (i2 != 0 && parseInt != 0) {
                    i5 = i2;
                    i4 = parseInt;
                }
                com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter = com.anythink.network.toutiao.TTATBannerAdapter.this;
                tTATBannerAdapter.d = i5 / 2;
                tTATBannerAdapter.e = i4 / 2;
                map = this.b;
                if (map != null && map.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH)) {
                    try {
                        i3 = (int) (java.lang.Double.parseDouble(this.b.get(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH).toString()) / this.c.getResources().getDisplayMetrics().density);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    if (i3 > 0) {
                        com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter2 = com.anythink.network.toutiao.TTATBannerAdapter.this;
                        tTATBannerAdapter2.e = (i3 / tTATBannerAdapter2.d) * tTATBannerAdapter2.e;
                        tTATBannerAdapter2.d = i3;
                    }
                }
                com.bytedance.sdk.openadsdk.TTAdNative createAdNative = adManager.createAdNative(this.c);
                com.anythink.network.toutiao.TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new com.anythink.network.toutiao.TTATCustomAdSlotBuilder(com.anythink.network.toutiao.TTATBannerAdapter.this.a, this.a, this.b);
                tTATCustomAdSlotBuilder.setAdCount(1);
                com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter3 = com.anythink.network.toutiao.TTATBannerAdapter.this;
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(tTATBannerAdapter3.d, tTATBannerAdapter3.e);
                createAdNative.loadBannerExpressAd(tTATCustomAdSlotBuilder.build(), com.anythink.network.toutiao.TTATBannerAdapter.this.j);
            }
            try {
            } catch (java.lang.Exception e) {
                e = e;
                i = 0;
            }
            if (!android.text.TextUtils.isEmpty(stringFromMap)) {
                java.lang.String[] split = stringFromMap.split("x");
                i = java.lang.Integer.parseInt(split[0]);
                try {
                    parseInt = java.lang.Integer.parseInt(split[1]);
                    i2 = i;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    i2 = i;
                    parseInt = 0;
                    if (i2 != 0) {
                    }
                    com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter4 = com.anythink.network.toutiao.TTATBannerAdapter.this;
                    tTATBannerAdapter4.d = i5 / 2;
                    tTATBannerAdapter4.e = i4 / 2;
                    map = this.b;
                    if (map != null) {
                    }
                    com.bytedance.sdk.openadsdk.TTAdNative createAdNative2 = adManager.createAdNative(this.c);
                    com.anythink.network.toutiao.TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder2 = new com.anythink.network.toutiao.TTATCustomAdSlotBuilder(com.anythink.network.toutiao.TTATBannerAdapter.this.a, this.a, this.b);
                    tTATCustomAdSlotBuilder2.setAdCount(1);
                    com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter32 = com.anythink.network.toutiao.TTATBannerAdapter.this;
                    tTATCustomAdSlotBuilder2.setExpressViewAcceptedSize(tTATBannerAdapter32.d, tTATBannerAdapter32.e);
                    createAdNative2.loadBannerExpressAd(tTATCustomAdSlotBuilder2.build(), com.anythink.network.toutiao.TTATBannerAdapter.this.j);
                }
                if (i2 != 0) {
                    i5 = i2;
                    i4 = parseInt;
                }
                com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter42 = com.anythink.network.toutiao.TTATBannerAdapter.this;
                tTATBannerAdapter42.d = i5 / 2;
                tTATBannerAdapter42.e = i4 / 2;
                map = this.b;
                if (map != null) {
                    i3 = (int) (java.lang.Double.parseDouble(this.b.get(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH).toString()) / this.c.getResources().getDisplayMetrics().density);
                    if (i3 > 0) {
                    }
                }
                com.bytedance.sdk.openadsdk.TTAdNative createAdNative22 = adManager.createAdNative(this.c);
                com.anythink.network.toutiao.TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder22 = new com.anythink.network.toutiao.TTATCustomAdSlotBuilder(com.anythink.network.toutiao.TTATBannerAdapter.this.a, this.a, this.b);
                tTATCustomAdSlotBuilder22.setAdCount(1);
                com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter322 = com.anythink.network.toutiao.TTATBannerAdapter.this;
                tTATCustomAdSlotBuilder22.setExpressViewAcceptedSize(tTATBannerAdapter322.d, tTATBannerAdapter322.e);
                createAdNative22.loadBannerExpressAd(tTATCustomAdSlotBuilder22.build(), com.anythink.network.toutiao.TTATBannerAdapter.this.j);
            }
            i2 = 0;
            parseInt = 0;
            if (i2 != 0) {
            }
            com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter422 = com.anythink.network.toutiao.TTATBannerAdapter.this;
            tTATBannerAdapter422.d = i5 / 2;
            tTATBannerAdapter422.e = i4 / 2;
            map = this.b;
            if (map != null) {
            }
            com.bytedance.sdk.openadsdk.TTAdNative createAdNative222 = adManager.createAdNative(this.c);
            com.anythink.network.toutiao.TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder222 = new com.anythink.network.toutiao.TTATCustomAdSlotBuilder(com.anythink.network.toutiao.TTATBannerAdapter.this.a, this.a, this.b);
            tTATCustomAdSlotBuilder222.setAdCount(1);
            com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter3222 = com.anythink.network.toutiao.TTATBannerAdapter.this;
            tTATCustomAdSlotBuilder222.setExpressViewAcceptedSize(tTATBannerAdapter3222.d, tTATBannerAdapter3222.e);
            createAdNative222.loadBannerExpressAd(tTATCustomAdSlotBuilder222.build(), com.anythink.network.toutiao.TTATBannerAdapter.this.j);
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATBannerAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback {
        public AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onCancel() {
        }

        @java.lang.Deprecated
        public final void onRefuse() {
        }

        @java.lang.Deprecated
        public final void onSelected(int i, java.lang.String str) {
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.toutiao.TTATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onSelected(int i, java.lang.String str, boolean z) {
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.toutiao.TTATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onShow() {
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATBannerAdapter$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;

        public AnonymousClass5(android.content.Context context, java.util.Map map, java.util.Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.network.toutiao.TTATBannerAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            try {
                if (com.anythink.network.toutiao.TTATBannerAdapter.this.getMixedFormatAdType() == 0) {
                    com.anythink.network.toutiao.TTATBannerAdapter.this.thirdPartyLoad(new com.anythink.network.toutiao.TTATAdapter(), this.a, this.b, this.c);
                } else {
                    com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter = com.anythink.network.toutiao.TTATBannerAdapter.this;
                    com.anythink.network.toutiao.TTATBannerAdapter.a(tTATBannerAdapter, tTATBannerAdapter.b, this.b, this.c);
                }
            } catch (java.lang.Throwable th) {
                com.anythink.network.toutiao.TTATBannerAdapter.this.notifyATLoadFail("", th.getMessage());
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATBannerAdapter$6, reason: invalid class name */
    public class AnonymousClass6 implements com.bytedance.sdk.openadsdk.TTAppDownloadListener {
        public AnonymousClass6() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.p) {
                if (com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                    return;
                }
                ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            com.anythink.network.toutiao.TTATBannerAdapter.p(com.anythink.network.toutiao.TTATBannerAdapter.this);
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATBannerAdapter.this.mDownloadListener).onInstalled(str, str2);
        }
    }

    private void a() {
        com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd = this.n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(this.k);
            this.n.setDownloadListener(this.l);
        }
    }

    private void a(android.app.Activity activity, com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setDislikeCallback(activity, new com.anythink.network.toutiao.TTATBannerAdapter.AnonymousClass4());
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        runOnNetworkRequestThread(new com.anythink.network.toutiao.TTATBannerAdapter.AnonymousClass3(map, map2, context.getApplicationContext()));
    }

    public static /* synthetic */ void a(com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter, android.app.Activity activity, com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setDislikeCallback(activity, tTATBannerAdapter.new AnonymousClass4());
    }

    public static /* synthetic */ void a(com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter, android.content.Context context, java.util.Map map, java.util.Map map2) {
        tTATBannerAdapter.runOnNetworkRequestThread(tTATBannerAdapter.new AnonymousClass3(map, map2, context.getApplicationContext()));
    }

    private boolean a(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "slot_id");
        if (android.text.TextUtils.isEmpty(stringFromMap) || android.text.TextUtils.isEmpty(this.a)) {
            return false;
        }
        this.f = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "nw_rft", 0);
        this.g = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        return true;
    }

    public static /* synthetic */ void b(com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter) {
        com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd = tTATBannerAdapter.n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(tTATBannerAdapter.k);
            tTATBannerAdapter.n.setDownloadListener(tTATBannerAdapter.l);
        }
    }

    public static /* synthetic */ boolean p(com.anythink.network.toutiao.TTATBannerAdapter tTATBannerAdapter) {
        tTATBannerAdapter.p = true;
        return true;
    }

    public void destory() {
        this.c = null;
        com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd = this.n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener) null);
            this.n.destroy();
            this.n = null;
        }
        this.k = null;
        this.j = null;
    }

    public android.view.View getBannerView() {
        return this.c;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.o;
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

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "slot_id");
        boolean z = false;
        if (!android.text.TextUtils.isEmpty(stringFromMap) && !android.text.TextUtils.isEmpty(this.a)) {
            this.f = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "nw_rft", 0);
            this.g = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
            z = true;
        }
        if (!z) {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        } else {
            this.b = context.getApplicationContext();
            com.anythink.network.toutiao.TTATInitManager.getInstance().initSDK(this.b, map, new com.anythink.network.toutiao.TTATBannerAdapter.AnonymousClass5(context, map, map2));
        }
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        if (getMixedFormatAdType() == 0) {
            return thirdPartyStartBiddingRequest(new com.anythink.network.toutiao.TTATAdapter(), context, map, map2, aTBiddingListener);
        }
        this.i = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
