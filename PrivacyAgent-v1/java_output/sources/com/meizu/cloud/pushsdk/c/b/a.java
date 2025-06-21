package com.meizu.cloud.pushsdk.c.b;

/* loaded from: classes23.dex */
public class a extends java.lang.Exception {
    private java.lang.String a;
    private int b;
    private java.lang.String c;
    private com.meizu.cloud.pushsdk.c.c.k d;

    public a() {
        this.b = 0;
    }

    public a(com.meizu.cloud.pushsdk.c.c.k kVar) {
        this.b = 0;
        this.d = kVar;
    }

    public a(java.lang.Throwable th) {
        super(th);
        this.b = 0;
    }

    public com.meizu.cloud.pushsdk.c.c.k a() {
        return this.d;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(java.lang.String str) {
        this.c = str;
    }

    public int b() {
        return this.b;
    }

    public void b(java.lang.String str) {
        this.a = str;
    }

    public java.lang.String c() {
        return this.a;
    }
}
