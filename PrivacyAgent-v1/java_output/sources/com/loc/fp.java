package com.loc;

/* loaded from: classes23.dex */
public final class fp extends com.loc.s {
    java.util.Map<java.lang.String, java.lang.String> a = null;
    java.util.Map<java.lang.String, java.lang.String> b = null;
    java.lang.String c = "";
    byte[] d = null;
    private java.lang.String e = null;

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        return this.a;
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.a = map;
    }

    public final void a(byte[] bArr) {
        this.d = bArr;
    }

    @Override // com.loc.bu
    public final java.lang.String b() {
        return this.c;
    }

    public final void b(java.lang.String str) {
        this.c = str;
    }

    public final void b(java.util.Map<java.lang.String, java.lang.String> map) {
        this.b = map;
    }

    @Override // com.loc.s, com.loc.bu
    public final java.lang.String c() {
        return !android.text.TextUtils.isEmpty(this.e) ? this.e : super.c();
    }

    public final void c(java.lang.String str) {
        this.e = str;
    }

    @Override // com.loc.bu
    public final byte[] d() {
        return this.d;
    }

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        return this.b;
    }
}
