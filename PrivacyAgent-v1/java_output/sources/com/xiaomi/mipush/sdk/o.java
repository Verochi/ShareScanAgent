package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class o {
    public static void a(android.content.Context context, android.content.Intent intent, android.net.Uri uri) {
        com.xiaomi.push.de a;
        com.xiaomi.push.dg dgVar;
        if (context == null) {
            return;
        }
        com.xiaomi.mipush.sdk.ao.a(context).m117a();
        if (com.xiaomi.push.de.a(context.getApplicationContext()).e == null) {
            com.xiaomi.push.de a2 = com.xiaomi.push.de.a(context.getApplicationContext());
            java.lang.String m127a = com.xiaomi.mipush.sdk.b.m126a(context.getApplicationContext()).m127a();
            java.lang.String packageName = context.getPackageName();
            int a3 = com.xiaomi.push.service.ad.a(context.getApplicationContext()).a(com.xiaomi.push.gp.AwakeInfoUploadWaySwitch.bw, 0);
            com.xiaomi.mipush.sdk.c cVar = new com.xiaomi.mipush.sdk.c();
            a2.b = m127a;
            a2.c = packageName;
            a2.d = a3;
            a2.e = cVar;
            com.xiaomi.push.service.ad.a(context).a(new com.xiaomi.mipush.sdk.q(102, "awake online config", context));
        }
        if ((context instanceof android.app.Activity) && intent != null) {
            a = com.xiaomi.push.de.a(context.getApplicationContext());
            dgVar = com.xiaomi.push.dg.ACTIVITY;
        } else {
            if (!(context instanceof android.app.Service) || intent == null) {
                if (uri == null || android.text.TextUtils.isEmpty(uri.toString())) {
                    return;
                }
                com.xiaomi.push.de.a(context.getApplicationContext()).a(com.xiaomi.push.dg.PROVIDER, context, (android.content.Intent) null, uri.toString());
                return;
            }
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                a = com.xiaomi.push.de.a(context.getApplicationContext());
                dgVar = com.xiaomi.push.dg.SERVICE_COMPONENT;
            } else {
                a = com.xiaomi.push.de.a(context.getApplicationContext());
                dgVar = com.xiaomi.push.dg.SERVICE_ACTION;
            }
        }
        a.a(dgVar, context, intent, (java.lang.String) null);
    }

    private static void a(android.content.Context context, com.xiaomi.push.hk hkVar) {
        boolean a = com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.AwakeAppPingSwitch.bw, false);
        int a2 = com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.AwakeAppPingFrequency.bw, 0);
        if (a2 >= 0 && a2 < 30) {
            com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
            a2 = 30;
        }
        if (a2 < 0) {
            a = false;
        }
        if (!com.xiaomi.push.iu.a()) {
            a(context, hkVar, a, a2);
        } else if (a) {
            com.xiaomi.push.m.a(context.getApplicationContext()).a(new com.xiaomi.mipush.sdk.p(hkVar, context), a2, 0);
        }
    }

    public static final <T extends com.xiaomi.push.hw<T, ?>> void a(android.content.Context context, T t, boolean z, int i) {
        byte[] a = com.xiaomi.push.hv.a(t);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        com.xiaomi.mipush.sdk.ao.a(context).m118a(intent);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.xiaomi.channel.commonutils.logger.b.a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("awake_info", str);
        hashMap.put(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, com.anythink.core.api.ErrorCode.exception);
        hashMap.put("description", "ping message");
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.d = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
        hkVar.i = context.getPackageName();
        hkVar.e = com.xiaomi.push.gu.AwakeAppResponse.ah;
        hkVar.c = com.xiaomi.push.service.ag.a();
        hkVar.h = hashMap;
        a(context, hkVar);
    }

    public static void a(android.content.Context context, java.lang.String str, int i, java.lang.String str2) {
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.d = str;
        java.util.HashMap hashMap = new java.util.HashMap();
        hkVar.h = hashMap;
        hashMap.put("extra_aw_app_online_cmd", java.lang.String.valueOf(i));
        hkVar.h.put("extra_help_aw_info", str2);
        hkVar.c = com.xiaomi.push.service.ag.a();
        byte[] a = com.xiaomi.push.hv.a(hkVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a);
        com.xiaomi.mipush.sdk.ao.a(context).m118a(intent);
    }
}
