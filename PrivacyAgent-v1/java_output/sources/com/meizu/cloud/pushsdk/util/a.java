package com.meizu.cloud.pushsdk.util;

/* loaded from: classes23.dex */
public class a {
    public static android.net.NetworkInfo a(android.content.Context context) {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(android.content.Context context) {
        android.net.NetworkInfo a = a(context);
        return a != null && a.isConnected() && a.getType() == 1;
    }
}
