package com.anythink.expressad.foundation.h;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public final class k extends com.anythink.expressad.foundation.h.d {
    private static final java.lang.String a = "SameDiTool";
    private static java.lang.String b = null;
    private static java.lang.String c = null;
    private static int d = -1;
    private static int e = -1;
    private static int f = -1;
    private static java.lang.String g = "";
    private static java.lang.String h = "";
    private static java.lang.String i = "";
    private static java.lang.String j = "";
    private static int k = 0;
    private static java.lang.String l = "";
    private static java.lang.String m = "";
    private static int n = -1;
    private static java.lang.String o = "";
    private static int p = 0;
    private static java.lang.String q = "";

    /* renamed from: com.anythink.expressad.foundation.h.k$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.foundation.h.d.a(this.a);
        }
    }

    /* renamed from: com.anythink.expressad.foundation.h.k$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass2(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        @android.annotation.SuppressLint({"MissingPermission"})
        public final void run() {
            android.content.Context context;
            android.net.ConnectivityManager connectivityManager;
            try {
                if (com.anythink.core.common.b.o.a().c("network_type")) {
                    return;
                }
                try {
                    if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() || (context = this.a) == null || (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) == null) {
                        return;
                    }
                    android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        int unused = com.anythink.expressad.foundation.h.k.f = 0;
                        return;
                    }
                    if (activeNetworkInfo.getType() == 1) {
                        int unused2 = com.anythink.expressad.foundation.h.k.f = 9;
                        return;
                    }
                    android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) this.a.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                    if (telephonyManager == null) {
                        int unused3 = com.anythink.expressad.foundation.h.k.f = 0;
                    } else {
                        int unused4 = com.anythink.expressad.foundation.h.k.f = com.anythink.expressad.foundation.h.k.a(telephonyManager.getNetworkType());
                    }
                } catch (java.lang.Exception unused5) {
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
                int unused6 = com.anythink.expressad.foundation.h.k.f = 0;
            }
        }
    }

    private k() {
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static int a() {
        try {
            android.content.Context f2 = com.anythink.core.common.b.o.a().f();
            if (com.anythink.core.common.b.o.a().c("network_type")) {
                return f;
            }
            try {
                if (com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() && f2 != null) {
                    if (f == -1) {
                        f = 0;
                        return 0;
                    }
                    try {
                        com.anythink.expressad.foundation.h.k.AnonymousClass2 anonymousClass2 = new com.anythink.expressad.foundation.h.k.AnonymousClass2(f2);
                        if (com.anythink.expressad.foundation.g.h.a.b().getActiveCount() <= 0) {
                            com.anythink.expressad.foundation.g.h.a.b().execute(anonymousClass2);
                        }
                    } catch (java.lang.Throwable th) {
                        th.getMessage();
                    }
                    return f;
                }
                return f;
            } catch (java.lang.Exception unused) {
                return f;
            }
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
            f = 0;
            return 0;
        }
    }

    public static int a(int i2) {
        if (i2 == 20) {
            return 5;
        }
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static java.lang.String a(android.content.Context context, int i2) {
        android.telephony.TelephonyManager telephonyManager;
        if (i2 == 0 || i2 == 9) {
            return "";
        }
        try {
            return (!com.anythink.expressad.foundation.g.a.bW || (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)) == null) ? "" : java.lang.String.valueOf(telephonyManager.getNetworkType());
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return "";
        }
    }

    private static java.lang.String a(java.lang.String str, android.content.Context context) {
        try {
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
        if (!android.text.TextUtils.isEmpty(o)) {
            return o;
        }
        if (!android.text.TextUtils.isEmpty(str) && context != null) {
            o = context.getPackageManager().getInstallerPackageName(str);
        }
        return o;
    }

    private static void a(java.lang.String str) {
        c = com.anythink.expressad.foundation.h.j.a(str);
        b = str;
    }

    public static int b(android.content.Context context) {
        android.content.res.Configuration configuration;
        return (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null || configuration.orientation != 2) ? 1 : 2;
    }

    public static java.lang.String b() {
        if (com.anythink.core.common.b.o.a().c("model")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                return "";
            }
            return android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static int c(android.content.Context context) {
        if (context == null) {
            return k;
        }
        int i2 = k;
        if (i2 != 0) {
            return i2;
        }
        try {
            int i3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            k = i3;
            return i3;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static java.lang.String c() {
        if (com.anythink.core.common.b.o.a().c("os_vc")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                return "";
            }
            if (android.text.TextUtils.isEmpty(h)) {
                h = java.lang.String.valueOf(d());
            }
            return h;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static int d() {
        try {
            return android.os.Build.VERSION.SDK_INT;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static java.lang.String d(android.content.Context context) {
        if (context == null) {
            return j;
        }
        try {
            if (!android.text.TextUtils.isEmpty(j)) {
                return j;
            }
            java.lang.String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            j = str;
            return str;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int e(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("screen")) {
            return 0;
        }
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() || context == null) {
                return 0;
            }
            try {
                android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                java.util.HashMap g2 = g(context);
                return g2.get("width") == null ? displayMetrics.widthPixels : ((java.lang.Integer) g2.get("width")).intValue();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static java.lang.String e() {
        android.content.Context f2;
        long currentTimeMillis;
        long l2;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3 = "";
        try {
            f2 = com.anythink.core.common.b.o.a().f();
            currentTimeMillis = java.lang.System.currentTimeMillis() - android.os.SystemClock.elapsedRealtime();
            l2 = l();
            str = "app_tki_" + currentTimeMillis + "_" + l2;
            str2 = (java.lang.String) com.anythink.expressad.foundation.h.v.b(f2, str, "");
            try {
            } catch (java.lang.Exception e2) {
                e = e2;
                str3 = str2;
                e.printStackTrace();
                return str3;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            return str2;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("1", "");
            jSONObject.put("2", java.lang.String.valueOf(l2));
            jSONObject.put("3", java.lang.String.valueOf(currentTimeMillis));
            jSONObject.put("4", "");
            jSONObject.put("5", "");
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
        }
        str3 = com.anythink.expressad.foundation.h.a.a(jSONObject.toString());
        com.anythink.expressad.foundation.h.v.a(f2, str, str3);
        return str3;
    }

    public static int f() {
        if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
            return 0;
        }
        if (d <= 0) {
            try {
                android.content.Context f2 = com.anythink.core.common.b.o.a().f();
                long longValue = ((java.lang.Long) com.anythink.expressad.foundation.h.v.b(f2, "TotalRamSize", 0L)).longValue();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (currentTimeMillis - longValue > 1800000 || d == -1) {
                    d = java.lang.Long.valueOf((l() / 1000) / 1000).intValue();
                    com.anythink.expressad.foundation.h.v.a(f2, "TotalRamSize", java.lang.Long.valueOf(currentTimeMillis));
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
        return d;
    }

    public static int f(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("screen")) {
            return 0;
        }
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() || context == null) {
                return 0;
            }
            try {
                android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                java.util.HashMap g2 = g(context);
                return g2.get("height") == null ? displayMetrics.heightPixels : ((java.lang.Integer) g2.get("height")).intValue();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static int g() {
        try {
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
        if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
            return 0;
        }
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        long j2 = 0;
        long longValue = ((java.lang.Long) com.anythink.expressad.foundation.h.v.b(f2, "FreeRamSize", 0L)).longValue();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - longValue > 1800000 || e == -1) {
            android.content.Context f3 = com.anythink.core.common.b.o.a().f();
            if (f3 != null) {
                android.app.ActivityManager activityManager = (android.app.ActivityManager) f3.getSystemService("activity");
                android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                j2 = memoryInfo.availMem;
            }
            e = java.lang.Long.valueOf((j2 / 1000) / 1000).intValue();
            com.anythink.expressad.foundation.h.v.a(f2, "FreeRamSize", java.lang.Long.valueOf(currentTimeMillis));
        }
        return e;
    }

    public static java.util.HashMap g(android.content.Context context) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            hashMap.put("height", java.lang.Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("width", java.lang.Integer.valueOf(displayMetrics.widthPixels));
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
        return hashMap;
    }

    public static java.lang.String h() {
        if (android.text.TextUtils.isEmpty(q)) {
            q = !com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() ? "" : java.util.Arrays.asList(android.os.Build.SUPPORTED_ABIS).toString();
        }
        return q;
    }

    public static java.lang.String h(android.content.Context context) {
        if (context == null) {
            return i;
        }
        try {
            if (!android.text.TextUtils.isEmpty(i)) {
                return i;
            }
            java.lang.String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            i = str;
            return str;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int i() {
        return 0;
    }

    public static void i(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                com.anythink.expressad.foundation.h.d.a(context);
            } else {
                com.anythink.core.common.b.o.a().b(new com.anythink.expressad.foundation.h.k.AnonymousClass1(context));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static java.util.UUID j() {
        try {
            return java.util.UUID.randomUUID();
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return null;
        }
    }

    private static void j(android.content.Context context) {
        try {
            h(context);
            d(context);
            c(context);
            b(context);
            com.anythink.expressad.foundation.g.a.bX = com.anythink.expressad.foundation.h.t.a(com.anythink.china.common.d.b, context);
            com.anythink.expressad.foundation.g.a.bW = com.anythink.expressad.foundation.h.t.a("android.permission.ACCESS_NETWORK_STATE", context);
            k(context);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static int k() {
        return n;
    }

    private static int k(android.content.Context context) {
        if (context == null) {
            return p;
        }
        if (p == 0) {
            try {
                p = context.getApplicationInfo().targetSdkVersion;
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
        }
        return p;
    }

    private static long l() {
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        if (f2 == null) {
            return 0L;
        }
        android.app.ActivityManager activityManager = (android.app.ActivityManager) f2.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static void l(android.content.Context context) {
        try {
            com.anythink.expressad.foundation.h.k.AnonymousClass2 anonymousClass2 = new com.anythink.expressad.foundation.h.k.AnonymousClass2(context);
            if (com.anythink.expressad.foundation.g.h.a.b().getActiveCount() <= 0) {
                com.anythink.expressad.foundation.g.h.a.b().execute(anonymousClass2);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private static long m() {
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        if (f2 == null) {
            return 0L;
        }
        android.app.ActivityManager activityManager = (android.app.ActivityManager) f2.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static boolean m(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics;
        if (context == null) {
            return false;
        }
        try {
            android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
            displayMetrics = new android.util.DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
        return java.lang.Math.sqrt(java.lang.Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + java.lang.Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 6.0d;
    }

    private static java.lang.String n() {
        return !com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() ? "" : java.util.Arrays.asList(android.os.Build.SUPPORTED_ABIS).toString();
    }

    private static java.lang.String o() {
        return !com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() ? "" : android.os.Build.CPU_ABI;
    }

    private static java.lang.String p() {
        return !com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() ? "" : android.os.Build.CPU_ABI2;
    }
}
