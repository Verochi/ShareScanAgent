package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class ConfigRequest extends com.alimm.tanx.core.request.tanxc_if<com.alimm.tanx.core.ad.bean.ConfigRequestBean, com.alimm.tanx.core.orange.bean.TanxConfigTableV2> implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "ConfigRequest";

    /* renamed from: com.alimm.tanx.core.request.ConfigRequest$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.ConfigResponseBean> {
        final /* synthetic */ com.alimm.tanx.core.net.callback.NetWorkCallBack tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.net.bean.RequestBean tanxc_for;
        final /* synthetic */ long tanxc_if;

        public AnonymousClass1(com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack, long j, com.alimm.tanx.core.net.bean.RequestBean requestBean) {
            this.tanxc_do = netWorkCallBack;
            this.tanxc_if = j;
            this.tanxc_for = requestBean;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack = this.tanxc_do;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i, str, str2);
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail(str, android.os.SystemClock.elapsedRealtime() - this.tanxc_if, i, str2, com.alimm.tanx.core.request.ConfigRequest.this.getReqJson(this.tanxc_for));
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void succ(com.alimm.tanx.core.ad.bean.ConfigResponseBean configResponseBean) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.request.ConfigRequest.TAG, "配置请求成功:" + com.alimm.tanx.core.utils.EncryptUtils.decrypt(configResponseBean.content));
            com.alimm.tanx.core.request.ConfigRequest.suc(configResponseBean, "", com.alimm.tanx.core.request.ConfigRequest.this.getReqJson(this.tanxc_for), this.tanxc_if, this.tanxc_do);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getReqJson(com.alimm.tanx.core.net.bean.RequestBean requestBean) {
        return (requestBean == null || requestBean.getJson() == null) ? "" : requestBean.getJson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void suc(com.alimm.tanx.core.ad.bean.ConfigResponseBean configResponseBean, java.lang.String str, java.lang.String str2, long j, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.orange.bean.TanxConfigTableV2> netWorkCallBack) {
        if (netWorkCallBack != null) {
            if (configResponseBean == null || android.text.TextUtils.isEmpty(configResponseBean.content)) {
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.DATA_PARSE_ERROR;
                netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail(configResponseBean.reqId, android.os.SystemClock.elapsedRealtime() - j, utErrorCode.getIntCode(), "ConfigResponseBean解析为空", str2);
                return;
            }
            if (android.text.TextUtils.isEmpty(configResponseBean.errorCode)) {
                java.lang.String str3 = configResponseBean.reqId;
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - j;
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode2 = com.alimm.tanx.core.ut.UtErrorCode.CONFIG_SERVER_NOT_CODE;
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail(str3, elapsedRealtime, utErrorCode2.getIntCode(), utErrorCode2.getMsg(), str2);
                netWorkCallBack.error(utErrorCode2.getIntCode(), configResponseBean.reqId, utErrorCode2.getMsg());
                return;
            }
            if (!configResponseBean.errorCode.equals(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE)) {
                try {
                    int parseInt = java.lang.Integer.parseInt(configResponseBean.errorCode);
                    com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail(configResponseBean.reqId, android.os.SystemClock.elapsedRealtime() - j, parseInt, configResponseBean.errorMsg, str2);
                    netWorkCallBack.error(parseInt, configResponseBean.reqId, configResponseBean.errorMsg);
                    return;
                } catch (java.lang.Exception e) {
                    com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
                    java.lang.String str4 = configResponseBean.reqId;
                    long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - j;
                    com.alimm.tanx.core.ut.UtErrorCode utErrorCode3 = com.alimm.tanx.core.ut.UtErrorCode.CONFIG_SERVER_CODE_PARSE_INTEGER_ERROR;
                    com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail(str4, elapsedRealtime2, utErrorCode3.getIntCode(), com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), str2);
                    netWorkCallBack.error(utErrorCode3.getIntCode(), configResponseBean.reqId, com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
                    return;
                }
            }
            java.lang.String decrypt = com.alimm.tanx.core.utils.EncryptUtils.decrypt(configResponseBean.content);
            if (android.text.TextUtils.isEmpty(decrypt)) {
                java.lang.String str5 = configResponseBean.reqId;
                long elapsedRealtime3 = android.os.SystemClock.elapsedRealtime() - j;
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode4 = com.alimm.tanx.core.ut.UtErrorCode.DECRYPT_ERROR;
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail(str5, elapsedRealtime3, utErrorCode4.getIntCode(), utErrorCode4.getMsg(), str2);
                netWorkCallBack.error(utErrorCode4.getIntCode(), "", utErrorCode4.getMsg());
                return;
            }
            try {
                com.alimm.tanx.core.orange.bean.TanxConfigTableV2 tanxConfigTableV2 = (com.alimm.tanx.core.orange.bean.TanxConfigTableV2) com.alibaba.fastjson.JSON.parseObject(decrypt, com.alimm.tanx.core.orange.bean.TanxConfigTableV2.class);
                if (tanxConfigTableV2 != null) {
                    netWorkCallBack.succ(tanxConfigTableV2);
                    com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigSuc(configResponseBean.reqId, android.os.SystemClock.elapsedRealtime() - j);
                } else {
                    java.lang.String str6 = configResponseBean.reqId;
                    long elapsedRealtime4 = android.os.SystemClock.elapsedRealtime() - j;
                    com.alimm.tanx.core.ut.UtErrorCode utErrorCode5 = com.alimm.tanx.core.ut.UtErrorCode.JSON_PARSE_ERROR;
                    com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail(str6, elapsedRealtime4, utErrorCode5.getIntCode(), utErrorCode5.getMsg(), str2);
                    netWorkCallBack.error(utErrorCode5.getIntCode(), "", utErrorCode5.getMsg());
                }
            } catch (java.lang.Exception e2) {
                com.alimm.tanx.core.utils.LogUtils.e(TAG, e2);
                java.lang.String str7 = configResponseBean.reqId;
                long elapsedRealtime5 = android.os.SystemClock.elapsedRealtime() - j;
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode6 = com.alimm.tanx.core.ut.UtErrorCode.JSON_PARSE_ERROR;
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail(str7, elapsedRealtime5, utErrorCode6.getIntCode(), utErrorCode6.getMsg(), str2);
                netWorkCallBack.error(utErrorCode6.getIntCode(), "", "catch异常：" + utErrorCode6.getMsg());
            }
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public com.alimm.tanx.core.net.bean.RequestBean buildRequestBean(com.alimm.tanx.core.ad.bean.ConfigRequestBean configRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.orange.bean.TanxConfigTableV2> netWorkCallBack) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "buildRequestBean");
        com.alimm.tanx.core.net.bean.RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(com.alimm.tanx.core.request.C.getConfigUrl());
        com.alimm.tanx.core.ad.bean.ConfigRequestBean configRequestBean2 = (com.alimm.tanx.core.ad.bean.ConfigRequestBean) super.buildBaseRequestBeanData(configRequestBean);
        android.app.Application appContext = com.alimm.tanx.core.TanxCoreManager.getInstance().getAppContext();
        configRequestBean2.md5_app_key = com.alimm.tanx.core.utils.MD5Utils.getMD5String(com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey());
        configRequestBean2.req_Id = uuid();
        if (configRequestBean2.device == null) {
            com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdDeviceBean adDeviceBean = new com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdDeviceBean();
            configRequestBean2.device = adDeviceBean;
            adDeviceBean.user_agent = com.alimm.tanx.core.utils.AndroidUtils.getUserAgent();
            configRequestBean2.device.android_id = com.alimm.tanx.core.utils.AndroidUtils.getAndroidId();
            com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdDeviceBean adDeviceBean2 = configRequestBean2.device;
            adDeviceBean2.device_type = 0;
            adDeviceBean2.brand = com.alimm.tanx.core.utils.AndroidUtils.getBrand();
            configRequestBean2.device.model = com.alimm.tanx.core.utils.AndroidUtils.getModel();
            configRequestBean2.device.os = 1;
            configRequestBean2.device.osv = com.alimm.tanx.core.utils.AndroidUtils.getSystemVersion();
            configRequestBean2.device.network = com.alimm.tanx.core.utils.NetWorkUtil.getNetworkType(appContext).getKey();
            configRequestBean2.device.operator = com.alimm.tanx.core.utils.NetWorkUtil.getOperatorType(appContext);
            android.graphics.Point screenSize = com.alimm.tanx.core.utils.AndroidUtils.getScreenSize(appContext);
            com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdDeviceBean adDeviceBean3 = configRequestBean2.device;
            adDeviceBean3.width = screenSize.x;
            adDeviceBean3.height = screenSize.y;
            adDeviceBean3.pixel_ratio = com.alimm.tanx.core.utils.AndroidUtils.getDisplayDpi(appContext);
        }
        configRequestBean2.device.installed_app = com.alimm.tanx.core.utils.SysUtils.getInstallStatus();
        configRequestBean2.device.imei = com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().getImei();
        configRequestBean2.device.oaid = com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().getOaid();
        configRequestBean2.device.clientId = com.alimm.tanx.core.TanxCoreSdk.getConfig().getClientId();
        configRequestBean2.device.widevineId = com.alimm.tanx.core.TanxCoreSdk.getConfig().getWidevineId();
        configRequestBean2.device.pseudoId = com.alimm.tanx.core.TanxCoreSdk.getConfig().getPseudoId();
        configRequestBean2.device.guid = com.alimm.tanx.core.TanxCoreSdk.getConfig().getGuid();
        configRequestBean2.device.orientation = com.alimm.tanx.core.utils.AndroidUtils.getScreenOrientation(appContext);
        if (configRequestBean2.user == null) {
            com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdUserBean adUserBean = new com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdUserBean();
            configRequestBean2.user = adUserBean;
            adUserBean.app_key = com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey();
        }
        java.lang.String jSONString = com.alibaba.fastjson.JSON.toJSONString(configRequestBean2);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, jSONString);
        buildBaseRequestBeanUrl.setJson(jSONString);
        return buildBaseRequestBeanUrl;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkDeviceId(com.alimm.tanx.core.ad.bean.ConfigRequestBean configRequestBean) {
        com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdDeviceBean adDeviceBean;
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "checkDeviceId");
        if (configRequestBean == null || (adDeviceBean = configRequestBean.device) == null) {
            return false;
        }
        return (android.text.TextUtils.isEmpty(adDeviceBean.imei) && android.text.TextUtils.isEmpty(configRequestBean.device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkInitData(com.alimm.tanx.core.ad.bean.ConfigRequestBean configRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.orange.bean.TanxConfigTableV2> netWorkCallBack) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "checkInitData");
        return configRequestBean != null;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkRequestBefore(com.alimm.tanx.core.ad.bean.ConfigRequestBean configRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.orange.bean.TanxConfigTableV2> netWorkCallBack) {
        com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdUserBean adUserBean;
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "checkRequestBefore");
        if (configRequestBean == null || (adUserBean = configRequestBean.user) == null || !android.text.TextUtils.isEmpty(adUserBean.app_key)) {
            return true;
        }
        com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.APP_KEY_NULL;
        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void request(com.alimm.tanx.core.ad.bean.ConfigRequestBean configRequestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.orange.bean.TanxConfigTableV2> netWorkCallBack) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, com.tencent.open.SocialConstants.TYPE_REQUEST);
        super.request((com.alimm.tanx.core.request.ConfigRequest) configRequestBean, (com.alimm.tanx.core.net.callback.NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void sendRequest(com.alimm.tanx.core.ad.bean.ConfigRequestBean configRequestBean, com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.orange.bean.TanxConfigTableV2> netWorkCallBack) {
        com.alimm.tanx.core.net.NetWorkManager.getInstance().sendHttpPost(requestBean, com.alimm.tanx.core.ad.bean.ConfigResponseBean.class, false, new com.alimm.tanx.core.request.ConfigRequest.AnonymousClass1(netWorkCallBack, android.os.SystemClock.elapsedRealtime(), requestBean));
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean useDeviceIdCache() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "useDeviceIdCache");
        return true;
    }
}
