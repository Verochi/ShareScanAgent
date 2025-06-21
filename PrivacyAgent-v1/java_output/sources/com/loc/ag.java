package com.loc;

/* loaded from: classes23.dex */
public class ag extends com.loc.s {
    public android.content.Context k;

    public ag(android.content.Context context) {
        this.k = context;
        a(5000);
        b(5000);
    }

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", com.baidu.mobads.sdk.internal.am.d);
        hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.13");
        hashMap.put("platinfo", java.lang.String.format("platform=Android&sdkversion=%s&product=%s", "4.3.13", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.loc.bu
    public final java.lang.String b() {
        return com.loc.r.a().b() ? "https://restapi.amap.com/rest/aaid/get" : "http://restapi.amap.com/rest/aaid/get";
    }

    @Override // com.loc.bu
    public final java.lang.String c_() {
        return "core";
    }

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("key", com.loc.m.f(this.k));
        java.lang.String a = com.loc.o.a();
        java.lang.String a2 = com.loc.o.a(this.k, a, com.loc.y.b(hashMap));
        hashMap.put("ts", a);
        hashMap.put("scode", a2);
        return hashMap;
    }
}
