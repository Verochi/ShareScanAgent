package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class HWPushHelper {
    private static boolean a;

    public static void convertMessage(android.content.Intent intent) {
        com.xiaomi.mipush.sdk.i.a(intent);
    }

    public static boolean hasNetwork(android.content.Context context) {
        return com.xiaomi.mipush.sdk.i.m149a(context);
    }

    public static boolean isHmsTokenSynced(android.content.Context context) {
        java.lang.String a2 = com.xiaomi.mipush.sdk.i.a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI);
        if (android.text.TextUtils.isEmpty(a2)) {
            return false;
        }
        java.lang.String a3 = com.xiaomi.mipush.sdk.i.a(context, a2);
        java.lang.String a4 = com.xiaomi.mipush.sdk.af.a(context).a(com.xiaomi.mipush.sdk.au.UPLOAD_HUAWEI_TOKEN);
        return (android.text.TextUtils.isEmpty(a3) || android.text.TextUtils.isEmpty(a4) || !"synced".equals(a4)) ? false : true;
    }

    public static boolean isUserOpenHmsPush(android.content.Context context) {
        return com.xiaomi.mipush.sdk.MiPushClient.getOpenHmsPush(context);
    }

    public static boolean needConnect() {
        return a;
    }

    public static void notifyHmsNotificationMessageClicked(android.content.Context context, java.lang.String str) {
        java.lang.String string;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray(str);
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.has("pushMsg")) {
                            string = jSONObject.getString("pushMsg");
                            break;
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
        }
        string = "";
        com.xiaomi.mipush.sdk.PushMessageReceiver a2 = com.xiaomi.mipush.sdk.i.a(context);
        if (a2 != null) {
            com.xiaomi.mipush.sdk.MiPushMessage a3 = com.xiaomi.mipush.sdk.i.a(string);
            if (a3.getExtra().containsKey("notify_effect")) {
                return;
            }
            a2.onNotificationMessageClicked(context, a3);
        }
    }

    public static void notifyHmsPassThoughMessageArrived(android.content.Context context, java.lang.String str) {
        java.lang.String str2 = "";
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (jSONObject.has("content")) {
                    str2 = jSONObject.getString("content");
                }
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
        }
        com.xiaomi.mipush.sdk.PushMessageReceiver a2 = com.xiaomi.mipush.sdk.i.a(context);
        if (a2 != null) {
            a2.onReceivePassThroughMessage(context, com.xiaomi.mipush.sdk.i.a(str2));
        }
    }

    public static void registerHuaWeiAssemblePush(android.content.Context context) {
        com.xiaomi.mipush.sdk.AbstractPushManager a2 = com.xiaomi.mipush.sdk.f.a(context).a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI);
        if (a2 != null) {
            a2.register();
        }
    }

    public static void reportError(java.lang.String str, int i) {
        com.xiaomi.mipush.sdk.i.a(str, i);
    }

    public static synchronized void setConnectTime(android.content.Context context) {
        synchronized (com.xiaomi.mipush.sdk.HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", java.lang.System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void setGetTokenTime(android.content.Context context) {
        synchronized (com.xiaomi.mipush.sdk.HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", java.lang.System.currentTimeMillis()).commit();
        }
    }

    public static void setNeedConnect(boolean z) {
        a = z;
    }

    public static synchronized boolean shouldGetToken(android.content.Context context) {
        long abs;
        synchronized (com.xiaomi.mipush.sdk.HWPushHelper.class) {
            abs = java.lang.Math.abs(java.lang.System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1L));
        }
        return abs > com.baidu.mobads.sdk.internal.bm.e;
    }

    public static synchronized boolean shouldTryConnect(android.content.Context context) {
        long abs;
        synchronized (com.xiaomi.mipush.sdk.HWPushHelper.class) {
            abs = java.lang.Math.abs(java.lang.System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L));
        }
        return abs > 5000;
    }

    public static void uploadToken(android.content.Context context, java.lang.String str) {
        com.xiaomi.mipush.sdk.i.m148a(context, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI, str);
    }
}
