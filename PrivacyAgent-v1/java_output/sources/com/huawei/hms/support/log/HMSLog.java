package com.huawei.hms.support.log;

/* loaded from: classes22.dex */
public class HMSLog {
    public static final com.huawei.hms.base.log.a a = new com.huawei.hms.base.log.a();

    public static java.lang.String a(android.content.Context context) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (android.content.pm.PackageManager.NameNotFoundException | java.lang.RuntimeException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        a.a(3, str, str2);
    }

    public static void e(java.lang.String str, long j, java.lang.String str2) {
        a.a(6, str, "[" + j + "] " + str2);
    }

    public static void e(java.lang.String str, long j, java.lang.String str2, java.lang.Throwable th) {
        a.b(6, str, "[" + j + "] " + str2, th);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        a.a(6, str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        a.b(6, str, str2, th);
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        a.a(4, str, str2);
    }

    public static void init(android.content.Context context, int i, java.lang.String str) {
        com.huawei.hms.base.log.a aVar = a;
        aVar.a(context, i, str);
        aVar.a(str, "============================================================================\n====== " + a(context) + "\n============================================================================");
    }

    public static boolean isErrorEnable() {
        return a.a(6);
    }

    public static boolean isInfoEnable() {
        return a.a(4);
    }

    public static boolean isWarnEnable() {
        return a.a(5);
    }

    public static void setExtLogger(com.huawei.hms.support.log.HMSExtLogger hMSExtLogger, boolean z) throws java.lang.IllegalArgumentException {
        if (hMSExtLogger == null) {
            throw new java.lang.IllegalArgumentException("extLogger is not able to be null");
        }
        com.huawei.hms.base.log.d dVar = new com.huawei.hms.base.log.d(hMSExtLogger);
        if (z) {
            a.a(dVar);
        } else {
            a.a().a(dVar);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        a.a(5, str, str2);
    }
}
