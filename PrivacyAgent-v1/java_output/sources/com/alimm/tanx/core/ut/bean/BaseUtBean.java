package com.alimm.tanx.core.ut.bean;

/* loaded from: classes.dex */
public class BaseUtBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public java.lang.String androidId;
    public java.lang.String appId;
    public java.lang.String appKey;
    public java.lang.String appName;
    public java.lang.String appVersion;
    public java.lang.String brand;
    public int deviceType = 0;
    public int height;
    public java.lang.String idfa;
    public java.lang.String imei;
    public java.lang.String model;
    public int network;
    public java.lang.String oaid;
    public int operator;
    public int orientation;
    public java.lang.String os;
    public java.lang.String osv;
    public java.lang.String packageName;
    public int pixelRatio;
    public java.lang.String sdkVersion;
    public java.lang.String userAgent;
    public java.lang.String utdid;
    public int width;

    public BaseUtBean() {
        com.alimm.tanx.core.config.TanxConfig config = com.alimm.tanx.core.TanxCoreSdk.getConfig();
        com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean utDeviceBean = com.alimm.tanx.core.utils.AndroidUtils.getUtDeviceBean();
        if (config != null) {
            this.appKey = config.getAppKey();
            this.appId = config.getAppId();
            this.appName = config.getAppName();
            if (utDeviceBean != null) {
                this.userAgent = utDeviceBean.user_agent;
                this.androidId = utDeviceBean.android_id;
                this.brand = utDeviceBean.brand;
                this.model = utDeviceBean.model;
                this.os = utDeviceBean.os;
                this.osv = utDeviceBean.osv;
                this.operator = com.alimm.tanx.core.utils.NetWorkUtil.getOperatorType(com.alimm.tanx.core.TanxCoreSdk.getApplication());
                this.width = utDeviceBean.width;
                this.height = utDeviceBean.height;
                this.pixelRatio = utDeviceBean.pixel_ratio;
            }
            this.imei = com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().getImei(true);
            this.oaid = com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().getOaid(true);
            this.sdkVersion = com.alimm.tanx.core.SdkConstant.getSdkVersion();
        }
        this.packageName = com.alimm.tanx.core.utils.AndroidUtils.getPackageName(com.alimm.tanx.core.TanxCoreSdk.getApplication());
        this.appVersion = com.alimm.tanx.core.utils.AndroidUtils.getAppVersion(com.alimm.tanx.core.TanxCoreSdk.getApplication(), this.packageName);
        this.network = com.alimm.tanx.core.utils.NetWorkUtil.getNetworkType(com.alimm.tanx.core.TanxCoreSdk.getApplication()).getKey();
        this.orientation = com.alimm.tanx.core.utils.AndroidUtils.getScreenOrientation(com.alimm.tanx.core.TanxCoreSdk.getApplication());
    }

    public java.lang.String toString() {
        return "BaseUtBean{appKey='" + this.appKey + "', appId='" + this.appId + "', appName='" + this.appName + "', appVersion='" + this.appVersion + "', packageName='" + this.packageName + "', userAgent='" + this.userAgent + "', network=" + this.network + ", orientation=" + this.orientation + ", imei='" + this.imei + "', oaid='" + this.oaid + "', androidId='" + this.androidId + "', deviceType=" + this.deviceType + ", brand='" + this.brand + "', model='" + this.model + "', os='" + this.os + "', osv='" + this.osv + "', operator=" + this.operator + ", width=" + this.width + ", height=" + this.height + ", pixelRatio=" + this.pixelRatio + ", sdkVersion='" + this.sdkVersion + "'} " + super.toString();
    }
}
