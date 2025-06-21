package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public final class k extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    com.anythink.expressad.videocommon.b.e.a().b();
                } else if (activeNetworkInfo.getType() == 1) {
                    com.anythink.expressad.videocommon.b.e.a().a(true);
                } else if (activeNetworkInfo.getType() == 0) {
                    com.anythink.expressad.videocommon.b.e.a().c();
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
