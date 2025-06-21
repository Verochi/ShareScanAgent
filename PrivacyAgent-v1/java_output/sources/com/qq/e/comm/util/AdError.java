package com.qq.e.comm.util;

/* loaded from: classes19.dex */
public class AdError {
    private int a;
    private java.lang.String b;

    public AdError() {
    }

    public AdError(int i, java.lang.String str) {
        this.a = i;
        this.b = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public java.lang.String getErrorMsg() {
        return this.b;
    }
}
