package com.jd.ad.sdk.jad_zk;

/* loaded from: classes23.dex */
public class jad_fs implements com.jd.ad.sdk.jad_zk.jad_dq {
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_zk.jad_cp jad_an(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_anVar) {
        boolean z = androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (android.util.Log.isLoggable("ConnectivityMonitor", 3)) {
            java.lang.Object[] objArr = new java.lang.Object[1];
            objArr[0] = z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            com.jd.ad.sdk.logger.Logger.d("ConnectivityMonitor", objArr);
        }
        return z ? new com.jd.ad.sdk.jad_zk.jad_er(context, jad_anVar) : new com.jd.ad.sdk.jad_zk.jad_na();
    }
}
