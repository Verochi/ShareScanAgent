package com.anythink.china.common;

/* loaded from: classes12.dex */
public class NotificationBroadcaseReceiver extends android.content.BroadcastReceiver {
    private static final java.lang.String a = "NotificationBroadcaseReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        java.lang.String action = intent.getAction();
        intent.getStringExtra(com.anythink.china.common.b.a.d);
        java.lang.String stringExtra = intent.getStringExtra(com.anythink.china.common.b.a.e);
        java.lang.String stringExtra2 = intent.getStringExtra(com.anythink.china.common.b.a.f);
        int intExtra = intent.getIntExtra(com.anythink.china.common.b.a.g, -1);
        if (android.text.TextUtils.isEmpty(action)) {
            return;
        }
        action.hashCode();
        if (action.equals(com.anythink.china.common.b.a.b)) {
            com.anythink.china.common.a.a(context).a(stringExtra, stringExtra2, intExtra);
        } else if (action.equals(com.anythink.china.common.b.a.c)) {
            com.anythink.china.common.a.a(context).a(stringExtra, stringExtra2);
        }
    }
}
