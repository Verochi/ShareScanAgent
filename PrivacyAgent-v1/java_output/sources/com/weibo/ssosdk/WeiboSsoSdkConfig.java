package com.weibo.ssosdk;

/* loaded from: classes19.dex */
public class WeiboSsoSdkConfig implements java.lang.Cloneable {
    private android.content.Context appContext;
    private java.lang.String appKey = "";
    private java.lang.String smid = "";
    private java.lang.String from = "";
    private java.lang.String wm = "";
    private java.lang.String oldwm = "";
    private java.lang.String sub = "";
    private java.lang.String smApiKey = "";
    private java.util.HashMap<java.lang.String, java.lang.String> extra = new java.util.HashMap<>();

    private java.lang.String urlEncode(java.lang.String str) {
        try {
            return java.net.URLEncoder.encode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return "";
        }
    }

    public void addExtra(java.lang.String str, java.lang.String str2) {
        this.extra.put(str, str2);
    }

    public java.lang.Object clone() {
        try {
            com.weibo.ssosdk.WeiboSsoSdkConfig weiboSsoSdkConfig = (com.weibo.ssosdk.WeiboSsoSdkConfig) super.clone();
            java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : weiboSsoSdkConfig.extra.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            weiboSsoSdkConfig.extra = hashMap;
            return weiboSsoSdkConfig;
        } catch (java.lang.CloneNotSupportedException unused) {
            return null;
        }
    }

    public java.lang.String getAppKey(boolean z) {
        return z ? urlEncode(this.appKey) : this.appKey;
    }

    public android.content.Context getApplicationContext() {
        return this.appContext;
    }

    public java.lang.String getExtraString(boolean z) {
        if (this.extra.isEmpty()) {
            return "";
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.extra.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (org.json.JSONException unused) {
                return "";
            }
        }
        return z ? urlEncode(jSONObject.toString()) : jSONObject.toString();
    }

    public java.lang.String getFrom(boolean z) {
        return z ? urlEncode(this.from) : this.from;
    }

    public java.lang.String getOldWm(boolean z) {
        return z ? urlEncode(this.oldwm) : this.oldwm;
    }

    public java.lang.String getSmApiKey() {
        return this.smApiKey;
    }

    public java.lang.String getSmid(boolean z) {
        return z ? urlEncode(this.smid) : this.smid;
    }

    public java.lang.String getSub(boolean z) {
        return z ? urlEncode(this.sub) : this.sub;
    }

    public java.lang.String getWm(boolean z) {
        return z ? urlEncode(this.wm) : this.wm;
    }

    public void setAppKey(java.lang.String str) {
        this.appKey = str;
    }

    public void setContext(android.content.Context context) {
        this.appContext = context.getApplicationContext();
    }

    public void setFrom(java.lang.String str) {
        this.from = str;
    }

    public void setOldWm(java.lang.String str) {
        this.oldwm = str;
    }

    public void setSmApiKey(java.lang.String str) {
        this.smApiKey = str;
    }

    public void setSmid(java.lang.String str) {
        this.smid = str;
    }

    public void setSub(java.lang.String str) {
        this.sub = str;
    }

    public void setWm(java.lang.String str) {
        this.wm = str;
    }

    public boolean verify() {
        return (this.appContext == null || android.text.TextUtils.isEmpty(this.appKey) || android.text.TextUtils.isEmpty(this.from) || android.text.TextUtils.isEmpty(this.wm)) ? false : true;
    }
}
