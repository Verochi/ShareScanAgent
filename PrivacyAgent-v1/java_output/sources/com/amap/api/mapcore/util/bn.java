package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class bn extends com.amap.api.mapcore.util.cp {
    private java.lang.String a;

    public bn(java.lang.String str) {
        this.a = str;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getIPV6URL() {
        return getURL();
    }

    @Override // com.amap.api.mapcore.util.cp, com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        java.util.Hashtable hashtable = new java.util.Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        return this.a;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final boolean isSupportIPV6() {
        return false;
    }
}
