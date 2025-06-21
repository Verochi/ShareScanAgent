package com.huawei.hms.activity;

/* loaded from: classes22.dex */
public class ForegroundIntentBuilder {
    private android.app.Activity activity;
    private java.lang.String foregroundBody;
    private com.huawei.hms.common.internal.RequestHeader foregroundHeader;
    private com.huawei.hms.activity.internal.ForegroundInnerHeader innerHeader;
    private java.lang.String innerPkgName;
    private android.content.Context mHostContext;

    public ForegroundIntentBuilder(android.app.Activity activity) throws java.lang.IllegalArgumentException {
        if (activity == null) {
            throw new java.lang.IllegalArgumentException("listener must not be null.");
        }
        this.activity = activity;
        com.huawei.hms.common.internal.RequestHeader requestHeader = new com.huawei.hms.common.internal.RequestHeader();
        this.foregroundHeader = requestHeader;
        requestHeader.setSdkVersion(60500300);
        this.foregroundBody = "";
        com.huawei.hms.activity.internal.ForegroundInnerHeader foregroundInnerHeader = new com.huawei.hms.activity.internal.ForegroundInnerHeader();
        this.innerHeader = foregroundInnerHeader;
        foregroundInnerHeader.setApkVersion(30000000);
    }

    public static void registerResponseCallback(java.lang.String str, com.huawei.hms.activity.internal.BusResponseCallback busResponseCallback) {
        com.huawei.hms.activity.internal.ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(java.lang.String str) {
        com.huawei.hms.activity.internal.ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public android.content.Intent build() {
        java.lang.String packageName;
        java.lang.String appId;
        android.content.Intent intentStartBridgeActivity = com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(this.activity, com.huawei.hms.activity.ForegroundBusDelegate.class.getName());
        android.content.Context context = this.mHostContext;
        if (context != null) {
            packageName = context.getPackageName();
            appId = com.huawei.hms.utils.Util.getAppId(this.mHostContext);
        } else {
            packageName = this.activity.getPackageName();
            appId = com.huawei.hms.utils.Util.getAppId(this.activity);
        }
        if (this.foregroundHeader.getAppID() == null) {
            this.foregroundHeader.setAppID(appId + "|");
        } else {
            this.foregroundHeader.setAppID(appId + "|" + this.foregroundHeader.getAppID());
        }
        if (android.text.TextUtils.isEmpty(this.foregroundHeader.getTransactionId())) {
            com.huawei.hms.common.internal.RequestHeader requestHeader = this.foregroundHeader;
            requestHeader.setTransactionId(com.huawei.hms.common.internal.TransactionIdCreater.getId(requestHeader.getAppID(), com.huawei.hms.support.api.entity.core.CoreNaming.HUBREQUEST));
        }
        this.foregroundHeader.setPkgName(packageName);
        intentStartBridgeActivity.putExtra(com.huawei.hms.activity.ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.foregroundHeader.toJson());
        intentStartBridgeActivity.putExtra(com.huawei.hms.activity.ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.foregroundBody);
        intentStartBridgeActivity.putExtra(com.huawei.hms.activity.ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.innerHeader.toJson());
        if (!android.text.TextUtils.isEmpty(this.innerPkgName)) {
            intentStartBridgeActivity.putExtra(com.huawei.hms.activity.ForegroundBusDelegate.INNER_PKG_NAME, this.innerPkgName);
        }
        return intentStartBridgeActivity;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setAction(java.lang.String str) {
        this.foregroundHeader.setApiName(str);
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setApiLevel(int i) {
        this.foregroundHeader.setApiLevel(i);
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setApplicationContext(android.content.Context context) {
        this.mHostContext = context;
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setInnerHms() {
        this.innerPkgName = this.activity.getPackageName();
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setKitSdkVersion(int i) {
        this.foregroundHeader.setKitSdkVersion(i);
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setMinApkVersion(int i) {
        this.innerHeader.setApkVersion(i);
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setRequestBody(java.lang.String str) {
        this.foregroundBody = str;
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setResponseCallback(java.lang.String str) {
        this.innerHeader.setResponseCallbackKey(str);
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setResponseCallback(java.lang.String str, com.huawei.hms.activity.internal.BusResponseCallback busResponseCallback) {
        this.innerHeader.setResponseCallbackKey(str);
        com.huawei.hms.activity.internal.ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setServiceName(java.lang.String str) {
        this.foregroundHeader.setSrvName(str);
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setSubAppId(java.lang.String str) {
        this.foregroundHeader.setAppID(str);
        return this;
    }

    public com.huawei.hms.activity.ForegroundIntentBuilder setTransactionId(java.lang.String str) {
        this.foregroundHeader.setTransactionId(str);
        return this;
    }
}
