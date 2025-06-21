package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class cp {
    private static volatile com.baidu.mobads.sdk.internal.cp a;

    private cp() {
    }

    public static com.baidu.mobads.sdk.internal.cp a() {
        if (a == null) {
            synchronized (com.baidu.mobads.sdk.internal.cp.class) {
                if (a == null) {
                    a = new com.baidu.mobads.sdk.internal.cp();
                }
            }
        }
        return a;
    }

    private android.net.NetworkCapabilities c(android.content.Context context) {
        android.net.Network activeNetwork;
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                return null;
            }
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) applicationContext.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
            return connectivityManager.getNetworkCapabilities(activeNetwork);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public java.lang.Boolean a(android.content.Context context) {
        try {
            boolean z = false;
            if (com.baidu.mobads.sdk.internal.bm.a(context).a() < 29) {
                android.net.NetworkInfo b = b(context);
                if (b != null && b.isConnected() && b.getType() == 1) {
                    z = true;
                }
                return java.lang.Boolean.valueOf(z);
            }
            android.net.NetworkCapabilities c = c(context);
            if (c != null && c.hasCapability(12) && c.hasCapability(16) && c.hasTransport(1)) {
                z = true;
            }
            return java.lang.Boolean.valueOf(z);
        } catch (java.lang.Throwable unused) {
            return java.lang.Boolean.FALSE;
        }
    }

    public android.net.NetworkInfo b(android.content.Context context) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                return ((android.net.ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
