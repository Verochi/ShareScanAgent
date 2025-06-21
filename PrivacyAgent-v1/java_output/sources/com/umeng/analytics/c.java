package com.umeng.analytics;

/* loaded from: classes19.dex */
public class c {
    private static final int a = 20;
    private static final java.lang.String b = "umeng_pcp";
    private static final java.lang.String c = "mob";
    private static final java.lang.String d = "em";
    private static final java.lang.String e = "cp";
    private static final java.lang.String f = "pk";
    private static final java.lang.String g = "pv";
    private static java.lang.String[] h = new java.lang.String[2];
    private static java.lang.Object i = new java.lang.Object();
    private static java.util.Map<java.lang.String, java.lang.Object> j = new java.util.HashMap();

    public static java.lang.String a() {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            android.content.SharedPreferences sharedPreferences = appContext.getSharedPreferences(b, 0);
            java.lang.String string = sharedPreferences.getString(c, "");
            if (com.umeng.analytics.pro.f.Q.equals(string)) {
                sharedPreferences.edit().putString(c, "").apply();
                return "";
            }
            if (android.text.TextUtils.isEmpty(string)) {
                return null;
            }
            sharedPreferences.edit().putString(c, "").apply();
            return new java.lang.String(com.umeng.analytics.pro.ax.a(android.util.Base64.decode(string, 0), com.umeng.commonsdk.UMConfigure.sAppkey.getBytes()));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String[] strArr = h;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null) {
            org.json.JSONStringer jSONStringer = new org.json.JSONStringer();
            try {
                synchronized (i) {
                    jSONStringer.array();
                    for (java.lang.String str : map.keySet()) {
                        jSONStringer.object();
                        jSONStringer.key("pk");
                        jSONStringer.value(str);
                        jSONStringer.key("pv");
                        jSONStringer.value(map.get(str));
                        jSONStringer.endObject();
                    }
                    jSONStringer.endArray();
                }
                android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(b, 0);
                sharedPreferences.edit().putString("cp", android.util.Base64.encodeToString(com.umeng.analytics.pro.ax.a(jSONStringer.toString().getBytes(), com.umeng.commonsdk.UMConfigure.sAppkey.getBytes()), 0)).apply();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(java.lang.String str) {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                android.content.SharedPreferences sharedPreferences = appContext.getSharedPreferences(b, 0);
                byte[] a2 = com.umeng.analytics.pro.ax.a(str.getBytes(), com.umeng.commonsdk.UMConfigure.sAppkey.getBytes());
                sharedPreferences.edit().putString(c, a2.length == 0 ? com.umeng.analytics.pro.f.Q : android.util.Base64.encodeToString(a2, 0)).apply();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(java.lang.String str, java.lang.Object obj) {
        synchronized (i) {
            if (j.containsKey(str)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "更新账号自定义KV: key=" + str + "; val=" + obj);
                j.put(str, obj);
                a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), j);
            } else {
                if (j.size() >= 20) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "设置账号自定义KV: 已经设置20个KV键值对，忽略设置请求。");
                    com.umeng.commonsdk.statistics.common.MLog.e("userProfile: Only 20 user-defined key-value pairs can be configured, please check!");
                    return;
                }
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "设置账号自定义KV: key=" + str + "; val=" + obj);
                j.put(str, obj);
                a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), j);
            }
        }
    }

    public static java.lang.String[] a(android.content.Context context) {
        java.lang.String[] a2;
        if (!android.text.TextUtils.isEmpty(h[0]) && !android.text.TextUtils.isEmpty(h[1])) {
            return h;
        }
        if (context == null || (a2 = com.umeng.common.b.a(context).a()) == null) {
            return null;
        }
        java.lang.String[] strArr = h;
        strArr[0] = a2[0];
        strArr[1] = a2[1];
        return strArr;
    }

    public static java.lang.String b() {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            android.content.SharedPreferences sharedPreferences = appContext.getSharedPreferences(b, 0);
            java.lang.String string = sharedPreferences.getString(d, "");
            if (com.umeng.analytics.pro.f.Q.equals(string)) {
                sharedPreferences.edit().putString(d, "").apply();
                return "";
            }
            if (android.text.TextUtils.isEmpty(string)) {
                return null;
            }
            sharedPreferences.edit().putString(d, "").apply();
            return new java.lang.String(com.umeng.analytics.pro.ax.a(android.util.Base64.decode(string, 0), com.umeng.commonsdk.UMConfigure.sAppkey.getBytes()));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static void b(android.content.Context context) {
        java.lang.String[] strArr = h;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }

    public static void b(java.lang.String str) {
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                android.content.SharedPreferences sharedPreferences = appContext.getSharedPreferences(b, 0);
                byte[] a2 = com.umeng.analytics.pro.ax.a(str.getBytes(), com.umeng.commonsdk.UMConfigure.sAppkey.getBytes());
                sharedPreferences.edit().putString(d, a2.length == 0 ? com.umeng.analytics.pro.f.Q : android.util.Base64.encodeToString(a2, 0)).apply();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static java.util.Map<java.lang.String, java.lang.Object> c(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(b, 0);
        java.lang.String string = sharedPreferences.getString("cp", "");
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            java.lang.String str = new java.lang.String(com.umeng.analytics.pro.ax.a(android.util.Base64.decode(string, 0), com.umeng.commonsdk.UMConfigure.sAppkey.getBytes()));
            if (str.length() <= 0) {
                return null;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            try {
                org.json.JSONArray jSONArray = (org.json.JSONArray) new org.json.JSONTokener(str).nextValue();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    org.json.JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    hashMap.put(jSONObject.getString("pk"), jSONObject.get("pv"));
                }
                sharedPreferences.edit().putString("cp", "").apply();
                return hashMap;
            } catch (java.lang.Throwable unused) {
                return hashMap;
            }
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }
}
