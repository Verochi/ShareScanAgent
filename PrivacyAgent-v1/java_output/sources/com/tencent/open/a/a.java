package com.tencent.open.a;

/* loaded from: classes19.dex */
public class a {
    protected static final android.net.Uri a = android.net.Uri.parse("content://telephony/carriers/preferapn");

    public static java.lang.String a(android.content.Context context) {
        int d = d(context);
        if (d == 2) {
            return com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI;
        }
        if (d == 1) {
            return "cmwap";
        }
        if (d == 4) {
            return "cmnet";
        }
        if (d == 16) {
            return "uniwap";
        }
        if (d == 8) {
            return "uninet";
        }
        if (d == 64) {
            return "wap";
        }
        if (d == 32) {
            return com.alipay.sdk.m.k.b.k;
        }
        if (d == 512) {
            return "ctwap";
        }
        if (d == 256) {
            return "ctnet";
        }
        if (d == 2048) {
            return "3gnet";
        }
        if (d == 1024) {
            return "3gwap";
        }
        java.lang.String b = b(context);
        return (b == null || b.length() == 0) ? "none" : b;
    }

    public static java.lang.String b(android.content.Context context) {
        return "";
    }

    public static java.lang.String c(android.content.Context context) {
        try {
            android.database.Cursor query = context.getContentResolver().query(a, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                query.close();
                return null;
            }
            java.lang.String string = query.getString(query.getColumnIndex("proxy"));
            query.close();
            return string;
        } catch (java.lang.SecurityException e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e.getMessage());
            return "";
        }
    }

    public static int d(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e.getMessage());
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 128;
        }
        if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
            return 2;
        }
        java.lang.String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
        if (lowerCase.startsWith("cmwap")) {
            return 1;
        }
        if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith(com.alipay.sdk.m.k.b.k)) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                java.lang.String c = c(context);
                if (c != null) {
                    if (c.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }

    public static java.lang.String e(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "MOBILE" : activeNetworkInfo.getTypeName();
    }
}
