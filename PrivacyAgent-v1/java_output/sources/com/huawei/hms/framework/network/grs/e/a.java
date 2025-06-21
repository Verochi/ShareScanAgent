package com.huawei.hms.framework.network.grs.e;

/* loaded from: classes22.dex */
public class a {
    private static final java.lang.String f = "a";
    private final java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>>> a = new java.util.concurrent.ConcurrentHashMap(16);
    private final java.util.Map<java.lang.String, java.lang.Long> b = new java.util.concurrent.ConcurrentHashMap(16);
    private final com.huawei.hms.framework.network.grs.e.c c;
    private final com.huawei.hms.framework.network.grs.e.c d;
    private final com.huawei.hms.framework.network.grs.g.h e;

    public a(com.huawei.hms.framework.network.grs.e.c cVar, com.huawei.hms.framework.network.grs.e.c cVar2, com.huawei.hms.framework.network.grs.g.h hVar) {
        this.d = cVar2;
        this.c = cVar;
        this.e = hVar;
        hVar.a(this);
    }

    private void a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.b bVar, android.content.Context context, java.lang.String str) {
        java.lang.Long l = this.b.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (com.huawei.hms.framework.network.grs.h.e.a(l)) {
            bVar.a(2);
            return;
        }
        if (com.huawei.hms.framework.network.grs.h.e.a(l, 300000L)) {
            this.e.a(new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context), null, str, this.d);
        }
        bVar.a(1);
    }

    private void a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, java.lang.String str, android.content.Context context) {
        if (com.huawei.hms.framework.network.grs.h.e.a(this.b.get(str), 300000L)) {
            this.e.a(new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context), null, null, this.d);
        }
    }

    public com.huawei.hms.framework.network.grs.e.c a() {
        return this.c;
    }

    public java.util.Map<java.lang.String, java.lang.String> a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, java.lang.String str, com.huawei.hms.framework.network.grs.e.b bVar, android.content.Context context) {
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> map = this.a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (map == null || map.isEmpty()) {
            return new java.util.HashMap();
        }
        a(grsBaseInfo, bVar, context, str);
        return map.get(str);
    }

    public void a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, android.content.Context context) {
        java.lang.String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.c.b(grsParasKey + "time", "0");
        this.b.remove(grsParasKey + "time");
        this.a.remove(grsParasKey);
        this.e.a(grsParasKey);
    }

    public void a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.g.d dVar, android.content.Context context, com.huawei.hms.framework.network.grs.g.k.c cVar) {
        if (dVar.f() == 2) {
            com.huawei.hms.framework.common.Logger.w(f, "update cache from server failed");
            return;
        }
        if (cVar.d().size() != 0) {
            this.c.b("geoipCountryCode", dVar.j());
            this.c.b("geoipCountryCodetime", dVar.a());
            return;
        }
        java.lang.String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        if (dVar.m()) {
            this.a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.c.a(grsParasKey, "")));
        } else {
            this.c.b(grsParasKey, dVar.j());
            this.a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
        }
        if (!android.text.TextUtils.isEmpty(dVar.e())) {
            this.c.b(grsParasKey + "ETag", dVar.e());
        }
        this.c.b(grsParasKey + "time", dVar.a());
        this.b.put(grsParasKey, java.lang.Long.valueOf(java.lang.Long.parseLong(dVar.a())));
    }

    public com.huawei.hms.framework.network.grs.g.h b() {
        return this.e;
    }

    public void b(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, android.content.Context context) {
        java.lang.String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        java.lang.String a = this.c.a(grsParasKey, "");
        java.lang.String a2 = this.c.a(grsParasKey + "time", "0");
        long j = 0;
        if (!android.text.TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
            try {
                j = java.lang.Long.parseLong(a2);
            } catch (java.lang.NumberFormatException e) {
                com.huawei.hms.framework.common.Logger.w(f, "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        this.a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(a));
        this.b.put(grsParasKey, java.lang.Long.valueOf(j));
        a(grsBaseInfo, grsParasKey, context);
    }

    public com.huawei.hms.framework.network.grs.e.c c() {
        return this.d;
    }
}
