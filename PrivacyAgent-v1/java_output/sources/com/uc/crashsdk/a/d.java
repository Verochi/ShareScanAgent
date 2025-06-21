package com.uc.crashsdk.a;

/* loaded from: classes19.dex */
public class d {
    static final /* synthetic */ boolean a = true;
    private static boolean b = true;
    private static boolean d = false;
    private static java.lang.String e = "hsdk";
    private static java.lang.String f = "alid ";
    private static java.lang.String g;
    private static java.lang.String i;
    private static final java.lang.Object c = new java.lang.Object();
    private static final java.lang.Object h = new java.lang.Object();

    private static java.lang.StringBuilder a(java.lang.StringBuilder sb, java.lang.String str, java.lang.String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(str2);
        return sb;
    }

    public static void a() {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(500), com.uc.crashsdk.b.H() ? com.heytap.mcssdk.constant.a.h : 90000L);
    }

    public static void a(int i2) {
        if (i2 != 500) {
            if (!a) {
                throw new java.lang.AssertionError();
            }
            return;
        }
        synchronized (c) {
            g = null;
            a(!com.uc.crashsdk.b.F());
            if (com.uc.crashsdk.a.g.b(g)) {
                com.uc.crashsdk.a.h.a(g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(boolean z) {
        java.lang.String str;
        long j;
        int i2;
        boolean z2;
        java.lang.String str2;
        if (d) {
            return false;
        }
        d = !z;
        if ((com.uc.crashsdk.a.b.equals("2.0") && com.uc.crashsdk.b.c(536870912)) || !com.uc.crashsdk.b.A()) {
            return false;
        }
        java.lang.String n = com.uc.crashsdk.b.n();
        java.lang.String a2 = com.uc.crashsdk.a.b.a(n);
        if (com.uc.crashsdk.a.g.b(a2)) {
            java.lang.String[] split = a2.split(" ", 4);
            if (split.length == 3) {
                str = split[0];
                j = com.uc.crashsdk.a.g.c(split[1]);
                i2 = (int) com.uc.crashsdk.a.g.c(split[2]);
                b = true;
                if (java.lang.System.currentTimeMillis() - j < 259200000) {
                    if (!"o".equals(str)) {
                        if ("2".equals(str)) {
                            b = false;
                        } else if ("1".equals(str)) {
                            b = false;
                        }
                    }
                    z2 = false;
                    if (z2 || z) {
                        return true;
                    }
                    if (i2 == android.os.Process.myPid()) {
                        return false;
                    }
                    g = "per";
                    java.lang.String g2 = g();
                    if (g2 == null || !g2.contains("retcode=")) {
                        if (g2 == null) {
                            g = "ner";
                        } else {
                            g = "ser";
                        }
                        return false;
                    }
                    if (g2.contains("retcode=0")) {
                        b = true;
                        str2 = "o";
                        g = "aus";
                    } else {
                        b = false;
                        if ("1".equals(str)) {
                            str2 = "2";
                            g = "auf2";
                        } else {
                            str2 = "1";
                            g = "auf1";
                        }
                    }
                    com.uc.crashsdk.a.b.a(n, java.lang.String.format(java.util.Locale.US, "%s %d %d", str2, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()), java.lang.Integer.valueOf(android.os.Process.myPid())));
                    if (com.uc.crashsdk.a.g.b(g2)) {
                        for (java.lang.String str3 : g2.split("`", 30)) {
                            java.lang.String[] split2 = str3.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, 2);
                            if (split2.length == 2) {
                                java.lang.String trim = split2[0].trim();
                                java.lang.String trim2 = split2[1].trim();
                                boolean z3 = com.uc.crashsdk.a.g.b(trim2) && trim2.startsWith(com.alipay.sdk.m.l.a.q);
                                if ("logurl".equals(trim)) {
                                    if (z3) {
                                        com.uc.crashsdk.e.b(trim2);
                                    }
                                } else if ("staturl".equals(trim)) {
                                    if (z3) {
                                        com.uc.crashsdk.a.h.b(trim2);
                                    }
                                } else if ("policyurl".equals(trim)) {
                                    if (z3) {
                                        synchronized (h) {
                                            i = trim2;
                                            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.j(), trim2 + "\n");
                                        }
                                    } else {
                                        continue;
                                    }
                                } else if ("logpolicy".equals(trim)) {
                                    com.uc.crashsdk.e.c(trim2);
                                }
                            }
                        }
                    }
                    return true;
                }
                z2 = true;
                if (z2) {
                }
                return true;
            }
        }
        str = null;
        j = 0;
        i2 = 0;
        b = true;
        if (java.lang.System.currentTimeMillis() - j < 259200000) {
        }
        z2 = true;
        if (z2) {
        }
        return true;
    }

    public static java.lang.String b() {
        try {
            return "inv" + f + "cras" + e;
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return "";
        }
    }

    public static void c() {
        synchronized (h) {
            i = null;
        }
    }

    public static byte[] d() {
        return new byte[]{6, 0, com.google.common.base.Ascii.ETB, 8};
    }

    public static boolean e() {
        if (!com.uc.crashsdk.e.F() && !com.uc.crashsdk.b.L()) {
            a(true);
            return b;
        }
        return true;
    }

    private static java.lang.String f() {
        java.lang.String str = i;
        if (com.uc.crashsdk.a.g.a(str)) {
            synchronized (h) {
                str = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.j(), (com.uc.crashsdk.g.S() ? "https://errlogos.umeng.com" : "https://errlog.umeng.com") + "/api/crashsdk/validate", true);
                i = str;
            }
        }
        return str;
    }

    private static java.lang.String g() {
        byte[] bArr;
        java.lang.String f2;
        byte[] a2;
        byte[] bArr2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        a(sb, "platform", com.uc.crashsdk.g.e());
        a(sb, "pkgname", com.uc.crashsdk.a.a);
        a(sb, "process", com.uc.crashsdk.e.h());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", "3.3.2.2");
        a(sb, "ctag", "umeng");
        a(sb, "inter", com.uc.crashsdk.g.S() ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        a(sb, "os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        java.lang.String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        com.uc.crashsdk.a.c.a(bArr3, 0, com.uc.crashsdk.a.h.j());
        com.uc.crashsdk.a.c.a(bArr3, 4, com.uc.crashsdk.a.c.a());
        com.uc.crashsdk.a.c.a(bArr3, 8, d());
        com.uc.crashsdk.a.c.a(bArr3, 12, com.uc.crashsdk.a.f());
        try {
            bArr = com.uc.crashsdk.a.c.a(sb2.getBytes(), bArr3, true);
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            bArr = null;
        }
        if (bArr == null || (f2 = f()) == null || (a2 = com.uc.crashsdk.a.c.a(f2, bArr)) == null) {
            return null;
        }
        try {
            bArr2 = com.uc.crashsdk.a.c.a(a2, bArr3, false);
        } catch (java.lang.Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new java.lang.String(bArr2);
        }
        return null;
    }
}
