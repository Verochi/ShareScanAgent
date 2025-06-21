package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class FCMPushHelper {
    private static java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("actionType", java.lang.String.valueOf(com.xiaomi.push.gk.AckMessage.L));
        hashMap.put("deviceStatus", java.lang.String.valueOf((int) com.xiaomi.push.hv.a(context, context.getPackageName())));
        hashMap.put("mat", java.lang.Long.toString(java.lang.System.currentTimeMillis()));
        return hashMap;
    }

    private static void a(android.content.Context context, com.xiaomi.push.hh hhVar) {
        try {
            com.xiaomi.mipush.sdk.MiPushMessage generateMessage = com.xiaomi.mipush.sdk.PushMessageHelper.generateMessage((com.xiaomi.push.ho) com.xiaomi.mipush.sdk.ai.a(context, hhVar), hhVar.h, false);
            com.xiaomi.mipush.sdk.PushMessageReceiver a = com.xiaomi.mipush.sdk.i.a(context);
            if (a != null) {
                a.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("fcm broadcast notification come error ", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(android.content.Context context, byte[] bArr) {
        java.lang.String format;
        boolean m119a = com.xiaomi.mipush.sdk.ao.a(context).m119a();
        boolean z = true;
        boolean z2 = !"com.xiaomi.xmsf".equals(context.getPackageName());
        boolean m97a = m97a(context);
        if (m119a && z2 && m97a) {
            bArr = com.xiaomi.push.service.cj.a(bArr, com.xiaomi.mipush.sdk.b.m126a(context).d());
            if (bArr == null) {
                format = "fcm message encrypt failed";
            } else {
                java.lang.String encodeToString = android.util.Base64.encodeToString(bArr, 2);
                if (!android.text.TextUtils.isEmpty(encodeToString)) {
                    android.content.Intent intent = new android.content.Intent(com.xiaomi.push.service.an.n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", encodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    context.startService(intent);
                    com.xiaomi.channel.commonutils.logger.b.a("fcm message reroute to xmsf");
                    if (z) {
                        com.xiaomi.channel.commonutils.logger.b.b("fcm message post local");
                        com.xiaomi.push.service.p.a(context, com.xiaomi.push.service.ct.a(bArr), bArr);
                        return;
                    }
                    return;
                }
                format = "fcm message buf base64 encode failed";
            }
        } else {
            format = java.lang.String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", java.lang.Boolean.valueOf(m119a), java.lang.Boolean.valueOf(z2), java.lang.Boolean.valueOf(m97a));
        }
        com.xiaomi.channel.commonutils.logger.b.a(format);
        z = false;
        if (z) {
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m97a(android.content.Context context) {
        return ((long) com.xiaomi.push.iu.b(context)) >= 50002000 && b(context);
    }

    private static boolean b(android.content.Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void clearToken(android.content.Context context) {
        com.xiaomi.mipush.sdk.i.m147a(context, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(android.content.Intent intent) {
        com.xiaomi.mipush.sdk.i.a(intent);
    }

    public static boolean isFCMSwitchOpen(android.content.Context context) {
        return com.xiaomi.mipush.sdk.i.m150a(context, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM) && com.xiaomi.mipush.sdk.MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        com.xiaomi.mipush.sdk.PushMessageReceiver a;
        java.lang.String str = map.get("pushMsg");
        if (android.text.TextUtils.isEmpty(str) || (a = com.xiaomi.mipush.sdk.i.a(context)) == null) {
            return;
        }
        a.onNotificationMessageArrived(context, com.xiaomi.mipush.sdk.i.a(str));
    }

    public static java.util.Map<java.lang.String, java.lang.String> notifyFCMPassThoughMessageCome(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        com.xiaomi.mipush.sdk.PushMessageReceiver a;
        java.lang.String str = map.get("pushMsg");
        if (!android.text.TextUtils.isEmpty(str) && (a = com.xiaomi.mipush.sdk.i.a(context)) != null) {
            a.onReceivePassThroughMessage(context, com.xiaomi.mipush.sdk.i.a(str));
        }
        java.lang.String str2 = map.get("mipushContainer");
        if (android.text.TextUtils.isEmpty(str2)) {
            return new java.util.HashMap();
        }
        try {
            byte[] decode = android.util.Base64.decode(str2, 2);
            a(context, com.xiaomi.push.service.ct.a(decode));
            a(context, decode);
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("fcm notify notification error ", th);
        }
        return a(context);
    }

    public static void persistIfXmsfSupDecrypt(android.content.Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putBoolean("is_xmsf_sup_decrypt", ((long) com.xiaomi.push.iu.b(context)) >= 50002000).apply();
    }

    public static void reportFCMMessageDelete() {
        com.xiaomi.mipush.sdk.MiTinyDataClient.upload(com.xiaomi.mipush.sdk.i.c(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM), "fcm", 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(android.content.Context context, java.lang.String str) {
        com.xiaomi.mipush.sdk.i.m148a(context, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM, str);
    }
}
