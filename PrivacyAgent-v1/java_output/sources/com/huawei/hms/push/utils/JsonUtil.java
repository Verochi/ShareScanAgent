package com.huawei.hms.push.utils;

/* loaded from: classes22.dex */
public class JsonUtil {
    public static void a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.Object obj, android.os.Bundle bundle) {
        if (obj == null) {
            com.huawei.hms.support.log.HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
            return;
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str2 = (java.lang.String) obj;
            bundle.putString(str, getString(jSONObject, str, android.text.TextUtils.isEmpty(str2) ? null : str2));
            return;
        }
        if (obj instanceof java.lang.Integer) {
            bundle.putInt(str, getInt(jSONObject, str, ((java.lang.Integer) obj).intValue()));
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            bundle.putIntArray(str, getIntArray(jSONObject, str, iArr.length != 0 ? iArr : null));
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            bundle.putLongArray(str, getLongArray(jSONObject, str, jArr.length != 0 ? jArr : null));
        } else if (!(obj instanceof java.lang.String[])) {
            com.huawei.hms.support.log.HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
        } else {
            java.lang.String[] strArr = (java.lang.String[]) obj;
            bundle.putStringArray(str, getStringArray(jSONObject, str, strArr.length != 0 ? strArr : null));
        }
    }

    public static int getInt(org.json.JSONObject jSONObject, java.lang.String str, int i) {
        if (jSONObject == null) {
            return i;
        }
        try {
            return jSONObject.has(str) ? jSONObject.getInt(str) : i;
        } catch (org.json.JSONException unused) {
            com.huawei.hms.support.log.HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            return i;
        }
    }

    public static int[] getIntArray(org.json.JSONObject jSONObject, java.lang.String str, int[] iArr) {
        int[] iArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    org.json.JSONArray jSONArray = jSONObject.getJSONArray(str);
                    iArr2 = new int[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        iArr2[i] = ((java.lang.Integer) jSONArray.get(i)).intValue();
                    }
                }
            } catch (org.json.JSONException unused) {
                com.huawei.hms.support.log.HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return iArr2 == null ? iArr : iArr2;
    }

    public static org.json.JSONArray getIntJsonArray(int[] iArr) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (iArr != null && iArr.length != 0) {
            for (int i : iArr) {
                jSONArray.put(i);
            }
        }
        return jSONArray;
    }

    public static long[] getLongArray(org.json.JSONObject jSONObject, java.lang.String str, long[] jArr) {
        long[] jArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    org.json.JSONArray jSONArray = jSONObject.getJSONArray(str);
                    jArr2 = new long[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        jArr2[i] = jSONArray.getLong(i);
                    }
                }
            } catch (org.json.JSONException unused) {
                com.huawei.hms.support.log.HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return jArr2 == null ? jArr : jArr2;
    }

    public static org.json.JSONArray getLongJsonArray(long[] jArr) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (jArr != null && jArr.length != 0) {
            for (long j : jArr) {
                jSONArray.put(j);
            }
        }
        return jSONArray;
    }

    public static java.lang.String getString(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        if (jSONObject == null) {
            return str2;
        }
        try {
            return (!jSONObject.has(str) || jSONObject.get(str) == null) ? str2 : java.lang.String.valueOf(jSONObject.get(str));
        } catch (org.json.JSONException unused) {
            com.huawei.hms.support.log.HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            return str2;
        }
    }

    public static java.lang.String[] getStringArray(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String[] strArr) {
        java.lang.String[] strArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    org.json.JSONArray jSONArray = jSONObject.getJSONArray(str);
                    strArr2 = new java.lang.String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = (java.lang.String) jSONArray.get(i);
                    }
                }
            } catch (org.json.JSONException unused) {
                com.huawei.hms.support.log.HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return strArr2;
    }

    public static org.json.JSONArray getStringJsonArray(java.lang.String[] strArr) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (strArr != null && strArr.length != 0) {
            for (java.lang.String str : strArr) {
                jSONArray.put(str);
            }
        }
        return jSONArray;
    }

    public static void transferJsonObjectToBundle(org.json.JSONObject jSONObject, android.os.Bundle bundle, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : hashMap.entrySet()) {
            a(jSONObject, entry.getKey(), entry.getValue(), bundle);
        }
    }
}
