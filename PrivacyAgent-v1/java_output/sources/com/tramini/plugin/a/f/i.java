package com.tramini.plugin.a.f;

/* loaded from: classes19.dex */
public final class i extends com.tramini.plugin.a.f.f {
    private static com.tramini.plugin.a.d.a a(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, org.json.JSONObject jSONObject, org.json.JSONArray jSONArray) {
        com.tramini.plugin.a.d.a a;
        int i;
        java.lang.reflect.Method[] methodArr;
        java.lang.Object invoke;
        java.lang.Object obj2 = obj;
        if (obj2 == null || !obj.getClass().getName().startsWith(str2)) {
            return null;
        }
        java.lang.String str5 = str + obj.getClass().getName() + ",";
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.tramini.plugin.a.f.f.a(obj.getClass(), arrayList);
            int size = arrayList.size();
            java.lang.reflect.Field[] fieldArr = new java.lang.reflect.Field[size];
            arrayList.toArray(fieldArr);
            if (size == 0) {
                return null;
            }
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                java.lang.reflect.Field field = fieldArr[i3];
                boolean z = true;
                field.setAccessible(true);
                java.lang.Object obj3 = field.get(obj2);
                java.lang.reflect.Method[] c = c(obj3, str3);
                if (obj3 != null && c != null) {
                    int length = c.length;
                    int i4 = 0;
                    while (i4 < length) {
                        java.lang.reflect.Method method = c[i4];
                        method.setAccessible(z);
                        try {
                            invoke = method.invoke(obj3, new java.lang.Object[i2]);
                        } catch (java.lang.Throwable unused) {
                        }
                        if (invoke instanceof org.json.JSONObject) {
                            if (((org.json.JSONObject) invoke).has(str4)) {
                                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                int i5 = 0;
                                while (i5 < jSONArray.length()) {
                                    try {
                                        java.lang.String optString = jSONArray.optString(i5);
                                        methodArr = c;
                                        try {
                                            java.lang.String optString2 = jSONObject.optString(optString);
                                            i = length;
                                            try {
                                                if (android.text.TextUtils.equals(optString2, "all")) {
                                                    jSONObject2.put(optString, invoke.toString());
                                                } else {
                                                    jSONObject2.put(optString, a(optString2, (org.json.JSONObject) invoke));
                                                }
                                                i5++;
                                                c = methodArr;
                                                length = i;
                                            } catch (java.lang.Throwable unused2) {
                                            }
                                        } catch (java.lang.Throwable unused3) {
                                        }
                                    } catch (java.lang.Throwable unused4) {
                                    }
                                }
                                methodArr = c;
                                i = length;
                                com.tramini.plugin.a.d.a aVar = new com.tramini.plugin.a.d.a();
                                aVar.a = jSONObject2;
                                return aVar;
                            }
                            methodArr = c;
                            i = length;
                            i4++;
                            c = methodArr;
                            length = i;
                            z = true;
                            i2 = 0;
                        }
                        methodArr = c;
                        i = length;
                        i4++;
                        c = methodArr;
                        length = i;
                        z = true;
                        i2 = 0;
                    }
                } else if (obj3 != null && !str5.contains(obj3.getClass().getName()) && (a = a(obj3, str5, str2, str3, str4, jSONObject, jSONArray)) != null) {
                    return a;
                }
                i3++;
                obj2 = obj;
                i2 = 0;
            }
            return null;
        } catch (java.lang.Throwable unused5) {
            return null;
        }
    }

    public static com.tramini.plugin.a.d.a a(org.json.JSONObject jSONObject, com.tramini.plugin.a.d.c cVar, java.lang.String str) {
        return a(com.tramini.plugin.a.f.f.a(jSONObject.optString("in_na"), str), "", jSONObject.optString("pre"), jSONObject.optString("mena"), jSONObject.optString("agu"), jSONObject, cVar.e);
    }

    private static java.lang.String a(java.lang.String str, org.json.JSONObject jSONObject) {
        java.lang.String[] split;
        int i;
        try {
            split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            i = 0;
        } catch (java.lang.Throwable unused) {
            return "";
        }
        while (i < split.length) {
            int i2 = i + 1;
            if (i2 == split.length) {
                return jSONObject.optString(split[i]);
            }
            try {
                jSONObject = new org.json.JSONObject(jSONObject.optString(split[i]));
            } catch (org.json.JSONException unused2) {
                jSONObject = new org.json.JSONArray(jSONObject.optString(split[i])).getJSONObject(0);
            }
            i = i2;
            return "";
        }
        return "";
    }

    private static java.lang.reflect.Method[] c(java.lang.Object obj, java.lang.String str) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.reflect.Method method : obj.getClass().getDeclaredMethods()) {
                if (method.getGenericReturnType().toString().contains(str)) {
                    arrayList.add(method);
                }
            }
            return (java.lang.reflect.Method[]) arrayList.toArray(new java.lang.reflect.Method[0]);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
