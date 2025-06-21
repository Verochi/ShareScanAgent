package com.uc.crashsdk;

/* loaded from: classes19.dex */
public class b {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static java.lang.String H = null;
    private static int I = 0;
    private static boolean J = false;
    private static boolean K = false;
    private static boolean L = true;
    private static java.io.RandomAccessFile M = null;
    private static boolean N = false;
    private static java.lang.String P = null;
    private static boolean Q = false;
    private static volatile java.lang.Object[] R = null;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    static final /* synthetic */ boolean i = true;
    private static java.lang.String j;
    private static java.lang.String k;
    private static java.lang.String l;
    private static java.lang.String m;
    private static java.lang.String n;
    private static java.lang.String o;
    private static java.lang.String p;
    private static java.lang.String q;
    private static java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private static java.lang.String f440s;
    private static java.lang.String t;
    private static java.lang.String u;
    private static java.lang.String v;
    private static java.lang.String w;
    private static boolean x;
    private static boolean y;
    private static volatile boolean z;
    public static final java.lang.Object e = new java.lang.Object();
    private static final java.lang.Object G = new java.lang.Object();
    private static final java.lang.Object O = new java.lang.Object();
    private static java.lang.Runnable S = new com.uc.crashsdk.a.e(101);
    private static boolean T = false;
    private static long U = 0;
    private static final java.lang.Object V = new java.lang.Object();
    private static long W = 0;
    private static boolean X = false;
    private static boolean Y = false;
    private static boolean Z = false;
    private static long aa = 0;
    private static final java.util.WeakHashMap<android.app.Activity, java.lang.Integer> ab = new java.util.WeakHashMap<>();
    private static boolean ac = false;
    private static java.lang.String ad = null;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static boolean ai = false;
    private static final java.lang.Object aj = new java.lang.Object();
    private static android.app.PendingIntent ak = null;

    public static boolean A() {
        return Y || !ad();
    }

    public static boolean B() {
        return Y && !x;
    }

