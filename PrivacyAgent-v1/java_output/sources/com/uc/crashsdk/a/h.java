package com.uc.crashsdk.a;

/* loaded from: classes19.dex */
public class h {
    static final /* synthetic */ boolean a = true;
    private static final java.lang.Object b = new java.lang.Object();
    private static final java.util.Map<java.lang.String, java.lang.String> c = new java.util.HashMap();
    private static int d = 0;
    private static final java.util.Map<java.lang.String, com.uc.crashsdk.a.h.a> e = new java.util.HashMap();
    private static final java.lang.Object f = new java.lang.Object();
    private static final java.lang.Object g = new java.lang.Object();
    private static final android.util.SparseArray<java.lang.String> h = new android.util.SparseArray<>();
    private static boolean i = false;
    private static boolean j = false;
    private static final java.lang.Object k = new java.lang.Object();
    private static java.lang.String l = null;

    public static class a {
        long a = 0;
        int b = 0;
        java.util.Map<java.lang.String, java.lang.String> c = new java.util.HashMap();
        private java.lang.String d;
        private boolean e;
        private boolean f;

        public a(java.lang.String str, boolean z, boolean z2) {
            this.e = false;
            this.f = false;
            this.d = str;
            this.e = z;
            this.f = z2;
        }

        private long d(java.lang.String str) {
            return com.uc.crashsdk.a.g.c(a(str));
        }

        public final java.lang.String a(java.lang.String str) {
            return this.c.get(str);
        }

        public final java.lang.String a(boolean z, boolean z2, boolean z3) {
            if (this.d == null) {
                return null;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (z) {
                com.uc.crashsdk.a.h.b(sb, "lt", "uc");
                com.uc.crashsdk.a.h.b(sb, "pre", com.uc.crashsdk.g.e());
                com.uc.crashsdk.a.h.b(sb, "pkg", com.uc.crashsdk.a.a);
                com.uc.crashsdk.a.h.b(sb, "rom", android.os.Build.VERSION.RELEASE);
                com.uc.crashsdk.a.h.b(sb, "brd", android.os.Build.BRAND);
                com.uc.crashsdk.a.h.b(sb, "model", android.os.Build.MODEL);
                com.uc.crashsdk.a.h.a(sb, "sdk", android.os.Build.VERSION.SDK_INT);
                com.uc.crashsdk.a.h.b(sb, "cpu", com.uc.crashsdk.e.e());
                com.uc.crashsdk.a.h.b(sb, "hdw", com.uc.crashsdk.e.f());
                long o = com.uc.crashsdk.a.h.o();
                com.uc.crashsdk.a.h.a(sb, "ram", o);
                com.uc.crashsdk.a.h.b(sb, "aram", com.uc.crashsdk.a.h.a(o));
                com.uc.crashsdk.a.h.b(sb, "cver", "3.3.2.2");
                com.uc.crashsdk.a.h.b(sb, "cseq", "240515102041");
                com.uc.crashsdk.a.h.b(sb, "ctag", "umeng");
                com.uc.crashsdk.a.h.b(sb, "aver", com.uc.crashsdk.a.a());
                com.uc.crashsdk.a.h.b(sb, "ver", com.uc.crashsdk.g.U());
                com.uc.crashsdk.a.h.b(sb, "sver", com.uc.crashsdk.g.V());
                com.uc.crashsdk.a.h.b(sb, "seq", com.uc.crashsdk.g.W());
                com.uc.crashsdk.a.h.b(sb, "grd", com.uc.crashsdk.b.A() ? "fg" : "bg");
                com.uc.crashsdk.a.h.b(sb, "os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
                com.uc.crashsdk.a.h.b(sb, "dn", com.uc.crashsdk.e.q());
                java.lang.String ac = com.uc.crashsdk.g.ac();
                if (android.text.TextUtils.isEmpty(ac)) {
                    ac = com.uc.crashsdk.e.q();
                }
                com.uc.crashsdk.a.h.b(sb, "k_uid", ac);
                java.lang.String ad = com.uc.crashsdk.g.ad();
                if (!android.text.TextUtils.isEmpty(ad)) {
                    com.uc.crashsdk.a.h.b(sb, "k_channel", ad);
                }
                sb.append("\n");
            }
            com.uc.crashsdk.a.h.b(sb, "lt", this.d);
            com.uc.crashsdk.a.h.a(sb, this.c);
            if (this.e && !z2) {
                long j = this.a;
                if (j != 0) {
                    com.uc.crashsdk.a.h.b(sb, com.umeng.analytics.pro.f.R, java.lang.String.valueOf(j));
                }
                if (z3) {
                    com.uc.crashsdk.a.h.b(sb, "pid", java.lang.String.format(java.util.Locale.US, com.google.android.material.timepicker.TimeModel.NUMBER_FORMAT, java.lang.Integer.valueOf(android.os.Process.myPid())));
                } else {
                    int i = this.b;
                    if (i != 0) {
                        com.uc.crashsdk.a.h.b(sb, "pid", java.lang.String.format(java.util.Locale.US, com.google.android.material.timepicker.TimeModel.NUMBER_FORMAT, java.lang.Integer.valueOf(i)));
                    }
                }
            }
            sb.append("\n");
            return sb.toString();
        }

        public final void a(java.lang.String str, long j) {
            long d = d(str) + j;
            if (d <= 100) {
                j = 0;
                if (d >= 0) {
                    j = d;
                }
            }
            a(str, java.lang.String.valueOf(j));
        }

        public final void a(java.lang.String str, java.lang.String str2) {
            this.c.put(str, str2);
        }

        public final boolean a(com.uc.crashsdk.a.h.a aVar) {
            if (!this.f) {
                com.uc.crashsdk.a.a.a("crashsdk", java.lang.String.format(java.util.Locale.US, "WaItem '%s' is not mergable!", this.d), null);
                return false;
            }
            for (java.lang.String str : aVar.c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long d = aVar.d(str);
                    if (d == 0) {
                        a(str, aVar.a(str));
                    } else if (d < 100) {
                        a(str, d);
                    }
                }
            }
            return true;
        }

        public final java.lang.String b(java.lang.String str) {
            java.lang.String a = a(str);
            return a == null ? "" : a;
        }

        public final boolean c(java.lang.String str) {
            if (com.uc.crashsdk.a.g.a(str)) {
                return false;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            java.util.Map c = com.uc.crashsdk.a.h.c(str);
            java.lang.String str2 = null;
            long j = 0;
            int i = 0;
            for (java.lang.String str3 : c.keySet()) {
                java.lang.String str4 = (java.lang.String) c.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.e && str3.equals(com.umeng.analytics.pro.f.R)) {
                    j = com.uc.crashsdk.a.g.c(str4);
                } else if (this.e && str3.equals("pid")) {
                    i = (int) com.uc.crashsdk.a.g.c(str4);
                } else {
                    hashMap.put(str3, str4);
                }
            }
            java.lang.String str5 = this.d;
            if (str5 != null && !str5.equals(str2)) {
                return false;
            }
            this.a = j;
            this.b = i;
            this.d = str2;
            this.c = hashMap;
            return true;
        }
    }

