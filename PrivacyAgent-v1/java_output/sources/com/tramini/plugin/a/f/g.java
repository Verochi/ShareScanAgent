package com.tramini.plugin.a.f;

/* loaded from: classes19.dex */
public final class g extends com.tramini.plugin.a.f.f {
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5 A[Catch: all -> 0x011b, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x011b, blocks: (B:23:0x007b, B:25:0x0081, B:28:0x00c5, B:68:0x0086, B:70:0x008c), top: B:22:0x007b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.tramini.plugin.a.d.a a(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, org.json.JSONObject jSONObject, org.json.JSONArray jSONArray) {
        int i;
        java.lang.reflect.Method[] methodArr;
        int i2;
        java.lang.Object invoke;
        org.json.JSONObject optJSONObject;
        java.lang.Object obj2 = obj;
        java.lang.String str7 = str5;
        if (obj2 == null || !obj.getClass().getName().startsWith(str2)) {
            return null;
        }
        java.lang.String str8 = str + obj.getClass().getName() + ",";
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.tramini.plugin.a.f.f.a(obj.getClass(), arrayList);
            int size = arrayList.size();
            java.lang.reflect.Field[] fieldArr = new java.lang.reflect.Field[size];
            arrayList.toArray(fieldArr);
            if (size == 0) {
                return null;
            }
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                java.lang.reflect.Field field = fieldArr[i4];
                boolean z = true;
                field.setAccessible(true);
                java.lang.Object obj3 = field.get(obj2);
                java.lang.reflect.Method[] c = c(obj3, str3);
                if (obj3 != null && c != null) {
                    int length = c.length;
                    int i5 = 0;
                    while (i5 < length) {
                        java.lang.reflect.Method method = c[i5];
                        method.setAccessible(z);
                        try {
                            invoke = method.invoke(obj3, new java.lang.Object[i3]);
                        } catch (java.lang.Throwable unused) {
                        }
                        if (invoke instanceof org.json.JSONObject) {
                            if (((org.json.JSONObject) invoke).has(str4)) {
                                optJSONObject = (org.json.JSONObject) invoke;
                            } else {
                                if (!android.text.TextUtils.isEmpty(str5) && ((org.json.JSONObject) invoke).has(str7)) {
                                    try {
                                        org.json.JSONArray optJSONArray = ((org.json.JSONObject) invoke).optJSONArray(str7);
                                        optJSONObject = (optJSONArray == null || optJSONArray.length() <= 0) ? null : optJSONArray.getJSONObject(i3);
                                    } catch (java.lang.Throwable unused2) {
                                    }
                                } else if (!android.text.TextUtils.isEmpty(str6)) {
                                    try {
                                        optJSONObject = ((org.json.JSONObject) invoke).optJSONObject(str6);
                                    } catch (java.lang.Throwable unused3) {
                                        optJSONObject = null;
                                        if (optJSONObject != null) {
                                        }
                                        methodArr = c;
                                        i2 = length;
                                        i5++;
                                        str7 = str5;
                                        c = methodArr;
                                        length = i2;
                                        z = true;
                                        i3 = 0;
                                    }
                                    if (optJSONObject != null) {
                                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                        methodArr = c;
                                        int i6 = 0;
                                        while (i6 < jSONArray.length()) {
                                            try {
                                                int i7 = length;
                                                try {
                                                    java.lang.String optString = jSONArray.optString(i6);
                                                    try {
                                                        java.lang.String optString2 = jSONObject.optString(optString);
                                                        if (android.text.TextUtils.equals(optString2, "all")) {
                                                            jSONObject2.put(optString, optJSONObject.toString());
                                                        } else {
                                                            java.lang.String a = a(optString2, optJSONObject);
                                                            if (!android.text.TextUtils.isEmpty(a)) {
                                                                jSONObject2.put(optString, a);
                                                            }
                                                        }
                                                    } catch (java.lang.Throwable unused4) {
                                                    }
                                                } catch (java.lang.Throwable unused5) {
                                                }
                                                i6++;
                                                length = i7;
                                            } catch (java.lang.Throwable unused6) {
                                            }
                                        }
                                        i2 = length;
                                        try {
                                            com.tramini.plugin.a.d.a aVar = new com.tramini.plugin.a.d.a();
                                            aVar.a = jSONObject2;
                                            return aVar;
                                        } catch (java.lang.Throwable unused7) {
                                            continue;
                                        }
                                    }
                                    methodArr = c;
                                    i2 = length;
                                    i5++;
                                    str7 = str5;
                                    c = methodArr;
                                    length = i2;
                                    z = true;
                                    i3 = 0;
                                }
                                optJSONObject = null;
                                if (optJSONObject != null) {
                                }
                                methodArr = c;
                                i2 = length;
                                i5++;
                                str7 = str5;
                                c = methodArr;
                                length = i2;
                                z = true;
                                i3 = 0;
                            }
                            if (optJSONObject != null) {
                            }
                            methodArr = c;
                            i2 = length;
                            i5++;
                            str7 = str5;
                            c = methodArr;
                            length = i2;
                            z = true;
                            i3 = 0;
                        }
                        methodArr = c;
                        i2 = length;
                        i5++;
                        str7 = str5;
                        c = methodArr;
                        length = i2;
                        z = true;
                        i3 = 0;
                    }
                } else if (obj3 != null && !str8.contains(obj3.getClass().getName())) {
                    i = i4;
                    com.tramini.plugin.a.d.a a2 = a(obj3, str8, str2, str3, str4, str5, str6, jSONObject, jSONArray);
                    if (a2 != null) {
                        return a2;
                    }
                    i4 = i + 1;
                    obj2 = obj;
                    str7 = str5;
                    i3 = 0;
                }
                i = i4;
                i4 = i + 1;
                obj2 = obj;
                str7 = str5;
                i3 = 0;
            }
            return null;
        } catch (java.lang.Throwable unused8) {
            return null;
        }
    }

    public static com.tramini.plugin.a.d.a a(org.json.JSONObject jSONObject, com.tramini.plugin.a.d.c cVar, java.lang.String str) {
        return a(com.tramini.plugin.a.f.f.a(jSONObject.optString("in_na"), str), "", jSONObject.optString("pre"), jSONObject.optString("mena"), jSONObject.optString("agu"), jSONObject.optString("agu_v2"), jSONObject.optString("agu_v3"), jSONObject, cVar.e);
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
