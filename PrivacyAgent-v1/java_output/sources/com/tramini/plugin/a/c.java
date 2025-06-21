package com.tramini.plugin.a;

/* loaded from: classes19.dex */
public class c extends android.content.BroadcastReceiver {
    public static final java.lang.String a = "c";

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            java.lang.String stringExtra = intent.getStringExtra(intent.getAction());
            java.lang.String stringExtra2 = intent.getStringExtra("data");
            java.lang.String[] stringArrayExtra = intent.getStringArrayExtra(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_DENIED);
            if (!android.text.TextUtils.isEmpty(stringExtra) && !android.text.TextUtils.isEmpty(stringExtra2)) {
                com.tramini.plugin.a.b.c.a().a(stringArrayExtra);
                com.tramini.plugin.a.b.c.a().b(stringExtra);
                com.tramini.plugin.a.b.c.a().c(stringExtra2);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
