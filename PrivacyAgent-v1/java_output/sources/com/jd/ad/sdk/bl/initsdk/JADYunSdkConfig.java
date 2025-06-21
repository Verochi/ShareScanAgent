package com.jd.ad.sdk.bl.initsdk;

/* loaded from: classes23.dex */
public class JADYunSdkConfig {
    private boolean enableLog;
    private java.lang.String mAppId;
    private com.jd.ad.sdk.bl.initsdk.JADPrivateController privateController;
    private boolean supportMultiProcess;

    public static class Builder {
        private java.lang.String appId;
        private boolean enableLog;
        public com.jd.ad.sdk.bl.initsdk.JADPrivateController privateController;
        private boolean supportMultiProcess;

        public com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig build() {
            return new com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig(this, null);
        }

        public com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig.Builder setAppId(@androidx.annotation.NonNull java.lang.String str) {
            this.appId = str;
            return this;
        }

        public com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig.Builder setEnableLog(boolean z) {
            this.enableLog = z;
            return this;
        }

        public com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig.Builder setPrivateController(@androidx.annotation.NonNull com.jd.ad.sdk.bl.initsdk.JADPrivateController jADPrivateController) {
            this.privateController = jADPrivateController;
            return this;
        }

        public com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig.Builder setSupportMultiProcess(boolean z) {
            this.supportMultiProcess = z;
            return this;
        }
    }

    private JADYunSdkConfig(com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig.Builder builder) {
        this.mAppId = builder.appId;
        this.enableLog = builder.enableLog;
        this.privateController = builder.privateController;
        this.supportMultiProcess = builder.supportMultiProcess;
    }

    public /* synthetic */ JADYunSdkConfig(com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig.Builder builder, com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void setAppId(java.lang.String str) {
        this.mAppId = str;
    }

    private void setEnableLog(boolean z) {
        this.enableLog = z;
    }

    public java.lang.String getAppId() {
        return this.mAppId;
    }

    public com.jd.ad.sdk.bl.initsdk.JADPrivateController getPrivateController() {
        return this.privateController;
    }

    public boolean isEnableLog() {
        return this.enableLog;
    }

    public boolean isSupportMultiProcess() {
        return this.supportMultiProcess;
    }

    public void setPrivateController(com.jd.ad.sdk.bl.initsdk.JADPrivateController jADPrivateController) {
        this.privateController = jADPrivateController;
    }

    public void setSupportMultiProcess(boolean z) {
        this.supportMultiProcess = z;
    }
}
