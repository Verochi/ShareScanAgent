package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class q0 {
    public static boolean a(android.content.Context context) {
        return java.lang.System.currentTimeMillis() - com.huawei.hms.hatool.g0.a(context, "Privacy_MY", "flashKeyTime", -1L) > com.heytap.mcssdk.constant.a.g;
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        int checkSelfPermission;
        if (context == null) {
            return true;
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return false;
            }
            com.huawei.hms.hatool.y.f("hmsSdk", "not have read phone permission!");
            return true;
        }
        checkSelfPermission = context.checkSelfPermission(str);
        if (checkSelfPermission == 0) {
            return false;
        }
        com.huawei.hms.hatool.y.f("hmsSdk", "not have read phone permission!");
        return true;
    }

    @android.annotation.SuppressLint({"DefaultLocale"})
    public static boolean a(android.content.Context context, java.lang.String str, int i) {
        java.lang.String str2 = com.huawei.hms.hatool.g0.c(context, str) + ".xml";
        long length = new java.io.File(context.getFilesDir(), "../shared_prefs/" + str2).length();
        if (length <= i) {
            return false;
        }
        com.huawei.hms.hatool.y.c("hmsSdk", java.lang.String.format("reach local file limited size - file len: %d limitedSize: %d", java.lang.Long.valueOf(length), java.lang.Integer.valueOf(i)));
        return true;
    }

    public static boolean a(java.lang.String str, long j, long j2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j - java.lang.Long.parseLong(str) > j2;
        } catch (java.lang.NumberFormatException unused) {
            com.huawei.hms.hatool.y.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
