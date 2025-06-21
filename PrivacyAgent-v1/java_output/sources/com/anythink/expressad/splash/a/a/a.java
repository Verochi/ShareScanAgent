package com.anythink.expressad.splash.a.a;

/* loaded from: classes12.dex */
public class a {
    private static final java.lang.String a = "a";

    public static com.anythink.expressad.foundation.d.c a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        if (android.text.TextUtils.isEmpty(str)) {
            return cVar;
        }
        if (android.text.TextUtils.isEmpty(str) && cVar == null) {
            return null;
        }
        if (str.contains("notice")) {
            try {
                org.json.JSONObject a2 = com.anythink.expressad.foundation.d.c.a(cVar);
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                try {
                    if (!jSONObject.has(com.anythink.expressad.foundation.d.c.O)) {
                        a2.put(com.anythink.expressad.foundation.d.c.O, "");
                    }
                } catch (java.lang.Exception unused) {
                }
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    a2.put(next, jSONObject.getString(next));
                }
                com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(a2);
                java.lang.String optString = a2.optString("unitId");
                if (!android.text.TextUtils.isEmpty(optString)) {
                    b.l(optString);
                }
                return b;
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                return cVar;
            }
        }
        try {
            org.json.JSONObject a3 = com.anythink.expressad.foundation.d.c.a(cVar);
            com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(a3);
            if (b2 == null) {
                b2 = cVar;
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.String optString2 = a3.optString("unitId");
                if (!android.text.TextUtils.isEmpty(optString2)) {
                    b2.l(optString2);
                }
                org.json.JSONObject optJSONObject = new org.json.JSONObject(str).optJSONObject(com.anythink.expressad.foundation.g.a.ce);
                if (optJSONObject != null) {
                    java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), java.lang.Integer.valueOf(optJSONObject.getString(com.anythink.expressad.foundation.g.a.cc)).intValue()));
                    java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), java.lang.Integer.valueOf(optJSONObject.getString(com.anythink.expressad.foundation.g.a.cd)).intValue()));
                }
                b2.p(b2.ad());
                java.lang.String ah = b2.ah();
                if (optJSONObject != null) {
                    java.util.Iterator<java.lang.String> keys2 = optJSONObject.keys();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (keys2.hasNext()) {
                        sb.append("&");
                        java.lang.String next2 = keys2.next();
                        java.lang.String optString3 = optJSONObject.optString(next2);
                        if (com.anythink.expressad.foundation.g.a.cc.equals(next2) || com.anythink.expressad.foundation.g.a.cd.equals(next2)) {
                            optString3 = java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), java.lang.Integer.valueOf(optString3).intValue()));
                        }
                        sb.append(next2);
                        sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(optString3);
                    }
                    b2.q(ah + ((java.lang.Object) sb));
                }
            }
            return b2;
        } catch (java.lang.Throwable unused2) {
            return cVar;
        }
    }

    private static java.lang.String a() {
        return "";
    }

    private static java.lang.String a(int i) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", i);
            java.lang.String jSONObject2 = jSONObject.toString();
            return !android.text.TextUtils.isEmpty(jSONObject2) ? android.util.Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String a(int i, float f, float f2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (i == 4) {
                jSONObject2.put(com.anythink.expressad.foundation.g.a.cc, com.anythink.expressad.video.bt.a.c.a);
                jSONObject2.put(com.anythink.expressad.foundation.g.a.cd, com.anythink.expressad.video.bt.a.c.a);
            } else {
                jSONObject2.put(com.anythink.expressad.foundation.g.a.cc, com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), f));
                jSONObject2.put(com.anythink.expressad.foundation.g.a.cd, com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), f2));
            }
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cf, i);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cg, com.anythink.core.common.b.o.a().f().getResources().getConfiguration().orientation);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.ch, com.anythink.expressad.foundation.h.t.c(com.anythink.core.common.b.o.a().f()));
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, jSONObject2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static java.lang.String a(java.lang.String str) {
        java.util.List<com.anythink.expressad.foundation.g.e.a> list;
        try {
            java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> map = com.anythink.expressad.foundation.g.a.f.i;
            if (map == null || !com.anythink.expressad.foundation.h.w.b(str) || !map.containsKey(str) || (list = map.get(str)) == null || list.size() <= 0) {
                return "";
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            for (int i = 0; i < list.size(); i++) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                com.anythink.expressad.foundation.g.e.a aVar = list.get(i);
                jSONObject.put("cid", aVar.a());
                jSONObject.put("crid", aVar.c());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static synchronized java.util.List<com.anythink.expressad.foundation.g.e.a> a(java.util.List<com.anythink.expressad.foundation.g.e.a> list, java.util.List<com.anythink.expressad.foundation.d.c> list2) {
        synchronized (com.anythink.expressad.splash.a.a.a.class) {
            if (list2 != null) {
                if (list2.size() > 0) {
                    if (list == null) {
                        list = new java.util.ArrayList<>();
                    }
                    for (com.anythink.expressad.foundation.d.c cVar : list2) {
                        if (cVar != null) {
                            com.anythink.expressad.foundation.g.e.a aVar = new com.anythink.expressad.foundation.g.e.a(cVar.aZ(), cVar.r());
                            if (list.size() >= 20) {
                                list.remove(0);
                            }
                            list.add(aVar);
                        }
                    }
                }
            }
        }
        return list;
    }

    private static void a(android.content.Context context, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (context == null || list == null || list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            com.anythink.expressad.foundation.d.c cVar = list.get(i);
            if (cVar != null) {
                com.anythink.expressad.foundation.h.t.a(context, cVar.ba());
            }
        }
    }

    private static void a(java.lang.String str, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.e.a>> map = com.anythink.expressad.foundation.g.a.f.i;
        if (map == null || list == null || list.size() <= 0) {
            return;
        }
        if (com.anythink.expressad.foundation.h.w.b(str)) {
            if (map.containsKey(str)) {
                map.put(str, a(map.get(str), list));
            } else {
                map.put(str, a(new java.util.ArrayList(), list));
            }
        }
        com.anythink.expressad.foundation.g.a.f.i = map;
    }

    private static java.lang.String b() {
        return "";
    }
}
