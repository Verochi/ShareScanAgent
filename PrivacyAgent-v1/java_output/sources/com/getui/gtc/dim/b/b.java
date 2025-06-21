package com.getui.gtc.dim.b;

/* loaded from: classes22.dex */
public final class b {
    private static final com.getui.gtc.dim.b.b i = new com.getui.gtc.dim.b.b();
    private long j = 0;
    long a = 10;
    long b = -1;
    long c = com.anythink.expressad.d.a.b.P;
    long d = -1;
    long e = -1;
    private long l = -1;
    boolean f = false;
    boolean g = false;
    boolean h = true;
    private boolean m = true;
    private final java.util.Map<java.lang.String, com.getui.gtc.dim.b.b.a> k = new java.util.HashMap(4);

    public static class a {
        public java.lang.String a;
        public long b;
        public java.lang.String c;
        public java.lang.String d;
        public int e;
        public int f;
        public int g;
        public int h;

        public final java.lang.String toString() {
            return "Config{key='" + this.a + "', sdkTotalRuntimeCondition=" + this.b + ", timeRangeStart='" + this.c + "', timeRangeEnd='" + this.d + "', timeRangeState=" + this.e + ", weekState=" + this.f + ", sdkAccessCountCondition=" + this.g + ", installDurationDayCondition=" + this.h + '}';
        }
    }

    /* renamed from: com.getui.gtc.dim.b.b$b, reason: collision with other inner class name */
    public static class C0299b {
        public static java.util.Calendar a(long j, java.lang.String str) {
            java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            int parseInt = java.lang.Integer.parseInt(split[0]);
            int parseInt2 = java.lang.Integer.parseInt(split[1]);
            int parseInt3 = java.lang.Integer.parseInt(split[2]);
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(j);
            calendar.set(11, parseInt);
            calendar.set(12, parseInt2);
            calendar.set(13, parseInt3);
            calendar.set(14, 0);
            return calendar;
        }

