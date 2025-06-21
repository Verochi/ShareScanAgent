package com.alibaba.sdk.android.vod.upload.common;

/* loaded from: classes.dex */
public class RequestIDSession {
    private static com.alibaba.sdk.android.vod.upload.common.RequestIDSession requestIDSession;
    private boolean canModify = true;
    private java.lang.String requestID;

    public static com.alibaba.sdk.android.vod.upload.common.RequestIDSession getInstance() {
        if (requestIDSession == null) {
            synchronized (com.alibaba.sdk.android.vod.upload.common.RequestIDSession.class) {
                if (requestIDSession == null) {
                    requestIDSession = new com.alibaba.sdk.android.vod.upload.common.RequestIDSession();
                }
            }
        }
        return requestIDSession;
    }

    public java.lang.String getRequestID() {
        if (this.requestID == null) {
            this.requestID = com.aliyun.vod.log.util.UUIDGenerator.generateRequestID();
        }
        return this.requestID;
    }

    public void setRequestID(java.lang.String str) {
        this.requestID = str;
    }

    public void setRequestID(java.lang.String str, boolean z) {
        this.requestID = str;
        this.canModify = z;
    }

    public void updateRequestID() {
        if (this.canModify) {
            this.requestID = com.aliyun.vod.log.util.UUIDGenerator.generateRequestID();
        }
    }
}
