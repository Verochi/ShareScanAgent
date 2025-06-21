package com.bytedance.android.live.base.api.outer.data;

/* loaded from: classes.dex */
public class AnchorInfo {
    java.lang.String avatar;
    long fansCount;
    java.lang.String nickname;
    java.lang.String openId;

    public AnchorInfo() {
    }

    public AnchorInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, long j) {
        this.openId = str;
        this.nickname = str2;
        this.avatar = str3;
        this.fansCount = j;
    }

    public java.lang.String getAvatar() {
        return this.avatar;
    }

    public long getFansCount() {
        return this.fansCount;
    }

    public java.lang.String getNickname() {
        return this.nickname;
    }

    public java.lang.String getOpenId() {
        return this.openId;
    }

    public void setAvatar(java.lang.String str) {
        this.avatar = str;
    }

    public void setFansCount(long j) {
        this.fansCount = j;
    }

    public void setNickname(java.lang.String str) {
        this.nickname = str;
    }

    public void setOpenId(java.lang.String str) {
        this.openId = str;
    }
}
