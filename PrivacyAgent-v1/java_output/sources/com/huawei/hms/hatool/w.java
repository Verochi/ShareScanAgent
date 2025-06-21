package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class w {
    public static java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> a(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return null;
        }
        java.util.Map<java.lang.String, ?> a = com.huawei.hms.hatool.g0.a(context, str);
        b(a);
        return a(a);
    }

    public static java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> a;
        java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> a2;
        if ("alltype".equals(str2) || android.text.TextUtils.isEmpty(str)) {
            com.huawei.hms.hatool.y.c("hmsSdk", "read all event records");
            a = a(context, "stat_v2_1");
            a2 = a(context, "cached_v2_1");
        } else {
            java.lang.String a3 = com.huawei.hms.hatool.u0.a(str, str2);
            a = b(context, "stat_v2_1", a3);
            a2 = b(context, "cached_v2_1", a3);
        }
        return a(a, a2);
    }

    public static java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> a(java.util.Map<java.lang.String, ?> map) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, ?> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            if (entry.getValue() instanceof java.lang.String) {
                a(key, (java.lang.String) entry.getValue(), hashMap);
            }
        }
        return hashMap;
    }

    public static java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> a(java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> map, java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new java.util.HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        java.util.HashMap hashMap = new java.util.HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    public static void a(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> map) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray(str2);
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                com.huawei.hms.hatool.q qVar = new com.huawei.hms.hatool.q();
                try {
                    qVar.a(jSONArray.getJSONObject(i));
                    arrayList.add(qVar);
                } catch (org.json.JSONException unused) {
                    com.huawei.hms.hatool.y.e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                }
            }
            map.put(str, arrayList);
        } catch (org.json.JSONException unused2) {
            com.huawei.hms.hatool.y.e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    public static java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String a = com.huawei.hms.hatool.g0.a(context, str, str2, "");
        java.util.HashMap hashMap = new java.util.HashMap();
        a(str2, a, hashMap);
        return hashMap;
    }

    public static void b(java.util.Map<java.lang.String, ?> map) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, ?>> it = map.entrySet().iterator();
        java.util.Set<java.lang.String> a = com.huawei.hms.hatool.u0.a(com.huawei.hms.hatool.b.b());
        while (it.hasNext()) {
            if (!a.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }
}
