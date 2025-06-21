package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ga {

    public enum a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);

        public final int d;

        a(int i) {
            this.d = i;
        }
    }

    public static int a(android.content.Context context) {
        android.os.Bundle bundle;
        if (context == null) {
            return 0;
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.android.systemui", 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt("SupportForPushVersionCode");
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    private static com.xiaomi.push.ga.a a(android.content.Context context, android.content.pm.ApplicationInfo applicationInfo) {
        java.lang.Boolean bool;
        boolean areNotificationsEnabled;
        int i = android.os.Build.VERSION.SDK_INT;
        if (applicationInfo == null || i < 24) {
            return com.xiaomi.push.ga.a.UNKNOWN;
        }
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                areNotificationsEnabled = ((android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled();
                bool = java.lang.Boolean.valueOf(areNotificationsEnabled);
            } else {
                java.lang.Object a2 = i >= 29 ? com.xiaomi.push.aj.a(context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION), "getService", new java.lang.Object[0]) : context.getSystemService("security");
                bool = a2 != null ? (java.lang.Boolean) com.xiaomi.push.aj.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, java.lang.Integer.valueOf(applicationInfo.uid)) : null;
            }
            if (bool != null) {
                return bool.booleanValue() ? com.xiaomi.push.ga.a.ALLOWED : com.xiaomi.push.ga.a.NOT_ALLOWED;
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("are notifications enabled error ".concat(java.lang.String.valueOf(e)));
        }
        return com.xiaomi.push.ga.a.UNKNOWN;
    }

    @android.annotation.TargetApi(19)
    public static com.xiaomi.push.ga.a a(android.content.Context context, java.lang.String str, boolean z) {
        android.content.pm.ApplicationInfo applicationInfo;
        com.xiaomi.push.ga.a a2;
        com.xiaomi.push.ga.a aVar;
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return com.xiaomi.push.ga.a.UNKNOWN;
        }
        try {
            applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            a2 = a(context, applicationInfo);
            aVar = com.xiaomi.push.ga.a.UNKNOWN;
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("get app op error ".concat(java.lang.String.valueOf(th)));
        }
        if (a2 != aVar) {
            return a2;
        }
        java.lang.Integer num = (java.lang.Integer) com.xiaomi.push.aj.a((java.lang.Class<? extends java.lang.Object>) android.app.AppOpsManager.class, "OP_POST_NOTIFICATION");
        if (num == null) {
            return aVar;
        }
        java.lang.Integer num2 = (java.lang.Integer) com.xiaomi.push.aj.a(context.getSystemService("appops"), "checkOpNoThrow", num, java.lang.Integer.valueOf(applicationInfo.uid), str);
        int i = (java.lang.Integer) com.xiaomi.push.aj.a((java.lang.Class<? extends java.lang.Object>) android.app.AppOpsManager.class, "MODE_ALLOWED");
        int i2 = (java.lang.Integer) com.xiaomi.push.aj.a((java.lang.Class<? extends java.lang.Object>) android.app.AppOpsManager.class, "MODE_IGNORED");
        com.xiaomi.channel.commonutils.logger.b.b(java.lang.String.format("get app mode %s|%s|%s", num2, i, i2));
        if (i == null) {
            i = 0;
        }
        if (i2 == null) {
            i2 = 1;
        }
        if (num2 != null) {
            return z ? !num2.equals(i2) ? com.xiaomi.push.ga.a.ALLOWED : com.xiaomi.push.ga.a.NOT_ALLOWED : num2.equals(i) ? com.xiaomi.push.ga.a.ALLOWED : com.xiaomi.push.ga.a.NOT_ALLOWED;
        }
        return com.xiaomi.push.ga.a.UNKNOWN;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (java.lang.Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    public static int b(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (java.lang.Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static boolean c(android.content.Context context, java.lang.String str) {
        if (!com.xiaomi.push.iu.a()) {
            return true;
        }
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        java.util.Iterator<android.app.ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if (java.util.Arrays.asList(it.next().pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static java.lang.String e(android.content.Context context, java.lang.String str) {
        android.content.pm.ApplicationInfo applicationInfo;
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return str;
        }
    }

    public static int f(android.content.Context context, java.lang.String str) {
        android.content.pm.ApplicationInfo i = i(context, str);
        if (i == null) {
            return 0;
        }
        int i2 = i.icon;
        return i2 == 0 ? i.logo : i2;
    }

    public static android.graphics.drawable.Drawable g(android.content.Context context, java.lang.String str) {
        android.content.pm.ApplicationInfo i = i(context, str);
        android.graphics.drawable.Drawable drawable = null;
        if (i != null) {
            try {
                drawable = i.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = i.loadLogo(context.getPackageManager());
                }
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("get app icon drawable failed, ".concat(java.lang.String.valueOf(e)));
            }
        }
        return drawable != null ? drawable : new android.graphics.drawable.ColorDrawable(0);
    }

    public static boolean h(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (android.provider.Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(android.provider.Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static android.content.pm.ApplicationInfo i(android.content.Context context, java.lang.String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.a("not found app info ".concat(str));
            return null;
        }
    }
}
