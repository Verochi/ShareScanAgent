package com.alimm.tanx.core.ad.ad.reward.model;

/* loaded from: classes.dex */
public class RewardVideoAdModel extends com.alimm.tanx.core.ad.model.BaseModel {

    /* renamed from: com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener {
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
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.tanxc_do, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_REWARD_VIDEO, "error", java.lang.System.currentTimeMillis() - this.tanxc_if);
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_for;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onError(tanxError);
            }
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onSuccess(java.util.List list) {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.tanxc_do, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_REWARD_VIDEO, "success", java.lang.System.currentTimeMillis() - this.tanxc_if);
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_for;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onSuccess(list);
            }
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onTimeOut() {
            com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodCallback(this.tanxc_do, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_REWARD_VIDEO, com.alimm.tanx.core.ut.impl.TanxInterfaceUt.CALLBACK_TIMEOUT, java.lang.System.currentTimeMillis() - this.tanxc_if);
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_for;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onTimeOut();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.RewardResponse> {
        final /* synthetic */ com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener tanxc_do;

        public AnonymousClass2(com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener iRewardRequestListener) {
            this.tanxc_do = iRewardRequestListener;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            this.tanxc_do.onError(new com.alimm.tanx.core.request.TanxError(str, i, str2));
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void succ(com.alimm.tanx.core.ad.bean.RewardResponse rewardResponse) {
            com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel.this.loopReward(rewardResponse, this.tanxc_do);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loopReward(com.alimm.tanx.core.ad.bean.RewardResponse rewardResponse, com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener iRewardRequestListener) {
        if (iRewardRequestListener != null) {
            try {
                if (rewardResponse == null) {
                    java.lang.String requestId = rewardResponse != null ? rewardResponse.getRequestId() : "";
                    com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.ERROR_QUERY_REWARD;
                    iRewardRequestListener.onError(new com.alimm.tanx.core.request.TanxError(requestId, utErrorCode.getIntCode(), utErrorCode.getMsg()));
                    return;
                }
                if (rewardResponse.getPidRewards() == null || rewardResponse.getPidRewards().size() <= 0) {
                    java.lang.String requestId2 = rewardResponse.getRequestId();
                    com.alimm.tanx.core.ut.UtErrorCode utErrorCode2 = com.alimm.tanx.core.ut.UtErrorCode.REWARD_QUERY_NULL;
                    iRewardRequestListener.onError(new com.alimm.tanx.core.request.TanxError(requestId2, utErrorCode2.getIntCode(), utErrorCode2.getMsg()));
                    return;
                }
                for (int i = 0; i < rewardResponse.getPidRewards().size(); i++) {
                    com.alimm.tanx.core.ad.bean.RewardResponse.PidRewards pidRewards = rewardResponse.getPidRewards().get(i);
                    int i2 = pidRewards.getTaskType() == 3 ? 1 : 0;
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put("pid", pidRewards.getPid());
                    hashMap.put("taskType", java.lang.Integer.valueOf(pidRewards.getTaskType()));
                    hashMap.put("sessionId", pidRewards.getSessionId());
                    hashMap.put("completeTime", pidRewards.getCompleteTime());
                    hashMap.put("rewardName", pidRewards.getRewardName());
                    hashMap.put("rewardCount", java.lang.Integer.valueOf(pidRewards.getRewardCount()));
                    iRewardRequestListener.onRewardArrived(true, i2, hashMap);
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("loopReward", e);
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public java.lang.String getScene() {
        return "rewardVideo";
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void onSuccess(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        if (this.requestListener == null) {
            return;
        }
        if (adInfo != null && !android.text.TextUtils.isEmpty(adInfo.getRequestId()) && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
            if (adInfo.getSeatList().get(0) != null && adInfo.getSeatList().get(0).getBidList() != null && adInfo.getSeatList().get(0).getBidList().size() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                    java.util.List<com.alimm.tanx.core.ad.bean.BidInfo> bidList = adInfo.getSeatList().get(i).getBidList();
                    if (bidList != null && bidList.size() > 0) {
                        java.util.Iterator<com.alimm.tanx.core.ad.bean.BidInfo> it = bidList.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new com.alimm.tanx.core.ad.ad.reward.tanxc_do(this.adSlot, it.next(), adInfo.getRequestId(), getScene()));
                        }
                    }
                }
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
        com.alimm.tanx.core.ut.impl.TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), com.alimm.tanx.core.ut.impl.TanxInterfaceUt.REQUEST_REWARD_VIDEO);
        super.sendRequest(tanxAdSlot, new com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel.AnonymousClass1(tanxAdSlot, currentTimeMillis, iTanxRequestListener), j);
    }

    public void sendRewardRequest(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean, com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener iRewardRequestListener) {
        new com.alimm.tanx.core.request.RewardRequest().request(rewardRequestBean, (com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.RewardResponse>) new com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel.AnonymousClass2(iRewardRequestListener));
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void timerCancelNotify(com.alimm.tanx.core.ad.bean.AdInfo adInfo, boolean z, int i) {
        com.alimm.tanx.core.ad.ad.reward.tanxc_do tanxc_doVar = null;
        r0 = null;
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = null;
        if (adInfo != null) {
            if (adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
                bidInfo = adInfo.getBidInfoList().get(0);
            }
            tanxc_doVar = new com.alimm.tanx.core.ad.ad.reward.tanxc_do(this.adSlot, bidInfo, adInfo.getRequestId(), getScene());
        }
        com.alimm.tanx.core.ut.impl.TanxCommonUt.utTimer(tanxc_doVar, z, i);
    }
}
