package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class JSONUtils {
    private static void addIndentBlank(java.lang.StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                sb.append('\t');
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return;
            }
        }
    }

    public static org.json.JSONObject cloneJsonObject(org.json.JSONObject jSONObject) throws com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException {
        if (jSONObject == null) {
            return new org.json.JSONObject();
        }
        try {
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(jSONObject);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(jSONObject.toString());
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                java.lang.Object obj = jSONObject.get(next);
                if (obj instanceof java.util.Date) {
                    jSONObject2.put(next, new java.util.Date(((java.util.Date) obj).getTime()));
                }
            }
            return jSONObject2;
        } catch (org.json.JSONException unused) {
            return jSONObject;
        }
    }

    public static java.lang.String formatJson(java.lang.String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    int i = 0;
                    char c = 0;
                    boolean z = false;
                    int i2 = 0;
                    while (i < str.length()) {
                        char charAt = str.charAt(i);
                        if (charAt == '\"') {
                            if (c != '\\') {
                                z = !z;
                            }
                            sb.append(charAt);
                        } else if (charAt != ',') {
                            if (charAt != '{') {
                                if (charAt != '}') {
                                    switch (charAt) {
                                        case '[':
                                            break;
                                        case '\\':
                                            break;
                                        case ']':
                                            break;
                                        default:
                                            sb.append(charAt);
                                            break;
                                    }
                                }
                                if (!z) {
                                    sb.append('\n');
                                    i2--;
                                    addIndentBlank(sb, i2);
                                }
                                sb.append(charAt);
                            }
                            sb.append(charAt);
                            if (!z) {
                                sb.append('\n');
                                i2++;
                                addIndentBlank(sb, i2);
                            }
                        } else {
                            sb.append(charAt);
                            if (c != '\\' && !z) {
                                sb.append('\n');
                                addIndentBlank(sb, i2);
                            }
                        }
                        i++;
                        c = charAt;
                    }
                    return sb.toString();
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
        return "";
    }

    public static boolean isJson(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String trim = str.trim();
            if (trim.startsWith("{") && trim.endsWith(com.alipay.sdk.m.u.i.d)) {
                return true;
            }
            if (trim.startsWith("[") && trim.endsWith("]")) {
                return true;
            }
        }
        return false;
    }

    public static java.util.Map<java.lang.String, java.lang.String> json2Map(org.json.JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        return hashMap;
    }

    public static void mergeDistinctProperty(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject == null) {
            return;
        }
        try {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                if (!jSONObject2.has(next)) {
                    java.lang.Object obj = jSONObject.get(next);
                    if (!(obj instanceof java.util.Date) || "$time".equals(next)) {
                        jSONObject2.put(next, obj);
                    } else {
                        jSONObject2.put(next, com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatDate((java.util.Date) obj, com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE));
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void mergeDuplicateProperty(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject == null) {
            return;
        }
        try {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                if (jSONObject2.has(next)) {
                    java.lang.Object obj = jSONObject.get(next);
                    if (!(obj instanceof java.util.Date) || "$time".equals(next)) {
                        jSONObject2.put(next, obj);
                    } else {
                        jSONObject2.put(next, com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatDate((java.util.Date) obj, com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE));
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void mergeJSONObject(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        if (jSONObject2 == null) {
            try {
                jSONObject2 = new org.json.JSONObject();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return;
            }
        }
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            java.lang.Object obj = jSONObject.get(next);
            if (!(obj instanceof java.util.Date) || "$time".equals(next)) {
                jSONObject2.put(next, obj);
            } else {
                jSONObject2.put(next, com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatDate((java.util.Date) obj, com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE));
            }
        }
    }

    public static org.json.JSONObject mergeSuperJSONObject(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        try {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                java.util.Iterator<java.lang.String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    java.lang.String next2 = keys2.next();
                    if (!android.text.TextUtils.isEmpty(next) && next.equalsIgnoreCase(next2)) {
                        keys2.remove();
                    }
                }
            }
            mergeJSONObject(jSONObject, jSONObject2);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return jSONObject2;
    }

    public static java.lang.String optionalStringKey(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }
}
