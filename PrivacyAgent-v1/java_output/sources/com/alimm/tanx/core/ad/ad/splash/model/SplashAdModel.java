package com.alimm.tanx.core.ad.ad.splash.model;

/* loaded from: classes.dex */
public class SplashAdModel extends com.alimm.tanx.core.ad.model.BaseModel implements com.alimm.tanx.core.ad.ad.template.rendering.splash.model.ISplashModel {
    private static final java.lang.String DEVICE_HEIGHT = "device_height";
    private static final int ERROR_NO_CACHE_LIST = -1000;
    private static final java.lang.String TAG = "SplashAdModel";
    private int fromType;
    private boolean isSyncReq;
    private int mLoadDataCode;
    private java.lang.String mRequestId = "";
    private final android.content.Context mContext = com.alimm.tanx.core.TanxCoreSdk.getApplication();

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.request.TanxAdSlot tanxc_if;

        public AnonymousClass1(com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot) {
            this.tanxc_do = iTanxRequestListener;
            this.tanxc_if = tanxAdSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.TAG, "开始获取本地缓存数据 ---" + currentTimeMillis);
            com.alimm.tanx.core.ad.bean.BidInfo chooseAd = com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.this.chooseAd(false);
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.TAG, "获取本地缓存数据结束 --- bidInfo= " + chooseAd + "------" + (java.lang.System.currentTimeMillis() - currentTimeMillis) + "  hasTimeOut=" + ((com.alimm.tanx.core.ad.model.BaseModel) com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.this).hasTimeOut);
            if (chooseAd == null) {
                if (((com.alimm.tanx.core.ad.model.BaseModel) com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.this).hasTimeOut) {
                    com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_do;
                    if (iTanxRequestListener != null) {
                        iTanxRequestListener.onError(new com.alimm.tanx.core.request.TanxError("timeout"));
                        return;
                    }
                    return;
                }
                com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.this.fromType = 1;
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.TAG, "获取本地缓存无缓存 开始走实时请求逻辑---------" + java.lang.System.currentTimeMillis());
                com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.super.sendRequest(this.tanxc_if, this.tanxc_do, 0L);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.common.AdTask.onErrorListener {
        final /* synthetic */ com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener tanxc_do;

        public AnonymousClass2(com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
            this.tanxc_do = iTanxRequestListener;
        }

        @Override // com.alimm.tanx.core.common.AdTask.onErrorListener
        public void onError(java.lang.String str) {
            this.tanxc_do.onError(new com.alimm.tanx.core.request.TanxError(str));
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getInstance().deleteCachedResponseJson();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.alimm.tanx.core.ad.bean.AdInfo tanxc_do;

        public AnonymousClass4(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
            this.tanxc_do = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.this.isSyncReq) {
                com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.this.cacheAdInfo(com.alibaba.fastjson.JSON.toJSONString(this.tanxc_do));
                com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getInstance().clearCachedAdvIds();
                if (this.tanxc_do != null) {
                    com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getInstance().setPreRequestId(this.tanxc_do.getRequestId());
                }
            }
            com.alimm.tanx.core.ad.ad.splash.tanxc_do.tanxc_do().tanxc_do(com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.this.mContext);
            com.alimm.tanx.core.ad.bean.AdInfo adInfo = this.tanxc_do;
            if (adInfo != null && adInfo.getBidInfoList() != null && this.tanxc_do.getBidInfoList().size() > 0) {
                java.util.Iterator<com.alimm.tanx.core.ad.bean.BidInfo> it = this.tanxc_do.getBidInfoList().iterator();
                while (it.hasNext()) {
                    com.alimm.tanx.core.ad.ad.splash.tanxc_do.tanxc_do().tanxc_do(com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.this.mContext, it.next().getCreativeName(), 0);
                }
            }
            com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getInstance().trimLocalCache();
            com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getInstance().downloadAdAsset(this.tanxc_do.getBidInfoList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheAdInfo(java.lang.String str) {
        com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot;
        try {
            if (!android.text.TextUtils.isEmpty(str) && (tanxAdSlot = this.adSlot) != null && !android.text.TextUtils.isEmpty(tanxAdSlot.getPid())) {
                java.lang.String splashAdResponseFile = com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getSplashAdResponseFile(this.mContext, this.adSlot.getPid());
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "cacheAdInfo fileName= " + splashAdResponseFile);
                com.alimm.tanx.core.utils.FileUtils.saveStr2File(splashAdResponseFile, str);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "cacheAdInfo error", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "cacheAdInfo error" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    private void cacheAndManageAsset(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        if (adInfo == null) {
            return;
        }
        com.alimm.tanx.core.common.tanxc_do.tanxc_do(new com.alimm.tanx.core.common.AdTask(new com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.AnonymousClass4(adInfo), "handleRequestResponse"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.alimm.tanx.core.ad.bean.BidInfo chooseAd(boolean z) {
        com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getInstance().trimLocalCache2Json();
        com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot = this.adSlot;
        com.alimm.tanx.core.ad.bean.AdInfo adInfoFromCache = getAdInfoFromCache(tanxAdSlot != null ? tanxAdSlot.getPid() : "");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("chooseAd: cold = ");
        sb.append(z);
        sb.append(", hasAdInfo = ");
        sb.append(adInfoFromCache != null);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, sb.toString());
        if (adInfoFromCache == null || adInfoFromCache.getAdCount() <= 0) {
            this.mLoadDataCode = com.alimm.tanx.core.ut.UtErrorCode.ERROR_NO_AD_ITEM.getIntCode();
            com.alimm.tanx.core.utils.LogUtils.e("chooseAd", "预请求无广告节点");
            return null;
        }
        this.mRequestId = adInfoFromCache.getRequestId();
        boolean z2 = false;
        for (com.alimm.tanx.core.ad.bean.BidInfo bidInfo : adInfoFromCache.getBidInfoList()) {
            com.alimm.tanx.core.ad.ad.splash.TanxSplashAd tanxSplashAd = new com.alimm.tanx.core.ad.ad.splash.TanxSplashAd(this.adSlot, bidInfo, adInfoFromCache.getRequestId(), 0, getScene());
            if (isDuringRelease(bidInfo)) {
                com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashJsonCheck(tanxSplashAd, 0, true, 0);
                if (isAssetExists(bidInfo)) {
                    com.alimm.tanx.core.utils.LogUtils.d(TAG, "chooseAd: isAssetExists bidInfo = " + bidInfo);
                    if (this.hasTimeOut) {
                        int intCode = com.alimm.tanx.core.ut.UtErrorCode.ERROR_AD_TIME_OUT.getIntCode();
                        this.mLoadDataCode = intCode;
                        com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashCacheExist(tanxSplashAd, 0, false, intCode);
                    } else {
                        cancel();
                        com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashTimer(tanxSplashAd, 0, true, 0);
                        com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.requestListener;
                        if (iTanxRequestListener != null) {
                            iTanxRequestListener.onSuccess(java.util.Arrays.asList(tanxSplashAd));
                        }
                        com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashCacheExist(tanxSplashAd, 0, true, 0);
                    }
                    return bidInfo;
                }
                z2 = true;
            } else {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "chooseAd: 不在投放期 bidInfo = " + bidInfo);
                int intCode2 = com.alimm.tanx.core.ut.UtErrorCode.ERROR_AD_NOT_IN_DURING_RELEASE.getIntCode();
                this.mLoadDataCode = intCode2;
                com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashJsonCheck(tanxSplashAd, 0, false, intCode2);
            }
        }
        if (z2) {
            this.mLoadDataCode = com.alimm.tanx.core.ut.UtErrorCode.ERROR_NO_CACHED_ASSET.getIntCode();
        } else {
            this.mLoadDataCode = com.alimm.tanx.core.ut.UtErrorCode.ERROR_NO_AD_DURING_RELEASE.getIntCode();
        }
        com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashCacheExist(new com.alimm.tanx.core.ad.ad.splash.TanxSplashAd(this.adSlot, null, adInfoFromCache.getRequestId(), 0, getScene()), 0, false, this.mLoadDataCode);
        return null;
    }

    private void deleteCachedAdInBackground() {
        com.alimm.tanx.core.common.tanxc_do.tanxc_do(new com.alimm.tanx.core.common.AdTask(new com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.AnonymousClass3(), "deleteCachedAdInBackground"));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.alimm.tanx.core.ad.bean.AdInfo getAdInfoFromCache(java.lang.String str) {
        boolean z;
        java.lang.Exception e;
        com.alimm.tanx.core.ad.bean.AdInfo adInfo;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.alimm.tanx.core.ad.bean.AdInfo adInfo2 = null;
        try {
            java.lang.String strFromFile = com.alimm.tanx.core.utils.FileUtils.getStrFromFile(com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getSplashAdResponseFile(this.mContext, str));
            if (android.text.TextUtils.isEmpty(strFromFile)) {
                z = false;
            } else {
                z = true;
                try {
                    adInfo = (com.alimm.tanx.core.ad.bean.AdInfo) com.alibaba.fastjson.JSON.parseObject(strFromFile, com.alimm.tanx.core.ad.bean.AdInfo.class);
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e = e;
                    adInfo = null;
                    com.alimm.tanx.core.utils.LogUtils.e(TAG, "getAdInfoFromCache exception.", e);
                    com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "getAdInfoFromCache exception." + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
                    adInfo2 = adInfo;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("getAdInfoFromCache: time = ");
                    sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
                    sb.append(",hasContent = ");
                    sb.append(z);
                    sb.append(", count = ");
                    sb.append(adInfo2 != null ? adInfo2.getAdCount() : 0);
                    com.alimm.tanx.core.utils.LogUtils.d(TAG, sb.toString());
                    return adInfo2;
                }
                try {
                    adInfo2 = com.alimm.tanx.core.request.tanxc_do.tanxc_do(adInfo);
                } catch (java.lang.Exception e3) {
                    e = e3;
                    com.alimm.tanx.core.utils.LogUtils.e(TAG, "getAdInfoFromCache exception.", e);
                    com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "getAdInfoFromCache exception." + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
                    adInfo2 = adInfo;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("getAdInfoFromCache: time = ");
                    sb2.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
                    sb2.append(",hasContent = ");
                    sb2.append(z);
                    sb2.append(", count = ");
                    sb2.append(adInfo2 != null ? adInfo2.getAdCount() : 0);
                    com.alimm.tanx.core.utils.LogUtils.d(TAG, sb2.toString());
                    return adInfo2;
                }
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            z = false;
        }
        java.lang.StringBuilder sb22 = new java.lang.StringBuilder();
        sb22.append("getAdInfoFromCache: time = ");
        sb22.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
        sb22.append(",hasContent = ");
        sb22.append(z);
        sb22.append(", count = ");
        sb22.append(adInfo2 != null ? adInfo2.getAdCount() : 0);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, sb22.toString());
        return adInfo2;
    }

    private void handleRequestResponse(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "handleRequestCallback: adInfo = " + adInfo + "");
        if (this.isSyncReq && !this.hasTimeOut) {
            if (adInfo != null && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
                if (adInfo.getSeatList().get(0) != null && adInfo.getSeatList().get(0).getBidList() != null && adInfo.getSeatList().get(0).getBidList().size() > 0) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                        java.util.List<com.alimm.tanx.core.ad.bean.BidInfo> bidList = adInfo.getSeatList().get(i).getBidList();
                        if (bidList != null && bidList.size() > 0) {
                            for (com.alimm.tanx.core.ad.bean.BidInfo bidInfo : bidList) {
                                com.alimm.tanx.core.utils.LogUtils.d(TAG, "handleRequestCallback: bidInfo = " + bidInfo + "");
                                if (bidInfo != null) {
                                    com.alimm.tanx.core.utils.LogUtils.d(TAG, "handleRequestCallback: 素材地址 = " + bidInfo.getCreativePath() + "");
                                }
                                arrayList.add(new com.alimm.tanx.core.ad.ad.splash.TanxSplashAd(this.adSlot, bidInfo, adInfo.getRequestId(), 1, getScene()));
                            }
                        }
                    }
                    this.requestListener.onSuccess(arrayList);
                }
            }
            this.requestListener.onError(new com.alimm.tanx.core.request.TanxError(adInfo != null ? adInfo.getRequestId() : "", com.alimm.tanx.core.request.TanxError.ERROR_ADINFO_ADCOUNT_NULL));
        }
        cacheAndManageAsset(adInfo);
    }

    private boolean isAssetExists(@androidx.annotation.NonNull com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
        return com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getInstance().isAssetCached(bidInfo, true);
    }

    private boolean isDuringRelease(@androidx.annotation.NonNull com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
        long currentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        return bidInfo.getReleaseStartTime() <= currentTimeMillis && bidInfo.getReleaseEndTime() >= currentTimeMillis;
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public java.lang.String getScene() {
        return "screen";
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void onSuccess(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        handleRequestResponse(adInfo);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void requestSucc(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        if (this.isCancel) {
            return;
        }
        checkSuccess(adInfo);
        cancel();
        timerCancelNotify(adInfo, true, 0);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.model.ISplashModel
    public void sendRequest(boolean z, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(z, tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.model.ISplashModel
    public void sendRequest(boolean z, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j) {
        this.adSlot = tanxAdSlot;
        this.isSyncReq = z;
        this.requestListener = iTanxRequestListener;
        if (z) {
            startTimer(j);
            com.alimm.tanx.core.common.tanxc_do.tanxc_do(new com.alimm.tanx.core.common.AdTask(new com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.AnonymousClass1(iTanxRequestListener, tanxAdSlot), "sendRequest", new com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.AnonymousClass2(iTanxRequestListener)));
            return;
        }
        super.sendRequest(tanxAdSlot, iTanxRequestListener, j);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "发起预请求 timeOut=" + j);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void timerCancelNotify(com.alimm.tanx.core.ad.bean.AdInfo adInfo, boolean z, int i) {
        com.alimm.tanx.core.ad.ad.splash.TanxSplashAd tanxSplashAd = null;
        r0 = null;
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = null;
        if (adInfo != null) {
            if (adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
                bidInfo = adInfo.getBidInfoList().get(0);
            }
            tanxSplashAd = new com.alimm.tanx.core.ad.ad.splash.TanxSplashAd(this.adSlot, bidInfo, adInfo.getRequestId(), 0, getScene());
        }
        com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashTimer(tanxSplashAd, this.fromType, z, i);
    }
}
