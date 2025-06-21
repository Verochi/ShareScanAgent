package com.alipay.sdk.m.a0;

/* loaded from: classes.dex */
public final class b {
    public static com.alipay.sdk.m.a0.b j = new com.alipay.sdk.m.a0.b();
    public long a = 0;
    public long b = 0;
    public long c = 0;
    public long d = 0;
    public long e = 0;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;

    public static boolean a(long j2) {
        return java.lang.System.currentTimeMillis() - j2 < 3600000;
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    public static com.alipay.sdk.m.a0.b b() {
        return j;
    }

    public static java.lang.String c() {
        long j2;
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
            j2 = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (java.lang.Throwable unused) {
            j2 = 0;
        }
        return java.lang.String.valueOf(j2);
    }

    public static java.lang.String d() {
        long j2;
        if ("mounted".equals(android.os.Environment.getExternalStorageState())) {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
            j2 = statFs.getBlockSize() * statFs.getAvailableBlocks();
            return java.lang.String.valueOf(j2);
        }
        j2 = 0;
        return java.lang.String.valueOf(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
    
        if (r2 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String e() {
        java.io.FileInputStream fileInputStream;
        java.io.InputStreamReader inputStreamReader;
        java.lang.String str = "0000000000000000";
        java.io.LineNumberReader lineNumberReader = null;
        try {
            fileInputStream = new java.io.FileInputStream(new java.io.File("/proc/cpuinfo"));
            try {
                inputStreamReader = new java.io.InputStreamReader(fileInputStream);
                try {
                    java.io.LineNumberReader lineNumberReader2 = new java.io.LineNumberReader(inputStreamReader);
                    for (int i = 1; i < 100; i++) {
                        try {
                            java.lang.String readLine = lineNumberReader2.readLine();
                            if (readLine != null) {
                                if (readLine.indexOf("Serial") >= 0) {
                                    str = readLine.substring(readLine.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1, readLine.length()).trim();
                                    break;
                                }
                            }
                        } catch (java.lang.Throwable unused) {
                            lineNumberReader = lineNumberReader2;
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                } catch (java.lang.Throwable unused2) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (java.lang.Throwable unused3) {
                                }
                            }
                        }
                    }
                    try {
                        lineNumberReader2.close();
                    } catch (java.lang.Throwable unused4) {
                    }
                    try {
                        inputStreamReader.close();
                    } catch (java.lang.Throwable unused5) {
                    }
                } catch (java.lang.Throwable unused6) {
                }
            } catch (java.lang.Throwable unused7) {
                inputStreamReader = null;
            }
        } catch (java.lang.Throwable unused8) {
            fileInputStream = null;
            inputStreamReader = null;
        }
        try {
            fileInputStream.close();
        } catch (java.lang.Throwable unused9) {
        }
        return str == null ? "" : str;
    }

    public static java.lang.String e(android.content.Context context) {
        int i = 0;
        try {
            i = android.provider.Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (java.lang.Throwable unused) {
        }
        return i == 1 ? "1" : "0";
    }

    public static java.lang.String f() {
        java.lang.String u = u();
        return !com.alipay.sdk.m.z.a.a(u) ? u : v();
    }

    public static java.lang.String f(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            android.media.AudioManager audioManager = (android.media.AudioManager) context.getSystemService("audio");
            int i = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", java.lang.String.valueOf(i));
            jSONObject.put(androidx.core.app.NotificationCompat.CATEGORY_CALL, java.lang.String.valueOf(streamVolume));
            jSONObject.put("system", java.lang.String.valueOf(streamVolume2));
            jSONObject.put("ring", java.lang.String.valueOf(streamVolume3));
            jSONObject.put(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MUSIC, java.lang.String.valueOf(streamVolume4));
            jSONObject.put(androidx.core.app.NotificationCompat.CATEGORY_ALARM, java.lang.String.valueOf(streamVolume5));
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject.toString();
    }

    public static java.lang.String g() {
        java.io.BufferedReader bufferedReader;
        java.io.FileReader fileReader;
        java.lang.String[] split;
        java.io.FileReader fileReader2 = null;
        try {
            fileReader = new java.io.FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader);
                try {
                    split = bufferedReader.readLine().split(":\\s+", 2);
                } catch (java.lang.Throwable unused) {
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                    if (bufferedReader == null) {
                        return "";
                    }
                    try {
                        bufferedReader.close();
                        return "";
                    } catch (java.lang.Throwable unused3) {
                        return "";
                    }
                }
            } catch (java.lang.Throwable unused4) {
                bufferedReader = null;
            }
        } catch (java.lang.Throwable unused5) {
            bufferedReader = null;
        }
        if (split == null || split.length <= 1) {
            try {
                fileReader.close();
            } catch (java.lang.Throwable unused6) {
            }
            bufferedReader.close();
            return "";
        }
        java.lang.String str = split[1];
        try {
            fileReader.close();
        } catch (java.lang.Throwable unused7) {
        }
        try {
            bufferedReader.close();
        } catch (java.lang.Throwable unused8) {
        }
        return str;
    }

    public static java.lang.String g(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        java.lang.String networkOperatorName;
        if (context != null) {
            try {
                telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            } catch (java.lang.Throwable unused) {
            }
            if (telephonyManager != null) {
                networkOperatorName = telephonyManager.getNetworkOperatorName();
                return (networkOperatorName != null || com.igexin.push.core.b.m.equals(networkOperatorName)) ? "" : networkOperatorName;
            }
        }
        networkOperatorName = null;
        if (networkOperatorName != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        if (r0 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String h() {
        java.io.BufferedReader bufferedReader;
        java.io.FileReader fileReader = null;
        try {
            java.io.FileReader fileReader2 = new java.io.FileReader("/proc/meminfo");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader2, 8192);
                try {
                    r1 = bufferedReader.readLine() != null ? java.lang.Integer.parseInt(r3.split("\\s+")[1]) : 0L;
                    try {
                        fileReader2.close();
                    } catch (java.lang.Throwable unused) {
                    }
                } catch (java.lang.Throwable unused2) {
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (java.lang.Throwable unused3) {
                        }
                    }
                }
            } catch (java.lang.Throwable unused4) {
                bufferedReader = null;
            }
        } catch (java.lang.Throwable unused5) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (java.lang.Throwable unused6) {
        }
        return java.lang.String.valueOf(r1);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0050 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String h(android.content.Context context) {
        android.hardware.SensorManager sensorManager;
        java.util.List<android.hardware.Sensor> sensorList;
        java.lang.String e;
        if (context != null) {
            try {
                sensorManager = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
            } catch (java.lang.Throwable unused) {
            }
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (android.hardware.Sensor sensor : sensorList) {
                    sb.append(sensor.getName());
                    sb.append(sensor.getVersion());
                    sb.append(sensor.getVendor());
                }
                e = com.alipay.sdk.m.z.a.e(sb.toString());
                return e != null ? "" : e;
            }
        }
        e = null;
        if (e != null) {
        }
    }

    public static java.lang.String i() {
        long j2;
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
            j2 = statFs.getBlockCount() * statFs.getBlockSize();
        } catch (java.lang.Throwable unused) {
            j2 = 0;
        }
        return java.lang.String.valueOf(j2);
    }

