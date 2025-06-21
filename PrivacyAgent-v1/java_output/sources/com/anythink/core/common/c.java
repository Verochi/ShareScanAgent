package com.anythink.core.common;

/* loaded from: classes12.dex */
public class c {
    public static java.lang.String a = "c";
    private static volatile com.anythink.core.common.c f;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> b = new java.util.concurrent.ConcurrentHashMap<>();
    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> c = new java.util.concurrent.ConcurrentHashMap<>();
    java.util.Map<java.lang.String, com.anythink.core.common.c.a> d = new java.util.concurrent.ConcurrentHashMap(5);
    java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Long>> e;

    public static class a {
        java.lang.String a;
        long b;
    }

    private c() {
    }

    public static com.anythink.core.common.c a() {
        if (f == null) {
            synchronized (com.anythink.core.common.c.class) {
                if (f == null) {
                    f = new com.anythink.core.common.c();
                }
            }
        }
        return f;
    }

    private void b(java.lang.String str, long j) {
        this.c.put(str, java.lang.Long.valueOf(j));
    }

    public final void a(java.lang.String str) {
        this.e = new java.util.concurrent.ConcurrentHashMap(3);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    java.lang.String next = keys.next();
                    org.json.JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    java.util.HashMap hashMap = new java.util.HashMap(3);
                    java.util.Iterator<java.lang.String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        try {
                            java.lang.String next2 = keys2.next();
                            hashMap.put(next2, java.lang.Long.valueOf(optJSONObject.getLong(next2)));
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                    this.e.put(next, hashMap);
                } catch (java.lang.Throwable unused2) {
                }
            }
        } catch (java.lang.Throwable unused3) {
        }
    }

    public final void a(java.lang.String str, long j) {
        this.b.put(str, java.lang.Long.valueOf(j));
    }

    public final void a(java.lang.String str, long j, com.anythink.core.api.AdError adError) {
        if (android.text.TextUtils.equals(adError.getCode(), com.anythink.core.api.ErrorCode.noADError)) {
            com.anythink.core.common.c.a aVar = this.d.get(str);
            if (aVar == null) {
                aVar = new com.anythink.core.common.c.a();
            }
            aVar.a = adError.getPlatformCode();
            aVar.b = j;
            this.d.put(str, aVar);
        }
    }

    public final boolean a(int i, com.anythink.core.d.e eVar, com.anythink.core.common.f.au auVar) {
        int i2;
        java.lang.Long l;
        if (this.e == null) {
            return false;
        }
        java.util.List<java.lang.Integer> n = eVar.n();
        if (n.size() == 0) {
            return false;
        }
        com.anythink.core.common.c.a aVar = this.d.get(auVar.u());
        if (aVar == null) {
            return false;
        }
        switch (i) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                i2 = 3;
                break;
            case 2:
            default:
                i2 = 1;
                break;
            case 8:
                i2 = 2;
                break;
        }
        if (!n.contains(java.lang.Integer.valueOf(i2))) {
            return false;
        }
        java.util.Map<java.lang.String, java.lang.Long> map = this.e.get(java.lang.String.valueOf(auVar.d()));
        return (map == null || (l = map.get(aVar.a)) == null || aVar.b + l.longValue() < java.lang.System.currentTimeMillis()) ? false : true;
    }

    public final boolean a(com.anythink.core.common.f.au auVar) {
        if (auVar.H() == 0) {
            return false;
        }
        return (this.b.get(auVar.u()) != null ? this.b.get(auVar.u()).longValue() : 0L) + auVar.H() >= java.lang.System.currentTimeMillis();
    }

    public final boolean b(com.anythink.core.common.f.au auVar) {
        if (auVar.m() == 7) {
            return false;
        }
        if (auVar.I() == 0) {
            return false;
        }
        return (this.c.get(auVar.u()) != null ? this.c.get(auVar.u()).longValue() : 0L) + auVar.I() >= java.lang.System.currentTimeMillis();
    }
}
