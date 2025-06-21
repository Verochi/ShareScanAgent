package com.zx.sdk.api;

/* loaded from: classes19.dex */
public class ZXID implements java.io.Serializable {
    private java.lang.String aids;
    private long expiredTime;
    private java.lang.String openid = "";
    private int ot;
    private java.lang.String tags;
    private java.lang.String value;
    private java.lang.String version;

    public org.json.JSONObject getAids() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            return !android.text.TextUtils.isEmpty(this.aids) ? new org.json.JSONObject(this.aids) : jSONObject;
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.r2.a(e);
            return jSONObject;
        }
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public int getOT() {
        return this.ot;
    }

    public java.lang.String getOpenid() {
        return this.openid;
    }

    public java.lang.String getTags() {
        return this.tags;
    }

    public java.lang.String getValue() {
        return this.value;
    }

    public java.lang.String getVersion() {
        return this.version;
    }

    public boolean isExpired() {
        return java.lang.System.currentTimeMillis() / 1000 >= this.expiredTime;
    }

    public void setAids(java.lang.String str) {
        this.aids = str;
    }

    public void setExpiredTime(long j) {
        this.expiredTime = j;
    }

    public void setOT(int i) {
        this.ot = i;
    }

    public void setOpenid(java.lang.String str) {
        this.openid = str;
    }

    public void setTags(java.lang.String str) {
        this.tags = str;
    }

    public void setValue(java.lang.String str) {
        this.value = str;
    }

    public void setVersion(java.lang.String str) {
        this.version = str;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return getValue();
    }
}
