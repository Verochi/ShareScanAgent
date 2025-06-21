package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class l {
    public static boolean a(android.content.Context context) {
        try {
            return ((android.app.KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    public static boolean b(android.content.Context context) {
        android.content.Intent intent = null;
        try {
            intent = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (java.lang.Exception unused) {
        }
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }
}
