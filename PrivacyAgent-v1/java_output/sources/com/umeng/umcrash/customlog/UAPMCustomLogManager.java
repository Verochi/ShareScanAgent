package com.umeng.umcrash.customlog;

/* loaded from: classes19.dex */
public class UAPMCustomLogManager {
    private static final int MAX_CACHE_SIZE = 100;
    private static final int MAX_MSG_LENGTH = 2048;
    private static final int MAX_TAG_LENGTH = 64;
    private static final java.lang.String TAG = "UAPMCustomLogManager";
    private static final org.json.JSONArray jsonObjects = new org.json.JSONArray();
    private static int sCacheSize = 100;

    private static void addCustomLogs(java.lang.String str, java.lang.String str2, int i) {
        synchronized (com.umeng.umcrash.customlog.UAPMCustomLogManager.class) {
            try {
                if (str.length() > 64) {
                    str = com.umeng.umcrash.UMCrashUtils.splitByByte(str, 64);
                }
                if (str2.length() > 2048) {
                    str2 = com.umeng.umcrash.UMCrashUtils.splitByByte(str2, 2048);
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("tag", str);
                jSONObject.put("msg", str2);
                jSONObject.put("l", i);
                jSONObject.put("t", java.lang.System.currentTimeMillis());
                jSONObject.put("pid", android.os.Process.myPid());
                jSONObject.put("tid", android.os.Process.myTid());
                org.json.JSONArray jSONArray = jsonObjects;
                if (jSONArray.length() >= sCacheSize) {
                    jSONArray.remove(0);
                    jSONArray.put(jSONObject);
                } else {
                    jSONArray.put(jSONObject);
                }
            } finally {
            }
        }
    }

    private static boolean checkParams(java.lang.String str, java.lang.String str2) {
        return (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) ? false : true;
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (checkParams(str, str2)) {
            addCustomLogs(str, str2, 1);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        if (checkParams(str, str2)) {
            addCustomLogs(str, str2, 4);
        }
    }

    public static java.lang.String getCustomLogs() {
        java.lang.String jSONArray;
        synchronized (com.umeng.umcrash.customlog.UAPMCustomLogManager.class) {
            try {
                jSONArray = jsonObjects.toString();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return jSONArray;
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        if (checkParams(str, str2)) {
            addCustomLogs(str, str2, 2);
        }
    }

    public static void setCache(int i) {
        sCacheSize = java.lang.Math.min(i, 100);
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        if (checkParams(str, str2)) {
            addCustomLogs(str, str2, 0);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        if (checkParams(str, str2)) {
            addCustomLogs(str, str2, 3);
        }
    }
}
