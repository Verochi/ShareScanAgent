package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class AdRequest extends com.alimm.tanx.core.request.tanxc_if<com.alimm.tanx.core.request.AdRequestBean, com.alimm.tanx.core.ad.bean.AdInfo> implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "AdRequest";

    /* renamed from: com.alimm.tanx.core.request.AdRequest$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.callback.AdNetWorkCallBack<com.alimm.tanx.core.ad.bean.AdInfo> {
        final /* synthetic */ com.alimm.tanx.core.net.callback.NetWorkCallBack tanxc_do;
        final /* synthetic */ long tanxc_for;
        final /* synthetic */ com.alimm.tanx.core.request.AdRequestBean tanxc_if;
        final /* synthetic */ com.alimm.tanx.core.net.bean.RequestBean tanxc_int;

        public AnonymousClass1(com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack, com.alimm.tanx.core.request.AdRequestBean adRequestBean, long j, com.alimm.tanx.core.net.bean.RequestBean requestBean) {
            this.tanxc_do = netWorkCallBack;
            this.tanxc_if = adRequestBean;
            this.tanxc_for = j;
            this.tanxc_int = requestBean;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack = this.tanxc_do;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i, str, str2);
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendAdRqFail(com.alimm.tanx.core.request.AdRequest.this.getScene(this.tanxc_if), com.alimm.tanx.core.request.AdRequest.this.getPid(this.tanxc_if), com.alimm.tanx.core.request.AdRequest.this.getReqId(this.tanxc_if), android.os.SystemClock.elapsedRealtime() - this.tanxc_for, i, str2, com.alimm.tanx.core.request.AdRequest.this.getReqJson(this.tanxc_int));
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void succ(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
            com.alimm.tanx.core.request.AdRequest adRequest = com.alimm.tanx.core.request.AdRequest.this;
            adRequest.suc(adInfo, "", adRequest.getReqJson(this.tanxc_int), this.tanxc_for, com.alimm.tanx.core.request.AdRequest.this.getAdSlot(this.tanxc_if), com.alimm.tanx.core.request.AdRequest.this.getScene(this.tanxc_if), com.alimm.tanx.core.request.AdRequest.this.getReqId(this.tanxc_if), this.tanxc_do);
        }

        @Override // com.alimm.tanx.core.net.callback.AdNetWorkCallBack
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void succ(com.alimm.tanx.core.ad.bean.AdInfo adInfo, java.lang.String str) {
            com.alimm.tanx.core.request.AdRequest adRequest = com.alimm.tanx.core.request.AdRequest.this;
            adRequest.suc(adInfo, str, adRequest.getReqJson(this.tanxc_int), this.tanxc_for, com.alimm.tanx.core.request.AdRequest.this.getAdSlot(this.tanxc_if), com.alimm.tanx.core.request.AdRequest.this.getScene(this.tanxc_if), com.alimm.tanx.core.request.AdRequest.this.getReqId(this.tanxc_if), this.tanxc_do);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.alimm.tanx.core.request.TanxAdSlot getAdSlot(com.alimm.tanx.core.request.AdRequestBean adRequestBean) {
        com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot;
        if (adRequestBean == null || (tanxAdSlot = adRequestBean.tanxAdSlot) == null) {
            return null;
        }
        return tanxAdSlot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getPid(com.alimm.tanx.core.request.AdRequestBean adRequestBean) {
        return getAdSlot(adRequestBean) != null ? getAdSlot(adRequestBean).getPid() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getReqId(com.alimm.tanx.core.request.AdRequestBean adRequestBean) {
        return adRequestBean != null ? adRequestBean.id : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getReqJson(com.alimm.tanx.core.net.bean.RequestBean requestBean) {
        return (requestBean == null || requestBean.getJson() == null) ? "" : requestBean.getJson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getScene(com.alimm.tanx.core.request.AdRequestBean adRequestBean) {
        com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot;
        return (adRequestBean == null || (tanxAdSlot = adRequestBean.tanxAdSlot) == null) ? "未知" : com.alimm.tanx.core.constant.TanxAdType.getAdTypeStr(tanxAdSlot.getAdType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void suc(com.alimm.tanx.core.ad.bean.AdInfo adInfo, java.lang.String str, java.lang.String str2, long j, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str3, java.lang.String str4, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.AdInfo> netWorkCallBack) {
        if (netWorkCallBack != null) {
            if (adInfo == null) {
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.DATA_PARSE_ERROR;
                netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), str4, android.os.SystemClock.elapsedRealtime() - j, utErrorCode.getIntCode(), utErrorCode.getMsg(), str2);
            } else if (adInfo.getStatus() == 0) {
                adInfo.setDecrypt(str);
                netWorkCallBack.succ(com.alimm.tanx.core.request.tanxc_do.tanxc_do(adInfo));
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendAdRqSuc(str3, tanxAdSlot, adInfo.getRequestId(), android.os.SystemClock.elapsedRealtime() - j, adInfo.getAdCount(), adInfo);
            } else {
                int status = adInfo.getStatus();
                java.lang.String msg = status == 1 ? com.alimm.tanx.core.ut.UtErrorCode.SERVER_RETURN_1.getMsg() : com.alimm.tanx.core.ut.UtErrorCode.SERVER_RETURN_ERROR.getMsg();
                netWorkCallBack.error(status, adInfo.getRequestId(), msg);
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), str4, android.os.SystemClock.elapsedRealtime() - j, status, msg, str2);
            }
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public com.alimm.tanx.core.net.bean.RequestBean buildRequestBean(com.alimm.tanx.core.request.AdRequestBean adRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.AdInfo> netWorkCallBack) {
        try {
            com.alimm.tanx.core.net.bean.RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(com.alimm.tanx.core.request.C.getAdUrl());
            com.alimm.tanx.core.request.AdRequestBean adRequestBean2 = (com.alimm.tanx.core.request.AdRequestBean) super.buildBaseRequestBeanData(adRequestBean);
            adRequestBean2.imp = new java.util.ArrayList();
            int i = 1;
            int max = java.lang.Math.max(adRequestBean2.tanxAdSlot.getAdCount(), 1);
            if (adRequestBean2.tanxAdSlot.getAdCount() > 10) {
                max = 10;
            }
            for (int i2 = 0; i2 < max; i2++) {
                com.alimm.tanx.core.request.AdRequestBean.AdImpBean adImpBean = new com.alimm.tanx.core.request.AdRequestBean.AdImpBean();
                adImpBean.pid = adRequestBean2.tanxAdSlot.getPid();
                adImpBean.native_template_id = adRequestBean2.tanxAdSlot.getNativeTemplateId();
                adImpBean.slot_num = 1;
                adImpBean.id = java.lang.String.valueOf(i2);
                adRequestBean2.imp.add(adImpBean);
            }
            if (adRequestBean2.user == null) {
                adRequestBean2.user = new com.alimm.tanx.core.request.AdRequestBean.AdUserBean();
            }
            adRequestBean2.user.user_tag = com.alimm.tanx.core.TanxCoreSdk.getConfig().getUserTag();
            adRequestBean2.user.media_uid = adRequestBean2.tanxAdSlot.getMediaUid();
            adRequestBean2.ext = adRequestBean2.tanxAdSlot.getExt();
            adRequestBean2.https_required = true;
            adRequestBean2.version = 1;
            if (!adRequestBean2.tanxAdSlot.isExpressRender()) {
                i = 2;
            }
            adRequestBean2.render_type = i;
            java.lang.String jSONString = com.alibaba.fastjson.JSON.toJSONString(adRequestBean2);
            com.alimm.tanx.core.utils.LogUtils.d(TAG, jSONString);
            buildBaseRequestBeanUrl.setJson(jSONString);
            return buildBaseRequestBeanUrl;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
            return null;
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkDeviceId(com.alimm.tanx.core.request.AdRequestBean adRequestBean) {
        com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean adDeviceBean;
        if (adRequestBean == null || (adDeviceBean = adRequestBean.device) == null) {
            return false;
        }
        return (android.text.TextUtils.isEmpty(adDeviceBean.imei) && android.text.TextUtils.isEmpty(adRequestBean.device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkInitData(com.alimm.tanx.core.request.AdRequestBean adRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.AdInfo> netWorkCallBack) {
        com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot;
        if (adRequestBean == null || (tanxAdSlot = adRequestBean.tanxAdSlot) == null) {
            com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.REQUEST_BEAN_ERROR;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg() + " :adRequestBean");
            return false;
        }
        if (android.text.TextUtils.isEmpty(tanxAdSlot.getPid())) {
            com.alimm.tanx.core.ut.UtErrorCode utErrorCode2 = com.alimm.tanx.core.ut.UtErrorCode.PID_NULL;
            netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
            return false;
        }
        if (!android.text.TextUtils.isEmpty(adRequestBean.tanxAdSlot.getMediaUid())) {
            return true;
        }
        if (adRequestBean.tanxAdSlot.getAdType() != 4 && adRequestBean.tanxAdSlot.getAdType() != 3) {
            return true;
        }
        com.alimm.tanx.core.ut.UtErrorCode utErrorCode3 = com.alimm.tanx.core.ut.UtErrorCode.MEDIA_UID_NULL;
        netWorkCallBack.error(utErrorCode3.getIntCode(), "", utErrorCode3.getMsg());
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkRequestBefore(com.alimm.tanx.core.request.AdRequestBean adRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.AdInfo> netWorkCallBack) {
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void request(com.alimm.tanx.core.request.AdRequestBean adRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.AdInfo> netWorkCallBack) {
        super.request((com.alimm.tanx.core.request.AdRequest) adRequestBean, (com.alimm.tanx.core.net.callback.NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void sendRequest(com.alimm.tanx.core.request.AdRequestBean adRequestBean, com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.AdInfo> netWorkCallBack) {
        com.alimm.tanx.core.net.NetWorkManager.getInstance().sendHttpPost(requestBean, com.alimm.tanx.core.ad.bean.AdInfo.class, new com.alimm.tanx.core.request.AdRequest.AnonymousClass1(netWorkCallBack, adRequestBean, android.os.SystemClock.elapsedRealtime(), requestBean));
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean useDeviceIdCache() {
        return false;
    }
}
