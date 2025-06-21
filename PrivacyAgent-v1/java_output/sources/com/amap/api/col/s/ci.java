package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class ci extends com.amap.api.col.s.bp {

    /* renamed from: s, reason: collision with root package name */
    public byte[] f111s;
    public java.lang.String t;

    public ci(byte[] bArr, java.lang.String str) {
        this.t = "1";
        this.f111s = (byte[]) bArr.clone();
        this.t = str;
        a(com.amap.api.col.s.dd.a.SINGLE);
        a(com.amap.api.col.s.dd.c.HTTP);
    }

    @Override // com.amap.api.col.s.dd
    public final boolean b_() {
        return false;
    }

    @Override // com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> f() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", java.lang.String.valueOf(this.f111s.length));
        return hashMap;
    }

    @Override // com.amap.api.col.s.dd
    public final byte[] g() {
        return this.f111s;
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        java.lang.String c = com.amap.api.col.s.bu.c(com.amap.api.col.s.cd.b);
        byte[] a = com.amap.api.col.s.bu.a(com.amap.api.col.s.cd.a);
        byte[] bArr = new byte[a.length + 50];
        java.lang.System.arraycopy(this.f111s, 0, bArr, 0, 50);
        java.lang.System.arraycopy(a, 0, bArr, 50, a.length);
        return java.lang.String.format(c, "1", this.t, "1", com.igexin.sdk.PushBuildConfig.sdk_conf_channelid, com.amap.api.col.s.bq.a(bArr));
    }
}
