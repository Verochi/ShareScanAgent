package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class FTOSPushHelper {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile boolean f5a;

    private static void a(android.content.Context context) {
        com.xiaomi.mipush.sdk.AbstractPushManager a2 = com.xiaomi.mipush.sdk.f.a(context).a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            a2.register();
        }
    }

    public static void doInNetworkChange(android.content.Context context) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f5a;
    }

    public static boolean hasNetwork(android.content.Context context) {
        return com.xiaomi.mipush.sdk.i.m149a(context);
    }

    public static void notifyFTOSNotificationClicked(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        com.xiaomi.mipush.sdk.PushMessageReceiver a2;
        if (map == null || !map.containsKey("pushMsg")) {
            return;
        }
        java.lang.String str = map.get("pushMsg");
        if (android.text.TextUtils.isEmpty(str) || (a2 = com.xiaomi.mipush.sdk.i.a(context)) == null) {
            return;
        }
        com.xiaomi.mipush.sdk.MiPushMessage a3 = com.xiaomi.mipush.sdk.i.a(str);
        if (a3.getExtra().containsKey("notify_effect")) {
            return;
        }
        a2.onNotificationMessageClicked(context, a3);
    }

    public static void setNeedRegister(boolean z) {
        f5a = z;
    }

    public static void uploadToken(android.content.Context context, java.lang.String str) {
        com.xiaomi.mipush.sdk.i.m148a(context, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS, str);
    }
}
