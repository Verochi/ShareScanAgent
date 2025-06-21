package com.alimm.tanx.core.ad.listener.reward;

/* loaded from: classes.dex */
public class TanxRewardRequest implements com.alimm.tanx.core.ad.listener.reward.ITanxCoreRewardRequest, com.alimm.tanx.core.utils.NotConfused {
    @Override // com.alimm.tanx.core.ad.listener.reward.ITanxRewardRequest
    public void queryRewards(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean, com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener iRewardRequestListener) {
        if (java.lang.System.currentTimeMillis() - com.alimm.tanx.core.request.tanxc_for.tanxc_if > com.alimm.tanx.core.request.tanxc_for.tanxc_do.longValue()) {
            queryRewards(rewardRequestBean, 3, null, iRewardRequestListener);
        } else {
            if (iRewardRequestListener != null) {
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.REWARD_QUERY_FREQUENCY_OVERRUN;
                iRewardRequestListener.onError(new com.alimm.tanx.core.request.TanxError("", utErrorCode.getIntCode(), utErrorCode.getMsg()));
            }
            com.alimm.tanx.core.utils.LogUtils.d("TanxRewardRequest", "主动查奖频控限制，放弃请求");
        }
        com.alimm.tanx.core.request.tanxc_for.tanxc_if = java.lang.System.currentTimeMillis();
    }

    @Override // com.alimm.tanx.core.ad.listener.reward.ITanxCoreRewardRequest
    public void queryRewards(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean, java.lang.Integer num, java.lang.String str, com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener iRewardRequestListener) {
        com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel rewardVideoAdModel = new com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel();
        if (rewardRequestBean != null) {
            rewardRequestBean.buildSessionId(num, str);
        }
        rewardVideoAdModel.sendRewardRequest(rewardRequestBean, iRewardRequestListener);
    }
}
