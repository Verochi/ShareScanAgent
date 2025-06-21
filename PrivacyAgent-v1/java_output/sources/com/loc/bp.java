package com.loc;

/* loaded from: classes23.dex */
public final class bp {
    public static int a = 0;
    public static java.lang.String b = "";
    public static java.util.HashMap<java.lang.String, java.lang.String> c;
    public static java.util.HashMap<java.lang.String, java.lang.String> d;
    public static java.util.HashMap<java.lang.String, java.lang.String> e;
    private static com.loc.bp f;

    public interface a {
        java.net.URLConnection a();
    }

    public bp() {
        com.loc.n.e();
    }

    private static int a(com.loc.bu buVar, long j) {
        try {
            d(buVar);
            long j2 = 0;
            if (j != 0) {
                j2 = android.os.SystemClock.elapsedRealtime() - j;
            }
            int n = buVar.n();
            if (buVar.p() != com.loc.bu.a.FIX && buVar.p() != com.loc.bu.a.SINGLE) {
                long j3 = n;
                if (j2 < j3) {
                    long j4 = j3 - j2;
                    if (j4 >= 1000) {
                        return (int) j4;
                    }
                }
                return java.lang.Math.min(1000, buVar.n());
            }
            return n;
        } catch (java.lang.Throwable unused) {
            return 5000;
        }
    }

    public static com.loc.bp a() {
        if (f == null) {
            f = new com.loc.bp();
        }
        return f;
    }

    public static com.loc.bv a(com.loc.bu buVar) throws com.loc.l {
        return a(buVar, buVar.s());
    }

    private static com.loc.bv a(com.loc.bu buVar, com.loc.bu.b bVar, int i) throws com.loc.l {
        try {
            d(buVar);
            buVar.a(bVar);
            buVar.c(i);
            return new com.loc.bs().a(buVar);
        } catch (com.loc.l e2) {
            throw e2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            throw new com.loc.l(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
        }
    }

    @java.lang.Deprecated
    private static com.loc.bv a(com.loc.bu buVar, boolean z) throws com.loc.l {
        byte[] bArr;
        d(buVar);
        buVar.a(z ? com.loc.bu.c.HTTPS : com.loc.bu.c.HTTP);
        com.loc.bv bvVar = null;
        long j = 0;
        boolean z2 = false;
        if (b(buVar)) {
            boolean c2 = c(buVar);
            try {
                j = android.os.SystemClock.elapsedRealtime();
                bvVar = a(buVar, b(buVar, c2), d(buVar, c2));
            } catch (com.loc.l e2) {
                if (e2.f() == 21 && buVar.p() == com.loc.bu.a.INTERRUPT_IO) {
                    throw e2;
                }
                if (!c2) {
                    throw e2;
                }
                z2 = true;
            }
        }
        if (bvVar != null && (bArr = bvVar.a) != null && bArr.length > 0) {
            return bvVar;
        }
        try {
            return a(buVar, c(buVar, z2), a(buVar, j));
        } catch (com.loc.l e3) {
            throw e3;
        }
    }

    private static com.loc.bu.b b(com.loc.bu buVar, boolean z) {
        if (buVar.p() == com.loc.bu.a.FIX) {
            return com.loc.bu.b.FIX_NONDEGRADE;
        }
        if (buVar.p() != com.loc.bu.a.SINGLE && z) {
            return com.loc.bu.b.FIRST_NONDEGRADE;
        }
        return com.loc.bu.b.NEVER_GRADE;
    }

    private static boolean b(com.loc.bu buVar) throws com.loc.l {
        d(buVar);
        try {
            java.lang.String c2 = buVar.c();
            if (android.text.TextUtils.isEmpty(c2)) {
                return false;
            }
            java.lang.String host = new java.net.URL(c2).getHost();
            if (!android.text.TextUtils.isEmpty(buVar.g())) {
                host = buVar.g();
            }
            return com.loc.n.g(host);
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    private static com.loc.bu.b c(com.loc.bu buVar, boolean z) {
        return buVar.p() == com.loc.bu.a.FIX ? z ? com.loc.bu.b.FIX_DEGRADE_BYERROR : com.loc.bu.b.FIX_DEGRADE_ONLY : z ? com.loc.bu.b.DEGRADE_BYERROR : com.loc.bu.b.DEGRADE_ONLY;
    }

    private static boolean c(com.loc.bu buVar) throws com.loc.l {
        d(buVar);
        if (!b(buVar)) {
            return true;
        }
        if (buVar.b().equals(buVar.c()) || buVar.p() == com.loc.bu.a.SINGLE) {
            return false;
        }
        return com.loc.n.h;
    }

    private static int d(com.loc.bu buVar, boolean z) {
        try {
            d(buVar);
            int n = buVar.n();
            int i = com.loc.n.e;
            if (buVar.p() != com.loc.bu.a.FIX) {
                if (buVar.p() != com.loc.bu.a.SINGLE && n >= i && z) {
                    return i;
                }
            }
            return n;
        } catch (java.lang.Throwable unused) {
            return 5000;
        }
    }

    private static void d(com.loc.bu buVar) throws com.loc.l {
        if (buVar == null) {
            throw new com.loc.l("requeust is null");
        }
        if (buVar.b() == null || "".equals(buVar.b())) {
            throw new com.loc.l("request url is empty");
        }
    }
}
