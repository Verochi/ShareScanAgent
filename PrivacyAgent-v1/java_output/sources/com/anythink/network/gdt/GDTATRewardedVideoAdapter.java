package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATRewardedVideoAdapter extends com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter {
    private static final java.lang.String f = com.anythink.network.gdt.GDTATRewardedVideoAdapter.class.getSimpleName();
    com.qq.e.ads.rewardvideo.RewardVideoAD a;
    com.qq.e.ads.interstitial2.UnifiedInterstitialAD b;
    java.lang.String c;
    java.lang.String d;
    java.lang.String e;
    private java.util.Map<java.lang.String, java.lang.Object> h;
    private boolean i;
    private int g = 0;
    private int j = 1;
    private boolean k = false;

    /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;

        public AnonymousClass1(android.content.Context context, java.util.Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            com.anythink.network.gdt.GDTATRewardedVideoAdapter.a(com.anythink.network.gdt.GDTATRewardedVideoAdapter.this, this.a, this.b);
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.qq.e.ads.rewardvideo.RewardVideoADListener {

        /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.qq.e.comm.compliance.DownloadConfirmListener {
            public AnonymousClass1() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public final void onDownloadConfirm(android.app.Activity activity, int i, java.lang.String str, com.qq.e.comm.compliance.DownloadConfirmCallBack downloadConfirmCallBack) {
                if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    com.anythink.network.gdt.GDTDownloadFirmInfo gDTDownloadFirmInfo = new com.anythink.network.gdt.GDTDownloadFirmInfo();
                    gDTDownloadFirmInfo.appInfoUrl = str;
                    gDTDownloadFirmInfo.scenes = i;
                    gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                    com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADClick() {
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADClose() {
            com.anythink.network.gdt.GDTATInitManager.getInstance().a();
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADExpose() {
            try {
                com.anythink.network.gdt.GDTATInitManager.getInstance().a(com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.getTrackingInfo().q(), new java.lang.ref.WeakReference(com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.a));
            } catch (java.lang.Throwable unused) {
            }
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADLoad() {
            try {
                java.util.Map<java.lang.String, java.lang.Object> extraInfo = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.a.getExtraInfo();
                if (extraInfo != null) {
                    if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h == null) {
                        com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h = new java.util.HashMap();
                    }
                    com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h.putAll(extraInfo);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            com.anythink.network.gdt.GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this;
            if (gDTATRewardedVideoAdapter.a != null && gDTATRewardedVideoAdapter.i) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.a.setDownloadConfirmListener(new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass2.AnonymousClass1());
            }
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADShow() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onError(com.qq.e.comm.util.AdError adError) {
            com.anythink.network.gdt.GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(adError.getErrorCode());
            gDTATRewardedVideoAdapter.notifyATLoadFail(sb.toString(), adError.getErrorMsg());
        }

        public final void onReward() {
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onReward();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onReward(java.util.Map<java.lang.String, java.lang.Object> map) {
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h == null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h = new java.util.HashMap();
            }
            com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h.put("gdt_trans_id", map.get("transId"));
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onReward();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onVideoCached() {
            com.qq.e.ads.rewardvideo.RewardVideoAD rewardVideoAD;
            if (!com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.k) {
                if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                    com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                }
            } else {
                if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mBiddingListener == null || (rewardVideoAD = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.a) == null) {
                    return;
                }
                double ecpm = rewardVideoAD.getECPM();
                com.anythink.network.gdt.GDTATBiddingNotice gDTATBiddingNotice = new com.anythink.network.gdt.GDTATBiddingNotice(com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.a);
                com.anythink.core.api.ATBiddingListener aTBiddingListener = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mBiddingListener;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(java.lang.System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onVideoComplete() {
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements com.qq.e.ads.interstitial2.UnifiedInterstitialADListener {

        /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$3$1, reason: invalid class name */
        public class AnonymousClass1 implements com.qq.e.comm.compliance.DownloadConfirmListener {
            public AnonymousClass1() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public final void onDownloadConfirm(android.app.Activity activity, int i, java.lang.String str, com.qq.e.comm.compliance.DownloadConfirmCallBack downloadConfirmCallBack) {
                if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    com.anythink.network.gdt.GDTDownloadFirmInfo gDTDownloadFirmInfo = new com.anythink.network.gdt.GDTDownloadFirmInfo();
                    gDTDownloadFirmInfo.appInfoUrl = str;
                    gDTDownloadFirmInfo.scenes = i;
                    gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                    com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                }
            }
        }

        /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$3$2, reason: invalid class name */
        public class AnonymousClass2 implements com.qq.e.ads.interstitial2.ADRewardListener {
            public AnonymousClass2() {
            }

            @Override // com.qq.e.comm.listeners.ADRewardListener
            public final void onReward(java.util.Map<java.lang.String, java.lang.Object> map) {
                if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h == null) {
                    com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h = new java.util.HashMap();
                }
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h.put("gdt_trans_id", map.get("transId"));
                if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onReward();
                }
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClicked() {
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClosed() {
            com.anythink.network.gdt.GDTATInitManager.getInstance().b();
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADExposure() {
            try {
                com.anythink.network.gdt.GDTATInitManager.getInstance().a(com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.getTrackingInfo().q(), new java.lang.ref.WeakReference(com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.b));
            } catch (java.lang.Throwable unused) {
            }
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
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
            try {
                java.util.Map<java.lang.String, java.lang.Object> extraInfo = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.b.getExtraInfo();
                if (extraInfo != null) {
                    if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h == null) {
                        com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h = new java.util.HashMap();
                    }
                    com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.h.putAll(extraInfo);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            com.anythink.network.gdt.GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this;
            if (gDTATRewardedVideoAdapter.b != null && gDTATRewardedVideoAdapter.i) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.b.setDownloadConfirmListener(new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass3.AnonymousClass1());
            }
            com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.b.setRewardListener(new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass3.AnonymousClass2());
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onNoAD(com.qq.e.comm.util.AdError adError) {
            com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.notifyATLoadFail(java.lang.String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderFail() {
            com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderSuccess() {
            if (!com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.k) {
                if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                    com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                }
            } else if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mBiddingListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this;
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = gDTATRewardedVideoAdapter.b;
                if (unifiedInterstitialAD == null) {
                    gDTATRewardedVideoAdapter.notifyATLoadFail("", "GDT : UnifiedInterstitialAD had been destroyed.");
                    return;
                }
                double ecpm = unifiedInterstitialAD.getECPM();
                com.anythink.network.gdt.GDTATBiddingNotice gDTATBiddingNotice = new com.anythink.network.gdt.GDTATBiddingNotice(com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.b);
                com.anythink.core.api.ATBiddingListener aTBiddingListener = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mBiddingListener;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(java.lang.System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onVideoCached() {
        }
    }

    /* renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener {
        public AnonymousClass4() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoComplete() {
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoError(com.qq.e.comm.util.AdError adError) {
            if (com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener customRewardedVideoEventListener = com.anythink.network.gdt.GDTATRewardedVideoAdapter.this.mImpressionListener;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(adError.getErrorCode());
                customRewardedVideoEventListener.onRewardedVideoAdPlayFailed(sb.toString(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoInit() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoLoading() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPageClose() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPageOpen() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPause() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoReady(long j) {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoStart() {
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.j != 2) {
            com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass2 anonymousClass2 = new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass2();
            if (android.text.TextUtils.isEmpty(this.e) || this.k) {
                com.qq.e.ads.rewardvideo.RewardVideoAD rewardVideoAD = new com.qq.e.ads.rewardvideo.RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1);
                this.a = rewardVideoAD;
                com.anythink.network.gdt.GDTATInitManager.getInstance();
                rewardVideoAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a(map));
            } else {
                this.a = new com.qq.e.ads.rewardvideo.RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1, this.e);
            }
            try {
                com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder builder = new com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder();
                builder.setUserId(this.mUserId);
                if (!android.text.TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                    this.mUserData = this.mUserData.replace(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.d);
                }
                builder.setCustomData(this.mUserData);
                com.qq.e.ads.rewardvideo.ServerSideVerificationOptions build = builder.build();
                if (build != null && com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("ServerSideVerificationOptions: userId:");
                    sb.append(build.getUserId());
                    sb.append("||userCustomData:");
                    sb.append(build.getCustomData());
                }
                this.a.setServerSideVerificationOptions(build);
            } catch (java.lang.Throwable unused) {
            }
            this.a.loadAD();
            return;
        }
        if (!(context instanceof android.app.Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass3 anonymousClass3 = new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass3();
        if (android.text.TextUtils.isEmpty(this.e) || this.k) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, this.d, anonymousClass3);
            this.b = unifiedInterstitialAD;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a(map));
        } else {
            this.b = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, this.d, anonymousClass3, null, this.e);
        }
        com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD2 = this.b;
        int parseInt = map.containsKey("video_muted") ? java.lang.Integer.parseInt(map.get("video_muted").toString()) : 0;
        int parseInt2 = map.containsKey("video_autoplay") ? java.lang.Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int parseInt3 = map.containsKey("video_duration") ? java.lang.Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD2 != null) {
            unifiedInterstitialAD2.setVideoOption(new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(parseInt == 1).setDetailPageMuted(parseInt == 1).setAutoPlayPolicy(parseInt2).build());
            if (parseInt3 != -1) {
                unifiedInterstitialAD2.setMaxVideoDuration(parseInt3);
            }
        }
        com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder builder2 = new com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder();
        if (!android.text.TextUtils.isEmpty(this.mUserId)) {
            builder2.setUserId(this.mUserId);
        }
        if (!android.text.TextUtils.isEmpty(this.mUserData)) {
            builder2.setCustomData(this.mUserData);
        }
        com.qq.e.ads.rewardvideo.ServerSideVerificationOptions build2 = builder2.build();
        if (build2 != null && com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("ServerSideVerificationOptions: userId:");
            sb2.append(build2.getUserId());
            sb2.append("||userCustomData:");
            sb2.append(build2.getCustomData());
        }
        this.b.setServerSideVerificationOptions(build2);
        this.b.setMediaListener(new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass4());
        this.b.loadFullScreenAD();
    }

    public static /* synthetic */ void a(com.anythink.network.gdt.GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter, android.content.Context context, java.util.Map map) {
        if (gDTATRewardedVideoAdapter.j != 2) {
            com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass2 anonymousClass2 = gDTATRewardedVideoAdapter.new AnonymousClass2();
            if (android.text.TextUtils.isEmpty(gDTATRewardedVideoAdapter.e) || gDTATRewardedVideoAdapter.k) {
                com.qq.e.ads.rewardvideo.RewardVideoAD rewardVideoAD = new com.qq.e.ads.rewardvideo.RewardVideoAD(context.getApplicationContext(), gDTATRewardedVideoAdapter.d, anonymousClass2, gDTATRewardedVideoAdapter.g != 1);
                gDTATRewardedVideoAdapter.a = rewardVideoAD;
                com.anythink.network.gdt.GDTATInitManager.getInstance();
                rewardVideoAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a((java.util.Map<java.lang.String, java.lang.Object>) map));
            } else {
                gDTATRewardedVideoAdapter.a = new com.qq.e.ads.rewardvideo.RewardVideoAD(context.getApplicationContext(), gDTATRewardedVideoAdapter.d, anonymousClass2, gDTATRewardedVideoAdapter.g != 1, gDTATRewardedVideoAdapter.e);
            }
            try {
                com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder builder = new com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder();
                builder.setUserId(gDTATRewardedVideoAdapter.mUserId);
                if (!android.text.TextUtils.isEmpty(gDTATRewardedVideoAdapter.mUserData) && gDTATRewardedVideoAdapter.mUserData.contains(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                    gDTATRewardedVideoAdapter.mUserData = gDTATRewardedVideoAdapter.mUserData.replace(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, gDTATRewardedVideoAdapter.d);
                }
                builder.setCustomData(gDTATRewardedVideoAdapter.mUserData);
                com.qq.e.ads.rewardvideo.ServerSideVerificationOptions build = builder.build();
                if (build != null && com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("ServerSideVerificationOptions: userId:");
                    sb.append(build.getUserId());
                    sb.append("||userCustomData:");
                    sb.append(build.getCustomData());
                }
                gDTATRewardedVideoAdapter.a.setServerSideVerificationOptions(build);
            } catch (java.lang.Throwable unused) {
            }
            gDTATRewardedVideoAdapter.a.loadAD();
            return;
        }
        if (!(context instanceof android.app.Activity)) {
            gDTATRewardedVideoAdapter.notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass3 anonymousClass3 = gDTATRewardedVideoAdapter.new AnonymousClass3();
        if (android.text.TextUtils.isEmpty(gDTATRewardedVideoAdapter.e) || gDTATRewardedVideoAdapter.k) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, gDTATRewardedVideoAdapter.d, anonymousClass3);
            gDTATRewardedVideoAdapter.b = unifiedInterstitialAD;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a((java.util.Map<java.lang.String, java.lang.Object>) map));
        } else {
            gDTATRewardedVideoAdapter.b = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, gDTATRewardedVideoAdapter.d, anonymousClass3, null, gDTATRewardedVideoAdapter.e);
        }
        com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD2 = gDTATRewardedVideoAdapter.b;
        int parseInt = map.containsKey("video_muted") ? java.lang.Integer.parseInt(map.get("video_muted").toString()) : 0;
        int parseInt2 = map.containsKey("video_autoplay") ? java.lang.Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int parseInt3 = map.containsKey("video_duration") ? java.lang.Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD2 != null) {
            unifiedInterstitialAD2.setVideoOption(new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(parseInt == 1).setDetailPageMuted(parseInt == 1).setAutoPlayPolicy(parseInt2).build());
            if (parseInt3 != -1) {
                unifiedInterstitialAD2.setMaxVideoDuration(parseInt3);
            }
        }
        com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder builder2 = new com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder();
        if (!android.text.TextUtils.isEmpty(gDTATRewardedVideoAdapter.mUserId)) {
            builder2.setUserId(gDTATRewardedVideoAdapter.mUserId);
        }
        if (!android.text.TextUtils.isEmpty(gDTATRewardedVideoAdapter.mUserData)) {
            builder2.setCustomData(gDTATRewardedVideoAdapter.mUserData);
        }
        com.qq.e.ads.rewardvideo.ServerSideVerificationOptions build2 = builder2.build();
        if (build2 != null && com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("ServerSideVerificationOptions: userId:");
            sb2.append(build2.getUserId());
            sb2.append("||userCustomData:");
            sb2.append(build2.getCustomData());
        }
        gDTATRewardedVideoAdapter.b.setServerSideVerificationOptions(build2);
        gDTATRewardedVideoAdapter.b.setMediaListener(gDTATRewardedVideoAdapter.new AnonymousClass4());
        gDTATRewardedVideoAdapter.b.loadFullScreenAD();
    }

    private static void a(com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD, java.util.Map<java.lang.String, java.lang.Object> map) {
        int parseInt = map.containsKey("video_muted") ? java.lang.Integer.parseInt(map.get("video_muted").toString()) : 0;
        int parseInt2 = map.containsKey("video_autoplay") ? java.lang.Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int parseInt3 = map.containsKey("video_duration") ? java.lang.Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(parseInt == 1).setDetailPageMuted(parseInt == 1).setAutoPlayPolicy(parseInt2).build());
            if (parseInt3 != -1) {
                unifiedInterstitialAD.setMaxVideoDuration(parseInt3);
            }
        }
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.d = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.g = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_muted", 0);
        this.j = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_type", 1);
        this.i = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
    }

    private void b(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass2 anonymousClass2 = new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass2();
        if (android.text.TextUtils.isEmpty(this.e) || this.k) {
            com.qq.e.ads.rewardvideo.RewardVideoAD rewardVideoAD = new com.qq.e.ads.rewardvideo.RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1);
            this.a = rewardVideoAD;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            rewardVideoAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a(map));
        } else {
            this.a = new com.qq.e.ads.rewardvideo.RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1, this.e);
        }
        try {
            com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder builder = new com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder();
            builder.setUserId(this.mUserId);
            if (!android.text.TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.mUserData = this.mUserData.replace(com.anythink.core.api.ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.d);
            }
            builder.setCustomData(this.mUserData);
            com.qq.e.ads.rewardvideo.ServerSideVerificationOptions build = builder.build();
            if (build != null && com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("ServerSideVerificationOptions: userId:");
                sb.append(build.getUserId());
                sb.append("||userCustomData:");
                sb.append(build.getCustomData());
            }
            this.a.setServerSideVerificationOptions(build);
        } catch (java.lang.Throwable unused) {
        }
        this.a.loadAD();
    }

    private void c(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (!(context instanceof android.app.Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass3 anonymousClass3 = new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass3();
        if (android.text.TextUtils.isEmpty(this.e) || this.k) {
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, this.d, anonymousClass3);
            this.b = unifiedInterstitialAD;
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(com.anythink.network.gdt.GDTATInitManager.a(map));
        } else {
            this.b = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD((android.app.Activity) context, this.d, anonymousClass3, null, this.e);
        }
        com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD2 = this.b;
        int parseInt = map.containsKey("video_muted") ? java.lang.Integer.parseInt(map.get("video_muted").toString()) : 0;
        int parseInt2 = map.containsKey("video_autoplay") ? java.lang.Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int parseInt3 = map.containsKey("video_duration") ? java.lang.Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD2 != null) {
            unifiedInterstitialAD2.setVideoOption(new com.qq.e.ads.cfg.VideoOption.Builder().setAutoPlayMuted(parseInt == 1).setDetailPageMuted(parseInt == 1).setAutoPlayPolicy(parseInt2).build());
            if (parseInt3 != -1) {
                unifiedInterstitialAD2.setMaxVideoDuration(parseInt3);
            }
        }
        com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder builder = new com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder();
        if (!android.text.TextUtils.isEmpty(this.mUserId)) {
            builder.setUserId(this.mUserId);
        }
        if (!android.text.TextUtils.isEmpty(this.mUserData)) {
            builder.setCustomData(this.mUserData);
        }
        com.qq.e.ads.rewardvideo.ServerSideVerificationOptions build = builder.build();
        if (build != null && com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("ServerSideVerificationOptions: userId:");
            sb.append(build.getUserId());
            sb.append("||userCustomData:");
            sb.append(build.getCustomData());
        }
        this.b.setServerSideVerificationOptions(build);
        this.b.setMediaListener(new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass4());
        this.b.loadFullScreenAD();
    }

    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.d = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        com.anythink.network.gdt.GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    public com.anythink.core.api.ATInitMediation getMediationInitManager() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance();
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.h;
    }

    public java.lang.String getNetworkName() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkName();
    }

    public java.lang.String getNetworkPlacementId() {
        return this.d;
    }

    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.gdt.GDTATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        com.qq.e.ads.rewardvideo.RewardVideoAD rewardVideoAD = this.a;
        if (rewardVideoAD != null) {
            return rewardVideoAD.isValid();
        }
        com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD = this.b;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.c = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        this.d = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "payload");
        this.g = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "video_muted", 0);
        this.j = com.anythink.core.api.ATInitMediation.getIntFromMap(map, "unit_type", 1);
        this.i = com.anythink.core.api.ATInitMediation.getBooleanFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (android.text.TextUtils.isEmpty(this.c) || android.text.TextUtils.isEmpty(this.d)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            com.anythink.network.gdt.GDTATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new com.anythink.network.gdt.GDTATRewardedVideoAdapter.AnonymousClass1(context, map));
        }
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    public void show(android.app.Activity activity) {
        if (this.a != null) {
            try {
                com.anythink.network.gdt.GDTATInitManager.getInstance().a(this.d, this.a);
                if (activity != null) {
                    this.a.showAD(activity);
                } else {
                    this.a.showAD();
                }
            } catch (java.lang.Throwable th) {
                com.anythink.network.gdt.GDTATInitManager.getInstance().a();
                th.printStackTrace();
            }
        }
        if (this.b != null) {
            try {
                com.anythink.network.gdt.GDTATInitManager.getInstance().a(this.d, this.b);
                this.b.showFullScreenAD(activity);
            } catch (java.lang.Throwable th2) {
                com.anythink.network.gdt.GDTATInitManager.getInstance().b();
                th2.printStackTrace();
            }
        }
    }

    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.k = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
