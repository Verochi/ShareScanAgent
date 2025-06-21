package com.qq.e.comm.constants;

/* loaded from: classes19.dex */
public class LoadAdParams {
    private com.qq.e.comm.constants.LoginType a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.util.Map<java.lang.String, java.lang.String> e;
    private org.json.JSONObject f;
    private final org.json.JSONObject g = new org.json.JSONObject();

    public java.util.Map getDevExtra() {
        return this.e;
    }

    public java.lang.String getDevExtraJsonString() {
        try {
            java.util.Map<java.lang.String, java.lang.String> map = this.e;
            return (map == null || map.size() <= 0) ? "" : new org.json.JSONObject(this.e).toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public org.json.JSONObject getExtraInfo() {
        return this.f;
    }

    public java.lang.String getLoginAppId() {
        return this.b;
    }

    public java.lang.String getLoginOpenid() {
        return this.c;
    }

    public com.qq.e.comm.constants.LoginType getLoginType() {
        return this.a;
    }

    public org.json.JSONObject getParams() {
        return this.g;
    }

    public java.lang.String getUin() {
        return this.d;
    }

    public void setDevExtra(java.util.Map<java.lang.String, java.lang.String> map) {
        this.e = map;
    }

    public void setExtraInfo(org.json.JSONObject jSONObject) {
        this.f = jSONObject;
    }

    public void setLoginAppId(java.lang.String str) {
        this.b = str;
    }

    public void setLoginOpenid(java.lang.String str) {
        this.c = str;
    }

    public void setLoginType(com.qq.e.comm.constants.LoginType loginType) {
        this.a = loginType;
    }

    public void setUin(java.lang.String str) {
        this.d = str;
    }

    public java.lang.String toString() {
        return "LoadAdParams{, loginType=" + this.a + ", loginAppId=" + this.b + ", loginOpenid=" + this.c + ", uin=" + this.d + ", passThroughInfo=" + this.e + ", extraInfo=" + this.f + '}';
    }
}
