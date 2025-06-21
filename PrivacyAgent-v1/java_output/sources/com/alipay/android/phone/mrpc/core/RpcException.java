package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public class RpcException extends java.lang.RuntimeException {
    public static final long serialVersionUID = -2875437994101380406L;
    public int mCode;
    public java.lang.String mMsg;
    public java.lang.String mOperationType;

    public RpcException(java.lang.Integer num, java.lang.String str) {
        super(a(num, str));
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    public RpcException(java.lang.Integer num, java.lang.String str, java.lang.Throwable th) {
        super(a(num, str), th);
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    public RpcException(java.lang.Integer num, java.lang.Throwable th) {
        super(th);
        this.mCode = num.intValue();
    }

    public RpcException(java.lang.String str) {
        super(str);
        this.mCode = 0;
        this.mMsg = str;
    }

    public static java.lang.String a(java.lang.Integer num, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("RPCException: ");
        if (num != null) {
            sb.append("[");
            sb.append(num);
            sb.append("]");
        }
        sb.append(" : ");
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public int getCode() {
        return this.mCode;
    }

    public java.lang.String getMsg() {
        return this.mMsg;
    }

    public java.lang.String getOperationType() {
        return this.mOperationType;
    }

    public void setOperationType(java.lang.String str) {
        this.mOperationType = str;
    }
}
