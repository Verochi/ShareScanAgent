package com.igexin.push.core;

/* loaded from: classes23.dex */
public class e {
    public static java.lang.String A = null;
    public static java.lang.String B = null;
    public static java.lang.String C = null;
    public static java.lang.String D = null;
    public static java.lang.String E = null;
    public static java.lang.String F = null;
    public static java.lang.String G = null;
    public static java.lang.String H = null;
    public static java.lang.String I = null;
    public static java.lang.String K = null;
    public static java.lang.String L = null;
    public static java.lang.String M = null;
    public static java.lang.String Z = null;
    public static java.lang.String a = "";
    public static int aA = 0;
    public static byte[] aB = null;
    public static long aH = 0;
    private static final java.lang.String aN = "CoreRuntimeInfo";
    private static java.util.Map<java.lang.String, java.lang.Integer> aO = null;
    public static java.lang.String ac = null;
    public static byte[] ad = null;
    public static boolean ae = false;
    public static boolean af = false;
    public static boolean ag = false;
    public static java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> ah = null;
    public static java.util.Map<java.lang.String, java.lang.Integer> ai = null;
    public static java.util.Map<java.lang.String, java.util.HashSet<java.lang.String>> aj = null;
    public static java.util.Map<java.lang.String, java.lang.Integer> ak = null;
    public static java.util.HashMap<java.lang.String, java.lang.Long> al = null;
    public static java.lang.String an = null;
    public static long ao = 0;
    public static java.lang.String ap = null;
    public static java.lang.String aq = null;
    public static java.lang.String ar = null;
    public static java.lang.String as = null;
    public static java.lang.String at = null;
    public static java.lang.String au = null;
    public static long av = 0;
    public static long aw = 0;
    public static volatile long ax = 0;
    public static long ay = 0;
    public static boolean az = false;
    public static java.lang.String b = "";
    public static long c = 0;
    public static java.lang.String d = null;
    public static java.lang.String e = null;
    public static java.lang.String f = "";
    public static java.lang.String g = "";
    public static java.lang.String h = null;
    public static java.lang.String i = "";
    public static int j;
    public static int k;
    public static android.content.Context l;

    /* renamed from: s, reason: collision with root package name */
    public static volatile boolean f388s;
    public static volatile boolean u;
    public static volatile boolean v;
    public static java.util.concurrent.atomic.AtomicBoolean m = new java.util.concurrent.atomic.AtomicBoolean(false);
    public static boolean n = true;
    public static java.util.HashMap<java.lang.String, java.lang.ClassLoader> o = new java.util.HashMap<>();
    public static volatile boolean p = true;
    public static volatile boolean q = false;
    public static int r = 0;
    public static boolean t = true;
    public static java.util.concurrent.atomic.AtomicBoolean w = new java.util.concurrent.atomic.AtomicBoolean(true);
    public static int x = 0;
    public static int y = 0;
    public static long z = 0;
    public static int J = -1;
    public static java.lang.String N = "";
    public static long O = -1;
    public static long P = -1;
    public static long Q = 0;
    public static long R = 0;
    public static long S = 0;
    public static long T = 0;
    public static long U = 0;
    public static java.lang.String V = null;
    public static boolean W = false;
    public static long X = 0;
    public static long Y = 0;
    public static long aa = 0;
    public static int ab = 0;
    public static int am = 0;
    public static java.lang.String aC = null;
    public static int aD = com.anythink.expressad.d.a.b.ck;
    public static boolean aE = false;
    public static long aF = 7200000;
    public static long aG = 7200000;
    public static java.lang.String aI = "oppo r9";
    public static int aJ = 200;
    public static java.lang.String aK = "";
    public static java.lang.String aL = "";
    private static java.lang.String aP = "";
    public static boolean aM = false;

    private static int a(java.lang.String str, boolean z2) {
        int intValue;
        synchronized (com.igexin.push.core.e.class) {
            if (aO.get(str) == null) {
                aO.put(str, 0);
            }
            intValue = aO.get(str).intValue();
            if (z2) {
                intValue--;
                aO.put(str, java.lang.Integer.valueOf(intValue));
                if (intValue == 0) {
                    aO.remove(str);
                }
            }
        }
        return intValue;
    }

