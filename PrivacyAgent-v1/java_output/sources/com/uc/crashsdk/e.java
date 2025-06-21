package com.uc.crashsdk;

/* loaded from: classes19.dex */
public class e implements java.lang.Thread.UncaughtExceptionHandler {
    static final /* synthetic */ boolean a = true;
    private static long b;
    private static java.lang.String i;
    private final java.util.List<java.io.FileInputStream> e = new java.util.ArrayList();
    private static final java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static boolean d = false;
    private static long f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static java.lang.String j = "";
    private static java.lang.String k = null;
    private static java.lang.String l = null;
    private static java.lang.String m = null;
    private static final java.lang.Object n = new java.lang.Object();
    private static final android.os.ConditionVariable o = new android.os.ConditionVariable();
    private static final java.lang.Object p = new java.lang.Object();
    private static final java.lang.Object q = new java.lang.Object();
    private static final java.lang.Object r = new java.lang.Object();

    /* renamed from: s, reason: collision with root package name */
    private static final java.util.ArrayList<java.lang.String> f441s = new java.util.ArrayList<>();
    private static int t = 0;
    private static java.lang.String u = null;
    private static boolean v = false;
    private static java.lang.String w = null;
    private static java.lang.String x = null;
    private static final java.lang.Object y = new java.lang.Object();
    private static final java.lang.Object z = new java.lang.Object();
    private static java.util.Map<java.lang.String, java.lang.Integer> A = null;
    private static java.lang.String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static java.lang.String J = "?";
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static com.uc.crashsdk.e.c Q = new com.uc.crashsdk.e.c((byte) 0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_URL_CODE);
    private static java.lang.Thread.UncaughtExceptionHandler T = null;
    private static java.lang.Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static java.lang.Runnable X = null;
    private static final java.lang.Object Y = new java.lang.Object();
    private static int Z = 101;
    private static java.lang.Runnable aa = new com.uc.crashsdk.a.e(407);
    private static final java.lang.Object ab = new java.lang.Object();
    private static volatile boolean ac = false;
    private static java.lang.Object ad = new java.lang.Object();
    private static android.os.ParcelFileDescriptor ae = null;
    private static boolean af = false;
    private static boolean ag = false;

    public static class a extends java.io.OutputStream {
        private final long a;
        private final java.io.OutputStream b;
        private int c = 0;
        private int d = 0;
        private boolean e = false;

