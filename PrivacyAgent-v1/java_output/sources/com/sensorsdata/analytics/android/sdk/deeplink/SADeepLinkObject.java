package com.sensorsdata.analytics.android.sdk.deeplink;

/* loaded from: classes19.dex */
public class SADeepLinkObject implements java.io.Serializable {
    private long mAppAwakePassedTime;
    private java.lang.String mChannels;
    private org.json.JSONObject mCustomParams;
    private java.lang.String mParams;
    private boolean success;

    public SADeepLinkObject(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2, boolean z, long j) {
        this.mParams = str;
        this.mChannels = str2;
        this.success = z;
        this.mCustomParams = jSONObject;
        this.mAppAwakePassedTime = j;
    }

    public long getAppAwakePassedTime() {
        return this.mAppAwakePassedTime;
    }

    public java.lang.String getChannels() {
        return this.mChannels;
    }

    public org.json.JSONObject getCustomParams() {
        return this.mCustomParams;
    }

    public java.lang.String getParams() {
        return this.mParams;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
