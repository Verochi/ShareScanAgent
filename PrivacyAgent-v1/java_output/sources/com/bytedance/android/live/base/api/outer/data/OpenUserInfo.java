package com.bytedance.android.live.base.api.outer.data;

/* loaded from: classes.dex */
public class OpenUserInfo {
    public java.lang.String avatar;
    private java.lang.String nickName;

    public OpenUserInfo() {
    }

    public OpenUserInfo(java.lang.String str, java.lang.String str2) {
        this.nickName = str;
        this.avatar = str2;
    }

    public java.lang.String getAvatar() {
        return this.avatar;
    }

    public java.lang.String getNickName() {
        return this.nickName;
    }
}
