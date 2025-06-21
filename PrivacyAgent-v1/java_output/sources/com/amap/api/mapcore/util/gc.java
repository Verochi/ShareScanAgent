package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class gc extends com.amap.api.mapcore.util.fc {
    private byte[] a;
    private java.lang.String b;

    public gc(byte[] bArr, java.lang.String str) {
        this.b = "1";
        this.a = (byte[]) bArr.clone();
        this.b = str;
        setDegradeAbility(com.amap.api.mapcore.util.hi.a.SINGLE);
        setHttpProtocol(com.amap.api.mapcore.util.hi.c.HTTP);
    }

    @Override // com.amap.api.mapcore.util.hi
    public final byte[] getEntityBytes() {
        return this.a;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", java.lang.String.valueOf(this.a.length));
        return hashMap;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        java.lang.String c = com.amap.api.mapcore.util.fi.c(com.amap.api.mapcore.util.fx.b);
        byte[] a = com.amap.api.mapcore.util.fi.a(com.amap.api.mapcore.util.fx.a);
        byte[] bArr = new byte[a.length + 50];
        java.lang.System.arraycopy(this.a, 0, bArr, 0, 50);
        java.lang.System.arraycopy(a, 0, bArr, 50, a.length);
        return java.lang.String.format(c, "1", this.b, "1", com.igexin.sdk.PushBuildConfig.sdk_conf_channelid, com.amap.api.mapcore.util.fd.a(bArr));
    }

    @Override // com.amap.api.mapcore.util.hi
    public final boolean isHostToIP() {
        return false;
    }
}
