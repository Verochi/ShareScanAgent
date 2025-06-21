package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ip {
    private static com.amap.api.mapcore.util.ip b;
    com.amap.api.mapcore.util.hb a;
    private android.content.Context c;
    private int d = com.amap.api.mapcore.util.it.i;
    private boolean e = false;
    private int f = 0;

    private ip(android.content.Context context) {
        this.a = null;
        this.c = null;
        try {
            com.amap.api.mapcore.util.fb.a().a(context);
        } catch (java.lang.Throwable unused) {
        }
        this.c = context;
        this.a = com.amap.api.mapcore.util.hb.a();
    }

    public static com.amap.api.mapcore.util.ip a(android.content.Context context) {
        if (b == null) {
            b = new com.amap.api.mapcore.util.ip(context);
        }
        return b;
    }

    public final com.amap.api.mapcore.util.hj a(com.amap.api.mapcore.util.iq iqVar) throws java.lang.Throwable {
        if (this.e) {
            iqVar.setHttpProtocol(com.amap.api.mapcore.util.hi.c.HTTPS);
        }
        return com.amap.api.mapcore.util.hb.b(iqVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00fd A[Catch: all -> 0x0104, TRY_LEAVE, TryCatch #1 {all -> 0x0104, blocks: (B:6:0x0012, B:8:0x007a, B:9:0x0081, B:15:0x00e5, B:16:0x00ec, B:18:0x00fd, B:24:0x00df), top: B:5:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.amap.api.mapcore.util.iq a(android.content.Context context, byte[] bArr, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        try {
            java.util.HashMap hashMap = new java.util.HashMap(16);
            com.amap.api.mapcore.util.iq iqVar = new com.amap.api.mapcore.util.iq(context, com.amap.api.mapcore.util.it.c());
            try {
                hashMap.put("Content-Type", com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 5.3.1");
                hashMap.put("KEY", com.amap.api.mapcore.util.ev.f(context));
                hashMap.put("enginever", com.amap.api.mapcore.util.it.a);
                java.lang.String a = com.amap.api.mapcore.util.ey.a();
                java.lang.String a2 = com.amap.api.mapcore.util.ey.a(context, a, "key=" + com.amap.api.mapcore.util.ev.f(context));
                hashMap.put("ts", a);
                hashMap.put("scode", a2);
                if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.3d) {
                    hashMap.put("aps_s_src", "openapi");
                }
                hashMap.put("encr", "1");
                iqVar.b(hashMap);
                iqVar.j();
                iqVar.a(java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "5.3.1", "loc", 3));
                iqVar.i();
                iqVar.b(str);
                iqVar.c(str2);
                iqVar.a(com.amap.api.mapcore.util.ix.a(bArr));
                iqVar.setProxy(com.amap.api.mapcore.util.fg.a(context));
                java.util.HashMap hashMap2 = new java.util.HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put(com.umeng.analytics.pro.bo.by, "3103");
                int i = this.f;
                if (i != 0) {
                    if (i != 1) {
                        str3 = i == 2 ? "language:en" : "language:cn";
                    }
                    hashMap2.put("custom", str3);
                    iqVar.a(hashMap2);
                    iqVar.setConnectionTimeout(this.d);
                    iqVar.setSoTimeout(this.d);
                    if (this.e) {
                        return iqVar;
                    }
                    iqVar.setHttpProtocol(com.amap.api.mapcore.util.hi.c.HTTPS);
                    return iqVar;
                }
                hashMap2.remove("custom");
                iqVar.a(hashMap2);
                iqVar.setConnectionTimeout(this.d);
                iqVar.setSoTimeout(this.d);
                if (this.e) {
                }
            } catch (java.lang.Throwable unused) {
                return iqVar;
            }
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    public final void a(long j, boolean z) {
        try {
            this.e = z;
            this.d = java.lang.Long.valueOf(j).intValue();
            this.f = 0;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocNetManager", "setOption");
        }
    }
}
