package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class AppendObjectResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private long nextPosition;
    private java.lang.String objectCRC64;

    public long getNextPosition() {
        return this.nextPosition;
    }

    public java.lang.String getObjectCRC64() {
        return this.objectCRC64;
    }

    public void setNextPosition(java.lang.Long l) {
        this.nextPosition = l.longValue();
    }

    public void setObjectCRC64(java.lang.String str) {
        this.objectCRC64 = str;
    }
}
