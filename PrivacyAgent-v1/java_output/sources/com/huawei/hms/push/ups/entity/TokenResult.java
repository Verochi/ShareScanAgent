package com.huawei.hms.push.ups.entity;

/* loaded from: classes22.dex */
public class TokenResult extends com.huawei.hms.push.ups.entity.CodeResult {
    public java.lang.String c;

    public TokenResult() {
    }

    public TokenResult(int i) {
        super(i);
    }

    public TokenResult(int i, java.lang.String str) {
        super(i, str);
    }

    public TokenResult(java.lang.String str) {
        this.c = str;
    }

    public java.lang.String getToken() {
        return this.c;
    }

    public void setToken(java.lang.String str) {
        this.c = str;
    }
}
