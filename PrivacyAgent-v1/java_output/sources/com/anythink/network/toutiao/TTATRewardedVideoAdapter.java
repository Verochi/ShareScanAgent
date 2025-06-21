package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATRewardedVideoAdapter extends com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter {
    boolean b;
    private com.bytedance.sdk.openadsdk.TTRewardVideoAd i;
    private java.util.Map<java.lang.String, java.lang.Object> j;
    private final java.lang.String h = getClass().getSimpleName();
    java.lang.String a = "";
    java.lang.String c = "";
    boolean d = false;
    com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener e = new com.anythink.network.toutiao.TTATRewardedVideoAdapter.AnonymousClass1();
    com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener f = new com.anythink.network.toutiao.TTATRewardedVideoAdapter.AnonymousClass2();
    private boolean k = false;
    com.bytedance.sdk.openadsdk.TTAppDownloadListener g = new com.anythink.network.toutiao.TTATRewardedVideoAdapter.AnonymousClass6();

    /* renamed from: com.anythink.network.toutiao.TTATRewardedVideoAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onError(int i, java.lang.String str) {
            com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoAdLoad(com.bytedance.sdk.openadsdk.TTRewardVideoAd tTRewardVideoAd) {
            try {
                if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mLoadListener != null) {
                    com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoCached(com.bytedance.sdk.openadsdk.TTRewardVideoAd tTRewardVideoAd) {
            com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.i = tTRewardVideoAd;
            try {
                java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.i.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.j == null) {
                        com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.j = new java.util.HashMap(3);
                    }
                    com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.j.putAll(mediaExtraInfo);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this;
            if (tTATRewardedVideoAdapter.d) {
                try {
                    com.anythink.network.toutiao.TTATInitManager.getInstance().a(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.j, com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.i, com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mBiddingListener);
                    return;
                } catch (java.lang.Throwable unused) {
                    return;
                }
            }
            try {
                if (tTATRewardedVideoAdapter.mLoadListener != null) {
                    com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATRewardedVideoAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdClose() {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdShow() {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdVideoBarClick() {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardArrived(boolean z, int i, android.os.Bundle bundle) {
            java.lang.String unused = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.h;
            "onRewardArrived(), rewardVerify: ".concat(java.lang.String.valueOf(z));
            if (z) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this;
                if (tTATRewardedVideoAdapter.b || tTATRewardedVideoAdapter.mImpressionListener == null) {
                    return;
                }
                com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this;
                tTATRewardedVideoAdapter2.b = true;
                tTATRewardedVideoAdapter2.mImpressionListener.onReward();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(boolean z, int i, java.lang.String str, int i2, java.lang.String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onSkippedVideo() {
            com.anythink.network.toutiao.TTATRewardedVideoAdapter.o(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this);
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoComplete() {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoError() {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed("", "Callback VideoError");
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATRewardedVideoAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;

        public AnonymousClass3(android.content.Context context, java.util.Map map, java.util.Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:18:0x0079
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            /*
                r7 = this;
                com.bytedance.sdk.openadsdk.TTAdManager r0 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
                android.content.Context r1 = r7.a
                com.bytedance.sdk.openadsdk.TTAdNative r0 = r0.createAdNative(r1)
                com.anythink.network.toutiao.TTATCustomAdSlotBuilder r1 = new com.anythink.network.toutiao.TTATCustomAdSlotBuilder
                com.anythink.network.toutiao.TTATRewardedVideoAdapter r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this
                java.lang.String r2 = r2.a
                java.util.Map r3 = r7.b
                java.util.Map r4 = r7.c
                r1.<init>(r2, r3, r4)
                android.content.Context r2 = r7.a
                android.content.res.Resources r2 = r2.getResources()
                android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
                int r2 = r2.widthPixels
                android.content.Context r3 = r7.a
                android.content.res.Resources r3 = r3.getResources()
                android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
                int r3 = r3.heightPixels
                android.content.Context r4 = r7.a     // Catch: java.lang.Throwable -> L43
                float r2 = (float) r2     // Catch: java.lang.Throwable -> L43
                int r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.a(r4, r2)     // Catch: java.lang.Throwable -> L43
                float r2 = (float) r2     // Catch: java.lang.Throwable -> L43
                android.content.Context r4 = r7.a     // Catch: java.lang.Throwable -> L43
                float r3 = (float) r3     // Catch: java.lang.Throwable -> L43
                int r3 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.a(r4, r3)     // Catch: java.lang.Throwable -> L43
                float r3 = (float) r3     // Catch: java.lang.Throwable -> L43
                r1.setExpressViewAcceptedSize(r2, r3)     // Catch: java.lang.Throwable -> L43
                goto L47
            L43:
                r2 = move-exception
                r2.printStackTrace()
            L47:
                java.util.Map r2 = r7.c
                r3 = 1
                if (r2 == 0) goto L7a
                java.lang.String r4 = "ad_is_support_deep_link"
                java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Exception -> L5b
                java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Exception -> L5b
                boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L5b
                r1.setSupportDeepLink(r2)     // Catch: java.lang.Exception -> L5b
            L5b:
                java.util.Map r2 = r7.c     // Catch: java.lang.Exception -> L79
                java.lang.String r4 = "ad_orientation"
                java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Exception -> L79
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L79
                int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L79
                if (r2 == r3) goto L75
                r4 = 2
                if (r2 == r4) goto L71
                goto L7a
            L71:
                r1.setOrientation(r4)     // Catch: java.lang.Exception -> L79
                goto L7a
            L75:
                r1.setOrientation(r3)     // Catch: java.lang.Exception -> L79
                goto L7a
            L79:
            L7a:
                com.anythink.network.toutiao.TTATRewardedVideoAdapter r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this
                java.lang.String r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.u(r2)
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L8f
                com.anythink.network.toutiao.TTATRewardedVideoAdapter r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this
                java.lang.String r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.v(r2)
                r1.setUserID(r2)
            L8f:
                com.anythink.network.toutiao.TTATRewardedVideoAdapter r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this
                java.lang.String r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.w(r2)
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto Lc3
                com.anythink.network.toutiao.TTATRewardedVideoAdapter r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this
                java.lang.String r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.x(r2)
                java.lang.String r4 = "{network_placement_id}"
                boolean r2 = r2.contains(r4)
                if (r2 == 0) goto Lba
                com.anythink.network.toutiao.TTATRewardedVideoAdapter r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this
                java.lang.String r5 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.y(r2)
                com.anythink.network.toutiao.TTATRewardedVideoAdapter r6 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this
                java.lang.String r6 = r6.a
                java.lang.String r4 = r5.replace(r4, r6)
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.a(r2, r4)
            Lba:
                com.anythink.network.toutiao.TTATRewardedVideoAdapter r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this
                java.lang.String r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.z(r2)
                r1.setMediaExtra(r2)
            Lc3:
                r1.setAdCount(r3)
                com.bytedance.sdk.openadsdk.AdSlot r1 = r1.build()
                com.anythink.network.toutiao.TTATRewardedVideoAdapter r2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this
                com.bytedance.sdk.openadsdk.TTAdNative$RewardVideoAdListener r2 = r2.e
                r0.loadRewardVideoAd(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.toutiao.TTATRewardedVideoAdapter.AnonymousClass3.run():void");
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATRewardedVideoAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener {
        public AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdClose() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdShow() {
            com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this;
            tTATRewardedVideoAdapter.b = false;
            try {
                java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo = tTATRewardedVideoAdapter.i.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.j == null) {
                        com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.j = new java.util.HashMap(3);
                    }
                    com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.j.clear();
                    com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.j.putAll(mediaExtraInfo);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdVideoBarClick() {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardArrived(boolean z, int i, android.os.Bundle bundle) {
            java.lang.String unused = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.h;
            "Again AD, onRewardArrived(), rewardVerify: ".concat(java.lang.String.valueOf(z));
            if (z) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this;
                if (tTATRewardedVideoAdapter.b || tTATRewardedVideoAdapter.mImpressionListener == null) {
                    return;
                }
                com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter2 = com.anythink.network.toutiao.TTATRewardedVideoAdapter.this;
                tTATRewardedVideoAdapter2.b = true;
                tTATRewardedVideoAdapter2.mImpressionListener.onAgainReward();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(boolean z, int i, java.lang.String str, int i2, java.lang.String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onSkippedVideo() {
            com.anythink.network.toutiao.TTATRewardedVideoAdapter.K(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this);
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoComplete() {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayEnd();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoError() {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayFailed("", "Again AD, Callback VideoError");
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATRewardedVideoAdapter$5, reason: invalid class name */
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
            com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            try {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.a(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this, this.a, this.b, this.c);
            } catch (java.lang.Throwable th) {
                com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.notifyATLoadFail("", th.getMessage());
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATRewardedVideoAdapter$6, reason: invalid class name */
    public class AnonymousClass6 implements com.bytedance.sdk.openadsdk.TTAppDownloadListener {
        public AnonymousClass6() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.k) {
                if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                    return;
                }
                ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            com.anythink.network.toutiao.TTATRewardedVideoAdapter.M(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this);
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(java.lang.String str, java.lang.String str2) {
            if (com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener == null || !(com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) com.anythink.network.toutiao.TTATRewardedVideoAdapter.this.mDownloadListener).onInstalled(str, str2);
        }
    }

    public static /* synthetic */ int K(com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    public static /* synthetic */ boolean M(com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.k = true;
        return true;
    }

    public static /* synthetic */ int a(android.content.Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        runOnNetworkRequestThread(new com.anythink.network.toutiao.TTATRewardedVideoAdapter.AnonymousClass3(context.getApplicationContext(), map, map2));
    }

    public static /* synthetic */ void a(com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter, android.content.Context context, java.util.Map map, java.util.Map map2) {
        tTATRewardedVideoAdapter.runOnNetworkRequestThread(tTATRewardedVideoAdapter.new AnonymousClass3(context.getApplicationContext(), map, map2));
    }

    private boolean a(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "slot_id");
        if (android.text.TextUtils.isEmpty(stringFromMap) || android.text.TextUtils.isEmpty(this.a)) {
            return false;
        }
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        return true;
    }

    private static int b(android.content.Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    public static /* synthetic */ int o(com.anythink.network.toutiao.TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    public void destory() {
        com.bytedance.sdk.openadsdk.TTRewardVideoAd tTRewardVideoAd = this.i;
        if (tTRewardVideoAd != null) {
            tTRewardVideoAd.setRewardAdInteractionListener(null);
            this.i.setRewardPlayAgainInteractionListener(null);
            this.i = null;
        }
        this.e = null;
        this.f = null;
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
        boolean z;
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.a = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "slot_id");
        if (android.text.TextUtils.isEmpty(stringFromMap) || android.text.TextUtils.isEmpty(this.a)) {
            z = false;
        } else {
            this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
            z = true;
        }
        if (z) {
            com.anythink.network.toutiao.TTATInitManager.getInstance().initSDK(context, map, new com.anythink.network.toutiao.TTATRewardedVideoAdapter.AnonymousClass5(context, map, map2));
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    public void show(android.app.Activity activity) {
        com.bytedance.sdk.openadsdk.TTRewardVideoAd tTRewardVideoAd;
        if (activity == null || (tTRewardVideoAd = this.i) == null) {
            return;
        }
        tTRewardVideoAd.setRewardAdInteractionListener(this.f);
        this.i.setDownloadListener(this.g);
        this.i.setRewardPlayAgainInteractionListener(new com.anythink.network.toutiao.TTATRewardedVideoAdapter.AnonymousClass4());
        this.i.showRewardVideoAd(activity);
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.d = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
