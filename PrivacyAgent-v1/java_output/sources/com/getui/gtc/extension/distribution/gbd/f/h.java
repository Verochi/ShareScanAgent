package com.getui.gtc.extension.distribution.gbd.f;

/* loaded from: classes22.dex */
public class h {
    private static final java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.f.h.a> A;
    private static final java.lang.String B = "all";
    private static final java.util.Map<java.lang.String, java.lang.String> C;
    private static final java.util.Map<java.lang.String, java.lang.String> D;
    private static final java.lang.String E = "^\\d{2}:\\d{2}:\\d{2}-\\d{2}:\\d{2}:\\d{2}#[0-3]$";
    public static final java.lang.String a = "bl";
    public static final java.lang.String b = "i-ie";
    public static final java.lang.String c = "i-is";
    public static final java.lang.String d = "i-ic";
    public static final java.lang.String e = "i-sn";
    public static final java.lang.String f = "i-oa";
    public static final java.lang.String g = "i-an";
    public static final java.lang.String h = "i-ad";
    public static final java.lang.String i = "loc";
    public static final java.lang.String j = "i-m";
    public static final java.lang.String k = "i-m-nl";
    public static final java.lang.String l = "pi";
    public static final java.lang.String m = "al";
    public static final java.lang.String n = "sl";
    public static final java.lang.String o = "wi";
    public static final java.lang.String p = "cr";
    public static final java.lang.String q = "sm";
    public static final java.lang.String r = "ci";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f331s = "sd";
    public static boolean t = false;
    private static final java.lang.String u = "GBD_HC";
    private static long v;
    private static long w;
    private static long x;
    private static long y;
    private static boolean z;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.f.h$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.HashMap<java.lang.String, java.lang.String> {
        public AnonymousClass1() {
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.A, "loc");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.C, "loc");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.B, "loc");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.D, "loc");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.y, "i-m");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.z, "i-m");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.h, "i-m");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.i, "i-m");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.K, "al");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.L, "al");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.M, "al");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.N, "al");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.O, "al");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.b, com.getui.gtc.extension.distribution.gbd.f.h.b);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.c, com.getui.gtc.extension.distribution.gbd.f.h.b);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.d, com.getui.gtc.extension.distribution.gbd.f.h.b);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.e, com.getui.gtc.extension.distribution.gbd.f.h.c);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.f, com.getui.gtc.extension.distribution.gbd.f.h.c);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.g, com.getui.gtc.extension.distribution.gbd.f.h.c);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.m, com.getui.gtc.extension.distribution.gbd.f.h.d);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.n, com.getui.gtc.extension.distribution.gbd.f.h.d);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.o, com.getui.gtc.extension.distribution.gbd.f.h.d);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.k, com.getui.gtc.extension.distribution.gbd.f.h.f);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.j, com.getui.gtc.extension.distribution.gbd.f.h.e);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.p, com.getui.gtc.extension.distribution.gbd.f.h.g);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.q, com.getui.gtc.extension.distribution.gbd.f.h.h);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.E, "wi");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.F, "wi");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.G, "wi");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.H, "wi");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.I, "ci");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.J, "ci");
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.w, com.getui.gtc.extension.distribution.gbd.f.h.p);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.f.h$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.util.HashMap<java.lang.String, java.lang.String> {
        public AnonymousClass2() {
            put("bl", "bl");
            put("loc", "loc");
            put(com.getui.gtc.extension.distribution.gbd.f.b.o, "i-m");
            put(com.getui.gtc.extension.distribution.gbd.f.b.v, "i-m");
            put(com.getui.gtc.extension.distribution.gbd.f.b.w, com.getui.gtc.extension.distribution.gbd.f.b.w);
            put(com.getui.gtc.extension.distribution.gbd.f.b.m, "i-m");
            put(com.getui.gtc.extension.distribution.gbd.f.b.n, "i-m");
            put("i-m", "i-m");
            put(com.getui.gtc.extension.distribution.gbd.f.b.r, "i-m");
            put(com.getui.gtc.extension.distribution.gbd.f.b.f328s, "i-m");
            put("i-m-nl", "i-m-nl");
            put("al", "al");
            put(com.getui.gtc.extension.distribution.gbd.f.b.b, "al");
            put(com.getui.gtc.extension.distribution.gbd.f.b.c, "al");
            put(com.getui.gtc.extension.distribution.gbd.f.b.d, "al");
            put(com.getui.gtc.extension.distribution.gbd.f.b.e, com.getui.gtc.extension.distribution.gbd.f.h.n);
            put("pi", "pi");
            put("wi", "wi");
            put(com.getui.gtc.extension.distribution.gbd.f.b.k, "wi");
            put("sm", "sm");
            put(com.getui.gtc.extension.distribution.gbd.f.b.f, com.getui.gtc.extension.distribution.gbd.f.h.f331s);
            put(com.getui.gtc.extension.distribution.gbd.f.b.x, com.getui.gtc.extension.distribution.gbd.f.b.x);
        }
    }

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
            return "Config{key='" + this.a + "', startupDurationCondition=" + this.b + ", timeRangeStart='" + this.c + "', timeRangeEnd='" + this.d + "', timeRangeState=" + this.e + ", weekState=" + this.f + ", startupCountCondition=" + this.g + ", installDurationDayCondition=" + this.h + '}';
        }
    }

    static {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        v = currentTimeMillis;
        w = currentTimeMillis;
        x = currentTimeMillis;
        z = false;
        A = new java.util.HashMap();
        t = true;
        C = new com.getui.gtc.extension.distribution.gbd.f.h.AnonymousClass1();
        D = new com.getui.gtc.extension.distribution.gbd.f.h.AnonymousClass2();
    }

    public static java.lang.String a(java.lang.String str) {
        return C.get(str);
    }

    public static void a() {
        if (com.getui.gtc.extension.distribution.gbd.d.h.bc == 0) {
            z = true;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.h(v);
        }
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        int i2 = com.getui.gtc.extension.distribution.gbd.d.h.bb + 1;
        com.getui.gtc.extension.distribution.gbd.d.h.bb = i2;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(340, java.lang.String.valueOf(i2));
        com.getui.gtc.extension.distribution.gbd.n.j.a(u, "h c init : " + v + " ," + com.getui.gtc.extension.distribution.gbd.d.h.bb + " ," + com.getui.gtc.extension.distribution.gbd.d.h.bc);
    }

    public static synchronized void a(long j2) {
        synchronized (com.getui.gtc.extension.distribution.gbd.f.h.class) {
            v = j2;
            w = j2;
            if (z) {
                z = false;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.h(j2);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(u, "h c serverTimeSync : " + v + " ," + com.getui.gtc.extension.distribution.gbd.d.h.bb + " ," + com.getui.gtc.extension.distribution.gbd.d.h.bc);
        }
    }

    public static void a(boolean z2, java.lang.String str) {
        java.lang.String[] strArr;
        java.lang.String str2;
        long parseLong;
        java.lang.String str3;
        java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.f.h.a> map;
        t = z2;
        com.getui.gtc.extension.distribution.gbd.n.j.a(u, "h c parseConfig start : " + z2 + ", " + str);
        long j2 = -1;
        java.util.HashMap hashMap = null;
        if (t) {
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.lang.String[] split = str.split(",");
                    int length = split.length;
                    char c2 = 0;
                    int i2 = 0;
                    while (i2 < length) {
                        java.lang.String str4 = split[i2];
                        if (!android.text.TextUtils.isEmpty(str4)) {
                            java.lang.String[] split2 = str4.split("\\|");
                            if (split2.length == 6) {
                                try {
                                    str2 = split2[c2];
                                    parseLong = java.lang.Long.parseLong(split2[1]);
                                    str3 = split2[2];
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    strArr = split;
                                }
                                if (java.util.regex.Pattern.compile(E).matcher(str3).matches()) {
                                    java.lang.String[] split3 = str3.split("#");
                                    java.lang.String[] split4 = split3[c2].split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    java.lang.String str5 = split4[c2];
                                    java.lang.String str6 = split4[1];
                                    int parseInt = java.lang.Integer.parseInt(split3[1]);
                                    int parseInt2 = java.lang.Integer.parseInt(split2[3]);
                                    int parseInt3 = java.lang.Integer.parseInt(split2[4]);
                                    int parseInt4 = java.lang.Integer.parseInt(split2[5]);
                                    strArr = split;
                                    try {
                                        com.getui.gtc.extension.distribution.gbd.f.h.a aVar = new com.getui.gtc.extension.distribution.gbd.f.h.a();
                                        aVar.a = str2;
                                        long j3 = parseLong * 1000;
                                        aVar.b = j3;
                                        aVar.c = str5;
                                        aVar.d = str6;
                                        aVar.e = parseInt;
                                        aVar.f = parseInt2;
                                        aVar.g = parseInt3;
                                        aVar.h = parseInt4;
                                        j2 = java.lang.Math.max(j2, j3);
                                        if (hashMap == null) {
                                            hashMap = new java.util.HashMap();
                                        }
                                        hashMap.put(str2, aVar);
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(u, "h c parseConfig : parse config failed (format err), ".concat(str4));
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                        i2++;
                                        split = strArr;
                                        c2 = 0;
                                    }
                                    i2++;
                                    split = strArr;
                                    c2 = 0;
                                } else {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(u, "h c parseConfig : parse time range failed (format err), ".concat(str4));
                                }
                            }
                        }
                        strArr = split;
                        i2++;
                        split = strArr;
                        c2 = 0;
                    }
                }
            } catch (java.lang.Throwable th3) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
            }
        }
        y = j2;
        synchronized (com.getui.gtc.extension.distribution.gbd.f.h.class) {
            map = A;
            map.clear();
            if (hashMap != null && !hashMap.isEmpty()) {
                map.putAll(hashMap);
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(u, "h c parseConfig end: " + map);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(android.content.Context context) {
        boolean z2;
        java.lang.String str;
        if (com.getui.gtc.extension.distribution.gbd.n.l.a()) {
            str = "check safe f: debuggable";
        } else if (com.getui.gtc.extension.distribution.gbd.n.l.n(context)) {
            str = "check safe f: u-model";
        } else if (com.getui.gtc.extension.distribution.gbd.d.d.aK && com.getui.gtc.extension.distribution.gbd.n.a.f.c()) {
            str = "check safe f: xposed";
        } else {
            com.getui.gtc.extension.distribution.gbd.n.a.d.a();
            java.lang.String str2 = android.os.Build.FINGERPRINT;
            if (!str2.contains("generic") && !str2.contains("unknown") && !str2.contains("generic_x86") && !str2.contains("vbox")) {
                java.lang.String str3 = android.os.Build.MODEL;
                if (!str3.contains("google_sdk") && !str3.contains("Emulator") && !str3.contains("Android SDK built for x86") && !android.os.Build.MANUFACTURER.contains("Genymotion")) {
                    java.lang.String str4 = android.os.Build.HARDWARE;
                    if (!"goldfish".equals(str4) && !"ranchu".equals(str4)) {
                        z2 = false;
                        if (z2) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check safe s");
                            return true;
                        }
                        str = "check safe f: emulator";
                    }
                }
            }
            z2 = true;
            if (z2) {
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(u, str);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
    
        if (r10.before(r9) == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(java.lang.String str, com.getui.gtc.extension.distribution.gbd.f.h.a aVar) {
        boolean z2;
        if (aVar == null) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str + " , config is null");
            return false;
        }
        try {
            long C2 = com.getui.gtc.extension.distribution.gbd.n.l.C();
            long j2 = com.getui.gtc.extension.distribution.gbd.d.h.bd;
            int i2 = com.getui.gtc.extension.distribution.gbd.d.h.bb;
            long j3 = com.getui.gtc.extension.distribution.gbd.d.h.bc;
            com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str + " , " + C2 + ", " + aVar + ", " + j2 + " ," + i2 + " ," + j3);
            long j4 = aVar.b;
            if (j4 >= 0 && (j4 <= 0 || j2 >= j4)) {
                if (aVar.e == 1) {
                    java.lang.String str2 = aVar.c;
                    java.lang.String str3 = aVar.d;
                    java.util.Calendar a2 = com.getui.gtc.extension.distribution.gbd.n.ae.a(C2, str2);
                    java.util.Calendar a3 = com.getui.gtc.extension.distribution.gbd.n.ae.a(C2, str3);
                    java.util.Calendar calendar = java.util.Calendar.getInstance();
                    calendar.setTimeInMillis(C2);
                    if (a3.before(a2)) {
                        if (!calendar.after(a2)) {
                        }
                    } else {
                        z2 = calendar.after(a2) && calendar.before(a3);
                    }
                    if (z2) {
                        int i3 = aVar.f;
                        if (i3 > 0 && i3 <= 3 && ((i3 != 1 || !com.getui.gtc.extension.distribution.gbd.n.ae.a(C2)) && (aVar.f != 2 || com.getui.gtc.extension.distribution.gbd.n.ae.a(C2)))) {
                            int i4 = aVar.g;
                            if (i4 >= 0 && i2 >= i4) {
                                if (aVar.h >= 0 && com.getui.gtc.extension.distribution.gbd.n.ae.a(C2, j3) >= aVar.h) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str + " , passed");
                                    return true;
                                }
                                com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str + " , 5 not passed, " + b(j3));
                                return false;
                            }
                            com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str + " , 4 not passed, " + i2);
                            return false;
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str + " , 3 not passed");
                        return false;
                    }
                }
                com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str + " , 2 not passed, " + b(C2));
                return false;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str + " , 1 not passed, " + j2 + "ms");
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str + " , catch exception, not passed");
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        com.getui.gtc.extension.distribution.gbd.f.h.a aVar;
        java.lang.String str3 = str + ", " + str2;
        synchronized (com.getui.gtc.extension.distribution.gbd.f.h.class) {
            java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.f.h.a> map = A;
            if (!map.containsKey(str2)) {
                str2 = "all";
            }
            aVar = map.get(str2);
            com.getui.gtc.extension.distribution.gbd.n.j.a(u, "check filed condition : " + str3 + " , queryKey : " + str2);
        }
        return a(str3, aVar);
    }

    private static java.lang.String b(long j2) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(j2));
    }

    public static java.lang.String b(java.lang.String str) {
        return D.get(str);
    }

    public static void b() {
        try {
            long C2 = com.getui.gtc.extension.distribution.gbd.n.l.C();
            long j2 = C2 - x;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            long j3 = com.getui.gtc.extension.distribution.gbd.d.h.be;
            if (j2 <= 0) {
                j2 = 0;
            }
            long j4 = j3 + j2;
            com.getui.gtc.extension.distribution.gbd.d.h.be = j4;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(390, java.lang.String.valueOf(j4));
            x = C2;
            if (A.isEmpty()) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(u, "h c r total time : config is empty");
                return;
            }
            if (com.getui.gtc.extension.distribution.gbd.d.h.bd > y) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(u, "h c r total time : accumulated to max value , " + com.getui.gtc.extension.distribution.gbd.d.h.bd + "ms, " + y + "ms");
                return;
            }
            long C3 = com.getui.gtc.extension.distribution.gbd.n.l.C();
            long j5 = C3 - w;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            long j6 = com.getui.gtc.extension.distribution.gbd.d.h.bd + (j5 > 0 ? j5 : 0L);
            com.getui.gtc.extension.distribution.gbd.d.h.bd = j6;
            com.getui.gtc.extension.distribution.gbd.d.h.bd = j6;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(342, java.lang.String.valueOf(j6));
            w = C3;
            com.getui.gtc.extension.distribution.gbd.n.j.a(u, "h c r total time : " + com.getui.gtc.extension.distribution.gbd.d.h.bd + "ms, " + y + "ms");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    public static boolean c() {
        return t;
    }

    private static boolean c(java.lang.String str) {
        return java.util.regex.Pattern.compile(E).matcher(str).matches();
    }

    private static void d() {
        a(true, "loc|0|00:00:00-24:00:00#1|3|0|0,sm|0|00:00:00-24:00:00#1|3|0|0,bl|0|00:00:00-24:00:00#1|3|0|0,i-m|0|00:00:00-24:00:00#1|3|0|0");
        for (java.util.Map.Entry<java.lang.String, com.getui.gtc.extension.distribution.gbd.f.h.a> entry : A.entrySet()) {
            a("test-" + entry.getKey(), entry.getValue());
        }
    }

    private static void d(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(u, str);
    }
}
