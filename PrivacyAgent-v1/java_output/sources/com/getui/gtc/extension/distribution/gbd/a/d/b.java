package com.getui.gtc.extension.distribution.gbd.a.d;

/* loaded from: classes22.dex */
public final class b implements com.getui.gtc.extension.distribution.gbd.a.a {
    public static final int a = 50;
    private static final java.lang.String d = "GBD_LFAction";
    private static com.getui.gtc.extension.distribution.gbd.a.d.b e = null;
    private static final java.lang.String g = "harmony";
    java.util.concurrent.locks.Lock b;
    java.util.concurrent.locks.Condition c;
    private boolean f = false;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.d.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.n.a.g.b {
        public AnonymousClass1() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.a.g.b
        public final void a() {
            com.getui.gtc.extension.distribution.gbd.a.d.b.this.b.lock();
            try {
                com.getui.gtc.extension.distribution.gbd.a.d.b.this.c.signalAll();
            } finally {
                com.getui.gtc.extension.distribution.gbd.a.d.b.this.b.unlock();
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.d.b$2, reason: invalid class name */
    public class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.Object, java.lang.String> {
        public AnonymousClass2() {
        }

        private static java.lang.String a() {
            if (!com.getui.gtc.extension.distribution.gbd.d.d.R || com.getui.gtc.extension.distribution.gbd.d.h.h < 18) {
                return "";
            }
            try {
                byte[] propertyByteArray = new android.media.MediaDrm(new java.util.UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (byte b : propertyByteArray) {
                    sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
                }
                return sb.toString();
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return "";
            }
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(java.lang.Object obj) {
            return a();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.d.b$3, reason: invalid class name */
    public class AnonymousClass3 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, java.lang.String> {
        public AnonymousClass3() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.String a2(android.content.Context context) {
            try {
                java.lang.String packageName = context.getPackageName();
                android.content.pm.PackageInfo a = com.getui.gtc.extension.distribution.gbd.n.k.a(packageName, 0);
                if (a != null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(packageName);
                    sb.append("#");
                    sb.append(a.versionName);
                    sb.append("#");
                    sb.append(a.versionCode);
                    sb.append("#");
                    sb.append(a.firstInstallTime);
                    sb.append("#");
                    sb.append(a.lastUpdateTime);
                    sb.append("#");
                    sb.append((a.applicationInfo.flags & 2) > 0 ? 1 : 0);
                    return sb.toString().replace("|", "");
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            return "";
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(android.content.Context context) {
            return a2(context);
        }
    }

    public b() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.b = reentrantLock;
        this.c = reentrantLock.newCondition();
    }

    private static void a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "LFMobileEnv dataCheck = true");
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(131)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "instant r 131");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str, 131);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "not instant r 131");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str, 131);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "report lfMobileEnvInfo data: type = 131 content = ".concat(java.lang.String.valueOf(str)));
    }

    private static void a(java.lang.StringBuilder sb) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return;
        }
        sb.append(com.getui.gtc.extension.distribution.gbd.n.l.a(false));
    }

