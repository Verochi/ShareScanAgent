package com.hihonor.push.framework.aidl.entity;

/* loaded from: classes22.dex */
public class PushTokenResult implements com.hihonor.push.framework.aidl.IMessageEntity {

    @com.hihonor.push.framework.aidl.annotation.Packed
    private java.lang.String pushToken = "";

    public java.lang.String getPushToken() {
        return this.pushToken;
    }

    public void setPushToken(java.lang.String str) {
        this.pushToken = str;
    }
}
