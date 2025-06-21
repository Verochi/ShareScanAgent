package com.huawei.hms.push.ups.entity;

/* loaded from: classes22.dex */
public class CodeResult {
    public int a;
    public java.lang.String b;

    public CodeResult() {
    }

    public CodeResult(int i) {
        this.a = i;
    }

    public CodeResult(int i, java.lang.String str) {
        this.a = i;
        this.b = str;
    }

    public java.lang.String getReason() {
        return this.b;
    }

    public int getReturnCode() {
        return this.a;
    }

    public void setReason(java.lang.String str) {
        this.b = str;
    }

    public void setReturnCode(int i) {
        this.a = i;
    }
}
