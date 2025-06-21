package com.umeng.commonsdk.internal.utils;

/* loaded from: classes19.dex */
public class h {
    public static boolean a() {
        return b() || c() || d() || e();
    }

    private static boolean b() {
        java.lang.String str = android.os.Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean c() {
        try {
            if (new java.io.File("/system/app/Superuser.apk").exists()) {
                return true;
            }
        } catch (java.lang.Exception unused) {
        }
        try {
            return new java.io.File("/system/app/Kinguser.apk").exists();
        } catch (java.lang.Exception unused2) {
            return false;
        }
    }

    private static boolean d() {
        return new com.umeng.commonsdk.internal.utils.e().a(com.umeng.commonsdk.internal.utils.e.a.check_su_binary) != null;
    }

    private static boolean e() {
        java.lang.String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i = 0; i < 12; i++) {
            if (new java.io.File(strArr[i] + com.getui.gtc.extension.distribution.gbd.n.aa.a).exists()) {
                return true;
            }
        }
        return false;
    }
}
