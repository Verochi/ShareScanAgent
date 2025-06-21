package com.bytedance.android.livehostapi.platform;

/* loaded from: classes.dex */
public class TokenInfo {
    public java.lang.String accessToken;
    public long expireAt;
    public java.lang.String name;
    public java.lang.String openId;

    public TokenInfo() {
    }

    public TokenInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, long j) {
        this.name = str;
        this.openId = str2;
        this.accessToken = str3;
        this.expireAt = j;
    }

    public java.lang.String getAccessToken() {
        return this.accessToken;
    }

    public long getExpireAt() {
        return this.expireAt;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getOpenId() {
        return this.openId;
    }

    public void setAccessToken(java.lang.String str) {
        this.accessToken = str;
    }

    public void setExpireAt(long j) {
        this.expireAt = j;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setOpenId(java.lang.String str) {
        this.openId = str;
    }
}