        public static boolean a(long j) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(j);
            int i = calendar.get(7);
            return i == 1 || i == 7;
        }
    }

    private b() {
    }

    public static com.getui.gtc.dim.b.b a() {
        return i;
    }

    private static boolean a(android.content.Context context) {
        try {
            if (!com.getui.gtc.base.util.CommonUtil.isAppForeground()) {
                android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
                return registerReceiver == null || registerReceiver.getExtras() == null || registerReceiver.getExtras().getInt("plugged") == 2;
            }
            boolean z = android.provider.Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
            android.content.Intent registerReceiver2 = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver2 != null && registerReceiver2.getExtras() != null) {
                return z && registerReceiver2.getExtras().getInt("plugged") == 2;
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0094 A[Catch: all -> 0x000f, TryCatch #0 {all -> 0x000f, blocks: (B:46:0x0003, B:48:0x0009, B:4:0x0014, B:6:0x001e, B:10:0x0026, B:12:0x002c, B:14:0x0032, B:16:0x003d, B:18:0x0045, B:20:0x004d, B:23:0x0056, B:25:0x0060, B:27:0x0068, B:30:0x0071, B:33:0x007c, B:35:0x0086, B:40:0x0094, B:42:0x009a), top: B:45:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: all -> 0x000f, TRY_LEAVE, TryCatch #0 {all -> 0x000f, blocks: (B:46:0x0003, B:48:0x0009, B:4:0x0014, B:6:0x001e, B:10:0x0026, B:12:0x002c, B:14:0x0032, B:16:0x003d, B:18:0x0045, B:20:0x004d, B:23:0x0056, B:25:0x0060, B:27:0x0068, B:30:0x0071, B:33:0x007c, B:35:0x0086, B:40:0x0094, B:42:0x009a), top: B:45:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(boolean z, boolean z2) {
        boolean z3;
        if (z) {
            try {
                if (com.getui.gtc.base.util.CommonUtil.isAppDebugEnable()) {
                    com.getui.gtc.dim.e.b.b("check safe f: debuggable");
                    return false;
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.dim.e.b.b(th);
                return false;
            }
        }
        if (z && a(com.getui.gtc.base.GtcProvider.context())) {
            com.getui.gtc.dim.e.b.b("check safe f: u-model");
            return false;
        }
        if (z2 && c()) {
            com.getui.gtc.dim.e.b.b("check safe f: xp");
            return false;
        }
        java.lang.String str = android.os.Build.FINGERPRINT;
        if (!str.contains("generic") && !str.contains("unknown") && !str.contains("generic_x86") && !str.contains("vbox")) {
            java.lang.String str2 = android.os.Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !android.os.Build.MANUFACTURER.contains("Genymotion")) {
                java.lang.String str3 = android.os.Build.HARDWARE;
                if (!"goldfish".equals(str3) && !"ranchu".equals(str3)) {
                    z3 = false;
                    if (z3) {
                        com.getui.gtc.dim.e.b.a("check safe s");
                        return true;
                    }
                    com.getui.gtc.dim.e.b.b("check safe f: emulator");
                    return false;
                }
            }
        }
        z3 = true;
        if (z3) {
        }
    }

    private long b() {
        long j;
        synchronized (this) {
            if (this.l < 0) {
                this.l = b("dim-key-sdk-sync-install-time");
            }
            j = this.l;
        }
        return j;
    }

    public static long b(java.lang.String str) {
        try {
            com.getui.gtc.dim.b.d unused = com.getui.gtc.dim.b.d.a.a;
            com.getui.gtc.dim.b.h a2 = com.getui.gtc.dim.b.d.a(str);
            java.lang.Object obj = a2 != null ? a2.a : null;
            r0 = obj instanceof java.lang.String ? java.lang.Long.parseLong((java.lang.String) obj) : -1L;
            com.getui.gtc.dim.e.b.a("dim sys get " + str + " from db: " + r0);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
        }
        if (r0 < 0) {
            return 0L;
        }
        return r0;
    }

    private static boolean c() {
        if (e(f("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=")) || e(f("Y29tLnNhdXJpay5zdWJzdHJhdGU="))) {
            return true;
        }
        try {
            java.lang.ClassLoader.getSystemClassLoader().loadClass(f("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5YcG9zZWRIZWxwZXJz"));
            return true;
        } catch (java.lang.Exception e) {
            java.lang.String f = f("ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5YcG9zZWRCcmlkZ2U=");
            java.lang.String f2 = f("bWFpbg==");
            java.lang.String f3 = f("aGFuZGxlSG9va2VkTWV0aG9k");
            for (java.lang.StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals(f) && (stackTraceElement.getMethodName().equals(f2) || stackTraceElement.getMethodName().equals(f3))) {
                    return true;
                }
            }
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.Writer) stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            if (stringWriter.toString().contains(f("eHBvc2Vk"))) {
                return true;
            }
            try {
                java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet();
                java.io.FileReader fileReader = new java.io.FileReader("/proc/" + android.os.Process.myPid() + "/maps");
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                            hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                        }
                    } catch (java.lang.Throwable th) {
                        try {
                            com.getui.gtc.dim.e.b.b(th);
                            fileReader.close();
                            bufferedReader.close();
                            return false;
                        } finally {
                            fileReader.close();
                            bufferedReader.close();
                        }
                    }
                }
                java.lang.String f4 = f("Y29tLnNhdXJpay5zdWJzdHJhdGU=");
                java.lang.String f5 = f("WHBvc2VkQnJpZGdlLmphcg==");
                for (java.lang.String str : hashSet) {
                    if (str.contains(f4)) {
                        return true;
                    }
                    if (str.contains(f5)) {
                        return true;
                    }
                }
                fileReader.close();
                bufferedReader.close();
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.dim.e.b.b(th2);
                return false;
            }
            return false;
        }
    }

    public static java.util.List<com.getui.gtc.dim.b.b.a> d(java.lang.String str) {
        java.lang.String[] strArr;
        int i2;
        java.lang.String str2;
        long parseLong;
        java.lang.String str3;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.String[] split = str.split(",");
            int length = split.length;
            char c = 0;
            int i3 = 0;
            while (i3 < length) {
                java.lang.String str4 = split[i3];
                if (!android.text.TextUtils.isEmpty(str4)) {
                    java.lang.String[] split2 = str4.split("\\|");
                    if (split2.length == 6) {
                        try {
                            str2 = split2[c];
                            parseLong = java.lang.Long.parseLong(split2[1]);
                            str3 = split2[2];
                        } catch (java.lang.Throwable th) {
                            th = th;
                            strArr = split;
                            i2 = length;
                        }
                        if (java.util.regex.Pattern.compile("^\\d{2}:\\d{2}:\\d{2}-\\d{2}:\\d{2}:\\d{2}#[0-3]$").matcher(str3).matches()) {
                            java.lang.String[] split3 = str3.split("#");
                            java.lang.String[] split4 = split3[c].split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            java.lang.String str5 = split4[c];
                            java.lang.String str6 = split4[1];
                            int parseInt = java.lang.Integer.parseInt(split3[1]);
                            int parseInt2 = java.lang.Integer.parseInt(split2[3]);
                            int parseInt3 = java.lang.Integer.parseInt(split2[4]);
                            int parseInt4 = java.lang.Integer.parseInt(split2[5]);
                            long j = parseInt3;
                            com.getui.gtc.dim.b.b bVar = i;
                            strArr = split;
                            i2 = length;
                            try {
                                if (j > bVar.a) {
                                    bVar.a = j;
                                }
                                if (parseLong > bVar.c) {
                                    bVar.c = parseLong;
                                }
                                com.getui.gtc.dim.b.b.a aVar = new com.getui.gtc.dim.b.b.a();
                                aVar.a = str2;
                                aVar.b = parseLong;
                                aVar.c = str5;
                                aVar.d = str6;
                                aVar.e = parseInt;
                                aVar.f = parseInt2;
                                aVar.g = parseInt3;
                                aVar.h = parseInt4;
                                arrayList.add(aVar);
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                com.getui.gtc.dim.e.b.b(th);
                                i3++;
                                split = strArr;
                                length = i2;
                                c = 0;
                            }
                            i3++;
                            split = strArr;
                            length = i2;
                            c = 0;
                        }
                    }
                }
                strArr = split;
                i2 = length;
                i3++;
                split = strArr;
                length = i2;
                c = 0;
            }
        } catch (java.lang.Throwable th3) {
            com.getui.gtc.dim.e.b.b(th3);
        }
        return arrayList;
    }

    private static boolean e(java.lang.String str) {
        try {
            com.getui.gtc.dim.e.d.a(str, 0);
            com.getui.gtc.dim.e.b.a("specific " + str + " p info hit success");
            return true;
        } catch (java.lang.Throwable unused) {
            com.getui.gtc.dim.e.b.a("specific " + str + " p info hit failed");
            return false;
        }
    }

    private static java.lang.String f(java.lang.String str) {
        return new java.lang.String(android.util.Base64.decode(str, 0));
    }

    public final void a(long j) {
        if (this.m) {
            this.j = j;
            synchronized (this) {
                if (b() == 0) {
                    try {
                        this.l = java.lang.System.currentTimeMillis() + j;
                        com.getui.gtc.dim.b.d unused = com.getui.gtc.dim.b.d.a.a;
                        com.getui.gtc.dim.b.d.a("dim-key-sdk-sync-install-time", (java.lang.Object) java.lang.String.valueOf(this.l));
                        com.getui.gtc.dim.e.b.a("dim sys server install time set: " + this.l);
                    } catch (java.lang.Throwable th) {
                        com.getui.gtc.dim.e.b.b(th);
                    }
                }
            }
        }
        com.getui.gtc.dim.e.b.a("dim sys syncTime set: " + j + ", syncTime: " + this.m);
    }

    public final void a(java.lang.String str) {
        try {
            for (java.lang.String str2 : str.split(",")) {
                java.lang.String[] split = str2.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                java.lang.String str3 = split[0];
                boolean z = true;
                if (java.lang.Integer.parseInt(split[1]) != 1) {
                    z = false;
                }
                if ("dim".equals(str3)) {
                    this.f = z;
                } else if ("xp".equals(str3)) {
                    this.g = z;
                } else if (com.umeng.analytics.pro.f.ac.equals(str3)) {
                    this.h = z;
                } else if ("st".equals(str3)) {
                    this.m = z;
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
        }
        com.getui.gtc.dim.e.b.a("dim sys globalHC policy set: ".concat(java.lang.String.valueOf(str)));
    }

    public final void a(java.lang.String str, com.getui.gtc.dim.b.b.a aVar) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.k.put(str, aVar);
        com.getui.gtc.dim.e.b.a("dim sys globalHC set: " + str + " : " + aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        if (r10.before(r9) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(java.lang.String str) {
        boolean z;
        try {
            com.getui.gtc.dim.b.b.a aVar = this.k.get(str);
            if (aVar == null) {
                aVar = this.k.get("dim-2-2-0-1");
            }
            if (aVar == null) {
                com.getui.gtc.dim.e.b.a("check filed condition : " + str + " , config is null");
                return false;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis() + this.j;
            long j = aVar.b;
            if (j > 0 && this.d < j * 1000) {
                com.getui.gtc.dim.e.b.a("check filed condition : " + str + " , 1 not passed, " + this.d);
                return false;
            }
            if (aVar.e == 1) {
                java.lang.String str2 = aVar.c;
                java.lang.String str3 = aVar.d;
                java.util.Calendar a2 = com.getui.gtc.dim.b.b.C0299b.a(currentTimeMillis, str2);
                java.util.Calendar a3 = com.getui.gtc.dim.b.b.C0299b.a(currentTimeMillis, str3);
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTimeInMillis(currentTimeMillis);
                if (a3.before(a2)) {
                    if (!calendar.after(a2)) {
                    }
                } else {
                    z = calendar.after(a2) && calendar.before(a3);
                }
                if (z) {
                    int i2 = aVar.f;
                    if (i2 > 0 && i2 <= 3 && ((i2 != 1 || !com.getui.gtc.dim.b.b.C0299b.a(currentTimeMillis)) && (aVar.f != 2 || com.getui.gtc.dim.b.b.C0299b.a(currentTimeMillis)))) {
                        int i3 = aVar.g;
                        if (i3 > 0 && this.b < i3) {
                            com.getui.gtc.dim.e.b.a("check filed condition : " + str + " , 4 not passed, " + this.b);
                            return false;
                        }
                        long b = b();
                        if (b == 0) {
                            b = com.getui.gtc.dim.e.d.a(com.getui.gtc.base.GtcProvider.context().getPackageName(), 0).firstInstallTime;
                        }
                        if (aVar.h <= 0 || currentTimeMillis - b >= r2 * 86400000) {
                            com.getui.gtc.dim.e.b.a("check filed condition : " + str + " , passed");
                            return true;
                        }
                        com.getui.gtc.dim.e.b.a("check filed condition : " + str + " , 5 not passed, " + b);
                        return false;
                    }
                    com.getui.gtc.dim.e.b.a("check filed condition : " + str + " , 3 not passed");
                    return false;
                }
            }
            com.getui.gtc.dim.e.b.a("check filed condition : " + str + " , 2 not passed");
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a("check filed condition : " + str + " , catch exception, not passed", th);
            return false;
        }
    }
}
