package com.sensorsdata.analytics.android.sdk;

/* loaded from: classes19.dex */
public class SAAdvertisingConfig {
    private boolean enableRemarketing = false;
    public java.util.List<java.lang.String> eventNames;
    public com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey;
    public java.lang.String serverUrl;
    private java.lang.String wakeupUrl;

    public SAAdvertisingConfig() {
    }

    public SAAdvertisingConfig(java.lang.String str, java.util.List<java.lang.String> list, com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey) {
        this.secreteKey = secreteKey;
        this.serverUrl = str;
        this.eventNames = list;
    }

    public com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig enableRemarketing() {
        this.enableRemarketing = true;
        return this;
    }

    public java.lang.String getWakeupUrl() {
        return this.wakeupUrl;
    }

    public boolean isEnableRemarketing() {
        return this.enableRemarketing;
    }

    public com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig setWakeupUrl(java.lang.String str) {
        this.wakeupUrl = str;
        return this;
    }
}
