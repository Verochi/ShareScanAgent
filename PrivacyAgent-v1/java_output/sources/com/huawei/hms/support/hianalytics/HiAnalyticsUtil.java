package com.huawei.hms.support.hianalytics;

/* loaded from: classes22.dex */
public class HiAnalyticsUtil {
    private static final java.lang.Object a = new java.lang.Object();
    private static com.huawei.hms.support.hianalytics.HiAnalyticsUtil b;
    private static com.huawei.hms.support.hianalytics.HiAnalyticsUtils c;

    private java.lang.String a(android.content.Context context, java.lang.String str) {
        return "01||" + context.getPackageName() + "|" + com.huawei.hms.utils.Util.getAppId(context) + "|60500300|" + str;
    }

    public static com.huawei.hms.support.hianalytics.HiAnalyticsUtil getInstance() {
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil hiAnalyticsUtil;
        synchronized (a) {
            if (b == null) {
                b = new com.huawei.hms.support.hianalytics.HiAnalyticsUtil();
                c = com.huawei.hms.support.hianalytics.HiAnalyticsUtils.getInstance();
            }
            hiAnalyticsUtil = b;
        }
        return hiAnalyticsUtil;
    }

    public static java.util.Map<java.lang.String, java.lang.String> getMapFromForegroundResponseHeader(com.huawei.hms.common.internal.ResponseHeader responseHeader) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (responseHeader == null) {
            return hashMap;
        }
        hashMap.put("transId", responseHeader.getTransactionId());
        hashMap.put("appid", responseHeader.getActualAppID());
        hashMap.put("service", responseHeader.getSrvName());
        hashMap.put("apiName", responseHeader.getApiName());
        hashMap.put("package", responseHeader.getPkgName());
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_RESULT, java.lang.String.valueOf(responseHeader.getStatusCode()));
        hashMap.put("result", java.lang.String.valueOf(responseHeader.getErrorCode()));
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, responseHeader.getErrorReason());
        hashMap.put("callTime", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
        return hashMap;
    }

    public static java.util.Map<java.lang.String, java.lang.String> getMapFromRequestHeader(com.huawei.hms.common.internal.ResponseHeader responseHeader) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (responseHeader == null) {
            return hashMap;
        }
        hashMap.put("transId", responseHeader.getTransactionId());
        hashMap.put("appid", responseHeader.getActualAppID());
        hashMap.put("service", responseHeader.getSrvName());
        java.lang.String apiName = responseHeader.getApiName();
        if (!android.text.TextUtils.isEmpty(apiName)) {
            java.lang.String[] split = apiName.split("\\.");
            if (split.length >= 2) {
                hashMap.put("apiName", split[1]);
            }
        }
        hashMap.put("package", responseHeader.getPkgName());
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_RESULT, java.lang.String.valueOf(responseHeader.getStatusCode()));
        hashMap.put("result", java.lang.String.valueOf(responseHeader.getErrorCode()));
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, responseHeader.getErrorReason());
        hashMap.put("callTime", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
        return hashMap;
    }

    public static java.lang.String versionCodeToName(java.lang.String str) {
        return com.huawei.hms.support.hianalytics.HiAnalyticsUtils.versionCodeToName(str);
    }

    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getMapForBi(android.content.Context context, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String[] split = str.split("\\.");
        if (split.length >= 2) {
            java.lang.String str2 = split[0];
            java.lang.String str3 = split[1];
            java.lang.String appId = com.huawei.hms.utils.Util.getAppId(context);
            hashMap.put("transId", com.huawei.hms.common.internal.TransactionIdCreater.getId(appId, str));
            hashMap.put("appid", appId);
            hashMap.put("service", str2);
            hashMap.put("apiName", str3);
            hashMap.put("package", context.getPackageName());
            hashMap.put("version", "6.5.0.300");
            hashMap.put("callTime", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        }
        return hashMap;
    }

    public java.util.Map<java.lang.String, java.lang.String> getMapFromForegroundRequestHeader(com.huawei.hms.common.internal.RequestHeader requestHeader) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (requestHeader == null) {
            return hashMap;
        }
        hashMap.put("transId", requestHeader.getTransactionId());
        hashMap.put("appid", requestHeader.getActualAppID());
        hashMap.put("service", requestHeader.getSrvName());
        hashMap.put("apiName", requestHeader.getApiName());
        hashMap.put("package", requestHeader.getPkgName());
        hashMap.put("callTime", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
        return hashMap;
    }

    public java.util.Map<java.lang.String, java.lang.String> getMapFromRequestHeader(com.huawei.hms.common.internal.RequestHeader requestHeader) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (requestHeader == null) {
            return hashMap;
        }
        hashMap.put("transId", requestHeader.getTransactionId());
        hashMap.put("appid", requestHeader.getActualAppID());
        hashMap.put("service", requestHeader.getSrvName());
        java.lang.String apiName = requestHeader.getApiName();
        if (!android.text.TextUtils.isEmpty(apiName)) {
            java.lang.String[] split = apiName.split("\\.");
            if (split.length >= 2) {
                hashMap.put("apiName", split[1]);
            }
        }
        hashMap.put("package", requestHeader.getPkgName());
        hashMap.put("callTime", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
        return hashMap;
    }

    @java.lang.Deprecated
    public boolean hasError() {
        if (com.huawei.hms.android.SystemUtils.isChinaROM()) {
            return false;
        }
        com.huawei.hms.support.log.HMSLog.i("HiAnalyticsUtil", "not ChinaROM ");
        return true;
    }

    public boolean hasError(android.content.Context context) {
        return c.hasError(context);
    }

    public void onBuoyEvent(android.content.Context context, java.lang.String str, java.lang.String str2) {
        c.onBuoyEvent(context, str, str2);
    }

    public void onEvent(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context != null) {
            onEvent2(context, str, a(context, str2));
        }
    }

    public void onEvent(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        c.onEvent(context, str, map);
    }

    public void onEvent2(android.content.Context context, java.lang.String str, java.lang.String str2) {
        c.onEvent2(context, str, str2);
    }

    public void onNewEvent(android.content.Context context, java.lang.String str, java.util.Map map) {
        c.onNewEvent(context, str, map);
    }
}