        public a(long j, java.io.OutputStream outputStream) {
            this.a = j;
            this.b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int a(byte[] bArr, int i, int i2) {
            int i3;
            this.d += i2;
            if (this.e) {
                return 0;
            }
            int B = com.uc.crashsdk.g.B();
            if (B > 0) {
                int i4 = this.c;
                if (i4 + i2 > B) {
                    i3 = B - i4;
                    this.c += i3;
                    if (this.a == 0) {
                        b(new java.lang.String(bArr, i, i3));
                    } else {
                        this.b.write(bArr, i, i3);
                    }
                    if (i3 < i2) {
                        this.e = true;
                    }
                    return i3;
                }
            }
            i3 = i2;
            this.c += i3;
            if (this.a == 0) {
            }
            if (i3 < i2) {
            }
            return i3;
        }

        private void b(java.lang.String str) {
            if (com.uc.crashsdk.b.d) {
                com.uc.crashsdk.JNIBridge.nativeClientWriteData(this.a, str);
            }
        }

        public final void a() {
            try {
                if (this.d - this.c > 0) {
                    a("\n");
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(java.lang.String.format(java.util.Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", java.lang.Integer.valueOf(this.d), java.lang.Integer.valueOf(this.c), java.lang.Integer.valueOf(com.uc.crashsdk.g.B()), java.lang.Integer.valueOf(this.d - this.c)));
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        public final void a(java.lang.String str) {
            if (com.uc.crashsdk.e.h && com.uc.crashsdk.e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            if (com.uc.crashsdk.e.h && com.uc.crashsdk.e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", java.lang.String.format(java.util.Locale.US, "%c", java.lang.Integer.valueOf(i)));
            }
            if (this.a != 0) {
                b(java.lang.String.format(java.util.Locale.US, "%c", java.lang.Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            if (com.uc.crashsdk.e.h && com.uc.crashsdk.e.O() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new java.lang.String(bArr));
                } catch (java.lang.Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            if (com.uc.crashsdk.e.h && com.uc.crashsdk.e.O()) {
                byte[] bArr2 = new byte[i2];
                java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new java.lang.String(bArr2));
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }
    }

    public static class b implements java.util.Comparator<java.io.File> {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(java.io.File file, java.io.File file2) {
            java.io.File file3 = file;
            java.io.File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }
    }

    public static class c extends android.content.BroadcastReceiver {
        private c() {
        }

        public /* synthetic */ c(byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            java.lang.String action = intent.getAction();
            if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
                if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                    boolean unused = com.uc.crashsdk.e.K = "android.intent.action.BATTERY_LOW".equals(action);
                    com.uc.crashsdk.e.K();
                    return;
                } else {
                    if ("android.intent.action.ANR".equals(action)) {
                        try {
                            com.uc.crashsdk.e.d(context);
                            return;
                        } catch (java.lang.Throwable th) {
                            com.uc.crashsdk.a.g.a(th);
                            return;
                        }
                    }
                    return;
                }
            }
            int unused2 = com.uc.crashsdk.e.C = intent.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, -1);
            int unused3 = com.uc.crashsdk.e.D = intent.getIntExtra("scale", -1);
            int unused4 = com.uc.crashsdk.e.E = intent.getIntExtra("voltage", -1);
            int unused5 = com.uc.crashsdk.e.F = intent.getIntExtra("health", -1);
            int unused6 = com.uc.crashsdk.e.G = intent.getIntExtra("plugged", -1);
            int unused7 = com.uc.crashsdk.e.H = intent.getIntExtra("status", -1);
            int unused8 = com.uc.crashsdk.e.I = intent.getIntExtra("temperature", -1);
            java.lang.String unused9 = com.uc.crashsdk.e.J = intent.getStringExtra("technology");
            if (com.uc.crashsdk.e.J() >= 2) {
                com.uc.crashsdk.e.K();
                com.uc.crashsdk.e.L();
            }
        }
    }

    public static class d {
        long a;
        long b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private d() {
            this.a = 0L;
            this.b = 0L;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    public e() {
        try {
            M();
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void A() {
        if (com.uc.crashsdk.g.r()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), 10000L);
        }
    }

    public static void B() {
        if (ac || com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(com.bytedance.sdk.openadsdk.TTAdConstant.INTERACTION_TYPE_CODE), 1000L);
    }

    public static void C() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_LIST_CODE), 7000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003b, code lost:
    
        if ((java.lang.System.currentTimeMillis() % 3) == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        if (r0 == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        r4 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void D() {
        int O2 = com.uc.crashsdk.g.O();
        boolean z2 = false;
        boolean z3 = true;
        if (O2 == 0 || O2 == 3 || O2 == 4) {
            if (android.os.Build.VERSION.SDK_INT <= 25) {
                boolean z4 = O2 != 0;
                if (O2 == 3) {
                    z4 = java.lang.System.currentTimeMillis() % 10 == 0;
                }
                if (O2 != 4) {
                    z3 = z4;
                }
            }
        }
        if (!z3) {
            com.uc.crashsdk.a.a.a("crashsdk", "SIG 3 is disabled by settings");
        }
        boolean L2 = com.uc.crashsdk.b.L();
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper() || !z3) {
            z2 = z3;
        } else {
            com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_INFO_CODE));
        }
        com.uc.crashsdk.JNIBridge.nativeCmd(7, L2 ? 1L : 0L, null, null);
        if (z2) {
            com.uc.crashsdk.JNIBridge.cmd(8);
        }
    }

    public static android.os.ParcelFileDescriptor E() {
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (ad) {
            android.os.ParcelFileDescriptor parcelFileDescriptor = ae;
            if (parcelFileDescriptor != null) {
                return parcelFileDescriptor;
            }
            int cmd = (int) com.uc.crashsdk.JNIBridge.cmd(14);
            if (cmd == -1) {
                return null;
            }
            android.os.ParcelFileDescriptor adoptFd = android.os.ParcelFileDescriptor.adoptFd(cmd);
            ae = adoptFd;
            af = true;
            return adoptFd;
        }
    }

    public static boolean F() {
        return ag;
    }

    public static void G() {
        java.lang.String Y2 = com.uc.crashsdk.g.Y();
        java.io.File file = new java.io.File(Y2);
        if (file.exists() && file.isDirectory()) {
            java.io.File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + Y2);
                return;
            }
            for (java.io.File file2 : listFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ int J() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    public static /* synthetic */ void K() {
        java.lang.StringBuilder Y2;
        if (com.uc.crashsdk.b.d && (Y2 = Y()) != null) {
            com.uc.crashsdk.JNIBridge.set(125, Y2.toString());
        }
        L = true;
        Z();
    }

    public static /* synthetic */ int L() {
        M = 0;
        return 0;
    }

    private void M() {
        int J2 = com.uc.crashsdk.g.J();
        for (int i2 = 0; i2 < J2; i2++) {
            try {
                this.e.add(new java.io.FileInputStream("/dev/null"));
            } catch (java.lang.Exception e) {
                com.uc.crashsdk.a.g.a(e);
                return;
            }
        }
    }

    private void N() {
        java.util.Iterator<java.io.FileInputStream> it = this.e.iterator();
        while (it.hasNext()) {
            com.uc.crashsdk.a.g.a(it.next());
        }
        this.e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O() {
        if (com.uc.crashsdk.g.Q()) {
            return true;
        }
        return a();
    }

    private static java.lang.String P() {
        return com.uc.crashsdk.g.e() + "_";
    }

    private static java.lang.String Q() {
        return com.uc.crashsdk.b.B() ? "fg" : "bg";
    }

    private static byte[] R() {
        byte[] bArr = null;
        int i2 = 1024;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (java.lang.Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static java.lang.String S() {
        return (!com.uc.crashsdk.b.F() || d) ? com.uc.crashsdk.export.LogType.JAVA_TYPE : "ucebujava";
    }

    private static void T() {
        java.lang.String str;
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.io.FileReader fileReader;
        java.lang.String str2 = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        try {
            str = android.os.Build.HARDWARE;
        } catch (java.lang.Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            str = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        try {
            fileReader = new java.io.FileReader(new java.io.File("/proc/cpuinfo"));
            try {
                bufferedReader = new java.io.BufferedReader(fileReader, 512);
                int i2 = 0;
                do {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1).trim();
                        } else if (readLine.startsWith("Processor")) {
                            str2 = readLine.substring(readLine.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1).trim();
                        }
                        i2++;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            k = str;
                            l = str2;
                        } catch (java.lang.Throwable th4) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (java.lang.Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (java.lang.Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        k = str;
        l = str2;
    }

    private static java.lang.String U() {
        return com.uc.crashsdk.g.X() + "bytes";
    }

    private static boolean V() {
        return android.os.Build.VERSION.SDK_INT < 29;
    }

    private static void W() {
        if (O || com.uc.crashsdk.b.F() || com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.JNIBridge.cmd(18);
    }

    private static void X() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_URL_CODE), 1000L);
    }

    private static java.lang.StringBuilder Y() {
        java.lang.String str;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append("\n");
            sb.append("scale: ");
            sb.append(D);
            sb.append("\n");
            switch (F) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append("\n");
            int i2 = G;
            java.lang.String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append("\n");
            int i3 = H;
            java.lang.String str3 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append("\n");
            sb.append("voltage: ");
            sb.append(E);
            sb.append("\n");
            sb.append("temperature: ");
            sb.append(I);
            sb.append("\n");
            sb.append("technology: ");
            sb.append(J);
            sb.append("\n");
            sb.append("battery low: ");
            sb.append(K);
            sb.append("\n");
            return sb;
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Z() {
        if (com.uc.crashsdk.b.c && L && com.uc.crashsdk.a.c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, 2000L);
        }
    }

    public static int a(java.io.OutputStream outputStream, java.lang.String str, int i2) {
        int i3 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            java.lang.String a2 = com.uc.crashsdk.a.b.a(str);
            if (a2 == null) {
                a2 = "file: '" + str + "' not found or decode failed!";
            }
            int length = a2.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(a2.getBytes("UTF-8"), 0, i2);
                    outputStream.write("\n".getBytes("UTF-8"));
                } catch (java.lang.Throwable th) {
                    th = th;
                    i3 = i2;
                    a(th, outputStream);
                    i2 = i3;
                    a(outputStream);
                    return i2;
                }
            }
            if (i2 < a2.length()) {
                outputStream.write(java.lang.String.format(java.util.Locale.US, "(truncated %d bytes)\n", java.lang.Integer.valueOf(a2.length() - i2)).getBytes("UTF-8"));
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i2;
    }

    private static long a(android.os.StatFs statFs, java.lang.String str, java.lang.String str2) {
        try {
            java.lang.reflect.Method declaredMethod = android.os.StatFs.class.getDeclaredMethod(str, new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            java.lang.Object invoke = declaredMethod.invoke(statFs, new java.lang.Object[0]);
            if (invoke != null && (invoke instanceof java.lang.Long)) {
                return ((java.lang.Long) invoke).longValue();
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.reflect.Method declaredMethod2 = android.os.StatFs.class.getDeclaredMethod(str2, new java.lang.Class[0]);
            declaredMethod2.setAccessible(true);
            java.lang.Object invoke2 = declaredMethod2.invoke(statFs, new java.lang.Object[0]);
            if (invoke2 == null || !(invoke2 instanceof java.lang.Integer)) {
                return 0L;
            }
            return ((java.lang.Integer) invoke2).intValue();
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    private static java.io.BufferedReader a(java.io.InputStreamReader inputStreamReader) {
        java.io.BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new java.io.BufferedReader(inputStreamReader, i2);
            } catch (java.lang.Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    public static java.lang.String a(int i2) {
        try {
            java.lang.String a2 = com.uc.crashsdk.a.g.a(new java.io.File(java.lang.String.format(java.util.Locale.US, "/proc/%d/cmdline", java.lang.Integer.valueOf(i2))), 128, false);
            return com.uc.crashsdk.a.g.b(a2) ? l(a2) : "unknown";
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    private static java.lang.String a(java.io.File file) {
        java.lang.String str;
        try {
            str = file.getCanonicalPath();
        } catch (java.lang.Throwable unused) {
            str = null;
        }
        return com.uc.crashsdk.a.g.a(str) ? file.getPath() : str;
    }

    public static java.lang.String a(java.lang.String str) {
        int lastIndexOf;
        int indexOf;
        int i2;
        int indexOf2;
        java.io.File file;
        byte[] e;
        byte[] bArr;
        if (!com.uc.crashsdk.g.y() || (lastIndexOf = str.lastIndexOf(47)) <= 0 || (indexOf = str.indexOf(95, lastIndexOf)) <= lastIndexOf || (indexOf2 = str.indexOf(95, (i2 = indexOf + 1))) <= indexOf) {
            return str;
        }
        java.lang.String d2 = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(lastIndexOf + 1, indexOf) + str.substring(i2, indexOf2));
        if (d2 == null || (e = com.uc.crashsdk.a.g.e((file = new java.io.File(str)))) == null || e.length <= 0) {
            return str;
        }
        try {
            bArr = com.uc.crashsdk.a.c.b(e, d2.substring(0, 16).getBytes());
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            bArr = null;
        }
        if (bArr == null) {
            return str;
        }
        java.lang.String str2 = str + ".ec";
        java.io.File file2 = new java.io.File(str2 + com.baidu.mobads.sdk.internal.al.k);
        if (!com.uc.crashsdk.a.g.a(file2, bArr)) {
            return str;
        }
        if (file2.renameTo(new java.io.File(str2))) {
            file.delete();
            return str2;
        }
        file2.delete();
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
    
        r3.write(r4.getBytes("UTF-8"));
        r3.write("\n".getBytes("UTF-8"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec(android.os.Build.VERSION.SDK_INT >= 26 ? new java.lang.String[]{com.aliyun.vod.log.struct.AliyunLogKey.KEY_PART_SIZE, "-ef"} : new java.lang.String[]{com.aliyun.vod.log.struct.AliyunLogKey.KEY_PART_SIZE}).getInputStream()));
            boolean b2 = com.uc.crashsdk.a.g.b(str);
            boolean b3 = com.uc.crashsdk.a.g.b(str2);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                boolean z2 = true;
                if ((!b2 || !readLine.contains(str)) && ((!b3 || !readLine.contains(str2)) && (readLine.indexOf(47) >= 0 || readLine.indexOf(46) <= 0))) {
                    z2 = false;
                }
            }
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "exception exists.";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(37:0|1|(59:2|3|4|(2:332|333)|6|(2:8|9)(1:331)|10|11|12|13|(1:15)|17|(2:19|20)|25|26|27|28|29|30|(1:32)|34|(1:38)|40|41|43|44|45|46|47|49|50|(2:295|296)|52|53|54|55|56|57|59|60|61|62|63|64|(4:66|67|68|69)|73|74|75|76|77|79|80|81|82|(1:84)(2:268|(1:270))|85|86|87|88)|(4:90|91|92|93)(3:210|211|(8:218|219|220|221|222|223|224|(42:226|227|228|229|230|231|232|233|234|235|236|237|96|97|98|99|(3:101|102|103)(7:171|172|(1:174)|175|(1:177)|178|(4:180|(1:182)(1:186)|183|184))|104|105|106|107|108|(4:110|111|112|113)|117|118|119|120|121|122|(4:124|125|126|127)|131|132|133|(1:135)|136|137|(1:139)|140|141|(1:143)(1:148)|144|145)(32:257|95|96|97|98|99|(0)(0)|104|105|106|107|108|(0)|117|118|119|120|121|122|(0)|131|132|133|(0)|136|137|(0)|140|141|(0)(0)|144|145)))|94|95|96|97|98|99|(0)(0)|104|105|106|107|108|(0)|117|118|119|120|121|122|(0)|131|132|133|(0)|136|137|(0)|140|141|(0)(0)|144|145|(2:(0)|(1:155))) */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x04cc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x04cd, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0480, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0482, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0455, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0457, code lost:
    
        a(r0, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x044b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x044d, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0426, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0428, code lost:
    
        a(r0, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0357, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0358, code lost:
    
        a(r0, r15);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x042f A[Catch: all -> 0x048e, TRY_LEAVE, TryCatch #31 {all -> 0x048e, blocks: (B:96:0x034a, B:99:0x035b, B:104:0x0416, B:108:0x042b, B:110:0x042f, B:113:0x0444, B:116:0x0441, B:122:0x045a, B:124:0x045e, B:127:0x0473, B:130:0x0470, B:131:0x0476, B:154:0x0482, B:159:0x0457, B:163:0x044d, B:167:0x0428, B:170:0x0375, B:190:0x0358, B:245:0x0347, B:107:0x0422, B:126:0x0461, B:133:0x047c, B:112:0x0432, B:118:0x0447, B:121:0x0451, B:98:0x034d), top: B:244:0x0347, inners: #5, #10, #23, #24, #28, #39, #41 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x045e A[Catch: all -> 0x048e, TRY_LEAVE, TryCatch #31 {all -> 0x048e, blocks: (B:96:0x034a, B:99:0x035b, B:104:0x0416, B:108:0x042b, B:110:0x042f, B:113:0x0444, B:116:0x0441, B:122:0x045a, B:124:0x045e, B:127:0x0473, B:130:0x0470, B:131:0x0476, B:154:0x0482, B:159:0x0457, B:163:0x044d, B:167:0x0428, B:170:0x0375, B:190:0x0358, B:245:0x0347, B:107:0x0422, B:126:0x0461, B:133:0x047c, B:112:0x0432, B:118:0x0447, B:121:0x0451, B:98:0x034d), top: B:244:0x0347, inners: #5, #10, #23, #24, #28, #39, #41 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04bb A[Catch: all -> 0x04cc, TryCatch #29 {all -> 0x04cc, blocks: (B:141:0x04b7, B:143:0x04bb, B:144:0x04c6), top: B:140:0x04b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x037a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String a(java.lang.Throwable th, java.lang.String str, long j2, boolean z2) {
        java.io.FileOutputStream fileOutputStream;
        int i2;
        java.io.FileOutputStream fileOutputStream2;
        com.uc.crashsdk.e.a aVar;
        java.lang.String str2;
        int i3;
        java.lang.String str3;
        java.util.HashSet hashSet;
        java.lang.String a2;
        android.os.StatFs statFs;
        long a3;
        long a4;
        com.uc.crashsdk.e.a aVar2 = null;
        try {
            if (!com.uc.crashsdk.b.L()) {
                try {
                    com.uc.crashsdk.g.a();
                    a(true);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    try {
                        a(th, aVar2);
                        if (j2 != 0) {
                        }
                        com.uc.crashsdk.a.g.a(aVar2);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        if (!ag) {
                        }
                        b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                        return str;
                    } catch (java.lang.Throwable th3) {
                        if (j2 != 0) {
                            b(aVar2);
                        }
                        com.uc.crashsdk.a.g.a(aVar2);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        throw th3;
                    }
                }
            }
            i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            fileOutputStream2 = i2 == 0 ? new java.io.FileOutputStream(str) : null;
            try {
                aVar = new com.uc.crashsdk.e.a(j2, fileOutputStream2);
                try {
                    try {
                        if (com.uc.crashsdk.b.d) {
                            com.uc.crashsdk.JNIBridge.set(126, str);
                        }
                    } catch (java.lang.Throwable th4) {
                        com.uc.crashsdk.a.g.a(th4);
                    }
                    b(aVar, str, S());
                    if (z2) {
                        try {
                            aVar.flush();
                        } catch (java.lang.Throwable th5) {
                            com.uc.crashsdk.a.g.a(th5);
                        }
                    }
                    try {
                        aVar.write(("Process Name: '" + h() + "'\n").getBytes("UTF-8"));
                        aVar.write(("Thread Name: '" + java.lang.Thread.currentThread().getName() + "'\n").getBytes("UTF-8"));
                    } catch (java.lang.Throwable th6) {
                        com.uc.crashsdk.a.g.a(th6);
                    }
                    try {
                        aVar.write("Back traces starts.\n".getBytes("UTF-8"));
                        try {
                            java.lang.reflect.Field declaredField = java.lang.Throwable.class.getDeclaredField("detailMessage");
                            declaredField.setAccessible(true);
                            java.lang.Object obj = declaredField.get(th);
                            if (obj != null) {
                                declaredField.set(th, ((java.lang.String) obj).replaceAll("\n\t", "\n->  "));
                            }
                        } catch (java.lang.Throwable th7) {
                            com.uc.crashsdk.a.g.a(th7);
                        }
                        java.lang.String message = th.getMessage();
                        if (message != null && !message.equals(th.getLocalizedMessage())) {
                            aVar.write(("Message: " + message + "\n").getBytes("UTF-8"));
                        }
                    } catch (java.lang.Throwable th8) {
                        com.uc.crashsdk.a.g.a(th8);
                    }
                    try {
                        th.printStackTrace(new java.io.PrintStream(aVar));
                    } catch (java.lang.Throwable th9) {
                        com.uc.crashsdk.a.g.a(th9);
                    }
                    try {
                        aVar.write("Back traces ends.\n".getBytes("UTF-8"));
                    } catch (java.lang.Throwable th10) {
                        com.uc.crashsdk.a.g.a(th10);
                    }
                    a((java.io.OutputStream) aVar);
                    try {
                        aVar.flush();
                    } catch (java.lang.Throwable th11) {
                        com.uc.crashsdk.a.g.a(th11);
                    }
                    try {
                        com.uc.crashsdk.a.a(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                    } catch (java.lang.Throwable th12) {
                        com.uc.crashsdk.a.g.a(th12);
                    }
                    if (z2) {
                        try {
                            aVar.flush();
                        } catch (java.lang.Throwable th13) {
                            com.uc.crashsdk.a.g.a(th13);
                        }
                    }
                    try {
                        aVar.write("meminfo:\n".getBytes("UTF-8"));
                        b(aVar, "/proc/meminfo", 10240);
                    } catch (java.lang.Throwable th14) {
                        a(th14, aVar);
                    }
                    try {
                        java.lang.String format = java.lang.String.format(java.util.Locale.US, "/proc/%d/status", java.lang.Integer.valueOf(android.os.Process.myPid()));
                        aVar.write("status:\n".getBytes("UTF-8"));
                        b(aVar, format, 10240);
                    } catch (java.lang.Throwable th15) {
                        a(th15, aVar);
                    }
                    try {
                        aVar.write(("memory info:\n" + g()).getBytes("UTF-8"));
                    } catch (java.lang.Throwable th16) {
                        a(th16, aVar);
                    }
                    a((java.io.OutputStream) aVar);
                    f(aVar);
                    try {
                        com.uc.crashsdk.a.a(aVar, "UTF-8", (java.util.ArrayList<java.lang.String>) null);
                    } catch (java.lang.Throwable th17) {
                        a(th17, aVar);
                    }
                    if (ag) {
                        h = false;
                        try {
                            aVar.write(s("JAVADUMPFILES").getBytes("UTF-8"));
                        } catch (java.lang.Throwable th18) {
                            a(th18, aVar);
                        }
                        h = true;
                    }
                    try {
                        aVar.flush();
                    } catch (java.lang.Throwable th19) {
                        com.uc.crashsdk.a.g.a(th19);
                    }
                    b((java.io.OutputStream) aVar);
                    try {
                        aVar.flush();
                    } catch (java.lang.Throwable th20) {
                        com.uc.crashsdk.a.g.a(th20);
                    }
                    try {
                        aVar.write("battery info:\n".getBytes("UTF-8"));
                    } catch (java.lang.Throwable th21) {
                        a(th21, aVar);
                    }
                    try {
                        if (ag) {
                            h = false;
                            aVar.write(s("BATTERYINFO").getBytes("UTF-8"));
                            h = true;
                        } else {
                            java.lang.StringBuilder Y2 = Y();
                            if (Y2 != null) {
                                aVar.write(Y2.toString().getBytes("UTF-8"));
                            }
                        }
                    } catch (java.lang.Throwable th22) {
                        a(th22, aVar);
                    }
                    a((java.io.OutputStream) aVar);
                    try {
                        aVar.write("disk info:\n".getBytes("UTF-8"));
                    } catch (java.lang.Throwable th23) {
                        a(th23, aVar);
                    }
                } catch (java.lang.Throwable th24) {
                    th = th24;
                    fileOutputStream = fileOutputStream2;
                    aVar2 = aVar;
                    a(th, aVar2);
                    if (j2 != 0) {
                    }
                    com.uc.crashsdk.a.g.a(aVar2);
                    com.uc.crashsdk.a.g.a(fileOutputStream);
                    if (!ag) {
                    }
                    b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                    return str;
                }
            } catch (java.lang.Throwable th25) {
                th = th25;
                fileOutputStream = fileOutputStream2;
            }
        } catch (java.lang.Throwable th26) {
            th = th26;
        }
        if (ag) {
            h = false;
            try {
                aVar.write(s("FSSTAT").getBytes("UTF-8"));
            } catch (java.lang.Throwable th27) {
                a(th27, aVar);
            }
            h = true;
        } else {
            try {
                hashSet = new java.util.HashSet();
                a2 = a(new java.io.File(com.uc.crashsdk.a.g.b()));
            } catch (java.lang.Throwable th28) {
                th = th28;
                str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                i3 = i2;
            }
            if (!com.uc.crashsdk.a.g.a(a2) && !hashSet.contains(a2) && !a2.equals("/storage/emulated")) {
                hashSet.add(a2);
                try {
                    statFs = new android.os.StatFs(a2);
                    a3 = a(statFs, "getBlockCountLong", "getBlockCount");
                    i3 = i2;
                    try {
                        a4 = a(statFs, "getBlockSizeLong", "getBlockSize");
                    } catch (java.lang.Throwable th29) {
                        th = th29;
                        str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                    }
                } catch (java.lang.Throwable unused) {
                }
                if ((a3 / 1024) * a4 < com.huawei.hms.utils.FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                    str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                    fileOutputStream = fileOutputStream2;
                    str3 = "\n";
                    a((java.io.OutputStream) aVar);
                    aVar.write("device status:\n".getBytes("UTF-8"));
                    if (ag) {
                    }
                    a((java.io.OutputStream) aVar);
                    c(aVar);
                    d(aVar);
                    java.lang.String str4 = str2;
                    com.uc.crashsdk.a.b(aVar, "UTF-8", str4, null);
                    if (ag) {
                    }
                    aVar.flush();
                    com.uc.crashsdk.a.a(aVar, "UTF-8", str4, null);
                    if (ag) {
                    }
                    aVar.a();
                    a(aVar);
                    aVar.flush();
                    if (i3 != 0) {
                    }
                    com.uc.crashsdk.a.g.a(aVar);
                    com.uc.crashsdk.a.g.a(fileOutputStream);
                    if (!ag) {
                    }
                    b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                    return str;
                }
                long a5 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
                try {
                    long a6 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
                    try {
                        java.util.Locale locale = java.util.Locale.US;
                        str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                        fileOutputStream = fileOutputStream2;
                        try {
                            aVar.write(java.lang.String.format(locale, "%s:\n", a2).getBytes("UTF-8"));
                            java.lang.Object[] objArr = new java.lang.Object[1];
                            str3 = "\n";
                            double d2 = a4;
                            try {
                                objArr[0] = java.lang.Long.valueOf((long) (((a3 * 1.0d) * d2) / 1024.0d));
                                aVar.write(java.lang.String.format(locale, "  total:      %d kB\n", objArr).getBytes("UTF-8"));
                                aVar.write(java.lang.String.format(locale, "  available:  %d kB\n", java.lang.Long.valueOf((long) (((a5 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                                aVar.write(java.lang.String.format(locale, "  free:       %d kB\n", java.lang.Long.valueOf((long) (((a6 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                                aVar.write(java.lang.String.format(locale, "  block size: %d B\n\n", java.lang.Long.valueOf(a4)).getBytes("UTF-8"));
                            } catch (java.lang.Throwable th30) {
                                th = th30;
                                try {
                                    a(th, aVar);
                                } catch (java.lang.Throwable th31) {
                                    th = th31;
                                    try {
                                        a(th, aVar);
                                        a((java.io.OutputStream) aVar);
                                        aVar.write("device status:\n".getBytes("UTF-8"));
                                        if (ag) {
                                        }
                                        a((java.io.OutputStream) aVar);
                                        c(aVar);
                                        d(aVar);
                                        java.lang.String str42 = str2;
                                        com.uc.crashsdk.a.b(aVar, "UTF-8", str42, null);
                                        if (ag) {
                                        }
                                        aVar.flush();
                                        com.uc.crashsdk.a.a(aVar, "UTF-8", str42, null);
                                        if (ag) {
                                        }
                                        aVar.a();
                                        a(aVar);
                                        aVar.flush();
                                        if (i3 != 0) {
                                        }
                                        com.uc.crashsdk.a.g.a(aVar);
                                    } catch (java.lang.Throwable th32) {
                                        th = th32;
                                        aVar2 = aVar;
                                        a(th, aVar2);
                                        if (j2 != 0) {
                                            b(aVar2);
                                        }
                                        com.uc.crashsdk.a.g.a(aVar2);
                                        com.uc.crashsdk.a.g.a(fileOutputStream);
                                        if (!ag) {
                                        }
                                        b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                                        return str;
                                    }
                                    com.uc.crashsdk.a.g.a(fileOutputStream);
                                    if (!ag) {
                                    }
                                    b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                                    return str;
                                }
                                a((java.io.OutputStream) aVar);
                                aVar.write("device status:\n".getBytes("UTF-8"));
                                if (ag) {
                                }
                                a((java.io.OutputStream) aVar);
                                c(aVar);
                                d(aVar);
                                java.lang.String str422 = str2;
                                com.uc.crashsdk.a.b(aVar, "UTF-8", str422, null);
                                if (ag) {
                                }
                                aVar.flush();
                                com.uc.crashsdk.a.a(aVar, "UTF-8", str422, null);
                                if (ag) {
                                }
                                aVar.a();
                                a(aVar);
                                aVar.flush();
                                if (i3 != 0) {
                                }
                                com.uc.crashsdk.a.g.a(aVar);
                                com.uc.crashsdk.a.g.a(fileOutputStream);
                                if (!ag) {
                                }
                                b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                                return str;
                            }
                        } catch (java.lang.Throwable th33) {
                            th = th33;
                            str3 = "\n";
                            a(th, aVar);
                            a((java.io.OutputStream) aVar);
                            aVar.write("device status:\n".getBytes("UTF-8"));
                            if (ag) {
                            }
                            a((java.io.OutputStream) aVar);
                            c(aVar);
                            d(aVar);
                            java.lang.String str4222 = str2;
                            com.uc.crashsdk.a.b(aVar, "UTF-8", str4222, null);
                            if (ag) {
                            }
                            aVar.flush();
                            com.uc.crashsdk.a.a(aVar, "UTF-8", str4222, null);
                            if (ag) {
                            }
                            aVar.a();
                            a(aVar);
                            aVar.flush();
                            if (i3 != 0) {
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                            com.uc.crashsdk.a.g.a(fileOutputStream);
                            if (!ag) {
                            }
                            b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                            return str;
                        }
                    } catch (java.lang.Throwable th34) {
                        th = th34;
                        str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                        fileOutputStream = fileOutputStream2;
                    }
                } catch (java.lang.Throwable th35) {
                    th = th35;
                    str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                    fileOutputStream = fileOutputStream2;
                    str3 = "\n";
                    a(th, aVar);
                    a((java.io.OutputStream) aVar);
                    aVar.write("device status:\n".getBytes("UTF-8"));
                    if (ag) {
                    }
                    a((java.io.OutputStream) aVar);
                    c(aVar);
                    d(aVar);
                    java.lang.String str42222 = str2;
                    com.uc.crashsdk.a.b(aVar, "UTF-8", str42222, null);
                    if (ag) {
                    }
                    aVar.flush();
                    com.uc.crashsdk.a.a(aVar, "UTF-8", str42222, null);
                    if (ag) {
                    }
                    aVar.a();
                    a(aVar);
                    aVar.flush();
                    if (i3 != 0) {
                    }
                    com.uc.crashsdk.a.g.a(aVar);
                    com.uc.crashsdk.a.g.a(fileOutputStream);
                    if (!ag) {
                    }
                    b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                    return str;
                }
                a((java.io.OutputStream) aVar);
                aVar.write("device status:\n".getBytes("UTF-8"));
                if (ag) {
                    try {
                        h = false;
                        aVar.write(s("DEVICESTATUS").getBytes("UTF-8"));
                        h = true;
                    } catch (java.lang.Throwable th36) {
                        th = th36;
                        a(th, aVar);
                        a((java.io.OutputStream) aVar);
                        c(aVar);
                        d(aVar);
                        java.lang.String str422222 = str2;
                        com.uc.crashsdk.a.b(aVar, "UTF-8", str422222, null);
                        if (ag) {
                        }
                        aVar.flush();
                        com.uc.crashsdk.a.a(aVar, "UTF-8", str422222, null);
                        if (ag) {
                        }
                        aVar.a();
                        a(aVar);
                        aVar.flush();
                        if (i3 != 0) {
                        }
                        com.uc.crashsdk.a.g.a(aVar);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        if (!ag) {
                        }
                        b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                        return str;
                    }
                } else {
                    try {
                        java.util.Locale locale2 = java.util.Locale.US;
                        aVar.write(java.lang.String.format(locale2, "has root: %s\n", java.lang.Boolean.valueOf(com.uc.crashsdk.a.g.e())).getBytes("UTF-8"));
                        java.lang.String str5 = android.os.Build.TAGS;
                        java.lang.String str6 = str5 != null ? str5 : "";
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("build tags: ");
                        sb.append(str6);
                        if (com.uc.crashsdk.a.g.f()) {
                            sb.append(" (default root)");
                        }
                        sb.append(str3);
                        aVar.write(sb.toString().getBytes("UTF-8"));
                        java.lang.String h2 = com.uc.crashsdk.a.g.h();
                        if (com.uc.crashsdk.a.g.b(h2)) {
                            aVar.write(java.lang.String.format(locale2, "su binary: %s\n", h2).getBytes("UTF-8"));
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append("su permission: ");
                            sb2.append(com.uc.crashsdk.a.g.g() ? "valid (" : "invalid (");
                            sb2.append(com.uc.crashsdk.a.g.i());
                            sb2.append(")\n");
                            aVar.write(sb2.toString().getBytes("UTF-8"));
                        }
                    } catch (java.lang.Throwable th37) {
                        th = th37;
                        a(th, aVar);
                        a((java.io.OutputStream) aVar);
                        c(aVar);
                        d(aVar);
                        java.lang.String str4222222 = str2;
                        com.uc.crashsdk.a.b(aVar, "UTF-8", str4222222, null);
                        if (ag) {
                        }
                        aVar.flush();
                        com.uc.crashsdk.a.a(aVar, "UTF-8", str4222222, null);
                        if (ag) {
                        }
                        aVar.a();
                        a(aVar);
                        aVar.flush();
                        if (i3 != 0) {
                        }
                        com.uc.crashsdk.a.g.a(aVar);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        if (!ag) {
                        }
                        b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                        return str;
                    }
                }
                a((java.io.OutputStream) aVar);
                c(aVar);
                d(aVar);
                java.lang.String str42222222 = str2;
                com.uc.crashsdk.a.b(aVar, "UTF-8", str42222222, null);
                if (ag) {
                    h = false;
                    try {
                        aVar.write(s("JAVACACHEDINFOS").getBytes("UTF-8"));
                    } catch (java.lang.Throwable th38) {
                        a(th38, aVar);
                    }
                    h = true;
                }
                aVar.flush();
                com.uc.crashsdk.a.a(aVar, "UTF-8", str42222222, null);
                if (ag) {
                    h = false;
                    try {
                        aVar.write(s("JAVACALLBACKINFOS").getBytes("UTF-8"));
                    } catch (java.lang.Throwable th39) {
                        a(th39, aVar);
                    }
                    h = true;
                }
                aVar.a();
                a(aVar);
                aVar.flush();
                if (i3 != 0) {
                    b(aVar);
                }
                com.uc.crashsdk.a.g.a(aVar);
                com.uc.crashsdk.a.g.a(fileOutputStream);
                if (!ag) {
                    r(str);
                }
                b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
                return str;
            }
        }
        str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
        i3 = i2;
        fileOutputStream = fileOutputStream2;
        str3 = "\n";
        a((java.io.OutputStream) aVar);
        aVar.write("device status:\n".getBytes("UTF-8"));
        if (ag) {
        }
        a((java.io.OutputStream) aVar);
        c(aVar);
        d(aVar);
        java.lang.String str422222222 = str2;
        com.uc.crashsdk.a.b(aVar, "UTF-8", str422222222, null);
        if (ag) {
        }
        aVar.flush();
        com.uc.crashsdk.a.a(aVar, "UTF-8", str422222222, null);
        if (ag) {
        }
        aVar.a();
        a(aVar);
        aVar.flush();
        if (i3 != 0) {
        }
        com.uc.crashsdk.a.g.a(aVar);
        com.uc.crashsdk.a.g.a(fileOutputStream);
        if (!ag) {
        }
        b(ag ? a(m(str)) : str, com.uc.crashsdk.export.LogType.JAVA_TYPE);
        return str;
    }

    private static java.lang.String a(java.util.Date date) {
        return java.lang.String.format(java.util.Locale.US, "%d%02d%02d%02d%02d%02d", java.lang.Integer.valueOf(date.getYear() + 1900), java.lang.Integer.valueOf(date.getMonth() + 1), java.lang.Integer.valueOf(date.getDate()), java.lang.Integer.valueOf(date.getHours()), java.lang.Integer.valueOf(date.getMinutes()), java.lang.Integer.valueOf(date.getSeconds()));
    }

    public static java.lang.StringBuilder a(java.lang.StackTraceElement[] stackTraceElementArr, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (java.lang.StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    z2 = true;
                    i3 = 0;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static void a(int i2, java.lang.Object[] objArr) {
        int i3;
        switch (i2) {
            case 401:
                com.uc.crashsdk.JNIBridge.nativeCmd(10, com.uc.crashsdk.b.I() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Z();
                y();
                return;
            case 402:
                java.lang.Object obj = Y;
                synchronized (obj) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.q()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.e()) {
                        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    }
                    if (!d(com.uc.crashsdk.export.LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                        return;
                    }
                    int nativeGenerateUnexpLog = com.uc.crashsdk.JNIBridge.nativeGenerateUnexpLog(com.uc.crashsdk.g.p(), com.uc.crashsdk.g.q());
                    if (nativeGenerateUnexpLog != 0) {
                        com.uc.crashsdk.f.a(11);
                        if ((nativeGenerateUnexpLog & 4352) != 0) {
                            Z = 105;
                            i3 = 30;
                        } else if ((nativeGenerateUnexpLog & com.uc.crashsdk.export.LogType.UNEXP_EXIT) != 0) {
                            Z = 104;
                            i3 = 31;
                        } else if ((nativeGenerateUnexpLog & com.uc.crashsdk.export.LogType.UNEXP_RESTART) != 0) {
                            Z = 106;
                            i3 = 32;
                        } else {
                            if ((nativeGenerateUnexpLog & 1280) != 0) {
                                Z = 103;
                                com.uc.crashsdk.f.a(10);
                            } else if ((nativeGenerateUnexpLog & 2304) != 0) {
                                Z = 107;
                                com.uc.crashsdk.f.a(29);
                            } else {
                                Z = 102;
                            }
                            a(true);
                        }
                        com.uc.crashsdk.f.a(i3);
                        a(true);
                    }
                    synchronized (obj) {
                        X = null;
                    }
                    return;
                }
            case 403:
                ab();
                return;
            case 404:
            default:
                if (!a) {
                    throw new java.lang.AssertionError();
                }
                return;
            case 405:
                L = false;
                java.lang.StringBuilder Y2 = Y();
                java.lang.String g2 = com.uc.crashsdk.b.g();
                if (Y2 != null) {
                    com.uc.crashsdk.a.g.a(new java.io.File(g2), Y2.toString());
                    return;
                }
                return;
            case 406:
                if (!a && objArr == null) {
                    throw new java.lang.AssertionError();
                }
                a((java.lang.String) objArr[0], ((java.lang.Boolean) objArr[1]).booleanValue(), ((java.lang.Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (java.lang.Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case com.bytedance.sdk.openadsdk.TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                synchronized (ab) {
                    if (!ac && com.uc.crashsdk.g.R() && com.uc.crashsdk.b.z()) {
                        com.uc.crashsdk.b.s();
                        com.uc.crashsdk.a.h.f();
                        com.uc.crashsdk.f.c();
                        if (com.uc.crashsdk.b.F()) {
                            C();
                        }
                        if (com.uc.crashsdk.g.R()) {
                            a(java.util.Calendar.getInstance());
                        }
                        ac = true;
                        return;
                    }
                    return;
                }
            case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                d(false);
                return;
            case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                a(false, true);
                return;
            case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_CODE /* 411 */:
                if (com.uc.crashsdk.b.d) {
                    com.uc.crashsdk.JNIBridge.set(28, d(com.uc.crashsdk.export.LogType.NATIVE_TYPE));
                    com.uc.crashsdk.JNIBridge.set(29, d(com.uc.crashsdk.export.LogType.ANR_TYPE));
                    return;
                }
                return;
            case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_URL_CODE /* 412 */:
                if (!R && com.uc.crashsdk.b.B() && com.uc.crashsdk.g.N()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (com.uc.crashsdk.b.B() && com.uc.crashsdk.g.N()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (java.lang.Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                }
                return;
            case com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                com.uc.crashsdk.JNIBridge.cmd(8);
                return;
            case com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_URL_CODE /* 414 */:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i4 = N + 1;
                    N = i4;
                    if (i4 < 10) {
                        X();
                        return;
                    } else {
                        if (com.uc.crashsdk.b.d) {
                            com.uc.crashsdk.JNIBridge.set(130, "(get failed)");
                            return;
                        }
                        return;
                    }
                } catch (java.lang.Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                if (!a && objArr == null) {
                    throw new java.lang.AssertionError();
                }
                long longValue = ((java.lang.Long) objArr[0]).longValue();
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                if (calendar.getTimeInMillis() >= longValue) {
                    com.uc.crashsdk.a.h.g();
                    com.uc.crashsdk.f.a(100);
                    d(true);
                    com.uc.crashsdk.f.a(true);
                    com.uc.crashsdk.a.h.b();
                } else {
                    com.uc.crashsdk.a.h.h();
                    com.uc.crashsdk.a.h.i();
                    com.uc.crashsdk.a.h.c();
                }
                a(calendar);
                break;
            case 416:
                break;
        }
        W();
    }

    public static void a(android.content.Context context) {
        try {
            if (V()) {
                context.registerReceiver(new com.uc.crashsdk.e.c((byte) 0), new android.content.IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static void a(com.uc.crashsdk.e.a aVar) {
        try {
            aVar.a(java.lang.String.format(java.util.Locale.US, "log end: %s\n", n()));
        } catch (java.lang.Throwable th) {
            a(th, aVar);
        }
    }

    private static void a(com.uc.crashsdk.e.a aVar, java.lang.String str, long j2) {
        java.lang.String nativeDumpThreads;
        java.lang.String str2 = null;
        if (com.uc.crashsdk.b.d) {
            try {
                aVar.flush();
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            nativeDumpThreads = com.uc.crashsdk.JNIBridge.nativeDumpThreads(str, j2);
            if (ag || nativeDumpThreads == null || nativeDumpThreads.length() >= 512 || !nativeDumpThreads.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || nativeDumpThreads.indexOf(10) >= 0) {
                str2 = nativeDumpThreads;
            } else {
                if (!new java.io.File(nativeDumpThreads).exists()) {
                    str2 = "Can not found " + nativeDumpThreads;
                }
                java.lang.String str3 = str2;
                str2 = nativeDumpThreads;
                nativeDumpThreads = str3;
            }
        } else {
            nativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (nativeDumpThreads != null) {
            try {
                aVar.write(nativeDumpThreads.getBytes("UTF-8"));
                aVar.write("\n".getBytes("UTF-8"));
            } catch (java.lang.Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((java.io.OutputStream) aVar);
        } else if (str2 != null && !ag) {
            b(aVar, str2, 1048576);
            java.io.File file = new java.io.File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (java.lang.Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    private static void a(java.io.OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (java.lang.Throwable th) {
            a(th, outputStream);
        }
    }

    public static void a(java.io.OutputStream outputStream, java.lang.String str, java.lang.String str2) {
        h = false;
        try {
            outputStream.write(java.lang.String.format(java.util.Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    public static void a(java.io.OutputStream outputStream, java.lang.String str, java.lang.String str2, int i2, boolean z2, boolean z3) {
        h = false;
        try {
            java.util.Locale locale = java.util.Locale.US;
            java.lang.Object[] objArr = new java.lang.Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = java.lang.Integer.valueOf(i2);
            objArr[3] = java.lang.Integer.valueOf(z2 ? 1 : 0);
            objArr[4] = java.lang.Integer.valueOf(z3 ? 1 : 0);
            outputStream.write(java.lang.String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
        a(outputStream);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0356 A[Catch: all -> 0x0442, TryCatch #1 {all -> 0x0442, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cd, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0384, B:124:0x0391, B:129:0x03bb, B:131:0x03e1, B:133:0x03e8, B:135:0x03ef, B:137:0x03f6, B:139:0x03fd, B:141:0x0404, B:146:0x0416, B:148:0x041d, B:150:0x0424, B:152:0x042b, B:153:0x040f, B:154:0x038b, B:155:0x03ae, B:157:0x03b3, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0433), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03ae A[Catch: all -> 0x0442, TryCatch #1 {all -> 0x0442, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cd, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0384, B:124:0x0391, B:129:0x03bb, B:131:0x03e1, B:133:0x03e8, B:135:0x03ef, B:137:0x03f6, B:139:0x03fd, B:141:0x0404, B:146:0x0416, B:148:0x041d, B:150:0x0424, B:152:0x042b, B:153:0x040f, B:154:0x038b, B:155:0x03ae, B:157:0x03b3, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0433), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01da A[Catch: all -> 0x0442, TryCatch #1 {all -> 0x0442, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cd, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0384, B:124:0x0391, B:129:0x03bb, B:131:0x03e1, B:133:0x03e8, B:135:0x03ef, B:137:0x03f6, B:139:0x03fd, B:141:0x0404, B:146:0x0416, B:148:0x041d, B:150:0x0424, B:152:0x042b, B:153:0x040f, B:154:0x038b, B:155:0x03ae, B:157:0x03b3, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0433), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0210 A[Catch: all -> 0x0442, TryCatch #1 {all -> 0x0442, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cd, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0384, B:124:0x0391, B:129:0x03bb, B:131:0x03e1, B:133:0x03e8, B:135:0x03ef, B:137:0x03f6, B:139:0x03fd, B:141:0x0404, B:146:0x0416, B:148:0x041d, B:150:0x0424, B:152:0x042b, B:153:0x040f, B:154:0x038b, B:155:0x03ae, B:157:0x03b3, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0433), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0226 A[Catch: all -> 0x0442, TryCatch #1 {all -> 0x0442, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cd, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0384, B:124:0x0391, B:129:0x03bb, B:131:0x03e1, B:133:0x03e8, B:135:0x03ef, B:137:0x03f6, B:139:0x03fd, B:141:0x0404, B:146:0x0416, B:148:0x041d, B:150:0x0424, B:152:0x042b, B:153:0x040f, B:154:0x038b, B:155:0x03ae, B:157:0x03b3, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0433), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02fc A[Catch: all -> 0x0442, TryCatch #1 {all -> 0x0442, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cd, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0384, B:124:0x0391, B:129:0x03bb, B:131:0x03e1, B:133:0x03e8, B:135:0x03ef, B:137:0x03f6, B:139:0x03fd, B:141:0x0404, B:146:0x0416, B:148:0x041d, B:150:0x0424, B:152:0x042b, B:153:0x040f, B:154:0x038b, B:155:0x03ae, B:157:0x03b3, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0433), top: B:4:0x000a, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(java.lang.String str, boolean z2, boolean z3) {
        android.os.ConditionVariable conditionVariable;
        int i2;
        boolean z4;
        boolean z5;
        java.io.File[] fileArr;
        int i3;
        java.lang.String path;
        java.lang.String b2;
        java.io.File a2;
        int i4;
        int i5;
        java.lang.String str2;
        java.lang.String str3;
        int i6;
        java.io.File file;
        boolean z6;
        com.uc.crashsdk.a.a.a("crashsdk", "crashsdk uploading logs");
        synchronized (n) {
            try {
                try {
                    if (com.uc.crashsdk.a.g.b(str)) {
                        java.lang.String Y2 = com.uc.crashsdk.g.Y();
                        java.io.File file2 = new java.io.File(Y2);
                        if (file2.exists()) {
                            java.io.File[] listFiles = file2.listFiles();
                            if (listFiles == null) {
                                com.uc.crashsdk.a.a.b("List folder failed: " + Y2);
                            } else {
                                int length = listFiles.length;
                                int i7 = 0;
                                int i8 = 0;
                                int i9 = 0;
                                int i10 = 0;
                                int i11 = 0;
                                int i12 = 0;
                                int i13 = 0;
                                int i14 = 0;
                                int i15 = 0;
                                boolean z7 = false;
                                boolean z8 = false;
                                boolean z9 = false;
                                while (true) {
                                    if (i7 >= length) {
                                        i2 = i10;
                                        z4 = z7;
                                        z5 = z8;
                                        break;
                                    }
                                    java.io.File file3 = listFiles[i7];
                                    if (file3.isFile()) {
                                        java.lang.String name = file3.getName();
                                        fileArr = listFiles;
                                        if (!name.endsWith(com.baidu.mobads.sdk.internal.al.k)) {
                                            i3 = length;
                                            z4 = z7;
                                            z5 = z8;
                                            if (file3.length() == 0) {
                                                i8++;
                                                com.uc.crashsdk.a.g.a(file3);
                                            } else {
                                                if (z2) {
                                                    long currentTimeMillis = (java.lang.System.currentTimeMillis() - file3.lastModified()) / 1000;
                                                    if (currentTimeMillis < 0 || (currentTimeMillis >= 2 && (currentTimeMillis >= 5 || !file3.getName().endsWith(com.anythink.china.common.a.a.f)))) {
                                                        z6 = true;
                                                        com.uc.crashsdk.a.a.a(java.lang.String.format(java.util.Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), java.lang.Long.valueOf(currentTimeMillis), java.lang.Boolean.valueOf(z6)));
                                                        if (!z6) {
                                                            i10++;
                                                        }
                                                    }
                                                    z6 = false;
                                                    com.uc.crashsdk.a.a.a(java.lang.String.format(java.util.Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), java.lang.Long.valueOf(currentTimeMillis), java.lang.Boolean.valueOf(z6)));
                                                    if (!z6) {
                                                    }
                                                }
                                                try {
                                                } catch (java.lang.Throwable th) {
                                                    th = th;
                                                    i2 = i10;
                                                }
                                                if (com.uc.crashsdk.g.l()) {
                                                    java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("([^_]+)_([^_]+)_([^_]+)\\.crashsdk").matcher(file3.getName());
                                                    if (matcher.matches()) {
                                                        i2 = i10;
                                                        try {
                                                            file = new java.io.File(com.uc.crashsdk.g.Y() + java.lang.String.format(java.util.Locale.US, "%s%s_%s_%s.%s", j(matcher.group(2)), n(), Q(), matcher.group(1), matcher.group(3)));
                                                            com.uc.crashsdk.a.a.a("crashsdk", "File " + file3.getPath() + " matches, rename to " + file.getPath());
                                                            file3.renameTo(file);
                                                            if (file != file3) {
                                                                i14++;
                                                            }
                                                            file3 = file;
                                                        } catch (java.lang.Throwable th2) {
                                                            th = th2;
                                                            com.uc.crashsdk.a.g.a(th);
                                                            path = file3.getPath();
                                                            boolean[] n2 = n(path);
                                                            b2 = b(path, n2[0], n2[1]);
                                                            if (path != b2) {
                                                            }
                                                            a2 = com.uc.crashsdk.d.a(file3);
                                                            if (a2 == null) {
                                                            }
                                                            if (a2 == null) {
                                                            }
                                                            i4 = i12;
                                                            z8 = z5;
                                                            i10 = i2;
                                                            i7++;
                                                            listFiles = fileArr;
                                                            i12 = i4;
                                                            length = i3;
                                                            z7 = z4;
                                                        }
                                                        path = file3.getPath();
                                                        boolean[] n22 = n(path);
                                                        b2 = b(path, n22[0], n22[1]);
                                                        if (path != b2) {
                                                            if (n22[0]) {
                                                                i12++;
                                                            }
                                                            if (n22[1]) {
                                                                i13++;
                                                            }
                                                            file3 = new java.io.File(b2);
                                                        }
                                                        a2 = com.uc.crashsdk.d.a(file3);
                                                        if (a2 == null) {
                                                            a2 = null;
                                                        } else if (file3 != a2 && !file3.getName().equals(a2.getName()) && file3.exists()) {
                                                            file3.delete();
                                                        }
                                                        if (a2 == null) {
                                                            com.uc.crashsdk.a.a.b("onBeforeUploadLog return null, skip upload: " + file3.getAbsolutePath());
                                                        } else {
                                                            int C2 = com.uc.crashsdk.g.C();
                                                            if (C2 <= 0 || a2.length() < C2) {
                                                                com.uc.crashsdk.e.d dVar = new com.uc.crashsdk.e.d((byte) 0);
                                                                dVar.b = 0L;
                                                                dVar.a = java.lang.System.currentTimeMillis();
                                                                java.lang.String U2 = U();
                                                                if (new java.io.File(U2).exists()) {
                                                                    a(U2, new com.uc.crashsdk.a.e(451, new java.lang.Object[]{U2, dVar}));
                                                                }
                                                                long D2 = com.uc.crashsdk.g.D();
                                                                int E2 = com.uc.crashsdk.g.E();
                                                                int F2 = com.uc.crashsdk.g.F();
                                                                if (D2 >= 0) {
                                                                    i4 = i12;
                                                                    i5 = i13;
                                                                    if (dVar.b + a2.length() > D2) {
                                                                        dVar.e = true;
                                                                        str2 = "Reach max upload bytes: " + D2;
                                                                        com.uc.crashsdk.a.a.b(str2);
                                                                        if (!dVar.e) {
                                                                            i13 = i5;
                                                                            z8 = z5;
                                                                            i10 = i2;
                                                                            z4 = true;
                                                                        } else if (dVar.g) {
                                                                            i13 = i5;
                                                                            i10 = i2;
                                                                            z8 = true;
                                                                        } else if (dVar.f) {
                                                                            i13 = i5;
                                                                            z8 = z5;
                                                                            i10 = i2;
                                                                            z9 = true;
                                                                        } else {
                                                                            java.lang.String name2 = a2.getName();
                                                                            if (name2.startsWith(P())) {
                                                                                java.lang.String[] split = name2.split("_", 10);
                                                                                if (split.length == 9) {
                                                                                    str3 = split[1];
                                                                                    boolean z10 = str3 == null && str3.equals(com.uc.crashsdk.g.U());
                                                                                    if (com.uc.crashsdk.a.c.a(a2, a2.getName(), str)) {
                                                                                        i15++;
                                                                                        if (z10) {
                                                                                            com.uc.crashsdk.f.a(14);
                                                                                        }
                                                                                        i6 = 3;
                                                                                    } else {
                                                                                        com.uc.crashsdk.a.a.a("crashsdk", "Uploaded log: " + a2.getName(), null);
                                                                                        if (z10) {
                                                                                            com.uc.crashsdk.f.a(13);
                                                                                        }
                                                                                        dVar.b += a2.length();
                                                                                        if (b(a2)) {
                                                                                            dVar.c++;
                                                                                        } else {
                                                                                            dVar.d++;
                                                                                        }
                                                                                        java.lang.String U3 = U();
                                                                                        a(U3, new com.uc.crashsdk.a.e(452, new java.lang.Object[]{U3, dVar}));
                                                                                        a2.delete();
                                                                                        i6 = 3;
                                                                                        i15 = 0;
                                                                                    }
                                                                                    if (i15 < i6) {
                                                                                        com.uc.crashsdk.a.a.a("crashsdk", "Upload failed 3 times continuously, abort upload!", null);
                                                                                        i12 = i4;
                                                                                        i13 = i5;
                                                                                        break;
                                                                                    } else {
                                                                                        i13 = i5;
                                                                                        z8 = z5;
                                                                                        i10 = i2;
                                                                                    }
                                                                                }
                                                                            }
                                                                            str3 = null;
                                                                            if (str3 == null) {
                                                                            }
                                                                            if (com.uc.crashsdk.a.c.a(a2, a2.getName(), str)) {
                                                                            }
                                                                            if (i15 < i6) {
                                                                            }
                                                                        }
                                                                        i7++;
                                                                        listFiles = fileArr;
                                                                        i12 = i4;
                                                                        length = i3;
                                                                        z7 = z4;
                                                                    }
                                                                } else {
                                                                    i4 = i12;
                                                                    i5 = i13;
                                                                }
                                                                if (!com.uc.crashsdk.g.f()) {
                                                                    if (b(a2)) {
                                                                        if (E2 >= 0 && dVar.c >= E2) {
                                                                            dVar.g = true;
                                                                            str2 = "Reach max upload builtin log count: " + E2;
                                                                            com.uc.crashsdk.a.a.b(str2);
                                                                        }
                                                                    } else if (F2 >= 0 && dVar.d >= F2) {
                                                                        dVar.f = true;
                                                                        str2 = "Reach max upload custom log count: " + F2;
                                                                        com.uc.crashsdk.a.a.b(str2);
                                                                    }
                                                                }
                                                                if (!dVar.e) {
                                                                }
                                                                i7++;
                                                                listFiles = fileArr;
                                                                i12 = i4;
                                                                length = i3;
                                                                z7 = z4;
                                                            } else {
                                                                i11++;
                                                                com.uc.crashsdk.a.g.a(a2);
                                                            }
                                                        }
                                                        i4 = i12;
                                                        z8 = z5;
                                                        i10 = i2;
                                                        i7++;
                                                        listFiles = fileArr;
                                                        i12 = i4;
                                                        length = i3;
                                                        z7 = z4;
                                                    }
                                                }
                                                i2 = i10;
                                                file = file3;
                                                if (file != file3) {
                                                }
                                                file3 = file;
                                                path = file3.getPath();
                                                boolean[] n222 = n(path);
                                                b2 = b(path, n222[0], n222[1]);
                                                if (path != b2) {
                                                }
                                                a2 = com.uc.crashsdk.d.a(file3);
                                                if (a2 == null) {
                                                }
                                                if (a2 == null) {
                                                }
                                                i4 = i12;
                                                z8 = z5;
                                                i10 = i2;
                                                i7++;
                                                listFiles = fileArr;
                                                i12 = i4;
                                                length = i3;
                                                z7 = z4;
                                            }
                                            i4 = i12;
                                            z8 = z5;
                                            i7++;
                                            listFiles = fileArr;
                                            i12 = i4;
                                            length = i3;
                                            z7 = z4;
                                        } else if ((java.lang.System.currentTimeMillis() - file3.lastModified()) / 1000 > 30) {
                                            i3 = length;
                                            com.uc.crashsdk.a.a.b("delete legacy tmp file: " + name);
                                            i9++;
                                            com.uc.crashsdk.a.g.a(file3);
                                            i4 = i12;
                                            z4 = z7;
                                            i7++;
                                            listFiles = fileArr;
                                            i12 = i4;
                                            length = i3;
                                            z7 = z4;
                                        }
                                    } else {
                                        com.uc.crashsdk.a.g.a(file3);
                                        fileArr = listFiles;
                                    }
                                    i3 = length;
                                    i4 = i12;
                                    z4 = z7;
                                    i7++;
                                    listFiles = fileArr;
                                    i12 = i4;
                                    length = i3;
                                    z7 = z4;
                                }
                                if (i9 > 0) {
                                    com.uc.crashsdk.f.a(200, i9);
                                }
                                if (i8 > 0) {
                                    com.uc.crashsdk.f.a(15, i8);
                                }
                                if (i11 > 0) {
                                    com.uc.crashsdk.f.a(17, i11);
                                }
                                if (z4) {
                                    com.uc.crashsdk.f.a(19);
                                }
                                if (z5) {
                                    com.uc.crashsdk.f.a(20);
                                }
                                if (z9) {
                                    com.uc.crashsdk.f.a(21);
                                }
                                if (z4 || z5 || z9) {
                                    com.uc.crashsdk.f.a(18);
                                }
                                if (i12 > 0) {
                                    com.uc.crashsdk.f.a(24, i12);
                                }
                                if (i13 > 0) {
                                    com.uc.crashsdk.f.a(201, i13);
                                }
                                if (i14 > 0) {
                                    com.uc.crashsdk.f.a(25, i14);
                                }
                                if (i2 > 0) {
                                    com.uc.crashsdk.f.a(26, i2);
                                }
                            }
                        } else {
                            com.uc.crashsdk.a.a.a("crashsdk", "Folder not exist: " + Y2);
                        }
                    } else {
                        com.uc.crashsdk.a.a.a("crashsdk", "upload url is empty!");
                    }
                } catch (java.lang.Throwable th3) {
                    try {
                        com.uc.crashsdk.a.g.a(th3);
                        if (z3) {
                            conditionVariable = o;
                        }
                    } finally {
                    }
                }
                if (z3) {
                    conditionVariable = o;
                    conditionVariable.open();
                }
            } catch (java.lang.Throwable th4) {
                throw th4;
            }
        }
    }

    private static void a(java.lang.Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (java.lang.String) null).toString());
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.lang.Throwable th, java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new java.io.PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (java.lang.Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    private static void a(java.util.Calendar calendar) {
        if (com.uc.crashsdk.g.T()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_COVER_URL_CODE, new java.lang.Object[]{java.lang.Long.valueOf(timeInMillis2)}), j2 <= 3600000 ? 1000 + j2 : 3600000L);
        }
    }

    public static void a(boolean z2) {
        java.io.File[] listFiles;
        try {
            if (com.uc.crashsdk.b.y() && (listFiles = new java.io.File(com.uc.crashsdk.g.Y()).listFiles()) != null) {
                int m2 = com.uc.crashsdk.g.m();
                int n2 = com.uc.crashsdk.g.n();
                if (listFiles.length < java.lang.Math.min(m2, n2)) {
                    return;
                }
                int i2 = 0;
                int i3 = 0;
                for (java.io.File file : listFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < m2) ? 0 : (i2 - m2) + 1;
                int i5 = (z2 || i3 < n2) ? 0 : (i3 - n2) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                java.util.Arrays.sort(listFiles, new com.uc.crashsdk.e.b((byte) 0));
                int i6 = i4;
                int i7 = i5;
                for (java.io.File file2 : listFiles) {
                    boolean b2 = b(file2);
                    if (b2 && i6 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i6 += -1;
                    } else if (!b2 && i7 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i7 += -1;
                    }
                    if (i6 == 0 && i7 == 0) {
                        break;
                    }
                }
                com.uc.crashsdk.f.a(16, i4 + i5);
                if (i4 > 0) {
                    com.uc.crashsdk.f.a(22, i4);
                }
                if (i5 > 0) {
                    com.uc.crashsdk.f.a(23, i5);
                }
            }
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean a() {
        if (f == 0) {
            f = 2L;
            if (h(com.uc.crashsdk.b.b("logs")) == 1) {
                f = 1L;
            }
        }
        return f == 1;
    }

    public static boolean a(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        if (af) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        }
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        }
        if (ae != null) {
            com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
        }
        ae = parcelFileDescriptor;
        int fd = parcelFileDescriptor.getFd();
        int nativeCmd = (int) com.uc.crashsdk.JNIBridge.nativeCmd(13, fd, null, null);
        ag = nativeCmd != -1;
        return fd == -1 || nativeCmd != -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(java.lang.String str, long j2, java.lang.StringBuffer stringBuffer, java.lang.String str2, long j3, java.util.ArrayList<java.lang.String> arrayList, java.util.ArrayList<java.lang.String> arrayList2, java.util.ArrayList<java.lang.String> arrayList3, java.lang.String str3) {
        java.io.FileOutputStream fileOutputStream;
        com.uc.crashsdk.e.a aVar;
        java.util.ArrayList<java.lang.String> arrayList4;
        if (j2 == 0) {
            try {
                fileOutputStream = new java.io.FileOutputStream(str);
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = null;
                aVar = null;
                com.uc.crashsdk.a.g.a(th);
                if (aVar == null) {
                }
            }
        } else {
            fileOutputStream = null;
        }
        try {
            aVar = new com.uc.crashsdk.e.a(j2, fileOutputStream);
            try {
                synchronized (f441s) {
                    u = str;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(126, u);
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.uc.crashsdk.a.g.a(th);
                if (aVar == null) {
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            aVar = null;
        }
        if (aVar == null) {
            return false;
        }
        if ((j3 & 1) != 0) {
            try {
                b(aVar, str, str2);
            } finally {
                try {
                    arrayList4 = f441s;
                    synchronized (arrayList4) {
                    }
                } finally {
                }
            }
        }
        try {
            aVar.write(stringBuffer.toString().getBytes());
            aVar.write("\n".getBytes("UTF-8"));
            aVar.flush();
        } catch (java.lang.Throwable th4) {
            a(th4, aVar);
        }
        a((java.io.OutputStream) aVar);
        if ((j3 & 4) != 0) {
            b((java.io.OutputStream) aVar);
            try {
                aVar.flush();
            } catch (java.lang.Throwable th5) {
                com.uc.crashsdk.a.g.a(th5);
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            com.uc.crashsdk.a.a(aVar, "UTF-8", arrayList);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            com.uc.crashsdk.a.a(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            com.uc.crashsdk.a.b(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
        }
        if (str3 != null) {
            try {
                aVar.flush();
            } catch (java.lang.Throwable th6) {
                a(th6, aVar);
            }
            try {
                aVar.write("threads dump:\n".getBytes("UTF-8"));
            } catch (java.lang.Throwable th7) {
                a(th7, aVar);
            }
            h = false;
            w = str3;
            try {
                a(aVar, str3, j2);
            } catch (java.lang.Throwable th8) {
                a(th8, aVar);
            }
            w = null;
            h = true;
        }
        if ((j3 & 8) != 0 && j2 == 0) {
            try {
                aVar.flush();
            } catch (java.lang.Throwable th9) {
                a(th9, aVar);
            }
            try {
                aVar.write("all threads dump:\n".getBytes("UTF-8"));
            } catch (java.lang.Throwable th10) {
                a(th10, aVar);
            }
            v = true;
            try {
                a(aVar, "all", 0L);
            } catch (java.lang.Throwable th11) {
                a(th11, aVar);
            }
            v = false;
        }
        if ((j3 & 16) != 0) {
            e(aVar);
        }
        if ((j3 & 2) != 0) {
            aVar.a();
            a(aVar);
        }
        if (j2 != 0) {
            b(aVar);
        }
        try {
            arrayList4 = f441s;
            synchronized (arrayList4) {
                t++;
                java.lang.String str4 = u;
                if (str4 != null) {
                    arrayList4.add(str4);
                    if (arrayList4.size() > 3) {
                        arrayList4.remove(0);
                    }
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(127, u);
                    }
                    u = null;
                }
                if (com.uc.crashsdk.b.d) {
                    com.uc.crashsdk.JNIBridge.set(25, t);
                }
            }
        } catch (java.lang.Throwable th12) {
            com.uc.crashsdk.a.g.a(th12);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    private static boolean a(java.lang.String str, com.uc.crashsdk.a.e eVar) {
        boolean z2;
        java.nio.channels.FileChannel fileChannel;
        java.lang.Exception e;
        synchronized (p) {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (java.lang.Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            ?? r5 = 0;
            r5 = null;
            java.nio.channels.FileLock lock = null;
            z2 = false;
            try {
                try {
                    try {
                        fileChannel = new java.io.RandomAccessFile(file, "rw").getChannel();
                    } catch (java.lang.Throwable th) {
                        th = th;
                        r5 = file;
                        com.uc.crashsdk.a.g.a((java.io.Closeable) r5);
                        throw th;
                    }
                } catch (java.lang.Exception e3) {
                    try {
                        com.uc.crashsdk.a.g.a(e3);
                        fileChannel = null;
                    } catch (java.lang.Exception e4) {
                        fileChannel = null;
                        e = e4;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(fileChannel);
                        return z2;
                    }
                }
                if (fileChannel != null) {
                    try {
                        lock = fileChannel.lock();
                    } catch (java.lang.Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (java.lang.Exception e6) {
                            e = e6;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel);
                            return z2;
                        }
                    }
                }
                try {
                    z2 = eVar.a();
                    com.uc.crashsdk.a.g.a(fileChannel);
                } finally {
                    if (lock != null) {
                        try {
                            lock.release();
                        } catch (java.lang.Exception e7) {
                            com.uc.crashsdk.a.g.a(e7);
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        return z2;
    }

    private static boolean a(java.lang.String str, com.uc.crashsdk.e.d dVar) {
        java.lang.String a2 = com.uc.crashsdk.a.g.a(new java.io.File(str), 64, false);
        if (a2 == null) {
            return false;
        }
        try {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a2);
            if (matcher.find()) {
                long parseLong = java.lang.Long.parseLong(matcher.group(1));
                if (java.lang.System.currentTimeMillis() - parseLong < 86400000) {
                    dVar.b = java.lang.Long.parseLong(matcher.group(2));
                    dVar.c = java.lang.Integer.parseInt(matcher.group(3));
                    dVar.d = java.lang.Integer.parseInt(matcher.group(4));
                    dVar.a = parseLong;
                }
            }
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    public static boolean a(java.lang.String str, java.lang.String str2, boolean z2) {
        if (!o(str2)) {
            return false;
        }
        com.uc.crashsdk.a.h.a(str, str2, true, z2);
        com.uc.crashsdk.a.a.b(java.lang.String.format(java.util.Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static boolean a(java.lang.StringBuffer stringBuffer, java.lang.String str, long j2, java.util.ArrayList<java.lang.String> arrayList, java.util.ArrayList<java.lang.String> arrayList2, java.util.ArrayList<java.lang.String> arrayList3, java.lang.String str2) {
        long j3;
        boolean z2;
        boolean a2;
        if (c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = ag || com.uc.crashsdk.b.L();
        if (!z3 && !com.uc.crashsdk.a.d.e()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!d(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        }
        if (aa()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        java.lang.String str3 = com.uc.crashsdk.g.Y() + k(str);
        ?? r11 = (j2 & 32) != 0 ? 1 : 0;
        if (z3) {
            long nativeClientCreateConnection = com.uc.crashsdk.b.d ? com.uc.crashsdk.JNIBridge.nativeClientCreateConnection(str3, "custom", str, r11) : 0L;
            if (nativeClientCreateConnection == 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str);
                return false;
            }
            j3 = nativeClientCreateConnection;
        } else {
            if (a(h(), str, (boolean) r11)) {
                return false;
            }
            com.uc.crashsdk.g.a();
            a(false);
            j3 = 0;
        }
        synchronized (q) {
            z2 = r11;
            a2 = a(str3, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
        }
        if (a2 && !z3) {
            b(h(), str, z2);
        }
        if (j3 != 0) {
            com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(j3);
        }
        if (!a2) {
            return false;
        }
        if (!z3) {
            r(str3);
        }
        if (!z3) {
            str3 = a(m(str3));
        }
        b(str3, str);
        if (!z2 || z3) {
            return true;
        }
        try {
            a(true, false);
            return true;
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!d) {
            if (com.uc.crashsdk.b.d) {
                com.uc.crashsdk.JNIBridge.set(1, true);
            }
            d = true;
        }
        try {
            java.lang.String k2 = k();
            if (com.uc.crashsdk.a.g.a(k2)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            if (com.uc.crashsdk.a.f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new java.lang.Object[]{k2, java.lang.Boolean.valueOf(z3), java.lang.Boolean.valueOf(z2)})) && z2) {
                o.close();
                if (!r6.block(3000L)) {
                    com.uc.crashsdk.a.a.a("crashsdk", "timeout to wait for uploading");
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    private static boolean aa() {
        return com.uc.crashsdk.b.d && com.uc.crashsdk.JNIBridge.nativeIsCrashing();
    }

    private static void ab() {
        java.lang.String Z2 = com.uc.crashsdk.g.Z();
        java.io.File file = new java.io.File(Z2);
        if (file.isDirectory()) {
            try {
                java.io.File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    java.util.Arrays.sort(listFiles, new com.uc.crashsdk.e.b((byte) 0));
                    int length = listFiles.length - 150;
                    int i2 = length < 0 ? 0 : length;
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i3 < listFiles.length) {
                        java.io.File file2 = listFiles[i3];
                        boolean z2 = i3 < i2;
                        if (!z2 && currentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        try {
                            file2.delete();
                            i4++;
                            i5 = 0;
                        } catch (java.lang.Throwable th) {
                            i5++;
                            com.uc.crashsdk.a.g.a(th);
                        }
                        if (i5 >= 3) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i4 + " logs in " + Z2);
                }
            } catch (java.lang.Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    public static int b(java.io.OutputStream outputStream, java.lang.String str, int i2) {
        int i3;
        java.io.DataInputStream dataInputStream;
        int i4;
        java.io.DataInputStream dataInputStream2 = null;
        int i5 = 0;
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                byte[] R2 = R();
                if (R2 == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    return 0;
                }
                dataInputStream = new java.io.DataInputStream(new java.io.FileInputStream(file));
                i4 = 0;
                i3 = 0;
                loop0: while (true) {
                    boolean z2 = false;
                    while (true) {
                        try {
                            int read = dataInputStream.read(R2);
                            if (read == -1) {
                                break loop0;
                            }
                            i4 += read;
                            int i6 = i2 - i3;
                            if (read <= i6 + 32) {
                                i6 = read;
                            }
                            if (i6 > 0 && !z2) {
                                outputStream.write(R2, 0, i6);
                                i3 += i6;
                            }
                            if (!z2) {
                                if (i6 < read || i3 >= i2) {
                                    z2 = true;
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            i5 = i3;
                            dataInputStream2 = dataInputStream;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                                i3 = i5;
                                a(outputStream);
                                return i3;
                            } finally {
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i4 = 0;
                i3 = 0;
            }
            if (i3 > 0) {
                outputStream.write("\n".getBytes("UTF-8"));
            }
            if (i3 < i4) {
                outputStream.write(java.lang.String.format(java.util.Locale.US, "(truncated %d bytes)\n", java.lang.Integer.valueOf(i4 - i3)).getBytes("UTF-8"));
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i3;
    }

    public static long b() {
        if (g == -1) {
            g = h(com.uc.crashsdk.b.b("local"));
        }
        return g;
    }

    private static java.lang.String b(java.lang.String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = m(str);
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (!z3) {
            return str;
        }
        try {
            return a(str);
        } catch (java.lang.Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return str;
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_LIST_SIZE_CODE), i2 * 1000);
    }

    public static void b(android.content.Context context) {
        if (com.uc.crashsdk.g.N()) {
            try {
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    private static void b(com.uc.crashsdk.e.a aVar) {
        h = false;
        try {
            aVar.write((s("LOG_END") + "\n").getBytes("UTF-8"));
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    private static void b(java.io.OutputStream outputStream) {
        java.io.BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
        } finally {
        }
        try {
            if (com.uc.crashsdk.g.o() <= 0) {
                try {
                    outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                } catch (java.lang.Throwable th) {
                    a(th, outputStream);
                }
                a(outputStream);
                return;
            }
            int o2 = com.uc.crashsdk.g.o();
            bufferedReader = a(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec(new java.lang.String[]{"logcat", "-d", "-b", "events", "-b", "main", "-v", "threadtime", "-t", java.lang.String.valueOf(o2)}).getInputStream()));
            if (bufferedReader == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                } catch (java.lang.Throwable th2) {
                    a(th2, outputStream);
                }
                a(outputStream);
                return;
            }
            h = false;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    i2++;
                    if (i3 < o2 && !readLine.contains(" I auditd ") && !readLine.contains(" I liblog ")) {
                        outputStream.write(readLine.getBytes("UTF-8"));
                        outputStream.write("\n".getBytes("UTF-8"));
                        i3++;
                    }
                } else {
                    try {
                        break;
                    } catch (java.lang.Throwable th3) {
                        a(th3, outputStream);
                    }
                }
            }
            outputStream.write(java.lang.String.format(java.util.Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)).getBytes("UTF-8"));
            h = true;
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
            return;
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
            return;
        } finally {
        }
    }

    private static void b(java.io.OutputStream outputStream, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (java.lang.Throwable th) {
            a(th, outputStream);
        }
        try {
            java.util.Locale locale = java.util.Locale.US;
            outputStream.write(java.lang.String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()), n()).getBytes("UTF-8"));
            java.lang.Object[] objArr = new java.lang.Object[3];
            objArr[0] = e();
            if (com.uc.crashsdk.a.g.a(l)) {
                T();
            }
            objArr[1] = l;
            objArr[2] = f();
            outputStream.write(java.lang.String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (java.lang.Throwable th2) {
            a(th2, outputStream);
        }
        try {
            java.util.Locale locale2 = java.util.Locale.US;
            outputStream.write(java.lang.String.format(locale2, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", android.os.Build.MODEL, android.os.Build.VERSION.RELEASE, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + android.os.Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            java.lang.Object[] objArr2 = new java.lang.Object[4];
            objArr2[0] = a(new java.util.Date(b));
            objArr2[1] = java.lang.Long.valueOf(java.lang.Runtime.getRuntime().maxMemory());
            objArr2[2] = com.uc.crashsdk.a.g.d();
            objArr2[3] = com.uc.crashsdk.b.B() ? "fg" : "bg";
            outputStream.write(java.lang.String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (java.lang.Throwable th3) {
            a(th3, outputStream);
        }
        try {
            java.util.Locale locale3 = java.util.Locale.US;
            outputStream.write(java.lang.String.format(locale3, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", com.uc.crashsdk.g.U(), com.uc.crashsdk.g.V(), com.uc.crashsdk.g.W(), java.lang.Integer.valueOf(com.uc.crashsdk.a.c())).getBytes("UTF-8"));
            java.lang.String str4 = "0";
            java.lang.String str5 = "";
            if (com.uc.crashsdk.b.d) {
                java.lang.String nativeGet = com.uc.crashsdk.JNIBridge.nativeGet(1, 0L, null);
                str3 = com.uc.crashsdk.JNIBridge.nativeGet(2, 0L, null);
                str4 = nativeGet;
            } else {
                str3 = "";
            }
            outputStream.write(java.lang.String.format(locale3, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.3.2.2", str4, "240515102041", str3, "umeng").getBytes("UTF-8"));
            if (str != null) {
                str5 = str;
            }
            outputStream.write(("Report Name: " + str5.substring(str5.lastIndexOf(47) + 1) + "\n").getBytes("UTF-8"));
        } catch (java.lang.Throwable th4) {
            a(th4, outputStream);
        }
        try {
            outputStream.write(java.lang.String.format("UUID: %s\n", ag ? s("UUID") : B).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (java.lang.Throwable th5) {
            a(th5, outputStream);
        }
        try {
            java.lang.String E2 = com.uc.crashsdk.b.E();
            if (com.uc.crashsdk.a.g.a(E2)) {
                E2 = "(none)";
            }
            outputStream.write(("Activity: " + E2 + "\n").getBytes("UTF-8"));
        } catch (java.lang.Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (ag) {
                h = false;
                outputStream.write(s("HEADER").getBytes("UTF-8"));
                h = true;
            }
        } catch (java.lang.Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    public static void b(java.lang.String str) {
        synchronized (y) {
            x = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + "\n");
        }
    }

    private static void b(java.lang.String str, java.lang.String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b(java.lang.String str, java.lang.String str2, boolean z2) {
        com.uc.crashsdk.a.h.a(str, str2, false, z2);
    }

    public static void b(boolean z2) {
        try {
            boolean z3 = com.uc.crashsdk.g.s() && com.uc.crashsdk.b.F() && !d;
            if (!z3) {
                z3 = com.uc.crashsdk.g.t();
            }
            if (z3) {
                if (!z2) {
                    a(true, false);
                    return;
                }
                java.lang.String k2 = k();
                if (com.uc.crashsdk.a.g.a(k2)) {
                    return;
                }
                j();
                a(k2, false, false);
            }
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean b(int i2, java.lang.Object[] objArr) {
        if (i2 == 451) {
            if (a || objArr != null) {
                return a((java.lang.String) objArr[0], (com.uc.crashsdk.e.d) objArr[1]);
            }
            throw new java.lang.AssertionError();
        }
        if (i2 != 452) {
            if (a) {
                return false;
            }
            throw new java.lang.AssertionError();
        }
        if (!a && objArr == null) {
            throw new java.lang.AssertionError();
        }
        java.lang.String str = (java.lang.String) objArr[0];
        com.uc.crashsdk.e.d dVar = (com.uc.crashsdk.e.d) objArr[1];
        return com.uc.crashsdk.a.g.a(new java.io.File(str), java.lang.String.format(java.util.Locale.US, "%d %d %d %d", java.lang.Long.valueOf(dVar.a), java.lang.Long.valueOf(dVar.b), java.lang.Integer.valueOf(dVar.c), java.lang.Integer.valueOf(dVar.d)).getBytes());
    }

    private static boolean b(java.io.File file) {
        int indexOf;
        java.lang.String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf <= 0 || (indexOf = name.indexOf(46, lastIndexOf)) <= 0) {
            return false;
        }
        java.lang.String substring = name.substring(lastIndexOf + 1, indexOf);
        return com.uc.crashsdk.export.LogType.JAVA_TYPE.equals(substring) || "ucebujava".equals(substring) || com.uc.crashsdk.export.LogType.NATIVE_TYPE.equals(substring) || "ucebujni".equals(substring) || com.uc.crashsdk.export.LogType.UNEXP_TYPE.equals(substring) || com.uc.crashsdk.export.LogType.ANR_TYPE.equals(substring);
    }

    public static void c() {
        i = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(java.io.OutputStream outputStream) {
        int i2;
        if (com.uc.crashsdk.b.d) {
            java.lang.String o2 = com.uc.crashsdk.b.o();
            h = false;
            if (1 == com.uc.crashsdk.JNIBridge.cmd(17, o2)) {
                java.io.File file = new java.io.File(o2);
                try {
                    byte[] e = com.uc.crashsdk.a.g.e(file);
                    if (e != null) {
                        outputStream.write(e);
                    }
                } catch (java.lang.Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (java.lang.Throwable th2) {
                    a(th2, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        java.io.File[] fileArr = null;
        try {
            i2 = com.uc.crashsdk.g.K();
            try {
                fileArr = new java.io.File("/proc/self/fd").listFiles();
                if (fileArr != null) {
                    outputStream.write(java.lang.String.format(java.util.Locale.US, "opened file count: %d, write limit: %d.\n", java.lang.Integer.valueOf(fileArr.length), java.lang.Integer.valueOf(i2)).getBytes("UTF-8"));
                } else {
                    outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                a(th, outputStream);
                if (fileArr != null) {
                }
                a(outputStream);
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            i2 = 900;
        }
        if (fileArr != null) {
            try {
                if (fileArr.length >= i2) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    try {
                        for (java.io.File file2 : fileArr) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append("\n");
                        }
                    } catch (java.lang.Throwable th5) {
                        a(th5, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (java.lang.Throwable th6) {
                a(th6, outputStream);
            }
        }
        a(outputStream);
    }

    public static void c(java.lang.String str) {
        synchronized (z) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.l(), str + "\n");
        }
    }

    public static void c(boolean z2) {
        boolean z3 = true;
        if (!R ? !z2 || !com.uc.crashsdk.g.N() : z2 && com.uc.crashsdk.g.N()) {
            z3 = false;
        }
        if (z3) {
            com.uc.crashsdk.a.e eVar = S;
            if (com.uc.crashsdk.a.f.b(eVar)) {
                com.uc.crashsdk.a.f.a(eVar);
            }
            com.uc.crashsdk.a.f.a(0, eVar, 3000L);
        }
    }

    public static java.lang.String d() {
        java.lang.String str = i;
        if (str != null) {
            return str;
        }
        java.lang.String j2 = j(null);
        i = j2;
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(java.io.OutputStream outputStream) {
        int i2;
        int i3;
        java.io.File[] fileArr = null;
        try {
            i2 = com.uc.crashsdk.g.L();
            try {
                fileArr = new java.io.File("/proc/self/task").listFiles();
            } catch (java.lang.Throwable th) {
                th = th;
                com.uc.crashsdk.a.g.a(th);
                i3 = 0;
                if (fileArr != null) {
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            i2 = 300;
        }
        if (fileArr == null) {
            return;
        }
        i3 = fileArr.length;
        if (i3 < i2) {
            return;
        }
        if (fileArr != null) {
            return;
        }
        try {
            outputStream.write("threads info:\n".getBytes("UTF-8"));
            outputStream.write(java.lang.String.format(java.util.Locale.US, "threads count: %d, dump limit: %d.\n", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2)).getBytes("UTF-8"));
            outputStream.write(" tid     name\n".getBytes("UTF-8"));
            for (java.io.File file : fileArr) {
                outputStream.write(java.lang.String.format(java.util.Locale.US, "%5s %s\n", file.getName(), l(com.uc.crashsdk.a.g.a(new java.io.File(file.getPath(), "comm"), 128, false))).getBytes("UTF-8"));
            }
        } catch (java.lang.Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static void d(boolean z2) {
        com.uc.crashsdk.f.d(false);
        if (z2) {
            com.uc.crashsdk.f.a(com.uc.crashsdk.b.c(), false);
            com.uc.crashsdk.a.h.i();
        } else {
            com.uc.crashsdk.f.a();
            com.uc.crashsdk.a.h.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(android.content.Context context) {
        java.util.List<android.app.ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        boolean z2 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int myPid = android.os.Process.myPid();
        java.util.Iterator<android.app.ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            android.app.ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == myPid) {
                O = true;
                if (O()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (com.uc.crashsdk.b.d) {
                    com.uc.crashsdk.JNIBridge.set(130, next.longMsg);
                }
                z2 = true;
            }
        }
        if (!z2 && com.uc.crashsdk.b.d) {
            W();
        }
        return true;
    }

    public static boolean d(java.lang.String str) {
        if (ag) {
            return true;
        }
        try {
            return p(str);
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static int e(boolean z2) {
        return com.uc.crashsdk.f.a(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7 A[Catch: all -> 0x00cb, TRY_LEAVE, TryCatch #5 {all -> 0x00cb, blocks: (B:43:0x0092, B:45:0x00a7), top: B:42:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d8 A[Catch: all -> 0x013b, TryCatch #4 {all -> 0x013b, blocks: (B:50:0x00d2, B:52:0x00d8, B:54:0x00e0, B:55:0x0106, B:57:0x010c, B:59:0x0114), top: B:49:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010c A[Catch: all -> 0x013b, TryCatch #4 {all -> 0x013b, blocks: (B:50:0x00d2, B:52:0x00d8, B:54:0x00e0, B:55:0x0106, B:57:0x010c, B:59:0x0114), top: B:49:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String e() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.reflect.Method declaredMethod;
        java.lang.String str3;
        java.lang.String str4;
        boolean z2;
        if (!com.uc.crashsdk.a.g.a(j)) {
            return j;
        }
        java.lang.String str5 = null;
        try {
            java.lang.reflect.Field declaredField = android.os.Build.class.getDeclaredField("SUPPORTED_ABIS");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(null);
            if (obj != null && (obj instanceof java.lang.String[])) {
                java.lang.String[] strArr = (java.lang.String[]) obj;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                int length = strArr.length;
                int i2 = 0;
                boolean z3 = true;
                while (i2 < length) {
                    java.lang.String str6 = strArr[i2];
                    if (!z3) {
                        sb.append(",");
                    }
                    sb.append(str6);
                    i2++;
                    z3 = false;
                }
                j = sb.toString();
            }
        } catch (java.lang.Throwable unused) {
        }
        if (com.uc.crashsdk.a.g.a(j)) {
            try {
                str3 = android.os.Build.CPU_ABI;
            } catch (java.lang.Throwable unused2) {
                str3 = null;
            }
            try {
                str4 = android.os.Build.CPU_ABI2;
            } catch (java.lang.Throwable unused3) {
                str4 = null;
                z2 = !com.uc.crashsdk.a.g.a(str3);
                if (z2) {
                }
                if (!com.uc.crashsdk.a.g.a(str4)) {
                }
                declaredMethod = java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class);
                if (declaredMethod != null) {
                }
            }
            z2 = !com.uc.crashsdk.a.g.a(str3);
            if (z2) {
                j = str3;
            }
            if (!com.uc.crashsdk.a.g.a(str4)) {
                if (z2) {
                    j += ",";
                    j += str4;
                } else {
                    j = str4;
                }
            }
        }
        try {
            declaredMethod = java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class);
        } catch (java.lang.Throwable th) {
            th = th;
            str = null;
        }
        if (declaredMethod != null) {
            str2 = null;
            if (!com.uc.crashsdk.a.g.a(str5)) {
                j += ",";
                j += str5;
            }
            if (!com.uc.crashsdk.a.g.a(str2)) {
                j += ",";
                j += str2;
            }
            return j;
        }
        declaredMethod.setAccessible(true);
        str = (java.lang.String) declaredMethod.invoke(null, "ro.product.cpu.abi", null);
        try {
            str2 = (java.lang.String) declaredMethod.invoke(null, "ro.product.cpu.abi2", null);
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.uc.crashsdk.a.g.a(th);
            str2 = null;
            str5 = str;
            if (!com.uc.crashsdk.a.g.a(str5)) {
            }
            if (!com.uc.crashsdk.a.g.a(str2)) {
            }
            return j;
        }
        str5 = str;
        try {
            if (!com.uc.crashsdk.a.g.a(str5) && !j.contains(str5)) {
                j += ",";
                j += str5;
            }
            if (!com.uc.crashsdk.a.g.a(str2) && !j.contains(str2)) {
                j += ",";
                j += str2;
            }
        } catch (java.lang.Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void e(java.io.OutputStream outputStream) {
        java.io.BufferedReader bufferedReader;
        int indexOf;
        boolean z2;
        if (com.uc.crashsdk.b.d) {
            try {
                outputStream.write("solib build id:\n".getBytes("UTF-8"));
            } catch (java.lang.Throwable th) {
                a(th, outputStream);
            }
            java.io.FileReader fileReader = null;
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.io.FileReader fileReader2 = new java.io.FileReader(new java.io.File("/proc/self/maps"));
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader2, 512);
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.endsWith(".so") && (indexOf = readLine.indexOf(47)) != -1) {
                                java.lang.String substring = readLine.substring(indexOf);
                                if (!substring.contains("/data/") && !substring.contains(com.uc.crashsdk.a.a)) {
                                    z2 = false;
                                    if (z2 && !arrayList.contains(substring)) {
                                        arrayList.add(substring);
                                        if (ag) {
                                            outputStream.write(java.lang.String.format(java.util.Locale.US, "%s: %s\n", substring, com.uc.crashsdk.JNIBridge.nativeGet(3, 0L, substring)).getBytes("UTF-8"));
                                        } else {
                                            try {
                                                outputStream.write((java.lang.String.format("$^%s`%s^$", "SOBUILDID", substring) + "\n").getBytes("UTF-8"));
                                            } catch (java.lang.Throwable th2) {
                                                a(th2, outputStream);
                                            }
                                        }
                                    }
                                }
                                z2 = true;
                                if (z2) {
                                    arrayList.add(substring);
                                    if (ag) {
                                    }
                                }
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            fileReader = fileReader2;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                a(outputStream);
                            } catch (java.lang.Throwable th4) {
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                throw th4;
                            }
                        }
                    }
                    com.uc.crashsdk.a.g.a(fileReader2);
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
        }
    }

    public static boolean e(java.lang.String str) {
        try {
            if (!com.uc.crashsdk.a.g.b(str) || !str.startsWith("lib") || !str.endsWith(".so")) {
                return false;
            }
            java.lang.System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static int f(boolean z2) {
        int b2 = z2 ? com.uc.crashsdk.f.a(com.uc.crashsdk.b.c()) ? 1 : 0 : com.uc.crashsdk.f.b();
        int b3 = com.uc.crashsdk.f.b(z2);
        return b3 > b2 ? b3 : b2;
    }

    public static java.lang.String f() {
        if (com.uc.crashsdk.a.g.a(k)) {
            T();
        }
        return k;
    }

    public static java.lang.StringBuilder f(java.lang.String str) {
        return a(java.lang.Thread.currentThread().getStackTrace(), str);
    }

    private static void f(java.io.OutputStream outputStream) {
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (java.lang.Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(java.lang.String.format(java.util.Locale.US, "last version: '%s'\n", ag ? s("LASTVER") : com.uc.crashsdk.a.m()).getBytes("UTF-8"));
        } catch (java.lang.Throwable th2) {
            a(th2, outputStream);
        }
        try {
            java.util.ArrayList<java.lang.String> arrayList = f441s;
            synchronized (arrayList) {
                if (u != null) {
                    outputStream.write(java.lang.String.format(java.util.Locale.US, "generating log: %s\n", u).getBytes("UTF-8"));
                }
                if (t > 0 || arrayList.size() > 0) {
                    outputStream.write(java.lang.String.format(java.util.Locale.US, "generated %d logs, recent are:\n", java.lang.Integer.valueOf(t)).getBytes("UTF-8"));
                    java.util.Iterator<java.lang.String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(java.lang.String.format(java.util.Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            java.util.Locale locale = java.util.Locale.US;
            outputStream.write(java.lang.String.format(locale, "dumping all threads: %s\n", java.lang.Boolean.valueOf(v)).getBytes("UTF-8"));
            java.lang.String str = w;
            if (str != null) {
                outputStream.write(java.lang.String.format(locale, "dumping threads: %s\n", str).getBytes("UTF-8"));
            }
        } catch (java.lang.Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static java.lang.String g() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(java.lang.Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(java.lang.Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(java.lang.Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(android.os.Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(android.os.Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(android.os.Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            try {
                android.app.ActivityManager activityManager = (android.app.ActivityManager) com.uc.crashsdk.a.g.a().getSystemService("activity");
                if (activityManager != null) {
                    android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / 1024);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / 1024);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append("\n");
                }
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return sb.toString();
        } catch (java.lang.Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return "";
        }
    }

    private static long h(java.lang.String str) {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", java.lang.String.class, java.lang.Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((java.lang.Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return 0L;
    }

    public static java.lang.String h() {
        java.lang.String str = m;
        if (str != null) {
            return str;
        }
        java.lang.String a2 = a(android.os.Process.myPid());
        m = a2;
        return a2;
    }

    private static java.lang.String i(java.lang.String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        } catch (java.lang.Throwable unused) {
            return "unknown";
        }
    }

    public static boolean i() {
        return d;
    }

    private static java.lang.String j(java.lang.String str) {
        if (str == null) {
            str = java.lang.String.valueOf(java.lang.System.currentTimeMillis()) + new java.util.Random().nextInt(65536);
        }
        return java.lang.String.format(java.util.Locale.US, "%s%s_%s_%s_%s_%s_", P(), com.uc.crashsdk.g.U(), com.uc.crashsdk.g.W(), i(android.os.Build.MODEL), i(android.os.Build.VERSION.RELEASE), str);
    }

    public static void j() {
        try {
            android.os.StrictMode.setThreadPolicy(new android.os.StrictMode.ThreadPolicy.Builder(android.os.StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static java.lang.String k() {
        java.lang.String str = x;
        if (com.uc.crashsdk.a.g.a(str)) {
            synchronized (y) {
                str = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.i(), com.uc.crashsdk.g.z(), true);
                x = str;
            }
        }
        return str;
    }

    private static java.lang.String k(java.lang.String str) {
        return java.lang.String.format(java.util.Locale.US, "%s%s_%s_%s.log", d(), n(), Q(), str);
    }

    private static java.lang.String l(java.lang.String str) {
        if (!com.uc.crashsdk.a.g.b(str)) {
            return "";
        }
        int indexOf = str.indexOf(0);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    public static void l() {
        synchronized (y) {
            x = null;
        }
    }

    private static java.lang.String m(java.lang.String str) {
        java.lang.String a2 = com.uc.crashsdk.a.b.a(str, com.uc.crashsdk.g.x(), com.uc.crashsdk.g.w());
        if (!str.equals(a2)) {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a2;
    }

    public static void m() {
        if (ag) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_CODE), 1000L);
    }

    public static java.lang.String n() {
        return a(new java.util.Date());
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r7.endsWith(r3) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
    
        if (r7.indexOf(com.anythink.china.common.a.a.f, r7.lastIndexOf(95)) != r7.lastIndexOf(com.anythink.china.common.a.a.f)) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean[] n(java.lang.String str) {
        boolean w2 = com.uc.crashsdk.g.w();
        boolean y2 = com.uc.crashsdk.g.y();
        if (w2 || y2) {
            if (!str.endsWith(com.baidu.mobads.sdk.internal.al.k) && !str.contains(".ec")) {
                int lastIndexOf = str.lastIndexOf(java.io.File.separatorChar);
                if (lastIndexOf < 0) {
                    lastIndexOf = 0;
                }
                int i2 = 0;
                do {
                    lastIndexOf = str.indexOf(95, lastIndexOf);
                    if (lastIndexOf >= 0) {
                        i2++;
                        lastIndexOf++;
                    }
                } while (lastIndexOf >= 0);
                if (i2 == 8) {
                    java.lang.String x2 = com.uc.crashsdk.g.x();
                    if (str.endsWith(com.anythink.china.common.a.a.f)) {
                        if (!com.uc.crashsdk.a.g.a(x2)) {
                        }
                    } else if (!com.uc.crashsdk.a.g.a(x2)) {
                    }
                    w2 = false;
                }
            }
            w2 = false;
            y2 = false;
        }
        return new boolean[]{w2, y2};
    }

    public static void o() {
        b = java.lang.System.currentTimeMillis();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|4|(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|54|(0)|25|26|27|29|30|31|32) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|26|27|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dd, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e2, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e5, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ea, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ed, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae A[Catch: all -> 0x00ee, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x0033, B:7:0x0041, B:9:0x0047, B:11:0x0051, B:13:0x0056, B:49:0x0068, B:18:0x0078, B:22:0x0083, B:24:0x00ae, B:31:0x00d5, B:32:0x00e8, B:43:0x00ea, B:44:0x00ed, B:39:0x00e5, B:52:0x0072), top: B:3:0x0005, inners: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean o(java.lang.String str) {
        boolean z2;
        boolean z3;
        int parseInt;
        synchronized (r) {
            java.io.File file = new java.io.File(com.uc.crashsdk.g.X() + "customlog");
            java.lang.String a2 = com.uc.crashsdk.a.g.a(file, 1024, false);
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            try {
                if (a2 != null) {
                    stringBuffer.append(a2);
                    java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("([^\\n\\r\\t\\s]+) (\\d+) (\\d+)").matcher(stringBuffer);
                    for (int i2 = 0; matcher.find(i2); i2 = matcher.end()) {
                        if (str.equals(matcher.group(1))) {
                            long parseLong = java.lang.Long.parseLong(matcher.group(2));
                            if (currentTimeMillis - parseLong < 86400000) {
                                try {
                                    parseInt = java.lang.Integer.parseInt(matcher.group(3));
                                } catch (java.lang.Exception e) {
                                    com.uc.crashsdk.a.g.a(e);
                                }
                                int G2 = com.uc.crashsdk.g.G();
                                z3 = G2 < 0 && parseInt >= G2;
                                stringBuffer.replace(matcher.start(), matcher.end(), java.lang.String.format(java.util.Locale.US, "%s %d %d", str, java.lang.Long.valueOf(parseLong), java.lang.Integer.valueOf(parseInt + 1)));
                                z2 = true;
                                if (!z2) {
                                    stringBuffer.append(java.lang.String.format(java.util.Locale.US, "%s %d 1\n", str, java.lang.Long.valueOf(currentTimeMillis)));
                                }
                                java.io.FileWriter fileWriter = null;
                                java.io.FileWriter fileWriter2 = new java.io.FileWriter(file);
                                java.lang.String stringBuffer2 = stringBuffer.toString();
                                fileWriter2.write(stringBuffer2, 0, stringBuffer2.length());
                                com.uc.crashsdk.a.g.a(fileWriter2);
                            } else {
                                parseLong = currentTimeMillis;
                            }
                            parseInt = 0;
                            int G22 = com.uc.crashsdk.g.G();
                            if (G22 < 0) {
                            }
                            stringBuffer.replace(matcher.start(), matcher.end(), java.lang.String.format(java.util.Locale.US, "%s %d %d", str, java.lang.Long.valueOf(parseLong), java.lang.Integer.valueOf(parseInt + 1)));
                            z2 = true;
                            if (!z2) {
                            }
                            java.io.FileWriter fileWriter3 = null;
                            java.io.FileWriter fileWriter22 = new java.io.FileWriter(file);
                            java.lang.String stringBuffer22 = stringBuffer.toString();
                            fileWriter22.write(stringBuffer22, 0, stringBuffer22.length());
                            com.uc.crashsdk.a.g.a(fileWriter22);
                        }
                    }
                }
                java.io.FileWriter fileWriter222 = new java.io.FileWriter(file);
                java.lang.String stringBuffer222 = stringBuffer.toString();
                fileWriter222.write(stringBuffer222, 0, stringBuffer222.length());
                com.uc.crashsdk.a.g.a(fileWriter222);
            } catch (java.lang.Throwable th) {
                th = th;
            }
            z2 = false;
            z3 = false;
            if (!z2) {
            }
            java.io.FileWriter fileWriter32 = null;
        }
        return z3;
    }

    public static void p() {
        java.lang.String str;
        java.lang.Throwable th;
        if (com.uc.crashsdk.a.g.a(B)) {
            java.lang.String str2 = null;
            try {
                java.io.File file = new java.io.File(com.uc.crashsdk.g.X() + "unique");
                if (file.exists()) {
                    str = com.uc.crashsdk.a.g.a(file, 48, false);
                    try {
                        if (str != null) {
                            try {
                                if (str.length() == 36) {
                                    str2 = str.replaceAll("[^0-9a-zA-Z-]", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                }
                            } catch (java.lang.Exception e) {
                                com.uc.crashsdk.a.g.a(e);
                            }
                        }
                        str2 = str;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        com.uc.crashsdk.a.g.a(th);
                        str2 = str;
                        B = str2;
                    }
                }
                if (com.uc.crashsdk.a.g.a(str2)) {
                    com.uc.crashsdk.b.G();
                    str2 = java.util.UUID.randomUUID().toString();
                    if (!com.uc.crashsdk.a.g.a(str2)) {
                        com.uc.crashsdk.a.g.a(file, str2.getBytes());
                    }
                }
            } catch (java.lang.Throwable th3) {
                str = str2;
                th = th3;
            }
            B = str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ae A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d4, B:23:0x00ef, B:24:0x00df, B:38:0x00fc, B:41:0x0106, B:45:0x0033, B:47:0x003b, B:48:0x0044, B:50:0x004c, B:52:0x0054, B:54:0x005c, B:59:0x006a, B:61:0x0074, B:63:0x0081, B:65:0x008b, B:66:0x0096, B:68:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a0 A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d4, B:23:0x00ef, B:24:0x00df, B:38:0x00fc, B:41:0x0106, B:45:0x0033, B:47:0x003b, B:48:0x0044, B:50:0x004c, B:52:0x0054, B:54:0x005c, B:59:0x006a, B:61:0x0074, B:63:0x0081, B:65:0x008b, B:66:0x0096, B:68:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean p(java.lang.String str) {
        boolean z2;
        boolean z3;
        int i2;
        java.lang.Integer num;
        synchronized (z) {
            z2 = false;
            if (A == null) {
                A = q(com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.l(), "all:1", false));
            }
            if (A.containsKey("all")) {
                num = A.get("all");
            } else if (A.containsKey(str)) {
                num = A.get(str);
            } else {
                if (!com.uc.crashsdk.export.LogType.JAVA_TYPE.equals(str) && !com.uc.crashsdk.export.LogType.NATIVE_TYPE.equals(str) && !com.uc.crashsdk.export.LogType.ANR_TYPE.equals(str) && !com.uc.crashsdk.export.LogType.UNEXP_TYPE.equals(str)) {
                    z3 = false;
                    if (!z3 && A.containsKey(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.EVENT_ID_CRASH)) {
                        num = A.get(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.EVENT_ID_CRASH);
                    } else if (z3 && A.containsKey("nocrash")) {
                        num = A.get("nocrash");
                    } else if (A.containsKey("other")) {
                        i2 = 1;
                        if (i2 != 0) {
                            long j2 = i2;
                            if (j2 < 0) {
                                long j3 = j2 == -2 ? 7L : j2 == -3 ? 15L : j2 == -4 ? 60L : 30L;
                                long b2 = com.uc.crashsdk.a.b();
                                long currentTimeMillis = b2 == 0 ? -1L : (java.lang.System.currentTimeMillis() - b2) / 86400000;
                                j2 = currentTimeMillis <= j3 ? 1L : currentTimeMillis - j3;
                            }
                            if (j2 != 1) {
                                if (j2 > 0) {
                                    if (java.lang.System.currentTimeMillis() % j2 == 0) {
                                    }
                                }
                            }
                            z2 = true;
                        }
                    } else {
                        num = A.get("other");
                    }
                }
                z3 = true;
                if (!z3) {
                }
                if (z3) {
                }
                if (A.containsKey("other")) {
                }
            }
            i2 = num.intValue();
            if (i2 != 0) {
            }
        }
        return z2;
    }

    public static java.lang.String q() {
        return B;
    }

    private static java.util.Map<java.lang.String, java.lang.Integer> q(java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.lang.String str2 : str.split("\\|", 30)) {
            java.lang.String[] split = str2.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, 3);
            if (split.length == 2) {
                java.lang.String trim = split[0].trim();
                if (!com.uc.crashsdk.a.g.a(trim)) {
                    int i2 = 1;
                    try {
                        i2 = java.lang.Integer.parseInt(split[1].trim(), 10);
                    } catch (java.lang.Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    hashMap.put(trim, java.lang.Integer.valueOf(i2));
                }
            }
        }
        return hashMap;
    }

    public static void r() {
        O = false;
        if (!com.uc.crashsdk.b.B()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (V()) {
            return;
        }
        N = 0;
        X();
    }

    private static void r(java.lang.String str) {
        if (com.uc.crashsdk.g.r()) {
            try {
                ab();
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                java.io.File file = new java.io.File(com.uc.crashsdk.g.Z());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new java.io.File(str), file);
            } catch (java.lang.Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static java.lang.String s(java.lang.String str) {
        return java.lang.String.format("$^%s^$", str);
    }

    public static void s() {
        T = java.lang.Thread.getDefaultUncaughtExceptionHandler();
        java.lang.Thread.setDefaultUncaughtExceptionHandler(new com.uc.crashsdk.e());
    }

    public static void t() {
        java.lang.Thread.setDefaultUncaughtExceptionHandler(T);
    }

    public static boolean u() {
        return c.get() || aa();
    }

    public static java.lang.Throwable v() {
        return U;
    }

    public static int w() {
        if (com.uc.crashsdk.b.I() == 5) {
            return Z;
        }
        return 100;
    }

    public static void x() {
        long p2 = com.uc.crashsdk.g.p();
        if (p2 < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.I() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(401));
        if (z2) {
            com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(402);
            X = eVar;
            com.uc.crashsdk.a.f.a(0, eVar, p2);
        }
    }

    public static void y() {
        if (com.uc.crashsdk.b.c && com.uc.crashsdk.a.c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean z() {
        synchronized (Y) {
            java.lang.Runnable runnable = X;
            if (runnable == null || W) {
                return false;
            }
            com.uc.crashsdk.a.f.a(runnable);
            X = null;
            return true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(1:216)|(3:251|252|(15:255|256|257|(1:221)|222|223|224|225|(1:227)|228|(1:232)|233|(1:236)|238|(1:244)(2:242|243)))|218|(1:221)|222|223|224|225|(0)|228|(2:230|232)|233|(1:236)|238|(2:240|244)(1:245)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:345|(3:380|381|(15:384|385|386|(1:350)|351|352|353|354|(1:356)|357|(1:361)|362|(1:365)|367|(1:373)(2:371|372)))|347|(1:350)|351|352|353|354|(0)|357|(2:359|361)|362|(1:365)|367|(2:369|373)(1:374)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:396|(3:431|432|(15:435|436|437|(1:401)|402|403|404|405|(1:407)|408|(1:412)|413|(1:416)|418|(1:424)(2:422|423)))|398|(1:401)|402|403|404|405|(0)|408|(2:410|412)|413|(1:416)|418|(2:420|424)(1:425)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:82|(3:117|118|(15:121|122|123|(1:87)|88|89|90|91|(1:93)|94|(1:98)|99|(1:102)|104|(1:110)(2:108|109)))|84|(1:87)|88|89|90|91|(0)|94|(2:96|98)|99|(1:102)|104|(2:106|110)(1:111)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:11|(4:13|(6:16|17|18|19|(1:21)(1:23)|14)|28|22)|(3:64|65|(15:68|69|70|(1:33)|34|35|36|37|(1:39)|40|(1:44)|45|(1:48)|50|(1:57)(2:54|55)))|30|(1:33)|34|35|36|37|(0)|40|(2:42|44)|45|(1:48)|50|(2:52|57)(1:58)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:159|(1:163)|(3:198|199|(15:202|203|204|(1:168)|169|170|171|172|(1:174)|175|(1:179)|180|(1:183)|185|(1:191)(2:189|190)))|165|(1:168)|169|170|171|172|(0)|175|(2:177|179)|180|(1:183)|185|(2:187|191)(1:192)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:515|516|(2:518|(1:520))|(3:555|556|(16:559|560|561|562|(1:525)|526|527|528|529|(0)|532|(2:534|536)|537|(1:540)|542|(0)(0)))|522|(0)|526|527|528|529|(0)|532|(0)|537|(0)|542|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:456|457|(1:459)|461|(1:465)|(3:500|501|(16:504|505|506|507|(1:470)|471|472|473|474|(1:476)|477|(1:481)|482|(1:485)|487|(1:493)(2:491|492)))|467|(1:470)|471|472|473|474|(0)|477|(2:479|481)|482|(1:485)|487|(2:489|493)(1:494)) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x013e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x013f, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0106, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0107, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03b7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03b8, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x037f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0380, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0438, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0439, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0400, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0401, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0292, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0293, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x025a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x025b, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x0313, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x0314, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x02db, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x02dc, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x05f2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x05f3, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x05ba, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x05bb, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b8, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x007f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0080, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0134 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0376 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03a0 A[Catch: all -> 0x03b7, TryCatch #17 {all -> 0x03b7, blocks: (B:172:0x0384, B:175:0x038f, B:177:0x03a0, B:179:0x03a4, B:180:0x03a7, B:183:0x03af), top: B:171:0x0384 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0421 A[Catch: all -> 0x0438, TryCatch #19 {all -> 0x0438, blocks: (B:225:0x0405, B:228:0x0410, B:230:0x0421, B:232:0x0425, B:233:0x0428, B:236:0x0430), top: B:224:0x0405 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x042e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:245:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0482 A[Catch: all -> 0x0556, TryCatch #40 {all -> 0x0556, blocks: (B:265:0x0452, B:268:0x0464, B:270:0x046a, B:272:0x0482, B:273:0x0485, B:276:0x04b3, B:280:0x04b0, B:159:0x034a, B:275:0x04aa), top: B:150:0x0203, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04fa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0524 A[Catch: all -> 0x053b, TryCatch #22 {all -> 0x053b, blocks: (B:294:0x0508, B:297:0x0513, B:299:0x0524, B:301:0x0528, B:302:0x052b, B:305:0x0533), top: B:293:0x0508 }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0531 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:314:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x04de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0251 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x027b A[Catch: all -> 0x0292, TryCatch #36 {all -> 0x0292, blocks: (B:354:0x025f, B:357:0x026a, B:359:0x027b, B:361:0x027f, B:362:0x0282, B:365:0x028a), top: B:353:0x025f }] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0288 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:374:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x02d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:407:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x02fc A[Catch: all -> 0x0313, TryCatch #37 {all -> 0x0313, blocks: (B:405:0x02e0, B:408:0x02eb, B:410:0x02fc, B:412:0x0300, B:413:0x0303, B:416:0x030b), top: B:404:0x02e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0309 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:420:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:425:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[Catch: all -> 0x00b7, TryCatch #18 {all -> 0x00b7, blocks: (B:37:0x0084, B:40:0x008f, B:42:0x00a0, B:44:0x00a4, B:45:0x00a7, B:48:0x00af), top: B:36:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:469:0x05b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x05db A[Catch: all -> 0x05f2, TryCatch #15 {all -> 0x05f2, blocks: (B:474:0x05bf, B:477:0x05ca, B:479:0x05db, B:481:0x05df, B:482:0x05e2, B:485:0x05ea), top: B:473:0x05bf }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:484:0x05e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:489:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:494:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:524:0x0638 A[ADDED_TO_REGION, DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0650 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0662 A[Catch: all -> 0x0679, DONT_GENERATE, FINALLY_INSNS, TryCatch #20 {all -> 0x0679, blocks: (B:529:0x0646, B:532:0x0651, B:534:0x0662, B:536:0x0666, B:537:0x0669, B:540:0x0671), top: B:528:0x0646 }] */
    /* JADX WARN: Removed duplicated region for block: B:539:0x066f A[ADDED_TO_REGION, DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0686 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:549:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0127 A[Catch: all -> 0x013e, TryCatch #23 {all -> 0x013e, blocks: (B:91:0x010b, B:94:0x0116, B:96:0x0127, B:98:0x012b, B:99:0x012e, B:102:0x0136), top: B:90:0x010b }] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:434:0x0218 -> B:329:0x0220). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:437:0x021d -> B:329:0x0220). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(java.lang.Thread thread, java.lang.Throwable th, boolean z2) {
        boolean z3;
        ?? r12;
        java.lang.Throwable th2;
        boolean z4;
        boolean i2;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        boolean z5;
        java.lang.String str;
        boolean z6;
        boolean i3;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        boolean z7;
        boolean i4;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler3;
        java.lang.Throwable th3;
        boolean z8;
        boolean i5;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler4;
        java.io.File file;
        boolean z9;
        boolean i6;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler5;
        boolean z10;
        boolean i7;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler6;
        boolean z11;
        boolean i8;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler7;
        boolean z12;
        boolean i9;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler8;
        boolean z13 = (ag && com.uc.crashsdk.b.d) || com.uc.crashsdk.b.L();
        try {
            r12 = 4;
            if (c.getAndSet(true) && android.os.Process.myPid() > 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "another thread is generating java report!");
                com.uc.crashsdk.a.a.d("DEBUG", "current thread exception is:");
                a(th);
                if (com.uc.crashsdk.g.j()) {
                    int i10 = 0;
                    while (!V) {
                        try {
                            java.lang.Thread.sleep(1000L);
                        } catch (java.lang.Throwable th4) {
                            com.uc.crashsdk.a.g.a(th4);
                        }
                        i10++;
                        if (i10 >= 4) {
                            break;
                        }
                    }
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
                if (z2) {
                    try {
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        z12 = false;
                    }
                    if (com.uc.crashsdk.g.s() && !z13) {
                        try {
                            a(true, false);
                            z12 = true;
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            z12 = true;
                            com.uc.crashsdk.a.g.a(th);
                            if (!z12) {
                            }
                            com.uc.crashsdk.f.c(false);
                            i9 = com.uc.crashsdk.g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i9);
                            if (i9) {
                            }
                            if (com.uc.crashsdk.b.B()) {
                            }
                            V = true;
                            if (android.os.Process.myPid() <= 0) {
                            }
                        }
                        if (!z12 && !z13) {
                            b(false);
                        }
                        com.uc.crashsdk.f.c(false);
                        i9 = com.uc.crashsdk.g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                            i9 = true;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i9);
                        if (i9 && (uncaughtExceptionHandler8 = T) != null) {
                            uncaughtExceptionHandler8.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B() && !z13) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (android.os.Process.myPid() <= 0 || !com.uc.crashsdk.g.j()) {
                            return;
                        }
                        android.os.Process.killProcess(android.os.Process.myPid());
                        return;
                    }
                }
                z12 = false;
                if (!z12) {
                    b(false);
                }
                com.uc.crashsdk.f.c(false);
                i9 = com.uc.crashsdk.g.i();
                if (!com.uc.crashsdk.a.d.e()) {
                }
                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i9);
                if (i9) {
                    uncaughtExceptionHandler8.uncaughtException(thread, th);
                }
                if (com.uc.crashsdk.b.B()) {
                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                }
                V = true;
                if (android.os.Process.myPid() <= 0) {
                    return;
                } else {
                    return;
                }
            }
            U = th;
            if (!z13 && !com.uc.crashsdk.a.d.e()) {
                com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                if (z2) {
                    try {
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        z11 = false;
                    }
                    if (com.uc.crashsdk.g.s() && !z13) {
                        try {
                            a(true, false);
                            z11 = true;
                        } catch (java.lang.Throwable th8) {
                            th = th8;
                            z11 = true;
                            com.uc.crashsdk.a.g.a(th);
                            if (!z11) {
                            }
                            com.uc.crashsdk.f.c(false);
                            i8 = com.uc.crashsdk.g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i8);
                            if (i8) {
                            }
                            if (com.uc.crashsdk.b.B()) {
                            }
                            V = true;
                            if (android.os.Process.myPid() <= 0) {
                            }
                        }
                        if (!z11 && !z13) {
                            b(false);
                        }
                        com.uc.crashsdk.f.c(false);
                        i8 = com.uc.crashsdk.g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                            i8 = true;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i8);
                        if (i8 && (uncaughtExceptionHandler7 = T) != null) {
                            uncaughtExceptionHandler7.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B() && !z13) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (android.os.Process.myPid() <= 0 || !com.uc.crashsdk.g.j()) {
                            return;
                        }
                        android.os.Process.killProcess(android.os.Process.myPid());
                        return;
                    }
                }
                z11 = false;
                if (!z11) {
                    b(false);
                }
                com.uc.crashsdk.f.c(false);
                i8 = com.uc.crashsdk.g.i();
                if (!com.uc.crashsdk.a.d.e()) {
                }
                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i8);
                if (i8) {
                    uncaughtExceptionHandler7.uncaughtException(thread, th);
                }
                if (com.uc.crashsdk.b.B()) {
                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                }
                V = true;
                if (android.os.Process.myPid() <= 0) {
                    return;
                } else {
                    return;
                }
            }
            com.uc.crashsdk.a.a.d("DEBUG", "encryptLog: " + com.uc.crashsdk.g.y() + ", zipCrashLog: " + com.uc.crashsdk.g.y());
            if (com.uc.crashsdk.g.a != null) {
                com.uc.crashsdk.a.a.d("DEBUG", "the set zip log to false stack is:");
                com.uc.crashsdk.g.a.printStackTrace();
            }
            if (com.uc.crashsdk.g.b != null) {
                com.uc.crashsdk.a.a.d("DEBUG", "the set encrypt to true stack is:");
                com.uc.crashsdk.g.b.printStackTrace();
            }
            com.uc.crashsdk.a.a.d("DEBUG", "begin to generate java report");
            try {
                N();
            } catch (java.lang.Throwable th9) {
                com.uc.crashsdk.a.g.a(th9);
            }
            try {
                z5 = com.uc.crashsdk.g.u();
                try {
                    java.lang.String g2 = com.uc.crashsdk.g.g();
                    if (g2 == null || g2.equals("")) {
                        g2 = k(S());
                    }
                    str = com.uc.crashsdk.g.Y() + g2;
                    z3 = false;
                } catch (java.lang.Throwable th10) {
                    th = th10;
                    com.uc.crashsdk.a.a.d("DEBUG", "get java log name failed: " + th);
                    a(th);
                    com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                    a(th);
                    str = null;
                    z3 = true;
                    try {
                        if (z13) {
                        }
                        boolean z14 = th instanceof java.lang.OutOfMemoryError;
                        a(th, str, r12, z14);
                        com.uc.crashsdk.a.a.d("DEBUG", "generate java report finished");
                        if (!com.uc.crashsdk.b.L()) {
                            java.lang.String name = new java.io.File(str).getName();
                            java.lang.String Z2 = com.uc.crashsdk.g.Z();
                            file = new java.io.File(Z2);
                            if (!file.exists()) {
                            }
                            java.lang.String format = java.lang.String.format(java.util.Locale.US, "%s%s.hprof", Z2, name);
                            com.uc.crashsdk.a.a.d("DEBUG", "begin dump hprof: " + format);
                            long currentTimeMillis = java.lang.System.currentTimeMillis();
                            try {
                                android.os.Debug.dumpHprofData(format);
                            } catch (java.lang.Throwable th11) {
                                com.uc.crashsdk.a.g.a(th11);
                            }
                            com.uc.crashsdk.a.a.d("DEBUG", "end dump hprof, use " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
                        }
                        if (r12 != 0) {
                            com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(r12);
                        }
                        if (z2) {
                        }
                        z8 = false;
                        if (!z8) {
                        }
                        try {
                            com.uc.crashsdk.f.c(false);
                        } catch (java.lang.Throwable th12) {
                            com.uc.crashsdk.a.g.a(th12);
                        }
                        try {
                            i5 = com.uc.crashsdk.g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i5);
                            if (i5) {
                            }
                            if (com.uc.crashsdk.b.B()) {
                            }
                        } catch (java.lang.Throwable th13) {
                            com.uc.crashsdk.a.g.a(th13);
                        }
                        V = true;
                        if (android.os.Process.myPid() > 0) {
                        }
                    } catch (java.lang.Throwable th14) {
                        th = th14;
                    }
                }
            } catch (java.lang.Throwable th15) {
                th = th15;
                z5 = false;
            }
            try {
                if (z13) {
                    try {
                        com.uc.crashsdk.g.a();
                        try {
                            if (com.uc.crashsdk.b.B()) {
                                com.uc.crashsdk.f.a(3);
                            } else {
                                com.uc.crashsdk.f.a(4);
                            }
                        } catch (java.lang.Throwable th16) {
                            com.uc.crashsdk.a.g.a(th16);
                        }
                    } catch (java.lang.Throwable th17) {
                        com.uc.crashsdk.a.g.a(th17);
                    }
                    try {
                        new java.io.File(com.uc.crashsdk.b.b()).createNewFile();
                    } catch (java.lang.Throwable th18) {
                        com.uc.crashsdk.a.g.a(th18);
                    }
                    if (z5) {
                        com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                        if (z2) {
                            try {
                            } catch (java.lang.Throwable th19) {
                                th = th19;
                                z7 = false;
                            }
                            if (com.uc.crashsdk.g.s() && !z13) {
                                try {
                                    a(true, false);
                                    z7 = true;
                                } catch (java.lang.Throwable th20) {
                                    th = th20;
                                    z7 = true;
                                    com.uc.crashsdk.a.g.a(th);
                                    if (!z7) {
                                    }
                                    com.uc.crashsdk.f.c(false);
                                    i4 = com.uc.crashsdk.g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i4);
                                    if (i4) {
                                    }
                                    if (com.uc.crashsdk.b.B()) {
                                    }
                                    V = true;
                                    if (android.os.Process.myPid() <= 0) {
                                    }
                                }
                                if (!z7 && !z13) {
                                    b(false);
                                }
                                com.uc.crashsdk.f.c(false);
                                i4 = com.uc.crashsdk.g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i4 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i4);
                                if (i4 && (uncaughtExceptionHandler3 = T) != null) {
                                    uncaughtExceptionHandler3.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z13) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                                V = true;
                                if (android.os.Process.myPid() <= 0 || !com.uc.crashsdk.g.j()) {
                                    return;
                                }
                                android.os.Process.killProcess(android.os.Process.myPid());
                                return;
                            }
                        }
                        z7 = false;
                        if (!z7) {
                            b(false);
                        }
                        com.uc.crashsdk.f.c(false);
                        i4 = com.uc.crashsdk.g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i4);
                        if (i4) {
                            uncaughtExceptionHandler3.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B()) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (android.os.Process.myPid() <= 0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (!d(com.uc.crashsdk.export.LogType.JAVA_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "java log sample miss");
                        if (z2) {
                            try {
                            } catch (java.lang.Throwable th21) {
                                th = th21;
                                z6 = false;
                            }
                            if (com.uc.crashsdk.g.s() && !z13) {
                                try {
                                    a(true, false);
                                    z6 = true;
                                } catch (java.lang.Throwable th22) {
                                    th = th22;
                                    z6 = true;
                                    com.uc.crashsdk.a.g.a(th);
                                    if (!z6) {
                                    }
                                    com.uc.crashsdk.f.c(false);
                                    i3 = com.uc.crashsdk.g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i3);
                                    if (i3) {
                                    }
                                    if (com.uc.crashsdk.b.B()) {
                                    }
                                    V = true;
                                    if (android.os.Process.myPid() <= 0) {
                                    }
                                }
                                if (!z6 && !z13) {
                                    b(false);
                                }
                                com.uc.crashsdk.f.c(false);
                                i3 = com.uc.crashsdk.g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i3 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i3);
                                if (i3 && (uncaughtExceptionHandler2 = T) != null) {
                                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z13) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                                V = true;
                                if (android.os.Process.myPid() <= 0 || !com.uc.crashsdk.g.j()) {
                                    return;
                                }
                                android.os.Process.killProcess(android.os.Process.myPid());
                                return;
                            }
                        }
                        z6 = false;
                        if (!z6) {
                            b(false);
                        }
                        com.uc.crashsdk.f.c(false);
                        i3 = com.uc.crashsdk.g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i3);
                        if (i3) {
                            uncaughtExceptionHandler2.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B()) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (android.os.Process.myPid() <= 0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    r12 = 0;
                } else {
                    if (z5) {
                        str = "omit";
                        com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                    }
                    long nativeClientCreateConnection = com.uc.crashsdk.b.d ? com.uc.crashsdk.JNIBridge.nativeClientCreateConnection(str, com.uc.crashsdk.export.LogType.JAVA_TYPE, null, 0) : 0L;
                    r12 = nativeClientCreateConnection;
                    if (nativeClientCreateConnection == 0) {
                        com.uc.crashsdk.a.a.d("DEBUG", "skip java crash:");
                        a(th);
                        if (nativeClientCreateConnection != 0 && com.uc.crashsdk.b.d) {
                            com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(nativeClientCreateConnection);
                        }
                        if (z2) {
                            try {
                            } catch (java.lang.Throwable th23) {
                                th = th23;
                                z10 = false;
                            }
                            if (com.uc.crashsdk.g.s() && !z13) {
                                try {
                                    a(true, false);
                                    z10 = true;
                                } catch (java.lang.Throwable th24) {
                                    th = th24;
                                    z10 = true;
                                    com.uc.crashsdk.a.g.a(th);
                                    if (!z10) {
                                    }
                                    com.uc.crashsdk.f.c(false);
                                    i7 = com.uc.crashsdk.g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i7);
                                    if (i7) {
                                    }
                                    if (com.uc.crashsdk.b.B()) {
                                    }
                                    V = true;
                                    if (android.os.Process.myPid() <= 0) {
                                    }
                                }
                                if (!z10 && !z13) {
                                    b(false);
                                }
                                com.uc.crashsdk.f.c(false);
                                i7 = com.uc.crashsdk.g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i7 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i7);
                                if (i7 && (uncaughtExceptionHandler6 = T) != null) {
                                    uncaughtExceptionHandler6.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z13) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                                V = true;
                                if (android.os.Process.myPid() <= 0 || !com.uc.crashsdk.g.j()) {
                                    return;
                                }
                                android.os.Process.killProcess(android.os.Process.myPid());
                                return;
                            }
                        }
                        z10 = false;
                        if (!z10) {
                            b(false);
                        }
                        com.uc.crashsdk.f.c(false);
                        i7 = com.uc.crashsdk.g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i7);
                        if (i7) {
                            uncaughtExceptionHandler6.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B()) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (android.os.Process.myPid() <= 0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (z5) {
                        if (nativeClientCreateConnection != 0 && com.uc.crashsdk.b.d) {
                            com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(nativeClientCreateConnection);
                        }
                        if (z2) {
                            try {
                            } catch (java.lang.Throwable th25) {
                                th = th25;
                                z9 = false;
                            }
                            if (com.uc.crashsdk.g.s() && !z13) {
                                try {
                                    a(true, false);
                                    z9 = true;
                                } catch (java.lang.Throwable th26) {
                                    th = th26;
                                    z9 = true;
                                    com.uc.crashsdk.a.g.a(th);
                                    if (!z9) {
                                    }
                                    com.uc.crashsdk.f.c(false);
                                    i6 = com.uc.crashsdk.g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i6);
                                    if (i6) {
                                    }
                                    if (com.uc.crashsdk.b.B()) {
                                    }
                                    V = true;
                                    if (android.os.Process.myPid() <= 0) {
                                    }
                                }
                                if (!z9 && !z13) {
                                    b(false);
                                }
                                com.uc.crashsdk.f.c(false);
                                i6 = com.uc.crashsdk.g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i6 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i6);
                                if (i6 && (uncaughtExceptionHandler5 = T) != null) {
                                    uncaughtExceptionHandler5.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z13) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                                V = true;
                                if (android.os.Process.myPid() <= 0 || !com.uc.crashsdk.g.j()) {
                                    return;
                                }
                                android.os.Process.killProcess(android.os.Process.myPid());
                                return;
                            }
                        }
                        z9 = false;
                        if (!z9) {
                            b(false);
                        }
                        com.uc.crashsdk.f.c(false);
                        i6 = com.uc.crashsdk.g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i6);
                        if (i6) {
                            uncaughtExceptionHandler5.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B()) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (android.os.Process.myPid() <= 0) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                boolean z142 = th instanceof java.lang.OutOfMemoryError;
                a(th, str, r12, z142);
                com.uc.crashsdk.a.a.d("DEBUG", "generate java report finished");
                if (!com.uc.crashsdk.b.L() && z142 && com.uc.crashsdk.g.k()) {
                    java.lang.String name2 = new java.io.File(str).getName();
                    java.lang.String Z22 = com.uc.crashsdk.g.Z();
                    file = new java.io.File(Z22);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    java.lang.String format2 = java.lang.String.format(java.util.Locale.US, "%s%s.hprof", Z22, name2);
                    com.uc.crashsdk.a.a.d("DEBUG", "begin dump hprof: " + format2);
                    long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                    android.os.Debug.dumpHprofData(format2);
                    com.uc.crashsdk.a.a.d("DEBUG", "end dump hprof, use " + (java.lang.System.currentTimeMillis() - currentTimeMillis2) + " ms");
                }
                if (r12 != 0 && com.uc.crashsdk.b.d) {
                    com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(r12);
                }
                if (z2) {
                    try {
                    } catch (java.lang.Throwable th27) {
                        th3 = th27;
                        z8 = false;
                    }
                    if (com.uc.crashsdk.g.s() && !z13) {
                        try {
                            a(true, false);
                            z8 = true;
                        } catch (java.lang.Throwable th28) {
                            th3 = th28;
                            z8 = true;
                            com.uc.crashsdk.a.g.a(th3);
                            if (!z8) {
                            }
                            com.uc.crashsdk.f.c(false);
                            i5 = com.uc.crashsdk.g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i5);
                            if (i5) {
                            }
                            if (com.uc.crashsdk.b.B()) {
                            }
                            V = true;
                            if (android.os.Process.myPid() > 0) {
                            }
                        }
                        if (!z8 && !z13) {
                            b(false);
                        }
                        com.uc.crashsdk.f.c(false);
                        i5 = com.uc.crashsdk.g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                            i5 = true;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i5);
                        if (i5 && (uncaughtExceptionHandler4 = T) != null) {
                            uncaughtExceptionHandler4.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B() && !z13) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (android.os.Process.myPid() > 0 || !com.uc.crashsdk.g.j()) {
                            return;
                        }
                        android.os.Process.killProcess(android.os.Process.myPid());
                        return;
                    }
                }
                z8 = false;
                if (!z8) {
                    b(false);
                }
                com.uc.crashsdk.f.c(false);
                i5 = com.uc.crashsdk.g.i();
                if (!com.uc.crashsdk.a.d.e()) {
                }
                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i5);
                if (i5) {
                    uncaughtExceptionHandler4.uncaughtException(thread, th);
                }
                if (com.uc.crashsdk.b.B()) {
                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                }
                V = true;
                if (android.os.Process.myPid() > 0) {
                    return;
                } else {
                    return;
                }
            } catch (java.lang.Throwable th29) {
                th = th29;
            }
        } catch (java.lang.Throwable th30) {
            th = th30;
            z3 = false;
        }
        th = th30;
        z3 = false;
        r12 = 0;
        try {
            com.uc.crashsdk.a.a.d("DEBUG", "exception occurs while java log: " + th);
            a(th);
            if (!z3) {
                com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                a(th);
            }
            if (r12 != 0 && com.uc.crashsdk.b.d) {
                com.uc.crashsdk.JNIBridge.nativeClientCloseConnection(r12);
            }
            if (z2) {
                try {
                } catch (java.lang.Throwable th31) {
                    th2 = th31;
                    z4 = false;
                }
                if (com.uc.crashsdk.g.s() && !z13) {
                    try {
                        a(true, false);
                        z4 = true;
                    } catch (java.lang.Throwable th32) {
                        th2 = th32;
                        z4 = true;
                        com.uc.crashsdk.a.g.a(th2);
                        if (!z4) {
                        }
                        com.uc.crashsdk.f.c(false);
                        i2 = com.uc.crashsdk.g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i2);
                        if (i2) {
                        }
                        if (com.uc.crashsdk.b.B()) {
                        }
                        V = true;
                        if (android.os.Process.myPid() <= 0) {
                        }
                    }
                    if (!z4 && !z13) {
                        b(false);
                    }
                    com.uc.crashsdk.f.c(false);
                    i2 = com.uc.crashsdk.g.i();
                    if (!com.uc.crashsdk.a.d.e()) {
                        i2 = true;
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i2);
                    if (i2 && (uncaughtExceptionHandler = T) != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, th);
                    }
                    if (com.uc.crashsdk.b.B() && !z13) {
                        com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                    }
                    V = true;
                    if (android.os.Process.myPid() <= 0 || !com.uc.crashsdk.g.j()) {
                    }
                    android.os.Process.killProcess(android.os.Process.myPid());
                    return;
                }
            }
            z4 = false;
            if (!z4) {
                b(false);
            }
            com.uc.crashsdk.f.c(false);
            i2 = com.uc.crashsdk.g.i();
            if (!com.uc.crashsdk.a.d.e()) {
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i2);
            if (i2) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
            if (com.uc.crashsdk.b.B()) {
                com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
            }
            V = true;
            if (android.os.Process.myPid() <= 0) {
            }
        } finally {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        a(thread, th, false);
    }
}
