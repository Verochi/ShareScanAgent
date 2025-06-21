package com.meizu.cloud.pushsdk.util;

/* loaded from: classes23.dex */
public class b {
    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        return a(context, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID);
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return n(context, str).getString(str2, "");
    }

    public static void a(android.content.Context context, int i, java.lang.String str) {
        a(context, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID_EXPIRE_TIME, i);
    }

    public static void a(android.content.Context context, java.lang.String str, int i) {
        a(context, "mz_push_preference", str + ".notification_id", i);
    }

    public static void a(android.content.Context context, java.lang.String str, long j) {
        a(context, "mz_push_preference_new", str + ".ad_last_close_time", j);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        n(context, str).edit().putInt(str2, i).apply();
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, long j) {
        n(context, str).edit().putLong(str2, j).apply();
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        n(context, str).edit().putString(str2, str3).apply();
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        n(context, str).edit().putBoolean(str2, z).apply();
    }

    public static void a(android.content.Context context, java.lang.String str, boolean z) {
        a(context, "mz_push_preference", "switch_notification_message_" + str, z);
    }

    public static int b(android.content.Context context, java.lang.String str) {
        return b(context, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID_EXPIRE_TIME);
    }

    public static int b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return n(context, str).getInt(str2, 0);
    }

    public static void b(android.content.Context context, java.lang.String str, int i) {
        a(context, "mz_push_preference", str + ".notification_push_task_id", i);
    }

    public static void b(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        a(context, "mz_push_preference", str + "." + str2, i);
    }

    public static void b(android.content.Context context, java.lang.String str, boolean z) {
        a(context, "mz_push_preference", "switch_through_message_" + str, z);
    }

    public static int c(android.content.Context context, java.lang.String str) {
        return n(context, "mz_push_preference").getInt(str + ".notification_id", 0);
    }

    public static long c(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return n(context, str).getLong(str2, 0L);
    }

    public static void c(android.content.Context context, java.lang.String str, int i) {
        a(context, "mz_push_preference", str + ".message_seq", i);
    }

    public static void c(android.content.Context context, java.lang.String str, boolean z) {
        a(context, "mz_push_preference", str + ".first_request_publicKey", z);
    }

    public static int d(android.content.Context context, java.lang.String str) {
        return n(context, "mz_push_preference").getInt(str + ".notification_push_task_id", 0);
    }

    public static boolean d(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return n(context, str).getBoolean(str2, true);
    }

    public static boolean e(android.content.Context context, java.lang.String str) {
        return d(context, "mz_push_preference", "switch_notification_message_" + str);
    }

    public static boolean e(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return n(context, str).edit().remove(str2).commit();
    }

    public static boolean f(android.content.Context context, java.lang.String str) {
        return f(context, "mz_push_preference", "switch_notification_message_" + str);
    }

    public static boolean f(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return n(context, str).contains(str2);
    }

    public static java.lang.String g(android.content.Context context, java.lang.String str) {
        return a(context, "mz_push_preference", "push_alias_" + str);
    }

    public static void g(android.content.Context context, java.lang.String str, java.lang.String str2) {
        a(context, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_ID_PREFERENCE_NAME, str2 + "_" + com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID, str);
    }

    public static void h(android.content.Context context, java.lang.String str, java.lang.String str2) {
        a(context, "mz_push_preference", "push_alias_" + str, str2);
    }

    public static boolean h(android.content.Context context, java.lang.String str) {
        return d(context, "mz_push_preference", "switch_through_message_" + str);
    }

    public static int i(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return b(context, "mz_push_preference", str + "." + str2);
    }

    public static boolean i(android.content.Context context, java.lang.String str) {
        return f(context, "mz_push_preference", "switch_through_message_" + str);
    }

    public static int j(android.content.Context context, java.lang.String str) {
        int b = b(context, "mz_push_preference", str + ".message_seq") + 1;
        c(context, str, b);
        com.meizu.cloud.pushinternal.DebugLogger.e("mz_push_preference", "current messageSeq " + b);
        return b;
    }

    public static boolean j(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return e(context, "mz_push_preference", str + "." + str2);
    }

    public static java.lang.String k(android.content.Context context, java.lang.String str) {
        return a(context, "mz_push_preference", str + ".encryption_public_key");
    }

    public static void k(android.content.Context context, java.lang.String str, java.lang.String str2) {
        a(context, "mz_push_preference", str + ".encryption_public_key", str2);
    }

    public static boolean l(android.content.Context context, java.lang.String str) {
        return d(context, "mz_push_preference", str + ".first_request_publicKey");
    }

    public static long m(android.content.Context context, java.lang.String str) {
        return c(context, "mz_push_preference_new", str + ".ad_last_close_time");
    }

    private static android.content.SharedPreferences n(android.content.Context context, java.lang.String str) {
        return context.getSharedPreferences(str, 0);
    }
}
