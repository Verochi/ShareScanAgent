package com.ss.android.download.api.model;

/* loaded from: classes19.dex */
public class DeepLink {
    private long id;
    private org.json.JSONObject json;
    private java.lang.String mCloudGameUrl;
    private java.lang.String mOpenUrl;
    private java.lang.String mWebTitle;
    private java.lang.String mWebUrl;
    private java.lang.String packageName;

    public DeepLink() {
    }

    public DeepLink(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mOpenUrl = str;
        this.mWebUrl = str2;
        this.mWebTitle = str3;
    }

    public java.lang.String getCloudGameUrl() {
        return this.mCloudGameUrl;
    }

    public long getId() {
        return this.id;
    }

    public org.json.JSONObject getJson() {
        return this.json;
    }

    public java.lang.String getOpenUrl() {
        return this.mOpenUrl;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public java.lang.String getWebTitle() {
        return this.mWebTitle;
    }

    public java.lang.String getWebUrl() {
        return this.mWebUrl;
    }

    public void setCloudGameUrl(java.lang.String str) {
        this.mCloudGameUrl = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setJson(org.json.JSONObject jSONObject) {
        this.json = jSONObject;
    }

    public void setOpenUrl(java.lang.String str) {
        this.mOpenUrl = str;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setWebTitle(java.lang.String str) {
        this.mWebTitle = str;
    }

    public void setWebUrl(java.lang.String str) {
        this.mWebUrl = str;
    }
}
