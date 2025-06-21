package com.hihonor.push.framework.aidl.entity;

/* loaded from: classes22.dex */
public class ResponseHeader implements com.hihonor.push.framework.aidl.IMessageEntity {

    @com.hihonor.push.framework.aidl.annotation.Packed
    public int statusCode;

    @com.hihonor.push.framework.aidl.annotation.Packed
    public java.lang.String statusMessage;

    public ResponseHeader() {
        this.statusCode = com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_INTERNAL_ERROR.statusCode;
    }

    public ResponseHeader(int i, java.lang.String str) {
        int i2 = com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_INTERNAL_ERROR.statusCode;
        this.statusCode = i;
        this.statusMessage = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public java.lang.String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public void setStatusMessage(java.lang.String str) {
        this.statusMessage = str;
    }
}
