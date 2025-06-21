package com.igexin.push.g.a;

/* loaded from: classes31.dex */
public abstract class d extends com.igexin.c.a.d.b {
    public static final java.lang.String e = "HttpPlugin";
    public java.lang.String f;
    public byte[] g;
    public java.io.InputStream h;
    public long i;
    public boolean j = true;
    public boolean k = true;
    public boolean l = true;
    public boolean m;

    public d(java.lang.String str) {
        com.igexin.c.a.c.a.a("HttpPluginhttp url:".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
        this.f = str;
    }

    private void a(java.io.InputStream inputStream, long j) {
        this.h = inputStream;
        this.i = j;
    }

    private java.lang.String b() {
        return this.f;
    }

    private void b(byte[] bArr) {
        this.g = bArr;
    }

    private byte[] d() {
        return this.g;
    }

    private java.io.InputStream e() {
        return this.h;
    }

    private long f() {
        return this.i;
    }

    @Override // com.igexin.c.a.d.a.a
    public final void a() {
    }

    public void a(java.lang.Exception exc) {
    }

    public void a(byte[] bArr) throws java.lang.Exception {
        this.m = false;
        if (bArr == null) {
            return;
        }
        new java.lang.String(bArr);
        com.igexin.c.a.c.a.a("HttpPluginhttp:responseData: " + new java.lang.String(bArr), new java.lang.Object[0]);
        if (bArr.length >= 7 && bArr[5] == 111 && bArr[6] == 107) {
            this.m = true;
        }
    }
}
