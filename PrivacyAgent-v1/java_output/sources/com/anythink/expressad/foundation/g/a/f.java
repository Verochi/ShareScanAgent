package com.anythink.expressad.foundation.g.a;

/* loaded from: classes12.dex */
public class f {
    public static final java.lang.String a = "native";
    public static final java.lang.String b = "reward";
    public static final java.lang.String c = "interactive";
    public static final java.lang.String d = "interstitial";
    public static final java.lang.String e = "banner";
    public static final java.lang.String f = "splash";
    public static final java.lang.String g = "h5_native";
    public static java.util.Map<java.lang.String, java.lang.Long> h = new java.util.HashMap();
    public static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> i = new java.util.HashMap();
    public static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> j = new java.util.HashMap();
    public static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> k = new java.util.HashMap();
    public static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> l = new java.util.HashMap();
    public static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> m = new java.util.HashMap();
    public static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> n = new java.util.HashMap();
    public static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> o = new java.util.HashMap();
    public static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> p = new java.util.HashMap();
    private static final java.lang.String q = "f";

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.util.List<com.anythink.expressad.foundation.g.e.a> list;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> b2 = android.text.TextUtils.isEmpty(str2) ? j.containsKey(str) ? j : k.containsKey(str) ? k : l.containsKey(str) ? l : m.containsKey(str) ? m : n.containsKey(str) ? n : o.containsKey(str) ? o : p.containsKey(str) ? p : null : b(str2);
        if (b2 != null) {
            try {
                if (com.anythink.expressad.foundation.h.w.b(str) && b2.containsKey(str) && (list = b2.get(str)) != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        jSONObject.put("cid", list.get(i2).a());
                        jSONObject.put("rid", list.get(i2).b());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    private static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> a(java.lang.String str) {
        if (j.containsKey(str)) {
            return j;
        }
        if (k.containsKey(str)) {
            return k;
        }
        if (l.containsKey(str)) {
            return l;
        }
        if (m.containsKey(str)) {
            return m;
        }
        if (n.containsKey(str)) {
            return n;
        }
        if (o.containsKey(str)) {
            return o;
        }
        if (p.containsKey(str)) {
            return p;
        }
        return null;
    }

    public static void a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.lang.String str2) {
        java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> b2 = b(str2);
        if (cVar == null || b2 == null) {
            return;
        }
        try {
            if (android.text.TextUtils.isEmpty(cVar.aZ())) {
                return;
            }
            com.anythink.expressad.foundation.g.e.a aVar = new com.anythink.expressad.foundation.g.e.a(cVar.aZ(), cVar.Z());
            if (!b2.containsKey(str)) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add(aVar);
                b2.put(str, arrayList);
                return;
            }
            java.util.List<com.anythink.expressad.foundation.g.e.a> list = b2.get(str);
            if (list != null && list.size() == 20) {
                list.remove(0);
            }
            if (list != null) {
                list.add(aVar);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private static void a(java.util.Map... mapArr) {
        try {
            for (java.util.Map map : mapArr) {
                if (map != null) {
                    map.clear();
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private static java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> b(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "banner":
                return n;
            case "native":
                return j;
            case "reward":
                return k;
            case "splash":
                return o;
            case "h5_native":
                return p;
            case "interstitial":
                return m;
            case "interactive":
                return l;
            default:
                return null;
        }
    }

    private static void b(java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.lang.String str2) {
        java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> b2 = b(str2);
        if (cVar == null || b2 == null) {
            return;
        }
        try {
            if (android.text.TextUtils.isEmpty(cVar.aZ())) {
                return;
            }
            com.anythink.expressad.foundation.g.e.a aVar = new com.anythink.expressad.foundation.g.e.a(cVar.aZ(), cVar.Z());
            if (!b2.containsKey(str)) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add(aVar);
                b2.put(str, arrayList);
            } else {
                java.util.List<com.anythink.expressad.foundation.g.e.a> list = b2.get(str);
                if (list != null) {
                    list.add(aVar);
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
