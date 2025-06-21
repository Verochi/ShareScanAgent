package com.huawei.hms.aaid.utils;

/* loaded from: classes22.dex */
public class BaseUtils {
    public static void clearSubjectIds(android.content.Context context) {
        com.huawei.hms.opendevice.i.a(context).removeKey("subjectId");
    }

    public static void delLocalToken(android.content.Context context, java.lang.String str) {
        com.huawei.hms.opendevice.i.a(context).c(str);
    }

    public static void deleteAllTokenCache(android.content.Context context) {
        com.huawei.hms.opendevice.i.a(context).a();
    }

    public static void deleteCacheData(android.content.Context context, java.lang.String str) {
        com.huawei.hms.opendevice.i.a(context).removeKey(str);
    }

    public static java.lang.String getBaseUrl(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return com.huawei.hms.opendevice.e.a(context, str, str2, str3, str4);
    }

    public static java.lang.String getCacheData(android.content.Context context, java.lang.String str, boolean z) {
        return z ? com.huawei.hms.opendevice.i.a(context).a(str) : com.huawei.hms.opendevice.i.a(context).getString(str);
    }

    public static java.lang.String getLocalToken(android.content.Context context, java.lang.String str) {
        return com.huawei.hms.opendevice.i.a(context).b(str);
    }

    public static boolean getProxyInit(android.content.Context context) {
        return com.huawei.hms.opendevice.i.a(context).getBoolean("_proxy_init");
    }

    public static java.lang.String[] getSubjectIds(android.content.Context context) {
        java.lang.String string = com.huawei.hms.opendevice.i.a(context).getString("subjectId");
        return android.text.TextUtils.isEmpty(string) ? new java.lang.String[0] : string.split(",");
    }

    public static void initSecret(android.content.Context context) {
        com.huawei.hms.opendevice.b.a(context);
    }

    public static boolean isMainProc(android.content.Context context) {
        java.lang.String a = com.huawei.hms.opendevice.p.a(context);
        java.lang.String str = context.getApplicationInfo().processName;
        com.huawei.hms.support.log.HMSLog.i("BaseUtils", "main process name: " + str + ", current process name: " + a);
        return str.equals(a);
    }

    public static void reportAaidToken(android.content.Context context, java.lang.String str) {
        com.huawei.hms.opendevice.n.a(context, str);
    }

    public static boolean saveCacheData(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        return z ? com.huawei.hms.opendevice.i.a(context).a(str, str2) : com.huawei.hms.opendevice.i.a(context).saveString(str, str2);
    }

    public static void saveProxyInit(android.content.Context context, boolean z) {
        com.huawei.hms.opendevice.i.a(context).saveBoolean("_proxy_init", z);
    }

    public static void saveToken(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.huawei.hms.opendevice.i.a(context).b(str, str2);
    }

    public static java.lang.String sendPostRequest(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        return com.huawei.hms.opendevice.d.a(context, str, str2, map);
    }
}
