package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class iq extends com.amap.api.mapcore.util.hc {
    java.util.Map<java.lang.String, java.lang.String> h;
    java.lang.String i;
    java.lang.String j;
    byte[] k;
    byte[] l;
    boolean m;
    java.lang.String n;
    java.util.Map<java.lang.String, java.lang.String> o;
    boolean p;
    private java.lang.String q;

    public iq(android.content.Context context, com.amap.api.mapcore.util.fh fhVar) {
        super(context, fhVar);
        this.h = null;
        this.q = "";
        this.i = "";
        this.j = "";
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = false;
    }

    public final void a(java.lang.String str) {
        this.n = str;
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.o = map;
    }

    public final void a(byte[] bArr) {
        this.k = bArr;
    }

    public final void b(java.lang.String str) {
        this.i = str;
    }

    public final void b(java.util.Map<java.lang.String, java.lang.String> map) {
        this.h = map;
    }

    public final void c(java.lang.String str) {
        this.j = str;
    }

    @Override // com.amap.api.mapcore.util.hc
    public final byte[] c() {
        return this.k;
    }

    @Override // com.amap.api.mapcore.util.hc
    public final byte[] d() {
        return this.l;
    }

    @Override // com.amap.api.mapcore.util.hc
    public final boolean f() {
        return this.m;
    }

    @Override // com.amap.api.mapcore.util.hc
    public final java.lang.String g() {
        return this.n;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getIPDNSName() {
        return this.q;
    }

    @Override // com.amap.api.mapcore.util.fc, com.amap.api.mapcore.util.hi
    public final java.lang.String getIPV6URL() {
        return this.j;
    }

    @Override // com.amap.api.mapcore.util.hc, com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        return this.o;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        return this.h;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getSDKName() {
        return "loc";
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        return this.i;
    }

    @Override // com.amap.api.mapcore.util.hc
    public final boolean h() {
        return this.p;
    }

    public final void i() {
        this.m = true;
    }

    public final void j() {
        this.p = true;
    }
}
