package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class cw extends com.amap.api.col.s.dd {

    /* renamed from: s, reason: collision with root package name */
    public byte[] f112s;
    public java.util.Map<java.lang.String, java.lang.String> t;

    public cw(byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map) {
        this.f112s = bArr;
        this.t = map;
        a(com.amap.api.col.s.dd.a.SINGLE);
        a(com.amap.api.col.s.dd.c.HTTPS);
    }

    @Override // com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        return this.t;
    }

    @Override // com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> f() {
        return null;
    }

    @Override // com.amap.api.col.s.dd
    public final byte[] g() {
        return this.f112s;
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
