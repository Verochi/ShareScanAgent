package com.umeng.commonsdk.internal.utils;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes19.dex */
public class k {
    public static final java.lang.String b = "_dsk_s";
    public static final java.lang.String c = "_thm_z";
    public static final java.lang.String d = "_gdf_r";
    public static final java.lang.String a = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.f444s);
    private static java.lang.Object e = new java.lang.Object();

    /* renamed from: com.umeng.commonsdk.internal.utils.k$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ java.lang.String[] a;
        final /* synthetic */ android.content.Context b;

        public AnonymousClass1(java.lang.String[] strArr, android.content.Context context) {
            this.a = strArr;
            this.b = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                this.a[0] = com.umeng.commonsdk.internal.utils.k.c();
                this.a[1] = com.umeng.commonsdk.internal.utils.k.a();
                this.a[2] = com.umeng.commonsdk.internal.utils.k.b();
                com.umeng.commonsdk.statistics.common.ULog.i("diskType = " + this.a[0] + "; ThremalZone = " + this.a[1] + "; GoldFishRc = " + this.a[2]);
                com.umeng.commonsdk.internal.utils.k.b(this.b, this.a);
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.b, th);
            }
        }
    }

    public static int a(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        int i;
        if (android.os.Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        java.lang.Process exec = java.lang.Runtime.getRuntime().exec(str);
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(exec.getInputStream()));
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i = -1;
                break;
            }
            if (readLine.contains(str2)) {
                i = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i;
        } catch (java.lang.InterruptedException unused) {
            return -1;
        }
    }

    public static java.lang.String a() {
        int i;
        try {
            i = a("ls /sys/class/thermal", "thermal_zone");
        } catch (java.lang.Throwable unused) {
            i = -1;
        }
        return i > 0 ? "thermal_zone" : i < 0 ? "noper" : "unknown";
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            synchronized (e) {
                jSONObject.put(b, sharedPreferences.getString(b, ""));
                jSONObject.put(c, sharedPreferences.getString(c, ""));
                jSONObject.put(d, sharedPreferences.getString(d, ""));
            }
            return jSONObject.toString();
        } catch (java.lang.Exception e2) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static java.lang.String b() {
        int i;
        try {
            i = a("ls /", "goldfish");
        } catch (java.lang.Throwable unused) {
            i = -1;
        }
        return i > 0 ? "goldfish" : i < 0 ? "noper" : "unknown";
    }

    public static void b(android.content.Context context) {
        if (c(context)) {
            return;
        }
        new com.umeng.commonsdk.internal.utils.k.AnonymousClass1(new java.lang.String[]{"unknown", "unknown", "unknown"}, context).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.content.Context context, java.lang.String[] strArr) {
        android.content.SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return;
        }
        synchronized (e) {
            sharedPreferences.edit().putString(b, strArr[0]).putString(c, strArr[1]).putString(d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String c() {
        java.io.BufferedReader bufferedReader;
        java.lang.String str = "mtd";
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/diskstats"));
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        str = "unknown";
                        break;
                    }
                    if (readLine.contains("mmcblk")) {
                        str = "mmcblk";
                        break;
                    }
                    if (readLine.contains("sda")) {
                        str = "sda";
                        break;
                    }
                    if (readLine.contains("mtd")) {
                        break;
                    }
                } catch (java.lang.Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    str = "noper";
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    return str;
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (java.lang.Throwable unused3) {
            }
        }
        return str;
    }

    public static boolean c(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null || android.text.TextUtils.isEmpty(sharedPreferences.getString(b, ""))) ? false : true;
    }
}