    public static void C() {
        com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(100));
    }

    public static void D() {
        java.lang.String str;
        if (!d || (str = ad) == null) {
            return;
        }
        com.uc.crashsdk.JNIBridge.set(129, str);
    }

    public static java.lang.String E() {
        java.lang.String str = ad;
        return str == null ? "" : str;
    }

    public static boolean F() {
        if (!ae) {
            if (!com.uc.crashsdk.a.g.a(com.uc.crashsdk.a.a) && com.uc.crashsdk.a.a.equals(com.uc.crashsdk.e.h())) {
                af = true;
                if (d) {
                    com.uc.crashsdk.JNIBridge.set(2, true);
                }
            }
            ae = true;
        }
        return af;
    }

    public static void G() {
        ag = true;
        if (d) {
            com.uc.crashsdk.JNIBridge.set(34, true);
        }
    }

    public static boolean H() {
        return ag;
    }

    public static int I() {
        boolean U2 = U();
        return t() ? U2 ? 3 : 6 : s() ? U2 ? 2 : 5 : U2 ? 4 : 1;
    }

    public static int J() {
        boolean V2 = V();
        boolean W2 = W();
        boolean X2 = X();
        if (t()) {
            if (V2) {
                return 12;
            }
            if (W2) {
                return 14;
            }
            return X2 ? 16 : 98;
        }
        if (!s()) {
            return 1;
        }
        if (V2) {
            return 11;
        }
        if (W2) {
            return 13;
        }
        return X2 ? 15 : 97;
    }

    public static void K() {
        if (d) {
            com.uc.crashsdk.JNIBridge.nativeSet(27, I, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, null);
            com.uc.crashsdk.JNIBridge.set(30, L);
        }
    }

    public static boolean L() {
        if (!ai) {
            synchronized (aj) {
                if (!ai) {
                    ah = ae();
                    ai = true;
                }
            }
        }
        return ah;
    }

    public static void M() {
        if (com.uc.crashsdk.e.F() || L() || ak != null || com.uc.crashsdk.g.h() < 0) {
            return;
        }
        try {
            android.content.Context a2 = com.uc.crashsdk.a.g.a();
            android.content.Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(a2.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetActivity(a2, 0, launchIntentForPackage, 0);
            android.app.PendingIntent activity = android.app.PendingIntent.getActivity(a2, 0, launchIntentForPackage, 0);
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetActivity(activity, a2, 0, launchIntentForPackage, 0);
            ak = activity;
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean N() {
        if (ak == null) {
            com.uc.crashsdk.a.a.b("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.a.a("crashsdk", "restarting ...");
            ((android.app.AlarmManager) com.uc.crashsdk.a.g.a().getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM)).set(1, java.lang.System.currentTimeMillis() + 200, ak);
            return true;
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static /* synthetic */ boolean O() {
        ac = true;
        return true;
    }

    private static java.lang.String Q() {
        if (j == null) {
            j = d("ss");
        }
        return j;
    }

    private static java.lang.String R() {
        if (l == null) {
            l = d("ctn");
        }
        return l;
    }

    private static java.lang.String S() {
        if (m == null) {
            m = d(com.anythink.basead.b.a.C0131a.k);
        }
        return m;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:13|(9:17|18|(1:24)|25|26|(1:28)|30|31|32)|35|18|(2:20|24)|25|26|(0)|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #0 {all -> 0x0075, blocks: (B:26:0x006b, B:28:0x0071), top: B:25:0x006b, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void T() {
        boolean z2;
        if (z || y) {
            return;
        }
        synchronized (G) {
            if (z) {
                return;
            }
            f(com.uc.crashsdk.g.X());
            java.lang.String p2 = p();
            java.io.File file = new java.io.File(b());
            java.io.File file2 = new java.io.File(R());
            A = "f".equals(p2);
            B = "b".equals(p2);
            D = file.exists();
            boolean exists = file2.exists();
            E = exists;
            if (!D && !exists) {
                z2 = false;
                C = z2;
                if (!z2 && (A || B)) {
                    boolean r2 = r();
                    F = r2;
                    C = r2;
                }
                if (z()) {
                    Z();
                }
                z = true;
            }
            z2 = true;
            C = z2;
            if (!z2) {
                boolean r22 = r();
                F = r22;
                C = r22;
            }
            if (z()) {
            }
            z = true;
        }
    }

    private static boolean U() {
        T();
        return C;
    }

    private static boolean V() {
        T();
        return D;
    }

    private static boolean W() {
        T();
        return E;
    }

    private static boolean X() {
        T();
        return F;
    }

    private static void Y() {
        if (d) {
            com.uc.crashsdk.JNIBridge.set(26, x);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0041 -> B:13:0x0044). Please report as a decompilation issue!!! */
    private static void Z() {
        if (!T) {
            T = true;
            try {
                new java.io.File(b()).delete();
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            try {
                new java.io.File(R()).delete();
            } catch (java.lang.Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            try {
                if (d) {
                    com.uc.crashsdk.JNIBridge.cmd(16);
                } else {
                    new java.io.File(S()).delete();
                }
            } catch (java.lang.Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
        }
        java.lang.Object[] ab2 = ab();
        if (!ab2[0].equals(P) && R == null) {
            a(ab2);
        } else {
            Q = true;
            aa();
        }
    }

    private static java.lang.Object a(java.lang.Object obj, java.lang.Class<?> cls, java.lang.String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            java.lang.reflect.Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    public static java.lang.String a() {
        java.lang.String str = H;
        if (str != null) {
            return str;
        }
        java.lang.String h2 = com.uc.crashsdk.e.h();
        if (com.uc.crashsdk.a.g.a(h2)) {
            H = "LLUN";
        } else {
            int i2 = 0;
            if (h2.length() > 48) {
                int length = h2.length() - 48;
                h2 = h2.substring(0, 48);
                i2 = length;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            byte[] bytes = h2.getBytes();
            for (int length2 = bytes.length - 1; length2 >= 0; length2--) {
                byte b2 = bytes[length2];
                if (b2 == 46) {
                    sb.append('0');
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) ((b2 + 65) - 97));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 < 48 || b2 > 57) {
                    sb.append('2');
                } else {
                    sb.append((char) b2);
                }
            }
            if (i2 > 0) {
                sb.append(java.lang.String.valueOf(i2));
            }
            H = sb.toString();
        }
        return H;
    }

    public static java.lang.String a(java.lang.String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".st");
        if (!i && lastIndexOf < 0) {
            throw new java.lang.AssertionError();
        }
        java.lang.String substring = str.substring(0, lastIndexOf);
        if (substring.length() <= 0) {
            return null;
        }
        return substring + ".stcb";
    }

    public static void a(int i2) {
        java.lang.Object a2;
        android.app.Activity activity;
        int i3;
        boolean z2 = false;
        boolean z3 = true;
        switch (i2) {
            case 100:
                java.lang.Object ac2 = ac();
                if (ac2 == null || (a2 = a(ac2, (java.lang.Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    java.util.Iterator it = ((java.util.Map) a2).entrySet().iterator();
                    boolean z4 = false;
                    while (it.hasNext()) {
                        java.lang.Object value = ((java.util.Map.Entry) it.next()).getValue();
                        if (value != null && (activity = (android.app.Activity) a(value, (java.lang.Class<?>) null, "activity")) != null) {
                            boolean booleanValue = ((java.lang.Boolean) a(value, (java.lang.Class<?>) null, "paused")).booleanValue();
                            boolean booleanValue2 = ((java.lang.Boolean) a(value, (java.lang.Class<?>) null, "stopped")).booleanValue();
                            java.util.WeakHashMap<android.app.Activity, java.lang.Integer> weakHashMap = ab;
                            synchronized (weakHashMap) {
                                if (booleanValue || booleanValue2) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                    z4 = true;
                                }
                                weakHashMap.put(activity, java.lang.Integer.valueOf(i3));
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        b(z4);
                        return;
                    }
                    return;
                } catch (java.lang.Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 101:
                try {
                    if (new java.io.File(Q()).exists()) {
                        z3 = false;
                    }
                    N = z3;
                    if (z3 || Q) {
                        a(ab());
                        Q = false;
                        return;
                    }
                    return;
                } catch (java.lang.Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                    return;
                }
            case 102:
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(103));
                return;
            case 103:
                try {
                    com.uc.crashsdk.a.g.a(new java.io.File(S()));
                    return;
                } catch (java.lang.Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 104:
                com.uc.crashsdk.a.h.d();
                com.uc.crashsdk.f.a(102);
                if (F()) {
                    com.uc.crashsdk.e.C();
                    return;
                }
                return;
            default:
                if (!i) {
                    throw new java.lang.AssertionError();
                }
                return;
        }
    }

    public static void a(boolean z2) {
        L = z2;
        if (d) {
            com.uc.crashsdk.JNIBridge.set(30, z2);
        }
    }

    private static void a(java.lang.Object[] objArr) {
        R = objArr;
        synchronized (O) {
            java.lang.String str = (java.lang.String) objArr[0];
            long longValue = ((java.lang.Long) objArr[1]).longValue();
            if (longValue < U) {
                com.uc.crashsdk.a.a.c("crashsdk", java.lang.String.format(java.util.Locale.US, "Update state generation %d, last is: %d", java.lang.Long.valueOf(longValue), java.lang.Long.valueOf(U)));
                return;
            }
            U = longValue;
            java.lang.String Q2 = Q();
            if (d) {
                java.io.RandomAccessFile randomAccessFile = M;
                if (randomAccessFile != null) {
                    com.uc.crashsdk.a.g.a(randomAccessFile);
                    M = null;
                }
                boolean nativeChangeState = com.uc.crashsdk.JNIBridge.nativeChangeState(Q2, str, N);
                N = false;
                if (!nativeChangeState) {
                    com.uc.crashsdk.a.a.b("write state failed: " + str);
                }
            } else {
                java.io.RandomAccessFile randomAccessFile2 = M;
                if (randomAccessFile2 == null || N) {
                    if (randomAccessFile2 != null) {
                        com.uc.crashsdk.a.g.a(randomAccessFile2);
                        M = null;
                    }
                    try {
                        java.io.RandomAccessFile randomAccessFile3 = new java.io.RandomAccessFile(Q2, "rw");
                        M = randomAccessFile3;
                        randomAccessFile3.seek(0L);
                        N = false;
                    } catch (java.lang.Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
                try {
                    M.write(str.getBytes());
                    M.seek(0L);
                } catch (java.lang.Exception e3) {
                    com.uc.crashsdk.a.g.a(e3);
                }
            }
            P = str;
            R = null;
        }
    }

    public static boolean a(android.content.Context context) {
        try {
            ((android.app.Application) context).registerActivityLifecycleCallbacks(new com.uc.crashsdk.c());
            if (!com.uc.crashsdk.g.M()) {
                return true;
            }
            C();
            return true;
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static boolean a(java.lang.Object obj, java.lang.String str, com.uc.crashsdk.a.e eVar) {
        java.nio.channels.FileChannel fileChannel;
        boolean z2;
        synchronized (obj) {
            java.nio.channels.FileChannel fileChannel2 = null;
            r1 = null;
            java.nio.channels.FileLock lock = null;
            java.nio.channels.FileChannel fileChannel3 = null;
            boolean z3 = false;
            if (d) {
                int nativeOpenFile = com.uc.crashsdk.JNIBridge.nativeOpenFile(str);
                if (nativeOpenFile < 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                try {
                    boolean nativeLockFile = com.uc.crashsdk.JNIBridge.nativeLockFile(nativeOpenFile, true);
                    try {
                        z2 = eVar.a();
                        return z2;
                    } finally {
                        if (nativeLockFile) {
                            com.uc.crashsdk.JNIBridge.nativeLockFile(nativeOpenFile, false);
                        }
                    }
                } finally {
                    com.uc.crashsdk.JNIBridge.nativeCloseFile(nativeOpenFile);
                }
            }
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (java.lang.Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            try {
                try {
                    fileChannel = new java.io.RandomAccessFile(file, "rw").getChannel();
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.uc.crashsdk.a.g.a(fileChannel3);
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                try {
                    com.uc.crashsdk.a.g.a(e3);
                    fileChannel = null;
                } catch (java.lang.Exception e4) {
                    e = e4;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileChannel2);
                    z2 = z3;
                    return z2;
                }
            }
            if (fileChannel != null) {
                try {
                    try {
                        lock = fileChannel.lock();
                    } catch (java.lang.Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (java.lang.Exception e6) {
                            e = e6;
                            fileChannel2 = fileChannel;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel2);
                            z2 = z3;
                            return z2;
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    fileChannel3 = fileChannel;
                    th = th2;
                    com.uc.crashsdk.a.g.a(fileChannel3);
                    throw th;
                }
            }
            try {
                z3 = eVar.a();
                com.uc.crashsdk.a.g.a(fileChannel);
                z2 = z3;
                return z2;
            } finally {
                if (lock != null) {
                    try {
                        lock.release();
                    } catch (java.lang.Exception e7) {
                        com.uc.crashsdk.a.g.a(e7);
                    }
                }
            }
        }
    }

    private static void aa() {
        if (!com.uc.crashsdk.a.f.b(S)) {
            com.uc.crashsdk.a.f.a(1, S);
            return;
        }
        java.lang.Object[] objArr = R;
        if (objArr == null || !ab()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.f.a(S);
            com.uc.crashsdk.a.f.a(1, S);
        }
    }

    private static java.lang.Object[] ab() {
        synchronized (V) {
            long j2 = W + 1;
            W = j2;
            if (x) {
                return new java.lang.Object[]{"e", java.lang.Long.valueOf(j2)};
            }
            if (B()) {
                return new java.lang.Object[]{"f", java.lang.Long.valueOf(W)};
            }
            return new java.lang.Object[]{"b", java.lang.Long.valueOf(W)};
        }
    }

    private static java.lang.Object ac() {
        java.lang.Object a2;
        java.lang.Object a3 = a((android.app.Application) com.uc.crashsdk.a.g.a(), (java.lang.Class<?>) android.app.Application.class, "mLoadedApk");
        if (a3 != null && (a2 = a(a3, (java.lang.Class<?>) null, "mActivityThread")) != null) {
            return a2;
        }
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new java.lang.Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return null;
    }

    private static boolean ad() {
        java.lang.String a2 = com.uc.crashsdk.a.g.a(new java.io.File("/proc/self/cgroup"), 512, false);
        if (com.uc.crashsdk.a.g.a(a2)) {
            return false;
        }
        return a2.contains("/bg_non_interactive") || a2.contains("/background");
    }

    private static boolean ae() {
        try {
            java.lang.reflect.Method declaredMethod = android.os.Process.class.getDeclaredMethod("isIsolated", new java.lang.Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                java.lang.Object invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
                if (invoke != null && (invoke instanceof java.lang.Boolean)) {
                    return ((java.lang.Boolean) invoke).booleanValue();
                }
            }
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        int myUid = android.os.Process.myUid() % 100000;
        return myUid >= 99000 && myUid <= 99999;
    }

    public static java.lang.String b() {
        if (k == null) {
            k = d("ctj");
        }
        return k;
    }

    public static java.lang.String b(java.lang.String str) {
        return "debug.crs." + str;
    }

    public static void b(int i2) {
        I = i2;
        K();
    }

    public static void b(android.content.Context context) {
        long j2;
        boolean z2;
        com.uc.crashsdk.a.a.a("Restart APP");
        if (context == null) {
            return;
        }
        if (p == null) {
            p = d("rt");
        }
        java.io.File file = new java.io.File(p);
        try {
            j2 = java.lang.Long.parseLong(com.uc.crashsdk.a.g.d(file));
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            j2 = -1;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        if (com.uc.crashsdk.g.h() < 0 || (j2 > 0 && currentTimeMillis - j2 <= com.uc.crashsdk.g.h())) {
            z2 = false;
        } else {
            f(com.uc.crashsdk.g.X());
            com.uc.crashsdk.a.g.a(file, java.lang.String.valueOf(currentTimeMillis));
            z2 = true;
        }
        com.uc.crashsdk.a.a.a("lastTime: " + j2 + ", currentTime: " + currentTimeMillis + ", needRestart: " + z2);
        if (z2) {
            try {
                com.uc.crashsdk.d.a(true);
            } catch (java.lang.Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            N();
        }
    }

    public static void b(boolean z2) {
        if (com.uc.crashsdk.e.u()) {
            return;
        }
        if (z2 && x) {
            com.uc.crashsdk.g.P();
            x = false;
            Y();
        }
        boolean z3 = com.uc.crashsdk.e.F() || L();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (X && !Y && z2) {
            long j2 = aa;
            if (j2 != 0 && !z3 && currentTimeMillis - j2 > 1800000) {
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(104), 1000L);
            }
        }
        aa = currentTimeMillis;
        Y = z2;
        if (z2) {
            X = true;
        }
        if (d) {
            com.uc.crashsdk.JNIBridge.nativeSetForeground(z2);
        }
        if (x || z3) {
            return;
        }
        T();
        Z();
        if (z2) {
            com.uc.crashsdk.a.a(false);
            if (!Z) {
                com.uc.crashsdk.e.B();
                Z = true;
            }
        }
        if (!N) {
            aa();
        }
        com.uc.crashsdk.e.c(z2);
    }

    public static java.lang.String c() {
        if (n == null) {
            n = d("st");
        }
        return n;
    }

    public static boolean c(int i2) {
        return (i2 & I) != 0;
    }

    private static java.lang.String d(java.lang.String str) {
        return com.uc.crashsdk.g.X() + a() + "." + str;
    }

    public static java.io.File[] d() {
        return e(".st");
    }

    public static java.lang.String e() {
        if (o == null) {
            o = d("stcb");
        }
        return o;
    }

    private static java.io.File[] e(java.lang.String str) {
        if (!i && str.length() <= 0) {
            throw new java.lang.AssertionError();
        }
        java.io.File[] listFiles = new java.io.File(com.uc.crashsdk.g.X()).listFiles();
        if (listFiles == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.io.File file : listFiles) {
            if (file.getPath().endsWith(str)) {
                arrayList.add(file);
            }
        }
        return (java.io.File[]) arrayList.toArray(new java.io.File[arrayList.size()]);
    }

    private static boolean f(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    public static java.io.File[] f() {
        return e(".stcb");
    }

    public static java.lang.String g() {
        if (v == null) {
            v = d("bati");
        }
        return v;
    }

    public static java.lang.String h() {
        if (w == null) {
            w = d("hdr");
        }
        return w;
    }

    public static java.lang.String i() {
        if (q == null) {
            q = com.uc.crashsdk.g.X() + com.umeng.analytics.pro.f.R;
        }
        return q;
    }

    public static java.lang.String j() {
        if (r == null) {
            r = com.uc.crashsdk.g.X() + "authu";
        }
        return r;
    }

    public static java.lang.String k() {
        if (f440s == null) {
            f440s = com.uc.crashsdk.g.X() + "statu";
        }
        return f440s;
    }

    public static java.lang.String l() {
        if (t == null) {
            t = com.uc.crashsdk.g.X() + "poli";
        }
        return t;
    }

    public static java.lang.String m() {
        if (u == null) {
            u = com.uc.crashsdk.g.X() + "ver";
        }
        return u;
    }

    public static java.lang.String n() {
        return com.uc.crashsdk.g.X() + "bvu";
    }

    public static java.lang.String o() {
        return com.uc.crashsdk.g.X() + "fds";
    }

    public static java.lang.String p() {
        return com.uc.crashsdk.a.g.a(new java.io.File(Q()), 8, false);
    }

    public static boolean q() {
        return y;
    }

    public static boolean r() {
        if (!J) {
            if (d) {
                K = com.uc.crashsdk.JNIBridge.cmd(15) == 1;
            } else {
                K = new java.io.File(S()).exists();
            }
            J = true;
        }
        return K;
    }

    public static boolean s() {
        T();
        return A;
    }

    public static boolean t() {
        T();
        return B;
    }

    public static boolean u() {
        return x;
    }

    public static void v() {
        boolean z2;
        f(com.uc.crashsdk.g.X());
        y = true;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        java.lang.String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        java.lang.String[] strArr2 = {com.umeng.analytics.pro.f.R, "authu", "statu", "poli"};
        java.io.File[] listFiles = new java.io.File(com.uc.crashsdk.g.X()).listFiles();
        if (listFiles != null) {
            for (java.io.File file : listFiles) {
                java.lang.String name = file.getName();
                int i2 = 0;
                while (true) {
                    if (i2 >= 7) {
                        z2 = false;
                        break;
                    } else {
                        if (name.endsWith(strArr[i2])) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 4) {
                            break;
                        }
                        if (name.equals(strArr2[i3])) {
                            z2 = true;
                            break;
                        }
                        i3++;
                    }
                }
                if (z2) {
                    com.uc.crashsdk.a.a.a("crashsdk", "delete file: " + file.getPath());
                    com.uc.crashsdk.a.g.a(file);
                }
            }
        }
        Z();
    }

    public static void w() {
        if (x) {
            return;
        }
        x = true;
        if (L() || com.uc.crashsdk.e.u()) {
            return;
        }
        f(com.uc.crashsdk.g.X());
        Y();
        Z();
    }

    public static boolean x() {
        return f(com.uc.crashsdk.g.X());
    }

    public static boolean y() {
        return f(com.uc.crashsdk.g.Y());
    }

    public static boolean z() {
        return X || !ad();
    }
}
