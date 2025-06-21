package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ib {
    private static java.lang.String a = null;
    private static java.lang.String b = null;
    private static java.lang.String c = "";
    private static java.lang.String d = null;
    private static java.lang.String e = null;
    private static final java.lang.String f = "\u0002";
    private static final java.lang.String[] g = {"--", "a-", "u-", "v-", "o-", "g-"};
    private static final java.util.Set<java.lang.String> h;
    private static boolean i;

    static {
        java.util.HashSet hashSet = new java.util.HashSet();
        h = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
        i = true;
    }

    @android.annotation.TargetApi(17)
    public static int a() {
        java.lang.Object a2 = com.xiaomi.push.aj.a("android.os.UserHandle", "myUserId", new java.lang.Object[0]);
        if (a2 == null) {
            return -1;
        }
        return ((java.lang.Integer) java.lang.Integer.class.cast(a2)).intValue();
    }

    private static long a(java.io.File file) {
        android.os.StatFs statFs = new android.os.StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String str;
        if (d == null) {
            java.lang.String l = l(context);
            java.lang.String m = !com.xiaomi.push.iu.f() ? m(context) : "";
            int i2 = 1;
            if (!(android.os.Build.VERSION.SDK_INT < 26) && b(m) && b((java.lang.String) null)) {
                com.xiaomi.push.aa.a(context);
                if (android.text.TextUtils.isEmpty(null)) {
                    java.lang.String b2 = com.xiaomi.push.aa.a(context).b();
                    if (android.text.TextUtils.isEmpty(b2) || b2.startsWith("00000000-0000-0000-0000-000000000000")) {
                        i2 = 5;
                    } else {
                        i2 = 4;
                        l = b2;
                    }
                } else {
                    l = ((java.lang.String) null) + l;
                    i2 = 2;
                }
            } else {
                l = m + l + ((java.lang.String) null);
            }
            com.xiaomi.channel.commonutils.logger.b.b("devid rule select:".concat(java.lang.String.valueOf(i2)));
            if (i2 == 3) {
                d = l;
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                if (i2 > 0) {
                    java.lang.String[] strArr = g;
                    if (i2 < strArr.length) {
                        str = strArr[i2];
                        sb.append(str);
                        sb.append(com.xiaomi.push.ao.b(l));
                        d = sb.toString();
                    }
                }
                str = g[0];
                sb.append(str);
                sb.append(com.xiaomi.push.ao.b(l));
                d = sb.toString();
            }
        }
        return d;
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        android.content.pm.ApplicationInfo applicationInfo;
        android.content.pm.PackageInfo packageInfo = (android.content.pm.PackageInfo) com.xiaomi.push.aj.a((java.lang.Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
            int i2 = applicationInfo.flags;
            if ((i2 & 2097152) != 2097152 || (i2 & 8388608) == 8388608) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            java.lang.String[] strArr = g;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    public static java.lang.String b() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        float g2 = ((((((g() + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = g2;
        if (d2 > 0.5d) {
            g2 = (float) java.lang.Math.ceil(d2);
        }
        sb.append(g2);
        sb.append("GB");
        return sb.toString();
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            return com.xiaomi.push.it.a(context).a;
        } catch (java.lang.Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    private static boolean b(java.lang.String str) {
        if (str == null) {
            return true;
        }
        java.lang.String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase(com.igexin.push.core.b.m) || trim.equalsIgnoreCase("unknown");
    }

    public static java.lang.String c() {
        int i2 = 1;
        while (true) {
            double d2 = i2;
            if (d2 >= ((a(android.os.Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) {
                return d2 + "GB";
            }
            i2 <<= 1;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        int f2 = f();
        java.lang.String d2 = d(context);
        while (d2 == null) {
            int i2 = f2 - 1;
            if (f2 <= 0) {
                break;
            }
            try {
                java.lang.Thread.sleep(500L);
            } catch (java.lang.InterruptedException unused) {
            }
            d2 = d(context);
            f2 = i2;
        }
        return d2;
    }

    private static boolean c(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && com.xiaomi.push.ao.e(str) && !com.xiaomi.push.ao.f(str);
    }

    public static java.lang.String d() {
        return g() + "KB";
    }

    public static java.lang.String d(android.content.Context context) {
        java.lang.String str;
        java.lang.Object obj;
        java.lang.Object a2;
        java.lang.Object a3;
        if (com.xiaomi.push.iu.f()) {
            return "";
        }
        java.lang.String str2 = a;
        if (str2 != null) {
            return str2;
        }
        try {
            if (o(context)) {
                str = (!com.xiaomi.push.iu.a() || (a2 = com.xiaomi.push.aj.a("miui.telephony.TelephonyManager", "getDefault", new java.lang.Object[0])) == null || (a3 = com.xiaomi.push.aj.a(a2, "getMiuiDeviceId", new java.lang.Object[0])) == null || !(a3 instanceof java.lang.String)) ? null : (java.lang.String) java.lang.String.class.cast(a3);
                if (str == null) {
                    android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                    if (android.os.Build.VERSION.SDK_INT < 26) {
                        str = telephonyManager.getDeviceId();
                    } else {
                        if (1 == telephonyManager.getPhoneType()) {
                            obj = com.xiaomi.push.aj.a((java.lang.Object) telephonyManager, "getImei", (java.lang.Object[]) null);
                        } else if (2 == telephonyManager.getPhoneType()) {
                            obj = com.xiaomi.push.aj.a((java.lang.Object) telephonyManager, "getMeid", (java.lang.Object[]) null);
                        }
                        str = (java.lang.String) obj;
                    }
                }
            } else {
                str = null;
            }
            if (!c(str)) {
                return "";
            }
            a = str;
            return str;
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("failure to get id:".concat(java.lang.String.valueOf(th)));
            return null;
        }
    }

    public static java.lang.String e() {
        return (a(android.os.Environment.getDataDirectory()) / 1024) + "KB";
    }

    public static java.lang.String e(android.content.Context context) {
        int f2 = f();
        java.lang.String f3 = f(context);
        while (f3 == null) {
            int i2 = f2 - 1;
            if (f2 <= 0) {
                break;
            }
            try {
                java.lang.Thread.sleep(500L);
            } catch (java.lang.InterruptedException unused) {
            }
            f3 = f(context);
            f2 = i2;
        }
        return f3;
    }

    private static int f() {
        return android.os.Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    public static java.lang.String f(android.content.Context context) {
        n(context);
        java.lang.String str = "";
        if (android.text.TextUtils.isEmpty(c)) {
            return "";
        }
        for (java.lang.String str2 : c.split(",")) {
            if (c(str2)) {
                str = str + com.xiaomi.push.ao.a(str2) + ",";
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    private static int g() {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.lang.String[] split;
        int i2 = 0;
        if (new java.io.File("/proc/meminfo").exists()) {
            java.io.BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/meminfo"), 8192);
                } catch (java.io.IOException unused) {
                }
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (!android.text.TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && android.text.TextUtils.isDigitsOnly(split[1])) {
                        i2 = java.lang.Integer.parseInt(split[1]);
                    }
                    bufferedReader.close();
                } catch (java.lang.Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception unused4) {
            } catch (java.lang.Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
        return i2;
    }

    public static synchronized java.lang.String g(android.content.Context context) {
        synchronized (com.xiaomi.push.ib.class) {
            java.lang.String str = e;
            if (str != null) {
                return str;
            }
            java.lang.String b2 = com.xiaomi.push.ao.b(l(context) + ((java.lang.String) null));
            e = b2;
            return b2;
        }
    }

    public static synchronized java.lang.String h(android.content.Context context) {
        java.lang.String b2;
        synchronized (com.xiaomi.push.ib.class) {
            b2 = com.xiaomi.push.ao.b(l(context) + ((java.lang.String) null));
        }
        return b2;
    }

    public static java.lang.String i(android.content.Context context) {
        return ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimOperatorName();
    }

    public static boolean j(android.content.Context context) {
        android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static boolean k(android.content.Context context) {
        android.os.PowerManager powerManager = (android.os.PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    private static java.lang.String l(android.content.Context context) {
        java.lang.String str = b;
        if (str != null || !i) {
            return str;
        }
        boolean p = p(context);
        i = p;
        if (!p) {
            return null;
        }
        try {
            b = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("failure to get androidId: ".concat(java.lang.String.valueOf(th)));
        }
        return b;
    }

    private static java.lang.String m(android.content.Context context) {
        int f2 = f();
        java.lang.String d2 = d(context);
        while (android.text.TextUtils.isEmpty(d2)) {
            int i2 = f2 - 1;
            if (f2 <= 0) {
                break;
            }
            try {
                java.lang.Thread.sleep(500L);
            } catch (java.lang.InterruptedException unused) {
            }
            d2 = d(context);
            f2 = i2;
        }
        return d2;
    }

    private static java.lang.String n(android.content.Context context) {
        java.lang.Object a2;
        if (com.xiaomi.push.iu.f() || android.os.Build.VERSION.SDK_INT < 22) {
            return "";
        }
        if (!android.text.TextUtils.isEmpty(c)) {
            return c;
        }
        d(context);
        if (android.text.TextUtils.isEmpty(a)) {
            return "";
        }
        try {
            if (o(context)) {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                java.lang.Integer num = (java.lang.Integer) com.xiaomi.push.aj.a((java.lang.Object) telephonyManager, "getPhoneCount", new java.lang.Object[0]);
                if (num != null && num.intValue() > 1) {
                    java.lang.String str = null;
                    for (int i2 = 0; i2 < num.intValue(); i2++) {
                        if (android.os.Build.VERSION.SDK_INT < 26) {
                            a2 = com.xiaomi.push.aj.a((java.lang.Object) telephonyManager, "getDeviceId", java.lang.Integer.valueOf(i2));
                        } else if (1 == telephonyManager.getPhoneType()) {
                            a2 = com.xiaomi.push.aj.a((java.lang.Object) telephonyManager, "getImei", java.lang.Integer.valueOf(i2));
                        } else {
                            if (2 == telephonyManager.getPhoneType()) {
                                a2 = com.xiaomi.push.aj.a((java.lang.Object) telephonyManager, "getMeid", java.lang.Integer.valueOf(i2));
                            }
                            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.equals(a, str) && c(str)) {
                                c += str + ",";
                            }
                        }
                        str = (java.lang.String) a2;
                        if (!android.text.TextUtils.isEmpty(str)) {
                            c += str + ",";
                        }
                    }
                    int length = c.length();
                    if (length > 0) {
                        c = c.substring(0, length - 1);
                    }
                    return c;
                }
            }
            return "";
        } catch (java.lang.Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("failure to get ids: ".concat(java.lang.String.valueOf(e2)));
            return "";
        }
    }

    private static boolean o(android.content.Context context) {
        java.lang.String packageName = context.getPackageName();
        if (com.xiaomi.push.iu.a() && h.contains(packageName)) {
            return context.getPackageManager().checkPermission(com.anythink.china.common.d.a, packageName) == 0 || context.getPackageManager().checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", packageName) == 0;
        }
        return false;
    }

    private static boolean p(android.content.Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        android.content.Intent intent = new android.content.Intent();
        android.content.ComponentName componentName = new android.content.ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
        intent.setComponent(componentName);
        try {
            android.os.Bundle bundle = context.getPackageManager().getServiceInfo(componentName, 128).metaData;
            if (bundle != null) {
                java.lang.String string = bundle.getString("supportGetAndroidID");
                if (android.text.TextUtils.isEmpty(string)) {
                    return true;
                }
                return java.lang.Boolean.parseBoolean(string);
            }
        } catch (java.lang.Exception unused) {
        }
        return true;
    }
}
