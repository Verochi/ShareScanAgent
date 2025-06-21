package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class eo<T, V> extends com.amap.api.mapcore.util.en<T, V> {
    public eo(android.content.Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.mapcore.util.en
    public abstract V a(java.lang.String str) throws com.amap.api.mapcore.util.em;

    @Override // com.amap.api.mapcore.util.en
    public abstract java.lang.String c();

    @Override // com.amap.api.mapcore.util.hi
    public byte[] getEntityBytes() {
        try {
            return c().getBytes("utf-8");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.mapcore.util.cp, com.amap.api.mapcore.util.hi
    public java.util.Map<java.lang.String, java.lang.String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.en, com.amap.api.mapcore.util.hi
    public java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        java.util.HashMap hashMap = new java.util.HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 9.1.0");
        hashMap.put("x-INFO", com.amap.api.mapcore.util.ey.b(((com.amap.api.mapcore.util.en) this).g));
        hashMap.put("platinfo", java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s", "9.1.0", "trace"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
