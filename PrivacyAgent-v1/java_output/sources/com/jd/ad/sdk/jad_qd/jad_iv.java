package com.jd.ad.sdk.jad_qd;

/* loaded from: classes23.dex */
public class jad_iv {
    @android.annotation.SuppressLint({"MissingPermission"})
    public static int jad_an(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        try {
            if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("connectionType")) {
                return -1;
            }
            int i = 0;
            if (context != null && androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != -1) {
                try {
                    connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                } catch (java.lang.SecurityException e) {
                    e.printStackTrace();
                    connectivityManager = null;
                }
                android.net.NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                int i2 = 1;
                if (activeNetworkInfo != null) {
                    int type = activeNetworkInfo.getType();
                    i = type != 0 ? type != 1 ? type != 9 ? 1 : 2 : 3 : 4;
                }
                if (i != 0) {
                    i2 = i;
                }
                return com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i2);
            }
            return 0;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }
}
