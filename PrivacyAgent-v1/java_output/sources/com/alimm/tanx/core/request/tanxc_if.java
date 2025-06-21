package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public abstract class tanxc_if<Req extends com.alimm.tanx.core.ad.bean.RequestBaseBean, Rep extends com.alimm.tanx.core.ad.bean.BaseBean> {
    private static final java.lang.String TAG = "BaseRequest";
    private static long localTime;
    private static long sTime;

    /* renamed from: com.alimm.tanx.core.request.tanxc_if$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.alimm.tanx.core.ad.bean.RequestBaseBean tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.net.callback.NetWorkCallBack tanxc_if;

        public AnonymousClass1(com.alimm.tanx.core.ad.bean.RequestBaseBean requestBaseBean, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
            this.tanxc_do = requestBaseBean;
            this.tanxc_if = netWorkCallBack;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            long unused = com.alimm.tanx.core.request.tanxc_if.sTime = java.lang.System.currentTimeMillis();
            try {
                if (com.alimm.tanx.core.request.tanxc_if.this.checkInitData(this.tanxc_do, this.tanxc_if)) {
                    com.alimm.tanx.core.net.bean.RequestBean buildRequestBean = com.alimm.tanx.core.request.tanxc_if.this.buildRequestBean(this.tanxc_do, this.tanxc_if);
                    if (buildRequestBean == null) {
                        com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack = this.tanxc_if;
                        com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.REQUEST_BEAN_ERROR;
                        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                    } else if (!com.alimm.tanx.core.request.tanxc_if.this.checkDeviceId(this.tanxc_do)) {
                        com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack2 = this.tanxc_if;
                        com.alimm.tanx.core.ut.UtErrorCode utErrorCode2 = com.alimm.tanx.core.ut.UtErrorCode.APP_DEVICE_NUMBER_NULL;
                        netWorkCallBack2.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
                    } else {
                        if (!com.alimm.tanx.core.request.tanxc_if.this.checkRequestBefore(this.tanxc_do, this.tanxc_if)) {
                            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.request.tanxc_if.TAG, "checkRequestBefore() : false");
                            return;
                        }
                        long unused2 = com.alimm.tanx.core.request.tanxc_if.localTime = java.lang.System.currentTimeMillis() - com.alimm.tanx.core.request.tanxc_if.sTime;
                        com.alimm.tanx.core.utils.LogUtils.d("BaseRequest time ", "local->" + com.alimm.tanx.core.request.tanxc_if.localTime);
                        com.alimm.tanx.core.request.tanxc_if.this.sendRequest(this.tanxc_do, buildRequestBean, this.tanxc_if);
                    }
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.request.tanxc_if.TAG, e);
            }
        }
    }

    public Req buildBaseRequestBeanData(Req req) {
        android.app.Application appContext = com.alimm.tanx.core.TanxCoreManager.getInstance().getAppContext();
        if (req.app == null) {
            com.alimm.tanx.core.ad.bean.RequestBaseBean.AdAppBean adAppBean = new com.alimm.tanx.core.ad.bean.RequestBaseBean.AdAppBean();
            req.app = adAppBean;
            adAppBean.package_name = com.alimm.tanx.core.utils.AndroidUtils.getPackageName(appContext);
            req.app.app_name = com.alimm.tanx.core.utils.AndroidUtils.getAppName(appContext);
            com.alimm.tanx.core.ad.bean.RequestBaseBean.AdAppBean adAppBean2 = req.app;
            adAppBean2.app_version = com.alimm.tanx.core.utils.AndroidUtils.getAppVersion(appContext, adAppBean2.package_name);
            req.app.sdk_version = com.alimm.tanx.core.SdkConstant.getSdkVersion();
        }
        if (req.device == null) {
            com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean adDeviceBean = new com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean();
            req.device = adDeviceBean;
            adDeviceBean.user_agent = com.alimm.tanx.core.utils.AndroidUtils.getUserAgent();
            adDeviceBean.android_id = com.alimm.tanx.core.utils.AndroidUtils.getAndroidId();
            adDeviceBean.device_type = 0;
            adDeviceBean.brand = com.alimm.tanx.core.utils.AndroidUtils.getBrand();
            adDeviceBean.model = com.alimm.tanx.core.utils.AndroidUtils.getModel();
            adDeviceBean.os = "Android";
            adDeviceBean.osv = com.alimm.tanx.core.utils.AndroidUtils.getSystemVersion();
            adDeviceBean.network = com.alimm.tanx.core.utils.NetWorkUtil.getNetworkType(appContext).getKey();
            req.device.operator = com.alimm.tanx.core.utils.NetWorkUtil.getOperatorType(appContext);
            android.graphics.Point screenSize = com.alimm.tanx.core.utils.AndroidUtils.getScreenSize(appContext);
            adDeviceBean.width = screenSize.x;
            adDeviceBean.height = screenSize.y;
            adDeviceBean.pixel_ratio = com.alimm.tanx.core.utils.AndroidUtils.getDisplayDpi(appContext);
        }
        req.device.installed_app = com.alimm.tanx.core.utils.SysUtils.getInstallStatus();
        req.device.imei = com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().getImei();
        req.device.oaid = com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().getOaid();
        req.device.clientId = com.alimm.tanx.core.TanxCoreSdk.getConfig().getClientId();
        req.device.widevineId = com.alimm.tanx.core.TanxCoreSdk.getConfig().getWidevineId();
        req.device.pseudoId = com.alimm.tanx.core.TanxCoreSdk.getConfig().getPseudoId();
        req.device.guid = com.alimm.tanx.core.TanxCoreSdk.getConfig().getGuid();
        req.device.orientation = com.alimm.tanx.core.utils.AndroidUtils.getScreenOrientation(appContext);
        req.id = uuid();
        return req;
    }

    public com.alimm.tanx.core.net.bean.RequestBean buildBaseRequestBeanUrl(java.lang.String str) {
        com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().getImei(useDeviceIdCache());
        com.alimm.tanx.core.net.bean.RequestBean build = new com.alimm.tanx.core.net.bean.RequestBean().setUrl(str).build();
        build.setOverrideError(true);
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        build.setHeads(hashMap);
        return build;
    }

    public abstract com.alimm.tanx.core.net.bean.RequestBean buildRequestBean(Req req, com.alimm.tanx.core.net.callback.NetWorkCallBack<Rep> netWorkCallBack);

    public abstract boolean checkDeviceId(Req req);

    public abstract boolean checkInitData(Req req, com.alimm.tanx.core.net.callback.NetWorkCallBack<Rep> netWorkCallBack);

    public abstract boolean checkRequestBefore(Req req, com.alimm.tanx.core.net.callback.NetWorkCallBack<Rep> netWorkCallBack);

    public boolean checkStrNull(java.lang.String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (java.lang.String str : strArr) {
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public void request(Req req, com.alimm.tanx.core.net.callback.NetWorkCallBack<Rep> netWorkCallBack) {
        com.alimm.tanx.core.common.tanxc_do.tanxc_do(new com.alimm.tanx.core.request.tanxc_if.AnonymousClass1(req, netWorkCallBack));
    }

    public abstract void sendRequest(Req req, com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack<Rep> netWorkCallBack);

    public abstract boolean useDeviceIdCache();

    public java.lang.String uuid() {
        return java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + (java.lang.System.currentTimeMillis() / 1000);
    }
}
