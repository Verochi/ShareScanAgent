package com.loc;

/* loaded from: classes23.dex */
public final class bo extends com.loc.bu {
    private byte[] a;
    private java.util.Map<java.lang.String, java.lang.String> b;

    public bo(byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map) {
        this.a = bArr;
        this.b = map;
        a(com.loc.bu.a.SINGLE);
        a(com.loc.bu.c.HTTPS);
    }

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        return null;
    }

    @Override // com.loc.bu
    public final java.lang.String b() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.loc.bu
    public final byte[] d() {
        return this.a;
    }

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        return this.b;
    }
}
