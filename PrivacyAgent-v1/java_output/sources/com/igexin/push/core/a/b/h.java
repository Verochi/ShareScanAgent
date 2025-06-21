package com.igexin.push.core.a.b;

/* loaded from: classes23.dex */
public final class h extends com.igexin.push.core.a.b.a {
    private static final java.lang.String a = com.igexin.push.config.c.a + "_RedirectServerAction";

    private static void a(java.lang.String str, org.json.JSONArray jSONArray) {
        try {
            com.igexin.c.a.c.a.a(a + "|start fetch idc config, url : " + str, new java.lang.Object[0]);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.g.a.f(new com.igexin.push.core.h.b(str, jSONArray)), false, true);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(a + e.toString(), new java.lang.Object[0]);
        }
    }

    private static void a(org.json.JSONObject jSONObject) {
        long optLong = jSONObject.optLong("delay");
        if (optLong >= 0) {
            com.igexin.push.core.e.b(optLong);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("address_list");
        com.igexin.c.a.c.a.a("redirect|" + optLong + "|" + optJSONArray.toString(), new java.lang.Object[0]);
        for (int i = 0; i < optJSONArray.length(); i++) {
            java.lang.String optString = optJSONArray.optString(i);
            int indexOf = optString.indexOf(44);
            if (indexOf > 0) {
                java.lang.String substring = optString.substring(0, indexOf);
                java.lang.String substring2 = optString.substring(indexOf + 1);
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                try {
                    long parseLong = java.lang.Long.parseLong(substring2);
                    com.igexin.push.c.a.b bVar = new com.igexin.push.c.a.b();
                    bVar.a = "socket://".concat(java.lang.String.valueOf(substring));
                    bVar.b = currentTimeMillis + (parseLong * 1000);
                    arrayList.add(bVar);
                } catch (java.lang.NumberFormatException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
        }
        com.igexin.push.c.c.a().d().a(arrayList);
    }

    public static java.lang.String[] a(org.json.JSONArray jSONArray) {
        java.lang.String[] strArr = null;
        try {
            strArr = new java.lang.String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = "https://" + jSONArray.getString(i);
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(a + "|parseIDCConfigURL exception" + e.toString(), new java.lang.Object[0]);
        }
        return strArr;
    }

    private static void b(org.json.JSONObject jSONObject) {
        if (jSONObject.has("loc") && jSONObject.has("conf")) {
            try {
                com.igexin.push.config.SDKUrlConfig.setLocation(jSONObject.getString("loc"));
                java.lang.String str = com.igexin.push.core.e.a;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.lang.String str2 = a;
                sb.append(str2);
                sb.append(" set group id : ");
                sb.append(com.igexin.push.core.e.f);
                com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
                org.json.JSONArray jSONArray = jSONObject.getJSONArray("conf");
                java.lang.String[] a2 = a(jSONArray);
                if (a2 == null || a2.length <= 1) {
                    return;
                }
                java.lang.String[] idcConfigUrl = com.igexin.push.config.SDKUrlConfig.getIdcConfigUrl();
                if (idcConfigUrl != null && (idcConfigUrl.length <= 1 || a2[1].equals(idcConfigUrl[1]))) {
                    com.igexin.c.a.c.a.a(str2 + "|current idc config url == new idc config url, return", new java.lang.Object[0]);
                    return;
                }
                if (com.igexin.push.core.e.ao == 0) {
                    a(a2[1], jSONArray);
                    return;
                }
                if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.ao > 7200000) {
                    a(a2[1], jSONArray);
                    return;
                }
                com.igexin.c.a.c.a.a(str2 + "|get idc cfg last time less than 2 hours return", new java.lang.Object[0]);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(a + e.toString(), new java.lang.Object[0]);
            }
        }
    }

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str2 = a;
        sb.append(str2);
        sb.append("|redirect server resp data : ");
        sb.append(jSONObject);
        com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
        try {
            a(jSONObject);
            com.igexin.c.a.b.a.a.d.a().g();
            if (jSONObject.has("loc") && jSONObject.has("conf")) {
                try {
                    com.igexin.push.config.SDKUrlConfig.setLocation(jSONObject.getString("loc"));
                    java.lang.String str3 = com.igexin.push.core.e.a;
                    com.igexin.c.a.c.a.a(str2 + " set group id : " + com.igexin.push.core.e.f, new java.lang.Object[0]);
                    org.json.JSONArray jSONArray = jSONObject.getJSONArray("conf");
                    java.lang.String[] a2 = a(jSONArray);
                    if (a2 != null && a2.length > 1) {
                        java.lang.String[] idcConfigUrl = com.igexin.push.config.SDKUrlConfig.getIdcConfigUrl();
                        if (idcConfigUrl != null && (idcConfigUrl.length <= 1 || a2[1].equals(idcConfigUrl[1]))) {
                            com.igexin.c.a.c.a.a(str2 + "|current idc config url == new idc config url, return", new java.lang.Object[0]);
                        }
                        if (com.igexin.push.core.e.ao == 0) {
                            str = a2[1];
                        } else if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.ao > 7200000) {
                            str = a2[1];
                        } else {
                            com.igexin.c.a.c.a.a(str2 + "|get idc cfg last time less than 2 hours return", new java.lang.Object[0]);
                        }
                        a(str, jSONArray);
                    }
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a(a + e.toString(), new java.lang.Object[0]);
                }
            }
            if (com.igexin.push.h.g.a()) {
                com.igexin.c.a.c.a.a(a + "|redirect reInit so ~~~~~", new java.lang.Object[0]);
                com.igexin.push.h.g.d();
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(a + e2.toString(), new java.lang.Object[0]);
        }
        return true;
    }
}
