package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class TanxError extends java.lang.Exception {
    public static final java.lang.String ERROR_ADINFO_ADCOUNT_NULL = "adInfo adCount is null";
    public static final java.lang.String ERROR_ADINFO_NULL = "adInfo is null";
    public static final java.lang.String ERROR_AD_SWITCH_CLOSE = "ad switch close";
    public static final java.lang.String ERROR_TIMEOUT = "timeout";
    private int code;
    private java.lang.String message;
    private java.lang.String reqId;

    public TanxError(java.lang.String str) {
        super(str);
        this.reqId = "";
        this.message = "";
        this.code = -9999;
    }

    public TanxError(java.lang.String str, int i, java.lang.String str2) {
        super("\n reqId: " + str + "\n ErrorCode:" + i + " \n message:" + str2);
        this.reqId = str;
        this.code = i;
        this.message = str2;
    }

    public TanxError(java.lang.String str, java.lang.String str2) {
        super(str2 + " \n reqId: " + str);
        this.code = -9999;
        this.reqId = str;
        this.message = str2;
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return this.message;
    }

    public java.lang.String getReqId() {
        return this.reqId;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(java.lang.String str) {
        this.message = str;
    }

    public void setReqId(java.lang.String str) {
        this.reqId = str;
    }

    @Override // java.lang.Throwable
    public java.lang.String toString() {
        return "TanxError :  reqId: " + this.reqId + "\n ErrorCode:" + this.code + " \n message:" + this.message;
    }
}
