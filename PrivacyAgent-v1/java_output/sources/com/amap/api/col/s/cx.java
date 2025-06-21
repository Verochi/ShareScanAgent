package com.amap.api.col.s;

/* loaded from: classes12.dex */
public class cx {
    public static int a = 0;
    public static java.lang.String b = "";
    public static java.util.HashMap<java.lang.String, java.lang.String> c;
    public static java.util.HashMap<java.lang.String, java.lang.String> d;
    public static java.util.HashMap<java.lang.String, java.lang.String> e;
    public static com.amap.api.col.s.cx f;

    public interface a {
        java.net.URLConnection a();
    }

    public cx() {
        com.amap.api.col.s.bj.d();
    }

    public static int a(com.amap.api.col.s.dd ddVar, long j) {
        try {
            d(ddVar);
            long j2 = 0;
            if (j != 0) {
                j2 = android.os.SystemClock.elapsedRealtime() - j;
            }
            int m = ddVar.m();
            if (ddVar.o() != com.amap.api.col.s.dd.a.FIX && ddVar.o() != com.amap.api.col.s.dd.a.SINGLE) {
                long j3 = m;
                if (j2 < j3) {
                    long j4 = j3 - j2;
                    if (j4 >= 1000) {
                        return (int) j4;
                    }
                }
                return java.lang.Math.min(1000, ddVar.m());
            }
            return m;
        } catch (java.lang.Throwable unused) {
            return 5000;
        }
    }

    public static com.amap.api.col.s.cx a() {
        if (f == null) {
            f = new com.amap.api.col.s.cx();
        }
        return f;
    }

    public static com.amap.api.col.s.dd.b a(com.amap.api.col.s.dd ddVar, boolean z) {
        if (ddVar.o() == com.amap.api.col.s.dd.a.FIX) {
            return com.amap.api.col.s.dd.b.FIX_NONDEGRADE;
        }
        if (ddVar.o() != com.amap.api.col.s.dd.a.SINGLE && z) {
            return com.amap.api.col.s.dd.b.FIRST_NONDEGRADE;
        }
        return com.amap.api.col.s.dd.b.NEVER_GRADE;
    }

    public static com.amap.api.col.s.de a(com.amap.api.col.s.dd ddVar) throws com.amap.api.col.s.bh {
        return d(ddVar, ddVar.r());
    }

    public static com.amap.api.col.s.dd.b b(com.amap.api.col.s.dd ddVar, boolean z) {
        return ddVar.o() == com.amap.api.col.s.dd.a.FIX ? z ? com.amap.api.col.s.dd.b.FIX_DEGRADE_BYERROR : com.amap.api.col.s.dd.b.FIX_DEGRADE_ONLY : z ? com.amap.api.col.s.dd.b.DEGRADE_BYERROR : com.amap.api.col.s.dd.b.DEGRADE_ONLY;
    }

    public static com.amap.api.col.s.de b(com.amap.api.col.s.dd ddVar, com.amap.api.col.s.dd.b bVar, int i) throws com.amap.api.col.s.bh {
        try {
            d(ddVar);
            ddVar.a(bVar);
            ddVar.c(i);
            return new com.amap.api.col.s.da().m(ddVar);
        } catch (com.amap.api.col.s.bh e2) {
            throw e2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
        }
    }

    public static boolean b(com.amap.api.col.s.dd ddVar) throws com.amap.api.col.s.bh {
        d(ddVar);
        try {
            java.lang.String a2 = ddVar.a();
            if (android.text.TextUtils.isEmpty(a2)) {
                return false;
            }
            java.lang.String host = new java.net.URL(a2).getHost();
            if (!android.text.TextUtils.isEmpty(ddVar.i())) {
                host = ddVar.i();
            }
            return com.amap.api.col.s.bj.d(host);
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    public static int c(com.amap.api.col.s.dd ddVar, boolean z) {
        try {
            d(ddVar);
            int m = ddVar.m();
            int i = com.amap.api.col.s.bj.e;
            if (ddVar.o() != com.amap.api.col.s.dd.a.FIX) {
                if (ddVar.o() != com.amap.api.col.s.dd.a.SINGLE && m >= i && z) {
                    return i;
                }
            }
            return m;
        } catch (java.lang.Throwable unused) {
            return 5000;
        }
    }

    public static boolean c(com.amap.api.col.s.dd ddVar) throws com.amap.api.col.s.bh {
        d(ddVar);
        if (!b(ddVar)) {
            return true;
        }
        if (ddVar.h().equals(ddVar.a()) || ddVar.o() == com.amap.api.col.s.dd.a.SINGLE) {
            return false;
        }
        return com.amap.api.col.s.bj.h;
    }

    @java.lang.Deprecated
    public static com.amap.api.col.s.de d(com.amap.api.col.s.dd ddVar, boolean z) throws com.amap.api.col.s.bh {
        byte[] bArr;
        d(ddVar);
        ddVar.a(z ? com.amap.api.col.s.dd.c.HTTPS : com.amap.api.col.s.dd.c.HTTP);
        com.amap.api.col.s.de deVar = null;
        long j = 0;
        boolean z2 = false;
        if (b(ddVar)) {
            boolean c2 = c(ddVar);
            try {
                j = android.os.SystemClock.elapsedRealtime();
                deVar = b(ddVar, a(ddVar, c2), c(ddVar, c2));
            } catch (com.amap.api.col.s.bh e2) {
                if (e2.f() == 21 && ddVar.o() == com.amap.api.col.s.dd.a.INTERRUPT_IO) {
                    throw e2;
                }
                if (!c2) {
                    throw e2;
                }
                z2 = true;
            }
        }
        if (deVar != null && (bArr = deVar.a) != null && bArr.length > 0) {
            return deVar;
        }
        try {
            return b(ddVar, b(ddVar, z2), a(ddVar, j));
        } catch (com.amap.api.col.s.bh e3) {
            throw e3;
        }
    }

    public static void d(com.amap.api.col.s.dd ddVar) throws com.amap.api.col.s.bh {
        if (ddVar == null) {
            throw new com.amap.api.col.s.bh("requeust is null");
        }
        if (ddVar.h() == null || "".equals(ddVar.h())) {
            throw new com.amap.api.col.s.bh("request url is empty");
        }
    }
}
