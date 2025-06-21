package com.tramini.plugin.a.f;

/* loaded from: classes19.dex */
public final class d extends com.tramini.plugin.a.f.f {
    private static com.tramini.plugin.a.d.a a(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject, org.json.JSONArray jSONArray) {
        com.tramini.plugin.a.d.a a;
        if (obj == null || !obj.getClass().getName().startsWith(str2)) {
            return null;
        }
        java.lang.String str4 = str + obj.getClass().getName() + ",";
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.tramini.plugin.a.f.f.a(obj.getClass(), arrayList);
            int size = arrayList.size();
            java.lang.reflect.Field[] fieldArr = new java.lang.reflect.Field[size];
            arrayList.toArray(fieldArr);
            if (size == 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                java.lang.reflect.Field field = fieldArr[i2];
                field.setAccessible(true);
                java.lang.Object obj2 = field.get(obj);
                java.lang.reflect.Method c = c(obj2, str3);
                if (obj2 != null && c != null) {
                    c.setAccessible(true);
                    try {
                        java.lang.Object invoke = c.invoke(obj2, new java.lang.Object[i]);
                        if (invoke instanceof org.json.JSONObject) {
                            java.lang.String str5 = "";
                            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                try {
                                    java.lang.String optString = jSONArray.optString(i3);
                                    try {
                                        java.lang.String optString2 = jSONObject.optString(optString);
                                        if (android.text.TextUtils.equals(optString2, "all")) {
                                            str5 = optString;
                                        } else {
                                            java.lang.String d = d(invoke, optString2);
                                            if (!android.text.TextUtils.isEmpty(d)) {
                                                jSONObject2.put(optString, d);
                                            }
                                        }
                                    } catch (java.lang.Throwable unused) {
                                    }
                                } catch (java.lang.Throwable unused2) {
                                }
                            }
                            try {
                                if (jSONObject2.length() > 0) {
                                    com.tramini.plugin.a.d.a aVar = new com.tramini.plugin.a.d.a();
                                    if (!android.text.TextUtils.isEmpty(str5)) {
                                        jSONObject2.put(str5, invoke.toString());
                                    }
                                    aVar.a = jSONObject2;
                                    return aVar;
                                }
                                continue;
                            } catch (java.lang.Throwable unused3) {
                                continue;
                            }
                        }
                    } catch (java.lang.Throwable unused4) {
                    }
                } else if (obj2 != null && !str4.contains(obj2.getClass().getName()) && (a = a(obj2, str4, str2, str3, jSONObject, jSONArray)) != null) {
                    return a;
                }
                i2++;
                i = 0;
            }
            return null;
        } catch (java.lang.Throwable unused5) {
            return null;
        }
    }

    public static com.tramini.plugin.a.d.a a(org.json.JSONObject jSONObject, com.tramini.plugin.a.d.c cVar, java.lang.String str) {
        return a(com.tramini.plugin.a.f.f.a(jSONObject.optString("in_na"), str), "", jSONObject.optString("pre"), jSONObject.optString("mena"), jSONObject, cVar.e);
    }

    private static java.lang.reflect.Method c(java.lang.Object obj, java.lang.String str) {
        try {
            java.util.ArrayList<java.lang.reflect.Method> arrayList = new java.util.ArrayList();
            com.tramini.plugin.a.f.f.b(obj.getClass(), arrayList);
            for (java.lang.reflect.Method method : arrayList) {
                if (method.getGenericReturnType().toString().contains(str)) {
                    return method;
                }
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static java.lang.String d(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof org.json.JSONObject) {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            if (jSONObject.has(str)) {
                return jSONObject.optString(str);
            }
            while (keys.hasNext()) {
                java.lang.Object opt = jSONObject.opt(keys.next());
                if ((opt instanceof org.json.JSONObject) || (opt instanceof org.json.JSONArray)) {
                    java.lang.String d = d(opt, str);
                    if (!android.text.TextUtils.isEmpty(d)) {
                        return d;
                    }
                }
            }
        }
        if (!(obj instanceof org.json.JSONArray)) {
            return null;
        }
        int i = 0;
        while (true) {
            org.json.JSONArray jSONArray = (org.json.JSONArray) obj;
            if (i >= jSONArray.length()) {
                return null;
            }
            java.lang.Object opt2 = jSONArray.opt(i);
            if ((opt2 instanceof org.json.JSONObject) || (opt2 instanceof org.json.JSONArray)) {
                java.lang.String d2 = d(opt2, str);
                if (!android.text.TextUtils.isEmpty(d2)) {
                    return d2;
                }
            }
            i++;
        }
    }
}
