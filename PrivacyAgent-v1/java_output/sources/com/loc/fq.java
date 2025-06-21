package com.loc;

/* loaded from: classes23.dex */
public final class fq {
    private static com.loc.fq b;
    com.loc.bp a;
    private android.content.Context c;
    private int d = com.loc.fv.i;
    private boolean e = false;
    private int f = 0;

    private fq(android.content.Context context) {
        this.a = null;
        this.c = null;
        try {
            com.loc.r.a().a(context);
        } catch (java.lang.Throwable unused) {
        }
        this.c = context;
        this.a = com.loc.bp.a();
    }

    public static com.loc.fq a(android.content.Context context) {
        if (b == null) {
            b = new com.loc.fq(context);
        }
        return b;
    }

    public final com.loc.bv a(com.loc.fr frVar) throws java.lang.Throwable {
        if (this.e) {
            frVar.a(com.loc.bu.c.HTTPS);
        }
        return com.loc.bp.a(frVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0101 A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #1 {all -> 0x0108, blocks: (B:6:0x0012, B:8:0x007a, B:9:0x0081, B:12:0x008f, B:18:0x00e9, B:19:0x00f0, B:21:0x0101, B:27:0x00e3), top: B:5:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.loc.fr a(android.content.Context context, byte[] bArr, java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.String str3;
        try {
            java.util.HashMap hashMap = new java.util.HashMap(16);
            com.loc.fr frVar = new com.loc.fr(context, com.loc.fv.c());
            try {
                hashMap.put("Content-Type", com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.5");
                hashMap.put("KEY", com.loc.m.f(context));
                hashMap.put("enginever", com.loc.fv.a);
                java.lang.String a = com.loc.o.a();
                java.lang.String a2 = com.loc.o.a(context, a, "key=" + com.loc.m.f(context));
                hashMap.put("ts", a);
                hashMap.put("scode", a2);
                if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.3d) {
                    hashMap.put("aps_s_src", "openapi");
                }
                hashMap.put("encr", "1");
                frVar.b(hashMap);
                java.lang.String str4 = z ? "loc" : "locf";
                frVar.c(true);
                frVar.b(java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.5", str4, 3));
                frVar.b(z);
                frVar.c(str);
                frVar.d(str2);
                frVar.c(com.loc.gd.a(bArr));
                frVar.a(com.loc.w.a(context));
                java.util.HashMap hashMap2 = new java.util.HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put(com.umeng.analytics.pro.bo.by, "3103");
                int i = this.f;
                if (i != 0) {
                    if (i != 1) {
                        str3 = i == 2 ? "language:en" : "language:cn";
                    }
                    hashMap2.put("custom", str3);
                    frVar.a((java.util.Map<java.lang.String, java.lang.String>) hashMap2);
                    frVar.a(this.d);
                    frVar.b(this.d);
                    if (this.e) {
                        return frVar;
                    }
                    frVar.a(com.loc.bu.c.HTTPS);
                    return frVar;
                }
                hashMap2.remove("custom");
                frVar.a((java.util.Map<java.lang.String, java.lang.String>) hashMap2);
                frVar.a(this.d);
                frVar.b(this.d);
                if (this.e) {
                }
            } catch (java.lang.Throwable unused) {
                return frVar;
            }
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e5 A[Catch: all -> 0x00f8, TryCatch #1 {all -> 0x00f8, blocks: (B:14:0x00d7, B:16:0x00e5, B:17:0x00ea), top: B:13:0x00d7, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.String a(android.content.Context context, double d, double d2) {
        java.lang.String str;
        try {
            java.util.HashMap hashMap = new java.util.HashMap(16);
            com.loc.fr frVar = new com.loc.fr(context, com.loc.fv.c());
            hashMap.clear();
            hashMap.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
            hashMap.put(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.5");
            java.util.HashMap hashMap2 = new java.util.HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put("key", com.loc.m.f(context));
            int i = this.f;
            try {
                if (i != 0) {
                    if (i != 1) {
                        str = i == 2 ? "en" : "zh-CN";
                    }
                    hashMap2.put("language", str);
                    hashMap2.put("curLocationType", !com.loc.gd.m(this.c) ? "coarseLoc" : "fineLoc");
                    java.lang.String a = com.loc.o.a();
                    java.lang.String a2 = com.loc.o.a(context, a, com.loc.y.b(hashMap2));
                    hashMap2.put("ts", a);
                    hashMap2.put("scode", a2);
                    frVar.b(("output=json&radius=1000&extensions=all&location=" + d2 + "," + d).getBytes("UTF-8"));
                    frVar.c(false);
                    frVar.b(true);
                    frVar.b(java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.5", "loc", 3));
                    frVar.a((java.util.Map<java.lang.String, java.lang.String>) hashMap2);
                    frVar.b(hashMap);
                    frVar.a(com.loc.w.a(context));
                    frVar.a(com.loc.fv.i);
                    frVar.b(com.loc.fv.i);
                    frVar.d("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
                    frVar.c("http://restsdk.amap.com/v3/geocode/regeo");
                    if (this.e) {
                        frVar.a(com.loc.bu.c.HTTPS);
                    }
                    return new java.lang.String(com.loc.bp.a(frVar).a, "utf-8");
                }
                frVar.d("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
                frVar.c("http://restsdk.amap.com/v3/geocode/regeo");
                if (this.e) {
                }
                return new java.lang.String(com.loc.bp.a(frVar).a, "utf-8");
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "LocNetManager", "post");
                return null;
            }
            hashMap2.remove("language");
            hashMap2.put("curLocationType", !com.loc.gd.m(this.c) ? "coarseLoc" : "fineLoc");
            java.lang.String a3 = com.loc.o.a();
            java.lang.String a22 = com.loc.o.a(context, a3, com.loc.y.b(hashMap2));
            hashMap2.put("ts", a3);
            hashMap2.put("scode", a22);
            frVar.b(("output=json&radius=1000&extensions=all&location=" + d2 + "," + d).getBytes("UTF-8"));
            frVar.c(false);
            frVar.b(true);
            frVar.b(java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.5", "loc", 3));
            frVar.a((java.util.Map<java.lang.String, java.lang.String>) hashMap2);
            frVar.b(hashMap);
            frVar.a(com.loc.w.a(context));
            frVar.a(com.loc.fv.i);
            frVar.b(com.loc.fv.i);
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(long j, boolean z, int i) {
        try {
            this.e = z;
            this.d = java.lang.Long.valueOf(j).intValue();
            this.f = i;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "LocNetManager", "setOption");
        }
    }
}
