package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ha extends com.amap.api.mapcore.util.hi {
    private byte[] a;
    private java.util.Map<java.lang.String, java.lang.String> b;

    public ha(byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map) {
        this.a = bArr;
        this.b = map;
        setDegradeAbility(com.amap.api.mapcore.util.hi.a.SINGLE);
        setHttpProtocol(com.amap.api.mapcore.util.hi.c.HTTPS);
    }

    @Override // com.amap.api.mapcore.util.hi
    public final byte[] getEntityBytes() {
        return this.a;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        return this.b;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
