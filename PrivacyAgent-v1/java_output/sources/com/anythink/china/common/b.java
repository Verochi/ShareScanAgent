package com.anythink.china.common;

/* loaded from: classes12.dex */
public class b extends android.content.BroadcastReceiver {
    private static final java.lang.String a = "b";

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        java.lang.String action = intent.getAction();
        if (("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) && intent.getData() != null) {
            com.anythink.china.common.a.a(context).b(intent.getData().getSchemeSpecificPart());
        }
    }
}
