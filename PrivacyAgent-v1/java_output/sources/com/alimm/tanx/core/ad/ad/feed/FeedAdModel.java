package com.alimm.tanx.core.ad.ad.feed;

/* loaded from: classes.dex */
public class FeedAdModel extends com.alimm.tanx.core.ad.model.BaseModel {

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedAdModel$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener<com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd> {
        final /* synthetic */ com.alimm.tanx.core.request.TanxAdSlot tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener tanxc_for;
        final /* synthetic */ long tanxc_if;

        public AnonymousClass1(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, long j, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
            this.tanxc_do = tanxAdSlot;
            this.tanxc_if = j;
            this.tanxc_for = iTanxRequestListener;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onError(com.alimm.tanx.core.request.TanxError tanxError) {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.tanxc_do, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_FEED, "error", java.lang.System.currentTimeMillis() - this.tanxc_if);
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_for;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onError(tanxError);
            }
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onSuccess(java.util.List<com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd> list) {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.tanxc_do, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_FEED, "success", java.lang.System.currentTimeMillis() - this.tanxc_if);
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_for;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onSuccess(list);
            }
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onTimeOut() {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.tanxc_do, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_FEED, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.CALLBACK_TIMEOUT, java.lang.System.currentTimeMillis() - this.tanxc_if);
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_for;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onTimeOut();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.FeedAdModel$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.view.player.cache.videocache.PreloadListener {
        final /* synthetic */ com.alimm.tanx.core.ad.ITanxAd tanxc_do;

        public AnonymousClass2(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
            this.tanxc_do = iTanxAd;
        }

        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
        public void onCached(java.lang.String str) {
            com.alimm.tanx.core.ut.impl.TanxCommonUt.cacheCheck(this.tanxc_do, str, 0, null);
        }

        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
        public void onError(java.lang.String str, java.lang.Exception exc) {
            com.alimm.tanx.core.ut.impl.TanxCommonUt.cacheCheck(this.tanxc_do, str, 1, exc);
        }

        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
        public void onStartCached(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        }
    }

    private void preload(java.util.List<com.alimm.tanx.core.ad.ad.feed.tanxc_do> list, boolean z) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i));
            }
            if (list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    com.alimm.tanx.core.ad.ad.feed.tanxc_do tanxc_doVar = list.get(i2);
                    com.alimm.tanx.core.utils.VideoCacheManager.getInstance().preload(tanxc_doVar, z, new com.alimm.tanx.core.ad.ad.feed.FeedAdModel.AnonymousClass2(tanxc_doVar));
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    private com.alimm.tanx.core.ad.bean.BidInfo updateData(com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
        try {
            if (bidInfo.getTemplateConf() != null && !android.text.TextUtils.isEmpty(bidInfo.getTemplateConf().getRenderUrl()) && !android.text.TextUtils.isEmpty(bidInfo.getSubMaterials())) {
                java.lang.String renderUrl = bidInfo.getTemplateConf().getRenderUrl();
                java.lang.StringBuilder sb = new java.lang.StringBuilder("?");
                java.util.Map map = (java.util.Map) com.alibaba.fastjson.JSON.parse(bidInfo.getSubMaterials());
                if (map != null) {
                    for (java.util.Map.Entry entry : map.entrySet()) {
                        java.lang.String str = (java.lang.String) entry.getKey();
                        java.lang.String str2 = (java.lang.String) entry.getValue();
                        sb.append(str);
                        sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(str2);
                        sb.append("&");
                    }
                    if (sb.toString().length() >= 2) {
                        java.lang.String sb2 = sb.toString();
                        if (sb2.substring(sb2.length() - 1, sb2.length()).equals("&")) {
                            sb2 = sb2.substring(0, sb2.length() - 1);
                        }
                        bidInfo.getTemplateConf().setRenderUrl(renderUrl + sb2);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
        return bidInfo;
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public java.lang.String getScene() {
        return com.alimm.tanx.core.constant.TanxAdType.FEED_STRING;
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void onSuccess(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        if (this.requestListener == null) {
            return;
        }
        if (adInfo != null && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
            boolean z = false;
            if (adInfo.getSeatList().get(0) != null && adInfo.getSeatList().get(0).getBidList() != null && adInfo.getSeatList().get(0).getBidList().size() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                    java.util.List<com.alimm.tanx.core.ad.bean.BidInfo> bidList = adInfo.getSeatList().get(i).getBidList();
                    if (bidList != null && bidList.size() > 0) {
                        java.util.Iterator<com.alimm.tanx.core.ad.bean.BidInfo> it = bidList.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new com.alimm.tanx.core.ad.ad.feed.tanxc_do(this.adSlot, updateData(it.next()), adInfo.getRequestId(), getScene()));
                        }
                    }
                }
                com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot = this.adSlot;
                if (tanxAdSlot != null && tanxAdSlot.isCacheUnderWifi()) {
                    z = true;
                }
                preload(arrayList, z);
                this.requestListener.onSuccess(arrayList);
                return;
            }
        }
        this.requestListener.onError(new com.alimm.tanx.core.request.TanxError(adInfo != null ? adInfo.getRequestId() : "", com.alimm.tanx.core.request.TanxError.ERROR_ADINFO_ADCOUNT_NULL));
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_FEED);
        super.sendRequest(tanxAdSlot, new com.alimm.tanx.core.ad.ad.feed.FeedAdModel.AnonymousClass1(tanxAdSlot, currentTimeMillis, iTanxRequestListener), j);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void timerCancelNotify(com.alimm.tanx.core.ad.bean.AdInfo adInfo, boolean z, int i) {
    }
}
