package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class COSPushHelper {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile boolean f4a;

    public static void convertMessage(android.content.Intent intent) {
        com.xiaomi.mipush.sdk.i.a(intent);
    }

    public static void doInNetworkChange(android.content.Context context) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f4a;
    }

    public static boolean hasNetwork(android.content.Context context) {
        return com.xiaomi.mipush.sdk.i.m149a(context);
    }

    public static void onNotificationMessageCome(android.content.Context context, java.lang.String str) {
    }

    public static void onPassThoughMessageCome(android.content.Context context, java.lang.String str) {
    }

    public static void registerCOSAssemblePush(android.content.Context context) {
        com.xiaomi.mipush.sdk.AbstractPushManager a2 = com.xiaomi.mipush.sdk.f.a(context).a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH :  register cos when network change!");
            a2.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (com.xiaomi.mipush.sdk.COSPushHelper.class) {
            f4a = z;
        }
    }

    public static void uploadToken(android.content.Context context, java.lang.String str) {
        com.xiaomi.mipush.sdk.i.m148a(context, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS, str);
    }
}