    private static void b(java.lang.StringBuilder sb) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return;
        }
        sb.append(com.getui.gtc.extension.distribution.gbd.n.l.b(false));
    }

    private static void c(java.lang.StringBuilder sb) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "not fetch iccid.");
            return;
        }
        java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.ab.a();
        if (!android.text.TextUtils.isEmpty(a2)) {
            sb.append(a2);
        }
        java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.n.ab.a(1);
        if (!android.text.TextUtils.isEmpty(a3)) {
            sb.append("#");
            sb.append(a3);
        }
        java.lang.String a4 = com.getui.gtc.extension.distribution.gbd.n.ab.a(2);
        if (android.text.TextUtils.isEmpty(a4)) {
            return;
        }
        if (android.text.TextUtils.isEmpty(a3)) {
            sb.append("#");
        }
        sb.append(",");
        sb.append(a4);
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.a.d.b f() {
        com.getui.gtc.extension.distribution.gbd.a.d.b bVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.a.d.b.class) {
            if (e == null) {
                e = new com.getui.gtc.extension.distribution.gbd.a.d.b();
            }
            bVar = e;
        }
        return bVar;
    }

    private static boolean g() {
        try {
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.aL)) {
                java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.aL.split(",");
                java.lang.String w = com.getui.gtc.extension.distribution.gbd.n.l.w();
                for (java.lang.String str : split) {
                    java.lang.String[] split2 = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    if (split2.length == 2) {
                        java.lang.String str2 = split2[0];
                        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(split2[1].split("&")));
                        if (!w.equalsIgnoreCase(str2)) {
                            continue;
                        } else {
                            if (split2[1].equals("*")) {
                                com.getui.gtc.extension.distribution.gbd.n.j.b(d, "virtual r *, false.");
                                return false;
                            }
                            java.lang.String lowerCase = com.getui.gtc.extension.distribution.gbd.n.l.z().toLowerCase();
                            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "virtual r = ".concat(java.lang.String.valueOf(lowerCase)));
                            java.util.Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (lowerCase.contains(((java.lang.String) it.next()).toLowerCase())) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.b(d, "virtual r in bl.");
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private void h() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "package data, 131");
        java.lang.String i = i();
        if (android.text.TextUtils.isEmpty(i)) {
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "LFMobileEnv dataCheck = true");
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(131)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "instant r 131");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(i, 131);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "not instant r 131");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(i, 131);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "report lfMobileEnvInfo data: type = 131 content = ".concat(java.lang.String.valueOf(i)));
    }

    private java.lang.String i() {
        java.lang.String str;
        try {
            if (com.getui.gtc.extension.distribution.gbd.d.c.e != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C())));
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
                sb.append("|");
                java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append("|");
                sb.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
                sb.append("|");
                int i = android.os.Build.VERSION.SDK_INT;
                if (i < 29) {
                    sb.append(com.getui.gtc.extension.distribution.gbd.n.l.a(false));
                }
                sb.append("|");
                if (i < 29) {
                    sb.append(com.getui.gtc.extension.distribution.gbd.n.l.b(false));
                }
                sb.append("|");
                java.lang.String y = com.getui.gtc.extension.distribution.gbd.n.l.y();
                if (!android.text.TextUtils.isEmpty(y)) {
                    sb.append("ANDROID-".concat(java.lang.String.valueOf(y)));
                }
                sb.append("|");
                java.lang.String str3 = com.getui.gtc.extension.distribution.gbd.d.h.K;
                if (str3 != null) {
                    sb.append(str3);
                }
                sb.append("|");
                java.lang.String str4 = com.getui.gtc.extension.distribution.gbd.d.h.M;
                if (str4 != null) {
                    sb.append(str4);
                }
                sb.append("||");
                sb.append("|");
                sb.append("|");
                java.lang.String str5 = com.getui.gtc.extension.distribution.gbd.d.c.c;
                if (str5 != null) {
                    sb.append(str5);
                }
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.w());
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.z());
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.x());
                sb.append("|");
                sb.append("|||");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.v() ? 1 : 0);
                sb.append("|");
                sb.append("|");
                java.lang.String p = p();
                if (!android.text.TextUtils.isEmpty(p)) {
                    sb.append(p);
                }
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.m(com.getui.gtc.extension.distribution.gbd.d.c.d));
                sb.append("|");
                java.lang.String u = u();
                java.lang.String str6 = "";
                if (android.text.TextUtils.isEmpty(u)) {
                    u = "";
                }
                sb.append(u);
                sb.append("|");
                if (i >= 29) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(d, "not fetch iccid.");
                } else {
                    java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.ab.a();
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        sb.append(a2);
                    }
                    java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.n.ab.a(1);
                    if (!android.text.TextUtils.isEmpty(a3)) {
                        sb.append("#");
                        sb.append(a3);
                    }
                    java.lang.String a4 = com.getui.gtc.extension.distribution.gbd.n.ab.a(2);
                    if (!android.text.TextUtils.isEmpty(a4)) {
                        if (android.text.TextUtils.isEmpty(a3)) {
                            sb.append("#");
                        }
                        sb.append(",");
                        sb.append(a4);
                    }
                }
                sb.append("|");
                sb.append(q());
                sb.append("|");
                sb.append(r());
                sb.append("|");
                java.lang.String g2 = com.getui.gtc.extension.distribution.gbd.n.l.g();
                if (!android.text.TextUtils.isEmpty(g2)) {
                    sb.append(g2);
                }
                sb.append("|");
                try {
                    java.util.LinkedHashMap<java.lang.Long, java.lang.Long> D = com.getui.gtc.extension.distribution.gbd.n.l.D();
                    if (D.size() > 0) {
                        for (java.util.Map.Entry<java.lang.Long, java.lang.Long> entry : D.entrySet()) {
                            sb.append(entry.getKey());
                            sb.append(",");
                            sb.append(entry.getValue());
                            sb.append("#");
                        }
                        if (sb.toString().endsWith("#")) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
                sb.append("|");
                if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.ae)) {
                    str = null;
                } else {
                    str = com.getui.gtc.extension.distribution.gbd.d.h.ae;
                    com.getui.gtc.extension.distribution.gbd.d.h.ad = 0;
                    com.getui.gtc.extension.distribution.gbd.d.h.ae = "";
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a(com.getui.gtc.extension.distribution.gbd.d.h.ad);
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.d(com.getui.gtc.extension.distribution.gbd.d.h.ae);
                    com.getui.gtc.extension.distribution.gbd.n.j.b(d, "read shutdown data : ".concat(java.lang.String.valueOf(str)));
                }
                if (!android.text.TextUtils.isEmpty(str)) {
                    sb.append(str);
                }
                sb.append("|");
                com.getui.gtc.extension.distribution.gbd.n.j.b(d, "getlm type = 131");
                java.lang.String c = com.getui.gtc.extension.distribution.gbd.n.o.c();
                if (!android.text.TextUtils.isEmpty(c)) {
                    sb.append(c);
                }
                sb.append("|");
                java.lang.String n = n();
                if (!android.text.TextUtils.isEmpty(n)) {
                    sb.append(n);
                }
                sb.append("|");
                java.lang.String n2 = com.getui.gtc.extension.distribution.gbd.n.l.n(com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName());
                if (!android.text.TextUtils.isEmpty(n2)) {
                    sb.append(n2);
                }
                sb.append("|");
                if (this.f) {
                    sb.append(com.getui.gtc.extension.distribution.gbd.n.a.f.b() ? 1 : 0);
                }
                sb.append("|");
                if (this.f && com.getui.gtc.extension.distribution.gbd.n.a.d.a().b) {
                    sb.append(com.getui.gtc.extension.distribution.gbd.n.a.d.a().a ? 1 : 0);
                }
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.j());
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.l("131"));
                sb.append("|");
                sb.append("|");
                sb.append("|");
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                java.lang.String str7 = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "pi", com.getui.gtc.extension.distribution.gbd.d.c.d, new com.getui.gtc.extension.distribution.gbd.a.d.b.AnonymousClass3());
                if (str7 == null) {
                    str7 = "";
                }
                sb.append(str7);
                sb.append("|");
                sb.append("|");
                com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                java.lang.String str8 = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.i, com.getui.gtc.extension.distribution.gbd.f.b.i, new com.getui.gtc.extension.distribution.gbd.a.d.b.AnonymousClass2());
                if (str8 != null) {
                    str6 = str8;
                }
                sb.append(str6);
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.ab.b());
                sb.append("|");
                sb.append(s());
                sb.append("|");
                sb.append(t());
                sb.append("|");
                sb.append("|");
                sb.append("|");
                sb.append("|");
                sb.append("|");
                sb.append("|");
                sb.append(v());
                sb.append("|");
                java.lang.String k = k();
                sb.append(k);
                sb.append("|");
                com.getui.gtc.extension.distribution.gbd.f.g unused3 = com.getui.gtc.extension.distribution.gbd.f.g.a.a;
                sb.append(com.getui.gtc.extension.distribution.gbd.f.g.b());
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.k("131"));
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.L());
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "os info : ".concat(java.lang.String.valueOf(k)));
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, " " + sb.substring(sb.length() - 100));
                return sb.toString();
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
        }
        return null;
    }

    private static java.lang.String j() {
        com.getui.gtc.extension.distribution.gbd.f.g unused = com.getui.gtc.extension.distribution.gbd.f.g.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.g.b();
    }

    private static java.lang.String k() {
        if (!com.getui.gtc.extension.distribution.gbd.d.d.dk) {
            return "&&&&";
        }
        try {
            if (android.os.Build.VERSION.SDK_INT <= 21) {
                return "&&&&";
            }
            android.system.StructUtsname uname = android.system.Os.uname();
            return uname.machine + "&" + uname.nodename + "&" + uname.release + "&" + uname.sysname + "&" + uname.version;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "&&&&";
        }
    }

    private java.lang.String l() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.i, com.getui.gtc.extension.distribution.gbd.f.b.i, new com.getui.gtc.extension.distribution.gbd.a.d.b.AnonymousClass2());
        return str == null ? "" : str;
    }

    private java.lang.String m() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "pi", com.getui.gtc.extension.distribution.gbd.d.c.d, new com.getui.gtc.extension.distribution.gbd.a.d.b.AnonymousClass3());
        return str == null ? "" : str;
    }

    private static java.lang.String n() {
        byte[] j;
        if (!com.getui.gtc.extension.distribution.gbd.n.l.b(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
            return null;
        }
        if (!com.getui.gtc.extension.distribution.gbd.n.x.a(2, 2)) {
            return "";
        }
        try {
            java.lang.String str = "/sdcard/libs/" + com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName() + ".bin";
            if (new java.io.File(str).exists() && (j = com.getui.gtc.extension.distribution.gbd.n.l.j(str)) != null) {
                return new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.ad.b(j));
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return null;
    }

    private static java.lang.String o() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.ae)) {
            return null;
        }
        java.lang.String str = com.getui.gtc.extension.distribution.gbd.d.h.ae;
        com.getui.gtc.extension.distribution.gbd.d.h.ad = 0;
        com.getui.gtc.extension.distribution.gbd.d.h.ae = "";
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(com.getui.gtc.extension.distribution.gbd.d.h.ad);
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.d(com.getui.gtc.extension.distribution.gbd.d.h.ae);
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "read shutdown data : ".concat(java.lang.String.valueOf(str)));
        return str;
    }

    private static java.lang.String p() {
        java.util.ArrayList arrayList;
        java.util.List<android.content.pm.PackageInfo> a2;
        java.lang.String[] split;
        java.lang.String c;
        boolean z;
        boolean z2;
        boolean z3;
        try {
            arrayList = new java.util.ArrayList();
            a2 = com.getui.gtc.extension.distribution.gbd.n.b.a();
            split = com.getui.gtc.extension.distribution.gbd.d.d.bu.split("\\|");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (split.length != 4) {
            return "";
        }
        int i = 0;
        java.lang.String[] split2 = split[0].split(",");
        int i2 = 1;
        java.lang.String[] split3 = split[1].split(",");
        java.lang.String[] split4 = split[2].split(",");
        java.lang.String[] split5 = split[3].split(",");
        for (android.content.pm.PackageInfo packageInfo : a2) {
            if ((packageInfo.applicationInfo.flags & i2) > 0) {
                if (split3.length > i2 && !split3[0].equals("none")) {
                    boolean z4 = true;
                    for (java.lang.String str : split3) {
                        if (packageInfo.packageName.contains(str)) {
                            z4 = false;
                        }
                    }
                    if (!z4) {
                    }
                }
                if (split4.length > 0 && !split4[0].equals("none")) {
                    int length = split4.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z3 = true;
                            break;
                        }
                        if (!packageInfo.packageName.contains(split4[i3])) {
                            z3 = false;
                            break;
                        }
                        i3++;
                    }
                    if (!z3) {
                    }
                }
                if (split2.length > 0 && !split2[0].equals("none")) {
                    int length2 = split2.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            z2 = true;
                            break;
                        }
                        if (packageInfo.packageName.startsWith(split2[i4])) {
                            z2 = false;
                            break;
                        }
                        i4++;
                    }
                    if (!z2) {
                    }
                }
                if (split5.length > 0 && !split5[0].equals("none")) {
                    int length3 = split5.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length3) {
                            z = true;
                            break;
                        }
                        if (packageInfo.packageName.endsWith(split5[i5])) {
                            z = false;
                            break;
                        }
                        i5++;
                    }
                    if (!z) {
                    }
                }
                arrayList.add(packageInfo);
            }
            i2 = 1;
        }
        if (!arrayList.isEmpty()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                android.content.pm.PackageInfo packageInfo2 = (android.content.pm.PackageInfo) it.next();
                if (i == 0) {
                    sb.append(packageInfo2.packageName);
                    sb.append("#");
                    sb.append(packageInfo2.versionName);
                    sb.append("#");
                    sb.append(packageInfo2.versionCode);
                    sb.append("#");
                    c = com.getui.gtc.extension.distribution.gbd.n.b.c(packageInfo2);
                } else {
                    sb.append(",");
                    sb.append(packageInfo2.packageName);
                    sb.append("#");
                    sb.append(packageInfo2.versionName);
                    sb.append("#");
                    sb.append(packageInfo2.versionCode);
                    sb.append("#");
                    c = com.getui.gtc.extension.distribution.gbd.n.b.c(packageInfo2);
                }
                sb.append(c);
                i++;
            }
            arrayList.clear();
            java.lang.String replace = sb.toString().replace("|", "$");
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "system app: ".concat(java.lang.String.valueOf(replace)));
            return replace;
        }
        return "";
    }

    private static java.lang.String q() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bS)) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.bS.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = 1;
                if (i >= length) {
                    break;
                }
                java.lang.String str = split[i];
                sb.append(str);
                sb.append("#");
                java.lang.String str2 = "android.permission." + str;
                sb.append(com.getui.gtc.extension.distribution.gbd.n.l.b(com.getui.gtc.extension.distribution.gbd.d.c.d, str2) ? 1 : 0);
                sb.append("#");
                if (!com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, str2)) {
                    i2 = 0;
                }
                sb.append(i2);
                sb.append(",");
                i++;
            }
            if (sb.length() > 0 && sb.toString().endsWith(",")) {
                sb = sb.deleteCharAt(sb.length() - 1);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return sb.toString();
    }

    private static java.lang.String r() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            int i = 1;
            sb.append(com.getui.gtc.extension.distribution.gbd.n.l.k(com.getui.gtc.extension.distribution.gbd.d.c.d) ? 1 : 0);
            sb.append(",");
            if (com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.BLUETOOTH")) {
                if (!com.getui.gtc.extension.distribution.gbd.n.l.s()) {
                    i = 0;
                }
                sb.append(i);
            } else {
                sb.append("-1");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return sb.toString();
    }

    private static long s() {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.l.C() - android.os.SystemClock.elapsedRealtime();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return -1L;
        }
    }

    private static java.lang.String t() {
        try {
            android.view.WindowManager windowManager = (android.view.WindowManager) com.getui.gtc.extension.distribution.gbd.d.c.d.getSystemService("window");
            android.graphics.Point point = new android.graphics.Point();
            windowManager.getDefaultDisplay().getRealSize(point);
            return point.x + "&" + point.y + "," + com.getui.gtc.extension.distribution.gbd.d.c.d.getResources().getDisplayMetrics().densityDpi + "," + java.lang.Double.valueOf(new java.text.DecimalFormat("#.00").format(java.lang.Math.sqrt(java.lang.Math.pow(point.x / r1.xdpi, 2.0d) + java.lang.Math.pow(point.y / r1.ydpi, 2.0d))));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private static java.lang.String u() {
        try {
            return java.util.Locale.getDefault().getLanguage();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static java.lang.String v() {
        try {
            if (!w()) {
                return "0,-1";
            }
            return "1," + x();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "0,-1";
        }
    }

    private static boolean w() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            return g.equals(cls.getMethod("getOsBrand", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]));
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException | java.lang.Exception unused) {
            return false;
        }
    }

    private static java.lang.String x() {
        try {
            java.lang.reflect.Method method = null;
            for (java.lang.reflect.Method method2 : java.lang.Class.forName("android.os.SystemProperties").getMethods()) {
                if (method2.getName().equals(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
                    method = method2;
                }
            }
            return method != null ? (java.lang.String) method.invoke(null, com.alipay.sdk.m.c.a.b, "error") : "error";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "error";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        java.lang.String i;
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "doSample");
        if (com.getui.gtc.extension.distribution.gbd.n.l.c(131)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "type 131 in type black list, return.");
            return;
        }
        try {
            java.lang.String m = com.getui.gtc.extension.distribution.gbd.n.l.m();
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            if (!android.text.TextUtils.isEmpty(m)) {
                com.getui.gtc.extension.distribution.gbd.d.h.K = m;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(130, com.getui.gtc.extension.distribution.gbd.n.ad.a(m.getBytes()));
            }
            java.lang.String n = com.getui.gtc.extension.distribution.gbd.n.l.n();
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            if (!android.text.TextUtils.isEmpty(n)) {
                com.getui.gtc.extension.distribution.gbd.d.h.M = n;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(131, com.getui.gtc.extension.distribution.gbd.n.ad.a(n.getBytes()));
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        this.f = com.getui.gtc.extension.distribution.gbd.d.d.aK && g();
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "report virtual " + this.f);
        this.b.lock();
        try {
            if (this.f) {
                com.getui.gtc.extension.distribution.gbd.n.a.g.a().a(com.getui.gtc.extension.distribution.gbd.d.c.d, new com.getui.gtc.extension.distribution.gbd.a.d.b.AnonymousClass1());
                this.c.await(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                com.getui.gtc.extension.distribution.gbd.n.a.d.a().a(com.getui.gtc.extension.distribution.gbd.d.c.d);
            }
        } finally {
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.b(d, "package data, 131");
                i = i();
                if (android.text.TextUtils.isEmpty(i)) {
                }
            } finally {
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "package data, 131");
        i = i();
        if (android.text.TextUtils.isEmpty(i)) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "LFMobileEnv dataCheck = true");
            if (com.getui.gtc.extension.distribution.gbd.n.l.d(131)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(d, "instant r 131");
                com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(i, 131);
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.b(d, "not instant r 131");
                com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(i, 131);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "report lfMobileEnvInfo data: type = 131 content = ".concat(java.lang.String.valueOf(i)));
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 131;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return "* * * * *";
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return "* * * * *";
    }
}