    public static java.lang.String i(android.content.Context context) {
        java.util.List<android.hardware.Sensor> sensorList;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (context != null) {
            try {
                android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    for (android.hardware.Sensor sensor : sensorList) {
                        if (sensor != null) {
                            org.json.JSONObject jSONObject = new org.json.JSONObject();
                            jSONObject.put("name", sensor.getName());
                            jSONObject.put("version", sensor.getVersion());
                            jSONObject.put("vendor", sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    public static java.lang.String j() {
        long j2;
        if ("mounted".equals(android.os.Environment.getExternalStorageState())) {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
            j2 = statFs.getBlockSize() * statFs.getBlockCount();
            return java.lang.String.valueOf(j2);
        }
        j2 = 0;
        return java.lang.String.valueOf(j2);
    }

    public static java.lang.String j(android.content.Context context) {
        try {
            android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return java.lang.Integer.toString(displayMetrics.widthPixels) + "*" + java.lang.Integer.toString(displayMetrics.heightPixels);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String k() {
        java.lang.String str;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            str = (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static java.lang.String k(android.content.Context context) {
        try {
            android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(displayMetrics.widthPixels);
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String l() {
        java.lang.String str;
        try {
            str = java.util.Locale.getDefault().toString();
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static java.lang.String l(android.content.Context context) {
        try {
            android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(displayMetrics.heightPixels);
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String m() {
        java.lang.String str;
        try {
            str = java.util.TimeZone.getDefault().getDisplayName(false, 0);
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static java.lang.String m(android.content.Context context) {
        java.lang.String str;
        try {
            str = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static java.lang.String n() {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis() - android.os.SystemClock.elapsedRealtime();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String n(android.content.Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            return telephonyManager != null ? java.lang.String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String o() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.os.SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:12:0x001f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String o(android.content.Context r3) {
        /*
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            java.lang.String r0 = ""
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1f
            r2 = 29
            if (r1 < r2) goto Lf
            goto L20
        Lf:
            r2 = 26
            if (r1 < r2) goto L1c
            r1 = 28
            if (r3 < r1) goto L1c
            java.lang.String r3 = defpackage.jp3.a()     // Catch: java.lang.Throwable -> L1f
            goto L21
        L1c:
            java.lang.String r3 = android.os.Build.SERIAL     // Catch: java.lang.Throwable -> L1f
            goto L21
        L1f:
        L20:
            r3 = r0
        L21:
            if (r3 != 0) goto L24
            goto L25
        L24:
            r0 = r3
        L25:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.o(android.content.Context):java.lang.String");
    }

    public static java.lang.String p() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb.append(org.apache.tools.tar.TarConstants.VERSION_POSIX + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            for (int i = 0; i < 7; i++) {
                sb.append(new java.io.File(strArr[i]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String p(android.content.Context context) {
        long j2;
        try {
            if (!((android.app.KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            java.lang.String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
            long j3 = 0;
            for (int i = 0; i < 5; i++) {
                try {
                    j2 = new java.io.File(strArr[i]).lastModified();
                } catch (java.lang.Throwable unused) {
                    j2 = -1;
                }
                j3 = java.lang.Math.max(j2, j3);
            }
            return "1:" + j3;
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    public static java.lang.String q() {
        java.lang.String[] strArr = {"dalvik.system.Taint"};
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(org.apache.tools.tar.TarConstants.VERSION_POSIX);
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        for (int i = 0; i <= 0; i++) {
            try {
                java.lang.Class.forName(strArr[0]);
                sb.append("1");
            } catch (java.lang.Throwable unused) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String q(android.content.Context context) {
        boolean z;
        try {
            android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("status", -1);
            if (intExtra2 != 2 && intExtra2 != 5) {
                z = false;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(!z ? "1" : "0");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(intExtra);
                return sb.toString();
            }
            z = true;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(!z ? "1" : "0");
            sb2.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb2.append(intExtra);
            return sb2.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String r() {
        java.io.LineNumberReader lineNumberReader;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb.append(org.apache.tools.tar.TarConstants.VERSION_POSIX + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        for (java.lang.String str : linkedHashMap.keySet()) {
            char c = '0';
            try {
                lineNumberReader = new java.io.LineNumberReader(new java.io.InputStreamReader(new java.io.FileInputStream(str)));
                while (true) {
                    try {
                        java.lang.String readLine = lineNumberReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.toLowerCase().contains((java.lang.CharSequence) linkedHashMap.get(str))) {
                            c = '1';
                            break;
                        }
                    } catch (java.lang.Throwable unused) {
                        sb.append('0');
                        if (lineNumberReader == null) {
                        }
                        lineNumberReader.close();
                    }
                }
                sb.append(c);
            } catch (java.lang.Throwable unused2) {
                lineNumberReader = null;
            }
            try {
                lineNumberReader.close();
            } catch (java.lang.Throwable unused3) {
            }
        }
        return sb.toString();
    }

    public static java.lang.String r(android.content.Context context) {
        if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return null;
            }
            int subtype = activeNetworkInfo.getSubtype();
            return (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String s() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(org.apache.tools.tar.TarConstants.VERSION_POSIX + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (java.lang.String str : linkedHashMap.keySet()) {
            char c = '0';
            try {
                java.lang.String str2 = (java.lang.String) android.os.Build.class.getField(str).get(null);
                java.lang.String str3 = (java.lang.String) linkedHashMap.get(str);
                java.lang.String lowerCase = str2 != null ? str2.toLowerCase() : null;
                if (lowerCase != null && lowerCase.contains(str3)) {
                    c = '1';
                }
            } catch (java.lang.Throwable unused) {
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static java.lang.String t() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(org.apache.tools.tar.TarConstants.VERSION_POSIX + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (java.lang.String str : linkedHashMap.keySet()) {
            java.lang.String str2 = (java.lang.String) linkedHashMap.get(str);
            java.lang.String b = com.alipay.sdk.m.z.a.b(str, "");
            sb.append((b == null || !b.contains(str2)) ? '0' : '1');
        }
        return sb.toString();
    }

    public static java.lang.String u() {
        java.io.FileReader fileReader;
        java.io.BufferedReader bufferedReader;
        java.lang.String readLine;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            fileReader = new java.io.FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader, 8192);
                try {
                    readLine = bufferedReader.readLine();
                } catch (java.lang.Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                    if (fileReader == null) {
                        return "";
                    }
                    try {
                        fileReader.close();
                        return "";
                    } catch (java.lang.Throwable unused3) {
                        return "";
                    }
                }
            } catch (java.lang.Throwable unused4) {
            }
        } catch (java.lang.Throwable unused5) {
            fileReader = null;
        }
        if (com.alipay.sdk.m.z.a.a(readLine)) {
            try {
                bufferedReader.close();
            } catch (java.lang.Throwable unused6) {
            }
            fileReader.close();
            return "";
        }
        java.lang.String trim = readLine.trim();
        try {
            bufferedReader.close();
        } catch (java.lang.Throwable unused7) {
        }
        try {
            fileReader.close();
        } catch (java.lang.Throwable unused8) {
        }
        return trim;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r1 = r2[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003a, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004d, code lost:
    
        if (r0 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String v() {
        java.io.BufferedReader bufferedReader;
        java.lang.String[] split;
        java.lang.String str = "";
        java.io.FileReader fileReader = null;
        try {
            java.io.FileReader fileReader2 = new java.io.FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader2, 8192);
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!com.alipay.sdk.m.z.a.a(readLine) && (split = readLine.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) != null && split.length > 1 && split[0].contains("BogoMIPS")) {
                                break;
                            }
                        }
                    } catch (java.lang.Throwable unused) {
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable unused3) {
                bufferedReader = null;
            }
        } catch (java.lang.Throwable unused4) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (java.lang.Throwable unused5) {
        }
        return str;
    }

    private java.lang.String w() {
        java.lang.String str;
        if (a(this.e) && (str = this.i) != null) {
            return str;
        }
        this.i = null;
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements() && this.i == null) {
                java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        java.net.InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof java.net.Inet4Address)) {
                            this.i = nextElement.getHostAddress().toString();
                            break;
                        }
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        if (this.i == null) {
            this.i = "";
        }
        this.e = java.lang.System.currentTimeMillis();
        return this.i;
    }

    public final java.lang.String a() {
        try {
            return java.lang.String.valueOf(new java.io.File("/sys/devices/system/cpu/").listFiles(new com.alipay.sdk.m.a0.c(this)).length);
        } catch (java.lang.Throwable unused) {
            return "1";
        }
    }

    public final synchronized java.lang.String a(android.content.Context context) {
        java.lang.String str;
        if (a(this.b) && (str = this.g) != null) {
            return str;
        }
        if (a(context, com.anythink.china.common.d.a)) {
            return "";
        }
        if (context != null) {
            try {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager != null) {
                    this.g = telephonyManager.getDeviceId();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        if (this.g == null) {
            this.g = "";
        }
        this.b = java.lang.System.currentTimeMillis();
        return this.g;
    }

    public final synchronized java.lang.String b(android.content.Context context) {
        java.lang.String str;
        if (a(this.a) && (str = this.f) != null) {
            return str;
        }
        if (a(context, com.anythink.china.common.d.a)) {
            return "";
        }
        if (context != null) {
            try {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager != null) {
                    this.f = telephonyManager.getSubscriberId();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        if (this.f == null) {
            this.f = "";
        }
        this.a = java.lang.System.currentTimeMillis();
        return this.f;
    }

    public final synchronized java.lang.String c(android.content.Context context) {
        java.lang.String str;
        if (a(this.c) && (str = this.h) != null) {
            return str;
        }
        if (a(context, com.anythink.china.common.d.a)) {
            return "";
        }
        try {
            java.lang.String simSerialNumber = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimSerialNumber();
            this.h = simSerialNumber;
            if (simSerialNumber == null || simSerialNumber.length() == 0) {
                this.h = "";
            }
        } catch (java.lang.Throwable unused) {
        }
        this.c = java.lang.System.currentTimeMillis();
        return this.h;
    }

    public final java.lang.String d(android.content.Context context) {
        try {
            java.lang.String r = r(context);
            java.lang.String w = w();
            if (com.alipay.sdk.m.z.a.b(r) && com.alipay.sdk.m.z.a.b(w)) {
                return r + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + w();
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }
}