    public static java.lang.ClassLoader a(java.lang.String str) {
        java.lang.String str2 = str.split("_")[0];
        if (o.containsKey(str2)) {
            return o.get(str2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        int i2;
        boolean z2;
        com.igexin.push.core.ServiceManager.getInstance();
        java.lang.String d2 = com.igexin.push.core.ServiceManager.d(l);
        com.igexin.push.core.ServiceManager.getInstance();
        java.lang.String e2 = com.igexin.push.core.ServiceManager.e(l);
        try {
            if (!android.text.TextUtils.isEmpty(e2)) {
                java.lang.Class<?> cls = java.lang.Class.forName(e2);
                if (cls != com.igexin.sdk.PushService.class) {
                    if (!com.igexin.sdk.PushService.class.isAssignableFrom(cls)) {
                        z2 = false;
                        if (z2) {
                            e2 = null;
                        }
                    }
                }
                z2 = true;
                if (z2) {
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        java.lang.String[] strArr = {d2, e2, com.igexin.sdk.GService.class.getName()};
        int b2 = com.igexin.push.config.e.b();
        for (int i3 = 0; i3 < 3; i3++) {
            java.lang.String str = strArr[i3];
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    android.content.ComponentName componentName = new android.content.ComponentName(l, str);
                    android.content.pm.PackageManager packageManager = l.getPackageManager();
                    if (b2 != -1 && b2 != 1) {
                        i2 = 2;
                        packageManager.setComponentEnabledSetting(componentName, i2, 1);
                    }
                    i2 = 1;
                    packageManager.setComponentEnabledSetting(componentName, i2, 1);
                } catch (java.lang.Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                }
            }
        }
    }

    public static void a(long j2) {
        z = j2;
        A = com.igexin.c.b.a.b(java.lang.String.valueOf(j2));
    }

    public static boolean a(android.content.Context context) {
        l = context;
        g = context.getPackageName();
        i = com.igexin.push.h.o.b(context, "sc", "").toString();
        ac = "getui.permission.GetuiService." + g;
        if (!e()) {
            com.igexin.c.a.c.a.a(aN, "parseManifests failed");
            com.igexin.c.a.c.a.a("CoreRuntimeInfo|parseManifests failed", new java.lang.Object[0]);
            throw new java.lang.IllegalArgumentException("parseManifests failed");
        }
        ad = com.igexin.c.b.a.b(a + context.getPackageName()).getBytes();
        com.igexin.push.h.j.a();
        com.igexin.push.config.e.a();
        a();
        if (android.os.Build.VERSION.SDK_INT < 29) {
            java.lang.System.currentTimeMillis();
            D = com.igexin.push.h.n.g();
            java.lang.System.currentTimeMillis();
            E = com.igexin.push.h.n.f();
            java.lang.System.currentTimeMillis();
        }
        F = com.igexin.push.h.n.e();
        G = com.igexin.push.h.n.d();
        n = com.igexin.push.h.c.e();
        ah = new java.util.concurrent.ConcurrentHashMap();
        ai = new java.util.concurrent.ConcurrentHashMap();
        aj = new java.util.HashMap();
        ak = new java.util.HashMap();
        al = new java.util.HashMap<>();
        f388s = com.igexin.push.core.d.d.a().b("p");
        aO = new java.util.HashMap();
        az = true;
        com.igexin.c.a.c.a.a("CoreRuntimeInfo|getui sdk init success ##########", new java.lang.Object[0]);
        if (new com.igexin.sdk.main.SdkInitSwitch(l).isSwitchOn()) {
            com.igexin.push.core.d.d.a().a("i", java.lang.Boolean.TRUE);
            new com.igexin.sdk.main.SdkInitSwitch(l).delete();
        }
        if (new com.igexin.sdk.main.SdkPushSwitch(l).isSwitchOn()) {
            f388s = true;
            com.igexin.push.core.d.d.a().a("p", java.lang.Boolean.TRUE);
            new com.igexin.sdk.main.SdkPushSwitch(l).delete();
        }
        return true;
    }

    public static boolean a(java.lang.String str, java.lang.Integer num) {
        synchronized (com.igexin.push.core.e.class) {
            int intValue = num.intValue();
            if (aO.get(str) == null || (intValue = aO.get(str).intValue() + num.intValue()) != 0) {
                aO.put(str, java.lang.Integer.valueOf(intValue));
                return true;
            }
            aO.remove(str);
            return false;
        }
    }

    public static java.lang.Boolean b() {
        return java.lang.Boolean.valueOf(aP.equals("*"));
    }

    public static void b(long j2) {
        O = j2;
    }

    private static void c() {
        if (new com.igexin.sdk.main.SdkInitSwitch(l).isSwitchOn()) {
            com.igexin.push.core.d.d.a().a("i", java.lang.Boolean.TRUE);
            new com.igexin.sdk.main.SdkInitSwitch(l).delete();
        }
        if (new com.igexin.sdk.main.SdkPushSwitch(l).isSwitchOn()) {
            f388s = true;
            com.igexin.push.core.d.d.a().a("p", java.lang.Boolean.TRUE);
            new com.igexin.sdk.main.SdkPushSwitch(l).delete();
        }
    }

    private static java.lang.String d() {
        return com.igexin.push.config.SDKUrlConfig.getConfigServiceUrl();
    }

    private static boolean e() {
        try {
            android.content.pm.ApplicationInfo b2 = com.igexin.push.h.n.b(l);
            if (b2 == null || b2.metaData == null) {
                return false;
            }
            java.lang.String a2 = com.igexin.push.h.d.a(b2);
            if (android.text.TextUtils.isEmpty(a2)) {
                a2 = b2.metaData.getString(com.igexin.push.core.b.b);
            }
            if (android.text.TextUtils.isEmpty(a2)) {
                a2 = b2.metaData.getString("GETUI_APPID");
            }
            if (a2 != null) {
                a2 = a2.trim();
            }
            b = b2.metaData.getString(com.igexin.push.core.b.d);
            java.lang.String string = b2.metaData.getString(com.igexin.push.core.b.e);
            if (string != null) {
                aP = string;
            }
            if (android.text.TextUtils.isEmpty(a2)) {
                com.igexin.c.a.c.a.a(aN, "getui sdk init error, missing parm ######");
                com.igexin.c.a.c.a.a("CoreRuntimeInfo|getui sdk init error, missing parm #####", new java.lang.Object[0]);
                return false;
            }
            a = a2;
            f = com.igexin.push.config.SDKUrlConfig.getLocation();
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static void f() {
        if (android.os.Build.VERSION.SDK_INT < 29) {
            java.lang.System.currentTimeMillis();
            D = com.igexin.push.h.n.g();
            java.lang.System.currentTimeMillis();
            E = com.igexin.push.h.n.f();
            java.lang.System.currentTimeMillis();
        }
        F = com.igexin.push.h.n.e();
        G = com.igexin.push.h.n.d();
    }
}
