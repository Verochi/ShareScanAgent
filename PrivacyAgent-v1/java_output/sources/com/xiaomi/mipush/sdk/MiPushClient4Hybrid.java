package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class MiPushClient4Hybrid {
    private static com.xiaomi.mipush.sdk.MiPushClient4Hybrid.MiPushCallback sCallback;
    private static java.util.Map<java.lang.String, com.xiaomi.mipush.sdk.b.a> dataMap = new java.util.HashMap();
    private static java.util.Map<java.lang.String, java.lang.Long> sRegisterTimeMap = new java.util.HashMap();

    public static class MiPushCallback {
        public void onCommandResult(java.lang.String str, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(java.lang.String str, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(java.lang.String str, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_".concat(java.lang.String.valueOf(str)), java.lang.System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(com.xiaomi.mipush.sdk.MiPushMessage miPushMessage, boolean z) {
        java.lang.String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int intValue = !android.text.TextUtils.isEmpty(str) ? java.lang.Integer.valueOf(str).intValue() : 0;
        if (!z) {
            intValue = (intValue & (-4)) + com.xiaomi.push.ga.a.NOT_ALLOWED.d;
        }
        return (short) intValue;
    }

    public static boolean isRegistered(android.content.Context context, java.lang.String str) {
        return com.xiaomi.mipush.sdk.b.m126a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(android.content.Context context, com.xiaomi.push.hm hmVar) {
        java.util.ArrayList arrayList;
        com.xiaomi.mipush.sdk.b.a aVar;
        java.lang.String str = hmVar.i;
        if (hmVar.e == 0 && (aVar = dataMap.get(str)) != null) {
            aVar.a(hmVar.g, hmVar.h);
            com.xiaomi.mipush.sdk.b.m126a(context).a(str, aVar);
        }
        if (android.text.TextUtils.isEmpty(hmVar.g)) {
            arrayList = null;
        } else {
            arrayList = new java.util.ArrayList();
            arrayList.add(hmVar.g);
        }
        com.xiaomi.mipush.sdk.MiPushCommandMessage generateCommandMessage = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(com.xiaomi.push.dx.COMMAND_REGISTER.k, arrayList, hmVar.e, hmVar.f, null, null);
        com.xiaomi.mipush.sdk.MiPushClient4Hybrid.MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(android.content.Context context, com.xiaomi.push.hs hsVar) {
        com.xiaomi.mipush.sdk.MiPushCommandMessage generateCommandMessage = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(com.xiaomi.push.dx.COMMAND_UNREGISTER.k, null, hsVar.e, hsVar.f, null, null);
        java.lang.String str = hsVar.g;
        com.xiaomi.mipush.sdk.MiPushClient4Hybrid.MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(str, generateCommandMessage);
        }
    }

    public static void registerPush(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.xiaomi.mipush.sdk.b.m126a(context).m131a(str2, str3, str)) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.xiaomi.mipush.sdk.b.a a = com.xiaomi.mipush.sdk.b.m126a(context).a(str);
            if (a != null) {
                arrayList.add(a.c);
                com.xiaomi.mipush.sdk.MiPushCommandMessage generateCommandMessage = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(com.xiaomi.push.dx.COMMAND_REGISTER.k, arrayList, 0L, null, null, null);
                com.xiaomi.mipush.sdk.MiPushClient4Hybrid.MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
                hkVar.d = str2;
                hkVar.e = com.xiaomi.push.gu.PullOfflineMessage.ah;
                hkVar.c = com.xiaomi.push.service.ag.a();
                hkVar.a(false);
                com.xiaomi.mipush.sdk.ao.a(context).a(hkVar, com.xiaomi.push.gk.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (java.lang.Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, java.lang.Long.valueOf(currentTimeMillis));
        java.lang.String a2 = com.xiaomi.push.ao.a(6);
        com.xiaomi.mipush.sdk.b.a aVar = new com.xiaomi.mipush.sdk.b.a(context);
        aVar.c(str2, str3, a2);
        dataMap.put(str, aVar);
        com.xiaomi.push.hl hlVar = new com.xiaomi.push.hl();
        hlVar.c = com.xiaomi.push.service.ag.a();
        hlVar.d = str2;
        hlVar.g = str3;
        hlVar.f = str;
        hlVar.h = a2;
        hlVar.e = com.xiaomi.push.ga.a(context, context.getPackageName());
        hlVar.a(com.xiaomi.push.ga.b(context, context.getPackageName()));
        hlVar.l = "4_9_0";
        hlVar.a();
        hlVar.t = com.xiaomi.push.gy.Init;
        if (!com.xiaomi.push.iu.f()) {
            java.lang.String d = com.xiaomi.push.ib.d(context);
            if (!android.text.TextUtils.isEmpty(d)) {
                hlVar.r = com.xiaomi.push.ao.a(d);
            }
        }
        int a3 = com.xiaomi.push.ib.a();
        if (a3 >= 0) {
            hlVar.b(a3);
        }
        com.xiaomi.push.hk hkVar2 = new com.xiaomi.push.hk();
        hkVar2.e = com.xiaomi.push.gu.HybridRegister.ah;
        hkVar2.d = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
        hkVar2.i = context.getPackageName();
        hkVar2.a(com.xiaomi.push.hv.a(hlVar));
        hkVar2.c = com.xiaomi.push.service.ag.a();
        com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) hkVar2, com.xiaomi.push.gk.Notification, (com.xiaomi.push.gx) null);
    }

    public static void removeDuplicateCache(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        java.lang.String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (android.text.TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        com.xiaomi.mipush.sdk.am.a(context, str);
    }

    public static void reportMessageArrived(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.a("do not ack message, message is null");
            return;
        }
        try {
            com.xiaomi.push.ha haVar = new com.xiaomi.push.ha();
            haVar.d = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
            haVar.c = miPushMessage.getMessageId();
            haVar.a(java.lang.Long.valueOf(miPushMessage.getExtra().get(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            haVar.a(getDeviceStatus(miPushMessage, z));
            if (!android.text.TextUtils.isEmpty(miPushMessage.getTopic())) {
                haVar.f = miPushMessage.getTopic();
            }
            com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) haVar, com.xiaomi.push.gk.AckMessage, false, com.xiaomi.push.service.au.a(com.xiaomi.mipush.sdk.PushMessageHelper.generateMessage(miPushMessage)));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } catch (java.lang.Throwable th) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(th);
            } finally {
                miPushMessage.getExtra().remove(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
                miPushMessage.getExtra().remove(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
            }
        }
    }

    public static void reportMessageClicked(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        com.xiaomi.mipush.sdk.MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(com.xiaomi.mipush.sdk.MiPushClient4Hybrid.MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(android.content.Context context, java.lang.String str) {
        return java.lang.Math.abs(java.lang.System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification_".concat(java.lang.String.valueOf(str)), -1L)) > 300000;
    }

    public static void unregisterPush(android.content.Context context, java.lang.String str) {
        sRegisterTimeMap.remove(str);
        com.xiaomi.mipush.sdk.b.a a = com.xiaomi.mipush.sdk.b.m126a(context).a(str);
        if (a == null) {
            return;
        }
        com.xiaomi.push.hr hrVar = new com.xiaomi.push.hr();
        hrVar.c = com.xiaomi.push.service.ag.a();
        hrVar.g = str;
        hrVar.d = a.f45a;
        hrVar.e = a.c;
        hrVar.h = a.b;
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.e = com.xiaomi.push.gu.HybridUnregister.ah;
        hkVar.d = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
        hkVar.i = context.getPackageName();
        hkVar.a(com.xiaomi.push.hv.a(hrVar));
        hkVar.c = com.xiaomi.push.service.ag.a();
        com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, (com.xiaomi.push.gx) null);
        com.xiaomi.mipush.sdk.b.m126a(context).b(str);
    }

    public static void uploadClearMessageData(android.content.Context context, java.util.LinkedList<? extends java.lang.Object> linkedList) {
        com.xiaomi.push.service.p.a(context, linkedList);
    }
}
