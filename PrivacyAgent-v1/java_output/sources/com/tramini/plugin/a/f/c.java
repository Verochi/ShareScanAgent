package com.tramini.plugin.a.f;

/* loaded from: classes19.dex */
public final class c extends com.tramini.plugin.a.f.f {
    private static com.tramini.plugin.a.d.a a(java.lang.Object obj, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, org.json.JSONArray jSONArray) {
        com.tramini.plugin.a.d.a a;
        if (obj == null || !obj.getClass().getName().startsWith(str2)) {
            return null;
        }
        java.lang.String str3 = str + obj.getClass().getName() + ",";
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.tramini.plugin.a.f.f.a(obj.getClass(), arrayList);
            int size = arrayList.size();
            java.lang.reflect.Field[] fieldArr = new java.lang.reflect.Field[size];
            arrayList.toArray(fieldArr);
            if (size == 0) {
                return null;
            }
            for (int i = 0; i < size; i++) {
                java.lang.reflect.Field field = fieldArr[i];
                field.setAccessible(true);
                java.lang.Object obj2 = field.get(obj);
                if (obj2 != null && (obj2 instanceof org.json.JSONObject)) {
                    try {
                        java.lang.String str4 = "";
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            java.lang.String optString = jSONArray.optString(i2);
                            java.lang.String optString2 = jSONObject.optString(optString);
                            if (android.text.TextUtils.equals(optString2, "all")) {
                                str4 = optString;
                            } else {
                                java.lang.String a2 = a(optString2, (org.json.JSONObject) obj2);
                                if (!android.text.TextUtils.isEmpty(a2)) {
                                    jSONObject2.put(optString, a2);
                                }
                            }
                        }
                        if (jSONObject2.length() != 0) {
                            com.tramini.plugin.a.d.a aVar = new com.tramini.plugin.a.d.a();
                            if (!android.text.TextUtils.isEmpty(str4)) {
                                jSONObject2.put(str4, obj2.toString());
                            }
                            aVar.a = jSONObject2;
                            return aVar;
                        }
                        continue;
                    } catch (java.lang.Throwable unused) {
                        continue;
                    }
                } else if (obj2 != null && !str3.contains(obj2.getClass().getName()) && (a = a(obj2, str3, str2, jSONObject, jSONArray)) != null) {
                    return a;
                }
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static com.tramini.plugin.a.d.a a(org.json.JSONObject jSONObject, com.tramini.plugin.a.d.c cVar, java.lang.String str) {
        return a(com.tramini.plugin.a.f.f.a(jSONObject.optString("in_na"), str), "", jSONObject.optString("pre"), jSONObject, cVar.e);
    }

    private static java.lang.String a(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            int i = 0;
            while (i < split.length) {
                int i2 = i + 1;
                if (i2 == split.length) {
                    return jSONObject.optString(split[i]);
                }
                jSONObject = jSONObject.optJSONObject(split[i]);
                i = i2;
            }
            return "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
