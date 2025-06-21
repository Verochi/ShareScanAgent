package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class NetUtils {
    public static int getAPNType(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        if (subtype == 13 && !telephonyManager.isNetworkRoaming()) {
            return 4;
        }
        if (subtype == 3 || subtype == 8) {
            return 3;
        }
        if (subtype == 5 && !telephonyManager.isNetworkRoaming()) {
            return 3;
        }
        if (subtype == 1 || subtype == 2 || subtype != 4) {
            return 2;
        }
        telephonyManager.isNetworkRoaming();
        return 2;
    }

    public static int getConnectedType(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static boolean isGPSEnabled(android.content.Context context) {
        return ((android.location.LocationManager) context.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION)).isProviderEnabled(com.amap.api.services.geocoder.GeocodeSearch.GPS);
    }

    public static boolean isMobileConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean isNetworkConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (context == null || context.getApplicationContext() == null || (activeNetworkInfo = ((android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean isWifiConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }
}
