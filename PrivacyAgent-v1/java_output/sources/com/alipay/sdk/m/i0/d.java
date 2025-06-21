package com.alipay.sdk.m.i0;

/* loaded from: classes.dex */
public class d {
    public java.lang.String a;
    public int b;
    public long c = java.lang.System.currentTimeMillis() + 86400000;

    public d(java.lang.String str, int i) {
        this.a = str;
        this.b = i;
    }

    public java.lang.String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
