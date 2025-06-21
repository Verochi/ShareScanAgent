package com.bytedance.android.live.base.api.push.model;

/* loaded from: classes.dex */
public class PushData {
    java.lang.String anchorOpenId;
    java.lang.String avatar;
    java.lang.String infoText;
    java.lang.String logPb;
    java.lang.String nickName;
    public java.lang.String openRoomId;
    java.lang.String requestId;
    java.lang.Long roomId;

    public java.lang.String getAnchorOpenId() {
        return this.anchorOpenId;
    }

    public java.lang.String getAvatar() {
        return this.avatar;
    }

    public java.lang.String getInfoText() {
        return this.infoText;
    }

    public java.lang.String getLogPb() {
        return this.logPb;
    }

    public java.lang.String getNickName() {
        return this.nickName;
    }

    public java.lang.String getRequestId() {
        return this.requestId;
    }

    public java.lang.Long getRoomId() {
        return this.roomId;
    }

    public void setAnchorOpenId(java.lang.String str) {
        this.anchorOpenId = str;
    }

    public void setAvatar(java.lang.String str) {
        this.avatar = str;
    }

    public void setInfoText(java.lang.String str) {
        this.infoText = str;
    }

    public void setLogPb(java.lang.String str) {
        this.logPb = str;
    }

    public void setNickName(java.lang.String str) {
        this.nickName = str;
    }

    public void setRequestId(java.lang.String str) {
        this.requestId = str;
    }

    public void setRoomId(java.lang.Long l) {
        this.roomId = l;
    }
}
