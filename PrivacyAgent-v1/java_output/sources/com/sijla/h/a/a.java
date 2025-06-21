package com.sijla.h.a;

/* loaded from: classes19.dex */
public final class a {
    private static java.lang.String a = "";
    private static java.lang.String b = "";
    private static java.lang.String c = "";
    private static java.lang.String d = "";
    private static long e = 0;
    private static org.json.JSONObject f = null;
    private static int g = 0;
    private static java.lang.String h = "";

    public static java.lang.String a(android.content.Context context) {
        return "qtcallback_" + context.getPackageName();
    }

    public static java.lang.String a(android.content.Context context, boolean z) {
        com.sijla.bean.a aVar;
        java.lang.String a2;
        if (z) {
            return "";
        }
        try {
            aVar = (com.sijla.bean.a) com.sijla.h.a.a(context).b("iim");
            if (aVar == null) {
                aVar = new com.sijla.bean.a();
            }
            a2 = aVar.a();
        } catch (java.lang.Exception unused) {
        }
        if (!com.sijla.h.c.a(a2)) {
            return a2;
        }
        if (!com.sijla.h.c.a("")) {
            aVar.a("");
            com.sijla.h.a.a(context).a("iim", aVar);
            return "";
        }
        return "emt";
    }

    public static void a(android.content.Context context, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.sijla.bean.a aVar = (com.sijla.bean.a) com.sijla.h.a.a(context).b("iim");
            if (aVar == null) {
                aVar = new com.sijla.bean.a();
            }
            aVar.a(str);
            com.sijla.h.a.a(context).a("iim", aVar);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            com.sijla.h.a.e.a(str2, c(context, str), false);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a() {
        try {
            java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
            if (externalStorageState == null || !externalStorageState.equals("mounted")) {
                return false;
            }
            return !externalStorageState.equals("mounted_ro");
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        return "QM_ON_APP_FOREGROUND_" + context.getPackageName();
    }

    public static java.lang.String b(android.content.Context context, boolean z) {
        if (z) {
            return "";
        }
        com.sijla.bean.a aVar = (com.sijla.bean.a) com.sijla.h.a.a(context).b("iim");
        if (aVar == null) {
            aVar = new com.sijla.bean.a();
        }
        java.lang.String b2 = aVar.b();
        if (!com.sijla.h.c.a(b2)) {
            return b2;
        }
        if (com.sijla.h.c.a("")) {
            return "";
        }
        aVar.b("");
        com.sijla.h.a.a(context).a("iim", aVar);
        return "";
    }

    public static boolean b() {
        java.lang.String[] strArr = {"/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/"};
        for (int i = 0; i < 5; i++) {
            if (new java.io.File(strArr[i] + com.getui.gtc.extension.distribution.gbd.n.aa.a).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(android.content.Context context, java.lang.String str) {
        if (context != null) {
            try {
                return context.checkPermission(str, android.os.Process.myPid(), android.system.Os.getuid()) == 0;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static java.lang.String c() {
        java.lang.String processName;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return "";
        }
        processName = android.app.Application.getProcessName();
        return processName;
    }

    public static java.lang.String c(android.content.Context context) {
        return "QM_ON_APP_BACKGROUND_" + context.getPackageName();
    }

    private static java.lang.String c(android.content.Context context, java.lang.String str) {
        return com.sijla.h.a.d.b(context) + "/cache2/" + str;
    }

    public static java.lang.String d() {
        return "";
    }

    private static java.lang.String d(android.content.Context context, java.lang.String str) {
        try {
            java.io.File file = new java.io.File(c(context, str));
            return (file.exists() && file.isFile()) ? com.sijla.h.a.e.b(file).trim() : "";
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean d(android.content.Context context) {
        try {
            return ((android.os.PowerManager) context.getSystemService("power")).isInteractive();
        } catch (java.lang.Exception unused) {
            return true;
        }
    }

    public static java.lang.String e() {
        return f() + " " + h();
    }

    public static boolean e(android.content.Context context) {
        com.sijla.h.c.a.a();
        if (!com.sijla.h.c.a.b()) {
            return false;
        }
        try {
            android.net.NetworkInfo v = v(context);
            if (v != null && v.isConnected()) {
                if (v.getState() == android.net.NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static java.lang.String f() {
        try {
            return android.os.Build.MANUFACTURER;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean f(android.content.Context context) {
        android.net.NetworkInfo v = v(context);
        return v != null && v.isConnected() && v.getType() == 1;
    }

    public static java.lang.String g() {
        try {
            return android.os.Build.BRAND;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void g(android.content.Context context) {
        if (com.sijla.h.c.a(context, "___swssid___", 300L)) {
            com.sijla.a.a.a(new com.sijla.h.a.b(context));
        }
    }

    public static java.lang.String h() {
        try {
            return android.os.Build.MODEL;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String h(android.content.Context context) {
        java.lang.String d2 = d(context, "wsidcache");
        if (d2 == null) {
            d2 = "";
        }
        return d2.replace("\n", "");
    }

    public static java.lang.String i() {
        return "";
    }

    public static java.lang.String i(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(a)) {
            try {
                android.content.pm.PackageManager packageManager = context.getPackageManager();
                a = packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString().trim();
            } catch (java.lang.Exception unused) {
            }
        }
        return a;
    }

    public static java.lang.String j() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static java.lang.String j(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(b)) {
            try {
                b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName.replace(" ", "");
            } catch (java.lang.Exception unused) {
            }
        }
        return b;
    }

    public static java.lang.String k() {
        return "";
    }

    public static void k(android.content.Context context) {
        try {
            java.lang.String packageName = context.getPackageName();
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            b = packageInfo.versionName.replace(" ", "");
            a = packageInfo.applicationInfo.loadLabel(packageManager).toString().trim();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            f = jSONObject;
            jSONObject.put("instime", packageInfo.firstInstallTime);
            f.put("uptime", packageInfo.lastUpdateTime);
            f.put("installer", "");
            h = com.sijla.h.a.g.a(new java.lang.String(packageInfo.signatures[0].toByteArray()));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public static java.lang.String l() {
        if (android.text.TextUtils.isEmpty(d) && java.lang.System.currentTimeMillis() - e > 3600000) {
            e = java.lang.System.currentTimeMillis();
            d = "";
        }
        return d;
    }

    public static java.lang.String l(android.content.Context context) {
        java.lang.String w = w(context);
        return android.text.TextUtils.isEmpty(w) ? w(context) : w;
    }

    public static java.lang.String m() {
        return "";
    }

    public static java.lang.String m(android.content.Context context) {
        return w(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static java.lang.String n() {
        java.lang.Exception e2;
        java.io.BufferedReader bufferedReader;
        java.lang.Object obj = "/proc/meminfo";
        java.lang.String str = "";
        int i = 1;
        i = 1;
        java.lang.Object obj2 = null;
        try {
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/meminfo"), 8192);
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    str = readLine.substring(readLine.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1).trim();
                    java.io.Closeable[] closeableArr = {bufferedReader};
                    com.sijla.h.c.a(closeableArr);
                    obj = bufferedReader;
                    i = closeableArr;
                } catch (java.lang.Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    java.io.Closeable[] closeableArr2 = {bufferedReader};
                    com.sijla.h.c.a(closeableArr2);
                    obj = bufferedReader;
                    i = closeableArr2;
                    return str;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                obj2 = obj;
                java.io.Closeable[] closeableArr3 = new java.io.Closeable[i];
                closeableArr3[0] = obj2;
                com.sijla.h.c.a(closeableArr3);
                throw th;
            }
        } catch (java.lang.Exception e4) {
            e2 = e4;
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            java.io.Closeable[] closeableArr32 = new java.io.Closeable[i];
            closeableArr32[0] = obj2;
            com.sijla.h.c.a(closeableArr32);
            throw th;
        }
        return str;
    }

    public static java.lang.String n(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(c)) {
            java.lang.String str = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            if (context == null) {
                return com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            java.lang.String d2 = d(context, "osc_mno");
            if (!android.text.TextUtils.isEmpty(d2)) {
                c = d2;
            } else if (b(context, com.anythink.china.common.d.a)) {
                try {
                    android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                    if (5 == telephonyManager.getSimState()) {
                        java.lang.String simOperator = telephonyManager.getSimOperator();
                        if (!android.text.TextUtils.isEmpty(simOperator)) {
                            str = simOperator;
                        }
                        c = str;
                        a(context, "osc_mno", str);
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                c = "nop";
            }
        }
        return c;
    }

    public static long o() {
        try {
            if (a()) {
                return (android.os.Environment.getExternalStorageDirectory().getFreeSpace() / 1024) / 1024;
            }
            return 0L;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static java.lang.String o(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager == null || !b(context, com.anythink.china.common.d.a)) {
            return "";
        }
        int networkType = telephonyManager.getNetworkType();
        switch (networkType) {
        }
        return "";
    }

    public static java.lang.String p() {
        return "";
    }

    public static java.lang.String p(android.content.Context context) {
        return a(context, false);
    }

    public static int q() {
        int i = g;
        if (i != 0) {
            return i;
        }
        try {
            g = new java.io.File("/sys/devices/system/cpu/").listFiles(new com.sijla.h.a.c()).length;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        if (g <= 0) {
            g = java.lang.Runtime.getRuntime().availableProcessors();
        }
        if (g <= 0) {
            g = 1;
        }
        return g;
    }

    public static java.lang.String q(android.content.Context context) {
        return b(context, false);
    }

    public static long r() {
        return java.lang.System.currentTimeMillis() - android.os.SystemClock.elapsedRealtime();
    }

    public static org.json.JSONObject r(android.content.Context context) {
        org.json.JSONObject jSONObject = f;
        if (jSONObject == null || !jSONObject.keys().hasNext()) {
            f = new org.json.JSONObject();
            try {
                android.content.pm.PackageManager packageManager = context.getPackageManager();
                java.lang.String packageName = context.getPackageName();
                f.put("appid", packageName);
                if (packageManager != null) {
                    android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                    long j = packageInfo.firstInstallTime;
                    long j2 = packageInfo.lastUpdateTime;
                    f.put("instime", j);
                    f.put("uptime", j2);
                    f.put("installer", "");
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return f;
    }

    public static int s() {
        return -1;
    }

    public static java.lang.String s(android.content.Context context) {
        try {
            return a() ? android.text.format.Formatter.formatFileSize(context, android.os.Environment.getExternalStorageDirectory().getTotalSpace()) : "0M";
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "0M";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static java.lang.String t(android.content.Context context) {
        android.net.NetworkInfo v;
        try {
            v = v(context);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
        if (v == null || !v.isConnected()) {
            return "";
        }
        if (v.getType() == 1) {
            return "WIFI";
        }
        if (v.getType() != 0) {
            return "";
        }
        java.lang.String subtypeName = v.getSubtypeName();
        switch (v.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                break;
            case 13:
                break;
            default:
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                    if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                        break;
                    }
                }
                break;
        }
        return "";
    }

    public static java.lang.String u(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(h)) {
            try {
                h = com.sijla.h.a.g.a(new java.lang.String(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()));
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return h;
    }

    private static android.net.NetworkInfo v(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        try {
            if (!b(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static java.lang.String w(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(com.sijla.b.g.b)) {
            try {
                java.lang.String d2 = d(context, "ANDROID_I_K");
                if (android.text.TextUtils.isEmpty(d2)) {
                    d2 = java.util.UUID.randomUUID().toString();
                    a(context, "ANDROID_I_K", d2);
                }
                com.sijla.b.g.b = d2;
            } catch (java.lang.Exception unused) {
            }
        }
        return com.sijla.b.g.b;
    }
}
