package com.alipay.sdk.m.i0;

/* loaded from: classes.dex */
public class a {
    public long a;
    public java.lang.String b;
    public java.lang.String c;
    public int d;

    public a(java.lang.String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.a = j;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public boolean a() {
        return this.a > java.lang.System.currentTimeMillis();
    }

    public void b() {
        this.a = 0L;
    }
}
