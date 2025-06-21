package com.huawei.hms.framework.network.grs.h;

/* loaded from: classes22.dex */
public class a {
    public static java.lang.String a() {
        return "5.0.10.302";
    }

    public static java.lang.String a(android.content.Context context) {
        if (context == null) {
            return "";
        }
        if (com.huawei.hms.framework.common.ContextHolder.getAppContext() != null) {
            context = com.huawei.hms.framework.common.ContextHolder.getAppContext();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.huawei.hms.framework.common.Logger.w("AgentUtil", "", e);
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null) {
            return java.lang.String.format(java.util.Locale.ROOT, str + "/%s", a());
        }
        java.lang.String packageName = (com.huawei.hms.framework.common.ContextHolder.getAppContext() == null ? context : com.huawei.hms.framework.common.ContextHolder.getAppContext()).getPackageName();
        java.lang.String a = a(context);
        java.lang.String str3 = android.os.Build.VERSION.RELEASE;
        java.lang.String str4 = android.os.Build.MODEL;
        java.util.Locale locale = java.util.Locale.ROOT;
        java.lang.String str5 = "%s/%s (Linux; Android %s; %s) " + str + "/%s %s";
        java.lang.Object[] objArr = new java.lang.Object[6];
        objArr[0] = packageName;
        objArr[1] = a;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = a();
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        objArr[5] = str2;
        return java.lang.String.format(locale, str5, objArr);
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return a(context, str, str2);
    }
}
