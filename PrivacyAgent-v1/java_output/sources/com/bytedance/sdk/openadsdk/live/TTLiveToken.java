package com.bytedance.sdk.openadsdk.live;

/* loaded from: classes22.dex */
public class TTLiveToken implements java.io.Serializable {
    public java.lang.String accessToken;
    public long expireAt;
    public java.lang.String name;
    public java.lang.String openId;
    public java.lang.String refreshToken;

    public TTLiveToken(java.lang.String str, java.lang.String str2, java.lang.String str3, long j, java.lang.String str4) {
        this.name = str;
        this.accessToken = str2;
        this.openId = str3;
        this.expireAt = j;
        this.refreshToken = str4;
    }

    public java.lang.String toString() {
        return "TTLiveToken{accessToken='" + this.accessToken + "', openId='" + this.openId + "', expireAt=" + this.expireAt + ", refreshToken='" + this.refreshToken + "'}";
    }
}
