package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class i {
    private static java.util.HashMap<java.lang.String, java.lang.String> a = new java.util.HashMap<>();

    public static int a() {
        java.lang.Integer num = (java.lang.Integer) com.xiaomi.push.aj.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int a(android.content.Context context, com.xiaomi.mipush.sdk.e eVar, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        java.lang.String a2 = a(eVar);
        java.lang.String string = sharedPreferences.getString(a2, "");
        java.lang.String m134c = com.xiaomi.mipush.sdk.b.m126a(context).m134c();
        java.lang.String string2 = sharedPreferences.getString("last_check_token", "");
        if (android.text.TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        }
        if (android.text.TextUtils.isEmpty(string)) {
            return 1;
        }
        if (!string.equals(str)) {
            return 2;
        }
        if (!android.text.TextUtils.equals(m134c, string2)) {
            return 3;
        }
        if (m151a(eVar)) {
            if (a() != sharedPreferences.getInt(b(eVar), 0)) {
                return 4;
            }
        }
        return 0;
    }

    public static com.xiaomi.mipush.sdk.MiPushMessage a(java.lang.String str) {
        com.xiaomi.mipush.sdk.MiPushMessage miPushMessage = new com.xiaomi.mipush.sdk.MiPushMessage();
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME)) {
                    miPushMessage.setAlias(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                    java.util.HashMap hashMap = new java.util.HashMap();
                    while (keys != null && keys.hasNext()) {
                        java.lang.String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
        }
        return miPushMessage;
    }

    public static com.xiaomi.mipush.sdk.PushMessageReceiver a(android.content.Context context) {
        android.content.pm.ResolveInfo resolveInfo;
        android.content.Intent intent = new android.content.Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                java.util.Iterator<android.content.pm.ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    resolveInfo = it.next();
                    android.content.pm.ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            resolveInfo = null;
            if (resolveInfo != null) {
                return (com.xiaomi.mipush.sdk.PushMessageReceiver) com.xiaomi.push.jc.a(context, resolveInfo.activityInfo.name).newInstance();
            }
            return null;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context, com.xiaomi.mipush.sdk.e eVar) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        java.lang.String a2 = a(eVar);
        if (android.text.TextUtils.isEmpty(a2)) {
            return null;
        }
        return sharedPreferences.getString(a2, "");
    }

    public static synchronized java.lang.String a(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        synchronized (com.xiaomi.mipush.sdk.i.class) {
            str2 = a.get(str);
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static java.lang.String a(com.xiaomi.mipush.sdk.e eVar) {
        int i = com.xiaomi.mipush.sdk.k.a[eVar.ordinal()];
        if (i == 1) {
            return "hms_push_token";
        }
        if (i == 2) {
            return "fcm_push_token_v2";
        }
        if (i == 3) {
            return "cos_push_token";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_token";
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
    
        if (r14 != 0) goto L16;
     */
    /* renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.HashMap<java.lang.String, java.lang.String> m145a(android.content.Context context, com.xiaomi.mipush.sdk.e eVar) {
        com.xiaomi.push.jd.a a2;
        int a3;
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        java.lang.String a4 = a(eVar);
        if (android.text.TextUtils.isEmpty(a4)) {
            return hashMap;
        }
        int i = com.xiaomi.mipush.sdk.k.a[eVar.ordinal()];
        java.lang.String str = null;
        android.content.pm.ApplicationInfo applicationInfo = null;
        if (i != 1) {
            if (i == 2) {
                a2 = new com.xiaomi.push.jd.a(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR).a("brand", com.xiaomi.mipush.sdk.ag.FCM.name()).a("token", a(context, a4)).a("package_name", context.getPackageName());
                a3 = a();
                if (a3 == 0) {
                    a3 = 40090;
                }
            } else if (i == 3) {
                str = "brand:" + com.xiaomi.mipush.sdk.ag.OPPO.name() + "~token:" + a(context, a4) + "~package_name:" + context.getPackageName();
            } else if (i == 4) {
                a2 = new com.xiaomi.push.jd.a(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR).a("brand", com.xiaomi.mipush.sdk.ag.VIVO.name()).a("token", a(context, a4)).a("package_name", context.getPackageName());
                a3 = a();
            }
            a2.a("version", java.lang.Integer.valueOf(a3));
            str = a2.toString();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
            str = "brand:" + com.xiaomi.mipush.sdk.n.a(context).name() + "~token:" + a(context, a4) + "~package_name:" + context.getPackageName() + "~app_id:" + (applicationInfo != null ? applicationInfo.metaData.getInt(com.xiaomi.mipush.sdk.Constants.HUAWEI_HMS_CLIENT_APPID) : -1);
        }
        hashMap.put(com.xiaomi.mipush.sdk.Constants.ASSEMBLE_PUSH_REG_INFO, str);
        return hashMap;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m146a(android.content.Context context) {
        boolean z = false;
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        java.lang.String a2 = a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI);
        java.lang.String a3 = a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM);
        if (!android.text.TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && android.text.TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            com.xiaomi.mipush.sdk.ao.a(context).a(2, a2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m147a(android.content.Context context, com.xiaomi.mipush.sdk.e eVar) {
        java.lang.String a2 = a(eVar);
        if (android.text.TextUtils.isEmpty(a2)) {
            return;
        }
        context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, "").apply();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m148a(android.content.Context context, com.xiaomi.mipush.sdk.e eVar, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        int a2 = a(context, eVar, str);
        if (a2 == 0) {
            com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : send token upload, check:".concat(java.lang.String.valueOf(a2)));
        a(eVar, str);
        com.xiaomi.mipush.sdk.au a3 = com.xiaomi.mipush.sdk.l.a(eVar);
        if (a3 == null) {
            return;
        }
        com.xiaomi.mipush.sdk.ao.a(context).a((java.lang.String) null, a3, eVar);
    }

    public static void a(android.content.Intent intent) {
        android.os.Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(com.xiaomi.mipush.sdk.PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    private static synchronized void a(com.xiaomi.mipush.sdk.e eVar, java.lang.String str) {
        synchronized (com.xiaomi.mipush.sdk.i.class) {
            java.lang.String a2 = a(eVar);
            if (android.text.TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (android.text.TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : token is null");
            } else {
                a.put(a2, str);
            }
        }
    }

    public static void a(java.lang.String str, int i) {
        com.xiaomi.mipush.sdk.MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = ".concat(java.lang.String.valueOf(i)));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m149a(android.content.Context context) {
        if (context == null) {
            return false;
        }
        return com.xiaomi.push.ai.a(context);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m150a(android.content.Context context, com.xiaomi.mipush.sdk.e eVar) {
        if (com.xiaomi.mipush.sdk.l.m153a(eVar) != null) {
            return com.xiaomi.push.service.ad.a(context).a(com.xiaomi.mipush.sdk.l.m153a(eVar).bw, true);
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m151a(com.xiaomi.mipush.sdk.e eVar) {
        return eVar == com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS || eVar == com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM;
    }

    public static boolean a(com.xiaomi.push.hh hhVar, com.xiaomi.mipush.sdk.e eVar) {
        com.xiaomi.push.gx gxVar;
        java.util.Map<java.lang.String, java.lang.String> map;
        if (hhVar == null || (gxVar = hhVar.h) == null || (map = gxVar.j) == null) {
            return false;
        }
        return (eVar == com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(map.get("assemble_push_type"));
    }

    public static byte[] a(android.content.Context context, com.xiaomi.push.hh hhVar, com.xiaomi.mipush.sdk.e eVar) {
        if (a(hhVar, eVar)) {
            return com.xiaomi.push.an.c(a(context, eVar));
        }
        return null;
    }

    public static java.lang.String b(com.xiaomi.mipush.sdk.e eVar) {
        return a(eVar) + "_version";
    }

    public static void b(android.content.Context context) {
        com.xiaomi.mipush.sdk.f.a(context).register();
    }

    public static void b(android.content.Context context, com.xiaomi.mipush.sdk.e eVar, java.lang.String str) {
        com.xiaomi.push.m.a(context).a(new com.xiaomi.mipush.sdk.j(str, context, eVar), 0);
    }

    public static java.lang.String c(com.xiaomi.mipush.sdk.e eVar) {
        int i = com.xiaomi.mipush.sdk.k.a[eVar.ordinal()];
        if (i == 1) {
            return "hms_push_error";
        }
        if (i == 2) {
            return "fcm_push_error";
        }
        if (i == 3) {
            return "cos_push_error";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_error";
    }

    public static void c(android.content.Context context) {
        com.xiaomi.mipush.sdk.f.a(context).unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(android.content.Context context, com.xiaomi.mipush.sdk.e eVar, java.lang.String str) {
        synchronized (com.xiaomi.mipush.sdk.i.class) {
            java.lang.String a2 = a(eVar);
            if (android.text.TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(a2, str).putString("last_check_token", com.xiaomi.mipush.sdk.b.m126a(context).m134c());
            if (m151a(eVar)) {
                edit.putInt(b(eVar), a());
            }
            edit.apply();
            com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : update sp file success!  ".concat(java.lang.String.valueOf(str)));
        }
    }
}
