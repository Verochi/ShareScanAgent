package com.anythink.expressad.video.module.b;

/* loaded from: classes12.dex */
public final class a {
    public static java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.String>> a = new java.util.HashMap<>();
    private static final java.lang.String b = "VideoViewReport";

    private static java.lang.String a(java.lang.String str, com.anythink.expressad.foundation.g.f.h.b bVar) {
        java.lang.String trim = bVar.a().trim();
        if (android.text.TextUtils.isEmpty(trim)) {
            return "";
        }
        if (!str.endsWith("?") && !str.endsWith("&")) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(str.contains("?") ? "&" : "?");
            str = sb.toString();
        }
        return str + trim;
    }

    public static void a() {
    }

    public static void a(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().o() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().o(), false);
    }

    public static void a(android.content.Context context, com.anythink.expressad.foundation.d.c cVar, int i, int i2) {
        try {
            java.lang.String[] p = cVar.L().p();
            if (cVar.L() == null || p == null) {
                return;
            }
            java.lang.String[] strArr = new java.lang.String[p.length];
            for (int i3 = 0; i3 < p.length; i3++) {
                java.lang.String str = p[i3];
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("endscreen_type", i);
                java.lang.String jSONObject2 = jSONObject.toString();
                if (!android.text.TextUtils.isEmpty(jSONObject2)) {
                    jSONObject2 = com.anythink.expressad.foundation.h.j.a(jSONObject2);
                }
                if (!android.text.TextUtils.isEmpty(jSONObject2)) {
                    str = str + "&value=" + java.net.URLEncoder.encode(jSONObject2);
                }
                strArr[i3] = cVar.n() == 1 ? str + "&to=1&cbt=" + cVar.az() + "&tmorl=" + i2 : str + "&to=0&cbt=" + cVar.az() + "&tmorl=" + i2;
            }
            com.anythink.expressad.a.a.a(context, cVar, cVar.K(), strArr, true);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, com.anythink.expressad.foundation.d.c cVar, int i, int i2, int i3) {
        java.lang.String str;
        if (i2 == 0 || context == null || cVar == null) {
            return;
        }
        try {
            java.util.List<java.util.Map<java.lang.Integer, java.lang.String>> i4 = cVar.L().i();
            int i5 = ((i + 1) * 100) / i2;
            if (i4 != null) {
                int i6 = 0;
                while (i6 < i4.size()) {
                    java.util.Map<java.lang.Integer, java.lang.String> map = i4.get(i6);
                    if (map != null && map.size() > 0) {
                        java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.lang.String>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            java.util.Map.Entry<java.lang.Integer, java.lang.String> next = it.next();
                            int intValue = next.getKey().intValue();
                            java.lang.String value = next.getValue();
                            if (cVar.n() == 1) {
                                str = value + "&to=1&cbt=" + cVar.az() + "&tmorl=" + i3;
                            } else {
                                str = value + "&to=0&cbt=" + cVar.az() + "&tmorl=" + i3;
                            }
                            if (intValue <= i5 && !android.text.TextUtils.isEmpty(str)) {
                                com.anythink.expressad.a.a.a(context, cVar, cVar.K(), new java.lang.String[]{str}, true);
                                it.remove();
                                i4.remove(i6);
                                i6--;
                            }
                        }
                    }
                    i6++;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = "&";
        java.lang.String str5 = "";
        if (cVar == null || cVar2 == null) {
            return;
        }
        try {
            com.anythink.expressad.video.module.c.a aVar = new com.anythink.expressad.video.module.c.a(com.anythink.core.common.b.o.a().f());
            com.anythink.expressad.foundation.g.f.h.b bVar = new com.anythink.expressad.foundation.g.f.h.b();
            bVar.a("user_id", com.anythink.expressad.foundation.h.j.a(str2));
            bVar.a(com.anythink.expressad.d.a.b.aM, "1");
            bVar.a("reward_name", cVar2.a());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(cVar2.b());
            bVar.a("reward_amount", sb.toString());
            bVar.a("unit_id", str);
            bVar.a("click_id", cVar.aa());
            if (!android.text.TextUtils.isEmpty(str3)) {
                bVar.a("extra", str3);
            }
            aVar.a("", bVar);
            java.lang.String str6 = cVar.ak() + "/addReward?";
            java.lang.String trim = bVar.a().trim();
            if (!android.text.TextUtils.isEmpty(trim)) {
                if (!str6.endsWith("?") && !str6.endsWith("&")) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(str6);
                    if (!str6.contains("?")) {
                        str4 = "?";
                    }
                    sb2.append(str4);
                    str6 = sb2.toString();
                }
                str5 = str6 + trim;
            }
            com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), cVar, cVar.K(), str5, false);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
        if (cVar != null) {
            try {
                if (cVar.al() == null || cVar.al().size() <= 0) {
                    return;
                }
                for (java.lang.String str2 : cVar.al()) {
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), cVar, str, str2, false);
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(com.anythink.expressad.foundation.d.c cVar, java.util.Map<java.lang.Integer, java.lang.String> map, java.lang.String str, int i) {
        if (cVar == null || map == null) {
            return;
        }
        try {
            if (map.size() > 0) {
                java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.lang.String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    java.util.Map.Entry<java.lang.Integer, java.lang.String> next = it.next();
                    java.lang.Integer key = next.getKey();
                    java.lang.String value = next.getValue();
                    if (i == key.intValue() && !android.text.TextUtils.isEmpty(value)) {
                        com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), cVar, str, value, false);
                        it.remove();
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(java.lang.String str) {
        a.remove(str);
    }

    public static void b(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().j() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().j(), false);
    }

    public static void c(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().k() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().k(), false);
    }

    public static void d(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().q() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().q(), false);
    }

    public static void e(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().m() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().m(), false);
    }

    private static void f(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().d() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().d(), true);
    }

    private static void g(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().e() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().e(), false);
    }

    private static void h(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().f() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().f(), false);
    }

    private static void i(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().g() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().g(), false);
    }

    private static void j(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().h() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().h(), false);
    }

    private static void k(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().l() == null) {
            return;
        }
        java.lang.String K = cVar.K();
        java.util.ArrayList<java.lang.String> arrayList = a.get(K);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            a.put(K, arrayList);
        }
        if (arrayList.contains(cVar.aZ())) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().l(), false);
        arrayList.add(cVar.aZ());
    }
}
