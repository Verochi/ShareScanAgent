package com.efs.sdk.base.core.util;

/* loaded from: classes22.dex */
public class NetworkUtil {
    public static final java.lang.String MOBILE_NETWORK = "2G/3G";
    public static final java.lang.String NETWORK_CLASS_2G = "2g";
    public static final java.lang.String NETWORK_CLASS_3G = "3g";
    public static final java.lang.String NETWORK_CLASS_4G = "4g";
    public static final java.lang.String NETWORK_CLASS_5G = "5g";
    public static final java.lang.String NETWORK_CLASS_DENIED = "denied";
    public static final java.lang.String NETWORK_CLASS_DISCONNECTED = "disconnected";
    public static final java.lang.String NETWORK_CLASS_UNKNOWN = "unknown";
    public static final java.lang.String NETWORK_TYPE_WIFI = "wifi";
    public static final java.lang.String UNKNOW = "";
    public static final java.lang.String WIFI = "Wi-Fi";

    public static boolean checkPermission(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            try {
                if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", java.lang.String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (java.lang.Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static android.net.NetworkInfo getActiveNetworkInfo(android.content.Context context) {
        android.net.NetworkInfo[] allNetworkInfo;
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                com.efs.sdk.base.core.util.Log.w("efs.base", "get CONNECTIVITY_SERVICE is null");
                return null;
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if ((activeNetworkInfo != null && activeNetworkInfo.isConnected()) || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
                return activeNetworkInfo;
            }
            for (int i = 0; i < allNetworkInfo.length; i++) {
                android.net.NetworkInfo networkInfo = allNetworkInfo[i];
                if (networkInfo != null && networkInfo.isConnected()) {
                    return allNetworkInfo[i];
                }
            }
            return activeNetworkInfo;
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "get network info error", th);
            return null;
        }
    }

    public static java.lang.String[] getNetworkAccessMode(android.content.Context context) {
        java.lang.String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            strArr[0] = "";
            return strArr;
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "";
            return strArr;
        }
        android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.getState() == android.net.NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.getState() == android.net.NetworkInfo.State.CONNECTED) {
            strArr[0] = "2G/3G";
            strArr[1] = networkInfo2.getSubtypeName();
        }
        return strArr;
    }

    public static java.lang.String getNetworkType(android.content.Context context) {
        if (isRejectAccessNetworkState(context)) {
            return NETWORK_CLASS_DENIED;
        }
        android.net.NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null) {
            return NETWORK_CLASS_DISCONNECTED;
        }
        if (activeNetworkInfo.getType() == 1) {
            return NETWORK_TYPE_WIFI;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 20) {
            return NETWORK_CLASS_5G;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NETWORK_CLASS_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NETWORK_CLASS_3G;
            case 13:
                return NETWORK_CLASS_4G;
            default:
                java.lang.String subtypeName = activeNetworkInfo.getSubtypeName();
                return android.text.TextUtils.isEmpty(subtypeName) ? "unknown" : (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? NETWORK_CLASS_3G : subtypeName;
        }
    }

    public static int getNetworkTypeUmeng(android.content.Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (checkPermission(context, com.anythink.china.common.d.a)) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (java.lang.Exception unused) {
            return -100;
        }
    }

    public static boolean hasAccessNetworkState(android.content.Context context) {
        return context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
    }

    public static boolean isConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == android.net.NetworkInfo.State.CONNECTED;
    }

    public static boolean isRejectAccessNetworkState(android.content.Context context) {
        return !hasAccessNetworkState(context);
    }

    public static boolean isWifi(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        return !isRejectAccessNetworkState(context) && (activeNetworkInfo = getActiveNetworkInfo(context)) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }
}
