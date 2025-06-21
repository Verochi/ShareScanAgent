package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ch extends com.amap.api.mapcore.util.en<java.lang.String, com.amap.api.mapcore.util.ch.a> {

    public static class a {
        public byte[] a;
        public int b = -1;
    }

    public ch(android.content.Context context, java.lang.String str) {
        super(context, str);
        ((com.amap.api.mapcore.util.en) this).h = "/map/styles";
    }

    private static com.amap.api.mapcore.util.ch.a b(byte[] bArr) throws com.amap.api.mapcore.util.em {
        com.amap.api.mapcore.util.ch.a aVar = new com.amap.api.mapcore.util.ch.a();
        aVar.a = bArr;
        return aVar;
    }

    @Override // com.amap.api.mapcore.util.en
    public final /* bridge */ /* synthetic */ com.amap.api.mapcore.util.ch.a a(java.lang.String str) throws com.amap.api.mapcore.util.em {
        return null;
    }

    @Override // com.amap.api.mapcore.util.en
    public final /* synthetic */ com.amap.api.mapcore.util.ch.a a(byte[] bArr) throws com.amap.api.mapcore.util.em {
        return b(bArr);
    }

    public final void b(java.lang.String str) {
        ((com.amap.api.mapcore.util.en) this).h = str;
    }

    @Override // com.amap.api.mapcore.util.en
    public final java.lang.String c() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getIPV6URL() {
        return com.amap.api.mapcore.util.dl.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.cp, com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        java.util.HashMap hashMap = new java.util.HashMap(16);
        hashMap.put("key", com.amap.api.mapcore.util.ev.f(((com.amap.api.mapcore.util.en) this).g));
        hashMap.put("output", "bin");
        java.lang.String a2 = com.amap.api.mapcore.util.ey.a();
        java.lang.String a3 = com.amap.api.mapcore.util.ey.a(((com.amap.api.mapcore.util.en) this).g, a2, com.amap.api.mapcore.util.fi.b(hashMap));
        hashMap.put("ts", a2);
        hashMap.put("scode", a3);
        return hashMap;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        return ((com.amap.api.mapcore.util.en) this).h;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final boolean isSupportIPV6() {
        return true;
    }
}
