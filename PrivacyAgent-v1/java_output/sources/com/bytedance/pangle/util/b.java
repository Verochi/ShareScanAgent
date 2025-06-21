package com.bytedance.pangle.util;

/* loaded from: classes.dex */
public final class b {
    private static java.lang.String a;

    public static java.lang.String a(android.content.Context context) {
        if (a == null) {
            java.lang.String[] a2 = com.bytedance.pangle.util.c.a(new java.io.File(context.getApplicationInfo().sourceDir));
            java.lang.String str = a2[0];
            a = str;
            if (android.text.TextUtils.isEmpty(str)) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + a2[2]);
            }
        }
        return a;
    }

    public static boolean a() {
        try {
            return (com.bytedance.pangle.Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
