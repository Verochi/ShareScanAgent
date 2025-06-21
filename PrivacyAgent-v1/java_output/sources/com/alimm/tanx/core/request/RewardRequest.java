package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class RewardRequest extends com.alimm.tanx.core.request.tanxc_if<com.alimm.tanx.core.ad.bean.RewardRequestBean, com.alimm.tanx.core.ad.bean.RewardResponse> implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "RewardRequest";

    /* renamed from: com.alimm.tanx.core.request.RewardRequest$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.RewardResponse> {
        final /* synthetic */ com.alimm.tanx.core.net.callback.NetWorkCallBack tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.net.bean.RequestBean tanxc_for;
        final /* synthetic */ long tanxc_if;
        final /* synthetic */ com.alimm.tanx.core.ad.bean.RewardRequestBean tanxc_int;

        public AnonymousClass1(com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack, long j, com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean) {
            this.tanxc_do = netWorkCallBack;
            this.tanxc_if = j;
            this.tanxc_for = requestBean;
            this.tanxc_int = rewardRequestBean;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack = this.tanxc_do;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i, str, str2);
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.tanxc_if;
                com.alimm.tanx.core.net.bean.RequestBean requestBean = this.tanxc_for;
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendRewardRqFail(str, elapsedRealtime, i, str2, requestBean == null ? "" : requestBean.getJson());
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void succ(com.alimm.tanx.core.ad.bean.RewardResponse rewardResponse) {
            java.lang.Integer triggerEvent = com.alimm.tanx.core.request.RewardRequest.this.getTriggerEvent(this.tanxc_int);
            com.alimm.tanx.core.net.bean.RequestBean requestBean = this.tanxc_for;
            com.alimm.tanx.core.request.RewardRequest.suc(rewardResponse, triggerEvent, requestBean == null ? "" : requestBean.getJson(), this.tanxc_if, this.tanxc_do);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.Integer getTriggerEvent(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean) {
        if (rewardRequestBean != null) {
            return rewardRequestBean.trigger_event;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void suc(com.alimm.tanx.core.ad.bean.RewardResponse rewardResponse, java.lang.Integer num, java.lang.String str, long j, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.RewardResponse> netWorkCallBack) {
        if (netWorkCallBack != null) {
            if (rewardResponse == null) {
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.DATA_PARSE_ERROR;
                netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendRewardRqFail(rewardResponse.getRequestId(), android.os.SystemClock.elapsedRealtime() - j, utErrorCode.getIntCode(), "RewardResponse解析为空", str);
                return;
            }
            if (rewardResponse.getStatus() != 1) {
                if (rewardResponse.getStatus() == 0) {
                    netWorkCallBack.succ(rewardResponse);
                    com.alimm.tanx.core.ut.impl.TanxCommonUt.sendRewardRqSuc(rewardResponse.getRequestId(), android.os.SystemClock.elapsedRealtime() - j, rewardResponse);
                    return;
                } else {
                    int status = rewardResponse.getStatus();
                    netWorkCallBack.error(status, rewardResponse.getRequestId(), "查询服务端错误码信息");
                    com.alimm.tanx.core.ut.impl.TanxCommonUt.sendRewardRqFail(rewardResponse.getRequestId(), android.os.SystemClock.elapsedRealtime() - j, status, "查询服务端错误码信息", str);
                    return;
                }
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "loopReward过程状态码为1");
            if (num != null) {
                if (num.intValue() == 1 || num.intValue() == 3) {
                    com.alimm.tanx.core.ut.UtErrorCode utErrorCode2 = com.alimm.tanx.core.ut.UtErrorCode.REWARD_QUERY_NULL;
                    netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg() + ",server_code:1");
                }
            }
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public com.alimm.tanx.core.net.bean.RequestBean buildRequestBean(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.RewardResponse> netWorkCallBack) {
        com.alimm.tanx.core.net.bean.RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(com.alimm.tanx.core.request.C.getRewardUrl());
        java.lang.String jSONString = com.alibaba.fastjson.JSON.toJSONString(super.buildBaseRequestBeanData(rewardRequestBean));
        com.alimm.tanx.core.utils.LogUtils.d(TAG, jSONString);
        buildBaseRequestBeanUrl.setJson(jSONString);
        return buildBaseRequestBeanUrl;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkDeviceId(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean) {
        com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean adDeviceBean;
        if (rewardRequestBean == null || (adDeviceBean = rewardRequestBean.device) == null) {
            return false;
        }
        return (android.text.TextUtils.isEmpty(adDeviceBean.imei) && android.text.TextUtils.isEmpty(rewardRequestBean.device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkInitData(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.RewardResponse> netWorkCallBack) {
        com.alimm.tanx.core.ad.bean.RewardRequestBean.RewardUserBean rewardUserBean;
        if (rewardRequestBean == null || (rewardUserBean = rewardRequestBean.user) == null || checkStrNull(rewardUserBean.media_uid)) {
            com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.MEDIA_UID_NULL;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        } else {
            java.util.List<com.alimm.tanx.core.ad.bean.RewardRequestBean.PidVerifications> list = rewardRequestBean.task_check;
            if (list == null || list.size() <= 0) {
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode2 = com.alimm.tanx.core.ut.UtErrorCode.PID_NULL;
                netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
                return false;
            }
            for (int i = 0; i < rewardRequestBean.task_check.size(); i++) {
                if (rewardRequestBean.task_check.get(i) == null || android.text.TextUtils.isEmpty(rewardRequestBean.task_check.get(i).pid)) {
                    com.alimm.tanx.core.ut.UtErrorCode utErrorCode3 = com.alimm.tanx.core.ut.UtErrorCode.PID_NULL;
                    netWorkCallBack.error(utErrorCode3.getIntCode(), "", utErrorCode3.getMsg());
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkRequestBefore(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.RewardResponse> netWorkCallBack) {
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void request(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.RewardResponse> netWorkCallBack) {
        super.request((com.alimm.tanx.core.request.RewardRequest) rewardRequestBean, (com.alimm.tanx.core.net.callback.NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void sendRequest(com.alimm.tanx.core.ad.bean.RewardRequestBean rewardRequestBean, com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.RewardResponse> netWorkCallBack) {
        com.alimm.tanx.core.net.NetWorkManager.getInstance().sendHttpPost(requestBean, com.alimm.tanx.core.ad.bean.RewardResponse.class, new com.alimm.tanx.core.request.RewardRequest.AnonymousClass1(netWorkCallBack, android.os.SystemClock.elapsedRealtime(), requestBean, rewardRequestBean));
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean useDeviceIdCache() {
        return false;
    }
}
