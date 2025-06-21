package com.huawei.hms.support.hianalytics;

/* loaded from: classes22.dex */
public class a {
    public static java.util.Map<java.lang.String, java.lang.String> getMapForBi(android.content.Context context, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            java.lang.String[] split = str.split("\\.");
            if (split.length >= 2) {
                java.lang.String str2 = split[0];
                java.lang.String str3 = split[1];
                hashMap.put("service", str2);
                hashMap.put("apiName", str3);
                hashMap.put("package", context.getPackageName());
                hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
                hashMap.put("callTime", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            }
        }
        return hashMap;
    }
}
