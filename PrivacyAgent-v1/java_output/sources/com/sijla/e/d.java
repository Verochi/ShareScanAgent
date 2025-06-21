package com.sijla.e;

/* loaded from: classes19.dex */
public final class d extends com.sijla.e.c {
    private final java.lang.String b;
    private java.lang.String c;
    private android.content.Context d;

    public d(android.content.Context context) {
        this.d = context;
        java.lang.String str = com.sijla.h.a.d.a(context) + "qfs/";
        this.b = str;
        this.c = str + "qfs.js-" + com.sijla.c.a.e();
    }

    private static void a(java.util.List<java.io.File> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.io.File file : list) {
            if (file.exists()) {
                hashMap.put(file.getName(), file);
            }
        }
        org.json.JSONArray optJSONArray = com.sijla.c.d.a.optJSONArray("fdurls");
        if (optJSONArray != null) {
            com.sijla.c.a.a(optJSONArray, 1 == com.sijla.c.d.a.optInt("repeatReportst", 0), new org.json.JSONObject(), hashMap);
        }
        com.sijla.h.a.e.a(list);
    }

    private static org.json.JSONObject b(org.json.JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        java.lang.String optString = jSONObject.optString(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_1, "");
        if (android.text.TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            java.lang.String substring = com.sijla.h.a.g.a(optString).substring(0, 8);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                if (next != null && !com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_1.equals(next) && !"e".equals(next)) {
                    try {
                        jSONObject2.put(next, com.sijla.d.b.b(substring, jSONObject.optString(next)));
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject2;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void b() {
        try {
            if (com.sijla.h.a.a.e(this.d) && com.sijla.h.c.a(this.d, "qfs_time_dur", com.sijla.c.d.a.optLong("timepost", 60L))) {
                java.lang.String e = com.sijla.c.a.e();
                java.util.List list = null;
                java.io.File[] a = com.sijla.h.a.e.a(this.b, (java.io.FileFilter) null);
                if (a != null && a.length > 0) {
                    for (java.io.File file : a) {
                        if (!file.getName().contains(e)) {
                            com.sijla.h.a.e.a(file);
                        }
                    }
                }
                java.io.File file2 = new java.io.File(this.c);
                if (file2.exists()) {
                    try {
                        org.json.JSONArray jSONArray = new org.json.JSONArray(com.sijla.h.c.a(com.sijla.h.c.a(file2)));
                        int length = jSONArray.length();
                        if (length > 0) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            for (int i = 0; i < length; i++) {
                                sb.append(jSONArray.optJSONObject(i).toString());
                                sb.append("\n");
                            }
                            java.lang.String str = this.b + "qfs_" + com.sijla.h.i.b(this.d) + "_" + com.sijla.c.a.f() + "_" + (com.sijla.h.c.d()[0]);
                            com.sijla.h.a.e.a(sb.toString(), str, true);
                            com.sijla.mla.a.y.c(str, str + ".gz");
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
                java.io.File[] a2 = com.sijla.h.a.e.a(this.b, new com.sijla.e.e(this));
                if (a2 != null && a2.length > 0) {
                    list = java.util.Arrays.asList(a2);
                }
                a((java.util.List<java.io.File>) list);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sijla.e.c
    public final void a() {
        super.a();
        b();
    }

    @Override // com.sijla.e.c
    public final void a(long j) {
        super.a(j);
        b();
    }

    public final void a(org.json.JSONObject jSONObject) {
        org.json.JSONObject b = b(jSONObject);
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.io.File file = new java.io.File(this.c);
        if (file.exists()) {
            try {
                jSONArray = new org.json.JSONArray(com.sijla.h.c.a(com.sijla.h.c.a(file)));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        if (b != null) {
            jSONArray.put(b);
            com.sijla.h.a.e.a(this.c, com.sijla.h.c.e(jSONArray.toString()));
        }
    }

    @Override // com.sijla.e.c, com.sijla.b.u.b
    public final void d() {
        b();
    }

    @Override // com.sijla.e.c, com.sijla.b.u.b
    public final void e() {
        b();
    }
}
