package com.aliyun.svideosdk.conan;

/* loaded from: classes12.dex */
public class a {
    public static final java.io.File a = new java.io.File(android.os.Environment.getExternalStorageDirectory(), "AlivcData");
    private static java.lang.String b;
    private static java.lang.String c;
    private static android.content.Context d;
    private static int e;
    private static com.aliyun.svideosdk.conan.b f;

    /* renamed from: com.aliyun.svideosdk.conan.a$a, reason: collision with other inner class name */
    public static class C0089a extends java.util.TimerTask {
        final /* synthetic */ java.io.File a;
        final /* synthetic */ java.lang.String b;

        public C0089a(java.io.File file, java.lang.String str) {
            this.a = file;
            this.b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0024 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #0 {all -> 0x0034, blocks: (B:3:0x0001, B:5:0x000a, B:9:0x0016, B:11:0x001d, B:13:0x0024), top: B:2:0x0001 }] */
        @Override // java.util.TimerTask, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            boolean z2 = false;
            if (!this.a.exists() && !this.a.createNewFile()) {
                z = false;
                java.util.Properties properties = new java.util.Properties();
                properties.setProperty("UUID", this.b);
                if (z) {
                    java.io.FileWriter fileWriter = new java.io.FileWriter(this.a);
                    properties.store(fileWriter, (java.lang.String) null);
                    fileWriter.close();
                    z2 = true;
                }
                com.aliyun.svideosdk.conan.a.b();
                if (!z2 || com.aliyun.svideosdk.conan.a.e >= 10) {
                }
                com.aliyun.svideosdk.conan.a.b(this.a, this.b);
                return;
            }
            z = true;
            java.util.Properties properties2 = new java.util.Properties();
            properties2.setProperty("UUID", this.b);
            if (z) {
            }
            com.aliyun.svideosdk.conan.a.b();
            if (z2) {
            }
        }
    }

    public static /* synthetic */ int b() {
        int i = e;
        e = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.io.File file, java.lang.String str) {
        if (file == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        new java.util.Timer().schedule(new com.aliyun.svideosdk.conan.a.C0089a(file, str), 3000L);
    }

    public static java.lang.String c() {
        return java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static java.lang.String d() {
        java.lang.String str;
        try {
            str = (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(null, "ro.board.platform", "");
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        return str.equals("") ? android.os.Build.HARDWARE : str;
    }

    public static java.lang.String e() {
        if (!android.text.TextUtils.isEmpty(c)) {
            return c;
        }
        r();
        return c;
    }

    public static java.lang.String f() {
        if (f == null) {
            f = new com.aliyun.svideosdk.conan.b();
        }
        f.a(p());
        return java.lang.String.valueOf(f.a());
    }

    public static java.lang.String g() {
        return android.os.Build.BRAND;
    }

    public static java.lang.String h() {
        return android.os.Build.MANUFACTURER;
    }

    public static java.lang.String i() {
        return android.os.Build.MODEL;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:13:0x0019, B:15:0x001f, B:20:0x002b), top: B:12:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[Catch: all -> 0x0066, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000b, B:10:0x000f, B:22:0x0043, B:24:0x004b, B:25:0x0062), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized java.lang.String j() {
        boolean z;
        synchronized (com.aliyun.svideosdk.conan.a.class) {
            if (!android.text.TextUtils.isEmpty(b)) {
                return b;
            }
            java.io.File file = a;
            java.io.File file2 = new java.io.File(file, "alivc_data.txt");
            if (!file.exists() && !file.mkdir()) {
                z = false;
                if (z) {
                    java.util.Properties properties = new java.util.Properties();
                    java.io.FileReader fileReader = new java.io.FileReader(file2);
                    properties.load(fileReader);
                    fileReader.close();
                    b = properties.getProperty("UUID");
                }
                if (android.text.TextUtils.isEmpty(b)) {
                    e = 0;
                    java.lang.String replace = java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                    b = replace;
                    b(file2, replace);
                }
                return b;
            }
            z = true;
            if (z) {
            }
            if (android.text.TextUtils.isEmpty(b)) {
            }
            return b;
        }
    }

    public static java.lang.String k() {
        if (d == null) {
            return "0";
        }
        try {
            android.content.Intent registerReceiver = d.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            return java.lang.String.valueOf((int) (((registerReceiver != null ? registerReceiver.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, -1) : -1) / (registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1)) * 100.0f));
        } catch (java.lang.Throwable unused) {
            return "0";
        }
    }

    public static java.lang.String l() {
        return "";
    }

    public static java.lang.String m() {
        android.content.Context context = d;
        if (context == null) {
            return "0";
        }
        try {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return "0";
            }
            android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j = memoryInfo.totalMem;
            return j > 0 ? java.lang.String.valueOf((int) ((1.0f - ((memoryInfo.availMem * 1.0f) / j)) * 100.0f)) : "0";
        } catch (java.lang.Throwable unused) {
            return "0";
        }
    }

    public static java.lang.String n() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static java.lang.String o() {
        android.content.pm.ConfigurationInfo deviceConfigurationInfo;
        android.content.Context context = d;
        if (context != null) {
            try {
                android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
                if (activityManager != null && (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) != null) {
                    return java.lang.Integer.toHexString(java.lang.Integer.parseInt(deviceConfigurationInfo.reqGlEsVersion + ""));
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    public static android.content.Context p() {
        return d;
    }

    public static java.lang.String q() {
        try {
            android.content.Context context = d;
            return (context == null || context.getResources() == null || d.getResources().getConfiguration() == null) ? com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE : (d.getResources().getConfiguration().screenLayout & 15) >= 3 ? "pad" : com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE;
        } catch (java.lang.Throwable unused) {
            return com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void r() {
        java.io.BufferedReader bufferedReader;
        java.io.FileReader fileReader;
        java.io.FileReader fileReader2 = null;
        try {
            fileReader = new java.io.FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader);
            } catch (java.lang.Exception unused) {
                bufferedReader = null;
            } catch (java.lang.Throwable th) {
                bufferedReader = null;
                fileReader2 = fileReader;
                th = th;
            }
            try {
                java.lang.String readLine = bufferedReader.readLine();
                int i = 0;
                while (true) {
                    i++;
                    if (i >= 30) {
                        break;
                    }
                    java.lang.String[] split = readLine.split(":\\s+", 2);
                    if (split.length > 1 && split[0].contains("Processor")) {
                        c = split[1];
                    }
                    if (android.text.TextUtils.isEmpty(c)) {
                        readLine = bufferedReader.readLine();
                    }
                }
            } catch (java.lang.Exception unused2) {
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (bufferedReader == null) {
                    return;
                }
                bufferedReader.close();
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                if (bufferedReader == null) {
                    throw th;
                }
                try {
                    bufferedReader.close();
                    throw th;
                } catch (java.io.IOException unused5) {
                    throw th;
                }
            }
        } catch (java.lang.Exception unused6) {
            bufferedReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
            try {
                fileReader.close();
                break;
            } catch (java.io.IOException unused7) {
            }
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (java.io.IOException unused8) {
            }
            fileReader.close();
            bufferedReader.close();
        } catch (java.io.IOException unused9) {
        }
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public static void setSDKContext(android.content.Context context) {
        d = context != null ? context.getApplicationContext() : context;
        if (f == null) {
            f = new com.aliyun.svideosdk.conan.b();
        }
        f.a(context);
    }
}
