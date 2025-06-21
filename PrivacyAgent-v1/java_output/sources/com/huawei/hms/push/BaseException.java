package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class BaseException extends java.lang.Exception {
    public final int a;
    public final com.huawei.hms.aaid.constant.ErrorEnum b;

    public BaseException(int i) {
        com.huawei.hms.aaid.constant.ErrorEnum fromCode = com.huawei.hms.aaid.constant.ErrorEnum.fromCode(i);
        this.b = fromCode;
        this.a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return this.b.getMessage();
    }
}
