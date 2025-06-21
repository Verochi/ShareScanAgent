package com.huawei.hms.core.aidl;

/* loaded from: classes22.dex */
public class ResponseHeader implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    protected int statusCode;

    public ResponseHeader() {
    }

    public ResponseHeader(int i) {
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
