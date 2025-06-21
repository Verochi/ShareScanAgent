package com.alimm.tanx.core.config;

/* loaded from: classes.dex */
public class TanxCoreConfig implements java.io.Serializable {
    private static final java.lang.String TAG = "AdSdkConfig";
    private java.lang.String clientId;
    private java.lang.String guid;
    private java.lang.Boolean idAllSwitch;
    private boolean imeiSwitch;
    private java.lang.String mAppId;
    private java.lang.String mAppKey;
    private java.lang.String mAppName;
    private java.lang.String mAppSecret;
    private java.lang.String mChannel;
    private java.lang.String mImei;
    private com.alimm.tanx.core.net.INetWork mNetWork;
    private java.lang.String mOaid;
    private com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker mTanxUserTracker;
    private com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do mUserTracker;
    private boolean oaidSwitch;
    private java.lang.String pseudoId;
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> userTag;
    private java.lang.String widevineId;
    private boolean mDebugMode = false;
    private boolean netDebug = false;
    private com.alimm.tanx.core.utils.LogStatus logStatus = null;

    public static java.lang.String getTAG() {
        return TAG;
    }

    public java.lang.String getAppId() {
        return this.mAppId;
    }

    public java.lang.String getAppKey() {
        return this.mAppKey;
    }

    public java.lang.String getAppName() {
        return this.mAppName;
    }

    public java.lang.String getAppSecret() {
        return this.mAppSecret;
    }

    public java.lang.String getClientId() {
        return this.clientId;
    }

    public java.lang.String getGuid() {
        return this.guid;
    }

    public java.lang.String getImei() {
        return this.mImei;
    }

    public com.alimm.tanx.core.utils.LogStatus getLogStatus() {
        return this.logStatus;
    }

    public java.lang.String getOaid() {
        return this.mOaid;
    }

    public java.lang.String getPseudoId() {
        return this.pseudoId;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getUserTag() {
        return this.userTag;
    }

    public java.lang.String getWidevineId() {
        return this.widevineId;
    }

    public boolean isDebugMode() {
        return this.mDebugMode;
    }

    public java.lang.Boolean isIdAllSwitch() {
        return this.idAllSwitch;
    }

    public boolean isImeiSwitch() {
        return this.imeiSwitch;
    }

    public boolean isNetDebug() {
        return this.netDebug;
    }

    public boolean isOaidSwitch() {
        return this.oaidSwitch;
    }

    public void setAppId(java.lang.String str) {
        this.mAppId = str;
    }

    public void setAppKey(java.lang.String str) {
        this.mAppKey = str;
    }

    public void setAppName(java.lang.String str) {
        this.mAppName = str;
    }

    public void setAppSecret(java.lang.String str) {
        this.mAppSecret = str;
    }

    public void setChannel(java.lang.String str) {
        this.mChannel = str;
    }

    public void setClientId(java.lang.String str) {
        this.clientId = str;
    }

    public void setDebugMode(boolean z) {
        this.mDebugMode = z;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setDebugMode: debugMode = ");
        sb.append(z);
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public void setHttpImpl(com.alimm.tanx.core.net.INetWork iNetWork) {
        if (iNetWork != null) {
            com.alimm.tanx.core.net.NetWorkManager.getInstance().setINetWork(iNetWork);
        }
    }

    public void setIdAllSwitch(java.lang.Boolean bool) {
        if (bool != null) {
            this.imeiSwitch = bool.booleanValue();
            this.oaidSwitch = bool.booleanValue();
            this.idAllSwitch = bool;
        }
    }

    public void setImei(java.lang.String str) {
        this.mImei = str;
        com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().setImei(this.mImei);
    }

    public void setImeiSwitch(boolean z) {
        this.imeiSwitch = z;
    }

    public void setLogStatus(com.alimm.tanx.core.utils.LogStatus logStatus) {
        this.logStatus = logStatus;
    }

    public void setNetDebug(boolean z) {
        this.netDebug = z;
    }

    public void setOaidSwitch(boolean z) {
        this.oaidSwitch = z;
    }

    public void setPseudoId(java.lang.String str) {
        this.pseudoId = str;
    }

    public void setUserTag(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        this.userTag = map;
    }

    public void setWidevineId(java.lang.String str) {
        this.widevineId = str;
    }

    public void setmOaid(java.lang.String str) {
        this.mOaid = str;
        com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().setImei(this.mOaid);
    }
}
