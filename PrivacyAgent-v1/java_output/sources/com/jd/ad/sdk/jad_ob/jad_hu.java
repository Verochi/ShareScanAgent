package com.jd.ad.sdk.jad_ob;

/* loaded from: classes23.dex */
public class jad_hu extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            if (androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == -1) {
                return;
            }
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                com.jd.ad.sdk.logger.Logger.d("net is unavailable");
            } else {
                com.jd.ad.sdk.logger.Logger.d("net is available");
                if (!com.jd.ad.sdk.jad_ob.jad_bo.jad_bo) {
                    com.jd.ad.sdk.jad_ob.jad_er.jad_an(com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId());
                }
            }
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while network receiver onReceive：");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
        }
    }
}
