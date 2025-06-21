package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class i {
    public static void a(android.content.Context context, android.content.Intent intent) {
        try {
            if (context == null || intent == null) {
                com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
                return;
            }
            java.lang.String action = intent.getAction();
            if ("com.huawei.intent.action.PUSH".equals(action) || "com.huawei.push.msg.NOTIFY_MSG".equals(action) || "com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                if (byteArrayExtra != null && byteArrayExtra2 != null && byteArrayExtra.length != 0 && byteArrayExtra2.length != 0) {
                    a(context, intent, byteArrayExtra, byteArrayExtra2);
                    return;
                }
                com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "self show info or token is null.");
            }
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "onReceive RuntimeException.", e);
        } catch (java.lang.Exception unused) {
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "onReceive Exception.");
        }
    }

    public static void a(android.content.Context context, android.content.Intent intent, com.huawei.hms.push.k kVar) {
        com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "receive a selfshow message, the cmd type is " + kVar.i());
        if (com.huawei.hms.push.j.a(kVar.i())) {
            long a = com.huawei.hms.push.q.a(kVar.c());
            if (a == 0) {
                new com.huawei.hms.push.p(context, kVar).start();
                return;
            }
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "waiting...");
            intent.setPackage(context.getPackageName());
            com.huawei.hms.push.q.a(context, intent, a);
        }
    }

    public static void a(android.content.Context context, android.content.Intent intent, java.lang.String str, com.huawei.hms.push.k kVar, int i) {
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "receive a selfshow user handle message eventId = " + str);
        if ("-1".equals(str)) {
            com.huawei.hms.push.q.a(context, i);
        } else {
            com.huawei.hms.push.q.a(context, intent);
        }
        if ("1".equals(str)) {
            new com.huawei.hms.push.j(context, kVar).c();
            com.huawei.hms.push.utils.PluginUtil.onNotificationClicked(context, kVar.p(), kVar.b());
        } else if ("2".equals(str)) {
            com.huawei.hms.push.e.a(context, kVar.p(), kVar.b(), "2");
        } else {
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "other event");
        }
    }

    public static void a(android.content.Context context, android.content.Intent intent, byte[] bArr, byte[] bArr2) {
        java.lang.String stringExtra = intent.getStringExtra("selfshow_event_id");
        int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
        com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "get notifyId:" + intExtra);
        com.huawei.hms.push.k kVar = new com.huawei.hms.push.k(bArr, bArr2);
        if (!kVar.z()) {
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "parseMessage failed");
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "onReceive the msg id = " + kVar.p() + ",and cmd is " + kVar.i() + ",and the eventId is " + stringExtra);
        if (stringExtra == null) {
            a(context, intent, kVar);
        } else {
            a(context, intent, stringExtra, kVar, intExtra);
        }
    }
}
