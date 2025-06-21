package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class r {
    public static android.net.NetworkInfo a(android.content.Context context) {
        try {
            return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("NetUtils", e);
            return null;
        }
    }
}
