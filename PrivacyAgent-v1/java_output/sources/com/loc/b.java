package com.loc;

/* loaded from: classes23.dex */
public final class b {
    com.loc.bp a;

    public b(android.content.Context context) {
        this.a = null;
        try {
            com.loc.r.a().a(context);
        } catch (java.lang.Throwable unused) {
        }
        this.a = com.loc.bp.a();
    }

    private java.lang.String a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            java.util.HashMap hashMap = new java.util.HashMap(16);
            com.loc.fp fpVar = new com.loc.fp();
            hashMap.clear();
            hashMap.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
            hashMap.put(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.5");
            java.lang.String a = com.loc.o.a();
            java.lang.String a2 = com.loc.o.a(context, a, com.loc.y.b(map));
            map.put("ts", a);
            map.put("scode", a2);
            fpVar.b(map);
            fpVar.a((java.util.Map<java.lang.String, java.lang.String>) hashMap);
            fpVar.b(str);
            fpVar.a(com.loc.w.a(context));
            fpVar.a(com.loc.fv.i);
            fpVar.b(com.loc.fv.i);
            try {
                return new java.lang.String(com.loc.bp.a(fpVar).a, "utf-8");
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "GeoFenceNetManager", "post");
                return null;
            }
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.util.Map<java.lang.String, java.lang.String> b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        java.util.HashMap hashMap = new java.util.HashMap(16);
        hashMap.put("key", com.loc.m.f(context));
        if (!android.text.TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!android.text.TextUtils.isEmpty(str5) && !android.text.TextUtils.isEmpty(str6)) {
            hashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, str6 + "," + str5);
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            hashMap.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, str3);
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!android.text.TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    public final java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.String, java.lang.String> b = b(context, str2, null, null, null, null, null, null);
        b.put("extensions", "all");
        b.put("subdistrict", "0");
        return a(context, str, b);
    }

    public final java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        java.util.Map<java.lang.String, java.lang.String> b = b(context, str2, str3, str4, str5, null, null, null);
        b.put("children", "1");
        b.put("page", "1");
        b.put("extensions", "base");
        return a(context, str, b);
    }

    public final java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        java.util.Map<java.lang.String, java.lang.String> b = b(context, str2, str3, null, str4, str5, str6, str7);
        b.put("children", "1");
        b.put("page", "1");
        b.put("extensions", "base");
        return a(context, str, b);
    }
}
