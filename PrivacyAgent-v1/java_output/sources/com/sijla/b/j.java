package com.sijla.b;

/* loaded from: classes19.dex */
final class j extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            java.lang.String action = intent.getAction();
            java.lang.String a = com.sijla.h.a.a.a(context);
            java.lang.String packageName = context.getPackageName();
            if (action == null || !packageName.equals(intent.getPackage()) || !action.equals(a) || com.sijla.b.g.e == null) {
                return;
            }
            com.sijla.b.g.e.uploadCallBack(new org.json.JSONObject(intent.getStringExtra("qtcallback")));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