    public static /* synthetic */ java.lang.String a(long j2) {
        return j2 < android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "512M" : java.lang.String.format(java.util.Locale.US, "%dG", java.lang.Long.valueOf(((j2 / 1024) + 512) / 1024));
    }

    private static java.lang.StringBuilder a(java.lang.Iterable<com.uc.crashsdk.a.h.a> iterable, boolean z, boolean z2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z3 = true;
        for (com.uc.crashsdk.a.h.a aVar : iterable) {
            if (z3) {
                sb.append(aVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(aVar.a(false, z, z2));
            }
        }
        return sb;
    }

    private static java.util.ArrayList<com.uc.crashsdk.a.h.a> a(java.io.File file, java.lang.String str, int i2) {
        java.util.ArrayList<java.lang.String> a2 = com.uc.crashsdk.a.g.a(file, i2);
        java.util.ArrayList<com.uc.crashsdk.a.h.a> arrayList = new java.util.ArrayList<>();
        java.util.Iterator<java.lang.String> it = a2.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            com.uc.crashsdk.a.h.a aVar = new com.uc.crashsdk.a.h.a(str, false, false);
            if (aVar.c(next)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static void a() {
        a(0, com.uc.crashsdk.b.H() ? 700000L : 70000L);
    }

    private static void a(int i2, long j2) {
        if (com.uc.crashsdk.b.F()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(302, new java.lang.Object[]{java.lang.Integer.valueOf(i2)}), j2);
        }
    }

    private static void a(int i2, java.lang.String str) {
        h.put(i2, str);
    }

    private static void a(int i2, boolean z) {
        if (a(z, "crash rate")) {
            return;
        }
        java.lang.String str = com.uc.crashsdk.g.X() + "cr.wa";
        com.uc.crashsdk.b.a(b, str, new com.uc.crashsdk.a.e(351, new java.lang.Object[]{str, java.lang.Integer.valueOf(i2)}));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
    
        if (r3 == false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00af A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:19:0x001d, B:21:0x0028, B:23:0x002c, B:24:0x00c9, B:27:0x002e, B:29:0x0038, B:31:0x0040, B:33:0x005a, B:35:0x005f, B:42:0x0070, B:43:0x0077, B:44:0x008b, B:46:0x0097, B:50:0x00af, B:51:0x00c2, B:52:0x00a5, B:57:0x0083), top: B:18:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i2, java.lang.Object[] objArr) {
        java.lang.String str;
        java.lang.String q;
        long j2;
        boolean z;
        switch (i2) {
            case 301:
                if (!a && objArr == null) {
                    throw new java.lang.AssertionError();
                }
                a(((java.lang.Integer) objArr[0]).intValue(), false);
                return;
            case 302:
                if (!a && objArr == null) {
                    throw new java.lang.AssertionError();
                }
                synchronized (b) {
                    int intValue = ((java.lang.Integer) objArr[0]).intValue();
                    if (intValue == 0) {
                        if (!i) {
                            i = true;
                        }
                    }
                    if (!com.uc.crashsdk.a.b.equals("2.0") || !com.uc.crashsdk.b.c(268435456)) {
                        java.io.File file = new java.io.File(m());
                        java.lang.String c2 = com.uc.crashsdk.a.g.c(file);
                        com.uc.crashsdk.a.h.a aVar = new com.uc.crashsdk.a.h.a(com.umeng.analytics.pro.f.T, true, true);
                        if (!com.uc.crashsdk.a.g.a(c2)) {
                            aVar.c(c2);
                        }
                        if (intValue == 0) {
                            if (aVar.b != android.os.Process.myPid()) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        }
                        if (intValue == 0) {
                            aVar.a(com.umeng.analytics.pro.f.T, 1L);
                            str = "fjv";
                        } else if (intValue == 1) {
                            str = "hpv";
                        } else {
                            if (intValue == 2) {
                                aVar.a(com.umeng.analytics.pro.f.T, 1L);
                                str = "npv";
                            }
                            q = com.uc.crashsdk.e.q();
                            j2 = aVar.a;
                            if ((j2 != 0 || java.lang.System.currentTimeMillis() - j2 >= 28800000) ? c(q, aVar.a(true, true, false)) : false) {
                                aVar.c = new java.util.HashMap();
                                aVar.a = java.lang.System.currentTimeMillis();
                                aVar.b = android.os.Process.myPid();
                            }
                            com.uc.crashsdk.a.g.a(file, aVar.a(false, false, true));
                        }
                        aVar.a(str, 1L);
                        q = com.uc.crashsdk.e.q();
                        j2 = aVar.a;
                        if ((j2 != 0 || java.lang.System.currentTimeMillis() - j2 >= 28800000) ? c(q, aVar.a(true, true, false)) : false) {
                        }
                        com.uc.crashsdk.a.g.a(file, aVar.a(false, false, true));
                    }
                }
                return;
            case 303:
                b(false);
                return;
            default:
                if (!a) {
                    throw new java.lang.AssertionError();
                }
                return;
        }
    }

    private static void a(com.uc.crashsdk.a.h.a aVar) {
        java.util.Map<java.lang.String, java.lang.String> map = c;
        synchronized (map) {
            for (java.lang.String str : map.keySet()) {
                aVar.a(str, c.get(str));
            }
        }
    }

    public static void a(java.lang.String str) {
        synchronized (b) {
            java.io.File file = new java.io.File(m());
            com.uc.crashsdk.a.h.a aVar = new com.uc.crashsdk.a.h.a(com.umeng.analytics.pro.f.T, true, true);
            java.lang.String c2 = com.uc.crashsdk.a.g.c(file);
            if (!com.uc.crashsdk.a.g.a(c2)) {
                aVar.c(c2);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            com.uc.crashsdk.a.g.a(file, aVar.a(false, false, false));
        }
    }

    public static void a(java.lang.String str, int i2, int i3) {
        if (com.uc.crashsdk.g.R()) {
            synchronized (f) {
                java.util.Map<java.lang.String, com.uc.crashsdk.a.h.a> map = e;
                com.uc.crashsdk.a.h.a aVar = map.get(str);
                if (aVar == null) {
                    aVar = new com.uc.crashsdk.a.h.a("cst", false, true);
                    map.put(str, aVar);
                    a(aVar);
                }
                android.util.SparseArray<java.lang.String> sparseArray = h;
                synchronized (sparseArray) {
                    if (sparseArray.size() == 0) {
                        a(100, com.umeng.analytics.pro.f.T);
                        a(102, "hpv");
                        a(1, "all");
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                java.lang.String str2 = sparseArray.get(i2);
                if (str2 == null) {
                    com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i2, null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, java.lang.String.valueOf(i3));
                }
            }
        }
    }

    public static /* synthetic */ void a(java.lang.StringBuilder sb, java.lang.String str, long j2) {
        b(sb, str, java.lang.String.valueOf(j2));
    }

    public static /* synthetic */ void a(java.lang.StringBuilder sb, java.util.Map map) {
        for (java.lang.String str : map.keySet()) {
            b(sb, str, (java.lang.String) map.get(str));
        }
    }

    public static void a(boolean z) {
        a(1, z);
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            java.lang.String replaceAll = com.uc.crashsdk.a.g.a(str2) ? "" : str2.replaceAll("[`=]", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            java.util.Map<java.lang.String, java.lang.String> map = c;
            synchronized (map) {
                if (map.get(str3) == null) {
                    int i2 = d;
                    if (i2 >= 20) {
                        return false;
                    }
                    d = i2 + 1;
                }
                map.put(str3, replaceAll);
                return true;
            }
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        if (!com.uc.crashsdk.g.R()) {
            return false;
        }
        return com.uc.crashsdk.b.a(g, n(), new com.uc.crashsdk.a.e(353, new java.lang.Object[]{str, str2, java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2)}));
    }

    public static boolean a(boolean z, java.lang.String str) {
        if (!com.uc.crashsdk.b.d || z || !com.uc.crashsdk.JNIBridge.nativeIsCrashing()) {
            return false;
        }
        com.uc.crashsdk.a.a.b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    public static void b() {
        a(2, 0L);
    }

    private static void b(int i2, long j2) {
        if (com.uc.crashsdk.g.R()) {
            com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(301, new java.lang.Object[]{java.lang.Integer.valueOf(i2)}), j2);
        }
    }

    public static void b(java.lang.String str) {
        synchronized (k) {
            l = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.k(), str + "\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.lang.StringBuilder sb, java.lang.String str, java.lang.String str2) {
        sb.append(str);
        sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(str2);
        sb.append("`");
    }

    public static void b(boolean z) {
        if (a(z, "crash detail upload")) {
            return;
        }
        java.lang.String str = com.uc.crashsdk.g.X() + "dt.wa";
        com.uc.crashsdk.b.a(f, str, new com.uc.crashsdk.a.e(352, new java.lang.Object[]{str}));
        java.lang.String n = n();
        com.uc.crashsdk.b.a(g, n, new com.uc.crashsdk.a.e(354, new java.lang.Object[]{n}));
    }

    public static boolean b(int i2, java.lang.Object[] objArr) {
        switch (i2) {
            case 351:
                if (!a && objArr == null) {
                    throw new java.lang.AssertionError();
                }
                java.lang.String str = (java.lang.String) objArr[0];
                int intValue = ((java.lang.Integer) objArr[1]).intValue();
                if (intValue == 1) {
                    if (j) {
                        return false;
                    }
                    j = true;
                }
                if (!com.uc.crashsdk.g.aa()) {
                    return false;
                }
                java.io.File file = new java.io.File(str);
                java.util.ArrayList<com.uc.crashsdk.a.h.a> a2 = a(file, "crp", 100);
                if (intValue != 4) {
                    com.uc.crashsdk.a.h.a aVar = new com.uc.crashsdk.a.h.a("crp", false, false);
                    if (intValue == 1) {
                        aVar.a("et", java.lang.String.valueOf(com.uc.crashsdk.b.I()));
                        aVar.a("ete", java.lang.String.valueOf(com.uc.crashsdk.b.J()));
                    } else if (intValue == 3) {
                        aVar.a("et", "1");
                        aVar.a("ete", "1");
                    } else if (intValue == 2) {
                        aVar.a("hpv", "1");
                    }
                    aVar.a("prc", com.uc.crashsdk.e.h());
                    aVar.a(com.umeng.analytics.pro.ay.c, com.uc.crashsdk.b.F() ? "1" : "0");
                    a(aVar);
                    a2.add(0, aVar);
                }
                if (!a2.isEmpty()) {
                    boolean c2 = c(com.uc.crashsdk.e.q(), a((java.lang.Iterable<com.uc.crashsdk.a.h.a>) a2, true, false).toString());
                    com.uc.crashsdk.a.g.b(file);
                    if (!c2) {
                        com.uc.crashsdk.a.g.a(file, a((java.lang.Iterable<com.uc.crashsdk.a.h.a>) a2, false, true).toString());
                    }
                }
                return true;
            case 352:
                if (a || objArr != null) {
                    return d((java.lang.String) objArr[0]);
                }
                throw new java.lang.AssertionError();
            case 353:
                if (a || objArr != null) {
                    return b((java.lang.String) objArr[0], (java.lang.String) objArr[1], ((java.lang.Boolean) objArr[2]).booleanValue(), ((java.lang.Boolean) objArr[3]).booleanValue());
                }
                throw new java.lang.AssertionError();
            case 354:
                if (!a && objArr == null) {
                    throw new java.lang.AssertionError();
                }
                java.io.File file2 = new java.io.File((java.lang.String) objArr[0]);
                boolean c3 = c(com.uc.crashsdk.e.q(), a((java.lang.Iterable<com.uc.crashsdk.a.h.a>) a(file2, "cst", 30), true, false).toString());
                if (c3) {
                    com.uc.crashsdk.a.g.b(file2);
                }
                return c3;
            default:
                return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(java.lang.String str, java.lang.String str2) {
        boolean z;
        byte[] a2;
        byte[] a3;
        if (com.uc.crashsdk.a.g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String d2 = com.uc.crashsdk.a.g.d(com.uc.crashsdk.g.e() + str + currentTimeMillis + "AppChk#2014");
        try {
            a3 = com.uc.crashsdk.a.c.a(bytes, d2.substring(d2.length() - 16, d2.length()).getBytes());
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        if (a3 != null) {
            bytes = a3;
            z = true;
            java.lang.String substring = d2.substring(d2.length() - 8, d2.length());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.uc.crashsdk.g.A());
            sb.append("/api/v1/crashtrack/upload?chk=");
            sb.append(substring);
            sb.append("&vno=");
            sb.append(currentTimeMillis);
            sb.append("&uuid=");
            sb.append(str);
            sb.append("&app=");
            sb.append(com.uc.crashsdk.g.e());
            if (z) {
                sb.append("&enc=aes");
            }
            java.lang.String sb2 = sb.toString();
            return sb2 == null && (a2 = com.uc.crashsdk.a.c.a(sb2, bytes)) != null && new java.lang.String(a2).contains("retcode=0");
        }
        z = false;
        java.lang.String substring2 = d2.substring(d2.length() - 8, d2.length());
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(com.uc.crashsdk.g.A());
        sb3.append("/api/v1/crashtrack/upload?chk=");
        sb3.append(substring2);
        sb3.append("&vno=");
        sb3.append(currentTimeMillis);
        sb3.append("&uuid=");
        sb3.append(str);
        sb3.append("&app=");
        sb3.append(com.uc.crashsdk.g.e());
        if (z) {
        }
        java.lang.String sb22 = sb3.toString();
        if (sb22 == null) {
            return false;
        }
    }

    private static boolean b(java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        com.uc.crashsdk.a.h.a aVar;
        java.io.File file = new java.io.File(n());
        java.util.ArrayList<com.uc.crashsdk.a.h.a> a2 = a(file, "cst", 30);
        java.lang.String str3 = str + str2;
        java.util.Iterator<com.uc.crashsdk.a.h.a> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (str3.equals(aVar.b("prc") + aVar.b("typ"))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new com.uc.crashsdk.a.h.a("cst", false, true);
            aVar.a("prc", str);
            aVar.a("typ", str2);
            a(aVar);
            a2.add(aVar);
        }
        aVar.a("cnt", 1L);
        if (z) {
            aVar.a("lim", 1L);
        }
        if (z2) {
            aVar.a("syu", 1L);
        }
        return com.uc.crashsdk.a.g.a(file, a((java.lang.Iterable<com.uc.crashsdk.a.h.a>) a2, false, false).toString());
    }

    public static /* synthetic */ java.util.Map c(java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.lang.String str2 : str.split("`")) {
            if (str2.length() > 1) {
                java.lang.String[] split = str2.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, 3);
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    public static void c() {
        a(3, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c(java.lang.String str, java.lang.String str2) {
        boolean z;
        java.lang.String d2;
        java.lang.String sb;
        byte[] a2;
        byte[] a3;
        if (com.uc.crashsdk.a.g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        try {
            byte[] bArr = new byte[16];
            com.uc.crashsdk.a.c.a(bArr, 0, com.uc.crashsdk.a.c.a());
            com.uc.crashsdk.a.c.a(bArr, 4, j());
            com.uc.crashsdk.a.c.a(bArr, 8, com.uc.crashsdk.a.f());
            com.uc.crashsdk.a.c.a(bArr, 12, com.uc.crashsdk.a.d.d());
            a3 = com.uc.crashsdk.a.c.a(bytes, bArr);
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        if (a3 != null) {
            bytes = a3;
            z = true;
            if (str == null) {
                str = "unknown";
            }
            java.lang.String str3 = !com.uc.crashsdk.g.S() ? "4ea4e41a3993" : "28ef1713347d";
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            d2 = com.uc.crashsdk.a.g.d(str3 + str + valueOf + "AppChk#2014");
            if (d2 != null) {
                sb = null;
            } else {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(com.uc.crashsdk.g.A());
                sb2.append("?chk=");
                sb2.append(d2.substring(d2.length() - 8, d2.length()));
                sb2.append("&vno=");
                sb2.append(valueOf);
                sb2.append("&uuid=");
                sb2.append(str);
                sb2.append("&app=");
                sb2.append(str3);
                if (z) {
                    sb2.append("&enc=aes");
                }
                sb = sb2.toString();
            }
            return sb == null && (a2 = com.uc.crashsdk.a.c.a(sb, bytes)) != null && new java.lang.String(a2).contains("retcode=0");
        }
        z = false;
        if (str == null) {
        }
        if (!com.uc.crashsdk.g.S()) {
        }
        java.lang.String valueOf2 = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        d2 = com.uc.crashsdk.a.g.d(str3 + str + valueOf2 + "AppChk#2014");
        if (d2 != null) {
        }
        if (sb == null) {
            return false;
        }
    }

    public static void d() {
        b(2, 2000L);
        a(1, 70000L);
    }

    private static boolean d(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        java.util.Iterator<com.uc.crashsdk.a.h.a> it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            com.uc.crashsdk.a.h.a next = it.next();
            java.lang.String a2 = next.a("prc");
            if (!com.uc.crashsdk.a.g.a(a2)) {
                java.util.Map<java.lang.String, com.uc.crashsdk.a.h.a> map = e;
                com.uc.crashsdk.a.h.a aVar = map.get(a2);
                if (aVar != null) {
                    aVar.a(next);
                } else {
                    map.put(a2, next);
                }
            }
        }
        java.util.Map<java.lang.String, com.uc.crashsdk.a.h.a> map2 = e;
        java.lang.StringBuilder a3 = a((java.lang.Iterable<com.uc.crashsdk.a.h.a>) map2.values(), true, false);
        boolean b2 = com.uc.crashsdk.g.ab() ? b(com.uc.crashsdk.e.q(), a3.toString()) : c(com.uc.crashsdk.e.q(), a3.toString());
        com.uc.crashsdk.a.g.b(file);
        if (b2 || com.uc.crashsdk.a.g.a(file, a((java.lang.Iterable<com.uc.crashsdk.a.h.a>) map2.values(), false, true).toString())) {
            map2.clear();
        }
        return true;
    }

    public static boolean e() {
        return j;
    }

    public static void f() {
        b(1, 2000L);
    }

    public static void g() {
        b(3, 0L);
    }

    public static void h() {
        b(4, 0L);
    }

    public static void i() {
        if (com.uc.crashsdk.g.R()) {
            com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(303));
        }
    }

    public static byte[] j() {
        return new byte[]{Byte.MAX_VALUE, 100, 110, com.google.common.base.Ascii.US};
    }

    public static void k() {
        synchronized (k) {
            l = null;
        }
    }

    private static java.lang.String m() {
        return com.uc.crashsdk.g.X() + "pv.wa";
    }

    private static java.lang.String n() {
        return com.uc.crashsdk.g.X() + "cdt.wa";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long o() {
        java.util.Iterator<java.lang.String> it = com.uc.crashsdk.a.g.a(new java.io.File("/proc/meminfo"), 2).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            java.lang.String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return java.lang.Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (java.lang.NumberFormatException e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
        }
        return 0L;
    }
}
