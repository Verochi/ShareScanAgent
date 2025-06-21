package com.getui.gtc.base.util;

/* loaded from: classes22.dex */
public class NetworkUtil {
    public static boolean isNetWorkAvailable(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }
}
