package com.loc;

/* loaded from: classes23.dex */
public final class ga {
    private static com.loc.ga f;
    private static long i;
    private java.io.File d;
    private java.lang.String e;
    private android.content.Context g;
    private boolean h;
    private java.util.LinkedHashMap<java.lang.String, java.lang.Long> c = new java.util.LinkedHashMap<>();
    java.lang.String a = "";
    java.lang.String b = null;

    private ga(android.content.Context context) {
        this.e = null;
        android.content.Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        java.lang.String path = applicationContext.getFilesDir().getPath();
        if (this.e == null) {
            this.e = com.loc.gd.l(this.g);
        }
        try {
            this.d = new java.io.File(path, "reportRecorder");
        } catch (java.lang.Throwable th) {
            com.loc.el.a(th);
        }
        c();
    }

    public static synchronized com.loc.ga a(android.content.Context context) {
        com.loc.ga gaVar;
        synchronized (com.loc.ga.class) {
            if (f == null) {
                f = new com.loc.ga(context);
            }
            gaVar = f;
        }
        return gaVar;
    }

    private boolean b(android.content.Context context) {
        if (this.b == null) {
            this.b = com.loc.gc.a(context, "pref", "lastavedate", "0");
        }
        if (this.b.equals(this.a)) {
            return false;
        }
        android.content.SharedPreferences.Editor a = com.loc.gc.a(context, "pref");
        com.loc.gc.a(a, "lastavedate", this.a);
        com.loc.gc.a(a);
        this.b = this.a;
        return true;
    }

    private synchronized void c() {
        java.util.LinkedHashMap<java.lang.String, java.lang.Long> linkedHashMap = this.c;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            try {
                this.a = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date(java.lang.System.currentTimeMillis()));
                java.util.Iterator<java.lang.String> it = com.loc.gd.a(this.d).iterator();
                while (it.hasNext()) {
                    try {
                        java.lang.String[] split = new java.lang.String(com.loc.fk.b(com.loc.q.b(it.next()), this.e), "UTF-8").split(",");
                        if (split != null && split.length > 1) {
                            this.c.put(split[0], java.lang.Long.valueOf(java.lang.Long.parseLong(split[1])));
                        }
                    } catch (java.io.UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void d() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.util.Map.Entry<java.lang.String, java.lang.Long> entry : this.c.entrySet()) {
                try {
                    sb.append(com.loc.q.b(com.loc.fk.a((entry.getKey() + "," + entry.getValue()).getBytes("UTF-8"), this.e)) + "\n");
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            java.lang.String sb2 = sb.toString();
            if (android.text.TextUtils.isEmpty(sb2)) {
                return;
            }
            com.loc.gd.a(this.d, sb2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void a() {
        if (this.h) {
            d();
            this.h = false;
        }
    }

    public final synchronized void a(com.amap.api.location.AMapLocation aMapLocation) {
        try {
            if ((!this.c.containsKey(this.a) && this.c.size() >= 8) || (this.c.containsKey(this.a) && this.c.size() >= 9)) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Long>> it = this.c.entrySet().iterator();
                while (it.hasNext()) {
                    try {
                        arrayList.add(it.next().getKey());
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    if (arrayList.size() == this.c.size() - 7) {
                        break;
                    }
                }
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.c.remove((java.lang.String) it2.next());
                }
            }
            if (aMapLocation.getErrorCode() != 0) {
                return;
            }
            if (aMapLocation.getLocationType() != 6 && aMapLocation.getLocationType() != 5) {
                if (this.c.containsKey(this.a)) {
                    long longValue = this.c.get(this.a).longValue() + 1;
                    i = longValue;
                    this.c.put(this.a, java.lang.Long.valueOf(longValue));
                } else {
                    this.c.put(this.a, 1L);
                    i = 1L;
                }
                long j = i;
                if (j != 0 && j % 100 == 0) {
                    a();
                }
                this.h = true;
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final synchronized void b() {
        try {
            if (b(this.g)) {
                for (java.util.Map.Entry<java.lang.String, java.lang.Long> entry : this.c.entrySet()) {
                    try {
                        if (!this.a.equals(entry.getKey())) {
                            org.json.JSONObject jSONObject = new org.json.JSONObject();
                            jSONObject.put("param_long_first", entry.getKey());
                            jSONObject.put("param_long_second", entry.getValue());
                            com.loc.gb.a(this.g, "O023", jSONObject);
                        }
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }
}
