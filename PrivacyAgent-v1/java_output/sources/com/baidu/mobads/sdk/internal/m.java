package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class m {
    @android.annotation.TargetApi(8)
    public static android.graphics.Bitmap a(java.lang.String str) {
        try {
            byte[] decode = android.util.Base64.decode(str, 0);
            return android.graphics.BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object a(org.json.JSONObject jSONObject, java.lang.String str) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.opt(str) : "";
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> a(java.util.Map<java.lang.String, java.lang.String> map) {
        int length;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    java.util.HashMap hashMap = new java.util.HashMap(map);
                    java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
                    int i = 0;
                    for (java.lang.String str : com.baidu.mobads.sdk.api.ArticleInfo.PREDEFINED_KEYS) {
                        if (hashMap.containsKey(str)) {
                            java.lang.String str2 = (java.lang.String) hashMap.remove(str);
                            if (!android.text.TextUtils.isEmpty(str2) && (length = str2.length() + i) < 150) {
                                hashMap2.put(str, str2);
                                i = length;
                            }
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        java.util.Set<java.lang.String> keySet = hashMap.keySet();
                        org.json.JSONArray jSONArray = new org.json.JSONArray();
                        for (java.lang.String str3 : keySet) {
                            if (!android.text.TextUtils.isEmpty(str3)) {
                                java.lang.String str4 = (java.lang.String) hashMap.get(str3);
                                if (!android.text.TextUtils.isEmpty(str4)) {
                                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                                    jSONObject.put("k", str3);
                                    jSONObject.put("v", str4);
                                    jSONArray.put(jSONObject);
                                }
                            }
                        }
                        if (jSONArray.length() > 0) {
                            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                            jSONObject2.put("ext", jSONArray.toString());
                            if (jSONObject2.toString().length() < 3000) {
                                hashMap2.put("ext", jSONObject2.toString());
                            }
                        }
                    }
                    return hashMap2;
                }
            } catch (java.lang.Throwable unused) {
                return new java.util.HashMap<>();
            }
        }
        return new java.util.HashMap<>();
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        try {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
        } catch (java.lang.Exception unused) {
            com.baidu.mobads.sdk.internal.bt.a().a("json2HashMap error");
        }
        return hashMap;
    }

    public static org.json.JSONArray a(java.util.List<java.lang.String[]> list) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                for (int i2 = 0; i2 < list.get(i).length; i2++) {
                    jSONArray2.put(list.get(i)[i2]);
                }
                jSONArray.put(jSONArray2);
            } catch (java.lang.Exception e) {
                com.baidu.mobads.sdk.internal.bt.a().a(e);
            }
        }
        return jSONArray;
    }

    public static org.json.JSONArray a(double[] dArr) {
        org.json.JSONArray jSONArray = null;
        if (dArr == null) {
            return null;
        }
        try {
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            for (double d : dArr) {
                try {
                    jSONArray2.put(d);
                } catch (java.lang.Exception e) {
                    e = e;
                    jSONArray = jSONArray2;
                    com.baidu.mobads.sdk.internal.bt.a().a(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    public static org.json.JSONObject a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        try {
            return new org.json.JSONObject(hashMap);
        } catch (java.lang.Exception unused) {
            com.baidu.mobads.sdk.internal.bt.a().a("hashMap2Json error");
            return null;
        }
    }

    public static org.json.JSONObject a(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }
}
