package com.bytedance.sdk.openadsdk.downloadnew.core;

/* loaded from: classes22.dex */
public class TTDownloadEventModel {
    private org.json.JSONObject t;
    private org.json.JSONObject v;
    private java.lang.String vw;
    private java.lang.String wg;

    public static com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel builder() {
        return new com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel();
    }

    public org.json.JSONObject getExtJson() {
        return this.t;
    }

    public java.lang.String getLabel() {
        return this.wg;
    }

    public org.json.JSONObject getMaterialMeta() {
        return this.v;
    }

    public java.lang.String getTag() {
        return this.vw;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel setExtJson(org.json.JSONObject jSONObject) {
        this.t = jSONObject;
        return this;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel setLabel(java.lang.String str) {
        this.wg = str;
        return this;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel setMaterialMeta(org.json.JSONObject jSONObject) {
        this.v = jSONObject;
        return this;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel setTag(java.lang.String str) {
        this.vw = str;
        return this;
    }
}
